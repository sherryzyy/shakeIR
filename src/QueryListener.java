import BooleanExpression.*;
import antlr4Generated.QueryLanguageBaseListener;
import antlr4Generated.QueryLanguageParser;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.Stack;

public class QueryListener extends QueryLanguageBaseListener {

    private boolean ignoreTerminal=false;
    private Stack<BooleanExpression> exprStack=new Stack<BooleanExpression>();
    private BooleanExpression operand=null;


    public Stack<BooleanExpression> getExprStack() {
        return exprStack;
    }

    public BooleanExpression getOperand() {
        return operand;
    }

    @Override
    public void enterLiteralExpr(QueryLanguageParser.LiteralExprContext ctx) {
        ignoreTerminal=false;
    }

    @Override
    public void exitLiteralExpr(QueryLanguageParser.LiteralExprContext ctx) {
        ignoreTerminal=true;
    }

    @Override
    public void enterTermExpr(QueryLanguageParser.TermExprContext ctx) {
        ignoreTerminal=false;
    }

    @Override
    public void exitTermExpr(QueryLanguageParser.TermExprContext ctx) {
        ignoreTerminal=true;
    }

    @Override
    public void enterNestedExpr(QueryLanguageParser.NestedExprContext ctx) {
        exprStack.push(new NestedBooleanExpression());
    }

    @Override
    public void enterUnaryOp(QueryLanguageParser.UnaryOpContext ctx) {
        ignoreTerminal=true;
        exprStack.push(new UnaryBooleanExpression());
    }

    @Override
    public void exitUnaryOp(QueryLanguageParser.UnaryOpContext ctx) {
        ignoreTerminal=false;
        if(ctx.getText().equalsIgnoreCase(Not.TEXT)){
            ((UnaryBooleanExpression)exprStack.peek()).setUnaryBooleanOperator(Not.INSTANCE);
        }
    }

    @Override
    public void enterBinaryOp(QueryLanguageParser.BinaryOpContext ctx) {
        ignoreTerminal=true;
        exprStack.push(new BinaryBooleanExpression());
        ((BinaryBooleanExpression)exprStack.peek()).setLeft(operand);
        operand=null;
    }

    @Override
    public void exitBinaryOp(QueryLanguageParser.BinaryOpContext ctx) {
        ignoreTerminal=false;
        if(ctx.getText().equalsIgnoreCase(And.TEXT)){
            ((BinaryBooleanExpression)exprStack.peek()).setBinaryBooleanOperator(And.INSTANCE);
        }else if(ctx.getText().equalsIgnoreCase(Or.TEXT)){
            ((BinaryBooleanExpression)exprStack.peek()).setBinaryBooleanOperator(Or.INSTANCE);
        }
    }

    @Override
    public void exitNestedExpr(QueryLanguageParser.NestedExprContext ctx) {
        if(exprStack.size()>0){
            if(operand!=null){//another nested expr inside
                ((NestedBooleanExpression)exprStack.peek()).setNestedBooleanExpression(operand);
                operand=exprStack.pop();
                processOperand();
            }
        }
    }

    @Override
    public void exitBoolean_literal(QueryLanguageParser.Boolean_literalContext ctx) {
        operand=ctx.getText().equalsIgnoreCase(BooleanLiteral.TRUE.toString())?BooleanLiteral.TRUE:BooleanLiteral.FALSE;
        processOperand();
    }

    @Override
    public void visitTerminal(TerminalNode node) {
        if(!ignoreTerminal&&node.getText()!=null&&!node.getText().trim().equals("(")&&!node.getText().trim().equals(")")){
            operand=new Term(node.getText());
            processOperand();
        }
    }

    private void processOperand(){
        if(exprStack.size()>0&&exprStack.peek() instanceof UnaryBooleanExpression){
            ((UnaryBooleanExpression)exprStack.peek()).setBooleanExpression(operand);
            operand=exprStack.pop();
            processOperand();
        }
        if(exprStack.size()>0&&exprStack.peek() instanceof BinaryBooleanExpression){
            ((BinaryBooleanExpression)exprStack.peek()).setRight(operand);
            operand=exprStack.pop();
            processOperand();
        }
    }
}

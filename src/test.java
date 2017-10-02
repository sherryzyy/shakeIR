

import javax.script.*;
public class test {
    public static void main(String[] args) throws Exception {
        String str = "(a >= 0 && a <= 5)";
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("js");
        engine.put("a",4);
        Object result = engine.eval(str);

        System.out.println("结果类型:" + result.getClass().getName() + ",计算结果:" + result);

    }
}


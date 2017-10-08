<%--
  Created by IntelliJ IDEA.
  User: sherr
  Date: 2017/10/7
  Time: 22:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:directive.page import="src.core.Response" />
<jsp:directive.page import="src.core.webResult" />
<%@ page import="java.util.ArrayList" %>

<html>
<head>
    <title>Search Result</title>
    <style>
        #search{
            width:78px;
            height:28px;
            font:14px "宋体"
        }
        #textArea{
            width:300px;
            height:30px;
            font:14px "宋体"
        }
    </style>
</head>

<body>
<form action="search.jsp" name="search" method="get">
    <table border="0" height="30px" width="450px" align="center">
        <tr>
            <td><img src="dySE-logo.jpg" /></td>
            <td width ="66%"><input name="keyword" type="text" maxlength="100" id="textArea" ></td>
            <td height="29" align="center"><input type="submit" value="搜索一下" id = "search"></td>
        </tr>
    </table>
</form>
<%
    String keyword = new String(request.getParameter("keyword") .getBytes("ISO-8859-1"),"GB2312");
    Response resp = new src.core.Response();

    ArrayList<webResult> results = resp.getResponse(keyword);
    for(webResult result : results)
    {
%>

<h2><a href=<%=result.getUrl()%>><%=result.getTitle()%></a></h2>
<p><%=result.getContent()%><p>
<p><%=result.getUrl()%> <p>
        <%
}
%>
</body>
</html>

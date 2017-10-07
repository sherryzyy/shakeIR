<%--
  Created by IntelliJ IDEA.
  User: sherr
  Date: 2017/10/7
  Time: 22:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <title>Shakespeare Collection</title>
    <style>
        #search {
            width: 78px;
            height: 28px;
            font: 14px "宋体"
        }

        #textArea {
            width: 300px;
            height: 30px;
            font: 14px "宋体"
        }
    </style>
</head>

<body>
<p align="center"><img src="dySE-logo.jpg"/></p>
<form action="search.jsp" name="search" method="get"
      enctype="application/x-www-form-urlencoded">
    <table border="0" height="30px" width="450px" align="center">
        <tr>
            <td width="66%"><input name="keyword" type="text" maxlength="100"
                                   id="textArea"></td>
            <td height="29" align="center"><input type="submit" value="shake"
                                                  id="search"></td>
        </tr>
    </table>
</form>
</body>
</html>


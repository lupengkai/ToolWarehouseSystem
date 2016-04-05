<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: tage
  Date: 4/5/16
  Time: 12:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML>
<html>
<head>
    <base href="<%=basePath%>">

    <title></title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body>
<form method="post" action="/WMS/tools_add">
    <input type="hidden" name="departmentid" value="<s:property value="department.id"/>">
    <table>
        <tr>
            <td>
                name:
            </td>
            <td>
                <input type="text" name="toolname">
            </td>
        </tr>


        <tr>
            <td>
                price:
            </td>
            <td>
                <input type="text" name="toolprice">
            </td>
        </tr>

        <tr>
            <td>
                <input type="submit" value="add">
            </td>
        </tr>
    </table>
</form>
</body>
</html>

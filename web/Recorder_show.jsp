<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: tage
  Date: 4/6/16
  Time: 6:51 PM
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
<table border="2">
    <tr>
        <th>
            ID
        </th>
        <th>TIME</th>
        <th>Tool ID</th>
        <th>
            Tool Name
        </th>
    </tr>
    <s:iterator value="recorderList">
        <tr>
            <td>
                <s:property value="id"/>
            </td>
            <td>
                <s:property value="timestamp"/>
            </td>
            <td>
                <s:property value="tool.id"/>
            </td>
            <td>
                <s:property value="tool.name"/>
            </td>
        </tr>
    </s:iterator>
</table>

<s:debug/>
</body>
</html>

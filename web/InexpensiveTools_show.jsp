<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: tage
  Date: 4/3/16
  Time: 10:47 PM
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
<h4>Inexpensive Tool</h4>
<table border="2">
    <tr>
        <th>
            id
        </th>
        <th>name</th>
        <th>price</th>
        <th>Operation</th>
    </tr>
    <s:iterator value="inexpensiveTools">
        <tr>
            <td>
                <s:property value="id"/>
            </td>
            <td>
                <s:property value="name"/>
            </td>
            <td>
                <s:property value="price"/>
            </td>




            <td>
                    <a href="/WMS/manage/delete?toolid=<s:property value="id"/>">Cancellation</a>
            </td>
        </tr>
    </s:iterator>
</table>

<s:debug/>
</body>
</html>

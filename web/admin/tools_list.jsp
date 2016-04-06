<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: tage
  Date: 4/5/16
  Time: 10:37 AM
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

<a href="/WMS/tools_add_input?departmentid=<s:property value="toolDepartment.id"/>">add</a>


<h4>Inexpensive Tool</h4>
<table border="2">
    <tr>
        <th>
            id
        </th>
        <th>name</th>
        <th>price</th>
        <th>tool state</th>
        <th>staff</th>
        <th>Operation</th>
    </tr>
    <s:iterator value="inexpensiveToolList">
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
                <s:property value="toolState"/>
            </td>

            <td>
                <s:property value="staff.name"/>
            </td>
            <td>
                <s:if test='toolState.toString() == "FREE"'>
                <a href="/WMS/manage/register?toolid=<s:property value="id"/>">register</a>
                </s:if>
              <%--  <s:if test='toolState.toString() == "FREE" || toolState.toString() == "DAMAGED"'>
                <a href="/WMS/manage/delete?toolid=<s:property value="id"/>">delete</a>
                </s:if>--%>
            </td>
        </tr>
    </s:iterator>
</table>

<h4>Expensive Tool</h4>
<table border="2">
    <tr>
        <th>
            id
        </th>
        <th>name</th>
        <th>price</th>
        <th>tool state</th>
        <th>staff</th>
        <th>Request Staff</th>
        <th>Operation</th>
    </tr>
    <s:iterator value="expensiveToolList">
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
                <s:property value="toolState"/>
            </td>

            <td>
                <s:property value="staff.name"/>
            </td>

            <td>
                <s:property value="requestStaff.name"/>
            </td>
            <td>
                <s:if test='toolState.toString() == "REQUESTING"'>
                <a href="/WMS/manage/lend?toolid=<s:property value="id"/>">lend</a>
                </s:if>
            </td>
        </tr>
    </s:iterator>
</table>

<s:debug/>
</body>
</html>

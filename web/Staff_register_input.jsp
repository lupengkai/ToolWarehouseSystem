<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: tage
  Date: 4/4/16
  Time: 1:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@ page import="com.fastrepair.util.DepartmentType" %>
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

<h1 align="center">Register Input</h1>

<div align="center">
<form action="/Login_register_register" method="post">

    Username:<input type="text" name="username"/><br/>
    Password:<input type="password" name="password1"/><br/>
    Repeat password:<input type="password" name="password2"/><br/>


    Company:<select name="company">
        <s:iterator value="allCompanies" >
            <option value="<s:property value="id" />"><s:property value="name"/></option>
            <br>
        </s:iterator>
    </select>

<br/>
    <input type="radio" name="staff" value="employee"/>employee &nbsp;&nbsp;&nbsp;
    Department:<select name="department">
        <%
            for (DepartmentType departmentType : DepartmentType.values()) {
        %>
            <option value="<%=departmentType%>"><%=departmentType%></option>
        <%
            }
        %>
    </select> <br/>
    <input type="radio" name="staff" value="specialist"/>specialist<br/>

<input type="submit" value="Register">
</form>

</div>
</body>
</html>

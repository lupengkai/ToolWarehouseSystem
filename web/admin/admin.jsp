<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<!DOCTYPE>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>Warehouse Management System</title>
    <link type="text/css" rel="stylesheet" href="/css/style.css"/>
    <script type="text/javascript" src="/js/jquery-1.8.3.min.js"></script>
    <script type="text/javascript" src="/js/menu.js"></script>
</head>

<body>
<div class="top"></div>
<div id="header">
    <div class="logo">Warehouse Management System</div>
    <div class="navigation">
        <ul>
            <li>欢迎您！</li>
            <li><a href=""><s:property value="username"/> </a></li>
            <li><a href="">修改密码</a></li>
            <li><a href="">设置</a></li>
            <li><a href="">退出</a></li>
        </ul>
    </div>
</div>
<div id="content">
    <div class="left_menu">
        <ul id="nav_dot">
            <li>
                <h4 class="M1"><span></span>Mangement</h4>
                <div class="list-item none">
                    <a href="/WMS/Expensivetools_manage" target="menuFrame">Inexpensive</a>
                    <a href="/WMS/Inexpensivetools_manage" target="menuFrame">Expensive</a>
                </div>
            </li>
            <li>
                <h4 class="M2"><span></span>Lend</h4>
                <div class="list-item none">
                    <a href="/WMS/Expensivetools_lend" target="menuFrame">Inexpensive</a>
                    <a href="/WMS/Inexpensivetools_lend" target="menuFrame">Expensive</a>
                </div>
            </li>

        </ul>
    </div>
    <div class="m-right">
        <%--<div class="right-nav">
            <ul>
                <li><img src="/images/home.png"></li>
                <li style="margin-left:25px;">您当前的位置：</li>
                <li><a href="#">系统公告</a></li>
                <li>></li>
                <li><a href="#">最新公告</a></li>
            </ul>
        </div>--%>
        <div class="main">
            <iframe id="menuFrame" name="menuFrame" src="" style="overflow:visible;"
                    scrolling="yes" frameborder="no" width="100%" height="100%"></iframe>
        </div>
    </div>
</div>
<div class="bottom"></div>
<div id="footer"><p>FastRepair
</p></div>
<script>navList(12);</script>
</body>
</html>

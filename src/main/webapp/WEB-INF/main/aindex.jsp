<%--
  Created by IntelliJ IDEA.
  User: liuxiwen
  Date: 2017/3/29
  Time: 8:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set value="${pageContext.request.contextPath}" var="shop" />
<html>
<head>
    <%@ include file="/public/head.jspf" %>
</head>
<body class="easyui-layout">
    <div data-options="region: 'north', title: 'North Title', split: true" style="height: 100px;"></div>
    <div data-options="region: 'west', title: 'West Title', split: true" style="width: 200px;">
        <!-- 此处显示的是系统菜单 -->
        <div id="aa" class="easyui-accordion" style="width: 300px;height: 200px;">
            <div title="Title1" data-options="iconCls: 'icon-save'" style="overflow: auto; padding: 10px;">
                <h3 style="color: #0099FF;">Accordion for jQuery</h3>
                <p>Accordion is a part of easyui framework for jQuery. It lets you define your accordion component on web page more easily.</p>
            </div>
            <div title="Title2" data-options="iconCls: 'icon-reload', selected: true" style="padding: 10px;">content2</div>
            <div title="Title3">content3</div>
        </div>
    </div>
    <div data-options="region: 'center', title: 'Center Title'" style="padding: 5px; background: #eee;"></div>
</body>
</html>

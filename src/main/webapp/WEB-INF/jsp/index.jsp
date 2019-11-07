<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="copyright" content="All Rights Reserved, Copyright (C) 2018, Wuyeguo, Ltd."/>
    <title>首页</title>
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/easyui/1.3.4/themes/default/easyui.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/wu.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/icon.css"/>

    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/easyui/1.3.4/jquery.easyui.min.js"></script>
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/easyui/1.3.4/locale/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/echarts.min.js"></script>


</head>
<body class="easyui-layout">
<!-- 头部开始 -->
<div class="wu-header" data-options="region:'north',border:false,split:true">
    <div class="wu-header-left">
        <h1>简单OA系统</h1>
    </div>
    <div class="wu-header-right">
        <p><strong class="easyui-tooltip" title="2条未读消息">${user.userName}</strong>，欢迎您！</p>
        <p><a href="#" target="_self" iframe="0">网站首页</a>|<a href="#">支持论坛</a>|<a href="#">帮助中心</a>|<a href="javascript:openout()">安全退出</a></p>
    </div>
</div>
<!-- 头部结尾 -->
<!-- 左边导航开始 -->
<div class="wu-sidebar" data-options="region:'west',split:true,border:true,title:'导航菜单'">
    <div class="easyui-accordion" data-options="border:false,fit:false">
        <div title="员工管理" data-options="iconCls:'icon-application-osx-home'" style="padding:5px;">
            <ul class="easyui-tree wu-side-tree">
                <li iconCls="icon-users"><a href="javascript:void(0)" data-icon="icon-chart-organisation" data-link="toStaffIndex.staff" iframe="0">信息管理</a></li>
                <li iconCls="icon-book-magnify"><a href="javascript:void(0)" data-icon="icon-user-group" data-link="toStaffArchives.staff" iframe="0">档案管理</a></li>
                <li iconCls="icon-book-tabs"><a href="javascript:void(0)" data-icon="icon-users" data-link="toPactStaff.staff" iframe="0">合同管理</a></li>
                <%--<li iconCls="icon-book"><a href="javascript:void(0)" data-icon="icon-book" data-link="toPermissions.permissions" iframe="0">权限管理</a></li>
                <li iconCls="icon-book"><a href="javascript:void(0)" data-icon="icon-book" data-link="student-search.do" iframe="0">修改密码</a></li>--%>
            </ul>
        </div>
        <div title="人事调动管理" data-options="iconCls:'icon-application-view-icons'" style="padding:5px;">
            <ul class="easyui-tree wu-side-tree">
                <li iconCls="icon-bricks"><a href="javascript:void(0)" data-icon="icon-chart-organisation" data-link="toPersonnelstaff.personnel" iframe="0">员工职务信息</a></li>
                <li iconCls="icon-brick-go"><a href="javascript:void(0)" data-icon="icon-chart-organisation" data-link="toPersonnelIndex.personnel" iframe="0">人事调动记录</a></li>
            </ul>
        </div>
        <div title="薪酬管理" data-options="iconCls:'icon-application-osx-link'" style="padding:5px;">
            <ul class="easyui-tree wu-side-tree">
                <li iconCls="icon-chart-bar"><a href="javascript:void(0)" data-icon="icon-chart-organisation" data-link="toPay.pay" iframe="0">薪酬员工</a></li>
                <li iconCls="icon-chart-bar-link"><a href="javascript:void(0)" data-icon="icon-chart-organisation" data-link="toPayRecord.pay" iframe="0">薪酬记录</a></li>
                <li iconCls="iicon-clipboard"><a href="javascript:void(0)" data-icon="icon-chart-organisation" data-link="toMertisMoney.mertis" iframe="0">绩效管理</a></li>
                <li iconCls="icon-coins"><a href="javascript:void(0)" data-icon="icon-chart-organisation" data-link="toBasicMoney.basic" iframe="0">基本工资管理</a></li>
            </ul>
        </div>
        <div title="考勤管理" data-options="iconCls:'icon-application-osx-split'" style="padding:5px;">
            <ul class="easyui-tree wu-side-tree">
                <li iconCls="icon-comments"><a href="javascript:void(0)" data-icon="icon-chart-organisation" data-link="toCheckStaff.check" iframe="0">考勤员工</a></li>
                <li iconCls="icon-comment-play"><a href="javascript:void(0)" data-icon="icon-chart-organisation" data-link="toCheckIndex.check" iframe="0">考勤管理记录</a></li>
                <li iconCls="icon-comment-record"><a href="javascript:void(0)" data-icon="icon-chart-organisation" data-link="checktype.check" iframe="0">考勤类型管理</a></li>
            </ul>
        </div>
        <div title="部门管理" data-options="iconCls:'icon-application-osx-key'" style="padding:5px;">
            <ul class="easyui-tree wu-side-tree">
                <li iconCls="icon-drink-empty"><a href="javascript:void(0)" data-icon="icon-chart-organisation" data-link="toDepartment.department" iframe="0">部门管理</a></li>
                <li iconCls="icon-drink-red"><a href="javascript:void(0)" data-icon="icon-chart-organisation" data-link="toPosition.position" iframe="0">职务管理</a></li>
            </ul>
        </div>
    </div>

</div>
<div id="wu-dialog" class="easyui-dialog" data-options="closed:true,iconCls:'icon-save'"
     style="width:400px; padding:10px;">
    <p style="font-size: 20px;margin: auto 0;padding-left: 140px">确认退出</p>
</div>
<!-- 左边导航结尾 -->
<!-- 工作区域开始 -->
<div class="wu-main" data-options="region:'center'">
    <div id="wu-tabs" class="easyui-tabs" data-options="border:false,fit:true">
        <div title="首页" data-options="href:'xx.do',closable:false,iconCls:'icon-tip',cls:'pd3'"></div>
    </div>
</div>
<!-- 工作区域结束 -->
<!-- 底部开始 -->
<div class="wu-footer" data-options="region:'south',border:true,split:true">
    &copy; 2018 版 版权所有:rock
</div>
<!-- 底部结束 -->
<script type="text/javascript">

    function out(){
        console.log('今天你好');
        window.location.href='Out.login';
    }

    function openout(){
        $('#wu-dialog').dialog({
            closed: false,
            modal: true,
            title: "确认关闭",
            buttons: [{
                text: '确定',
                iconCls: 'icon-ok',
                handler: out
            }, {
                text: '取消',
                iconCls: 'icon-cancel',
                handler: function () {
                    $('#wu-dialog').dialog('close');
                }
            }]
        });
    }


    $(function () {
        $('.wu-side-tree a').bind("click", function () {
            var title = $(this).text();
            var url = $(this).attr('data-link');
            var iconCls = $(this).attr('data-icon');
            var iframe = $(this).attr('iframe') == 1 ? true : false;
            addTab(title, url, iconCls, iframe);
        });
    })

    /**
     * Name 添加菜单选项
     * Param title 名称
     * Param href 链接
     * Param iconCls 图标样式
     * Param iframe 链接跳转方式（true为iframe，false为href）
     */
    function addTab(title, href, iconCls, iframe) {
        var tabPanel = $('#wu-tabs');
        if (!tabPanel.tabs('exists', title)) {
            var content = '<iframe scrolling="auto" frameborder="0"  src="' + href + '" style="width:100%;height:100%;"></iframe>';

            tabPanel.tabs('add', {
                title: title,
                content: content,
                iconCls: iconCls,
                fit: true,
                cls: 'pd3',
                closable: true
            });

        } else {
            tabPanel.tabs('select', title);
        }
    }

    /**
     * Name 移除菜单选项
     */
    function removeTab() {
        var tabPanel = $('#wu-tabs');
        var tab = tabPanel.tabs('getSelected');
        if (tab) {
            var index = tabPanel.tabs('getTabIndex', tab);
            tabPanel.tabs('close', index);
        }
    }
</script>
</body>
</html>

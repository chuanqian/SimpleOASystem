<%--
  Created by IntelliJ IDEA.
  User: 11789
  Date: 2019.8.21
  Time: 14:24
  To change this template use File | Settings | File Templates.
--%>
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
<body>
<div class="easyui-layout" data-options="fit:true">

    <div data-options="region:'center',border:false">
        <!-- 工具栏开始 -->
        <div id="wu-toolbar">
            <div class="wu-toolbar-button">
                <a href="#" class="easyui-linkbutton" iconCls="icon-add" onclick="openAdd()" plain="true">添加</a>
                <a href="#" class="easyui-linkbutton" iconCls="icon-edit" onclick="openEdit()" plain="true">修改</a>
                <a href="#" class="easyui-linkbutton" iconCls="icon-remove" onclick="remove()" plain="true">删除</a>
                <a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="cancel()" plain="true">取消</a>
                <a href="#" class="easyui-linkbutton" iconCls="icon-reload" onclick="reload()" plain="true">刷新</a>
                <a href="#" class="easyui-linkbutton" iconCls="icon-print" onclick="openAdd()" plain="true">打印</a>
                <a href="#" class="easyui-linkbutton" iconCls="icon-help" onclick="openEdit()" plain="true">帮助</a>
                <a href="#" class="easyui-linkbutton" iconCls="icon-undo" onclick="remove()" plain="true">撤销</a>
                <a href="#" class="easyui-linkbutton" iconCls="icon-redo" onclick="cancel()" plain="true">重做</a>
                <a href="#" class="easyui-linkbutton" iconCls="icon-sum" onclick="reload()" plain="true">总计</a>
                <a href="#" class="easyui-linkbutton" iconCls="icon-back" onclick="reload()" plain="true">返回</a>
                <a href="#" class="easyui-linkbutton" iconCls="icon-tip" onclick="reload()" plain="true">提示</a>
                <a href="#" class="easyui-linkbutton" iconCls="icon-save" onclick="reload()" plain="true">保存</a>
                <a href="#" class="easyui-linkbutton" iconCls="icon-cut" onclick="reload()" plain="true">剪切</a>
            </div>
            <div class="wu-toolbar-search">
                <%--<label>起始时间：</label><input class="easyui-datebox" style="width:100px">
                <label>结束时间：</label><input class="easyui-datebox" style="width:100px">
                <label>用户组：</label>--%>
                <%--<select class="easyui-combobox" panelHeight="auto" style="width:100px">
                    <option value="0">选择用户组</option>
                    <option value="1">黄钻</option>
                    <option value="2">红钻</option>
                    <option value="3">蓝钻</option>
                </select>--%>
                <label>部门名称：</label><input id="deptName" class="wu-text" style="width:100px">
                <a href="javascript:opensearch()" class="easyui-linkbutton" iconCls="icon-search">开始检索</a>
            </div>
        </div>
        <!-- 工具栏结束 -->
        <!--表格开始  -->
        <table id="wu-datagrid" toolbar="#wu-toolbar"></table>
        <!--表格结束  -->
    </div>
</div>
<!-- 模态框开始 -->
<div id="wu-dialog" class="easyui-dialog" data-options="closed:true,iconCls:'icon-save'"
     style="width:400px; padding:10px;">
    <form id="wu-form" method="post">
        <table>
            <tr>
                <td width="60" align="right">部门名称:</td>
                <td>
                    <input type="text" name="departmentName" class="wu-text"/>
                    <input type="hidden" name="departmentId" class="wu-text"/>
                </td>
            </tr>
            <tr>
                <td align="right">部门总人数:</td>
                <td><input type="text" name="departmentTotalnum" class="wu-text"/></td>
            </tr>
            <tr>
                <td align="right">部门现有人数:</td>
                <td><input type="text" name="departmentExitsnum" class="wu-text"/></td>
            </tr>
        </table>
    </form>
</div>
</body>
<!-- 模态框结束-->
<script type="text/javascript">

    /**
     * 模糊查询
     */
    function opensearch() {
        var deptname=$("#deptName").val();
        var url='getAllDepartmentBySql.department?departmentName='+deptname;
        openthe(url);
    }

    /**
     * 添加记录
     */
    function add() {
        $('#wu-form').form('submit', {
            url: 'addDepartment.department',
            success: function (data) {
                var data = eval('(' + data + ')');
                console.log(data)
                if (data) {
                    $.messager.alert('信息提示', '提交成功！', 'info');
                    $('#wu-dialog').dialog('close');
                    $('#wu-datagrid').datagrid("load");
                } else {
                    $.messager.alert('信息提示', '提交失败！', 'info');
                }
            }
        });
    }

    /**
     *  修改记录
     */
    function edit() {

        $('#wu-form').form('submit', {
            url: 'editDepartment.department',
            success: function (data) {
                var data = eval('(' + data + ')');
                if (data) {
                    $.messager.alert('信息提示', '提交成功！', 'info');
                    $('#wu-dialog').dialog('close');
                    $('#wu-datagrid').datagrid("load");
                } else {
                    $.messager.alert('信息提示', '提交失败！', 'info');
                }
            }
        });
    }

    /**
     *  删除记录
     */
    function remove() {
        $.messager.confirm('信息提示', '确定要删除该记录？', function (result) {
            if (result) {
                var items = $('#wu-datagrid').datagrid('getSelections');
                console.log(items)
                var ids = "";
                $(items).each(function () {

                    ids += this.sysId + ","
                });
                console.log(ids);

                $.ajax({
                    url: 'removeDepartment.department',
                    data: {id: ids},
                    success: function (data) {
                        if (data) {
                            $.messager.alert('信息提示', '删除成功！', 'info');
                            $('#wu-datagrid').datagrid("load");
                        } else {
                            $.messager.alert('信息提示', '删除失败！', 'info');
                        }
                    }
                });
            }
        });
    }

    /**
     * 打开添加窗口
     */
    function openAdd() {
        $('#wu-form').form('clear');
        $('#wu-dialog').dialog({
            closed: false,
            modal: true,
            title: "添加信息",
            buttons: [{
                text: '确定',
                iconCls: 'icon-ok',
                handler: add
            }, {
                text: '取消',
                iconCls: 'icon-cancel',
                handler: function () {
                    $('#wu-dialog').dialog('close');
                }
            }]
        });
    }

    /**
     *  打开修改窗口
     */
    function openEdit() {
        //获取选中行
        var item = $('#wu-datagrid').datagrid('getSelected');
        console.log(item)
        if (item == null) {
            $.messager.alert('信息提示', '请选中行！', 'info');
            return;
        }
        $('#wu-form').form('clear');


        //绑定值
        $('#wu-form').form('load', item)

        $('#wu-dialog').dialog({
            closed: false,
            modal: true,
            title: "修改信息",
            buttons: [{
                text: '确定',
                iconCls: 'icon-ok',
                handler: edit
            }, {
                text: '取消',
                iconCls: 'icon-cancel',
                handler: function () {
                    $('#wu-dialog').dialog('close');
                }
            }]
        });
    }


    /**
     * 载入数据
     */
    openthe('getAllDepartmentBySql.department')
    function openthe(url) {
        $('#wu-datagrid').datagrid({
            url: url,
            method: "get",//提交方式
            rownumbers: true,//显示行号
            singleSelect: false,
            pagination: true, //如果表格需要支持分页，必须设置该选项为true
            pageSize: 5, //表格中每页显示的行数
            pageList: [5, 10, 15],
            fitColumns: true,
            fit: true,
            columns: [[
                {checkbox: true},
                {field: 'departmentName', title: '部门名称', width: 100},

                {field: 'departmentTotalnum', title: '部门总职务数', width: 100},
                {field: 'departmentLacknum', title: '部门缺少职务数', width: 100},
                {field: 'departmentExitsnum', title: '部门现有职务数', width: 100}

            ]]
        });
    }
</script>

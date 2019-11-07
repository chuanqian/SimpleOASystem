<%--
  Created by IntelliJ IDEA.
  User: 11789
  Date: 2019.8.21
  Time: 16:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="copyright" content="All Rights Reserved, Copyright (C) 2018, Wuyeguo, Ltd."/>
    <title>员工管理</title>
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/easyui/1.3.4/themes/default/easyui.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/wu.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/icon.css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/easyui/1.3.4/jquery.easyui.min.js"></script>
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/easyui/1.3.4/locale/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/echarts.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/verify.js"></script>
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
                <a href="#" class="easyui-linkbutton" iconCls="icon-tip" onclick="openenable()" plain="true">授权</a>
                <a href="#" class="easyui-linkbutton" iconCls="icon-tip" onclick="openEditPassword()" plain="true">修改密码</a>
            </div>
            <div class="wu-toolbar-search">
                <label>入职起始时间：</label><input id="starttime" class="easyui-datebox" style="width:100px">
                <label>入职结束时间：</label><input id="endtime" class="easyui-datebox" style="width:100px">
                <label>职位：</label>
                <select id="pid" class="easyui-combobox" panelHeight="auto" style="width:100px">
                </select>
                <label>员工姓名：</label><input id="staffname" class="wu-text" style="width:100px">
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
     style="overflow:auto;width:400px;height: 300px; padding:10px;">
    <form id="wu-form" method="post">
        <table>
            <tr>
                <td>
                    <p></p>
                </td>
            </tr>
            <tr>
                <td align="right">员工账号:</td>
                <td><input id="accounts" type="text" name="userName" class="wu-text" onfocus="inaccounts()" onblur="onaccounts()"/></td>
                <td id="account">*</td>
            </tr>
            <tr>
                <td align="right">员工密码:</td>
                <td><input id="passwords" type="password" name="userPassword" class="wu-text" onfocus="inpasswords()" onblur="onpasswords()"/></td>
                <td id="password">*</td>
            </tr>
            <tr>
                <td>
                    <p></p>
                </td>
            </tr>
            <tr>
                <td align="right">员工名称:</td>
                <td><input id="names" type="text" name="staffName" class="wu-text"/></td>
                <td id="name">*</td>
            </tr>
            <tr>
                <td align="right">员工性别:</td>
                <td>
                    <select id="sexs" name="staffSex" class="wu-text easyui-combobox" panelHeight="auto">
                        <option value="男">男</option>
                        <option value="女">女</option>
                    </select>
                </td>
                <td id="sex">*</td>
            </tr>
            <tr>
                <td align="right">出生日期:</td>
                <td><input id="briths" name="staffBirth" class="wu-text easyui-datebox"/></td>
                <td id="brith">*</td>
            </tr>
            <tr>
                <td align="right">联系方式:</td>
                <td><input id="phones" type="text" name="staffPhone" class="wu-text" onfocus="inphones()" onblur="onphones()"/></td>
                <td id="phone">*</td>
            </tr>
            <tr>
                <td align="right">员工邮箱:</td>
                <td><input id="emails" type="text" name="staffEmail" class="wu-text" onfocus="inemails()" onblur="onemails()"/></td>
                <td id="email">*</td>
            </tr>
            <tr>
                <td align="right">员工学历:</td>
                <td>
                    <select id="xuelis" name="staffXueli" class="wu-text easyui-combobox" panelHeight="auto">
                        <option value="小学">小学</option>
                        <option value="中学">中学</option>
                        <option value="本科">本科</option>
                        <option value="研究生">研究生</option>
                        <option value="博士">博士</option>
                    </select>
                </td>
                <td id="xueli">*</td>
            </tr>


            <tr>
                <td align="right">职务:</td>
                <td>
                    <select name="staffPosition" class="wu-text easyui-combobox" panelHeight="auto" id="pn">
                    </select>
                </td>
                <td id="pns">*</td>
            </tr>


            <tr>
                <td align="right">入职时间:</td>
                <td><input id="intimes" name="staffInTime" class="wu-text easyui-datebox"/></td>
            </tr>


            <tr>
                <td align="right">状态:</td>
                <td>
                    <select name="staffStatusId" class="wu-text easyui-combobox" panelHeight="auto" id="staId">
                    </select>
                </td>
                <td id="status">*</td>
            </tr>


            <tr>
                <td align="right">员工备注:</td>
                <td><input id="staff-infos" type="text" name="staffNote" class="wu-text"/></td>
                <td id="staff-info">*</td>
            </tr>

            <tr>
                <td>
                    <p></p>
                </td>
            </tr>

            <tr>
                <td align="right">档案名称:</td>
                <td><input id="anames" type="text" name="archivesName" class="wu-text"/></td>
                <td id="aname">*</td>
            </tr>
            <tr>
                <td align="right">档案内容:</td>
                <td><input id="a-infos" type="text" name="archivesInfo" class="wu-text"/></td>
                <td id="a-info">*</td>
            </tr>
            <tr>
                <td align="right">档案备注:</td>
                <td><input id="a-notes" type="text" name="archivesNote" class="wu-text"/></td>
                <td id="a-note">*</td>
            </tr>
            <tr>
                <td>
                    <p></p>
                </td>
            </tr>
            <tr>
                <td align="right">合同开始时间:</td>
                <td><input name="pactCreateTime" class="wu-text easyui-datebox"/></td>
            </tr>
            <tr>
                <td align="right">合同结束时间:</td>
                <td><input name="pactEndTime" class="wu-text easyui-datebox"/></td>
            </tr>
            <tr>
                <td align="right">合同内容:</td>
                <td><input id="p-infos" type="text" name="pactInfo" class="wu-text"/></td>
                <td id="p-info">*</td>
            </tr>
            <tr>
                <td align="right">合同备注:</td>
                <td><input id="p-notes" type="text" name="pactNote" class="wu-text"/></td>
                <td id="p-note">*</td>
            </tr>


        </table>
    </form>
</div>
<div id="staff-update" class="easyui-dialog" data-options="closed:true,iconCls:'icon-save'"
     style="width:400px; padding:10px;">
    <form id="staff-form" method="post">
        <table>
            <tr>
                <td align="right">员工名称:</td>
                <td>
                    <input type="text" name="staffName" class="wu-text"/>
                    <input type="hidden" name="staffUid" class="wu-text"/>
                </td>
            </tr>
            <tr>
                <td align="right">员工性别:</td>
                <td><input type="text" name="staffSex" class="wu-text"/></td>
            </tr>
            <tr>
                <td align="right">出生日期:</td>
                <td><input name="staffBirth" class="wu-text easyui-datebox"/></td>
            </tr>
            <tr>
                <td align="right">联系方式:</td>
                <td><input type="text" name="staffPhone" class="wu-text"/></td>
            </tr>
            <tr>
                <td align="right">员工邮箱:</td>
                <td><input type="text" name="staffEmail" class="wu-text"/></td>
            </tr>
            <tr>
                <td align="right">员工学历:</td>
                <td><select name="staffXueli" class="wu-text easyui-combobox" panelHeight="auto">
                    <option value="小学">小学</option>
                    <option value="中学">中学</option>
                    <option value="本科">本科</option>
                    <option value="研究生">研究生</option>
                    <option value="博士">博士</option>
                </select>
                </td>
            </tr>
            <tr>
                <td align="right">状态:</td>
                <td>
                    <select name="staffStatusId" class="wu-text easyui-combobox" panelHeight="auto" id="staId-update">
                    </select>
                </td>
            </tr>
            <tr>
                <td align="right">员工备注:</td>
                <td><input type="text" name="staffNote" class="wu-text"/></td>
            </tr>
        </table>
    </form>
</div>
<!-- 授权模态框 -->
<div id="editPassword-dialog" class="easyui-dialog" data-options="closed:true,iconCls:'icon-save'"
     style="width:400px; padding:10px;">
    <form id="editPassword-form" method="post">
        <table>
            <tr>
                <td width="60" align="right">员工姓名:</td>
                <td>
                    <input type="hidden" name="staffUid" class="wu-text" readonly="readonly"/>
                    <input type="text" name="staffName" class="wu-text" readonly="readonly"/>
                </td>
            </tr>
            <tr>
                <td align="right">新密吗:</td>
                <td><input type="text" name="newPassword" class="wu-text"/></td>
            </tr>
        </table>
    </form>
</div>
<!-- 授权模态框 -->
<div id="enable-dialog" class="easyui-dialog" data-options="closed:true,iconCls:'icon-save'"
     style="width:400px; padding:10px;">
    <form id="enable-form" method="post">
        <table>
            <tr>
                <td width="60" align="right">员工姓名:</td>
                <td>
                    <input type="hidden" name="staffUid" class="wu-text" readonly="readonly"/>
                    <input type="text" name="staffName" class="wu-text" readonly="readonly"/>
                </td>
            </tr>
            <tr>
                <td align="right">权限:</td>
                <td>
                    <select name="roleIds" class="wu-text easyui-combobox" panelHeight="auto" id="limit">
                    </select>
                </td>
            </tr>

        </table>
    </form>
</div>
</body>
<!-- 模态框结束-->
<script type="text/javascript">

    /**
     * 验证账户名
     */
    function inaccounts() {
        // console.log('jin');
        $("#account").css("color","black");
        $('#addBtn').linkbutton({
            disabled: false
        });
    }
    function onaccounts(){
        var account=$("#accounts").val();
        // console.log('chu');
        if(verifyaccount(account)){
            // console.log('qu');
            $("#account").css("color","red");
            $('#addBtn').linkbutton({
                disabled: true
            });

        }
    }

    /**
     * 验证密码
     */
    function inpasswords() {
        $("#password").css("color","black");
        $('#addBtn').linkbutton({
            disabled: false
        });
    }
    function onpasswords(){
        var account=$("#passwords").val();
        if(verifyPassword(account)){
            $("#password").css("color","red");
            $('#addBtn').linkbutton({
                disabled: true
            });
        }
    }

    /**
     * 验证联系方式
     */
    function inphones() {
        $("#phone").css("color","black");
        $('#addBtn').linkbutton({
            disabled: false
        });
    }
    function onphones(){
        var account=$("#phones").val();
        if(verifyphone(account)){
            $("#phone").css("color","red");
            $('#addBtn').linkbutton({
                disabled: true
            });
        }
    }

    /**
     * 验证邮箱
     */
    function inemails() {
        $("#email").css("color","black");
        $('#addBtn').linkbutton({
            disabled: false
        });
    }
    function onemails(){
        var account=$("#emails").val();
        if(verifyemail(account)){
            $("#email").css("color","red");
            $('#addBtn').linkbutton({
                disabled: true
            });
        }
    }


    /**
     * 加载职位newpid
     */
    $("#pid").combobox({
        url: "getAllPosition.position",//url*
        valueField: "positionId", //相当于 option 中的 value 发送到后台的
        textField: "positionName"//option中间的内容 显示给用户看的
    });

    /**
     * 模糊查询
     */
    function opensearch() {
        var starttime = $("#starttime").datebox("getValue");
        var endtime = $("#endtime").datebox("getValue");
        var pid = $("#pid").combobox("getValue");
        var staffname = $("#staffname").val();
        var url = 'getAllStaff.staff?startTime?startTime=' + starttime + '&endTime=' + endtime + '&staffPosition=' + pid + '&staffName=' + staffname;
        console.log(url);
        openthe(url);
    }


    /**
     * 添加记录
     */
    function add() {
        $('#wu-form').form('submit', {
            url: 'addStaffAndUserLoginAndArchivesAndPact.staff',
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

        $('#staff-form').form('submit', {
            url: 'updateStaff.staff',
            success: function (data) {
                var data = eval('(' + data + ')');
                if (data) {
                    $.messager.alert('信息提 示', '提交成功！', 'info');
                    $('#staff-update').dialog('close');
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
                console.log(items);
                // console.log(items.position.positionName);
                var ids = "";
                var pids = "";
                $(items).each(function () {
                    ids += this.staffUid + ",";
                    pids += this.position.positionName + ","
                });
                console.log(ids);
                console.log(pids);

                $.ajax({
                    url: 'removeStaff.staff',
                    data: {
                        id: ids,
                        positionNames: pids
                    },
                    success: function (data) {
                        console.log(data);
                        if (!data) {
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

    /*
    * 分配权限
    */
    function enable() {

        $('#enable-form').form('submit', {
            url: 'toGiveEnable.enable',
            success: function (data) {
                var data = eval('(' + data + ')');
                if (data) {
                    $.messager.alert('信息提示', '授权成功！', 'info');
                    $('#enable-dialog').dialog('close');
                    $('#wu-datagrid').datagrid("load");
                } else {
                    $.messager.alert('信息提示', '授权失败！', 'info');
                }
            }
        });

    }
    function enablePassword() {
        $('#editPassword-form').form('submit',{
            url: 'editPassword.enable',
            success:function (data) {
                var data = eval('('+data+')');
                if(data){
                    $.messager.alert('信息提示','修改成功','info');
                    $('#editPassword-dialog').dialog('close');
                    $('#wu-datagrid').datagrid("load");
                }else{
                    $.messager.alert('信息提示','修改失败','info');
                }
            }
        })
    }

    /*
    * 打开授权模态框
    */
    function openenable() {

        //获取选中行
        var item = $('#wu-datagrid').datagrid('getSelected');
        console.log(item);
        if (item == null) {
            $.messager.alert('信息提示', '请选中行！', 'info');
            return;
        }
        $('#enable-form').form('clear');
        //绑定值
        $('#enable-form').form('load', item);

        $("#limit").combobox({
            url: "getAllRole.role",//url*
            valueField: "roleId", //相当于 option 中的 value 发送到后台的
            textField: "roleName",//option中间的内容 显示给用户看的
            multiple: true
        });

        $('#enable-dialog').dialog({
            closed: false,
            modal: true,
            title: "分配权限",
            buttons: [{
                text: '确定',
                iconCls: 'icon-ok',
                handler: enable
            }, {
                text: '取消',
                iconCls: 'icon-cancel',
                handler: function () {
                    $('#enable-dialog').dialog('close');
                }
            }]
        });

    }

    /*
    * 打开修改密码模态框
    */
    function openEditPassword() {

        //获取选中行
        var item = $('#wu-datagrid').datagrid('getSelected');
        console.log(item);
        if (item == null) {
            $.messager.alert('信息提示', '请选中行！', 'info');
            return;
        }
        $('#editPassword-form').form('clear');
        //绑定值
        $('#editPassword-form').form('load', item);


        $('#editPassword-dialog').dialog({
            closed: false,
            modal: true,
            title: "分配权限",
            buttons: [{
                text: '确定',
                iconCls: 'icon-ok',
                handler: enablePassword
            }, {
                text: '取消',
                iconCls: 'icon-cancel',
                handler: function () {
                    $('#editPassword-dialog').dialog('close');
                }
            }]
        });

    }


    /**
     * 打开添加窗口
     */
    function openAdd() {

        $('#wu-form').form('clear');

        $("#pn").combobox({
            url: "getAllPosition.position",//url*
            valueField: "positionId", //相当于 option 中的 value 发送到后台的
            textField: "positionName"//option中间的内容 显示给用户看的
        });

        $("#staId").combobox({
            url: "getAllStaffStatus.status",//url*
            valueField: "staffStatusId", //相当于 option 中的 value 发送到后台的
            textField: "staffStatusName"//option中间的内容 显示给用户看的
        });

        $('#wu-dialog').dialog({
            closed: false,
            modal: true,
            title: "添加信息",
            buttons: [{
                text: '确定',
                id:"addBtn",
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
        console.log(item);
        if (item == null) {
            $.messager.alert('信息提示', '请选中行！', 'info');
            return;
        }
        $('#staff-form').form('clear');

        //绑定值
        $('#staff-form').form('load', item);
        $("#staId-update").combobox({
            url: "getAllStaffStatus.status",//url*
            valueField: "staffStatusId", //相当于 option 中的 value 发送到后台的
            textField: "staffStatusName"//option中间的内容 显示给用户看的
        });

        $('#staff-update').dialog({
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
                    $('#staff-update').dialog('close');
                }
            }]
        });
    }


    /**
     * 载入数据
     */
    openthe('getAllStaff.staff');

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
                {field: 'staffName', title: '员工姓名', width: 100},
                {field: 'staffSex', title: '员工性别', width: 100},
                {field: 'staffBirth', title: '员工出生日期', width: 100},
                {field: 'staffPhone', title: '员工联系方式', width: 100},
                {field: 'staffEmail', title: '员工邮箱', width: 100},
                {field: 'staffXueli', title: '员工学历', width: 100},
                {
                    field: 'position', title: '员工职务名称', width: 100,
                    formatter: function (value) {
                        console.log(value);
                        return value.positionName;
                    }

                },
                {field: 'staffInTime', title: '员工入职时间', width: 100},
                {
                    field: 'staffStatus', title: '员工状态', width: 100,
                    formatter: function (value) {
                        return value.staffStatusName;
                    }
                },
                {field: 'staffNote', title: '员工备注', width: 100},
                {field: 'trainingResult', title: '培训评价', width: 100}

            ]]
        });
    }

</script>

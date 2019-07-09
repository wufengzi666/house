<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="easyUI/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="easyUI/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="easyUI/css/demo.css">
    <script src="js/jquery-1.8.3.js"></script>
    <!--jquery.easyui.min.js包含了easyUI中的所有插件-->
    <script src="js/jquery.easyui.min.js"></script>
    <script language="JavaScript" src="js/district.js"></script>
</head>
<%---------------------------------------------------------------------------------------------------------------------------------------%>
<%---------------------------------------------------------------------------------------------------------------------------------------%>
<%---------------------------------------------------------------------------------------------------------------------------------------%>
<body>
<table id="dg"></table>

<%--设置表条的工具栏--%>
<div id="toolbar">
    <a href="javascript:add1()" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true"a>添加</a>
    <a href="javascript:up1()" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true"a>修改</a>
    <a href="javascript:delete2()" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true"a>批量删除</a>
</div>

<%--增加对话框--%>
<div id="addDialog" class="easyui-dialog" title=">>>>>>>增加区域<<<<<<"
     buttons="#bb"
     style="width:400px;height:200px; padding: 10px 20px;"
     closed="true">
    <form id="addform"  method="post">
        <table>
            <tr>
                <td>区域名称:</td>
                <td><input type="text" class="easyui-validatebox" required
                           name="name" id="bname" /></td>
            </tr>
        </table>
    </form>
</div>

<%--添加的对话框底部增加按钮--%>
<div id="bb">
    <a href="javascript:add2()" class="easyui-linkbutton" iconCls="icon-ok">添加</a>
    <a href="javascript:add3()" class="easyui-linkbutton" iconCls="icon-cancel">关闭</a>
</div>

<%--修改的对话框--%>
<div id="upDialog" class="easyui-dialog" title=">>>>>>>修改区域<<<<<<"
     buttons="#up"
     style="width:400px;height:200px; padding: 10px 20px;"
     closed="true">
    <form id="upform"  method="post">
        <table>
            <tr>
                <td>区域编号:</td>
                <td><input type="text" class="easyui-validatebox" required
                           name="id" id="ididd" /></td>
            </tr>
            <tr>
                <td>区域名称:</td>
                <td><input type="text" class="easyui-validatebox" required
                           name="name" id="name" /></td>
            </tr>
        </table>
    </form>
</div>

<%--修改对话框的底部按钮--%>
<div id="up">
    <a href="javascript:up2()" class="easyui-linkbutton" iconCls="icon-ok">修改</a>
    <a href="javascript:up3()" class="easyui-linkbutton" iconCls="icon-cancel">关闭</a>
</div>
<%--查看街道的对话框--%>
<div id="lookdialog" class="easyui-dialog" title=">>>>>>>街道信息<<<<<<"
     buttons="#lk"
     style="width:400px;height:500px; padding: 10px 20px;"
     closed="true">
    <table id="street"></table>
</div>

<%--查看街道的对话框底部按钮--%>
<div id="lk">
    <a href="javascript:look2()" class="easyui-linkbutton" iconCls="icon-cancel">关闭</a>
</div>

</body>
</html>

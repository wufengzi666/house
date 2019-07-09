<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="easyUI/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="easyUI/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="easyUI/css/demo.css">
    <script src="js/jquery-1.8.3.js"></script>
    <!--jquery.easyui.min.js包含了easyUI中的所有插件-->
    <script src="js/jquery.easyui.min.js"></script>
    <script>
        
       $(function () {
           $("#dg").datagrid({
               url:'gettypepage',
               title:"类型管理",
               toolbar:"#toolbar",
               pagination:"true",
               pageList:[3,5,10,15,20],
               pageSize:3,
               columns:[[
                   {field:'ck',checkbox:"true",width:100,align:'left'},
                   {field:'id',title:'类型编号',width:100},
                   {field:'name',title:'类型名称',width:100},
                   {field:'cz',title:'操作', width:80,
                       formatter: function(value,row,index){
                           return ' <a href="javascript:delete1('+row.id+')" class="easyui-linkbutton" iconCls="icon-ok">删除</a>';
                       }
                   }
               ]]
           });
       })
        
       /* 打开添加对话框*/
        function add1() {
            $("#addDialog").dialog("open");
        }

        //实现添加操作
        function add2() {
            $("#addform").form('submit',{
                url:"addtype",
                success:function (da) {
                    da=$.parseJSON(da);
                    if(da.resout==1){
                        $("#addDialog").dialog("close");
                        $.messager.alert("提示框","添加成功","info");
                        $("#dg").datagrid("reload");
                    }else {
                        $.messager.alert("提示框","添加失败","info");
                    }
                }});
        }

        function add3() {
            $("#addDialog").dialog("close");
        }

        function delete1(id) {
            $.messager.confirm('提示框', '确定要删除吗？^~^', function(r){
                if (r){
                    $.post("deletetype",{"id":id},function (da) {
                        if (da.resout == 1) {
                            $("#dg").datagrid("reload");
                            $.messager.alert("提示框", "删除成功^-^QAQ!", "info");
                        } else {
                            $.messager.alert("提示框", "删除失败^-^QAQ!", "info");
                        }
                    },"json")
                }else {
                    $.messager.alert("提示框","想好了再点啊","info")
                }
            });
        }


    </script>
</head>
<%--.....................................................................................
.........................................................................................--%>
<body>
<table id="dg"></table>

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
                <td>房屋类型名称:</td>
                <td><input type="text" class="easyui-validatebox" required
                           name="name" id="bname" /></td>
            </tr>
        </table>
    </form>
</div>

<%--增加对话框底部的按钮--%>
<div id="bb">
    <a href="javascript:add2()" class="easyui-linkbutton" iconCls="icon-ok">添加</a>
    <a href="javascript:add3()" class="easyui-linkbutton" iconCls="icon-cancel">关闭</a>
</div>


</body>
</html>

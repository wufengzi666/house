<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <title>Title</title>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="easyUI/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="easyUI/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="easyUI/css/demo.css">
    <script src="js/jquery-1.8.3.js"></script>
    <script src="js/jquery.easyui.min.js"></script>
    <script>
     $(function () {
         $("#dg").datagrid({
             url:"getuserpage",
             title:"用户管理",
             toolbar:"#toolbar",
             pagination:"true",
             pageList:[3,5,10,15,20],
             pageSize:3,
             columns:[[
                 {field:'ck',checkbox:"true",width:100,align:'left'},
                 {field:'id',title:'用户编号',width:100},
                 {field:'name',title:'用户姓名',width:100},
                 {field:'telephone',title:'用户电话',width:100},
                 {field:'cz',title:'操作', width:80,
                     formatter: function(value,row,index){
                         return ' <a href="javascript:delete1('+row.id+')" class="easyui-linkbutton" iconCls="icon-ok">删除</a>';
                     }
                 }
             ]]
         });
     })
     function search(){
         //实现搜索查询
         //datagrid的load方法是重新加载，它会将查询条件，随着页码,页大小
         //一起发送到当前控制所指定的服务器地址进行处理
         //$("#dg").datagrid("load",传查询条件:{键:值,键:值});
         var s_name=$("#s_name").val();
         var s_tel=$("#s_tel").val();
         var s_startage=$("#s_minid").val();
         var s_endage=$("#s_maxid").val();

         $("#dg").datagrid("load",{"name":s_name,"telephone":s_tel,"minid":s_startage,"maxid":s_endage});

     }
    </script>
</head>
<body>
<table id="dg"></table>

<div id="toolbar">
    <div>
        <a href="javascript:add1()" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true"a>添加</a>
        <a href="javascript:up1()" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true"a>修改</a>
        <a href="javascript:delete2()" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true"a>批量删除</a>
    </div>
    <div>
        <div>名称:<input type="text" id="s_name" name="name" style="width: 100px">
            电话:<input type="text" id="s_tel" name="telephone" style="width: 100px">
            开始编号:<input type="text" id="s_minid" name="minid" style="width: 100px">
            结束编号:<input type="text" id="s_maxid" name="maxid" style="width: 100px">
            <a
                    href="javascript:search()" class="easyui-linkbutton"
                    iconCls="icon-search" plain="true">搜索</a>
        </div>
    </div>

</div>

</body>
</html>

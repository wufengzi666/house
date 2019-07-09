$(function () {
    //表格上的id为dg，让表格以easyui方式呈现
    $('#dg').datagrid({
        url:'getDistrict',
        title:"区域管理",
        toolbar:"#toolbar",
        pagination:"true",
        pageList:[3,5,10,15,20],
        pageSize:3,
        columns:[[
            {field:'cb',checkbox:true,width:100},
            {field:'id',title:'区域编号',width:100,align:'left'},
            {field:'name',title:'区域名称',width:100},
            {field: 'dis', title: '操作', width: 100,
                formatter: function (value, row, index) {
                    return '<a href="javascript:lookstreet('+row.id+')" class="easyui-linkbutton" iconCls="icon-ok">查看街道</a> <a href="javascript:delete1('+row.id+')" class="easyui-linkbutton" iconCls="icon-ok">删除</a>';
                }
            }

        ]]
    });
});

//添加链接上的add1方法，打开添加对话框
function add1(){
    $("#addDialog").dialog("open");
}

//在添加对话框中执行添加方法
function add2() {
    $("#addform").form('submit', {
        url:"getadd",
        success:function(da){
            da=$.parseJSON(da)
            if(da.result==1){
                $("#addDialog").dialog("close");
                $.messager.alert("提示框","添加成功","info")
            }else {
                $.messager.alert('提示框','添加失败','info');
            }
        }
    });
}

/*对话框点击关闭时执行关闭对话框方法*/
function add3() {
    $("#addDialog").dialog("close");
}

/*打开修改对话框方法*/
function up1() {
    //获取所选择的所有行的集合
    var rows=$("#dg").datagrid('getSelections');
    if(rows.length!=1){
        $.messager.alert("提示框","修改时只能选择一条记录噢^-^","info")
        return;
    }
    $("#upDialog").dialog("open")
    var row=rows[0];
    $.post("getupdate",{"id":row.id},function (da) {
        //回显
        $("#upDialog").form("load",da)
    },"json")
}

//实现修改业务
function up2() {
    $("#upform").form('submit', {
        url:"update",
        success:function(da){
            da=$.parseJSON(da)
            if(da.result==1){
                $("#upDialog").dialog("close");
                $('#dg').datagrid('reload');
                $.messager.alert("提示框","修改成功","info")
            }else {
                $.messager.alert('提示框','修改失败','info');
            }
        }
    });

}

//对话框下面关闭按钮的方法
function up3() {
    $("#upDialog").dialog("close");
}

//点击操作后面的删除的方法
function delete1(id) {
    $.messager.confirm('提示框', '想好了要删除吗', function(r){
        if (r){
            $.post("delete",{"id":id},function (da) {
                if (da.result==1) {
                    $("#dg").datagrid("reload")
                }
                else {
                    $.messager.alert("提示框","删除失败","info");
                }
            },"json");
        }else{
            $.messager.alert('提示框','想好再点，可以吗！^_^','info');
        }
    });
}

//实现批量删除的方法
function delete2(){
    //获取选中行
    var rows = $("#dg").datagrid('getSelections');
    if(rows.length==0){
        $.messager.alert('提示框','删除至少要选取一行啊^_^','info');
        return;
    }

    //确认删除
    $.messager.confirm('提示框', '确定删除吗',function(r){
        if(r){
            var value="";
            for(var i=0;i<rows.length;i++){
                value=value+rows[i].id+",";
            }
            value=value.substring(0,value.length-1);  //去除最后的逗号

            //发送异步请求到服务器
            $.post("deleteMore",{"id":value},function(da){
                if(da.result>0){
                    //实现datagrid的刷新
                    $('#dg').datagrid('reload');
                }else{
                    $.messager.alert('提示框','删除失败！^_^','info');
                }
            },"json");
        }
    });
}

//查看街道的方法
function lookstreet(da) {
    $("#lookdialog").dialog("open");
    $("#street").datagrid({
        url:"getstreetpage?id="+da,
        title:"街道列表",
        //toolbar:"#toolbar",
        pagination:"true",
        pageList:[3,5,10,15,20],
        pageSize:3,
        columns:[[
            {field:'ck',checkbox:true,width:100},
            {field:'id',title:'街道编号',width:100,align:'left'},
            {field:'name',title:'街道名称',width:100},
            {field: 'dis', title: '操作', width: 100,
                formatter: function (value, row, index) {
                    return '<a href="javascript:delete1('+row.id+')" class="easyui-linkbutton" iconCls="icon-ok">删除</a>';
                }
            }

        ]]
    })
}


function look2() {
    $("#lookdialog").dialog("close");
    $("#dg").datagrid("reload");
}

$(function () {
    //表格上的id为dg，让表格以easyui方式呈现
    $('#dg').datagrid({
        url:'gethouseinfo',
        title:"审核管理(待审核房屋)",
        pagination:"true",
        pageList:[3,5,10,15,20],
        pageSize:3,
        columns:[[
            {field:'cb',checkbox:true,width:100},
            {field:'id',title:'房屋编号',width:100,align:'left'},
            {field:'title',title:'房屋名称',width:100},
            {field: 'DESCRIPTION', title: '房屋说明', width: 100},
            {field: 'price', title: '房屋价格', width: 100},
            {field: 'FLOORAGE', title: '房屋面积', width: 100},
            {field: 'PUBDATE', title: '发布时间', width: 100},
            {field: 'dis', title: '操作', width: 100,
                formatter: function (value, row, index) {
                    return '<a href="javascript:passhouse('+row.id+')" class="easyui-linkbutton" iconCls="icon-ok">通过审核</a> ';
                }
            }

        ]]
    });
});

function passhouse(id) {
    $.post("pass",{"id":id},function (da) {
        if(da.result==1){
            $.messager.alert("提示框","已通过审核","info");
            $("#dg").datagrid("reload")
        }else {
            $.messager.alert("提示框","未通过审核","info");
        }
    },"json")
}
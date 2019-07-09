<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<!-- saved from url=(0044)http://localhost:8080/HouseRent/page/add.jsp -->
<HTML xmlns="http://www.w3.org/1999/xhtml"><HEAD><TITLE>青鸟租房 -发布房屋信息</TITLE>
<META content="text/html; charset=utf-8" http-equiv=Content-Type><LINK 
rel=stylesheet type=text/css href="../css/style.css">
<META name=GENERATOR content="MSHTML 8.00.7601.17514"></HEAD>
<script language="JavaScript" src="../admin/js/jquery-1.8.3.js"></script>
<script language="JavaScript">
  $(function () {
      var id=$("#district_id").val();
      $.post("getstreetbydid",{"did":id},function (da) {
          $("#street_id>option:gt(0)").remove();
          for(var i=0;i<da.length;i++){
              var node=$("<option value="+da[i].id+">"+da[i].name+"</option>")
              $("#street_id").append(node);
          }
          $("#street_id").val(${house.streetId})
      },"json");

      $("#district_id").change(function () {
          var id=$(this).val();
          $.post("getstreetbydid",{"did":id},function (da) {
              $("#street_id>option:gt(0)").remove();
              for(var i=0;i<da.length;i++){
                  var node=$("<option value="+da[i].id+">"+da[i].name+"</option>")
                  $("#street_id").append(node);
              }
          },"json");
      })
  })
  function ret() {
      history.go(-1);
  }
</script>

<BODY>
<DIV id=header class=wrap>
<DIV id=logo><IMG src="../images/logo.gif"></DIV></DIV>
<DIV id=regLogin class=wrap>
<DIV class=dialog>
<DL class=clearfix>
  <DT>新房屋信息发布</DT>
  <DD class=past>填写房屋信息</DD></DL>
<DIV class=box>
<FORM  action="updatehouse" method="post" enctype="multipart/form-data" >
<DIV class=infos>
<TABLE class=field>
  <TBODY>
  <TR>
    <TD class=field>标　　题：
    <input type="hidden" value="${house.id}" name="id">
    </TD>
    <TD><INPUT id=add_action_title class=text type=text name=title value="${house.title}"> </TD></TR>
  <TR>
    <TD class=field>户　　型：</TD>
    <TD><SELECT class=text name=typeId>
      <option value="">请选择</option>
      <c:forEach items="${typeList}" var="t">
      <OPTION value="${t.id}" <c:if test="${t.id==house.typeId}">selected="selected"</c:if> >${t.name}</OPTION>
      </c:forEach>
    </SELECT>
    </TD></TR>
  <TR>
    <TD class=field>面　　积：</TD>
    <TD><INPUT id=add_action_floorage class=text type=text 
name=floorage value="${house.floorage}"></TD></TR>
  <TR>
    <TD class=field>价　　格：</TD>
    <TD><INPUT id=add_action_price class=text type=text name=price value="${house.price}"> </TD></TR>
  <TR>
    <TD class=field>发布日期：</TD>

    <TD>
      <INPUT class=text type=date value="<fmt:formatDate value="${house.pubdate}" pattern="yyyy-MM-dd"></fmt:formatDate>" name=houseDate>
    </TD></TR>

  <TR>
    <TD class=field>位　　置：</TD>
    <TD>区：<SELECT class=text name=district_id id="district_id">
      <option value="">请选择</option>

      <c:forEach var="d" items="${districtList}">

        <OPTION value="${d.id}" <c:if test="${d.id==house.did}">selected="selected"</c:if> >${d.name}</OPTION>
      </c:forEach>
    </SELECT>
      街：<SELECT class=text name=streetId id="street_id">
        <OPTION  value="">请选择</OPTION>
      </SELECT> </TD></TR>

  <TR>
    <TD class=field>联系方式：</TD>
    <TD><INPUT id=add_action_contact class=text type=text name=contact value="${house.contact}"> </TD></TR>
  <TR>
    <TD class=field>图片：<img width="80" height="100" src="http://localhost:80/${house.path}"></TD>
    <TD><input type="file" name=pfile>
    <input type="hidden" value="${house.path}" name="oldpath"></TD></TR>
  <TR>
      <TD class=field>详细信息：</TD>
      <TD><textarea name=description>${house.description}</textarea></TD></TR
  </TBODY></TABLE>
<DIV class=buttons><INPUT  value=立即修改 type="submit">
 <input type="button" value="返回" onclick="ret()">
</DIV></DIV></FORM></DIV></DIV></DIV>
<DIV id=footer class=wrap>
<DL>
  <DT>青鸟租房 © 2018 北大青鸟 京ICP证1000001号</DT>
  <DD>关于我们 · 联系方式 · 意见反馈 · 帮助中心</DD></DL></DIV></BODY></HTML>

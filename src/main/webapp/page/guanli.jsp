﻿<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
 Object obj=session.getAttribute("logininfo");
 if(obj==null){
   out.print("<script>alert('你还没有登陆，请登陆');location.href='login.jsp'</script>");
 }
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<!-- saved from url=(0050)http://localhost:8080/HouseRent/manage!list.action -->
<HTML xmlns="http://www.w3.org/1999/xhtml"><HEAD>
<TITLE>青鸟租房 - 用户管理</TITLE>
<META content="text/html; charset=utf-8" http-equiv=Content-Type><LINK 
rel=stylesheet type=text/css href="../css/style.css">

<META name=GENERATOR ></HEAD>
<BODY>
<DIV id=header class=wrap>
<DIV id=logo><IMG src="../images/logo.gif"></DIV>
<DIV class=search>
  欢迎:${sessionScope.logininfo.name}
  <LABEL class="ui-green searchs">
  <a href="${pageContext.request.contextPath}gofabu" title="">发布房屋信息</a></LABEL>
    <LABEL class="ui-green searchs">
        <a href="${pageContext.request.contextPath}goguanli" title="">管理房屋信息</a></LABEL>
<LABEL class=ui-green><INPUT onclick='document.location="login.jsp"' value="退       出" type=button name=search></LABEL>
</DIV></DIV>
<DIV class="main wrap">
<DIV id=houseArea>
<TABLE class=house-list>
  <TBODY>
  <c:forEach items="${houseinfo.list}" var="h">
  <TR>
    <TD class=house-thumb><SPAN><A href="details.htm" target="_blank"><img src="http://localhost:80/${h.path}" width="100" height="75" alt=""></A></SPAN></TD>
    <TD>
      <DL>
        <DT><A href="details.htm" target="_blank">${h.title}</A></DT>
        <DD>${h.dname}${h.sname},${h.floorage}平方米<BR>联系方式：${h.contact} </DD></DL></TD>
    <TD class=house-type><LABEL class=ui-green><INPUT onclick="location.href='goupdate?id=${h.id}'" value="修改" type=button name=search></LABEL></TD>
    <TD class=house-price><LABEL class=ui-green><INPUT value="删    除" type=button name=search onclick="location.href='deletehouse?id=${h.id}'"></LABEL></TD></TR>
  </c:forEach>
  </TBODY></TABLE></DIV>
<DIV class=pager>
<UL>
    <c:forEach begin="1" end="${houseinfo.pages}"  step="1" var="p">
  <LI class=current><A id=widget_338868862 
  href="goguanli?page=${p}"
  parseContent="true" showError="true" targets="houseArea" 
  ajaxAfterValidation="false" validate="false" 
dojoType="struts:BindAnchor">${p}</A>
   </LI>
    </c:forEach>
</UL>
   <SPAN class=total>${houseinfo.pageNum}/${houseinfo.pages}</SPAN> </DIV></DIV>
<DIV id=footer class=wrap>
<DL>
  <DT>青鸟租房 © 2018 北大青鸟 京ICP证1000001号</DT>
  <DD>关于我们 · 联系方式 · 意见反馈 · 帮助中心</DD></DL></DIV></BODY></HTML>

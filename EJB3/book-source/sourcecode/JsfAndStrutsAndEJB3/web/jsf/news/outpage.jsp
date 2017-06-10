<%@ page contentType="text/html;charset=GBK" %>
<%@ include file="/news/top.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
 <HEAD>
  <TITLE> 操作结果 </TITLE>
	<STYLE type=text/css>
		TD { FONT-SIZE: 14px }
		a {margin-right:35px;}
		A:link { COLOR: #0000ff }
		A:visited { COLOR: #000080 }
		A:active { COLOR: #FF9900 }
		A:hover { COLOR: #FF6600 }
		UL{margin:0 auto;padding:0 auto;}
		li{margin:0px;padding:0 auto;LIST-STYLE-TYPE: none;}
	</STYLE>
 </HEAD>

 <BODY>	<center>
 <f:view>
	<h1>操作结果:<FONT COLOR=red><h:messages/></FONT><h1><br/>
	<a href='<%= request.getContextPath() + "/news/catalog/list.jsf" %>'>返回目录列表</a>
	<a href='<%= request.getContextPath() + "/news/list.jsf" %>'>返回内容列表</a>
 </f:view>
	</center> 
 </BODY>
</HTML>
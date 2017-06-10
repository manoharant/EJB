<%@ page contentType="text/html;charset=GBK" %>
<%@ include file="/WEB-INF/page/top.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
 <HEAD>
  <TITLE> 操作结果 </TITLE>
	<STYLE type=text/css>
		TD { FONT-SIZE: 14px }
		A:link { COLOR: #0000ff }
		A:visited { COLOR: #000080 }
		A:active { COLOR: #FF9900 }
		A:hover { COLOR: #FF6600 }
	</STYLE>
 </HEAD>

 <BODY>
	<center><h1>
	操作结果:<FONT COLOR="red"><c:out value='${outmessage}'/></FONT>
	</h1><br>
	<a href="<html:rewrite action='/news/list'/>">返回内容列表</a>&nbsp;&nbsp;
	<a href="<html:rewrite action='/news/catalog/list'/>">返回目录列表</a>
	</center> 
 </BODY>
</HTML>
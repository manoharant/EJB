<%@ page contentType="text/html;charset=GBK" %>
<%@ include file="/WEB-INF/page/top.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
 <HEAD>
  <TITLE> ������� </TITLE>
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
	�������:<FONT COLOR="red"><c:out value='${outmessage}'/></FONT>
	</h1><br>
	<a href="<html:rewrite action='/news/list'/>">���������б�</a>&nbsp;&nbsp;
	<a href="<html:rewrite action='/news/catalog/list'/>">����Ŀ¼�б�</a>
	</center> 
 </BODY>
</HTML>
<%@ page contentType="text/html;charset=GBK" %>
<%@ include file="/WEB-INF/page/top.jsp" %>
<html>
<head>
<title>��EJB3.0���ž�����Ŀ¼����</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<STYLE type=text/css>
.headercss {background-color:#6f8ac4; COLOR: #FFFFFF}
.rowcss td{background-color:#f5f5f5}
.tablecss {text-align:center;width:80%;border:0px;align:expression(this.align="center");}
.lab {text-align:center;width:100%;FONT-SIZE: 12px}
.lab a{margin-right:15px;}
TD { FONT-SIZE: 14px }
A:link { COLOR: #0000ff }
A:visited { COLOR: #000080 }
A:active { COLOR: #FF9900 }
A:hover { COLOR: #FF6600 }
</STYLE>
</head>

<body bgcolor="#FFFFFF" text="#000000" marginwidth="0" marginheight="0">
<h1 align="center">  Ŀ¼�б�</h1>
<table class="tablecss">
<thead>
  <tr> 
    <td class="headercss">Ŀ¼ID</td>
	<td class="headercss">Ŀ¼����</td>
	<td width="8%" class="headercss">�޸�</td>
    <td width="8%" class="headercss">ɾ��</td>
  </tr>
</thead>
<tbody>
<c:if test="${!empty result.resultset}">
<c:forEach var="entry" items="${result.resultset}">
    <tr class="rowcss"> 
      <td><c:out value='${entry.catid}'/></td>
	  <td><c:out value='${entry.name}'/></td>
      <td><a href="<html:rewrite action='/news/catalog/dispose'/>?method=editUI&id=<c:out value='${entry.catid}'/>">�޸� </a></td>
	  <td><a href="<html:rewrite action='/news/catalog/dispose'/>?method=delete&id=<c:out value='${entry.catid}'/>">ɾ��</a></td>
    </tr>
</c:forEach></c:if>
</tbody>
</table><br/>
<label class="lab">
ÿҳ��ʾ��<c:out value='${dataScroller.maxResult}'/>����¼����<c:out value='${dataScroller.totalpage}'/>ҳ����ǰ�ڵ�<c:out value='${dataScroller.currentpage}'/>ҳ&nbsp;&nbsp;
<a href="<html:rewrite action='/news/catalog/dispose'/>?method=addUI">���Ŀ¼</a>&nbsp;&nbsp;<a href="<html:rewrite action='/news/list'/>">�����б�</a>&nbsp;&nbsp;
<c:if test="${dataScroller.totalpage>1 && dataScroller.currentpage!=1}">
<a href="<html:rewrite action='/news/catalog/list'/>?firstResult=0&maxResult=<c:out value='${dataScroller.maxResult}'/>">��ҳ</a>
</c:if>
<c:if test="${dataScroller.currentpage>1}">
<a href="<html:rewrite action='/news/catalog/list'/>?firstResult=<c:out value='${(dataScroller.currentpage-2)* dataScroller.maxResult}'/>&maxResult=<c:out value='${dataScroller.maxResult}'/>">��һҳ</a>
</c:if>
<c:if test="${dataScroller.currentpage<dataScroller.totalpage}">
<a href="<html:rewrite action='/news/catalog/list'/>?firstResult=<c:out value='${dataScroller.currentpage * dataScroller.maxResult}'/>&maxResult=<c:out value='${dataScroller.maxResult}'/>">��һҳ</a>
</c:if>
<c:if test="${dataScroller.totalpage>0 && dataScroller.currentpage<dataScroller.totalpage}">
<a href="<html:rewrite action='/news/catalog/list'/>?firstResult=<c:out value='${(dataScroller.totalpage-1)* dataScroller.maxResult}'/>&maxResult=<c:out value='${dataScroller.maxResult}'/>">βҳ</a>
</c:if>
</label>
</body>
</html>

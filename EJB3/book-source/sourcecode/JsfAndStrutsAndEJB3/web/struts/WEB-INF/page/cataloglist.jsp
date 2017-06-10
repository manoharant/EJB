<%@ page contentType="text/html;charset=GBK" %>
<%@ include file="/WEB-INF/page/top.jsp" %>
<html>
<head>
<title>《EJB3.0入门精讲》目录管理</title>
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
<h1 align="center">  目录列表</h1>
<table class="tablecss">
<thead>
  <tr> 
    <td class="headercss">目录ID</td>
	<td class="headercss">目录名称</td>
	<td width="8%" class="headercss">修改</td>
    <td width="8%" class="headercss">删除</td>
  </tr>
</thead>
<tbody>
<c:if test="${!empty result.resultset}">
<c:forEach var="entry" items="${result.resultset}">
    <tr class="rowcss"> 
      <td><c:out value='${entry.catid}'/></td>
	  <td><c:out value='${entry.name}'/></td>
      <td><a href="<html:rewrite action='/news/catalog/dispose'/>?method=editUI&id=<c:out value='${entry.catid}'/>">修改 </a></td>
	  <td><a href="<html:rewrite action='/news/catalog/dispose'/>?method=delete&id=<c:out value='${entry.catid}'/>">删除</a></td>
    </tr>
</c:forEach></c:if>
</tbody>
</table><br/>
<label class="lab">
每页显示：<c:out value='${dataScroller.maxResult}'/>条记录，共<c:out value='${dataScroller.totalpage}'/>页，当前在第<c:out value='${dataScroller.currentpage}'/>页&nbsp;&nbsp;
<a href="<html:rewrite action='/news/catalog/dispose'/>?method=addUI">添加目录</a>&nbsp;&nbsp;<a href="<html:rewrite action='/news/list'/>">内容列表</a>&nbsp;&nbsp;
<c:if test="${dataScroller.totalpage>1 && dataScroller.currentpage!=1}">
<a href="<html:rewrite action='/news/catalog/list'/>?firstResult=0&maxResult=<c:out value='${dataScroller.maxResult}'/>">首页</a>
</c:if>
<c:if test="${dataScroller.currentpage>1}">
<a href="<html:rewrite action='/news/catalog/list'/>?firstResult=<c:out value='${(dataScroller.currentpage-2)* dataScroller.maxResult}'/>&maxResult=<c:out value='${dataScroller.maxResult}'/>">上一页</a>
</c:if>
<c:if test="${dataScroller.currentpage<dataScroller.totalpage}">
<a href="<html:rewrite action='/news/catalog/list'/>?firstResult=<c:out value='${dataScroller.currentpage * dataScroller.maxResult}'/>&maxResult=<c:out value='${dataScroller.maxResult}'/>">下一页</a>
</c:if>
<c:if test="${dataScroller.totalpage>0 && dataScroller.currentpage<dataScroller.totalpage}">
<a href="<html:rewrite action='/news/catalog/list'/>?firstResult=<c:out value='${(dataScroller.totalpage-1)* dataScroller.maxResult}'/>&maxResult=<c:out value='${dataScroller.maxResult}'/>">尾页</a>
</c:if>
</label>
</body>
</html>

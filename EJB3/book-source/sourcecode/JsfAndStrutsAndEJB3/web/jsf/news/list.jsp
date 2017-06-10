<%@ page contentType="text/html;charset=GBK" %>
<%@ include file="/news/top.jsp" %>
<html>
<head>
<title>《EJB3.0入门精讲》内容管理</title>
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
<h1 align="center">  内容列表</h1>
 <f:view> 
   <h:form>
     <h:dataTable var="entry" value="#{newsList.newslist}" rendered="true" headerClass="headercss"
		        rowClasses="rowcss" styleClass="tablecss">
        <h:column>
           <f:facet name="header">
              <h:outputText value="新闻标题"/>
           </f:facet>
           <h:outputLink value="view.jsf">
	    	 <h:outputText value="#{entry.title}"/>
	    	 <f:param name="id" value="#{entry.newsid}"/>
		   </h:outputLink>
        </h:column>
       <h:column>
           <f:facet name="header">
              <h:outputText value="所在目录"/>
           </f:facet>
           <h:outputText value="#{entry.catalog.name}"/>
       </h:column>
       <h:column>
           <f:facet name="header">
              <h:outputText value="创建日期"/>
           </f:facet>
           <h:outputText id="dateField" value="#{entry.createdate}">
              <f:convertDateTime pattern="yyyy-MM-dd"/>
           </h:outputText>
       </h:column>
       <h:column>
           <f:facet name="header">
              <h:outputText value="修改"/>
           </f:facet>
           <h:commandLink action="#{newsAction.editUI}" >
			   <h:outputText value="修改"/>
			   <f:param name="id" value="#{entry.newsid}"/>
		   </h:commandLink>
       </h:column>
       <h:column>
           <f:facet name="header">
              <h:outputText value="删除"/>
           </f:facet>
           <h:commandLink action="#{newsAction.delete}" >
			   <h:outputText value="删除"/>
			   <f:param name="id" value="#{entry.newsid}"/>
		   </h:commandLink>
       </h:column>
     </h:dataTable>
   
   <h:outputLabel styleClass="lab">
		<h:outputFormat value="每页显示：{0}条记录，共{1}页，当前在第{2}页&nbsp;&nbsp;" escape="false">
		     <f:param value="#{newsList.maxResult}"/>
		     <f:param value="#{newsList.totalpage}"/>
		     <f:param value="#{newsList.currentpage}"/>
		</h:outputFormat>
		<h:outputLink value="AddNews.jsf">
		    <h:outputText value="添加新闻"/>
		</h:outputLink>
		<h:outputLink value="catalog/list.jsf">
		    <h:outputText value="目录列表"/>
		</h:outputLink>
	    <h:outputLink value="list.jsf" rendered="#{newsList.totalpage>1 && newsList.currentpage!=1}">
	    	<h:outputText value="首页"/>
	    	<f:param name="firstResult" value="0"/>
	    	<f:param name="maxResult" value="#{newsList.maxResult}"/>
		</h:outputLink>  
	   	<h:outputLink value="list.jsf" rendered="#{newsList.currentpage>1}">
	    	<h:outputText value="上一页"/>
	    	<f:param name="firstResult" value="#{(newsList.currentpage-2)* newsList.maxResult}"/>
	    	<f:param name="maxResult" value="#{newsList.maxResult}"/>
		</h:outputLink>  
	   	<h:outputLink value="list.jsf" rendered="#{newsList.currentpage<newsList.totalpage}">
	    	<h:outputText value="下一页"/>
	    	<f:param name="firstResult" value="#{newsList.currentpage * newsList.maxResult}"/>
	    	<f:param name="maxResult" value="#{newsList.maxResult}"/>
		</h:outputLink>  
	    <h:outputLink value="list.jsf" rendered="#{newsList.totalpage>0 && newsList.currentpage<newsList.totalpage}">
	    	<h:outputText value="尾页"/>
	    	<f:param name="firstResult" value="#{(newsList.totalpage-1)* newsList.maxResult}"/>
	    	<f:param name="maxResult" value="#{newsList.maxResult}"/>
		</h:outputLink>
	</h:outputLabel>
  </h:form>
  </f:view>
  <br/><br/>
注意：如果例子运行在Weblogic10.3技术预览版，调用query.setMaxResults(maxResult).setFirstResult(firstResult)分页存在问题，这应该是它的BUG
</body>
</html>

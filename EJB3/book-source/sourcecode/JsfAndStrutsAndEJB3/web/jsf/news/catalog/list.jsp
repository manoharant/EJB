<%@ page contentType="text/html;charset=GBK" %>
<%@ include file="/news/top.jsp" %>
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
 <f:view> 
   <h:form>
     <h:dataTable var="entry" value="#{catalogList.catalogs}" rendered="true" headerClass="headercss"
		        rowClasses="rowcss" styleClass="tablecss">
        <h:column>
           <f:facet name="header">
              <h:outputText value="目录ID"/>
           </f:facet>           
		    <h:outputText value="#{entry.catid}"/>
        </h:column>
       <h:column>
           <f:facet name="header">
              <h:outputText value="目录名称"/>
           </f:facet>
          <h:outputLink value="view.jsf">
	    	 <h:outputText value="#{entry.name}"/>
	    	 <f:param name="id" value="#{entry.catid}"/>
		   </h:outputLink>
       </h:column>
       <h:column>
           <f:facet name="header">
              <h:outputText value="修改"/>
           </f:facet>
           <h:commandLink action="#{catalogAction.editUI}" >
			   <h:outputText value="修改"/>
			   <f:param name="id" value="#{entry.catid}"/>
		   </h:commandLink>
       </h:column>
       <h:column>
           <f:facet name="header">
              <h:outputText value="删除"/>
           </f:facet>
           <h:commandLink action="#{catalogAction.delete}" >
			   <h:outputText value="删除"/>
			   <f:param name="id" value="#{entry.catid}"/>
		   </h:commandLink>
       </h:column>
     </h:dataTable>
   
   <h:outputLabel styleClass="lab">
		<h:outputFormat value="每页显示：{0}条记录，共{1}页，当前在第{2}页&nbsp;&nbsp;" escape="false">
		     <f:param value="#{catalogList.maxResult}"/>
		     <f:param value="#{catalogList.totalpage}"/>
		     <f:param value="#{catalogList.currentpage}"/>
		</h:outputFormat>
		<h:outputLink value="Addcatalog.jsf">
		    <h:outputText value="添加目录"/>
		</h:outputLink>
		<h:outputLink value="../list.jsf">
		    <h:outputText value="内容列表"/>
		</h:outputLink>
	    <h:outputLink value="list.jsf" rendered="#{catalogList.totalpage>1 && catalogList.currentpage!=1}">
	    	<h:outputText value="首页"/>
	    	<f:param name="firstResult" value="0"/>
	    	<f:param name="maxResult" value="#{catalogList.maxResult}"/>
		</h:outputLink>  
	   	<h:outputLink value="list.jsf" rendered="#{catalogList.currentpage>1}">
	    	<h:outputText value="上一页"/>
	    	<f:param name="firstResult" value="#{(catalogList.currentpage-2)* catalogList.maxResult}"/>
	    	<f:param name="maxResult" value="#{catalogList.maxResult}"/>
		</h:outputLink>  
	   	<h:outputLink value="list.jsf" rendered="#{catalogList.currentpage<catalogList.totalpage}">
	    	<h:outputText value="下一页"/>
	    	<f:param name="firstResult" value="#{catalogList.currentpage * catalogList.maxResult}"/>
	    	<f:param name="maxResult" value="#{catalogList.maxResult}"/>
		</h:outputLink>  
	    <h:outputLink value="list.jsf" rendered="#{catalogList.totalpage>0 && catalogList.currentpage<catalogList.totalpage}">
	    	<h:outputText value="尾页"/>
	    	<f:param name="firstResult" value="#{(catalogList.totalpage-1)* catalogList.maxResult}"/>
	    	<f:param name="maxResult" value="#{catalogList.maxResult}"/>
		</h:outputLink>
	</h:outputLabel>
  </h:form>
  </f:view>
</body>
</html>

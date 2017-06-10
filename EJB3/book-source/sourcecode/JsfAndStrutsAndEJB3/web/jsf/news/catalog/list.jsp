<%@ page contentType="text/html;charset=GBK" %>
<%@ include file="/news/top.jsp" %>
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
 <f:view> 
   <h:form>
     <h:dataTable var="entry" value="#{catalogList.catalogs}" rendered="true" headerClass="headercss"
		        rowClasses="rowcss" styleClass="tablecss">
        <h:column>
           <f:facet name="header">
              <h:outputText value="Ŀ¼ID"/>
           </f:facet>           
		    <h:outputText value="#{entry.catid}"/>
        </h:column>
       <h:column>
           <f:facet name="header">
              <h:outputText value="Ŀ¼����"/>
           </f:facet>
          <h:outputLink value="view.jsf">
	    	 <h:outputText value="#{entry.name}"/>
	    	 <f:param name="id" value="#{entry.catid}"/>
		   </h:outputLink>
       </h:column>
       <h:column>
           <f:facet name="header">
              <h:outputText value="�޸�"/>
           </f:facet>
           <h:commandLink action="#{catalogAction.editUI}" >
			   <h:outputText value="�޸�"/>
			   <f:param name="id" value="#{entry.catid}"/>
		   </h:commandLink>
       </h:column>
       <h:column>
           <f:facet name="header">
              <h:outputText value="ɾ��"/>
           </f:facet>
           <h:commandLink action="#{catalogAction.delete}" >
			   <h:outputText value="ɾ��"/>
			   <f:param name="id" value="#{entry.catid}"/>
		   </h:commandLink>
       </h:column>
     </h:dataTable>
   
   <h:outputLabel styleClass="lab">
		<h:outputFormat value="ÿҳ��ʾ��{0}����¼����{1}ҳ����ǰ�ڵ�{2}ҳ&nbsp;&nbsp;" escape="false">
		     <f:param value="#{catalogList.maxResult}"/>
		     <f:param value="#{catalogList.totalpage}"/>
		     <f:param value="#{catalogList.currentpage}"/>
		</h:outputFormat>
		<h:outputLink value="Addcatalog.jsf">
		    <h:outputText value="���Ŀ¼"/>
		</h:outputLink>
		<h:outputLink value="../list.jsf">
		    <h:outputText value="�����б�"/>
		</h:outputLink>
	    <h:outputLink value="list.jsf" rendered="#{catalogList.totalpage>1 && catalogList.currentpage!=1}">
	    	<h:outputText value="��ҳ"/>
	    	<f:param name="firstResult" value="0"/>
	    	<f:param name="maxResult" value="#{catalogList.maxResult}"/>
		</h:outputLink>  
	   	<h:outputLink value="list.jsf" rendered="#{catalogList.currentpage>1}">
	    	<h:outputText value="��һҳ"/>
	    	<f:param name="firstResult" value="#{(catalogList.currentpage-2)* catalogList.maxResult}"/>
	    	<f:param name="maxResult" value="#{catalogList.maxResult}"/>
		</h:outputLink>  
	   	<h:outputLink value="list.jsf" rendered="#{catalogList.currentpage<catalogList.totalpage}">
	    	<h:outputText value="��һҳ"/>
	    	<f:param name="firstResult" value="#{catalogList.currentpage * catalogList.maxResult}"/>
	    	<f:param name="maxResult" value="#{catalogList.maxResult}"/>
		</h:outputLink>  
	    <h:outputLink value="list.jsf" rendered="#{catalogList.totalpage>0 && catalogList.currentpage<catalogList.totalpage}">
	    	<h:outputText value="βҳ"/>
	    	<f:param name="firstResult" value="#{(catalogList.totalpage-1)* catalogList.maxResult}"/>
	    	<f:param name="maxResult" value="#{catalogList.maxResult}"/>
		</h:outputLink>
	</h:outputLabel>
  </h:form>
  </f:view>
</body>
</html>

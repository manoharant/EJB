<%@ page contentType="text/html;charset=GBK" %>
<%@ include file="/news/top.jsp" %>
<html>
<head>
<title>��EJB3.0���ž��������ݹ���</title>
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
<h1 align="center">  �����б�</h1>
 <f:view> 
   <h:form>
     <h:dataTable var="entry" value="#{newsList.newslist}" rendered="true" headerClass="headercss"
		        rowClasses="rowcss" styleClass="tablecss">
        <h:column>
           <f:facet name="header">
              <h:outputText value="���ű���"/>
           </f:facet>
           <h:outputLink value="view.jsf">
	    	 <h:outputText value="#{entry.title}"/>
	    	 <f:param name="id" value="#{entry.newsid}"/>
		   </h:outputLink>
        </h:column>
       <h:column>
           <f:facet name="header">
              <h:outputText value="����Ŀ¼"/>
           </f:facet>
           <h:outputText value="#{entry.catalog.name}"/>
       </h:column>
       <h:column>
           <f:facet name="header">
              <h:outputText value="��������"/>
           </f:facet>
           <h:outputText id="dateField" value="#{entry.createdate}">
              <f:convertDateTime pattern="yyyy-MM-dd"/>
           </h:outputText>
       </h:column>
       <h:column>
           <f:facet name="header">
              <h:outputText value="�޸�"/>
           </f:facet>
           <h:commandLink action="#{newsAction.editUI}" >
			   <h:outputText value="�޸�"/>
			   <f:param name="id" value="#{entry.newsid}"/>
		   </h:commandLink>
       </h:column>
       <h:column>
           <f:facet name="header">
              <h:outputText value="ɾ��"/>
           </f:facet>
           <h:commandLink action="#{newsAction.delete}" >
			   <h:outputText value="ɾ��"/>
			   <f:param name="id" value="#{entry.newsid}"/>
		   </h:commandLink>
       </h:column>
     </h:dataTable>
   
   <h:outputLabel styleClass="lab">
		<h:outputFormat value="ÿҳ��ʾ��{0}����¼����{1}ҳ����ǰ�ڵ�{2}ҳ&nbsp;&nbsp;" escape="false">
		     <f:param value="#{newsList.maxResult}"/>
		     <f:param value="#{newsList.totalpage}"/>
		     <f:param value="#{newsList.currentpage}"/>
		</h:outputFormat>
		<h:outputLink value="AddNews.jsf">
		    <h:outputText value="�������"/>
		</h:outputLink>
		<h:outputLink value="catalog/list.jsf">
		    <h:outputText value="Ŀ¼�б�"/>
		</h:outputLink>
	    <h:outputLink value="list.jsf" rendered="#{newsList.totalpage>1 && newsList.currentpage!=1}">
	    	<h:outputText value="��ҳ"/>
	    	<f:param name="firstResult" value="0"/>
	    	<f:param name="maxResult" value="#{newsList.maxResult}"/>
		</h:outputLink>  
	   	<h:outputLink value="list.jsf" rendered="#{newsList.currentpage>1}">
	    	<h:outputText value="��һҳ"/>
	    	<f:param name="firstResult" value="#{(newsList.currentpage-2)* newsList.maxResult}"/>
	    	<f:param name="maxResult" value="#{newsList.maxResult}"/>
		</h:outputLink>  
	   	<h:outputLink value="list.jsf" rendered="#{newsList.currentpage<newsList.totalpage}">
	    	<h:outputText value="��һҳ"/>
	    	<f:param name="firstResult" value="#{newsList.currentpage * newsList.maxResult}"/>
	    	<f:param name="maxResult" value="#{newsList.maxResult}"/>
		</h:outputLink>  
	    <h:outputLink value="list.jsf" rendered="#{newsList.totalpage>0 && newsList.currentpage<newsList.totalpage}">
	    	<h:outputText value="βҳ"/>
	    	<f:param name="firstResult" value="#{(newsList.totalpage-1)* newsList.maxResult}"/>
	    	<f:param name="maxResult" value="#{newsList.maxResult}"/>
		</h:outputLink>
	</h:outputLabel>
  </h:form>
  </f:view>
  <br/><br/>
ע�⣺�������������Weblogic10.3����Ԥ���棬����query.setMaxResults(maxResult).setFirstResult(firstResult)��ҳ�������⣬��Ӧ��������BUG
</body>
</html>

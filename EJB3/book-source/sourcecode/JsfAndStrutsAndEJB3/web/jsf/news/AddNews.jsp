<%@page contentType="text/html;charset=GBK"%>
<%@ include file="/news/top.jsp" %>
<html>
<head>
<title>�������</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
</head>
<body bgcolor="#FFFFFF" text="#000000" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
<f:view>
  <h:form>
	  <table width="80%" border="0" cellspacing="1" cellpadding="3" align="center">
	    <tr bgcolor="6f8ac4"> 
	      <td colspan="2" ><font color="#FFFFFF">������ţ�</font></td>
	    </tr>
	    <tr bgcolor="f5f5f5"> 
	      <td width="18%"> <div align="right">���� <font color="#FF0000">*</font> 
	          ��</div></td>
	      <td width="82%"> <h:inputText value="#{newsAction.news.title}" size="80" maxlength="90"/>
	      </td>
	    </tr>
	    <tr bgcolor="f5f5f5"> 
	      <td width="18%"> <div align="right">����Ŀ¼ <font color="#FF0000">*</font> 
	          ��</div></td>
	      <td width="82%">
		 	<h:selectOneMenu value="#{newsAction.news.catalog.catid}" rendered="#{newsAction.selectItemsSize>0}">
			    <f:selectItems value="#{newsAction.selectItems}"/>
			</h:selectOneMenu>
			<h:inputText value="#{newsAction.news.catalog.name}" size="30" maxlength="50" rendered="#{newsAction.selectItemsSize==0}"/>
	      </td>
	    </tr>
		
		<tr bgcolor="f5f5f5"> 
	      <td width="18%"> <div align="right">��Ϣ��Դ   
	          ��</div></td>
	      <td width="82%"> <h:inputText value="#{newsAction.news.source}" size="50" maxlength="50"/>
	      </td>
	    </tr>
	    <tr bgcolor="f5f5f5"> 
	      <td width="18%" valign="top"> <div align="right">��Ѷ���� <font color="#FF0000">*</font> 
	          ��</div></td>
	      <td width="82%"><h:inputTextarea cols="60" rows="13" value="#{newsAction.news.content}"/></td>
		</tr>
	    <tr bgcolor="f5f5f5"> 
	      <td colspan="2" align="center"><h:commandButton value=" ȷ �� " action="#{newsAction.add}"/></td>
	    </tr>
	  </table>
      </h:form>
    </f:view>
</body>
</html>


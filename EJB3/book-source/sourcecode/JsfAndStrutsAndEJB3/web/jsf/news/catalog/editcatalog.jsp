<%@ page contentType="text/html;charset=GBK" %>
<%@ include file="/news/top.jsp" %>
<html>
<head>
<title>�޸�Ŀ¼</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
</head>
<body bgcolor="#FFFFFF" text="#000000" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
<f:view>
  <h:form>
  	<h:inputHidden value="#{catalogAction.catalog.catid}"/>   
	  <table width="92%" border="0" cellspacing="1" cellpadding="3" align="center">
	    <tr bgcolor="6f8ac4"> 
	      <td colspan="2" ><font color="#FFFFFF">�޸�Ŀ¼��</font></td>
	    </tr>
	    <tr bgcolor="f5f5f5"> 
	      <td width="18%"> <div align="right">Ŀ¼���� <font color="#FF0000">*</font> 
	          ��</div></td>
	      <td width="82%"><h:inputText value="#{catalogAction.catalog.name}" size="50" maxlength="50"/>
	      </td>
	    </tr>
	    <tr bgcolor="f5f5f5"> 
	      <td colspan="2"> <div align="center"> 
	          <h:commandButton value=" ȷ �� " action="#{catalogAction.edit}"/>
	        </div></td>
	    </tr>
	  </table>
      </h:form>
    </f:view>
</body>
</html>
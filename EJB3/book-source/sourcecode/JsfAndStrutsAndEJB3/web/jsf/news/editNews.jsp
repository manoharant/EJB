<%@page contentType="text/html;charset=GBK"%>
<%@ include file="/news/top.jsp" %>
<html>
<head>
<title>修改新闻</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
</head>
<body bgcolor="#FFFFFF" text="#000000" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
<f:view>
  <h:form>
  	  <h:inputHidden value="#{newsAction.news.newsid}"/>   
	  <table width="80%" border="0" cellspacing="1" cellpadding="3" align="center">
	    <tr bgcolor="6f8ac4"> 
	      <td colspan="2" ><font color="#FFFFFF">修改新闻：</font></td>
	    </tr>
	    <tr bgcolor="f5f5f5"> 
	      <td width="18%"> <div align="right">标题 <font color="#FF0000">*</font> 
	          ：</div></td>
	      <td width="82%"> <h:inputText value="#{newsAction.news.title}" size="80" maxlength="90"/>
	      </td>
	    </tr>
	    <tr bgcolor="f5f5f5"> 
	      <td width="18%"> <div align="right">所属目录 <font color="#FF0000">*</font> 
	          ：</div></td>
	      <td width="82%">
		 	<h:selectOneMenu value="#{newsAction.news.catalog.catid}">
			    <f:selectItems value="#{newsAction.selectItems}"/>
			</h:selectOneMenu>
	      </td>
	    </tr>
		
		<tr bgcolor="f5f5f5"> 
	      <td width="18%"> <div align="right">信息来源   
	          ：</div></td>
	      <td width="82%"> <h:inputText value="#{newsAction.news.source}" size="50" maxlength="50"/>
	      </td>
	    </tr>
	    <tr bgcolor="f5f5f5"> 
	      <td width="18%" valign="top"> <div align="right">资讯内容 <font color="#FF0000">*</font> 
	          ：</div></td>
	      <td width="82%"><h:inputTextarea cols="60" rows="13" value="#{newsAction.news.content}"/></td>
		</tr>
	    <tr bgcolor="f5f5f5"> 
	      <td colspan="2" align="center"><h:commandButton value=" 确 认 " action="#{newsAction.edit}"/></td>
	    </tr>
	  </table>
      </h:form>
    </f:view>
</body>
</html>


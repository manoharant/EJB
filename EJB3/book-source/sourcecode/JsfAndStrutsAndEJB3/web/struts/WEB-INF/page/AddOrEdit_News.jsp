<%@ page contentType="text/html;charset=GBK" %>
<%@ include file="/WEB-INF/page/top.jsp" %>
<html>
<head>
<title><c:if test="${'add'==method}">添加</c:if><c:if test="${'add'!=method}">修改</c:if>新闻</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
</head>
<body bgcolor="#FFFFFF" text="#000000" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">

<html:form action="/news/dispose" method="post">
<html:hidden property="newsid"/>
<c:if test="${empty method}"><c:set var="method" value="add"/></c:if>
<input type="hidden" name="method" value="<c:out value="${method}"/>">
  <table width="80%" border="0" cellspacing="1" cellpadding="3" align="center">
    <tr bgcolor="6f8ac4"> 
      <td colspan="2" ><font color="#FFFFFF"><c:if test="${'add'==method}">添加</c:if><c:if test="${'add'!=method}">修改</c:if>新闻：</font></td>
    </tr>
    <tr bgcolor="f5f5f5"> 
      <td width="18%"> <div align="right">标题 <font color="#FF0000">*</font> 
          ：</div></td>
      <td width="82%"> <html:text property="title" size="80" maxlength="90"/>
      </td>
    </tr>
    <tr bgcolor="f5f5f5"> 
      <td width="18%"> <div align="right">所属目录 <font color="#FF0000">*</font> 
          ：</div></td>
      <td width="82%"> <c:if test="${fn:length(catalog)>0}">
	  <html:select property="catid">
		 <html:options collection="catalog" property="catid" labelProperty="name"/>
      </html:select></c:if><c:if test="${fn:length(catalog)==0}">
		<html:text property="catalogname" size="30" maxlength="50"/>
	  </c:if>
      </td>
    </tr>
	
	<tr bgcolor="f5f5f5"> 
      <td width="18%"> <div align="right">信息来源   
          ：</div></td>
      <td width="82%"> <html:text property="source" size="50" maxlength="50"/>
      </td>
    </tr>
    <tr bgcolor="f5f5f5"> 
      <td width="18%" valign="top"> <div align="right">资讯内容 <font color="#FF0000">*</font> 
          ：</div></td>
      <td width="82%"><html:textarea property="content" cols="60" rows="13"></html:textarea></td>
	</tr>
    <tr bgcolor="f5f5f5"> 
      <td colspan="2"> <div align="center"> 
          <input type="submit" name="Add" value=" 确 认 " class="frm_btn">
        </div></td>
    </tr>
  </table>
</html:form>
<br>
</body>
</html>


<%@ page contentType="text/html;charset=GBK" %>
<%@ include file="/WEB-INF/page/top.jsp" %>
<html>
<head>
<title><c:if test="${'add'==method}">添加</c:if><c:if test="${'add'!=method}">修改</c:if>目录</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
</head>
<body bgcolor="#FFFFFF" text="#000000" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">

<html:form action="/news/catalog/dispose" method="post">
<html:hidden property="catid"/>
<c:if test="${empty method}"><c:set var="method" value="add"/></c:if>
<input type="hidden" name="method" value="<c:out value="${method}"/>">
  <table width="92%" border="0" cellspacing="1" cellpadding="3" align="center">
    <tr bgcolor="6f8ac4"> 
      <td colspan="2" ><font color="#FFFFFF"><c:if test="${'add'==method}">添加</c:if><c:if test="${'add'!=method}">修改</c:if>目录：</font></td>
    </tr>
    <tr bgcolor="f5f5f5"> 
      <td width="18%"> <div align="right">目录名称 <font color="#FF0000">*</font> 
          ：</div></td>
      <td width="82%"> <html:text property="catalogname" size="50" maxlength="50"/>
      </td>
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


<%@ page contentType="text/html;charset=GBK" %>
<%@ include file="/news/top.jsp" %>
<html>
<head>
<title>��Ϣ���</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
</head>
<body leftmargin="8" >
<table width="700" border="0" cellspacing="0" cellpadding="0" align="center">
  <tr> 
    <th>
      ��Ϣ���<hr size=1>
    </th>
  </tr>
</table><f:view> 
<div align=center>
  <table width="700" cellspacing="1" cellpadding="4" align="center">
    <tr> 
      <th class="table_b_2" width="113" align="right">���ű���</th>
      <td class="table_b" width="472"><h:outputText value="#{newsView.news.title}"/>&nbsp;</td>
    </tr>
    <tr> 
      <th class="table_a_2" width="113" align="right" valign="top">Ŀ¼</th>
      <td class="table_a" width="472"><h:outputText value="#{newsView.news.catalog.name}"/>&nbsp; </td>
    </tr>
	<tr> 
      <th class="table_b_2" width="113" align="right">��Ϣ��Դ</th>
      <td class="table_b" width="472"><h:outputText value="#{newsView.news.source}"/></td>
    </tr>
    <tr> 
      <th class="table_b_2" width="113" align="right">����ʱ��</th>
      <td class="table_b" width="472"><h:outputText value="#{newsView.news.createdate}">
              <f:convertDateTime pattern="yyyy-MM-dd"/>
           </h:outputText></td>
    </tr>
    <tr> 
      <th class="table_b_2" width="113" align="right" valign="top">����</th>
      <td class="table_b" width="472"><h:outputText value="#{newsView.news.content}" escape="false"/></td>
    </tr>
  </table>
  <table width="600" align="center" cellpadding="2" cellspacing="2">
    <tr>
      <td align="center">
        <input type="button" name="Button" value=" �� �� " class="frm_btn" onclick="javascript:history.back()">
      </td>
    </tr>
  </table>
</div>  </f:view>
</body>
</HTML>
<%@ page contentType="text/html; charset=GBK"%>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=gb2312">
  <title>Jaas tests</title>
</head><body>
<jsp:include page="/includes/menubar.jsp"/>
<H3>Jaas Tests</H3>
<P>
   <A href="anon/anonymousPage.jsp">这个页面允许匿名用户访问</A> 
</P>
<P>
   <A href="user/departmentUser.jsp">这个页面允许部门角色访问</A>
</P>
<P>
	<A href="admin/adminPage.jsp">这个页面允许管理员角色访问</A>
</P>
</body>
</html>
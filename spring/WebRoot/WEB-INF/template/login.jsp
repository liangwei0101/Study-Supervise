<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%String path = request.getContextPath();%>
${message}
<form action="<%=path%>/user/login" method="post">
   		用户名：<input name="username" type="text" ><br/>
   		密码：<input name="password" type="password" ><br/>
   		<input type="submit" ><input type="reset">
</form>
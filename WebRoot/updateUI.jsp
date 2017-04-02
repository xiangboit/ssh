<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'updateUI.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	

  </head>
  
  <body>
    	<form action="info_update.action" method="post">
    		<s:hidden name="id"/><br>
    		name:<s:textfield name="name"/><br>
    		age:<s:textfield name="age"/><br>
    		address:<s:textfield name="address"/><br>
    		<input type="submit" value="提交">
    	</form>
  </body>
</html>

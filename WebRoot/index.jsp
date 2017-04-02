<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
  </head>
  <script type="text/javascript">
		function changepage(pageno){
			location.href="info_list.action?pageNo="+pageno;
		}
		
	</script>
  <body>
	  	<form action="info_list.action" method="post" name="form1">
	  		<p align="center">
	  			请输入名称：<s:textfield name="sel"/><input type="submit" value="查询">
	  		</p>
	  	</form>
  		
  		<table border="1px" align="center" width="600px" height="300px">
  			<tr>
  				<td>id</td>
  				<td>name</td>
  				<td>age</td>
  				<td>address</td>
  				<td>
  					操作
  				</td>
  			</tr>
  			<s:iterator value="infolist">
    		<tr>
  				<td>${id}</td>
  				<td>${name}</td>
  				<td>${age}</td>
  				<td>${address}</td>
  				<td>
  					<a href="info_updateUI.action?id=${id}">修改</a>&nbsp;
  					<a href="info_delete.action?id=${id}">删除</a>
  				</td>
  			</tr>
    	</s:iterator>
  		</table>
    	<p align="center">
    		<a href="info_addUI.action">新增</a>
    	</p>
    	
    	<p align="center">
   			当前${pageNo}页/总共${pageCount}页
   			<a href="info_list.action?pageNo=1">首页 </a>&nbsp;&nbsp;
   			<c:if test="${pageNo>1}">
   			<a href="info_list.action?pageNo=${pageNo-1 }">上一页</a>&nbsp;&nbsp;
   			</c:if>
   			<c:if test="${pageNo<pageCount}">
   			<a href="info_list.action?pageNo=${pageNo+1 }">下一页</a>&nbsp;&nbsp;
   			</c:if>
   			<a href="info_list.action?pageNo=${pageCount}">末页</a>&nbsp;&nbsp;
   			
   			跳转<select id="op" onchange="changepage(this.value)" >
   				 <c:forEach var="pn" begin="1" end="${pageCount}">
   					<option value="${pn}" >${pn}</option>
   				 </c:forEach>
   			   </select>
   		</p>
  </body>
  <!-- 通过js重新获取下拉列表的值 -->
  <script type="text/javascript">
  		document.getElementById("op").value=${pageNo};
  </script>
</html>

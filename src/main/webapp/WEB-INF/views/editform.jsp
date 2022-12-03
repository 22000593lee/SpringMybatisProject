<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@page import="com.example.board.BoardDAO, com.example.board.BoardVO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Form</title>
</head>
<body>

<%
	BoardDAO boardDAO = new BoardDAO();
	String id=request.getParameter("id");	
	BoardVO u=boardDAO.getBoard(Integer.parseInt(id));
%>

<h1>Edit Form</h1>
<form:form commandName="boardVO" method="post" action="../editok" >
<form:hidden path="seq"/>
<table id="edit">
<tr><td>Title:</td><td><form:input path="title" /></td></tr>
<tr><td>Writer:</td><td><form:input path="writer" /></td></tr>
<tr><td>Content:</td><td><form:textarea cols="50" rows="5" name="content" /></td></tr>

</table>
	<input type="submit" value="수정하기" />
	<input type="button" value="취소하기" onclick="history" />
</form:form>

</body>
</html>
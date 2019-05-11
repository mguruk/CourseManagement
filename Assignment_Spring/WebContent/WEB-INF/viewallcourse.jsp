<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="jstlcore" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
<h2>Courses</h2>
<table border="1" align="center">
	<tr>
	<th> Course Name </th> <th>Course Fee </th><th>Course Type</th>
	</tr>
    <jstlcore:forEach items="${List}" var="course">
		<tr align="center">
		<td align="center"><jstlcore:out value="${course.courseName}"></jstlcore:out></td>
		<td align="center"><jstlcore:out value="${course.coursefees}"></jstlcore:out></td>
		<td align="center"><jstlcore:out value="${course.courseType}"></jstlcore:out></td>
		</tr>
	</jstlcore:forEach>
</table>

 <br> <a href="./student.jsp"> Enroll Now</a> <br> 
</center>
</body>
</html>
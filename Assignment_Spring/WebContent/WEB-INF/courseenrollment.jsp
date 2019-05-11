<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Course Enrollment</h2>
<form:form action="enroll.htm" modelAttribute="student" method="get">

<table  border="0">
		<tr>
			<td>Student Name</td>
			<td><form:input path="studentName" id="studentName"/></td>
		</tr>
		
		<tr>
			<td>Course Name</td>
			<td>
			<form:select path="courseCode">    
    			<c:forEach items="${courseList}" var="course">
        			<form:option  value="${course.key}">${course.value}</form:option>
   			 	</c:forEach>
			</form:select>
			</td>
		</tr>
		
		<tr>
			<td>Gender</td>
			<td><form:radiobutton  path="gender" value="m"/>Male
			<form:radiobutton path="gender" value="f"/>Female</td>
		</tr>
		
		<tr>
			<td>Course Type</td>

		<td>elearning<form:checkbox path="courseType" value="elearning"/>
		classroom<form:checkbox path="courseType" value="classroom"/>
		<br><br>
		</tr>	
		
		
		
  <input type="submit" value="enroll">
</form:form>

 			<tr>
				<td colspan="2" align="center"><font color="red">${message}</font></td>
			</tr>
</table>
<a href="./student.jsp">Back</a>

</body>
</html>
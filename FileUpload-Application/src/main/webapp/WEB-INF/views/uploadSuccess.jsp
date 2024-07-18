<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>File uploaded successfully!</h2>


<%-- <p>File Name: ${fileName}</p> --%>
<%-- <p>File Size: ${fileSize} bytes</p> --%>



<p>Message: ${message}</p>
<p>And your photo is:</p>
<img src="${pageContext.request.contextPath}/getPhotograph?rollno=${rollno}" alt="User Photograph" />
</body>


</html>
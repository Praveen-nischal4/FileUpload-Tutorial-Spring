<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="saveDetails" method="post" enctype="multipart/form-data">
 

  Name    : <input type="text" name="name" placeholder="Enter your name"/> <br>
  Age     : <input type="text" name="age" placeholder="Entre your age"/> <br>
  Photo   : <input type="file" name="photo" /> <br>
  
   <input type="submit" value="Save Details" />

</form>
</body>
</html>
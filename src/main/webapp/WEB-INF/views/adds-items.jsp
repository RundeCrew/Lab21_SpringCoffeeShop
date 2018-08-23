<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta charset="UTF-8">
<title>Add</title>
</head>
<body>
  <form action="/add-for">
    <p>
    Name: <input name= "name" />
    </p>
    
    <p>
    Description: <input name= "description" />
    </p>
    
    <p>
    Quantity: <input name= "quantity" />
    </p>
      <button type="submit"> Submit </button>
       </form> 
       
    
</body>
</html>
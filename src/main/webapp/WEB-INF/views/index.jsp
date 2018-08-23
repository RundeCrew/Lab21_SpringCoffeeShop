<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Coffee Shop Home</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<link rel="stylesheet" href="/style.css" />

</head>
	<main class="container">
	<body>
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <a class="navbar-brand" href="#">Coffee Express</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarText" aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarText">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="/registrationform">Registration</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="/pricing">Pricing</a>
      </li>
    </ul>
  
  </div>
</nav>
		<p>
		<h1> Welcome to Coffee Express</h1>
	
		
		<table class="table">
		<tbody>
			<thead>
				<tr>
					<th>Item</th><th>Description</th><th>Quantity</th><th>Price</th><th>Action</th>
				</tr>
			</thead>
			
				<c:forEach var="item" items="${items}">
				<tr>							
					
					<td>${item.name}</td><td>${item.description}</td><td>${item.quantity}</td><td>$ ${item.price}</td>
					<td>
								 <%--  // added/items to see if working --%>
						<a href="/items/${ item.id }/edit" class="btn btn-light btn-sm">Edit</a>
						<a onclick="return confirm('Are you sure you want to delete?')" href="/items/${ item.id }/delete" class="btn btn-light btn-sm">Delete</a>
					</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		<a href="/adds-items" class="btn btn-light btn-sm">Add</a>
	</body>
	</main>
</html>
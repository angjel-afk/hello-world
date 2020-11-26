<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>

	<head>
		<title>Todo list</title>
		<link href="webjars/bootstrap/4.5.3/css/bootstrap.min.css" rel="stylesheet">
		<link rel="stylesheet" href="background.css">
	</head>

	<body>
	<font color="red" >${errorMessage}</font>
	
	<div class="container">
		<table class="table table-bordered table-striped table-dark">
		<caption>This is your todo list</caption>
			<thead class="thead-dark" >
				<tr>
					<th>Description</th>
					<th>Target Date</th>
					<th>Finished</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${todos}" var="item">
					<tr>
						<td>${item.description}</td>
						<td>${item.targetDate}</td>
						<td>${item.finished}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div>
			<a class="button" href="/add-todo">Add a Todo</a>
		</div>
	</div>

		
	<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/4.5.3/js/bootstrap.min.js"></script>
	</body>

</html>
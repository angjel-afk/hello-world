<html>
<style>
input[type="text"], 
input[type="number"],
 input[type="email"], 
 input[type="password"],
 button[type="submit"],
	textarea, 
	select {
	width: 100%;
	padding: 12px 20px;
	margin: 8px 0;
	display: inline-block;
	border: 1px solid #ccc;
	border-radius: 4px;
	box-sizing: border-box;
}
#other {
	margin-left: 25px;
	margin-top: 10px;
	margin-bottom: 25px;
}
div {
	width: 600px;
	margin: 0 auto;
	border-radius: 5px;
	background-color: #F2F2F2;
	padding: 20px;
}
.regSuccess {
	text-align: center;
	border: 3px solid green;
	color: #4CAF50;
	border-radius: 4px;
}
.labels {
	text-align: right; 
	color : black;
	font-family: sans-serif;
	font-style: normal;
	font-size: 15px;
	color: black;
}
.myHead {
	text-align: center;
	text-decoration: underline;
	text-transform: uppercase;
	color: #4CAF50;
	font-size: 25px;
	margin-top: 15px;
}
.myHead2 {
	text-align: center;
	text-decoration: none;
	text-transform: capitalize;
	color: #4CAF50;
	font-size: 25px;
	margin-top: 15px;
}
.our-class {
	text-align: center;
	font-size: 18px;
	padding: 10px;
	color: #333333
}
span {
	color: red;
}
</style>
<head>
<title>Register confirmation</title>
</head>
<body>
	<div>
		<font color="red">${errorMessage}</font>
		<h1 class="regSuccess">Registering successful</h1>
		<br></br> <label class="labels" for="firstName">User Name:${username}</label>
		<br></br>
		<label class="labels" for="email">Email:${user.email}</label>
		<br></br>
		<label class="labels" for="description">About me:${user.aboutMe}</label>
		 <br></br>
		
		
		<form action="login" >
         <button type="submit" style="width: 100px; margin-left: 250px; margin-bottom: -10px;" onClick="login" >LOG IN</button>
      </form>
		
		
	</div>
</body>
</html>
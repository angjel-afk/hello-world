<html>

<style>
input[type="text"],
input[type="number"],
input[type="email"], 
input[type="password"],
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

#male, #female, #other {
    margin-left:25px;
    margin-top:10px;
    margin-bottom:25px;
}

input[type=submit] {
  width: 100%;
  background-color: #4CAF50;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

input[type=submit]:hover {
  background-color: #45a049;
}

div {
  width: 600px;
  margin: 0 auto;
  border-radius: 5px;
  background-color: #f2f2f2;
  padding: 20px;
}

.myHead {
  text-align: center;
  text-decoration: underline;
  text-transform: uppercase;
  color: #4CAF50;
  font-size: 45px;
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
		<title>Registration form</title>
		</head>
		<body>
			<font color="red" >${errorMessage}</font>
			<div>
			
			<h1 class="myHead">Registration form</h1>
				<form method="post">
			
				<label for="firstName">First Name</label>
				<input type="text" id="firstName" name="firstName" placeholder="Your name.."> 
			
				<label for="lastName">Lastname</label>
				<input type="text" id="lastName" name="lastName" placeholder="Your lastname">
			
				<label for="age"> Age </label>
				<input type="number" id="age" name="age" placeholder="Your current age">
			
				<label for="email">Email</label>
				<input type="text" id="email" name="email" placeholder="Your email" required="required">
				
				<label for="address">Address</label>
				<input type="text" id="address" name="address" placeholder="Your address" required="required">
				
				<label for="country">Country</label>
		    	<select id="country" name="country">
		      		<option value="macedonia">Macedonia</option>
		      		<option value="canada">Canada</option>
		      		<option value="usa">USA</option>
		      		<option value="slovenia">Slovenia</option>
		      		<option value="croatia">Croatia</option>
		    	</select>
		    	
		    	<input type="radio" id="male" name="gender" value="male" checked="checked" >
		    	<label for="male">Male</label>
		    	<input type="radio" id="female" name="gender" value="female">
		    	<label for="female">Female</label>
		    	<input type="radio" id="other" name="gender" value="other">
		    	<label for="other">Other</label><br>
		    	
		    	<label for="username">Username</label>
				<input type="text" id="username" name="username" placeholder="Your username" required="required"> 
				
				<label for="password">Password</label>
				<input type="password" id="password" name="password" placeholder="Your password" required="required"> 
				
				<label for="confirmPassword">Confirm password</label>
				<input type="text" id="confirmPassword" name="confirmPassword" placeholder="Retype password" required="required"> 
		    
		    	<label for="description">About you</label>
				<textarea id="description" name="description" rows="4" cols="50"
			  	placeholder="Type few lines for yourself.."></textarea>
			  	
			  	<label>Target Date</label>
 				<input type="date" id="targetDate" name="targetDate"/>
			  	
			  	<input type="submit" />
				</form>
		</div>
	</body>
</html>
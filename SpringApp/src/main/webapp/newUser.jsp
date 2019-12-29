<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register New User</title>
<!-- <script type="text/javascript">
    function submitform(){
        alert("Sending Json");
        var xhr = new XMLHttpRequest();
        xhr.open(form.method, form.action, true);
        xhr.setRequestHeader('Content-Type', 'application/json; charset=UTF-8');
        var j = {
            "first_name":"binchen",
            "last_name":"heris",
        };
        xhr.send(JSON.stringify(j));
    }
</script> -->
</head>
<body>
	<h1>Register New User</h1>
	<form action="/api/createUser" method="post" enctype='application/json'>
		<table>
			<tr>
				<td>First Name</td>
				<td><input type="text" name="firstName" value=''></td>
			</tr>
			
			<tr>
				<td>Last Name</td>
				<td><input type="text" name="lastName" value=''></td>
			</tr>
			
			<tr>
				<td>City</td>
				<td><input type="text" name="city" value=''></td>
			</tr>
			
			<tr>
				<td>Login Id</td>
				<td><input type="text" name="loginId" value=''></td>
			</tr>
			
			<tr>
				<td>Password</td>
				<td><input type="text" name="password" value=''></td>
			</tr>
			
			<tr>
				<td><input type="submit" name="submit" value="submit"></td>
			</tr>
		</table>
	</form>
</body>
</html>
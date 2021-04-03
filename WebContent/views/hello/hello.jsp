<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Demo</title>
</head>
<body>
	<p>Hello ${ name }</p>
	<form method="POST" action="/MyDemo/HelloServlet">
		<input type="text" name="name"/>
		<select name="gender">
			<option value="0">Nữ</option>
			<option value="1">Nam</option>
		</select>
		<input type="checkbox" name="ok1" id="ok1"/>
		<label for="ok1">OK?</label>
		<input type="radio" name="ok" />
		<label>True</label>
		<input type="radio" name="ok" />
		<label>False</label>
		<button>Submit</button>
	</form>
</body>
</html>
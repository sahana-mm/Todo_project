<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>

body {
  font-family: Arial, sans-serif;
  background-color: #f4f4f4;
  margin: 0;
  padding: 0;
  display: flex;
  justify-content: center;
  align-items: center;
  min-height: 100vh;
  background:url('https://i.pinimg.com/originals/ac/54/a1/ac54a128942c750799c2c1fe144d2467.jpg') center/cover no-repeat;
  
}

form {
  background-color: #ffffff;
  border-radius: 10px;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
  padding: 20px;
  width: 300px;
  margin-left:auto;
  margin-right:150px;
}

/* Styling for the labels and inputs */
label {
  display: block;
  margin-bottom: 5px;
  font-weight: bold;
}

input[type="text"] {
  width: 90%;
  padding: 10px;
  margin-bottom: 10px;
  border: 1px solid #ccc;
  border-radius: 4px;
  transition: border-color 0.3s ease-in-out;
}

input[type="text"]:focus {
  border-color: #007bff;
}

input[type="submit"] {
  background-color: #007bff;
  color: #ffffff;
  border: none;
  padding: 10px 20px;
  border-radius: 4px;
  cursor: pointer;
  transition: background-color 0.3s ease-in-out;
}

input[type="submit"]:hover {
  background-color: #0056b3;
}</style>

<title>Insert title here</title>
</head>
<body>
<form action=TodoCon method=POST>
<label for=first_name>FIRST NAME</label>
<input type="text"  name="first_name">
<label for=last_name>LAST NAME</label>
<input type="text" name="last_name">
<label for=email>EMAIL</label>
<input type="text" name="email">
<label for=password>PASSWORD</label>
<input type="text" name="password">
<input type="submit" value="submit">

</form>
</body>
</html>
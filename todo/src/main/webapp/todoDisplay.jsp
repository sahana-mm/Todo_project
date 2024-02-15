    
    <%@ page import="java.util.List,java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="todo.Record" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TODO LIST</title>
<style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 20px;
        }
        body,.taskbar{
              background:url('https://pub-static.fotor.com/assets/bg/3c097427-e864-4078-a532-bc6aeecefbdc.jpg') center/cover no-repeat;     
        }
        h1 {
            text-align: center;
        }
        p{
            font-size:30px;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        th, td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: center;
            font-size: 20px;
            
        }
        th {
            background-color: #f2f2f2;
        }
         .button {
        display: inline-block;
        padding: 20px 40px;
        font-size: 25px;
        background-image:url('https://media.istockphoto.com/id/1271426981/video/abstract-clean-blurred-soft-beautiful-glitter-dust-tiny-moving-rising-glitter-bokeh-particles.jpg?s=640x640&k=20&c=s2At7Ds6q_4SJ4kRyNJ7CNumKjumoIajrQT4OOoAf5w=');
        color: white;
        border: solid 1pt black;
        border-radius: 10px;
        cursor: pointer;
        font-style:bold;
        text-decoration: none;
        
    }
        .taskbar {
            background-color: white;
            color: black;
            display: flex;
            align-items: center;
            padding: 10px 20px;
            justify-content: space-between;
        }
    </style>

</head>
<body>
 <div class="taskbar">
        <p><b>Todo Tasks</b></p>
       
    </div>
    <table align="center">
        <tr>
            
            <th>TITLE</th>
            <th>DESCRIPTION</th>
        </tr>
          <% 
        List<Record> recordsList = (List<Record>) request.getAttribute("records");
        if (recordsList != null) {
            for (Record record : recordsList) { 
        %>
        <tr>
            <td><%= record.getTitle() %></td>
            <td><%= record.getDesc() %></td>
        </tr>
         <% 
             }
         } else {
         %>
         <tr>
             <td colspan="2"><br><br><a href=DispTodo class="button" align="center">View todo list</a></td>
         </tr>
         <% 
         }
        %>
    </table> 
 </body>
</html>
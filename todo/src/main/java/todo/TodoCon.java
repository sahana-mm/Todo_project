package todo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


/**
 * Servlet implementation class TodoCon
 */
@WebServlet("/TOdoCon")
public class TodoCon extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TodoCon() {
        super();
        // TODO Auto-generated constructor stub
    }
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		String first_name = request.getParameter("first_name");
        String last_name = request.getParameter("last_name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
		 try {
		        Class.forName("com.mysql.cj.jdbc.Driver");
		        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/todo", "root", "Sahana@123");
		        String insertQuery = "insert into users (first_name, last_name, email, password) values (?, ?, ?, ?)";
	            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
	            preparedStatement.setString(1, first_name);
	            preparedStatement.setString(2, last_name);
	            preparedStatement.setString(3, email);
	            preparedStatement.setString(4, password);
	            int rowsAffected = preparedStatement.executeUpdate();
	            connection.close();
	            if (rowsAffected > 0) {
	                // Data inserted successfully
	                response.sendRedirect("todoInsert.jsp?success=true");
	            } else {
	                // Insertion failed
	                response.sendRedirect("form.jsp?success=false");
	            }
		 }
		 catch (ClassNotFoundException | SQLException e) {
	            e.printStackTrace(); // Log the exception for debugging
	            response.sendRedirect("form.jsp?success=false&error=" + e.getMessage());
	        }
	}

}

package todo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Servlet implementation class CreateDB
 */
@WebServlet("/CReateDB")
public class CreateDB extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateDB() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
        PrintWriter out = response.getWriter();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/todo", "root", "Sahana@123");
            Statement statement = connection.createStatement();

            // SQL statement to create a new database
            String createDatabaseQuery = "CREATE DATABASE IF NOT EXISTS todo";
            statement.executeUpdate(createDatabaseQuery);

            // Close the initial connection
            connection.close();

            // Reconnect using the new database
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/todo", "root", "raki@30032002");
            statement = connection.createStatement();
            
            // SQL statement to create a new table "Users"
            String createUsersTableQuery = "CREATE TABLE IF NOT EXISTS users (" +
                                      "first_name VARCHAR(20),"+
                                      "last_name VARCHAR(20),"+
                                      "email VARCHAR(35),"+
                                      "password VARCHAR(20))";
            statement.executeUpdate(createUsersTableQuery);
            
            
            // SQL statement to create a new table "Customers"
            String createTodosTableQuery = "CREATE TABLE IF NOT EXISTS todos (" +
                                      "title VARCHAR(50),"+
                                      "description VARCHAR(255))";
                                      
            statement.executeUpdate(createTodosTableQuery);
            
            out.println("<p>Database and tables created successfully</p>");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
            out.println("<p>Error creating table: " + e.getMessage() + "</p>");
        }
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

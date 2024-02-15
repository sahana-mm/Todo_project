package todo;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class TodoTable
 */
@WebServlet("/TodoTable")
public class TodoTable extends HttpServlet {
  private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TodoTable() {
        super();
        // TODO Auto-generated constructor stub
    }

  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
   */
//  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//    // TODO Auto-generated method stub
//    response.getWriter().append("Served at: ").append(request.getContextPath());
//  }

  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // TODO Auto-generated method stub
  	  response.setContentType("text/html");
   String title = request.getParameter("title");
         String description = request.getParameter("description");
     try {
       Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/todo", "root", "Sahana@123");
       String insertQuery2 = "insert into todos (title,description) values (?, ?)";
              PreparedStatement preparedStatement = connection.prepareStatement(insertQuery2);
              preparedStatement.setString(1, title);
              preparedStatement.setString(2, description);
             
              int rowsAffected = preparedStatement.executeUpdate();
             // connection.close();
              if (rowsAffected > 0) {
                  // Data inserted successfully
                  response.sendRedirect("todoDisplay.jsp?success=true");
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
/**
 *
 * @author Betsey McCarthy and Colin Hiriak 2015
 */
        

 
package SQL;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author emccarthy3
 */
public class SqlGatewayServlet extends HttpServlet {

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        
        String url = "index.jsp";
        
        String action = request.getParameter("action");
        
        if(action != null && action.equals("goToCheckout")) {
            url = "checkout.jsp";
        }
        
        if(action != null && action.equals("goToBooks")) {
            
            ArrayList<Book> books = BookDB.selectBooks();
            
            request.setAttribute("books", books);
            
            url = "manage.jsp";
        }
        
        if(action != null && action.equals("goToIndex")) {
            url = "index.jsp";
        }
       
if(action != null && action.equals("doCheckout")) {        
        
String firstName = request.getParameter("firstName");
   String lastName = request.getParameter("lastName");
   String email = request.getParameter("email");
   String bookTitle = request.getParameter("bookTitle");
            Book book = new Book(firstName, lastName, email, bookTitle);
        String sqlStatement = request.getParameter("sqlStatement");
        String sqlResult = "";
        try {
            // load the driver
            Class.forName("com.mysql.jdbc.Driver");
            
            // get a connection
            String dbURL = "jdbc:mysql://localhost:3306/mvc";
            String username = "root";
            String password = "mysqluser";
            
            String host = System.getenv("OPENSHIFT_MYSQL_DB_HOST");
            if((host!= null) && (host.trim().length()>1)){
                String port = System.getenv("OPENSHIFT_MYSQL_DB_PORT");
                String appname = System.getenv("OPENSHIFT_APP_NAME");
                username = System.getenv("OPENSHIFT_MYSQL_DB_USERNAME");
                password = System.getenv("OPENSHIFT_MYSQL_DB_PASSWORD");
                dbURL = "jdbc:mysql://" + host + ":" + port + "/" + appname;
            }
            
            Connection connection = DriverManager.getConnection(
                    dbURL, username, password);

            // create a statement
            Statement statement = connection.createStatement();

            // parse the SQL string
            sqlStatement = sqlStatement.trim();
            if (sqlStatement.length() >= 6) {
                String sqlType = sqlStatement.substring(0, 6);
                if (sqlType.equalsIgnoreCase("select")) {
                    // create the HTML for the result set
                    ResultSet resultSet
                            = statement.executeQuery(sqlStatement);
                    sqlResult = SQLUtil.getHtmlTable(resultSet);
                    resultSet.close();
                } else {
                    int i = statement.executeUpdate(sqlStatement);
                    if (i == 0) { // a DDL statement
                        sqlResult = 
                                "<p>The statement executed successfully.</p>";
                    } else { // an INSERT, UPDATE, or DELETE statement
                        sqlResult = 
                                "<p>The statement executed successfully.<br>"
                                + i + " row(s) affected.</p>";
                    }
                }
            }
            statement.close();
            connection.close();
        } catch (ClassNotFoundException e) {
            sqlResult = "<p>Error loading the databse driver: <br>"
                    + e.getMessage() + "</p>";
        } catch (SQLException e) {
            sqlResult = "<p>Error executing the SQL statement: <br>"
                    + e.getMessage() + "</p>";
        }

        HttpSession session = request.getSession();
        session.setAttribute("sqlResult", sqlResult);
        session.setAttribute("sqlStatement", sqlStatement);
session.setAttribute("firstName", firstName);
session.setAttribute("lastName", lastName);
session.setAttribute("bookTitle", bookTitle);
session.setAttribute("email", email);

        //String url = "/library.jsp";
        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }
}
}
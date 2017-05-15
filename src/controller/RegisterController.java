package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;

/**
 * Servlet implementation class RegisterController
 */
@WebServlet("/RegisterController")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		java.sql.PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		String userName = request.getParameter("username");
		String passWord = request.getParameter("password");
		String alias = request.getParameter("alias");
		System.out.println(userName+" "+passWord+" "+alias);

		try {
		
			Connection con = ConnectionMaker.getConnection();
			if(con != null){
			
				String checkForUsername =  "select * from users where username=?";
				preparedStatement = con.prepareStatement(checkForUsername);
				preparedStatement.setString(1, userName);
				rs  = preparedStatement.executeQuery();
				if(!rs.next()){
					preparedStatement = null;
					String query = "insert into users  values (0,?,?,?,?)";
					preparedStatement = con.prepareStatement(query);
					preparedStatement.setString(1, userName);
					preparedStatement.setString(2, passWord);
					preparedStatement.setString(3, alias);
					preparedStatement.setDate(4, new java.sql.Date(new java.util.Date().getTime()));
					int i = preparedStatement.executeUpdate();
					if(i!=0)
					{
						System.out.println("Creation Success");
						request.getRequestDispatcher("/userlogin.jsp").forward(request, response);
					}
					else
					{
						System.out.println("Creation failed, retry");
						request.getRequestDispatcher("/error.jsp").forward(request, response);
					}
				}else{
					System.out.println("Creation failed, retry");
					request.getRequestDispatcher("/error.jsp").forward(request, response);
				}
				}
				else
				{
					System.out.println("No Connection");
				}
			}  catch (SQLException e) {
			// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}

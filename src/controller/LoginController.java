package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
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
		HttpSession session = request.getSession();
		doGet(request, response);
		java.sql.PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		String userName = request.getParameter("username");
		String passWord = request.getParameter("password");
		System.out.println(userName+" "+passWord);

		try {
		
			Connection con = ConnectionMaker.getConnection();
			if(con != null){
			String query = "select * from users where username=? and password=?";
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, userName);
			preparedStatement.setString(2, passWord);
			rs = preparedStatement.executeQuery();
			if(rs.next())
			{
				System.out.println("Login Success");
				session.setAttribute("username", userName);
				request.getRequestDispatcher("/userhome.jsp").forward(request, response);
				con.close();
				rs.close();
			}
			else
			{
				System.out.println("Login failed, retry");
				request.getRequestDispatcher("/loginerror.jsp").forward(request, response);
			}
			}
			else
			{
				System.out.println("No Connection");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}

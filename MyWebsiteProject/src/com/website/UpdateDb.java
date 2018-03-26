package com.website;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.website.MyDBConn;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

/**
 * Servlet implementation class UpdateDb
 */
@WebServlet("servlet/UpdateDb")
public class UpdateDb extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateDb() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/jsp");
		PrintWriter out = response.getWriter();
		
		int tescoId = Integer.parseInt(request.getParameter("tescoId"));
		String tescoName =request.getParameter("tescoName");
		String tescoBranch =request.getParameter("tescoBranch");
		String tescoLoc = request.getParameter("tescoLoc");

		try {
			Connection con = (Connection) MyDBConn.getMySQLConnection();
			PreparedStatement ps =(PreparedStatement) con.prepareStatement("insert into tescoepping(tescoId, tescoName, tescoBranch, tescoLoc) values(?,?,?,?)");
			ps.setInt(1,tescoId);
			ps.setString(2,tescoName);
			ps.setString(3,tescoBranch);
			ps.setString(4,tescoLoc);
						
			int i=ps.executeUpdate();
			if(i>0)
			out.print("You are successfully registered...");
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		out.close();
	}
	

}


import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FormCalcul
 */
@WebServlet("/FormCalcul")
public class FormCalcul extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormCalcul() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(request.getParameter("par1")!=null || request.getParameter("par2")!=null) {
			String par1 = request.getParameter("par1");
			String par2 = request.getParameter("par2");
			int  somme = Integer.parseInt(par1)+Integer.parseInt(par2);
			response.getWriter().append(par1+" + "+par2+" = "+somme);
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				String user="root";
				String url= "jdbc:mysql://127.0.0.1/Calcule";
				String pwd="1299";
			
				Connection connexion =  DriverManager.getConnection(url, user, pwd);
				//System.out.println("biennnn");
				Statement statement = connexion.createStatement();
				statement.executeUpdate("Insert into nombres VALUES ('" + par1 + "','"+ par2+"');");
				
				
				
				
			} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
			
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
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

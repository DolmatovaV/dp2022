package servlet;



import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jdbc.Connect;
import jdbc.SqlCRUD;
import sports.Sport;
import sports.Mock;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import crud.Lab2CrudInterface;

/**
 * Servlet implementation class Servlet1
 */

@WebServlet("/Servlet1/*")
public class Servlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	LabCRUDinterface<Sport> crud = new SqlCRUD();

    
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub	
		
		crud = new SqlCRUD();
	}
	
	public void destroy() {
		// TODO Auto-generated method stub
		try {
			((SqlCRUD) crud).getConnection().close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		setAccessControlHeaders(response);
		response.setContentType("application/json");
		response.getWriter().println(crud.read());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		setAccessControlHeaders(response);
		Sport sport = Helpers.sportParse(request);
		crud.create(sport);
		doGet(request, response);
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		setAccessControlHeaders(response);
		Sport sport = Helpers.sportParse(request);
		int Id = Integer.parseInt(request.getPathInfo().substring(1));
		
		response.setContentType("application/json");
		crud.update(Id, sport);
		doGet(request, response);
	}
	
	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		setAccessControlHeaders(response);
		int Id = Integer.parseInt(request.getPathInfo().substring(1));
		
		response.setContentType("application/json");
		crud.delete(Id);
		doGet(request, response);
	}
	
		
		protected void doOptions(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			setAccessControlHeaders(response);
			response.setStatus(HttpServletResponse.SC_OK);

		}
		
		private void setAccessControlHeaders(HttpServletResponse resp) {
			
			resp.setHeader("Access-Control-Allow-Origin", "*");
			resp.setHeader("Access-Control-Allow-Methods", "*");
			resp.setHeader("Access-Control-Allow-Headers", "*");
		
	}

}

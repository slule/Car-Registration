package controllerGarage;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import helpers.GarageHelper;
import model.Car;
import model.Garage;

/**
 * Servlet implementation class UpdateGarage
 */
@WebServlet("/UpdateGarage")
public class UpdateGarage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateGarage() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GarageHelper helper = new GarageHelper ();
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String oldName = request.getParameter("oldName");
		String name = request.getParameter("newName");
		String location = request.getParameter("location");

		
		Garage garageToUpdate = helper.searchGarageByName(oldName);
		garageToUpdate.setName(name);
		garageToUpdate.setLocation(location);
		helper.update(garageToUpdate);
		
		getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
		
	}

}

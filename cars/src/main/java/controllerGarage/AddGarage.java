package controllerGarage;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import helpers.GarageHelper;
import model.Garage;


@WebServlet("/AddGarage")
public class AddGarage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddGarage() {
        super();
        // TODO Auto-generated constructor stub
    }

   

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Garage x = new Garage();
		GarageHelper helper = new GarageHelper();
		x.setName(request.getParameter("name"));
		x.setLocation(request.getParameter("location"));
		helper.persist(x);
		getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
		
		
		
	}

}





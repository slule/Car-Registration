package controllerCar;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import helpers.CarsHelper;
import model.Car;
import model.Garage;

/**
 * Servlet implementation class AddCar
 */
@WebServlet("/AddCar")
public class AddCar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	public AddCar() {
		super();
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Car t = new Car();
		CarsHelper helper = new CarsHelper();
		t.setCarMake(request.getParameter("carMake"));
		t.setCarModel(request.getParameter("carModel"));
		t.setCarYear(Integer.parseInt(request.getParameter("carYear")));
		t.getGarage().setName(request.getParameter("garageName"));
		helper.persist(t);
		getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
		
		
		
		
	}

}

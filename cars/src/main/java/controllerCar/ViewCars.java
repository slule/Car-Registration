package controllerCar;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import helpers.CarsHelper;
import model.Car;

/**
 * Servlet implementation class viewCars
 */
@WebServlet("/ViewCars")
public class ViewCars extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public ViewCars() {
		super();
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		CarsHelper helper = new CarsHelper();
		List<Car> carList = helper.showAllCars();
		request.setAttribute("carList", carList);
		
		
		getServletContext().getRequestDispatcher("/view.jsp").forward(request, response);
		
	}

}

package controllerCar;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import helpers.CarsHelper;
import model.Car;

/**
 * Servlet implementation class update
 */
@WebServlet("/update")
public class update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public update() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CarsHelper helper = new CarsHelper();
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String oldMake = request.getParameter("oldMake");
		String carMake = request.getParameter("carMake");
		String carModel = request.getParameter("carModel");
		int carYear = Integer.parseInt(request.getParameter("carYear"));
		
		Car carToUpdate = helper.searchCarByMake(oldMake);
		carToUpdate.setCarMake(carMake);
		carToUpdate.setCarModel(carModel);
		carToUpdate.setCarYear(carYear);
		
		helper.update(carToUpdate);
		
		getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
		
		
	}


}


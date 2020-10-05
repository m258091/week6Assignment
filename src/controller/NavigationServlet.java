package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Car;

/**
 * Servlet implementation class NavigationServlet
 */
@WebServlet("/navigationServlet")
public class NavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NavigationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CarHelper dao = new CarHelper();
		String act = request.getParameter("doThisToCar");
		
		String path = "/viewAllCarsServlet";
		
		if (act.contentEquals("delete")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				Car carToDelete = dao.searchForCarById(tempId);
				dao.deleteCar(carToDelete);
			} catch (NumberFormatException e) {
				System.out.println("Forgot to select a car to delete");
			}
			
			
		} else if (act.contentEquals("edit")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				Car carToEdit = dao.searchForCarById(tempId);
				request.setAttribute("carToEdit", carToEdit);
				path = "/edit-car.jsp";
			} catch (NumberFormatException e) {
				System.out.println("Forgot to select a car to edit");
			}
			
		} else if (act.contentEquals("add")) {
			path = "/index.html";
		}
		
		getServletContext().getRequestDispatcher(path).forward(request, response);
		
	}


}

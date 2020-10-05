package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Car;
import model.CarListDetails;
import model.CarShopper;

/**
 * Servlet implementation class createNewListServlet
 */
@WebServlet("/createNewCarListServlet")
public class CreateNewCarListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateNewCarListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CarHelper lih = new CarHelper();
		String listName = request.getParameter("carListName");
		System.out.println("Car List Name: " + listName);
	
		String carShopperName = request.getParameter("carShopperName");
		
		String[] selectedCars = request.getParameterValues("allCarsToAdd");
		List<Car> selectedCarsInList = new ArrayList<Car>();
		
		//make sure something was selected otherwise we get a null pointer exception
		
		if (selectedCars != null && selectedCars.length > 0) {
			for (int i = 0; i<selectedCars.length; i++) {
				System.out.println(selectedCars[i]);
				Car c =
						lih.searchForCarById(Integer.parseInt(selectedCars[i]));
				selectedCarsInList.add(c);
			}
		}
		
		CarShopper carShopper = new CarShopper(carShopperName);
		CarListDetails sld = new CarListDetails(listName, carShopper);
		sld.setListOfItems(selectedCarsInList);
		CarListDetailsHelper slh = new CarListDetailsHelper();
		slh.insertNewCarListDetails(sld);
		
		System.out.println("Success!");
		System.out.println(sld.toString());
		
		getServletContext().getRequestDispatcher("/viewAllCarsListsServlet").forward(request, response);
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}


import java.util.ArrayList;
import java.util.List;

import controller.CarListDetailsHelper;
import controller.CarShopperHelper;
import model.CarListDetails;
import model.Car;
import model.CarShopper;

public class CarShoppingTester {
	
	public static void main(String[] args) {
		
		CarShopper bill = new CarShopper("Bill");
		CarShopperHelper sh = new CarShopperHelper();
		
		sh.insertCarShopper(bill);
		
		List<CarShopper> allCarShoppers = sh.showAllCarShoppers();
		for (CarShopper a: allCarShoppers) {
			System.out.println(a.toString());
		}
		
		CarShopper cameron = new CarShopper("Cameron");
		CarShopperHelper sh1 = new CarShopperHelper();
		
		sh1.insertCarShopper(cameron);
		CarListDetailsHelper ldh = new CarListDetailsHelper();
		CarListDetails cameronList = new CarListDetails("Cameron's List", cameron);
		
		ldh.insertNewCarListDetails(cameronList);
		
		List<CarListDetails> allLists = ldh.getLists();
		
		for (CarListDetails a: allLists) {
			System.out.println(a.toString());
		}
		
		CarShopper susan = new CarShopper("Susan");
		CarShopperHelper sh2 = new CarShopperHelper();
		
		sh2.insertCarShopper(susan);
		
		CarListDetailsHelper ldh1 = new CarListDetailsHelper();
		CarListDetails susansList = new CarListDetails("Susan's Shopping List", susan);
		
		Car shampoo = new Car("Buick", "Caravan", 2019);
		Car brush = new Car("Toyota", "Avalon", 2015);
		
		List<Car> susansItems = new ArrayList<Car>();
		susansItems.add(shampoo);
		susansItems.add(brush);
		
		ldh1.insertNewCarListDetails(susansList);
		susansList.setListOfItems(susansItems);
		
		List<CarListDetails> allLists1 = ldh1.getLists();
		for (CarListDetails a1: allLists1) {
			System.out.println(a1.toString());
		}
		
		
	}

}

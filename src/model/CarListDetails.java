package model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

	@Entity
	@Table(name="car_list_details")
	public class CarListDetails {
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		@Column(name="LIST_ID")
		private int id;
		@Column(name="LIST_NAME")
		private String listName;
		@ManyToOne(cascade=CascadeType.PERSIST)
		@JoinColumn(name="CAR_SHOPPER_ID")
		private CarShopper shopper;
		@OneToMany(cascade=CascadeType.PERSIST, fetch=FetchType.EAGER)
		@JoinTable
		( 
			name="cars_on_list",
			joinColumns= { @JoinColumn(name="LIST_ID", referencedColumnName="LIST_ID") },
			inverseJoinColumns= { @JoinColumn(name="CAR_ID", referencedColumnName="ID", unique=true) }
			)
		private List<Car> listOfCars;
	
	public CarListDetails() {
		
	}
	
	public CarListDetails(int id, String listName, 
			CarShopper shopper, List<Car> listOfItems) {
		this.id = id;
		this.listName = listName;
		this.shopper = shopper;
		this.listOfCars = listOfItems;
	}

	public CarListDetails(String listName, 
			CarShopper shopper, List<Car> listOfItems) {
		this.listName = listName;
		this.shopper = shopper;
		this.listOfCars = listOfItems;
	}
	
	public CarListDetails(String listName, CarShopper shopper) {
		this.listName = listName;
		this.shopper = shopper;
	}

	public void setListOfItems(List<Car> listOfCars) {
		this.listOfCars = listOfCars;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getListName() {
		return listName;
	}

	public void setListName(String listName) {
		this.listName = listName;
	}

	public CarShopper getShopper() {
		return shopper;
	}

	public void setShopper(CarShopper shopper) {
		this.shopper = shopper;
	}

	public List<Car> getListOfCars() {
		return listOfCars;
	}

	@Override
	public String toString() {
		return "CarListDetails [id=" + id + ", listName=" + listName + ", shopper=" + shopper + ", listOfCars="
				+ listOfCars + "]";
	}	
	
}

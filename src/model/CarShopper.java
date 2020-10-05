package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="carshopper")
public class CarShopper {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CAR_SHOPPER_ID")
	private int id;
	@Column(name="CAR_SHOPPER_NAME")
	private String shopperName;
	
	
	public CarShopper() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CarShopper(int id, String shopperName) {
		super();
		this.id = id;
		this.shopperName = shopperName;
	}
	
	public CarShopper(String shopperName) {
		super();
		this.shopperName = shopperName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getShopperName() {
		return shopperName;
	}
	public void setShopperName(String shopperName) {
		this.shopperName = shopperName;
	}
	@Override
	public String toString() {
		return "Shopper [id=" + id + ", shopperName=" + shopperName + "]";
	}

}

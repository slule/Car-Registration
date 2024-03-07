/**  
* @Author Shalom Lule - slule@dmacc.edu  
* CIS175 <Spring 2024>
* Feb 20, 2024 
*/
package model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cars")
public class Car {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int carId;

	private String carMake;
	private String carModel;
	private int carYear;
	@ManyToOne
	@JoinColumn(name="garageId", nullable = false)
	private Garage garage = new Garage();

	

	public int getCarId() {
		return carId;
	}

	public void setCarId(int rowId) {
		this.carId = rowId;
	}

	public String getCarMake() {
		return carMake;
	}

	public void setCarMake(String carMake) {
		this.carMake = carMake;
	}

	public String getCarModel() {
		return carModel;
	}

	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}


	public int getCarYear() {
		return carYear;
	}

	
	public void setCarYear(int carYear) {
		this.carYear = carYear;
	}

	public Garage getGarage() {
		return garage;
	}


	public void setGarage(Garage garage) {
		this.garage = garage;
	}

	
	}
	
	










/**  
* @Author Shalom Lule - slule@dmacc.edu  
* CIS175 <Spring 2024>
* Mar 2, 2024 
*/ 
package model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "garage")
public class Garage {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int garageId;
	
	private String name;
	private String location;
	@OneToMany(mappedBy= "garage", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Car> cars;
	
	
	public int getGarageId() {
		return garageId;
	}
	
	public void setGarageId(int garageId) {
		this.garageId = garageId;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	

	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}


	public List<Car> getCars() {
		return cars;
	}


	public void setCars(List<Car> cars) {
		this.cars = cars;
	}


}



package model;

import java.io.Serializable;

public class Customer implements Serializable {


	private int id;
	private String name;
	private String surname;
	private String street;
	private int streetNumber;
	private int plz;
	private String city;
	public Customer() {
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setPlz(int plz) {
		this.plz = plz;
	}

	public Customer(int id)
	{
		this.id = id;
	}

	public int getId()
	{
		return id;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public void setSurname(String surname)
	{
		this.surname = surname;
	}
	
	public void setStreet(String street)
	{
		this.street = street;
	}
	
	public void setStreetNumber(int streetNumber)
	{
		this.streetNumber = streetNumber;
	}
	
	public void setPLZ(int plz)
	{
		this.plz = plz;
	}
	
	public void setCity(String city)
	{
		this.city = city;
	}
	
	public void printCostumer()
	{
		System.out.print(surname + " " + name);
		System.out.println(street + " " + streetNumber);
		System.out.println(plz + " " + city);
	}

	@Override
	public String toString() {
		return "Customer{" +
				"id=" + id +
				", name='" + name + '\'' +
				", surname='" + surname + '\'' +
				", street='" + street + '\'' +
				", streetNumber=" + streetNumber +
				", plz=" + plz +
				", city='" + city + '\'' +
				'}';
	}
}

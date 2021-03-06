package model;

import controller.BookingCinema;

import java.io.Serializable;
import java.util.ArrayList;

public class Booking implements Serializable {

	private static final long serialVersionUID = -6323485282545566727L;
	int cost;
	Customer costumer;
	Show show;
	int rowNumber;
	int seatNumber;
	
	
	public Booking(Customer costumer, Show show)
	{
		this.costumer = costumer;
		this.show = show;
	}

	public Booking(int cost, Customer costumer, Show show, int rowNumber, int seatNumber) {
		this.cost = cost;
		this.costumer = costumer;
		this.show = show;
		this.rowNumber = rowNumber;
		this.seatNumber = seatNumber;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public void setCostumer(Customer costumer) {
		this.costumer = costumer;
	}

	public void setShow(Show show) {
		this.show = show;
	}

	public Booking(ArrayList<Customer> customers, Show show) {
    }

    public int getCost()
	{
		if(show.getTheatre().getRows().get(rowNumber).getRowClass() == 1) {
			return cost += 8;
		}
		else {
			return cost += 5;
		}
	}
	
	public void setRowNumber(int rowNumber)
	{
		this.rowNumber = rowNumber;
	}
	
	public void setSeatNumber(int seatNumber)
	{
		this.seatNumber = seatNumber;
	}
	
	public boolean reserveSeat(int selectedRow, int selectedSeat)
	{
		if (show.getTheatre().getRows().get(selectedRow).getSeats().get(selectedSeat).getReservationStatus())
    	{  		
    		return false;
    	}
    	else {
    		show.getTheatre().getRows().get(selectedRow).getSeats().get(selectedSeat).reserve();
    		setRowNumber(selectedRow);
    		setSeatNumber(selectedSeat);

    		return true;
    	}
	}

	public Show getShow() {
		return show;
	}

	public int getRowNumber() {
		return rowNumber;
	}

	public int getSeatNumber() {
		return seatNumber;
	}

	public boolean unreserveSeat()
	{
    		show.getTheatre().getRows().get(rowNumber).getSeats().get(seatNumber).unreserve();

    		return true;
	}
	
	public Customer getCostumer()
	{
		return costumer;
	}

	@Override
	public String toString() {
		return "Booking{" +
				"cost=" + cost +
				", costumer=" + costumer +
				", show=" + show +
				'}';
	}
}

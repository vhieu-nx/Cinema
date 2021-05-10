package model;

import controller.BookingCinema;

import java.io.Serializable;

public class Seat implements Serializable {
	static final BookingCinema bookingCinema = BookingCinema.getINSTANCE();
	private static final long serialVersionUID =-477667091415244719L;
	int seatNumber;
	boolean isReserved;
	
	public Seat(boolean isReserved, int seatNumber)
	{
		this.isReserved = isReserved;
		this.seatNumber = seatNumber;
	}
	
	
	public void setSeatNumber(int seatNumber)
	{
		this.seatNumber = seatNumber;
	}
	
	public int getSeatNumber()
	{
		return this.seatNumber;
	}
	
	public boolean getReservationStatus()
	{
		return isReserved;
	}
	
	public void reserve()
	{
		isReserved = true;
	}
	
	public void unreserve()
	{
		isReserved = false;
//		bookingCinema.setWriter();
	}

	@Override
	public String toString() {
		return "Seat{" +
				"seatNumber=" + seatNumber +
				'}';
	}
}

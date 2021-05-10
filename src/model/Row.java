package model;

import java.io.Serializable;
import java.util.*;

public class Row implements Serializable {
	private static final long serialVersionUID = 8411877643763826180L;
	private ArrayList<Seat> seats;
	private int rowNumber; 
	private int rowClass;
	private int seatCount;

	public Row (int rowClass, int seatCount, int rowNumber)
	{
		this.rowNumber = rowNumber;
		this.rowClass = rowClass;
		this.seatCount = seatCount;
		seats = new ArrayList<Seat>();
		createSeats(this.seatCount);
	}
	
	public void setRowClass(int rowClass)
	{
		this.rowClass = rowClass;
	}
	
	public int getRowClass()
	{
		return this.rowClass;
	}
	
	public int getRowNumber()
	{
		return rowNumber;
	}
	
	public void createSeats(int seatCount)
	{
		for (int i = 1; i <= seatCount; i++)
		{
			seats.add(new Seat(false, i));
		}
	}
	
	public ArrayList<Seat> getSeats()
	{
		return seats;
	}

	@Override
	public String toString() {
		return "Row{" +
				"seats=" + seats +
				", rowNumber=" + rowNumber +
				", rowClass=" + rowClass +
				", seatCount=" + seatCount +
				'}';
	}
}

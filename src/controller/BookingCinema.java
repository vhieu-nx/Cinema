package controller;

import model.Booking;
import model.Customer;
import model.Show;
import storage.ReaderWriter;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class BookingCinema {
    Scanner scanner = new Scanner(System.in);
    private Booking booking;

    private ReaderWriter readerWriter = ReaderWriter.getINSTANCE();
    private ArrayList<Booking> bookings = readerWriter.readFile("booking.txt");
    private ArrayList<Customer> customers = readerWriter.readFile("customer.txt");
    private ArrayList<Show> shows = readerWriter.readFile("show.txt");




    private static BookingCinema INSTANCE;
    private BookingCinema(){

    }
    public static BookingCinema getINSTANCE(){
        if (INSTANCE == null) INSTANCE = new BookingCinema();
        return INSTANCE;
    }

    public  void cancelBooking() {
        System.out.println("CANCEL BOOKING Selected");
        System.out.println("-------------------------\n");
        for (int i = 0; i < bookings.size(); i++) {
            System.out.println("ID " +  bookings.get(i).getCostumer());
            System.out.println("Row: "+ bookings.get(i).getRowNumber());
            System.out.println("Seat: "+ bookings.get(i).getSeatNumber());

        }
        System.out.print("Enter the costumer id: ");

        int customerId = new Scanner(System.in).nextInt();
//        for (int i = 0; i < customers.size(); i++) {
//            if (customers.get(i).getId() == customerId){
//                for (int j = 0; j < customers.size(); j++) {
//                    if (bookings.get(i).getCostumer().getId() == customers.get(i).getId()){
//                        if (bookings.get(i).unreserveSeat()){
//                            System.out.println("Your reservation has been canceled!");
//                            setWriter();
//                        }
//                    }
//                }
//
//            }
//        }
        for (Booking customer : bookings) {
            if (customer.getCostumer().getId() == customerId)
            {
                for(Booking booking : bookings)
                {
                    if (booking.getCostumer().getId() == customer.getCostumer().getId())
                    {
                        if (booking.unreserveSeat())
                        {
                            setWriter();
                        }
                    }
                }

            }
            System.out.println("Your reservation has been canceled!");


//            else {
//                System.out.println("Customer ID does not exist");
//            }

        }
    }
    public void makeBooking() {
        System.out.println("MAKE BOOKING Selected");
        System.out.println("-------------------------\n");
        Random rnd = new Random();
        int costumerId = rnd.nextInt(999);
        Customer customer = new Customer(costumerId);
        customers.add(customer);


        for (int i = 0; i< shows.size(); i++)
        {
            int showNumber = i+1;
            System.out.println("Show Number: " + showNumber);;
            System.out.println("Show Name:   " + shows.get(i).getShowName());
            System.out.println("Show Date:   " + shows.get(i).getShowDate());
            System.out.print("\n");
        }
        System.out.println("-------------------------");
        System.out.print("Enter the show number: ");
        int showNumber = new Scanner(System.in).nextInt();
        int repeat = 0;
        System.out.println();
        do {
            shows.get(showNumber-1).getTheatre().printSeatPlan();
            System.out.print("Enter the row: ");
            int selectedRow = new Scanner(System.in).nextInt();
            System.out.print("Enter the seat: ");
            int selectedSeat = new Scanner(System.in).nextInt();
            System.out.println();
            Booking booking = new Booking(customer, shows.get(showNumber-1));
            if (booking.reserveSeat(selectedRow-1, selectedSeat-1)) {
                bookings.add(booking);
                System.out.println("The seat is now reserved for you.");
            }
            else {
                System.err.println("Sorry the seat is already reserved.");
            }
            System.out.println();
            System.out.print("Enter 1 to reserve another seat or 2 to check out: ");
            repeat = new Scanner(System.in).nextInt();
        } while (repeat == 1) ;
        System.out.println();
        System.out.println("Your Bill");
        System.out.println("-------------------------");
        int totalCost = 0;
        for (Booking booking : bookings)
        {
            if (booking.getCostumer().getId() == customer.getId())
            {
                totalCost += booking.getCost();

            }

        }
        System.out.println("Costumer ID: " + customer.getId());
        System.out.println("Total costs: " + totalCost + " USD");
        System.out.println();

    }
    public  void disPlayBooking(){
        System.out.println("DISPLAY Booking Selected");
        System.out.println("-------------------------\n");
        for (int i = 0; i < bookings.size(); i++) {
            System.out.println("Booking Cost: " + bookings.get(i).getCost() + "  USD");
            System.out.println("Booking Customer: " + bookings.get(i).getCostumer());
            System.out.println("Booking Show : " + bookings.get(i).getShow().getSeats());
//            System.out.println("Booking rowNumber : " + bookings.get(i).getRowNumber());
//            System.out.println("Booking seatNumber : " + bookings.get(i).getSeatNumber());
            System.out.println("\n");
            //int cost;
            //	Customer costumer;
            //	Show show;
            //	int rowNumber;
            //	int seatNumber;
        }
    }
    public void setWriter(){
        readerWriter.writeFile(bookings,"booking.txt");
    }
}

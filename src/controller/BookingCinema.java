package controller;

import model.Account;
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
    private ArrayList<Booking> bookingArrayList = readerWriter.readFile("booking.txt");
    private static BookingCinema INSTANCE;
    private BookingCinema(){

    }
    public static BookingCinema getINSTANCE(){
        if (INSTANCE == null) INSTANCE = new BookingCinema();
        return INSTANCE;
    }

    public   void cancelBooking(ArrayList<Booking> bookings, ArrayList<Customer> customers, Scanner choice) {
        System.out.println("CANCEL BOOKING Selected");
        System.out.println("-------------------------\n");
        System.out.print("Enter the costumer id: ");
        int customerId = choice.nextInt();
        for (Customer customer : customers) {
            if (customer.getId() == customerId)
            {
                for(Booking booking : bookings)
                {
                    if (booking.getCostumer().getId() == customer.getId())
                    {
                        if (booking.unreserveSeat())
                        {
                            setWriter();
                        }
                    }
                }
                System.out.println("Your reservation has been canceled!");
            }
        }
    }
    public void makeBooking(Scanner choice) {
        ArrayList<Show> shows = new ArrayList<>();
        ArrayList<Customer> customers = new ArrayList<>();
        ArrayList<Booking> bookings = new ArrayList<>();
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
        int showNumber = choice.nextInt();
        int repeat = 0;
        System.out.println();
        do {
            shows.get(showNumber-1).getTheatre().printSeatPlan();
            System.out.print("Enter the row: ");
            int selectedRow = choice.nextInt();
            System.out.print("Enter the seat: ");
            int selectedSeat = choice.nextInt();
            System.out.println();
            Booking booking = new Booking(customer, shows.get(showNumber-1));
            if (booking.reserveSeat(selectedRow-1, selectedSeat-1)) {
                bookings.add(booking);
                System.out.println("The seat is now reserved for you.");
            }
            else {
                System.out.println("Sorry the seat is already reserved.");
            }
            System.out.println();
            System.out.print("Enter 1 to reserve another seat or 2 to check out: ");
            repeat = choice.nextInt();
        } while (repeat == 1);
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
        System.out.println("Total costs: " + totalCost + " ĐôLaMỹ");
        setWriter();
        System.out.println();
    }
    public void setWriter(){
        readerWriter.writeFile(bookingArrayList,"booking.txt");
    }
}

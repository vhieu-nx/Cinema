package controller;

import checkInfor.CheckAcount;
import model.Account;
import model.Customer;
import model.Row;
import model.Seat;
import storage.ReaderWriter;

import java.util.ArrayList;
import java.util.Scanner;

public class CustomerManager {
    static final ArrayList<Customer> customers = new ArrayList<>();
    static final BookingCinema bookingCinema = BookingCinema.getINSTANCE();
    private Customer customer;

    private ReaderWriter readerWriter = ReaderWriter.getINSTANCE();
    private ArrayList<Customer> customerArrayList = readerWriter.readFile("customer.txt");
    private static CustomerManager INSTANCE;
    private CustomerManager(){

    }
    public String getInformation(){
        return customer.toString();
    }
    public static CustomerManager getINSTANCE(){
        if (INSTANCE == null) INSTANCE = new CustomerManager();
        return INSTANCE;
    }
    private int enterNameID(){
        System.out.println("Enter your ID Customer");
        int id = new Scanner(System.in).nextInt();
        return id;
    }
    private String enterName(){

        String name = "";
        do{
            System.out.println("Enter your  Customer Name");
            name = new Scanner(System.in).nextLine();
        }while (!name.matches(CheckAcount.CHECK_ACCOUNT));
        return name;
    }
    private String enterSurName(){
        String surname = "";
        do{
            System.out.println("Enter your Customer Surname ");
            surname = new Scanner(System.in).nextLine();
        }while (!surname.matches(CheckAcount.CHECK_ACCOUNT));
        return surname;
    }
    private String enterStreet(){
        System.out.println("Enter your Customer Street ");
        String street = new Scanner(System.in).nextLine();
        return street;
    }
    private int enterStreetNumber(){
        System.out.println("Enter your Customer StreetNumber ");
        int streetNumber = new Scanner(System.in).nextInt();
        return streetNumber;
    }
    private Integer enterplzNumber(){
        System.out.println("Enter your Customer plzNumber ");
        int plzNumber = new Scanner(System.in).nextInt();
        return plzNumber;
    }
    private String enterCity(){
        System.out.println("Enter your Customer City ");
        String street = new Scanner(System.in).nextLine();
        return street;
    }
    public void createCustomer(){
        Customer customer = new Customer();
//        customer.setId(enterNameID());
        customer.setName(enterName());
        customer.setSurname(enterSurName());
        customer.setStreet(enterStreet());
        customer.setStreetNumber(enterStreetNumber());
        customer.setPLZ(enterplzNumber());
        customer.setCity(enterCity());
        customerArrayList.add(customer);
        setWriter();
    }
    public  void disPlayBooking(){
        System.out.println("DISPLAY Customer Selected");
        System.out.println("-------------------------\n");
        for (int i = 0; i < customerArrayList.size(); i++) {
//            System.out.println("Customer ID: " + customerArrayList.get(i).getId());
//            System.out.println("Customer ID: " + bookingCinema.to.get(i).getCostumer());
            System.out.println("Customer Name: " + customerArrayList.get(i).getName());
            System.out.println("Customer Surname: " + customerArrayList.get(i).getSurname());
            System.out.println("Customer Street: " + customerArrayList.get(i).getStreet());
            System.out.println("Customer StreetNumber: " + customerArrayList.get(i).getStreetNumber());
            System.out.println("Customer PLZ: " + customerArrayList.get(i).getPlz());
            System.out.println("Customer City: " + customerArrayList.get(i).getCity());

            System.out.println("\n");
//            private int id;
//            private String name;
//            private String surname;
//            private String street;
//            private int streetNumber;
//            private int plz;
//            private String city;
        }
    }
    public void setWriter(){
        readerWriter.writeFile(customerArrayList,"customer.txt");
    }




    //private int id;
    //	private String name;
    //	private String surname;
    //	private String street;
    //	private int streetNumber;
    //	private int plz;
    //	private String city;

}

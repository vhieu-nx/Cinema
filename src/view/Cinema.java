package view;

import controller.*;
import model.Booking;
import model.Customer;
import model.Show;
import model.Theatre;

import java.util.*;

public class Cinema {
    static final AccountManager acountManager = AccountManager.getINSTANCE();
    static final BookingCinema bookingCinema = BookingCinema.getINSTANCE();
    static final TheatreManager theatreManager = TheatreManager.getINSTANCE();
    static final ShowManager showManager = ShowManager.getINSTANCE();
    static final CustomerManager customerManager = CustomerManager.getINSTANCE();


    public static void main(String[] args) {
        loginCinema();
    }
























    public static void loginCinema() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Cinema by Mr.Nguyen. \n Please login to perform the manager function. \nIf you don't have an account, please login to proceed. \nThanks so much");
        while (true) {
            System.out.println("1.Login");
            System.out.println("2.Registration");
            System.out.println("3.Exit");
            System.out.print("\nEnter Option: ");
            String chooseSelectOptionAccount = scanner.nextLine();
            switch (chooseSelectOptionAccount) {
                case "1":
                    if (!acountManager.loginAccount()) {

                        System.out.println("Login fails, username or password is incorrect");
                    } else {
                        System.out.println("Login successfully");
                        mainMenuCinema();
                    }
                    break;
                case "2":
                    acountManager.createAccount();
                    break;
                case "3":
                    System.exit(0);
                    break;
                default:
                    System.out.println("Pls select again");
            }
        }
    }

    private static void mainMenuCinema() {
        int option = 0;
        Scanner select = new Scanner(System.in);
        do {
            DisplayMenu.displayMenu();
            System.out.print("Enter Option: ");
            option = select.nextInt();
            if (option == 1) {
                theatreManager.addTheatre();
            }
            if (option == 2) {
                showManager.addShow();
            }
            if (option == 3) {
                showManager.disPlayShow();
            }
            if (option == 4) {
                bookingCinema.makeBooking();
            }
            if (option == 5) {
                bookingCinema.cancelBooking();
            }
            if (option == 6) {
                bookingCinema.disPlayBooking();
            }
            if (option == 8) {
                customerManager.createCustomer();
            }
            if (option == 9){
                customerManager.disPlayBooking();
            }
            if (option == 10) {
                System.exit(0);
            }
            // System.out.println("Please Enter 1 to Add Theatre");
            //        System.out.println("Please Enter 2 to Add Show");
            //        System.out.println("Please Enter 3 to Display Shows");
            //        System.out.println("Please Enter 4 to Make Booking");
            //        System.out.println("Please Enter 5 to Cancel Booking");
            //        System.out.println("Please Enter 6 to Display Booking");
            //        System.out.println("Please Enter 7 to reader file");
            //        System.out.println("Please Enter 8 to Customer add");
            //        System.out.println("Please Enter 9 to Customer show");
            //        System.out.println("Please Enter 10 to Exit \n");
        } while (true);
    }
}
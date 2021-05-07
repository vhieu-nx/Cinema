package view;

import controller.AccountManager;
import model.Booking;
import model.Customer;
import model.Show;
import model.Theatre;

import java.util.*;
	 
public class Cinema
{
	static final AccountManager acountManager = AccountManager.getINSTANCE();
	public static void main (String[] args) {
		mainMenuCinema();
	}

	public static void loginCinema(){
		Scanner scanner = new Scanner(System.in);
		System.out.println("Welcome to Cinema by Mr.Nguyen");
		while (true){
			System.out.println("1.Login");
			System.out.println("2.Registration");
			System.out.println("3.Exit");
			String chooseSelectOptionAccount = scanner.nextLine();
			switch (chooseSelectOptionAccount){
				case "1":
					if (!acountManager.loginAccount()){
						System.out.println("Login fails, username or password is incorrect");
					}else {
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
		ArrayList<Show >shows = new ArrayList<Show>();
		ArrayList<Theatre> theatres = new ArrayList<Theatre>();
		ArrayList<Booking> bookings = new ArrayList<Booking>();
		ArrayList<Customer> customers = new ArrayList<Customer>();
		Scanner select = new Scanner(System.in);
		Scanner choice = new Scanner(System.in);
		do
		{
			DisplayMenu.displayMenu();

			System.out.print("Enter Option: ");
				option = select.nextInt();
				if (option==1){
//					System.out.println(acountManager.getInformation());
					loginCinema();

				}
				if(option==3)
				{
					System.out.println("ADD THEATRE Selected");
					System.out.println("-------------------------\n");
					System.out.print("Enter a name for the theatre: \n");
					String theatreName = choice.nextLine();
					System.out.print("Enter a number for the theatre: \n");
					int theatreNumber = choice.nextInt();
					System.out.println("Enter the number of rows:");
					int rowCount = choice.nextInt();
					Theatre theatre = new Theatre(theatreNumber, theatreName);
					theatre.createRows(1, 10, rowCount);
					theatre.createRows(1, 5, 5);
					theatres.add(theatre);
				}

				if(option==4)
				{
					System.out.println("ADD SHOW Selected");
					System.out.println("-------------------------\n");
					System.out.println("Enter the date of the model.Show [DD/MM/YYYY]:");
					String showDate = new Scanner(System.in).nextLine();
					System.out.print("Enter name of model.Show: \n");
					String showName = new Scanner(System.in).nextLine();
					System.out.println("Select a theatre by typing the number:");
					for (int i=0; i < theatres.size(); i++)
					{
						System.out.println(i+1 + " " + theatres.get(i).getDescription());
					}
					int theatreNumber = choice.nextInt();
					shows.add(new Show(showName, showDate, theatres.get(theatreNumber-1)));
				}


				if(option==5)
				{
					System.out.println("DISPLAY SHOWS Selected");
					System.out.println("-------------------------\n");
					for (int i = 0; i < shows.size(); i++)
					{
						int showNumber = i+1;
						System.out.println("model.Show Number: " + showNumber);;
						System.out.println("model.Show Name: " + shows.get(i).getShowName());
						System.out.println("model.Show Date: " + shows.get(i).getShowDate());
						System.out.println("model.Seat Status:" + shows.get(i).getFreeSeatsCount());
						System.out.println("\n");
					}
					System.out.println("End of model.Show List.\n");
				}


				if(option==6)
				{
					System.out.println("MAKE BOOKING Selected");
					System.out.println("-------------------------\n");
					Random rnd = new Random();
					int costumerId = rnd.nextInt(999);
					Customer customer = new Customer(costumerId);
					customers.add(customer);
					for (int i = 0; i< shows.size(); i++)
					{
						int showNumber = i+1;
						System.out.println("model.Show Number: " + showNumber);;
						System.out.println("model.Show Name:   " + shows.get(i).getShowName());
						System.out.println("model.Show Date:   " + shows.get(i).getShowDate());
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
					System.out.println("Total costs: " + totalCost + " Euro");
					System.out.println();
				}

				if(option==7)
				{
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

									}
								}
							}
							System.out.println("Your reservation has been canceled!");
						}
					}
					System.out.println();
				}

				if(option==8)
				{
					System.exit(0);
				}

		  }while(true);
	}

}
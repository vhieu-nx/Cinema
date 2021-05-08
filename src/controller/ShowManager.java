package controller;

import model.Row;
import model.Show;
import model.Theatre;
import storage.ReaderWriter;

import java.util.ArrayList;
import java.util.Scanner;

public class ShowManager {
    private Show show;

    private ReaderWriter readerWriter = ReaderWriter.getINSTANCE();
    private ArrayList<Show> shows = readerWriter.readFile("show.txt");
    private ArrayList<Theatre> theatres = readerWriter.readFile("theatre.txt");
    private static ShowManager INSTANCE;
    private ShowManager(){

    }
    public static ShowManager getINSTANCE(){
        if (INSTANCE == null) INSTANCE = new ShowManager();
        return INSTANCE;
    }
    public void addShow (){
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
        int theatreNumber = new Scanner(System.in).nextInt();
        shows.add(new Show(showName, showDate, theatres.get(theatreNumber-1)));
        setWriter();
    }
    public  void disPlayShow(){
        System.out.println("DISPLAY SHOWS Selected");
        System.out.println("-------------------------\n");
        for (int i = 0; i < shows.size(); i++) {
            int showNumber = i + 1;
            System.out.println("Show Number: " + showNumber);
            ;
            System.out.println("Show Name: " + shows.get(i).getShowName());
            System.out.println("Show Date: " + shows.get(i).getShowDate());
//						System.out.println("model.Seat Status:" + shows.get(i).getFreeSeatsCount());
            System.out.println("\n");
        }
    }
    public void setWriter(){
        readerWriter.writeFile(shows,"show.txt");
    }
}

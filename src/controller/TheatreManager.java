package controller;

import model.Row;
import model.Theatre;
import storage.ReaderWriter;

import java.util.ArrayList;
import java.util.Scanner;

public class TheatreManager {
    private Theatre theatre;

    private ReaderWriter readerWriter = ReaderWriter.getINSTANCE();
    private ArrayList<Theatre> theatres = readerWriter.readFile("row.txt");
    private static TheatreManager INSTANCE;

    private TheatreManager() {

    }
    public static TheatreManager getINSTANCE() {
        if (INSTANCE == null) INSTANCE = new TheatreManager();
        return INSTANCE;
    }
    //    public void createRows(int rowClass, int seatCount, int rowCount)
//    {
//        for (int i = 1; i <= rowCount; i++)
//        {
//            row.add(new Row(rowClass, seatCount, i));
//        }
//        this.rowCount += rowCount;
//    }
    public  void addTheatre() {
        System.out.println("ADD THEATRE Selected");
        System.out.println("-------------------------\n");
        System.out.print("Enter a name for the theatre: \n");
        String theatreName = new Scanner(System.in).nextLine();
        System.out.print("Enter a number for the theatre: \n");
        int theatreNumber = new Scanner(System.in).nextInt();
        System.out.println("Enter the number of rows:");
        int rowCount = new Scanner(System.in).nextInt();
        Theatre theatre = new Theatre(theatreNumber, theatreName);
        theatre.createRows(1, 10, rowCount);
        theatre.createRows(1, 5, 5);
        theatres.add(theatre);
        setWriter();
    }
    public void setWriter() {
        readerWriter.writeFile(theatres, "theatre.txt");
    }
}

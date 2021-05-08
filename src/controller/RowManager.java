package controller;

import model.Account;
import model.Row;
import model.Seat;
import storage.ReaderWriter;

import java.util.ArrayList;

public class RowManager {
    static final ArrayList<Seat> seats = new ArrayList<>();
    private Row row;

    private ReaderWriter readerWriter = ReaderWriter.getINSTANCE();
    private ArrayList<Row> rowArrayList = readerWriter.readFile("row.txt");
    private static RowManager INSTANCE;
    private RowManager(){

    }
    public static RowManager getINSTANCE(){
        if (INSTANCE == null) INSTANCE = new RowManager();
        return INSTANCE;
    }
    public void createSeats(int seatCount)
    {
        for (int i = 1; i <= seatCount; i++)
        {
            seats.add(new Seat(false, i));
            setWriter();
        }
    }

    public void setWriter(){
        readerWriter.writeFile(rowArrayList,"row.txt");
    }

}

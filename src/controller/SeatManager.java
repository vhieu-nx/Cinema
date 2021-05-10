package controller;

import model.Row;
import model.Seat;
import storage.ReaderWriter;

import java.io.Serializable;
import java.util.ArrayList;

public class SeatManager implements Serializable {
    private Seat seat;

    private ReaderWriter readerWriter = ReaderWriter.getINSTANCE();
    private ArrayList<Seat> seatArrayList = readerWriter.readFile("seat.txt");
    private static SeatManager INSTANCE;
    private SeatManager(){

    }
    public static SeatManager getINSTANCE(){
        if (INSTANCE == null) INSTANCE = new SeatManager();
        return INSTANCE;
    }
    public void setWriter(){
        readerWriter.writeFile(seatArrayList,"seat.txt");
    }
}

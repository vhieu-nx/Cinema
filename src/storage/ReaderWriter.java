package storage;

import model.Booking;
import model.Customer;
import model.Show;
import org.w3c.dom.xpath.XPathResult;

import java.io.*;
import java.util.ArrayList;

public class ReaderWriter {
    private static  final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";
    public static final  String FILEPATH = "data/cinema.txt";
    File file = new File(FILEPATH);
    public void writeFile(ArrayList<Booking> bookings){
        try {
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (int i = 0; i <bookings.size() ; i++) {
                int cost = bookings.get(i).getCost();
                Customer customer = bookings.get(i).getCostumer();
                Show show  = bookings.get(i).getShow();
                int rowNumber = bookings.get(i).getRowNumber();
                int seatNumber = bookings.get(i).getSeatNumber();
                String line = cost + COMMA_DELIMITER + customer + COMMA_DELIMITER + show + COMMA_DELIMITER
                        + rowNumber + COMMA_DELIMITER + seatNumber + NEW_LINE_SEPARATOR;
                //int cost;
                //	Customer costumer;
                //	Show show;
                //	int rowNumber;
                //	int seatNumber;
                bufferedWriter.write(line);
            }
            bufferedWriter.close();
            fileWriter.close();
            System.out.println("Write File successfully");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public ArrayList<Booking> readFile() {
//        ArrayList<Contact> bookings = new ArrayList<>();
//
//        try {
//
//            FileInputStream fileIn = new FileInputStream(FILEPATH);
//            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
//
//            ArrayList<Contact> obj = (ArrayList<Contact>) objectIn.readObject();
//
//            System.out.println("The Object has been read from the file");
//            objectIn.close();
//            return obj;
//
//        } catch (Exception ex) {
//            ex.printStackTrace();
//            return bookings;
//        }
        ArrayList<Booking> bookings = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(FILEPATH);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                Booking booking = splitString(line);
                bookings.add(booking);
            }
            bufferedReader.close();
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bookings;
    }
    public static Booking splitString(String string) {
        ////int cost;
        //                //	Customer costumer;
        //                //	Show show;
        //                //	int rowNumber;
        //                //	int seatNumber;
        String[] splitData = string.split(COMMA_DELIMITER);
        int cost = Integer.parseInt(splitData[0]);

        Customer customer = splitData[1];
        Show show = splitData[2];
        int rowNumber = Integer.parseInt(splitData[3]);
        int seatNumber = Integer.parseInt(splitData[4]);

        Booking contact = new Booking(cost,customer,show,rowNumber,seatNumber);
        return contact;
    }


}

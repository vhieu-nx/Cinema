package storage;

import model.Booking;
import model.Customer;
import model.Show;
import org.w3c.dom.xpath.XPathResult;

import java.io.*;
import java.util.ArrayList;

public class ReaderWriter<E> {
    private static ReaderWriter INSTANCE;
    private ReaderWriter(){

    }
    public static ReaderWriter getINSTANCE(){
        if (INSTANCE == null) INSTANCE = new ReaderWriter();
        return INSTANCE;
    }
    public void writeFile(ArrayList<E> arrayList,String path){
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(path);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(arrayList);

            objectOutputStream.close();
            sleep();
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public ArrayList<E> readFile(String path){
        ArrayList<E> arrayList = new ArrayList<>();
        File file = new File(path);
        if (file.length() > 0){
            try {
                FileInputStream fileInputStream = new FileInputStream(path);
                ObjectInputStream objectInputStream  = new ObjectInputStream(fileInputStream);
                arrayList = (ArrayList<E>) objectInputStream.readObject();
                objectInputStream.close();
                sleep();
                fileInputStream.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return arrayList;
    }
    private void sleep() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}

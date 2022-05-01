package view;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class test {
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args){
        String date;
        do{
            System.out.println("Enter date: ");
            date = input.nextLine();
        }while(!checkDate(date));
    }

    public static boolean checkDate(String dateStr){
        try{
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            Date date = dateFormat.parse(dateStr);
            System.out.println(date);
            System.out.println(dateFormat.format(date));
            return true;
        }
        catch (ParseException e){
            System.err.println("something goes wrong! check date format please, bitch!");
            return false;
        }

    }
}

package utils;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

public class Valid {
    static Scanner scanner = new Scanner(System.in);
    public static final String SERVICECODE_REGEX = "^SV(VL|HO|RO)\\-\\d{4}$";
    public static final String SERVICENAME_REGEX = "^[A-Z][a-z]+$";
    public static final String AREAOFPOOLANDAREAUSE_REGEX = "^[3-9][0-9]{1,2}\\.+\\d+$";
    public static final String FEERENT_REGEX = "^[1-9]\\d+$";
    public static final String MAXIMUMPERSON_REGEX = "^[1-9]{1}$|[1][0-9]{1}$";
    public static final String NUMBERFLOOR_REGEX ="^[1-9]$";
    public static final String TYPEOFRENT_REGEX = "^[A-Z][a-z]+$";
    public static final String ROOMSTANDARD_REGEX = "^[A-Z][a-z]+$";
    public static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");

    public void checkBirthdayInput(String dobString){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dob = LocalDate.parse(dobString, dateTimeFormatter);
        LocalDate currentDate = LocalDate.now();
        Period p = Period.between(dob, currentDate);
    }

    public static Date checkValidDate(String dateStr){
        try{
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            return dateFormat.parse(dateStr);
        }
        catch (ParseException e){
            return null;
        }
    }

    public static boolean validInput(String input, String valid){
        return input.matches(valid);
    }

}

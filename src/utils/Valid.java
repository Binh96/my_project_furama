package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Valid {
    private static final String SERVICECODE_REGEX = "^SV(VL|HO|RO)\\-\\d{4}$";
    private static final String SERVICENAME_REGEX = "^[A-Z][a-z]+$";
    private static final String AREAOFPOOLANDAREAUSE_REGEX = "^[3-9][0-9]{1,2}\\.+\\d+$";
    private static final String FEERENT_REGEX = "^[1-9]\\d+$";
    private static final String MAXIMUMPERSON_REGEX = "^[1-9]{1}$|[1][0-9]{1}$";
    private static final String NUMBERFLOOR_REGEX ="^[1-9]$";
    private static final String TYPEOFRENT_REGEX = "^[A-Z][a-z]+$";
    private static final String ROOMSTANDARD_REGEX = "^[A-Z][a-z]+$";
    private static final String DATE_REGEX = "";
    private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");

    public void checkBirthdayInput(String dobString){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dob = LocalDate.parse(dobString, dateTimeFormatter);
        LocalDate currentDate = LocalDate.now();
        Period p = Period.between(dob, currentDate);
//        try{
//
//        }catch (){
//            System.out.println(e.getMessage());
//        }
    }

    public static Date checkValidDate(String dateStr){
        Date date = null;
        try {
            date = simpleDateFormat.parse(dateStr);
            return date;
        } catch (ParseException e) {
            System.err.println("Wrong format date");
        }
        return null;
    }
}

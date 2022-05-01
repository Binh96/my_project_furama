package services.impl;

import modules.Employee;
import utils.ReadFiles;
import utils.Valid;
import utils.WriteFiles;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class IEmployeeServiceImpl {
    static Scanner input = new Scanner(System.in);
    static List<Employee> employeeList = new ArrayList<>();
    static String path = "E:\\WorkSpace\\LearnJava\\project\\furama_manage\\src\\services\\impl\\employee.csv";
    static {
        String dateStr;
        Date date;
        do{
            System.out.println("Enter date: ");
            dateStr = input.nextLine();
            try {
                date = new SimpleDateFormat("dd-MM-yyyy").parse(dateStr);
                Employee employee1 = new Employee("Phan Xuan Binh", date, "male", "201744651", "0764648390", "abc@yahoo.com", "C0222G2", "College", "Leader", 2000000L);
                Employee employee2 = new Employee("Dang Ngoc Giuc", date, "male", "201744651", "0764648390", "abc@yahoo.com", "C0222G2", "College", "Leader", 2000000L);
                Employee employee3 = new Employee("Phan Xuan Binh", date, "male", "201744651", "0764648390", "abc@yahoo.com", "C0222G2", "College", "Leader", 2000000L);
                employeeList.add(employee1);
                employeeList.add(employee2);
                employeeList.add(employee3);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }while(!Valid.checkValidDate(dateStr));
        WriteFiles.writeToFileEmployee(path, employeeList);
    }
    public static void display(){
        System.out.println(ReadFiles.readFile("E:\\WorkSpace\\LearnJava\\project\\furama_manage\\src\\services\\impl\\employee.csv"));
    }
}

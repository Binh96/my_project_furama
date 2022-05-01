package services.impl;

import modules.Employee;
import utils.Valid;
import utils.WriteFiles;

import java.util.ArrayList;
import java.util.List;

public class IEmployeeServiceImpl {
    static List<Employee> employeeList = new ArrayList<>();
    static String path = "E:\\WorkSpace\\LearnJava\\project\\furama_manage\\src\\services\\impl\\employee.csv";
    static {
        String date = "17-11-1996";
        Valid.checkValidDate(date);
        Employee employee1 = new Employee("Phan Xuan Binh", date, "male", "201744651", "0764648390", "abc@yahoo.com", "C0222G2", "College", "Leader", 2000000L);
        Employee employee2 = new Employee("Dang Ngoc Giuc", date, "male", "201744651", "0764648390", "abc@yahoo.com", "C0222G2", "College", "Leader", 2000000L);
        Employee employee3 = new Employee("Phan Xuan Binh", date, "male", "201744651", "0764648390", "abc@yahoo.com", "C0222G2", "College", "Leader", 2000000L);
        employeeList.add(employee1);
        employeeList.add(employee2);
        employeeList.add(employee3);
        WriteFiles.writeToFileEmployee(path, employeeList);
    }

    public static void display(){
        for(Employee list : employeeList){
            System.out.println(list);
        }
    }
}

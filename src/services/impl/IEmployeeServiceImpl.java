package services.impl;

import modules.Employee;
import services.IEmployeeService;
import utils.ReadFiles;
import utils.Valid;
import utils.WriteFiles;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class IEmployeeServiceImpl implements IEmployeeService {
    static Scanner input = new Scanner(System.in);
    static List<Employee> employeeList = new ArrayList<>();
    static String path = "E:\\WorkSpace\\LearnJava\\project\\furama_manage\\src\\utils\\data\\employee.csv";

//    static {
//        Date date = new Date();
//        Employee employee1 = new Employee("Phan Xuan Binh", date, "male", "201744651", "0764648390", "abc@yahoo.com", "C0222G2", "College", "Leader", 2000000L);
//        Employee employee2 = new Employee("Dang Ngoc Giuc", date, "male", "132312312", "0764648390", "abc@yahoo.com", "C0222G2", "College", "Leader", 2000000L);
//        Employee employee3 = new Employee("Jonny Dang Lee", date, "male", "869695953", "0764648390", "abc@yahoo.com", "C0222G2", "College", "Leader", 2000000L);
//        employeeList.add(employee1);
//        employeeList.add(employee2);
//        employeeList.add(employee3);
//        WriteFiles.writeToFileEmployee(path, employeeList);
//    }

    public void display(){
        employeeList = ReadFiles.readFileEmployee(path);
        if(!employeeList.isEmpty()){
            for(Employee employee: employeeList){
                System.out.println(employee);
            }
        }
        else{
            System.out.println("Didn't have any employee!");
        }

    }

    public void add(){
        employeeList = ReadFiles.readFileEmployee(path);
        System.out.print("Enter employee name:");
        String name = input.nextLine();
        System.out.print("Enter date of birth: ");
        String dateStr = input.nextLine();
        Date date = Valid.checkValidDate(dateStr);
        System.out.print("Enter gender: ");
        String gender = input.nextLine();
        System.out.print("Enter id: ");
        String id = input.nextLine();
        System.out.print("Enter phone number: ");
        String phoneNumber = input.nextLine();
        System.out.print("Enter email: " );
        String email = input.nextLine();
        System.out.print("Enter employee code: ");
        String employeeCode = input.nextLine();
        String level = listLevelEmployee();
        String position = listPositionEmployee();
        System.out.print("Enter salary: ");
        Long salary = Long.parseLong(input.nextLine());
        Employee employee = new Employee(name, date, gender, id, phoneNumber, email, employeeCode, level, position, salary);
        employeeList.add(employee);
        WriteFiles.writeToFileEmployee(path, employeeList);
    }

    public void edit(){
        employeeList = ReadFiles.readFileEmployee(path);
        boolean check = true;
        displayId();
        System.out.print("Choose ID employee: ");
        String id = input.nextLine();
        for(Employee employee : employeeList){
            if(!employee.getId().equals(id)){
                check = false;
            }
            else{
                boolean flag = true;
                do{
                    System.out.print("Choose part you want to change: ");
                    String editPart = input.nextLine();
                    switch (editPart){
                        case "name" -> {
                            System.out.print("Edit name: ");
                            String name = input.nextLine();
                            employee.setName(name);
                            WriteFiles.writeToFileEmployee(path, employeeList);
                        }
                        case "dob" -> {
                            System.out.print("Edit day of birth: ");
                            String dayOfBirth = input.nextLine();
                            employee.setDateOfBirth(Valid.checkValidDate(dayOfBirth));
                            WriteFiles.writeToFileEmployee(path, employeeList);
                        }
                        case "gender" -> {
                            System.out.print("Edit gender: ");
                            String gender = input.nextLine();
                            employee.setGender(gender);
                            WriteFiles.writeToFileEmployee(path, employeeList);
                        }
                        case "id" -> {
                            System.out.print("Edit id: ");
                            String id2 = input.nextLine();
                            employee.setId(id2);
                            WriteFiles.writeToFileEmployee(path, employeeList);
                        }
                        case "phone" -> {
                            System.out.print("Edit phone: ");
                            String phone = input.nextLine();
                            employee.setPhoneMobile(phone);
                            WriteFiles.writeToFileEmployee(path, employeeList);
                        }
                        case "email" -> {
                            System.out.print("Edit email: ");
                            String email = input.nextLine();
                            employee.setEmail(email);
                            WriteFiles.writeToFileEmployee(path, employeeList);
                        }
                        case "idstaff" -> {
                            System.out.print("Edit id staff: ");
                            String employeeCode = input.nextLine();
                            employee.setEmployeeCode(employeeCode);
                            WriteFiles.writeToFileEmployee(path, employeeList);
                        }
                        case "level" -> {
                            System.out.print("Edit level: ");
                            String level = input.nextLine();
                            employee.setLevel(level);
                            WriteFiles.writeToFileEmployee(path, employeeList);
                        }
                        case "position" -> {
                            System.out.print("Edit position: ");
                            String position = input.nextLine();
                            employee.setPosition(position);
                            WriteFiles.writeToFileEmployee(path, employeeList);
                        }
                        case "salary" -> {
                            System.out.print("Edit id salary: ");
                            Long salary = Long.parseLong(input.nextLine());
                            employee.setSalary(salary);
                            WriteFiles.writeToFileEmployee(path, employeeList);
                        }
                        default -> {
                            System.out.println("You has been disconnected");
                            flag = false;
                        }
                    }
                }while (flag);
                break;
            }
        }
        if(!check){
            System.out.println("Sorry dude !! the one you want to edit doesn't exist");
        }
    }

    public void displayId(){
        List<Employee> stringList = ReadFiles.readFileEmployee("E:\\WorkSpace\\LearnJava\\project\\furama_manage\\src\\utils\\data\\employee.csv");
        for(Employee employee: stringList){
            System.out.println("Name employee: "+employee.getName()+", ID employee: "+ employee.getId());
        }
    }

    public String listLevelEmployee(){
        System.out.println("""
                            ---- List level------
                           1. Intermediate
                           2. Colleges
                           3. University
                           4. After University
                """);
        System.out.print("Choose level: ");
        int num = Integer.parseInt(input.nextLine());
        return chooseLevel(num);
    }

    public String chooseLevel(int num){
        String level="";
        switch (num){
            case 1 -> level = "Intermediate";
            case 2 -> level = "Colleges";
            case 3 -> level = "University";
            case 4 -> level = "After University";
            default -> System.out.println("doesn't exist in list");
        }
        return level;
    }

    public String listPositionEmployee(){
        System.out.println("""
                            ---- List position------
                           1. Reception
                           2. Service
                           3. Expert
                           4. Supervisor
                           5. Manager
                           6. Director
                """);
        System.out.print("Choose position: ");
        int num = Integer.parseInt(input.nextLine());
        return choosePosition(num);
    }

    public String choosePosition(int num){
        String position="";
        switch (num){
            case 1 -> position = "Reception";
            case 2 -> position = "Service";
            case 3 -> position = "Expert";
            case 4 -> position = "Supervisor";
            case 5 -> position = "Manager";
            case 6 -> position = "Director";
            default -> System.out.println("doesn't exist in list");
        }
        return position;
    }
}

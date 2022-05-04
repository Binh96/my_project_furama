package services.impl;

import modules.Customer;
import services.ICustomerService;
import utils.ReadFiles;
import utils.Valid;
import utils.WriteFiles;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class ICustomerServiceImpl implements ICustomerService {
    static List<Customer> customerList = new ArrayList<>();
    static Scanner input = new Scanner(System.in);
    static String path = "E:\\WorkSpace\\LearnJava\\project\\furama_manage\\src\\utils\\data\\customer.csv";

//    static{
//        Date date = new Date();
//
//        Customer customer1 = new Customer("Henry Bath", date, "male", "1231323123", "09876542123", "sdadad@dadadad.com", "C9090", "Diamond", "DN");
//        Customer customer2 = new Customer("Jessy Kai", date, "female", "1223114563", "098763123123", "sdadad@vbvadadad.com", "C92390", "Gold", "UK");
//        Customer customer3 = new Customer("Gary Kittie", date, "female", "6753123", "09876542123", "sdadad@dadadad.com", "C5670", "Diamond", "DN");
//
//        customerList.add(customer1);
//        customerList.add(customer2);
//        customerList.add(customer3);
//
//        WriteFiles.writeToFileCustomer(path, customerList);
//    }

    @Override
    public String typeOfCustomer() {
        System.out.println("""
                ---- List type customer ----
                1. Diamond
                2. Platinium
                3. Gold
                4. Silver
                5. Member
                """);
        System.out.print("Choose customer type: ");
        int num = Integer.parseInt(input.nextLine());
        return chooseCustomerType(num);
    }

    public String chooseCustomerType(int num){
        String str ="";
        switch (num){
            case 1 -> str = "Diamond";
            case 2 -> str = "Platinium";
            case 3 -> str = "Gold";
            case 4 -> str = "Silver";
            case 5 -> str = "Member";
            default -> System.out.println("doesn't exist");
        }
        return str;
    }

    @Override
    public void add() {
        ReadFiles.readFile(path);
        System.out.print("Enter customer name:");
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
        System.out.print("Enter customer code: ");
        String customerCode = input.nextLine();
        String customerType = typeOfCustomer();
        System.out.print("Enter address: ");
        String address = input.nextLine();
        Customer customer = new Customer(name, date, gender, id, phoneNumber, email, customerCode, customerType, address);
        customerList.add(customer);
        WriteFiles.writeToFileCustomer(path, customerList);
    }

    @Override
    public void display() {
        List<Customer> customers = ReadFiles.readFileCustomer(path);
        for(Customer customer: customers){
            if(customers.isEmpty()){
                System.out.println("Didn't have any customer!");
            }
            else{
                System.out.println(customer);
            }
        }
    }

    public void displayIdCustomer(){
        List<Customer> customers = ReadFiles.readFileCustomer(path);
        for(Customer customer: customers){
            if(customers.isEmpty()){
                System.out.println("Didn't have any customer!");
            }
            else{
                System.out.println("Name: "+ customer.getName()+", Id: "+customer.getId());
            }
        }
    }

    @Override
    public void edit() {
        boolean check = true;
        displayIdCustomer();
        System.out.print("Choose ID employee: ");
        String id = input.nextLine();
        for(Customer customer : customerList){
            if(!customer.getId().equals(id)){
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
                            customer.setName(name);
                            WriteFiles.writeToFileCustomer(path, customerList);
                        }
                        case "dob" -> {
                            System.out.print("Edit day of birth: ");
                            String dayOfBirth = input.nextLine();
                            customer.setDateOfBirth(Valid.checkValidDate(dayOfBirth));
                            WriteFiles.writeToFileCustomer(path, customerList);
                        }
                        case "gender" -> {
                            System.out.print("Edit gender: ");
                            String gender = input.nextLine();
                            customer.setGender(gender);
                            WriteFiles.writeToFileCustomer(path, customerList);
                        }
                        case "id" -> {
                            System.out.print("Edit id: ");
                            String id2 = input.nextLine();
                            customer.setId(id2);
                            WriteFiles.writeToFileCustomer(path, customerList);
                        }
                        case "phone" -> {
                            System.out.print("Edit phone: ");
                            String phone = input.nextLine();
                            customer.setPhoneMobile(phone);
                            WriteFiles.writeToFileCustomer(path, customerList);
                        }
                        case "email" -> {
                            System.out.print("Edit email: ");
                            String email = input.nextLine();
                            customer.setEmail(email);
                            WriteFiles.writeToFileCustomer(path, customerList);
                        }
                        case "customertype" -> {
                            System.out.print("Edit customer type: ");
                            String customerType = typeOfCustomer();
                            customer.setCustomerType(customerType);
                            WriteFiles.writeToFileCustomer(path, customerList);
                        }
                        case "customercode" -> {
                            System.out.print("Edit customer code:  ");
                            String customerCode = input.nextLine();
                            customer.setCustomerCode(customerCode);
                            WriteFiles.writeToFileCustomer(path, customerList);
                        }
                        case "address" -> {
                            System.out.print("Edit address: ");
                            String address = input.nextLine();
                            customer.setAddress(address);
                            WriteFiles.writeToFileCustomer(path, customerList);
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
}

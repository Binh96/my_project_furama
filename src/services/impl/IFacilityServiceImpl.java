package services.impl;

import modules.*;
import services.IFacilityService;
import utils.ReadFiles;
import utils.Valid;
import utils.WriteFiles;
import java.util.*;

public class IFacilityServiceImpl implements IFacilityService {
    static Scanner input = new Scanner(System.in);
    static String pathHouse = "E:\\WorkSpace\\LearnJava\\project\\furama_manage\\src\\utils\\data\\house.csv";
    static String pathVilla = "E:\\WorkSpace\\LearnJava\\project\\furama_manage\\src\\utils\\data\\villa.csv";
    static String pathRoom = "E:\\WorkSpace\\LearnJava\\project\\furama_manage\\src\\utils\\data\\room.csv";
    Map<Facility, Integer> facilityIntegerMap = new LinkedHashMap<>();
    List<Facility> maintainFacility = new ArrayList<>();
    List<House> houseList = new ArrayList<>();
    List<Villa> villaList = new ArrayList<>();
    List<Room> roomList = new ArrayList<>();

    public void addMap(Facility facility){
        Set<Facility> facilityKey = facilityIntegerMap.keySet();
        if(facilityIntegerMap.isEmpty()){
            facilityIntegerMap.put(facility, 1);
        }
        else{
            boolean flag = true;
            for(Facility key: facilityKey){
                if(facility.equals(key)){
                    updateMaintain(key);
                    facilityIntegerMap.put(key, facilityIntegerMap.get(key) + 1);
                    flag = false;
                    break;
                }
            }
            if(flag){
                facilityIntegerMap.put(facility, 1);
            }
        }
    }

    @Override
    public void add() {

    }

    @Override
    public void display() {
//        System.out.println("Facility Villa: ");
//        List<String> villas = ReadFiles.readFile(pathVilla);
//        for(String villa : villas){
//            System.out.println(villa);
//        }
//        System.out.println("Facility House: ");
//        List<House> houses = ReadFiles.readFileHouse(pathHouse);
//        for(House house: houses){
//            if(houses.isEmpty()){
//                System.out.println("Didn't have any house!");
//            }
//            else{
//                System.out.println(house);
//            }
//        }
//        System.out.println("Facility Room: ");
//        List<String> rooms = ReadFiles.readFile(pathRoom);
//        for(String room : rooms){
//            System.out.println(room);
//        }
    }

    public void displayMaintain(){
        for(Map.Entry<Facility, Integer> facility : facilityIntegerMap.entrySet()){
            if(facility.getValue() <=5){
                System.out.println(facility.getKey().getServiceName()+": "+facility.getValue());
            }
        }
    }

    public void updateMaintain(Facility facility){
        if(facilityIntegerMap.get(facility) >= 5){
            maintainFacility.add(facility);
            System.out.println("Service is maintained");
            facilityIntegerMap.put(facility, 0);
        }
    }

    public String typeOfRent(){
        System.out.println("""
                --- Type of rent ----
                1. Year
                2. Month
                3. Day
                4. Hours
                """);
        System.out.print("Enter type of rent: ");
        int num = Integer.parseInt(input.nextLine());
        return chooseTypeOfRent(num);
    }

    public String chooseTypeOfRent(int num){
        String str ="";
        switch (num){
            case 1 -> str = "Year";
            case 2 -> str = "Month";
            case 3 -> str = "Day";
            case 4 -> str = "Hours";
            default -> System.out.println("doesn't exist this type");
        }
        return str;
    }

    @Override
    public void edit() {

    }

    public void addNewHouse(){
        ReadFiles.readFile("E:\\WorkSpace\\LearnJava\\project\\furama_manage\\src\\utils\\files\\house.csv");

        System.out.print("Enter service code: ");
        String serviceCode = input.nextLine();
        while(!Valid.validInput(serviceCode, Valid.SERVICECODE_REGEX)){
            System.out.println("Try again! this time check carefully.");
            System.out.print("Enter again: ");
            serviceCode = input.nextLine();
        }
        System.out.print("Enter name service: ");
        String nameService = input.nextLine();
        while(!Valid.validInput(nameService, Valid.SERVICENAME_REGEX)){
            System.out.println("Try again! this time check carefully.");
            System.out.print("Enter again: ");
            nameService = input.nextLine();
        }
        System.out.print("Enter area used: ");
        Double areaUse = Double.parseDouble(input.nextLine());
        while(!Valid.validInput(String.valueOf(areaUse), Valid.AREAOFPOOLANDAREAUSE_REGEX)){
            System.out.println("Try again! this time check carefully.");
            System.out.print("Enter again: ");
            areaUse = Double.parseDouble(input.nextLine());
        }
        System.out.print("Enter fee for rent: ");
        Integer feeRent = Integer.parseInt(input.nextLine());
        while(!Valid.validInput(String.valueOf(feeRent), Valid.FEERENT_REGEX)){
            System.out.println("Try again! this time check carefully.");
            System.out.print("Enter again: ");
            feeRent = Integer.parseInt(input.nextLine());
        }
        System.out.print("Enter maximum person: ");
        Integer maxPerson = Integer.parseInt(input.nextLine());
        while(!Valid.validInput(String.valueOf(maxPerson), Valid.MAXIMUMPERSON_REGEX)){
            System.out.println("Try again! this time check carefully.");
            System.out.print("Enter again: ");
            maxPerson = Integer.parseInt(input.nextLine());
        }
        String typeOfRent = typeOfRent();
        while(!Valid.validInput(typeOfRent, Valid.TYPEOFRENT_REGEX)){
            System.out.println("Try again! this time check carefully.");
            System.out.print("Enter again: ");
            typeOfRent = typeOfRent();
        }
        System.out.print("Enter standard room: ");
        String standardRoom = input.nextLine();
        while(!Valid.validInput(standardRoom, Valid.ROOMSTANDARD_REGEX)){
            System.out.println("Try again! this time check carefully.");
            System.out.print("Enter again: ");
            standardRoom = input.nextLine();
        }
        System.out.print("Enter number floor: ");
        Integer numberOfFloor = Integer.parseInt(input.nextLine());
        while(!Valid.validInput(String.valueOf(numberOfFloor), Valid.NUMBERFLOOR_REGEX)){
            System.out.println("Try again! this time check carefully.");
            System.out.print("Enter again: ");
            numberOfFloor = Integer.parseInt(input.nextLine());
        }

        House house = new House(serviceCode, nameService, areaUse, feeRent, maxPerson, typeOfRent, standardRoom, numberOfFloor);
        Facility facility = new House(serviceCode, nameService, areaUse, feeRent, maxPerson, typeOfRent, standardRoom, numberOfFloor);
        houseList.add(house);
        this.addMap(facility);

        WriteFiles.writeToFileHouse(pathHouse, houseList);
    }

    public void addNewVilla(){
        ReadFiles.readFile("E:\\WorkSpace\\LearnJava\\project\\furama_manage\\src\\utils\\files\\house.csv");

        System.out.print("Enter service code: ");
        String serviceCode = input.nextLine();
        while(!Valid.validInput(serviceCode, Valid.SERVICECODE_REGEX)){
            System.out.println("Try again! this time check carefully.");
            System.out.print("Enter again: ");
            serviceCode = input.nextLine();
        }
        System.out.print("Enter name service: ");
        String nameService = input.nextLine();
        while(!Valid.validInput(nameService, Valid.SERVICENAME_REGEX)){
            System.out.println("Try again! this time check carefully.");
            System.out.print("Enter again: ");
            nameService = input.nextLine();
        }
        System.out.print("Enter area used: ");
        Double areaUse = Double.parseDouble(input.nextLine());
        while(!Valid.validInput(String.valueOf(areaUse), Valid.AREAOFPOOLANDAREAUSE_REGEX)){
            System.out.println("Try again! this time check carefully.");
            System.out.print("Enter again: ");
            areaUse = Double.parseDouble(input.nextLine());
        }
        System.out.print("Enter fee for rent: ");
        Integer feeRent = Integer.parseInt(input.nextLine());
        while(!Valid.validInput(String.valueOf(feeRent), Valid.FEERENT_REGEX)){
            System.out.println("Try again! this time check carefully.");
            System.out.print("Enter again: ");
            feeRent = Integer.parseInt(input.nextLine());
        }
        System.out.print("Enter maximum person: ");
        Integer maxPerson = Integer.parseInt(input.nextLine());
        while(!Valid.validInput(String.valueOf(maxPerson), Valid.MAXIMUMPERSON_REGEX)){
            System.out.println("Try again! this time check carefully.");
            System.out.print("Enter again: ");
            maxPerson = Integer.parseInt(input.nextLine());
        }
        String typeOfRent = typeOfRent();
        while(!Valid.validInput(typeOfRent, Valid.TYPEOFRENT_REGEX)){
            System.out.println("Try again! this time check carefully.");
            System.out.print("Enter again: ");
            typeOfRent = typeOfRent();
        }
        System.out.print("Enter standard room: ");
        String standardRoom = input.nextLine();
        while(!Valid.validInput(standardRoom, Valid.ROOMSTANDARD_REGEX)){
            System.out.println("Try again! this time check carefully.");
            System.out.print("Enter again: ");
            standardRoom = input.nextLine();
        }
        System.out.print("Enter number floor: ");
        Integer numberOfFloor = Integer.parseInt(input.nextLine());
        while(!Valid.validInput(String.valueOf(numberOfFloor), Valid.NUMBERFLOOR_REGEX)){
            System.out.println("Try again! this time check carefully.");
            System.out.print("Enter again: ");
            numberOfFloor = Integer.parseInt(input.nextLine());
        }
        System.out.print("Enter area pool: ");
        Integer areaPool = Integer.parseInt(input.nextLine());
        while(!Valid.validInput(String.valueOf(areaPool), Valid.AREAOFPOOLANDAREAUSE_REGEX)){
            System.out.println("Try again! this time check carefully.");
            System.out.print("Enter again: ");
            areaPool = Integer.parseInt(input.nextLine());
        }

        Villa villa = new Villa(serviceCode, nameService, areaUse, feeRent, maxPerson, typeOfRent, standardRoom, areaPool, numberOfFloor);
        Facility facility = new Villa(serviceCode, nameService, areaUse, feeRent, maxPerson, typeOfRent, standardRoom, areaPool, numberOfFloor);
        villaList.add(villa);
        this.addMap(facility);
        WriteFiles.writeToFileVilla(pathVilla, villaList);
    }

    public void addNewRoom(){
        ReadFiles.readFile("E:\\WorkSpace\\LearnJava\\project\\furama_manage\\src\\utils\\files\\house.csv");

        System.out.print("Enter service code: ");
        String serviceCode = input.nextLine();
        while(!Valid.validInput(serviceCode, Valid.SERVICECODE_REGEX)){
            System.out.println("Try again! this time check carefully.");
            System.out.print("Enter again: ");
            serviceCode = input.nextLine();
        }
        System.out.print("Enter name service: ");
        String nameService = input.nextLine();
        while(!Valid.validInput(nameService, Valid.SERVICENAME_REGEX)){
            System.out.println("Try again! this time check carefully.");
            System.out.print("Enter again: ");
            nameService = input.nextLine();
        }
        System.out.print("Enter area used: ");
        Double areaUse = Double.parseDouble(input.nextLine());
        while(!Valid.validInput(String.valueOf(areaUse), Valid.AREAOFPOOLANDAREAUSE_REGEX)){
            System.out.println("Try again! this time check carefully.");
            System.out.print("Enter again: ");
            areaUse = Double.parseDouble(input.nextLine());
        }
        System.out.print("Enter fee for rent: ");
        Integer feeRent = Integer.parseInt(input.nextLine());
        while(!Valid.validInput(String.valueOf(feeRent), Valid.FEERENT_REGEX)){
            System.out.println("Try again! this time check carefully.");
            System.out.print("Enter again: ");
            feeRent = Integer.parseInt(input.nextLine());
        }
        System.out.print("Enter maximum person: ");
        Integer maxPerson = Integer.parseInt(input.nextLine());
        while(!Valid.validInput(String.valueOf(maxPerson), Valid.MAXIMUMPERSON_REGEX)){
            System.out.println("Try again! this time check carefully.");
            System.out.print("Enter again: ");
            maxPerson = Integer.parseInt(input.nextLine());
        }
        String typeOfRent = typeOfRent();
        while(!Valid.validInput(typeOfRent, Valid.TYPEOFRENT_REGEX)){
            System.out.println("Try again! this time check carefully.");
            System.out.print("Enter again: ");
            typeOfRent = typeOfRent();
        }
        System.out.print("Enter free service: ");
        String freeService = input.nextLine();
        while(!Valid.validInput(String.valueOf(freeService), Valid.TYPEOFRENT_REGEX)){
            System.out.println("Try again! this time check carefully.");
            System.out.print("Enter again: ");
            freeService = input.nextLine();
        }

        Room room = new Room(serviceCode, nameService, areaUse, feeRent, maxPerson, typeOfRent, freeService);
        Facility facility = new Room(serviceCode, nameService, areaUse, feeRent, maxPerson, typeOfRent, freeService);
        roomList.add(room);
        this.addMap(facility);
        WriteFiles.writeToFileRoom(pathRoom, roomList);
    }

    public void addMenuService(){
        boolean flag = true;
        do{
            System.out.println("""
                ----- Menu service -----
                1. Add new house
                2. Add new villa
                3. Add new room
                """);
            System.out.print("Choose add service: ");
            int num = Integer.parseInt(input.nextLine());
            switch (num){
                case 1 -> addNewHouse();
                case 2 -> addNewVilla();
                case 3 -> addNewRoom();
                case 4 -> {
                    System.out.println("Return menu add service");
                    flag = false;
                }
                default ->{
                    System.out.println("It's not an option");
                }
            }
        }while(flag);
    }
}

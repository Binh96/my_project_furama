package utils;

import modules.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class WriteFiles {
    public static void writeToFile(String path, List<String> list){
        try{
            FileWriter fw = new FileWriter(path);
            BufferedWriter bw = new BufferedWriter(fw);
            for (String s : list) {
                bw.write(s);
                bw.newLine();
            }
            bw.close();
            fw.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void writeToFileEmployee(String path, List<Employee> list){
        List<String> employeeStringList = new ArrayList<>();
        for(Employee eList : list){
            employeeStringList.add(String.valueOf(eList));
        }
        writeToFile(path, employeeStringList);
    }

    public static void writeToFileCustomer(String path, List<Customer> list){
        List<String> customerStringList = new ArrayList<>();
        for(Customer customer : list){
            customerStringList.add(String.valueOf(customer));
        }
        writeToFile(path, customerStringList);
    }

    public static void writeToFileHouse(String path, List<House> list){
        List<String> houseStringList = new ArrayList<>();
        for(House house : list){
            houseStringList.add(String.valueOf(house));
        }
        writeToFile(path, houseStringList);
    }

    public static void writeToFileVilla(String path, List<Villa> list){
        List<String> villaStringList = new ArrayList<>();
        for(Villa villa : list){
            villaStringList.add(String.valueOf(villa));
        }
        writeToFile(path, villaStringList);
    }

    public static void writeToFileRoom(String path, List<Room> list){
        List<String> roomStringList = new ArrayList<>();
        for(Room room : list){
            roomStringList.add(String.valueOf(room));
        }
        writeToFile(path, roomStringList);
    }

    public static void writeMapToFile(String path, Map<Facility, Integer> map){
        try{
            FileWriter fw = new FileWriter(path);
            BufferedWriter bw = new BufferedWriter(fw);
            for (Map.Entry<Facility, Integer> mapEntry : map.entrySet()) {
                bw.write(mapEntry.getKey().getServiceName()+": "+mapEntry.getValue());
                bw.newLine();
            }
            bw.close();
            fw.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }

}

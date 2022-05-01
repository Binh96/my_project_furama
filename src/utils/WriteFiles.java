package utils;

import modules.Employee;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
}

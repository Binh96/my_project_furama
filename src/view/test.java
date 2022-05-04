package view;
import java.util.Arrays;
import java.util.Scanner;

public class test {
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        String str = "Phan-Xuan- Binh";
        String[] arr = str.split("- ");
        System.out.println(Arrays.toString(arr));
    }
}

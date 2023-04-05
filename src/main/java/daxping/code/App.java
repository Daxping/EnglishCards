package daxping.code;


import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Укажите путь к файлу \"xlsx\":");
        String pathToFile = scanner.nextLine().replace("\"","");
        System.out.println(ReadExcel.xlsxToMap(pathToFile));
        scanner.close();
    }
}
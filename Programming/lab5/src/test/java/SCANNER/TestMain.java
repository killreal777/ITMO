package SCANNER;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.Stack;

public class TestMain {
    public static void main(String[] args) throws FileNotFoundException {
        Stack<Scanner> scanners = new Stack<>();

        scanners.push(new Scanner(System.in));

        Scanner fileScanner1 = new Scanner(new FileReader("C:\\Git\\ITMO\\Programming\\lab5\\src\\test\\java\\SCANNER\\scanner_test"));
        Scanner fileScanner2 = new Scanner(new FileReader("C:\\Git\\ITMO\\Programming\\lab5\\src\\test\\java\\SCANNER\\scanner_test"));
        scanners.push(fileScanner1);

        if (scanners.contains(fileScanner2))
            System.out.println("Сканнеры 1 и 2 одинаковые");
        else
            System.out.println("Сканнеры 1 и 2 разные");
    }
}

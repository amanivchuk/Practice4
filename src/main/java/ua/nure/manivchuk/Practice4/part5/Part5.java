package ua.nure.manivchuk.Practice4.part5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

/**
 * Created by Lenovo on 11/24/2017.
 */
public class Part5 {
    public void output() {
        Scanner sc = new Scanner(System.in, "cp1251");
        while (sc.hasNext()) {

            String[] list = sc.nextLine().split(" ");
            if (list[0].equalsIgnoreCase("stop")) {
                System.out.println("Finished");
                break;
            }
            if (list.length != 2) {
                throw new ArrayIndexOutOfBoundsException();
            }

            Locale locale = new Locale(list[1].toLowerCase());
            ResourceBundle rb = ResourceBundle.getBundle("locales", locale);
            System.out.println(rb.getString(list[0]));

        }
    }

    public static void main(String[] args) {
        new Part5().output();
    }
}

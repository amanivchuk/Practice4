package ua.nure.manivchuk.Practice4;

import ua.nure.manivchuk.Practice4.task1.Task1;
import ua.nure.manivchuk.Practice4.task2.Task2;
import ua.nure.manivchuk.Practice4.task3.Task3;

/**
 * Created by Lenovo on 11/21/2017.
 */
public class Demo {
    public static void main(String[] args) {
        System.out.println("============= Part 1 ============");
        Task1 task1 = new Task1();
        System.out.println(task1.showTextFromFile());

        System.out.println("============= Part 2 ============");
        Task2 task2 = new Task2();
        task2.readWriteData();

        System.out.println("============= Part 3 ============");
        Task3 task3 = new Task3();
        task3.printResult();
    }
}

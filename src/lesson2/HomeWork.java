package lesson2;

/**
 * HomeWork - выполнение ДЗ №2
 *
 * @version 1.0.1
 * @package lesson2
 * @author  Vasya Brazhnikov
 * @copyright Copyright (c) 2018, Vasya Brazhnikov
 */
public class HomeWork {

    /**
     * main - здесь выполняются основные операции
     * @param args
     */
    public static void main(String[] args) {
        MyArray myArray = new MyArray();

        myArray.run();

        int arr[] = myArray.get();

        System.out.println(arr[999999]);
        System.out.println(arr[21313]);
        System.out.println(arr[453534]);
        System.out.println(arr[68678]);
    }
}

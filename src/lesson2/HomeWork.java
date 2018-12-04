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
        // инициализируем класс с массивом
        MyArray myArray = new MyArray();

        // заполняем массив случайными числами
        myArray.fillArray();

        long start = System.currentTimeMillis();
        // выполняем сортировку методом пузырька
        myArray.sortBubble();
        long finish = System.currentTimeMillis();
        
        System.out.println( finish - start );

        // заполняем массив случайными числами
        myArray.fillArray();

        start = System.currentTimeMillis();
        // выполняем сортировку методом выборки
        myArray.sortSelect();
        finish = System.currentTimeMillis();

        System.out.println( finish - start );

        // заполняем массив случайными числами
        myArray.fillArray();

        start = System.currentTimeMillis();
        // выполняем сортировку методом вставки
        myArray.sortInsert();
        finish = System.currentTimeMillis();

        System.out.println( finish - start );
    }
}

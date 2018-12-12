package lesson5;

import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        // ханойская башня
        Scanner con = new Scanner( System.in );
        int n = con.nextInt();
        hanoi( n,1,2,3 );

        // возведение числа в сепень с помощью рекурсии
        System.out.println( raiseNumbToPowerRec( 2, 3 ) );

        // возведение числа в сепень с помощью цикла
        System.out.println( raiseNumbToPower( 2, 3 ) );
    }

    /**
     * raiseNumbToPower - возведение в степень ( циклический способ )
     * @param a - число которое возводим в степень
     * @param b - степень в которую возводим число
     * @return int
     */
    private static int raiseNumbToPower ( int a, int b ) {
        int sum = 0;

        while ( b > 1 ) {
            if (sum != 0) {
                sum *= a;
            }
            else {
                sum = a * a;
            }
            b--;
        }

        return sum;
    }

    /**
     * raiseNumbToPowerRec - возведение в степень ( рекурсивный способ )
     * @param a - число которое возводим в степень
     * @param b - степень в которую возводим число
     * @return int
     */
    private static int raiseNumbToPowerRec ( int a, int b ) {
        int sum = 0;

        if ( b == 1 ) {
            return a;
        }
        else {
            return raiseNumbToPowerRec( a, b - 1 ) * a;
        }
    }

    /**
     * hanoi - алгортим ханойская башня
     * @param n - количество дисков
     * @param from - номер стержня с которого переносим
     * @param to   - номер стержня на который переносим
     * @param additional - стержень с помощью которого переносим
     */
    static void hanoi ( int n, int from, int to, int additional ) {

        if ( n == 0 ) {
            return;
        }

        hanoi(n - 1, from, additional, to );

        System.out.println( "n => " + n + " from => " + from + " to => " + to );

        hanoi(n - 1, additional, to, from );
    }
}

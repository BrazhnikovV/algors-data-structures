package lesson1;

import lesson1.Person;

public class Program {

    public static void main(String[] args) {
        int a = 5;
        int b;

        b = a;
        b++;
        System.out.println(a);
        System.out.println(b);

        Person p1 = new Person( "Vasya", "Brazhnikov", 35 );

        Person p2 = new Person( "Vasya", "Brazhnikov", 35 );

        p2 = p1;

        p2.setFirstName("Oleg");

        System.out.println(p2.getFirstName());
        System.out.println(p1.getFirstName());

        if ( p1.equals(p2) ) {
            System.out.println("Равны");
        }
        else {
            System.out.println("Не равны");
        }
    }
}

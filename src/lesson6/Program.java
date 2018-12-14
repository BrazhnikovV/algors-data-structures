package lesson6;

public class Program {

    public static void main(String[] args) {

        for ( int i = 0; i < 20; i++ ) {

            BST<String, Integer> assArr = new BST<>();
            for ( int j = 0; j < 100; j++ ) {
                assArr.put( Rnd.nextInt(10000 ) + "", Rnd.nextInt(10000 ) );
            }

            System.out.println(assArr.isBalanced());
        }
    }
}

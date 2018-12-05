package lesson3;

import java.util.NoSuchElementException;

/**
 * PrefixExpression - класс для вычисления перевернутого выражения в польской записи
 *
 * @version 1.0.1
 * @package lesson3
 * @author  Vasya Brazhnikov
 * @copyright Copyright (c) 2018, Vasya Brazhnikov
 */
public class PrefixExpression {

    /**
     * @access private
     * String expr - исходный выражение
     */
    private String expr;

    /**
     * PostfixExpression - конструктор
     * @param expr - выражения для вычисления
     */
    public PrefixExpression ( String expr ) {
        this.expr = expr;
    }

    /**
     * calcExpression - вычислить выражения в польской записи
     * @return int
     */
    public int calcExpression () {

        MyArrayStack<Integer> stack = new MyArrayStack<>();

        String[] s = expr.split( " " );

        for ( int i = s.length - 1; i >= 0; i-- ) {

            if ( s[i].equals( "+" ) || s[i].equals( "-" ) || s[i].equals( "/" ) || s[i].equals( "*" ) ) {

                if ( stack.size() < 2 ) {
                    throw new NoSuchElementException();
                }

                int a = stack.pop();
                int b = stack.pop();

                if      ( s[i].equals( "+" ) ) { stack.push(a + b ); }
                else if ( s[i].equals( "-" ) ) { stack.push(b + a ); }
                else if ( s[i].equals( "*" ) ) { stack.push(a * b ); }
                else if ( s[i].equals( "/" ) ) { stack.push(b / a ); }
            }
            else {
                stack.push( Integer.parseInt( s[i]) );
            }
        }

        return stack.peek();
    }
}

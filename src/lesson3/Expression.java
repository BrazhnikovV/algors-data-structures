package lesson3;

import java.util.EmptyStackException;
import java.util.concurrent.Executors;

/**
 * Expression - класс
 *
 * @version 1.0.1
 * @package lesson3
 * @author  Vasya Brazhnikov
 * @copyright Copyright (c) 2018, Vasya Brazhnikov
 */
public class Expression {

    /**
     * @access private
     * String expr
     */
    private String expr;

    /**
     * Expression - конструктор
     * @param expr
     */
    public Expression ( String expr ) {
        this.expr = expr;
    }

    /**
     * checkBrackets -
     * @return boolean
     */
    public boolean checkBrackets() {

        MyArrayStack<Character> stack = new MyArrayStack<>();

        for (int i = 0; i < this.expr.length(); i++) {
            char ch = this.expr.charAt(i);

            if ( ch == '(' || ch == '{' || ch == '[' ) {
                stack.push( ch );
            }
            else if ( ch == ')' || ch == '}' || ch == ']' ) {

                if ( stack.isEmpty() ) {
                    System.out.println( "Error in " + i + " position" );
                    return false;
                }

                char top = stack.pop();

                if ( ch == ')' && top != '(' || ch == ']' && top != '[' || ch == '}' && top != '{' ) {
                    System.out.println( "Error in " + i + " position" );
                    return false;
                }
            }
        }

        if ( !stack.isEmpty() ) {
            System.out.println( "Error brackets does not match " );
            return false;
        }

        return true;
    }
}

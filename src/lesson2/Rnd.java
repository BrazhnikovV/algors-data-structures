package lesson2;

import java.util.Random;

/**
 * Rnd - Генератор случайных чисел
 *
 * @version 1.0.1
 * @package lesson2
 * @author  Vasya Brazhnikov
 * @copyright Copyright (c) 2018, Vasya Brazhnikov
 */
public class Rnd {

    /**
     *  @access private
     *  @var Random random -
     */
    private static final Random random = new Random();

    /**
     * Сгенерировать случайное число
     * @param max максимальное значение случайного числа
     * @return результат
     */
    public static int nextInt( int max ) {
        return random.nextInt( max );
    }
}

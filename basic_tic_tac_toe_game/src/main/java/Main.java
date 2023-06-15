/**
 * Game tic tac toe AI
 * Игра крестики-нолики на доске 3x3
 *
 * @author Valentyn Mozul
 * @version 3.0 from 10.06.2023
 */

package src.main.java;

import java.util.Scanner;

import static src.main.java.TicTacToe.*;

public class Main {
    /**
     * Program entry point.
     *
     * @param args command Line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Welcome to TicTacToe game!");
        System.out.println("Enter numbers from 1 to 9 (Вводимо числа від 1 до 9)");

        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println("Move (хід) <" + aChar + ">");

            int position = scanner.nextInt();

            if (!move(aChar, position)) {
                if (position > 9 || position <= 0) {
                    System.out.println("Enter numbers from 1 to 9 (Вводимо числа від 1 до 9)");
                    continue;
                }
                System.out.println("This cell is occupied (Ця клітинка зайнята)");
                continue;
            }

            printBoard();

            Thread.sleep(1500);

            if (isBoardFull()) {
                System.out.println();
                System.out.println("Draw!!!");
                System.out.println("Game Over!");
                break;
            } else if (checkGameOver()) {
                System.out.println();
                System.out.println("Victory!!!" + " -> " + aChar);
                System.out.println("Game Over!");
                break;
            }

            if (aChar == 'x') {
                aChar = '0';
            } else {
                aChar = 'x';
            }
        }
    }
}

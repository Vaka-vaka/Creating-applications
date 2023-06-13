/**
 * Game tic tac toe AI
 * Игра крестики-нолики на доске 3x3
 *
 * @author Valentyn Mozul
 * @version 3.0 from 10.06.2023
 */

package src.main.java;

public class TicTacToe {
    static final char[] line1 = {'1', '2', '3'};
    static final char[] line2 = {'4', '5', '6'};
    static final char[] line3 = {'7', '8', '9'};

    public static void printBoard() {
        for (int i = 0; i < 3; i++) {
            System.out.print(line1[i] + " | ");
        }
        System.out.println();
        for (int i = 0; i < 3; i++) {
            System.out.print(line2[i] + " | ");
        }
        System.out.println();
        for (int i = 0; i < 3; i++) {
            System.out.print(line3[i] + " | ");
        }
    }
}

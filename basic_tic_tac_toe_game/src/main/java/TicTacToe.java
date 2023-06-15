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

    static char aChar = 'x';

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
        System.out.println();
    }

    public static boolean move(char c, int position) {
        if (1 == position && line1[0] == '1') {
            line1[0] = c;
        } else if (2 == position && line1[1] == '2') {
            line1[1] = c;
        } else if (3 == position && line1[2] == '3') {
            line1[2] = c;
        } else if (4 == position && line2[0] == '4') {
            line2[0] = c;
        } else if (5 == position && line2[1] == '5') {
            line2[1] = c;
        } else if (6 == position && line2[2] == '6') {
            line2[2] = c;
        } else if (7 == position && line3[0] == '7') {
            line3[0] = c;
        } else if (8 == position && line3[1] == '8') {
            line3[1] = c;
        } else if (9 == position && line3[2] == '9') {
            line3[2] = c;
        } else {
            return false;
        }
        return true;
    }

    public static char getChar(int position) {
        if (position == 1) {
            return line1[0];
        } else if (2 == position) {
            return line1[1];
        } else if (3 == position) {
            return line1[2];
        } else if (4 == position) {
            return line2[0];
        } else if (5 == position) {
            return line2[1];
        } else if (6 == position) {
            return line2[2];
        } else if (7 == position) {
            return line3[0];
        } else if (8 == position) {
            return line3[1];
        } else if (9 == position) {
            return line3[2];
        }
        return '#';
    }

    public static boolean checkThree(int n1, int n2, int n3) {
        char v1 = getChar(n1);
        char v2 = getChar(n2);
        char v3 = getChar(n3);

        return (v1 != ' ') && (v1 == v2) && (v2 == v3);
    }

    public static boolean isBoardFull() {
        int emptySpaseCount = 0;
        for (int i = 0; i < 3; i++) {
            if (line1[0] == '1') {
                emptySpaseCount++;
            } else if (line1[1] == '2') {
                emptySpaseCount++;
            } else if (line1[2] == '3') {
                emptySpaseCount++;
            } else if (line2[0] == '4') {
                emptySpaseCount++;
            } else if (line2[1] == '5') {
                emptySpaseCount++;
            } else if (line2[2] == '6') {
                emptySpaseCount++;
            } else if (line3[0] == '7') {
                emptySpaseCount++;
            } else if (line3[1] == '8') {
                emptySpaseCount++;
            } else if (line3[2] == '9') {
                emptySpaseCount++;
            }
        }
        return emptySpaseCount == 0;
    }

    public static boolean checkGameOver() {
        if (isBoardFull()) {
            return true;
        }

        boolean line1 = checkThree(1, 2, 3);
        boolean line2 = checkThree(4, 5, 6);
        boolean line3 = checkThree(7, 8, 9);

        boolean col1 = checkThree(1, 4, 7);
        boolean col2 = checkThree(2, 5, 8);
        boolean col3 = checkThree(3, 6, 9);

        boolean dia1 = checkThree(1, 5, 9);
        boolean dia2 = checkThree(3, 5, 7);

        return line1 || line2 || line3 || col1 || col2 || col3 || dia1 || dia2;
    }
}

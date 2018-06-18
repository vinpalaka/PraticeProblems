package matrix;// Connect 4 Parser
// https://en.wikipedia.org/wiki/Connect_Four

// Implement the function that takes a board string and decodes it into the representative 2D array.

// For an input string of "9_r4_brbrbr_3b2rb_b2r2br_r2b3rb"

// The output board would look like:

// |_|_|_|_|_|_|_|
// |_|_|r|_|_|_|_|
// |b|r|b|r|b|r|_|
// |b|b|b|r|r|b|_|
// |b|r|r|b|b|r|_|
// |r|b|b|r|r|r|b|

// (6x7 = 42 pieces)

// The strings should be one of:

// 'r' to indicate a red piece
// 'b' to indicate a black piece
// '_' to indicate an empty space

// The input string is not necessarily a valid board string. It is guaranteed not-empty.

//First check if string is valid, 
//initialize a array of chars
//start left
//if item is a number: start another add next char as many times
//


import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 You there??
 *
 * If you need more classes, simply define them inline.
 */

public class ConnectFour {


    public static char[][] getBoard(String input) {
        if(input == null)//isValid(input)
            return null;
        int columnLength = 7;
        int rowLength = 6;
        char[][] board = new char[rowLength][columnLength];
        int row = 0;
        int column = 0;

        for(int i = 0 ; i < input.length() - 1; i++) {
            char next = input.charAt(i);
            if(Character.isDigit(next)) {
                int val = Integer.valueOf( "" + next);
                System.out.println(val);

                while(column < val){

                    char item = input.charAt(i + 1);
                    if(isValidItem(item)) {
                        board[row][column++] = item;
                    }

                    if(column == 6) {
                        column = 0;
                        row++;
                    }
                    if(row > 5) {
                        return null;
                    }
                }

            } else if(isValidItem(next)) {
                board[row][column++] = next;
                if(column > 6) {
                    column = 0;
                    row++;
                }

                if(row > 5)
                    return null;


            }
        }
        return board;
    }

    public static boolean isValidItem(char c) {
        return c == '_' || c == 'b' || c == 'r';
    }


    public static void main(String[] args) {
        String input = "9_r4_brbrbr_3b2rb_b2r2br_r2b3rb";
        System.out.println(getBoard(input));
    }
    //printBoard(board);
}
        


/* 
Your previous Ruby content is preserved below:


 */
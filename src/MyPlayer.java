import java.awt.*;
import java.util.ArrayList;

public class MyPlayer {
    public Chip[][] gameBoard;
    public int[] columns;
    public ArrayList<Board> Allboards = new ArrayList<Board>();
    //public int[


    public MyPlayer() {
        //  columns = new int[10];

        /*
         * This code will run just once, when the game opens.
         * Add your code here.
         */
        //Print all boards 3x3 or smaller. So 19 boards
        // *** **  **  **  *   *   *  *   *   *
        // *** *** **  **  *** **  ** *   *   *   *** **  **  *   *  *
        // *** *** *** **  *** *** ** *** **  *   *** *** **  *** ** *   *** **   *

        //build an arraylist of all the boards that can exist
        //use the Board class I made to hold the board info
        for (int a = 1; a < 4; a++) {
            for (int b = 0; b <= a; b++) {
                for (int c = 0; c <= b; c++) {
                    // System.out.println(a + "" + b + "" + c);
                    Board newboard = new Board(a + "" + b + "" + c, 1, 1);
                    calculateboards(newboard, a, b, c);
                    Allboards.add(newboard);
                }
            }
        }

        for (int i = 0; i < Allboards.size(); i++) {
            Allboards.get(i).printboard();
        }
    }

    //makes the list of boards that could be made starting with the current board
    //adds each possible board to my Board object
    private void calculateboards(Board myboard, int c1, int c2, int c3) {
        for (int a = 0; a < c3; a++) {
            myboard.Addsubboard(c1 + "" + c2 + "" + a);
        }

        //for column 2 clicks need to set columns 3 equal to the same as column 2 if it is greater
        for (int b = 0; b < c2; b++) {
            if (b < c3) {
                myboard.Addsubboard(c1 + "" + b + "" + b);
            } else {
                myboard.Addsubboard(c1 + "" + b + "" + c3);
            }
        }

        //for column 1 for each row clicked need to set column 2 and 3 to equal if they are greater
        for (int c = 1; c < c1; c++) {
            //need a place to hold  starting value of column2 and column3
            //if column one is less than either of those columns
            //then use column one value instead of the value in column 2 or column 3
            int c2o = c2;
            int c3o = c3;
            if (c < c2)
                c2o = c;
            if (c < c3)
                c3o = c;
            myboard.Addsubboard(c + "" + c2o + "" + c3o);
        }

    }

    public Point move(Chip[][] pBoard) {

        System.out.println("MyPlayer Move");

        /***
         * This code will run each time the "MyPlayer" button is pressed.
         * Add your code to return the row and the column of the chip you want to take.
         * You'll be returning a data type called Point which consists of two integers.
         */

        //find out how many chips in each column by adding them to
        //the right slot in this array of 3 ints.
        int [] columns = new int[3];
        //loop over rows and columns and for each column add one for each chip that is
        //alive in that column
        for (int r = 0; r < pBoard[0].length; r++) {
            for (int c = 0; c < pBoard[0].length; c++) {
                //check size of c and r to make sure they are not bigger than 3
                if(pBoard[r][c].isAlive && c < 3 && r < 3)
                    columns[c] = columns[c] + 1;
            }
        }
        //make a string from the total number of chips in each column
        String board = columns[0] + "" + columns[1] + "" + columns[2];

        //find the right board by comparing the string we made to the string I hold for each
        //Board object "333,332,331,..". Those will be all 19 boards so just find the one that matches
        for(int i = 0; i < Allboards.size();i++){
            if(Allboards.get(i).boardstate.equals(board))
                return Allboards.get(i).movetomake;
        }
        //if the board match was not found just return the death one so it does something
        return new Point(0,0);
    }
}

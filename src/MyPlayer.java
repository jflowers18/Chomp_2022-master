import java.awt.*;

public class MyPlayer {
    public Chip[][] gameBoard;
    public int[] columns;
    //public int[


    public MyPlayer() {
        columns = new int[10];

        /***
         * This code will run just once, when the game opens.
         * Add your code here.
         */
        //Print all boards 3x3 or smaller. So 10 boards
        // *** **  *
        // *** *** *** *** **  *
        // *** *** *** *** *** *** *** ** *

        // How many total pieces on the board
       /* int piececount = 0;
        //loop to go backwards down from 9 to 0 to make 10 boards, taking one piece away
        //each time. I can use the count to tell me when to stop counting pieces because
        //there will be one less on each board until all the pieces are gone
        for(int count = 9;count >=0;count--){

            //keep track of how many pieces
            piececount = 0;

            //loop for 3 rows
            for (int r = 0; r < 3; r++) {

                //loop for 3 columns
                for (int c = 0; c < 3; c++) {

                }
            }

        }*/
        /*for (int a = 1; a < 4; a++) {
            for (int b = 0; b < 4; b++) {
                for (int c = 0; c < 4; c++) {
                    if (a >= b && b>=c){
                        System.out.println(a+""+b+""+c);
                    }
                }
            }
        }*/

        for (int a = 0; a < 4; a++) {
            for (int b = 0; b <= a; b++) {
                for (int c = 0; c <= b; c++) {
                    System.out.println(a + "" + b + "" + c);
                    calculateboards(a, b, c);

                }
            }
        }

//need to try and find what determines winning board if even vs odd or total chips on board
        //something like if ( a+b+c <=
        // totalboards = (a+b+c-1);
    }

    private void calculateboards(int c1, int c2, int c3) {


        for (int a = 0; a < c3; a++) {
            System.out.println("    " + c1 + "" + "" + c2 + "" + a);


        }

        for (int b = 0; b < c2; b++) {
            if (b < c3)
                System.out.println("    " + c1 + "" + "" + b + "" + b);
            else
                System.out.println("    " + c1 + "" + "" + b + "" + c3);


        }


        /*for (int c = 1; c < c1; c++) {
            for (int b = 0; b > c1; b++)
                for (int a = 0; a > c2; a++)
            if (c > c2)
                System.out.println("    "+c+""+""+b+""+a);
            else
                System.out.println("    "+c+""+""+c2+""+c3);

        }*/
        //for column 1 for each row clicked need to set column 2 and 3 to equal if they are greater
        for(int c = 1; c < c1; c++){
            //need a place to hold  starting value of column2 and column3
            //if column one is less than either of those columns
            //then use column one value instead of the value in column 2 or column 3
            int c2o = c2;
            int c3o = c3;
            if (c < c2)
                c2o = c;
            if (c < c3)
                c3o = c;
            System.out.println("    " + c + "" + c2o + "" + c3o);
        }

    }
    private Point calculatebestmove(int c1, int c2, int c3){
        //calcylate then print the best move option
        //best move leaves only 2 moves that can't kill all chips or 0
        //use the gameboard to find what is on the board
        int row = 1;
        int col = 1;
        return new Point(row, col);
    }

    public Point move(Chip[][] pBoard) {

        System.out.println("MyPlayer Move");


        gameBoard = pBoard;
        int column = 0;
        int row = 0;

        row = 1;
        column = 1;

        /***
         * This code will run each time the "MyPlayer" button is pressed.
         * Add your code to return the row and the column of the chip you want to take.
         * You'll be returning a data type called Point which consists of two integers.
         */





        //need to fill out calculate best move next
        Point myMove = calculatebestmove(1,1,1);
        return myMove;
    }


}

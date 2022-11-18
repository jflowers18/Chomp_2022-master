import java.awt.*;
import java.util.ArrayList;

public class Board {
    public String boardstate;
    //make this winner and only change it for the ones that will be loser boards
    public String winner = "Winner";
    public Point movetomake;
    //this can hold all the boards that you could get based on what board this is. So depending
    //on the chip picked the board ends up like one of these
    public ArrayList<String> subboards = new ArrayList<String>();


    public Board(String state, int moverow, int movecolumn) {
        //the boardstate is the string that says how many chips in each column
        //like "111" or "322"
        boardstate = state;
        Setup();
    }

    public void Setup(){
        //Setup the right move
        if(boardstate.contentEquals("211")){
            //2 times where 0,2 is the best move
            movetomake = new Point(0,2);
        }
        else if(boardstate.contentEquals("311") || boardstate.contentEquals("310")){
            //1 time where 2,0 is the best move
            movetomake = new Point(2,0);
        }
        else if(boardstate.contentEquals("111") || boardstate.contentEquals("110")){
            //3 times where 1,0 is the best move
            movetomake = new Point(0,1);
        }
        else if(boardstate.contentEquals("200") || boardstate.contentEquals("210") || boardstate.contentEquals("300")){
            //3 times where 1,0 is the best move
            movetomake = new Point(1,0);
        }
        else if(boardstate.contentEquals("100")){
            //3 times where 1,0 is the best move
            movetomake = new Point(0,0);
        }
        else{
            //10 cases where 1,1 is the best move
            movetomake = new Point(1,1);
        }

        // Mark as false for winning in these cases
        if(boardstate.contentEquals("330") || boardstate.contentEquals("320") ||
                boardstate.contentEquals("311") || boardstate.contentEquals("221") ||
                boardstate.contentEquals("210") || boardstate.contentEquals("100"))
            winner = "Loser";
    }
    public void Addsubboard (String board){
        subboards.add(board);
    }

    public void printboard(){
        System.out.println(boardstate + " -> " + winner);
        System.out.println("  Move to Make: " + (int)movetomake.getX() + "," + (int)movetomake.getY());
        System.out.println("  Possible Boards");

        for(int i = 0; i < subboards.size();i++){
            System.out.println("    " + subboards.get(i));
        }
    }

}
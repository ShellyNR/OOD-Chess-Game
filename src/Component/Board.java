package Component;

import Game.Game;
import Tools.common;

import java.awt.*;
import java.util.List;

public class Board {

    private Color color;
    private Spot[][] currentPosition;

    // CONSTRUCTORS
    public Board(Color color,char[][] initBoard){
        this.color = color;
        this.currentPosition = initBoard(initBoard);

    }

    public Board(char[][] initBoard){
        this.color = Color.black; //defualt color
        this.currentPosition = initBoard(initBoard);

    }

    public Board(){
        this.color = Color.black; //defualt color
        this.currentPosition = setDefualtBoard();

    }

    public Spot getSpot(int x, int y) {

        if (x < 0 || x > 7 || y < 0 || y > 7) {
            System.out.println("Index out of bound");
        }

        return currentPosition[x][y];
    }

    public void setSpot(int x, int y, Spot newSpot) {

        if (x < 0 || x > 7 || y < 0 || y > 7) {
            System.out.println("Index out of bound");
        }

        this.currentPosition[x][y] = newSpot;
    }


    // CREATE BOARDS

    private String getToolType(char ch){
        boolean isWhite = true;
        if(ch == 'e'){
            return "Empty";
        }
        if(Character.isUpperCase(ch)){
            isWhite = false;
        }
        char chLC = Character.toLowerCase(ch);
        String tool = null;
        switch (chLC){
            case 'k':
                tool = "King";
                break;
            case 'q':
                tool = "Queen";
                break;
            case 'r':
                tool = "Rook";
                break;
            case 'b':
                tool = "Bishop";
                break;
            case 'n':
                tool = "Knight";
                break;
            case 'p':
                tool = "Pawn";
                break;

        }
        if(isWhite){
            tool = tool + "W";
        }
        else{
            tool = tool + "B";
        }
        return tool;
    }

    private Spot[][] initBoard(char[][] state) {
        Spot[][] board= new Spot[8][8];

        for(int i=0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                String tool = getToolType(state[i][j]);
                board[i][j] = new Spot(i,j,common.toolsCache.get(tool));
            }
        }
        return board;
    }

    private Spot[][] setDefualtBoard() {
        Spot[][] board= new Spot[8][8];

        // initialize black pieces
        board[0][0] = new Spot(0, 0, common.toolsCache.get("RookB"));
        board[0][1] = new Spot(0, 1, common.toolsCache.get("KnightB"));
        board[0][2] = new Spot(0, 2, common.toolsCache.get("BishopB"));
        board[0][3] = new Spot(0, 3, common.toolsCache.get("QueenB"));
        board[0][4] = new Spot(0, 4, common.toolsCache.get("KingB"));
        board[0][5] = new Spot(0, 5, common.toolsCache.get("BishopB"));
        board[0][6] = new Spot(0, 6, common.toolsCache.get("KnightB"));
        board[0][7] = new Spot(0, 7, common.toolsCache.get("RookB"));

        board[1][0] = new Spot(1, 0, common.toolsCache.get("PawnB"));
        board[1][1] = new Spot(1, 1, common.toolsCache.get("PawnB"));
        board[1][2] = new Spot(1, 2, common.toolsCache.get("PawnB"));
        board[1][3] = new Spot(1, 3, common.toolsCache.get("PawnB"));
        board[1][4] = new Spot(1, 4, common.toolsCache.get("PawnB"));
        board[1][5] = new Spot(1, 5, common.toolsCache.get("PawnB"));
        board[1][6] = new Spot(1, 6, common.toolsCache.get("PawnB"));
        board[1][7] = new Spot(1, 7, common.toolsCache.get("PawnB"));

        // initialize white pieces
        board[7][0] = new Spot(7, 0, common.toolsCache.get("RookW"));
        board[7][1] = new Spot(7, 1, common.toolsCache.get("KnightW"));
        board[7][2] = new Spot(7, 2, common.toolsCache.get("BishopW"));
        board[7][3] = new Spot(7, 3, common.toolsCache.get("QueenW"));
        board[7][4] = new Spot(7, 4, common.toolsCache.get("KingW"));
        board[7][5] = new Spot(7, 5, common.toolsCache.get("BishopW"));
        board[7][6] = new Spot(7, 6, common.toolsCache.get("KnightW"));
        board[7][7] = new Spot(7, 7, common.toolsCache.get("RookW"));

        board[6][0] = new Spot(6, 0, common.toolsCache.get("PawnW"));
        board[6][1] = new Spot(6, 1, common.toolsCache.get("PawnW"));
        board[6][2] = new Spot(6, 2, common.toolsCache.get("PawnW"));
        board[6][3] = new Spot(6, 3, common.toolsCache.get("PawnW"));
        board[6][4] = new Spot(6, 4, common.toolsCache.get("PawnW"));
        board[6][5] = new Spot(6, 5, common.toolsCache.get("PawnW"));
        board[6][6] = new Spot(6, 6, common.toolsCache.get("PawnW"));
        board[6][7] = new Spot(6, 7, common.toolsCache.get("PawnW"));


        // initialize remaining spots without any piece
        for (int i = 2; i < 6; i++) {
            for (int j = 0; j < 8; j++) {
                board[i][j] = new Spot(i, j, common.toolsCache.get("Empty"));
            }
        }
        return board;
    }

    public void updateBoardByMove(Move move) {
        Spot start = move.getStart();
        Spot end = move.getEnd();
        setSpot(start.getX(), start.getY(), new Spot(start.getX(), start.getY(), common.toolsCache.get("Empty")));
        setSpot(end.getX(),end.getY(),new Spot(end.getX(), end.getY(), start.getTool()));
    }


}

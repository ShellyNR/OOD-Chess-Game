package Component;

import Tools.EnumTool;
import Tools.Tool;
import Tools.common;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static java.lang.Math.*;

public class Board {

    private Color color;
    private Spot[][] currentPosition;
    public static int LENGTH = 8;
    public List<Spot[][]> history = new ArrayList<>();
    HashMap<EnumTool, Tool> c = common.getInstance();

    // CONSTRUCTORS
    public Board(Color color,char[][] initBoard){
        this.color = color;
        this.currentPosition = initBoard(initBoard);
        storeBoardinHistory();
    }

    public Board(char[][] initBoard){
        this.color = Color.black; // default color
        this.currentPosition = initBoard(initBoard);
        storeBoardinHistory();
    }

    public Board(){
        this.color = Color.black; //default color
        this.currentPosition = setDefualtBoard();
        storeBoardinHistory();
    }

    public Spot[][] getCurrentPosition() {
        return currentPosition;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Spot getSpot(int x, int y) {

        if (x < 0 || x > (LENGTH - 1) || y < 0 || y > (LENGTH - 1)) {
            System.out.println("Index out of bound");
        }

        return currentPosition[x][y];
    }

    public void setSpot(int x, int y, Spot newSpot) {

        if (x < 0 || x > (LENGTH - 1) || y < 0 || y > (LENGTH - 1)) {
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
        Spot[][] board= new Spot[LENGTH][LENGTH];

        for(int i=0; i < LENGTH; i++){
            for(int j = 0; j < LENGTH; j++){
                String tool = getToolType(state[i][j]);
                board[i][j] = new Spot(i,j,c.get(tool));
            }
        }
        return board;
    }

    private Spot[][] setDefualtBoard() {
        Spot[][] board= new Spot[LENGTH][LENGTH];

        // initialize black pieces
        board[0][0] = new Spot(0, 0, c.get(EnumTool.RookB));
        board[0][1] = new Spot(0, 1, c.get(EnumTool.KnightB));
        board[0][2] = new Spot(0, 2, c.get(EnumTool.BishopB));
        board[0][3] = new Spot(0, 3, c.get(EnumTool.QueenB));
        board[0][4] = new Spot(0, 4, c.get(EnumTool.KingB));
        board[0][5] = new Spot(0, 5, c.get(EnumTool.BishopB));
        board[0][6] = new Spot(0, 6, c.get(EnumTool.KnightB));
        board[0][7] = new Spot(0, 7, c.get(EnumTool.RookB));

        board[1][0] = new Spot(1, 0, c.get(EnumTool.PawnB));
        board[1][1] = new Spot(1, 1, c.get(EnumTool.PawnB));
        board[1][2] = new Spot(1, 2, c.get(EnumTool.PawnB));
        board[1][3] = new Spot(1, 3, c.get(EnumTool.PawnB));
        board[1][4] = new Spot(1, 4, c.get(EnumTool.PawnB));
        board[1][5] = new Spot(1, 5, c.get(EnumTool.PawnB));
        board[1][6] = new Spot(1, 6, c.get(EnumTool.PawnB));
        board[1][7] = new Spot(1, 7, c.get(EnumTool.PawnB));

        // initialize white pieces
        board[7][0] = new Spot(7, 0, c.get(EnumTool.RookW));
        board[7][1] = new Spot(7, 1, c.get(EnumTool.KnightW));
        board[7][2] = new Spot(7, 2, c.get(EnumTool.BishopW));
        board[7][3] = new Spot(7, 3, c.get(EnumTool.QueenW));
        board[7][4] = new Spot(7, 4, c.get(EnumTool.KingW));
        board[7][5] = new Spot(7, 5, c.get(EnumTool.BishopW));
        board[7][6] = new Spot(7, 6, c.get(EnumTool.KnightW));
        board[7][7] = new Spot(7, 7, c.get(EnumTool.RookW));

        board[6][0] = new Spot(6, 0, c.get(EnumTool.PawnW));
        board[6][1] = new Spot(6, 1, c.get(EnumTool.PawnW));
        board[6][2] = new Spot(6, 2, c.get(EnumTool.PawnW));
        board[6][3] = new Spot(6, 3, c.get(EnumTool.PawnW));
        board[6][4] = new Spot(6, 4, c.get(EnumTool.PawnW));
        board[6][5] = new Spot(6, 5, c.get(EnumTool.PawnW));
        board[6][6] = new Spot(6, 6, c.get(EnumTool.PawnW));
        board[6][7] = new Spot(6, 7, c.get(EnumTool.PawnW));


        // initialize remaining spots without any piece
        for (int i = 2; i < LENGTH - 2; i++) {
                for (int j = 0; j < LENGTH; j++) {
                    board[i][j] = new Spot(i, j, c.get(EnumTool.Empty));
                }
        }
        return board;
    }

    public void updateBoardByMove(Move move) {
        Spot start = move.getStart();
        Spot end = move.getEnd();
        setSpot(start.getX(), start.getY(), new Spot(start.getX(), start.getY(), c.get(EnumTool.Empty)));
        setSpot(end.getX(),end.getY(),new Spot(end.getX(), end.getY(), start.getTool()));
        storeBoardinHistory();
    }

    public boolean isFreeBetweenSpotsRow(Spot start, Spot end){
        int y1 = min(start.getY(),end.getY());
        int y2 = max(start.getY(),end.getY());
        int x = start.getX();


        for(int i = y1 + 1 ; i < y2 ; i++) {
            if (!getSpot(x, i).isEmpty()) {
                return false;
            }
        }
        return true;
    }

    public boolean isFreeBetweenSpotsColumn(Spot start, Spot end){
        int x1 = min(start.getX(),end.getX());
        int x2 = max(start.getX(),end.getX());
        int y = start.getY();

        for(int i = x1 + 1 ; i < x2 ; i++){
            if(!getSpot(i,y).isEmpty()){
                return false;
            }
        }
        return true;

    }

    public boolean isFreeBetweenSpotsDiagonal(Spot start, Spot end){

        int dx = 1;
        int dy = 1;
        if(start.getX() > end.getX()){
            dx = -1;
        }
        if(start.getY() > end.getY()){
            dy = -1;
        }

        int delta = abs(start.getX() - end.getX());
        int x = start.getX() + dx;
        int y = start.getY() + dy;


        for(int i = 1 ; i < delta ; i++){
            if(!getSpot(x,y).isEmpty()){
                return false;
            }
            x += dx;
            y += dy;

        }
        return true;

    }

    public boolean isFreeBetween(Move move){
        if(move.isInTheSameRow()){
            return isFreeBetweenSpotsRow(move.getStart(),move.getEnd());
        }else if(move.isInTheSameColumn()){
            return isFreeBetweenSpotsColumn(move.getStart(),move.getEnd());
        }else if(move.isInTheSameDiagonal()){
            return isFreeBetweenSpotsDiagonal(move.getStart(),move.getEnd());
        }
        return false;
    }

    public Spot getKingSpotByColor(boolean isWhite) {
        for(int i=0; i < LENGTH; i++){
            for(int j = 0; j < LENGTH; j++){
                Spot s = getSpot(i, j);
                if (s.getTool().isWhite() == isWhite && s.getTool().isKing())
                    return s;
            }
        }
        return null; // can't happen
    }

    public void storeBoardinHistory(){
        Spot[][] board= new Spot[LENGTH][LENGTH];

        // initialize remaining spots without any piece
        for (int i = 0; i < LENGTH; i++) {
            for (int j = 0; j < LENGTH; j++) {
                board[i][j] = this.currentPosition[i][j];
            }
        }
        this.history.add(board);
    }

    public void undo(){
        if (!this.history.isEmpty()){
            this.currentPosition = this.history.remove(this.history.size()-1);
        }
    }


}

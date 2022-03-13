package Component;

import Game.Game;

import java.awt.*;
import java.util.List;

public class Board {

    private List<Game> currentPosition;
    private Color color;
    private Color defualtColor = Color.black;

    public Board(Color color,String initBoard,int size){
        this.color = color;
        this.currentPosition = initBoard(initBoard,size);

    }

    public Board(String initBoard,int size){
        this.color = defualtColor;
        this.currentPosition = initBoard(initBoard,size);

    }

    private List<Game> initBoard(String initBoard,int size) {
        Spot board[][] = new Spot[size][size];
        for(int i=0; i < size; i++){
            for(int j = 0; j < size; j++){

            }
        }


    }

    private List<Game> updateBoardByMove(Move move) {

    }




}

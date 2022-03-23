package ListenerToBoard;

import Game.BoardListener;
import Component.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

public class MouseListenerToBoard implements MouseListener, BoardNotifier {
    private int count = 0;
    private JButton chessPiece;
    private long lastclick;
    private List<BoardListener> boardListener =  new ArrayList<>();
    Move currentMove;

    @Override
    public void mouseClicked(MouseEvent e) {
        // if the two clicks are too close
        if(System.currentTimeMillis() < lastclick + 20) return;
        lastclick = System.currentTimeMillis();

        // the first click - source
        if (this.count == 0) {
            chessPiece = null;
            Component c = e.getComponent();
            if (!(c instanceof JButton)) return;
            chessPiece = (JButton) c;
            int w=chessPiece.getSize().width;
            int h=chessPiece.getSize().height;
            int x = chessPiece.getX() / w - 1;
            int y = chessPiece.getY() / h - 1;
            // initiate new move but without the start tool
            this.currentMove = new Move(new Spot(y, x, null));
            this.count = 1;
        } else if (this.count == 1) {
            // the second click
            if (chessPiece == null) return;
            Component c = e.getComponent();
            chessPiece = (JButton) c;
            int w=chessPiece.getSize().width;
            int h=chessPiece.getSize().height;
            int x = chessPiece.getX() / w - 1;
            int y = chessPiece.getY() / h - 1;

            // the move.end does not have a tool yet
            this.currentMove.setEnd(new Spot(y, x, null));

            // notify listeners about the move
            for (BoardListener ml:this.boardListener) {
                ml.notify(this.currentMove);
            }
            chessPiece = null;
            this.count = 0;
        }

    }

    //@Override
    public void addBoardListener(BoardListener ml) {
        this.boardListener.add(ml);
    }

    @Override
    public Object addBoardNotifier(Object o) {
        Component c = (Component)o;
        c.addMouseListener(this);
        return c;
    }

    @Override
    public void NotifyNewBoard() {
        for (BoardListener ml:this.boardListener) {
            ml.notifyNew();
        }
    }


    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}

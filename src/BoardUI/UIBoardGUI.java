package BoardUI;

import java.awt.*;

import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
import javax.swing.border.*;
import java.net.URL;
import java.util.*;
import javax.imageio.ImageIO;
import Component.*;
import Game.*;
import ListenerToBoard.BoardNotifier;
import Tools.*;

public class UIBoardGUI extends JFrame implements UIBoard {

    private final JPanel gui = new JPanel(new BorderLayout(3, 3));
    private JButton[][] chessBoardSquares = new JButton[8][8];
    private Image[][] chessPieceImages = new Image[2][6];
    private JPanel chessBoard;
    private final JLabel message = new JLabel(
            "Chess Champ is ready to play!");
    private Spot[][] currentPositionS;
    private static final String COLS = "ABCDEFGH";
    public Hashtable<String, Integer> map;
    public Move currentMove;
    private BoardNotifier notifier;
    HashMap<EnumTool, Tool> c = common.getInstance();

    public static final int BLACK = 0, WHITE = 1;

    public UIBoardGUI() {

        this.map = new Hashtable<String, Integer>() {{
            put("Queen", 0);
            put("King", 1);
            put("Rook", 2);
            put("Knight", 3);
            put("Bishop", 4);
            put("Pawn", 5);
        }};

    }

    @Override
    public void show(Move move) {
        this.currentMove = move;
        this.setupGame();
    }

    @Override
    public void start(Spot[][] startPosition) {
        this.currentPositionS = startPosition;
        this.setupNewGame();
    }

    public final JComponent getGui() {
        return gui;
    }

    public final void initialize() {
        JFrame f = new JFrame("ChessChamp");
        f.add(this.getGui());
        // Ensures JVM closes after frame(s) closed and
        // all non-daemon threads are finished
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        // See https://stackoverflow.com/a/7143398/418556 for demo.
        f.setLocationByPlatform(true);

        // ensures the frame is the minimum size it needs to be
        // in order display the components within it
        f.pack();

        // ensures the minimum size is enforced.
        f.setMinimumSize(f.getSize());
        f.setVisible(true);

        // create the images for the chess pieces
        createImages();

        // set up the main GUI
        gui.setBorder(new EmptyBorder(5, 5, 5, 5));
        JToolBar tools = new JToolBar();
        tools.setFloatable(false);
        gui.add(tools, BorderLayout.PAGE_START);

        Action newGameAction = new AbstractAction("New") {

            @Override
            public void actionPerformed(ActionEvent e) {
                updateNewGame();
            }
        };

        tools.add(newGameAction);
        tools.add(message);

        gui.add(new JLabel("?"), BorderLayout.LINE_START);

        chessBoard = new JPanel(new GridLayout(0, 9)) {

            /**
             * Override the preferred size to return the largest it can, in
             * a square shape.  Must (must, must) be added to a GridBagLayout
             * as the only component (it uses the parent as a guide to size)
             * with no GridBagConstaint (so it is centered).
             */
            @Override
            public final Dimension getPreferredSize() {
                Dimension d = super.getPreferredSize();
                Dimension prefSize = null;
                Component c = getParent();
                if (c == null) {
                    prefSize = new Dimension(
                            (int) d.getWidth(), (int) d.getHeight());
                } else if (c != null &&
                        c.getWidth() > d.getWidth() &&
                        c.getHeight() > d.getHeight()) {
                    prefSize = c.getSize();
                } else {
                    prefSize = d;
                }
                int w = (int) prefSize.getWidth();
                int h = (int) prefSize.getHeight();
                // the smaller of the two sizes
                int s = (w > h ? h : w);
                return new Dimension(s, s);
            }
        };

        chessBoard.setBorder(new CompoundBorder(
                new EmptyBorder(8, 8, 8, 8),
                new LineBorder(Color.BLACK)
        ));


        // Set the BG to be ochre
        Color ochre = new Color(204, 119, 34);
        chessBoard.setBackground(ochre);
        JPanel boardConstrain = new JPanel(new GridBagLayout());

        boardConstrain.setBackground(ochre);
        boardConstrain.add(chessBoard);
        gui.add(boardConstrain);

        // create the chess board squares
        Insets buttonMargin = new Insets(0, 0, 0, 0);
        for (int ii = 0; ii < chessBoardSquares.length; ii++) {
            for (int jj = 0; jj < chessBoardSquares[ii].length; jj++) {
                JButton b = new JButton();
                b.setMargin(buttonMargin);
                // our chess pieces are 64x64 px in size, so we'll
                // 'fill this in' using a transparent icon..
                ImageIcon icon = new ImageIcon(
                        new BufferedImage(64, 64, BufferedImage.TYPE_INT_ARGB));
                b.setIcon(icon);
                if ((jj % 2 == 1 && ii % 2 == 1)
                        //) {
                        || (jj % 2 == 0 && ii % 2 == 0)) {
                    b.setBackground(Color.WHITE);
                } else {
                    b.setBackground(Color.BLACK);
                }

                chessBoardSquares[jj][ii] = b;

            }
        }

        /*
         * fill the chess board
         */
        chessBoard.add(new JLabel(""));
        // fill the top row
        for (int ii = 0; ii < 8; ii++) {
            chessBoard.add(
                    new JLabel(COLS.substring(ii, ii + 1),
                            SwingConstants.CENTER));
        }
        // fill the black non-pawn piece row
        for (int ii = 0; ii < 8; ii++) {
            for (int jj = 0; jj < 8; jj++) {
                switch (jj) {
                    case 0:
                        chessBoard.add(new JLabel("" + (9 - (ii + 1)),
                                SwingConstants.CENTER));
                    default:
                        chessBoard.add(chessBoardSquares[jj][ii]);
                }
            }
        }
    }

    // when the user asks to start a new game - notify the listeners and call setupNewGame
    private void updateNewGame() {
        this.notifier.NotifyNewBoard();
        this.setupNewGame();
    }


    private final void createImages() {
        try {
            URL url = new URL("http://i.stack.imgur.com/memI0.png");
            BufferedImage bi = ImageIO.read(url);
            for (int ii = 0; ii < 2; ii++) {
                for (int jj = 0; jj < 6; jj++) {
                    chessPieceImages[ii][jj] = bi.getSubimage(
                            jj * 64, ii * 64, 64, 64);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }


    // set the component that will get data from the user
    @Override
    public void setNotifier(BoardNotifier notifier) {
        this.notifier = notifier;
    }

    // set the components that will be notified with data from the user
    @Override
    public void addBoardListener(BoardListener ml) {
        this.notifier.addBoardListener(ml);
    }

    //Initializes the icons of the initial chess board piece places

    private final void setupNewGame() {
        message.setText("Make your move!");
        // set up the black pieces
        for (int i = 0; i < currentPositionS.length; i++) {
            for (int j = 0; j < currentPositionS.length; j++) {
                //set the listener - the notifier listens to each JButton
                chessBoardSquares[i][j] = (JButton)this.notifier.addBoardNotifier(chessBoardSquares[i][j]);

                Tool tool = this.currentPositionS[i][j].getTool();
                if (tool.toString().equals("Empty")) {
                    chessBoardSquares[j][i].setIcon(null);
                    continue;
                }
                if (this.currentPositionS[i][j].getTool().isWhite() == true) {
                    chessBoardSquares[j][i].setIcon(new ImageIcon(
                            chessPieceImages[WHITE][this.map.get(tool.toString())]));
                } else {
                    chessBoardSquares[j][i].setIcon(new ImageIcon(
                            chessPieceImages[BLACK][this.map.get(tool.toString())]));
                }
                chessBoardSquares[j][i].setName(tool.toString());
            }
        }
    }

    // rearrange the game according to move, and update chessBoardSquares
    private final void setupGame(){
        if (this.currentMove == null) return;
        int x = this.currentMove.getStart().getY();
        int y = this.currentMove.getStart().getX();
        Tool tool = this.currentMove.getStart().getTool();
        chessBoardSquares[x][y].setIcon(null);
        this.currentPositionS[y][x].setTool(c.get(EnumTool.Empty));

        int xe = this.currentMove.getEnd().getY();
        int ye = this.currentMove.getEnd().getX();
        if (this.currentMove.getStart().getTool().isWhite() == true) {
            chessBoardSquares[xe][ye].setIcon(new ImageIcon(
                    chessPieceImages[WHITE][this.map.get(tool.toString())]));
        } else {
            chessBoardSquares[xe][ye].setIcon(new ImageIcon(
                    chessPieceImages[BLACK][this.map.get(tool.toString())]));
        }
        chessBoardSquares[xe][ye].setName(tool.toString());
        this.currentPositionS[ye][xe].setTool(tool);
    }

}
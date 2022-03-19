package BoardUI;


import Game.UIGameMenu;

import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.event.MenuListener;
import java.util.Set;

public class UIGameMenuJFrame extends JFrame implements UIGameMenu, ActionListener{

    private JFrame F;
    private JMenuBar menuBar;
    private JMenu menu1;
    private List<JMenuItem> items;
    private String returnStatus;
    private List<MenuListener> menuListener;

    public UIGameMenuJFrame(){
        this.F = new JFrame("chess");
        this.menuBar = new JMenuBar();
        this.menu1 = new JMenu("options");
        this.items = new ArrayList<>();
        this.menuListener = new ArrayList<>();
        menuBar.add(menu1);
        F.setJMenuBar(menuBar);
        F.setSize(300,100);
        F.setVisible(true);
    }

    @Override
    public void show(Set<String> op) {
        for (String game:op) {
            JMenuItem item = new JMenuItem(game);
            this.items.add(item);
            item.addActionListener(this);
            this.menu1.add(item);
        }
    }

    @Override
    public void addMenuListener(MenuListener ml) {
        this.menuListener.add(ml);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.returnStatus = e.getActionCommand();
        for (MenuListener ml:this.menuListener) {
            ml.notify(this.returnStatus);
        }
        F.setVisible(false);
        F.dispose(); //Destroy the JFrame object
    }


}


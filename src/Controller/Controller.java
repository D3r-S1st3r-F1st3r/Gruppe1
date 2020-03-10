package Controller;

import Model.Model;
import View.BoardView;
import View.ButtonView;
import View.StartScreenView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Controller implements ActionListener, MouseListener {

    private StartScreenView startscreenview;
    private BoardView boardView;
    private Model model;

    public Controller(){
        this.startscreenview = new StartScreenView(this);
        this.boardView = new BoardView(this);
        this.model = new Model();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == startscreenview.getStartButton()){
            startscreenview.setVisible(false);
            boardView.initGui();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
      ButtonView button = (ButtonView) e.getSource();

      //System.out.println(button.getXKor()+ " - " +button.getYKor());
      int zahl1 = button.getXKor();
      int zahl2 = button.getYKor();
      model.checkBomb(zahl1, zahl2);
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

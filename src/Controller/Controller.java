package Controller;

import Model.Model;
import View.BoardView;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Controller implements MouseListener {

    private BoardView boardView;
    private Model model;

    public Controller(){
        this.boardView = new BoardView();
        this.model = new Model();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        //Aktion nachdem das Spiel durch den "Start" Button gestartet wird
        if(e.getSource() == this.boardView.getStartButton()){
            boardView.initGame();
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

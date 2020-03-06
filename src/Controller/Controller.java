package Controller;

import Model.Model;
import View.BoardView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Controller implements ActionListener {

    private BoardView boardView;
    private Model model;

    public Controller(){
        this.boardView = new BoardView(this);
        this.model = new Model();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == boardView.getStartButton()){

            boardView.closeStartScreen();

        }
    }
}

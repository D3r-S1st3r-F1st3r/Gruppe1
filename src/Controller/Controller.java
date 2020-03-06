package Controller;

import Model.Model;
import View.BoardView;
import View.StartScreenView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Controller implements ActionListener {

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
}

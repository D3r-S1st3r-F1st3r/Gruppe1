package Controller;

import Model.Model;
import View.BoardView;
import View.ButtonView;
import View.StartScreenView;
import Model.FieldModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Controller implements ActionListener, MouseListener {

    private StartScreenView startscreenview;
    private BoardView boardView;
    private Model model;
    private FieldModel[][] fieldmodel = new FieldModel[16][16];

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

            //Feld wird im Model erstellt
            model.initFields();

            //Bomben werden im Model gesetzt
            model.setBombs();

            startPointDrawing();

            try {
                model.initPoints();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
      ButtonView button = (ButtonView) e.getSource();

      //System.out.println(button.getXKor()+ " - " +button.getYKor());
      int zahl1 = button.getYKor();
      int zahl2 = button.getXKor();

      //Bei einem Click auf die RECHTE Maustaste -> Flagge platzieren
      if(SwingUtilities.isRightMouseButton(e)){
          if(model.getFlagStatus(zahl1, zahl2) == false){
              boardView.setFlag(zahl1, zahl2);
              model.setFlag(zahl1,zahl2);
          }else{
              model.setFlag(zahl1,zahl2);
              boardView.deleteFlag(zahl1,zahl2);
          }
      }

      //Bei einem Click auf die LINKE Maustaste -> Feld aufdecken
      if(SwingUtilities.isLeftMouseButton(e)){
          //Wenn auf dem Feld eine Bombe = Spiel verloren
          if(model.checkBomb(zahl1, zahl2) == true){
              gameLoseAction();
          }else{
              System.out.println(zahl1+ "-" +zahl2);
              boardView.setButtonEnabled(zahl1, zahl2);
          }
      }
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

    public void startPointDrawing(){
        this.fieldmodel = model.getListWithPoints();

        for(int i = 0; i < fieldmodel.length; i++){
            for(int j = 0; j <fieldmodel[i].length; j++){
                boardView.setPoints(i, j, fieldmodel[i][j].getValue());
            }
        }
    }

    public void gameLoseAction(){
        System.out.println("BÄÄÄÄÄÄÄÄÄÄÄÄHM VERLOREN");
    }
}

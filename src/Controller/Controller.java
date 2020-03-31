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
    private boolean spielstatus = true;

    public Controller(){
        this.startscreenview = new StartScreenView(this);
        this.boardView = new BoardView(this);
        this.model = new Model();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == startscreenview.getStartButton()){
            model.setMinenAnzahl(startscreenview.setDifficulty());

            startscreenview.setVisible(false);
            boardView.initGui();

            //Feld wird im Model erstellt
            model.initFields();

            //Bomben werden im Model gesetzt
            model.setBombs();

            try {
                model.initPoints();
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            boardView.initAnzeige(model.getMinesLeft(), model.checkPoints());
            startPointDrawing();
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

          if(model.getFlagStatus(zahl1, zahl2) == false && fieldmodel[zahl1][zahl2].getShownStatus() == false && boardView.getSpielFeldButtonsBombeAufgedeckt(zahl1,zahl2) == false){
              boardView.setFlag(zahl1, zahl2);
              model.setFlag(zahl1,zahl2);
          }else if (model.getFlagStatus(zahl1, zahl2) == true && fieldmodel[zahl1][zahl2].getShownStatus() == false && boardView.getSpielFeldButtonsBombeAufgedeckt(zahl1,zahl2) == false){
              model.setFlag(zahl1,zahl2);
              boardView.deleteFlag(zahl1,zahl2);
          }
      }

      //Bei einem Click auf die LINKE Maustaste -> Feld aufdecken
      if(SwingUtilities.isLeftMouseButton(e)) {

          if (spielstatus == true) {
              //Wenn auf dem Feld eine Bombe = Spiel verloren
              if (model.checkBomb(zahl1, zahl2) == true) {
                  gameLoseAction();
              } else {

                  //"Button wird angezeigt" im Model merken
                  fieldmodel[zahl1][zahl2].setShownActive();
                  boardView.deleteFlag(zahl1, zahl2);

                  model.checkNeighborhood(zahl1, zahl2);

                  //Punkteanzahl vom aufgedeckten Feld anzeigen
                  startPointDrawing();
              }
              boardView.initAnzeige(model.getMinesLeft(), model.checkPoints());
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

    //Methode prüft nach jedem Klick, welche Felder sichtbar sein müssten und disabled die Button und zeigt deren Punkte an
    public void startPointDrawing(){
        this.fieldmodel = model.getListWithPoints();

        for(int i = 0; i < fieldmodel.length; i++){
            for(int j = 0; j <fieldmodel[i].length; j++){
                if(fieldmodel[i][j].getShownStatus()==true){
                    boardView.setPoints(i, j, fieldmodel[i][j].getValue());
                    boardView.setButtonEnabled(i, j);
                }
            }
        }
    }

    public void gameLoseAction(){
        System.out.println("BÄÄÄÄÄÄÄÄÄÄÄÄHM VERLOREN");
        spielstatus = false;

        for(int i = 0; i < fieldmodel.length; i++){
            for(int j = 0; j < fieldmodel[i].length; j++){
                if(fieldmodel[i][j].getBombActive()){
                    boardView.showBombs(i,j);
                }
            }
        }

    }
}

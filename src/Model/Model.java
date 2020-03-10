package Model;

import View.BoardView;

import java.util.List;
import java.util.Random;

public class Model {

    BoardView boardView;
    FieldModel[][] fieldModel = new FieldModel[15][15];

    //random generator
    Random randomizer = new Random();

    //different counter
    private int minesLeft;
    private int flagCount;

    //Anzahl der Minen
    private int minenAnzahl = 25;

    public void initFields(){
        for(int i = 0; i < 15; i++){
            for (int j = 0; j < 15; j++){
                fieldModel[i][j] = new FieldModel();
            }
        }
    }

    //setzt automatisch zufüllig Bomben im [][] Array
    public void setBombs(){

        for(int i = 0; i < minenAnzahl; i++){
            int zahl1 = randomizer.nextInt(15);
            int zahl2 = randomizer.nextInt(15);

            fieldModel[zahl1][zahl2].setBombActive();
        }
    }

    public boolean checkBomb(int i, int j){
        if(fieldModel[i][j].getBombActive() == true){
            return true;
        }else{
            setDisabledButton(i,j);
            return false;
        }
    }

    //Aktion, wenn Button gedrückt wurde
    public void setDisabledButton(int i, int j){
            fieldModel[i][j].setFlag(false);
            fieldModel[i][j].setShownActive();
    }

    //Aktion wenn Flagge gesetzt/entfernt wird
    public void setFlag(int i, int j){
        if(fieldModel[i][j].getFlag() == true){
            fieldModel[i][j].setFlag(false);
        }else{
            fieldModel[i][j].setFlag(true);
        }
    }

    public boolean getFlagStatus(int i, int j){
        return fieldModel[i][j].getFlag();
    }

}

package Model;

import View.BoardView;

import java.util.List;
import java.util.Random;

public class Model {

    BoardView boardView;
    FieldModel[][] fieldModel = new FieldModel[16][16];

    //random generator
    Random randomizer = new Random();

    //different counter
    private int minesLeft;
    private int flagCount;

    //Anzahl der Minen
    private int minenAnzahl = 100;

    public void initFields(){
        for(int i = 0; i < 16; i++){
            for (int j = 0; j < 16; j++){
                fieldModel[i][j] = new FieldModel();
            }
        }
    }

    //setzt automatisch zufüllig Bomben im [][] Array
    public void setBombs(){

        for(int i = 0; i < minenAnzahl; i++){
            int zahl1 = randomizer.nextInt(16);
            int zahl2 = randomizer.nextInt(16);

            fieldModel[zahl1][zahl2].setBombActive();

        }
    }

    public void initPoints() throws Exception {
        for(int i = 0; i < 16; i++){
            for(int j = 0; j < 16; j++){
                setValues(i,j);
            }
        }
    }

    //Werte werden gesetzt
    public void setValues(int i, int j) throws Exception{

        try{
            for(int xAchse = i - 1; xAchse <= i + 1; xAchse++){
                for(int yAchse = j - 1; yAchse <= j+1; yAchse++){
                    if(fieldModel[xAchse][yAchse].getBombActive() == true){
                        fieldModel[i][j].setValue();
                    }
                }
            }
        }   catch (ArrayIndexOutOfBoundsException ao){

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

    public void getPointsToDraw(){

    }
}

package Model;

import View.BoardView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Model {

    BoardView boardView;
    FieldModel[][] fieldModel = new FieldModel[16][16];

    //random generator
    Random randomizer = new Random();

    //window size
    private int fieldWidth = 16;
    private int fieldHeight = 16;


    //different counter
    private int minesLeft;
    private int flagCount;

    //Anzahl der Minen
    private int minenAnzahl = 25;

    public void initFields(){
        for(int i = 0; i < fieldWidth; i++){
            for (int j = 0; j < fieldHeight; j++){
                fieldModel[i][j] = new FieldModel();
            }
        }
    }

    //setzt automatisch zufüllig Bomben im [][] Array
    public void setBombs(){
        int c = 0;
        while (c < minenAnzahl+1){
            for(int i = 0; i< fieldWidth; i++){
                for(int j = 0; j< fieldHeight; j++){
                    if(randomizer.nextInt(100) <= 5){
                        if(!fieldModel[i][j].getBombActive()) {
                            fieldModel[i][j].setBombActive();
                            fieldModel[i][j].setBombValue(50);
                            c++;
                        }
                    }
                }
            }
        }

/*
        for(int i = 0; i < minenAnzahl; i++){

            int zahl1 = randomizer.nextInt(16);
            int zahl2 = randomizer.nextInt(16);
            if(!bombAktiv){
            fieldModel[zahl1][zahl2].setBombActive();
            fieldModel[zahl1][zahl2].setBombValue(50);
        }*/
    }

    public void initPoints() throws Exception {
        for(int i = 0; i < 16; i++){
            for(int j = 0; j < 16; j++){
                setValues(i,j);
            }
        }
    }

    //Werte werden gesetzt
    public void setValues(int i, int j) throws Exception {

                for (int xAchse = i - 1; xAchse <= i + 1; xAchse++) {
                    for (int yAchse = j - 1; yAchse <= j + 1; yAchse++) {
                        try {if (fieldModel[xAchse][yAchse].getBombActive()) {
                            fieldModel[i][j].setValue();
                        }
                        }
                        catch (ArrayIndexOutOfBoundsException ao) {
                            continue;

                        }
                    }
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

    public FieldModel[][] getListWithPoints(){
        return this.fieldModel;
    }

    public void checkNeighborhood(int y, int x){

        if(fieldModel[y][x].getValue() == 0){

            for(int i = y-1; i <= y+1; i++){
                for(int j = x-1; j <= x+1; j++){

                    try {
                        if (fieldModel[i][j].getValue() == 0 && fieldModel[i][j].getShownStatus() == false) {
                            fieldModel[i][j].setShownActive();

                            for(int eins = i-1; eins <= i+1; eins++){
                                for(int zwei = j-1; zwei <= j+1; zwei++){
                                    fieldModel[eins][zwei].setShownActive();
                                }
                            }
                            checkNeighborhood(i, j);
                        }
                    }catch (ArrayIndexOutOfBoundsException ao){

                    }
                }
            }
        }
    }
}

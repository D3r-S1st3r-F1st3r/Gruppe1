package Model;

import View.BoardView;

import javax.swing.*;
import java.util.Random;

public class Model {

    BoardView boardView;
    FieldModel[][] fieldModel;

    //random generator
    Random randomizer = new Random();

    //different counter
    private int minesLeft;
    private int flagCount;

    //Anzahl der Minen
    private int minenAnzahl = 25;


    public void initFields(){
        for(int i = 0; i < 16; i++){
            for (int j = 0; j < 16; j++){
                fieldModel = new FieldModel[i][j];
            }
        }
    }

    public void setBombs(){

        for(int i = 0; i < minenAnzahl; i++){
            int zahl1 = randomizer.nextInt(15);
            int zahl2 = randomizer.nextInt(15);

            fieldModel[zahl1][zahl2].setBombActive();

        }
    }

}

package Model;

import View.BoardView;

import javax.swing.*;

public class Model {

    BoardView boardView;

    //different counter
    private int minesLeft;
    private int secounds;
    private int flagCount;

    //Anzahl der Minen
    private int minenAnzahl = 50;

    //field size
    private int xFields = 16;
    private int yFields = 16;

}

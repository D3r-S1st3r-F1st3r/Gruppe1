package View;

import javax.swing.*;
import java.awt.*;

public class BoardView extends JFrame {

    //Komponenten
    JFrame jfr;             //Basisfenster

    JPanel startScreen;     //JPanel in dem der Startscreen angezeigt wird
    JButton startGame;      //Button, der das Spiel startet
    JButton endGame;        //Button, der das Spiel beendet

    JPanel gameScreen;      //JPanel in dem das Spielfeld angezeigt wird

    private int board_width = 800;
    private int board_height = 800;

    public BoardView(){
        jfr = new JFrame();
        jfr.setTitle("Minesweeper");
        jfr.setSize(board_width,board_height);
        jfr.setResizable(false);
        jfr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jfr.setVisible(true);

        //Fenster werden erstmal erstellt
        initStartScreen();
        addStartScreen();
        initGame();

    }

    //Start Screen wird initialisiert
    public void initStartScreen(){
        startScreen = new JPanel();                 //Panel wird erstellt

        startGame = new JButton("Spiel starten");      //Button wird erstellt und in das Panel eingefügt
        startScreen.add(startGame);
    }

    //Game Screen wird initialisiert
    public void initGame(){
        gameScreen = new JPanel();
    }

    //Startscreen wird im Fenster angezeigt
    public void addStartScreen(){
        jfr.add(startScreen);
    }

    //Spiel wird im Fenster angezeigt
    public void addGameScreen(){
        jfr.remove(startScreen);
        jfr.add(gameScreen);
    }

    //Buttonreaktion
    public JButton getStartButton(){
        return this.startGame;
    }
}

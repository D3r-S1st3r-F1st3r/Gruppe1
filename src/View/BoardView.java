package View;

import javax.swing.*;
import java.awt.*;

public class BoardView extends JFrame {

    //Komponenten
    JFrame jfr;             //Basisfenster
    Container contentPane;
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
        jfr.setResizable(true);
        jfr.setLocationRelativeTo(null);
        jfr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        contentPane = jfr.getContentPane();
        contentPane.setLayout(new BorderLayout());

        jfr.setVisible(true);

        initStartScreen();
    }

    //Start Screen wird initialisiert
    public void initStartScreen(){
        startScreen = new JPanel();                 //Panel wird erstellt
        startGame = new JButton("Spiel starten");      //Button wird erstellt und in das Panel eingefügt

        startScreen.add(startGame);
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

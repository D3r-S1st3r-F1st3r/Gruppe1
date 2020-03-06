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
        jfr.setPreferredSize(new Dimension(board_width,board_height));
        jfr.setResizable(false);
        jfr.setVisible(true);
        initStartScreen();
    }

    public void initStartScreen(){
        startGame = new JButton("Spiel starten");
    }

    public void initGame(){

    }
    public JButton getStartButton(){
        return this.startGame;
    }
}

package View;

import Controller.Controller;

import javax.sound.midi.ControllerEventListener;
import javax.swing.*;
import java.awt.*;

public class BoardView extends JFrame {

    Controller controller;

    //Komponenten
    private JFrame jfr;             //Basisfenster
    private Container contentPane;

    private JPanel gameScreen;      //JPanel in dem das Spielfeld angezeigt wird

    private int board_width = 800;
    private int board_height = 800;

    public BoardView(Controller controller){
           this.controller = controller;
    }

    public void initGui(){
        jfr = new JFrame();
        jfr.setTitle("Minesweeper - Game Window");
        jfr.setSize(board_width, board_height);
        jfr.setResizable(true);
        jfr.setLocationRelativeTo(null);
        jfr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        contentPane = jfr.getContentPane();
        contentPane.setLayout(new BorderLayout());
        jfr.setVisible(true);
    }

    public int getWidth(){
        return this.board_width;
    }

    public int getHeight(){
        return this.board_height;
    }
}

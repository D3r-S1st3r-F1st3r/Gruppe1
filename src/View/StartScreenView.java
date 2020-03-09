package View;

import Controller.Controller;

import javax.sound.midi.ControllerEventListener;
import javax.swing.*;
import java.awt.*;

public class StartScreenView extends JFrame {

    private boolean startScreenActive = true;

    Controller controller;

    //Komponenten
    private JFrame jfr;             //Basisfenster
    private Container contentPane;
    private JPanel startScreen;     //JPanel in dem der Startscreen angezeigt wird

    private JButton startGame;

    private int board_width = 800;
    private int board_height = 800;
    private boolean visible = true;

    public StartScreenView(Controller controller){
        this.controller = controller;

        jfr = new JFrame();
        jfr.setTitle("Minesweeper - Startscreen");
        jfr.setSize(board_width,board_height);
        jfr.setResizable(true);
        jfr.setLocationRelativeTo(null);
        jfr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        contentPane = jfr.getContentPane();
        contentPane.setLayout(new GridLayout());

        jfr.setVisible(true);

        initStartScreen();
    }

    //Startscreen wird erstellt
    public void initStartScreen(){
        startScreen = new JPanel();

       startGame = new JButton("");

        startGame.addActionListener(controller);

        startScreen.add(startGame);
        contentPane.add(startScreen);
    }

    //Buttonreaktion
    public JButton getStartButton(){
        return this.startGame;
    }

    public void setVisible(boolean wert){
        if(wert == true){
            this.jfr.setVisible(true);
        } else if(wert == false){
            this.jfr.setVisible(false);
        }
    }
}

package View;

import Controller.Controller;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class StartScreenView extends JFrame {

    Controller controller;

    //Komponenten
    private JFrame jfr;             //Basisfenster
    private Container contentPane;
    private JPanel startScreen;     //JPanel in dem der Startscreen angezeigt wird


    private JLabel lbl1;
    private ButtonGroup gruppe;
    private JPanel boxPanel;
    private JRadioButton low;
    private JRadioButton middle;
    private JRadioButton hard;


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
        contentPane.setLayout(new BorderLayout());

        jfr.setVisible(true);

        initStartScreen();
    }

    //Startscreen wird erstellt
    public void initStartScreen(){
        startScreen = new JPanel();
        boxPanel = new JPanel();
        boxPanel.setLayout(new BoxLayout(boxPanel,BoxLayout.PAGE_AXIS));

        gruppe = new ButtonGroup();

        lbl1 = new JLabel("Schwierigkeitsgrad wählen:");
        lbl1.setAlignmentX(Component.CENTER_ALIGNMENT);


        low = new JRadioButton("leicht (25 Minen)");
        low.setAlignmentX(Component.CENTER_ALIGNMENT);
        low.setSelected(true);
        middle = new JRadioButton("mittel (50 Minen)");
        middle.setAlignmentX(Component.CENTER_ALIGNMENT);
        hard = new JRadioButton("schwer (75 Minen)");
        hard.setAlignmentX(Component.CENTER_ALIGNMENT);

        gruppe.add(low);
        gruppe.add(middle);
        gruppe.add(hard);

        startGame = new JButton("Spiel starten");
        startGame.setAlignmentX(Component.CENTER_ALIGNMENT);

        startGame.addActionListener(controller);

        boxPanel.add(lbl1);
        boxPanel.add(low);
        boxPanel.add(middle);
        boxPanel.add(hard);
        //startScreen.add(boxPanel);
        boxPanel.add(startGame);
        contentPane.add(boxPanel, BorderLayout.CENTER);
       // contentPane.add(startScreen, BorderLayout.CENTER);
    }

    //Buttonreaktion
    public JButton getStartButton(){
        return this.startGame;
    }


    public int setDifficulty(){

        int output;

        if(low.isSelected()){
            output = 25;
            System.out.println("leicht ausgewählt");
        } else if(middle.isSelected()){
            output = 50;
            System.out.println("mittel ausgewählt");
        } else{
            output = 75;
            System.out.println("schwer ausgewählt");
        }

        return output;
    }

    public void setVisible(boolean wert){
        if(wert == true){
            this.jfr.setVisible(true);
        } else if(wert == false){
            this.jfr.setVisible(false);
        }
    }
}

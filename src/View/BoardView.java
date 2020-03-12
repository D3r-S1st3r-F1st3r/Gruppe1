package View;

import Controller.Controller;

import javax.swing.*;
import java.awt.*;

public class BoardView extends JFrame {

    Controller controller;

    private int score;

    //Komponenten
    private JFrame jfr;             //Basisfenster
    private Container contentPane;
    private JPanel spielfeld;

    //Anzeige
    private JPanel anzeige;
    private JLabel minesLeftLabel;      //left
    private JTextField minesLeftField;
    private JPanel left;
    private JPanel center;
    private JLabel pointsCollectedLabel;    //right
    private JTextField pointsCollectedField;
    private JPanel right;

    private JButton[][] spielfeldButtons = new JButton[16][16];

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

        //Anzeige
        anzeige = new JPanel();
        anzeige.setLayout(new BorderLayout());

        //Spielfeld
        spielfeld = new JPanel();
        spielfeld.setLayout(new GridLayout(16,16));

        initSpielfeld();

    }

    public int getWidth(){
        return this.board_width;
    }

    public int getHeight(){
        return this.board_height;
    }


    public void initAnzeige(int minenAnzahl, int punkteanzahl){

        //Panel für linke Anzeigeinhalt mit Flowlayout
        left = new JPanel();
        left.setLayout(new FlowLayout());

        //Label und Textfield wird konfiguriert und in Panel eingefügt
        minesLeftLabel = new JLabel("Minenanzahl: ");
        minesLeftField = new JTextField(3);
        minesLeftField.setText(String.valueOf(minenAnzahl));
        minesLeftField.setBackground(null);
        minesLeftField.setEditable(false);
        minesLeftField.setHorizontalAlignment(JTextField.CENTER);
        left.add(minesLeftLabel);
        left.add(minesLeftField);

        right = new JPanel();
        right.setLayout(new FlowLayout());

        //Label und Textfield wird konfiguriert und in Panel eingefügt
        pointsCollectedLabel = new JLabel("Punkte: ");
        pointsCollectedField = new JTextField(5);
        pointsCollectedField.setText(String.valueOf(punkteanzahl));
        pointsCollectedField.setHorizontalAlignment(JTextField.CENTER);
        pointsCollectedField.setBackground(null);
        pointsCollectedField.setEditable(false);
        pointsCollectedField.setForeground(Color.RED);
        right.add(pointsCollectedLabel);
        right.add(pointsCollectedField);


        anzeige.add(left, BorderLayout.LINE_START);
        anzeige.add(right, BorderLayout.LINE_END);

        contentPane.add(anzeige, BorderLayout.PAGE_START);
    }


    public void initSpielfeld(){

        for(int i = 0; i < 16; i++){
            for(int j = 0; j < 16; j++){
                spielfeldButtons[i][j] = new ButtonView(i,j);

                spielfeldButtons[i][j].addMouseListener(controller);

                spielfeld.add(spielfeldButtons[i][j]);
            }
        }

        contentPane.add(spielfeld,BorderLayout.CENTER);
    }

    public void setButtonEnabled(int zahl1, int zahl2){
        spielfeldButtons[zahl1][zahl2].setEnabled(false);

    }

    //Flagge wird in der View gesetzt
    public void setFlag(int zahl1, int zahl2){

        spielfeldButtons[zahl1][zahl2].setText("F");
    }


    //Flagge wird in der View gelöscht
    public void deleteFlag(int zahl1, int zahl2){

        spielfeldButtons[zahl1][zahl2].setText("");
    }

    public void showBombs(int zahl1, int zahl2){

        spielfeldButtons[zahl1][zahl2].setText("B");

    }


    public void setPoints(int zahl1, int zahl2, int value){
        if(value != 0){
            spielfeldButtons[zahl1][zahl2].setText(String.valueOf(value));
        }
    }
}

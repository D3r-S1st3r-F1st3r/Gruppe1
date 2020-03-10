package View;

import javax.swing.*;

public class ButtonView extends JButton {

    private int xKor;
    private int yKor;

    public ButtonView(int i, int j){
        super();
        this.xKor = j;
        this.yKor = i;
    }

    public int getXKor(){
        return this.xKor;
    }

    public int getYKor(){
        return this.yKor;
    }
}

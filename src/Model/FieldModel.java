package Model;

public class FieldModel {

    private boolean shown = false;
    private boolean bomb = false;
    private boolean flag = false;
    private int value = 0;

    public void setShownActive(){
        this.shown = true;
    }

    public void setBombActive(){
        this.bomb = true;
    }

    public void setFlag(boolean wert){
        this.flag = wert;
    }

    public void setValue(int value){
        this.value = value;
    }

    public boolean getBombActive(){

        return this.bomb;
    }
}

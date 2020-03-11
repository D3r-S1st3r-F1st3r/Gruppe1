package Model;

public class FieldModel {

    private boolean shown = false;
    private boolean bomb = false;
    private boolean flag = false;
    private int value = 0;

    public FieldModel(){
        this.shown = false;
        this.bomb = false;
        this.flag = false;
        this.value = 0;
    }

    public void setShownActive(){
        this.shown = true;
    }

    public void setBombActive(){

        this.bomb = true;
    }

    public void setFlag(boolean wert){

        this.flag = wert;
    }

    public boolean getFlag(){
        return this.flag;
    }

    public void setValue(){

        this.value++;
    }

    public int getValue(){
        return this.value;
    }

    public boolean getBombActive(){

        return this.bomb;
    }
}

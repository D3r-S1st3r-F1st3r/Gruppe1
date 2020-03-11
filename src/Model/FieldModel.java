package Model;

public class FieldModel {

    //allgemeine Variablen
    private boolean shown = false;
    private boolean bomb = false;
    private boolean flag = false;
    private int value = 0;

    //Konstruktor zu Erstellung des Feldes
    public FieldModel(){
        this.shown = false;
        this.bomb = false;
        this.flag = false;
        this.value = 0;
    }

    //Setter und Getter

    public void setShownActive(){
        this.shown = true;
    }

    public boolean getShownStatus(){
        return this.shown;
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

    public void setBombValue(int value){
        this.value += value;
    }

    public int getValue(){
        return this.value;
    }

    public boolean getBombActive(){

        return this.bomb;
    }
}

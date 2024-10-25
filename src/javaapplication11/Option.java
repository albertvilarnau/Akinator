package javaapplication11;

public class Option {
    private String text;
    private boolean hasComeOut;

    public Option(String text){
        this.text = text;
        this.hasComeOut = false;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setHasComeOut(boolean hasComeOut) {
        this.hasComeOut = hasComeOut;
    }

    public boolean getHasComeOut() {
        return hasComeOut;
    }
}

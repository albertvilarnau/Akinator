package javaapplication11;

public class Question {
    private String base_question;
    private boolean isElegible;
    private Option[] options;

    public Question(String base_question, Option[] options){
        this.base_question = base_question;
        this.options = options;
        this.isElegible = true;
    }

    public Option[] getOptions() {
        return options;
    }

    public void setOptions(Option[] options) {
        this.options = options;
    }

    public String getBase_question() {
        return base_question;
    }

    public void setBase_question(String base_question) {
        this.base_question = base_question;
    }

    public boolean getElegible(){
        return isElegible;
    }

    public void setElegible(boolean elegible) {
        isElegible = elegible;
    }


}

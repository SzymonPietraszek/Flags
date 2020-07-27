package application.backend.questionSelection;

public enum Conjunction {
    AND(" and "), OR(" or ");

    public String string;

    Conjunction(String option) {
        this.string = option;
    }

    public String toString(){
        return this.string;
    }
}

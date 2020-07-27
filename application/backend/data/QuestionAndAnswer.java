package application.backend.data;

import java.util.BitSet;

public class QuestionAndAnswer {
    private final String QUESTION;
    private final BitSet FLAGS_ANSWER = new BitSet(Data.NUMBER_OF_FLAGS);

    QuestionAndAnswer(String question, int[] flagsWithYes) {
        this.QUESTION = question;
        for (int flag : flagsWithYes) {
            FLAGS_ANSWER.set(flag);
        }
    }

    public boolean getAnswer(int flag) {
        return FLAGS_ANSWER.get(flag);
    }

    public String getQuestion() {
        return QUESTION;
    }
}
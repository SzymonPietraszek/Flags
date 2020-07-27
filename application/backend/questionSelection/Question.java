package application.backend.questionSelection;

import application.backend.ActiveFlags;
import application.backend.data.Data;

public class Question {
    private int questionNumber1;
    private int questionNumber2;//if there is one question only questionNumber1 is equal questionNumber2
    private Conjunction questionConjunction;//if there is one question only questionConjunction is null
    private int score;

    public Question(int questionNumber, ActiveFlags activeFlags) {
        this(questionNumber, questionNumber, null, activeFlags);
    }

    public Question(int questionNumber1, int questionNumber2, Conjunction questionConjunction, ActiveFlags activeFlags) {
        this.questionNumber1 = questionNumber1;
        this.questionNumber2 = questionNumber2;
        this.questionConjunction = questionConjunction;
        setScore(activeFlags);
    }

    public String toString() {
        return "Does your flag has " + Data.getQuestion(questionNumber1) +
                (isSingleQuestion() ? "" : questionConjunction + Data.getQuestion(questionNumber2))
                + "?";
    }

    public boolean getAnswerFor(int flag) {
        if (isSingleQuestion()) {
            return Data.getAnswer(questionNumber1, flag);
        } else if (isConjunctionAnd()) {
            return (Data.getAnswer(questionNumber1, flag) && Data.getAnswer(questionNumber2, flag));
        } else {
            return (Data.getAnswer(questionNumber1, flag) || Data.getAnswer(questionNumber2, flag));
        }
    }

    public int getScore() {
        return score;
    }


    private boolean isSingleQuestion() {
        return questionNumber1 == questionNumber2;
    }

    private boolean isConjunctionAnd() {
        return Conjunction.AND.equals(questionConjunction);
    }

    private void setScore(ActiveFlags activeFlags) {
        score = 0;
        for (int flag = 0; flag < Data.NUMBER_OF_FLAGS; ++flag)
            if (activeFlags.isFlagActive(flag))
                addToScore(flag);

        score = Math.abs(score);
    }

    private void addToScore(int flag) {
        if (isSingleQuestion()) {
            score += (Data.getAnswer(questionNumber1, flag) ? 1 : -1);
        } else {
            score += addToScoreMultipleQuestions(flag);
        }
    }

    private int addToScoreMultipleQuestions(int flag) {
        if (isConjunctionAnd()) {
            return (Data.getAnswer(questionNumber1, flag) && Data.getAnswer(questionNumber2, flag)) ? 1 : -1;
        } else {//OR
            return (Data.getAnswer(questionNumber1, flag) || Data.getAnswer(questionNumber2, flag)) ? 1 : -1;
        }
    }
}

package application.backend.questionSelection;


import application.backend.ActiveFlags;
import application.backend.data.Data;

public class QuestionSelection {

    private Question question;
    private ActiveFlags activeFlags;

    public QuestionSelection(ActiveFlags activeFlags) {
        this.activeFlags = activeFlags;
    }

    public String getQuestion() {
        selectQuestion();
        return question.toString();
    }

    public void changeActiveFlagsAfterQuestion(boolean answer) {
        activeFlags.changeActiveFlags(question, answer);
    }

    private void selectQuestion() {
        question = new Question(0, activeFlags);

        for (int q = 1; q < Data.NUMBER_OF_QUESTIONS; ++q)
            setQuestionIfScoreIsBetter(q, q, null);

        for (int q1 = 0; q1 < Data.NUMBER_OF_QUESTIONS; ++q1)
            for (int q2 = q1 + 1; q2 < Data.NUMBER_OF_QUESTIONS; ++q2) {
                setQuestionIfScoreIsBetter(q1, q2, Conjunction.AND);
                setQuestionIfScoreIsBetter(q1, q2, Conjunction.OR);
            }
    }

    private void setQuestionIfScoreIsBetter(int questionNumber1, int questionNumber2, Conjunction questionConjuction) {
        Question nextQuestion = new Question(questionNumber1, questionNumber2, questionConjuction, activeFlags);
        if (nextQuestion.getScore() < question.getScore())
            question = nextQuestion;
    }
}

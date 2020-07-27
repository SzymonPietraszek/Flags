package application.backend;

import application.backend.data.Data;
import application.backend.questionSelection.QuestionSelection;
import application.frontend.BackendPlugin;

public class Backend implements BackendPlugin {
    private QuestionSelection questionSelection;
    private ActiveFlags activeFlags;

    public Backend(){
        resetActiveFlags();
    }

    public int numberOfFlags() {
        return Data.NUMBER_OF_FLAGS;
    }

    public String getQuestion() {
        return questionSelection.getQuestion();
    }

    public boolean isFlagActive(int flag) {
        return activeFlags.isFlagActive(flag);
    }

    public boolean oneFlagLeft() {
        return activeFlags.oneFlagLeft();
    }

    public boolean noFlagsLeft() {
        return activeFlags.noFlagsLeft();
    }

    public int getFirstActiveFlagNumber() {
        return activeFlags.getFirstActiveFlagNumber();
    }

    public void changeActiveFlagsAfterQuestion(boolean answer) {
        questionSelection.changeActiveFlagsAfterQuestion(answer);
    }

    public boolean areTwoLastFlagsTheSame() {
        return activeFlags.areTwoLastFlagsTheSame();
    }

    public void changeActiveFlagsAfterLastQuestion(boolean answer) {
        activeFlags.changeActiveFlagsAfterLastQuestion(answer);
    }

    public void resetActiveFlags(){
        activeFlags = new ActiveFlags();
        questionSelection = new QuestionSelection(activeFlags);
    }
}

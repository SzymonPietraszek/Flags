package application.backend;

import application.backend.data.Data;
import application.backend.questionSelection.Question;

import java.util.BitSet;

public class ActiveFlags {
    private BitSet activeFlags;
    private int flagsLeft;

    public ActiveFlags() {
        activeFlags = new BitSet(Data.NUMBER_OF_FLAGS);
        activeFlags.set(0, Data.NUMBER_OF_FLAGS);
        flagsLeft = Data.NUMBER_OF_FLAGS;
    }

    public boolean isFlagActive(int flag) {
        return activeFlags.get(flag);
    }

    public boolean noFlagsLeft() {
        return flagsLeft == 0;
    }

    public boolean oneFlagLeft() {
        return flagsLeft == 1;
    }

    public int getFirstActiveFlagNumber() {
        return getFirstActiveFlagNumber(0);
    }

    private Integer getFirstActiveFlagNumber(int startFlagNumber) {
        for (int flagNumber = startFlagNumber; flagNumber < Data.NUMBER_OF_FLAGS; ++flagNumber)
            if (isFlagActive(flagNumber))
                return flagNumber;

        return null;
    }

    public boolean areTwoLastFlagsTheSame() {
        if (flagsLeft == 2) {
            int flagNumber1 = getFirstActiveFlagNumber();
            return theSameFlags(flagNumber1, getFirstActiveFlagNumber(flagNumber1 + 1));
        } else {
            return false;
        }
    }

    private boolean theSameFlags(int flagNumber1, int flagNumber2) {
        for (int question = 0; question < Data.NUMBER_OF_QUESTIONS; ++question)
            if (Data.getAnswer(question, flagNumber1) != Data.getAnswer(question, flagNumber2))
                return false;

        return true;
    }

    public void changeActiveFlags(Question question, boolean answer) {
        for (int flag = 0; flag < Data.NUMBER_OF_FLAGS; ++flag)
            if (isFlagActive(flag) && (answer != question.getAnswerFor(flag)))
                deactivate(flag);
    }

    private void deactivate(int flag) {
        activeFlags.set(flag, false);
        flagsLeft--;
    }

    public void changeActiveFlagsAfterLastQuestion(boolean answer) {
        int firstActiveFlag = getFirstActiveFlagNumber();
        int secondActiveFlag = getFirstActiveFlagNumber(firstActiveFlag + 1);
        if (answer)
            deactivate(secondActiveFlag);
        else
            deactivate(firstActiveFlag);
    }
}

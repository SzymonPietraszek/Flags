package application.frontend;

public interface BackendPlugin {
    public String getQuestion();
    public boolean areTwoLastFlagsTheSame();
    public boolean isFlagActive(int flag);
    public boolean oneFlagLeft();
    public boolean noFlagsLeft();
    public int getFirstActiveFlagNumber();
    public int numberOfFlags();

    public void changeActiveFlagsAfterQuestion(boolean answer);
    public void changeActiveFlagsAfterLastQuestion(boolean answer);
    public void resetActiveFlags();

}

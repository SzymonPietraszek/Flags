package application.frontend;

import application.Run;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frontend extends JFrame implements ActionListener {
    private static final int flagsInRow = 10;
    private static final int width = 80 * flagsInRow + 20;
    private static final int height = 700;
    private int countQuestions = 0;
    private BackendPlugin backend;

    public Frontend(BackendPlugin backend) {
        this.backend = backend;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(width, height);
        setResizable(false);
        startWindow();
    }

    private void startWindow(){
        JLabel label = new JLabel("<html>Hi! This app goal is to find chosen flag" +
                " based on closed questions. On the next screen you will see " +
                backend.numberOfFlags() + " national flags. Your task is to choose one flag " +
                "and answer questions. The app will find your flag in maximum 8 questions. " +
                "To be sure your answer was correct find your flag on the next screen. " +
                "If you are ready click START button.</html>");
        setFrameToTextAndButton(label, button("START"));
    }

    private void setFrameToTextAndButton(JComponent text, JButton button){
        setVisible(false);
        setTitle("Flags");
        setLayout(null);

        text.setBounds((int) (0.1* width), (int) (0.1* height), (int) (0.6* width), (int) (0.3*height));
        button.setBounds((int) (0.8* width), (int) (0.2* height), (int) (0.1* width), (int) (0.1*height));
        add(text);
        add(button);

        setVisible(true);
    }

    private void nextScreen() {
        setVisible(false);
        getContentPane().removeAll();
        repaint();
        if (backend.noFlagsLeft() || backend.oneFlagLeft()) {
            answer();
        } else {
            question();
        }
        setVisible(true);
    }

    private void answer() {
        if (backend.noFlagsLeft()) {
            noFlagsAnswer();
        } else if (backend.oneFlagLeft()) {
            oneFlagsAnswer();
        }
    }

    private void noFlagsAnswer(){
        JLabel  label = new JLabel("ups, something went wrong." +
                " Try again and make sure your questions are correct :)");
        setFrameToTextAndButton(label, button("Try again"));
    }

    private void oneFlagsAnswer(){
        JPanel panel = new JPanel();
        panel.add(new JLabel("Congratulations! You found your flag after "
                + countQuestions + " questions.                 "));
        panel.add(flagLabel(backend.getFirstActiveFlagNumber()));
        setFrameToTextAndButton(panel, button("Try again"));
    }

    private void question() {
        setTitle("Question number " + ++countQuestions);
        add(questionPanel(), BorderLayout.NORTH);
        add(flagsPanel(), BorderLayout.CENTER);
    }

    private JPanel questionPanel() {
        JPanel panel = new JPanel();

        if (backend.areTwoLastFlagsTheSame()) {
            theSameFlagsLeftQuestion(panel);
        } else {
            panel.add(new JLabel(backend.getQuestion(), JLabel.CENTER));
        }
        panel.add(button("Yes"));
        panel.add(button("No"));
        return panel;
    }

    private void theSameFlagsLeftQuestion(JPanel panel) {
        panel.add(new JLabel("Is this your flag "));
        panel.add(flagLabel(backend.getFirstActiveFlagNumber()));
        panel.add(new JLabel("?"));
    }

    private JScrollPane flagsPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, flagsInRow));

        for (int i = 0; i < backend.numberOfFlags(); i++) {
            if (backend.isFlagActive(i)) {
                panel.add(flagLabel(i));
            }
        }
        return new JScrollPane(panel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    }

    private JLabel flagLabel(int i) {
        ImageIcon icon = new ImageIcon(Run.class.getResource("res/" +  (i+1) + ".png"));
        return new JLabel(icon);
    }

    private JButton button(String name) {
        JButton button = new JButton(name);
        button.setActionCommand(name);
        button.addActionListener(this);
        return button;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getActionCommand().equals("Yes")) {
            sendResponse(true);
        } else if (e.getActionCommand().equals("No")) {
            sendResponse(false);
        } else if (e.getActionCommand().equals("START")) {
            setLayout(new BorderLayout());
            nextScreen();
        }else if(e.getActionCommand().equals("Try again")){
            reset();
        }
    }

    private void sendResponse(boolean answer){
        if(backend.areTwoLastFlagsTheSame()){
            backend.changeActiveFlagsAfterLastQuestion(answer);
        }else{
            backend.changeActiveFlagsAfterQuestion(answer);
        }
        nextScreen();
    }

    private void reset(){
        backend.resetActiveFlags();
        setLayout(new BorderLayout());
        countQuestions = 0;
        nextScreen();
    }
}

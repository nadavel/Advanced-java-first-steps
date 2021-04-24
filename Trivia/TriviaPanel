import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

//this class holds the logic for the trivia game
public class TriviaPanel extends JPanel {

    private TimerListener tl = new TimerListener();
    private Timer answerTimer = new Timer(10000, tl); //10 sec for answering
    private static int score;
    private JTextField scoreString;
    private final int CORRECT = 10, INCORRECT = 5;
    private JButton[] buttons;
    private Pool pool;
    private Question question;
    private JButton pressed;
    private final int NUM_OF_ANSWERS = 4;
    private Listener lis = new Listener();
    private JPanel answersPanel;
    private String tf;
    private Font font = new Font("Serif", Font.BOLD, 24);
    private QuestionPanel questionPanel;
    private static int correct;

    //constructor
    public TriviaPanel() {
        correct = 0;
        score = 0;
        scoreString = new JTextField();
        scoreString.setFont(font);
        questionPanel = new QuestionPanel();
        this.setLayout(new GridLayout(2, 1));
        pool = null;
        try {
            pool = new Pool();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        question = pool.getQuestion();
        String[] answers = question.shuffle();
        tf = question.getQuestion();//question text
        this.add(questionPanel);
        answersPanel = new JPanel();//panel for the 4 answers
        answersPanel.setLayout(new GridLayout(2, 2));
        buttons = new JButton[NUM_OF_ANSWERS];
        for (int i = 0; i < NUM_OF_ANSWERS; i++) {
            buttons[i] = new JButton(answers[i]);
            answersPanel.add(buttons[i]);
            buttons[i].addActionListener(lis);

        }
        this.add(answersPanel);
        answerTimer.start();
        updateScore();
    }

//moving to next question
    private void next() {
        Question q = pool.getQuestion();
        question = q;
        tf = q.getQuestion();
        String[] answers = q.shuffle();
        for (int i = 0; i < NUM_OF_ANSWERS; i++) {
            buttons[i].setText(answers[i]);
            buttons[i].setEnabled(true);
        }
        questionPanel.repaint();
    }

    public void gameOver() {
        answerTimer.stop();
        int input = JOptionPane.showConfirmDialog(null,
                "You were " +Math.round((double)correct/(Pool.getIterator()-1)*100)+"% accurate\n"+ "New game?", "Select an Option...", JOptionPane.YES_NO_CANCEL_OPTION);
        if (input == 0)
            restart();
        else
            System.exit(0);
    }
//reinitialize the data for starting a new game
    public void restart(){
        answerTimer.stop();
        correct = 0;
        score = 0;
        pool.restart();
        updateScore();
        next();
    }

    private void check(String guess) {
        answerTimer.stop();
        String answer = question.getCorrectAnswer();
        if (guess.equals(answer)) {
            correct++;
            score += CORRECT;
            tf = "Correct!!!";
        } else {
            score -= INCORRECT;
            tf = "Wrong answer";
        }
        questionPanel.repaint();
        updateScore();


//holds the game for 1 sec to show the player result for previous question
        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Timer timer = (Timer) e.getSource();
                timer.stop();
                afterCheckDelay();
            }
        });
        timer.start();
    }

    private void afterCheckDelay() {
        if (Pool.getIterator() < pool.getSize()) {
            answerTimer.restart();
            next();
        } else {
            gameOver();
        }
    }

    private void updateScore(){
        scoreString.setText("Score: " + score + "/" + Pool.getIterator() * CORRECT);
    }

    private class QuestionPanel extends JPanel {

        public QuestionPanel() {
            this.setLayout(new BorderLayout());
            this.add(scoreString, BorderLayout.EAST);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setFont(font);
            FontMetrics fm = g.getFontMetrics();
            int y = ((getHeight() - fm.getHeight()) / 2) + fm.getAscent();
            g.drawString(tf, 10, y);
        }
    }

    //reacting to player's input and disabling the buttons while we check the answer
    private class Listener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            pressed = (JButton) e.getSource();
            String guess = pressed.getText();
            for (int i = 0; i < NUM_OF_ANSWERS; i++)
                buttons[i].setEnabled(false);
            check(guess);
        }

    }
//reacting to the answer timer of 10 sec
    private class TimerListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            answerTimer.stop();
            score-=INCORRECT;
            updateScore();
            repaint();
            afterCheckDelay();
        }
    }

}

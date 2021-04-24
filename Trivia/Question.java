import java.util.Arrays;
import java.util.Collections;

//this class represents a single question
public class Question {

    private final int NUM_OF_ANSWERS = 4;
    private String question;
    private String[] answers = new String[NUM_OF_ANSWERS];
    private final int CORRECT_ANSWER = 0;

    //constructor
    public Question(String qu, String an, String dm1, String dm2, String dm3) {
        question = qu;
        answers[0] = an;
        answers[1] = dm1;
        answers[2] = dm2;
        answers[3] = dm3;
    }

    public String getCorrectAnswer() {
        return answers[CORRECT_ANSWER];
    }

    public String getQuestion() {
        return question;
    }

    public String[] getAnswers() {
        return answers;
    }
//for testing
    public String toString() {
        String str = question;
        for (int i = 0; i < 4; i++) {
            str += " " + answers[i];
        }
        str += "\n";
        return str;
    }

    public String[] shuffle() {
        String[] shuffled = new String[NUM_OF_ANSWERS];
        for (int i = 0; i < NUM_OF_ANSWERS; i++) {
            shuffled[i] = answers[i];
        }
        Collections.shuffle(Arrays.asList(shuffled));
        return shuffled;
    }
}

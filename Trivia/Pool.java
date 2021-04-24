import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

//this class represents the pool of questions
public class Pool {

    private ArrayList<Question> questions = new ArrayList<>();
    private Scanner input = new Scanner(new File("src/trivia.txt"));
    private static int iterator = 0;
//constructor reads questions and saves them to the data structure
    public Pool() throws FileNotFoundException {
        while (input.hasNext()) {
            String q = input.nextLine();
            String a = input.nextLine();
            String d1 = input.nextLine();
            String d2 = input.nextLine();
            String d3 = input.nextLine();
            Question question = new Question(q, a, d1, d2, d3);
            questions.add(question);
            }
        Collections.shuffle(questions);

    }

    public Question getQuestion() {
        Question q = questions.get(iterator);
        iterator++;
        return q;
    }

    public int getSize() {
        return questions.size();
    }

    public static int getIterator() {
        return iterator;
    }
    //reinitialize data for starting a new game
    public void restart(){
        iterator = 0;
        Collections.shuffle(questions);
    }
}

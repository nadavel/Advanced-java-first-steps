import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//this class represents the game
public class GameFrame extends JFrame {

    private JButton restart, finish, pressed;
    private JPanel buttons;
    private TriviaPanel tp;
    Listener lis = new Listener();

    //constructor
    public GameFrame() {
        super("Trivia");
        tp = new TriviaPanel();
        this.setLayout(new BorderLayout());
        this.add(tp, BorderLayout.CENTER);
        restart = new JButton("New game");
        finish = new JButton("End game");
        restart.addActionListener(lis);
        finish.addActionListener(lis);
        buttons = new JPanel();
        buttons.add(restart);
        buttons.add(finish);
        this.add(buttons, BorderLayout.SOUTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
//listener for the new game button
    private class Listener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == restart)
                tp.restart();
            else
                tp.gameOver();
        }

    }

}

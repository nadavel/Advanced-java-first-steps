import java.awt.EventQueue;

public class Tester {

    public static void main(String[] args) {
        new Tester();
    }

    public Tester() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                GameFrame frame = new GameFrame();
                frame.pack();
                frame.setSize(1000,600);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }
}

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    public MainWindow(){
        setTitle("Змейка");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(320,345);
        setLocation(400,400);
        add(new Game());
        setVisible(true);
    }

    public static void main(String[] args) {
        MainWindow mw = new MainWindow();
    }
}
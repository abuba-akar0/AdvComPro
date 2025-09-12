import javax.swing.*;

public class GUIDemo {
    public static void main(String[] args) {
        JFrame frame = new JFrame("GUI Demo");
        JButton button = new JButton("Click Me!");

        button.addActionListener(e -> JOptionPane.showMessageDialog(frame, "Button Clicked!"));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.getContentPane().add(button);
        frame.setVisible(true);
    }
}


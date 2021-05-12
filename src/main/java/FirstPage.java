import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FirstPage extends JFrame implements ActionListener {
    private final JTextField textField;
    private static int c;
    FirstPage() {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridBagLayout());
        this.setTitle("Intro screen");

        JButton button = new JButton();
        button.addActionListener(this);
        button.setBounds(200, 100, 100, 75);
        button.setBackground(Color.blue );
        button.setText("Enter");
        button.setFocusable(false);
        button.setForeground(Color.WHITE);
        button.setBorder(BorderFactory.createEtchedBorder());

        textField = new JTextField();
        textField.setPreferredSize(new Dimension(60, 20));

        this.add(textField);
        this.setSize(500, 500);
        this.setVisible(true);
        this.add(button);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (validating()) {
            this.dispose();
            SecondPage secondPage = new SecondPage();
        }
    }

    private boolean validating() {
        int i = Integer.parseInt(textField.getText());
        c = i;
        if (i >= 0 & i <= 1000) {
            return true;
        }
        return false;
    }

    public static int getC() {
        return c;
    }
}

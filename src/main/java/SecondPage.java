import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class SecondPage extends JFrame implements ActionListener {
    final Random random = new Random();
    private final JPanel jPanel;
    static int[] arrayOfButton;
    private final JButton buttonReset;
    private final JButton buttonLessThan30;


    SecondPage() {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jPanel = new JPanel();
        jPanel.setLayout(new MyLayout());

        JPanel sortAndReset = new JPanel();
        sortAndReset.setLayout(new FlowLayout());
        sortAndReset.setBounds(300, 0, 100, 100);

        JButton buttonSort = getSortButton();
        buttonReset = getResetButton();
        buttonLessThan30 = getButtonLessThan30();
        sortAndReset.add(buttonSort);
        sortAndReset.add(buttonReset);
        jPanel.add(buttonLessThan30);

        this.add(sortAndReset);
        this.add(jPanel);
        this.setTitle("Sort screen");
        this.setSize(500, 500);
        this.setVisible(true);

        int inputFromFirstPage = FirstPage.getC();
        arrayOfButton = new int[inputFromFirstPage];

        for (int i = 0; i < inputFromFirstPage - 1; i++) {
            JButton buttonRandom = getRandomButton();
            int number = Integer.parseInt(buttonRandom.getText());
            arrayOfButton[i] = number;
            jPanel.add(buttonRandom);
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttonReset) {
            this.dispose();
            new FirstPage();
        }if (e.getSource() == buttonLessThan30) {
            this.dispose();
            new SecondPage();
        }
    }

    public JButton getButtonLessThan30() {
        JButton reSort = new JButton();
        reSort.addActionListener(this);
        reSort.setBackground(Color.blue);
        reSort.setText("" + 0);
        reSort.setFocusable(false);
        reSort.setForeground(Color.WHITE);
        reSort.setBorder(BorderFactory.createEtchedBorder());
        return reSort;
    }

    public JButton getRandomButton() {
        JButton jButton = new JButton();
        int randomNumber = random.nextInt(100);
        jButton.setBackground(Color.blue);
        jButton.setText("" + randomNumber);
        jButton.setFocusable(false);
        jButton.setForeground(Color.WHITE);
        jButton.setBorder(BorderFactory.createEtchedBorder());
        if (randomNumber > 30) {
            jButton.addActionListener(e -> JOptionPane.showMessageDialog
                    (jPanel, "Please select a value smaller or equals to 30"));
        } else {
            jButton.addActionListener(e -> {
                SecondPage.this.dispose();
                new SecondPage();
            });
        }
        return jButton;
    }

    public JButton getSortButton() {
        JButton jButton = new JButton();
        jButton.setBackground(Color.BLACK);
        jButton.setText("Sort");
        jButton.setFocusable(false);
        jButton.setForeground(Color.WHITE);
        jButton.setBorder(BorderFactory.createEtchedBorder());
        jButton.addActionListener(e -> {
            SecondPage.this.dispose();
            new SortingPage();
        });
        return jButton;
    }

    public JButton getResetButton() {
        JButton jButton = new JButton();
        jButton.setBackground(Color.GREEN);
        jButton.setText("Reset");
        jButton.setFocusable(false);
        jButton.setForeground(Color.WHITE);
        jButton.setBorder(BorderFactory.createEtchedBorder());
        jButton.addActionListener(this);
        return jButton;
    }
}

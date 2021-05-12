import qiucksort.SortAsc;
import qiucksort.SortDesc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SortingPage extends JFrame implements ActionListener {
    JPanel jPanel;
    JButton buttonSort;
    JButton buttonReset;
    static boolean isDescSort;

    SortingPage() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jPanel = new JPanel();
        jPanel.setLayout(new MyLayout());

        JPanel sortAndReset = new JPanel();
        sortAndReset.setLayout(new FlowLayout());
        sortAndReset.setBounds(300, 0, 100, 100);

        buttonSort = getSortButton();
        buttonReset = getResetButton();
        sortAndReset.add(buttonReset);
        sortAndReset.add(buttonSort);

        this.add(sortAndReset);
        this.add(jPanel);
        this.setTitle("Sort screen");
        this.setSize(500, 500);
        this.setVisible(true);

        if (!isDescSort) {
            descSort();
            isDescSort = true;
        } else {
            ascSort();
            isDescSort = false;
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton j = (JButton) e.getSource();
        if (Integer.parseInt(j.getText()) > 30)
            JOptionPane.showMessageDialog(jPanel, "Please select a value smaller or equals to 30");
        else {
            this.dispose();
            new SecondPage();
        }
    }

    public JButton getSortButton() {
        JButton jButton = new JButton();
        jButton.setBackground(Color.BLACK);
        jButton.setText("Sort");
        jButton.setFocusable(false);
        jButton.setForeground(Color.WHITE);
        jButton.setBorder(BorderFactory.createEtchedBorder());
        jButton.addActionListener(e -> {
            SortingPage.this.dispose();
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
        jButton.addActionListener(e -> {
            SortingPage.this.dispose();
            new FirstPage();
        });
        return jButton;
    }

    public JButton getRandomButton() {
        JButton jButton = new JButton();
        jButton.setBackground(Color.blue);
        jButton.setFocusable(false);
        jButton.setForeground(Color.WHITE);
        jButton.setBorder(BorderFactory.createEtchedBorder());
        jButton.addActionListener(this);
        return jButton;
    }

    public void descSort() {
        int high = SecondPage.arrayOfButton.length - 1;
        SortDesc.quickSort(SecondPage.arrayOfButton, 0, high);
        for (int i = 0; i < SecondPage.arrayOfButton.length; i++) {
            JButton temp = getRandomButton();
            temp.setText("" + SecondPage.arrayOfButton[i]);
            jPanel.add(temp);
        }
    }

    public void ascSort() {
        int high = SecondPage.arrayOfButton.length - 1;
        SortAsc.quickSort(SecondPage.arrayOfButton, 0, high);
        for (int i = 0; i < SecondPage.arrayOfButton.length; i++) {
            JButton temp = getRandomButton();
            temp.setText("" + SecondPage.arrayOfButton[i]);
            jPanel.add(temp);
        }
    }
}

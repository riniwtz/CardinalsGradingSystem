import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.regex.Pattern;

public class GradingSystemUI extends JFrame {
    private JPanel panel;
    private JTextField totalRawGradePercentageField;
    private JTextField totalEquivalentGradePercentageField;
    private JButton viewGradingSystemTableButton;

    protected static Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();

    public GradingSystemUI() {
        this.setTitle("Grading System Checker v1.0 (Not Affiliated with Mapua)");
        this.setContentPane(panel);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack();
        this.setLocationRelativeTo(null);
        initializeComponents();
    }

    static boolean isGradingSystemTableWindowActive = false;

    protected void initializeComponents() {
        totalRawGradePercentageField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyChar() == ' ') {
                    System.out.println("test");
                }
                if (Pattern.compile("[a-z]+").matcher(totalRawGradePercentageField.getText()).find()) {
                    totalEquivalentGradePercentageField.setText("");
                } else if (Pattern.compile("\\d+").matcher(totalRawGradePercentageField.getText()).find()) {
                    int equivalentGrades = GradingSystem.getEquivalentGrades(Float.parseFloat(totalRawGradePercentageField.getText()));
                    totalEquivalentGradePercentageField.setText(String.valueOf(equivalentGrades));
                }
            }
        });

        viewGradingSystemTableButton.addActionListener(e -> {
            if (e.getSource() == viewGradingSystemTableButton) {
                if (!isGradingSystemTableWindowActive) {
                    isGradingSystemTableWindowActive = true;
                    new GradingSystemTableUI();
                }
            }
        });
    }
}

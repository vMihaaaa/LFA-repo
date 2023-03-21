import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class PatternChecker extends JFrame implements ActionListener {

    private JLabel patternLabel, stringLabel, resultLabel;
    private JTextField patternField, stringField;
    private JButton checkButton;

    public PatternChecker() {
        setTitle("Pattern Checker");
        setSize(400, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // create labels
        patternLabel = new JLabel("Enter pattern:");
        stringLabel = new JLabel("Enter string:");
        resultLabel = new JLabel("");

        // create text fields
        patternField = new JTextField(20);
        stringField = new JTextField(20);

        // create button
        checkButton = new JButton("Check");
        checkButton.addActionListener(this);

        // create panel and add components
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(5, 5, 5, 5);
        c.gridx = 0;
        c.gridy = 0;
        panel.add(patternLabel, c);
        c.gridx = 1;
        panel.add(patternField, c);
        c.gridx = 0;
        c.gridy = 1;
        panel.add(stringLabel, c);
        c.gridx = 1;
        panel.add(stringField, c);
        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = 2;
        panel.add(checkButton, c);
        c.gridy = 3;
        panel.add(resultLabel, c);

        // add panel to frame
        add(panel);

        setVisible(true);
    }

    public static void main(String[] args) {
        new PatternChecker();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String pattern = patternField.getText();
        String str = stringField.getText();

        try {
            Pattern.compile(pattern); // check if pattern is valid
            if (str.matches(pattern)) {
                resultLabel.setText("String matches pattern!");
            } else {
                resultLabel.setText("String does not match pattern!");
            }
        } catch (PatternSyntaxException ex) {
            resultLabel.setText("Invalid pattern!");
        }
    }
}

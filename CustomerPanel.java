import javax.swing.*;
import java.awt.*;

public class CustomerPanel {
    private JPanel panel;
    private JTextField nameTextField;
    private JTextField phoneTextField;
    private JLabel nameLabel;
    private JLabel phoneLabel;
    private JButton clearButton;
    private JButton saveButton;

    public CustomerPanel() {
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(500, 150, 400, 350);
        panel.setBackground(Color.DARK_GRAY);

        // Initialize components
        nameTextField = new JTextField();
        phoneTextField = new JTextField();
        nameLabel = new JLabel("Name:");
        phoneLabel = new JLabel("Phone:");

        clearButton = new JButton("Clear");
        saveButton = new JButton("Save");


        nameLabel.setForeground(Color.WHITE);
        phoneLabel.setForeground(Color.WHITE);


        clearButton.setForeground(Color.DARK_GRAY);
        clearButton.setBackground(Color.WHITE);
        clearButton.setOpaque(true);

        saveButton.setForeground(Color.DARK_GRAY);
        saveButton.setBackground(Color.WHITE);
        saveButton.setOpaque(true);


        // Set bounds for labels and fields
        nameLabel.setBounds(50, 50, 100, 30); // Label: x=50, y=50, width=100, height=30
        nameTextField.setBounds(160, 50, 180, 30); // Field: x=160, y=50, width=180, height=30

        phoneLabel.setBounds(50, 100, 100, 30); // Label: x=50, y=100, width=100, height=30
        phoneTextField.setBounds(160, 100, 180, 30); // Field: x=160, y=100, width=180, height=30

        clearButton.setBounds(160, 150, 80, 30);
        saveButton.setBounds(250, 150, 80, 30);

        // Add components to the panel

        panel.add(saveButton);
        panel.add(clearButton);
        panel.add(nameLabel);
        panel.add(nameTextField);
        panel.add(phoneLabel);
        panel.add(phoneTextField);

        clearButton.addActionListener(e -> {
            nameTextField.setText("");
            phoneTextField.setText("");
        });
    }



    public JPanel getPanel() {
        return panel;
    }
}

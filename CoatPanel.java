import javax.swing.*;
import java.awt.*;

public class CoatPanel {
    private JPanel panel;
    private JLabel coatHeading;
    private JLabel chestLabel;
    private JLabel waistLabel;
    private JLabel sleevesLabel;
    private JLabel shoulderLabel;
    private JLabel statusLabel;
    private JLabel descriptionLabel;


    private JTextField chestTextField;
    private JTextField waistTextField;
    private JTextField sleevesTextField;
    private JTextField shoulderTextField;
    private JTextArea descriptionField;
    private JComboBox<String> statusField;

    public CoatPanel() {
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(900, 20, 400, 450);
        panel.setBackground(new Color(169, 169, 169));


        coatHeading = new JLabel("Coat");
        coatHeading.setFont(new Font("Arial Black", Font.BOLD, 30));
        chestLabel = new JLabel("Chest");
        waistLabel = new JLabel("Waist");
        sleevesLabel = new JLabel("Sleeve");
        shoulderLabel = new JLabel("Shoulder");
        statusLabel = new JLabel("Status");
        descriptionLabel = new JLabel("Description");

        chestTextField = new JTextField();
        waistTextField = new JTextField();
        sleevesTextField = new JTextField();
        shoulderTextField = new JTextField();
        statusField = new JComboBox<>(new String[]{"Select", "Pending", "Process", "Completed", "Delivered"});
        descriptionField = new JTextArea();


        coatHeading.setBounds(200, 10, 200, 50);

        chestLabel.setBounds(50, 90, 100, 30);
        chestTextField.setBounds(150, 90, 200, 30);
        waistLabel.setBounds(50, 140, 100, 30);
        waistTextField.setBounds(150, 140, 200, 30);
        sleevesLabel.setBounds(50, 190, 100, 30);
        sleevesTextField.setBounds(150, 190, 200, 30);
        shoulderLabel.setBounds(50, 240, 100, 30);
        shoulderTextField.setBounds(150, 240, 200, 30);
        statusLabel.setBounds(50, 290, 100, 30);
        statusField.setBounds(150, 290, 200, 30);
        descriptionLabel.setBounds(50, 340, 100, 30);
        descriptionField.setBounds(150, 340, 230, 100);

        



        panel.add(coatHeading);
        panel.add(chestLabel);
        panel.add(chestTextField);
        panel.add(waistLabel);
        panel.add(waistTextField);
        panel.add(sleevesLabel);
        panel.add(sleevesTextField);
        panel.add(shoulderLabel);
        panel.add(shoulderTextField);
        panel.add(statusLabel);
        panel.add(statusField);
        panel.add(descriptionLabel);
        panel.add(descriptionField);
    }

    public JPanel getPanel() {
        return panel;
    }
}

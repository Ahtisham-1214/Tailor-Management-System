import javax.swing.*;
import java.awt.*;

public class KameezShalwaarPanel {
    private JPanel panel;

    private JLabel kameezLengthLabel;
    private JLabel sleevesLabel;
    private JLabel sleevesTypeLabel;
    private JLabel kameezTypeLabel;
    private JLabel shoulderLabel;
    private JLabel neckLabel;
    private JLabel collarTypeLabel;
    private JLabel deliveryDateLabel;
    private JLabel descriptionLabel;
    private JLabel statusLabel;
    private JLabel kameezShalwaarHeading;

    private JTextField kameezLengthTextField;
    private JTextField sleevesTextField;
    private JTextField shoulderTextField;
    private JTextField neckTextField;
    private JComboBox<String> sleevesTypeField;
    private JComboBox<String> kameezTypeField;
    private JComboBox<String> collarTypeField;
    private JComboBox<String> statusField;
    private JTextField deliveryDateTextField;
    private JTextArea descriptionField;
    private JButton clearButton;
    private JButton saveButton;
    public KameezShalwaarPanel() {
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(450, 50, 600, 650);
        panel.setBackground(new Color(188, 208, 241, 255));

        kameezShalwaarHeading = new JLabel("Kameez Shalwaar");
        kameezShalwaarHeading.setFont(new Font("Arial Black", Font.BOLD, 30));


        clearButton = new JButton("Clear");
        clearButton.setBackground(Color.WHITE);
        clearButton.setForeground(Color.DARK_GRAY);
        clearButton.setOpaque(true);

        saveButton = new JButton("Save");
        saveButton.setBackground(Color.WHITE);
        saveButton.setForeground(Color.DARK_GRAY);
        saveButton.setOpaque(true);



        kameezLengthLabel = new JLabel("Kameez Length");
        sleevesLabel = new JLabel("Sleeves");
        sleevesTypeLabel = new JLabel("Sleeves Type");
        kameezTypeLabel = new JLabel("Kameez Type");
        shoulderLabel = new JLabel("Shoulder");
        neckLabel = new JLabel("Neck");
        collarTypeLabel = new JLabel("Collar Type");
        statusLabel = new JLabel("Status");
        deliveryDateLabel = new JLabel("Delivery Date");
        descriptionLabel = new JLabel("Description");


        kameezLengthTextField = new JTextField();
        sleevesTextField = new JTextField();
        shoulderTextField = new JTextField();
        neckTextField = new JTextField();
        collarTypeField = new JComboBox<>(new String[]{"Select", "Cooper", "French", "Sherwani"});
        statusField = new JComboBox<>(new String[]{"Select", "Pending", "Process", "Completed", "Delivered"});
        deliveryDateTextField = new JTextField();
        descriptionField = new JTextArea();
        sleevesTypeField = new JComboBox<>(new String[]{"Select", "Square", "Oval"});
        kameezTypeField = new JComboBox<>(new String[]{"Select", "Square", "Oval"});



        kameezShalwaarHeading.setBounds(50, 10, 600, 30);

        kameezLengthLabel.setBounds(20, 60, 100, 30);
        kameezLengthTextField.setBounds(130, 60, 200, 30);

        sleevesLabel.setBounds(20, 100, 100, 30);
        sleevesTextField.setBounds(130, 100, 200, 30);

        shoulderLabel.setBounds(20, 140, 230, 30);
        shoulderTextField.setBounds(130, 140, 200, 30);

        neckLabel.setBounds(20, 180, 100, 30);
        neckTextField.setBounds(130, 180, 200, 30);

        collarTypeLabel.setBounds(20, 220, 230, 30);
        collarTypeField.setBounds(130, 220, 200, 30);

        sleevesTypeLabel.setBounds(20, 270, 230, 30);
        sleevesTypeField.setBounds(130, 270, 200, 30);

        kameezTypeLabel.setBounds(20, 320, 230, 30);
        kameezTypeField.setBounds(130, 320, 200, 30);

        statusLabel.setBounds(20, 370, 230, 30);
        statusField.setBounds(130, 370, 200, 30);

        deliveryDateLabel.setBounds(20, 420, 230, 30);
        deliveryDateTextField.setBounds(130, 420, 200, 30);

        descriptionLabel.setBounds(20, 480, 460, 30);
        descriptionField.setBounds(130, 480, 200, 100);

        clearButton.setBounds(130, 600, 80, 30);
        saveButton.setBounds(230, 600, 80, 30);


        
        
        

        panel.add(saveButton);
        panel.add(clearButton);
        panel.add(kameezShalwaarHeading);
        panel.add(kameezLengthLabel);
        panel.add(sleevesLabel);
        panel.add(sleevesTypeLabel);
        panel.add(kameezTypeLabel);
        panel.add(shoulderLabel);
        panel.add(neckLabel);
        panel.add(collarTypeLabel);
        panel.add(statusLabel);
        panel.add(deliveryDateLabel);
        panel.add(descriptionLabel);

        panel.add(kameezLengthTextField);
        panel.add(sleevesTextField);
        panel.add(shoulderTextField);
        panel.add(neckTextField);
        panel.add(collarTypeField);
        panel.add(statusField);
        panel.add(deliveryDateTextField);
        panel.add(descriptionField);
        panel.add(sleevesTypeField);
        panel.add(kameezTypeField);

        clearButton.addActionListener(e -> {
            kameezLengthTextField.setText("");
            sleevesTextField.setText("");
            shoulderTextField.setText("");
            neckTextField.setText("");
            collarTypeField.setSelectedIndex(0);
            statusField.setSelectedIndex(0);
            descriptionField.setText("");
        });


    }

    public JPanel getPanel() {
        return panel;
    }
}

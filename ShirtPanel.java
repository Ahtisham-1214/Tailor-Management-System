import javax.swing.*;
import java.awt.*;

public class ShirtPanel {
    private JPanel panel;
    private JLabel chestLabel;
    private JLabel neckLabel;
    private JLabel shoulderLabel;
    private JLabel statusLabel;
    private JLabel cuffTypeLabel;
    private JLabel descriptionLabel;
    private JLabel sleeveLengthLabel;
    private JLabel shirtLengthLabel;
    private JLabel deliveryDateLabel;
    private JLabel quantityLabel;


    private JTextField chestTextField;
    private JTextField neckTextField;
    private JTextField shoulderTextField;
    private JTextField sleeveLengthField;
    private JTextField shirtLengthField;
    private JComboBox<String> statusTextField;
    private JComboBox<String> cuffTypeField;
    private JTextArea descriptionField;
    private JTextField quantityTextField;
    private JLabel shirtHeading;
    private JButton clearButton;
    private JButton saveButton;
    private JTextField deliveryDateTextField;


    public ShirtPanel() {
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(400, 100, 500, 650);
        panel.setBackground(new Color(169, 169, 169));


        shirtHeading = new JLabel("Shirt");
        shirtHeading.setFont(new Font("Arial Black", Font.BOLD, 30));
        shirtHeading.setBounds(50, 10, 300, 30);

        clearButton = new JButton("Clear");
//        clearButton.setFont(new Font("Arial Black", Font.BOLD, 10));
        clearButton.setBackground(Color.WHITE);
        clearButton.setForeground(Color.DARK_GRAY);
        clearButton.setOpaque(true);


        saveButton = new JButton("Save");
        saveButton.setBackground(Color.WHITE);
        saveButton.setForeground(Color.DARK_GRAY);
        saveButton.setOpaque(true);

        chestLabel = new JLabel("Chest");
        neckLabel = new JLabel("Neck");
        shoulderLabel = new JLabel("Shoulder");
        sleeveLengthLabel = new JLabel("Sleeve Length");
        shirtLengthLabel = new JLabel("Shirt Length");
        cuffTypeLabel = new JLabel("Cuff Type");
        statusLabel = new JLabel("Status");
        deliveryDateLabel = new JLabel("Delivery Date");
        quantityLabel = new JLabel("Quantity");
        descriptionLabel = new JLabel("Description");

        chestTextField = new JTextField();
        neckTextField = new JTextField();
        shoulderTextField = new JTextField();
        sleeveLengthField = new JTextField();
        shirtLengthField = new JTextField();
        cuffTypeField = new JComboBox<>(new String[]{"Select","Half Sleeves", "Square", "Round"});
        statusTextField = new JComboBox<>(new String[]{"Select","Pending", "Process", "Completed", "Delivered"});
        deliveryDateTextField = new JTextField();
        quantityTextField = new JTextField();
        descriptionField = new JTextArea();

        chestLabel.setBounds(10, 60, 100, 30);
        neckLabel.setBounds(10, 100, 100, 30);
        shoulderLabel.setBounds(10, 140, 100, 30);
        sleeveLengthLabel.setBounds(10, 180, 100, 30);
        shirtLengthLabel.setBounds(10, 220, 100, 30);
        cuffTypeLabel.setBounds(10, 260, 100, 30);
        statusLabel.setBounds(10, 300, 100, 30);
        deliveryDateLabel.setBounds(10, 340, 100, 30);
        quantityLabel.setBounds(10, 380, 100, 30);
        descriptionLabel.setBounds(10, 420, 100, 30);

        chestTextField.setBounds(120, 60, 150, 30);
        neckTextField.setBounds(120, 100, 150, 30);
        shoulderTextField.setBounds(120, 140, 150, 30);
        sleeveLengthField.setBounds(120, 180, 150, 30);
        shirtLengthField.setBounds(120, 220, 150, 30);
        cuffTypeField.setBounds(120, 260, 150, 30);
        statusTextField.setBounds(120, 300, 150, 30);
        deliveryDateTextField.setBounds(120, 340, 150, 30);
        quantityTextField.setBounds(120, 380, 150, 30);
        descriptionField.setBounds(120, 420, 230, 100);

        clearButton.setBounds(120, 550,80, 30);
        saveButton.setBounds(220, 550,80, 30);



        panel.add(saveButton);
        panel.add(clearButton);


        panel.add(shirtHeading);
        panel.add(chestTextField);
        panel.add(neckTextField);
        panel.add(shoulderTextField);
        panel.add(statusTextField);
        panel.add(sleeveLengthField);
        panel.add(shirtLengthField);
        panel.add(cuffTypeField);
        panel.add(deliveryDateTextField);
        panel.add(quantityTextField);
        panel.add(descriptionField);


        panel.add(chestLabel);
        panel.add(neckLabel);
        panel.add(shoulderLabel);
        panel.add(statusLabel);
        panel.add(cuffTypeLabel);
        panel.add(deliveryDateLabel);
        panel.add(quantityLabel);
        panel.add(descriptionLabel);
        panel.add(sleeveLengthLabel);
        panel.add(shirtLengthLabel);


        clearButton.addActionListener(e ->{
            chestTextField.setText("");
            neckTextField.setText("");
            shoulderTextField.setText("");
            sleeveLengthField.setText("");
            shirtLengthField.setText("");
            deliveryDateTextField.setText("");
            quantityTextField.setText("");
            cuffTypeField.setSelectedIndex(0);
            statusTextField.setSelectedIndex(0);
            descriptionField.setText("");
        });

    }

    public JPanel getPanel() {
        return panel;
    }
}

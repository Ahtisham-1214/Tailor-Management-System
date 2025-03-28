import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class CoatPanel {
    private JPanel panel;
    private JLabel coatHeading;
    private JLabel chestLabel;
    private JLabel waistLabel;
    private JLabel sleevesLabel;
    private JLabel shoulderLabel;
    private JLabel statusLabel;
    private JLabel deliveryDateLabel;
    private JLabel descriptionLabel;
    private JLabel quantityLabel;


    private JButton clearButton;
    private JButton saveButton;

    private JTextField chestTextField;
    private JTextField waistTextField;
    private JTextField sleevesTextField;
    private JTextField shoulderTextField;
    private JTextField deliveryDateTextField;
    private JTextArea descriptionField;
    private JTextField quantityTextField;
    private JComboBox<String> statusField;

    public CoatPanel() {
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(450, 100, 500, 600);
        panel.setBackground(new Color(169, 169, 169));


        clearButton = new JButton("Clear");
        clearButton.setBackground(Color.WHITE);
        clearButton.setForeground(Color.DARK_GRAY);
        clearButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
        clearButton.setOpaque(true);


        saveButton = new JButton("Save");
        saveButton.setBackground(Color.WHITE);
        saveButton.setForeground(Color.DARK_GRAY);
        saveButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
        saveButton.setOpaque(true);

        coatHeading = new JLabel("Coat");
        coatHeading.setFont(new Font("Arial Black", Font.BOLD, 30));
        chestLabel = new JLabel("Chest");
        waistLabel = new JLabel("Waist");
        sleevesLabel = new JLabel("Sleeve");
        shoulderLabel = new JLabel("Shoulder");
        statusLabel = new JLabel("Status");
        deliveryDateLabel = new JLabel("Delivery Date");
        quantityLabel = new JLabel("Quantity");
        descriptionLabel = new JLabel("Description");

        chestTextField = new JTextField();
        waistTextField = new JTextField();
        sleevesTextField = new JTextField();
        shoulderTextField = new JTextField();
        statusField = new JComboBox<>(new String[]{"Select", "Pending", "Process", "Completed", "Delivered"});
        deliveryDateTextField = new JTextField("YYYY-MM-DD");
        quantityTextField = new JTextField();
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

        deliveryDateLabel.setBounds(50, 340, 100, 30);
        deliveryDateTextField.setBounds(150, 340, 200, 30);

        quantityLabel.setBounds(50, 380, 100, 30);
        quantityTextField.setBounds(150, 380, 200, 30);

        descriptionLabel.setBounds(50, 420, 100, 30);
        descriptionField.setBounds(150, 420, 230, 100);

        clearButton.setBounds(150, 550, 80, 30);
        saveButton.setBounds(250, 550, 80, 30);



        panel.add(clearButton);
        panel.add(saveButton);


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
        panel.add(deliveryDateLabel);
        panel.add(deliveryDateTextField);
        panel.add(quantityLabel);
        panel.add(quantityTextField);



        clearButton.addActionListener(e -> {
            chestTextField.setText("");
            waistTextField.setText("");
            sleevesTextField.setText("");
            shoulderTextField.setText("");
            descriptionField.setText("");
            deliveryDateTextField.setText("");
            quantityTextField.setText("");
            statusField.setSelectedIndex(0);
        });
        saveButton.addActionListener(e->{
            if (chestTextField.getText().isBlank()) 
                JOptionPane.showMessageDialog(null, "Enter Chest Field", "Chest Error", JOptionPane.ERROR_MESSAGE);
            else if (waistTextField.getText().isBlank())
                    JOptionPane.showMessageDialog(null, "Enter Waist Field", "Waist Error", JOptionPane.ERROR_MESSAGE);
            else if (sleevesTextField.getText().isBlank())
                JOptionPane.showMessageDialog(null, "Enter Sleeve Field", "Sleeve Error", JOptionPane.ERROR_MESSAGE);
            else if (shoulderTextField.getText().isBlank())
                JOptionPane.showMessageDialog(null, "Enter Shoulder Field", "Shoulder Error", JOptionPane.ERROR_MESSAGE);
        });
        deliveryDateTextField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (deliveryDateTextField.getText().equals("YYYY-MM-DD"))
                    deliveryDateTextField.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (deliveryDateTextField.getText().isEmpty())
                    deliveryDateTextField.setText("YYYY-MM-DD");
            }
        });

    }

    public JPanel getPanel() {
        return panel;
    }
}

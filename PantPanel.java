import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class PantPanel {
    private JPanel panel;
    private JLabel waistLabel;
    private JLabel lengthLabel;
    private JLabel typeLabel;
    private JLabel statusLabel;
    private JLabel inseamLabel;
    private JLabel descriptionLabel;
    private JLabel pantHeading;
    private JLabel deliveryDateLabel;
    private JLabel quantityLabel;


    private JButton clearButton;
    private JButton saveButton;

    private JTextArea descriptionTextArea;
    private JTextField waistTextField;
    private JTextField lengthTextField;
    private JTextField inseamTextField;
    private JComboBox<String> typeField;
    private JComboBox<String> statusField;
    private JTextField deliveryDateTextField;
    private JTextField quantityTextField;


    public PantPanel() {
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(450, 100, 500, 600);
        panel.setBackground(new Color(169, 169, 169));


        // Widgets
        clearButton = new JButton("Clear");
//        clearButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
        clearButton.setBackground(Color.WHITE);
        clearButton.setForeground(Color.DARK_GRAY);
        clearButton.setOpaque(true);

        saveButton = new JButton("Save");
//        saveButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
        saveButton.setBackground(Color.WHITE);
        saveButton.setForeground(Color.DARK_GRAY);
        saveButton.setOpaque(true);


        pantHeading = new JLabel("Pant");
        pantHeading.setFont(new Font("Arial Black", Font.BOLD, 30));


        waistLabel = new JLabel("Waist");
        lengthLabel = new JLabel("Length");
        typeLabel = new JLabel("Type");
        statusLabel = new JLabel("Status");
        inseamLabel = new JLabel("Inseam");
        deliveryDateLabel = new JLabel("Delivery Date");
        quantityLabel = new JLabel("Quantity");
        descriptionLabel = new JLabel("Description");


        descriptionTextArea = new JTextArea();
        waistTextField = new JTextField();
        lengthTextField = new JTextField();
        inseamTextField = new JTextField();
        deliveryDateTextField = new JTextField("YYYY-MM-DD");
        quantityTextField = new JTextField();
        typeField = new JComboBox<>(new String[]{"Select", "Straight", "Cuff"});
        statusField = new JComboBox<>(new String[]{"Select", "Pending", "Progress", "Completed", "Delivered"});


        // Setting bounds for widgets
        pantHeading.setBounds(200, 10, 200, 50);

        waistLabel.setBounds(50, 90, 100, 30);
        waistTextField.setBounds(150, 90, 200, 30);

        lengthLabel.setBounds(50, 140, 100, 30);
        lengthTextField.setBounds(150, 140, 200, 30);

        inseamLabel.setBounds(50, 190, 100, 30);
        inseamTextField.setBounds(150, 190, 200, 30);

        typeLabel.setBounds(50, 240, 100, 30);
        typeField.setBounds(150, 240, 200, 30);

        statusLabel.setBounds(50, 290, 100, 30);
        statusField.setBounds(150, 290, 200, 30);


        deliveryDateLabel.setBounds(50, 340, 100, 30);
        deliveryDateTextField.setBounds(150, 340, 200, 30);

        quantityLabel.setBounds(50, 380, 100, 30);
        quantityTextField.setBounds(150, 380, 200, 30);

        descriptionLabel.setBounds(50, 420, 100, 30);
        descriptionTextArea.setBounds(150, 420, 230, 100);

        clearButton.setBounds(150, 550, 80, 30);
        saveButton.setBounds(250, 550, 80, 30);

        // Adding widgets to panel
        panel.add(clearButton);
        panel.add(saveButton);

        panel.add(pantHeading);
        panel.add(descriptionLabel);
        panel.add(descriptionTextArea);
        panel.add(waistLabel);
        panel.add(waistTextField);
        panel.add(lengthLabel);
        panel.add(lengthTextField);
        panel.add(inseamLabel);
        panel.add(inseamTextField);
        panel.add(typeLabel);
        panel.add(typeField);
        panel.add(statusLabel);
        panel.add(statusField);
        panel.add(deliveryDateLabel);
        panel.add(deliveryDateTextField);
        panel.add(quantityLabel);
        panel.add(quantityTextField);

        clearButton.addActionListener(e -> {
            inseamTextField.setText("");
            waistTextField.setText("");
            lengthTextField.setText("");
            deliveryDateTextField.setText("");
            quantityTextField.setText("");
            typeField.setSelectedIndex(0);
            statusField.setSelectedIndex(0);
            descriptionTextArea.setText("");
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

        saveButton.addActionListener(e->{
            if (getWaistTextField().getText().isBlank())
                JOptionPane.showMessageDialog(null, "Please Enter Waist");
            else if (getLengthTextField().getText().isBlank())
                JOptionPane.showMessageDialog(null, "Please Enter Length");
            else if (getInseamTextField().getText().isBlank())
                JOptionPane.showMessageDialog(null, "Please Enter Inseam");

        });
    }

    public JPanel getPanel() {
        return panel;
    }

    public JButton getSaveButton() {
        return saveButton;
    }

    public JTextArea getDescriptionTextArea() {
        return descriptionTextArea;
    }

    public JTextField getWaistTextField() {
        return waistTextField;
    }

    public JTextField getLengthTextField() {
        return lengthTextField;
    }

    public JTextField getInseamTextField() {
        return inseamTextField;
    }

    public JComboBox<String> getTypeField() {
        return typeField;
    }

    public JComboBox<String> getStatusField() {
        return statusField;
    }

    public JTextField getDeliveryDateTextField() {
        return deliveryDateTextField;
    }

    public JTextField getQuantityTextField() {
        return quantityTextField;
    }
}

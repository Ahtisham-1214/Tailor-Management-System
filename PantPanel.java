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
    private JLabel orderDateLabel;
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
    private JTextField orderDateTextField;
    private JTextField deliveryDateTextField;
    private JTextField quantityTextField;


    public PantPanel() {
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(450, 100, 800, 600);
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
        orderDateLabel = new JLabel("Order Date");
        deliveryDateLabel = new JLabel("Delivery Date");
        quantityLabel = new JLabel("Quantity");
        descriptionLabel = new JLabel("Description");


        descriptionTextArea = new JTextArea();
        waistTextField = new JTextField();
        lengthTextField = new JTextField();
        inseamTextField = new JTextField();
        orderDateTextField = new JTextField("YYYY-MM-DD");
        deliveryDateTextField = new JTextField("YYYY-MM-DD");
        quantityTextField = new JTextField();
        typeField = new JComboBox<>(new String[]{"Select", "Straight", "Cuff"});
        statusField = new JComboBox<>(new String[]{"Select", "Pending", "Progress", "Completed", "Delivered"});


        // Setting bounds for widgets
        pantHeading.setBounds(200, 10, 200, 50);

        waistLabel.setBounds(50, 90, 100, 30);
        waistTextField.setBounds(150, 90, 200, 30);

        descriptionLabel.setBounds(400, 90, 100, 30);
        descriptionTextArea.setBounds(500, 90, 230, 100);

        lengthLabel.setBounds(50, 140, 100, 30);
        lengthTextField.setBounds(150, 140, 200, 30);

        inseamLabel.setBounds(50, 190, 100, 30);
        inseamTextField.setBounds(150, 190, 200, 30);

        typeLabel.setBounds(50, 240, 100, 30);
        typeField.setBounds(150, 240, 200, 30);

        statusLabel.setBounds(50, 290, 100, 30);
        statusField.setBounds(150, 290, 200, 30);


        orderDateLabel.setBounds(50, 340, 100, 30);
        orderDateTextField.setBounds(150, 340, 200, 30);

        deliveryDateLabel.setBounds(50, 380, 100, 30);
        deliveryDateTextField.setBounds(150, 380, 200, 30);

        quantityLabel.setBounds(50, 420, 100, 30);
        quantityTextField.setBounds(150, 420, 200, 30);


        clearButton.setBounds(500, 200, 80, 30);
        saveButton.setBounds(600, 200, 80, 30);

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
        panel.add(orderDateLabel);
        panel.add(orderDateTextField);
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
        orderDateTextField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (orderDateTextField.getText().equals("YYYY-MM-DD"))
                    orderDateTextField.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (orderDateTextField.getText().isEmpty())
                    orderDateTextField.setText("YYYY-MM-DD");
            }
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

        saveButton.addActionListener(e -> {
            if (waistTextField.getText().isBlank())
                JOptionPane.showMessageDialog(null, "Please Enter Waist");
            else if (lengthTextField.getText().isBlank())
                JOptionPane.showMessageDialog(null, "Please Enter Length");
            else if (inseamTextField.getText().isBlank())
                JOptionPane.showMessageDialog(null, "Please Enter Inseam");
//            else if (orderDateTextField.getText().isBlank())
//                orderDateTextField.setText(java.time.LocalDate.now().toString());
//            else if (deliveryDateTextField.getText().isBlank())
//                deliveryDateTextField.setText(java.time.LocalDate.now().plusDays(7).toString());
//            else if (statusField.getSelectedIndex() == 0)
//                statusField.setSelectedIndex(1);
//            else if (quantityTextField.getText().isBlank())
//                quantityTextField.setText("1");
            else {
                // Parse input values
                float waist = Float.parseFloat(waistTextField.getText());
                float length = Float.parseFloat(lengthTextField.getText());
                float inseam = Float.parseFloat(inseamTextField.getText());
                byte type = (byte) typeField.getSelectedIndex();
                byte status = (byte) statusField.getSelectedIndex();
                String description = descriptionTextArea.getText();
                int quantity = Integer.parseInt(quantityTextField.getText());
                java.sql.Date orderDate = java.sql.Date.valueOf(orderDateTextField.getText());
                java.sql.Date deliveryDate = java.sql.Date.valueOf(deliveryDateTextField.getText());

                // Create a Pant object
                Pant pant = new Pant(waist, length, type, inseam, status, description, quantity, orderDate, deliveryDate);
                Main.getOrders().getFirst().getPants().add(pant);
                JOptionPane.showMessageDialog(null, "Pant added successfully");
//                if (!Main.getOrders().getFirst().getPants().isEmpty()){
//                    for (int i = 0; i < Main.getOrders().getFirst().getPants().size(); i++){
//                        System.out.println(Main.getOrders().getFirst().toString());
//                        System.out.println(Main.getOrders().getFirst().getPants().get(i).toString());
//                    }
//                }else {
//                    System.out.println("No pant found");
//                }
            }
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

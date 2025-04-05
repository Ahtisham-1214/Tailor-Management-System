import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

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
    private JLabel orderDateLabel;
    private JLabel deliveryDateLabel;
    private JLabel quantityLabel;
    private JLabel collarTypeLabel;


    private JTextField chestTextField;
    private JTextField neckTextField;
    private JTextField shoulderTextField;
    private JTextField sleeveLengthField;
    private JTextField shirtLengthField;
    private JComboBox<String> statusTextField;
    private JComboBox<String> cuffTypeField;
    private JComboBox<String> collarTypeField;
    private JTextArea descriptionField;
    private JTextField quantityTextField;
    private JLabel shirtHeading;
    private JButton clearButton;
    private JButton saveButton;
    private JTextField deliveryDateTextField;
    private JTextField orderDateTextField;


    public ShirtPanel() {
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(400, 100, 750, 650);
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
        orderDateLabel = new JLabel("Order Date");
        deliveryDateLabel = new JLabel("Delivery Date");
        quantityLabel = new JLabel("Quantity");
        descriptionLabel = new JLabel("Description");
        collarTypeLabel = new JLabel("Collar Type");

        chestTextField = new JTextField();
        neckTextField = new JTextField();
        shoulderTextField = new JTextField();
        sleeveLengthField = new JTextField();
        shirtLengthField = new JTextField();
        collarTypeField = new JComboBox<>(new String[]{"Select", "Classic","Standard","Cooper"});
        cuffTypeField = new JComboBox<>(new String[]{"Select", "Half Sleeves", "Square", "Round"});
        statusTextField = new JComboBox<>(new String[]{"Select", "Pending", "Process", "Completed", "Delivered"});
        orderDateTextField = new JTextField("YYYY-MM-DD");
        deliveryDateTextField = new JTextField("YYYY-MM-DD");
        quantityTextField = new JTextField();
        descriptionField = new JTextArea();

        chestLabel.setBounds(10, 60, 100, 30);
        neckLabel.setBounds(10, 100, 100, 30);
        shoulderLabel.setBounds(10, 140, 100, 30);
        sleeveLengthLabel.setBounds(10, 180, 100, 30);
        shirtLengthLabel.setBounds(10, 220, 100, 30);
        cuffTypeLabel.setBounds(10, 260, 100, 30);
        statusLabel.setBounds(10, 300, 100, 30);
        orderDateLabel.setBounds(10, 340, 100, 30);
        deliveryDateLabel.setBounds(10, 380, 100, 30);
        quantityLabel.setBounds(10, 420, 100, 30);
        collarTypeLabel.setBounds(10, 460, 100, 30);
        descriptionLabel.setBounds(320, 60, 100, 30);

        chestTextField.setBounds(120, 60, 150, 30);
        neckTextField.setBounds(120, 100, 150, 30);
        shoulderTextField.setBounds(120, 140, 150, 30);
        sleeveLengthField.setBounds(120, 180, 150, 30);
        shirtLengthField.setBounds(120, 220, 150, 30);
        cuffTypeField.setBounds(120, 260, 150, 30);
        statusTextField.setBounds(120, 300, 150, 30);
        orderDateTextField.setBounds(120, 340, 150, 30);
        deliveryDateTextField.setBounds(120, 380, 150, 30);
        quantityTextField.setBounds(120, 420, 150, 30);
        collarTypeField.setBounds(120, 460, 150, 30);
        descriptionField.setBounds(420, 60, 230, 100);

        clearButton.setBounds(400, 200, 80, 30);
        saveButton.setBounds(500, 200, 80, 30);


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
        panel.add(orderDateLabel);
        panel.add(deliveryDateTextField);
        panel.add(quantityTextField);
        panel.add(collarTypeField);
        panel.add(descriptionField);


        panel.add(chestLabel);
        panel.add(neckLabel);
        panel.add(shoulderLabel);
        panel.add(statusLabel);
        panel.add(collarTypeLabel);
        panel.add(cuffTypeLabel);
        panel.add(orderDateTextField);
        panel.add(deliveryDateLabel);
        panel.add(quantityLabel);
        panel.add(descriptionLabel);
        panel.add(sleeveLengthLabel);
        panel.add(shirtLengthLabel);


        clearButton.addActionListener(e -> {
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
        saveButton.addActionListener(e -> {
            if (chestTextField.getText().isBlank())
                JOptionPane.showMessageDialog(null, "Enter a Chest", "Chest Error", JOptionPane.ERROR_MESSAGE);
            else if (neckTextField.getText().isBlank())
                JOptionPane.showMessageDialog(null, "Enter Neck", "Neck Error", JOptionPane.ERROR_MESSAGE);
            else if (shoulderTextField.getText().isBlank())
                JOptionPane.showMessageDialog(null, "Enter Shoulder", "Shoulder Error", JOptionPane.ERROR_MESSAGE);
            else if (sleeveLengthField.getText().isBlank())
                JOptionPane.showMessageDialog(null, "Enter Sleeve Length", "Sleeve Length Error", JOptionPane.ERROR_MESSAGE);
            else if (shirtLengthField.getText().isBlank())
                JOptionPane.showMessageDialog(null, "Enter Shirt Length", "Shirt Length Error", JOptionPane.ERROR_MESSAGE);
            else {
                float chest = Float.parseFloat(chestTextField.getText());
                float neck = Float.parseFloat(neckTextField.getText());
                float shoulder = Float.parseFloat(shoulderTextField.getText());
                float sleeveLength = Float.parseFloat(sleeveLengthField.getText());
                float shirtLength = Float.parseFloat(shirtLengthField.getText());
                byte cuffType = (byte) cuffTypeField.getSelectedIndex();
                byte status = (byte) statusTextField.getSelectedIndex();
                byte collarType = (byte) collarTypeField.getSelectedIndex();
                java.sql.Date orderDate = java.sql.Date.valueOf(orderDateTextField.getText());
                java.sql.Date deliveryDate = java.sql.Date.valueOf(deliveryDateTextField.getText());
                int quantity = Integer.parseInt(quantityTextField.getText());
                String description = descriptionField.getText();
                
                Shirt shirt = new Shirt(chest, sleeveLength, shirtLength, shoulder, neck, collarType, cuffType, status, description, quantity, orderDate, deliveryDate);
                Main.getOrders().getFirst().getShirts().add(shirt);
                JOptionPane.showMessageDialog(null, "Shirt Added successfully");
                if (!Main.getOrders().getFirst().getShirts().isEmpty()){
                    for (int i = 0; i < Main.getOrders().getFirst().getShirts().size(); i++){
                        System.out.println(Main.getOrders().getFirst().toString());
                        System.out.println(Main.getOrders().getFirst().getShirts().get(i).toString());
                    }
                }else {
                    System.out.println("No shirt found");
                }
            }
        });
        orderDateTextField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (orderDateTextField.getText().equals("YYYY-MM-DD")) {
                    orderDateTextField.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (orderDateTextField.getText().isEmpty()){
                    orderDateTextField.setText("YYYY-MM-DD");
                }
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

    }

    public JPanel getPanel() {
        return panel;
    }
}

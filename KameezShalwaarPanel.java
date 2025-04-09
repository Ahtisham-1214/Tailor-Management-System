import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.Date;

public class KameezShalwaarPanel {
    private JPanel panel;

    private JLabel trouserTypeLabel;
    private JLabel trouserLengthLabel;
    private JLabel trouserWidthLabel;
    private JLabel kameezLengthLabel;
    private JLabel sleevesLabel;
    private JLabel cuffTypeLabel;
    private JLabel kameezTypeLabel;
    private JLabel shoulderLabel;
    private JLabel neckLabel;
    private JLabel collarTypeLabel;
    private JLabel orderDateLabel;
    private JLabel deliveryDateLabel;
    private JLabel descriptionLabel;
    private JLabel quantityLabel;
    private JLabel statusLabel;
    private JLabel kameezShalwaarHeading;

    private JComboBox<String> trouserTypeField; // 1 for shalwaar 2 for Pajama
    private JTextField trouserLengthTextField;
    private JTextField trouserWidthTextField;
    private JTextField kameezLengthTextField;
    private JTextField sleevesTextField;
    private JTextField shoulderTextField;
    private JTextField neckTextField;
    private JComboBox<String> cuffTypeField;
    private JComboBox<String> kameezTypeField;
    private JComboBox<String> collarTypeField; //1 for Cooper, 2 for french 3 for sherwani
    private JComboBox<String> statusField;
    private JTextField orderDateTextField;
    private JTextField deliveryDateTextField;
    private JTextArea descriptionField;
    private JTextField quantityTextField;
    private JButton clearButton;
    private JButton saveButton;

    public KameezShalwaarPanel() {
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(450, 30, 850, 650);
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


        trouserLengthLabel = new JLabel("Trouser Length");
        trouserWidthLabel = new JLabel("Trouser Width");
        trouserTypeLabel = new JLabel("Trouser Type");
        kameezLengthLabel = new JLabel("Kameez Length");
        sleevesLabel = new JLabel("Sleeves");
        cuffTypeLabel = new JLabel("Sleeves Type");
        kameezTypeLabel = new JLabel("Kameez Type");
        shoulderLabel = new JLabel("Shoulder");
        neckLabel = new JLabel("Neck");
        collarTypeLabel = new JLabel("Collar Type");
        statusLabel = new JLabel("Status");
        orderDateLabel = new JLabel("Order Date");
        deliveryDateLabel = new JLabel("Delivery Date");
        quantityLabel = new JLabel("Quantity");
        descriptionLabel = new JLabel("Description");


        kameezLengthTextField = new JTextField();
        sleevesTextField = new JTextField();
        shoulderTextField = new JTextField();
        neckTextField = new JTextField();
        trouserLengthTextField = new JTextField();
        trouserWidthTextField = new JTextField();
        trouserTypeField = new JComboBox<>(new String[]{"Select", "Shalwaar", "Pajama"});
        collarTypeField = new JComboBox<>(new String[]{"Select", "Cooper", "French", "Sherwani"});
        statusField = new JComboBox<>(new String[]{"Select", "Pending", "Process", "Completed", "Delivered"});
        orderDateTextField = new JTextField("YYYY-MM-DD");
        deliveryDateTextField = new JTextField("YYYY-MM-DD");
        quantityTextField = new JTextField();
        descriptionField = new JTextArea();
        cuffTypeField = new JComboBox<>(new String[]{"Select", "Square", "Oval"});
        kameezTypeField = new JComboBox<>(new String[]{"Select", "Square", "Oval"});


        kameezShalwaarHeading.setBounds(50, 10, 600, 30);

        kameezLengthLabel.setBounds(20, 60, 100, 30);
        kameezLengthTextField.setBounds(130, 60, 200, 30);

        trouserLengthLabel.setBounds(400, 60, 100, 30);
        trouserLengthTextField.setBounds(530, 60, 200, 30);

        sleevesLabel.setBounds(20, 100, 100, 30);
        sleevesTextField.setBounds(130, 100, 200, 30);

        trouserWidthLabel.setBounds(400, 100, 100, 30);
        trouserWidthTextField.setBounds(530, 100, 200, 30);

        shoulderLabel.setBounds(20, 140, 230, 30);
        shoulderTextField.setBounds(130, 140, 200, 30);

        trouserTypeLabel.setBounds(400, 140, 100, 30);
        trouserTypeField.setBounds(530, 140, 200, 30);

        neckLabel.setBounds(20, 180, 100, 30);
        neckTextField.setBounds(130, 180, 200, 30);

        descriptionLabel.setBounds(400, 180, 460, 30);
        descriptionField.setBounds(530, 180, 200, 100);

        clearButton.setBounds(530, 310, 80, 30);
        saveButton.setBounds(630, 310, 80, 30);

        collarTypeLabel.setBounds(20, 220, 230, 30);
        collarTypeField.setBounds(130, 220, 200, 30);

        cuffTypeLabel.setBounds(20, 270, 230, 30);
        cuffTypeField.setBounds(130, 270, 200, 30);

        kameezTypeLabel.setBounds(20, 320, 230, 30);
        kameezTypeField.setBounds(130, 320, 200, 30);

        statusLabel.setBounds(20, 370, 230, 30);
        statusField.setBounds(130, 370, 200, 30);

        orderDateLabel.setBounds(20, 420, 230, 30);
        orderDateTextField.setBounds(130, 420, 200, 30);

        deliveryDateLabel.setBounds(20, 470, 230, 30);
        deliveryDateTextField.setBounds(130, 470, 200, 30);

        quantityLabel.setBounds(20, 520, 230, 30);
        quantityTextField.setBounds(130, 520, 200, 30);


        panel.add(saveButton);
        panel.add(clearButton);
        panel.add(kameezShalwaarHeading);
        panel.add(kameezLengthLabel);
        panel.add(sleevesLabel);
        panel.add(cuffTypeLabel);
        panel.add(kameezTypeLabel);
        panel.add(shoulderLabel);
        panel.add(neckLabel);
        panel.add(collarTypeLabel);
        panel.add(statusLabel);
        panel.add(orderDateLabel);
        panel.add(deliveryDateLabel);
        panel.add(quantityLabel);
        panel.add(descriptionLabel);

        panel.add(kameezLengthTextField);
        panel.add(sleevesTextField);
        panel.add(shoulderTextField);
        panel.add(neckTextField);
        panel.add(collarTypeField);
        panel.add(statusField);
        panel.add(orderDateTextField);
        panel.add(deliveryDateTextField);
        panel.add(quantityTextField);
        panel.add(descriptionField);
        panel.add(cuffTypeField);
        panel.add(kameezTypeField);

        panel.add(trouserLengthLabel);
        panel.add(trouserLengthTextField);
        panel.add(trouserWidthLabel);
        panel.add(trouserWidthTextField);
        panel.add(trouserTypeLabel);
        panel.add(trouserTypeField);


        clearButton.addActionListener(e -> {
            kameezLengthTextField.setText("");
            sleevesTextField.setText("");
            shoulderTextField.setText("");
            neckTextField.setText("");
            deliveryDateTextField.setText("");
            quantityTextField.setText("");
            collarTypeField.setSelectedIndex(0);
            statusField.setSelectedIndex(0);
            descriptionField.setText("");
        });

        saveButton.addActionListener(e -> {
            if (kameezLengthTextField.getText().isBlank())
                JOptionPane.showMessageDialog(null, "Enter Kameez Length", "Kameez Error", JOptionPane.ERROR_MESSAGE);
            else if (sleevesTextField.getText().isBlank())
                JOptionPane.showMessageDialog(null, "Enter Sleeves", "Sleeves Error", JOptionPane.ERROR_MESSAGE);
            else if (shoulderTextField.getText().isBlank())
                JOptionPane.showMessageDialog(null, "Enter Shoulder", "Shoulder Error", JOptionPane.ERROR_MESSAGE);
            else if (neckTextField.getText().isBlank())
                JOptionPane.showMessageDialog(null, "Enter Neck", "Neck Error", JOptionPane.ERROR_MESSAGE);
            else if (trouserLengthTextField.getText().isBlank())
                JOptionPane.showMessageDialog(null, "Enter Trouser Length", "Trouser Length Error", JOptionPane.ERROR_MESSAGE);
            else if (trouserWidthTextField.getText().isBlank())
                JOptionPane.showMessageDialog(null, "Enter Trouser Width", "Trouser Width Error", JOptionPane.ERROR_MESSAGE);
            else if (trouserTypeField.getSelectedIndex() == 0)
                JOptionPane.showMessageDialog(null, "Select Trouser Type", "Trouser Type Error", JOptionPane.ERROR_MESSAGE);
            else {
                try {
                    float kameezLength = Float.parseFloat(kameezLengthTextField.getText());
                    float sleeves = Float.parseFloat(sleevesTextField.getText());
                    float shoulder = Float.parseFloat(shoulderTextField.getText());
                    float neck = Float.parseFloat(neckTextField.getText());
                    float trouserLength = Float.parseFloat(trouserLengthTextField.getText());
                    float trouserWidth = Float.parseFloat(trouserWidthTextField.getText());
                    byte trouserType = (byte) trouserTypeField.getSelectedIndex();
                    byte collarType = (byte) collarTypeField.getSelectedIndex();
                    byte cuffType = (byte) cuffTypeField.getSelectedIndex();
                    byte kameezType = (byte) kameezTypeField.getSelectedIndex();
                    byte status = (byte) statusField.getSelectedIndex();
                    java.sql.Date orderDate = java.sql.Date.valueOf(orderDateTextField.getText());
                    java.sql.Date deliveryDate = java.sql.Date.valueOf(deliveryDateTextField.getText());
                    int quantity = Integer.parseInt(quantityTextField.getText());
                    String description = descriptionField.getText();

                    KameezShalwaar kameezShalwaar = new KameezShalwaar(trouserLength, trouserType, trouserWidth, kameezLength, sleeves, cuffType, kameezType, shoulder, neck, collarType, status, description, quantity, orderDate, deliveryDate);
                    Main.getOrders().getFirst().getKameezShalwaars().add(kameezShalwaar);

                    JOptionPane.showMessageDialog(null, "Kameez Shalwaar saved successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);

//                    if (!Main.getOrders().getFirst().getKameezShalwaars().isEmpty()){
//                        for (int i = 0; i < Main.getOrders().getFirst().getKameezShalwaars().size(); i++){
//                            System.out.println(Main.getOrders().getFirst().toString());
//                            System.out.println(Main.getOrders().getFirst().getKameezShalwaars().get(i).toString());
//                        }
//                    }else {
//                        System.out.println("No pant found");
//                    }

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Please enter valid numeric values where required.", "Input Error", JOptionPane.ERROR_MESSAGE);
                }
            }

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


    }

    public JPanel getPanel() {
        return panel;
    }
}

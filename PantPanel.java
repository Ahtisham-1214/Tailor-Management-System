import javax.swing.*;
import java.awt.*;

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

    private JButton clearButton;
    private JButton saveButton;

    private JTextArea descriptionTextArea;
    private JTextField waistTextField;
    private JTextField lengthTextField;
    private JTextField inseamTextField;
    private JComboBox<String> typeField;
    private JComboBox<String> statusField;
    private JTextField deliveryDateTextField;

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
        descriptionLabel = new JLabel("Description");


        descriptionTextArea = new JTextArea();
        waistTextField = new JTextField();
        lengthTextField = new JTextField();
        inseamTextField = new JTextField();
        deliveryDateTextField = new JTextField();
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

        descriptionLabel.setBounds(50, 380, 100, 30);
        descriptionTextArea.setBounds(150, 380, 230, 100);

        clearButton.setBounds(150, 500, 80, 30);
        saveButton.setBounds(250, 500, 80, 30);

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

        clearButton.addActionListener(e -> {
            inseamTextField.setText("");
            waistTextField.setText("");
            lengthTextField.setText("");
            typeField.setSelectedIndex(0);
            statusField.setSelectedIndex(0);
            descriptionTextArea.setText("");
        });

    }

    public JPanel getPanel() {
        return panel;
    }
}

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

    private JTextArea descriptionTextArea;
    private JTextField waistTextField;
    private JTextField lengthTextField;
    private JTextField inseamTextField;
    private JComboBox<String> typeField;
    private JComboBox<String> statusField;
    private JLabel pantHeading;

    public PantPanel() {
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(450, 20, 400, 450);
        panel.setBackground(new Color(169, 169, 169));



        // Widgets
        pantHeading = new JLabel("Pant");
        pantHeading.setFont(new Font("Arial Black", Font.BOLD, 30));


        waistLabel = new JLabel("Waist");
        lengthLabel = new JLabel("Length");
        typeLabel = new JLabel("Type");
        statusLabel = new JLabel("Status");
        inseamLabel = new JLabel("Inseam");
        descriptionLabel = new JLabel("Description");

        descriptionTextArea = new JTextArea();
        waistTextField = new JTextField();
        lengthTextField = new JTextField();
        inseamTextField = new JTextField();
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

        descriptionLabel.setBounds(50, 340, 100, 30);
        descriptionTextArea.setBounds(150, 340, 230, 100);


        // Adding widgets to panel
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


    }

    public JPanel getPanel() {
        return panel;
    }
}

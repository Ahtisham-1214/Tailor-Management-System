import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class SetTailorDetailPanel {
    private JPanel panel;
    private JLabel nameLabel;
    private JTextField nameField;
    private JLabel addressLabel;
    private JTextField addressField;
    private JLabel phoneLabel;
    private JTextField phoneField;
    private JLabel emailLabel;
    private JTextField emailField;
    private JButton setButton;

    public SetTailorDetailPanel() {
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(450, 20, 600, 600);
        panel.setBackground(Color.DARK_GRAY);

        nameLabel = new JLabel("Name");
        nameField = new JTextField();
        addressLabel = new JLabel("Address");
        addressField = new JTextField();
        phoneLabel = new JLabel("Phone");
        phoneField = new JTextField();
        emailLabel = new JLabel("Email");
        emailField = new JTextField();
        setButton = new JButton("Set");

        nameLabel.setForeground(Color.white);
        addressLabel.setForeground(Color.white);
        phoneLabel.setForeground(Color.white);
        emailLabel.setForeground(Color.white);


        nameLabel.setBounds(10, 20, 50, 20);
        addressLabel.setBounds(10, 60, 50, 20);
        phoneLabel.setBounds(10, 90, 50, 20);
        emailLabel.setBounds(10, 120, 50, 20);

        nameField.setBounds(70, 20, 150, 20);
        addressField.setBounds(70, 60, 150, 20);
        phoneField.setBounds(70, 90, 150, 20);
        emailField.setBounds(70, 120, 150, 20);
        setButton.setBounds(100, 160, 90, 30);


        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(addressLabel);
        panel.add(addressField);
        panel.add(phoneLabel);
        panel.add(phoneField);
        panel.add(emailLabel);
        panel.add(emailField);
        panel.add(setButton);

        setButton.addActionListener(e -> {
            String shopName = nameField.getText();
            String address = addressField.getText();
            String phone = phoneField.getText();
            String email = emailField.getText();

            // Validate input
            if (shopName.isEmpty() || address.isEmpty() || phone.isEmpty() || email.isEmpty()) {
                JOptionPane.showMessageDialog(null, "All fields are required!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Insert data into the database using DatabaseConnection
            try (Connection connection = DatabaseConnection.getConnection()) {
                String query = "UPDATE details SET shop_name = ?, address = ?, phone_no = ?, email = ? WHERE id = 1";
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, shopName);
                preparedStatement.setString(2, address);
                preparedStatement.setString(3, phone);
                preparedStatement.setString(4, email);

                int rowsInserted = preparedStatement.executeUpdate();
                if (rowsInserted > 0) {
                    JOptionPane.showMessageDialog(null, "Details set successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error while inserting data into the database.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
    }


    public JPanel getPanel() {
        return panel;
    }
}

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TailorDetailPanel {
    private JPanel panel;
    private JLabel nameLabel;
    private JLabel addressLabel;
    private JLabel contactLabel;
    private JLabel emailLabel;
    private JButton backButton;

    public TailorDetailPanel() {
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(0, 0, 250, 800);
        panel.setBackground(Color.DARK_GRAY);


        nameLabel = new JLabel();
        addressLabel = new JLabel();
        contactLabel = new JLabel();
        emailLabel = new JLabel();


        nameLabel.setFont(new Font("Arial", Font.BOLD, 20));
        addressLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        contactLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        emailLabel.setFont(new Font("Arial", Font.PLAIN, 15));

        nameLabel.setForeground(Color.DARK_GRAY);
        addressLabel.setForeground(Color.DARK_GRAY);
        contactLabel.setForeground(Color.DARK_GRAY);
        emailLabel.setForeground(Color.DARK_GRAY);

        nameLabel.setOpaque(true);
        addressLabel.setOpaque(true);
        contactLabel.setOpaque(true);
        emailLabel.setOpaque(true);

        nameLabel.setBackground(Color.WHITE);
        addressLabel.setBackground(Color.WHITE);
        contactLabel.setBackground(Color.WHITE);
        emailLabel.setBackground(Color.WHITE);

        backButton = new JButton("Back");
        backButton.setBackground(Color.WHITE);
        backButton.setForeground(Color.DARK_GRAY);
        backButton.setOpaque(true);

        backButton.setBounds(0, 20, 80, 40);
        nameLabel.setBounds(0, 200, 250, 40);
        contactLabel.setBounds(0, 250, 250, 40);
        emailLabel.setBounds(0, 300, 250, 40);
        addressLabel.setBounds(0, 350, 250, 40);

        panel.add(backButton);
        panel.add(nameLabel);
        panel.add(contactLabel);
        panel.add(emailLabel);
        panel.add(addressLabel);
        fetchDataFromDatabase();

    }
    private void fetchDataFromDatabase() {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "SELECT shop_name, address, phone_no, email FROM details WHERE id = 1";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                nameLabel.setText(resultSet.getString("shop_name"));
                addressLabel.setText(resultSet.getString("address"));
                contactLabel.setText(resultSet.getString("phone_no"));
                emailLabel.setText(resultSet.getString("email"));
            } else {
                JOptionPane.showMessageDialog(null, "No data found in the database!", "Info", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error fetching data from the database.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public JButton getBackButton() {
        return backButton;
    }

    public JPanel getPanel() {
        return panel;
    }
}

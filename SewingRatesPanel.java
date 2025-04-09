import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class SewingRatesPanel {
    private JPanel panel;
    private JLabel shirtPriceLabel;
    private JLabel pantPriceLabel;
    private JLabel coatPriceLabel;
    private JLabel kameezShalwaarPriceLabel;

    private JTextField shirtPriceTextField;
    private JTextField pantPriceTextField;
    private JTextField coatPriceTextField;
    private JTextField kameezShalwaarPriceTextField;

    private JButton saveButton;

    public SewingRatesPanel() {
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(450, 20, 600, 600);
        panel.setBackground(Color.DARK_GRAY);

        shirtPriceLabel = new JLabel("Shirt Price");
        shirtPriceTextField = new JTextField();

        pantPriceLabel = new JLabel("Pant Price");
        pantPriceTextField = new JTextField();

        coatPriceLabel = new JLabel("Coat Price");
        coatPriceTextField = new JTextField();

        kameezShalwaarPriceLabel = new JLabel("Kameez Shalwaar Price");
        kameezShalwaarPriceTextField = new JTextField();

        saveButton = new JButton("Save");

        shirtPriceLabel.setForeground(Color.WHITE);
        pantPriceLabel.setForeground(Color.WHITE);
        coatPriceLabel.setForeground(Color.WHITE);
        kameezShalwaarPriceLabel.setForeground(Color.WHITE);
        saveButton.setBackground(Color.WHITE);

        shirtPriceLabel.setBounds(10, 20, 80, 20);
        pantPriceLabel.setBounds(10, 60, 80, 20);
        coatPriceLabel.setBounds(10, 100, 80, 20);
        kameezShalwaarPriceLabel.setBounds(10, 140, 250, 20);

        shirtPriceTextField.setBounds(220, 20, 150, 20);
        pantPriceTextField.setBounds(220, 60, 150, 20);
        coatPriceTextField.setBounds(220, 100, 150, 20);
        kameezShalwaarPriceTextField.setBounds(220, 140, 150, 20);

        saveButton.setBounds(200, 170, 80, 20);


        panel.add(shirtPriceLabel);
        panel.add(shirtPriceTextField);
        panel.add(pantPriceLabel);
        panel.add(pantPriceTextField);
        panel.add(coatPriceLabel);
        panel.add(coatPriceTextField);
        panel.add(kameezShalwaarPriceLabel);
        panel.add(kameezShalwaarPriceTextField);
        panel.add(saveButton);

        saveButton.addActionListener(e -> {
            float shirtPrice = Float.parseFloat(shirtPriceTextField.getText());
            float pantPrice = Float.parseFloat(pantPriceTextField.getText());
            float coatPrice = Float.parseFloat(coatPriceTextField.getText());
            float kameezShalwaarPrice = Float.parseFloat(kameezShalwaarPriceTextField.getText());

            try (Connection connection = DatabaseConnection.getConnection()) {
                String query = "UPDATE  price set shirt_price = ?, pant_price = ?, coat_price = ?, kameez_shalwaar_price = ? where id = 1";
                assert connection != null;
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setFloat(1, shirtPrice);
                preparedStatement.setFloat(2, pantPrice);
                preparedStatement.setFloat(3, coatPrice);
                preparedStatement.setFloat(4, kameezShalwaarPrice);
                int rowsAffected = preparedStatement.executeUpdate();
                if (rowsAffected > 0)
                    JOptionPane.showMessageDialog(null, "Successfully saved");

            } catch (Exception exception) {
                exception.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error while inserting data into the database.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
    }

    public JPanel getPanel() {
        return panel;
    }
}

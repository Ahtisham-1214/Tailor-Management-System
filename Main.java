import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Main {
    private JFrame frame;
    private JPanel loginPanel;
    private JLabel userLabel;
    private JLabel passwordLabel;
    private JTextField userNameTextField;
    private JPasswordField passwordTextField;
    private JButton loginButton;


    public Main() {

        frame = new JFrame("Tailor Management System");
        frame.setLayout(null);
        loginPanel = new JPanel();
        loginPanel.setLayout(null);
        loginPanel.setBounds(0, 0, 800, 600);

        userNameTextField = new JTextField();
        passwordTextField = new JPasswordField();


        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        userLabel = new JLabel("Username: ");
        passwordLabel = new JLabel("Password: ");

        loginButton = new JButton("Login");


        userLabel.setBounds(10, 10, 100, 30);
        passwordLabel.setBounds(10, 40, 100, 30);
        userNameTextField.setBounds(100, 10, 150, 25);
        passwordTextField.setBounds(100, 40, 150, 25);
        loginButton.setBounds(100, 80, 100, 30);


        loginPanel.add(userLabel);
        loginPanel.add(passwordLabel);
        loginPanel.add(userNameTextField);
        loginPanel.add(passwordTextField);
        loginPanel.add(loginButton);


        frame.add(loginPanel);

        frame.setVisible(true);

        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                handleLogin();
            }
        });
    }

    private void handleLogin() {
        String username = userNameTextField.getText();
        String password = new String(passwordTextField.getPassword());

        // Validate input
        if (username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Please enter both username and password.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Check credentials in the database
        try (Connection connection = DatabaseConnection.getConnection()) {
            if (connection == null) {
                JOptionPane.showMessageDialog(frame, "Database connection failed.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String query = "SELECT * FROM users WHERE username = ? AND password = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                JOptionPane.showMessageDialog(frame, "Login successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
                // Proceed to the next screen or functionality
            } else {
                JOptionPane.showMessageDialog(frame, "Invalid username or password.", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(frame, "An error occurred while connecting to the database.", "Error", JOptionPane.ERROR_MESSAGE);
        }


    }


    public static void main(String[] args) {

        Main main = new Main();
    }
}

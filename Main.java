import javax.swing.*;
import java.sql.*;

public class Main {
    private JFrame frame;
    private JPanel welcomePanel;
    private LoginPanel loginPanel;


    public Main() {

        // Frame
        frame = new JFrame("Tailor Management System");
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

        // Labels, Fields and Buttons

        JLabel welcomeText = new JLabel("Welcome to Tailor Management System", SwingConstants.CENTER);
        welcomeText.setBounds(200, 450, 400, 30);
        JLabel imageLabel = new JLabel(new ImageIcon("pic.jpg"));
        imageLabel.setBounds(10, 10, 736, 600);


        // Welcome Panel
        welcomePanel = new JPanel();
        welcomePanel.setLayout(null);
        welcomePanel.setBounds(0, 0, 1000, 700);
        welcomePanel.add(welcomeText);
        welcomePanel.add(imageLabel);


        frame.add(welcomePanel);
        frame.setVisible(true);

        loginPanel = new LoginPanel();

        // Timer to switch panels after 3 seconds
        Timer timer = new Timer(1000, e -> {
            frame.remove(welcomePanel);
            frame.add(loginPanel.getPanel());
            frame.revalidate();
            frame.repaint();
        });
        timer.setRepeats(false); // Ensure the timer runs only once
        timer.start();


        loginPanel.getLoginButton().addActionListener(e -> handleLogin());
    }

    private void handleLogin() {
        String username = loginPanel.getUserNameTextField().getText();
        String password = loginPanel.getPasswordTextField().getText();

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

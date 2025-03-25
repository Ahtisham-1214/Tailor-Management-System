import javax.swing.*;
import java.awt.*;

public class LoginPanel {
    JPanel panel;
    private JLabel userLabel;
    private JLabel passwordLabel;
    private JTextField userNameTextField;
    private JPasswordField passwordTextField;
    private JButton loginButton;
    public LoginPanel() {
        userLabel = new JLabel("Username: ");
        passwordLabel = new JLabel("Password: ");
        userNameTextField = new JTextField();
        passwordTextField = new JPasswordField();

        userLabel.setForeground(Color.WHITE);
        passwordLabel.setForeground(Color.WHITE);

        loginButton = new JButton("Login");
        loginButton.setBackground(Color.WHITE);
        loginButton.setForeground(Color.DARK_GRAY);
        loginButton.setOpaque(true);

        userLabel.setBounds(100, 200, 100, 30);
        passwordLabel.setBounds(100, 250, 100, 30);
        userNameTextField.setBounds(200, 200, 150, 25);
        passwordTextField.setBounds(200, 250, 150, 25);
        loginButton.setBounds(200, 300, 100, 30);


        // Login Panel
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(450, 100, 550, 500);
        panel.setBackground(Color.DARK_GRAY);

        // Adding to Login Panel
        panel.add(userLabel);
        panel.add(passwordLabel);
        panel.add(userNameTextField);
        panel.add(passwordTextField);
        panel.add(loginButton);



    }

    public JPanel getPanel() {
        return panel;
    }

    public JButton getLoginButton() {
        return loginButton;
    }

    public JTextField getUserNameTextField() {
        return userNameTextField;
    }

    public JPasswordField getPasswordTextField() {
        return passwordTextField;
    }
}

import javax.swing.*;

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
        loginButton = new JButton("Login");


        userLabel.setBounds(370, 300, 100, 30);
        passwordLabel.setBounds(370, 350, 100, 30);
        userNameTextField.setBounds(470, 300, 150, 25);
        passwordTextField.setBounds(470, 350, 150, 25);
        loginButton.setBounds(500, 400, 100, 30);


        // Login Panel
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(0, 0, 1000, 700);

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

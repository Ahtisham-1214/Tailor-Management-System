import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;

public class Main {
    private JFrame frame;
    private JPanel welcomePanel;
    private LoginPanel loginPanel;
    TailorDetailPanel tailorDetailPanel;
    SideBarPanel sideBarPanel;
    CustomerPanel customerPanel;
    KameezShalwaarPanel kameezShalwaarPanel;
    CoatPanel coatPanel;
    ShirtPanel shirtPanel;
    PantPanel pantPanel;

    private JPanel orderPanel;
    private JLabel orderLabel;
    private JLabel orderIcon;


    public Main() {

        // Frame
        frame = new JFrame("Tailor Management System");
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setBackground(Color.WHITE);

        // Labels, Fields and Buttons

        JLabel welcomeText = new JLabel("Welcome to Tailor Management System", SwingConstants.CENTER);
        welcomeText.setBounds(200, 450, 400, 30);
        JLabel imageLabel = new JLabel(new ImageIcon("pic.jpg"));
        imageLabel.setBounds(10, 10, 736, 600);

        orderPanel = new JPanel();
        orderPanel.setBackground(Color.GRAY);
        orderPanel.setLayout(null);
        orderPanel.setBounds(450, 150, 200, 200);

        orderIcon = new JLabel( new ImageIcon("OrderIcon.png"));

        orderLabel = new JLabel("Order");
        orderLabel.setForeground(Color.BLACK);
        orderLabel.setFont(new Font("Serif", Font.BOLD, 30));
//        orderLabel.setOpaque(true);
        orderIcon.setBounds(40, 10, 100, 150);
        orderLabel.setBounds(50, 150, 80, 30);


        orderPanel.add(orderLabel);
        orderPanel.add(orderIcon);




        sideBarPanel = new SideBarPanel();
        customerPanel = new CustomerPanel();
        coatPanel = new CoatPanel();
        kameezShalwaarPanel = new KameezShalwaarPanel();
        pantPanel = new PantPanel();
        shirtPanel = new ShirtPanel();

        // Welcome Panel
        welcomePanel = new JPanel();
        welcomePanel.setLayout(null);
        welcomePanel.setBounds(0, 0, 1000, 700);
        welcomePanel.add(welcomeText);
        welcomePanel.add(imageLabel);


        frame.add(welcomePanel);
        frame.setVisible(true);

        loginPanel = new LoginPanel();
        tailorDetailPanel = new TailorDetailPanel();

        // Timer to switch panels after 3 seconds
        Timer timer = new Timer(0, e -> {
            frame.remove(welcomePanel);
            frame.add(tailorDetailPanel.getPanel());
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

                frame.getContentPane().removeAll();
                frame.add(tailorDetailPanel.getPanel());
                frame.add(orderPanel);
                frame.revalidate();
                frame.repaint();


            } else {
                JOptionPane.showMessageDialog(frame, "Invalid username or password.", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(frame, "An error occurred while connecting to the database.", "Error", JOptionPane.ERROR_MESSAGE);
        }


        sideBarPanel.getPantLabel().addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                frame.getContentPane().removeAll(); // Remove all components
                frame.add(pantPanel.getPanel()); // Add PantPanel
                frame.add(sideBarPanel.getPanel()); // Re-add SideBarPanel
                frame.revalidate(); // Revalidate the frame
                frame.repaint(); // Repaint the frame
            }
        });

        sideBarPanel.getShirtLabel().addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent e) {
                frame.getContentPane().removeAll();
                frame.add(shirtPanel.getPanel());
                frame.add(sideBarPanel.getPanel());
                frame.revalidate();
                frame.repaint();
            }
        });

        sideBarPanel.getCoatLabel().addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent e) {
                frame.getContentPane().removeAll();
                frame.add(coatPanel.getPanel());
                frame.add(sideBarPanel.getPanel());
                frame.revalidate();
                frame.repaint();
            }
        });

        sideBarPanel.getKameezShalwaarLabel().addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent e) {
                frame.getContentPane().removeAll();
                frame.add(kameezShalwaarPanel.getPanel());
                frame.add(sideBarPanel.getPanel());
                frame.revalidate();
                frame.repaint();
            }
        });


        orderPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                frame.getContentPane().removeAll();
                frame.add(sideBarPanel.getPanel());
                frame.add(customerPanel.getPanel());
                frame.revalidate();
                frame.repaint();
            }
        });


    }


    public static void main(String[] args) {

        Main main = new Main();
    }
}

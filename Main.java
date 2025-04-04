import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.LinkedList;

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
    SetTailorDetailPanel setTailorDetailPanel;

    private JPanel orderPanel;
    private JLabel orderLabel;
    private JLabel orderIcon;

    private JPanel viewPanel;
    private JLabel viewLabel;
    private JLabel viewIcon;

    private JPanel settingsPanel;
    private JLabel settingsLabel;
    private JLabel settingsIcon;

    private JPanel analysisPanel;
    private JLabel analysisLabel;
    private JLabel analysisIcon;
    private static LinkedList<Customer> orders;

    public Main() {
        orders = new LinkedList<>();
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
        viewPanel = new JPanel();
        settingsPanel = new JPanel();
        analysisPanel = new JPanel();

        orderPanel.setBackground(Color.GRAY);
        viewPanel.setBackground(Color.GRAY);
        analysisPanel.setBackground(Color.GRAY);
        settingsPanel.setBackground(Color.GRAY);

        orderPanel.setLayout(null);
        viewPanel.setLayout(null);
        analysisPanel.setLayout(null);
        settingsPanel.setLayout(null);

        orderPanel.setBounds(450, 150, 200, 200);
        viewPanel.setBounds(750, 150, 200, 200);
        analysisPanel.setBounds(450, 450, 200, 200);
        settingsPanel.setBounds(750, 450, 200, 200);

        orderIcon = new JLabel(new ImageIcon("OrderIcon.png"));
        viewIcon = new JLabel(new ImageIcon("table.png"));
        analysisIcon = new JLabel(new ImageIcon("analysis.png"));
        settingsIcon = new JLabel(new ImageIcon("settings.png"));


        viewLabel = new JLabel("View");
        viewLabel.setForeground(Color.BLACK);
        viewLabel.setFont(new Font("Serif", Font.BOLD, 30));
//        viewLabel.setOpaque(true);


        orderLabel = new JLabel("Order");
        orderLabel.setForeground(Color.BLACK);
        orderLabel.setFont(new Font("Serif", Font.BOLD, 30));
//        orderLabel.setOpaque(true);

        analysisLabel = new JLabel("Analysis");
        analysisLabel.setForeground(Color.BLACK);
        analysisLabel.setFont(new Font("Serif", Font.BOLD, 20));
//        analyticsLabel.setOpaque(true);

        settingsLabel = new JLabel("Settings");
        settingsLabel.setForeground(Color.BLACK);
        settingsLabel.setFont(new Font("Serif", Font.BOLD, 20));
//        orderLabel.setOpaque(true);


        orderLabel.setBounds(50, 150, 80, 30);
        viewLabel.setBounds(50, 150, 80, 30);
        analysisLabel.setBounds(50, 150, 80, 30);
        settingsLabel.setBounds(50, 150, 80, 30);

        orderIcon.setBounds(40, 10, 100, 150);
        viewIcon.setBounds(40, 10, 140, 150);
        analysisIcon.setBounds(40, 10, 150, 150);
        settingsIcon.setBounds(40, 10, 150, 150);


        orderPanel.add(orderLabel);
        orderPanel.add(orderIcon);

        viewPanel.add(viewLabel);
        viewPanel.add(viewIcon);

        settingsPanel.add(settingsLabel);
        settingsPanel.add(settingsIcon);

        analysisPanel.add(analysisLabel);
        analysisPanel.add(analysisIcon);

        sideBarPanel = new SideBarPanel();
        customerPanel = new CustomerPanel();
        coatPanel = new CoatPanel();
        kameezShalwaarPanel = new KameezShalwaarPanel();
        pantPanel = new PantPanel();
        shirtPanel = new ShirtPanel();
        setTailorDetailPanel = new SetTailorDetailPanel();
        loginPanel = new LoginPanel();
        tailorDetailPanel = new TailorDetailPanel();

        // Welcome Panel
        welcomePanel = new JPanel();
        welcomePanel.setLayout(null);
        welcomePanel.setBounds(0, 0, 1000, 700);
        welcomePanel.add(welcomeText);
        welcomePanel.add(imageLabel);


        frame.add(welcomePanel);
        frame.setVisible(true);


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


        actionsAndListeners();
    }

    public static LinkedList<Customer> getOrders() {
        return orders;
    }

    public static void main(String[] args) {

        Main main = new Main();

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
//                JOptionPane.showMessageDialog(frame, "Login successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
                // Proceed to the next screen or functionality

                frame.getContentPane().removeAll();
                frame.add(tailorDetailPanel.getPanel());
                landingWidgetsPanels(viewPanel, settingsPanel, analysisPanel, orderPanel);


            } else {
                JOptionPane.showMessageDialog(frame, "Invalid username or password.", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(frame, "An error occurred while connecting to the database.", "Error", JOptionPane.ERROR_MESSAGE);
        }


    }

    private void landingWidgetsPanels(JPanel settingsPanel, JPanel analysisPanel, JPanel viewPanel, JPanel orderPanel) {
        frame.add(orderPanel);
        frame.add(settingsPanel);
        frame.add(analysisPanel);
        frame.add(viewPanel);
        frame.revalidate();
        frame.repaint();
    }

    private void actionsAndListeners() {

        loginPanel.getLoginButton().addActionListener(e -> handleLogin());
        frame.getRootPane().setDefaultButton(loginPanel.getLoginButton());
        tailorDetailPanel.getBackButton().addActionListener(e -> {
            frame.getContentPane().removeAll();
            frame.add(tailorDetailPanel.getPanel());
            loginPanel.getUserNameTextField().setText("");
            loginPanel.getPasswordTextField().setText("");
            frame.add(loginPanel.getPanel());
            frame.getRootPane().setDefaultButton(loginPanel.getLoginButton());
            frame.revalidate();
            frame.repaint();
        });

        sideBarPanel.getCustomerLabel().addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                frame.getContentPane().removeAll();
                frame.add(customerPanel.getPanel());
                frame.add(sideBarPanel.getPanel());
                frame.revalidate();
                frame.repaint();
            }
        });
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

        sideBarPanel.getBackButton().addActionListener(e -> {
            frame.getContentPane().removeAll();
            frame.add(tailorDetailPanel.getPanel());
            landingWidgetsPanels(settingsPanel, analysisPanel, viewPanel, orderPanel);
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

        settingsPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent e) {
                frame.getContentPane().removeAll();
                frame.add(setTailorDetailPanel.getSetDetailpanel());
                frame.add(tailorDetailPanel.getPanel());

                frame.revalidate();
                frame.repaint();
            }
        });
    }
}

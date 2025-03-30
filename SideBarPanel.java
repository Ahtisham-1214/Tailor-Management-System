import javax.swing.*;
import java.awt.*;

public class SideBarPanel {
    private JPanel panel;
    private JLabel customerLabel;
    private JLabel shirtLabel;
    private JLabel pantLabel;
    private JLabel coatLabel;
    private JLabel kameezShalwaarLabel;
    private JButton backButton;

    public SideBarPanel() {
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.DARK_GRAY);
        panel.setBounds(0, 0, 250, 800);

        customerLabel = new JLabel("Customer");
        shirtLabel = new JLabel("Shirt");
        pantLabel = new JLabel("Pant");
        coatLabel = new JLabel("Coat");
        kameezShalwaarLabel = new JLabel("Kameez Shalwaar");
        backButton = new JButton("Back");

        customerLabel.setFont(new Font("Arial", Font.BOLD, 20));
        shirtLabel.setFont(new Font("Arial", Font.BOLD, 20));
        pantLabel.setFont(new Font("Arial", Font.BOLD, 20));
        coatLabel.setFont(new Font("Arial", Font.BOLD, 20));
        kameezShalwaarLabel.setFont(new Font("Arial", Font.BOLD, 20));

        customerLabel.setForeground(Color.DARK_GRAY);
        shirtLabel.setForeground(Color.DARK_GRAY);
        pantLabel.setForeground(Color.DARK_GRAY);
        coatLabel.setForeground(Color.DARK_GRAY);
        kameezShalwaarLabel.setForeground(Color.DARK_GRAY);
        backButton.setForeground(Color.DARK_GRAY);

        customerLabel.setOpaque(true);
        shirtLabel.setOpaque(true);
        pantLabel.setOpaque(true);
        coatLabel.setOpaque(true);
        kameezShalwaarLabel.setOpaque(true);
        backButton.setOpaque(true);

        customerLabel.setBackground(Color.WHITE);
        shirtLabel.setBackground(Color.WHITE);
        pantLabel.setBackground(Color.WHITE);
        coatLabel.setBackground(Color.WHITE);
        kameezShalwaarLabel.setBackground(Color.WHITE);
        backButton.setBackground(Color.WHITE);


        customerLabel.setBounds(0, 150, 250, 40);
        shirtLabel.setBounds(0, 200, 250, 40);
        pantLabel.setBounds(0, 250, 250, 40);
        coatLabel.setBounds(0, 300, 250, 40);
        kameezShalwaarLabel.setBounds(0, 350, 250, 40);
        backButton.setBounds(0, 20, 80, 40);


        panel.add(customerLabel);
        panel.add(shirtLabel);
        panel.add(pantLabel);
        panel.add(coatLabel);
        panel.add(kameezShalwaarLabel);
        panel.add(backButton);

    }

    public JPanel getPanel() {
        return panel;
    }

    public JLabel getCustomerLabel() {
        return customerLabel;
    }
    public JLabel getShirtLabel() {
        return shirtLabel;
    }

    public JLabel getPantLabel() {
        return pantLabel;
    }

    public JLabel getCoatLabel() {
        return coatLabel;
    }

    public JLabel getKameezShalwaarLabel() {
        return kameezShalwaarLabel;
    }

    public JButton getBackButton() {
        return backButton;
    }
}

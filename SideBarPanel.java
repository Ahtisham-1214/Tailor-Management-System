import javax.swing.*;
import java.awt.*;

public class SideBarPanel {
    private JPanel panel;
    private JLabel shirtLabel;
    private JLabel pantLabel;
    private JLabel coatLabel;
    private JLabel kameezShalwaarLabel;

    public SideBarPanel() {
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.DARK_GRAY);
        panel.setBounds(0, 0, 250, 800);

        shirtLabel = new JLabel("Shirt");
        pantLabel = new JLabel("Pant");
        coatLabel = new JLabel("Coat");
        kameezShalwaarLabel = new JLabel("Kameez Shalwaar");

        shirtLabel.setFont(new Font("Arial", Font.BOLD, 20));
        pantLabel.setFont(new Font("Arial", Font.BOLD, 20));
        coatLabel.setFont(new Font("Arial", Font.BOLD, 20));
        kameezShalwaarLabel.setFont(new Font("Arial", Font.BOLD, 20));

        shirtLabel.setForeground(Color.DARK_GRAY);
        pantLabel.setForeground(Color.DARK_GRAY);
        coatLabel.setForeground(Color.DARK_GRAY);
        kameezShalwaarLabel.setForeground(Color.DARK_GRAY);

        shirtLabel.setOpaque(true);
        pantLabel.setOpaque(true);
        coatLabel.setOpaque(true);
        kameezShalwaarLabel.setOpaque(true);

        shirtLabel.setBackground(Color.WHITE);
        pantLabel.setBackground(Color.WHITE);
        coatLabel.setBackground(Color.WHITE);
        kameezShalwaarLabel.setBackground(Color.WHITE);


        shirtLabel.setBounds(0, 200, 250, 40);
        pantLabel.setBounds(0, 250, 250, 40);
        coatLabel.setBounds(0, 300, 250, 40);
        kameezShalwaarLabel.setBounds(0, 350, 250, 40);


        panel.add(shirtLabel);
        panel.add(pantLabel);
        panel.add(coatLabel);
        panel.add(kameezShalwaarLabel);


    }

    public JPanel getPanel() {
        return panel;
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
}

import javax.swing.*;
import java.awt.*;

public class KameezShalwaarPanel {
    private JPanel panel;

    // Labels for thYe variablesY
    private JLabel kameezLengthLabel;
    private JLabel sleevesLabel;
    private JLabel sleevesTypeLabel;
    private JLabel kameezTypeLabel;
    private JLabel shoulderLabel;
    private JLabel neckLabel;
    private JLabel collarTypeLabel;
    private JLabel descriptionLabel;
    private JLabel statusLabel;
    private JLabel kameezShalwaarHeading;

    public KameezShalwaarPanel() {
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(20, 500, 1300, 150);
        panel.setBackground(new Color(169, 169, 169));

        kameezShalwaarHeading = new JLabel("Kameez Shalwaar");
        kameezShalwaarHeading.setFont(new Font("Arial Black", Font.BOLD, 30));



        kameezLengthLabel = new JLabel("Kameez Length");
        sleevesLabel = new JLabel("Sleeves");
        sleevesTypeLabel = new JLabel("Sleeves Type");
        kameezTypeLabel = new JLabel("Kameez Type");
        shoulderLabel = new JLabel("Shoulder");
        neckLabel = new JLabel("Neck");
        collarTypeLabel = new JLabel("Collar Type");
        statusLabel = new JLabel("Status");
        descriptionLabel = new JLabel("Description");



        kameezShalwaarHeading.setBounds(100, 10, 600, 30);
        kameezLengthLabel.setBounds(20, 60, 100, 30);
        sleevesLabel.setBounds(260, 60, 100, 30);
        sleevesTypeLabel.setBounds(20, 100, 230, 30);
        kameezTypeLabel.setBounds(260, 100, 230, 30);
        shoulderLabel.setBounds(20, 140, 230, 30);
        neckLabel.setBounds(260, 140, 230, 30);
        collarTypeLabel.setBounds(20, 180, 230, 30);
        statusLabel.setBounds(260, 180, 230, 30);
        descriptionLabel.setBounds(20, 200, 460, 30);

        
        
        
        
        
        panel.add(kameezShalwaarHeading);
        panel.add(kameezLengthLabel);
        panel.add(sleevesLabel);
        panel.add(sleevesTypeLabel);
        panel.add(kameezTypeLabel);
        panel.add(shoulderLabel);
        panel.add(neckLabel);
        panel.add(collarTypeLabel);
        panel.add(statusLabel);
        panel.add(descriptionLabel);
    }

    public JPanel getPanel() {
        return panel;
    }
}

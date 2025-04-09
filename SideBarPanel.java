import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SideBarPanel {
    private JPanel panel;
    private JLabel customerLabel;
    private JLabel shirtLabel;
    private JLabel pantLabel;
    private JLabel coatLabel;
    private JLabel kameezShalwaarLabel;
    private JButton backButton;
    private JButton confirmOrderButton;
    private JButton generateReceiptButton;

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
        confirmOrderButton = new JButton("Confirm Order");
        generateReceiptButton = new JButton("Generate Receipt");

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
        confirmOrderButton.setForeground(Color.DARK_GRAY);
        generateReceiptButton.setForeground(Color.DARK_GRAY);

        customerLabel.setOpaque(true);
        shirtLabel.setOpaque(true);
        pantLabel.setOpaque(true);
        coatLabel.setOpaque(true);
        kameezShalwaarLabel.setOpaque(true);
        backButton.setOpaque(true);
        confirmOrderButton.setOpaque(true);
        generateReceiptButton.setOpaque(true);

        customerLabel.setBackground(Color.WHITE);
        shirtLabel.setBackground(Color.WHITE);
        pantLabel.setBackground(Color.WHITE);
        coatLabel.setBackground(Color.WHITE);
        kameezShalwaarLabel.setBackground(Color.WHITE);
        backButton.setBackground(Color.WHITE);
        confirmOrderButton.setBackground(Color.WHITE);
        generateReceiptButton.setBackground(Color.WHITE);


        customerLabel.setBounds(0, 150, 250, 40);
        shirtLabel.setBounds(0, 200, 250, 40);
        pantLabel.setBounds(0, 250, 250, 40);
        coatLabel.setBounds(0, 300, 250, 40);
        kameezShalwaarLabel.setBounds(0, 350, 250, 40);
        confirmOrderButton.setBounds(0, 400, 200, 40);
        generateReceiptButton.setBounds(0, 450, 200, 40);
        backButton.setBounds(0, 20, 80, 40);


        panel.add(customerLabel);
        panel.add(shirtLabel);
        panel.add(pantLabel);
        panel.add(coatLabel);
        panel.add(kameezShalwaarLabel);
        panel.add(backButton);
        panel.add(confirmOrderButton);
        panel.add(generateReceiptButton);

        generateReceiptButton.addActionListener(e -> {

            System.out.println("Customer Name: " + Main.getOrders().getFirst().getName());
            System.out.println("---------------------------------------------------");
            System.out.println("Item\t\tQty\t\tPrice\t\tTotal");
            System.out.println("---------------------------------------------------");

            float pantTotal = pantPrice() * pantQuantity();
            float shirtTotal = shirtPrice() * shirtQuantity();
            float coatTotal = coatPrice() * coatQuantity();
            float kameezShalwaarTotal = kameezShalwarPrice() * kameezShalwaarQuantity();

            if (pantQuantity() != 0) {
                System.out.printf("Pant\t\t%d\t\t%.2f\t\t%.2f%n", pantQuantity(), pantPrice(), pantTotal);
            }
            if (shirtQuantity() != 0) {
                System.out.printf("Shirt\t\t%d\t\t%.2f\t\t%.2f%n", shirtQuantity(), shirtPrice(), shirtTotal);
            }
            if (coatQuantity() != 0) {
                System.out.printf("Coat\t\t%d\t\t%.2f\t\t%.2f%n", coatQuantity(), coatPrice(), coatTotal);
            }
            if (kameezShalwaarQuantity() != 0) {
                System.out.printf("Kameez Shalwaar\t%d\t\t%.2f\t\t%.2f%n", kameezShalwaarQuantity(), kameezShalwarPrice(), kameezShalwaarTotal);
            }

            System.out.println("---------------------------------------------------");
            System.out.printf("\t\t\t\t\t\t\t\t%.2f%n", pantTotal + shirtTotal + coatTotal + kameezShalwaarTotal);

            System.out.println("\n\n*************************************************");
            fetchTailorShopDetails();
        });

        getConfirmOrderButton().addActionListener(e -> {
            DatabaseHandler databaseHandler = new DatabaseHandler();
            if (!Main.getOrders().isEmpty()) {
                for (Customer customer : Main.getOrders()) {
                    databaseHandler.insertCustomer(customer);
                    if (!customer.getPants().isEmpty()) {
                        for (int i = 0; i < customer.getPants().size(); i++)
                            databaseHandler.insertPant(customer.getPants().get(i), customer.getPhoneNumber());

                    }

                    if (!customer.getShirts().isEmpty()) {
                        for (int i = 0; i < customer.getShirts().size(); i++)
                            databaseHandler.insertShirt(customer.getShirts().get(i), customer.getPhoneNumber());

                    }

                    if (!customer.getCoats().isEmpty()) {
                        for (int i = 0; i < customer.getCoats().size(); i++)
                            databaseHandler.insertCoat(customer.getCoats().get(i), customer.getPhoneNumber());

                    }

                    if (!customer.getKameezShalwaars().isEmpty()) {
                        for (int i = 0; i < customer.getKameezShalwaars().size(); i++)
                            databaseHandler.insertKameezShalwaar(customer.getKameezShalwaars().get(i), customer.getPhoneNumber());

                    }
                }
            }
        });


    }

    private float pantPrice() {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "Select pant_price from price where id = 1";
            assert connection != null;
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getFloat("pant_price");
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage() + "Failed to get Pant price");
        }
        return 0;
    }

    private float coatPrice() {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "Select coat_price from price where id = 1";
            assert connection != null;
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getFloat("coat_price");
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage() + "Failed to get Coat price");
        }
        return 0;
    }

    private float shirtPrice() {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "Select shirt_price from price where id = 1";
            assert connection != null;
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getFloat("shirt_price");
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage() + "Failed to get Shirt price");
        }
        return 0;
    }

    private float kameezShalwarPrice() {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "Select kameez_shalwaar_price from price where id = 1";
            assert connection != null;
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getFloat("kameez_shalwaar_price");
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage() + "Failed to get Kameez Shalwaar price");
        }
        return 0;
    }


    private int pantQuantity() {
        int quantity = 0;
        if (!Main.getOrders().getFirst().getPants().isEmpty()) {
            for (int i = 0; i < Main.getOrders().getFirst().getPants().size(); i++)
                quantity = Main.getOrders().getFirst().getPants().get(i).getQuantity();
        }
        return quantity;
    }

    private int shirtQuantity() {
        int quantity = 0;
        if (!Main.getOrders().getFirst().getShirts().isEmpty()) {
            for (int i = 0; i < Main.getOrders().getFirst().getShirts().size(); i++)
                quantity = Main.getOrders().getFirst().getShirts().get(i).getQuantity();
        }
        return quantity;
    }

    private int coatQuantity() {
        int quantity = 0;
        if (!Main.getOrders().getFirst().getCoats().isEmpty()) {
            for (int i = 0; i < Main.getOrders().getFirst().getCoats().size(); i++)
                quantity = Main.getOrders().getFirst().getCoats().get(i).getQuantity();
        }
        return quantity;
    }

    private int kameezShalwaarQuantity() {
        int quantity = 0;
        if (!Main.getOrders().getFirst().getKameezShalwaars().isEmpty()) {
            for (int i = 0; i < Main.getOrders().getFirst().getKameezShalwaars().size(); i++)
                quantity = Main.getOrders().getFirst().getKameezShalwaars().get(i).getQuantity();
        }
        return quantity;
    }

    private void fetchTailorShopDetails() {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "SELECT shop_name, address, phone_no, email FROM details WHERE id = 1";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String name = (resultSet.getString("shop_name"));
                String address = (resultSet.getString("address"));
                String phone = (resultSet.getString("phone_no"));
                String email = (resultSet.getString("email"));
                System.out.println(name);
                System.out.println(address);
                System.out.println(phone);
                System.out.println(email);
            } else {
                JOptionPane.showMessageDialog(null, "No data found in the database!", "Info", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error fetching data from the database.", "Error", JOptionPane.ERROR_MESSAGE);
        }
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

    public JButton getConfirmOrderButton() {
        return confirmOrderButton;
    }

    public JButton getGenerateReceiptButton() {
        return generateReceiptButton;
    }
}

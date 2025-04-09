import java.sql.*;

public class DatabaseHandler {
    public void insertCustomer(Customer customer) {
        String checkQuery = "SELECT COUNT(*) FROM customer WHERE phone = ?";
        String insertQuery = "INSERT INTO customer (name, phone) VALUES (?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
                PreparedStatement checkStatement = connection.prepareStatement(checkQuery);
                PreparedStatement insertStatement = connection.prepareStatement(insertQuery)) {

            // Check if the customer already exists
            checkStatement.setString(1, customer.getPhoneNumber());
            ResultSet resultSet = checkStatement.executeQuery();
            resultSet.next();
            int count = resultSet.getInt(1);

            if (count > 0) {
                System.out.println("Customer with phone number " + customer.getPhoneNumber() + " already exists.");
            } else {
                // Insert the customer if they don't exist
                insertStatement.setString(1, customer.getName());
                insertStatement.setString(2, customer.getPhoneNumber());
                int rowsInserted = insertStatement.executeUpdate();

                if (rowsInserted > 0) {
                    System.out.println("Customer inserted successfully.");
                } else {
                    System.out.println("Failed to insert customer.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertPant(Pant pant, String phoneNumber) {
        String query = "INSERT INTO pant (waist, length, inseam, " +
                "type, status, quantity, description, order_date, " +
                "delivery_date, phone) "
                +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            // Set the values for the prepared statement
            preparedStatement.setFloat(1, pant.getWaist());
            preparedStatement.setFloat(2, pant.getLength());
            preparedStatement.setFloat(3, pant.getInseam());
            preparedStatement.setByte(4, pant.getType());
            preparedStatement.setByte(5, pant.getStatus());
            preparedStatement.setInt(6, pant.getQuantity());
            preparedStatement.setString(7, pant.getDescription());
            preparedStatement.setDate(8, (Date) pant.getOrderDate());
            preparedStatement.setDate(9, (Date) pant.getDeliveryDate());
            preparedStatement.setString(10, phoneNumber);

            // Execute the query
            int rowsInserted = preparedStatement.executeUpdate();

            if (rowsInserted > 0) {
                System.out.println("Pant details inserted successfully for phone number: " + phoneNumber);
            } else {
                System.out.println("Failed to insert pant details for phone number: " + phoneNumber);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error inserting pant details for phone number: " + phoneNumber);
        }
    }

    public void insertShirt(Shirt shirt, String phoneNumber) {
        String query = "INSERT INTO shirt (chest, neck, shoulder," +
                " sleeves_length, shirt_length, cuff_type, status, quantity," +
                " description, order_date, delivery_date, phone) "
            +
            "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            // Set the values for the prepared statement
            preparedStatement.setFloat(1, shirt.getChest());
            preparedStatement.setFloat(2, shirt.getNeck());
            preparedStatement.setFloat(3, shirt.getShoulder());
            preparedStatement.setFloat(4, shirt.getSleeveLength());
            preparedStatement.setFloat(5, shirt.getShirtLength());
            preparedStatement.setByte(6, shirt.getCuffType());
            preparedStatement.setByte(7, shirt.getStatus());
            preparedStatement.setInt(8, shirt.getQuantity());
            preparedStatement.setString(9, shirt.getDescription());
            preparedStatement.setDate(10, (Date) shirt.getOrderDate());
            preparedStatement.setDate(11, (Date) shirt.getDeliveryDate());
            preparedStatement.setString(12, phoneNumber);

            // Execute the query
            int rowsInserted = preparedStatement.executeUpdate();

            if (rowsInserted > 0) {
                System.out.println("Shirt details inserted successfully for phone number: " + phoneNumber);
            } else {
                System.out.println("Failed to insert shirt details for phone number: " + phoneNumber);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error inserting shirt details for phone number: " + phoneNumber);
        }
    }
 
    public void insertCoat(Coat coat, String phoneNumber){
        String query = "Insert into coat (chest, waist, shoulder, sleeves," +
                "status, quantity, description, order_date, delivery_date, phone) "+
                "VALUES (?,?,?,?,?,?,?,?,?,?)";
        try (Connection connection = DatabaseConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query)){

            // Set the values for the prepared statement
            preparedStatement.setFloat(1, coat.getChest());
            preparedStatement.setFloat(2, coat.getWaist());
            preparedStatement.setFloat(3, coat.getShoulder());
            preparedStatement.setFloat(4, coat.getSleeves());
            preparedStatement.setByte(5, coat.getStatus());
            preparedStatement.setInt(6, coat.getQuantity());
            preparedStatement.setString(7, coat.getDescription());
            preparedStatement.setDate(8, (Date) coat.getOrderDate());
            preparedStatement.setDate(9, (Date) coat.getDeliveryDate());
            preparedStatement.setString(10, phoneNumber);

            // Execute the query
            int rowsInserted = preparedStatement.executeUpdate();

            if (rowsInserted > 0) {
                System.out.println("Coat details inserted successfully for phone number: " + phoneNumber);
            } else {
                System.out.println("Failed to insert coat details for phone number: " + phoneNumber);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error inserting coat details for phone number: " + phoneNumber);
        }
    }

    public void insertKameezShalwaar(KameezShalwaar kameezShalwaar, String phoneNumber){
        String query = "INSERT INTO kameez_shalwaar (kameez_length, sleeves_length, shoulder, neck, collar_type, cuff_type, " +
            "kameez_type, trouser_length, trouser_width, trouser_type, status, quantity, description, order_date, " +
            "delivery_date, phone) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            // Set the values for the prepared statement
            preparedStatement.setFloat(1, kameezShalwaar.getKameezLength());
            preparedStatement.setFloat(2, kameezShalwaar.getSleeves());
            preparedStatement.setFloat(3, kameezShalwaar.getShoulder());
            preparedStatement.setFloat(4, kameezShalwaar.getNeck());
            preparedStatement.setByte(5, kameezShalwaar.getCollarType());
            preparedStatement.setByte(6, kameezShalwaar.getCuffType());
            preparedStatement.setByte(7, kameezShalwaar.getKameezType());
            preparedStatement.setFloat(8, kameezShalwaar.getTrouserLength());
            preparedStatement.setFloat(9, kameezShalwaar.getTrouserAnkle());
            preparedStatement.setByte(10, kameezShalwaar.getTrouserType());
            preparedStatement.setByte(11, kameezShalwaar.getStatus());
            preparedStatement.setInt(12, kameezShalwaar.getQuantity());
            preparedStatement.setString(13, kameezShalwaar.getDescription());
            preparedStatement.setDate(14, (Date) kameezShalwaar.getOrderDate());
            preparedStatement.setDate(15, (Date) kameezShalwaar.getDeliveryDate());
            preparedStatement.setString(16, phoneNumber);

            // Execute the query
            int rowsInserted = preparedStatement.executeUpdate();

            if (rowsInserted > 0) {
            System.out.println("Kameez Shalwaar details inserted successfully for phone number: " + phoneNumber);
            } else {
            System.out.println("Failed to insert Kameez Shalwaar details for phone number: " + phoneNumber);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error inserting Kameez Shalwaar details for phone number: " + phoneNumber);
        }
    }
}

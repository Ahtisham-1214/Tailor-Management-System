import java.util.LinkedList;

public class Order {
    private static LinkedList<Customer> orders;

    public Order() {
        orders = new LinkedList<>();
    }

    public void addCustomer(Customer c) {
        orders.clear();
        orders.add(c);
    }

    public void showCustomer() {
        if (getOrders().isEmpty()) {
            System.out.println("No customers found.");
            return;
        }
        // Display the first customer's information
        Customer c = orders.getFirst();
        System.out.println(c.getName() + "\t" + c.getPhoneNumber());

        // If the customer has pants, show their details
        if (!c.getPants().isEmpty()) {
            c.getPants().getFirst().getPantDetail(); // Get the first pant's details
        } else {
            System.out.println("No pants found for this customer.");
        }
        
    }

    public static LinkedList<Customer> getOrders() {
        return orders;
    }


    public Customer getCustomer() {
        return getOrders().getFirst();
    }

    // Method to add a Pant object to a customer
    public void addPantToCustomer(Pant pant) {
        Customer customer = getCustomer();
        if (customer != null) {
            customer.addPant(pant);
            System.out.println("Pant added to customer: " + customer.getName());
            // Debugging output to confirm pants have been added
            System.out.println("Number of pants in customer list: " + customer.getPants().size());
        } else {
            System.out.println("Customer not found. Please add a customer first.");
        }
    }
}

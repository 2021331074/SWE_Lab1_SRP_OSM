import java.util.ArrayList;
import java.util.List;

// Program Breakdown
// Step 1: Product Creation
class Product {
    private String name;
    private double price;
    private String description;

    public Product(String name, double price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }
}


// Step 2: Customer Creation
class Customer {
    private String name;
    private String email;
    // After Creating Cart Class
    private Cart cart;

    public Customer(String name, String email) {
        this.name = name;
        this.email = email;

        this.cart = new Cart();
    }

    public void addToCart(Product product) {
        // Method used from Cart Class
        cart.addProduct(product);
    }

    public void removeFromCart(Product product) {
        // Method used from Cart Class
        cart.removeProduct(product);
    }

    public void checkout() {    // initially blank
        // After Creating Order Class
        Order order = new Order(cart);
        order.generateOrderSummary(name);
    }
}


// Step 3: Adding Products to the Cart
class Cart {
    private List<Product> products;

    public Cart() {
        products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(Product product) {
        products.remove(product);
    }

    public List<Product> getProducts() {
        return products;
    }

    public double getTotalPrice() {
        double total = 0;
        for (Product product : products) {
            total += product.getPrice();
        }
        return total;
    }
}


// Step 4: Checkout and Order Summary
class Order {
    private Cart cart;

    public Order(Cart cart) {
        this.cart = cart;
    }

    public void generateOrderSummary(String customerName) {
        System.out.println("Order Summary:");
        System.out.println("-----------------------------------------");
        int index = 1;
        for (Product product : cart.getProducts()) {
            System.out.println("Product " + index++ + ": " + product.getName());
            System.out.println(" - Price: TK " + product.getPrice());
            System.out.println(" - Description: " + product.getDescription());
        }
        System.out.println("-----------------------------------------");
        System.out.println("Total Amount: TK " + cart.getTotalPrice());
        System.out.println("-----------------------------------------");
        System.out.println("Thank you for shopping with us, " + customerName + "!");
        System.out.println("Your order has been processed successfully!");
    }
}



public class OnlineShoppingManagement {
    public static void main(String[] args) {
        // Step 1: Create Products
        Product laptop = new Product("Laptop", 1000.0, "High performance laptop");
        Product headphones = new Product("Headphones", 150.0, "Noise-cancelling headphones");

        // Step 2: Create a Customer
        Customer customer = new Customer("Iron Man", "ironMan@gmail.com");

        // Step 3: Add products to the customer’s cart
        customer.addToCart(laptop);
        customer.addToCart(headphones);

        // Step 4: Process the checkout and display the order summary
        customer.checkout();
    }
}

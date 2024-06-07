import com.model.Product;
import com.model.User;
import com.service.AuthenticationService;
import com.service.Order;
import com.util.ProductFileReader;
import com.view.ShoppingCart;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        Scanner scanner = new Scanner(System.in);
        ArrayList<Product> products = ProductFileReader.readProductsFromFile("src/product.txt");//static method need not to create objects

        ShoppingCart cart = new ShoppingCart(products);
        //User user = new User("Rahat","R123");
        AuthenticationService authenticationService = new AuthenticationService();
        authenticationService.register("Rahat","R123");
        authenticationService.register("Alamin","A123");
        boolean authentication = authenticationService.login("Alamin","A123");
        System.out.println("User login"+" "+authentication);
        authenticationService.viewUser();

        while (true) {
            System.out.println("1. View Products");
            System.out.println("2. Add Product to Cart");
            System.out.println("3. View Cart");
            System.out.println("4. Remove Product from Cart");
            System.out.println("5. Checkout");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    for (Product product : products) {
                        System.out.println(product);
                    }
                    break;
                case 2:
                    System.out.print("Enter product ID to add to cart: ");
                    String productId = scanner.nextLine();
                    for (Product product : products) {
                        if (product.getId().equals(productId)) {
                            cart.addProduct(product);
                            break;
                        }
                    }
                    break;
                case 3:
                    cart.viewCart();
                    break;
                case 4:
                    System.out.print("Enter product ID to remove from cart: ");
                    String removeId = scanner.nextLine();
                    cart.removeProduct(removeId);
                    break;
                case 5:
                    System.out.print("Enter your name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter your address: ");
                    String address = scanner.nextLine();
                    Order order = new Order(cart, name, address);
                    order.placeOrder();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option, please try again.");
            }
        }
    }
    }
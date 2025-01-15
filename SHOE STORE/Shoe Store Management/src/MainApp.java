import java.util.*;

public class MainApp {
    private static List<User> users;
    private static List<Shoe> shoes;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        users = DataHandler.loadUsers();
        shoes = DataHandler.loadShoes();
        showMainMenu();
    }

    private static void showMainMenu() {
        while (true) {
            System.out.println("\n==== Shoe Store Management ====");
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("3. Exit");
            System.out.print("Select an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> login();
                case 2 -> register();
                case 3 -> {
                    System.out.println("Exiting... Thank you!");
                    DataHandler.saveUsers(users);
                    DataHandler.saveShoes(shoes);
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    private static void login() {
        System.out.print("Enter Username: ");
        String username = scanner.nextLine();
        System.out.print("Enter Password: ");
        String password = scanner.nextLine();

        boolean found = users.stream()
                .anyMatch(user -> user.getUsername().equals(username) && user.getPassword().equals(password));

        if (found) {
            System.out.println("Login successful!");
            showDashboard();
        } else {
            System.out.println("Invalid credentials!");
        }
    }

    private static void register() {
        System.out.print("Enter New Username: ");
        String username = scanner.nextLine();
        System.out.print("Enter New Password: ");
        String password = scanner.nextLine();

        users.add(new User(username, password));
        System.out.println("Registration successful!");
    }

    private static void showDashboard() {
        while (true) {
            System.out.println("\n==== Dashboard ====");
            System.out.println("1. View Shoes");
            System.out.println("2. Add Shoe");
            System.out.println("3. Logout");
            System.out.print("Select an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> viewShoes();
                case 2 -> addShoe();
                case 3 -> {
                    System.out.println("Logging out...");
                    return;
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    private static void viewShoes() {
        if (shoes.isEmpty()) {
            System.out.println("No shoes available.");
        } else {
            System.out.println("\nAvailable Shoes:");
            shoes.forEach(shoe -> System.out.println(shoe.getDetails()));
        }
    }

    private static void addShoe() {
        System.out.print("Enter Brand: ");
        String brand = scanner.nextLine();
        System.out.print("Enter Model: ");
        String model = scanner.nextLine();
        System.out.print("Enter Size: ");
        int size = scanner.nextInt();
        System.out.print("Enter Price: ");
        double price = scanner.nextDouble();
        scanner.nextLine();

        shoes.add(new Shoe(brand, model, size, price));
        System.out.println("Shoe added successfully!");
    }
}

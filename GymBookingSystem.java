import java.util.Scanner;

public class GymBookingSystem {
    private static BookingManager BookingManager = new BookingManager();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter admin password: ");
        String password = scanner.nextLine();

        if (authenticateAdmin(password)) {
            while (true) {
                System.out.println("1. Create Booking");
                System.out.println("2. Display Bookings");
                System.out.println("3. Exit");
                System.out.print("Choose an option: ");
                int option = scanner.nextInt();
                scanner.nextLine();  // Consume newline

                if (option == 1) {
                    createBooking(scanner);
                } else if (option == 2) {
                    BookingManager.displayBookings();
                } else if (option == 3) {
                    break;
                } else {
                    System.out.println("Invalid option. Try again.");
                }
            }
        } else {
            System.out.println("Authentication failed.");
        }
    }

    private static boolean authenticateAdmin(String password) {
        return "admin123".equals(password);  // Replace with your actual password
    }

    private static void createBooking(Scanner scanner) {
        System.out.print("Enter Customer ID: ");
        String customerId = scanner.nextLine();
        System.out.print("Enter Customer Name: ");
        String customerName = scanner.nextLine();
        System.out.print("Enter Time (e.g., 2-4pm): ");
        String time = scanner.nextLine();
        System.out.print("Enter Amount: ");
        double amount = scanner.nextDouble();
        System.out.print("Is Member Discount Applied? (yes/no): ");
        boolean isMemberDiscountApplied = scanner.next().equalsIgnoreCase("yes");
        System.out.print("Is Payment Successful? (yes/no): ");
        boolean isPaymentSuccessful = scanner.next().equalsIgnoreCase("yes");
        scanner.nextLine();  // Consume newline

        BookingManager.createBooking(customerId, customerName, time, amount, isMemberDiscountApplied, isPaymentSuccessful);
        System.out.println("Booking created successfully.");
    }
}

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BookingManager {
    private List<Booking> bookings;
    private static final String FILE_NAME = "bookings.txt";

    public BookingManager() {
        bookings = loadBookings();
    }

    public void createBooking(String customerId, String customerName, String time, double amount, boolean isMemberDiscountApplied, boolean isPaymentSuccessful) {
        Booking booking = new Booking(customerId, customerName, time, amount, isMemberDiscountApplied, isPaymentSuccessful);
        bookings.add(booking);
        saveBookings();
    }

    public void displayBookings() {
        for (Booking booking : bookings) {
            System.out.println(booking);
        }
    }

    private void saveBookings() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(bookings);
        } catch (IOException e) {
            System.out.println("Error saving bookings: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    private List<Booking> loadBookings() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            return (List<Booking>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return new ArrayList<>();
        }
    }
}

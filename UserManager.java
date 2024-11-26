// UserManager.java
import java.io.*;
import java.util.HashMap;

public class UserManager {
    private HashMap<String, User> users;
    private static final String USER_FILE = "users.txt";

    public UserManager() {
        users = new HashMap<>();
        loadUsers();
    }

    public void registerMember(String name, String username, String password) {
        if (!users.containsKey(username)) {
            Member member = new Member(name, username, password);
            users.put(username, member);
            saveUsers();
            System.out.println("Member registered successfully.");
        } else {
            System.out.println("Username already exists.");
        }
    }

    public User login(String username, String password) {
        User user = users.get(username);
        if (user != null && user.getPassword().equals(password)) {
            System.out.println("Login successful.");
            return user;
        } else {
            System.out.println("Invalid credentials.");
            return null;
        }
    }

    private void saveUsers() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(USER_FILE))) {
            for (User user : users.values()) {
                if (user instanceof Member) {
                    Member member = (Member) user;
                    writer.println(user.getName() + "," + user.getUsername() + "," + user.getPassword() + "," + member.hasMembership());
                }
            }
        } catch (IOException e) {
            System.out.println("Error saving users: " + e.getMessage());
        }
    }

    private void loadUsers() {
        try (BufferedReader reader = new BufferedReader(new FileReader(USER_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    String name = parts[0];
                    String username = parts[1];
                    String password = parts[2];
                    boolean hasMembership = Boolean.parseBoolean(parts[3]);
                    Member member = new Member(name, username, password);
                    if (hasMembership) {
                        member.activateMembership();
                    }
                    users.put(username, member);
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading users: " + e.getMessage());

        }
    }
}

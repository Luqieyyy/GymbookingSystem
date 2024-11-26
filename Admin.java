public class Admin {
    private static final String ADMIN_ID = "admin";
    private static final String PASSWORD = "password";

    public static boolean login(String id, String password) {
        return ADMIN_ID.equals(id) && PASSWORD.equals(password);
    }
}

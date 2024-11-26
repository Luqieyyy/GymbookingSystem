import java.io.Serializable;

public class User implements Serializable {
    private String name;
    private String idNumber;
    private String phone;

    public User(String name, String idNumber, String phone) {
        this.name = name;
        this.idNumber = idNumber;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public String toString() {
        return name + "," + idNumber + "," + phone;
    }
}

package pengliu.me.jdbctemplate;

/**
 * Created by peng on 8/5/15.
 */
public class Contact
{
    private String name;
    private String email;
    private String address;
    private String phone;

    // getters and setters are removed for brevity.

    public String toString() {
        return String.format("[%s - %s - %s - %s]", getName(), getEmail(), getAddress(), getPhone());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}

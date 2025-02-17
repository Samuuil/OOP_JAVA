public class Guest implements User {
    @Override
    public String getRole() {
        return "Guest";
    }

    @Override
    public String toString() {
        return "User Role: Guest";
    }
}

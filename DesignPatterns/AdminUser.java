public class AdminUser implements User {
    @Override
    public String getRole() {
        return "Admin";
    }

    @Override
    public String toString() {
        return "User Role: Admin";
    }
}

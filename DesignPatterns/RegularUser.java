public class RegularUser implements User {
    @Override
    public String getRole() {
        return "Regular User";
    }

    @Override
    public String toString() {
        return "User Role: Regular User";
    }
}

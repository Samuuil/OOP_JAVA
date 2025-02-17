public class UserFactory {
    public static User createUser(String type) {
        switch (type.toLowerCase()) {
            case "admin":
                return new AdminUser();
            case "regular":
                return new RegularUser();
            case "guest":
                return new Guest();
            default:
                throw new IllegalArgumentException("Invalid user type: " + type);
        }
    }
}

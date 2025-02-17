public class Main {
    public static void main(String[] args) {
        Order order1 = new Order.Builder()
                .setMainDish("Pizza Margherita")
                .setDrink("Coke")
                .setDessert("Tiramisu")
                .build();

        Order order2 = new Order.Builder()
                .setMainDish("Pasta Carbonara")
                .setDrink("Mineral Water")
                .build();

        System.out.println(order1);
        System.out.println(order2);
    }
}

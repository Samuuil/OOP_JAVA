class Order {
    private String mainDish;
    private String drink;
    private String dessert;
    private String notes;

    private Order(Builder builder) {
        this.mainDish = builder.mainDish;
        this.drink = builder.drink;
        this.dessert = builder.dessert;
        this.notes = builder.notes;
    }

    @Override
    public String toString() {
        return "Order: " + mainDish + ", " + (drink != null ? drink : "No Drink") +
                (dessert != null ? ", " + dessert : "") +
                (notes != null ? " (Notes: " + notes + ")" : "");
    }

    public static class Builder {
        private String mainDish;
        private String drink;
        private String dessert;
        private String notes;

        public Builder setMainDish(String mainDish) {
            this.mainDish = mainDish;
            return this;
        }

        public Builder setDrink(String drink) {
            this.drink = drink;
            return this;
        }

        public Builder setDessert(String dessert) {
            this.dessert = dessert;
            return this;
        }

        public Builder setNotes(String notes) {
            this.notes = notes;
            return this;
        }

        public Order build() {
            return new Order(this);
        }
    }
}
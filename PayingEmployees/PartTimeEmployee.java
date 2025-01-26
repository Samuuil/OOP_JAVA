class PartTimeEmployee extends Employee {
    private double hourlyRate;
    private int hoursPerMonth;

    public PartTimeEmployee(String name, int id, double hourlyRate, int hoursPerMonth) {
        super(name, id);
        this.hourlyRate = hourlyRate;
        this.hoursPerMonth = hoursPerMonth;
    }

    @Override
    public double calculateMonthlyPay() {
        return hourlyRate * hoursPerMonth;
    }

    @Override
    public String getRole() {
        return "PartTime";
    }
}
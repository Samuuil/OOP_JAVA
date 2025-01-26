abstract class Employee {
    protected String name;
    protected int id;

    public Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public abstract double calculateMonthlyPay();

    public abstract String getRole();

    @Override
    public String toString() {
        return String.format("ID:%d, Name:%s, MonthlySalary:%.2f", id, name, calculateMonthlyPay());
    }
}
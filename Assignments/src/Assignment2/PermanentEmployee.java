package Assignment2;

class PermanentEmployee extends Employee implements Payable {
    private double bonus;

    public PermanentEmployee(String empId, String name, double basicSalary, double bonus) {
        super(empId, name, basicSalary);
        this.bonus = bonus;
    }

    public double getBonus() { return bonus; }

    @Override
    double calculateTax() {
        return 0.10 * (basicSalary + bonus);
    }

    @Override
    public double calculateNetSalary() {
        return (basicSalary + bonus) - calculateTax();
    }

    @Override
    public void generatePayslip() {
        System.out.println("\n===== Payslip (Permanent Employee) =====");
        System.out.println("ID: " + getEmpId());
        System.out.println("Name: " + getName());
        System.out.println("Basic Salary: " + basicSalary);
        System.out.println("Bonus: " + bonus);
        System.out.println("Tax: " + calculateTax());
        System.out.println("Net Salary: " + calculateNetSalary());
        System.out.println("========================================");
    }
}

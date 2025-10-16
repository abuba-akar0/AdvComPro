package Assignment2;

class ContractEmployee extends Employee implements Payable {
    private int contractDuration; // in months

    public ContractEmployee(String empId, String name, double basicSalary, int contractDuration) {
        super(empId, name, basicSalary);
        this.contractDuration = contractDuration;
    }

    public int getContractDuration() { return contractDuration; }

    @Override
    double calculateTax() {
        return 0.05 * basicSalary;
    }

    @Override
    public double calculateNetSalary() {
        return basicSalary - calculateTax();
    }

    @Override
    public void generatePayslip() {
        System.out.println("\n===== Payslip (Contract Employee) =====");
        System.out.println("ID: " + getEmpId());
        System.out.println("Name: " + getName());
        System.out.println("Basic Salary: " + basicSalary);
        System.out.println("Contract Duration: " + contractDuration + " months");
        System.out.println("Tax: " + calculateTax());
        System.out.println("Net Salary: " + calculateNetSalary());
        System.out.println("=======================================");
    }
}

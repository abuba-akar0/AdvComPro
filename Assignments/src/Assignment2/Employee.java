package Assignment2;

abstract class Employee {
    private String empId;
    private String name;
    protected double basicSalary; // protected so subclasses can access

    public Employee(String empId, String name, double basicSalary) {
        this.empId = empId;
        this.name = name;
        this.basicSalary = basicSalary;
    }

    // Getters and Setters
    public String getEmpId() { return empId; }
    public String getName() { return name; }
    public double getBasicSalary() { return basicSalary; }

    public void setBasicSalary(double basicSalary) {
        if (basicSalary > 0)
            this.basicSalary = basicSalary;
    }

    // Abstract method for tax
    abstract double calculateTax();
}

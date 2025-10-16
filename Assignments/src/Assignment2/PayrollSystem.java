package Assignment2;

import java.util.*;

public class PayrollSystem {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Payable> employees = new ArrayList<>();

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n=== Employee Payroll Management System ===");
            System.out.println("1. Add Employee");
            System.out.println("2. View All Employees");
            System.out.println("3. Search Employee");
            System.out.println("4. Highest Net Salary");
            System.out.println("5. Average Salary");
            System.out.println("6. Generate Payslip");
            System.out.println("7. Exit");
            System.out.print("Choose option: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> addEmployee();
                case 2 -> viewAll();
                case 3 -> searchEmployee();
                case 4 -> highestSalary();
                case 5 -> averageSalary();
                case 6 -> generatePayslip();
                case 7 -> System.out.println("Exiting... Goodbye!");
                default -> System.out.println("Invalid option! Try again.");
            }
        } while (choice != 7);
    }

    static void addEmployee() {
        if (employees.size() >= 5) {
            System.out.println("Max limit reached (5 employees)!");
            return;
        }

        int typeChoice = 0;
        do {
            System.out.println("Select Employee Type:");
            System.out.println("1. Permanent Employee");
            System.out.println("2. Contract Employee");
            System.out.print("Enter choice (1 or 2): ");
            if (sc.hasNextInt()) {
                typeChoice = sc.nextInt();
                sc.nextLine(); // consume newline
            } else {
                sc.nextLine(); // consume invalid input
                typeChoice = 0;
            }
        } while (typeChoice != 1 && typeChoice != 2);

        System.out.print("Enter ID: ");
        String id = sc.nextLine();
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Basic Salary: ");
        double salary = sc.nextDouble();

        if (typeChoice == 1) {
            System.out.print("Enter Bonus: ");
            double bonus = sc.nextDouble();
            employees.add(new PermanentEmployee(id, name, salary, bonus));
        } else {
            System.out.print("Enter Contract Duration (months): ");
            int duration = sc.nextInt();
            employees.add(new ContractEmployee(id, name, salary, duration));
        }

        System.out.println("Employee added successfully!");
    }

    static void viewAll() {
        if (employees.isEmpty()) {
            System.out.println("No employees found!");
            return;
        }

        System.out.println("\n--------------------------------------------------------------------------------------");
        System.out.printf("%-10s %-15s %-12s %-12s %-12s %-12s %-12s\n", "ID", "Name", "Type", "Basic", "Bonus/Dur", "Tax", "Net Salary");
        System.out.println("--------------------------------------------------------------------------------------");
        for (Payable p : employees) {
            if (p instanceof PermanentEmployee e)
                System.out.printf("%-10s %-15s %-12s %-12.2f %-12.2f %-12.2f %-12.2f\n",
                        e.getEmpId(), e.getName(), "Permanent", e.getBasicSalary(), e.getBonus(), e.calculateTax(), e.calculateNetSalary());
            else if (p instanceof ContractEmployee e)
                System.out.printf("%-10s %-15s %-12s %-12.2f %-12d %-12.2f %-12.2f\n",
                        e.getEmpId(), e.getName(), "Contract", e.getBasicSalary(), e.getContractDuration(), e.calculateTax(), e.calculateNetSalary());
        }
        System.out.println("--------------------------------------------------------------------------------------");
    }

    static void searchEmployee() {
        System.out.print("Enter Employee ID: ");
        String id = sc.nextLine();

        for (Payable p : employees) {
            Employee e = (Employee) p;
            if (e.getEmpId().equalsIgnoreCase(id)) {
                p.generatePayslip();
                return;
            }
        }
        System.out.println("Employee ID not found!");
    }

    static void highestSalary() {
        if (employees.isEmpty()) {
            System.out.println("No employees found!");
            return;
        }

        Payable max = employees.get(0);
        for (Payable p : employees)
            if (p.calculateNetSalary() > max.calculateNetSalary())
                max = p;

        System.out.println("Employee with Highest Net Salary:");
        max.generatePayslip();
    }

    static void averageSalary() {
        if (employees.isEmpty()) {
            System.out.println("No employees found!");
            return;
        }

        double total = 0;
        for (Payable p : employees)
            total += p.calculateNetSalary();

        System.out.println("Average Net Salary: " + (total / employees.size()));
    }

    static void generatePayslip() {
        System.out.print("Enter Employee ID: ");
        String id = sc.nextLine();

        for (Payable p : employees) {
            Employee e = (Employee) p;
            if (e.getEmpId().equalsIgnoreCase(id)) {
                p.generatePayslip();
                return;
            }
        }
        System.out.println("Employee ID not found!");
    }
}

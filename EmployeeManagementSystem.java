import java.util.Scanner;

public class EmployeeManagementSystem {

    static Scanner scanner = new Scanner(System.in);
    static Employee[] employees = new Employee[10]; 

    public static void main(String[] args) {
        System.out.println("Welcome to Employee Management System!");

        while (true) {
            System.out.println("1. Add Employee");
            System.out.println("2. View Employees");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addEmployee();
                    break;
                case 2:
                    viewEmployees();
                    break;
                case 3:
                    System.out.println("Exiting Employee Management System. Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    static void addEmployee() {
        System.out.print("Enter employee name: ");
        String name = scanner.next();
        System.out.print("Enter employee id: ");
        int id = scanner.nextInt();
        System.out.print("Enter employee salary: ");
        double salary = scanner.nextDouble();
        System.out.print("Enter performance evaluation (out of 10): ");
        int performance = scanner.nextInt();
        System.out.print("Enter attendance percentage: ");
        double attendance = scanner.nextDouble();

        Employee employee = new Employee(id, name, salary, performance, attendance);

        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                employees[i] = employee;
                System.out.println("Employee added successfully!");
                return;
            }
        }

        System.out.println("Employee database is full. Cannot add more employees.");
    }

    static void viewEmployees() {
        System.out.println("Employee List:");
        System.out.printf("%-5s %-15s %-10s %-15s %-10s%n", "ID", "Name", "Salary", "Performance", "Attendance");
        System.out.println("---------------------------------------------------");

        // Sort employees by ID before displaying
        sortEmployeesById();

        for (Employee employee : employees) {
            if (employee != null) {
                System.out.printf("%-5d %-15s %-10.2f %-15d %-10.2f%n",
                        employee.getId(), employee.getName(), employee.getSalary(),
                        employee.getPerformance(), employee.getAttendance());
            }
        }
    }

    static void sortEmployeesById() {
        for (int i = 0; i < employees.length - 1; i++) {
            for (int j = 0; j < employees.length - i - 1; j++) {
                if (employees[j] != null && employees[j + 1] != null &&
                        employees[j].getId() > employees[j + 1].getId()) {
                    Employee temp = employees[j];
                    employees[j] = employees[j + 1];
                    employees[j + 1] = temp;
                }
            }
        }
    }
}

class Employee {
    private int id;
    private String name;
    private double salary;
    private int performance;
    private double attendance;

    public Employee(int id, String name, double salary, int performance, double attendance) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.performance = performance;
        this.attendance = attendance;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public int getPerformance() {
        return performance;
    }

    public double getAttendance() {
        return attendance;
    }
}

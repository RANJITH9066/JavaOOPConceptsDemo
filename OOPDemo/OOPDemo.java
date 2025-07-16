import java.util.*;

// Abstract class (Abstraction)
abstract class Person {
    private String name; // Encapsulation
    private int age;

    public Person(String name, int age) {
        this.name = name; this.age = age;
    }

    public String getName() { return name; }
    public int getAge() { return age; }

    public abstract void displayRole(); // Abstraction
}

// Interface
interface Payable {
    void calculatePay();
}

// Inheritance + Method Overriding
class Employee extends Person implements Payable {
    private double salary;

    public Employee(String name, int age, double salary) {
        super(name, age); this.salary = salary;
    }

    @Override
    public void displayRole() {
        System.out.println(getName() + " is an Employee.");
    }

    @Override
    public void calculatePay() {
        System.out.println("Monthly Pay: ₹" + salary);
    }

    // Method Overloading (Polymorphism)
    public void calculatePay(int bonus) {
        System.out.println("Pay with Bonus: ₹" + (salary + bonus));
    }
}

// Another child class
class Manager extends Employee {
    private int teamSize;

    public Manager(String name, int age, double salary, int teamSize) {
        super(name, age, salary); this.teamSize = teamSize;
    }

    @Override
    public void displayRole() {
        System.out.println(getName() + " is a Manager of " + teamSize + " people.");
    }
}

// Main class
public class OOPDemo {
    public static void main(String[] args) {
        List<Person> staff = new ArrayList<>(); // Collection

        staff.add(new Employee("Ranjith", 25, 35000));
        staff.add(new Manager("Varalakshmi", 48, 50000, 5));

        for (Person p : staff) {
            p.displayRole();

            if (p instanceof Employee emp) {
                emp.calculatePay();     // Overridden method
                emp.calculatePay(5000); // Overloaded method
            }
        }

        // Exception Handling
        try {
            Person p = staff.get(5); // Index out of bounds
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
    }
}
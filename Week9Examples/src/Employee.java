import java.util.Comparator;
import java.util.Date;

public class Employee {
    private String fullName;
    private String socialInsuranceNumber;
    private Date hireDate;

    // Constructor
    public Employee(String fullName, String socialInsuranceNumber, Date hireDate) {
        this.fullName = fullName;
        this.socialInsuranceNumber = socialInsuranceNumber;
        this.hireDate = hireDate;
    }

    // Getter and Setter for fullName
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    // Getter and Setter for socialInsuranceNumber
    public String getSocialInsuranceNumber() {
        return socialInsuranceNumber;
    }

    public void setSocialInsuranceNumber(String socialInsuranceNumber) {
        this.socialInsuranceNumber = socialInsuranceNumber;
    }

    // Getter and Setter for hireDate
    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    // Override the toString method
    @Override
    public String toString() {
        return "Employee{" +
                "fullName='" + fullName + '\'' +
                ", socialInsuranceNumber='" + socialInsuranceNumber + '\'' +
                ", hireDate=" + hireDate +
                '}';
    }

    // Main method for testing
    public static void main(String[] args) {
        // Create a new employee instance
        Employee emp = new Employee("John Doe", "123-45-6789", new Date());

        // Display the employee details using toString method
        System.out.println(emp.toString());
    }
}

class HireDateComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, Employee o2) {
        if (o1.getHireDate().before(o2.getHireDate())) {
            return -1;
        } else if (o1.getHireDate().after(o2.getHireDate())) {
            return 1;
        } else {
            return 0;
        }
    }
}

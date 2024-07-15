import java.util.Date;

public class Employee {
    private String fullName;
    private String socialInsuranceNumber;
    private Date date;

    // Constructor
    public Employee(String fullName, String socialInsuranceNumber, Date date) {
        this.fullName = fullName;
        this.socialInsuranceNumber = socialInsuranceNumber;
        this.date = date;
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

    // Getter and Setter for date
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    // Override the toString method
    @Override
    public String toString() {
        return "Employee{" +
                "fullName='" + fullName + '\'' +
                ", socialInsuranceNumber='" + socialInsuranceNumber + '\'' +
                ", date=" + date +
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

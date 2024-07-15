import java.util.Comparator;
import java.util.Date;

class Employee {
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
}

class HireDateComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, Employee o2) {
        return o1.getHireDate().compareTo(o2.getHireDate());
    }
}

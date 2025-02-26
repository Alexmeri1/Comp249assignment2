import Deductions.TaxCalculator;

public class Employee {

    protected long employeNumber;
    protected String firstName;
    protected String lastName;
    protected double hoursWorked;
    protected double wage;
    protected double grossIncome;

    public Employee() {
        this(0L, "NoFirstName", "NoLastName", 0.0, 0.0, 0.0);
    }

    public Employee(Employee o) {
        this(o.employeNumber, o.firstName, o.lastName, o.hoursWorked, o.wage, o.grossIncome);
    }

    public Employee(long number, String firstName, String lastName, double hoursWorked, double wage, double grossIncome) throws MinimumWageException {
        this.employeNumber = number;
        this.firstName = firstName;
        this.lastName = lastName;
        this.hoursWorked = hoursWorked;
        if (wage < 15.75) {
            throw new MinimumWageException();
        }
        this.wage = wage;
        this.grossIncome = grossIncome;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(double hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public double getWage() {
        return wage;
    }

    public void setWage(double wage) {
        this.wage = wage;
    }

    public double getGrossIncome() {
        return grossIncome;
    }

    public void setGrossIncome(double grossIncome) {
        this.grossIncome = grossIncome;
    }

    public long getEmployeNumber() {
        return employeNumber;
    }

    public void setEmployeNumber(long employeNumber) {
        this.employeNumber = employeNumber;
    }

    public double getEmployeeTotalDeduction() {
        TaxCalculator t = new TaxCalculator();
        return t.getTotalDeduction(this.grossIncome);
    }

    public double getEmployeeNetSalary() {
        return this.grossIncome - this.getEmployeeTotalDeduction();
    }

}

import Deductions.TaxCalculator;

import java.io.IOException;

public class Employee {

    protected long employeNumber;
    protected String firstName;
    protected String lastName;
    protected double hoursWorked;
    protected double wage;


    public Employee() throws MinimumWageException,IllegalArgumentException{
        this(0L, "NoFirstName", "NoLastName", 0.0, 0.0);
    }

    public Employee(Employee o) throws MinimumWageException,IllegalArgumentException{
        this(o.employeNumber, o.firstName, o.lastName, o.hoursWorked, o.wage);
    }

    public Employee(long number, String firstName, String lastName, double hoursWorked, double wage) throws MinimumWageException,IllegalArgumentException {
        if (wage < 15.75) {
            throw new MinimumWageException();
        }

        // if id negative, or hours worked negative
        if(number < 0 || hoursWorked < 0 ){
            throw new IllegalArgumentException("Negative field");
        }

        //more than 24 * 7 (1 week)
        if( hoursWorked > 168){
            throw new IllegalArgumentException("Hours worked too large");
        }
        this.employeNumber = number;
        this.firstName = firstName;
        this.lastName = lastName;
        this.hoursWorked = hoursWorked;
        this.wage = wage;
    }

    // Calculate gross income, as a function
    public double getGrossIncome(){
        return hoursWorked * wage * 52;
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

    public long getEmployeNumber() {
        return this.employeNumber;
    }

    public void setEmployeNumber(long employeNumber) {
        this.employeNumber = employeNumber;
    }


    //return the total tax of the employee from his salary
    public double getEmployeeTotalDeduction() {
        TaxCalculator t = new TaxCalculator();
        return t.getTotalDeduction(getGrossIncome());
    }

    //Calculate and rerturn the net salary
    public double getEmployeeNetSalary() {
        return getGrossIncome() - this.getEmployeeTotalDeduction();
    }

    //Return the to String for when we will write in file
    public String toString(){

        return String.format("%-15s %-15s %-15s %-15s %-15s %-15s",
                this.employeNumber, this.firstName, this.lastName,
                formatAmount(this.getGrossIncome()), formatAmount(this.getEmployeeTotalDeduction()),
                formatAmount(this.getEmployeeNetSalary()));
    }

    // add a dollar sign in form and devide the different 100's (e.g. 90000.05 -> $90 000.05)
    private static String formatAmount(double amount){
        //Start by placing commas and then replacing them with spaces.
        return String.format("$%,.2f",amount).replace(",", " ");
    }

}

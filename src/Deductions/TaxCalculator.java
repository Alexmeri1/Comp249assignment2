package Deductions;

public class TaxCalculator {

    //Create an instance of every tax
    Deduction provT = new ProvincialIncomeTax();
    Deduction fedT = new FederalIncomeTax();
    Deduction quebecT = new QuebecPensionPlan();
    Deduction employeeT = new EmploymentInsurance();
    Deduction quebecParentT = new QuebecParentalInsurancePlan();

    //Calculate the whole tax
    public double getTotalDeduction(double salary){
        double totalTax = 0.0;

        totalTax = provT.calculateTax(salary) + fedT.calculateTax(salary)
                + quebecT.calculateTax(salary) + employeeT.calculateTax(salary)
                +quebecParentT.calculateTax(salary);

        return totalTax;
    }



}

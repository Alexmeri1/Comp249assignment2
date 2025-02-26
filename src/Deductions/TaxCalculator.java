package Deductions;

public class TaxCalculator {

    Deduction provT = new ProvincialIncomeTax();
    //Deduction fedT = new FederalIncomeTax();
    Deduction quebecT = new QuebecPensionPlan();
    Deduction employeeT = new EmploymentInsurance();
    Deduction quebecParentT = new QuebecParentalInsurancePlan();

    public double getTotalDeduction(double salary){
        Double totalTax = 0.0;
        //totalTax = provT.calculateTax(salary) + fedT.calculateTax(salary)
          //          + quebecT.calculateTax(salary) + employeeT.calculateTax(salary)
           //     +quebecParentT.calculateTax(salary);
        return totalTax;
    }



}

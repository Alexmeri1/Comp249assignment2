package Deductions;

public class EmploymentInsurance extends Deduction {


    @Override
    public double calculateTax(double grossIncome) {
        if (grossIncome >= 65700) {
            return 1077.48;
        }
        return 0.0164 * grossIncome;
    }


}

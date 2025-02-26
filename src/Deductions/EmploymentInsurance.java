package Deductions;

public class EmploymentInsurance extends Deduction{

    @Override
    public double calculateTax(double grossIncome) {

        if(grossIncome >= 65700){
            return 1077.48;
        }

        int howMany100s = (int) grossIncome/100;
        return 1.64 * howMany100s;


    }
}

package Deductions;

public class QuebecParentalInsurancePlan extends Deduction{
    @Override
    public double calculateTax(double grossIncome) {
        if(grossIncome >= 98000){
            return 484.12;
        }

        double percent = 0.494;

        return (percent*grossIncome)/100;
    }
}

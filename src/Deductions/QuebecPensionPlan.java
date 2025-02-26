package Deductions;

public class QuebecPensionPlan extends Deduction{
    @Override
    public double calculateTax(double grossIncome) {
        if (grossIncome >= 71300){
            return 7700.4;
        }
        double percentage = 10.8;
        return (percentage*grossIncome)/100;
    }
}

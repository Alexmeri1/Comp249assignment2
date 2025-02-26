package Deductions;

public class ProvincialIncomeTax extends Deduction {
    @Override
    public double calculateTax(double grossIncome) {
        if (grossIncome > 129590) {
            return (grossIncome * 25.75) / 100;
        } else if (grossIncome <= 129590 && grossIncome > 106495) {
            return (grossIncome * 24) / 100;
        } else if (grossIncome <= 106495 && grossIncome > 53255) {
            return (grossIncome * 19) / 100;
        } else if (grossIncome <= 53255 && grossIncome > 18571) {
            return (grossIncome * 14) / 100;
        }
        return 0;
    }
}

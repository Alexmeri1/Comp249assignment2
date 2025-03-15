package Deductions;

public class ProvincialIncomeTax extends Deduction {
    @Override
    public double calculateTax(double grossIncome) {
        double tax = 0.0;
        double temp = 0.0;
        if (grossIncome < 18571) {
            return 0.0;
        }
        if (grossIncome > 129590) {
            temp = grossIncome - 129590;
            tax += temp * 0.2575;
            grossIncome -= temp;
        }
        if (grossIncome > 106495) {
            temp = grossIncome - 106495;
            tax += temp * 0.24;
            grossIncome -= temp;
        }
        if (grossIncome > 53255) {
            temp = grossIncome - 53255;
            tax += temp * 0.19;
            grossIncome -= temp;
        }
        if (grossIncome > 18571) {
            temp = grossIncome - 18571;
            tax += temp * 0.14;
        }
        return tax;
    }
}
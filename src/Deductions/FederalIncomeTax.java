package Deductions;

public class FederalIncomeTax extends Deduction {
    @Override
    public double calculateTax(double grossIncome) {
        double tax = 0.0;
        double temp = 0.0;


        // No tax below $16,129
        if (grossIncome < 16129) {
            return 0.0;
        }

        // 33% on income above $253,414
        if (grossIncome > 253414) {
            temp = grossIncome - 253414;
            tax += temp * 0.33;
            grossIncome -= temp;
        }

        // 29% on income from $177,883 to $253,414
        if (grossIncome > 177883) {
            temp = grossIncome - 177883;
            tax += temp * 0.29;
            grossIncome -= temp;
        }

        // 26% on income from $114,751 to $177,882
        if (grossIncome > 114751) {
            temp = grossIncome - 114751;
            tax += temp * 0.26;
            grossIncome -= temp;
        }
        // 20.5% on income from $57,376 to $114,750
        if (grossIncome > 57376) {
            temp = grossIncome - 57376;
            tax += temp * 0.205;
            grossIncome -= temp;

        }

        // 15% on income from $16,129 to $57,375
        if (grossIncome >= 16129) {
            temp = grossIncome - 16129;
            tax += temp * 0.15;
            grossIncome -= temp;
        }

        return tax;
    }
}
package Deductions;

public class FederalIncomeTax extends Deduction {

    @Override
    public double calculateTax(double grossIncome) {
        if (grossIncome > 253414) {
            return (grossIncome * 33) / 100;
        } else if (grossIncome <= 253414 && grossIncome > 177883) {
            return (grossIncome * 29) / 100;
        } else if (grossIncome <= 177882 && grossIncome > 114751) {
            return (grossIncome * 19) / 100;
        } else if (grossIncome <= 114750 && grossIncome > 57376) {
            return (grossIncome * 14) / 100;
        } else if (grossIncome <= 57375 && grossIncome >= 16129) {
            return (grossIncome * 14) / 100;
        }

        return 0;
    }
}

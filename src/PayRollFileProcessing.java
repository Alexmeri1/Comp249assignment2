import java.io.*;
import java.util.Scanner;


public class PayRollFileProcessing {

    public Employee parseLine(String line) throws Exception {

        String[] splitted = line.split(" +");
        if (splitted.length != 5) {
            throw new IllegalArgumentException("Line does not have 5 fields!");
        }
        Employee employee = null;

        Long employeeID = Long.valueOf(splitted[0]);
        String employeeLastName = splitted[1];
        String employeeFirstName = splitted[2];
        Double employeeHours = Double.valueOf(splitted[3]);
        Double employeeWage = Double.valueOf(splitted[4]);

        double grossIncome = employeeHours * employeeWage * 52;
        employee = new Employee(employeeID, employeeFirstName, employeeLastName, employeeHours, employeeWage, grossIncome);

        return employee;

    }


    public void writeToErrorFile(String line) {

    }

    public void writeToReportFile(String line) {

    }


}

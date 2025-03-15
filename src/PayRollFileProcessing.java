import javax.swing.text.NumberFormatter;
import java.io.*;
import java.text.FieldPosition;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.Scanner;


public class PayRollFileProcessing {

    public Employee parseLine(String line) throws IOException {

        String[] splitted = line.split(" +");
        if (splitted.length != 5) {
            throw new IllegalArgumentException("Line does not have 5 fields!");
        }
        Employee employee = null;

        Long employeeID = Long.valueOf(splitted[0]);
        String employeeLastName = splitted[2];
        String employeeFirstName = splitted[1];
        Double employeeHours = Double.valueOf(splitted[3]);
        Double employeeWage = Double.valueOf(splitted[4]);

        employee = new Employee(employeeID, employeeFirstName, employeeLastName, employeeHours, employeeWage);

        return employee;

    }


    public void writeToErrorFile(String line) {

        try ( PrintWriter pw = new PrintWriter(new FileOutputStream("payrollError.txt", true))){

            pw. println(line);

        } catch (FileNotFoundException e) {
            System.out.println("Couldn't find the error file");

        } catch (Exception e) {
            System.out.println("Something unexpected happened while writing to error file");
        }

    }

    public void writeToReportFile(Employee[] arr) {
        if (arr == null || arr.length == 0) {
            System.out.println("Array is empty");
            return;
        }
        try (PrintWriter pw = new PrintWriter(new FileOutputStream("payrollReport.txt", false))){
            //print all the employee to the arr

                String headerLine1 = String.format("%-15s %-15s %-15s %-15s %-15s %-15s",
                        "Employee", "First name", "Last Name", "Gross salary", "Deductions", "Net salary");
                pw.println(headerLine1);
                pw.println("Number");
                pw.println("-------------------------------------------------------------------------------------------------------");
            System.out.println("Writing to report file");
                for (Employee emp : arr) {
                    pw.println(emp.toString());
                }

        } catch (FileNotFoundException e) {
            System.out.println("Couldn't find the error file");

        } catch (Exception e) {
            System.out.println("Something unexpected happened while writing to report file\n" +
                    "more precicesuly" + e.getMessage());
        }

    }


}

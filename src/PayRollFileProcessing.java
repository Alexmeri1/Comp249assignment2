import java.io.*;


public class PayRollFileProcessing {

    //Read a line and return an employee
    public Employee parseLine(String line) throws IllegalArgumentException {

        //Split the line received by spaces, 1 or more
        String[] splitted = line.split(" +");

        //If not 5 fields then it is wrong
        if (splitted.length != 5) {
            throw new IllegalArgumentException("Line does not have 5 fields!");
        }
        Employee employee = null;

        //We try to do this, and there is a catch in the main
        Long employeeID = Long.valueOf(splitted[0]);
        String employeeLastName = splitted[2];
        String employeeFirstName = splitted[1];
        Double employeeHours = Double.valueOf(splitted[3]);
        Double employeeWage = Double.valueOf(splitted[4]);

        //Try to create the employee
        employee = new Employee(employeeID, employeeFirstName, employeeLastName, employeeHours, employeeWage);

        return employee;
    }


    public void writeToErrorFile(String line) {

        //Locate or create error file
        try (PrintWriter pw = new PrintWriter(new FileOutputStream("payrollError.txt", true))) {
            //write the line received
            pw.println(line);

        } catch (FileNotFoundException e) {
            System.out.println("Couldn't find the error file");

        } catch (Exception e) {
            System.out.println("Something unexpected happened while writing to error file");
        }

    }

    public void writeToReportFile(Employee[] arr) {
        //if array is null or empty do nothing
        if (arr == null || arr.length == 0) {
            System.out.println("Array is empty");
            return;
        }
        //Create or open the report file
        try (PrintWriter pw = new PrintWriter(new FileOutputStream("payrollReport.txt", false))) {

            //Create the header of the document
            String headerLine1 = String.format("%-15s %-15s %-15s %-15s %-15s %-15s",
                    "Employee", "First name", "Last Name", "Gross salary", "Deductions", "Net salary");
            pw.println(headerLine1);
            pw.println("Number");
            pw.println("-------------------------------------------------------------------------------------------------------");

            System.out.println("Writing to report file");

            //print all the employee to the arr
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

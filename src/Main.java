// Assignment 2
// Written by: Alexander Meriakri #40310155


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Employee[] employees = null;
        PayRollFileProcessing fileManager = new PayRollFileProcessing();

        try {
            Scanner reader = new Scanner(new FileInputStream(" payroll.txt"));

            while (reader.hasNextLine()) {

                String line = reader.nextLine();
                Employee employee = null;
                try {
                    employee = fileManager.parseLine(line);
                } catch (NumberFormatException nfe) {
                    fileManager.writeToErrorFile(line);
                    throw new NumberFormatException("One of the fields had an invalid character!");
                } catch (MinimumWageException mwe) {
                    fileManager.writeToErrorFile(line);
                    throw new MinimumWageException();
                } catch (Exception e) {
                    fileManager.writeToErrorFile(line);
                    throw new RuntimeException("Something unexpected happened");
                }finally {
                    employees = addEmployeeToArray(employee, employees);
                }


            }
            if (employees != null) {
                for (Employee e : employees) {
                    System.out.println(e.getGrossIncome());
                    System.out.println(e.getEmployeeTotalDeduction());
                    System.out.println(e.getEmployeeNetSalary());

                }
            }

        } catch (FileNotFoundException e) {

            throw new RuntimeException(e);

        }

    }

    public static Employee[] addEmployeeToArray(Employee e, Employee[] arr) {
        Employee[] newArr;
        if(e ==null){
            System.out.println("Employee null");
            return arr;
        }
        if (arr == null || arr.length == 0) {
            newArr = new Employee[1];
            newArr[0] = e;
            return newArr;
        }
        newArr = new Employee[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];

        }
        newArr[arr.length] = e;
        return newArr;
    }

}
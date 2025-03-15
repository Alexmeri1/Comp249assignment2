// Assignment 2
// Written by: Alexander Meriakri #40310155
//This is the main class where everything plays out
import java.io.*;
import java.util.Scanner;

public class Main {
    static int totalLinesRead = 0;
    static int totalToErrorFile = 0;

    public static void main(String[] args) {

        //Initialize the array
        Employee[] employees = null;

        //Create a file Manager
        PayRollFileProcessing fileManager = new PayRollFileProcessing();

        System.out.println("Welcome to Alex's payroll calculator");

        try {

            Scanner reader = new Scanner(new FileInputStream("payroll.txt"));
            System.out.println("Opening file payroll...\n");

            while (reader.hasNextLine()) {

                //read a line
                String line = reader.nextLine();
                Employee employee = null;
                try {

                    totalLinesRead++;
                    //try to get an employee from the line read
                    employee = fileManager.parseLine(line);

                    //If successfully read the line and created an employee, add him to the array
                    employees = addEmployeeToArray(employee, employees);

                }

                //If has an exception print, put it in error file
                catch (NumberFormatException nfe) {
                    //System.out.println("One of the fields had an invalid character!");
                    fileManager.writeToErrorFile(line);
                    totalToErrorFile++;
                } catch (IllegalArgumentException e) {
                    //System.out.println(e.getMessage());
                    fileManager.writeToErrorFile(line);
                    totalToErrorFile++;
                } catch (MinimumWageException mwe) {
                    //System.out.println(mwe);
                    fileManager.writeToErrorFile(line);
                    totalToErrorFile++;
                }  catch(Exception e) {
                    //System.out.println("Something unexpected happened" + e.getMessage());
                    fileManager.writeToErrorFile(line);
                    totalToErrorFile++;
                }

            }
            //Close reader at the end
            reader.close();
        } catch (FileNotFoundException e) {

            throw new RuntimeException("File not found");

        }

        //If the file had errors
        if(totalToErrorFile != 0 ){
            System.out.println("Error lines found in file payroll");
        }

        readAndDisplayFile("payrollError.txt");

        System.out.println(totalLinesRead + " lines read from payroll file");
        System.out.println(totalToErrorFile + " lines written to error file");

        //Check if there are employees
        if (employees != null) {
            System.out.println("Calculating deductions");
            //Write all the employees to the report file
            fileManager.writeToReportFile(employees);

            readAndDisplayFile("payrollReport.txt");
        }else{
            System.out.println("No employees were found");
        }

        System.out.println("Thank you for using the app");

    }

    private static void readAndDisplayFile(String fileName){

        try (Scanner reader = new Scanner(new FileInputStream(fileName))){
            String line = null;

            //For every line in the text line read it and display the line
            while( reader.hasNextLine() ){
                line = reader.nextLine();
                System.out.println(line);
            }


        }catch(FileNotFoundException e){
            System.out.println("File not found");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }

    private static Employee[] addEmployeeToArray(Employee e, Employee[] arr) {
        Employee[] newArr;
        if (e == null) {
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
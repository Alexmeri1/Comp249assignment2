// Assignment 2
// Written by: Alexander Meriakri #40310155


import Deductions.TaxCalculator;

import javax.xml.transform.stream.StreamSource;
import java.io.*;
import java.util.Scanner;

public class Main {
    static int  totalLinesRead = 0;
    static int totalToErrorFile = 0;

    public static void main(String[] args) {


        Employee[] employees = null;
        PayRollFileProcessing fileManager = new PayRollFileProcessing();


        try {

            Scanner reader = new Scanner(new FileInputStream("payroll.txt"));
            System.out.println("Opening file payroll...\n");

            while (reader.hasNextLine()) {

                String line = reader.nextLine();
                Employee employee = null;
                boolean isException = false;
                try {
                    totalLinesRead++;
                    employee = fileManager.parseLine(line);
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

        } catch (FileNotFoundException e) {

            throw new RuntimeException("File not found");

        }

        if(totalToErrorFile != 0 ){
            System.out.println("Error lines found in file payroll");
        }
        readAndDisplayFile("payrollError.txt");

        System.out.println(totalLinesRead + " lines read from payroll file");
        System.out.println(totalToErrorFile + " lines written to error file");
        System.out.println("Calculating deductions");
        if (employees != null) {

            fileManager.writeToReportFile(employees);

        }

        readAndDisplayFile("payrollReport.txt");

        TaxCalculator tc = new TaxCalculator();
        System.out.println(tc.getTotalDeduction(52000));

    }

    private static void readAndDisplayFile(String fileName){

        try (Scanner reader = new Scanner(new FileInputStream(fileName))){
            String line = null;
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
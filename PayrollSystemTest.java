// Siona Vivian
// 16/7/24
// CS 143
// Lab 4: Payroll System Modification
/*
The program is to modify the provided Payroll system to include private instance
variable birthDate in class Employee and calculate the payroll for each Employee
polymorphically.
*/
// Sources: Dietel Textbook / Provided Employee and intiial PayrollSystemTest.java
//                            files

import java.util.Scanner; // program uses Scanner to obtain user input

public class PayrollSystemTest {
   public static void main(String[] args) {
      // create subclass objects
      SalariedEmployee salariedEmployee =
         new SalariedEmployee(
         "John", "Smith", "111-11-1111", 6, 15, 1944, 800.00);
      HourlyEmployee hourlyEmployee =
         new HourlyEmployee(
         "Karen", "Price", "222-22-2222", 12, 29, 1960, 16.75, 40);
      CommissionEmployee commissionEmployee =
         new CommissionEmployee(
         "Sue", "Jones", "333-33-3333", 9, 8, 1954, 10000, .06);
      BasePlusCommissionEmployee basePlusCommissionEmployee =
         new BasePlusCommissionEmployee(
         "Bob", "Lewis", "444-44-4444", 3, 2, 1965, 5000, .04, 300);

      // create four-element Employee array
      Employee[] employees = {salariedEmployee,
                              hourlyEmployee,
                              commissionEmployee,
                              basePlusCommissionEmployee};

      System.out.println();
      for (Employee current : employees) {
         System.out.println(current);
         System.out.printf(
            "earned $%,.2f\n\n", current.earnings());
      }

      printEmployeeEarnings(employees);

   }

   public static void printEmployeeEarnings(Employee[] employees) {
      Scanner input = new Scanner(System.in); // to get current month
      int currentMonth;

      do {
         System.out.print("Enter the current month (1 - 12): ");
         currentMonth = input.nextInt();
         System.out.println();
      } while ((currentMonth < 1) || (currentMonth > 12));

      for (Employee currentEmployee : employees) {
         System.out.println(currentEmployee); // invokes toString

         // if month of employee's birthday, add $100 to salary
         if (currentMonth == currentEmployee.getBirthDate().getMonth()) {
            System.out.printf(
               "earned $%,.2f %s\n\n", currentEmployee.earnings(),
               "plus $100.00 birthday bonus");
         }
         else {
            System.out.printf(
               "earned $%,.2f\n\n", currentEmployee.earnings());
         }
      }
   }
}


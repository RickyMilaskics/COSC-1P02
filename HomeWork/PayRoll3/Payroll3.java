 


import java.util.*;
import BasicIO.*;
import static BasicIO.Formats.*;


/** This class is a program to do a simple payroll producing a report.
  * 
  * @author David Hughes
  * 
  * @version 1.0 (Aug. 2009)
  *
  * new concepts: persistent objects                                            */

public class Payroll3 {
    
    
    private BinaryDataFile    empData;     // data file for employee info
    private BasicForm         display;     // form for user input
    private BinaryOutputFile  newEmpData;  // data file for updated emp info
    private ReportPrinter     report;      // printer for report
    
    
    /** The constructor opens the data file for the emp info, creates the
      * prompter for user input, sets up theprinter for the report and creates
      * the new emp info file.                                                  */
    
    public Payroll3 ( ) {
        
        empData = new BinaryDataFile();
        display = new BasicForm("Pay","Next");
        newEmpData = new BinaryOutputFile();
        report = new ReportPrinter();
        
    };  // constructor
    
    
    /** This method does the monthly payroll for a small company generating a
      * report.                                                                 */
    
    private void doMonthEnd ( ) {
        
        Employee  anEmp;      // the employee
        double    hours;      // hours worked
        double    pay;        // employee's pay
        double    totPay;     // total pay
        double    totYTDPay;  // total year-to-date pay
        int       button;     // button pressed
        
        buildForm();
        setUpReport(new Date());
        totPay = 0;
        totYTDPay = 0;
        while ( true ) {
            anEmp = (Employee)empData.readObject();
        if ( empData.isEOF() ) break;
            fillForm(anEmp);
            button = display.accept();
            if ( button == 0 ) {
                hours = display.readDouble("hours");
                pay = anEmp.calculatePay(hours);
                writeDetail(anEmp,hours,pay);
                totPay = totPay + pay;
                totYTDPay = totYTDPay + anEmp.getYTDPay();
            };
            newEmpData.writeObject(anEmp);
        };
        writeSummary(totPay,totYTDPay);
        empData.close();
        newEmpData.close();
        display.close();
        report.close();
        
    };  // doMonthEnd
    
    
    /** This method builds the form for user input                              */
    
    private void buildForm ( ) {
        
        display.addTextField("empNum","Employee",8,10,10);
        display.setEditable("empNum",false);
        display.addTextField("empName","Name",20,10,40);
        display.setEditable("empName",false);
        display.addTextField("rate","Pay Rate",getCurrencyInstance(),6,10,70);
        display.setEditable("rate",false);
        display.addTextField("hours","Hours Worked",getDecimalInstance(1),6,10,100);
        display.addTextField("YTDPay","YTD Gross Pay",getCurrencyInstance(),11,10,130);
        display.setEditable("YTDPay",false);
        
    };  // buildForm
    
    
    /** This method fills in the fields of the form for the Employee.
      * 
      * @param  anEmployee  employee for information                            */
    
    private void fillForm ( Employee anEmployee ) {
        
        display.clearAll();
        display.writeString("empNum",anEmployee.getEmpNum());
        display.writeString("empName",anEmployee.getEmpName());
        display.writeDouble("rate",anEmployee.getRate());
        display.writeDouble("YTDPay",anEmployee.getYTDPay());
        
    };  // fillForm
    
    
    /** This method sets up the report, adding all fields.
      * 
      * @param  date  date for payroll report                                   */
    
    private void setUpReport ( Date date ) {
        
        report.setTitle("Timmy's Coffee Bar",getDateInstance().format(date));
        report.addField("empNum","Employee #",10);
        report.addField("empName","Name",20);
        report.addField("rate","Pay Rate",getCurrencyInstance(),9);
        report.addField("hours","Hours",getDecimalInstance(2),6);
        report.addField("pay","Total Pay",getCurrencyInstance(),11);
        report.addField("YTDPay","YTD Pay",getCurrencyInstance(),12);
        
    };  // setUpReport
    
    
    /** This method generates a report detail line.
      * 
      * @param  empNum  employee number
      * @param  rate    pay rate
      * @param  hours   hours worked
      * @param  pay     total pay
      * @param  YTDPay  year-to-dat pay                                          */
    
    private void writeDetail ( Employee anEmployee, double hours, double pay ) {
        
        report.writeString("empNum",anEmployee.getEmpNum());
        report.writeString("empName",anEmployee.getEmpName());
        report.writeDouble("rate",anEmployee.getRate());
        report.writeDouble("hours",hours);
        report.writeDouble("pay",pay);
        report.writeDouble("YTDPay",anEmployee.getYTDPay());
        
    };  // writeDetail
    
    
    /** This method generates the report summary.
      * 
      * @param  totPay     total pay for all employees
      * @param  totYTDPay  total YTD pay for all employees                       */
    
    private void writeSummary ( double totPay, double totYTDPay ) {
        
        report.writeString("empNum","Total");
        report.writeDouble("pay",totPay);
        report.writeDouble("YTDPay",totYTDPay);
        
    };  // writeSummary
    
    
    public static void main ( String[] args ) { new Payroll3().doMonthEnd(); };
    
    
}  // Payroll3

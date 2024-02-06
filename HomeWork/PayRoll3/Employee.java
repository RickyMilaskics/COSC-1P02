 


import java.io.*;
import BasicIO.*;


/** This class represents an employee in the company.                           */

public class Employee implements Serializable {
    
    
    public static final long    serialVersionUID = 987654322L;
    
    private String  empNum;    // employee number
    private String  empName;   // employee name
    private double  rate;      // pay rate
    private double  YTDPay;    // year-to-date gross pay
    
    
    /** The constructor creates a new employee reading the employee data from a
      * text file.
      *
      * @param  from  data file for employee data.                              */
    
    public Employee ( ASCIIDataFile from ) {
        
        empNum = from.readString();
        if ( ! from.isEOF() ) {
            empName = from.readString();
            rate = from.readDouble();
            YTDPay = from.readDouble();
        };
        
    };  // constructor
    
    
    /** This method returns the employee number.
      *
      * @return  String  employee number.                                       */
    
    public String getEmpNum ( ) {
        
        return empNum;
        
    };  // getEmpNum
    
    
    /** This method returns the employee name.
      *
      * @return  String  employee name.                                         */
    
    public String getEmpName ( ) {
        
        return empName;
        
    };  // getEmpName
    
    
    /** This method returns the employee' pay rate.
      *
      * @return  double  pay rate.                                              */
    
    public double getRate ( ) {
        
        return rate;
        
    };  // getRate
    
    
    /** This method changes the employee's rate of pay.
      *
      * @param newRate new pay rate.        */
    
    public void setRate ( double newRate ) {
        
        rate = newRate;
        
    };  // setRate
    
    
    /** This method returns the employee's year-to-date gross pay.
      *
      * @return  double  year-to-date gross pay.                                */
    
    public double getYTDPay ( ) {
        
        return YTDPay;
        
    };  // getYTDPay
    
    
    /** This method returns the employee's gross pay for the pay period based on
      * hours worked updating year-to-date gross pay.
      *
      * @param  hours  hours worked
      *
      * @return  double  gross pay amount                                       */
    
    public double calculatePay ( double hours ) {
        
        double  pay;  // gross pay
        
        if ( hours > 40.0 ) {
            pay = 40.0 * rate + ( hours - 40.0 ) * rate * 1.5;
        }
        else {
            pay = hours * rate;
        }
        YTDPay = YTDPay + pay;
        return pay;
        
    };  // calculatePay
    
    
    /** This method writes the employee information as a line to a text file.
      *
      * @param  to  file to write to.                                           */
    
    public void write ( ASCIIOutputFile to ) {
        
        to.writeString(empNum);
        to.writeString(empName);
        to.writeDouble(rate);
        to.writeDouble(YTDPay);
        to.newLine();
        
    };  // write
    
    
}  // Employee

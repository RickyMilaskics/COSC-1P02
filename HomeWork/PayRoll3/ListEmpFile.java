 


import BasicIO.*;


/** This class is a program to list the binary employee file.
  * 
  * @author David Hughes
  * 
  * @version 1.0 (Aug. 2008)
  *
  * new concepts: reading a binary file                                         */

public class ListEmpFile {
    
    
    private BinaryDataFile    empData;     // employee text data file
    private ASCIIDisplayer    display;     // display for listing
    
    
    /** The constructor opens the data file for the emp info and creates a
      * display for the listing.                                                */
    
    public ListEmpFile ( ) {
        
        empData = new BinaryDataFile();
        display = new ASCIIDisplayer();
        
    };  // constructor
    
    
    /** This method lists the binary employee file.                             */
    
    private void list ( ) {
        
        Employee  anEmp;      // the employee
        int       numEmp;     // number of employees
        
        numEmp = 0;
        while ( true ) {
            anEmp = (Employee)empData.readObject();
        if ( empData.isEOF() ) break;
            numEmp = numEmp + 1;
            writeDetail(anEmp);
        };
        display.newLine();
        display.writeString("Number of records:");
        display.writeInt(numEmp);
        empData.close();
        display.close();
        
    };  // list
    
    
    /** This method writes the employee details to the display.
      * 
      * @param  anEmployee  the employee                                          */
    
    private void writeDetail ( Employee anEmployee ) {
        
        display.writeString(anEmployee.getEmpNum());
        display.writeString(anEmployee.getEmpName());
        display.writeDouble(anEmployee.getRate());
        display.writeDouble(anEmployee.getYTDPay());
        display.newLine();
        
    };  // writeDetail
    
    
    public static void main ( String[] args ) { new ListEmpFile().list(); };
    
    
}  // ListEmpFile

 


import BasicIO.*;


/** This class is a program to create the binary employee file.
  * 
  * @author David Hughes
  * 
  * @version 1.0 (Aug. 2009)
  *
  * new concepts: creating a binary file                                        */

public class MakeEmpFile {
    
    
    private ASCIIDataFile     empData;     // employee text data file
    private BinaryOutputFile  newEmpData;  // employee binary data file
    private ASCIIDisplayer    display;     // display for user feedback
    
    
    /** The constructor opens the data file for the emp info, creates a
      * display for user feedback, and creates the binary emp file.             */
    
    public MakeEmpFile ( ) {
        
        empData = new ASCIIDataFile();
        display = new ASCIIDisplayer();
        newEmpData = new BinaryOutputFile();
        
    };  // constructor
    
    
    /** This method creates the binary employee file.                           */
    
    private void create ( ) {
        
        Employee  anEmp;      // the employee
        int       numEmp;     // number of employees
        
        numEmp = 0;
        while ( true ) {
            anEmp = new Employee(empData);
        if ( empData.isEOF() ) break;
            numEmp = numEmp + 1;
            newEmpData.writeObject(anEmp);
        };
        display.writeString("Number of records created:");
        display.writeInt(numEmp);
        empData.close();
        newEmpData.close();
        display.close();
        
    };  // create
    
    
    public static void main ( String[] args ) { new MakeEmpFile().create(); };
    
    
}  // MakeEmpFile

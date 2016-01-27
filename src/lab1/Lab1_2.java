package lab1;

import org.apache.jena.rdf.model.*;
import java.io.*;

/** Tutorial 5 - read RDF XML from a file and write it to standard out
 */
public class Lab1_2 extends Object {

    /**
        NOTE that the file is loaded from the class-path and so requires that
        the data-directory, as well as the directory containing the compiled
        class, must be added to the class-path when running this and
        subsequent examples.
    */    
   //static final String inputFileName  = "kevin.rdf";
    static final String outputXML = "Lab1_2_aChaturvedi.xml";
    static final String outputNTRIPLE = "Lab1_2_aChaturvedi.ntp";
    static final String outputN3 = "Lab1_2_aChaturvedi.n3";
    
    String personURI    = "http://utdallas/semclass#KevenAtes";
    String fullName    = "Dr. Keven L. Ates";
    String birthDate   = "1901-01-01";
    String email     = "atescomp@utdallas.edu";
    String title     = "Senior Lecturer";
                              
    public static void main (String args[]) throws FileNotFoundException {
    	//org.apache.log4j.BasicConfigurator.configure(new NullAppender());
    	org.apache.log4j.Logger.getRootLogger().setLevel(org.apache.log4j.Level.OFF);
    	
        // create an empty model
        Model model = ModelFactory.createDefaultModel();

       // InputStream in = FileManager.get().open( inputFileName );
        OutputStream outXML = new FileOutputStream(outputXML);
        OutputStream outNTRIPLE = new FileOutputStream(outputNTRIPLE);
        OutputStream outN3 = new FileOutputStream(outputN3);
//        if (in == null) {
//            throw new IllegalArgumentException( "File: " + inputFileName + " not found");
//        }
        
        // read the RDF/XML file
      //  model.read(in, null);
                    
        // write it to standard out
        model.write(outXML, "RDF/XML-ABBREV");            
        model.write(outNTRIPLE, "N-TRIPLES");
        model.write(outN3, "N3");
    }
}

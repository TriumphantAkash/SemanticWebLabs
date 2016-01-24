package tutorials;

import org.apache.jena.rdf.model.*;
import org.apache.jena.util.FileManager;
import org.apache.log4j.varia.NullAppender;

import java.io.*;

/** Tutorial 5 - read RDF XML from a file and write it to standard out
 */
public class Tutorial05 extends Object {

    /**
        NOTE that the file is loaded from the class-path and so requires that
        the data-directory, as well as the directory containing the compiled
        class, must be added to the class-path when running this and
        subsequent examples.
    */    
    static final String inputFileName  = "kevin.rdf";
                              
    public static void main (String args[]) {
    	org.apache.log4j.BasicConfigurator.configure(new NullAppender());
        // create an empty model
        Model model = ModelFactory.createDefaultModel();

        InputStream in = FileManager.get().open( inputFileName );
        if (in == null) {
            throw new IllegalArgumentException( "File: " + inputFileName + " not found");
        }
        
        // read the RDF/XML file
        model.read(in, null);
                    
        // write it to standard out
        model.write(System.out);            
    }
}

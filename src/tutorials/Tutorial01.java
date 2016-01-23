package tutorials;

import org.apache.jena.rdf.model.*;
import org.apache.jena.vocabulary.*;
import org.apache.log4j.varia.NullAppender;

/** Tutorial 1 creating a simple model
 */

public class Tutorial01 extends Object {
    // some definitions
    static String personURI    = "http://somewhere/JohnSmith";
    static String fullName     = "John Smith";
    
      public static void main (String args[]) {
    	  org.apache.log4j.BasicConfigurator.configure(new NullAppender());
        // create an empty model
        Model model = ModelFactory.createDefaultModel();

       // create the resource
       Resource johnSmith = model.createResource(personURI);

      // add the property
      johnSmith.addProperty(VCARD.FN, fullName);
      }
}

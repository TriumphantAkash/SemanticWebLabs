package lab1;

import org.apache.jena.rdf.model.*;
import org.apache.jena.vocabulary.*;
import org.apache.log4j.varia.NullAppender;


/** Tutorial 3 Statement attribute accessor methods
 */

public class Tutorial04 extends Object {
    public static void main (String args[]) {
    
    	org.apache.log4j.BasicConfigurator.configure(new NullAppender());
        // some definitions
        String personURI    = "http://somewhere/JohnSmith";
        String givenName    = "John";
        String familyName   = "Smith";
        String fullName     = givenName + " " + familyName;
        // create an empty model
        Model model = ModelFactory.createDefaultModel();

        // create the resource
        //   and add the properties cascading style
        Resource johnSmith
          = model.createResource(personURI)
                 .addProperty(VCARD.FN, fullName)
                 .addProperty(VCARD.N,
                              model.createResource()
                                   .addProperty(VCARD.Given, givenName)
                                   .addProperty(VCARD.Family, familyName));
        
     // now write the model in XML form to a file
        model.write(System.out);
       // model.write(System.out, "N-TRIPLES");
    }
}
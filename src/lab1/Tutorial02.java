package lab1;

import org.apache.jena.rdf.model.*;
import org.apache.jena.vocabulary.*;
import org.apache.log4j.varia.NullAppender;

/** Tutorial 2 resources as property values
 */
public class Tutorial02 extends Object {
    
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
        Resource johnSmith  = model.createResource(personURI)
             .addProperty(VCARD.FN, fullName)					//VCARD.FN property has a literal value here (fullName)
             .addProperty(VCARD.N, 								//VCARD.N property has a resource value here
                      model.createResource()
                           .addProperty(VCARD.Given, givenName)
                           .addProperty(VCARD.Family, familyName));
        
      }
}

package lab1;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;

import org.apache.jena.query.Dataset;
import org.apache.jena.query.ReadWrite;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.tdb.TDBFactory;
import org.apache.jena.util.FileManager;
import org.apache.jena.vocabulary.VCARD;



public class lab1_4d extends Object {
    public static void main (String args[]) {
    
        
        String personURI    = "http://utdallas/semclass#KevenAtes";
        String designation="Dr.";
        String givenName    = "Keven";
        String middleInitital="L.";
        String familyName   = "Ates";
        String fullName     = designation+" "+ givenName +" "+middleInitital+ " " + familyName;
        String email= "atescomp@utdallas.edu";
        String birthDate="19010101";
        String title="Senior Lecturer";
        final String inputFileName  = "akash_FOAFFriends.rdf";
        Model model;
        String defaultNameSpace = "http://org.semwebprogramming/chapter2/people#";
        
        org.apache.log4j.Logger.getRootLogger().
        setLevel(org.apache.log4j.Level.OFF);
        
        
        
        Dataset dataset=TDBFactory.createDataset("MyDatabases/Dataset1");

    	dataset.begin(ReadWrite.WRITE);
    	
    	
    	
    	try
     	{
    		model=dataset.getNamedModel("myrdf");         
            model.createResource(personURI)
            .addProperty(VCARD.FN, fullName)
            .addProperty(VCARD.BDAY,birthDate)
            .addProperty(VCARD.EMAIL, email)
            .addProperty(VCARD.TITLE, title);          
        
           InputStream in = FileManager.get().open( inputFileName );
          if (in == null) {
              throw new IllegalArgumentException( "File: " + inputFileName + " not found");
          }
          
          model.read(in, defaultNameSpace);            
          
          
          try {
  			FileOutputStream xmlAnswer = new FileOutputStream("Lab1_4_aChaturvedi.xml");
  			FileOutputStream ntpAnswer = new FileOutputStream("Lab1_4_aChaturvedi.ntp");
  			FileOutputStream n3pAnswer = new FileOutputStream("Lab1_4_aChaturvedi.n3");
  			model.write(xmlAnswer,"RDF/XML-ABBREV");
  			model.write(ntpAnswer,"N-TRIPLES" );
  			model.write(n3pAnswer, "N3");
  		} catch (FileNotFoundException e) {
  			  			e.printStackTrace();
  		}
    	  	
 		
    		
    		dataset.commit();
    	}
    	finally
    	{
    		dataset.end();
    	}

    }
}

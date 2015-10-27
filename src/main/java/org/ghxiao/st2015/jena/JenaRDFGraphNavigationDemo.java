package org.ghxiao.st2015.jena;


import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.RDFNode;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.rdf.model.Statement;
import org.apache.jena.rdf.model.StmtIterator;
import org.apache.jena.vocabulary.VCARD;

public class JenaRDFGraphNavigationDemo {

    public static void main(String[] args) {
// some definitions
        String personURI = "http://somewhere/JohnSmith";
        String givenName = "John";
        String familyName = "Smith";
        String fullName = givenName + " " + familyName;

// create an empty Model
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

        // retrieve the John Smith vcard resource from the model
        Resource vcard = model.getResource(personURI);

        // retrieve the value of the N property
        Resource name = (Resource) vcard.getProperty(VCARD.N)
                .getObject();

        // retrieve the value of the N property
        Resource retrievedName = vcard.getProperty(VCARD.N)
                .getResource();


// retrieve the first name property
        String retrievedFName = vcard.getProperty(VCARD.FN)
                .getString();

        System.out.println(retrievedName);
        System.out.println(retrievedFName);



    }
}

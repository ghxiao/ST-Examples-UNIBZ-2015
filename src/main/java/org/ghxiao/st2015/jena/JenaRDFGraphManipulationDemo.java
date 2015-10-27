package org.ghxiao.st2015.jena;


import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.rdf.model.StmtIterator;
import org.apache.jena.vocabulary.VCARD;

public class JenaRDFGraphManipulationDemo {

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

        vcard.addProperty(VCARD.NICKNAME, "Smithy")
                .addProperty(VCARD.NICKNAME, "Adman");

        // set up the output
        System.out.println("The nicknames of \""
                + fullName + "\" are:");
// list the nicknames
        StmtIterator iter = vcard.listProperties(VCARD.NICKNAME);
        while (iter.hasNext()) {
            System.out.println("    " + iter.nextStatement()
                    .getObject()
                    .toString());
        }




    }
}

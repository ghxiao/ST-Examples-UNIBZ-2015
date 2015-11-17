package org.ghxiao.st2015.jena;


import org.apache.jena.rdf.model.InfModel;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.util.FileManager;

import java.io.InputStream;

public class JenaRDFSDemo {
    public static void main(String[] args) {
        String I_NS = "http://example.org/inst/";

        // Build a trivial example data set
        Model model = ModelFactory.createDefaultModel();

        String inputFileName = "src/main/resources/lab5/tourism.ttl";
        InputStream in = FileManager.get().open( inputFileName );

        model.read(in, null, "TURTLE");

        InfModel inf = ModelFactory.createRDFSModel(model);

//        Resource museion = model.getResource(I_NS + "Museion");
//        museion.listProperties().forEachRemaining(System.out::println);
//
//
        Resource museion = inf.getResource(I_NS + "Museion");
        museion.listProperties().forEachRemaining(System.out::println);

        Resource chickenHut = inf.getResource(I_NS + "ChickenHut");
        chickenHut.listProperties().forEachRemaining(System.out::println);

    }
}

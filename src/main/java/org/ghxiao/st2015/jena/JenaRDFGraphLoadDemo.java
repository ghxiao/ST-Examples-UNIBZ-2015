package org.ghxiao.st2015.jena;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.util.FileManager;

import java.io.InputStream;

public class JenaRDFGraphLoadDemo {
    public static void main(String[] args) {
        // create an empty model
        Model model = ModelFactory.createDefaultModel();

// use the FileManager to find the input file
        String inputFileName = "src/main/resources/lab1/xiao.ttl";
        InputStream in = FileManager.get().open( inputFileName );
        if (in == null) {
            throw new IllegalArgumentException(
                    "File: " + inputFileName + " not found");
        }

// read the RDF/XML file
        model.read(in, null, "TURTLE");

// write it to standard out
        model.write(System.out);

    }
}

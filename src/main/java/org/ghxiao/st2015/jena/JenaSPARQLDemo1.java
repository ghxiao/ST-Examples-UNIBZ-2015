package org.ghxiao.st2015.jena;

import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.RDFNode;
import org.apache.jena.util.FileManager;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class JenaSPARQLDemo1 {

    public static void main(String[] args) throws IOException {
        // create an empty model
        Model model = ModelFactory.createDefaultModel();

// use the FileManager to find the input file
        String inputFileName = "src/main/resources/lab3/example.ttl";
        InputStream in = FileManager.get().open(inputFileName);
        if (in == null) {
            throw new IllegalArgumentException(
                    "File: " + inputFileName + " not found");
        }

// read the RDF/XML file
        model.read(in, null, "TURTLE");

// write it to standard out
        model.write(System.out);

        // load an SPARQL query file

        Path path = Paths.get("src/main/resources/lab3/q1.sparql");
        String sparql = new String(Files.readAllBytes(path), "UTF-8");

        System.out.println("SPARQL Query:");

        System.out.println(sparql);

        // Evaluate the SPARQL query

        System.out.println("SPARQL Query (internal):");

        Query q = QueryFactory.create(sparql);
        System.out.println(q);

        QueryExecution queryExecution = QueryExecutionFactory.create(q, model);
        ResultSet resultSet = queryExecution.execSelect();

        resultSet.forEachRemaining(
                //b -> System.out.println(b)
                System.out::println
        );

//        while(resultSet.hasNext()){
//            QuerySolution s = resultSet.next();
//            RDFNode name = s.get("name");
//            System.out.println(name);
//        }
    }
}

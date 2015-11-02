package org.ghxiao.st2015.jena;


import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.ResultSet;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class JenaSPARQLDemo2 {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("src/main/resources/lab3/dbpedia_chinese_people.rq");
        String sparql = new String(Files.readAllBytes(path), "UTF-8");

        System.out.println("SPARQL Query:");

        System.out.println(sparql);

        Query q = QueryFactory.create(sparql);

        /* connects a SPARQL endpoint*/

        String endpoint = "http://dbpedia.org/sparql";

        System.out.println("Solution over the endpoint: " + endpoint);

        /* !!!! */
        QueryExecution qe = QueryExecutionFactory.sparqlService(endpoint, q);

        ResultSet rs = qe.execSelect();

        rs.forEachRemaining(System.out::println);

    }
}

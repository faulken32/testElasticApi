/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.testelasticapi;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.node.Node;
import static org.elasticsearch.node.NodeBuilder.*;

/**
 *
 * @author ncanicatti
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Node node = nodeBuilder().node();
        Node node2 = nodeBuilder().node();
        Node node3 = nodeBuilder().node();

        Client client = node.client();

        ObjectMapper mapper = new ObjectMapper(); // create once, reuse

        Cv cv = new Cv("1", "Canicatti", "test CV avec beaucoup de texte");

        try {
            // generate json
            byte[] json = mapper.writeValueAsBytes(cv);
            IndexResponse response = client.prepareIndex("cv", "candidat")
                    .setSource(json)
                    .execute()
                    .actionGet();
            
            System.out.println("objet creee: " + response.isCreated());

        } catch (JsonProcessingException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        client.close();
        node.close();
        node2.close();
        node3.close();
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.api;

import com.api.dto.Experiences;
import com.api.dto.Candidat;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.transport.InetSocketTransportAddress;

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

        Candidat nc = new Candidat();
        nc.setName("nicolas");
        nc.setPhone("0662094137");
        nc.setCvContends("blblalbladfdf");

        try {

            Client client = new TransportClient()
                    .addTransportAddress(new InetSocketTransportAddress("192.168.0.15", 9300))
                    .addTransportAddress(new InetSocketTransportAddress("192.168.0.15", 9301));
//                    .addTransportAddress(new InetSocketTransportAddress("192.168.0.17", 9302));

            ObjectMapper mapper = new ObjectMapper(); // create once, reuse

            // generate json
            byte[] json = mapper.writeValueAsBytes(nc);
            IndexResponse response = client.prepareIndex("cvdb", "candidat")
                    .setSource(json)
                    .execute()
                    .actionGet();

            Candidat nc1 = new Candidat();
            nc1.setName("nicolas");
            nc1.setId(response.getId());

            Experiences experiences = new Experiences("Université de Montpellier 2 ",
                    "Stagiaire",
                    "02/10/2001",
                    "02/11/2013",
                    "blbla",
                    nc1);

            System.out.println("objet creee: " + response.isCreated());

              byte[] json2 = mapper.writeValueAsBytes(experiences);
            IndexResponse response2 = client.prepareIndex("cvdb", "exp")
                    .setSource(json2)
                    .execute()
                    .actionGet();
            
              System.out.println("objet creee: " + response2.isCreated());
//            Candidat candidat = new Candidat(response.getId(), nc.getName());
//
//
//            byte[] json2 = mapper.writeValueAsBytes(experiences);
//            IndexResponse response2 = client.prepareIndex("cvdb", "exp")
//                    .setSource(json2)
//                    .execute()
//                    .actionGet();
//
//            System.out.println("objet creee: " + response2.isCreated());
            client.close();
        } catch (JsonProcessingException exp) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, exp);
        }

    }

}

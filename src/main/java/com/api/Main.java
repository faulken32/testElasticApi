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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
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

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String formatDate = format.format(date);

        ArrayList<String> dep = new ArrayList<String>();

        dep.add("06");
        dep.add("78");

        Candidat nc = new Candidat();
        nc.setName("nicolas");
        nc.setPhone("0662094137");
        nc.setCvContends("blblalbladfdf");
        nc.setEmail("canicatti.nicolas@gmail.com");
        nc.setMobilite(dep);
        nc.setEnterDate(formatDate);
        nc.setPreavis((float) 3);
        nc.setProfiled(false);
        nc.setAutoMaticProfiled(false);

        try {

            Client client = new TransportClient()
                    .addTransportAddress(new InetSocketTransportAddress("172.31.4.150", 9300))
                    .addTransportAddress(new InetSocketTransportAddress("172.31.4.150", 9301))
                    .addTransportAddress(new InetSocketTransportAddress("172.31.4.150", 9302));

            ObjectMapper mapper = new ObjectMapper(); // create once, reuse

            for (int i = 0; i < 100000; i++) {

                byte[] json = mapper.writeValueAsBytes(nc);
                IndexResponse response = client.prepareIndex("cvdb", "candidat")
                        .setSource(json)
                        .execute()
                        .actionGet();
                System.out.println("objet creee: " + response.isCreated());
                // generate json
                Candidat nc1 = new Candidat();
                nc1.setName("nicolas");
                nc1.setId(response.getId());    

                SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");

                Calendar c = new GregorianCalendar();
                c.set(2000, 1, 1);

                ArrayList<String> arrayList = new ArrayList<>();

                arrayList.add("Java");
                arrayList.add("Php");
                arrayList.add("kibana");
                arrayList.add("JSF");

                Experiences experiences = new Experiences();
                experiences.setTitle("rrrrr");

                experiences.setStart(format1.format(c.getTime()));
                experiences.setEnd(format1.format(c.getTime()));
                experiences.setCandidatid(nc1.getId());
                experiences.setTecnoList(arrayList);

                byte[] json2 = mapper.writeValueAsBytes(experiences);
                IndexResponse response2 = client.prepareIndex("cvdb", "exp")
                        .setSource(json2)
                        .execute()
                        .actionGet();

                System.out.println("objet creee: " + response2.isCreated());
//            Candidat candidat = new Candidat(response.getId(), nc.getName());

            }
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

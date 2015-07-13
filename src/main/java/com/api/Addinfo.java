/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.api;

import com.api.dto.Candidat;
import com.api.dto.Comments;
import com.api.dto.Experiences;
import com.api.dto.PartialCandidat;
import com.api.dto.School;
import com.api.mapping.CandidatMap;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
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
 * @author t311372
 */
public class Addinfo {

    public Addinfo() throws IOException {
        
        
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String formatDate = format.format(date);

        ArrayList<String> dep = new ArrayList<String>();

        dep.add("06");
        dep.add("78");

        Candidat nc = new Candidat();
        nc.setName("nicolas");
        nc.setPhone("0662094137");
        nc.setCvContends("Ingénieur");
        nc.setEmail("canicatti.nicolas@gmail.com");
        nc.setMobilite(dep);
        nc.setEnterDate(formatDate);
        nc.setPreavis((float) 3);
        nc.setProfiled(false);
        nc.setAutoMaticProfiled(false);

        try {

            Client client = new TransportClient()
                    .addTransportAddress(new InetSocketTransportAddress("10.60.198.75", 9300));
//                    .addTransportAddress(new InetSocketTransportAddress("172.31.4.150", 9301))
//                    .addTransportAddress(new InetSocketTransportAddress("172.31.4.150", 9302));

            ObjectMapper mapper = new ObjectMapper(); // create once, reuse
            CandidatMap candidatMap = new CandidatMap();

//            client.admin().indices().create(new CreateIndexRequest("cvdb")).actionGet();
//            CandidatSettings candidatSettings = new CandidatSettings();
//            client.admin().indices().prepareUpdateSettings().setSettings(candidatSettings.getSettings()).setIndices(
//                    "cvdb").execute().actionGet();
//            client.admin().indices()
//                    .preparePutMapping("cvdb")
//                    .setType("candidat")
//                    .setSource(candidatMap.getMapping())
//                    .execute().actionGet();
//            for (int i = 0; i < 10; i++) {
            byte[] json = mapper.writeValueAsBytes(nc);
            IndexResponse response = client.prepareIndex("cvdb", "candidat")
                    .setSource(json)
                    .execute()
                    .actionGet();
            System.out.println("objet creee: " + response.isCreated());
            nc.setId(response.getId());
            // generate json

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
            experiences.setCandidat(nc);
            experiences.setTecnoList(arrayList);

            PartialCandidat partialCandidat = new PartialCandidat();
            partialCandidat.setId(response.getId());
            partialCandidat.setName(nc.getName());
            
            Comments comments = new Comments();
            comments.setPartialCandidat(partialCandidat);
            comments.setCommentDate(formatDate);
            comments.setComment("blabla bla test");
            
            School school = new School();
            school.setSchool("polytech");
            school.setTitle("M1");
            school.setStart("2001-01-01");
            school.setEnd("2001-09-01");
            school.setPartialCandidat(partialCandidat);
            
            
            byte[] json2 = mapper.writeValueAsBytes(experiences);
            IndexResponse response2 = client.prepareIndex("cvdb", "exp")
                    .setSource(json2)
                    .execute()
                    .actionGet();

            System.out.println("objet creee: " + response2.isCreated());
            
            
            byte[] json3 = mapper.writeValueAsBytes(comments);
            IndexResponse response3 = client.prepareIndex("cvdb", "comments")
                    .setSource(json3)
                    .execute()
                    .actionGet();

            System.out.println("objet creee: " + response3.isCreated());
            
             byte[] json4 = mapper.writeValueAsBytes(school);
            IndexResponse response4 = client.prepareIndex("cvdb", "school")
                    .setSource(json4)
                    .execute()
                    .actionGet();

            System.out.println("objet creee: " + response4.isCreated());
            
            
            client.close();
        } catch (JsonProcessingException exp) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, exp);
        }
    }
    
    
    
    
    
    
}

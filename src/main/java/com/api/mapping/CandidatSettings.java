/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.api.mapping;

import java.io.IOException;

import static org.elasticsearch.common.xcontent.XContentFactory.jsonBuilder;


/*
{
    "settings" : {
        "index" : {
            "number_of_shards" : 5,
            "number_of_replicas" : 1,
            "analysis": {
                "analyzer" : {
                    "default": {
                        "type": "french"
                    }
                }
            }
        }    
    }
}
*/
/**
 *
 * @author t311372
 */
public class CandidatSettings {

    private final String settings;

    public CandidatSettings() throws IOException {

        
          settings = jsonBuilder()
                .startObject()                   
                        .startObject("settings")
                            .startObject("index")
                                .startObject("analysis")
                                    .startObject("analyzer")
                                        .startObject("default")
                                            .field("type" , "french")
                                        .endObject()
                                    .endObject()                                                              
                                .endObject()
                            .endObject()
                        .endObject()                   
                .endObject().toString();              
    }

    public String getSettings() {
        return settings;
    }
    
    
    
}

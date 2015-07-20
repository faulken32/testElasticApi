/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.api.mapping;

import java.io.IOException;
import org.elasticsearch.common.xcontent.XContentBuilder;
import static org.elasticsearch.common.xcontent.XContentFactory.jsonBuilder;

/**
 *
 * @author t311372
 */
public class CandidatMap {

    private final String NOT_ANALYSED = "not_analyzed";
    private final String STRING = "string";

    private final XContentBuilder mapping;
    
  /*  
    {
    "settings" : {
      
            "analysis": {
            "analyzer" : {
"default": {
"type": "french"
}
}
}
}
}
*/
//   candidat mapping
    
    /**
    {   
        "properties": {
          "age": {
            "type": "long"
          },
          "autoMaticProfiled": {
            "type": "boolean"
          },
          "cvContends": {
            "type": "string",
             "analyzer": "french"
          },
          "email": {
            "type": "string",
            "index" : "not_analyzed"

          },
          "enterDate": {
            "type": "date",
            "format": "dateOptionalTime"
          },
          "id": {
            "type": "string",
            "index" : "not_analyzed"
          },
          "mobilite": {
//            "type": "string",
//            "index" : "not_analyzed"
          },
          "name": {
            "type": "string",
            "index" : "not_analyzed"

          },
          "nbYearExp": {
            "type": "double"
          },
          "phone": {
            "type": "string",
            "index" : "not_analyzed"
          },
          "preavis": {
            "type": "double"
          },
          "profiled": {
            "type": "boolean"
          },
          "surname": {
            "type": "string",
            "index" : "not_analyzed"
          },
          "updateDate": {
            "type": "date",
            "format": "dateOptionalTime"
          },
          "status" : {
            "type" : string,
            "index" : "not_analyzed"
           }
        }
      }
    */
 

    public CandidatMap() throws IOException {

        mapping = jsonBuilder()
                .startObject()
                .startObject("candidat")
                .startObject("properties")
                .startObject("email")
                .field("type", this.STRING)
                .field("index", this.NOT_ANALYSED)
                .endObject()
                .endObject()
                .endObject()
                .endObject();

    }

    public XContentBuilder getMapping() {
        return mapping;
    }

}

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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.api;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.html.simpleparser.HTMLWorker;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.Pipeline;
import com.itextpdf.tool.xml.XMLWorker;

import com.itextpdf.tool.xml.XMLWorkerHelper;
import com.itextpdf.tool.xml.html.Tags;
import com.itextpdf.tool.xml.parser.XMLParser;
import com.itextpdf.tool.xml.pipeline.css.CSSResolver;
import com.itextpdf.tool.xml.pipeline.css.CssResolverPipeline;
import com.itextpdf.tool.xml.pipeline.end.PdfWriterPipeline;
import com.itextpdf.tool.xml.pipeline.html.HtmlPipeline;
import com.itextpdf.tool.xml.pipeline.html.HtmlPipelineContext;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author ncanicatti
 */
public class Main {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException, DocumentException {

        Path get = Paths.get("");
        URI u = URI.create("http://localhost:8080/site/elastic/get/AU6wAB3LiDpfl3wwFdA6");
        InputStream openStream = u.toURL().openStream();

        // write the inputStream to a FileOutputStream
        FileOutputStream fileOutputStream = new FileOutputStream(new File("C:\\dev\\index.html"));

        int read = 0;
        byte[] bytes = new byte[1024];

        while ((read = openStream.read(bytes)) != -1) {
            fileOutputStream.write(bytes, 0, read);
        }
//     try (InputStream in = u.toURL().openStream()) {
//         Files.copy(in, get);
//     }
        Document document = new Document();
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("pdf.pdf"));
        document.open();
        HtmlPipelineContext htmlContext = new HtmlPipelineContext(null);

        htmlContext.setTagFactory(Tags.getHtmlTagProcessorFactory());

        CSSResolver cssResolver
                = XMLWorkerHelper.getInstance().getDefaultCssResolver(true);

        Pipeline<?> pipeline
                = new CssResolverPipeline(cssResolver,
                        new HtmlPipeline(htmlContext,
                                new PdfWriterPipeline(document, writer)));

        XMLWorker worker = new XMLWorker(pipeline, true);

        XMLParser p = new XMLParser(worker);

        p.parse(new FileInputStream("C:\\dev\\index.html"));

        // step 1C:\\dev\\index.html
        // step 2
//       
        // step 3
        
        // step 4

//        XMLWorkerHelper.getInstance().parseXHtml(writer, document,
//                new FileInputStream(new File("C:\\dev\\index.html")));
        //step 5
        document.close();

        System.out.println("PDF Created!");
    }
}

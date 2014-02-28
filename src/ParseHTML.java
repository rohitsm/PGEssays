/**
 * Program to parse raw HTML from a URL
 * Created by rohit on 1/29/14.
 */

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.lang.String;

import java.io.IOException;

public class ParseHTML {

    public static Document getPageHTML(String link) throws IOException{
        System.out.println("Link = " + link);
        Document doc = Jsoup.connect(link).get();
        return doc;
    }

    public static Elements getPageContent(Document blogPage) throws IOException{

        Element body = blogPage.body();
        Elements outerTable = body.select("table");
        Elements outerTBody = outerTable.select("tbody");
        Elements outerTR = outerTBody.select("tr");
        Elements outerTD = outerTR.select("td");
        Elements innerTable = outerTD.select("table");
        Elements innerTBody = innerTable.select("tbody");
        Elements innerTR = innerTBody.select("tr");
        Elements innerTD = innerTR.select("td");
        Elements font = innerTD.select("font");
        return font;
    }

}

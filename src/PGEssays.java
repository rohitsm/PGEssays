/**
 * Program to collect Paul Graham's Essays
 * Created by rohit on 1/29/14.
 */

import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class PGEssays {

    static String link = "http://paulgraham.com/articles.html";

    public static void main(String args []) throws IOException{
//        ParseHTML page = new ParseHTML();
        Document page = ParseHTML.getPageHTML(link);

        Element body = page.body();
        Elements outerTable = body.select("table");
        Elements outerTBody = outerTable.select("tbody");
        Elements outerTR = outerTBody.select("tr");
        Elements outerTD = outerTR.select("td");
        Elements innerTable = outerTD.select("table");
        Elements innerTBody = innerTable.select("tbody");
        Elements innerTR = innerTBody.select("tr");
        Elements innerTD = innerTR.select("td");
        Elements font = innerTD.select("font").select("a[href]");
        Elements url = font.select("a[href]");

        //url contains a list of links

        System.out.println("URL = " +url);



    }


}


/**
 * Created by rohit on 1/29/14.
 */

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.lang.String;

import java.io.IOException;

public class ParseHTML {

    public static Document getPageHTML(String link) throws IOException{
        System.out.println("Link = " + link);
        Document doc = Jsoup.connect(link).get();
        return doc;
    }
}

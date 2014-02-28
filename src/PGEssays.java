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
        Elements font = ParseHTML.getPageContent(page);
        Elements url = font.select("a[href]");

        //url contains a list of links

        System.out.println("URL size = " + url.size());
//        System.out.print("URL = " + url);

        for (Element first : url){
            getBlogPost(first);
            break;
        }

//        String title = "<a href=\"ff.html\">Female Founders</a>";
//        getBlogPost(title);

    }

    public static void getBlogPost(Element title) throws IOException{
        // Takes URL and returns the blog content

        String blogPostURL = "http://paulgraham.com/" + title.attr("href");
        String blogPostTitle = title.text();
//        String blogPostDate =;

        Document blogPage = ParseHTML.getPageHTML(blogPostURL);
        Elements font = ParseHTML.getPageContent(blogPage);
        System.out.println("Font: \n\n" + font.first().text());
//        System.out.println("Font: \n\n" + font.parse)

        String text = Jsoup.parse(html.replaceAll("(?i)<br[^>]*>", "br2n")).text();
        text = descrizione.replaceAll("br2n", "\n");

    }
}


/**
 * Program to collect Paul Graham's Essays
 * Created by rohit on 1/29/14.
 */

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class PGEssays {

    static String link = "http://paulgraham.com/articles.html";

    public static void main(String args []) throws IOException{

        int count = 0;

        Document page = ParseHTML.getPageHTML(link);
        Elements font = ParseHTML.getPageContent(page);
        Elements url = font.select("a[href]");

        /* url contains a list of links */
        System.out.println("URL size = " + url.size());

        for (Element first : url){
            System.out.print("Post No: " + count);
            getBlogPost(first);
            count++;
        }

        System.out.print("End Main");
    }

    public static void getBlogPost(Element title) throws IOException{

        /* Takes URL and returns the blog content */

        String blogPostURL = "http://paulgraham.com/" + title.attr("href");
        String blogPostTitle = title.text();
        System.out.println(" Title: " + blogPostTitle);

        try{
            Document blogPage = ParseHTML.getPageHTML(blogPostURL);
            blogPage.select("br").append("\\n");
            String blogPost = blogPage.text().replace("\\n", "\n");
            writeToFile(blogPostTitle, blogPost);

            System.out.println("Done getBlogPost");

        } catch (IOException e){
            e.printStackTrace();
        }

    }

    public static void writeToFile(String blogPostTitle, String blogPost){

        String fileName = blogPostTitle;
        try{
            File file = new File("content/"+fileName+".txt");

            /* If file doesn't exist, then create it */
            if(!file.exists()){
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(blogPost);
            bw.close();

        }catch (IOException e) {
            e.printStackTrace();

        }
    }
}
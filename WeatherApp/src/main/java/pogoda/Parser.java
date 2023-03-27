/**
 * Greate class Parser
 *
 * @author Valentyn Mozul
 * @version 1.0 from 26.03.2023
 */

package src.main.java.pogoda;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    private static Document getPage() throws IOException {
        String url = "https://www.gismeteo.ua/ua/";
        Document page = Jsoup.parse(new URL(url), 3000);
        return page;
    }

    //Нд, 26 березня, 22:15
    //26 березня
    //
    private static Pattern pattern = Pattern.compile("\\d{2}\\s\\W{7}");

    private static String getDateFromString(String stringDate) throws Exception {
        Matcher matcher = pattern.matcher(stringDate);
        if (matcher.find()) {
            return matcher.group();
        }
        throw new Exception("Can't extract date from string!");
    }

    /**
     * Program entry point.
     *
     * @param args command Line arguments
     */
    public static void main(String[] args) throws Exception {
        Document page = getPage();
        //css query language
        Element divWth = page.select("div[class=frame-now]").first();
        String names = divWth.select("div[class=current-time]").text();
        Elements label = divWth.select("div[class=item-label]");
        Elements value = divWth.select("div[class=item-value]");
        String date = getDateFromString(names);
        System.out.println(date + " Температура    Вітер    Тиск    Вологість    Вода");
    }
}

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

import java.io.IOException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    private static Document getPage() throws IOException {
        String url = "https://www.gismeteo.ua/ua/";
        return Jsoup.parse(new URL(url), 3000);
//        Document page = Jsoup.parse(new URL(url), 3000);
//        return page;
    }

    //Нд, 26 березня, 22:15
    private static final Pattern pattern = Pattern.compile("\\d{2}\\s\\W{7}");

    private static String getDateFromString(String stringDate) throws Exception {
        Matcher matcher = pattern.matcher(stringDate);
        if (matcher.find()) {
            return matcher.group();
        }
        throw new Exception("Can't extract date from string!");
    }

    private static String getValues(String values, int index) {
        String string = "";
        String[] arrayString = values.split(" ");
        for (int i = 0; i < arrayString.length; i++) {
            string = arrayString[index];
        }
        return string;
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
        assert divWth != null;
        String names = divWth.select("div[class=current-time]").text();
        //Elements label = divWth.select("div[class=item-label]");
        String value = divWth.select("div[class=item-value]").text();
        String date = getDateFromString(names);
        System.out.println("Погода Gismeteo " + date + "\nТемпература = " + getValues(value, 0)
                + ";\nВітер = " + getValues(value, 2) + " м/с"
                + ";\nТиск = " + getValues(value, 8) + " мм рт. ст."
                + ";\nВологість = " + getValues(value, 14) + " %"
                + ";\nВода = " + getValues(value, 18) + ".");
    }
}

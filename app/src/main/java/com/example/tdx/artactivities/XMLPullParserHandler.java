package com.example.tdx.artactivities;


import android.util.Log;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tdx on 9/17/15.
 */


import android.util.Log;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tdx on 9/17/15.
 */
public class XMLPullParserHandler {

    List<Card> cards;

    private Card card;
    private String text;

    public XMLPullParserHandler() {
        cards = new ArrayList<Card>();

    }

    public List<Card> getCards() {
        return cards;
    }

    public List<Card> parse(InputStream is) {

        XmlPullParserFactory factory = null;
        XmlPullParser parser = null;

        try {
            factory = XmlPullParserFactory.newInstance();
            factory.setNamespaceAware(true);

            parser = factory.newPullParser();
            parser.setInput(is, null);

            int eventType = parser.getEventType();
            while(eventType != XmlPullParser.END_DOCUMENT) {
                String tagname = parser.getName();
                switch (eventType) {
                    case XmlPullParser.START_TAG:

                        if (tagname.equalsIgnoreCase("card")) {
                            card = new Card();
                            Log.d("my app", "new card");
                        }
                        break;
                    case XmlPullParser.TEXT:
                        text = parser.getText();
                        break;

                    case XmlPullParser.END_TAG:

                        if (tagname.equalsIgnoreCase("card")) {
                            cards.add(card);
                            Log.d("myapp", "add card");
                        } else if (tagname.equalsIgnoreCase("name")) {
                            card.setName(text);
                        } else if (tagname.equalsIgnoreCase("id")) {
                            card.setId(Integer.parseInt(text));
                        } else if (tagname.equalsIgnoreCase("month")) {
                            card.setMonth(text);
                        } else if (tagname.equalsIgnoreCase("description")) {
                            card.setDescription(text);
                        } else if (tagname.equalsIgnoreCase("step")) {
                            card.addDirection(text);
                        } else if (tagname.equalsIgnoreCase("item")) {
                            card.addMaterial(text);
                        }
                        break;

                    default:
                        break;
                }
                eventType = parser.next();
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return cards;
    }
}

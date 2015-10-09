package com.example.tdx.artactivities;

import android.content.Context;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tdx on 10/9/15.
 */
public class Cards {

    List<Card> cards;

    public Cards(Context context) {

        try {
            XMLPullParserHandler parser = new XMLPullParserHandler();
            cards = parser.parse(context.getAssets().open("cards.xml"));
        } catch(IOException e) {
            e.printStackTrace();
        }

    }

    public List<Card> getCards() {
        return cards;
    }

    public List<Card> getCards(String month) {

        if (month.toLowerCase().contains("all")) { return cards; }

        List<Card> rtnCards = new ArrayList<Card>();
        for (Card curCard : cards) {
            if (curCard.getMonth().toLowerCase().contains(month.toLowerCase())) { rtnCards.add(curCard); }
        }

        return rtnCards;
    }

    public List<Card> search(String[] names, String[] materials) {
        // todo add code to serach by name and materials and return that.
        return cards;

    }

}

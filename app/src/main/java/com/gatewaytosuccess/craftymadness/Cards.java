package com.gatewaytosuccess.craftymadness;

import android.content.Context;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Tyler Decker on 10/9/15.
 */
public class Cards {

    List<Card> cards;
    private Random rnd;

    public Cards(Context context) {

        rnd = new Random();
        try {
            XMLPullParserHandler parser = new XMLPullParserHandler();
            cards = parser.parse(context.getAssets().open("cards.xml"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public int getSize() { return cards.size();}

    public Card getRandomCard() {

        int index = rnd.nextInt(cards.size());
        return cards.get(index);
    }


    public List<Card> getCards() {
        return cards;
    }

    public List<Card> getCards(String month) {

        if (month.toLowerCase().contains("all")) {
            return cards;
        }

        List<Card> rtnCards = new ArrayList<Card>();
        for (Card curCard : cards) {
            if (curCard.getMonth().toLowerCase().contains(month.toLowerCase())) {
                rtnCards.add(curCard);
            }
        }

        return rtnCards;
    }

    public List<Card> search(String term) {

        return search(term, term);
    }

    public List<Card> search(String name, String materials) {
        List<Card> rtnCards = new ArrayList<Card>();
        List<String> listMatierals = null;
        boolean curFound = false;

        for (Card curCard : cards) {
            if (!name.isEmpty() && curCard.toString().toLowerCase().contains(name.toLowerCase())) {
                rtnCards.add(curCard);
                continue;
            }

            if (!materials.isEmpty()) {
                listMatierals = curCard.getMaterials_List();
                for (String item : listMatierals) {

                    if (item.toLowerCase().contains(materials.toLowerCase())) {
                        rtnCards.add(curCard);
                        break;
                    }
                }
            }

        }
        return rtnCards;
    }
}


package com.example.tdx.artactivities;

import android.content.Context;
import android.util.Log;
import android.widget.Switch;

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
        } catch (IOException e) {
            e.printStackTrace();
        }

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


    public List<Card> getCards(int month) {

        switch (month) {
            case 1:
                return getCards("jan");

            case 2:
                return getCards("feb");

            case 3:
                return getCards("mar");

            case 4:
                return getCards("apr");

            case 5:
                return getCards("may");

            case 6:
                return getCards("jun");

            case 7:
                return getCards("jul");

            case 8:
                return getCards("aug");

            case 9:
                return getCards("sep");

            case 10:
                return getCards("oct");

            case 11:
                return getCards("nov");

            case 12:
                return getCards("dec");

        }
        return getCards();
    }

    public List<Card> search(String name, String materials) {
        List<Card> rtnCards = new ArrayList<Card>();
        List<String> listMatierals = null;
        boolean curFound = false;

        for (Card curCard : cards) {

            Log.d("&&&&&&&&&&&&&&", curCard.toString().toLowerCase());
            Log.d("### sName =", name);


            if (!name.isEmpty() && curCard.toString().toLowerCase().contains(name.toLowerCase())) {
                Log.d("^^^^^^^^^^^^^^^^^", "add");
                rtnCards.add(curCard);
                continue;
            }

            if (!materials.isEmpty()) {
                listMatierals = curCard.getMaterials_List();
                for (String item : listMatierals) {
                    Log.d("-----------", item.toLowerCase());
                    Log.d("### sMaterials=", materials.toLowerCase());


                    if (item.toLowerCase().contains(materials.toLowerCase())) {
                        Log.d("$$$$$$$$$$$$$$$$$", "add");
                        rtnCards.add(curCard);
                        break;
                    }
                }
            }

        }
        return rtnCards;
    }
}


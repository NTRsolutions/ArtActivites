package com.gatewaytosuccess.craftymadness;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Tyler Decker on 10/8/15.
 */
public class CardListAdapter extends ArrayAdapter<Card> {


    Context context;
    int layoutResourceId;

    List<Card> data = null;


    public CardListAdapter(Context context, int layoutResourceId, List<Card> data) {
        super(context, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.data = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        CardHolder holder = null;

        if(row == null)
        {
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);

            holder = new CardHolder();
            holder.imgIcon = (ImageView)row.findViewById(com.gatewaytosuccess.craftymadness.R.id.list_row_icon);
            holder.txtTitle = (TextView)row.findViewById(com.gatewaytosuccess.craftymadness.R.id.list_row_name);
            holder.txtDescription = (TextView)row.findViewById(com.gatewaytosuccess.craftymadness.R.id.list_row_description);

            row.setTag(holder);
        }
        else
        {
            holder = (CardHolder)row.getTag();
        }

        Card card = data.get(position);
        holder.txtTitle.setText(card.getName());
        holder.imgIcon.setImageResource(card.getImageID(getContext()));
        holder.txtDescription.setText(card.getDescription());

        return row;
    }

    static class CardHolder
    {
        ImageView imgIcon;
        TextView txtTitle;
        TextView txtDescription;

    }
}
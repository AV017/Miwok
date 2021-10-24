package com.example.miwok;

import android.app.Activity;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word> {
    private int mColorResourceId;

    public WordAdapter(Activity context , ArrayList<Word> w,int ColorResourceId){
        super(context,0,w);
        mColorResourceId = ColorResourceId;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listViewItem = convertView;

        if(listViewItem == null){
            listViewItem = LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);
        }

        Word currentword = getItem(position);
        TextView miwokTextView = (TextView)listViewItem.findViewById(R.id.miwok_text_view);
        miwokTextView.setText(currentword.getmMiwokTranslation());

        TextView defaultTextView = (TextView)listViewItem.findViewById(R.id.default_text_view);
        defaultTextView.setText(currentword.getmDefaultTranslation());

        ImageView image = (ImageView)listViewItem.findViewById(R.id.image);
        if(currentword.hasImage()) {
            image.setImageResource(currentword.getImageResourceId());
            image.setVisibility(View.VISIBLE);
        }
        else{
            image.setVisibility(View.GONE);
        }

        View textContainer = listViewItem.findViewById(R.id.text_container);
        int color = ContextCompat.getColor(getContext(),mColorResourceId);
        textContainer.setBackgroundColor(color);


        return listViewItem;
    }
}

package com.example.rollcount2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CustomList extends ArrayAdapter<Game> {

    private ArrayList<Game> rolls;
    private Context context;

    public CustomList(Context context, ArrayList<Game> rolls) {
        super(context, 0, rolls);
        this.rolls = rolls;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;

        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.content, parent, false);
        }

        Game game = rolls.get(position);

        //Finding game name and number of rolls in content.xml
        TextView gameName = view.findViewById(R.id.game_name_text);
        TextView numberOfRolls = view.findViewById(R.id.number_of_rolls_text);

        //Appling these values to the customelist
        gameName.setText(game.getGameName());
        numberOfRolls.setText(game.getNumberOfRolls());

        return view;
    }
}

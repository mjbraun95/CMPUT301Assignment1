package com.example.rollcount2;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class AddGameFragment extends DialogFragment {

    private EditText gameName;
    private EditText dicePerRoll;
    private EditText sidesPerDie;
    private EditText dateCreated;
    private OnFragmentInteractionListener listener;

    public interface OnFragmentInteractionListener {
        void onOkPressed(String gameNameString, String dicePerRollString, String sidesPerDieString, String dateCreatedString);
    }

//    @Override
//    public void onOkPressed(Game newGame) {
//        gameAdapter.add(game);
//    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        // Inflate the layout for this fragment
        if (context instanceof OnFragmentInteractionListener) {
            listener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.add_game_fragment_layout, null);

        //EditTexts - editable text boxes w blinking cursor
        gameName = view.findViewById(R.id.game_name_editText);
        dicePerRoll = view.findViewById(R.id.dice_per_roll_editText);
        sidesPerDie = view.findViewById(R.id.sides_per_die_editText);
        dateCreated = view.findViewById(R.id.date_started_editText);
//        Game game = savedInstanceState.
//        newInstance()

        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        return builder
            .setView(view)
            .setTitle("New game")
            .setNegativeButton("Cancel", null)
            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                //When OK is pressed
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
//                    gameName.setText();

                    String gameNameString = gameName.getText().toString();
                    String dicePerRollString = dicePerRoll.getText().toString();
                    String sidesPerDieString = sidesPerDie.getText().toString();
                    String dateCreatedString = dateCreated.getText().toString();
                    listener.onOkPressed(gameNameString, dicePerRollString, sidesPerDieString, dateCreatedString);
                }
            }).create();

    }

    static AddGameFragment newInstance(Game game) {
        Bundle args = new Bundle();
        args.putSerializable("game", game);

        AddGameFragment fragment = new AddGameFragment();
        fragment.setArguments(args);
        return fragment;
    }

}

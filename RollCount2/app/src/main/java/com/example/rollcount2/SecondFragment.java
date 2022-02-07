package com.example.rollcount2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.rollcount2.databinding.FragmentSecondBinding;
import com.google.android.material.snackbar.Snackbar;

public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;

    private TextView gameName, dicePerRoll, sidesPerDie, dateCreated;

    //https://stackoverflow.com/questions/34963505/change-fragments-when-button-is-clicked
    public SecondFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.add_game_fragment_layout, null);
        binding = FragmentSecondBinding.inflate(inflater, container, false);

        gameName = binding.gameNameText;
        dicePerRoll = binding.numberOfDicePerTurnText;
        sidesPerDie = binding.sidesPerDieText;
        dateCreated = binding.dateCreatedText;
        gameName.setText("Game Name: ");

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_FirstFragment);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    static SecondFragment newInstance(Game game) {
        Bundle args = new Bundle();
        args.putSerializable("game", game);

        SecondFragment fragment = new SecondFragment();
        fragment.setArguments(args);
        return fragment;
    }

}
package com.example.rollcount2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.fragment.NavHostFragment;

import com.example.rollcount2.databinding.FragmentFirstBinding;
import com.google.android.material.navigation.NavigationView;

public class FirstFragment extends Fragment implements AddGameFragment.OnFragmentInteractionListener {
// implements AddGameFragment.OnFragmentInteractionListener
    private FragmentFirstBinding binding;

    //https://stackoverflow.com/questions/34963505/change-fragments-when-button-is-clicked
    public FirstFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonFirst.setOnClickListener((v) -> {
            new AddGameFragment().show(getChildFragmentManager(), "NEW_GAME");
        });

//        binding.buttonFirst.setOnClickListener(new View.OnClickListener() {
//
//            //Click "New Game"
//            @Override
//            public void onClick(View view) {
//                NavHostFragment.findNavController(FirstFragment.this)
//                        .navigate(R.id.action_FirstFragment_to_AddGameFragment);
//            }
//        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    //Click "New Game"
    @Override
    public void onOkPressed(String gameNameString, String dicePerRollString, String sidesPerDieString, String numberOfRollsString, String dateCreatedString) {}

    //https://stackoverflow.com/questions/34963505/change-fragments-when-button-is-clicked
    @Override
    public void changeFragment(int id){
//        if (id == 1) {
//            FirstFragment fragment = new FirstFragment();
//            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
//            ft.replace(R.id.nav_host_fragment_content_main, fragment);
//            ft.commit();
//        }
//        else if (id == 2) {
//            SecondFragment fragment = new SecondFragment();
//            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
//            ft.replace(R.id.nav_host_fragment_content_main, fragment);
//            ft.commit();
//        }
    }
}
package com.example.rollcount2;

import android.os.Bundle;

import com.example.rollcount2.databinding.AddGameFragmentLayoutBinding;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.rollcount2.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AddGameFragment.OnFragmentInteractionListener {
//public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;

    ListView gameList;
    ArrayAdapter<Game> gameAdapter;
    ArrayList<Game> gameDataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        binding2 = AddGameFragmentLayoutBinding.inflate()
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setSupportActionBar(binding.toolbar);

        gameList = findViewById(R.id.game_list);

        String []gameNames = {"Game1", "Game2", "Game3"};
        String []dicePerRoll = {"1", "2", "3"};
        String []sidesPerDie = {"2", "3", "4"};

        gameDataList = new ArrayList<>();
        for (int i=0; i<gameNames.length; i++) {
            gameDataList.add(new Game(gameNames[i], dicePerRoll[i], sidesPerDie[i]));
        }
        gameAdapter = new CustomList(this, gameDataList);
        gameList.setAdapter(gameAdapter);

        //Load content_main
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

        //When clicked on a Game
        gameList.setOnItemClickListener((adapterView,view,position,id) -> {
//            (new AddGameFragment().newInstance(gameAdapter.getItem(position))).show(getSupportFragmentManager(), "ADD_GAME");
            navController.navigate(R.id.action_FirstFragment_to_SecondFragment);
        });

//        binding.fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }

    @Override
    public void onOkPressed(Game game) {
        gameAdapter.add(game);
//        NavHostFragment.findNavController(navControl)
//                .navigate(R.id.action_AddGameFragment_to_SecondFragment);
    }
}
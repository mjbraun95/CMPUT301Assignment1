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
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AddGameFragment.OnFragmentInteractionListener {
//public class MainActivity extends AppCompatActivity {

//    private static final String SQL_CREATE_ENTRIES =
//            "CREATE TABLE " + FeedReaderContract.FeedEntry.TABLE_NAME + " (" +
//                    FeedReaderContract.FeedEntry._ID + " INTEGER PRIMARY KEY," +
//                    FeedReaderContract.FeedEntry.COLUMN_NAME_TITLE + " TEXT," +
//                    FeedReaderContract.FeedEntry.COLUMN_NAME_SUBTITLE + " TEXT)";
//
//    private static final String SQL_DELETE_ENTRIES =
//            "DROP TABLE IF EXISTS " + FeedReaderContract.FeedEntry.TABLE_NAME;

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;

    ListView gameList;
    ArrayAdapter<Game> gameAdapter;
    ArrayList<Game> gameDataList;

    private EditText gameNameEdt, dicePerRollEdt, sidesPerDieEdt, dateCreatedEdt;
    private Button addGameBtn;
    private DBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        binding2 = AddGameFragmentLayoutBinding.inflate()

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setSupportActionBar(binding.toolbar);

        // creating a new dbhandler class
        // and passing our context to it.
        dbHandler = new DBHandler(MainActivity.this);

        gameList = findViewById(R.id.game_list);
        String []gameNames = {"Game1", "Game2", "Game3"};
        String []dicePerRoll = {"1", "2", "3"};
        String []sidesPerDie = {"2", "3", "4"};
        String []dateCreated = {"Jan 31st", "Feb 1st", "Feb 2nd"};
        gameDataList = new ArrayList<>();
        for (int i=0; i<gameNames.length; i++) {
            gameDataList.add(new Game(gameNames[i], dicePerRoll[i], sidesPerDie[i], dateCreated[i]));
        }
        gameAdapter = new CustomList(this, gameDataList);
        gameList.setAdapter(gameAdapter);
        //Get navController
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        //When clicked on a Game
        gameList.setOnItemClickListener((adapterView,view,position,id) -> {
//            (new AddGameFragment().newInstance(gameAdapter.getItem(position))).show(getSupportFragmentManager(), "ADD_GAME");
            navController.navigate(R.id.action_FirstFragment_to_SecondFragment);
        });

//        addGameBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                // below line is to get data from all edit text fields.
//                String gameNameString = gameNameEdt.getText().toString();
//                String dicePerRollString = dicePerRollEdt.getText().toString();
//                String sidesPerDieString = sidesPerDieEdt.getText().toString();
//                String dateCreatedString = dateCreatedEdt.getText().toString();
//
//                // validating if the text fields are empty or not.
//                if (gameNameString.isEmpty() && dicePerRollString.isEmpty() && sidesPerDieString.isEmpty() && dateCreatedString.isEmpty()) {
//                    Toast.makeText(MainActivity.this, "Please enter all the data..", Toast.LENGTH_SHORT).show();
//                    return;
//                }
//
//                // on below line we are calling a method to add new
//                // game to sqlite data and pass all our values to it.
//                dbHandler.addNewGame(gameNameString, dicePerRollString, sidesPerDieString, dateCreatedString);
//
//                // after adding the data we are displaying a toast message.
//                Toast.makeText(MainActivity.this, "Game has been added.", Toast.LENGTH_SHORT).show();
//                gameNameEdt.setText("");
//                sidesPerDieEdt.setText("");
//                dicePerRollEdt.setText("");
//                dateCreatedEdt.setText("");
//            }
//        });


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
    public void onOkPressed(String gameNameString, String dicePerRollString, String sidesPerDieString, String dateCreatedString) {
//        // initializing all our variables.
//        gameNameEdt = findViewById(R.id.game_name_editText);
//        dicePerRollEdt = findViewById(R.id.dice_per_roll_editText);
//        sidesPerDieEdt = findViewById(R.id.sides_per_die_editText);
//        dateCreatedEdt = findViewById(R.id.date_started_editText);
//        addGameBtn = findViewById(R.id.idBtnAddGame);
//        // below line is to get data from all edit text fields.
//        String gameNameString = game.getGameName();
//        String dicePerRollString = game.getDicePerRoll();
//        String sidesPerDieString = game.getSidesPerDie();
//        String dateCreatedString = game.getDateStarted();

        // validating if the text fields are empty or not.
        if (gameNameString.isEmpty() || dicePerRollString.isEmpty() || sidesPerDieString.isEmpty() || dateCreatedString.isEmpty()) {
            Toast.makeText(MainActivity.this, "Please enter all the data..", Toast.LENGTH_SHORT).show();
            return;
        }
        gameAdapter.add(new Game(gameNameString, dicePerRollString, sidesPerDieString, dateCreatedString));
        // on below line we are calling a method to add new
        // game to sqlite data and pass all our values to it.
        dbHandler.addNewGame(gameNameString, dicePerRollString, sidesPerDieString, dateCreatedString);

//        // after adding the data we are displaying a toast message.
        Toast.makeText(MainActivity.this, (gameNameString + " has been added."), Toast.LENGTH_SHORT).show();


//        NavHostFragment.findNavController(navControl)
//                .navigate(R.id.action_AddGameFragment_to_SecondFragment);
    }
}
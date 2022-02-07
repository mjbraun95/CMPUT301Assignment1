package com.example.rollcount2;


import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHandler extends SQLiteOpenHelper {

    // creating a constant variables for our database.
    // below variable is for our database name.
    private static final String DB_NAME = "gamedb";

    // below int is our database version
    private static final int DB_VERSION = 1;

    // below variable is for our table name.
    private static final String TABLE_NAME = "MyGames";

    // below variable is for our id column.
    private static final String ID_COL = "ID";

    // below variable is for our game name column
    private static final String NAME_COL = "GameName";

    // below variable id for our game duration column.
    private static final String DICE_PER_ROLL_COL = "DicePerRoll";

    // below variable for our game description column.
    private static final String SIDES_PER_DIE_COL = "SidesPerDie";

    // below variable is for our game tracks column.
    private static final String DATE_STARTED_COL = "DateStarted";

    // creating a constructor for our database handler.
    public DBHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    // below method is for creating a database by running a sqlite query
    @Override
    public void onCreate(SQLiteDatabase db) {
        // on below line we are creating
        // an sqlite query and we are
        // setting our column names
        // along with their data types.
        String query = "CREATE TABLE " + TABLE_NAME + " ("
                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + NAME_COL + " TEXT,"
                + DICE_PER_ROLL_COL + " TEXT,"
                + SIDES_PER_DIE_COL + " TEXT,"
                + DATE_STARTED_COL + " TEXT)";

        // at last we are calling a exec sql
        // method to execute above sql query
        db.execSQL(query);
    }

    // this method is use to add new game to our sqlite database.
    public void addNewGame(String gameName, String dicePerRoll, String sidesPerDie, String dateStarted) {

        // on below line we are creating a variable for
        // our sqlite database and calling writable method
        // as we are writing data in our database.
        SQLiteDatabase db = this.getWritableDatabase();

        // on below line we are creating a
        // variable for content values.
        ContentValues values = new ContentValues();

        // on below line we are passing all values
        // along with its key and value pair.
        values.put(NAME_COL, gameName);
        values.put(DICE_PER_ROLL_COL, dicePerRoll);
        values.put(SIDES_PER_DIE_COL, sidesPerDie);
        values.put(DATE_STARTED_COL, dateStarted);

        // after adding all values we are passing
        // content values to our table.
        db.insert(TABLE_NAME, null, values);

        // at last we are closing our
        // database after adding database.
        db.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // this method is called to check if the table exists already.
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
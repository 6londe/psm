package blonde.psm.model.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import blonde.psm.model.schema.Title;
import blonde.psm.model.enums.Genre;
import blonde.psm.model.enums.Platform;

public class SQLiteHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "psm";
    private static final String TABLE_NAME = "titles";

    private static final String KEY_ID = "id";
    private static final String KEY_PLATFORM = "platform";
    private static final String KEY_NAME = "name";
    private static final String KEY_GENRE = "genre";
    private static final String KEY_PUBLISHER = "publisher";
    private static final String KEY_DATE = "date";

    public SQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(
            "CREATE TABLE " + TABLE_NAME + " ("
            + KEY_ID + " TEXT PRIMARY KEY, "
            + KEY_PLATFORM + " INTEGER, "
            + KEY_NAME + " TEXT, "
            + KEY_GENRE + " INTEGER, "
            + KEY_PUBLISHER + " TEXT, "
            + KEY_DATE + " INTEGER "
            + ")"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public Title getTitle(int id) {

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(
                "SELECT " + KEY_PLATFORM + ", " + KEY_NAME + ", " + KEY_GENRE + ", " + KEY_PUBLISHER + ", " + KEY_DATE +
                " FROM " + TABLE_NAME +
                " WHERE " + KEY_ID + " = " + id, null);

        Title title = null;

        if (cursor.moveToFirst()) {
            title = new Title(
                    Platform.values()[cursor.getInt(0)],
                    cursor.getString(1),
                    Genre.values()[cursor.getInt(2)],
                    cursor.getString(3),
                    cursor.getInt(4)
            );
        }
        cursor.close();
        db.close();

        return title;
    }

    public boolean setTitle(Title title) {

        try {
            SQLiteDatabase db = this.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put(KEY_ID, title.get_id());
            values.put(KEY_PLATFORM, title.get_platform().getValue());
            values.put(KEY_NAME, title.get_name());
            values.put(KEY_GENRE, title.get_genre().getValue());
            values.put(KEY_PUBLISHER, title.get_publisher());
            values.put(KEY_DATE, title.get_date());

            db.insert(TABLE_NAME, null, values);
            db.close();
            return true;
        }
        catch(Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void resetTable() {
        SQLiteDatabase db = this.getWritableDatabase();

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        db.execSQL(
                "CREATE TABLE " + TABLE_NAME + " ("
                        + KEY_ID + " TEXT PRIMARY KEY, "
                        + KEY_PLATFORM + " INTEGER, "
                        + KEY_NAME + " TEXT, "
                        + KEY_GENRE + " INTEGER, "
                        + KEY_PUBLISHER + " TEXT, "
                        + KEY_DATE + " INTEGER "
                        + ")"
        );
        db.close();
    }

}

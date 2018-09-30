package blonde.psm.db;

import android.content.Context;
import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import blonde.psm.db.schema.Title;
import blonde.psm.enums.Genre;
import blonde.psm.enums.Platform;

public class DataImporter {

    private Context mContext;
    private DatabaseHelper databaseHelper;
    private static String TAG = DataImporter.class.getSimpleName();

    public DataImporter(Context context) {
        this.mContext = context;
        this.databaseHelper = new DatabaseHelper(context);
    }

    public boolean importData(Platform platform) {

        Genre[] genres = Genre.values();

        InputStream inputStream = mContext.getResources().openRawResource(platform.getRawId());
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String line;

        try {
            while ((line = bufferedReader.readLine()) != null) {

                StringTokenizer tokens = new StringTokenizer(line, ",");

                String name = tokens.nextToken();
                Genre genre = genres[Integer.parseInt(tokens.nextToken())];
                String publisher = tokens.nextToken();
                int date = Integer.parseInt(tokens.nextToken());

                Title title = new Title(platform, name, genre, publisher, date);
                databaseHelper.setTitle(title);
            }

            Log.e(TAG, "Data Imported: " + platform);

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

}

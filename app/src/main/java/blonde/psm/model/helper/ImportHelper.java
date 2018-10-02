package blonde.psm.model.helper;

import android.content.Context;
import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import blonde.psm.model.schema.Title;
import blonde.psm.model.enums.Genre;
import blonde.psm.model.enums.Platform;

public class ImportHelper {

    private Context mContext;
    private SQLiteHelper SQLiteHelper;
    private static String TAG = ImportHelper.class.getSimpleName();

    public ImportHelper(Context context) {
        this.mContext = context;
        this.SQLiteHelper = new SQLiteHelper(context);
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
                SQLiteHelper.setTitle(title);
            }

            Log.e(TAG, "Data Imported: " + platform);

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

}

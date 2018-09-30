package blonde.psm.db.schema;

import blonde.psm.enums.Genre;
import blonde.psm.enums.Platform;

public class Title {

    private String _id;
    private Platform _platform;
    private String _name;
    private Genre _genre;
    private String _publisher;
    private int _date;

    public Title(Platform platform, String name, Genre genre, String publisher, int date) {

        this._platform = platform;
        this._name = name;
        this._genre = genre;
        this._publisher = publisher;
        this._date = date;
        this._id = getTitleId(this);
    }

    public static String getTitleId(Title title) {

        // FIXME id creation logic
        return ""
                + title._platform
                + title._name.charAt(0)
                + title._name.charAt(title.get_name().length() - 1)
                + title._genre
                + title._publisher.charAt(0)
                + title._date;
    }

    public String get_id() {
        return _id;
    }

    public Platform get_platform() {
        return _platform;
    }

    public String get_name() {
        return _name;
    }

    public Genre get_genre() {
        return _genre;
    }

    public String get_publisher() {
        return _publisher;
    }

    public int get_date() {
        return _date;
    }

}
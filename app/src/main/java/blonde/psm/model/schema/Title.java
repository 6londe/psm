package blonde.psm.model.schema;

import blonde.psm.model.enums.Genre;
import blonde.psm.model.enums.Platform;

public class Title {

    private Platform _platform;
    private String _name;
    private Genre _genre;
    private String _publisher;

    public Title(Platform platform, String name, Genre genre, String publisher) {

        this._platform = platform;
        this._name = name;
        this._genre = genre;
        this._publisher = publisher;
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

}
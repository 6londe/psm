package blonde.psm.model.schema;

import blonde.psm.model.enums.Genre;
import blonde.psm.model.enums.Platform;

public class Title {

    private Platform platform;
    private String name;
    private Genre genre;
    private String publisher;
    private int image;

    public Title(Platform platform, String name, Genre genre, String publisher, int image) {

        this.platform = platform;
        this.name = name;
        this.genre = genre;
        this.publisher = publisher;
        this.image = image;
    }

    public Platform getPlatform() {
        return platform;
    }

    public String getName() {
        return name;
    }

    public Genre getGenre() {
        return genre;
    }

    public String getPublisher() {
        return publisher;
    }

    public int getImage() {
        return image;
    }

}
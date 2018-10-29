package blonde.psm.model.schema;

import android.os.Parcel;
import android.os.Parcelable;

import blonde.psm.model.enums.Genre;
import blonde.psm.model.enums.Platform;

public class Title implements Parcelable {

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

    private Title(Parcel parcel) {
        platform = Platform.values()[parcel.readInt()];
        name = parcel.readString();
        genre = Genre.values()[parcel.readInt()];
        publisher = parcel.readString();
        image = parcel.readInt();
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(platform.getValue());
        parcel.writeString(name);
        parcel.writeInt(genre.getValue());
        parcel.writeString(publisher);
        parcel.writeInt(image);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Parcelable.Creator<Title> CREATOR = new Parcelable.Creator<Title>() {

        @Override
        public Title createFromParcel(Parcel parcel) {
            return new Title(parcel);
        }

        @Override
        public Title[] newArray(int size) {
            return new Title[size];
        }
    };

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
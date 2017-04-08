package asim.net.tourguide;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

/**
 * Created by asimaltwijry on 4/6/17.
 */

public class Location implements Parcelable {
    private int title;
    private int body;
    private int image;
    private int phoneNumber;
    private String mode;

    public Location(Parcel in){
        super();
        readFromParcel(in);

    }
    public Location(int title, int body, int image, int phoneNumber, String mode) {
        //for historical sites
        this.title = title;
        this.body = body;
        this.image = image;
        this.mode = mode;
        this.phoneNumber = phoneNumber;

    }

    public String getMode() {
        return mode;
    }

    public int getTitle() {

        return title;
    }

    public int getBody() {
        return body;
    }

    public int getImage() {
        return image;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }



    @Override
    public String toString() {
        return "location{" +
                "title='" + title + '\'' +
                ", body='" + body + '\'' +
                ", image=" + image +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }

    public static final Parcelable.Creator<Location> CREATOR = new Parcelable.Creator<Location>() {
        public Location createFromParcel(Parcel in) {
            return new Location(in);
        }

        public Location[] newArray(int size) {

            return new Location[size];
        }

    };

    public void readFromParcel(Parcel in) {
        title = in.readInt();
        body = in.readInt();
        image = in.readInt();
        phoneNumber = in.readInt();
        mode = in.readString();
        Log.v("Hey","readFromParcel: "+mode);

    }
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int i) {
        dest.writeInt(title);
        dest.writeInt(body);
        dest.writeInt(image);
        dest.writeInt(phoneNumber);
        dest.writeString(mode);
        Log.v("Hey","writeToParcel");


    }
}
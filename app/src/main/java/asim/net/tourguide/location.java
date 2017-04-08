package asim.net.tourguide;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

/**
 * Created by asimaltwijry on 4/6/17.
 */

public class location implements Parcelable {
    private int title;
    private int body;
    private int image;
    private String phoneNumber;
    private String mode;

    public location(Parcel in){
        super();
        readFromParcel(in);

    }
    public location(int title, int body, int image) {
        //for historical sites
        this.title = title;
        this.body = body;
        this.image = image;
        this.mode = "Historical";

    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public location(int title, int image, String phoneNumber) {
        //for Restaurants and hotels.
        this.title = title;
        this.image = image;
        this.phoneNumber = phoneNumber;
        this.mode = "Restaurants";

    }

    public void setTitle(int title) {
        this.title = title;
    }

    public void setBody(int body) {
        this.body = body;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public boolean hasBody() {
        return body != 0;
    }

    public boolean hasPhoneNumber() {
        return phoneNumber != null;
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

    public static final Parcelable.Creator<location> CREATOR = new Parcelable.Creator<location>() {
        public location createFromParcel(Parcel in) {
            return new location(in);
        }

        public location[] newArray(int size) {

            return new location[size];
        }

    };

    public void readFromParcel(Parcel in) {
        title = in.readInt();
        body = in.readInt();
        image = in.readInt();
        phoneNumber = in.readString();
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
        dest.writeString(phoneNumber);
        dest.writeString(mode);
        Log.v("Hey","writeToParcel");


    }
}

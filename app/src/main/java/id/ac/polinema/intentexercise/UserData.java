package id.ac.polinema.intentexercise;


import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

public class UserData implements Parcelable {
    private String fullName;
    private String email;
    private String password;
    private String confirmPassword;
    private String homepage;
    private String about;
    private Uri path;

    public UserData(String fullName, String email, String password, String confirmPassword, String homepage, String about, Uri path) {
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.homepage = homepage;
        this.about = about;
        this.path = path;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public Uri getPath() {
        return path;
    }

    public void setPath(Uri path) {
        this.path = path;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.fullName);
        dest.writeString(this.email);
        dest.writeString(this.password);
        dest.writeString(this.confirmPassword);
        dest.writeString(this.homepage);
        dest.writeString(this.about);
        dest.writeParcelable(this.path, flags);
    }

    protected UserData(Parcel in) {
        this.fullName = in.readString();
        this.email = in.readString();
        this.password = in.readString();
        this.confirmPassword = in.readString();
        this.homepage = in.readString();
        this.about = in.readString();
        this.path = in.readParcelable(Uri.class.getClassLoader());
    }

    public static final Creator<UserData> CREATOR = new Creator<UserData>() {
        @Override
        public UserData createFromParcel(Parcel source) {
            return new UserData(source);
        }

        @Override
        public UserData[] newArray(int size) {
            return new UserData[size];
        }
    };
}


package com.ibm.mobileappbuilder.businessdirectory20150916145512.ds;
import java.util.Date;
import android.graphics.Bitmap;
import android.net.Uri;

import ibmmobileappbuilder.mvp.model.IdentifiableBean;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;

public class MoviesDSItem implements Parcelable, IdentifiableBean {

    @SerializedName("movieName") public String movieName;
    @SerializedName("movieID") public Long movieID;
    @SerializedName("inEnglish") public Boolean inEnglish;
    @SerializedName("description") public String description;
    @SerializedName("releaseDate") public Date releaseDate;
    @SerializedName("rating") public Long rating;
    @SerializedName("moviePoster") public String moviePoster;
    @SerializedName("id") public String id;
    @SerializedName("moviePosterUri") public transient Uri moviePosterUri;

    @Override
    public String getIdentifiableId() {
      return id;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(movieName);
        dest.writeValue(movieID);
        dest.writeValue(inEnglish);
        dest.writeString(description);
        dest.writeValue(releaseDate != null ? releaseDate.getTime() : null);
        dest.writeValue(rating);
        dest.writeString(moviePoster);
        dest.writeString(id);
    }

    public static final Creator<MoviesDSItem> CREATOR = new Creator<MoviesDSItem>() {
        @Override
        public MoviesDSItem createFromParcel(Parcel in) {
            MoviesDSItem item = new MoviesDSItem();

            item.movieName = in.readString();
            item.movieID = (Long) in.readValue(null);
            item.inEnglish = (Boolean) in.readValue(null);
            item.description = in.readString();
            Long releaseDateAux = (Long) in.readValue(null);
            item.releaseDate = releaseDateAux != null ? new Date(releaseDateAux) : null;
            item.rating = (Long) in.readValue(null);
            item.moviePoster = in.readString();
            item.id = in.readString();
            return item;
        }

        @Override
        public MoviesDSItem[] newArray(int size) {
            return new MoviesDSItem[size];
        }
    };

}



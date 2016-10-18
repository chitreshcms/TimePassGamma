
package com.ibm.mobileappbuilder.businessdirectory20150916145512.ds;
import ibmmobileappbuilder.ds.restds.GeoPoint;
import java.util.Date;
import android.graphics.Bitmap;
import android.net.Uri;

import ibmmobileappbuilder.mvp.model.IdentifiableBean;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;

public class MTMDataDSItem implements Parcelable, IdentifiableBean {

    @SerializedName("mTMUserName") public String mTMUserName;
    @SerializedName("mTMTheaterName") public String mTMTheaterName;
    @SerializedName("mTMTheaterLocation") public GeoPoint mTMTheaterLocation;
    @SerializedName("mTMTheaterAddress") public String mTMTheaterAddress;
    @SerializedName("mTMNetProfit") public Double mTMNetProfit;
    @SerializedName("movieID") public Long movieID;
    @SerializedName("movieShowTime") public Date movieShowTime;
    @SerializedName("movieName") public String movieName;
    @SerializedName("movieTheaterPhoto") public String movieTheaterPhoto;
    @SerializedName("inMall") public Boolean inMall;
    @SerializedName("id") public String id;
    @SerializedName("movieTheaterPhotoUri") public transient Uri movieTheaterPhotoUri;

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
        dest.writeString(mTMUserName);
        dest.writeString(mTMTheaterName);
        dest.writeDoubleArray(mTMTheaterLocation != null  && mTMTheaterLocation.coordinates.length != 0 ? mTMTheaterLocation.coordinates : null);
        dest.writeString(mTMTheaterAddress);
        dest.writeValue(mTMNetProfit);
        dest.writeValue(movieID);
        dest.writeValue(movieShowTime != null ? movieShowTime.getTime() : null);
        dest.writeString(movieName);
        dest.writeString(movieTheaterPhoto);
        dest.writeValue(inMall);
        dest.writeString(id);
    }

    public static final Creator<MTMDataDSItem> CREATOR = new Creator<MTMDataDSItem>() {
        @Override
        public MTMDataDSItem createFromParcel(Parcel in) {
            MTMDataDSItem item = new MTMDataDSItem();

            item.mTMUserName = in.readString();
            item.mTMTheaterName = in.readString();
            double[] mTMTheaterLocation_coords = in.createDoubleArray();
            if (mTMTheaterLocation_coords != null)
                item.mTMTheaterLocation = new GeoPoint(mTMTheaterLocation_coords);
            item.mTMTheaterAddress = in.readString();
            item.mTMNetProfit = (Double) in.readValue(null);
            item.movieID = (Long) in.readValue(null);
            Long movieShowTimeAux = (Long) in.readValue(null);
            item.movieShowTime = movieShowTimeAux != null ? new Date(movieShowTimeAux) : null;
            item.movieName = in.readString();
            item.movieTheaterPhoto = in.readString();
            item.inMall = (Boolean) in.readValue(null);
            item.id = in.readString();
            return item;
        }

        @Override
        public MTMDataDSItem[] newArray(int size) {
            return new MTMDataDSItem[size];
        }
    };

}



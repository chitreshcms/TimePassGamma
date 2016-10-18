
package com.ibm.mobileappbuilder.businessdirectory20150916145512.ds;
import ibmmobileappbuilder.ds.restds.GeoPoint;
import android.graphics.Bitmap;
import android.net.Uri;

import ibmmobileappbuilder.mvp.model.IdentifiableBean;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;

public class TouristDSItem implements Parcelable, IdentifiableBean {

    @SerializedName("tPName") public String tPName;
    @SerializedName("tPLocation") public GeoPoint tPLocation;
    @SerializedName("tPPhoto") public String tPPhoto;
    @SerializedName("tPDescription") public String tPDescription;
    @SerializedName("tPAddress") public String tPAddress;
    @SerializedName("id") public String id;
    @SerializedName("tPPhotoUri") public transient Uri tPPhotoUri;

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
        dest.writeString(tPName);
        dest.writeDoubleArray(tPLocation != null  && tPLocation.coordinates.length != 0 ? tPLocation.coordinates : null);
        dest.writeString(tPPhoto);
        dest.writeString(tPDescription);
        dest.writeString(tPAddress);
        dest.writeString(id);
    }

    public static final Creator<TouristDSItem> CREATOR = new Creator<TouristDSItem>() {
        @Override
        public TouristDSItem createFromParcel(Parcel in) {
            TouristDSItem item = new TouristDSItem();

            item.tPName = in.readString();
            double[] tPLocation_coords = in.createDoubleArray();
            if (tPLocation_coords != null)
                item.tPLocation = new GeoPoint(tPLocation_coords);
            item.tPPhoto = in.readString();
            item.tPDescription = in.readString();
            item.tPAddress = in.readString();
            item.id = in.readString();
            return item;
        }

        @Override
        public TouristDSItem[] newArray(int size) {
            return new TouristDSItem[size];
        }
    };

}



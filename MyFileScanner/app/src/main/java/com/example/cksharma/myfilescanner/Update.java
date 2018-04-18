package com.example.cksharma.myfilescanner;

import android.os.Parcel;
import android.os.Parcelable;


public class Update implements Parcelable {



    public int totalMB = 0;
    public double averageFileSize  = 0;

    public String[] biggestTenFileNames = new String[10];
    public long[]   biggestTenFileSizes = new long[10];

    public String[] mostFrequentFiveExtensions = new String[5];

    public byte isDone = 0;

    public Update(){}

    protected Update(Parcel in) {
        totalMB = in.readInt();
        averageFileSize = in.readDouble();
        in.readStringArray(biggestTenFileNames);
        in.readLongArray(biggestTenFileSizes);
        in.readStringArray(mostFrequentFiveExtensions);
        isDone = in.readByte();
    }

    public static final Creator<Update> CREATOR = new Creator<Update>() {
        @Override
        public Update createFromParcel(Parcel in) {
            return new Update(in);
        }

        @Override
        public Update[] newArray(int size) {
            return new Update[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(totalMB);
        dest.writeDouble(averageFileSize);

        dest.writeStringArray(biggestTenFileNames);
        dest.writeLongArray(biggestTenFileSizes);

        dest.writeStringArray(mostFrequentFiveExtensions);

        dest.writeByte(isDone);
    }
}

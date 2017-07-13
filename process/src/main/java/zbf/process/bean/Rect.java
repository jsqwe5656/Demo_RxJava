package zbf.process.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by zbf on 2017/7/13.
 */

public final class Rect implements Parcelable
{
    public int left;
    public int top;
    public int right;
    public int bottom;

    public Rect(){}

    protected Rect(Parcel in)
    {
        left = in.readInt();
        top = in.readInt();
        right = in.readInt();
        bottom = in.readInt();
    }

    public static final Creator<Rect> CREATOR = new Creator<Rect>()
    {
        @Override
        public Rect createFromParcel(Parcel in)
        {
            return new Rect(in);
        }

        @Override
        public Rect[] newArray(int size)
        {
            return new Rect[size];
        }
    };

    @Override
    public int describeContents()
    {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeInt(left);
        parcel.writeInt(top);
        parcel.writeInt(right);
        parcel.writeInt(bottom);
    }
}

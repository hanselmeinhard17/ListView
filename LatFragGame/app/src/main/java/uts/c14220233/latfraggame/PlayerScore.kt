package uts.c14220233.latfraggame

import android.os.Parcel
import android.os.Parcelable

data class PlayerScore(var score: Int) : Parcelable {
    constructor(parcel: Parcel) : this(parcel.readInt()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(score)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<PlayerScore> {
        override fun createFromParcel(parcel: Parcel): PlayerScore {
            return PlayerScore(parcel)
        }

        override fun newArray(size: Int): Array<PlayerScore?> {
            return arrayOfNulls(size)
        }
    }
}

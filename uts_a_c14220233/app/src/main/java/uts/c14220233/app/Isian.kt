package uts.c14220233.app

import android.os.Parcel
import android.os.Parcelable

data class Isian(
    val Total : Long,
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readLong(),
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeLong(Total)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Isian> {
        override fun createFromParcel(parcel: Parcel): Isian {
            return Isian(parcel)
        }

        override fun newArray(size: Int): Array<Isian?> {
            return arrayOfNulls(size)
        }
    }
}

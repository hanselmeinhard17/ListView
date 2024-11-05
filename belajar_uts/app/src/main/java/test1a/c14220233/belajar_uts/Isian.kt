package test1a.c14220233.belajar_uts

import android.os.Parcel
import android.os.Parcelable

data class Isian(
    val Total : Long,
    val BatasKategori : Long,
    val TotalKategori : Long,
    val Kategori : String?
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readLong(),
        parcel.readLong(),
        parcel.readLong(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeLong(Total)
        parcel.writeLong(BatasKategori)
        parcel.writeLong(TotalKategori)
        parcel.writeString(Kategori)
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

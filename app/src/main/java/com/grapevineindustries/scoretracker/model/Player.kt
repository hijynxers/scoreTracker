package com.grapevineindustries.scoretracker.model

import android.os.Parcel
import android.os.Parcelable

class Player(val name: String?): Parcelable {
    var score = 0

    constructor(parcel: Parcel) : this(parcel.readString()) {
        score = parcel.readInt()
    }

    override fun toString(): String {
        return "$name: $score"
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeInt(score)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Player> {
        override fun createFromParcel(parcel: Parcel): Player {
            return Player(parcel)
        }

        override fun newArray(size: Int): Array<Player?> {
            return arrayOfNulls(size)
        }
    }
}
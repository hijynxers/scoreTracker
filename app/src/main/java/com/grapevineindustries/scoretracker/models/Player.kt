package com.grapevineindustries.scoretracker.models

import android.os.Parcel
import android.os.Parcelable

class Player(var name: String?): Parcelable{
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

class Players() : ArrayList<Player>(), Parcelable {
    constructor(parcel: Parcel) : this() {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Players> {
        override fun createFromParcel(parcel: Parcel): Players {
            return Players(parcel)
        }

        override fun newArray(size: Int): Array<Players?> {
            return arrayOfNulls(size)
        }
    }
}

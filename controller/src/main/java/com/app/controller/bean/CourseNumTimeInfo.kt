package com.app.controller.bean

import android.os.Parcel
import android.os.Parcelable

data class CourseNumTimeInfo(
        val num:Int,
        var startTime:String,
        var endTime:String
):Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readInt(),
            parcel.readString(),
            parcel.readString()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(num)
        parcel.writeString(startTime)
        parcel.writeString(endTime)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<CourseNumTimeInfo> {
        override fun createFromParcel(parcel: Parcel): CourseNumTimeInfo {
            return CourseNumTimeInfo(parcel)
        }

        override fun newArray(size: Int): Array<CourseNumTimeInfo?> {
            return arrayOfNulls(size)
        }
    }
}
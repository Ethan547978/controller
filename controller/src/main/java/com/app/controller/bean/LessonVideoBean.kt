package com.app.controller.bean

import android.os.Parcel
import android.os.Parcelable
data class LessonPageBean(
        val current:Int,
        val size :Int,
        var records: MutableList<LessonBean>
)

data class LessonBean(
        val id:Int,
        val title:String,
        val type:Int,
        val accessType:Int,
        val logo:String?,
        val description:String,
        val url:String,
        val duration:Int,
        val viewNum:Int,
        val createTime:String,
        var classList:List<LessonClassListBean>?
        ):Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readInt(),
            parcel.readString(),
            parcel.readInt(),
            parcel.readInt(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readInt(),
            parcel.readInt(),
            parcel.readString(),
            parcel.createTypedArrayList(LessonClassListBean)) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(title)
        parcel.writeInt(type)
        parcel.writeInt(accessType)
        parcel.writeString(logo)
        parcel.writeString(description)
        parcel.writeString(url)
        parcel.writeInt(duration)
        parcel.writeInt(viewNum)
        parcel.writeString(createTime)
        parcel.writeTypedList(classList)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<LessonBean> {
        override fun createFromParcel(parcel: Parcel): LessonBean {
            return LessonBean(parcel)
        }

        override fun newArray(size: Int): Array<LessonBean?> {
            return arrayOfNulls(size)
        }
    }
}

data class LessonClassListBean(
        val grade:Int,
        val classNum:Int,
        val type:Int
):Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readInt(),
            parcel.readInt(),
            parcel.readInt()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(grade)
        parcel.writeInt(classNum)
        parcel.writeInt(type)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<LessonClassListBean> {
        override fun createFromParcel(parcel: Parcel): LessonClassListBean {
            return LessonClassListBean(parcel)
        }

        override fun newArray(size: Int): Array<LessonClassListBean?> {
            return arrayOfNulls(size)
        }
    }
}
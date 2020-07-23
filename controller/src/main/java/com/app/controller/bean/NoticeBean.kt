package com.app.controller.bean

import android.os.Parcel
import android.os.Parcelable

data class NoticeBean(
        val id:Int,
        val title:String,
        val rid:Int,
        val noticeType:Int,
        val accessType:Int,
        val logo:String?,
        val content:String,
        val picAttach:String?,
        val fileAttach:String?,
        val status:Int,
        val publisher:String,
        val createTime:String,
        val isRead:Int,
        val classList:List<NoticeClassBean>?
):Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readInt(),
            parcel.readString(),
            parcel.readInt(),
            parcel.readInt(),
            parcel.readInt(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readInt(),
            parcel.readString(),
            parcel.readString(),
            parcel.readInt(),
            parcel.createTypedArrayList(NoticeClassBean)) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(title)
        parcel.writeInt(rid)
        parcel.writeInt(noticeType)
        parcel.writeInt(accessType)
        parcel.writeString(logo)
        parcel.writeString(content)
        parcel.writeString(picAttach)
        parcel.writeString(fileAttach)
        parcel.writeInt(status)
        parcel.writeString(publisher)
        parcel.writeString(createTime)
        parcel.writeInt(isRead)
        parcel.writeTypedList(classList)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<NoticeBean> {
        override fun createFromParcel(parcel: Parcel): NoticeBean {
            return NoticeBean(parcel)
        }

        override fun newArray(size: Int): Array<NoticeBean?> {
            return arrayOfNulls(size)
        }
    }
}

data class NoticeClassBean(
        val type:Int,
        val grade:String,
        val classNum:Int
):Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readInt(),
            parcel.readString(),
            parcel.readInt()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(type)
        parcel.writeString(grade)
        parcel.writeInt(classNum)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<NoticeClassBean> {
        override fun createFromParcel(parcel: Parcel): NoticeClassBean {
            return NoticeClassBean(parcel)
        }

        override fun newArray(size: Int): Array<NoticeClassBean?> {
            return arrayOfNulls(size)
        }
    }
}

data class NoticeListBean(
        val current:Int,
        val size:Int,
        val records:MutableList<NoticeBean>
)

data class NoticeDetailBean(
        val id:Int,
        val readCount:Int,
        val unreadCount:Int,
        val title:String,
        val rid:Int,
        val noticeType:Int,
        val logo:String?,
        val content:String,
        val picAttach:String?,
        val fileAttach:String?,
        val publisher:String,
        val createTime:String
)
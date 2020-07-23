package com.app.controller.bean

import android.os.Parcel
import android.os.Parcelable

data class ContrabandVisitorListBean(
        val id:Int,
        val visitorName:String,
        val visitorMobile:String,
        val visitorIdNo:String,
        val visitUserName:String,
        val schoolName:String,
        val schoolYear:String?,
        val visitorPicture:String?,
        val content:String?,
        val checkTime:String,
        val parentName:String?,
        val parentMobile:String?,
        val security:String?,
        val dealTime:String?,
        val images:String?,
        val createTime:String,
        val grade:Int,
        val visitUserType:Int,
        val visitUserRole:Int,
        val gradeType:Int,
        val classNum:Int,
        val status:Int,
        val hasContraband:Int
):Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readInt(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readInt(),
            parcel.readInt(),
            parcel.readInt(),
            parcel.readInt(),
            parcel.readInt(),
            parcel.readInt(),
            parcel.readInt()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(visitorName)
        parcel.writeString(visitorMobile)
        parcel.writeString(visitorIdNo)
        parcel.writeString(visitUserName)
        parcel.writeString(schoolName)
        parcel.writeString(schoolYear)
        parcel.writeString(visitorPicture)
        parcel.writeString(content)
        parcel.writeString(checkTime)
        parcel.writeString(parentName)
        parcel.writeString(parentMobile)
        parcel.writeString(security)
        parcel.writeString(dealTime)
        parcel.writeString(images)
        parcel.writeString(createTime)
        parcel.writeInt(grade)
        parcel.writeInt(visitUserType)
        parcel.writeInt(visitUserRole)
        parcel.writeInt(gradeType)
        parcel.writeInt(classNum)
        parcel.writeInt(status)
        parcel.writeInt(hasContraband)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ContrabandVisitorListBean> {
        override fun createFromParcel(parcel: Parcel): ContrabandVisitorListBean {
            return ContrabandVisitorListBean(parcel)
        }

        override fun newArray(size: Int): Array<ContrabandVisitorListBean?> {
            return arrayOfNulls(size)
        }
    }
}
package com.app.controller.bean

import android.os.Parcel
import android.os.Parcelable

data class ContrabandListBean(
        val id:Int,
        val studentName:String,
        val sno:String,
        val schoolName:String,
        val schoolYear:String?,
        val logo:String?,
        val content:String?,
        val headTeacher:String,
        val checkTime:String,
        val parentName:String,
        val parentMobile:String,
        val security:String?,
        val dealTime:String?,
        val images:String?,
        val createTime:String,
        val grade:Int,
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
            parcel.readInt(),
            parcel.readInt(),
            parcel.readInt(),
            parcel.readInt(),
            parcel.readInt()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(studentName)
        parcel.writeString(sno)
        parcel.writeString(schoolName)
        parcel.writeString(schoolYear)
        parcel.writeString(logo)
        parcel.writeString(content)
        parcel.writeString(headTeacher)
        parcel.writeString(checkTime)
        parcel.writeString(parentName)
        parcel.writeString(parentMobile)
        parcel.writeString(security)
        parcel.writeString(dealTime)
        parcel.writeString(images)
        parcel.writeString(createTime)
        parcel.writeInt(grade)
        parcel.writeInt(gradeType)
        parcel.writeInt(classNum)
        parcel.writeInt(status)
        parcel.writeInt(hasContraband)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ContrabandListBean> {
        override fun createFromParcel(parcel: Parcel): ContrabandListBean {
            return ContrabandListBean(parcel)
        }

        override fun newArray(size: Int): Array<ContrabandListBean?> {
            return arrayOfNulls(size)
        }
    }
}
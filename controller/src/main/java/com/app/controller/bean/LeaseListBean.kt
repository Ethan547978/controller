package com.app.controller.bean

data class LeaseListBean( val current:Int,
                     val size:Int,
                     val records:MutableList<LeaveBean>)
package com.app.controller.bean

data class ContrabandVisitorBean (
    val current:Int,
    val size:Int,
    val records:MutableList<ContrabandVisitorListBean>
    )
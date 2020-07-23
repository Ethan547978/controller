package com.app.controller.bean

data class ContrabandBean(
         val current:Int,
         val size:Int,
         val records:MutableList<ContrabandListBean>
)
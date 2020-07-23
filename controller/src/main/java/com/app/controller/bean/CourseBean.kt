package com.app.controller.bean

data class CourseBean(val id: Int,
                      val type: Int,
                      val grade: Int,
                      val classNum: Int,
                      val num: Int,
                      val startTime: String,
                      val endTime: String,
                      val courseName: String,
                      val userName: String,
                      val address: String,
                      val userId: Int
)

data class CourseListBean(val weekday: Int,
                      val courseList: List<CourseBean>
)

data class CourseAdapterBean(val id: Int,
                      val type: Int,
                      val grade: Int,
                      val classNum: Int,
                      val num: Int,
                      val startTime: String,
                      val endTime: String,
                      val courseName: String,
                      val userName: String,
                      val weekday: Int,
                      val address: String,
                      val userId: Int
)
class CourseListAdapterBean(val num: Int,
                          val courseList: MutableList<CourseAdapterBean>
):Comparator<CourseListAdapterBean> {
    override fun compare(o1: CourseListAdapterBean?, o2: CourseListAdapterBean?): Int {
        return o1!!.num.compareTo(o2!!.num)
    }
}




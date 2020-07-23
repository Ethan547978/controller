package com.app.controller.bean;

import com.chad.library.adapter.base.entity.SectionEntity;

public class GradeSectionBean  extends SectionEntity<GradeInfoBean> {

    public GradeSectionBean(boolean isHeader, String header) {
        super(isHeader, header);
    }

    public GradeSectionBean(GradeInfoBean gradeInfoBean) {
        super(gradeInfoBean);
    }
}

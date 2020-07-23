package com.app.controller.bean;

import com.chad.library.adapter.base.entity.SectionEntity;

public class ClassSectionBean extends SectionEntity<ClassInfo> {

    public ClassSectionBean(boolean isHeader, String header) {
        super(isHeader, header);
    }

    public ClassSectionBean(ClassInfo gradeInfoBean) {
        super(gradeInfoBean);
    }
}

package com.app.controller.bean;


import com.chad.library.adapter.base.entity.SectionEntity;

public class ContactSection extends SectionEntity<ContactInfoBean> {
    private boolean isMore;

    public ContactSection(boolean isHeader, String header) {
        super(isHeader, header);
    }

    public ContactSection(ContactInfoBean t) {
        super(t);
    }
}

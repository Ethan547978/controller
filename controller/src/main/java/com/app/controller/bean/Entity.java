package com.app.controller.bean;



import android.os.Parcel;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Comparator;


public abstract class Entity {

    protected static Comparator<Field> mComparator = new  Comparator<Field>() {
        @Override
        public int compare(Field lhs, Field rhs) {
            if (lhs.getName().compareTo(rhs.getName()) > 0)
                return 1;
            else if (lhs.getName().compareTo(rhs.getName()) < 0)
                return -1;
            return 0;
        }
    };

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer("{");
        Class clazz = getClass();
        string(sb, clazz);

        if (sb.length() > 1)
            sb.deleteCharAt(sb.length() - 1);
        sb.append("}");

        return sb.toString();
    }

    private void string(StringBuffer sb, Class clazz) {
        if (clazz.getSuperclass() != null && clazz.getSuperclass() != Object.class) {
            string(sb,clazz.getSuperclass());
        }
        try {
            for (Field item : clazz.getDeclaredFields()) {

                if (Modifier.toString(item.getModifiers()).contains("static"))
                {
                    //不要static修饰的属性
                    continue;
                }
                boolean accessFlag = item.isAccessible();
                /**
                 * 设置是否有权限访问反射类中的私有属性的
                 * */
                item.setAccessible(true);
                sb.append(item.getName()).append(":").append(item.get(this) + "").append(",");
                item.setAccessible(accessFlag);
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    protected static void writeObject(Parcel source, Object mMember) {
        Field[] fields = mMember.getClass().getDeclaredFields();
        Arrays.sort(fields, mComparator);
        try {
            for (Field field : fields)
            {
                if (Modifier.toString(field.getModifiers()).contains("static"))
                {
                    //不要static修饰的属性
                    continue;
                }
                boolean accessFlag = field.isAccessible();
                /**
                 * 设置是否有权限访问反射类中的私有属性的
                 * */
                field.setAccessible(true);
                field.set(mMember, source.readValue(mMember.getClass().getClassLoader()));
                field.setAccessible(accessFlag);
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    protected void readObject(Parcel dest, Object mMember) {
        Field[] fields = mMember.getClass().getDeclaredFields();
        Arrays.sort(fields, mComparator);
        try {
            for (Field field : fields)
            {
                if (Modifier.toString(field.getModifiers()).contains("static"))
                {
                    //不要static修饰的属性
                    continue;
                }
                boolean accessFlag = field.isAccessible();
                /**
                 * 设置是否有权限访问反射类中的私有属性的
                 * */
                field.setAccessible(true);
                dest.writeValue(field.get(mMember));
                field.setAccessible(accessFlag);
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}

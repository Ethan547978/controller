package com.app.controller.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * MeFragment userInfo
 */
public class MeUserInfo extends Entity implements Parcelable {

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        readObject(dest, this);
    }

    public static final Creator<MeUserInfo> CREATOR = new Creator<MeUserInfo>() {
        @Override
        public MeUserInfo createFromParcel(Parcel source) {
            MeUserInfo mMember = new MeUserInfo();
            writeObject(source, mMember);
            return mMember;
        }

        @Override
        public MeUserInfo[] newArray(int size) {
            return new MeUserInfo[size];
        }
    };

    private int jinbiamount;
    private int useFinsTotal;
    private int anchorDynamic;
//    private ArrayList<GSinger> singerUids;
//    private int level;
    private int followTotal;
//    private int explevel;
    private int fSingerTotal;
    private int isAnchor;
    private int richlevel;
    //小等级
    private String childLevel;
    private int bonusLevel;
    private int bonusLevelCurrValue;
    private int bonusLevelNextValue;
    private String profit;
    private int endMonthBonus;
    private ArrayList<String> singerImg;
    //主播的是主播等级，用户是活跃等级
    private int explevel;
    //等级图片
    private String level_images_small;
    //等级全图
    private String level_images_big;
    //等级字体颜色
    private String levelColor;
    //当前经验
    private int explevelvalue;
    //下一级经验
    private int explevelNextValue;

    public String getChildLevel() {
        return childLevel;
    }

    public void setChildLevel(String childLevel) {
        this.childLevel = childLevel;
    }

    public String getLevelColor() {
        return levelColor;
    }

    public void setLevelColor(String levelColor) {
        this.levelColor = levelColor;
    }

    public String getLevel_images_big() {
        return level_images_big;
    }

    public void setLevel_images_big(String level_images_big) {
        this.level_images_big = level_images_big;
    }

    public String getLevel_images_small() {
        return level_images_small;
    }

    public void setLevel_images_small(String level_images_small) {
        this.level_images_small = level_images_small;
    }

    public int getExplevelvalue() {
        return explevelvalue;
    }

    public void setExplevelvalue(int explevelvalue) {
        this.explevelvalue = explevelvalue;
    }

    public int getExplevelNextValue() {
        return explevelNextValue;
    }

    public void setExplevelNextValue(int explevelNextValue) {
        this.explevelNextValue = explevelNextValue;
    }

    public int getAnchorDynamic() {
        return anchorDynamic;
    }

    public void setAnchorDynamic(int anchorDynamic) {
        this.anchorDynamic = anchorDynamic;
    }

    public int getJinbiamount() {
        return jinbiamount;
    }

    public void setJinbiamount(int jinbiamount) {
        this.jinbiamount = jinbiamount;
    }

    public int getUseFinsTotal() {
        return useFinsTotal;
    }

    public void setUseFinsTotal(int useFinsTotal) {
        this.useFinsTotal = useFinsTotal;
    }

    public int getFollowTotal() {
        return followTotal;
    }

    public void setFollowTotal(int followTotal) {
        this.followTotal = followTotal;
    }

    public int getExplevel() {
        return explevel;
    }

    public void setExplevel(int explevel) {
        this.explevel = explevel;
    }

    public int getfSingerTotal() {
        return fSingerTotal;
    }

    public void setfSingerTotal(int fSingerTotal) {
        this.fSingerTotal = fSingerTotal;
    }


    public int getIsAnchor() {
        return isAnchor;
    }

    public void setIsAnchor(int isAnchor) {
        this.isAnchor = isAnchor;
    }

    public int getRichlevel() {
        return richlevel;
    }

    public void setRichlevel(int richlevel) {
        this.richlevel = richlevel;
    }

    public int getBonusLevel() {
        return bonusLevel;
    }

    public void setBonusLevel(int bonusLevel) {
        this.bonusLevel = bonusLevel;
    }

    public int getBonusLevelCurrValue() {
        return bonusLevelCurrValue;
    }

    public void setBonusLevelCurrValue(int bonusLevelCurrValue) {
        this.bonusLevelCurrValue = bonusLevelCurrValue;
    }

    public int getBonusLevelNextValue() {
        return bonusLevelNextValue;
    }

    public void setBonusLevelNextValue(int bonusLevelNextValue) {
        this.bonusLevelNextValue = bonusLevelNextValue;
    }

    public String getProfit() {
        return profit;
    }

    public void setProfit(String profit) {
        this.profit = profit;
    }

    public int getEndMonthBonus() {
        return endMonthBonus;
    }

    public void setEndMonthBonus(int endMonthBonus) {
        this.endMonthBonus = endMonthBonus;
    }

    public ArrayList<String> getSingerImg() {
        return singerImg;
    }

    public void setSingerImg(ArrayList<String> singerImg) {
        this.singerImg = singerImg;
    }

}

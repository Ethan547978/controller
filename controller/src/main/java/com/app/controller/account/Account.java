package com.app.controller.account;


import com.google.gson.annotations.Expose;
import com.app.controller.bean.ClassInfo;
import com.app.controller.bean.SchoolInfo;
import com.app.controller.bean.StudentInfo;
import com.app.controller.bean.TeacherInfo;
import com.app.controller.store.local.cache.manager.HttpCacheStoreManager;
import com.app.controller.store.local.file.FileStoreManager;
import com.app.controller.store.local.sharepre.manager.SharePreferencesManager;

import java.util.ArrayList;

/**
 * Description : 账号实体
 * Creator : ZST
 */
public class Account {

    private FileStoreManager mFileStoreManager;
    private HttpCacheStoreManager mHttpCacheStoreManager;
    private SharePreferencesManager mSharePreferencesManager;

    /**
     * 若想保存到本地的字段，一定要加上@Expose标签，否则无效
     */
    @Expose
    private int mUserType;//用户类型：1.教职工，2.家长，3.学生
    @Expose
    private long mUid;//用户ID
    @Expose
    private String mToken;//登录token
    @Expose
    private String mNickName;//用户昵称
    @Expose
    private String mPassword;//账号密码
    @Expose
    private String mMobile;//手机号码
    @Expose
    private String mIcon;//头像
    @Expose
    private int mSex;//性别
    @Expose
    private String mIMUsername;//环信用户名
    @Expose
    private String mIMPassword;//环信密码
    @Expose
    private TeacherInfo mTeacher;//教职工
    @Expose
    private SchoolInfo mSchool;//学校
    @Expose
    private ArrayList<StudentInfo> mStudentInfos;//家长特有字段
    @Expose
    private ArrayList<ClassInfo> mClasses;//班主任特有字段

//    @Expose
//    private String mSign;//个性签名
//    @Expose
//    private int mSex;//性别 0 女 1 男 -1未知
//    @Expose
//    private long mBirthday;
//    @Expose
//    private String mPhoto;//用户头像
//    @Expose
//    private String mSocketToken;//socketToken
//    @Expose
//    private int mIdentity;//身份标识
//    @Expose
//    private String mGold = "0";//用户金币数量
//    @Expose
//    private int mSun;//用户阳光值
//    @Expose
//    private int mLevel;//等级
//    @Expose
//    private int mUserSystemLivePush;
//    @Expose
//    private int mUserSystemDownload;

    private Account() {
    }

    public static Account newAccount() {
        return new Account();
    }

    /**
     * 用户ID
     */
    public long getUid() {
        return mUid;
    }

    public void setUid(long uid,int userType) {
        this.mUid = uid;
        Account account = AccountManager.getInstance().getLoginAccountForCache();
        String cacheUid = account.getUid() + "-" + account.getUserType();
        if (cacheUid.equals(mUid + "-" + userType) || account.getUid() == 0) {
            account.mUid = this.mUid;
            account.mUserType = userType;
            AccountManager.getInstance().saveLoginAccount(account);
        }
    }

    public ArrayList<StudentInfo> getStudentsInfo() {
        return mStudentInfos;
    }

    public void setStudentsInfos(ArrayList<StudentInfo> mStudentInfos) {
        this.mStudentInfos = mStudentInfos;
        Account account = AccountManager.getInstance().getLoginAccountForCache();
        String cacheUid = account.getUid()+"-"+account.getUserType();
        if (cacheUid.equals(mUid)) {
            account.mStudentInfos = mStudentInfos;
            AccountManager.getInstance().saveLoginAccount(account);
        }
    }

    public ArrayList<ClassInfo> getClassesInfo() {
        return mClasses;
    }

    public void setClassesInfo(ArrayList<ClassInfo> classes) {
        this.mClasses = classes;
        Account account = AccountManager.getInstance().getLoginAccountForCache();
        String cacheUid = account.getUid()+"-"+account.getUserType();
        if (cacheUid.equals(mUid)) {
            account.mClasses = classes;
            AccountManager.getInstance().saveLoginAccount(account);
        }
    }

    /**
     * 用户类型：1.教职工，2.家长，3.学生
     */
    public int getUserType() {
        return mUserType;
    }

    public boolean isStaffRole(){
        return mUserType == 1;
    }

    public boolean isParentsRole(){
        return mUserType == 2;
    }

    public void setUserType(long uid,int userType) {
        this.mUserType = userType;

        Account account = AccountManager.getInstance().getLoginAccountForCache();
        String cacheUid = account.getUid() + "-" + account.getUserType();
        if (cacheUid.equals(uid + "-" + userType)) {
            account.mUserType = userType;
            AccountManager.getInstance().saveLoginAccount(account);
        }
    }

    /**
     * 登录token
     */
    public String getToken() {
        return mToken;
    }

    public void setToken(String token) {
        this.mToken = token;

        Account account = AccountManager.getInstance().getLoginAccountForCache();
        String cacheUid = account.getUid()+"-"+account.getUserType();
        if (cacheUid.equals(mUid + "-" + mUserType)) {
            account.mToken = token;
            AccountManager.getInstance().saveLoginAccount(account);
        }
    }

    /**
     * 用户昵称
     */
    public String getNickName() {
        return mNickName;
    }

    public void setNickName(String nickName) {
        this.mNickName = nickName;

        Account account = AccountManager.getInstance().getLoginAccountForCache();
        String cacheUid = account.getUid()+"-"+account.getUserType();
        if (cacheUid.equals(mUid+ "-" + mUserType)) {
            account.mNickName = nickName;
            AccountManager.getInstance().saveLoginAccount(account);
        }
    }

    public String getPassword() {
        return mPassword;
    }

    public void setPassword(String password) {
        this.mPassword = password;

        Account account = AccountManager.getInstance().getLoginAccountForCache();
        String cacheUid = account.getUid()+"-"+account.getUserType();
        if (cacheUid.equals(mUid+ "-" + mUserType)) {
            account.mPassword = password;
            AccountManager.getInstance().saveLoginAccount(account);
        }
    }

    /**
     * 手机号码
     */
    public String getMobile() {
        return mMobile;
    }

    public void setMobile(String mobile) {
        this.mMobile = mobile;

        Account account = AccountManager.getInstance().getLoginAccountForCache();
        String cacheUid = account.getUid()+"-"+account.getUserType();
        if (cacheUid.equals(mUid+ "-" + mUserType)) {
            account.mMobile = mobile;
            AccountManager.getInstance().saveLoginAccount(account);
        }
    }

    /**
     * 头像
     */
    public String getIcon() {
        return mIcon;
    }

    public void setIcon(String icon) {
        this.mIcon = icon;

        Account account = AccountManager.getInstance().getLoginAccountForCache();
        String cacheUid = account.getUid()+"-"+account.getUserType();
        if (cacheUid.equals(mUid+ "-" + mUserType)) {
            account.mIcon = icon;
            AccountManager.getInstance().saveLoginAccount(account);
        }
    }

    public int getSex() {
        return mSex;
    }

    public void setSex(int sex) {
        this.mSex = sex;

        Account account = AccountManager.getInstance().getLoginAccountForCache();
        String cacheUid = account.getUid()+"-"+account.getUserType();
        if (cacheUid.equals(mUid+ "-" + mUserType)) {
            account.mSex = sex;
            AccountManager.getInstance().saveLoginAccount(account);
        }
    }

    public String getIMUserName() {
        return mIMUsername;
    }

    public void setIMUserName(String imUserName) {
        this.mIMUsername = imUserName;

        Account account = AccountManager.getInstance().getLoginAccountForCache();
        String cacheUid = account.getUid()+"-"+account.getUserType();
        if (cacheUid.equals(mUid+ "-" + mUserType)) {
            account.mIMUsername = imUserName;
            AccountManager.getInstance().saveLoginAccount(account);
        }
    }

    public String getIMPassword() {
        return mIMPassword;
    }

    public void setIMPassword(String imPassword) {
        this.mIMPassword = imPassword;

        Account account = AccountManager.getInstance().getLoginAccountForCache();
        String cacheUid = account.getUid()+"-"+account.getUserType();
        if (cacheUid.equals(mUid+ "-" + mUserType)) {
            account.mIMPassword = imPassword;
            AccountManager.getInstance().saveLoginAccount(account);
        }
    }

    /**
     * 教职工
     */
    public TeacherInfo getTeacher() {
        return mTeacher;
    }

    public void setTeacher(TeacherInfo teacher) {
        this.mTeacher = teacher;

        Account account = AccountManager.getInstance().getLoginAccountForCache();
        String cacheUid = account.getUid()+"-"+account.getUserType();
        if (cacheUid.equals(mUid+ "-" + mUserType)) {
            account.mTeacher = teacher;
            AccountManager.getInstance().saveLoginAccount(account);
        }
    }

    /**
     * 教职工
     */
    public SchoolInfo getSchool() {
        return mSchool;
    }

    public void setSchool(SchoolInfo school) {
        this.mSchool = school;

        Account account = AccountManager.getInstance().getLoginAccountForCache();
        String cacheUid = account.getUid()+"-"+account.getUserType();
        if (cacheUid.equals(mUid+ "-" + mUserType)) {
            account.mSchool = school;
            AccountManager.getInstance().saveLoginAccount(account);
        }
    }

    public HttpCacheStoreManager getHttpCacheStoreManager() {
        if (mHttpCacheStoreManager == null) {
            mHttpCacheStoreManager = new HttpCacheStoreManager(this);
        }
        return mHttpCacheStoreManager;
    }

    public FileStoreManager getFileStoreManager() {
        if (mFileStoreManager == null) {
            mFileStoreManager = new FileStoreManager(this);
        }
        return mFileStoreManager;
    }

    public SharePreferencesManager getPreferencesStoreManager() {
        if (mSharePreferencesManager == null) {
            mSharePreferencesManager = new SharePreferencesManager(this);
        }
        return mSharePreferencesManager;
    }

    public void updateToLoginAccount() {
        AccountManager.getInstance().commmitToDisk();
    }
}

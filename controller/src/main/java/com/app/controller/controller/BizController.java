package com.app.controller.controller;


import com.google.gson.Gson;
import com.app.controller.account.AccountManager;
import com.app.controller.bean.DepartmentBean;
import com.app.controller.bean.GetStudentListBean;
import com.app.controller.bean.GetTeacherListBean;
import com.app.controller.bean.HomeworkDetailBean;
import com.app.controller.bean.HomeworkListBean;
import com.app.controller.bean.HomeworkScoreListBean;
import com.app.controller.bean.MyGradeClassBean;
import com.app.controller.bean.StudentInfo;
import com.app.controller.bean.TeacherInfo;
import com.app.controller.bean.TodayCourseBean;
import com.app.controller.bean.XuedouDetailBean;
import com.app.controller.controller.core.BaseControllers;
import com.app.controller.controller.core.Controller;
import com.app.controller.controller.core.ControllerCacheParams;
import com.app.controller.controller.core.ControllerRunnable;
import com.app.controller.controller.core.Listener;
import com.app.controller.store.remote.store.HttpBizStore;

import java.util.HashMap;
import java.util.List;

import okhttp3.RequestBody;

/**
 * Description : 普通业务Controller
 * Creator : ZST
 * Data : 2017/8/25.
 */
public class BizController extends BaseControllers {

    private BizController() {

    }

    private static class SingletonHolder {
        private static final BizController INSTANCE = new BizController();
    }

    public static BizController getInstance() {
        return SingletonHolder.INSTANCE;
    }


    /**
     * 教职工列表查询
     */
    public Controller getTeacherList(final int departmentId, final String search, final String orderColumn, final String orderType, final int pageNum, final int pageSize, final Listener<GetTeacherListBean> listener) {
        return runDataController(new ControllerCacheParams(false, false, "getTeacherList"), listener, new ControllerRunnable<GetTeacherListBean>() {
            @Override
            public GetTeacherListBean run(Controller controller) {
                Gson gson = new Gson();
                HashMap<String, Object> paramsMap = new HashMap<>();
                paramsMap.put("departmentId", departmentId);
                paramsMap.put("search", search);
                paramsMap.put("orderColumn", orderColumn);
                paramsMap.put("orderType", orderType);
                paramsMap.put("pageNum", pageNum);
                paramsMap.put("pageSize", pageSize);
                String strEntity = gson.toJson(paramsMap);
                RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json;charset=UTF-8"), strEntity);
                return runData(getProtocol(HttpBizStore.class).getTeacherList(AccountManager.getInstance().getLoginAccount().getToken(), body));
            }
        });
    }

    /**
     * 教职工个人数据详情
     */
    public Controller getTeacherInfo(final int userId, final Listener<TeacherInfo> listener) {
        return runDataController(new ControllerCacheParams(false, false, "getTeacherInfo"), listener, new ControllerRunnable<TeacherInfo>() {
            @Override
            public TeacherInfo run(Controller controller) {
                Gson gson = new Gson();
                HashMap<String, Object> paramsMap = new HashMap<>();
                paramsMap.put("userId", userId);
                String strEntity = gson.toJson(paramsMap);
                RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json;charset=UTF-8"), strEntity);
                return runData(getProtocol(HttpBizStore.class).getTeacherInfo(AccountManager.getInstance().getLoginAccount().getToken(), body));
            }
        });
    }

    /**
     * 保存/新增教职工个人数据详情
     */
    public Controller saveTeacherInfo(final int userId, final int departmentId, final String name, final int role, final int isLeader, final String mobile, final String logo, final int sex, final String title, final String job, final int age, final String graduate, final String major, final String education, final String hometown, final Listener<Boolean> listener) {
        return runCommandController(AccountManager.getInstance().getLoginAccount(), listener, new ControllerRunnable<Boolean>() {
            @Override
            public Boolean run(Controller controller) {
                Gson gson = new Gson();
                HashMap<String, Object> paramsMap = new HashMap<>();
                paramsMap.put("userId", userId);
                paramsMap.put("departmentId", departmentId);
                paramsMap.put("name", name);
                paramsMap.put("role", role);
                paramsMap.put("isLeader", isLeader);
                paramsMap.put("mobile", mobile);
                paramsMap.put("logo", logo);
                paramsMap.put("sex", sex);
                paramsMap.put("title", title);
                paramsMap.put("job", job);
                paramsMap.put("age", age);
                paramsMap.put("graduate", graduate);
                paramsMap.put("major", major);
                paramsMap.put("education", education);
                paramsMap.put("hometown", hometown);
                String strEntity = gson.toJson(paramsMap);
                RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json;charset=UTF-8"), strEntity);
                return runData(getProtocol(HttpBizStore.class).saveTeacherInfo(AccountManager.getInstance().getLoginAccount().getToken(), body));
            }
        });
    }

    /**
     * 删除教职工
     */
    public Controller deleteTeacher(final int userId, final Listener<Boolean> listener) {
        return runCommandController(AccountManager.getInstance().getLoginAccount(), listener, new ControllerRunnable<Boolean>() {
            @Override
            public Boolean run(Controller controller) {
                Gson gson = new Gson();
                HashMap<String, Object> paramsMap = new HashMap<>();
                paramsMap.put("userId", userId);
                String strEntity = gson.toJson(paramsMap);
                RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json;charset=UTF-8"), strEntity);
                return runData(getProtocol(HttpBizStore.class).deleteTeacher(AccountManager.getInstance().getLoginAccount().getToken(), body));
            }
        });
    }

    /**
     * 学生列表查询
     */
    public Controller getStudentList(final int grade, final String search, final int sex, final int classNum, final String orderColumn, final String orderType, final int pageNum, final int pageSize, final Listener<GetStudentListBean> listener) {
        return runDataController(new ControllerCacheParams(false, false, "getTeacherList"), listener, new ControllerRunnable<GetStudentListBean>() {
            @Override
            public GetStudentListBean run(Controller controller) {
                Gson gson = new Gson();
                HashMap<String, Object> paramsMap = new HashMap<>();
                paramsMap.put("grade", grade);
                paramsMap.put("search", search);
                paramsMap.put("sex", sex);
                paramsMap.put("classNum", classNum);
                paramsMap.put("orderColumn", orderColumn);
                paramsMap.put("orderType", orderType);
                paramsMap.put("pageNum", pageNum);
                paramsMap.put("pageSize", pageSize);
                String strEntity = gson.toJson(paramsMap);
                RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json;charset=UTF-8"), strEntity);
                return runData(getProtocol(HttpBizStore.class).getStudentList(AccountManager.getInstance().getLoginAccount().getToken(), body));
            }
        });
    }

    /**
     * 保存/新增教职工个人数据详情
     */
    public Controller saveStudentInfo(final int userId, final String name, final String sno, final String logo, final String parentName, final String parentMobile,final int parentSex, final int gradeType, final int grade, final int classNum, final int sex, final String birthday, final String schoolDate, final Listener<Boolean> listener) {
        return runCommandController(AccountManager.getInstance().getLoginAccount(), listener, new ControllerRunnable<Boolean>() {
            @Override
            public Boolean run(Controller controller) {
                Gson gson = new Gson();
                HashMap<String, Object> paramsMap = new HashMap<>();
                paramsMap.put("userId", userId);
                paramsMap.put("name", name);
                paramsMap.put("sno", sno);
                paramsMap.put("logo", logo);
                paramsMap.put("parentName", parentName);
                paramsMap.put("parentMobile", parentMobile);
                paramsMap.put("parentSex", parentSex);
                paramsMap.put("gradeType", gradeType);
                paramsMap.put("grade", grade);
                paramsMap.put("classNum", classNum);
                paramsMap.put("sex", sex);
                paramsMap.put("birthday", birthday);
                paramsMap.put("schoolDate", schoolDate);
                String strEntity = gson.toJson(paramsMap);
                RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json;charset=UTF-8"), strEntity);
                return runData(getProtocol(HttpBizStore.class).saveStudentInfo(AccountManager.getInstance().getLoginAccount().getToken(), body));
            }
        });
    }

    /**
     * 学生个人数据详情
     */
    public Controller getStudentInfo(final int userId, final Listener<StudentInfo> listener) {
        return runDataController(new ControllerCacheParams(false, false, "getStudentInfo"), listener, new ControllerRunnable<StudentInfo>() {
            @Override
            public StudentInfo run(Controller controller) {
                Gson gson = new Gson();
                HashMap<String, Object> paramsMap = new HashMap<>();
                paramsMap.put("userId", userId);
                String strEntity = gson.toJson(paramsMap);
                RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json;charset=UTF-8"), strEntity);
                return runData(getProtocol(HttpBizStore.class).getStudentInfo(AccountManager.getInstance().getLoginAccount().getToken(), body));
            }
        });
    }

    /**
     * 删除学生
     */
    public Controller deleteStudent(final int userId, final Listener<Boolean> listener) {
        return runCommandController(AccountManager.getInstance().getLoginAccount(), listener, new ControllerRunnable<Boolean>() {
            @Override
            public Boolean run(Controller controller) {
                Gson gson = new Gson();
                HashMap<String, Object> paramsMap = new HashMap<>();
                paramsMap.put("userId", userId);
                String strEntity = gson.toJson(paramsMap);
                RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json;charset=UTF-8"), strEntity);
                return runData(getProtocol(HttpBizStore.class).deleteStudent(AccountManager.getInstance().getLoginAccount().getToken(), body));
            }
        });
    }

    /**
     * 家庭作业列表
     */
    public Controller getHomeworkList(final int timeChoice, final int pageNum, final int pageSize, final Listener<HomeworkListBean> listener) {
        return runDataController(new ControllerCacheParams(false, false, "getHomeworkList"), listener, new ControllerRunnable<HomeworkListBean>() {
            @Override
            public HomeworkListBean run(Controller controller) {
                Gson gson = new Gson();
                HashMap<String, Object> paramsMap = new HashMap<>();
                paramsMap.put("timeChoice", timeChoice);
                paramsMap.put("pageNum", pageNum);
                paramsMap.put("pageSize", pageSize);
                String strEntity = gson.toJson(paramsMap);
                RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json;charset=UTF-8"), strEntity);
                return runData(getProtocol(HttpBizStore.class).getHomeworkList(AccountManager.getInstance().getLoginAccount().getToken(), body));
            }
        });
    }

    /**
     * 提交/批改的作业详情
     */
    public Controller getHomeworkDetail(final int id,  final Listener<HomeworkDetailBean> listener) {
        return runDataController(new ControllerCacheParams(false, false, "getHomeworkDetail"), listener, new ControllerRunnable<HomeworkDetailBean>() {
            @Override
            public HomeworkDetailBean run(Controller controller) {
                Gson gson = new Gson();
                HashMap<String, Object> paramsMap = new HashMap<>();
                paramsMap.put("id", id);
                String strEntity = gson.toJson(paramsMap);
                RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json;charset=UTF-8"), strEntity);
                return runData(getProtocol(HttpBizStore.class).getHomeworkDetail(AccountManager.getInstance().getLoginAccount().getToken(), body));
            }
        });
    }

    /**
     * 家长提交作业
     */
    public Controller submitHomework(final int id, final int workId, final String content, final String studentAttach, final Listener<Integer> listener) {
        return runCommandController(AccountManager.getInstance().getLoginAccount(), listener, new ControllerRunnable<Integer>() {
            @Override
            public Integer run(Controller controller) {
                Gson gson = new Gson();
                HashMap<String, Object> paramsMap = new HashMap<>();
                if(id > 0){
                    paramsMap.put("id", id);
                }
                paramsMap.put("workId", workId);
                paramsMap.put("content", content);
                paramsMap.put("studentAttach", studentAttach);
                String strEntity = gson.toJson(paramsMap);
                RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json;charset=UTF-8"), strEntity);
                return runData(getProtocol(HttpBizStore.class).submitHomework(AccountManager.getInstance().getLoginAccount().getToken(), body));
            }
        });
    }

    /**
     * 批改列表
     */
    public Controller getHomeworkScoreList(final int id, final Listener<HomeworkScoreListBean> listener) {
        return runCommandController(AccountManager.getInstance().getLoginAccount(), listener, new ControllerRunnable<HomeworkScoreListBean>() {
            @Override
            public HomeworkScoreListBean run(Controller controller) {
                Gson gson = new Gson();
                HashMap<String, Object> paramsMap = new HashMap<>();
                paramsMap.put("id", id);
                String strEntity = gson.toJson(paramsMap);
                RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json;charset=UTF-8"), strEntity);
                return runData(getProtocol(HttpBizStore.class).getHomeworkScoreList(AccountManager.getInstance().getLoginAccount().getToken(), body));
            }
        });
    }

    /**
     * 发布作业
     */
    public Controller getHomeworkScoreList(final int id, final int gradeType, final int grade, final int classNum, final String subject, final String content, final int onlineSubmit, final Listener<Integer> listener) {
        return runCommandController(AccountManager.getInstance().getLoginAccount(), listener, new ControllerRunnable<Integer>() {
            @Override
            public Integer run(Controller controller) {
                Gson gson = new Gson();
                HashMap<String, Object> paramsMap = new HashMap<>();
                paramsMap.put("id", id);
                paramsMap.put("gradeType", gradeType);
                paramsMap.put("grade", grade);
                paramsMap.put("classNum", classNum);
                paramsMap.put("subject", subject);
                paramsMap.put("content", content);
                paramsMap.put("onlineSubmit", onlineSubmit);
                String strEntity = gson.toJson(paramsMap);
                RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json;charset=UTF-8"), strEntity);
                return runData(getProtocol(HttpBizStore.class).publishHomework(AccountManager.getInstance().getLoginAccount().getToken(), body));
            }
        });
    }

    /**
     * 我教学的班级
     */
    public Controller getMyGradeClass(final Listener<List<MyGradeClassBean>> listener) {
        return runCommandController(AccountManager.getInstance().getLoginAccount(), listener, new ControllerRunnable<List<MyGradeClassBean>>() {
            @Override
            public List<MyGradeClassBean> run(Controller controller) {
                return runData(getProtocol(HttpBizStore.class).getMyGradeClass(AccountManager.getInstance().getLoginAccount().getToken()));
            }
        });
    }

    public Controller revertHomework(final int id,final Listener<Boolean> listener) {
        return runCommandController(AccountManager.getInstance().getLoginAccount(), listener, new ControllerRunnable<Boolean>() {
            @Override
            public Boolean run(Controller controller) {
                Gson gson = new Gson();
                HashMap<String, Object> paramsMap = new HashMap<>();
                paramsMap.put("id", id);
                String strEntity = gson.toJson(paramsMap);
                RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json;charset=UTF-8"), strEntity);
                return runData(getProtocol(HttpBizStore.class).revertHomework(AccountManager.getInstance().getLoginAccount().getToken(),body));
            }
        });
    }

    /**
     * 教师批改作业
     */
    public Controller correctHomework(final int id,final String score,final String remark,final int isLike,final int isRecommend,final String teacherAttach,final Listener<Boolean> listener) {
        return runCommandController(AccountManager.getInstance().getLoginAccount(), listener, new ControllerRunnable<Boolean>() {
            @Override
            public Boolean run(Controller controller) {
                Gson gson = new Gson();
                HashMap<String, Object> paramsMap = new HashMap<>();
                paramsMap.put("id", id);
                paramsMap.put("score", score);
                paramsMap.put("remark", remark);
                paramsMap.put("isLike", isLike);
                paramsMap.put("isRecommend", isRecommend);
                paramsMap.put("teacherAttach", teacherAttach);
                String strEntity = gson.toJson(paramsMap);
                RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json;charset=UTF-8"), strEntity);
                return runData(getProtocol(HttpBizStore.class).correctHomework(AccountManager.getInstance().getLoginAccount().getToken(),body));
            }
        });
    }

    /**
     * 获奖作业列表
     */
    public Controller recommendList(final int id,final Listener<List<HomeworkDetailBean>> listener) {
        return runCommandController(AccountManager.getInstance().getLoginAccount(), listener, new ControllerRunnable<List<HomeworkDetailBean>>() {
            @Override
            public List<HomeworkDetailBean> run(Controller controller) {
                Gson gson = new Gson();
                HashMap<String, Object> paramsMap = new HashMap<>();
                paramsMap.put("id", id);
                String strEntity = gson.toJson(paramsMap);
                RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json;charset=UTF-8"), strEntity);
                return runData(getProtocol(HttpBizStore.class).recommendList(AccountManager.getInstance().getLoginAccount().getToken(),body));
            }
        });
    }

    /**
     * 我的今日课程
     */
    public Controller getTodayList(final Listener<List<TodayCourseBean>> listener) {
        return runCommandController(AccountManager.getInstance().getLoginAccount(), listener, new ControllerRunnable<List<TodayCourseBean>>() {
            @Override
            public List<TodayCourseBean> run(Controller controller) {
                return runData(getProtocol(HttpBizStore.class).getTodayList(AccountManager.getInstance().getLoginAccount().getToken()));
            }
        });
    }

    //部门列表
    public Controller getDepartmentList(final Listener<List<DepartmentBean>> listener) {
        return runCommandController(AccountManager.getInstance().getLoginAccount(), listener, new ControllerRunnable<List<DepartmentBean>>() {
            @Override
            public List<DepartmentBean> run(Controller controller) {
                return runData(getProtocol(HttpBizStore.class).getDepartmentList(AccountManager.getInstance().getLoginAccount().getToken()));
            }
        });
    }
    //编辑架构
    public Controller saveSchool(final int id,final String name,final String address,final String mobile,final Listener<Integer> listener) {
        return runCommandController(AccountManager.getInstance().getLoginAccount(), listener, new ControllerRunnable<Integer>() {
            @Override
            public Integer run(Controller controller) {
                Gson gson = new Gson();
                HashMap<String, Object> paramsMap = new HashMap<>();
                paramsMap.put("id", id);
                paramsMap.put("name", name);
                paramsMap.put("address", address);
                paramsMap.put("mobile", mobile);
                String strEntity = gson.toJson(paramsMap);
                RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json;charset=UTF-8"), strEntity);
                return runData(getProtocol(HttpBizStore.class).saveSchool(AccountManager.getInstance().getLoginAccount().getToken(),body));
            }
        });
    }

    //编辑架构
    public Controller saveDepartment(final int id,final String name,final String mobile,final Listener<Integer> listener) {
        return runCommandController(AccountManager.getInstance().getLoginAccount(), listener, new ControllerRunnable<Integer>() {
            @Override
            public Integer run(Controller controller) {
                Gson gson = new Gson();
                HashMap<String, Object> paramsMap = new HashMap<>();
                if(id > 0){
                    paramsMap.put("id", id);
                }
                paramsMap.put("name", name);
                paramsMap.put("mobile", mobile);
                String strEntity = gson.toJson(paramsMap);
                RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json;charset=UTF-8"), strEntity);
                return runData(getProtocol(HttpBizStore.class).saveDepartment(AccountManager.getInstance().getLoginAccount().getToken(),body));
            }
        });
    }


    //意见反馈
    public Controller feedback(final String title,final String content,final String images,final int anonymous,final Listener<Boolean> listener) {
        return runCommandController(AccountManager.getInstance().getLoginAccount(), listener, new ControllerRunnable<Boolean>() {
            @Override
            public Boolean run(Controller controller) {
                Gson gson = new Gson();
                HashMap<String, Object> paramsMap = new HashMap<>();
                paramsMap.put("title", title);
                paramsMap.put("content", content);
                paramsMap.put("images", images);
                paramsMap.put("anonymous", anonymous);
                String strEntity = gson.toJson(paramsMap);
                RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json;charset=UTF-8"), strEntity);
                return runData(getProtocol(HttpBizStore.class).feedback(AccountManager.getInstance().getLoginAccount().getToken(),body));
            }
        });
    }

    //学豆详情
    public Controller xuedouDetail(final int userId,final Listener<XuedouDetailBean> listener) {
        return runCommandController(AccountManager.getInstance().getLoginAccount(), listener, new ControllerRunnable<XuedouDetailBean>() {
            @Override
            public XuedouDetailBean run(Controller controller) {
                Gson gson = new Gson();
                HashMap<String, Object> paramsMap = new HashMap<>();
                paramsMap.put("userId", userId);
                String strEntity = gson.toJson(paramsMap);
                RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json;charset=UTF-8"), strEntity);
                return runData(getProtocol(HttpBizStore.class).xuedouDetail(AccountManager.getInstance().getLoginAccount().getToken(),body));
            }
        });
    }

    //领取学豆
    public Controller xuedouCollect(final int userId,final Listener<XuedouDetailBean> listener) {
        return runCommandController(AccountManager.getInstance().getLoginAccount(), listener, new ControllerRunnable<XuedouDetailBean>() {
            @Override
            public XuedouDetailBean run(Controller controller) {
                Gson gson = new Gson();
                HashMap<String, Object> paramsMap = new HashMap<>();
                paramsMap.put("userId", userId);
                String strEntity = gson.toJson(paramsMap);
                RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json;charset=UTF-8"), strEntity);
                return runData(getProtocol(HttpBizStore.class).xuedouCollect(AccountManager.getInstance().getLoginAccount().getToken(),body));
            }
        });
    }
    //
    public Controller addAction(final int studentId,final int type,final Listener<Integer> listener) {
        return runCommandController(AccountManager.getInstance().getLoginAccount(), listener, new ControllerRunnable<Integer>() {
            @Override
            public Integer run(Controller controller) {
                Gson gson = new Gson();
                HashMap<String, Object> paramsMap = new HashMap<>();
                paramsMap.put("studentId", studentId);
                paramsMap.put("type", type);
                String strEntity = gson.toJson(paramsMap);
                RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json;charset=UTF-8"), strEntity);
                return runData(getProtocol(HttpBizStore.class).addAction(AccountManager.getInstance().getLoginAccount().getToken(),body));
            }
        });
    }
}

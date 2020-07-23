package com.app.controller.controller;

import com.google.gson.Gson;
import com.app.controller.account.AccountManager;
import com.app.controller.bean.ClassInfo;
import com.app.controller.bean.CourseListBean;
import com.app.controller.bean.GoodListBean;
import com.app.controller.bean.GradeClassBean;
import com.app.controller.bean.LessonPageBean;
import com.app.controller.bean.MyCourseListBean;
import com.app.controller.bean.RecommendListBean;
import com.app.controller.controller.core.BaseControllers;
import com.app.controller.controller.core.Controller;
import com.app.controller.controller.core.ControllerCacheParams;
import com.app.controller.controller.core.ControllerRunnable;
import com.app.controller.controller.core.Listener;
import com.app.controller.store.remote.store.HttpCourseStore;
import com.app.library.utils.StringUtils;

import java.util.HashMap;
import java.util.List;

import okhttp3.RequestBody;

public class CourseController extends BaseControllers {
    private CourseController() {

    }

    private static class SingletonHolder {
        private static final CourseController INSTANCE = new CourseController();
    }

    public static CourseController getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public Controller getCourseList(final int type, final int grade, final int classNum,
                                 final Listener<List<CourseListBean>> listener) {
        return runDataController(new ControllerCacheParams(false, false, "getCourseList"), listener, new ControllerRunnable<List<CourseListBean>>() {
            @Override
            public List<CourseListBean> run(Controller controller) {
                Gson gson = new Gson();
                HashMap<String, Object> paramsMap = new HashMap<>();
                paramsMap.put("type", type);
                paramsMap.put("grade", grade);
                paramsMap.put("classNum", classNum);
                String strEntity = gson.toJson(paramsMap);
                RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json;charset=UTF-8"), strEntity);
                return runData(getProtocol(HttpCourseStore.class).getCourseList(AccountManager.getInstance().getLoginAccount().getToken(), body));
            }
        });
    }
    public Controller getMyCourseList(final Listener<List<MyCourseListBean>> listener) {
        return runDataController(new ControllerCacheParams(false, false, "getMyCourseList"), listener, new ControllerRunnable<List<MyCourseListBean>>() {
            @Override
            public List<MyCourseListBean> run(Controller controller) {
                Gson gson = new Gson();
                HashMap<String, Object> paramsMap = new HashMap<>();
                String strEntity = gson.toJson(paramsMap);
                RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json;charset=UTF-8"), strEntity);
                return runData(getProtocol(HttpCourseStore.class).getMyCourseList(AccountManager.getInstance().getLoginAccount().getToken(), body));
            }
        });
    }

    public Controller getOnlineList(final int type, final int pageNum, final int pageSize,
                                    final Listener<LessonPageBean> listener) {
        return runDataController(new ControllerCacheParams(false, false, "getOnlineList"), listener, new ControllerRunnable<LessonPageBean>() {
            @Override
            public LessonPageBean run(Controller controller) {
                Gson gson = new Gson();
                HashMap<String, Object> paramsMap = new HashMap<>();
                paramsMap.put("type", type);
                paramsMap.put("pageNum", pageNum);
                paramsMap.put("pageSize", pageSize);
                String strEntity = gson.toJson(paramsMap);
                RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json;charset=UTF-8"), strEntity);
                return runData(getProtocol(HttpCourseStore.class).getOnlineList(AccountManager.getInstance().getLoginAccount().getToken(), body));
            }
        });
    }

    public Controller saveCourse(final String id,final String title,
                                 final String type,final String accessType,
                                 final String description,
                                 final String url,
                                 final List<GradeClassBean> selectGrade,
                                 final Listener<Integer> listener) {
        return runDataController(new ControllerCacheParams(false, false, "saveCourse"), listener, new ControllerRunnable<Integer>() {
            @Override
            public Integer run(Controller controller) {
                Gson gson = new Gson();
                HashMap<String, Object> paramsMap = new HashMap<>();
                if (!StringUtils.isEmpty(id)){
                    paramsMap.put("id", id);
                }
                if (!StringUtils.isEmpty(url)){
                    paramsMap.put("url", url);
                    paramsMap.put("logo", url);
                }
                if (selectGrade!=null && selectGrade.size() !=0){
                    paramsMap.put("classList", selectGrade);
                }
                paramsMap.put("title", title);
                paramsMap.put("type", type);
                paramsMap.put("accessType", accessType);
                paramsMap.put("description", description);
                String strEntity = gson.toJson(paramsMap);
                RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json;charset=UTF-8"), strEntity);
                return runData(getProtocol(HttpCourseStore.class).saveCourse(AccountManager.getInstance().getLoginAccount().getToken(), body));
            }
        });
    }
    public Controller saveCourseTable(final int id,final int grade,
                                 final int type,final int classNum,
                                 final int weekday,
                                 final int num,
                                 final String startTime,
                                 final String endTime,
                                 final String address,
                                 final String courseName,
                                 final int userId,
                                 final Listener<Integer> listener) {
        return runDataController(new ControllerCacheParams(false, false, "saveCourse"), listener, new ControllerRunnable<Integer>() {
            @Override
            public Integer run(Controller controller) {
                Gson gson = new Gson();
                HashMap<String, Object> paramsMap = new HashMap<>();
                if (id != 0){
                    paramsMap.put("id", id);
                }
                if (userId != 0){
                    paramsMap.put("userId", userId);
                }
                paramsMap.put("grade", grade);
                paramsMap.put("type", type);
                paramsMap.put("classNum", classNum);
                paramsMap.put("weekday", weekday);
                paramsMap.put("num", num);
                if (!StringUtils.isEmptyOrBlank(startTime)){
                    paramsMap.put("startTime", startTime);
                }
                if (!StringUtils.isEmptyOrBlank(endTime)){
                    paramsMap.put("endTime", endTime);
                }
                if (!StringUtils.isEmptyOrBlank(address)){
                    paramsMap.put("address", address);
                }
                if (!StringUtils.isEmptyOrBlank(courseName)){
                    paramsMap.put("courseName", courseName);
                }
                String strEntity = gson.toJson(paramsMap);
                RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json;charset=UTF-8"), strEntity);
                return runData(getProtocol(HttpCourseStore.class).saveCourseTable(AccountManager.getInstance().getLoginAccount().getToken(), body));
            }
        });
    }
    public Controller readCourse(final Integer id,
                                 final Listener<Integer> listener) {
        return runDataController(new ControllerCacheParams(false, false, "readCourse"), listener, new ControllerRunnable<Integer>() {
            @Override
            public Integer run(Controller controller) {
                Gson gson = new Gson();
                HashMap<String, Integer> paramsMap = new HashMap<>();
                paramsMap.put("id", id);
                String strEntity = gson.toJson(paramsMap);
                RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json;charset=UTF-8"), strEntity);
                return runData(getProtocol(HttpCourseStore.class).readCourse(AccountManager.getInstance().getLoginAccount().getToken(), body));
            }
        });
    }

    public Controller courseClass(final Listener<List<ClassInfo>> listener) {

        return runDataController(new ControllerCacheParams(false, false, "courseClass"), listener, new ControllerRunnable<List<ClassInfo>>() {
            @Override
            public List<ClassInfo> run(Controller controller) {
                Gson gson = new Gson();
                HashMap<String, Object> paramsMap = new HashMap<>();
                String strEntity = gson.toJson(paramsMap);
                RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json;charset=UTF-8"), strEntity);
                return runData(getProtocol(HttpCourseStore.class).courseClass(AccountManager.getInstance().getLoginAccount().getToken(), body));
            }
        });
    }

    public Controller goodList(final Integer userId,final Integer pageNum,final Integer pageSize,final Listener<GoodListBean> listener) {

        return runDataController(new ControllerCacheParams(false, false, "courseClass"), listener, new ControllerRunnable<GoodListBean>() {
            @Override
            public GoodListBean run(Controller controller) {
                Gson gson = new Gson();
                HashMap<String, Object> paramsMap = new HashMap<>();
                paramsMap.put("userId", userId);
                paramsMap.put("pageNum", pageNum);
                paramsMap.put("pageSize", pageSize);
                String strEntity = gson.toJson(paramsMap);
                RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json;charset=UTF-8"), strEntity);
                return runData(getProtocol(HttpCourseStore.class).goodList(AccountManager.getInstance().getLoginAccount().getToken(), body));
            }
        });
    }

    public Controller getRecommendList2(final Integer pageNum,final Integer pageSize,final Listener<RecommendListBean> listener) {

        return runDataController(new ControllerCacheParams(false, false, "courseClass"), listener, new ControllerRunnable<RecommendListBean>() {
            @Override
            public RecommendListBean run(Controller controller) {
                Gson gson = new Gson();
                HashMap<String, Object> paramsMap = new HashMap<>();
                paramsMap.put("pageNum", pageNum);
                paramsMap.put("pageSize", pageSize);
                String strEntity = gson.toJson(paramsMap);
                RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json;charset=UTF-8"), strEntity);
                return runData(getProtocol(HttpCourseStore.class).getRecommendList2(AccountManager.getInstance().getLoginAccount().getToken(), body));
            }
        });
    }
}

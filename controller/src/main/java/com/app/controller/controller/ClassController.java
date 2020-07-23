package com.app.controller.controller;

import com.google.gson.Gson;
import com.app.controller.account.AccountManager;
import com.app.controller.bean.ClassInfo;
import com.app.controller.bean.DutyBean;
import com.app.controller.bean.DutyWeekday;
import com.app.controller.bean.DutyWeekdays;
import com.app.controller.bean.GradeInfoBean;
import com.app.controller.bean.JobBean;
import com.app.controller.bean.StudentInfo;
import com.app.controller.controller.core.BaseControllers;
import com.app.controller.controller.core.Controller;
import com.app.controller.controller.core.ControllerCacheParams;
import com.app.controller.controller.core.ControllerRunnable;
import com.app.controller.controller.core.Listener;
import com.app.controller.store.remote.store.HttpClassStore;

import java.util.HashMap;
import java.util.List;

import okhttp3.RequestBody;

public class ClassController extends BaseControllers {
    private ClassController() {

    }

    private static class SingletonHolder {
        private static final ClassController INSTANCE = new ClassController();
    }

    public static ClassController getInstance() {
        return ClassController.SingletonHolder.INSTANCE;
    }

    /**
     *
     *
     * @param type
     * @param grade
     * @param classNum
     * @param listener
     * @return
     */
    public Controller getStudentList(final int type, final int grade, final int classNum,  final Listener<List<StudentInfo>> listener) {

        return runDataController(new ControllerCacheParams(false, false, "getTeacherList"), listener, new ControllerRunnable<List<StudentInfo>>() {
            @Override
            public List<StudentInfo> run(Controller controller) {
                Gson gson = new Gson();
                HashMap<String, Object> paramsMap = new HashMap<>();
                paramsMap.put("type", type);
                paramsMap.put("grade", grade);
                paramsMap.put("classNum", classNum);
                String strEntity = gson.toJson(paramsMap);
                RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json;charset=UTF-8"), strEntity);
                return runData(getProtocol(HttpClassStore.class).getStudentList(AccountManager.getInstance().getLoginAccount().getToken(), body));
            }
        });
    }

    /**
     *
     *
     * @param type
     * @param grade
     * @param classNum
     * @param listener
     * @return
     */
    public Controller getStudentJobList(final int type, final int grade, final int classNum,  final Listener<List<JobBean>> listener) {

        return runDataController(new ControllerCacheParams(false, false, "getStudentJobList"), listener, new ControllerRunnable<List<JobBean>>() {
            @Override
            public List<JobBean> run(Controller controller) {
                Gson gson = new Gson();
                HashMap<String, Object> paramsMap = new HashMap<>();
                paramsMap.put("type", type);
                paramsMap.put("grade", grade);
                paramsMap.put("classNum", classNum);
                String strEntity = gson.toJson(paramsMap);
                RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json;charset=UTF-8"), strEntity);
                return runData(getProtocol(HttpClassStore.class).getStudentJobList(AccountManager.getInstance().getLoginAccount().getToken(), body));
            }
        });
    }

    /**
     *
     * @param type
     * @param grade
     * @param classNum
     * @param listener
     * @return
     */
    public Controller getStudentDutyToday(final int type, final int grade, final int classNum,  final Listener<List<DutyWeekdays>> listener) {

        return runDataController(new ControllerCacheParams(false, false, "getStudentDutyToday"), listener, new ControllerRunnable<List<DutyWeekdays>>() {
            @Override
            public List<DutyWeekdays> run(Controller controller) {
                Gson gson = new Gson();
                HashMap<String, Object> paramsMap = new HashMap<>();
                paramsMap.put("type", type);
                paramsMap.put("grade", grade);
                paramsMap.put("classNum", classNum);
                String strEntity = gson.toJson(paramsMap);
                RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json;charset=UTF-8"), strEntity);
                return runData(getProtocol(HttpClassStore.class).getStudentDutyToday(AccountManager.getInstance().getLoginAccount().getToken(), body));
            }
        });
    }

    /**
     *
     * @param type
     * @param grade
     * @param classNum
     * @param listener
     * @return
     */
    public Controller getStudentDutyList(final int type, final int grade, final int classNum,  final Listener<List<DutyBean>> listener) {

        return runDataController(new ControllerCacheParams(false, false, "getStudentDutyList"), listener, new ControllerRunnable<List<DutyBean>>() {
            @Override
            public List<DutyBean> run(Controller controller) {
                Gson gson = new Gson();
                HashMap<String, Object> paramsMap = new HashMap<>();
                paramsMap.put("type", type);
                paramsMap.put("grade", grade);
                paramsMap.put("classNum", classNum);
                String strEntity = gson.toJson(paramsMap);
                RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json;charset=UTF-8"), strEntity);
                return runData(getProtocol(HttpClassStore.class).getStudentDutyList(AccountManager.getInstance().getLoginAccount().getToken(), body));
            }
        });
    }

    public Controller saveStudentDuty(final int dutyNum, final String dutyContent, final List<DutyWeekday> dutyWeekday, final Listener<Integer> listener) {

        return runDataController(new ControllerCacheParams(false, false, "saveStudentDuty"), listener, new ControllerRunnable<Integer>() {
            @Override
            public Integer run(Controller controller) {
                Gson gson = new Gson();
                HashMap<String, Object> paramsMap = new HashMap<>();
                if (dutyNum !=0){
                    paramsMap.put("dutyNum", dutyNum);
                }
                paramsMap.put("dutyContent", dutyContent);
                paramsMap.put("dutyWeekdays", dutyWeekday);
                String strEntity = gson.toJson(paramsMap);
                RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json;charset=UTF-8"), strEntity);
                return runData(getProtocol(HttpClassStore.class).saveStudentDuty(AccountManager.getInstance().getLoginAccount().getToken(), body));
            }
        });
    }
    public Controller deleteStudentDuty(final int dutyNum, final Listener<Integer> listener) {

        return runDataController(new ControllerCacheParams(false, false, "deleteStudentDuty"), listener, new ControllerRunnable<Integer>() {
            @Override
            public Integer run(Controller controller) {
                Gson gson = new Gson();
                HashMap<String, Object> paramsMap = new HashMap<>();
                paramsMap.put("dutyNum", dutyNum);
                String strEntity = gson.toJson(paramsMap);
                RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json;charset=UTF-8"), strEntity);
                return runData(getProtocol(HttpClassStore.class).deleteStudentDuty(AccountManager.getInstance().getLoginAccount().getToken(), body));
            }
        });
    }
    public Controller getStudentDutyDetail(final int dutyNum, final Listener<DutyBean> listener) {
        return runDataController(new ControllerCacheParams(false, false, "getStudentDutyDetail"), listener, new ControllerRunnable<DutyBean>() {
            @Override
            public DutyBean run(Controller controller) {
                Gson gson = new Gson();
                HashMap<String, Object> paramsMap = new HashMap<>();
                paramsMap.put("dutyNum", dutyNum);
                String strEntity = gson.toJson(paramsMap);
                RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json;charset=UTF-8"), strEntity);
                return runData(getProtocol(HttpClassStore.class).getStudentDutyDetail(AccountManager.getInstance().getLoginAccount().getToken(), body));
            }
        });
    }

    /**
     * @param listener
     * @return
     */
    public Controller saveStudentJobList(final int id, final int userId, final String job,  final Listener<Integer> listener) {

        return runDataController(new ControllerCacheParams(false, false, "saveStudentJobList"), listener, new ControllerRunnable<Integer>() {
            @Override
            public Integer run(Controller controller) {
                Gson gson = new Gson();
                HashMap<String, Object> paramsMap = new HashMap<>();
                if (id !=0){paramsMap.put("id", id);}
                paramsMap.put("userId", userId);
                paramsMap.put("job", job);
                String strEntity = gson.toJson(paramsMap);
                RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json;charset=UTF-8"), strEntity);
                return runData(getProtocol(HttpClassStore.class).saveStudentJob(AccountManager.getInstance().getLoginAccount().getToken(), body));
            }
        });
    }
    public Controller getClassList(final int type, final int grade,  final Listener<List<ClassInfo>> listener) {

        return runDataController(new ControllerCacheParams(false, false, "getStudentDutyList"), listener, new ControllerRunnable<List<ClassInfo>>() {
            @Override
            public List<ClassInfo> run(Controller controller) {
                Gson gson = new Gson();
                HashMap<String, Object> paramsMap = new HashMap<>();
                paramsMap.put("type", type);
                paramsMap.put("grade", grade);
                String strEntity = gson.toJson(paramsMap);
                RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json;charset=UTF-8"), strEntity);
                return runData(getProtocol(HttpClassStore.class).getClassList(AccountManager.getInstance().getLoginAccount().getToken(), body));
            }
        });
    }
    public Controller getGradeList(final Listener<List<GradeInfoBean>> listener) {

        return runDataController(new ControllerCacheParams(false, false, "getGradeList"), listener, new ControllerRunnable<List<GradeInfoBean>>() {
            @Override
            public List<GradeInfoBean> run(Controller controller) {
                Gson gson = new Gson();
                HashMap<String, Object> paramsMap = new HashMap<>();
                String strEntity = gson.toJson(paramsMap);
                RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json;charset=UTF-8"), strEntity);
                return runData(getProtocol(HttpClassStore.class).getGradeList(AccountManager.getInstance().getLoginAccount().getToken(), body));
            }
        });
    }
    public Controller saveGrade(final int type, final int grade,final Listener<Integer> listener) {
        return runDataController(new ControllerCacheParams(false, false, "saveGrade"), listener, new ControllerRunnable<Integer>() {
            @Override
            public Integer run(Controller controller) {
                Gson gson = new Gson();
                HashMap<String, Object> paramsMap = new HashMap<>();
                paramsMap.put("type", type);
                paramsMap.put("grade", grade);
                String strEntity = gson.toJson(paramsMap);
                RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json;charset=UTF-8"), strEntity);
                return runData(getProtocol(HttpClassStore.class).saveGrade(AccountManager.getInstance().getLoginAccount().getToken(), body));
            }
        });
    }
    public Controller deleteGrade(final int type, final int grade,final Listener<Integer> listener) {
        return runDataController(new ControllerCacheParams(false, false, "deleteGrade"), listener, new ControllerRunnable<Integer>() {
            @Override
            public Integer run(Controller controller) {
                Gson gson = new Gson();
                HashMap<String, Object> paramsMap = new HashMap<>();
                paramsMap.put("type", type);
                paramsMap.put("grade", grade);
                String strEntity = gson.toJson(paramsMap);
                RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json;charset=UTF-8"), strEntity);
                return runData(getProtocol(HttpClassStore.class).deleteGrade(AccountManager.getInstance().getLoginAccount().getToken(), body));
            }
        });
    }
    public Controller saveClass(final int type, final int grade,final int classNum, final int userId,final Listener<Integer> listener) {
        return runDataController(new ControllerCacheParams(false, false, "saveGrade"), listener, new ControllerRunnable<Integer>() {
            @Override
            public Integer run(Controller controller) {
                Gson gson = new Gson();
                HashMap<String, Object> paramsMap = new HashMap<>();
                paramsMap.put("type", type);
                paramsMap.put("grade", grade);
                paramsMap.put("classNum", classNum);
                paramsMap.put("userId", userId);
                String strEntity = gson.toJson(paramsMap);
                RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json;charset=UTF-8"), strEntity);
                return runData(getProtocol(HttpClassStore.class).saveClass(AccountManager.getInstance().getLoginAccount().getToken(), body));
            }
        });
    }
    public Controller deleteClass(final int type, final int grade,final int classNum, final Listener<Integer> listener) {
        return runDataController(new ControllerCacheParams(false, false, "saveGrade"), listener, new ControllerRunnable<Integer>() {
            @Override
            public Integer run(Controller controller) {
                Gson gson = new Gson();
                HashMap<String, Object> paramsMap = new HashMap<>();
                paramsMap.put("type", type);
                paramsMap.put("grade", grade);
                paramsMap.put("classNum", classNum);
                String strEntity = gson.toJson(paramsMap);
                RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json;charset=UTF-8"), strEntity);
                return runData(getProtocol(HttpClassStore.class).deleteClass(AccountManager.getInstance().getLoginAccount().getToken(), body));
            }
        });
    }
}

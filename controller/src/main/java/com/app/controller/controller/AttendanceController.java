package com.app.controller.controller;

import com.google.gson.Gson;
import com.app.controller.account.AccountManager;
import com.app.controller.bean.AttendanceConfigBean;
import com.app.controller.bean.AuditConfigBean;
import com.app.controller.bean.CourseAttendBean;
import com.app.controller.bean.LeaseListBean;
import com.app.controller.bean.LeaveStudentBean;
import com.app.controller.bean.LeaveTeacherBean;
import com.app.controller.bean.MyClockForStudentListBean;
import com.app.controller.bean.MyClockForTeacherListBean;
import com.app.controller.bean.StatClassSummary;
import com.app.controller.bean.StatClassSummaryDetail;
import com.app.controller.bean.StatSchoolSummaryBean;
import com.app.controller.bean.StatSchoolTeacherSummaryBean;
import com.app.controller.bean.StatSchoolUserSummaryBean;
import com.app.controller.bean.StatTeacherSummaryBean;
import com.app.controller.bean.StatUserSummaryBean;
import com.app.controller.controller.core.BaseControllers;
import com.app.controller.controller.core.Controller;
import com.app.controller.controller.core.ControllerCacheParams;
import com.app.controller.controller.core.ControllerRunnable;
import com.app.controller.controller.core.Listener;
import com.app.controller.store.remote.store.HttpAttendanceStore;
import com.app.library.utils.StringUtils;

import java.util.HashMap;

import okhttp3.RequestBody;

public class AttendanceController extends BaseControllers {
    private AttendanceController() {

    }

    private static class SingletonHolder {
        private static final AttendanceController INSTANCE = new AttendanceController();
    }

    public static AttendanceController getInstance() {
        return SingletonHolder.INSTANCE;
    }

    /**
     * @return
     */
    public Controller applyLeave(final int leaveType, final String startTime,final String endTime,final String reason,final String images,
                                       final Listener listener) {
        return runDataController(new ControllerCacheParams(false, false, "applyLeave"), listener, new ControllerRunnable<Object>() {
            @Override
            public Object run(Controller controller) {
                Gson gson = new Gson();
                HashMap<String, Object> paramsMap = new HashMap<>();

                if (!StringUtils.isEmpty(images)){
                    paramsMap.put("images", images);
                }
                paramsMap.put("leaveType", leaveType);
                paramsMap.put("startTime", startTime);
                paramsMap.put("endTime", endTime);
                paramsMap.put("reason", reason);
                String strEntity = gson.toJson(paramsMap);
                RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json;charset=UTF-8"), strEntity);
                return runData(getProtocol(HttpAttendanceStore.class).applyLeave(AccountManager.getInstance().getLoginAccount().getToken(), body));
            }
        });
    }
    public Controller applyStudentLeave(final int studentId,final int leaveType, final String startTime,final String endTime,final String reason,final String images,
                                 final Listener listener) {
        return runDataController(new ControllerCacheParams(false, false, "applyLeave"), listener, new ControllerRunnable<Object>() {
            @Override
            public Object run(Controller controller) {
                Gson gson = new Gson();
                HashMap<String, Object> paramsMap = new HashMap<>();

                if (!StringUtils.isEmpty(images)){
                    paramsMap.put("images", images);
                }
                paramsMap.put("leaveType", leaveType);
                paramsMap.put("startTime", startTime);
                paramsMap.put("endTime", endTime);
                paramsMap.put("reason", reason);
                paramsMap.put("studentId", studentId);
                String strEntity = gson.toJson(paramsMap);
                RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json;charset=UTF-8"), strEntity);
                return runData(getProtocol(HttpAttendanceStore.class).applyStudentLeave(AccountManager.getInstance().getLoginAccount().getToken(), body));
            }
        });
    }

    public Controller listPersonal(final int auditStatus, final String startTime,final String endTime,final int pageNum,final int pageSize,
                                 final Listener listener) {
        return runDataController(new ControllerCacheParams(false, false, "listPersonal"), listener, new ControllerRunnable<LeaseListBean>() {
            @Override
            public LeaseListBean run(Controller controller) {
                Gson gson = new Gson();
                HashMap<String, Object> paramsMap = new HashMap<>();

                if (!StringUtils.isEmpty(startTime)){
                    paramsMap.put("startTime", startTime);
                }
                if (!StringUtils.isEmpty(endTime)){
                    paramsMap.put("endTime", endTime);
                }
                paramsMap.put("auditStatus", auditStatus);

                paramsMap.put("pageNum", pageNum);
                paramsMap.put("pageSize", pageSize);
                String strEntity = gson.toJson(paramsMap);
                RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json;charset=UTF-8"), strEntity);
                return runData(getProtocol(HttpAttendanceStore.class).listPersonal(AccountManager.getInstance().getLoginAccount().getToken(), body));
            }
        });
    }
    public Controller listStudentPersonal(final int auditStatus, final String startTime,final String endTime,final int pageNum,final int pageSize,
                                   final Listener listener) {
        return runDataController(new ControllerCacheParams(false, false, "listPersonal"), listener, new ControllerRunnable<LeaseListBean>() {
            @Override
            public LeaseListBean run(Controller controller) {
                Gson gson = new Gson();
                HashMap<String, Object> paramsMap = new HashMap<>();

                if (!StringUtils.isEmpty(startTime)){
                    paramsMap.put("startTime", startTime);
                }
                if (!StringUtils.isEmpty(endTime)){
                    paramsMap.put("endTime", endTime);
                }
                paramsMap.put("auditStatus", auditStatus);

                paramsMap.put("pageNum", pageNum);
                paramsMap.put("pageSize", pageSize);
                String strEntity = gson.toJson(paramsMap);
                RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json;charset=UTF-8"), strEntity);
                return runData(getProtocol(HttpAttendanceStore.class).listStudentPersonal(AccountManager.getInstance().getLoginAccount().getToken(), body));
            }
        });
    }
    public Controller findAudits(final int auditStatus, final String startTime,final String endTime,final int pageNum,final int pageSize,
                                   final Listener listener) {
        return runDataController(new ControllerCacheParams(false, false, "findAudits"), listener, new ControllerRunnable<LeaseListBean>() {
            @Override
            public LeaseListBean run(Controller controller) {
                Gson gson = new Gson();
                HashMap<String, Object> paramsMap = new HashMap<>();

                if (!StringUtils.isEmpty(startTime)){
                    paramsMap.put("startTime", startTime);
                }
                if (!StringUtils.isEmpty(endTime)){
                    paramsMap.put("endTime", endTime);
                }
                paramsMap.put("auditStatus", auditStatus);

                paramsMap.put("pageNum", pageNum);
                paramsMap.put("pageSize", pageSize);
                String strEntity = gson.toJson(paramsMap);
                RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json;charset=UTF-8"), strEntity);
                return runData(getProtocol(HttpAttendanceStore.class).findAudits(AccountManager.getInstance().getLoginAccount().getToken(), body));
            }
        });
    }
    public Controller getTeacherLeave(final int id,
                                   final Listener listener) {
        return runDataController(new ControllerCacheParams(false, false, "applyLeave"), listener, new ControllerRunnable<LeaveTeacherBean>() {
            @Override
            public LeaveTeacherBean run(Controller controller) {
                Gson gson = new Gson();
                HashMap<String, Object> paramsMap = new HashMap<>();
                paramsMap.put("id", id);
                String strEntity = gson.toJson(paramsMap);
                RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json;charset=UTF-8"), strEntity);
                return runData(getProtocol(HttpAttendanceStore.class).getTeacherLeave(AccountManager.getInstance().getLoginAccount().getToken(), body));
            }
        });
    }
    public Controller getStudentLeave(final int id,
                                      final Listener listener) {
        return runDataController(new ControllerCacheParams(false, false, "applyLeave"), listener, new ControllerRunnable<LeaveStudentBean>() {
            @Override
            public LeaveStudentBean run(Controller controller) {
                Gson gson = new Gson();
                HashMap<String, Object> paramsMap = new HashMap<>();
                paramsMap.put("id", id);
                String strEntity = gson.toJson(paramsMap);
                RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json;charset=UTF-8"), strEntity);
                return runData(getProtocol(HttpAttendanceStore.class).getStudentLeave(AccountManager.getInstance().getLoginAccount().getToken(), body));
            }
        });
    }
    public Controller cancelTeacherLeave(final int applyId,
                                      final Listener listener) {
        return runDataController(new ControllerCacheParams(false, false, "applyLeave"), listener, new ControllerRunnable<Integer>() {
            @Override
            public Integer run(Controller controller) {
                Gson gson = new Gson();
                HashMap<String, Object> paramsMap = new HashMap<>();
                paramsMap.put("applyId", applyId);
                String strEntity = gson.toJson(paramsMap);
                RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json;charset=UTF-8"), strEntity);
                return runData(getProtocol(HttpAttendanceStore.class).cancelTeacherLeave(AccountManager.getInstance().getLoginAccount().getToken(), body));
            }
        });
    }
    public Controller approveLeave(final int applyId,final String auditContent,
                                         final Listener listener) {
        return runDataController(new ControllerCacheParams(false, false, "applyLeave"), listener, new ControllerRunnable<Integer>() {
            @Override
            public Integer run(Controller controller) {
                Gson gson = new Gson();
                HashMap<String, Object> paramsMap = new HashMap<>();
                if (!StringUtils.isEmpty(auditContent)){
                    paramsMap.put("auditContent", auditContent);
                }
                paramsMap.put("applyId", applyId);
                String strEntity = gson.toJson(paramsMap);
                RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json;charset=UTF-8"), strEntity);
                return runData(getProtocol(HttpAttendanceStore.class).approveLeave(AccountManager.getInstance().getLoginAccount().getToken(), body));
            }
        });
    }
    public Controller rejectLeave(final int applyId,final String auditContent,
                                   final Listener listener) {
        return runDataController(new ControllerCacheParams(false, false, "applyLeave"), listener, new ControllerRunnable<Integer>() {
            @Override
            public Integer run(Controller controller) {
                Gson gson = new Gson();
                HashMap<String, Object> paramsMap = new HashMap<>();
                if (!StringUtils.isEmpty(auditContent)){
                    paramsMap.put("auditContent", auditContent);
                }
                paramsMap.put("applyId", applyId);
                String strEntity = gson.toJson(paramsMap);
                RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json;charset=UTF-8"), strEntity);
                return runData(getProtocol(HttpAttendanceStore.class).rejectLeave(AccountManager.getInstance().getLoginAccount().getToken(), body));
            }
        });
    }
    public Controller saveAuditConfig(final int firstMinDays,final int firstMaxDays,final int firstAuditorRole,
                                  final int secondMinDays,final int secondMaxDays,final int secondAuditorRole,
                                  final int thirdMinDays,final int thirdAuditorRole,
                                  final Listener listener) {
        return runDataController(new ControllerCacheParams(false, false, "saveAuditConfig"), listener, new ControllerRunnable<Integer>() {
            @Override
            public Integer run(Controller controller) {
                Gson gson = new Gson();
                HashMap<String, Object> paramsMap = new HashMap<>();
                paramsMap.put("firstMinDays", firstMinDays);
                paramsMap.put("firstMaxDays", firstMaxDays);
                paramsMap.put("firstAuditorRole", firstAuditorRole);
                paramsMap.put("secondMinDays", secondMinDays);
                paramsMap.put("secondMaxDays", secondMaxDays);
                paramsMap.put("secondAuditorRole", secondAuditorRole);
                paramsMap.put("thirdMinDays", thirdMinDays);
                paramsMap.put("thirdAuditorRole", thirdAuditorRole);
                String strEntity = gson.toJson(paramsMap);
                RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json;charset=UTF-8"), strEntity);
                return runData(getProtocol(HttpAttendanceStore.class).saveAuditConfig(AccountManager.getInstance().getLoginAccount().getToken(), body));
            }
        });
    }
    public Controller getAuditConfig(final Listener listener) {
        return runDataController(new ControllerCacheParams(true, true, "getAuditConfig"), listener, new ControllerRunnable<AuditConfigBean>() {
            @Override
            public AuditConfigBean run(Controller controller) {
                Gson gson = new Gson();
                HashMap<String, Object> paramsMap = new HashMap<>();
                String strEntity = gson.toJson(paramsMap);
                RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json;charset=UTF-8"), strEntity);
                return runData(getProtocol(HttpAttendanceStore.class).getAuditConfig(AccountManager.getInstance().getLoginAccount().getToken(), body));
            }
        });
    }
    public Controller saveAttendanceConfig(final int type,final String morningEnterTime,final String morningOutTime,
                                      final String afternoonEnterTime,final String afternoonOutTime,final String eveningEnterTime,
                                      final String eveningOutTime,final String weekdays,
                                      final int late1From,final int late1To,
                                      final int late2,final int late3,
                                      final int early1From,final int early1To,
                                      final int early2,final int early3,
                                      final Listener listener) {
        return runDataController(new ControllerCacheParams(false, false, "saveAttendanceConfig"), listener, new ControllerRunnable<Integer>() {
            @Override
            public Integer run(Controller controller) {
                Gson gson = new Gson();
                HashMap<String, Object> paramsMap = new HashMap<>();
                paramsMap.put("type", type);
                paramsMap.put("morningEnterTime", morningEnterTime);
                paramsMap.put("morningOutTime", morningOutTime);
                paramsMap.put("afternoonEnterTime", afternoonEnterTime);
                paramsMap.put("afternoonOutTime", afternoonOutTime);
                paramsMap.put("eveningEnterTime", eveningEnterTime);
                paramsMap.put("eveningOutTime", eveningOutTime);
                paramsMap.put("weekdays", weekdays);
                paramsMap.put("late1From", late1From);
                paramsMap.put("late1To", late1To);
                paramsMap.put("late2", late2);
                paramsMap.put("late3", late3);
                paramsMap.put("early1From", early1From);
                paramsMap.put("early1To", early1To);
                paramsMap.put("early2", early2);
                paramsMap.put("early3", early3);
                String strEntity = gson.toJson(paramsMap);
                RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json;charset=UTF-8"), strEntity);
                return runData(getProtocol(HttpAttendanceStore.class).saveAttendanceConfig(AccountManager.getInstance().getLoginAccount().getToken(), body));
            }
        });
    }
    public Controller findAttendanceConfig(final int type,
                                           final Listener listener) {
        return runDataController(new ControllerCacheParams(true, true, "findAttendanceConfig"), listener, new ControllerRunnable<AttendanceConfigBean>() {
            @Override
            public AttendanceConfigBean run(Controller controller) {
                Gson gson = new Gson();
                HashMap<String, Object> paramsMap = new HashMap<>();
                paramsMap.put("type", type);
                String strEntity = gson.toJson(paramsMap);
                RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json;charset=UTF-8"), strEntity);
                return runData(getProtocol(HttpAttendanceStore.class).findAttendanceConfig(AccountManager.getInstance().getLoginAccount().getToken(), body));
            }
        });
    }
    public Controller statSchoolUserSummary(final String attendanceDateStart,final String attendanceDateEnd,
                                            final int pageNum,final int pageSize,
                                            final String orderColumn,final String orderType,
                                           final Listener listener) {
        return runDataController(new ControllerCacheParams(false, false, "statSchoolUserSummary"), listener, new ControllerRunnable<StatSchoolUserSummaryBean>() {
            @Override
            public StatSchoolUserSummaryBean run(Controller controller) {
                Gson gson = new Gson();
                HashMap<String, Object> paramsMap = new HashMap<>();
                paramsMap.put("attendanceDateStart", attendanceDateStart);
                paramsMap.put("attendanceDateEnd", attendanceDateEnd);
                paramsMap.put("pageNum", pageNum);
                paramsMap.put("pageSize", pageSize);
                paramsMap.put("orderColumn", orderColumn);
                paramsMap.put("orderType", orderType);
                String strEntity = gson.toJson(paramsMap);
                RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json;charset=UTF-8"), strEntity);
                return runData(getProtocol(HttpAttendanceStore.class).statSchoolUserSummary(AccountManager.getInstance().getLoginAccount().getToken(), body));
            }
        });
    }
    public Controller statSchoolTeacherSummary(final String attendanceDateStart,final String attendanceDateEnd,
                                            final int pageNum,final int pageSize,
                                            final String orderColumn,final String orderType,
                                            final Listener listener) {
        return runDataController(new ControllerCacheParams(false, false, "statSchoolTeacherSummary"), listener, new ControllerRunnable<StatSchoolUserSummaryBean>() {
            @Override
            public StatSchoolUserSummaryBean run(Controller controller) {
                Gson gson = new Gson();
                HashMap<String, Object> paramsMap = new HashMap<>();
                paramsMap.put("attendanceDateStart", attendanceDateStart);
                paramsMap.put("attendanceDateEnd", attendanceDateEnd);
                paramsMap.put("pageNum", pageNum);
                paramsMap.put("pageSize", pageSize);
                paramsMap.put("orderColumn", orderColumn);
                paramsMap.put("orderType", orderType);
                String strEntity = gson.toJson(paramsMap);
                RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json;charset=UTF-8"), strEntity);
                return runData(getProtocol(HttpAttendanceStore.class).statSchoolTeacherSummary(AccountManager.getInstance().getLoginAccount().getToken(), body));
            }
        });
    }
    public Controller statUserSummary( final int userId,final String attendanceDateStart,final String attendanceDateEnd,
                                            final int pageNum,final int pageSize,
                                            final Listener listener) {
        return runDataController(new ControllerCacheParams(false, false, "statSchoolUserSummary"), listener, new ControllerRunnable<StatUserSummaryBean>() {
            @Override
            public StatUserSummaryBean run(Controller controller) {
                Gson gson = new Gson();
                HashMap<String, Object> paramsMap = new HashMap<>();
                paramsMap.put("attendanceDateStart", attendanceDateStart);
                paramsMap.put("attendanceDateEnd", attendanceDateEnd);
                paramsMap.put("pageNum", pageNum);
                paramsMap.put("pageSize", pageSize);
                paramsMap.put("userId", userId);
                String strEntity = gson.toJson(paramsMap);
                RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json;charset=UTF-8"), strEntity);
                return runData(getProtocol(HttpAttendanceStore.class).statUserSummary(AccountManager.getInstance().getLoginAccount().getToken(), body));
            }
        });
    }
    public Controller statUserTeacherSummary( final int userId,final String attendanceDateStart,final String attendanceDateEnd,
                                       final int pageNum,final int pageSize,
                                       final Listener listener) {
        return runDataController(new ControllerCacheParams(false, false, "statUserTeacherSummary"), listener, new ControllerRunnable<StatUserSummaryBean>() {
            @Override
            public StatUserSummaryBean run(Controller controller) {
                Gson gson = new Gson();
                HashMap<String, Object> paramsMap = new HashMap<>();
                paramsMap.put("attendanceDateStart", attendanceDateStart);
                paramsMap.put("attendanceDateEnd", attendanceDateEnd);
                paramsMap.put("pageNum", pageNum);
                paramsMap.put("pageSize", pageSize);
                paramsMap.put("userId", userId);
                String strEntity = gson.toJson(paramsMap);
                RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json;charset=UTF-8"), strEntity);
                return runData(getProtocol(HttpAttendanceStore.class).statUserTeacherSummary(AccountManager.getInstance().getLoginAccount().getToken(), body));
            }
        });
    }
    public Controller statSchoolSummary(final Listener listener) {
        return runDataController(new ControllerCacheParams(false, false, "statSchoolSummary"), listener, new ControllerRunnable<StatSchoolSummaryBean>() {
            @Override
            public StatSchoolSummaryBean run(Controller controller) {
                Gson gson = new Gson();
                HashMap<String, Object> paramsMap = new HashMap<>();
                String strEntity = gson.toJson(paramsMap);
                RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json;charset=UTF-8"), strEntity);
                return runData(getProtocol(HttpAttendanceStore.class).statSchoolSummary(AccountManager.getInstance().getLoginAccount().getToken(), body));
            }
        });
    }
    public Controller statSchoolTeacherTodaySummary(final Listener listener) {
        return runDataController(new ControllerCacheParams(false, false, "statSchoolTeacherTodaySummary"), listener, new ControllerRunnable<StatSchoolTeacherSummaryBean>() {
            @Override
            public StatSchoolTeacherSummaryBean run(Controller controller) {
                Gson gson = new Gson();
                HashMap<String, Object> paramsMap = new HashMap<>();
                String strEntity = gson.toJson(paramsMap);
                RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json;charset=UTF-8"), strEntity);
                return runData(getProtocol(HttpAttendanceStore.class).statSchoolTeacherTodaySummary(AccountManager.getInstance().getLoginAccount().getToken(), body));
            }
        });
    }

    //(教职工)个人考勤统计
    public Controller statTeacherSummary( final int userId,final String attendanceDateStart,final String attendanceDateEnd, final int pageNum,final int pageSize, final Listener listener) {
        return runDataController(new ControllerCacheParams(false, false, "statTeacherSummary"), listener, new ControllerRunnable<StatTeacherSummaryBean>() {
            @Override
            public StatTeacherSummaryBean run(Controller controller) {
                Gson gson = new Gson();
                HashMap<String, Object> paramsMap = new HashMap<>();
                paramsMap.put("attendanceDateStart", attendanceDateStart);
                paramsMap.put("attendanceDateEnd", attendanceDateEnd);
                paramsMap.put("pageNum", pageNum);
                paramsMap.put("pageSize", pageSize);
                paramsMap.put("userId", userId);
                String strEntity = gson.toJson(paramsMap);
                RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json;charset=UTF-8"), strEntity);
                return runData(getProtocol(HttpAttendanceStore.class).statTeacherSummary(AccountManager.getInstance().getLoginAccount().getToken(), body));
            }
        });
    }


    //(教职工)我的刷卡列表
    public Controller myClockListForTeacher( final String attendanceDateStart,final String attendanceDateEnd, final int pageNum,final int pageSize, final Listener listener) {
        return runDataController(new ControllerCacheParams(false, false, "statTeacherSummary"), listener, new ControllerRunnable<MyClockForTeacherListBean>() {
            @Override
            public MyClockForTeacherListBean run(Controller controller) {
                Gson gson = new Gson();
                HashMap<String, Object> paramsMap = new HashMap<>();
                paramsMap.put("attendanceDateStart", attendanceDateStart);
                paramsMap.put("attendanceDateEnd", attendanceDateEnd);
                paramsMap.put("pageNum", pageNum);
                paramsMap.put("pageSize", pageSize);
                String strEntity = gson.toJson(paramsMap);
                RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json;charset=UTF-8"), strEntity);
                return runData(getProtocol(HttpAttendanceStore.class).myClockListForTeacher(AccountManager.getInstance().getLoginAccount().getToken(), body));
            }
        });
    }
    //(学生)我的刷卡列表
    public Controller myClockListForStudent( final String attendanceDateStart,final String attendanceDateEnd, final int pageNum,final int pageSize, final Listener listener) {
        return runDataController(new ControllerCacheParams(false, false, "myClockListForStudent"), listener, new ControllerRunnable<MyClockForStudentListBean>() {
            @Override
            public MyClockForStudentListBean run(Controller controller) {
                Gson gson = new Gson();
                HashMap<String, Object> paramsMap = new HashMap<>();
                paramsMap.put("attendanceDateStart", attendanceDateStart);
                paramsMap.put("attendanceDateEnd", attendanceDateEnd);
                paramsMap.put("pageNum", pageNum);
                paramsMap.put("pageSize", pageSize);
                String strEntity = gson.toJson(paramsMap);
                RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json;charset=UTF-8"), strEntity);
                return runData(getProtocol(HttpAttendanceStore.class).myClockListForStudent(AccountManager.getInstance().getLoginAccount().getToken(), body));
            }
        });
    }
    //(学生)班级考勤-当日详情
    public Controller statClassSummaryDetail( final int grade, final int gradeType,final int classNum,
                                              final String attendanceDate,final Listener listener) {
        return runDataController(new ControllerCacheParams(false, false, "statClassSummaryDetail"), listener, new ControllerRunnable<StatClassSummaryDetail>() {
            @Override
            public StatClassSummaryDetail run(Controller controller) {
                Gson gson = new Gson();
                HashMap<String, Object> paramsMap = new HashMap<>();
                paramsMap.put("grade", grade);
                paramsMap.put("gradeType", gradeType);
                paramsMap.put("classNum", classNum);
                paramsMap.put("attendanceDate", attendanceDate);
                String strEntity = gson.toJson(paramsMap);
                RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json;charset=UTF-8"), strEntity);
                return runData(getProtocol(HttpAttendanceStore.class).statClassSummaryDetail(AccountManager.getInstance().getLoginAccount().getToken(), body));
            }
        });
    }

    //(学生)班级考勤-当日详情
    public Controller statClassSummary( final int grade, final int gradeType,final int classNum,
                                        final String attendanceDateStart, final String attendanceDateEnd,final int pageNum,
                                        final int pageSize,
                                              final Listener listener) {
        return runDataController(new ControllerCacheParams(false, false, "statClassSummaryDetail"), listener, new ControllerRunnable<StatClassSummary>() {
            @Override
            public StatClassSummary run(Controller controller) {
                Gson gson = new Gson();
                HashMap<String, Object> paramsMap = new HashMap<>();
                paramsMap.put("grade", grade);
                paramsMap.put("gradeType", gradeType);
                paramsMap.put("classNum", classNum);
                paramsMap.put("attendanceDateStart", attendanceDateStart);
                paramsMap.put("attendanceDateEnd", attendanceDateEnd);
                paramsMap.put("pageNum", pageNum);
                paramsMap.put("pageSize", pageSize);
                String strEntity = gson.toJson(paramsMap);
                RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json;charset=UTF-8"), strEntity);
                return runData(getProtocol(HttpAttendanceStore.class).statClassSummary(AccountManager.getInstance().getLoginAccount().getToken(), body));
            }
        });
    }
    //(学生)班级考勤-当日详情
    public Controller findCourseAttend( final int courseId,
                                        final Listener listener) {
        return runDataController(new ControllerCacheParams(false, false, "statClassSummaryDetail"), listener, new ControllerRunnable<CourseAttendBean>() {
            @Override
            public CourseAttendBean run(Controller controller) {
                Gson gson = new Gson();
                HashMap<String, Object> paramsMap = new HashMap<>();
                paramsMap.put("courseId", courseId);
                String strEntity = gson.toJson(paramsMap);
                RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json;charset=UTF-8"), strEntity);
                return runData(getProtocol(HttpAttendanceStore.class).findCourseAttend(AccountManager.getInstance().getLoginAccount().getToken(), body));
            }
        });
    }

    //(学生)课程考勤 签到
    public Controller courseAttend( final int courseId,final int studentId,
                                        final Listener listener) {
        return runDataController(new ControllerCacheParams(false, false, "statClassSummaryDetail"), listener, new ControllerRunnable<Integer>() {
            @Override
            public Integer run(Controller controller) {
                Gson gson = new Gson();
                HashMap<String, Object> paramsMap = new HashMap<>();
                paramsMap.put("courseId", courseId);
                paramsMap.put("studentId", studentId);
                String strEntity = gson.toJson(paramsMap);
                RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json;charset=UTF-8"), strEntity);
                return runData(getProtocol(HttpAttendanceStore.class).courseAttend(AccountManager.getInstance().getLoginAccount().getToken(), body));
            }
        });
    }
    //(学生)课程考勤 取消
    public Controller cancelAttend( final int courseId,final int studentId,
                                    final Listener listener) {
        return runDataController(new ControllerCacheParams(false, false, "cancelAttend"), listener, new ControllerRunnable<Integer>() {
            @Override
            public Integer run(Controller controller) {
                Gson gson = new Gson();
                HashMap<String, Object> paramsMap = new HashMap<>();
                paramsMap.put("courseId", courseId);
                paramsMap.put("studentId", studentId);
                String strEntity = gson.toJson(paramsMap);
                RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json;charset=UTF-8"), strEntity);
                return runData(getProtocol(HttpAttendanceStore.class).cancelAttend(AccountManager.getInstance().getLoginAccount().getToken(), body));
            }
        });
    }
    //(学生)课程考勤一键签到
    public Controller allAttend( final int courseId,
                                    final Listener listener) {
        return runDataController(new ControllerCacheParams(false, false, "allAttend"), listener, new ControllerRunnable<Integer>() {
            @Override
            public Integer run(Controller controller) {
                Gson gson = new Gson();
                HashMap<String, Object> paramsMap = new HashMap<>();
                paramsMap.put("courseId", courseId);
                String strEntity = gson.toJson(paramsMap);
                RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json;charset=UTF-8"), strEntity);
                return runData(getProtocol(HttpAttendanceStore.class).allAttend(AccountManager.getInstance().getLoginAccount().getToken(), body));
            }
        });
    }
}

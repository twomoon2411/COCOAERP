package kh.cocoa.controller;


import com.sun.org.apache.bcel.internal.generic.RETURN;
import kh.cocoa.dto.AtdChangeReqDTO;
import kh.cocoa.dto.AttendanceDTO;
import kh.cocoa.service.AttendanceService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/restattendance")
public class RestAttendanceController {


    @Autowired
    private AttendanceService attendanceService;

    @RequestMapping("/getAtdTime")
    public String getAtdTime(){
        List<AttendanceDTO> getAtdTime = attendanceService.getAtdTime(1000);
        JSONArray json = new JSONArray(getAtdTime);
        return json.toString();
    }

    @RequestMapping("/isInWork")
    public String isInWork(){
        String isInWork=attendanceService.isInWork(1000);
        return isInWork;
    }

    @RequestMapping("/isOutWork")
    public String isOutWork(){
        String isOutWork=attendanceService.isOutWork(1000);
        String isInWork=attendanceService.isInWork(1000);
        if(isInWork==null){
            return "nyInWork";
        }
        return isOutWork;
    }

    @RequestMapping("/atdIn")
    public String atdIn(String status){
        System.out.println(status);
        if(attendanceService.isInWork(1000)!=null){
            int updateResult = attendanceService.reRegStartTime(1000);
            if(updateResult>0){
                return "updateSuccess";
            }else{
                return "updateFailed";
            }
        }else{
            SimpleDateFormat frm = new SimpleDateFormat ( "HHMM");
            Date time = new Date();
            String getCurTime = frm.format(time);
            if(Integer.parseInt(getCurTime)>930){
                status="late";
            }else{
                if(status!=null){
                    status="out";
                }else{
                    status="in";
                }
            }
            int insertResult = attendanceService.startWork2(1000,status);
            if(insertResult>0){
                return "insertSuccess";
            }else{
                return "insertFailed";
            }
        }

    }


    @RequestMapping("/atdOut")
    public String atdOut(){
        SimpleDateFormat frm = new SimpleDateFormat ( "HH");
        Date time = new Date();
        String getCurTime = frm.format(time);
        String getStartTime =attendanceService.isInWork(1000);
        int overTime=0;
        if(getStartTime!=null){
            int sub = Integer.parseInt(getCurTime)-Integer.parseInt(getStartTime.replaceAll(":","").substring(0,2))-1;
            System.out.println(sub);
            if(sub>8){
                overTime=sub-8;
            }
        }
        if(attendanceService.isOutWork(1000)!=null){
            int updateResult = attendanceService.endWork(1000,overTime);
            if(updateResult>0){
                return "updateSuccess";
            }else{
                return "updateFailed";
            }
        }else{

            int insertResult = attendanceService.endWork(1000,overTime);
            if(insertResult>0){
                return "insertSuccess";
            }else{
                return "insertFailed";
            }
        }
    }

    @RequestMapping("/getMonthAtdTime")
    public String getMonthAtdTime(){
        List<AttendanceDTO> getAtdTime = attendanceService.getMonthAtdTime(1000);
        JSONArray json = new JSONArray(getAtdTime);
        return json.toString();
    }

    @RequestMapping("/getReqInfo")
    public String getReqInfo(int atd_seq){
        AtdChangeReqDTO isReq =attendanceService.isReq(atd_seq);
        if(isReq!=null){
            JSONObject json = new JSONObject(isReq);
            return json.toString();
        }
        return "false";
    }

    @RequestMapping("/getAtdList")
    public String getAtdList(String number){
        List<AttendanceDTO> atdList = attendanceService.getAttendanceList2(1000,number);
        JSONArray json = new JSONArray(atdList);
        return json.toString();
    }

    @RequestMapping("/search")
    public String search(String number,
                         String search,
                         String start_time,
                         String end_time){
        int parse_end_time = Integer.parseInt(end_time.replaceAll("-",""));
        parse_end_time++;
        List<AttendanceDTO> getSearchAtd = attendanceService.getSearchAtd(1000,number,search,start_time,parse_end_time);
        JSONArray json = new JSONArray(getSearchAtd);
        return json.toString();
    }

    @RequestMapping("/changeReq")
    public String changeReq(AtdChangeReqDTO dto){
        int addChangeReq=attendanceService.addChangeReq(dto);
        if(addChangeReq>0){
            return "successInsert";
        }else{
            return "failedInsert";
        }

    }

    @RequestMapping("/delChangeReq")
    public String delChangeReq(int atd_seq){
        int delChangeReq=attendanceService.delChangeReq(atd_seq);
        if(delChangeReq>0){
            return "successDelete";
        }else{
            return "failedDelete";
        }
    }

    @RequestMapping("/modChangeReq")
    public String modChangeReq(AtdChangeReqDTO dto){
        int modChangeReq=attendanceService.modChangeReq(dto);
        if(modChangeReq>0){
            return "successUpdate";
        }else{
            return "failedUpdate";
        }
    }

    @RequestMapping("/getIsReqInfo")
    public String getIsReqInfo(int atd_seq){
        AtdChangeReqDTO getIsReqInfo=attendanceService.getIsReqInfo(atd_seq);
        JSONObject json = new JSONObject(getIsReqInfo);
        return json.toString();
    }


}

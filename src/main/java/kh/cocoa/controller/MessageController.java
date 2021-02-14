package kh.cocoa.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import kh.cocoa.dto.MessageDTO;
import kh.cocoa.dto.MessengerPartyDTO;
import kh.cocoa.service.FilesService;
import kh.cocoa.service.MessageService;


@Controller
@RequestMapping("/message")
public class MessageController {

    @Autowired
    MessageService msgservice;
    
    @Autowired
    FilesService fservice;

    @RequestMapping("/")
    public String toChatExam() {
        return "/messenger/chatExam";
    }

    // 메세지 테이블에 insert
    @RequestMapping("insertMessage")
    @ResponseBody
    public String insertMessage(MessageDTO msgdto) throws IOException {
    	System.out.println("인서트 메세지 컨트롤러 도착");
    	int result = 0;
    	
    	//메세지 타입이 TEXT 인지 FILE 이나 IMAGE인지에 따라
    	if(msgdto.getType().contentEquals("TEXT")) {
    		result = msgservice.insertMessage(msgdto); //의진씨한테 확인받기 (원래 코드)
    	}
        JsonObject obj = new JsonObject();
        obj.addProperty("result", result);
        return new Gson().toJson(obj);
    }
    // 메세지 목록 불러오기
    @RequestMapping("getMessageListByCpage")
    @ResponseBody
    public String getMessageList(int m_seq,int cpage){
        System.out.println("m_seq: " +m_seq);
        JSONArray jArray = new JSONArray();
        HashMap<String,Object> param = new HashMap<>();
        List<MessageDTO> list = msgservice.getMessageListByCpage(m_seq,cpage);
        for(int i=0; i<list.size();i++){
            param.put("seq",list.get(i).getSeq());
            param.put("contents",list.get(i).getContents());
            param.put("emp_code",list.get(i).getEmp_code());
            param.put("write_date",list.get(i).getWrite_date());
            param.put("type",list.get(i).getType());
            param.put("savedname",list.get(i).getSavedname());
            jArray.put(param);
        }
        return jArray.toString();
    }

    // 채팅창에서 검색한 메세지 찾기
    @RequestMapping("searchMsgInChatRoom")
    @ResponseBody
    public String searchMsgInChatRoom(int m_seq, String contents){
        JSONArray jArray = new JSONArray();
        HashMap<String,Object> param = null;
        List<MessageDTO> msgSearchList = msgservice.searchMsgInChatRoom(m_seq, contents);
        for(int i=0; i<msgSearchList.size();i++){
            param = new HashMap<>();
            param.put("seq",msgSearchList.get(i).getSeq());
            param.put("contents",msgSearchList.get(i).getContents());
            jArray.put(param);
        }
        return jArray.toString();
    }
    
    //Messenger 컨트롤러 addMemberToChat 과 연계해 테스트 중
    /*
    @RequestMapping("chatAnnounce")
    @ResponseBody
    public String chatAnnounce(MessageDTO message, MessengerPartyDTO partyList, RedirectAttributes redirectAttributes) {
    	System.out.println("chatAnnoune arrived!");
    	System.out.println("message : "+message);
    	System.out.println("partyList : "+ partyList);
    	JSONArray jArrayAnnounce = new JSONArray();
    	HashMap<String,Object> param = new HashMap<>();
    	param.put("m_seq", message.getM_seq());
    	param.put("type", message.getType());
    	jArrayAnnounce.put(param);
    	
    	JSONArray jArrayPartyList = new JSONArray();
    	HashMap<String,Object> param2 = new HashMap<>();
    	param2.put("partyList", partyList);
    	
    	JSONArray jArrayAll = new JSONArray();
    	jArrayAll.put(jArrayAnnounce);
    	jArrayAll.put(jArrayPartyList);
    	return jArrayAll.toString();
    }*/

    @ExceptionHandler(NullPointerException.class)
    public Object nullex(Exception e) {
        System.err.println(e.getClass());
        return "index";
    }
}

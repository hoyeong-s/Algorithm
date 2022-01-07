package KAKAO_BLIND_RECRUITMENT_2019;

import java.io.*;
import java.util.*;

public class 오픈채팅방 {
	static boolean [] check;
	static HashMap<String, String> map = new HashMap<>();
	
	public static void main(String[] args) {
		String [] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
		solution(record);
	}
	public static String[] solution(String[] record) {
        String[] answer = new String[record.length];
        StringTokenizer st;
        check = new boolean [record.length];
        int cnt = 0;
        
        for(int i=0; i<record.length; i++) {
        	st = new StringTokenizer(record[i]);
        	String f = st.nextToken();
        	String id = st.nextToken();
        	if(f.charAt(0)=='E') {
        		String nick = st.nextToken();
        		map.put(id, nick);
        		check[cnt] = true;
        		answer[cnt++] = id;
        	}
        	else if(f.charAt(0)=='L') {
        		answer[cnt++] = id;
        	}
        	else {
        		String nick = st.nextToken();
        		map.put(id, nick);
        	}	
        }
        String [] result = new String[cnt];
        for(int i=0; i<cnt; i++) {
        	StringBuilder sb = new StringBuilder();
        	sb.append(map.get(answer[i]));
        	if(check[i]) sb.append("님이 들어왔습니다.");
        	else sb.append("님이 나갔습니다.");
        	result[i] = sb.toString();
        }
        
        return result;
    }
}

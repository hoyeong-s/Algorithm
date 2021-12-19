package Dev_matching_2021;

import java.io.*;
import java.util.*;

public class 광고_삽입 {
	static int [] arr;
	static Queue<Integer> q = new LinkedList<Integer>();
	public static void main(String[] args) {
		String [] logs = {"01:20:15-01:45:14", "00:40:31-01:00:00", "00:25:50-00:48:29", "01:30:59-01:53:29", "01:37:44-02:02:30"};
		solution("02:03:55","00:14:15",logs);
		
//		String [] logss = {"69:59:59-89:59:59", "01:00:00-21:00:00", "79:59:59-99:59:59", "11:00:00-31:00:00"};
//		solution("99:59:59","25:00:00",logss);
	}
	public static String solution(String play_time, String adv_time, String[] logs) {
        String answer = "";
        
        StringTokenizer st = new StringTokenizer(play_time,":-");
        int h = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        
        arr = new int [h*3600 + m*60 + s +1];
        
        for(int i=0; i<logs.length; i++)
        	translate(logs[i]);
        
        st = new StringTokenizer(adv_time,":-");
        int hh = Integer.parseInt(st.nextToken());
        int mm = Integer.parseInt(st.nextToken());
        int ss = Integer.parseInt(st.nextToken());
        
        int time = hh*3600 + mm*60 + ss;
        
        long sum = 0;
        for(int i=0; i<time; i++) {
        	sum += arr[i];
        }
        
        long max = sum;
        int result = 0;
        
        for(int i=time; i<arr.length; i++) {
        	sum += arr[i]-arr[i-time];
        	if(sum > max) {
        		max = sum;
        		result = i-time+1;
        	}
        }
        
        int sec = result % 60;
        int min = result / 60;
        int hour = min / 60;
        min = min % 60;
        
        StringBuilder sb = new StringBuilder();
        if(hour<10) sb.append("0"+hour);
        else sb.append(hour);
        sb.append(":");
        if(min<10) sb.append("0"+min);
        else sb.append(min);
        sb.append(":");
        if(sec<10) sb.append("0"+sec);
        else sb.append(sec);
        
        return sb.toString();
    }
	
	private static void translate(String log) {
		StringTokenizer st = new StringTokenizer(log,":-");
		
		int h = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		
		int start = h*3600 + m*60 + s;
		
		int hh = Integer.parseInt(st.nextToken());
		int mm = Integer.parseInt(st.nextToken());
		int ss = Integer.parseInt(st.nextToken());
		
		int end = hh*3600 + mm*60 + ss;
		
		for(int i = start; i<end; i++) // 왜 end 안넣? >> 배열에서 end는 끝나는 시간이기 때문에 넣어주지 X
			arr[i]++;
		
	}
}

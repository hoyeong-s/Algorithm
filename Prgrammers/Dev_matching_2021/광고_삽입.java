package Dev_matching_2021;

import java.util.StringTokenizer;

public class 광고_삽입 {
	static int [] arr;
	public static void main(String[] args) {
		String [] logs = {"01:20:15-01:45:14", "00:40:31-01:00:00", "00:25:50-00:48:29", "01:30:59-01:53:29", "01:37:44-02:02:30"};
		solution("02:03:55","00:14:15",logs);
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
        
        int max = 0;
        for(int i=1; i<=arr.length-1; i++) {
        	arr[i] += arr[i-1];
        	if(i>=time) max = Math.max(max, arr[i]-arr[i-time]);
        	if(i==5459 || i==6314) System.out.println(i+" "+arr[i]);
        }
        
        int sec = max % 60;
        int min = max / 60;
        int hour = min / 60;
        min = min % 60;
        
        StringBuilder sb = new StringBuilder();
        sb.append(hour + ":" + min + ":" + sec);
        
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
		
		for(int i = start; i<=end; i++)
			arr[i]++;
		
	}
}

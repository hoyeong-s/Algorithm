package KAKAO_INTERN_2020;

public class 키패드_누르기 {
	static int pr=12, pl=10;
	public static void main(String[] args) {
		int [] num = {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};
		solution(num,"left");
	}
	
	public static String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<numbers.length; i++) {
        	if(numbers[i]==1 || numbers[i]==4 || numbers[i]==7) {
        		sb.append("L");
        		pl = numbers[i];
        	}
        	else if(numbers[i]==3 || numbers[i]==6 || numbers[i]==9) {
        		sb.append("R");
        		pr = numbers[i];
        	}
        	else {
        		String s;
        		if(numbers[i]==0) {
        			s = find(11,hand);
        			sb.append(s);
            		if(s.equals("R")) pr = 11;
            		else pl = 11;
        		}else {
        			s = find(numbers[i], hand);
            		
            		sb.append(s);
            		if(s.equals("R")) pr = numbers[i];
            		else pl = numbers[i];
        		}
        	}
        }
        return sb.toString();
    }
	
	private static String find(int num, String hand) {
		int plr = (pl-1)/3;
		int plc = (pl-1)%3;

		int prr = (pr-1)/3;
		int prc = (pr-1)%3;
		
		int nr = (num-1)/3;
		int nc = (num-1)%3;
		
		int ldis = Math.abs(plr-nr) + Math.abs(plc-nc);
		int rdis = Math.abs(prr-nr) + Math.abs(prc-nc);
		
		if(ldis < rdis) return "L";
		else if(ldis > rdis) return "R";
		else {
			if(hand.equals("right")) return "R";
			else return "L";
		}
	}
	
}

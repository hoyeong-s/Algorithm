package KAKAO_BLIND_RECRUITMENT_2022;

public class 양궁대회 {
    static int max=-1;
    static int [] peach, result;
    
    public int[] solution(int n, int[] info) {
        int [] fail = {-1};
        result = new int [11];
        peach = info;
        
        dfs(0,n,new int [11]);
        
        System.out.println(max);
        if(max==-1) return fail;
        return result;
    }
    
    private static void dfs(int idx, int n, int [] lion){
        if(n==0 || idx>=11){ 
            if(n>0) lion[10] += n; // 남은 화살 모두 0점에 넣기
            int point = counting(lion);
            if(point>0){
                if(point == max){
                    if(lower(lion)) result = lion.clone();
                }
                else if(point>max){
                    max = point;
                    result = lion.clone();
                }
            }
            lion[10] -= n; // ***** dfs에서 return 하므로 원래 값으로 바꿔 줘야함 *****
            return;
        }
        // 이번 점수 스킵
        dfs(idx+1, n, lion);
        
        // 이번 점수 먹는 경우
        int p = peach[idx];
        if(n>p){
            lion[idx] = p+1;
            dfs(idx+1,n-p-1,lion);
            lion[idx] = 0;
        }   
    }
    
    private static boolean lower(int [] lion){ // true 면 lion이 큼
        for(int i=10; i>=0; i--){
            if(lion[i]!=0 && result[i]==0) return true;
            if(lion[i]==0 && result[i]!=0) return false;
        }
        return false;
    }
    
    private static int counting(int [] lion){
        int p = 0;
        int l = 0;
        
        for(int i=0; i<11; i++){
            if(lion[i]>peach[i]) l+=(10-i);
            else if(lion[i]<peach[i]) p+=(10-i);
        }
        return l-p;
    }
}
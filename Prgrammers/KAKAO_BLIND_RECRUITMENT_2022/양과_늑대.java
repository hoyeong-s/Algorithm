package KAKAO_BLIND_RECRUITMENT_2022;

import java.util.*;

class Solution {
    static int max;
    static int [] a;
    static ArrayList<Integer> list [];
    
    public int solution(int[] info, int[][] edges) {
        int answer = 0;
        a = info;
                
        list = new ArrayList[info.length];
        for(int i=0; i<info.length; i++)
            list[i] = new ArrayList<>();
        
        for(int i=0; i<edges.length; i++){
            int f = edges[i][0];
            int t = edges[i][1];
            list[f].add(t);
        }
        dfs(0,0,0,new ArrayList<Integer>() );
        return max;
    }
    private static void dfs(int idx, int sheep, int wolf, ArrayList<Integer> nodes){
        int d_sheep = sheep;
        int d_wolf = wolf;
        if(a[idx]==0) d_sheep++;
        else d_wolf++;
        
        if(d_wolf>=d_sheep) return;
        
        max = Math.max(max,d_sheep);
        
        for(int i=0; i<list[idx].size(); i++)
            nodes.add(list[idx].get(i));
            
        for(int i=0; i<nodes.size(); i++){
            int next = nodes.get(i);
            nodes.remove(new Integer(next));
            dfs(next,d_sheep,d_wolf,nodes);
            nodes.add(i,next);
        }
        
        for(int i=0; i<list[idx].size(); i++)
            nodes.remove(new Integer(list[idx].get(i)));
    }
}
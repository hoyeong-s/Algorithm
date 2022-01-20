package KAKAO_BLIND_RECRUITMENT_2022;

import java.util.*;

class Solution {
    static int max,len;
    static int [] a;
    static boolean [][][] visited;
    static ArrayList<Integer> list [];
    static class animal{
        int sheep,wolf,node;
        String gone;
        public animal(int sheep, int wolf, int node, String gone){
            super();
            this.sheep = sheep;
            this.wolf = wolf;
            this.node = node;
            this.gone = gone;
        }
    }
    
    public int solution(int[] info, int[][] edges) {
        int answer = 0;
        a = info;
        
        visited = new boolean [info.length+1][info.length+1][info.length+1]; // 양의 개수, 늑대의 개수, 해당 노드 
        
        list = new ArrayList[info.length];
        for(int i=0; i<info.length; i++)
            list[i] = new ArrayList<>();
        
        for(int i=0; i<edges.length; i++){
            int f = edges[i][0];
            int t = edges[i][1];
            list[f].add(t);
            list[t].add(f);
        }
        bfs();
        
        return max;
    }
    
    private static void bfs(){
        Queue<animal> q = new LinkedList<>();
        q.add(new animal(1,0,0,"0"));
        visited[1][0][0] = true;
        
        while(!q.isEmpty()){
            animal ani = q.poll();
            int sheep = ani.sheep;
            int wolf = ani.wolf;
            int node = ani.node;
            String gone = ani.gone;
            
            max = Math.max(max,sheep);
            
            for(int i=0; i<list[node].size(); i++){
                int next = list[node].get(i);
                int d_sheep = sheep;
                int d_wolf = wolf;
                String d_gone = gone;
                if(!gone.contains(Integer.toString(next))){
                    if(a[next]==0) d_sheep++;
                    else d_wolf++;
                    d_gone += Integer.toString(next);
                }
                
                if(d_sheep<=d_wolf || visited[d_sheep][d_wolf][next]) continue;
                visited[d_sheep][d_wolf][next] = true;
                q.add(new animal(d_sheep,d_wolf,next,d_gone));
            }
            
        }
    }
}
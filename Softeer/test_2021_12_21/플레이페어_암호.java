package test_2021_12_21;

import java.util.*;
import java.io.*;


public class 플레이페어_암호
{   
    static char [][] map = new char [5][5];
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String message = br.readLine();
        String key = br.readLine();

        map = make(key);

        String [] arr = new String [message.length()];
        arr = split(message);

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<arr.length; i++){
            if(arr[i]==null) break;
            sb.append(trans(arr[i]));
        }

        System.out.println(sb.toString());
    }
    public static char [][] make(String key){
        boolean [] check = new boolean [26];
        char [][] map = new char [5][5];

        int cnt = 0;
        for(int i=0; i<key.length(); i++){
            char alp = key.charAt(i);
            if(!check[alp-'A']){
                check[alp-'A'] = true;
                int r = cnt / 5;
                int c = cnt % 5;
                map[r][c] = alp;
                cnt++;
            }
        }
        for(int i=0; i<check.length; i++){
            if(!check[i]){
                if((char)(i+'A')=='J') continue;
                int r = cnt / 5;
                int c = cnt % 5;
                map[r][c] = (char)(i+'A');
                cnt++;
            }
        }
        return map;
    }

    public static String [] split(String message){
        int cnt =0;
        String [] arr = new String [message.length()];
        StringBuilder sb;

        for(int i=0; i<message.length(); i++){
            sb = new StringBuilder();

            if(i+1<message.length()) {
                char a = message.charAt(i);
                char b = message.charAt(i+1);
                if(a==b){ // 같은 문자일 때 
                    if(a!='X'){
                        sb.append(a);
                        sb.append('X');
                    }else{
                        sb.append(a);
                        sb.append('Q');
                    }
                }
                else{ // 다른 문자일 때 
                    sb.append(a);
                    sb.append(b);
                    i++;
                }
            }else{
                sb.append(message.charAt(i));
                sb.append('X');
            }
            arr[cnt++] = sb.toString();
        }

        return arr;
    }
    public static String trans(String str){
        char a = str.charAt(0);
        char b = str.charAt(1);

        return amho(find(a), find(b));
    }

    public static int find(char c){
        for(int i=0; i<5; i++){
            for(int j=0; j<5; j++){
                if(map[i][j]==c) return i*5+j;
            }
        }
        return 0;
    }

    public static String amho(int a, int b){
        int ar = a/5;
        int ac = a%5;

        int br = b/5;
        int bc = b%5;

        StringBuilder sb = new StringBuilder();
        if(ar==br) { // 같은 행
            if(ac<4) sb.append(map[ar][ac+1]);
            else sb.append(map[ar][0]);

            if(bc<4) sb.append(map[br][bc+1]);
            else sb.append(map[br][0]);
        }
        else if(ac==bc) { // 같은 열
            if(ar<4) sb.append(map[ar+1][ac]);
            else sb.append(map[0][ac]);

            if(br<4) sb.append(map[br+1][bc]);
            else sb.append(map[0][bc]);
        }
        else { // 모두 아닐 때
            sb.append(map[ar][bc]);
            sb.append(map[br][ac]);
        }
        return sb.toString();
    }
}

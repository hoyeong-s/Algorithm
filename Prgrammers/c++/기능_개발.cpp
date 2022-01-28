#include <string>
#include <vector>
#include <queue>

using namespace std;

vector<int> solution(vector<int> progresses, vector<int> speeds) {
    vector<int> answer;

    int cur=0;
    int cnt=0;
    for(int i=0; i<progresses.size(); i++){
      int p = 100 - progresses[i];
      int time = 0;
      int s = speeds[i];
      if(p%s==0) time = p/s;
      else time = p/s+1;

      if(time>cur){
        if(i!=0)answer.push_back(cnt);
        cur = time;
        cnt = 1;
      }
      else{
        cnt++;
      }
    }
    answer.push_back(cnt);
    return answer;
}
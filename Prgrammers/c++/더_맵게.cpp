#include <string>
#include <vector>
#include <queue>

using namespace std;

int solution(vector<int> scoville, int K) {
    int answer = 0;
    priority_queue<int, vector<int>, greater<int>> pq;

    for(int i=0; i<scoville.size(); i++){
      pq.push(scoville[i]);
    }

    while(pq.top()<K && pq.size()>1){
      answer++;
      int f = pq.top();
      pq.pop();
      int s = pq.top();
      pq.pop();
      pq.push(f+(s*2));
    }
    if(pq.top()<K) return -1;
    else return answer;
}
#include <iostream>
#include <queue>

using namespace std;

int main(){
  int N, M;
  cin >> N >> M;

  queue<int> q;
  
  for(int i=1; i<=N; i++){
    q.push(i);  
  }

  int idx=0;
  int result [N];
  while(q.size() > 1){
    for(int i=0; i<M-1; i++){
      int num = q.front();
      q.pop();
      q.push(num);
    }
    int cur = q.front();
    q.pop();
    result[idx++] = cur;
  }

  while(!q.empty()){ // 남은 항목 처리
    int num = q.front();
    q.pop();
    result[idx++] = num;
  }

  cout << "<";
  for(int i=0; i<N-1; i++)
    cout << result[i] << ", ";
  cout << result[N-1] <<">";
  
}
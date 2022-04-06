#include <iostream>
#include <queue>

using namespace std;

struct Dot{
  int idx, num;
  Dot(int _idx, int _num){
    idx = _idx;
    num = _num;
  }
};

struct compare{
  bool operator()(const Dot a, const Dot b){
    return a.num < b.num;
  }
};

int main(){
  int T;
  cin >> T;
  
  for(int i=0; i<T; i++){
    int N,M;
  cin >> N >> M;

    queue<Dot> q;
  priority_queue<Dot, vector<Dot>, compare> pq;

    int n;
    for(int j=0; j<N; j++){
      cin >> n;

      q.push(Dot(j,n));
      pq.push(Dot(j,n));
  }

  int cnt = 0;
    bool checking = 0;
  while(!q.empty() && !checking){
    cnt++;
    Dot cur = pq.top();
    pq.pop();

    while(!q.empty()){
      Dot now = q.front();
      q.pop();
      if(now.num!=cur.num) q.push(now);
      else {
        if(now.idx == M) {
          cout << cnt << endl;
          checking = 1;
        }
        break;
      }
    }
  }
}
}
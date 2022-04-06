#include <iostream>
#include <queue>
#include <cstdlib>

using namespace std;

struct compare{
  bool operator()(const int a, const int b){
      if(abs(a)!=abs(b)) return abs(a)>abs(b);
      else return a>b;
  }
};

int main(){
  int N;
  cin >> N;

  priority_queue<int,vector<int>,compare> pq;
  
  for(int i=0; i<N; i++){
    int num;
    cin >> num;

    if(num!=0){
      pq.push(num);
    }else{
      if(pq.empty()) cout << 0 << endl;
      else{
        int n = pq.top();
        pq.pop();
        cout << n << endl;
        }
    }
  }
}
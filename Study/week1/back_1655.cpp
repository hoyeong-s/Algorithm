#include <iostream>
#include <queue>

using namespace std;

struct compare{
  bool operator()(const int a, const int b){
    return a>b;
  }
};

int main(){
  ios_base :: sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  
  priority_queue<int, vector<int>, compare> high_pq;
  priority_queue<int> low_pq;

  int N;
  cin >> N;
  for(int i=0; i<N; i++){
    int num;
    cin >> num;
    
    if(i%2==0) low_pq.push(num);
    else high_pq.push(num);

    if(i>=1 && low_pq.top() > high_pq.top()){
      int lcur = low_pq.top();
      low_pq.pop();

      int hcur = high_pq.top();
      high_pq.pop();

      high_pq.push(lcur);
      low_pq.push(hcur);
    }

    cout << low_pq.top() << "\n";
  }
}

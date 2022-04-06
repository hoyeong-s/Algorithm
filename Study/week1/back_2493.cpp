#include <iostream>
#include <stack>

using namespace std;

struct Dot{
  int idx, num;
  Dot(int _idx, int _num){
    idx = _idx;
    num = _num;
  }
};

int main(){
  int N;
  cin >> N;

  int arr [N+1];
  int result [N+1];
  fill_n(result,N+1,0);
  
  for(int i=1; i<=N; i++){
    int num;
    cin >> num;
    arr[i] = num;
  }

  int idx = N-1;
  stack<Dot> s;

  for(int i=N; i>=1; i--){
    int height = arr[idx];
    s.push(Dot(i,arr[i]));
    
    while(!s.empty()){
      int cur = s.top().num;
      if(height > cur){
        result[s.top().idx] = idx;
        s.pop();
      }
      else break;
    }
    idx--;
  }

  for(int i=1; i<=N; i++)
    cout << result[i] << " ";
}
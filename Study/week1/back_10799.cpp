#include <iostream>
#include <string>
#include <stack>

using namespace std;

int main(){
  string str;
  getline(cin,str);

  stack<int> s;
  s.push(0);
  
  int lazer = 0, result = 0;
  for(int i=1; i<str.length(); i++){
    char c = str[i];

    if(c=='(') s.push(0);
    else{
      if(s.top()==0){ // 레이저 일 때
        s.pop();
        if(s.size()>=1){
          s.top()++;
        }
      }
      else{
        int num = s.top();
        s.pop();
        result += num+1;
        if(s.size()>0) s.top() += num;
      }
    }
  }
  cout << result;
}

#include <iostream>
#include <string>
#include <stack>

using namespace std;

bool check(string str){
  stack<int> s;
  int len = (int)str.length();
  
  for(int i=0; i<len; i++){
    char c = str[i];
    if(c=='(') s.push(c);
    else{
      if(s.empty()) return false;
      else s.pop();
    }
  }
  return s.empty();
}

int main() {
  int n;
  cin >> n;

  for(int i=0; i<n; i++){
    string str;
    cin >> str;
    if(check(str)) cout << "YES" << endl;
    else cout << "NO" << endl;
  }
  
} 
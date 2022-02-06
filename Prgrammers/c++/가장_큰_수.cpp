#include <string>
#include <vector>
#include <algorithm>

using namespace std;

bool check(string &a, string &b){
  return a+b > b+a;
}

string solution(vector<int> numbers) {
    string answer = "";

    vector <string> arr;
    for(auto iter : numbers)
      arr.push_back(to_string(iter));
    
    sort(arr.begin(), arr.end(), check);

    for(auto it : arr)
      answer += it;
    
    if(answer.at(0)=='0') return "0";
    else return answer;
}
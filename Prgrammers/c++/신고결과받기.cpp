#include <string>
#include <vector>
#include <iostream>
#include <sstream>
#include <unordered_set>
#include <unordered_map>

using namespace std;

vector<int> solution(vector<string> id_list, vector<string> report, int k) {
    vector<int> answer;
    int id [id_list.size()] ;
    unordered_set <string> hash;
    unordered_map <string,int> map;

    for(int i=0; i<id_list.size(); i++){
      map[id_list[i]] = i;
    }

    for(int i=0; i<report.size(); i++){
      hash.insert(report[i]);
    }

    stringstream ss;

    for(string s : hash){
      ss.str(s);
      string f,t;
      ss >> f >> t;

      id[map.find(t)->second]++;
    }
    

    return answer;
}
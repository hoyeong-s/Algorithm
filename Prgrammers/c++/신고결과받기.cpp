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
    int result [id_list.size()];
    unordered_set <string> hash;
    unordered_map <string,int> map;
    unordered_map <string,vector<string>> map_list;

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

      vector<string> v;
      if(map_list.end() != map_list.find(f)){
        v = map_list.find(t)->second;
      }
      v.push_back(f);
      map_list[f] = v;

      id[map.find(t)->second]++;
      ss.clear();
    }

    for(int i=0; i<id_list.size(); i++){
      if(id[i]>=k){
        string name = id_list[i];
        vector<string> v;
        v = map_list.find(name)->second;
        for(auto str : v){
          result[map.find(str)->second]++;
        }
      }
    }

    return answer;
}
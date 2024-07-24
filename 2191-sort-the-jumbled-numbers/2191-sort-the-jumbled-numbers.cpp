class Solution {
public:
    vector<int> sortJumbled(vector<int>& mapping, vector<int>& nums) {
        string map = "";
        vector<vector<int>> mp;
        vector<int> ans,res;
        for(int n : mapping){
            map += to_string(n);
        }
        for(int n : nums){
            string num = "";
            string str = to_string(n);
            for(char ch : str){
                num += map[ch-'0'];
            }
            ans.push_back(stoi(num));
        }
        
        for(int i = 0;i < ans.size(); i++){
            mp.push_back({ans[i],i});
        }

        sort(begin(mp),end(mp));
        
        for(auto vec : mp){
            int idx = vec[1];
            res.push_back(nums[idx]);
        }
        return res;
    }
};
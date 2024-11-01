class Solution {
public:
    string makeFancyString(string s) {
        // O(1) Space

        int cnt =0, j=0;
        char curr = s[0];

        for(int i=0;i<s.length();i++) {
            if(s[i]==curr) {
                cnt++;
            } else {
                cnt = 1;
                curr=s[i];
            }

            if(cnt < 3) {
                s[j]=curr;
                j++;
            }
        }

        s.resize(j);

        return s;
    }
};
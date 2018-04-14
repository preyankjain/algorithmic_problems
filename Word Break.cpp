/**
**Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine 
**if s can be segmented into a space-separated sequence of one or more dictionary words. 
**You may assume the dictionary does not contain duplicate words.
**/

class Solution {
public:
    bool wordBreak(string s, vector<string>& wordDict) {
        int opt[s.length()] = {0};
        
        for (int i = 0; i < s.length(); i++)
        {
            for (int j = 0; j < wordDict.size(); j++)
            {
                int len =  wordDict.at(j).length();
                if (i-len+1 == 0)
                {
                    if (wordDict.at(j) == s.substr(i - len + 1, len))
                    {
                        opt[i] = 1;
                        break;
                    }
                }
                else if (i-len+1 > 0)
                {
                    if (wordDict.at(j) == s.substr(i - len + 1, len) && opt[i - len] == 1)
                    {
                        opt[i] = 1;
                        break;
                    }
                }
            }
        }
        if (opt[s.length() - 1] == 1)
            return true;
        else
            return false;
    }
};
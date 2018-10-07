package javasrc;

import java.util.ArrayList;
import java.util.List;

public class UberLetterCombinationOfPhoneNumber {
    String[] store = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
        // BFS + Queue: string[] mapping of num-char (add 0 1); explore each level by retriving and append then add back
        /*LinkedList<String> ans = new LinkedList<String>();
		if(digits.isEmpty()) return ans;
		String[] mapping = new String[] {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
		ans.add("");
		while(ans.peek().length()!=digits.length()){
			String remove = ans.remove();
			String map = mapping[digits.charAt(remove.length())-'0'];
			for(char c: map.toCharArray()){
				ans.addLast(remove+c);
			}
		}
		return ans;*/

        //DFS + stringbuilder
        // remember to reset when returning back from next level

        List<String> result = new ArrayList();
        if(digits == null || digits.length()==0)
            return result;
        helper(result,digits, new StringBuilder(),0);
        return result;
    }
    private void helper(List<String> result, String digits, StringBuilder runStr, int idx){
        if(idx == digits.length()){
            result.add(runStr.toString());
            return;
        }
        char[] chars = store[digits.charAt(idx)-'0'].toCharArray();
        for(char c : chars){
            helper(result,digits, runStr.append(c),idx+1);
            runStr.deleteCharAt(runStr.length()-1);
        }
    }
}

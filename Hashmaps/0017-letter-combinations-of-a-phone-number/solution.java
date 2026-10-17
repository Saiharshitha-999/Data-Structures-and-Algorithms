class Solution {

    String[] map = {
        "", "", "abc", "def",
        "ghi", "jkl", "mno",
        "pqrs", "tuv", "wxyz"
    };

    public List<String> letterCombinations(String digits) {

        List<String> ans = new ArrayList<>();
        if(digits.length() == 0)
        {
            return ans;
        }

        helper(0, digits, new StringBuilder(), ans);
        return ans;
    }

    public void helper(int index,
                       String digits,
                       StringBuilder curr,
                       List<String> ans)
    {
        if(index == digits.length())
        {
            ans.add(curr.toString());
            return;
        }

        String letters =
            map[digits.charAt(index) - '0'];

        for(int i = 0; i < letters.length(); i++)
        {
            curr.append(letters.charAt(i));

            helper(index + 1,
                   digits,
                   curr,
                   ans);

            curr.deleteCharAt(curr.length() - 1);
        }
    }
}

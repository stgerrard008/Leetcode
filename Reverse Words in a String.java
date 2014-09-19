public class Solution {
    public String reverseWords(String s) {
        if (s == null)
            return null;
        char[] ch = s.toCharArray();
        String r = "";
        String word = "";
        for(int i = 0;i<ch.length;i++){
            if (ch[i]!=' '){
                word += ch[i];
            }else{
                if (!word.trim().equals("")){
                    r = " " + word + r;
                }
                word = "";
            }
        }
        if (!word.trim().equals("")){
            r = word + r;
        }
        return r.trim();
    }
}
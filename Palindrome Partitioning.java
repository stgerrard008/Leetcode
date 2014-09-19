public class Solution {
    private ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
    public ArrayList<ArrayList<String>> partition(String s) {
        ArrayList<String> temp = new ArrayList<String>();
        recurse(s,temp);
        return result;
    }
    
    private void recurse(String s, ArrayList<String> temp){
        String head;
        if (s.equals("")){
        	ArrayList<String> t = new ArrayList<String>();
        	for(int i=0;i<temp.size();i++)
        		t.add(temp.get(i));
            result.add(t);
        }else{
            for(int i = 0; i < s.length(); i++){
                head = s.substring(0,i+1);
                if (palindrome(head)){
                    temp.add(head);
                    recurse(s.substring(i+1), temp);
                    temp.remove(temp.size()-1);
                }
            }
        }
    }
    
    private boolean palindrome(String s){
        int len = s.length();
        for(int i =0; i < len/2; i++){
            if (!s.substring(i,i+1).equals(s.substring(len-1-i,len-i)))
            return false;
        }
        return true;
    }
}

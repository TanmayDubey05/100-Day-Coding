class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        HashMap<String, Integer> map = new HashMap();
        ArrayList<String> ret = new ArrayList<>();

        for(int i = 0; i<s.length()-9; i++) {
            String substring = s.substring(i,i+10);
            if(map.containsKey(substring)){
                map.replace(substring, map.get(substring)+1);
            }
            else{
                map.put(substring,1);
            }
            if (map.get(substring)==2) {
                ret.add(substring);
            }
        }
        return ret;
    }
}
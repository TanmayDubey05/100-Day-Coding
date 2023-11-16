class Solution {
    public String intToRoman(int num) {
    int[] val = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] syms = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < val.length; i++) {
            while (num >= val[i]) {
                num -= val[i];
                result.append(syms[i]);
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int num1 = 3;
        int num2 = 58;
        int num3 = 1994;

        System.out.println(solution.intToRoman(num1));
        System.out.println(solution.intToRoman(num2));  
        System.out.println(solution.intToRoman(num3));  
    }
}
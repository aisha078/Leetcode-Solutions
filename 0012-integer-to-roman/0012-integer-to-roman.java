class Solution {
    public String intToRoman(int num) {
        // Core values mapped to their Roman numeral equivalents in descending order
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        
        StringBuilder roman = new StringBuilder();
        
        // Loop through the values array
        for (int i = 0; i < values.length; i++) {
            // Repeat the symbol while the number is greater than or equal to the value
            while (num >= values[i]) {
                roman.append(symbols[i]);
                num -= values[i];
            }
            
            // Early exit if the number is fully converted
            if (num == 0) {
                break;
            }
        }
        
        return roman.toString();
    }
}
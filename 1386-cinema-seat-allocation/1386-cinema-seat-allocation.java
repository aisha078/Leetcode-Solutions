class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {

        HashMap<Integer, Integer> map = new HashMap<>();

        
        for (int[] seat : reservedSeats) {

            int row = seat[0];
            int col = seat[1];

            
            if (col >= 2 && col <= 9) {

                int bit = 1 << (col - 2);

                map.put(row, map.getOrDefault(row, 0) | bit);
            }
        }

        
        int answer = (n - map.size()) * 2;

        for (int mask : map.values()) {

            boolean left =
                    (mask & 0b00001111) == 0;

            boolean middle =
                    (mask & 0b00111100) == 0;

            boolean right =
                    (mask & 0b11110000) == 0;

            if (left && right) {
                answer += 2;
            }
            else if (left || middle || right) {
                answer += 1;
            }
        }

        return answer;
    }
}
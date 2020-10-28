package exam;

public class leetcode464 {
	public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (maxChoosableInteger >= desiredTotal) return true;
        if ((1 + maxChoosableInteger) * maxChoosableInteger / 2 < desiredTotal) return false;
        int[] state = new int[maxChoosableInteger + 1]; 

        return backtraceWitMemo(state, desiredTotal, new HashMap<String, Boolean>());
    }

    private boolean backtraceWitMemo(int[] state, int total, HashMap<String, Boolean> map) {
        String key = Arrays.toString(state);
        if (map.containsKey(key)) return map.get(key);

        for (int i = 1; i < state.length; i++){
            if (state[i] == 0){ //如果这个数字i还没有被选中
                state[i] = 1;
                if (total - i <= 0 || !backtraceWitMemo(state, total - i, map)) {
                    map.put(key, true);
                    state[i] = 0; //在返回之前回溯
                    return true;
                }
                state[i] = 0;
            }
        }
        map.put(key, false);
        return false;
    }
}

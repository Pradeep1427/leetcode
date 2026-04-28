import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, new ArrayList<>(), candidates, target, 0);
        return res;
    }

    private void backtrack(List<List<Integer>> res, List<Integer> temp, int[] arr, int target, int start) {
        if (target == 0) {
            res.add(new ArrayList<>(temp));
            return;
        }

        if (target < 0) return;

        for (int i = start; i < arr.length; i++) {
            temp.add(arr[i]);
            backtrack(res, temp, arr, target - arr[i], i);
            temp.remove(temp.size() - 1);
        }
    }
}
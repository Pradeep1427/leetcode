import java.util.*;

class Solution {
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        int[] counts = new int[n];
        int[][] arr = new int[n][2]; // {value, index}

        for (int i = 0; i < n; i++) {
            arr[i][0] = nums[i];
            arr[i][1] = i;
        }

        mergeSort(arr, 0, n - 1, counts);

        List<Integer> res = new ArrayList<>();
        for (int c : counts) res.add(c);
        return res;
    }

    private void mergeSort(int[][] arr, int left, int right, int[] counts) {
        if (left >= right) return;

        int mid = (left + right) / 2;
        mergeSort(arr, left, mid, counts);
        mergeSort(arr, mid + 1, right, counts);
        merge(arr, left, mid, right, counts);
    }

    private void merge(int[][] arr, int left, int mid, int right, int[] counts) {
        List<int[]> temp = new ArrayList<>();
        int i = left, j = mid + 1;
        int rightCount = 0;

        while (i <= mid && j <= right) {
            if (arr[j][0] < arr[i][0]) {
                rightCount++;
                temp.add(arr[j++]);
            } else {
                counts[arr[i][1]] += rightCount;
                temp.add(arr[i++]);
            }
        }

        while (i <= mid) {
            counts[arr[i][1]] += rightCount;
            temp.add(arr[i++]);
        }

        while (j <= right) {
            temp.add(arr[j++]);
        }

        for (int k = 0; k < temp.size(); k++) {
            arr[left + k] = temp.get(k);
        }
    }
}
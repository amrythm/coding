package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FOurSum {

    public static void main(String[] args) {
        int[] arr = {1,0,-1,0,-2,2};

        List<List<Integer>> ans = fourSum(arr, 0);

        for (List<Integer> i: ans) {
            System.out.println(i);
        }
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {

        Arrays.sort(nums);
        int n = nums.length;

        List<List<Integer>> list = new ArrayList<>();

        for(int i = 0; i< n-3; i++) {
            for(int j = i+1; j<n-2; j++) {

                int left = j+1;
                int right = n-1;
                int sum = nums[i] + nums[j];
                int temp_target = target - sum;
                while(left < right) {

                    if(temp_target == nums[i] + nums[j]){
                        List<Integer> x = new ArrayList<>();
                        x.add(nums[i]);
                        x.add(nums[j]);
                        x.add(nums[left]);
                        x.add(nums[right]);
                        list.add(x);
                        int temp = nums[left];
                        while (left < n - 1 && nums[left] == temp)
                            left++;
                        int temp2 = nums[right];
                        while (right > 2 && nums[right] == temp2)
                            right--;
                    }
                    else if(temp_target < nums[left] + nums[right]) {
                        int temp = nums[right];
                        while(right > 2 && nums[right] == temp)
                            right--;
                    } else if(temp_target > nums[left] + nums[right]) {
                        int temp = nums[left];
                        while(left <n-1 && nums[left] == temp)
                            left++;
                    }
                }
                int temp = nums[j];
                while(j< n-2 && nums[j]== nums[j+1])
                    j++;
            }
            int temp = nums[i];
            while(i<n-3 && nums[i]== nums[i+1])
                i++;
        }

        return list;
    }
}

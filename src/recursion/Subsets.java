package recursion;

import java.util.*;

public class Subsets {
    List<List<Integer>> lists;
    Set<List<Integer>> set;

    /**
     * Broken!!!!!
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {
        set = new HashSet<>();
        lists = new LinkedList<>();
        lists.add(new LinkedList<Integer>());
        subsets(nums, 0, new LinkedList<Integer>());
        return lists;
    }

    private void subsets(int[] nums, int index, List<Integer> list) {
        if(index == lists.size() || index == nums.length) {
            lists.add(list);
            return;
        }
        LinkedList<Integer> copy = new LinkedList<>(list);
        copy.add(nums[index]);
        lists.add(copy);//adds

        subsets(nums, index + 1, copy);
        LinkedList<Integer> newList = new LinkedList<>();
            newList.add(nums[index]);
        //lists.add(newList);
        subsets(nums, index + 1, newList);
    }

    /**
     * Correct way
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets1(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        result.add(new ArrayList<Integer>());
        for (int i = 0; i < nums.length; i++) {
            int currentSize = result.size();
            for (int j = 0; j < currentSize; j++) {
                ArrayList<Integer> temp2 = (ArrayList<Integer>) result.get(j);
                List<Integer> newTemp = (ArrayList<Integer>) temp2.clone();
                newTemp.add(nums[i]);
                result.add(newTemp);
            }
        }
        return result;
    }
}

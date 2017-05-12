package com.superluli.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FrequentTreeSum {
	
	public static void main(String[] args) {
		
		TreeNode root = TreeNode.fromTreeString("3,1,5,0,2,4,6,#,#,#,3");
		System.err.println(root);
		System.err.println(Arrays.toString(findFrequentTreeSum(root)));
	}
	
    public static int[] findFrequentTreeSum(TreeNode root) {
        
        if(root == null) return new int[0];
        
        Map<Integer, Integer> counts = new HashMap<Integer, Integer>();
        findTreeSum(root, counts);
        int maxCount = -1;
        List<Integer> maxSums = new ArrayList<Integer>();
        for(Map.Entry<Integer, Integer> entry : counts.entrySet()){
            int sum = entry.getKey();
            int count = entry.getValue();
            if(count >= maxCount){
                if(count > maxCount) maxSums.clear();
                maxSums.add(sum);
                maxCount = count;
            }
        }
        int[] arr = new int[maxSums.size()];
        for(int i = 0; i < maxSums.size(); i++){
            arr[i] = maxSums.get(i);
        }
        return arr;
    }
    
    public static int findTreeSum(TreeNode root, Map<Integer, Integer> counts) {
        
        if(root == null) return 0;
        
        int leftSum = root.left != null ? findTreeSum(root.left, counts) : 0;
        int rightSum = root.right != null ? findTreeSum(root.right, counts) : 0;
        int sum = root.val + leftSum + rightSum;
        if(counts.containsKey(sum)){
            int count = counts.get(sum);
            counts.put(sum, count+1);
        }
        else counts.put(sum, 1);
        return sum;
    }
}

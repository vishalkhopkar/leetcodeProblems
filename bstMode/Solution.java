package bstMode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Solution {
	List<Integer> traversal;
	int noWithMaxFreq, maxFreq = Integer.MIN_VALUE, currFreq, prev;
	Map<Integer, Integer> frequencies = new HashMap<>();
	public int[] findMode(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        traversal = new ArrayList<>();
        inorder(root);
        frequencies.put(traversal.get(traversal.size() - 1), currFreq);
        // now traversal and map gets filled
        int maxFreq = Integer.MIN_VALUE;
        for(int y : frequencies.values()) {
        	if(y > maxFreq) maxFreq = y;
        }
        for(int x : frequencies.keySet()) {
        	if(frequencies.get(x) == maxFreq){
        		ret.add(x);
        	}
        }
        return convertToArray(ret);
    }
	
	private int[] convertToArray(List<Integer> ret) {
		int[] arr = new int[ret.size()];
		for(int i = 0; i < arr.length; i++)
			arr[i] = ret.get(i);
		return arr;
	}

	void inorder(TreeNode x) {
		if(x != null) {
			inorder(x.left);
			if(traversal.isEmpty()) {
				currFreq = 1;
			}
			else {
				prev = traversal.get(traversal.size() - 1);
				if (x.val == prev) {
					// if curr is same as the last elem in the traversal list
					// increase frequency
					currFreq++;
				}
				else {
					// x.val is not the same as the last elem
					frequencies.put(prev, currFreq);
					currFreq = 1;
				}
			}
			traversal.add(x.val);
			inorder(x.right);
			
		}
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		Integer[] nums = {10, 5, 15, 3, 5, null, null, null, null, 5};
		TreeNode bt = buildBinarySearchTree(nums);
		System.out.println(Arrays.toString(s.findMode(bt)));
	}

	private static TreeNode buildBinarySearchTree(Integer[] nums) {
		TreeNode[] nodes = new TreeNode[nums.length];
		for(int i = 0; i < nums.length; i++) {
			nodes[i] = (nums[i] == null) ? null : new TreeNode(nums[i]);
		}
		for(int i = 0; i < nums.length/2; i++) {
			if(nodes[i] != null) {
				nodes[i].left = (2*i + 1) >= nums.length ? null : nodes[2*i + 1];
				nodes[i].right = (2*i + 2) >= nums.length ? null : nodes[2*i + 2];
			}
			
		}
		return nodes[0];
	}

}

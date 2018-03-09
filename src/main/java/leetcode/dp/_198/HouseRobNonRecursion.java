package leetcode.dp._198;

/**
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police
 * @author Administrator
 *
 */
public class HouseRobNonRecursion{
	
    public int rob(int[] nums) {
    	if (nums.length == 0) {
			return 0;
		}
		return _rob(0,nums );
    }

	private int _rob(int idx, int[] nums) {
		if (idx >= nums.length) {
			return 0;
		}
//		抢了当前的house，idx+2,至少隔一个再抢
		int a = nums[idx]+_rob(idx+2, nums);
//		没有抢当前的house，idx+1,可以从下一个开始抢
		int b = 0+_rob(idx+1, nums);
//		求出两种策略的最大值，返回最大的
		int res = Math.max(a, b);
		return res;
	}
}

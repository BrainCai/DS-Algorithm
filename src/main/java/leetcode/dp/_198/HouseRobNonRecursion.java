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
//		���˵�ǰ��house��idx+2,���ٸ�һ������
		int a = nums[idx]+_rob(idx+2, nums);
//		û������ǰ��house��idx+1,���Դ���һ����ʼ��
		int b = 0+_rob(idx+1, nums);
//		������ֲ��Ե����ֵ����������
		int res = Math.max(a, b);
		return res;
	}
}

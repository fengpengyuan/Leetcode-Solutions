package com.Solution;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;



public class Solution {

	public static int findMin(int[] arr) {
		int low = 0;
		int high = arr.length - 1;
		while (arr[low] > arr[high]) {
			int mid = (low + high) / 2;
			if (arr[mid] > arr[high])
				low = mid + 1;
			else
				high = mid;
		}
		return arr[low];
	}

	public static void printAllKLength(char[] set, int k) {
		int n = set.length;
		printAllKLength(set, n, k, "");

	}

	public static void printAllKLength(char[] set, int n, int k, String s) {
		if (k == 0) {
			System.out.println(s);
			return;
		}

		for (int i = 0; i < n; i++) {
			s += set[i];
			// String prefix=s+set[i];
			printAllKLength(set, n, k - 1, s);
			s = s.substring(0, s.length() - 1);
		}
	}

	public static boolean arithmeticThree(int set[]) {
		int n = set.length;
		if (n < 3)
			return false;

		for (int j = n - 2; n > 0; n--) {
			int i = j - 1, k = j + 1;
			while (i >= 0 && k <= n - 1) {
				if (set[i] + set[k] > 2 * set[j])
					i--;
				else if (set[i] + set[k] < 2 * set[j])
					k++;
				else
					return true;
			}
		}
		return false;

	}

	public static int lenghtOfLongestAP(int set[]) {
		if (set.length <= 2)
			return set.length;
		int n = set.length;

		int[][] length = new int[n][n];

		for (int i = 0; i < n; i++)
			length[i][n - 1] = 2;
		int maxlength = 2;

		for (int j = n - 2; j > 0; j--) {
			int i = j - 1, k = j + 1;

			while (i >= 0 && k <= n - 1) {
				if (set[i] + set[k] < 2 * set[j])
					k++;
				else if (set[i] + set[k] > 2 * set[j]) {
					length[i][j] = 2;
					i--;
				} else {
					length[i][j] = length[j][k] + 1;
					maxlength = Math.max(maxlength, length[i][j]);
					i--;
					k++;
				}
			}

			// If the loop was stopped due to k becoming more than
			// n-1, set the remaining entries in column j as 2
			while (i >= 0) {
				length[i][j] = 2;
				i--;
			}
		}

		return maxlength;
	}

	public static void rearrange1(int[] arr) {
		int n = arr.length;

		// int[] res=new int[n];
		int k = 0;
		int i = 1;

		while (i < n) {
			if (arr[i] * arr[k] < 0) {
				k++;
				i++;
			} else {
				while (i < n && arr[i] * arr[k] > 0) {
					i++;
				}
				if (i >= n)
					break;
				else {
					int t = arr[k + 1];
					arr[k + 1] = arr[i];
					arr[i] = t;
					k++;
					i = k + 1;
				}

			}
		}

		for (int j = 0; j < n; j++) {
			System.out.print(arr[j] + " ");
		}
	}

	public static void rearrange2(int[] arr) {
		int n = arr.length;
		int i = -1;

		for (int j = 0; j < n; j++) {
			if (arr[j] < 0) {
				i++;
				int t = arr[i];
				arr[i] = arr[j];
				arr[j] = t;
			}
		}

		int pos = i + 1;
		int neg = 0;
		while (pos < n && neg < pos && arr[neg] < 0) {
			int t = arr[neg];
			arr[neg] = arr[pos];
			arr[pos] = t;
			pos++;
			neg += 2;
		}

		for (int j = 0; j < n; j++) {
			System.out.print(arr[j] + " ");
		}
	}

	public int threeSumClosest(int[] num, int target) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (num.length < 3)
			return 0;
		Arrays.sort(num);
		int minDif = Integer.MAX_VALUE;
		int closest = Integer.MAX_VALUE;
		for (int i = 0; i < num.length; i++) {
			int j = i + 1;
			int k = num.length - 1;
			while (j < k) {
				int sum = num[i] + num[j] + num[k];
				int dif = Math.abs(sum - target);
				if (sum == target)
					return target;
				if (dif < minDif) {
					minDif = dif;
					closest = sum;
				}
				if (sum > target)
					k--;
				else
					j++;
			}
		}
		return closest;
	}

	public String addBinary(String a, String b) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int l1 = a.length();
		int l2 = b.length();
		String res = "";
		int carry = 0;

		while (l1 > 0 && l2 > 0) {
			int sum = a.charAt(l1 - 1) - '0' + b.charAt(l2 - 1) - '0' + carry;
			carry = sum / 2;
			sum = sum % 2;
			res = "" + sum + res;
			l1--;
			l2--;
		}

		while (l1 > 0) {
			int sum = a.charAt(l1 - 1) - '0' + carry;
			carry = sum / 2;
			sum = sum % 2;
			res = "" + sum + res;
			l1--;

		}

		while (l2 > 0) {
			int sum = b.charAt(l2 - 1) - '0' + carry;
			carry = sum / 2;
			sum = sum % 2;
			res = "" + sum + res;
			l2--;

		}
		if (carry == 1)
			res = "1" + res;
		return res;
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (l1 == null || l2 == null)
			return l1 == null ? l2 : l1;

		int carry = 0;
		ListNode head = new ListNode(0);
		ListNode cur = head;

		while (l1 != null && l2 != null) {
			int sum = l1.val + l2.val + carry;
			carry = sum / 10;
			sum = sum % 10;
			cur.next = new ListNode(sum);
			cur = cur.next;
			l1 = l1.next;
			l2 = l2.next;

		}
		while (l1 != null) {
			int sum = l1.val + carry;
			carry = sum / 10;
			sum = sum % 10;
			cur.next = new ListNode(sum);
			cur = cur.next;
			l1 = l1.next;

		}

		while (l2 != null) {
			int sum = l2.val + carry;
			carry = sum / 10;
			sum = sum % 10;
			cur.next = new ListNode(sum);
			cur = cur.next;
			l2 = l2.next;

		}
		if (carry == 1) {
			cur.next = new ListNode(1);
		}
		return head.next;
	}

	public ArrayList<String> anagrams(String[] strs) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<String> res = new ArrayList<String>();
		HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();

		for (String s : strs) {
			char[] ch = s.toCharArray();
			Arrays.sort(ch);
			String key = new String(ch);
			if (!map.containsKey(key)) {
				ArrayList<String> lst = new ArrayList<String>();
				lst.add(s);
				map.put(key, lst);
			} else {
				map.get(key).add(s);
			}
		}

		Iterator<ArrayList<String>> it = map.values().iterator();
		while (it.hasNext()) {
			ArrayList<String> list = it.next();
			if (list.size() > 1)
				res.addAll(list);
		}
		return res;
	}

	public boolean isBalanced(TreeNode root) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (root == null)
			return true;
		int left = getHeight(root.left);
		int right = getHeight(root.right);
		if (Math.abs(left - right) > 1)
			return false;
		else
			return isBalanced(root.left) && isBalanced(root.right);

	}

	public int getHeight(TreeNode root) {
		if (root == null)
			return 0;
		int left = getHeight(root.left);
		int right = getHeight(root.right);
		if (left > right)
			return left + 1;
		else
			return right + 1;
	}

	public boolean isSameTree(TreeNode p, TreeNode q) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (p == null && q == null)
			return true;
		if (p == null || q == null)
			return false;
		if (p.val != q.val)
			return false;
		else
			return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
	}

	public ArrayList<Integer> inorderTraversal(TreeNode root) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<Integer> res = new ArrayList<Integer>();
		if (root == null)
			return res;
		Stack<TreeNode> stk = new Stack<TreeNode>();
		TreeNode cur = root;
		while (cur != null) {
			stk.push(cur);
			cur = cur.left;
		}

		while (!stk.isEmpty()) {
			TreeNode top = stk.pop();
			res.add(top.val);
			if (top.right != null) {
				TreeNode node = top.right;
				while (node != null) {
					stk.push(node);
					node = node.left;
				}

			}

		}
		return res;

	}

	public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> list = new ArrayList<Integer>();
		if (root == null)
			return res;
		Queue<TreeNode> q1 = new LinkedList<TreeNode>();
		Queue<TreeNode> q2 = new LinkedList<TreeNode>();
		q1.add(root);
		while (!q1.isEmpty()) {
			TreeNode top = q1.remove();
			list.add(top.val);

			if (top.left != null)
				q2.add(top.left);
			if (top.right != null)
				q2.add(top.right);
			if (q1.isEmpty()) {
				res.add(list);
				list = new ArrayList<Integer>();
				q1 = q2;
				q2 = new LinkedList<TreeNode>();
			}
		}
		return res;
	}

	public ArrayList<ArrayList<Integer>> levelOrder2(TreeNode root) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> list = new ArrayList<Integer>();
		if (root == null)
			return res;
		Queue<TreeNode> que = new LinkedList<TreeNode>();
		int levelnum = 0;
		int nextlevel = 0;
		que.add(root);
		levelnum++;
		while (!que.isEmpty()) {
			TreeNode top = que.remove();
			list.add(top.val);
			levelnum--;
			if (top.left != null) {
				que.add(top.left);
				nextlevel++;
			}
			if (top.right != null) {
				que.add(top.right);
				nextlevel++;
			}
			if (levelnum == 0) {
				res.add(list);
				list = new ArrayList<Integer>();
				levelnum = nextlevel;
				nextlevel = 0;
			}
		}
		return res;
	}

	public void reverseLevelOrder(TreeNode root) {
		if (root == null)
			return;
		int height = getHeight(root);
		for (int i = height; i > 0; i--)
			reverseLevelorder(root, i);
	}

	public void reverseLevelorder(TreeNode root, int level) {
		if (root == null)
			return;
		if (level == 1)
			System.out.println(root.val);
		else {
			reverseLevelorder(root.left, level - 1);
			reverseLevelorder(root.right, level - 1);
		}
	}

	public int climbStairs(int n) {
		// Start typing your Java solution below
		// DO NOT write main() function
		// if(n==1)
		// return 1;
		// else if(n==2)
		// return 2;
		// else
		// return climbStairs(n-1)+climbStairs(n-2);
		if (n == 1)
			return 1;
		if (n == 2)
			return 2;
		int first = 1;
		int second = 2;
		int total = 0;
		for (int i = 3; i <= n; i++) {
			total = first + second;
			first = second;
			second = total;
		}
		return total;

	}

	public TreeNode buildTree(int[] inorder, int[] postorder) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (inorder.length == 0)
			return null;
		int n = postorder.length;
		return buildTree(inorder, 0, n - 1, postorder, 0, n - 1);

	}

	public TreeNode buildTree(int[] inorder, int beg1, int end1,
			int[] postorder, int beg2, int end2) {
		if (beg1 > end1)
			return null;
		TreeNode root = new TreeNode(postorder[end2]);
		int index = -1;
		for (int i = beg1; i <= end1; i++) {
			if (inorder[i] == postorder[end2]) {
				index = i;
				break;
			}
		}
		int len = index - beg1;
		root.left = buildTree(inorder, beg1, index - 1, postorder, beg2, beg2
				+ len - 1);
		root.right = buildTree(inorder, index + 1, end1, postorder, beg2 + len,
				end2 - 1);
		return root;
	}

	public TreeNode buildTree2(int[] preorder, int[] inorder) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (preorder.length == 0)
			return null;
		int n = preorder.length;

		return buildTree2(preorder, 0, n - 1, inorder, 0, n - 1);
	}

	public TreeNode buildTree2(int[] preorder, int beg1, int end1,
			int[] inorder, int beg2, int end2) {
		if (beg1 > end1)
			return null;
		TreeNode root = new TreeNode(preorder[beg1]);
		int index = -1;
		for (int i = beg2; i <= end2; i++) {
			if (inorder[i] == preorder[beg1]) {
				index = i;
				break;
			}
		}
		int len = index - beg2;
		root.left = buildTree2(preorder, beg1 + 1, beg1 + len, inorder, beg2,
				index - 1);
		root.right = buildTree2(preorder, beg1 + len + 1, end1, inorder,
				index + 1, end2);
		return root;
	}

	public TreeNode sortedArrayToBST(int[] num) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (num.length == 0)
			return null;
		int n = num.length;
		return sortedArrayToBST(num, 0, n - 1);

	}

	public TreeNode sortedArrayToBST(int[] num, int beg, int end) {
		if (beg > end)
			return null;
		int mid = (beg + end) / 2;
		TreeNode root = new TreeNode(num[mid]);

		root.left = sortedArrayToBST(num, beg, mid - 1);
		root.right = sortedArrayToBST(num, mid + 1, end);
		return root;
	}

	public TreeNode sortedListToBST(ListNode head) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (head == null)
			return null;
		int l = 0;
		ListNode cur = head;
		while (cur != null) {
			l++;
			cur = cur.next;
		}

		return sortedListToBST(head, 0, l - 1);
	}

	public TreeNode sortedListToBST(ListNode head, int beg, int end) {
		if (head == null || beg > end)
			return null;
		int mid = (beg + end) / 2;
		ListNode cur = head;
		for (int i = beg; i < mid; i++)
			cur = cur.next;

		TreeNode root = new TreeNode(cur.val);

		root.left = sortedListToBST(head, beg, mid - 1);
		root.right = sortedListToBST(cur.next, mid + 1, end);
		return root;
	}

	public ArrayList<String> generateParenthesis(int n) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<String> res = new ArrayList<String>();
		if (n <= 0)
			return res;

		String s = "";
		generateParenthesis(n, 0, 0, s, res);
		return res;
	}

	public void generateParenthesis(int n, int left, int right, String s,
			ArrayList<String> res) {
		if (left == n && left == right) {
			res.add(s);
			return;
		}
		if (left < n) {
			generateParenthesis(n, left + 1, right, s + "(", res);
		}
		if (right < left)
			generateParenthesis(n, left, right + 1, s + ")", res);
	}

	public void merge(int A[], int m, int B[], int n) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int i = m - 1;
		int j = n - 1;
		int k = m + n - 1;
		while (i >= 0 && j >= 0) {
			if (A[i] > B[j]) {
				A[k--] = A[i--];

			} else {
				A[k--] = B[j--];
			}
		}

		while (j >= 0)
			A[k--] = B[j--];

	}

//	class Mycomparator implements Comparator<Interval> {
//
//		@Override
//		public int compare(Interval o1, Interval o2) {
//			// TODO Auto-generated method stub
//
//			return o1.start - o2.start;
//		}
//
//	}
//
//	public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
//		// Start typing your Java solution below
//		// DO NOT write main() function
//		ArrayList<Interval> res = new ArrayList<Interval>();
//		if (intervals.size() < 2)
//			return intervals;
//		Collections.sort(intervals, new Mycomparator());
//		res.add(intervals.get(0));
//
//		for (int i = 1; i < intervals.size(); i++) {
//			Interval interval = intervals.get(i);
//			Interval lastinterval = res.get(res.size() - 1);
//			if (interval.start > lastinterval.end) {
//				res.add(interval);
//			} else {
//				lastinterval.end = Math.max(interval.end, lastinterval.end);
//			}
//
//		}
//		return res;
//	}

	public int[] plusOne(int[] digits) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int n = digits.length;
		int carry = 1;
		for (int i = n - 1; i >= 0; i--) {
			int sum = digits[i] + carry;
			carry = sum / 10;
			sum = sum % 10;
			digits[i] = sum;
		}
		if (carry == 1) {
			int[] res = new int[n + 1];
			res[0] = 1;
			for (int i = 1; i < n + 1; i++) {
				res[i] = digits[i - 1];
			}
			return res;
		}
		return digits;
	}

	public boolean searchMatrix(int[][] matrix, int target) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int n = matrix.length;
		int m = matrix[0].length;

		int i = 0;
		int j = m - 1;
		while (i < n && j >= 0) {
			if (matrix[i][j] == target)
				return true;
			else if (matrix[i][j] > target)
				j--;
			else
				i++;
		}
		return false;

	}

	public int search(int[] A, int target) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (A.length == 0)
			return -1;
		int beg = 0;
		int end = A.length - 1;
		while (beg <= end) {
			int mid = (beg + end) / 2;
			if (A[mid] == target)
				return mid;
			else if (A[mid] >= A[beg]) {
				if (A[beg] <= target && target < A[mid])
					end = mid - 1;
				else
					beg = mid + 1;
			} else {
				if (A[mid] < target && target <= A[end])
					beg = mid + 1;
				else
					end = mid - 1;
			}
		}
		return -1;
	}

	public ListNode deleteDuplicates(ListNode head) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (head == null)
			return null;
		ListNode cur = head.next;
		ListNode pre = head;
		while (cur != null) {
			if (cur.val != pre.val) {
				pre.next = cur;
				cur = cur.next;
				pre = pre.next;
			} else {
				cur = cur.next;
			}
		}
		pre.next = null;
		return head;
	}

	public ListNode removeNthFromEnd(ListNode head, int n) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (head == null)
			return null;
		ListNode cur = head;
		for (int i = 0; i < n; i++)
			cur = cur.next;

		ListNode t = head;
		ListNode pre = null;

		while (cur != null) {
			pre = t;
			cur = cur.next;
			t = t.next;
		}
		if (pre != null) {
			pre.next = t.next;
			return head;
		} else
			return head.next;
	}

	public ArrayList<Interval> insert(ArrayList<Interval> intervals,
			Interval newInterval) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (intervals.size() == 0) {
			intervals.add(newInterval);
			return intervals;
		}

		ArrayList<Interval> res = new ArrayList<Interval>();
		boolean inserted = false;
		for (int i = 0; i < intervals.size(); i++) {
			Interval interval = intervals.get(i);
			if (interval.start < newInterval.start) {
				insertInterval(res, interval);
			} else {
				insertInterval(res, newInterval);
				inserted = true;
				insertInterval(res, interval);
			}
		}
		if (!inserted)
			insertInterval(res, newInterval);
		return res;
	}

	public void insertInterval(ArrayList<Interval> res, Interval interval) {
		if (res.size() == 0) {
			res.add(interval);
			return;
		}

		Interval intval = res.get(res.size() - 1);
		if (intval.end >= interval.start) {
			intval.end = Math.max(interval.end, intval.end);
		} else
			res.add(interval);
	}

	public boolean isInterleave(String s1, String s2, String s3) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int l1 = s1.length();
		int l2 = s2.length();
		int l3 = s3.length();
		if (l3 != l1 + l2)
			return false;

		boolean[][] dp = new boolean[l1 + 1][l2 + 1];
		dp[0][0] = true;
		for (int i = 1; i <= l1; i++)
			dp[i][0] = dp[i - 1][0] && s1.charAt(i - 1) == s3.charAt(i - 1);
		for (int i = 1; i <= l2; i++)
			dp[0][i] = dp[0][i - 1] && s2.charAt(i - 1) == s3.charAt(i - 1);

		for (int i = 1; i <= l1; i++) {
			for (int j = 1; j <= l2; j++) {
				dp[i][j] = dp[i - 1][j]
						&& s1.charAt(i - 1) == s3.charAt(i + j - 1)
						|| dp[i][j - 1]
						&& s2.charAt(j - 1) == s3.charAt(i + j - 1);
			}
		}
		return dp[l1][l2];

	}

	public boolean hasPathSum(TreeNode root, int sum) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (root == null)
			return false;
		int curSum = 0;
		return hasPathSum(root, sum, curSum);
	}

	public boolean hasPathSum(TreeNode root, int sum, int curSum) {
		if (root == null)
			return false;
		curSum += root.val;
		if (curSum == sum && root.left == null && root.right == null)
			return true;
		else {
			return hasPathSum(root.left, sum, curSum)
					|| hasPathSum(root.right, sum, curSum);
		}
	}

	public ListNode rotateRight(ListNode head, int n) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (head == null)
			return null;
		int len = 0;
		ListNode cur = head;
		while (cur != null) {
			cur = cur.next;
			len++;
		}
		n = n % len;
		if (n == 0)
			return head;

		cur = head;
		for (int i = 0; i < n; i++) {
			cur = cur.next;
		}
		ListNode pre = head;
		while (cur != null && cur.next != null) {
			pre = pre.next;
			cur = cur.next;
		}
		ListNode newhead = pre.next;
		pre.next = null;
		cur.next = head;
		return newhead;
	}

	public static ListNode rotateRight2(ListNode head, int n) {
		if (head == null)
			return null;
		int len = 1;
		ListNode cur = head;
		while (cur.next != null) {
			cur = cur.next;
			len++;
		}
		n = n % len;

		cur.next = head;
		int step = len - n;
		for (int i = 0; i < step; i++)
			cur = cur.next;
		head = cur.next;
		cur.next = null;
		return head;
	}

	public void sortColors(int[] A) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int i = 0;
		int j = A.length - 1;
		while (i < j) {
			while (i < j && A[i] == 0)
				i++;
			while (j > i && A[j] != 0)
				j--;
			if (i < j) {
				int t = A[i];
				A[i] = A[j];
				A[j] = t;
			}
		}

		int k = A.length - 1;
		while (i < k) {
			while (i < k && A[i] == 1)
				i++;
			while (k > i && A[k] == 2)
				k--;
			if (i < k) {
				int t = A[i];
				A[i] = A[k];
				A[k] = t;
			}
		}
	}

	public void sortColors2(int[] A) {
		int i = 0;
		int j = A.length - 1;
		int k = A.length - 1;

		while (i < j) {
			if (A[i] == 2) {
				int t = A[i];
				A[i] = A[k];
				A[k] = t;
				k--;

				if (j > k)
					j = k;
			} else if (A[i] == 1) {
				int t = A[i];
				A[i] = A[j];
				A[j] = t;
				j--;
			} else
				i++;
		}
	}

	public static void printKLength(char[] set, int k) {
		if (k == 0)
			return;
		String s = "";
		int curLen = 0;
		printKLength(set, s, curLen, k);
	}

	public static void printKLength(char[] set, String s, int curLen, int k) {
		if (curLen == k) {
			System.out.println(s);
			return;
		}
		for (int i = 0; i < set.length; i++) {
			s += set[i];
			curLen++;
			printKLength(set, s, curLen, k);
			s = s.substring(0, s.length() - 1);
			curLen--;
		}
	}

	// public ListNode quickSortRecur(ListNode head){
	// if(head==null)
	// return null;
	//
	// ListNode cur=head;
	// while(cur.next!=null){
	// cur=cur.next;
	// }
	//
	// return quickSortRecur(head, cur);
	// // ListNode pivot=cur;
	// //
	// // ListNode newHead=partition(head,pivot);
	// //
	//
	//
	// }
	//
	// public ListNode quickSortRecur(ListNode head, ListNode tail){
	// if(head==null||head==tail)
	// return head;
	// ListNode newHead=partition(head,tail);
	//
	// ListNode cur=newHead;
	// while(cur.next!=tail)
	// cur=cur.next;
	// ListNode p=newHead;
	// while(p!=null&&p.next!=null)
	// p=p.next;
	// ListNode Head=quickSortRecur(newHead,cur);
	// }
	//
	// public ListNode partition(ListNode head, ListNode pivot){
	// if(head==null)
	// return null;
	// ListNode cur=head;
	// ListNode small=new ListNode(0);
	// ListNode smallHead=small;
	// ListNode big=new ListNode(1);
	// ListNode bigHead=big;
	// while(cur!=pivot){
	// if(cur.val<pivot.val){
	// small.next=cur;
	// small=small.next;
	// }
	// else{
	// big.next=cur;
	// big=big.next;
	// }
	// cur=cur.next;
	// }
	// small.next=pivot;
	// pivot.next=bigHead.next;
	//
	// return smallHead.next;
	//
	// }

	public static ListNode mergeSortList(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode mid = getMiddle(head);
		ListNode second = mid.next;
		mid.next = null;

		ListNode fhalf = mergeSortList(head);
		ListNode shalf = mergeSortList(second);

		return mergeList(fhalf, shalf);
	}

	public static ListNode mergeList(ListNode first, ListNode second) {
		if (first == null || second == null)
			return first == null ? first : second;

		ListNode dummy = new ListNode(0);
		ListNode dummyHead = dummy;
		while (first != null && second != null) {
			if (first.val < second.val) {
				dummy.next = first;
				first = first.next;

			} else {
				dummy.next = second;
				second = second.next;
			}
			dummy = dummy.next;
		}
		if (first != null)
			dummy.next = first;
		if (second != null)
			dummy.next = second;

		return dummyHead.next;
	}

	public static ListNode getMiddle(ListNode head) {
		if (head == null)
			return null;
		ListNode cur = head;
		int len = 0;
		while (cur != null) {
			cur = cur.next;
			len++;
		}
		System.out.println(len);
		ListNode p = head;
		for (int i = 0; i < len / 2 - 1; i++) {
			p = p.next;
		}

		return p;
		// ListNode slow, fast; slow = fast = head;
		// while(fast.next != null && fast.next.next != null) {
		// slow = slow.next; fast = fast.next.next;
		// }
		// return slow;
	}

	public int maxDepth(TreeNode root) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (root == null)
			return 0;
		int left = maxDepth(root.left);
		int right = maxDepth(root.right);
		if (left > right)
			return left + 1;
		else
			return right + 1;
	}

	public ListNode mergeKLists(ArrayList<ListNode> lists) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (lists.size() == 0)
			return null;

		while (lists.size() > 1) {
			ListNode list1 = lists.remove(0);
			ListNode list2 = lists.remove(0);

			ListNode node = mergeSortedList(list1, list2);
			lists.add(node);
		}

		return lists.get(0);

	}

	public ListNode mergeSortedList(ListNode node1, ListNode node2) {
		if (node1 == null || node2 == null)
			return node1 == null ? node2 : node1;

		ListNode dummy = new ListNode(0);
		ListNode dummyHead = dummy;
		while (node1 != null && node2 != null) {
			if (node1.val < node2.val) {
				dummy.next = node1;
				node1 = node1.next;
			} else {
				dummy.next = node2;
				node2 = node2.next;
			}
			dummy = dummy.next;
		}
		if (node1 != null)
			dummy.next = node1;
		if (node2 != null)
			dummy.next = node2;
		return dummyHead.next;
	}

	public int minPathSum(int[][] grid) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int n = grid.length;
		int m = grid[0].length;
		int[][] dp = new int[n][m];
		dp[0][0] = grid[0][0];
		for (int i = 1; i < n; i++)
			dp[i][0] = dp[i - 1][0] + grid[i][0];
		for (int i = 1; i < m; i++)
			dp[0][i] = dp[0][i - 1] + grid[0][i];

		for (int i = 1; i < n; i++) {
			for (int j = 1; j < m; j++) {
				dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
			}
		}

		return dp[n - 1][m - 1];
	}

	public int removeElement(int[] A, int elem) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int i = 0;
		int j = 0;
		while (i < A.length) {
			while (i < A.length && A[i] == elem) {
				i++;
			}
			if (i < A.length) {
				A[j] = A[i];
				j++;
			}
			i++;

		}
		return j;
	}

	public int removeElement2(int[] A, int elem) {
		if (A.length == 0)
			return 0;
		int i = 0;
		int j = 0;
		while (i < A.length) {
			if (A[i] != elem) {
				A[j] = A[i];
				j++;
			}
			i++;
		}
		return j;
	}

	public int reverse(int x) {
		// Start typing your Java solution below
		// DO NOT write main() function
		boolean sign = false;
		boolean overflow = false;
		if (x < 0) {
			sign = true;
			x = -x;
		}

		int sum = 0;
		while (x > 0) {
			int digit = x % 10;
			x = x / 10;
			if ((Integer.MAX_VALUE - digit) / 10 >= sum) {
				sum = 10 * sum + digit;
			} else {
				overflow = true;
				break;
			}

		}
		if (sign) {
			if (overflow) {
				return Integer.MIN_VALUE;
			} else
				return -sum;
		} else {
			if (overflow)
				return Integer.MAX_VALUE;
			else
				return sum;
		}

	}

	public ListNode reverseBetween(ListNode head, int m, int n) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (head == null)
			return null;
		ListNode p = head;
		ListNode pre = null;
		for (int i = 0; i < m - 1; i++) {
			pre = p;
			p = p.next;
		}

		ListNode pstart = p;
		ListNode ppre = p;
		ListNode cur = p;
		cur = cur.next;
		for (int i = 0; i < n - m; i++) {
			ListNode pnext = cur.next;
			cur.next = ppre;
			ppre = cur;
			cur = pnext;
		}
		pstart.next = cur;
		if (pre != null) {
			pre.next = ppre;
		} else
			head = ppre;
		return head;

	}

	public ArrayList<ArrayList<Integer>> subsets(int[] S) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> sol = new ArrayList<Integer>();
		if (S.length == 0)
			return res;
		Arrays.sort(S);
		subsets(0, S.length, S, sol, res, 0);
		return res;
	}

	public void subsets(int dep, int maxdep, int[] S, ArrayList<Integer> sol,
			ArrayList<ArrayList<Integer>> res, int curPos) {
		res.add(sol);
		if (dep == maxdep) {
			return;
		} else {
			for (int i = curPos; i < S.length; i++) {
				ArrayList<Integer> list = new ArrayList<Integer>(sol);
				list.add(S[i]);
				subsets(dep + 1, maxdep, S, list, res, i + 1);
			}
		}
	}

	public int removeDuplicates(int[] A) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (A.length < 3)
			return A.length;
		int i = 0;
		int j = 1;
		while (j < A.length) {
			if (A[i] != A[j]) {
				i++;
				A[i] = A[j];
			}
			j++;
		}
		return i + 1;
	}

	public void rotate(int[][] matrix) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (matrix.length == 0)
			return;
		int m = matrix.length;
		int n = matrix[0].length;
		for (int i = 0; i < m; i++) {
			for (int j = i; j < n; j++) {
				int t = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = t;
			}
		}

		for (int i = 0; i < m; i++) {
			int beg = 0;
			int end = n - 1;
			while (beg < end) {
				int t = matrix[i][beg];
				matrix[i][beg] = matrix[i][end];
				matrix[i][end] = t;
				beg++;
				end--;
			}
		}
	}

	public void setZeroes(int[][] matrix) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (matrix.length == 0)
			return;
		int m = matrix.length;
		int n = matrix[0].length;
		int[] row = new int[m];
		int[] col = new int[n];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == 0) {
					row[i] = 1;
					col[j] = 1;
				}
			}
		}

		for (int i = 0; i < m; i++) {
			for (int j = 0; j > n; j++) {
				if (row[i] == 1 || col[j] == 1)
					matrix[i][j] = 0;
			}
		}
	}

	public int uniquePaths(int m, int n) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int[][] dp = new int[m][n];
		for (int i = 0; i < m; i++)
			dp[i][0] = 1;
		for (int j = 0; j < n; j++)
			dp[0][j] = 1;

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
			}
		}
		return dp[m - 1][n - 1];
	}

	public int[] twoSum(int[] numbers, int target) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int[] res = new int[2];
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (int i = 0; i < numbers.length; i++) {
			if (!map.containsKey(numbers[i]))
				map.put(numbers[i], i + 1);
			else {
				if (numbers[i] * 2 == target) {
					res[0] = map.get(numbers[i]);
					res[1] = i + 1;
					return res;
				}
			}
		}
		Arrays.sort(numbers);

		int i = 0;
		int j = numbers.length - 1;
		while (i < j) {
			int sum = numbers[i] + numbers[j];
			if (sum == target) {
				int index1 = map.get(numbers[i]);
				int index2 = map.get(numbers[j]);

				res[0] = index1 < index2 ? index1 : index2;
				res[1] = index1 > index2 ? index1 : index2;
				break;
			} else if (sum > target)
				j--;
			else
				i++;
		}
		return res;
	}

	public int maxProfit(int[] prices) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (prices.length < 2)
			return 0;
		int lowest = prices[0];
		int max = 0;

		for (int i = 1; i < prices.length; i++) {
			if (prices[i] - lowest > max)
				max = prices[i] - lowest;
			if (prices[i] < lowest)
				lowest = prices[i];

		}
		return max;
	}

	public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		if (num.length < 3)
			return res;
		Arrays.sort(num);

		for (int i = 0; i < num.length; i++) {
			int j = i + 1;
			int k = num.length - 1;
			while (j < k) {
				int sum = num[i] + num[j] + num[k];
				if (sum == 0) {
					ArrayList<Integer> sol = new ArrayList<Integer>();
					sol.add(num[i]);
					sol.add(num[j]);
					sol.add(num[k]);
					res.add(sol);
					while (j + 1 < k && num[j] == num[j + 1])
						j++;
					j++;
					while (k - 1 > j && num[k] == num[k - 1])
						k--;
					k--;
				} else if (sum > 0)
					k--;
				else
					j++;
			}

			while (i + 1 < num.length - 2 && num[i] == num[i + 1])
				i++;
			// i++;
		}
		return res;
	}

	public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates,
			int target) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		if (candidates.length == 0)
			return res;
		ArrayList<Integer> sol = new ArrayList<Integer>();
		Arrays.sort(candidates);
		int curSum = 0;
		combinationSum(candidates, target, curSum, sol, res, 0);
		return res;
	}

	public void combinationSum(int[] candidates, int target, int curSum,
			ArrayList<Integer> sol, ArrayList<ArrayList<Integer>> res,
			int curPos) {
		if (curPos == candidates.length || curSum > target)
			return;
		if (curSum == target) {
			ArrayList<Integer> out = new ArrayList<Integer>(sol);
			res.add(out);
		}
		for (int i = curPos; i < candidates.length; i++) {
			curSum += candidates[i];
			sol.add(candidates[i]);
			combinationSum(candidates, target, curSum, sol, res, i);
			curSum -= candidates[i];
			sol.remove(sol.size() - 1);
		}
	}

	public static int longestConsecutive(int[] num) {
		// Start typing your Java solution below
		// DO NOT write main() function
		HashSet<Integer> set = new HashSet<Integer>();
		for (int i : num) {
			set.add(i);
		}
		int res = 0;

		for (int i : num) {
			if (set.contains(i)) {
				// System.out.println(set);
				res = Math.max(res,
						getCount(set, i, true) + getCount(set, i - 1, false));
				// System.out.println(set);
			}
		}
		return res;

	}

	public static int getCount(HashSet<Integer> set, int val, boolean asc) {
		int count = 0;
		while (set.contains(val)) {
			count++;
			set.remove(val);
			if (asc)
				val++;
			else
				val--;

		}
		return count;
	}

	public int searchInsert(int[] A, int target) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (A.length == 0)
			return 0;

		int beg = 0;
		int end = A.length - 1;
		while (beg <= end) {
			int mid = (beg + end) / 2;
			if (A[mid] == target)
				return mid;
			else if (A[mid] < target)
				beg = mid + 1;
			else
				end = mid - 1;
		}
		return beg;

	}

	static int sum = 0;

	public static int sumNumbers(TreeNode root) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (root == null)
			return 0;

		return sumNumbers(root, 0);
	}

	public static int sumNumbers(TreeNode root, int sum) {
		if (root == null)
			return 0;
		sum = sum * 10 + root.val;
		if (root.left == null && root.right == null)
			return sum;
		return sumNumbers(root.left, sum) + sumNumbers(root.right, sum);
	}

	public boolean isSymmetric(TreeNode root) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (root == null)
			return true;

		return isSymmetric(root.left, root.right);

	}

	public boolean isSymmetric(TreeNode left, TreeNode right) {
		if (left == null && right == null)
			return true;
		if (left == null || right == null)
			return false;
		if (left.val != right.val)
			return false;
		else
			return isSymmetric(left.left, right.right)
					&& isSymmetric(left.right, right.left);
	}

	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;
		if (m == 0)
			return 0;
		int[][] dp = new int[m][n];
		dp[0][0] = obstacleGrid[0][0] == 1 ? 0 : 1;

		for (int i = 1; i < m; i++)
			dp[i][0] = obstacleGrid[i][0] == 1 ? 0 : dp[i - 1][0];
		for (int i = 1; i < n; i++)
			dp[0][i] = obstacleGrid[0][i] == 1 ? 0 : dp[0][i - 1];

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				dp[i][j] = obstacleGrid[i][j] == 1 ? 0 : dp[i - 1][j]
						+ dp[i][j - 1];
			}
		}
		return dp[m - 1][n - 1];
	}

	public ListNode swapPairs(ListNode head) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (head == null)
			return null;

		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode ppre = dummy;
		ListNode pre = head;
		ListNode cur = head.next;
		while (cur != null) {
			ListNode pnext = cur.next;
			cur.next = pre;
			ppre.next = cur;
			pre.next = pnext;
			cur = pnext;
			if (pnext != null) {
				ppre = pre;
				pre = cur;
				cur = cur.next;
			}

		}
		return dummy.next;

	}

	public static int longestContinousSubArray(int[] arr) {
		if (arr.length < 4)
			return arr.length;
		HashSet<Integer> set = new HashSet<Integer>();
		int start = 0;
		int end = 0;
		int len = 1;
		for (int i = 0; i < arr.length; i++) {
			if (set.contains(arr[i])) {
				end++;
				len = Math.max(len, end - start);
			} else if (set.size() < 3) {
				set.add(arr[i]);
				end++;
				len = Math.max(len, end - start);
			} else {

				while (set.size() > 2) {
					set.remove(arr[start]);
					start++;
				}
				end++;
				len = Math.max(len, end - start);
				set.add(arr[i]);
			}
		}
		return len;
	}

	public boolean isPalindrome(String s) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (s.length() == 0)
			return true;
		s = s.toLowerCase();
		int len = s.length();
		int i = 0;
		int j = len - 1;
		while (i < j) {
			if (Character.isLetterOrDigit(s.charAt(i))
					&& Character.isLetterOrDigit(s.charAt(j))
					&& s.charAt(i) == s.charAt(j)) {
				i++;
				j--;
			} else if (!Character.isLetterOrDigit(s.charAt(i)))
				i++;
			else if (!Character.isLetterOrDigit(s.charAt(j)))
				j--;
			else
				return false;
		}
		return true;

	}

	public boolean isPalindromeRecur(String s) {
		if (s.length() == 0 || s.length() == 1 || s == null)
			return true;
		s = s.toLowerCase();
		s = s.trim();
		int len = s.length();
		if (s.charAt(0) != s.charAt(len - 1))
			return false;
		return isPalindromeRecur(s.substring(1, len - 1).trim());
	}

	public boolean isPalindrome(int x) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (x < 0)
			return false;

		int base = 1;
		int t = x;
		while (t / 10 > 0) {
			base *= 10;
			t = t / 10;
		}

		while (x > 0) {
			int first = x / base;
			int last = x % 10;
			if (first != last)
				return false;
			else {
				x = x - first * base;
				x /= 10;
				base /= 100;
			}
		}
		return true;
	}

	public ArrayList<Integer> spiralOrder(int[][] matrix) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<Integer> res = new ArrayList<Integer>();
		if (matrix.length == 0)
			return res;
		int m = matrix.length;
		int n = matrix[0].length;
		int upbound = 0;
		int bottombound = m - 1;
		int leftbound = 0;
		int rightbound = n - 1;
		while (upbound < bottombound && leftbound < rightbound) {
			for (int i = leftbound; i <= rightbound; i++)
				res.add(matrix[upbound][i]);
			upbound++;
			for (int i = upbound; i <= bottombound; i++)
				res.add(matrix[i][rightbound]);
			rightbound--;

			for (int i = rightbound; i >= leftbound; i--)
				res.add(matrix[bottombound][i]);
			bottombound--;

			for (int i = bottombound; i >= upbound; i--)
				res.add(matrix[i][leftbound]);
			leftbound++;
		}

		if (upbound < bottombound && leftbound == rightbound) {
			for (int i = upbound; i <= bottombound; i++)
				res.add(matrix[i][leftbound]);
		}
		if (upbound == bottombound && leftbound < rightbound) {
			for (int i = leftbound; i <= rightbound; i++)
				res.add(matrix[upbound][i]);
		}

		if (leftbound == rightbound && upbound == bottombound)
			res.add(matrix[upbound][leftbound]);

		return res;

	}

	public static int maxSubArray(int[] arr) {
		if (arr.length == 0)
			return 0;
		int sum = 0;
		int max = Integer.MIN_VALUE;

		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
			if (sum > max)
				max = sum;
			else if (sum < 0)
				sum = 0;
		}
		if (max == 0) {
			max = arr[0];
			for (int i = 1; i < arr.length; i++) {
				if (arr[i] > max)
					max = arr[i];
			}
		}
		return max;
	}

	public ArrayList<ArrayList<Integer>> combine(int n, int k) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		if (k > n)
			return res;
		ArrayList<Integer> sol = new ArrayList<Integer>();
		combine(n, k, sol, res, 1, 0);
		return res;
	}

	public void combine(int n, int maxdepth, ArrayList<Integer> sol,
			ArrayList<ArrayList<Integer>> res, int curpos, int depth) {
		if (depth == maxdepth) {
			ArrayList<Integer> out = new ArrayList<Integer>(sol);
			res.add(out);
			return;
		} else {
			for (int i = curpos; i <= n; i++) {
				sol.add(i);
				combine(n, maxdepth, sol, res, i + 1, depth + 1);
				sol.remove(sol.size() - 1);
			}
		}
	}

	public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int m = triangle.size();
		int n = triangle.get(m - 1).size();
		int[][] dp = new int[m][n];
		dp[0][0] = triangle.get(0).get(0);

		for (int i = 1; i < m; i++)
			dp[i][0] = dp[i - 1][0] + triangle.get(i).get(0);

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < triangle.get(i).size(); j++) {
				if (j == triangle.get(i).size() - 1)
					dp[i][j] = dp[i - 1][j - 1] + triangle.get(i).get(j);
				else
					dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1])
							+ triangle.get(i).get(j);
			}
		}

		int min = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			if (dp[m - 1][i] < min)
				min = dp[m - 1][i];
		}

		return min;

	}

	public void connect(TreeLinkNode root) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (root == null)
			return;
		if (root.left != null)
			root.left.next = root.right;
		if (root.right != null)
			if (root.next != null)
				root.right.next = root.next.left;
			else
				root.right.next = null;
		connect(root.left);
		connect(root.right);
	}

	public void connect2(TreeLinkNode root) {
		if (root == null)
			return;
		Queue<TreeLinkNode> que = new LinkedList<TreeLinkNode>();
		int levelnum = 0;
		int nextlevel = 0;
		que.add(root);
		levelnum++;
		while (!que.isEmpty()) {
			TreeLinkNode top = que.remove();
			levelnum--;
			if (top.left != null) {
				que.add(top.left);
				nextlevel++;
			}
			if (top.right != null) {
				que.add(top.right);
				nextlevel++;
			}
			if (levelnum == 0) {
				top.next = null;
				levelnum = nextlevel;
				nextlevel = 0;
			} else {
				top.next = que.peek();
			}
		}

	}

	public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		if (root == null)
			return res;
		ArrayList<Integer> sol = new ArrayList<Integer>();

		pathSum(root, sum, sol, res, 0);
		return res;

	}

	public void pathSum(TreeNode root, int sum, ArrayList<Integer> sol,
			ArrayList<ArrayList<Integer>> res, int cursum) {
		if (root == null)
			return;
		cursum += root.val;
		sol.add(root.val);
		if (cursum == sum && root.left == null && root.right == null) {
			ArrayList<Integer> out = new ArrayList<Integer>(sol);
			res.add(out);
			// return;
		}

		pathSum(root.left, sum, sol, res, cursum);
		pathSum(root.right, sum, sol, res, cursum);
		cursum -= sol.get(sol.size() - 1);
		sol.remove(sol.size() - 1);

	}

	public int minDepth(TreeNode root) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (root == null)
			return 0;
		int left = minDepth(root.left);
		int right = minDepth(root.right);
		if (left == 0)
			return right + 1;
		else if (right == 0)
			return left + 1;
		return left > right ? right + 1 : left + 1;
	}

	public boolean isValidBST(TreeNode root) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (root == null)
			return true;
		return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	public boolean isBST(TreeNode root, int leftmost, int rightmost) {
		if (root == null)
			return true;
		if (root.val > leftmost && root.val < rightmost)
			return isBST(root.left, leftmost, root.val)
					&& isBST(root.right, root.val, rightmost);
		else
			return false;
	}

	public int lengthOfLastWord(String s) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (s == null || s.length() == 0)
			return 0;
		s = s.trim();

		int i = s.length() - 1;
		int count = 0;
		while (i >= 0 && s.charAt(i) != ' ') {
			count++;
			i--;

		}
		return count;
	}

	public double pow(double x, int n) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (n == 0)
			return 1;
		boolean neg = false;
		if (n < 0) {
			neg = true;
			n = -n;
		}
		double res = pow(x, n / 2);
		if (n % 2 == 0)
			res = res * res;
		else
			res = res * res * x;

		if (neg)
			res = 1 / res;

		return res;
	}

	public boolean isValid(String s) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (s == null || s.length() == 0)
			return true;
		Stack<Character> stk = new Stack<Character>();

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '(' || c == '[' || c == '{')
				stk.push(c);
			else {
				if (stk.isEmpty())
					return false;
				else if ((c == ')' && stk.peek() == '('
						|| (c == ']' && stk.peek() == '[') || (c == '}' && stk
						.peek() == '{')))
					stk.pop();
				else
					return false;
			}
		}
		return stk.isEmpty();
	}

	public String longestCommonPrefix(String[] strs) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (strs.length == 0)
			return "";
		String s = strs[0];
		for (int i = 1; i < strs.length; i++) {
			if (strs[i].length() < s.length())
				s = strs[i];
		}
		// String prefix="";
		for (int i = 0; i < s.length(); i++) {
			// char c=s.charAt(i);
			for (int j = 0; j < strs.length; j++) {
				if (s.charAt(i) != strs[j].charAt(i))
					return s.substring(0, i);
				// else
				// prefix+=c;
			}
		}
		return s;
	}

	public int atoi(String str) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (str.length() == 0)
			return 0;
		boolean neg = false;
		boolean overflow = false;
		int res = 0;
		str = str.trim();
		int i = 0;
		if (str.charAt(i) == '-') {
			neg = true;
			i++;
		} else if (str.charAt(i) == '+')
			i++;

		while (i < str.length()) {
			char c = str.charAt(i);
			if (c >= '0' && c <= '9') {
				int digit = c - '0';
				if ((Integer.MAX_VALUE - digit) / 10 >= res)
					res = res * 10 + digit;
				else {
					overflow = true;
					break;
				}
			} else
				break;
			i++;
		}
		if (neg) {
			if (overflow)
				return Integer.MIN_VALUE;
			else
				return -res;
		} else {
			if (overflow)
				return Integer.MAX_VALUE;
			else
				return res;
		}
	}

	public ListNode partition(ListNode head, int x) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (head == null)
			return null;
		ListNode small = new ListNode(0);
		ListNode smallHead = small;
		ListNode big = new ListNode(1);
		ListNode bigHead = big;
		ListNode cur = head;
		while (cur != null) {
			if (cur.val < x) {
				small.next = cur;
				small = small.next;
			} else {
				big.next = cur;
				big = big.next;
			}
			cur = cur.next;
		}
		small.next = bigHead.next;
		big.next = null;
		return smallHead.next;
	}

	public int sqrt(int x) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (x == 0)
			return 0;
		if (x == 1)
			return 1;
		double res = x;
		while (Math.abs(res * res - x) > 0.001) {
			res = res - (res * res - x) / (2 * res);
		}
		return (int) res;
	}

	public ArrayList<ArrayList<Integer>> generate(int numRows) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		if (numRows <= 0)
			return res;

		int[][] dp = new int[numRows][numRows];

		for (int i = 0; i < numRows; i++) {
			dp[i][0] = 1;
		}

		for (int i = 1; i < numRows; i++) {
			for (int j = 1; j <= i; j++) {
				if (j == i)
					dp[i][j] = 1;
				else
					dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];
			}
		}

		for (int i = 0; i < numRows; i++) {
			ArrayList<Integer> sol = new ArrayList<Integer>();
			for (int j = 0; j <= i; j++) {
				sol.add(dp[i][j]);
			}
			res.add(sol);
		}
		return res;

	}

	public ArrayList<Integer> getRow(int rowIndex) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<Integer> res = new ArrayList<Integer>();
		if (rowIndex < 0)
			return res;
		int[] dp = new int[rowIndex + 1];
		dp[0] = 1;
		dp[rowIndex] = 1;

		for (int i = 1; i <= rowIndex; i++) {
			for (int j = i; j > 0; j--) {
				if (j == i)
					dp[j] = 1;
				else
					dp[j] = dp[j - 1] + dp[j];
			}
		}
		for (int i = 0; i < dp.length; i++)
			res.add(dp[i]);
		return res;

	}

	public boolean exist(char[][] board, String word) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int m = board.length;
		int n = board[0].length;
		if (m == 0)
			return false;
		boolean[][] canUse = new boolean[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++)
				canUse[i][j] = true;
		}

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (board[i][j] == word.charAt(0)) {
					if (exist(board, word, i, j, canUse, 0))
						return true;
				}

			}
		}
		return false;
	}

	public boolean exist(char[][] board, String word, int i, int j,
			boolean[][] canUse, int curPos) {
		if (curPos == word.length())
			return true;

		if (i >= 0 && i < board.length && j >= 0 && j < board[0].length
				&& board[i][j] == word.charAt(curPos) && canUse[i][j]) {
			canUse[i][j] = false;
			boolean res = exist(board, word, i - 1, j, canUse, curPos + 1)
					|| exist(board, word, i + 1, j, canUse, curPos + 1)
					|| exist(board, word, i, j - 1, canUse, curPos + 1)
					|| exist(board, word, i, j + 1, canUse, curPos + 1);
			if (res)
				return true;
			else
				canUse[i][j] = true;

		}
		return false;

	}

	public ArrayList<Integer> findSubstring(String S, String[] L) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<Integer> res = new ArrayList<Integer>();
		int num = L.length;
		int len = L[0].length();
		if (S.length() < num * len)
			return res;

		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 0; i < num; i++) {
			if (!map.containsKey(L[i]))
				map.put(L[i], 1);
			else
				map.put(L[i], map.get(L[i]) + 1);
		}

		HashMap<String, Integer> found = new HashMap<String, Integer>();

		for (int i = 0; i < S.length() - num * len + 1; i++) {
			found.clear();
			int j = 0;
			for (j = 0; j < num; j++) {
				String str = S.substring(i + j * len, i + j * len + len);
				if (!map.containsKey(str))
					break;
				if (!found.containsKey(str))
					found.put(str, 1);
				else
					found.put(str, found.get(str) + 1);
				if (found.get(str) > map.get(str))
					break;
			}
			if (j == num)
				res.add(i);

		}
		return res;

	}

	public int removeDuplicates2(int[] A) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (A.length < 3)
			return A.length;

		int i = 0;
		int j = 1;
		int count = 1;
		while (j < A.length) {
			if (A[i] != A[j]) {
				i++;
				A[i] = A[j];
				count = 1;
			} else {
				count++;
				if (count <= 2) {
					i++;
					A[i] = A[j];
				}
			}
			j++;
		}
		return i + 1;
	}

	public void flatten(TreeNode root) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (root == null)
			return;
		TreeNode left = root.left;
		TreeNode right = root.right;
		if (left != null) {
			root.right = left;
			root.left = null;

			TreeNode rightmost = left;
			while (rightmost.right != null) {
				rightmost = rightmost.right;
			}
			rightmost.right = right;
		}
		flatten(root.right);

	}

	public void flatten2(TreeNode root) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (root == null)
			return;
		Stack<TreeNode> stk = new Stack<TreeNode>();
		stk.push(root);
		TreeNode cur = root;
		while (!stk.isEmpty()) {
			TreeNode top = stk.pop();
			if (top.right != null)
				stk.push(top.right);
			if (top.left != null)
				stk.push(top.left);
			if (top != root) {
				cur.left = null;
				cur.right = top;
				cur = cur.right;
			}

		}
	}

	public int maxProfit3(int[] prices) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (prices.length < 2)
			return 0;
		int n = prices.length;
		int[] profit1 = new int[n];
		profit1[0] = 0;
		int max1 = 0;
		int lowest = prices[0];

		for (int i = 1; i < n; i++) {
			if (lowest > prices[i])
				lowest = prices[i];
			if (prices[i] - lowest > max1) {
				max1 = prices[i] - lowest;
			}
			profit1[i] = max1;

		}

		int[] profit2 = new int[n];
		profit2[n - 1] = 0;
		int max2 = 0;
		int highest = prices[n - 1];

		for (int i = n - 2; i >= 0; i--) {
			if (prices[i] > highest)
				highest = prices[i];
			if (highest - prices[i] > max2)
				max2 = highest - prices[i];

			profit2[i] = max2;
		}
		int maxprofit = 0;

		for (int i = 0; i < n; i++) {
			if (profit1[i] + profit2[i] > maxprofit)
				maxprofit = profit1[i] + profit2[i];
		}
		return maxprofit;
	}

	public int minDistance(String word1, String word2) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int l1 = word1.length();
		int l2 = word2.length();
		int[][] dp = new int[l1 + 1][l2 + 1];
		dp[0][0] = 0;
		for (int i = 1; i <= l1; i++) {
			dp[i][0] = i;
		}
		for (int i = 1; i <= l2; i++)
			dp[0][i] = i;

		for (int i = 1; i <= l1; i++) {
			for (int j = 1; j <= l2; j++) {
				if (word1.charAt(i - 1) == word2.charAt(j - 1))
					dp[i][j] = dp[i - 1][j - 1];
				else
					dp[i][j] = Math.min(dp[i - 1][j - 1],
							Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
			}
		}

		return dp[l1][l2];
	}

	public int[][] generateMatrix(int n) {
		// Start typing your Java solution below
		// DO NOT write main() function
		// if(n==0)
		// return null;
		int[][] matrix = new int[n][n];
		int upbound = 0;
		int bottombound = n - 1;
		int leftbound = 0;
		int rightbound = n - 1;
		int num = 1;
		while (upbound <= bottombound && leftbound <= rightbound) {
			for (int i = leftbound; i <= rightbound; i++) {
				matrix[upbound][i] = num++;
			}
			upbound++;
			for (int i = upbound; i <= bottombound; i++) {
				matrix[i][rightbound] = num++;
			}
			rightbound--;

			for (int i = rightbound; i >= leftbound; i--)
				matrix[bottombound][i] = num++;
			bottombound--;
			for (int i = bottombound; i >= upbound; i--)
				matrix[i][leftbound] = num++;
			leftbound++;

		}
		// if(leftbound==rightbound&&upbound==bottombound)
		// matrix[upbound][leftbound]=num;
		return matrix;
	}

	public String longestPalindrome(String s) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (s.length() <= 1)
			return s;

		int beg = 1;
		int beg1 = 0;
		int end1 = 0;
		int beg2 = 0;
		int end2 = 0;

		int longest = 0;

		while (beg < s.length()) {

			// case 1: abba
			int i = beg - 1;
			int j = beg;
			while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
				if (j - i + 1 > longest) {
					beg1 = i;
					end1 = j;
					longest = j - i + 1;
				}
				i--;
				j++;
			}
			// case 2 aba
			i = beg - 1;
			j = beg + 1;
			while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
				if (j - i + 1 > longest) {
					beg2 = i;
					end2 = j;
					longest = j - i + 1;
				}
				i--;
				j++;
			}
			beg++;
		}

		if (end2 - beg2 > end1 - beg1)
			return s.substring(beg2, end2 + 1);
		else
			return s.substring(beg1, end1 + 1);
	}

	public int lengthOfLongestSubstring(String s) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (s.length() < 2)
			return s.length();

		int start = 0;
		int longest = 1;
		int length = 0;
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (!map.containsKey(c)) {
				map.put(c, i);
				length++;
				if (length > longest)
					longest = length;
			} else {
				int dupIdx = map.get(c);

				for (int j = dupIdx; j >= start; j--) {
					map.remove(s.charAt(j));
					length--;
				}
				map.put(c, i);
				length++;
				start = dupIdx + 1;
			}
		}
		return longest;
	}

	public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		if (num.length == 0)
			return res;
		ArrayList<Integer> sol = new ArrayList<Integer>();
		boolean[] used = new boolean[num.length];
		Arrays.sort(num);
		combinationSum2(num, target, 0, sol, res, used, 0);
		return res;
	}

	public void combinationSum2(int[] num, int target, int curSum,
			ArrayList<Integer> sol, ArrayList<ArrayList<Integer>> res,
			boolean[] used, int curPos) {
		if (curPos == num.length || curSum > target)
			return;
		if (target == curSum) {
			ArrayList<Integer> out = new ArrayList<Integer>(sol);
			res.add(out);
		}

		for (int i = curPos; i < num.length; i++) {
			if (!used[i]) {
				if (i != 0 && num[i] == num[i - 1] && !used[i - 1])
					continue;
				curSum += num[i];
				sol.add(num[i]);
				used[i] = true;
				combinationSum2(num, target, curSum, sol, res, used, i);
				curSum -= num[i];
				sol.remove(sol.size() - 1);
				used[i] = false;
			}

		}

	}

	public int numDistinct(String S, String T) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (S.length() < T.length())
			return 0;
		int m = S.length();
		int n = T.length();
		int[][] dp = new int[m + 1][n + 1];

		dp[0][0] = 1;
		for (int i = 1; i <= m; i++)
			dp[i][0] = 1;
		for (int i = 1; i <= n; i++)
			dp[0][i] = 0;

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (S.charAt(i - 1) == T.charAt(j - 1))
					dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
				else
					dp[i][j] = dp[i - 1][j];
			}
		}

		return dp[m][n];

	}

	public int numDistinct2(String S, String T) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int m = S.length();
		int n = T.length();
		int[] dp = new int[n + 1];

		dp[0] = 1;

		for (int i = 1; i <= m; i++) {
			for (int j = n; j > 0; j--) {
				if (S.charAt(i - 1) == T.charAt(j - 1))
					dp[j] = dp[j - 1] + dp[j];

			}
		}

		return dp[n];
	}

	public String strStr(String haystack, String needle) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (needle.length() == 0)
			return haystack;
		if (haystack.length() < needle.length())
			return null;
		int len = needle.length();
		for (int i = 0; i < haystack.length() - len + 1; i++) {
			String s = haystack.substring(i, i + len);
			if (s.equals(needle))
				return haystack.substring(i);
		}
		return null;
	}

	public int firstMissingPositive(int[] A) {
		// Start typing your Java solution below
		// DO NOT write main() function
		for (int i = 0; i < A.length; i++) {
			while (i + 1 != A[i]) {
				if (A[i] <= 0 || A[i] > A.length || A[i] == A[A[i] - 1])
					break;
				int temp = A[i];
				A[i] = A[A[i] - 1];
				A[temp - 1] = temp;
			}
		}

		for (int i = 0; i < A.length; i++) {
			if (A[i] != i + 1)
				return i + 1;
		}
		return A.length + 1;
	}

	public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		if (root == null)
			return res;
		Stack<TreeNode> stk1 = new Stack<TreeNode>();
		Stack<TreeNode> stk2 = new Stack<TreeNode>();

		stk1.push(root);

		boolean left2right = true;
		ArrayList<Integer> sol = new ArrayList<Integer>();
		while (!stk1.isEmpty()) {
			TreeNode top = stk1.pop();

			sol.add(top.val);
			if (left2right) {
				if (top.left != null)
					stk2.push(top.left);
				if (top.right != null)
					stk2.push(top.right);
			} else {
				if (top.right != null)
					stk2.push(top.right);

				if (top.left != null)
					stk2.push(top.left);
			}
			if (stk1.isEmpty()) {
				res.add(sol);
				sol = new ArrayList<Integer>();
				left2right = !left2right;
				stk1 = stk2;
				stk2 = new Stack<TreeNode>();
			}
		}
		return res;
	}

	public int trap(int[] A) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (A.length < 2)
			return 0;
		int n = A.length;
		int[] left = new int[n];
		int leftmost = A[0];
		for (int i = 0; i < n; i++) {
			left[i] = leftmost;
			if (A[i] > leftmost)
				leftmost = A[i];
		}

		int[] right = new int[n];
		int rightmost = A[n - 1];

		for (int i = n - 1; i >= 0; i--) {
			right[i] = rightmost;
			if (A[i] > rightmost)
				rightmost = A[i];
		}
		int ans = 0;
		for (int i = 0; i < n; i++) {
			if (Math.min(left[i], right[i]) > A[i])
				ans += Math.min(left[i], right[i]) - A[i];
		}

		return ans;

	}

	public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		if (num.length == 0)
			return res;
		ArrayList<Integer> sol = new ArrayList<Integer>();
		boolean[] used = new boolean[num.length];
		Arrays.sort(num);
		subsetsWithDup(0, num.length, num, used, sol, res, 0);
		return res;

	}

	public void subsetsWithDup(int depth, int maxdepth, int[] num,
			boolean[] used, ArrayList<Integer> sol,
			ArrayList<ArrayList<Integer>> res, int curPos) {
		res.add(sol);
		if (depth == maxdepth) {
			return;
		}

		for (int i = curPos; i < num.length; i++) {
			if (!used[i]) {
				if (i != 0 && num[i] == num[i - 1] && !used[i - 1])
					continue;
				ArrayList<Integer> lst = new ArrayList<Integer>(sol);
				lst.add(num[i]);
				used[i] = true;
				subsetsWithDup(depth + 1, maxdepth, num, used, lst, res, i);
				used[i] = false;
			}

		}
	}

	public String minWindow(String S, String T) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (S.length() == 0)
			return "";

		int[] needfind = new int[256];
		for (int i = 0; i < T.length(); i++) {
			needfind[T.charAt(i)]++;
		}

		int[] hasfound = new int[256];
		int windowStart = 0;
		int windowEnd = 0;
		int count = T.length();

		int start = 0;
		// int end=0;
		int minLength = S.length() + 1;

		for (int i = 0; i < S.length(); i++) {
			char c = S.charAt(i);
			if (needfind[c] == 0)
				continue;
			hasfound[c]++;
			if (hasfound[c] <= needfind[c])
				count--;

			if (count == 0) {
				while (needfind[S.charAt(start)] == 0
						|| hasfound[S.charAt(start)] > needfind[S.charAt(start)]) {
					if (hasfound[S.charAt(start)] > needfind[S.charAt(start)])
						hasfound[S.charAt(start)]--;
					start++;
				}

				if (i - start + 1 < minLength) {
					minLength = i - start + 1;
					windowStart = start;
					windowEnd = i;
				}
			}
		}
		if (count == 0)
			return S.substring(windowStart, windowEnd + 1);
		else
			return "";
	}

	public String multiply(String num1, String num2) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int l1 = num1.length();
		int l2 = num2.length();
		int[] res = new int[l1 + l2];

		for (int i = 0; i < l1; i++) {
			int carry = 0;
			int d1 = num1.charAt(l1 - i - 1) - '0';
			for (int j = 0; j < l2; j++) {
				int d2 = num2.charAt(l2 - j - 1) - '0';
				int times = d1 * d2 + carry + res[i + j];
				carry = times / 10;
				times = times % 10;
				res[i + j] = times;
			}
			res[i + l2] = carry;
		}

		String ans = "";
		int i = l1 + l2 - 1;
		while (i > 0 && res[i] == 0)
			i--;

		while (i >= 0) {
			ans = ans + res[i];
			i--;
		}

		return ans;

	}

	public ArrayList<ArrayList<Integer>> permute(int[] num) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		if (num.length == 0)
			return res;
		ArrayList<Integer> sol = new ArrayList<Integer>();
		boolean[] used = new boolean[num.length];
		permute(0, num.length, num, used, sol, res);
		return res;
	}

	public void permute(int curPos, int maxDepth, int[] num, boolean[] used,
			ArrayList<Integer> sol, ArrayList<ArrayList<Integer>> res) {
		if (curPos == maxDepth) {
			ArrayList<Integer> out = new ArrayList<Integer>(sol);
			res.add(out);
			return;
		} else {
			for (int i = 0; i < num.length; i++) {
				if (!used[i]) {
					sol.add(num[i]);
					used[i] = true;
					permute(curPos + 1, maxDepth, num, used, sol, res);
					used[i] = false;
					sol.remove(sol.size() - 1);
				}
			}
		}
	}

	public static int getLevelDiff(TreeNode root) {
		if (root == null)
			return 0;
		return root.val - getLevelDiff(root.left) - getLevelDiff(root.right);
	}

	public static void merge(ListNode p, ListNode q) {
		if (p == null || q == null)
			return;

		ListNode pcur = p;
		ListNode qcur = q;

		while (pcur != null && qcur != null) {
			ListNode pnext = pcur.next;
			ListNode qnext = qcur.next;

			pcur.next = qcur;
			qcur.next = pnext;

			pcur = pnext;
			qcur = qnext;
		}
		q = qcur;
	}

	public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		if (num.length == 0)
			return res;
		ArrayList<Integer> sol = new ArrayList<Integer>();
		boolean[] used = new boolean[num.length];
		Arrays.sort(num);
		permuteUnique(num, used, sol, res, 0);
		return res;
	}

	public void permuteUnique(int[] num, boolean[] used,
			ArrayList<Integer> sol, ArrayList<ArrayList<Integer>> res,
			int curPos) {
		if (curPos == num.length) {
			ArrayList<Integer> out = new ArrayList<Integer>(sol);
			res.add(out);
			return;
		} else {
			for (int i = 0; i < num.length; i++) {
				if (!used[i]) {
					if (i != 0 && num[i] == num[i - 1] && !used[i - 1])
						continue;
					used[i] = true;
					sol.add(num[i]);
					permuteUnique(num, used, sol, res, curPos + 1);
					used[i] = false;
					sol.remove(sol.size() - 1);
				}

			}
		}
	}

	public void nextPermutation(int[] num) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (num.length < 2)
			return;
		int index = -1;
		for (int i = 0; i < num.length - 1; i++) {
			if (num[i] < num[i + 1])
				index = i;
		}
		if (index == -1) {
			Arrays.sort(num);
			return;
		}

		int idx = index + 1;
		for (int i = index; i < num.length; i++) {
			if (num[i] > num[index])
				idx = i;
		}
		int t = num[index];
		num[index] = num[idx];
		num[idx] = t;

		int beg = index + 1;
		int end = num.length - 1;
		while (beg < end) {
			int temp = num[beg];
			num[beg] = num[end];
			num[end] = temp;
			beg++;
			end--;
		}
	}

	public String getPermutation(int n, int k) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int[] num = new int[n];
		for (int i = 0; i < n; i++) {
			num[i] = i + 1;
		}

		for (int i = 1; i < k; i++)
			nextpermute(num);

		String ans = "";
		for (int i = 0; i < n; i++)
			ans += num[i];
		return ans;

	}

	public void nextpermute(int[] num) {
		if (num.length < 2)
			return;

		int index = -1;
		for (int i = 0; i < num.length - 1; i++) {
			if (num[i] < num[i + 1])
				index = i;
		}
		if (index == -1)
			return;

		int index2 = index + 1;
		for (int i = index + 1; i < num.length; i++) {
			if (num[i] > num[index])
				index2 = i;
		}

		int t = num[index];
		num[index] = num[index2];
		num[index2] = t;

		int beg = index + 1;
		int end = num.length - 1;

		while (beg < end) {
			int temp = num[beg];
			num[beg] = num[end];
			num[end] = temp;
			beg++;
			end--;
		}
	}

	public static String countAndSay(int n) {
		// Start typing your Java solution below
		// DO NOT write main() function
		String num = "1";

		for (int i = 1; i < n; i++) {
			String res = "";
			char c = num.charAt(0);
			int count = 1;
			for (int j = 1; j < num.length(); j++) {
				if (num.charAt(j) == c) {
					count++;
				} else {
					res = res + count + c;
					c = num.charAt(j);
					count = 1;
				}

			}
			res = res + count + c;
			num = res;
		}
		return num;
	}

	public int maxArea(int[] height) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int left = 0;
		int right = height.length - 1;
		int maxarea = 0;
		while (left < right) {
			int area = Math.min(height[left], height[right]) * (right - left);
			if (area > maxarea)
				maxarea = area;
			if (height[left] < height[right])
				left++;
			else
				right--;
		}
		return maxarea;
	}

	public String simplifyPath(String path) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (path.length() == 0)
			return "/";
		Stack<String> stk = new Stack<String>();
		String[] strs = path.split("/");
		for (String s : strs) {
			if (s.equals(""))
				continue;
			else if (s.equals("."))
				continue;
			else if (s.equals("..")) {
				if (!stk.isEmpty())
					stk.pop();
			} else
				stk.push(s);
		}
		if (stk.isEmpty())
			return "/";
		String res = "";
		while (!stk.isEmpty()) {
			res = "/" + stk.pop() + res;
		}
		return res;
	}

	public int[] searchRange(int[] A, int target) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int[] res = { -1, -1 };
		if (A.length == 0)
			return res;
		int beg = 0;
		int end = A.length - 1;
		int index = -1;
		while (beg <= end) {
			int mid = (beg + end) / 2;
			if (A[mid] == target) {
				index = mid;
				break;
			} else if (A[mid] > target)
				end = mid - 1;
			else
				beg = mid + 1;
		}

		int beg1 = 0;
		int end1 = index - 1;
		while (beg1 <= end1) {
			int mid = (beg1 + end1) / 2;
			if (A[mid] == target)
				end1 = mid - 1;
			else
				beg1 = mid + 1;
		}
		res[0] = end1 + 1;

		int beg2 = index + 1;
		int end2 = A.length - 1;

		while (beg2 <= end2) {
			int mid = (beg2 + end2) / 2;
			if (A[mid] == target)
				beg2 = mid + 1;
			else
				end2 = mid - 1;
		}
		res[1] = beg2 - 1;

		return res;

	}

	public boolean canJump(int[] A) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (A.length == 0)
			return true;
		boolean[] dp = new boolean[A.length];
		dp[A.length - 1] = true;

		int step = 1;
		for (int i = A.length - 2; i >= 0; i--) {
			if (A[i] >= step) {
				dp[i] = true;
				step = 1;
			} else
				step++;
		}

		return dp[0];
	}

	public int jump(int[] A) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (A.length < 2)
			return 0;

		int max = A[0];
		int min = 1;
		int step = 0;
		while (max < A.length - 1) {
			int m = max;
			for (int i = min; i <= max; i++) {
				if (A[i] + i > m)
					m = A[i] + i;
			}
			min = max + 1;
			max = m;
			step++;
		}
		return step + 1;
	}

	public int longestValidParentheses(String s) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (s.length() < 2)
			return 0;
		int[] dp = new int[s.length()];

		int max = 0;
		for (int i = s.length() - 2; i >= 0; i--) {
			if (s.charAt(i) == '(') {
				int j = i + 1 + dp[i + 1];
				if (j < s.length() && s.charAt(j) == ')') {
					dp[i] = dp[i + 1] + 2;
					if (j + 1 < s.length())
						dp[i] += dp[j + 1];
				}
			}
			max = max > dp[i] ? max : dp[i];
		}
		return max;
	}

	public int romanToInt(String s) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int res = 0;
		for (int i = 0; i < s.length(); i++) {
			if (i > 0 && c2n(s.charAt(i)) > c2n(s.charAt(i - 1)))
				res += (c2n(s.charAt(i)) - 2 * c2n(s.charAt(i - 1)));
			else
				res += c2n(s.charAt(i));
		}
		return res;
	}

	public int c2n(char c) {
		switch (c) {
		case 'I':
			return 1;
		case 'V':
			return 5;
		case 'X':
			return 10;
		case 'L':
			return 50;

		case 'C':
			return 100;

		case 'D':
			return 500;

		case 'M':
			return 1000;

		}
		return 0;
	}

	public int romanToInt2(String s) {
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);

		int res = 0;

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			res += sign(s, i, map) * map.get(c);
		}
		return res;
	}

	public int sign(String s, int i, HashMap<Character, Integer> map) {
		if (i == s.length() - 1)
			return 1;
		else if (map.get(s.charAt(i)) < map.get(s.charAt(i + 1)))
			return -1;
		else
			return 1;
	}

	public String intToRoman(int num) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (num <= 0 || num > 3999)
			return null;

		String res = "";
		String[] str = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX",
				"V", "IV", "I" };
		int[] number = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };

		for (int i = 0; i < str.length; i++) {
			while (num >= number[i]) {
				num -= number[i];
				res += str[i];
			}

		}
		return res;
	}

	public int numTrees(int n) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (n <= 1)
			return 1;

		int total = 0;
		for (int i = 1; i <= n; i++)
			total += numTrees(i - 1) * numTrees(n - i);
		return total;
	}

	public static void subArraySumsZero(int[] A) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int cursum = 0;
		for (int i = 0; i < A.length; i++) {
			cursum += A[i];
			if (cursum == 0) {
				// System.out.print ("yuan"+i);
				System.out.println("subset : { 0 - " + i + " }");
			} else if (map.containsKey(cursum)) {
				System.out.println("subset : { " + (map.get(cursum) + 1)
						+ " - " + i + " }");
			} else
				map.put(cursum, i);
		}

	}

	public ArrayList<String> letterCombinations(String digits) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<String> res = new ArrayList<String>();
		String sol = "";
		letterCombinations(digits, sol, res, 0);
		return res;
	}

	public void letterCombinations(String digits, String sol,
			ArrayList<String> res, int curPos) {
		if (curPos == digits.length()) {
			res.add(sol);
			return;
		}
		int index = digits.charAt(curPos) - '0';
		String str = getString(index);

		for (int i = 0; i < str.length(); i++) {
			letterCombinations(digits, sol + str.charAt(i), res, curPos + 1);
		}
	}

	public String getString(int index) {
		String[] strs = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs",
				"tuv", "wxyz" };
		return strs[index];
	}

	public ListNode reverseKGroup(ListNode head, int k) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (head == null)
			return null;
		int len = 0;
		ListNode cur = head;
		while (cur != null) {
			len++;
			cur = cur.next;
		}

		cur = head;
		int count = 0;

		ListNode pre = null;
		if (len >= k) {
			while (cur != null && count < k) {
				ListNode pnext = cur.next;
				cur.next = pre;
				pre = cur;
				cur = pnext;
				count++;
			}

			if (head != null) {
				head.next = reverseKGroup(cur, k);
			}
		} else
			return head;
		return pre;
	}
//、、island
	public static int numOfShapes(int[][] A) {
		int m = A.length;
		int n = A[0].length;
		boolean[][] visited = new boolean[m][n];
		int count = 0;

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (!visited[i][j]) {
					// visited[i][j]=true;
					dfs(A, i, j, visited);
					count++;
				}
			}
		}
		return count;
	}

	public static void dfs(int[][] A, int i, int j, boolean[][] visited) {

		int[] rowDirec = { -1, -1, -1, 0, 0, 1, 1, 1 };
		int[] colDirec = { -1, 0, 1, -1, 1, -1, 0, 1 };
		visited[i][j] = true;

		for (int k = 0; k < 8; k++) {
			if (isOK(A, i, j, i + rowDirec[k], j + colDirec[k], visited)) {
				dfs(A, i + rowDirec[k], j + colDirec[k], visited);
			}

		}
	}

	public static boolean isOK(int[][] A, int row, int col, int newRow,
			int newCol, boolean[][] visited) {
		return (newRow >= 0 && newRow < A.length && newCol >= 0
				&& newCol < A[0].length && A[newRow][newCol] == A[row][col] && !visited[newRow][newCol]);
	}

	int max = Integer.MIN_VALUE;

	public int maxPathSum(TreeNode root) {
		// Start typing your Java solution below
		// DO NOT write main() function

		if (root == null)
			return 0;
		max = root.val;
		// int[] max={root.val};
		maxPathSumHelper(root);
		return max;
	}

	public int maxPathSumHelper(TreeNode root) {
		if (root == null)
			return 0;

		int l = maxPathSumHelper(root.left);
		int r = maxPathSumHelper(root.right);
		int sum = root.val;

		if (l > 0)
			sum += l;
		if (r > 0)
			sum += r;

		max = Math.max(sum, max);

		return Math.max(l, r) > 0 ? Math.max(l, r) + root.val : root.val;

	}

	public static void printLeftViewOfBT(TreeNode root) {
		if (root == null)
			return;
		Queue<TreeNode> q1 = new LinkedList<TreeNode>();
		Queue<TreeNode> q2 = new LinkedList<TreeNode>();

		q1.add(root);

		while (!q1.isEmpty()) {
			TreeNode top = q1.remove();
			if (top == root)
				System.out.print(top.val + " ");

			if (top.left != null) {
				q2.add(top.left);

			}
			if (top.right != null) {
				q2.add(top.right);
			}

			if (q1.isEmpty()) {
				if (!q2.isEmpty())
					System.out.print(q2.peek().val + " ");
				q1 = q2;
				q2 = new LinkedList<TreeNode>();
			}

		}
	}

	static int maxLevel = 0;

	public static void leftViewOfBT(TreeNode root) {
		int[] maxLevel = { 0 };
		leftViewUtil(root, 1, maxLevel);
	}

	public static void leftViewUtil(TreeNode root, int curLevel, int[] maxLevel) {
		if (root == null)
			return;
		if (curLevel > maxLevel[0]) {
			System.out.print(root.val + " ");
			maxLevel[0] = curLevel;
		}
		leftViewUtil(root.left, curLevel + 1, maxLevel);
		leftViewUtil(root.right, curLevel + 1, maxLevel);
	}

	// 从第一位到dp[i]这一位组成的String，有多少种解码组合
	// 如果dp[i]所对应的的单个字符可以解码，那么dp[i]就包括前dp[i-1]位所积累的组合数 dp[i] = dp[i-1]

	// 如果不仅dp[i]所对应的的单个字符可以解码，dp[i-1] － dp[i]，
	// 两个字符组成的也可以解码，那么不仅包括dp[i-1]积累的组合数，
	// 也包括dp[i-2]位积累的组合数 dp[i] = dp[i-1] + dp[i-2]
	public int numDecodings(String s) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (s.length() == 0)
			return 0;

		int[] dp = new int[s.length() + 1];
		dp[0] = 1;

		if (isValidCode(s.substring(0, 1)))
			dp[1] = 1;

		for (int i = 2; i <= s.length(); i++) {
			//
			if (isValidCode(s.substring(i - 1, i)))
				dp[i] = dp[i - 1];

			if (isValidCode(s.substring(i - 2, i)))
				dp[i] += dp[i - 2];
		}
		return dp[s.length()];
	}

	public boolean isValidCode(String s) {
		if (s.charAt(0) == '0')
			return false;
		int a = Integer.parseInt(s);
		if (a >= 1 && a <= 26)
			return true;
		else
			return false;
	}

	// number of ways to get sum 'x'
	// with 'n' dice and 'm' with m faces.
	int findDiceWays(int m, int n, int x) {
		int[][] table = new int[n + 1][x + 1];

		for (int i = 1; i <= x && i <= m; i++)
			table[1][i] = i;

		for (int i = 2; i <= n; i++) {
			for (int j = 1; j <= x; j++) {
				for (int k = 1; k <= m && k < j; k++) {
					table[i][j] += table[i - 1][j - k];
				}
			}
		}

		return table[n][x];
	}

	public static boolean DictionaryContains(String s) {
		String[] dic = { "mobile", "samsung", "sam", "sung", "man", "mango",
				"icecream", "and", "go", "i", "like", "ice", "cream" };

		for (int i = 0; i < dic.length; i++) {
			if (dic[i].equals(s))
				return true;
		}

		return false;
	}

	public static boolean wordBreak(String str) {
		boolean[] wb = new boolean[str.length() + 1];

		for (int i = 1; i <= str.length(); i++) {
			if (!wb[i] && DictionaryContains(str.substring(0, i)))
				wb[i] = true;

			if (wb[i]) {
				if (i == str.length())
					return true;

				for (int j = i + 1; j <= str.length(); j++) {
					if (!wb[j] && DictionaryContains(str.substring(i, j)))
						wb[j] = true;
					if (j == str.length() && wb[j])
						return true;
				}
			}
		}

		return false;
	}

	public static boolean wordBreakRecur(String str) {
		if (str.length() == 0)
			return true;
		for (int i = 1; i <= str.length(); i++) {
			if (DictionaryContains(str.substring(0, i))
					&& wordBreak(str.substring(i)))
				return true;
		}
		return false;
	}

	public void reverseLevelOrderI(TreeNode root) {
		int h = getHeight(root);
		int i;
		for (i = h; i >= 1; i--)
			// THE ONLY LINE DIFFERENT FROM NORMAL LEVEL ORDER
			printGivenLevel(root, i);
	}

	public void printGivenLevel(TreeNode root, int i) {
		if (root == null)
			return;
		if (i == 1)
			System.out.println(root.val);
		else if (i > 1) {
			printGivenLevel(root.left, i - 1);
			printGivenLevel(root.right, i - 1);
		}
	}

	// public int ladderLength(String start, String end, HashSet<String> dict){
	// HashSet<String> visited=new HashSet<String>();
	// Queue<String> que=new LinkedList<String>();
	// que.add(start);
	// que.add("|");
	// visited.add(start);
	//
	// int distance=1;
	//
	// while(!que.isEmpty()){
	// String s=que.poll();
	// if(s.equals(end))
	// return distance;
	// if(s.equals("|")){
	// que.add("|");
	// distance++;
	// }
	// else{
	// addTrans(s,que,dict);
	// }
	//
	// }
	// return 0;
	// }
	//
	// public void addTrans(String s, Queue<String> que, HashSet<String> dic){
	// char[] ch=s.toCharArray();
	//
	// for(int i=0;i<ch.length;i++){
	// char t=ch[i];
	// for(char c='a';c<='z';c++ ){
	// if(c!=ch[i]){
	// ch[i]=c;
	// String str=new String(ch);
	// if(dic.contains(str)&&!str.equals(s))
	// que.add(str);
	//
	// }
	//
	// ch[i]=t;
	// }
	// }
	// }

	public int ladderLength(String start, String end, HashSet<String> dict) {
		int curLevel = 1;
		int nextLevel = 0;

		Queue<String> que = new LinkedList<String>();
		int steps = 1;

		HashSet<String> visited = new HashSet<String>();

		que.add(start);

		while (!que.isEmpty()) {
			String st = que.remove();
			curLevel--;

			if (st.equals(end)) {
				return steps;
			} else {
				char[] ch = st.toCharArray();
				for (int i = 0; i < ch.length; i++) {
					char t = ch[i];
					for (char c = 'a'; c <= 'z'; c++) {
						if (c != t) {
							ch[i] = c;
							String str = new String(ch);
							if (dict.contains(str) && !visited.contains(str)) {
								visited.add(str);
								que.add(str);
								nextLevel++;
							}

						}
					}
					ch[i] = t;
				}
			}

			if (curLevel == 0) {
				steps++;
				curLevel = nextLevel;
				nextLevel = 0;
			}
		}

		return 0;

	}

	public ArrayList<TreeNode> generateTrees(int n) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<TreeNode> res = new ArrayList<TreeNode>();

		generateTreesUtil(1, n, res);
		return res;
	}

	public void generateTreesUtil(int beg, int end, ArrayList<TreeNode> res) {
		// ArrayList<TreeNode> res=new ArrayList<TreeNode>();
		if (beg > end) {
			res.add(null);
			// return res;
		} else {
			for (int i = beg; i <= end; i++) {
				ArrayList<TreeNode> left = new ArrayList<TreeNode>();
				generateTreesUtil(beg, i - 1, left);
				ArrayList<TreeNode> right = new ArrayList<TreeNode>();
				generateTreesUtil(i + 1, end, right);

				for (int j = 0; j < left.size(); j++) {
					for (int k = 0; k < right.size(); k++) {
						TreeNode root = new TreeNode(i);
						root.left = left.get(j);
						root.right = right.get(k);
						res.add(root);
					}
				}
			}
		}
		// return res;
	}

	public static int maxProd(int n) {
		if (n <= 0)
			return 0;

		int[] val = new int[n + 1];
		val[0] = 0;
		val[1] = 1;

		for (int i = 1; i <= n; i++) {
			int max = 0;

			for (int j = 1; j <= i / 2; j++) {
				max = Math.max(max, Math.max(j * (i - j), val[i - j] * j));
			}
			val[i] = max;
		}

		return val[n];
	}

	public void solve(char[][] board) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (board.length == 0 || board == null)
			return;
		int m = board.length;
		int n = board[0].length;

		for (int i = 0; i < n; i++) {
			dfs(0, i, board);
			dfs(m - 1, i, board);
		}

		for (int i = 1; i < m - 1; i++) {
			dfs(i, 0, board);
			dfs(i, n - 1, board);
		}

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (board[i][j] == 'O')
					board[i][j] = 'X';
				else if (board[i][j] == 'D')
					board[i][j] = 'O';
			}
		}
	}

	public void dfs(int x, int y, char[][] board) {
		int m = board.length;
		int n = board[0].length;
		if (x < 0 || x >= m || y < 0 || y >= n || board[x][y] != 'O')
			return;
		board[x][y] = 'D';
		dfs(x - 1, y, board);
		dfs(x + 1, y, board);
		dfs(x, y - 1, board);
		dfs(x, y + 1, board);
	}

	public static void modifyBST(TreeNode root) {
		if (root == null)
			return;
		int[] sum = new int[1];
		modifyBSTUtil(root, sum);
	}

	public static void modifyBSTUtil(TreeNode root, int[] sum) {
		if (root == null)
			return;
		modifyBSTUtil(root.right, sum);
		sum[0] += root.val;
		root.val = sum[0];

		modifyBSTUtil(root.left, sum);
	}

	public static void inorderTrav(TreeNode root) {
		if (root == null)
			return;
		inorderTrav(root.left);
		System.out.print(root.val + " ");
		inorderTrav(root.right);
	}

	public static void leftViewofBST(TreeNode root) {
		int[] maxLevel = { 0 };
		leftViewofBSTUtil(root, 1, maxLevel);
	}

	public static void leftViewofBSTUtil(TreeNode root, int curLevel, int[] max) {
		if (root == null)
			return;

		if (curLevel > max[0]) {
			System.out.print(root.val + " ");
			max[0] = curLevel;
		}

		leftViewofBSTUtil(root.left, curLevel + 1, max);
		leftViewofBSTUtil(root.right, curLevel + 1, max);

	}

	public static void printRightViewOfBT(TreeNode root) {
		if (root == null)
			return;
		Queue<TreeNode> q1 = new LinkedList<TreeNode>();
		Queue<TreeNode> q2 = new LinkedList<TreeNode>();

		q1.add(root);

		while (!q1.isEmpty()) {
			TreeNode top = q1.poll();
			if (top.left != null) {
				q2.add(top.left);
			}
			if (top.right != null)
				q2.add(top.right);

			if (q1.isEmpty()) {
				System.out.print(top.val + " ");
				q1 = q2;
				q2 = new LinkedList<TreeNode>();
			}
		}
	}

	public static int divide(int dividend, int divisor) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int res = 0;
		boolean sign = false;
		if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0))
			sign = true;

		long dvd = dividend;
		long dvs = divisor;
		if (dvd < 0)
			dvd = -dvd;
		if (dvs < 0)
			dvs = -dvs;
		// long dvd=dividend<0?-dividend:dividend;
		// long dvs=divisor<0?-divisor:divisor;

		while (dvd >= dvs) {
			long tmp = dvs;

			for (int i = 0; dvd >= tmp; i++, tmp <<= 1) {
				dvd -= tmp;
				res += 1 << i;
			}
		}
		return sign ? -res : res;
	}

	public boolean isMatch(String s, String p) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (s.length() == 0)
			return check(p);
		if (p.length() == 0)
			return false;

		char s1 = s.charAt(0);
		char p1 = p.charAt(0);

		char p2 = '0';
		if (p.length() > 1)
			p2 = p.charAt(1);

		if (p2 == '*') {
			if (s1 == p1 || p1 == '.')
				return isMatch(s.substring(1), p) || isMatch(s, p.substring(2));
			else
				return isMatch(s, p.substring(2));
		} else {
			if (s1 == p1 || p1 == '.')
				return isMatch(s.substring(1), p.substring(1));

			else
				return false;
		}
	}

	public boolean check(String p) {
		if (p.length() % 2 != 0)
			return false;

		for (int i = 1; i < p.length(); i += 2) {
			if (p.charAt(i) != '*')
				return false;
		}
		return true;
	}

	public ArrayList<ArrayList<String>> partition(String s) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
		if (s.length() == 0)
			return res;

		ArrayList<String> sol = new ArrayList<String>();
		patitionUtil(0, s.length(), s, sol, res);
		return res;
	}

	public void patitionUtil(int depth, int maxDepth, String s,
			ArrayList<String> sol, ArrayList<ArrayList<String>> res) {
		if (s.length() == 0)
			return;
		if (depth == maxDepth) {
			ArrayList<String> out = new ArrayList<String>(sol);
			res.add(out);
		} else {
			for (int i = depth; i < s.length(); i++) {
				if (isPalindrom(s.substring(depth, i + 1))) {
					sol.add(s.substring(depth, i + 1));
					patitionUtil(i + 1, maxDepth, s, sol, res);
					sol.remove(sol.size() - 1);
				}
			}
		}
	}

	public boolean isPalindrom(String s) {
		if (s.length() == 0)
			return true;
		int i = 0;
		int j = s.length() - 1;
		while (i < j) {
			if (s.charAt(i) != s.charAt(j))
				return false;
			i++;
			j--;
		}
		return true;
	}

	public ArrayList<String> restoreIpAddresses(String s) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<String> res = new ArrayList<String>();
		if (s.length() < 4 || s.length() > 12)
			return res;

		restoreIpAdressUtil(0, s, "", res);
		return res;
	}

	public void restoreIpAdressUtil(int depth, String s, String sol,
			ArrayList<String> res) {
		if (depth == 3 && isValidNum(s)) {
			res.add(sol + s);
			return;
		}

		for (int i = 1; i < 4 && i < s.length(); i++) {
			String substr = s.substring(0, i);
			if (isValidNum(substr)) {
				restoreIpAdressUtil(depth + 1, s.substring(i), sol + substr
						+ '.', res);
			}
		}
	}

	public boolean isValidNum(String s) {
		if (s.charAt(0) == '0')
			return s.equals("0");
		int num = Integer.parseInt(s);
		return num > 0 && num <= 255;
	}

	public static TreeNode mirror(TreeNode root) {
		if (root == null)
			return null;
		TreeNode tmp = root.left;
		root.left = root.right;
		root.right = tmp;

		mirror(root.left);
		mirror(root.right);
		return root;
	}

	public int maximalRectangle(char[][] matrix) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int m = matrix.length;
		if (m == 0)
			return 0;
		int n = matrix[0].length;

		int[][] dp = new int[m][n];

		for (int i = 0; i < m; i++) {
			dp[i][0] = matrix[i][0] - '0';
		}

		for (int i = 0; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (matrix[i][j] == '1')
					dp[i][j] = dp[i][j - 1] + 1;
				else
					dp[i][j] = 0;

			}
		}

		int maxArea = 0;

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				int maxlength = dp[i][j];

				for (int k = i; k >= 0; k--) {
					if (dp[k][j] == 0)
						break;
					maxlength = Math.min(dp[k][j], maxlength);
					maxArea = Math.max(maxArea, maxlength * (i - k + 1));
				}
			}
		}
		return maxArea;
	}

	public int largestRectangleArea(int[] height) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (height.length == 0)
			return 0;
		Stack<Integer> stk = new Stack<Integer>();
		int i = 0;
		int maxArea = 0;
		int[] h = new int[height.length + 1];
		h = Arrays.copyOf(height, height.length + 1);
		while (i < h.length) {
			if (stk.isEmpty() || h[i] >= h[stk.peek()])
				stk.push(i++);
			else {
				int top = stk.pop();
				maxArea = Math.max(maxArea, h[top]
						* (stk.isEmpty() ? i : i - stk.peek() - 1));

			}
		}

		return maxArea;
	}

	public int maximalRectangle2(char[][] matrix) {
		int m = matrix.length;
		if (m == 0)
			return 0;
		int n = matrix[0].length;

		int[][] dp = new int[m][n + 1];
		// actually we know that height can just be a int[n+1],

		for (int i = 0; i < n; i++) {
			dp[0][i] = matrix[0][i] - '0';
		}

		for (int i = 1; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == '1')
					dp[i][j] = dp[i - 1][j] + 1;
				else
					dp[i][j] = 0;
			}
		}

		int maxArea = 0;

		for (int i = 0; i < m; i++) {
			int area = largestRec(dp[i]);

			if (area > maxArea)
				maxArea = area;
		}
		return maxArea;
	}

	public int largestRec(int[] height) {
		if (height.length == 0)
			return 0;
		Stack<Integer> stk = new Stack<Integer>();
		int max = 0;
		int i = 0;
		while (i < height.length) {
			if (stk.isEmpty() || height[i] >= height[stk.peek()])
				stk.push(i++);
			else {
				int t = stk.pop();
				max = Math.max(max,
						height[t] * (stk.isEmpty() ? i : i - stk.peek() - 1));
			}
		}
		return max;
	}

	public ArrayList<Integer> grayCode(int n) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<Integer> res = new ArrayList<Integer>();
		int count = (int) Math.pow(2, n);
		for (int i = 0; i < count; i++) {
			res.add(binary2Gray(i));
		}
		return res;
	}

	public int binary2Gray(int num) {
		return (num >> 1) ^ num;
	}

	public static ArrayList<String> grayCode2(int n) {
		ArrayList<String> res = new ArrayList<String>();
		if (n <= 0)
			return res;
		ArrayList<String> sol = new ArrayList<String>();
		sol.add("0");
		sol.add("1");

		int count = (int) Math.pow(2, n);

		for (int i = 2; i < count; i = i << 1) {
			for (int j = i - 1; j >= 0; j--) {
				sol.add(sol.get(j));
			}
			// System.out.println(sol);

			for (int j = 0; j < i; j++) {
				sol.set(j, "0" + sol.get(j));
			}
			// System.out.println(sol);
			for (int j = i; j < 2 * i; j++)
				sol.set(j, "1" + sol.get(j));
			// System.out.println(sol);
		}

		// for(int i=0;i<sol.size();i++){
		// res.add(Integer.parseInt(sol.get(i)));
		// }

		return sol;

	}

	public ArrayList<Integer> grayCode3(int n) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		if (n < 0)
			return res;
		if (n == 0) {
			res.add(0);
			return res;
		} else {
			ArrayList<Integer> sol = grayCode3(n - 1);
			res.addAll(sol);
			for (int i = sol.size() - 1; i >= 0; i--) {
				res.add(sol.get(i) + (int) Math.pow(2, n - 1));
			}
		}
		return res;

	}

	public boolean isScramble(String s1, String s2) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (s1.length() != s2.length())
			return false;
		if (s1.equals(s2))
			return true;

		for (int i = 1; i < s1.length(); i++) {
			String s11 = s1.substring(0, i);
			String s12 = s1.substring(i);

			String s21 = s2.substring(0, i);
			String s22 = s2.substring(i);

			if (isScramble(s11, s21) && isScramble(s12, s22))
				return true;

			s22 = s2.substring(s2.length() - i);
			s21 = s2.substring(0, s2.length() - i);

			if (isScramble(s11, s22) && isScramble(s12, s21))
				return true;
		}

		return false;
	}

	// dp[i][j][k] 代表了s1从i开始，s2从j开始，长度为k的两个substring是否为scramble
	// string。
	// 1. 如果两个substring相等的话，则为true
	//
	// 2. 如果两个substring中间某一个点，左边的substrings为scramble string，
	// 同时右边的substrings也为scramble string，则为true
	//
	// 3. 如果两个substring中间某一个点，s1左边的substring和s2右边的substring为scramble
	// string, 同时s1右边substring和s2左边的substring也为scramble
	// string，则为true
	public boolean isScramble2(String s1, String s2) {
		int l1 = s1.length();
		int l2 = s2.length();
		if (l1 != l2)
			return false;
		boolean[][][] dp = new boolean[l1][l1][l1 + 1];

		for (int i = l1 - 1; i >= 0; i--) {
			for (int j = l1 - 1; j >= 0; j--) {
				for (int k = 1; k < l1 - Math.max(i, j); k++) {
					if (s1.substring(i, i + k).equals(s2.substring(j, j + k)))
						dp[i][j][k] = true;
					else {
						for (int l = 1; l < k; l++) {
							if ((dp[i][j][l] && dp[i + l][j + l][k - l])
									|| (dp[i][j + k - l][l] && dp[i + l][j][k
											- l])) {
								dp[i][j][k] = true;
								break;
							}

						}
					}
				}
			}
		}

		return dp[0][0][l1];
	}

	public void solve2(char[][] board) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (board.length == 0)
			return;
		int m = board.length;
		int n = board[0].length;

		for (int i = 0; i < m; i++) {
			dfs(board, i, 0); // left
			dfs(board, i, n - 1);// right
		}

		for (int i = 1; i < n - 1; i++) {
			dfs(board, 0, i);// up
			dfs(board, m - 1, i); // down
		}

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (board[i][j] == 'O')
					board[i][j] = 'X';

				if (board[i][j] == '+')
					board[i][j] = 'O';
			}
		}
	}

	public void dfs(char[][] board, int i, int j) {
		int m = board.length;
		int n = board[0].length;
		if (i < 0 || i >= m || j < 0 || j >= n)
			return;

		if (board[i][j] == 'O') {
			board[i][j] = '+';
			dfs(board, i + 1, j);
			dfs(board, i - 1, j);
			dfs(board, i, j - 1);
			dfs(board, i, j + 1);
		}

	}

	 public static double findMedianSortedArrays(int A[], int B[]) {
	        // Start typing your Java solution below
	        // DO NOT write main() function
	        int m=A.length;
	        int n=B.length;
	        int len=m+n;
	        if(len%2==0)
	        	return (findKth(A,0,m, B,0,n,len/2)+findKth(A,0,m,B,0,n,len/2+1))/2.0;
	        else
	        	return findKth(A,0,m, B,0, n, len/2+1);	        	
	        		
	    }
	 
	 public static double findKth(int[] A, int aoffset, int m, int[] B, int boffset, int n, int k){
		 if(m>n)
			 return findKth(B, boffset, n, A, aoffset, m, k);
		 if(m==0)
			 return B[k-1];
		 if(k==1)
			 return Math.min(A[aoffset], B[boffset]);
		 
		 int pa=Math.min(m, k/2);
		 
		 int pb=k-pa;
		 
		 if(A[aoffset+pa-1]<B[boffset+pb-1])
			 return findKth(A, aoffset+pa,m-pa,B,boffset,n,k-pa);
		 else
			 return findKth(A,aoffset,m,B,boffset+pb,n-pb,k-pb);
			 
	 }

	 public static ListNode interleaveList(ListNode head){
		 if(head==null)
			 return null;
		 
		 int count=0;
		 ListNode cur=head;
		 
		 while(cur!=null){
			 count++;
			 cur=cur.next;
		 }
		 
		cur=head;
		
		for(int i=0;i<count/2;i++){
			cur=cur.next;
		}
		
		ListNode pnext=cur.next;
		cur.next=null;
		
		ListNode r=reverseList(pnext);
		ListNode p=head;
		while(p!=null&&r!=null){
			ListNode q=p.next;
			ListNode n=r.next;
			p.next=r;
			r.next=q;
			
			p=q;
			r=n;
		}
		
		return head;
	 }
	 
		public static ListNode reverseList(ListNode head){
			if(head==null)
				return null;
			ListNode cur=head;
			ListNode pre=null;
			
			while(cur!=null){
				ListNode pnext=cur.next;
				cur.next=pre;
				pre=cur;
				cur=pnext;
			}
			head=pre;
			return head;
		}
		
		public static ListNode reverseListRec(ListNode head){
			if(head==null)
				return null;
//			ListNode cur=head;
			ListNode rest=head.next;
			if(rest==null)
				return head;
			
			ListNode node=reverseListRec(rest);
			rest.next=head;
			head.next=null;
			return node;
		}
		
		 public static String convert(String s, int nRows) {
		        // Start typing your Java solution below
		        // DO NOT write main() function
			 if(nRows<=1)
				 return s;
			 String res="";
			 
			 int zigsize=2*nRows-2;
			 
			 for(int i=0;i<nRows;i++){
				 for(int j=i;j<s.length();j+=zigsize){
					 res+=s.charAt(j);
					 if(i>0&&i<nRows-1){
						 int k=j+zigsize-2*i;
						 if(k<s.length())
							 res+=s.charAt(k);
					 }
				 }
			 }			 
			 return res;
		 }
		 
		 public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
		        // Start typing your Java solution below
		        // DO NOT write main() function
			 ArrayList<ArrayList<Integer>> res=new ArrayList<ArrayList<Integer>>();
			 if(num.length<4)
				 return res;
			 Arrays.sort(num);
			 
			 for(int i=0;i<num.length-3;i++){
				 for(int j=i+1;j<num.length-2;j++){
					 int beg=j+1;
					 int end=num.length-1;
					 
					 while(beg<end){
						 int sum=num[i]+num[j]+num[beg]+num[end];
						 if(sum==target){
							 ArrayList<Integer> sol=new ArrayList<Integer>();
							 sol.add(num[i]);
							 sol.add(num[j]);
							 sol.add(num[beg]);
							 sol.add(num[end]);
							 
							 if(!res.contains(sol)){
								 res.add(sol);								 
							 }
							 beg++;
							 end--;
							 
						 }
						 else if(sum>target)
							 end--;
						 else
							 beg++;
					 }
				 }
			 }
			 return res;
		    }
		 
		 
		 public int minCut(String s) {
		        // Start typing your Java solution below
		        // DO NOT write main() function
		        if(s.length()<2)
		        	return 0;
		        int n=s.length();
		        boolean[][] p=new boolean[n][n];
		        int[][] cut=new int[n][n];
		        
		        for(int i=0;i<n;i++){
		        	p[i][i]=true;
		        	cut[i][i]=0;
		        }
		        
		        for(int len=2;len<=n;len++){
		        	for(int i=0;i<n-len+1;i++){
		        		int j=i+len-1;
		        		if(len==2){
		        			p[i][j]=s.charAt(i)==s.charAt(j);
		        		}
		        		else if(s.charAt(i)==s.charAt(j)){
		        			p[i][j]=p[i+1][j-1];
		        		}
		        		else
		        			p[i][j]=false;
		        		
		        		if(p[i][j])
		        			cut[i][j]=0;
		        		else
		        			cut[i][j]=Integer.MAX_VALUE;
		        		
		        		for(int k=i;k<j;k++){
		        			cut[i][j]=Math.min(cut[i][k]+cut[k+1][j]+1,cut[i][j]);
		        		}
		        	}
		        }
		        return cut[0][n-1];
		        	
		    }
		 
		 
		 public int minCut2(String s) {
		        // Start typing your Java solution below
		        // DO NOT write main() function
//			 dp[i] = 区间[i,n]之间最小的cut数，n为字符串长度
//			 P[i][j] = str[i] == str[j] && P[i+1][j-1]; palindrome?
			 int n=s.length();
			 int[] dp=new int[n+1];
			 boolean[][] p=new boolean[n][n];
			 
			//the worst case is cutting by each char
			 for(int i=0;i<=n;i++)
				 dp[i]=n-i;
			 
			 for(int i=n-1;i>=0;i--){
				 for(int j=i;j<n;j++){
					 if(s.charAt(i)==s.charAt(j)&&(j-i<2||p[i+1][j-1])){
						 p[i][j]=true;
						 dp[i]=Math.min(dp[i], dp[j+1]+1);
					 }						 
				 }
			 }
			 return dp[0]-1;
		        
		    }
		 
		 public static ArrayList<Character> serialize(TreeNode root){
			 ArrayList<Character> res=new ArrayList<Character>();
			 serializeUtil(root,res);
			 return res;
		 }
		 public static void serializeUtil(TreeNode root,ArrayList<Character> res){
			 if(root==null){
				 res.add('#');
				 return;
			 }
			 res.add((char) (root.val+'0'));
			 serializeUtil(root.left,res);
			 serializeUtil(root.right,res);
		 }
		 
		 public static TreeNode deserialize(ArrayList<Character> res, int[] index){
			 if(index[0]>res.size()||res.get(index[0])=='#')
				 return null;
			 TreeNode root=new TreeNode(res.get(index[0])-'0');
			 index[0]++;
			 root.left=deserialize(res,index);
			 index[0]++;
			 root.right=deserialize(res,index);
			 return root;
		 }
		 
//		 public ArrayList<ArrayList<String>> findLadders(String start, String end, HashSet<String> dict) {
//		        // Start typing your Java solution below
//		        // DO NOT write main() function
//		        
//		    }
		 
		 public static ArrayList<String> fullJustify(String[] words, int L) {
		        // Start typing your Java solution below
		        // DO NOT write main() function
			 ArrayList<String> res=new ArrayList<String>();
			 
			 int n=words.length;
			 int i=0;
			 while(i<n){
				 int size=0;
				 int newsize;
				 int beg=i;
				 while(i<n){
					 if(size==0)
						 newsize=words[i].length();
					 else
						 newsize=size+words[i].length()+1;
					 
					 if(newsize<=L)
						 size=newsize;
					 else
						 break;
					 i++;
				 }
				 
				 int spacenumber=L-size;
				 int spaceforeach;
				 
				 if(i-beg-1!=0&&i<n){
					 spaceforeach=spacenumber/(i-beg-1);
					 spacenumber=spacenumber%(i-beg-1);
				 }
				 else
					 spaceforeach=0;
				 
				 String s=words[beg];
				 for(int j=beg+1;j<i;j++){
					 for(int k=0;k<spaceforeach+1;k++)
						 s+=" ";
					 if(spacenumber>0&&i<n){
						 s+=" ";
						 spacenumber--;
					 }
					 s+=words[j];
				 }
				 
				 for(int j=0;j<spacenumber;j++)
					 s+=" ";
				 				 
				 res.add(s);
			 }
			 return res;
		 }
		 
		 public int selectGasStation(int[] a, int[] g) {
			 if(a.length==1)
				 return a[0]-g[0]>=0?0:-1;
			 int start=0;
			 int end=1;
			 int cur_petrol=a[start]-g[start];
			 
			 while(end!=start||cur_petrol<0){
				 while(cur_petrol<0&&start!=end){
					 cur_petrol-=a[start]-g[start];
					 start=(start+1)%a.length;
					 if(start==0)
						 return -1;
				 }
				 cur_petrol+=a[end]-g[end];
				 end=(end+1)%a.length;
				 
			 }
			 return start;
			 
		    }
		 
		 
//		 For each element in s
//		 If *s==*p or *p == ? which means this is a match, then goes to next element s++ p++.
//		 If p=='*', this is also a match, but one or many chars may be available, so let us save this *'s position and the matched s position.
//		 If not match, then we check if there is a * previously showed up,
//		        if there is no *,  return false;
//		        if there is an *,  we set current p to the next element of *, and set current s to the next saved s position.

		 //wildcard matching
		 public boolean isMatch2(String s, String p) {
		        // Start typing your Java solution below
		        // DO NOT write main() function
		      int star=-1;
		      int sp=0;
		      int i=0;
		      int j=0;
		      while(i<s.length()){
		    	  if(j<p.length()&&(p.charAt(j)=='?'||s.charAt(i)==p.charAt(j))){
		    		  i++;
		    		  j++;
		    		  continue;
		    	  }
		    	  if(j<p.length()&&p.charAt(j)=='*'){
		    		  star=j++;
		    		  sp=i;
		    		  continue;
		    	  }
		    	  if(star!=-1){
		    		  j=star+1;
		    		  i=++sp;
		    		  continue;
		    	  }
		    	  return false;
		    		  
		      }
		      while(j<p.length()&&p.charAt(j)=='*'){
		    	  j++;
		      }
		      return j==p.length();
		    }
		 
		 public boolean isValidSudoku(char[][] board) {
		        // Start typing your Java solution below
		        // DO NOT write main() function
		        
			 //check rows
			 
			 for(int i=0;i<9;i++){
				 boolean check[]=new boolean[10];
				 for(int j=0;j<9;j++){
					 char c=board[i][j];
					 if(c=='.')
						 continue;
					 int num=c-'0';
					 if(num>=1&&num<=9){
						 if(!check[num])
							 check[num]=true;
						 else
							 return false;
					 }
				 }
			 }
			 
			 //check cols
			 
			 for(int i=0;i<9;i++){
				 boolean check[]=new boolean[10];
				 for(int j=0;j<9;j++){
					 char c=board[j][i];
					 if(c=='.')
						 continue;
					 int num=c-'0';
					 if(num>=1&&num<=9){
						 if(!check[num])
							 check[num]=true;
						 else
							 return false;
					 }
				 }
			 }
			 
			 
	 //check grids
			 
			 for(int i=0;i<9;i+=3){
				 for(int j=0;j<9;j+=3){
					 boolean check[]=new boolean[10];
					 
					 for(int k=0;k<3;k++){
						 for(int l=0;l<3;l++){
							 char c=board[i+k][j+l];
							 if(c=='.')
								 continue;
							 int num=c-'0';
							 if(num>=1&&num<=9){
								 if(!check[num])
									 check[num]=true;
								 else
									 return false;
							 }
						 }
					 }
				 }				
			 }
			 return true;
		    }
		 
		 public ArrayList<String[]> solveNQueens(int n) {
		        // Start typing your Java solution below
		        // DO NOT write main() function
			 ArrayList<String[]> res=new ArrayList<String[]>();
			 int[] loc=new int[n];
			 dfsQueen(0,n,loc,res);
			 return res;
		    }
		 
		 public void dfsQueen(int cur, int n, int[] loc, ArrayList<String[]> res){
			 if(cur==n){
				 printboard(res,loc,n);
			 }
			 else{
				 for(int i=0;i<n;i++){
					 loc[cur]=i;
					 if(isValid(loc,cur)){
						 dfsQueen(cur+1,n,loc,res);
					 }
				 }
			 }
		 }
		 
		 public boolean isValid(int[] loc, int cur){
			 for(int i=0;i<cur;i++){
				 if(loc[cur]==loc[i]||Math.abs(loc[i]-loc[cur])==(cur-i))
					 return false;
			 }
			 return true;
		 }
		 
		 public void printboard(ArrayList<String[]> res, int[] loc, int n){
			 String[] ans=new String[n];
			 for(int i=0;i<n;i++){
				 String row="";
				 for(int j=0;j<n;j++){
					 if(loc[i]==j)
						 row+='Q';
					 else
						 row+='.';
				 }
				 ans[i]=row;
			 }
			 res.add(ans);
		 }
		 
		 public int totalNQueens(int n) {
		        // Start typing your Java solution below
		        // DO NOT write main() function
		        int[] res=new int[1];
		        if(n<=0)
		        	return 0;
		        int[] loc=new int[n];
		        dfsQueen2(0,n,loc, res);
		        return res[0];
		    }
		 
		 public void dfsQueen2(int cur, int n, int[] loc, int[] res){
			 if(cur==n){
				 res[0]++;
			 }
			 else{
				 for(int i=0;i<n;i++){
					 loc[cur]=i;
					 if(isValid(loc,cur)){
						 dfsQueen2(cur+1,n,loc,res);
					 }
				 }
			 }
		 }
		 
		 public int candy(int[] ratings) {
		        // Note: The Solution object is instantiated only once and is reused by each test case.
		        int res=0;
		        int[] left=new int[ratings.length];
		        Arrays.fill(left, 1);
		        int[] right=new int[ratings.length];
		        Arrays.fill(right, 1);
		        
		        for(int i=1;i<ratings.length;i++){
		        	if(ratings[i]>ratings[i-1])
		        		left[i]=left[i-1]+1;
		        }
		        
		        for(int i=right.length-2;i>=0;i--){
		        	if(ratings[i]>ratings[i+1])
		        		right[i]=right[i+1]+1;
		        }
		        
		        for(int i=0;i<ratings.length;i++)
		        	res+=Math.max(left[i], right[i]);
		        return res;
		    }
		 
		 
		 public void solveSudoku(char[][] board) {
		        // Start typing your Java solution below
		        // DO NOT write main() function
		        ArrayList<Integer> empty=new ArrayList<Integer>();
		        for(int i=0;i<9;i++){
		        	for(int j=0;j<9;j++){
		        		if(board[i][j]=='.')
		        			empty.add(i*9+j);
		        	}
		        }
		        dfsSudoku(empty,board,0);
		    }
		 
		 public boolean dfsSudoku(ArrayList<Integer> empty, char[][] board,int cur){
			 if(cur==empty.size())
				 return true;
			 int index=empty.get(cur);
			 int row=index/9;
			 int col=index%9;
			 
			 for(int i=1;i<=9;i++){
				 if(isValidSudoku(i,row,col,board)){
					 board[row][col]=(char) ('0'+i);
					 if(dfsSudoku(empty,board,cur+1))
						 return true;
					 board[row][col]='.';
				 }
			 }
			 return false;
		 }
		 
		 public boolean isValidSudoku(int v,int row, int col, char[][] board){
			 for(int i=0;i<9;i++){
				 if(board[row][i]=='0'+v)
					 return false;
				 if(board[i][col]=='0'+v)
					 return false;
				 
				 int b_row=3*(row/3)+i/3;
				 int b_col=3*(col/3)+i%3;
				 if(board[b_row][b_col]=='0'+v)
					 return false;
			 }
			 return true;
		 }
		 
		 
		 public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		        // Note: The Solution object is instantiated only once and is reused by each test case.
		        if(node==null)
		        	return null;
		        Queue<UndirectedGraphNode> que=new LinkedList<UndirectedGraphNode>();
		        HashMap<UndirectedGraphNode,UndirectedGraphNode> map=new HashMap<UndirectedGraphNode,UndirectedGraphNode>();
		        
		        que.add(node);
		        UndirectedGraphNode copy=new UndirectedGraphNode(node.label);
		        
		        map.put(node, copy);
		        
		        while(!que.isEmpty()){
		        	UndirectedGraphNode t=que.poll();
		        	ArrayList<UndirectedGraphNode> neighbors=t.neighbors;
		        	
		        	for(int i=0;i<neighbors.size();i++){
		        		UndirectedGraphNode neighbor=neighbors.get(i);
		        		if(!map.containsKey(neighbor)){
		        			UndirectedGraphNode p=new UndirectedGraphNode(neighbor.label);
		        			map.get(t).neighbors.add(p);
		        			map.put(neighbor, p);
		        			que.add(neighbor);
		        		}
		        		else{
		        			map.get(t).neighbors.add(map.get(neighbor));
		        		}
		        	}
		        }
		        return copy;
		    }
		 
		 
		 public boolean isNumber(String s) {
		        // Start typing your Java solution below
		        // DO NOT write main() function		        
		        s=s.trim();
		        if(s.length()==0)
		        	return false;
		        
		        boolean e=false;
		        boolean dot=false;
		        boolean dig=false;
		        int i=0;
		        
		        while(i<s.length()-1){
		        	char c=s.charAt(i);
		        	if(i==0){
		        		if(c>='0'&&c<='9'){
		        			dig=true;
		        		}
		        		else{
		        			if(c=='+'||c=='-'||c=='.'){
		        				if(s.length()==1)
		        					return false;
		        				if(c=='.')
		        					dot=true;		        				
		        			}
		        			else
		        				return false;
		        		}		        			
		        	}
		        	else{
		        		switch(c){
		        		case 'e':// e cannot follow +,-
		        			if(e==false&&s.charAt(i-1)!='+'&&s.charAt(i-1)!='-'&&dig&&i!=s.length()-1)
		        				e=true;
		        			else
		        				return false;
		        			break;
		        		case '+':// + can only occur after e
		        			if(s.charAt(i-1)!='e')
		        				return false;
		        			break;
		        		case '-':// - can only occur after e
		        			if(s.charAt(i-1)!='e')
		        				return false;
		        			break;
		        		case '.': // . can only occur once and cannot occure after e
		        			if(dot==false&&e==false)
		        				dot=true;
		        			else
		        				return false;
		        			break;
		        		default:// only 0-9 can be valid numbers
		        			if(c<'0'||c>'9')
		        				return false;
		        			else
		        				dig=true;
		        			break;       				
		        			
		        		}
		        	}
		        	i++;
		        }
		        if (s.charAt(i)>='0' && s.charAt(i)<='9'){
		        	return true;
		        	}
		        if (s.charAt(i)=='.' && !dot && !e && i-1>=0&&s.charAt(i-1)>='0' && s.charAt(i-1)<='9') {return true;} 
		        return false;		        
		    }
		 
		 public void recoverTree(TreeNode root) {
		        // Start typing your Java solution below
		        // DO NOT write main() function
		        ArrayList<TreeNode> nodes=new ArrayList<TreeNode>();
		        inorderTrav(root,nodes);
		        int i,j;
		        for(i=0;nodes.get(i).val<nodes.get(i+1).val;i++);
		        
		        for(j=nodes.size()-1;nodes.get(j).val>nodes.get(j-1).val;j--);
		        int t=nodes.get(i).val;
		        nodes.get(i).val=nodes.get(j).val;
		        nodes.get(j).val=t;
		    }
		 
		 public void inorderTrav(TreeNode root, ArrayList<TreeNode> nodes){
			 if(root==null)
				 return;
			 inorderTrav(root.left,nodes);
			 nodes.add(root);
			 inorderTrav(root.right,nodes);
		 }
		 
		 TreeNode first;
		 TreeNode second;
		 TreeNode pre;
		 
		 public void recoverTree2(TreeNode root) {
			 first=null;
			 second=null;
			 pre=null;
			 
			 inorder(root);
			 int t=first.val;
			 first.val=second.val;
			 second.val=t;
		 }
		 
		 public void inorder(TreeNode root){
			 if(root==null)
				 return;
			 inorder(root.left);
			 if(pre==null)
				 pre=root;
			 else{
				 if(pre.val>root.val){
					 if(first==null)
						 first=pre;
					 second=root;
				 }
				 pre=root;
			 }
			 inorder(root.right);
			 
		 }
		 public void recoverBST(TreeNode root){
			 first=null;
			 second=null;
			 pre=null;
			 inorderCheck(root);
			 int t=first.val;
			 first.val=second.val;
			 second.val=t;
					 
		 }
		 public void inorderCheck(TreeNode root){
			 if(root==null)
				 return ;
			 inorderCheck(root.left);
			 if(pre==null)
				 pre=root;
			 else{
				 if(pre.val>root.val){
					 if(first==null)
						 first=pre;
					 second=root;
				 }
				 pre=root;
			 }
			 inorderCheck(root.right);		 	 
				 
		 }
		 
		 
		 public void solveBFS(char[][] board) {
		        // Start typing your Java solution below
		        // DO NOT write main() function
		        int m=board.length;
		        if(m==0)
		        	return;
		        int n=board[0].length;
		        ArrayList<Integer> q1=new ArrayList<Integer>();
		        ArrayList<Integer> q2=new ArrayList<Integer>();
		        
		        for(int i=0;i<m;i++){
		        	if(board[i][0]=='O'){
		        		q1.add(i);
		        		q2.add(0);
		        	}
		        	if(board[i][n-1]=='O'){
		        		q1.add(i);
		        		q2.add(n-1);
		        	}
		        }
		        
		        for(int i=1;i<n;i++){
		        	if(board[0][i]=='O'){
		        		q1.add(0);
		        		q2.add(i);
		        	}
		        	if(board[m-1][i]=='O'){
		        		q1.add(m-1);
		        		q2.add(i);
		        	}
		        }
		        
		        int i=0;
		        while(i<q1.size()){
		        	int x=q1.get(i);
		        	int y=q2.get(i);
		        	board[x][y]='A';
		        	
		        	  
		            if (x-1>=0 && board[x-1][y]=='O'){
		                q1.add(x-1);
		                q2.add(y);
		            }
		            if (x+1<m && board[x+1][y]=='O'){
		                q1.add(x+1);
		                q2.add(y);
		            }
		            if (y-1>=0 && board[x][y-1]=='O'){
		                q1.add(x);
		                q2.add(y-1);
		            }
		            if (y+1<n && board[x][y+1]=='O'){
		                q1.add(x);
		                q2.add(y+1);
		            }
		            i++;  
		        }
		        
		        for(int j=0;j<m;j++){
		        	for(int k=0;k<n;k++){
		        		if(board[j][k]=='O')
		        			board[j][k]='X';
		        		
		        		if(board[j][k]=='A')
		        			board[j][k]='O';
		        	}
		        }
		        
		    }
		 
		 public static int[] levelSum(TreeNode root){
			 int height=getTreeHeight(root);
			 
			 int[] res=new int[height];
			 levelSumUtil(root, res,0);
			 
			 return res;
		 }
		 
		 public static int getTreeHeight(TreeNode root){
			 if(root==null)
				 return 0;
			 int left=getTreeHeight(root.left);
			 int right=getTreeHeight(root.right);
			 return left>right?left+1:right+1;
		 }
		 
		 public static void levelSumUtil(TreeNode root, int[] res, int level){
			 if(root==null)
				 return;
			 res[level]+=root.val;
			 levelSumUtil(root.left,res,level+1);
			 levelSumUtil(root.right,res,level+1);
			 
		 }
		 class myComparator implements Comparator<Interval>{

			@Override
			public int compare(Interval o1, Interval o2) {
				return o1.start-o2.start;
				// TODO Auto-generated method stub
				
			}
			 
		 }
		 
		 public void intersected(Interval[] intervals, boolean[] isIntersected) {
			 if(intervals.length<2)
				 return;
			 
			 HashMap<Interval,Integer> map=new HashMap<Interval,Integer>();
			 for(int i=0;i<intervals.length;i++){
				 map.put(intervals[i],i);
			 }
			 Arrays.sort(intervals, new myComparator());
			 Interval interval1=intervals[0];
			 int end=interval1.end;
			 for(int i=1;i<intervals.length;i++){
				 
				 Interval interval2=intervals[i];
				 
				 if(end>=interval2.start){
//					 isIntersected[map.get(interval1)]=true;
					 isIntersected[map.get(interval2)]=true;
				 }
				 end=Math.max(end, interval2.end);			 
				 
			 }
			 
			 int n=intervals.length;
			 interval1=intervals[n-1];
			 int start=interval1.start;
			 	for(int i=n-2;i>=0;i--){
				 
				 Interval interval2=intervals[i];
				 
				 if(start<=interval2.end){
//					 isIntersected[map.get(interval1)]=true;
					 isIntersected[map.get(interval2)]=true;
				 }
				 start=Math.min(start, interval2.start);				 
				 
			 }
	
		    }
		 
		 static TreeNode previous=null;
		 static TreeNode succ=null;
		 public static TreeNode inorder_succ(TreeNode root, TreeNode A){
			 if(root==null)
				 return null;
			 inorder_succ(root.left,A);
			 if(previous==null)
				 previous=root;
			 else{
				 if(previous.val==A.val){
					 succ=root;
				 }
//					 return root;
				 previous=root;
//				 succ=root.right;
			 }
			 inorder_succ(root.right,A);
			 return succ;
			
		 }
		 
		 public static ArrayList<ArrayList<Integer>> verticalView(TreeNode root){
			 ArrayList<ArrayList<Integer>> res=new ArrayList<ArrayList<Integer>>();
			 if(root==null)
				 return res;
			 TreeMap<Integer,ArrayList<Integer>> map=new TreeMap<Integer, ArrayList<Integer>>();
			 verticalViewUtil(root,0,map);
//			 System.out.println(map.entrySet());
			 Iterator<Integer> it=map.keySet().iterator();
//			 int count=0; //zigzag manner
			 while(it.hasNext()){
				 ArrayList<Integer> sol=map.get(it.next());
				 res.add(sol);
//				 if(count%2==0)
//					 res.add(sol);
//				 else{
//					 Collections.reverse(sol);
//					 res.add(sol);
//				 }
//				 count++;
			 }
			 return res;
		 }
		 
		 public static void verticalViewUtil(TreeNode root, int dis, TreeMap<Integer,ArrayList<Integer>> map){
			 if(root==null)
				 return;
			 
			 if(!map.containsKey(dis)){
				 ArrayList<Integer> sol=new ArrayList<Integer>();
				 sol.add(root.val);
				 map.put(dis, sol);
			 }
			 else{
				 map.get(dis).add(root.val);
			 }
			 verticalViewUtil(root.left,dis-1,map);
			 verticalViewUtil(root.right,dis+1,map);
		 }
		 
		 public RandomListNode copyRandomList(RandomListNode head) {
		        // Note: The Solution object is instantiated only once and is reused by each test case.
		        if(head==null)
		        	return null;
		        
		        RandomListNode cur=head;
		        while(cur!=null){
		        	RandomListNode pnext=cur.next;
		        	RandomListNode node=new RandomListNode(cur.label);
		        	cur.next=node;
		        	node.next=pnext;
		        	cur=pnext;		        	
		        }
		        
		        cur=head;
		        while(cur!=null){
		        	if(cur.random!=null)
		        		cur.next.random=cur.random.next;
		        	cur=cur.next.next;
		        	
		        }
		        
		        RandomListNode colone=head.next;
		      //restore the original and copy linked lists  	        
		        cur=head;
		        RandomListNode tmp=head.next;
		        while(cur!=null&&tmp!=null){
		        	cur.next=cur.next.next;
		        	cur=cur.next;
		        	if(tmp.next!=null){
		        		tmp.next=tmp.next.next;
		        		tmp=tmp.next;
		        	}
		        }
		        
		        return colone;
		    }
		 
		 public boolean wordBreak(String s, Set<String> dict) {
		        // Note: The Solution object is instantiated only once and is reused by each test case.
		        if(s==null||s.length()==0)
		        	return true;
		        for(int i=1;i<=s.length();i++){
		        	String sub=s.substring(0,i);
		        	if(dict.contains(sub)&&wordBreak(s.substring(i),dict))
		        		return true;
		        }
		        return false;
		    }
		 
		 
		 public boolean wordBreakDP(String s, Set<String> dict) {
		        // Note: The Solution object is instantiated only once and is reused by each test case.
		        if(s==null||s.length()==0)
		        	return true;
		        boolean[] wb=new boolean[s.length()+1];
		        for(int i=1;i<=s.length();i++){
		        	String sub=s.substring(0,i);
		        	if(!wb[i]&&dict.contains(sub))
		        		wb[i]=true;
		        	if(wb[i]){
		        		if(i==s.length())
		        			return true;
		        		for(int j=i+1;j<=s.length();j++){
		        			String str=s.substring(i,j);
		        			if(!wb[j]&&dict.contains(str))
		        				wb[j]=true;
		        			if(wb[j]){
		        				if(j==s.length())
		        					return true;
		        			}
		        		}
		        	}
		        }
		        return false;
		    }
	
		 static TreeNode head=null;
		 public static TreeNode extractLeafList(TreeNode root){
			 if(root==null)
				 return null;
//			 TreeNode head=null;
//			 extractLeafList(root.right);
			 if(root.left==null&&root.right==null){
				 if(head==null)
					 head=root;
				 else{
					 head.left=root;
					 root.right=head;
					 head=root;
				 }	
				 System.out.println(head.val+" ffffff");
			 }
			 extractLeafList(root.right);
			extractLeafList(root.left);
			 
//			extractLeafListUtil(root);
			return  head;
		 }
		 
		 public static TreeNode leafList(TreeNode root){
			 if(root==null)
				 return null;
			 leafList(root.right);
			 if(root.left==null&&root.right==null){
				 root.right=head;
				 if(head!=null)
					 head.left=root;
				 head=root;
			 }
			 
			
			 leafList(root.left);
			 return head;
		 }
		 
		public static int FindNumberOfRotations( int[] arr, int pivotMin, int pivotMax )
		 {
		     /*
		     You know that the array is sorted in ascending
		     order and rotated some X number of times.These are
		     the clues that you have in your hand.
		     */
		     if(pivotMin == pivotMax)
		         return pivotMin+1;
		  
		     int mid = pivotMin+(pivotMax-pivotMin)/2;
		     if( arr[mid] > arr[pivotMin] )
		     {
		         return FindNumberOfRotations( arr, mid, pivotMax );
		     }
		     else
		     {
		         return FindNumberOfRotations( arr, pivotMin, mid );
		     }
		 }
		
		public static void RotateArrayElements( int[] arr, int len )
		{
		    int curVal=arr[0];
		    int prevVal = arr[0];
		 
		    for( int i=0 ; i < len ; i++ )
		    {
		        if( i == 0 ){
		            arr[i] = arr[len-1];
		        }
		        else
		        {
		            curVal = arr[i];
		            arr[i] = prevVal;
		            prevVal = curVal;
		        }
		    }
		}
		 
		
		public static int findRotateNum(int[] arr){
//			if(arr.length==0)
//				return -1;
			int beg=0;
			int end=arr.length-1;
			while(beg<end){
				if(arr[beg]<arr[end])
					return end+1;
				else{
					int mid=(beg+end)/2;
					if(arr[beg]<=arr[mid]&&arr[mid+1]<=arr[end])
						return mid+1;
					else if(arr[beg]<=arr[mid])
						beg=mid+1;
					else
						end=mid;
				}
				
				
			}
			return -1;
		}
		
		public static int singleNumber(int[] A) {
	        // Note: The Solution object is instantiated only once and is reused by each test case.
	        int res=0;
	        
	        
	        for(int i=0;i<32;i++){
	        	int sum=0;
	        	int x=(1<<i);
	        	for(int j=0;j<A.length;j++){
	        		if((x&A[j])!=0)
	        			sum++;
	        	}
	        	if(sum%3!=0)
	        		res|=x;
	        }
	        return res;
	    }
		
//		public static ArrayList<String> wordBreak2(String s, Set<String> dict) {
//	        // Note: The Solution object is instantiated only once and is reused by each test case.
//			ArrayList<String> res=new ArrayList<String>();
//			if(s.length()==0)
//				return res;
//			int n=s.length();
//			boolean[] wb=new boolean[n+1];
//			
//			for(int i=1;i<=n;i++){
//				String sub=s.substring(0,i);
//				if(!wb[i]&&dict.contains(sub))
//					wb[i]=true;
//				if(wb[i]){
//					if(i==n){
//						String sol="";
//						int beg=0;
//						for(int j=1;j<=n;j++){
//							if(wb[j]){
//								if(dict.contains(s.substring(beg,j))){
//									sol+=s.substring(beg,j)+" ";
//									beg=j;
//								}
//								
//							}
//						}
//						res.add(sol);
//					}
//					else{
//						for(int j=i+1;j<=n;j++){
//							if(!wb[j]&&dict.contains(s.substring(i,j)))
//								wb[j]=true;
//							if(wb[j]){
//								if(j==n){
//									String sol="";
//									int beg=0;
//									for(int k=1;k<=n;k++){
//										if(wb[k]){
//											sol+=s.substring(beg,k)+" ";
//											beg=k;
//										}
//									}
//									res.add(sol);
//								}
//							}
//						}
//					}
//					
//				}
//			}
//			return res;
//	    }

		
		public static int SplitInt2MaxProduct(int num){
			int max=1;
			if(num<=4)
				return num;
			int k=num/3;
			int r=num%3;
			if(r==1){
				k--;
				r+=3;
			}
			for(int i=0;i<k;i++){
				max*=3;
			}
			if(r>0)
				return max*r;
			return max;
		}
		
		static int count=0;
		public static int countNodes(TreeNode root, int min, int max){
			if(root==null)
				return 0;
			if(root.val>=min&&root.val<=max)
				count++;
			countNodes(root.left,min,max);
			countNodes(root.right,min,max);
			return count;
		}
		
		
		
		
		
		
//		
//		public static int nextPalindrome(int num)
//		 {
//		  return nextPalindrome(num,true);
//		 }
//		 private static int nextPalindrome(int num,boolean firstTime)
//		 {
//		  String numString=""+num;
//		  int leftEndIndex=-1;
//		  int rightStartIndex=-1;
//		  boolean isOdd=numString.length()%2==1;
//		  if(isOdd)
//		  {
//		   leftEndIndex=numString.length()/2;
//		   rightStartIndex=leftEndIndex+1;
//		  }
//		  else
//		  {
//		   leftEndIndex=rightStartIndex=numString.length()/2;
//		   
//		  }
//		  String leftHalf=numString.substring(0,leftEndIndex);
//		  String rightHalf=numString.substring(rightStartIndex);
//		  
//		  String leftReversed=new StringBuffer(leftHalf).reverse().toString();
//		  String palindrome=null;
//		  if(Integer.parseInt(leftReversed)>Integer.parseInt(rightHalf)||!firstTime)
//		  {
//		   if(isOdd)
//		    palindrome=leftHalf+numString.charAt(leftEndIndex)+leftReversed;
//		   else
//		    palindrome=leftHalf+leftReversed;
//		   return Integer.parseInt(palindrome);
//		  }
//		  else
//		  {
//		   if(isOdd)
//		   {
//		    String leftAndMiddle=leftHalf+numString.charAt(leftEndIndex);
//		    int incrementedLeft=Integer.parseInt(leftAndMiddle)+1;
//		    return nextPalindrome(Integer.parseInt(incrementedLeft+rightHalf),false);
//		   }
//		   else
//		   {
//		    int incrementedLeft=Integer.parseInt(leftHalf)+1;
//		    return nextPalindrome(Integer.parseInt(incrementedLeft+rightHalf),false);
//		   }
//		  }
//		  
//		 }
		
		
		
		
		
		
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = { 0 };
		System.out.println(longestConsecutive(num));
		int[] arr = { 1, 7, 10, 13, 14, 19 };
		System.out.println(findMin(arr));

		char[] set = { 'a', 'b' };
		// printAllKLength(set,3);
		printKLength(set, 4);

		int set1[] = { 1, 2, 3, 4, 5, 6, 7, 8 };
		System.out.println(lenghtOfLongestAP(set1));

		int[] array = { -1, 1, 2, 3, 1, -2, 3, 4, -5, 6, 7, -8 };

		rearrange1(array);
		System.out.println();
		rearrange2(array);
		System.out.println();
		ListNode head = new ListNode(5);
		ListNode node1 = new ListNode(0);
		ListNode node2 = new ListNode(7);
		ListNode node3 = new ListNode(6);
		ListNode node4 = new ListNode(8);
		ListNode node5 = new ListNode(1);
		ListNode node6 = new ListNode(4);
		ListNode node7 = new ListNode(3);
		head.next = node1;
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		node6.next = node7;
		
//		ListNode x=reverseListRec(head);
//		while(x!=null){
//			System.out.print(x.val+"->");
//			x=x.next;
//		}
//		System.out.println( "wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww ");
		ListNode c=interleaveList(head);
		
//		ListNode c=reverseList(head);
		while(c!=null){
			System.out.print(c.val+"->");
			c=c.next;
		}
		System.out.println( "wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww ");
		ListNode res = mergeSortList(head);
		while (res != null) {
			System.out.print(res.val + " ");
			res = res.next;
		}
		System.out.println();

		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(2);
		root.right = new TreeNode(6);
		root.left.right = new TreeNode(4);
		root.left.left = new TreeNode(1);
		root.right.right = new TreeNode(8);
		 root.right.right.right=new TreeNode(9);
		root.right.right.left = new TreeNode(7);
		root.left.right.left = new TreeNode(3);
		
//		TreeNode leafHead=leafList(root);
//		
//		while(leafHead!=null){
//			System.out.print(leafHead.val+" ");
//			leafHead=leafHead.right;
//			
//		}
//		
		System.out.print(countNodes(root,0,4));
		System.out.println("ooooooooooooooooooooooo");
//		System.out.println(verticalView(root));
		System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
		System.out.println(inorder_succ(root,root.left.left).val);
		System.out.println("zzzzzzzzzzzzzzzzzzzzzzzzzzzzz");
		ArrayList<Character> ret=serialize(root);
		
		System.out.println(ret);
		int[] index={0};
		TreeNode sroot=deserialize(ret, index);
		inorderTrav(sroot);
		System.out.println();
		
		System.out.println("yyyyyyyyyyyyyyyyyyyyyyyy");
		int[] levelsum=levelSum(root);
		for(int i=0;i<levelsum.length;i++){
			System.out.print(levelsum[i]+" ");
		}
		System.out.println();
		
		printRightViewOfBT(root);
		System.out.println();
		leftViewofBST(root);
		System.out.println();
		System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxx");
		System.out.println(getLevelDiff(root));

		inorderTrav(root);
		System.out.println();
		mirror(root);
		inorderTrav(root);
		System.out.println();
		modifyBST(root);
		inorderTrav(root);

		System.out.println("yuan fengpeng");

		System.out.println(sumNumbers(root));
		int[] arrs = { 1, 2, 3, 5, 3, 3, 1, 2, 3, 1, 2 };
		System.out.println(longestContinousSubArray(arrs));

		ListNode p = new ListNode(1);
		p.next = new ListNode(2);
		// p.next.next=new ListNode(3);

		ListNode q = new ListNode(4);
		q.next = new ListNode(5);
		q.next.next = new ListNode(6);

		merge(p, q);

		ListNode cur = p;
		while (cur != null) {
			System.out.print(cur.val + " ");
			cur = cur.next;
		}

		System.out.println(countAndSay(3));

		int[] subArray = { 4, 6, 3, -9, -5, 1, 3, 0, 2 };
		subArraySumsZero(subArray);

		int[][] M = { { 1, 1, 0 }, { 0, 1, 0 }, { 1, 0, 0 },

		};

		System.out.println(numOfShapes(M));

		printLeftViewOfBT(root);
		System.out.println();
		leftViewOfBT(root);

		System.out.println(wordBreakRecur("samsungandmango"));

		System.out.println(maxProd(2));

		System.out.println(divide(-2147483648, -1));

		// grayCode2(2);
		System.out.println(grayCode2(3));
		int[] A={2};
		int[] B={};
		
		System.out.println(findMedianSortedArrays(A,B));
		System.out.println(convert("PAYPALISHIRING", 3));
		String[] words={"This", "is", "an", "example", "of", "text", "justification."};
		System.out.println(fullJustify(words,16));
		
		
//		[2,4],[2,3],[4,4],[5,5],[2,3],[5,6],[0,0],[5,6]]
		Interval inter1=new Interval(5,5);
		Interval inter2=new Interval(1,2);
		Interval inter3=new Interval(2,4);
		Interval inter4=new Interval(2,3);
		Interval inter5=new Interval(4,4);
		Interval inter6=new Interval(5,5);
		Interval inter7=new Interval(2,3);
		Interval inter8=new Interval(5,6);
		Interval inter9=new Interval(0,0);
		Interval inter10=new Interval(5,6);
//		Interval inter11=new Interval(3,5);
		
		Interval[] intervals={inter1,inter2,inter3,inter4,inter5,inter6,inter7,inter8,inter9,inter10};
		boolean[] isIntersected={false,false,false,false,false,false,false,false,false,false};
		Solution sol=new Solution();
		sol.intersected(intervals, isIntersected);
		for(int i=0;i<10;i++)
			System.out.print(isIntersected[i]+" ");
		
		
		int sortedarr[] = {1,2,3,4,5,6,7,8,9};
	    // Iterate it some random number of times
	    int nIter = (int) ((10*Math.random())%9);
	    for( int i = 0 ; i < nIter ; i++ )
	    {
	        RotateArrayElements(sortedarr, 9);
	    }
	 
	    int nRotations = FindNumberOfRotations( sortedarr, 0, 9 ) ;
	    if( nRotations == nIter )
	    {
	       System.out.println(nRotations+ " Cool! You did a great job!!");
	    }
	    else
	    {
	    	System.out.println("You need to work more smarter :-/");
	    }
	    
	    for(int i=0;i<sortedarr.length;i++){
	    	System.out.print(sortedarr[i]+" ");
	    }
	    System.out.println();
	    System.out.println( findRotateNum(sortedarr));
	    
	    int arr1[] = {12, 1, 12, 3, 12, 1, 1, 2, 3, 2, 2, 3, 7};
	    
	    System.out.println(singleNumber(arr1)+" yuan");
	    String wb="catsanddog";
	    HashSet<String> dict=new HashSet<String>();
	    dict.add("cat");
	    dict.add("cats");
	    dict.add("and");
	    dict.add("sand");
	    dict.add("dog");
//	    System.out.println(wordBreak2(wb,dict));
	    System.out.println(SplitInt2MaxProduct(11));
//	    System.out.println(nextPalindrome(5));
	}

}

package com.Leetcode;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.Vector;






public class Solution {
	
	public static int[] twoSum(int[] numbers, int target) {
		int[] res={-1,-1};
		if(numbers.length<2)
			return res;
		
		HashMap<Integer, Integer> map=new HashMap<Integer, Integer>();
		for(int i=0;i<numbers.length;i++){
			if(map.containsKey(numbers[i])){
				if(numbers[i]*2==target){
					res[0]=map.get(numbers[i]);
					res[1]=i+1;
					return res;
				}
			}
			else
				map.put(numbers[i], i+1);
		}
		
		for(int i=0;i<numbers.length;i++){
			int num=target-numbers[i];
			if(map.containsKey(num)&&map.get(num)!=i+1){
				res[0]=map.get(numbers[i]);
				res[1]=map.get(num);
				break;
			}
		}
		return res;
	}
	
	public static int[] twoSum2(int[] numbers, int target) {
		int res[]={-1,-1};
		HashMap<Integer, Integer> map=new HashMap<Integer,Integer>();
		
		for(int i=0;i<numbers.length;i++){
			if(map.containsKey(numbers[i])){
				res[0]=map.get(numbers[i]);
				res[1]=i+1;
			}
			else if(!map.containsKey(target-numbers[i]))
				map.put(target-numbers[i], i+1);
		}
		return res;
	}
	
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if(l1==null||l2==null)
			return l1==null?l2:l1;
		ListNode dummy=new ListNode(0);
		ListNode pre=dummy;;
		int carry=0;
		while(l1!=null&&l2!=null){
			int sum=l1.val+l2.val+carry;
			carry=sum/10;
			sum=sum%10;
			ListNode cur=new ListNode(sum);
			pre.next=cur;
			pre=cur;
			l1=l1.next;
			l2=l2.next;
		}
		
		while(l1!=null){
			int sum=l1.val+carry;
			carry=sum/10;
			sum=sum%10;
			ListNode cur=new ListNode(sum);
			pre.next=cur;
			pre=cur;
			l1=l1.next;
		}
		
		while(l2!=null){
			int sum=l2.val+carry;
			carry=sum/10;
			sum=sum%10;
			ListNode cur=new ListNode(sum);
			pre.next=cur;
			pre=cur;
			l2=l2.next;
		}
		
		if(carry==1){
			ListNode node=new ListNode(1);
			pre.next=node;
		}
		return dummy.next;
	}
	
	public static int[] plusOne(int[] digits) {
		int n=digits.length;	
		
		int carry=1;
		for(int i=n-1;i>=0;i--){
			int sum=digits[i]+carry;
			carry=sum/10;
			sum=sum%10;
			digits[i]=sum;
		}
		if(carry==1){
			int[] res=new int[n+1];
			res[0]=1;
			System.arraycopy(digits, 0, res, 1, n);
			return res;
		}
		return digits;
	}
	
	public static void setZeroes(int[][] matrix) {
		int m=matrix.length;
		int n=matrix[0].length;
		boolean[] rows=new boolean[m];
		boolean[] cols=new boolean[n];
		
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				if(matrix[i][j]==0){
					rows[i]=true;
					cols[j]=true;
				}
			}
		}
		
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				if(rows[i]==true||cols[j]==true)
					matrix[i][j]=0;
			}
		}
		
	}
	
	public static void setZeroesConstanctSpace(int[][] matrix) {
		int m=matrix.length;
		if(m==0)
			return;
		int n=matrix[0].length;
		
		boolean fr=false;
		boolean fc=false;
		for(int i=0;i<m;i++){
			if(matrix[i][0]==0){
				fc=true;
				break;
			}
		}
		
		for(int i=0;i<n;i++){
			if(matrix[0][i]==0){
				fr=true;
				break;
			}
		}
		
		for(int i=1;i<m;i++){
			for(int j=1;j<n;j++){
				if(matrix[i][j]==0){
					matrix[i][0]=0;
					matrix[0][j]=0;
				}
			}
		}
		
		for(int i=1;i<m;i++){
			for(int j=1;j<n;j++){
				if(matrix[i][0]==0||matrix[0][j]==0)
					matrix[i][j]=0;
			}
		}
		
		if(fc){
			for(int i=0;i<m;i++)
				matrix[i][0]=0;
		}
		if(fr){
			for(int i=0;i<n;i++)
				matrix[0][i]=0;
		}
	}
	
	 public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
		 ArrayList<ArrayList<Integer>> res=new ArrayList<ArrayList<Integer>>();
		 if(num.length<3)
			 return res;
		 Arrays.sort(num);
		 
		 for(int i=0;i<num.length-2;i++){
			 int j=i+1;
			 int k=num.length-1;
			 
			 while(j<k){
				 int sum=num[i]+num[j]+num[k];
				 if(sum==0){
					 ArrayList<Integer> sol=new ArrayList<Integer>();
					 sol.add(num[i]);
					 sol.add(num[j]);
					 sol.add(num[k]);
					 res.add(sol);
					 while(j+1<k&&num[j]==num[j+1])
						 j++;
					 j++;
					 while(k-1>j&&num[k]==num[k-1])
						 k--;
					 k--;
				 }
				 else if(sum>0)
					 k--;
				 else
					 j++;
			 }
			 while(i+1<num.length-2&&num[i]==num[i+1])
				 i++;
		 }
		 return res;
	 }
	 
	 public int maxArea(int[] height) {
		 if(height.length<2)
			 return 0;
		 int i=0;
		 int j=height.length-1;
		 int max=Integer.MIN_VALUE;
		 while(i<j){
			 int area=Math.min(height[i], height[j])*(j-i);
			 if(area>max)
				 max=area;
			 if(height[i]<height[j])
				 i++;
			 else
				 j--;
		 }
		 return max;
	 }
	 
	 public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		 if(l1==null||l2==null)
			 return l1==null?l2:l1;
		 ListNode dummy=new ListNode(0);
		 ListNode pre=dummy;
		 while(l1!=null&&l2!=null){
			 if(l1.val<l2.val){
				 pre.next=l1;
				 l1=l1.next;
			 }
			 else{
				 pre.next=l2;
				 l2=l2.next;
			 }
			 pre=pre.next;
		 }
		 if(l1!=null)
			 pre.next=l1;
		 if(l2!=null)
			 pre.next=l2;
		 return dummy.next;
	 }
	 
	 public boolean hasCycle(ListNode head) {
		 if(head==null)
			 return false;
		 ListNode slow=head;
		 ListNode fast=head;
		 
		 while(fast!=null&&fast.next!=null){
			 slow=slow.next;
			 fast=fast.next.next;
			 if(slow==fast)
				 break;
		 }
		 if(fast==null||fast.next==null)
			 return false;
		 return true;
	 }
	 
	 public ListNode detectCycle(ListNode head) {
		 if(head==null)
			 return null;
		 ListNode slow=head;
		 ListNode fast=head;
		 
		 while(fast!=null&&fast.next!=null){
			 slow=slow.next;
			 fast=fast.next.next;
			 if(slow==fast)
				 break;
		 }
		 if(fast==null||fast.next==null)
			 return null;
		 
		 slow=head;
		 
		 while(slow!=fast){
			 slow=slow.next;
			 fast=fast.next;
		 }
		 return slow;
		 
	 }
	 
	 public int candy(int[] ratings) {
		 int n=ratings.length;
		 int[] left=new int[n];
		 int[] right=new int[n];
		 
		 Arrays.fill(left, 1);
		 Arrays.fill(right, 1);
		 
		 for(int i=1;i<n;i++){
			 if(ratings[i]>ratings[i-1])
				 left[i]=left[i-1]+1;
		 }
		 
		 for(int i=n-2;i>=0;i--){
			 if(ratings[i]>ratings[i+1])
				 right[i]=right[i+1]+1;
		 }
		 int sum=0;
		 
		 for(int i=0;i<n;i++){
			 sum+=Math.max(left[i], right[i]);
		 }
		 return sum;
	 }
	 
	 public static int candySpaceOp(int[] ratings) {
		 int n=ratings.length;
		 int candies[]=new int[n];
		 Arrays.fill(candies, 1);
		 for(int i=1;i<n;i++){
			 if(ratings[i]>ratings[i-1])
				 candies[i]=candies[i-1]+1;
		 }
		 
		 int sum=candies[n-1];
		 for(int i=n-2;i>=0;i--){
			 if(ratings[i]>ratings[i+1]&&candies[i]<=candies[i+1])
				 candies[i]=candies[i+1]+1;
			 sum+=candies[i];
		 }
		 return sum;
	 }
	 
	 
	 public TreeNode buildTree(int[] inorder, int[] postorder) {
		 int n=inorder.length;
		 if(n==0)
			 return null;
		 return buildTreeUtil(inorder,0,n-1, postorder, 0,n-1);
	 }
	 
	 public TreeNode buildTreeUtil(int[] inorder, int beg1, int end1, int[] postorder, int beg2, int end2){
		 if(beg1>end1)
			 return null;
		 TreeNode root=new TreeNode(postorder[end2]);
		 int index=-1;
		 for(int i=beg1;i<=end1;i++){
			 if(inorder[i]==root.val){
				 index=i;
				 break;
			 }
		 }
		 
		 root.left=buildTreeUtil(inorder, beg1, index-1, postorder, beg2, beg2+index-beg1-1);
		 root.right=buildTreeUtil(inorder,index+1, end1, postorder,beg2+index-beg1,end2-1);
		 
		 return root;
	 }
	 
	 public int maxDepth(TreeNode root) {
		 if(root==null)
			 return 0;
		 int left=maxDepth(root.left);
		 int right=maxDepth(root.right);
		 return left>right?left+1:right+1;
	 }
	 
	 public int minDepth(TreeNode root) {
		 if(root==null)
			 return 0;
		 int left=minDepth(root.left);
		 int right=minDepth(root.right);
		 if(left==0)
			 return right+1;
		 else if(right==0)
			 return left+1;
		 return 
				 left<right?left+1:right+1;
		 
	 }
	 
	 
	 public static ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
		 ArrayList<ArrayList<Integer>> res=new ArrayList<ArrayList<Integer>>();
		 if(root==null)
			 return res;
		 Queue<TreeNode> que=new LinkedList<TreeNode>();
		 int curlevel=0;
		 int nextlevel=0;
		 que.add(root);
		 curlevel++;
		 ArrayList<Integer> level=new ArrayList<Integer>();
		 while(!que.isEmpty()){
			 TreeNode top=que.poll();
			 level.add(top.val);
			 curlevel--;
			 if(top.left!=null){
				 que.add(top.left);
				 nextlevel++;
			 }
			 if(top.right!=null){
				 que.add(top.right);
				 nextlevel++;
			 }
			 
			 if(curlevel==0){
				 res.add(level);
				 level=new ArrayList<Integer>();
				 curlevel=nextlevel;
				 nextlevel=0;
			 }
			 
		 }
		 return res;
	 }
	 
	 
	 public TreeNode sortedArrayToBST(int[] num) {
		 if(num.length==0)
			 return null;
		 return sortedArrayToBSTUtil(num, 0, num.length-1);
	 }
	 
	 public TreeNode sortedArrayToBSTUtil(int[]num, int beg, int end){
		 if(beg>end)
			 return null;
		 TreeNode root=new TreeNode(num[(beg+end)/2]);
		 root.left=sortedArrayToBSTUtil(num, beg, (beg+end)/2-1);
		 root.right=sortedArrayToBSTUtil(num, (beg+end)/2+1,end);
		 
		 return root;
	 }
	 
	 public ArrayList<Integer> inorderTraversal(TreeNode root) {
		 ArrayList<Integer> res=new ArrayList<Integer>();
		 if(root==null)
			 return res;
		 
		 Stack<TreeNode> stk=new Stack<TreeNode>();
		 TreeNode cur=root;
		 while(cur!=null){
			 stk.push(cur);
			 cur=cur.left;
		 }
		 
		 while(!stk.isEmpty()){
			 TreeNode top=stk.pop();
			 res.add(top.val);
			 if(top.right!=null){
				 top=top.right;
				 while(top!=null){
					 stk.push(top);
					 top=top.left;
				 }
			 }
		 }
		 return res;
	 }
	 
	 public ArrayList<String> generateParenthesis(int n) {
		 ArrayList<String> res=new ArrayList<String>();
		 if(n<=0)
			 return res;
		 String sol="";
		 generateParenthesisUtil(0,0,n,sol,res);
		 return res;
	 }
	 
	 
	 public void generateParenthesisUtil(int left, int right, int n,String sol,ArrayList<String> res){
		 if(left==n&&left==right)
			 res.add(sol);
		 if(left<n)
			 generateParenthesisUtil(left+1,right,n,sol+"(",res);
		 if(right<left)
			 generateParenthesisUtil(left,right+1,n,sol+")",res);
		 
	 }
	 
//	 f(x)=max(x, f(N-x)+1)
	 public static int maxTimesEggs(int n){
		 int[] dp=new int[n+1];
		 dp[0]=0;
		 dp[1]=1;
		 for(int i=2;i<=n;i++){
			 int max=Math.max(dp[n-i]+1,i);
			 if(dp[i]==0||dp[i]>max)
				 dp[i]=max;
		 }
		 return dp[n];
	 }
	 
	 // n eggs, k floors
	 public static int maxTimesEggs(int egg, int floor){
		 int[][] dp=new int[egg+1][floor+1];
		 		
		 for(int i=1;i<=egg;i++){
			 dp[i][0]=0;
			 dp[i][1]=1;
		 }
		 
		 for(int i=1;i<=floor;i++){
//			 dp[0][i]=0;
			 dp[1][i]=i;
		 }
		 
		 for(int n=2;n<=egg;n++){
			 for(int k=2;k<=floor;k++){
				 dp[n][k]=floor;
				 for(int x=1;x<=k;x++){
					 int t=Math.max(dp[n-1][x-1], dp[n][k-x])+1;
					 if(t<dp[n][k])
						 dp[n][k]=t;
				 }
			 }
		 }
		
		 
		 return dp[egg][floor];
		 
	 }
	 
	 Comparator<Interval> cmp=new Comparator<Interval>(){

		@Override
		public int compare(Interval o1, Interval o2) {
			// TODO Auto-generated method stub
			return o1.start-o2.start;
		}
		 
	 };
	 public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
		 if(intervals.size()<2)
			 return intervals;
		 ArrayList<Interval> res=new ArrayList<Interval>();
		 Collections.sort(intervals,cmp);
		 res.add(intervals.get(0));
		 for(int i=1;i<intervals.size();i++){
			 Interval interval=intervals.get(i);
			 Interval last=res.get(res.size()-1);
			 if(interval.start>last.end)
				 res.add(interval);
			 else
				 last.end=Math.max(interval.end, last.end);
		 }
		 return res;
	 }
	 
	 public void merge(int A[], int m, int B[], int n) {
		 int k=m+n-1;
		 int i=m-1;
		 int j=n-1;
		 
		 while(i>=0&&j>=0){
			 if(A[i]>B[j])
				 A[k--]=A[i--];
			 else
				 A[k--]=B[j--];
		 }
		 while(j>=0)
			 A[k--]=B[j--];
	 }
	 
	 public static ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
		 if(intervals.size()==0){
			 intervals.add(newInterval);
			 return intervals;
		 }
		 ArrayList<Interval> res=new ArrayList<Interval>();
		 boolean inserted=false;
		 
		 for(int i=0;i<intervals.size();i++){
			 Interval interval=intervals.get(i);
			 if(interval.start<newInterval.start){
				 insertInterval(res,interval);
			 }
			 else{
				 insertInterval(res,newInterval);
				 inserted=true;
				 insertInterval(res,interval);
			 }
		 }
		 if(!inserted)
			insertInterval(res,newInterval);
		 return res;		 
			 
	 }
	 public static void insertInterval(ArrayList<Interval> intervals, Interval newInterval){
		 if(intervals.size()==0){
			 intervals.add(newInterval);
			 return;
		 }
		 Interval interval=intervals.get(intervals.size()-1);
		 if(interval.end<newInterval.start)
			 intervals.add(newInterval);
		 else
			 interval.end=Math.max(interval.end, newInterval.end);
	 }
	 
	 public static ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
		 ArrayList<ArrayList<Integer>> res=new ArrayList<ArrayList<Integer>>();
		 if(num.length==0)
			 return res;
		 ArrayList<Integer> sol=new ArrayList<Integer>();
		 boolean[] used=new boolean[num.length];
		 Arrays.sort(num);
		 permuteUniqueUtil(0,num.length,num, used,sol,res);
		 return res;
	 }
	 
	 public static void permuteUniqueUtil(int depth, int max, int[] num,boolean[] used,
			 ArrayList<Integer> sol,ArrayList<ArrayList<Integer>> res){
		 if(depth==max){
			 ArrayList<Integer> out=new ArrayList<Integer>(sol);
			 res.add(out);
			 
		 }
		 else{
			 for(int i=0;i<num.length;i++){
				 if(!used[i]){
					 if(i!=0&&!used[i-1]&&num[i]==num[i-1])
						 continue;
					 used[i]=true;
					 sol.add(num[i]);
					 permuteUniqueUtil(depth+1,max, num,used, sol, res);
					 sol.remove(sol.size()-1);
					 used[i]=false;
				 }
			 }
		 }
		 
	 }
	 
	 public ArrayList<Integer> preorderTraversal(TreeNode root) {
		 ArrayList<Integer> res=new  ArrayList<Integer>();
		 if(root==null)
			 return res;
		 Stack<TreeNode> stk=new Stack<TreeNode>();
		 stk.push(root);
		 while(!stk.isEmpty()){
			 TreeNode top=stk.pop();
			 res.add(top.val);
			 if(top.right!=null)
				 stk.push(top.right);
			 if(top.left!=null)
				 stk.push(top.left);
		 }
		 return res;
	 }
	 
	 public ArrayList<Integer> postorderTraversal(TreeNode root) {
		 ArrayList<Integer> res=new ArrayList<Integer>();
		 if(root==null)
			 return res;
		 Stack<TreeNode> stk1=new Stack<TreeNode>();
		 Stack<TreeNode> stk2=new Stack<TreeNode>();
		 stk1.push(root);
		 while(!stk1.isEmpty()){
			 TreeNode top=stk1.pop();
			 stk2.push(top);
			 
			 if(top.left!=null)
				 stk1.push(top.left);
			 if(top.right!=null)
				 stk1.push(top.right);
		 }
		 while(!stk2.isEmpty())
			 res.add(stk2.pop().val);
		 return res;
	 }
	 
	 public ArrayList<Integer> postorderTraversal2(TreeNode root) {
		 ArrayList<Integer> res=new ArrayList<Integer>();
		 if(root==null)
			 return res;
		 Stack<TreeNode> stk=new Stack<TreeNode>();
		 TreeNode cur=root;
		 TreeNode pre=null;
		 while(cur!=null){
			 stk.push(cur);
			 cur=cur.left;
		 }
		 
		 while(!stk.isEmpty()){
			 TreeNode top=stk.peek();
			 if(top.right!=null&&pre!=top.right){
				 top=top.right;
				 while(top!=null){
					 stk.push(top);
					 top=top.left;
				 }
			 }
			 else{
				 top=stk.pop();
				 res.add(top.val);
				 pre=top;
			 }
		 }
		 return res;
	 }
	 
	 public int reverse(int x) {
		 boolean neg=false;
		 boolean overflow=false;
		 if(x<0){
			 x=-x;
			 neg=true;
		 }
		 int res=0;
		 while(x>0){
			 int digit=x%10;
			 if((Integer.MAX_VALUE-digit)/10<res){
				 overflow=true;
				 break;
			 }
			 x=x/10;
			 res=res*10+digit;
		 }
		 if(overflow){
			 if(neg)
				 res=-res;
			 return res; 
		 }
		 else{
			 if(neg)
				 return -res;
			 else
				 return res;
		 }
		 
	 }
	 
	 public int maxProfit(int[] prices) {
		 if(prices.length<2)
			 return 0;
		 int min=prices[0];
		 int max=0;
		 for(int i=1;i<prices.length;i++){
			 if(prices[i]-min>max)
				 max=prices[i]-min;
			 if(prices[i]<min)
				 min=prices[i];
		 }
		 return max;
	 }
	 
	 
	 public int maxProfit2(int[] prices) {
		 if(prices.length<2)
			 return 0;
		 int max=0;
		 
		 for(int i=1;i<prices.length;i++){
			 if(prices[i]-prices[i-1]>0)
				 max+=prices[i]-prices[i-1];
		 }
		 return max;
	 }
	 
	 public int maxProfit3(int[] prices) {
		 if(prices.length<2)
			 return 0;
		 int n=prices.length;
		 int[] left=new int[n];
		 int lowest=prices[0];
		 left[0]=0;
		 int max=0;
		 for(int i=1;i<n;i++){
			 if(prices[i]<lowest)
				 lowest=prices[i];
			 max=Math.max(prices[i]-lowest, max);
			 left[i]=max;
		 }
		 
		 int[] right=new int[n];
		 right[n-1]=0;
		 max=0;
		 int highest=prices[n-1];
		 for(int i=n-2;i>=0;i--){
			 if(prices[i]>highest)
				 highest=prices[i];
			 max=Math.max(highest-prices[i], max);
			 right[i]=max;
		 }
		 
		 max=0;
		 for(int i=0;i<n;i++){
			 if(left[i]+right[i]>max)
				 max=left[i]+right[i];
		 }
		 return max;
	 }
	 
	 public int minPathSum(int[][] grid) {
		 int n=grid.length;
		 int m=grid[0].length;
		 int[][] dp=new int[n][m];
		 dp[0][0]=grid[0][0];
		 for(int i=1;i<n;i++)
			 dp[i][0]=dp[i-1][0]+grid[i][0];
		 
		 for(int j=1;j<m;j++)
			 dp[0][j]=dp[0][j-1]+grid[0][j];
		 
		 for(int i=1;i<n;i++){
			 for(int j=1;j<m;j++){
				 dp[i][j]=Math.min(dp[i-1][j], dp[i][j-1])+grid[i][j];
			 }
		 }
		 return dp[n-1][m-1];
	 }
	 
	 public int singleNumber(int[] A) {
		 int res=A[0];
		 for(int i=1;i<A.length;i++)
			 res^=A[i];
		 return res;
	 }
	 
	 
	 public static ListNode removeNthFromEnd(ListNode head, int n) {
		 if(head==null)
			 return null;
		 ListNode dummy=new ListNode(0);
		 dummy.next=head;
		
		 ListNode slow=head;
		 ListNode fast=head;
		
		 for(int i=0;i<n-1;i++)
			 fast=fast.next;
		 
		 ListNode pre=dummy;
		 while(fast.next!=null){
			 fast=fast.next;
			 pre=slow;
			 slow=slow.next;			 
		 }
		 pre.next=slow.next;
		 return dummy.next;
		 
	 }
	 
	 public TreeNode buildTree2(int[] preorder, int[] inorder) {
		 int n=preorder.length;
		 if(n==0)
			 return null;
		 
		 return buildTree2Util(preorder, 0,n-1, inorder, 0,n-1);
	 }
	 
	 public TreeNode buildTree2Util(int[] preorder, int beg1, int end1, int[] inorder, int beg2, int end2){
		 if(beg2>end2)
			 return null;
		 TreeNode root=new TreeNode(preorder[beg1]);
		 int index=-1;
		 
		 for(int i=beg2;i<=end2;i++){
			 if(inorder[i]==root.val){
				 index=i;
				 break;
			 }
		 }
		 int length=index-beg2;
		 
		 root.left=buildTree2Util(preorder, beg1+1,beg1+length, inorder, beg2,index-1);
		 root.right=buildTree2Util(preorder, beg1+length+1, end1, inorder, index+1, end2);
		 return root;
	 }
	 
	 public int firstMissingPositive(int[] A) {
		 for(int i=0;i<A.length;i++){
			 while(A[i]!=i+1){
				 if(A[i]<=0||A[i]>A.length||A[i]==A[A[i]-1])
					 break;
				 int t=A[i];
				 A[i]=A[A[i]-1];
				 A[t-1]=t;
			 }
		 }
		 
		 for(int i=0;i<A.length;i++){
			 if(A[i]!=i+1)
				 return i+1;
		 }
		 return A.length+1;
			 
	 }
	 
	 public int firstMissingPositive2(int[] A) {
		 int n=A.length;
		 boolean[] aux=new boolean[n];
		 
		 for(int i=0;i<n;i++){
			 if(A[i]>0&&A[i]<=n)
				 aux[A[i]-1]=true;
		 }
		 
		 for(int i=0;i<n;i++){
			 if(!aux[i])
				 return i+1;
		 }
		 return n+1;
	 }
	 
	 
	 public ListNode insertionSortList(ListNode head) {
		 if(head==null||head.next==null)
			 return head;
		 ListNode dummy=new ListNode(0);
		 dummy.next=head;
		 
		 ListNode cur=head.next;
		 ListNode last=head;
		 
		 while(cur!=null){
			 ListNode pre=dummy;
			 ListNode it=dummy.next;
			 
			 while(it!=cur&&it.val<cur.val){
				 pre=it;
				 it=it.next;
			 }
			 if(it==cur)
				 last=cur;
			 else{
				 last.next=cur.next;
				 pre.next=cur;
				 cur.next=it;
			 }
			 cur=last.next;
		 }
		 return dummy.next;
		
	 }
	 public int lengthOfLongestSubstring(String s) {
		 if(s.length()<2)
			 return s.length();
		 
		 HashMap<Character,Integer> map=new HashMap<Character, Integer>();
		 int maxLen=0;
		 int start=0;
		 for(int i=0;i<s.length();i++){
			 char c=s.charAt(i);
			 if(!map.containsKey(c))
				 map.put(c, i);
			 else{
				int length=i-start;
				maxLen=Math.max(length, maxLen);
				int dup=map.get(c);
				for(int j=dup;j>=start;j--){
					map.remove(s.charAt(j));
				}
				map.put(c, i);
				start=dup+1;
			 }
		 }
		 int length=s.length()-start;
		 return maxLen>length?maxLen:length;
	 }
	 
	 public int evalRPN(String[] tokens) {
		 if(tokens.length==0)
			 return 0;
		 
		 Stack<Integer> stk=new Stack<Integer>();
		 
		 for(int i=0;i<tokens.length;i++){
			 String s=tokens[i];
			 if(!s.equals("+")&&!s.equals("-")&&!s.equals("*")&&!s.equals("/"))
				 stk.push(Integer.parseInt(s));
			 else{
				 int num1=stk.pop();
				 int num2=stk.pop();
				 if(s.equals("+"))
					 stk.push(num1+num2);
				 else if(s.equals("-"))
					 stk.push(num2-num1);
				 else if(s.equals("*"))
					 stk.push(num1*num2);
				 else stk.push(num2/num1);
			 }
		 }
		 return stk.pop();
	 }
	 
	 public int getHeight(TreeNode root){
		 if(root==null)
			 return 0;
		 int left=getHeight(root.left);
		 int right=getHeight(root.right);
		 return right>left?right+1:left+1;
	 }
	 public boolean isBalanced(TreeNode root) {
		 if(root==null)
			 return true;
		 
		 int left=getHeight(root.left);
		 int right=getHeight(root.right);
		 if(Math.abs(left-right)>1)
			 return false;
		 return isBalanced(root.left)&&isBalanced(root.right);
	 }
	 
	 public TreeNode sortedListToBST(ListNode head) {
		 if(head==null)
			 return null;
		 
//		 ListNode slow=head;
//		 ListNode fast=head;
//		 while(fast!=null&&fast.next!=null){			
//			 fast=fast.next.next;
//			 if(fast==null)
//				 break;
//			 slow=slow.next;
//		 }
//		 ListNode head1=slow.next;
//		 slow.next=null;
		 ListNode cur=head;
		 int len=0;
		 while(cur!=null){
			 len++;
			 cur=cur.next;
		 }
		 return sortedListToBSTUtil(head,0, len-1);
	 }
	 
	 public TreeNode sortedListToBSTUtil(ListNode head, int beg, int end){
		 if(head==null||beg>end)
			 return null;
		 int mid=beg+(end-beg)/2;
		 ListNode cur=head;
		 for(int i=beg;i<mid;i++)
			 cur=cur.next;
		 
		 TreeNode root=new TreeNode(cur.val);
		 root.left=sortedListToBSTUtil(head,beg,mid-1);
		 root.right=sortedListToBSTUtil(cur.next,mid+1,end);
		 return root;
	 }
	 
	 public TreeNode sortedListToBST2(ListNode head) {
		 if(head==null)
			 return null;
		 
		 ListNode slow=head;
		 ListNode fast=head;
		 ListNode pre=null;
		 while(fast!=null&&fast.next!=null){			
			 fast=fast.next.next;
			 if(fast==null)
				 break;
			 pre=slow;
			 slow=slow.next;
		 }
		 ListNode head1=slow.next;
		 
		 TreeNode root=new TreeNode(slow.val);
		 root.right=sortedListToBST(head1);
		 if(pre==null){
			 return root;
		 }
		 else{
			 pre.next=null;
			 root.left=sortedListToBST(head);
		 }
		 return root;
	 }
	 
	 public static String longestPalindrome(String s) {
		 if(s.length()<2)
			 return s;
		 int beg=0;
		 int end=0;
		 int maxLen=0;
		 
		 for(int i=1;i<s.length();i++){
			 int j=i-1;
			 int k=i;
			 while(k<s.length()&&j>=0&&s.charAt(k)==s.charAt(j)){
				 j--;
				 k++;
			 }
			 int length=k-j-1;
			 if(length>maxLen){
				 maxLen=length;
				 beg=j+1;
				 end=k-1;
			 }
			 
			 j=i-1;
			 k=i+1;
			 
			 while(k<s.length()&&j>=0&&s.charAt(k)==s.charAt(j)){
				 k++;
				 j--;
			 }
			 length=k-j-1;
			 if(length>maxLen){
				 maxLen=length;
				 beg=j+1;
				 end=k-1;
			 }
		 }
		 
		 return s.substring(beg,end+1);
	 }
	 
	 public static String minWindow2(String S, String T) {
		 if(S.length()==0)
			 return "";
		 int count=T.length();
		 int[] needToFind=new int[256];
		 for(int i=0;i<T.length();i++){
			 needToFind[T.charAt(i)]++;
		 }
		 int start=0;
		 int windowstart=0;
		 int end=0;
		 int min=S.length();
		 int[] hasFound=new int[256];
		 for(int i=0;i<S.length();i++){
			 char c=S.charAt(i);
			 if(needToFind[c]==0)
				 continue;
			 hasFound[c]++;
			 if(hasFound[c]<=needToFind[c])
				 count--;
			 if(count==0){
				 while(needToFind[S.charAt(start)]==0||hasFound[S.charAt(start)]>needToFind[S.charAt(start)]){
					 if(hasFound[S.charAt(start)]>needToFind[S.charAt(start)])
						 hasFound[S.charAt(start)]--;
					 start++;
				 }
				 if(i-start+1<=min){
					 min=i-start+1;
					 windowstart=start;
					 end=i;
				 }
			 }
		 }
		 
		 if(count==0)
			 return S.substring(windowstart,end+1);
		 else
			 return "";
	 }
	 
	 public void flatten(TreeNode root) {
		 if(root==null)
			 return;
		 TreeNode right=root.right;
		 flatten(root.left);
		 root.right=root.left;
		 root.left=null;
		 TreeNode cur=root;
		  
		 while(cur.right!=null)
			 cur=cur.right;
		 cur.right=right;
		 flatten(right);
	 }
	 
	 public int trap(int[] A) {
		 if(A.length<2)
			 return 0;
		 int n=A.length;
		 int[] left=new int[n];
		 int leftmost=A[0];
		 for(int i=0;i<n;i++){
			 left[i]=leftmost;
			 if(A[i]>leftmost)
				 leftmost=A[i];
		 }
		 
		 int[] right=new int[n];
		 int rightmost=A[n-1];
		 for(int i=n-1;i>=0;i--){
			 right[i]=rightmost;
			 if(A[i]>rightmost)
				 rightmost=A[i];
		 }
		 
		 int sum=0;
		 for(int i=0;i<n;i++){
			 int trap=Math.min(left[i], right[i])-A[i];
			 if(trap>0)
				 sum+=trap;
		 }
		 return sum;
	 }
	 
	 public boolean isSymmetric(TreeNode root) {
		 if(root==null)
			 return true;
		 
		 return isSymmetric(root.left,root.right);
	 }
	 
	 public boolean isSymmetric(TreeNode left, TreeNode right){
		 if(left==null&&right==null)
			 return true;
		 if(left==null||right==null)
			 return false;
		 if(left.val!=right.val)
			 return false;
		 return isSymmetric(left.left,right.right)&&isSymmetric(left.right,right.left);
	 }
	 
	 public static String countAndSay(int n) {
		 if(n<=0)
			 return "";
		 String s="1";
		 
		 
		 for(int i=0;i<n;i++){
			 String res="";
			 char c=s.charAt(0);
			 int count=1;
			 for(int j=1;j<s.length();j++){
				 if(s.charAt(j)==c)
					 count++;
				 else{
					 res=res+count+c;
					 c=s.charAt(j);
					 count=1;
				 }
			 }
			 s=res+count+c;
		 }
		 return s;
	 }
	 
	 public String addBinary(String a, String b) {
		 if(a.length()==0||b.length()==0)
			 return a.length()==0?b:a;
		 
		 String res="";
		 int i=a.length()-1;
		 int j=b.length()-1;
		 int carry=0;
		 while(i>=0&&j>=0){
			 int sum=a.charAt(i)-'0'+b.charAt(j)-'0'+carry;
			 carry=sum/2;
			 sum=sum%2;
			 res=sum+res;
			 i--;
			 j--;
		 }
		 
		 while(i>=0){
			 int sum=a.charAt(i)-'0'+carry;
			 carry=sum/2;
			 sum=sum%2;
			 res=sum+res;
			 i--;
		 }
		 while(j>=0){
			 int sum=b.charAt(j)-'0'+carry;
			 carry=sum/2;
			 sum=sum%2;
			 res=sum+res;
			 j--;
		 }
		 if(carry==1)
			 return "1"+res;
		 else
			 return res;
	 }
	 
	 public boolean hasPathSum(TreeNode root, int sum) {
		 if(root==null)
			 return false;
		 int cursum=0;
		 return hasPathSum(root,cursum,sum);
	 }
	 
	 public boolean hasPathSum(TreeNode root, int cursum, int sum) {
		 if(root==null)
			 return false;
		 cursum+=root.val;
		 if(cursum==sum&&root.left==null&&root.right==null)
			 return true;
		 return hasPathSum(root.left,cursum,sum)||hasPathSum(root.right,cursum,sum);
	 }
	 
	 
	 public ArrayList<String> letterCombinations(String digits) {
		 ArrayList<String> res=new ArrayList<String>();
		 letterCombinations(0, digits,"",res);
		 return res;
	 }
	 
	 public void letterCombinations(int dep, String digits, String sol, ArrayList<String> res){
		 if(dep==digits.length()){
			 res.add(sol);
			 return;
		 }
		 
		 String s=getString(digits.charAt(dep)-'0');
		 for(int i=0;i<s.length();i++){
			 letterCombinations(dep+1,digits,sol+s.charAt(i),res);
		 }
	 }
	 
	 public String getString(int pos){
		 String[] strs={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
		 return strs[pos];
	 }
	 
	 public int atoi(String str) {
		 if(str.length()==0)
			 return 0;
		 str=str.trim();
		 boolean neg=false;
		 boolean overflow=false;
		 int i=0;
		 if(str.charAt(i)=='-'){
			 neg=true;
			 i++;
		 }
		 else if(str.charAt(i)=='+')
			 i++;
		 
		 int res=0;
		 while(i<str.length()){
			 int digit=str.charAt(i)-'0';
			 if(digit>=0&&digit<=9){
				 if((Integer.MAX_VALUE-digit)/10<res){
					 overflow=true;
					 break;
				 }
				 else{
					 res=res*10+digit;
					 i++;
				 }
				 
			 }
			 else
				 break;			 
		 }
		 
		 if(overflow){
			 if(neg)
				 return Integer.MIN_VALUE;
			 else
				 return Integer.MAX_VALUE;
		 }
		 else{
			 if(neg)
				 return -res;
			 else
				 return res;
		 }
	 }
	 
	 public static boolean isPalindrome(int x) {
		 if(x<0)
			 return false;
		 int base=1;
		 int t=x;
		 while(t>=10){
			 base*=10;
			 t/=10;
		 }
		 
//		 System.out.println(base);
		 while(x>0){
			 int first=x/base;
			 int last=x%10;
			 if(last!=first)
				 return false;
			 x=(x%base)/10;
			 base/=100;
		 }
		 return true;
	 }
	 
	 public boolean isSameTree(TreeNode p, TreeNode q) {
		 if(p==null&&q==null)
			 return true;
		 if(p==null||q==null)
			 return false;
		 if(p.val!=q.val)
			 return false;
		 return isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);
	 }
	 
	 public int searchInsert(int[] A, int target) {
		 int beg=0;
		 int end=A.length-1;
		 while(beg<=end){
			 int mid=beg+(end-beg)/2;
			 if(A[mid]==target)
				 return mid;
			 else if(A[mid]>target)
				 end=mid-1;
			 else
				 beg=mid+1;
		 }
		 return beg;
	 }
	 
	 
	 public boolean isValidBST(TreeNode root) {
		 if(root==null)
			 return true;
		 return isValidBST(root, Integer.MIN_VALUE,Integer.MAX_VALUE);
	 }
	 
	 public boolean isValidBST(TreeNode root, int leftmost, int rightmost){
		 if(root==null)
			 return true;
		 if(root.val<=leftmost||root.val>=rightmost)
			 return false;
		 return isValidBST(root.left,leftmost,root.val)&&
				 isValidBST(root.right,root.val,rightmost);
	 }
	 
	 public int sumNumbers(TreeNode root) {
		 if(root==null)
			 return 0;
		 return sumNumbers(root,0);
	 }
	 public int sumNumbers(TreeNode root, int sum){
		 if(root==null)
			 return 0;
		 sum=sum*10+root.val;
		 if(root.left==null&&root.right==null)
			 return sum;
		 else 
			 return sumNumbers(root.left,sum)+sumNumbers(root.right,sum);
	 }
	 
	 public static int findMaxRepeating(int[] A, int N){
		 for(int i=0;i<A.length;i++){
			 A[A[i]%N]+=N;
		 }
		 
		 System.out.println(Arrays.toString(A));
		 int max=A[0];
		 int res=0;
		 
		 for(int i=1;i<A.length;i++){
			 if(A[i]>max){
				 max=A[i];
				 res=i;
			 }
		 }
		 
		 for(int i=0;i<A.length;i++){
			 A[i]=A[i]%N;
		 }
		 return res;
	 }
	 
	 
	 public static void findIndex(int[] A, int target){
		 if(A.length==0)
			 return;
		 findIndex(A,0,A.length-1,target);
	 }
	 
	 public static void findIndex(int[] A, int beg, int end, int target){
		 if(beg>end)
			 return;
		 int mid=beg+(end-beg)/2;
		 if(A[mid]==target)
			 System.out.print(mid+1+" ");
		 else{
			 findIndex(A, beg,mid-1,target);
			 findIndex(A, mid+1, end,target);
		 }
	 }
	 
	 public static ListNode sortList(ListNode head) {
	        if(head==null||head.next==null)
	        	return head;
	        ListNode slow=head;
	        ListNode fast=head;
	        while(fast!=null&&fast.next!=null){
	        	fast=fast.next.next;
	        	if(fast==null)
	        		break;
	        	slow=slow.next;
	        }
	        System.out.println(slow.val);
	        
	        ListNode head2=slow.next;
	        slow.next=null;
	        
	        ListNode h1=sortList(head);
	        ListNode h2=sortList(head2);
	        ListNode res=mergeList(h1,h2);
	        return res;
	    }
	 
	 public static ListNode mergeList(ListNode head1, ListNode head2){
		 if(head1==null||head2==null)
			 return head1==null?head2:head1;
		 ListNode dummy=new ListNode(0);
		 ListNode pre=dummy;
		 while(head1!=null&&head2!=null){
			 if(head1.val<head2.val){
				 pre.next=head1;
				 head1=head1.next;
			 }
			 else{
				 pre.next=head2;
				 head2=head2.next;
			 }
			 pre=pre.next;
		 }
		 if(head1!=null)
			 pre.next=head1;
		 if(head2!=null)
			 pre.next=head2;
		 return dummy.next;
	 }
	 
	 
	 public boolean isPalindrome(String s) {
		 if(s.length()<2)
			 return true;
		 s=s.toLowerCase();
		 int beg=0;
		 int end=s.length()-1;
		 
		 while(beg<end){
			 while(beg<end&&!Character.isLetterOrDigit(s.charAt(beg)))
				 beg++;
			 while(end>beg&&!Character.isLetterOrDigit(s.charAt(end)))
				 end--;
			 if(s.charAt(beg)!=s.charAt(end))
				 return false;
			 beg++;
			 end--;
		 }
		 return true;
	 }
	 
	  public int maxPathSum(TreeNode root) {
		  if(root==null)
			  return 0;
		  int[] max={Integer.MIN_VALUE};
		  maxPathSumUtil(root,max);
		  return max[0];
	  }
	  
	  public int maxPathSumUtil(TreeNode root, int[] max){
		  if(root==null)
			  return 0;
		  int left=maxPathSumUtil(root.left,max);
		  int right=maxPathSumUtil(root.right,max);
		  int sum=root.val;
		  if(left>0)
			  sum+=left;
		  if(right>0)
			  sum+=right;
		  max[0]=Math.max(max[0], sum);
		  return Math.max(left, right)>0?Math.max(left, right)+root.val:root.val;
	  }
	  
	  public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
		  int n=triangle.size();
		  int len=triangle.get(n-1).size();
		  
		  int[][] dp=new int[n][len];
		  dp[0][0]=triangle.get(0).get(0);
		  
		  for(int i=1;i<n;i++){
			  dp[i][0]=dp[i-1][0]+triangle.get(i).get(0);
		  }
		  
		  for(int i=1;i<n;i++){
			  for(int j=1;j<len;j++){
				  if(j==triangle.get(i).size()-1){
					  dp[i][j]=dp[i-1][j-1]+triangle.get(i).get(j);
				  }
				  else
					  dp[i][j]=Math.min(dp[i-1][j-1], dp[i-1][j])+triangle.get(i).get(j);
			  }
		  }
		  
		  int min=dp[n-1][0];
		  for(int i=1;i<len;i++){
			  if(dp[n-1][i]<min)
				  min=dp[n-1][i];
		  }
		  return min;
	  }
	  
	  public int minimumTotal2(ArrayList<ArrayList<Integer>> triangle) {
		  int size=triangle.size();
		  int n=triangle.get(size-1).size();
		  int[] dp=new int[n];
		  dp[0]=triangle.get(0).get(0);
		  for(int i=1;i<size;i++){
			  for(int j=triangle.get(i).size()-1;j>0;j--){
				  if(j==triangle.get(i).size()-1)
					  dp[j]=dp[j-1]+triangle.get(i).get(j);
				  else if(j==0)
					  dp[j]=dp[j]+triangle.get(i).get(j);
				  else
					  dp[j]=Math.min(dp[j], dp[j-1])+triangle.get(i).get(j);
			  }
		  }
		  
		  int min=dp[0];
		  for(int i=1;i<n;i++)
			  min=Math.min(dp[i], min);
		  return min;
	  }
	  
	  
	  public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
		  ArrayList<ArrayList<Integer>> res=new ArrayList<ArrayList<Integer>>();
		  if(root==null)
			  return res;
		  Queue<TreeNode> que=new LinkedList<TreeNode>();
		  int curlevel=0;
		  int nextlevel=0;
		  que.add(root);
		  curlevel++;
		  boolean l2r=false;
		  ArrayList<Integer> level=new ArrayList<Integer>();
		  while(!que.isEmpty()){
			  TreeNode top=que.remove();
			  curlevel--;
			  level.add(top.val);
			  if(top.left!=null){
				  que.add(top.left);
				  nextlevel++;
			  }
			  if(top.right!=null){
				  que.add(top.right);
				  nextlevel++;
			  }
			  if(curlevel==0){
				  if(l2r)
					  Collections.reverse(level);
				  res.add(level);
				  level=new ArrayList<Integer>();
				  curlevel=nextlevel;
				  nextlevel=0;
				  l2r=!l2r;
			  }
		  }
		  return res;
	  }
	  
	  public void rotate(int[][] matrix) {
		  int n=matrix.length;
		  if(n==0)
			  return;
		  for(int i=0;i<n;i++){
			  for(int j=0;j<n;j++){
				  int t=matrix[i][j];
				  matrix[i][j]=matrix[j][i];
				  matrix[j][i]=t;
			  }
		  }
		  
		  for(int i=0;i<n;i++){
			  int beg=0;
			  int end=n-1;
			  while(beg<end){
				  int t=matrix[i][beg];
				  matrix[i][beg]=matrix[i][end];
				  matrix[i][end]=t;
				  beg++;
				  end--;
			  }
		  }
	  }
	  
	  public void connect(TreeLinkNode root) {
		  if(root==null)
			  return;
		  if(root.left!=null)
			  root.left.next=root.right;
		  if(root.right!=null){
			  if(root.next!=null)
				  root.right.next=root.next.left;
			  else
				  root.right.next=null;
		  }
			  connect(root.left);
			  connect(root.right);
	  }
	 
	  
	  public void connect2(TreeLinkNode root) {
		  if(root==null)
			  return;
		  if(root.next!=null)
			  connect2(root.next);
		  if(root.left!=null){
			  if(root.right!=null){
				  root.left.next=root.right;
				  root.right.next=getNextRight(root);
			  }
			  else
				  root.left.next=getNextRight(root);
			  connect2(root.left);
		  }
		  else if(root.right!=null){
			  root.right.next=getNextRight(root);
			  connect2(root.right);
		  }
		  else 
			  connect2(getNextRight(root));
	  }
	  
	  public TreeLinkNode getNextRight(TreeLinkNode root){
		  if(root==null)
			  return  null;
		  
		  TreeLinkNode cur=root.next;
		  while(cur!=null){
			  if(cur.left!=null)
				  return cur.left;
			  else if(cur.right!=null)
				  return cur.right;
			  else
				  cur=cur.next;
		  }
		  return null;
	  }
	  
	  
	  public void connect2Que(TreeLinkNode root) {
		  if(root==null)
			  return;
		  Queue<TreeLinkNode> que=new LinkedList<TreeLinkNode>();
		  int curlevel=0;
		  int nextlevel=0;
		  que.add(root);
		  curlevel++;
		  while(!que.isEmpty()){
			  TreeLinkNode top=que.remove();
			  curlevel--;
			  if(top.left!=null){
				  que.add(top.left);
				  curlevel++;
			  }
			  if(top.right!=null){
				  que.add(top.right);
				  curlevel++;
			  }
			  if(curlevel==0){
				  top.next=null;
				  curlevel=nextlevel;
				  nextlevel=0;
			  }
			  else
				  top.next=que.peek();
		  }
	  }
	  
	  public ListNode mergeKLists(ArrayList<ListNode> lists) {
		  if(lists.size()==0)
			  return null;
		  while(lists.size()>1){
			  ListNode l1=lists.remove(0);
			  ListNode l2=lists.remove(0);
			  ListNode l=mergeLists(l1,l2);
			  lists.add(l);
		  }
		  return lists.get(0);
	  }
	  
	  public ListNode mergeLists(ListNode l1, ListNode l2){
		  if(l1==null||l2==null)
			  return l1==null?l2:l1;
		  ListNode dummy=new ListNode(0);
		  ListNode pre=dummy;
		  while(l1!=null&&l2!=null){
			  if(l1.val<l2.val){
				  pre.next=l1;
				  l1=l1.next;
			  }
			  else{
				  pre.next=l2;
				  l2=l2.next;
			  }
			  pre=pre.next;
		  }
		  if(l1!=null)
			  pre.next=l1;
		  if(l2!=null)
			  pre.next=l2;
		  
		  return dummy.next;
	  }
	  
	  public int lengthOfLastWord(String s) {
		  s=s.trim();
		  if(s.length()==0)
			  return 0;
		  int i=s.length()-1;
		  while(i>=0&&s.charAt(i)!=' ')
			  i--;
		  return s.length()-i;
	  }
	  
	  public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
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
						  if(!res.contains(sol))
							  res.add(sol);
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
	  
	  public String longestCommonPrefix(String[] strs) {
		  if(strs.length==0)
			  return "";
		  int minlen=Integer.MAX_VALUE;
		  int index=-1;
		  
		  for(int i=0;i<strs.length;i++){
			  if(strs[i].length()<minlen){
				  minlen=strs[i].length();
				  index=i;
			  }
		  }
		  String s=strs[index];
		  
		  for(int i=0;i<s.length();i++){
			 for(int j=0;j<strs.length;j++){
				 if(s.charAt(i)!=strs[j].charAt(i))
					 return s.substring(0,i);
			 }
		  }
		  return s;
	  }
	  
	  
	  public void reorderList(ListNode head) {
		  if(head==null||head.next==null)
			  return;
		  ListNode slow=head;
		  ListNode fast=head;
		  while(fast!=null&&fast.next!=null){
			  fast=fast.next.next;
			  if(fast==null)
				  break;
			  slow=slow.next;
		  }
		  
		  ListNode head2=slow.next;
		  slow.next=null;
		  ListNode node=reverseList(head2);
		  
		  while(head!=null&&node!=null){
			  ListNode next1=head.next;
			  ListNode next2=node.next;
			  head.next=node;
			  node.next=next1;
			  
			  head=next1;
			  node=next2;
		  }
	  }
	  
	  public static ListNode reverseList(ListNode head){
		  if(head==null||head.next==null)
			  return head;
		  
		  ListNode pre=null;
		  ListNode cur=head;
		  
		  while(cur!=null){
			  ListNode next=cur.next;
			  
			  cur.next=pre;
			  pre=cur;
			  cur=next;
		  }
		  
		  return pre;
	  }
	  
	  public ListNode partition(ListNode head, int x) {
		  if(head==null)
			  return null;
		  ListNode small=new ListNode(0);
		  ListNode pre1=small;
		  
		  ListNode big=new ListNode(0);
		  ListNode pre2=big;
		  ListNode cur=head;
		  while(cur!=null){
			  if(cur.val<x){
				  pre1.next=cur;
				  pre1=cur;
			  }
			  else{
				  pre2.next=cur;
				  pre2=cur;
			  }
			  cur=cur.next;
		  }
		  pre1.next=big.next;
		  pre2.next=null;
		  return small.next;
	  }
	  
	  
	  public int threeSumClosest(int[] num, int target) {
		  if(num.length<3)
			  return 0;
		  int closest=Integer.MAX_VALUE;
		  int mindif=Integer.MAX_VALUE;
		  
		  Arrays.sort(num);
		  
		  for(int i=0;i<num.length-2;i++){
			  int beg=i+1;
			  int end=num.length-1;
			  while(beg<end){
				  int sum=num[i]+num[beg]+num[end];
				  int dif=Math.abs(sum-target);
				  if(dif==0)
					  return target;
				  if(dif<mindif){
					  mindif=dif;
					  closest=sum;
				  }
				  if(sum>target)
					  end--;
				  else
					  beg++;
			  }
		  }
		  return closest;
	  }
	  
	  
	  public static ArrayList<Integer> findSubstring(String S, String[] L) {
		  ArrayList<Integer> res=new ArrayList<Integer>();
		  int n=L.length;
		  int len=L[0].length();
		  int size=n*len;
		  if(S.length()<size)
			  return res;
		  HashMap<String, Integer> map=new HashMap<String,Integer>();
		  for(int i=0;i<n;i++){
			  String s=L[i];
			  if(!map.containsKey(s))
				  map.put(s, 1);
			  else
				  map.put(s, map.get(s)+1);
		  }		   
		  
		  for(int i=0;i<S.length()-n*len+1;i++){
			  HashMap<String, Integer> found=new HashMap<String, Integer>();
			  int j=0;
			  for(j=0;j<n;j++){
				  String str=S.substring(i+j*len,i+j*len+len);
				  if(!map.containsKey(str))
					  break;
				  if(!found.containsKey(str))
					  found.put(str, 1);
				  else
					  found.put(str, found.get(str)+1);
				  if(found.get(str)>map.get(str))
					  break;
			  }
			  if(j==n)
				  res.add(i);				  
		  }
		  return res;
	  }
	  
	  public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
		  ArrayList<ArrayList<Integer>> res=new ArrayList<ArrayList<Integer>>();
		  if(root==null)
			  return res;
		  ArrayList<Integer> sol=new ArrayList<Integer>();
		  pathSumUtil(root, sum, 0, sol, res);
		  return res;
	  }
	  
	  
	  public static void pathSumUtil(TreeNode root, int sum, int cursum, ArrayList<Integer> sol, ArrayList<ArrayList<Integer>> res){
		  if(root==null||cursum>sum)
			  return;
		  cursum+=root.val;
		  sol.add(root.val);
		  if(root.left==null&&root.right==null&&cursum==sum){
			  ArrayList<Integer> out=new ArrayList<Integer>(sol);
			  res.add(out);
		  }
		  pathSumUtil(root.left,sum,cursum,sol,res);
		  pathSumUtil(root.right,sum,cursum,sol,res);
		  cursum-=root.val;
		  sol.remove(sol.size()-1);
		  
	  }
		  
	  
	  public static ArrayList<Integer> pathSumOne(TreeNode root, int target){
		  ArrayList<Integer> res=new ArrayList<Integer>();
		  if(root==null)
			  return res;
		  pathSumOneUtil(root, target, 0, res);
		  return res;
	  }
	  
	  public static boolean pathSumOneUtil(TreeNode root, int target, int cursum, ArrayList<Integer> res){
		  if(root==null)
			  return false;
		  cursum+=root.val;
		  res.add(root.val);
		  System.out.println(cursum+" ss");
		  if(root.left==null&&root.right==null&&cursum==target)
			  return true;
		  if(pathSumOneUtil(root.left,target, cursum,res))
			  return true;
		  else{
			  if(pathSumOneUtil(root.right,target, cursum,res))
					  return true;
			  else{
				  cursum-=root.val;
			  	  res.remove(res.size()-1);
			  }
				  
		  }
		  return false;
//		  cursum-=root.val;
//		  res.remove(res.size()-1);
		  
	  }
	  
	  public static ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
		  ArrayList<ArrayList<Integer>> res=new ArrayList<ArrayList<Integer>>();
		  if(num.length==0)
			  return res;
		  ArrayList<Integer> sol=new ArrayList<Integer>();
		  boolean[] used=new boolean[num.length];
		  Arrays.sort(num);
		  subsetWithDupUtil(0, num,used, sol,res);
		  return res;
	  }
	  
	  public static void subsetWithDupUtil(int cur, int[] num, boolean[] used, ArrayList<Integer> sol,ArrayList<ArrayList<Integer>> res){
		  res.add(sol);
		  if(cur==num.length){
			  return;
		  }
		  
		  for(int i=cur;i<num.length;i++){
			  if(!used[i]){
				  if(i>0&&num[i]==num[i-1]&&!used[i-1])
					  continue;
				  used[i]=true;
				  ArrayList<Integer> lst=new ArrayList<Integer>(sol);
				  lst.add(num[i]);
				  subsetWithDupUtil(i+1,num, used, lst, res);
				  used[i]=false;
			  }
		  }
	  }
	  
	  public static ArrayList<ArrayList<Integer>> subsets(int[] S) {
		  ArrayList<ArrayList<Integer>> res=new ArrayList<ArrayList<Integer>>();
		  if(S.length==0)
			  return res;
		  ArrayList<Integer> sol=new ArrayList<Integer>();
		  Arrays.sort(S);
		  subsetsUtil(0,S,sol,res);
		  return res;
	  }
	  
	  public static void subsetsUtil(int cur, int[] S, ArrayList<Integer> sol, ArrayList<ArrayList<Integer>> res){
		  res.add(sol);
		  if(cur==S.length)
			  return;
		  for(int i=cur;i<S.length;i++){
			  ArrayList<Integer> lst=new ArrayList<Integer>(sol);
			  lst.add(S[i]);
			  subsetsUtil(i+1,S,lst,res);			  
		  }
	  }
	  
	  public boolean searchMatrix(int[][] matrix, int target) {
		  int n=matrix.length;		  
		  if(n==0)
			  return false;
		  int m=matrix[0].length;
		  int i=0;
		  int j=m-1;
		  
		  while(i<n&&j>=0){
			  int t=matrix[i][j];
			  if(t==target)
				  return true;
			  if(t<target)
				  i++;
			  else
				  j--;
		  }
		  return false;
	  }
	  
	  public boolean isValid(String s) {
		  if(s.length()==0)
			  return true;
		  
		  Stack<Character> stk=new Stack<Character>();
		  for(int i=0;i<s.length();i++){
			  char c=s.charAt(i);
			  if(c=='('||c=='['||c=='{')
				  stk.push(c);
			  else{
				  if(stk.isEmpty())
					  return false;
				  else if(c==')'&&stk.peek()=='('||c==']'&&stk.peek()=='['||c=='}'&&stk.peek()=='{')
					  stk.pop();
				  else
					  return false;
			  }
				  
		  }
		  return stk.isEmpty();
	  }
	  
	  public ListNode deleteDuplicates(ListNode head) {
		  if(head==null||head.next==null)
			  return head;
		  ListNode cur=head.next;
		  ListNode pre=head;
		  while(cur!=null){
			  if(cur.val!=pre.val){
				  cur=cur.next;
				  pre=pre.next;
			  }
			  else{
				  while(cur!=null&&cur.val==pre.val)
					  cur=cur.next;
				  pre.next=cur;
				  pre=cur;
				  if(cur!=null)
					  cur=cur.next;
			  }
		  }
		  return head;
	  }
	  
	  public ListNode deleteDuplicates2(ListNode head) {
		  if(head==null||head.next==null)
			  return head;
		  ListNode cur=head.next;
		  ListNode pre=head;
		  while(cur!=null){
			  while(cur!=null&&cur.val==pre.val)
				  cur=cur.next;
			  pre.next=cur;
			  pre=cur;
			  if(cur!=null)
				  cur=cur.next;			  
		  }
		  return head;
	  }
	  
	  public int numTrees(int n) {
		  if(n<=1)
			  return 1;
		  int total=0;
		  for(int i=2;i<=n;i++){
			  int left=numTrees(i-1);
			  int right=numTrees(n-i);
			  total=left*right;					  
		  }
		  return total;
	  }
	  
	  public static int removeDuplicates(int[] A) {
		  if(A.length<3)
			  return A.length;
		  int t=A[0];
		  int count=1;
		  int j=1;
		  for(int i=1;i<A.length;i++){
			  if(A[i]!=t){
				  A[j++]=A[i];
				  t=A[i];
				  count=1;
			  }
			  else{	
				  count++;
				  if(count<3)
					  A[j++]=A[i];					  
			  }				  
		  }
		  return j;
	  }
	  
	  public static int removeDuplicates2(int[] A) {
		  if(A.length<3)
			  return A.length;
		  int count=1;
		  int j=0;
		  for(int i=1;i<A.length;i++){
			  if(A[i]!=A[i-1]){
				  A[++j]=A[i];
				  count=1;
			  }
			  else{	
				  count++;
				  if(count<3)
					  A[++j]=A[i];					  
			  }				  
		  }
		  
		  return j+1;
	  }
	  
	  public int removeDuplicatesOne(int[] A) {
		  if(A.length<2)
			  return A.length;
		  int j=0;
		  for(int i=1;i<A.length;i++){
			  if(A[i]!=A[i-1]){
				  j++;
				  A[j]=A[i];
			  }				  
		  }
		  return j+1;
	  }
	  
	  public ListNode swapPairs(ListNode head) {
		  ListNode dummy=new ListNode(0);
		  dummy.next=head;
		  ListNode pre=dummy;
		  ListNode cur=head;
		  
		  while(cur!=null&&cur.next!=null){
			  ListNode pnext=cur.next.next;
			  pre.next=cur.next;
			  cur.next.next=cur;
			  cur.next=pnext;			  
			  
			  pre=cur;
			  cur=pnext;			  
		  }
		  return dummy.next;
	  }
	  
	  public boolean isInterleave(String s1, String s2, String s3) {
		  int n1=s1.length();
		  int n2=s2.length();
		  int n3=s3.length();
		  if(n1+n2!=n3)
			  return false;
		  boolean[][] dp=new boolean[n1+1][n2+1];
		  dp[0][0]=true;
		  
		  for(int i=1;i<=n1;i++){
			  dp[i][0]=dp[i-1][0]&&s1.charAt(i-1)==s3.charAt(i-1);
		  }
		  
		  for(int i=1;i<=n2;i++){
			  dp[0][i]=dp[0][i-1]&&s2.charAt(i-1)==s3.charAt(i-1);
		  }
		  
		  for(int i=1;i<=n1;i++){
			  for(int j=1;j<=n2;j++){
				  dp[i][j]=dp[i-1][j]&&s1.charAt(i-1)==s3.charAt(i+j-1)||
						  dp[i][j-1]&&s2.charAt(j-1)==s3.charAt(i+j-1);
			  }
		  }
		  return dp[n1][n2];			  
	  }
	  
	  public static int search(int[] A, int target) {
		  if(A.length==0)
			  return -1;
		  int beg=0;
		  int end=A.length-1;
		  
		  while(beg<=end){
			  int mid=beg+(end-beg)/2;
			  if(A[mid]==target)
				  return mid;
			  else if(A[beg]<=A[mid]){
				  if(A[beg]<=target&&target<A[mid])
					  end=mid-1;
				  else
					  beg=mid+1;
			  }
			  else {
				  if(A[mid]<target&&target<=A[end])
					  beg=mid+1;
				  else
					  end=mid-1;
			  }
		  }
		  return -1;
	  }
	  
	  public static boolean search2(int[] A, int target){
		  int i=0;
		  int j=A.length-1;
		  while(i<=j){
			  int mid=i+(j-i)/2;
			  if(A[mid]==target)
				  return true;
			  if(A[i]<A[mid]){
				  if(A[i]<=target&&target<A[mid])
					  j=mid-1;
				  else
					  i=mid+1;
			  }
			  else if(A[i]>A[mid]){
				  if(A[mid]<target&&target<=A[j])
					  i=mid+1;
				  else
					  j=mid-1;
			  }
			  else
				  i++;
				  
		  }
		  return false;
	  }
	  
	  public ListNode reverseBetween(ListNode head, int m, int n) {
		  if(head==null)
			  return null;
		  ListNode dummy=new ListNode(0);
		  dummy.next=head;
		  ListNode ppre=dummy;
		  ListNode cur=head;
		  for(int i=0;i<m-1;i++){
			  ppre=cur;
			  cur=cur.next;
		  }
		  ListNode pre=cur;
		  ListNode start=cur;
		  cur=cur.next;
		  for(int i=0;i<n-m;i++){
			  ListNode pnext=cur.next;
			  cur.next=pre;
			  pre=cur;
			  cur=pnext;			  
		  }
		  ppre.next=pre;
		  start.next=cur;
		  
		  return dummy.next;
		  
	  }
	  
	  public RandomListNode copyRandomList(RandomListNode head) {
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
		  
		  cur=head;
		  RandomListNode coloneHead=head.next;
		  RandomListNode colone=coloneHead;
		  
		  while(cur!=null){
			  cur.next=colone.next;
			  cur=cur.next;
			  if(cur!=null)
				  colone.next=cur.next;
			  else
				  colone.next=null;
			  colone=colone.next;
		  }
		  
		  return coloneHead;
	  }
	  
	  public int uniquePaths(int m, int n) {
		  int[][] dp=new int[m][n];
		   for(int i=0;i<m;i++)
			   dp[i][0]=1;
		   for(int i=0;i<n;i++)
			   dp[0][i]=1;
		   for(int i=1;i<m;i++){
			   for(int j=1;j<n;j++)
				   dp[i][j]=dp[i-1][j]+dp[i][j-1];
		   }
		   return dp[m-1][n-1];
	  }
	  
	  
	  public ArrayList<ArrayList<Integer>> combine(int n, int k) {
		  ArrayList<ArrayList<Integer>> res=new ArrayList<ArrayList<Integer>>();
		  if(k>n)
			  return res;
		  ArrayList<Integer> sol=new ArrayList<Integer>();
		  combine(0,1,k,n,sol, res);
		  return res;
	  }
	  
	  public void combine(int dep,int cur, int k, int n, ArrayList<Integer> sol,ArrayList<ArrayList<Integer>> res ) {
		  if(dep==k){
			  ArrayList<Integer> out=new ArrayList<Integer>(sol);
			  res.add(out);
		  }
		  
		  for(int i=cur;i<=n;i++){
			  sol.add(cur);
			  combine(dep+1,i+1,k,n,sol,res);
			  sol.remove(sol.size()-1);
		  }
	  }
	  
	  public String simplifyPath(String path) {
		  if(path.length()==0)
			  return "/";
		  String[] strs=path.split("/");
		  
		  Stack<String> stk=new Stack<String>();
		  
		  for(int i=0;i<strs.length;i++){
			  if(strs[i].equals("")||strs[i].equals("."))
				  continue;
			  if(strs[i].equals("..")){
				  if(!stk.isEmpty())
					  stk.pop();
			  }
			  else
				  stk.push(strs[i]);
		  }
		  String res="";
		  if(stk.isEmpty())
			  return "/";
		  while(!stk.isEmpty()){
			  res="/"+stk.pop()+res;
		  }
		  return res;
	  }
	  
	  public int singleNumber2(int[] A) {
		  int res=0;
		  for(int i=0;i<32;i++){
			  int sum=0;
			  int x=1<<i;
			  for(int j=0;j<A.length;j++){
				  if((x&A[j])!=0)
					  sum++;
			  }
			  if(sum%3!=0)
				  res|=x;
		  }
		  return res;
	  }
	  
	  public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
		  ArrayList<ArrayList<Integer>> res=new ArrayList<ArrayList<Integer>>();
		  if(root==null)
			  return res;
		  ArrayList<Integer> level=new ArrayList<Integer>();
		  Queue<TreeNode> que=new LinkedList<TreeNode>();
		  int curlevel=0;
		  int nextlevel=0;
		  que.add(root);
		  curlevel++;
		  while(!que.isEmpty()){
			  TreeNode top=que.poll();
			  curlevel--;
			  level.add(top.val);
			  if(top.left!=null){
				  que.add(top.left);
				  nextlevel++;
			  }
			  if(top.right!=null){
				  que.add(top.right);
				  nextlevel++;
			  }
			  if(curlevel==0){
				  res.add(level);
				  level=new ArrayList<Integer>();
				  curlevel=nextlevel;
				  nextlevel=0;
			  }
		  }
		  Collections.reverse(res);
		  return res;
	  }
	  
	  public ListNode deleteDuplicatesAll(ListNode head) {
		  if(head==null)
			  return null;
		  ListNode dummy=new ListNode(0);
		  dummy.next=head;
		  ListNode pre=dummy;
		  ListNode cur=head;
		  
		  while(cur!=null){
			  boolean dup=false;
			  while(cur.next!=null&&cur.val==cur.next.val){
				  cur=cur.next;
				  dup=true;
			  }
			  if(dup){
				  pre.next=cur.next;
				  cur=cur.next;
			  }
			  else{
				  pre=cur;
				  cur=cur.next;
			  }				  
		  }
		  return dummy.next;
	  }
	  
	  public int removeElement(int[] A, int elem) {
		  int j=0;
		  for(int i=0;i<A.length;i++){
			  if(A[i]!=elem)
				  A[j++]=A[i];
		  }
		  return j;
	  }
	  
	  public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
		  ArrayList<ArrayList<Integer>> res=new ArrayList<ArrayList<Integer>>();
		  if(candidates.length==0)
			  return res;
		  ArrayList<Integer> sol=new ArrayList<Integer>();
		  Arrays.sort(candidates);
		  combinationSumUtil(0, candidates, sol, res, target, 0);
		  return res;
	  }
	  
	  public void combinationSumUtil(int cur,int[] candidates, ArrayList<Integer> sol, 
			  ArrayList<ArrayList<Integer>> res, int target,int cursum){
		  if(cur==candidates.length||cursum>target){
			 return;
		  }
		  if(cursum==target){
			  ArrayList<Integer> out=new ArrayList<Integer>(sol);
			  res.add(out);
		  }
		  	  
		  for(int i=cur;i<candidates.length;i++){
			  cursum+=candidates[i];
			  sol.add(candidates[i]);
			  combinationSumUtil(i,candidates, sol, res, target, cursum);
			  cursum-=candidates[i];
			  sol.remove(sol.size()-1);
		  }
	  }
	  
	  
	  public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
		  ArrayList<ArrayList<Integer>> res=new ArrayList<ArrayList<Integer>>();
		  if(num.length==0)
			  return res;
		  ArrayList<Integer> sol=new ArrayList<Integer>();
		  boolean[] used=new boolean[num.length];
		  Arrays.sort(num);
		  combinationSumUtil2(0, num, used,sol, res, target, 0);
		  return res;
	  }
	  
	  
	  public void combinationSumUtil2(int cur,int[] num, boolean[] used,ArrayList<Integer> sol, 
			  ArrayList<ArrayList<Integer>> res, int target,int cursum){
		  if(cur==num.length||cursum>target){
			 return;
		  }
		  if(cursum==target){
			  ArrayList<Integer> out=new ArrayList<Integer>(sol);
			  res.add(out);
		  }
		  	  
		  for(int i=cur;i<num.length;i++){
			  if(!used[i]){
				  if(i!=0&&num[i]==num[i-1]&&!used[i-1])
					  continue;
				  cursum+=num[i];
				  used[i]=true;
				  sol.add(num[i]);
				  combinationSumUtil2(i+1,num, used,sol, res, target, cursum);
				  cursum-=num[i];
				  used[i]=false;
				  sol.remove(sol.size()-1); 
			  }
			  
		  }
	  }
	  
	  public int climbStairs(int n) {
		  if(n<=1)
			  return 1;
		  int total=0;
		  int first=1;
		  int second=1;
		  for(int i=2;i<=n;i++){
			  total=first+second;
			  first=second;
			  second=total;
		  }
		  return total;
	  }
	  
	  
	  public void nextPermutation(int[] num) {
		  if(num.length<2)
			  return;
		  int index=-1;
		  for(int i=0;i<num.length-1;i++){
			  if(num[i]<num[i+1])
				  index=i;
		  }
		  if(index==-1){
			  Arrays.sort(num);
		  		return;
		  }
		  
		  int idx=-1;
		  for(int i=index+1;i<num.length;i++){
			  if(num[i]>num[index])
				  idx=i;
		  }
		  
		  int t=num[index];
		  num[index]=num[idx];
		  num[idx]=t;
		  
		  int beg=index+1;
		  int end=num.length-1;
		  
		  while(beg<end){
			  int tmp=num[beg];
			  num[beg]=num[end];
			  num[end]=tmp;
			  beg++;
			  end--;
		  }
	  }
	  
	  public static ListNode reverseKGroup(ListNode head, int k) {
		  if(head==null||k==1)
			  return head;
		  ListNode dummy=new ListNode(0);
		  dummy.next=head;
		  ListNode pre=dummy;
		  ListNode cur=head;
		  //tricky
		  int count=0;

		  while(cur!=null){
			  count++;
			  if(count%k==0){
				 pre=reverseGroup(pre,cur.next);
				 cur=pre.next;
			  }
			  else
				  cur=cur.next;
		  }
		  return dummy.next;
	  }
	  
	  public static ListNode reverseGroup(ListNode p, ListNode q){
		  ListNode last=p.next;
		  ListNode cur=last.next;
		  while(cur!=q){
			 last.next=cur.next;
			 cur.next=p.next;
			 p.next=cur;
			 cur=last.next;
		  }
		  return last;
	  }
	  
	  
	  
	  public int minDistance(String word1, String word2) {
		  int n1=word1.length();
		  int n2=word2.length();
		  int[][] dp=new int[n1+1][n2+1];
		  
		  for(int i=1;i<=n1;i++){
			  dp[i][0]=i;
		  }
		  for(int i=1;i<=n2;i++){
			  dp[0][i]=i;
		  }
		  
		  for(int i=1;i<=n1;i++){
			  for(int j=1;j<=n2;j++){
				  if(word1.charAt(i-1)==word2.charAt(j-1))
					  dp[i][j]=dp[i-1][j-1];
				  else
					  dp[i][j]=Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]))+1;
			  }
		  }
		  return dp[n1][n2];
	  }
	  
	  public boolean canJump(int[] A) {
		  if(A.length<2)
			  return true;
		  boolean[] dp=new boolean[A.length];
		  dp[A.length-1]=true;
		  int gap=1;
		  
		  for(int i=A.length-2;i>=0;i--){
			  if(A[i]>=gap){
				  dp[i]=true;
				  gap=1;
			  }
			  else
				  gap++;
		  }
		  return dp[0];
	  }
	  
	  public ArrayList<Integer> spiralOrder(int[][] matrix) {
		  ArrayList<Integer>  res=new ArrayList<Integer> ();
		  int m=matrix.length;
		  if(m==0)
			  return res;
		  int n=matrix[0].length;
		  
		  int top=0;
		  int bottom=m-1;
		  int left=0;
		  int right=n-1;
		  
		  while(true){
//	      while(top<=bottom&&left<=right){
			  for(int i=left;i<=right;i++){
				  res.add(matrix[top][i]);
			  }
			  if(++top>bottom)
				  break;
			  
			  for(int i=top;i<=bottom;i++){
				  res.add(matrix[i][right]);
			  }
			  if(--right<left)
				  break;
			  for(int i=right;i>=left;i--){
				  res.add(matrix[bottom][i]);
			  }
			  if(--bottom<top)
				  break;
			  for(int i=bottom;i>=top;i--)
				  res.add(matrix[i][left]);
			  if(++left>right)
				  break;
		  }
		  
		  return res;
	  }
	  
	  public int[][] generateMatrix(int n) {
		  int[][] matrix=new int[n][n];
		  int top=0;
		  int left=0;
		  int bottom=n-1;
		  int right=n-1;
		  int k=1;
		  while(top<=bottom&&left<=right){
			  for(int i=left;i<=right;i++)
				  matrix[top][i]=k++;
			  top++;
			  for(int i=top;i<=bottom;i++)
				  matrix[i][right]=k++;
			  right--;
			  for(int i=right;i>=left;i--)
				  matrix[bottom][i]=k++;
			  bottom--;
			  for(int i=bottom;i>=top;i--)
				  matrix[i][left]=k++;
			  left++;
		  }
		  return matrix;
	  }
	  
	  public ListNode rotateRight(ListNode head, int n) {
		  if(head==null)
			  return null;
		  int len=0;
		  ListNode cur=head;
		  while(cur!=null){
			  len++;
			  cur=cur.next;
		  }
		  n=n%len;
		  if(n==0)
			  return head;
		  cur=head;
		  ListNode dummy=new ListNode(0);
		  dummy.next=head;
		  ListNode pre=dummy;
		  for(int i=0;i<len-n;i++){
			  pre=cur;
			  cur=cur.next;			  
		  }
		  head=cur;
		  pre.next=null;
		  while(cur!=null&&cur.next!=null)
			  cur=cur.next;
		  cur.next=dummy.next;
		  return head;
	  }
	  
	  public int maxSubArray(int[] A) {
		  int n=A.length;
		  if(A.length==0)
			  return 0;
		  int max=Integer.MIN_VALUE;
		  int sum=0;
		  for(int i=0;i<n;i++){
			  sum+=A[i];
			  if(sum<0)
				  sum=0;
			  if(sum>max)
				  max=sum;
		  }
		  if(max==0){
			  max=A[0];
			  for(int i=1;i<n;i++){
				  if(A[i]>max)
					  max=A[i];
			  }
		  }
		  return max;
	  }
	  
	  public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		  int m=obstacleGrid.length;
		  int n=obstacleGrid[0].length;
		  int[][] dp=new int[m][n];
		  dp[0][0]=obstacleGrid[0][0]==1?0:1;
		  
		  for(int i=1;i<m;i++)
			  dp[i][0]=obstacleGrid[i][0]==1?0:dp[i-1][0];
		  
		  for(int i=1;i<n;i++)
			  dp[0][i]=obstacleGrid[0][i]==1?0:dp[0][i-1];
		  
		  for(int i=1;i<m;i++){
			  for(int j=1;j<n;j++){
				  dp[i][j]=obstacleGrid[i][j]==1?0:dp[i-1][j]+dp[i][j-1];
			  }
		  }
		  return dp[m-1][n-1];
	  }
	  
	  public String getPermutation(int n, int k) {
		  if(k<=0)
			  return "";
		  int[] num=new int[n];
		  
		  for(int i=0;i<n;i++)
			  num[i]=i+1;
		  
		  for(int i=1;i<k;i++)
			  getNextPermutation(num);
		  String res="";
		  for(int i=0;i<n;i++)
			  res+=num[i];
		  return res;
	  }
	  
	  public void getNextPermutation(int[] num){
		  if(num.length<2)
			  return;
		  int index=-1;
		  for(int i=0;i<num.length-1;i++){
			  if(num[i]<num[i+1])
				  index=i;
		  }
		  int idx=index+1;
		  for(int i=index+1;i<num.length;i++){
			  if(num[i]>num[index])
				  idx=i;
		  }
		  int t=num[index];
		  num[index]=num[idx];
		  num[idx]=t;
		  
		  int beg=index+1;
		  int end=num.length-1;
		  while(beg<end){
			  int tmp=num[beg];
			  num[beg]=num[end];
			  num[end]=tmp;
			  beg++;
			  end--;
		  }
	  }
	  
	  public static String getPermutation2(int n, int k) {
		  int[] num=new int[n];
		  int permCount=1;
		  
		  for(int i=0;i<n;i++){
			  num[i]=i+1;
			  permCount*=(i+1);
		  }
		  k--;
		  
		  String res="";
		  for(int i=0;i<n;i++){
			  permCount/=(n-i);
			  int index=k/permCount;
			  res+=num[index];
			  for(int j=index;j<n-i-1;j++){
				  num[j]=num[j+1];
			  }
			  k=k%permCount;
		  }
		  return res;
	  }
	  
	  
	  public String intToRoman(int num) {
		  if(num<=0||num>3999)
			  return "";
		  String[] strs={"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX",
					"V", "IV", "I" };
		  int[] nums={1000,900,500,400,100,90,50,40,10,9,5,4,1};
		  String res="";
		  for(int i=0;i<nums.length;i++){
			  while(num>=nums[i]){
				  num-=nums[i];
				  res+=strs[i];
			  }
		  }
		  return res;
	  }
	  
	  
	  public ArrayList<ArrayList<Integer>> permute(int[] num) {
		  ArrayList<ArrayList<Integer>> res=new ArrayList<ArrayList<Integer>>();
		  if(num.length==0)
			  return res;
		  ArrayList<Integer> sol=new ArrayList<Integer>();
		  boolean[] used=new boolean[num.length];
		  permuteUtil(0,num,used,sol,res);	
		  return res;
	  }
	  
	  public void permuteUtil(int dep, int[]num, boolean[] used,ArrayList<Integer>sol, ArrayList<ArrayList<Integer>> res){
		  if(dep==num.length){
			  ArrayList<Integer> out=new ArrayList<Integer>(sol);
			  res.add(out);
		  }
		  
		  for(int i=0;i<num.length;i++){
			  if(!used[i]){
				  sol.add(num[i]);
				  used[i]=true;
				  permuteUtil(dep+1,num,used,sol,res);
				  used[i]=false;
				  sol.remove(sol.size()-1);
			  }
		  }
	  }
	  
	  public double pow(double x, int n) {
		  if(n==0)
			  return 1;
		  boolean neg=false;
		  if(n<0){
			  neg=true;
			  n=-n;
		  }
		  double res=pow(x,n/2);
		  if(n%2==0)
			  res=res*res;
		  else
			  res=res*res*x;
		  if(neg)
			  res=1/res;
		  return res;
	  }
	  
	  public static TreeNode convert2DLL(TreeNode root){
		  if(root==null)
			  return null;
		  TreeNode head=root;
		  TreeNode left=convert2DLL(root.left);
		  
		  if(left!=null){
			  head=left;
			  while(left.right!=null){
				  left=left.right;
			  }
			  left.right=root;
			  root.left=left;			  
		  }
		 
		  TreeNode right=convert2DLL(root.right);
		  if(right!=null){
			  root.right=right;
			  right.left=root;
		  }
		  
		  return head;
	  }
	  
	  public ArrayList<String> anagrams(String[] strs) {
		  ArrayList<String> res=new ArrayList<String>();
		  
		  HashMap<String, ArrayList<String>> map=new HashMap<String, ArrayList<String>>();
		  
		  for(int i=0;i<strs.length;i++){
			  char[] ch=strs[i].toCharArray();
			  Arrays.sort(ch);
			  String s=new String(ch);
			  if(map.containsKey(s))
				  map.get(s).add(strs[i]);
			  else{
				  ArrayList<String> lst=new ArrayList<String>();
				  lst.add(strs[i]);
				  map.put(s, lst);
			  }
		  }
		  
		  Iterator<String> it=map.keySet().iterator();
		  while(it.hasNext()){
			  String s=it.next();
			  ArrayList<String> lst=map.get(s);
			  if(lst.size()>1)
				  res.addAll(lst);
		  }
		  return res;
	  }
	  
	  public ArrayList<String> anagrams2(String[] strs) {
		  ArrayList<String> res=new ArrayList<String>();
		  HashMap<String, Integer> map=new HashMap<String, Integer>();
		  
		  for(int i=0;i<strs.length;i++){
			  char[] ch=strs[i].toCharArray();
			  Arrays.sort(ch);
			  String s=new String(ch);
			  if(!map.containsKey(s))
				  map.put(s, i);
			  else{				  
				  res.add(strs[i]);
				  if(map.get(s)!=-1){
					  res.add(strs[map.get(s)]);
					  map.put(s, -1);
				  }
			  }
		  }
		  return res;
	  }
	  
	  public static String multiply(String num1, String num2) {
		  int n1=num1.length();
		  int n2=num2.length();
		  
		  int[] res=new int[n1+n2];
		  for(int i=n1-1;i>=0;i--){
			  int carry=0;
			  int digit1=num1.charAt(i)-'0';
			  for(int j=n2-1;j>=0;j--){
				  int digit2=num2.charAt(j)-'0';
				  int prod=digit1*digit2+res[i+j+1]+carry;
				  carry=prod/10;
				  prod%=10;
				  res[i+j+1]=prod;
			  }
			  res[i]=carry;
		  }
		  
//		  System.out.println(Arrays.toString(res));
		  String ans="";
		  int j=0;
		  while(j<res.length&&res[j]==0)
			  j++;
		  if(j==res.length)
			  return "0";
		  for(;j<res.length;j++)
			  ans+=res[j];
		  return ans;
	  }
	  
	  
	  public int numDistinct(String S, String T) {
		  int n1=S.length();
		  int n2=T.length();
		  int[][] dp=new int[n1+1][n2+1];
		  
		  for(int i=0;i<=n1;i++){
			  dp[i][0]=1;
		  }
		  for(int i=1;i<=n2;i++)
			  dp[0][i]=0;
		  
		  for(int i=1;i<=n1;i++){
			  for(int j=1;j<=n2;j++){
				  if(S.charAt(i-1)==T.charAt(j-1))
					  dp[i][j]=dp[i-1][j-1]+dp[i-1][j];//use or not use
				  else
					  dp[i][j]=dp[i-1][j];
			  }
		  }
		  return dp[n1][n2];
	  }
	  
	  public static int[] searchRange(int[] A, int target) {
		  int[] res={-1,-1};
		  int beg=0;
		  int end=A.length-1;
		  
		  while(beg<end){
			  int mid=beg+(end-beg)/2;
			  if(A[mid]>=target){
				  end=mid;
			  }
			  else
				  beg=mid+1;
		  }
		  System.out.println(beg+" and "+end);
		  
		  if(A[beg]==target)
			  res[0]=beg;
		  else
			  return res;
		  beg=0;
		  end=A.length;
		  while(beg<end){
			  int mid=beg+(end-beg)/2;
			  if(A[mid]<=target)
				  beg=mid+1;
			  else
				  end=mid;
		  }
		  
		  res[1]=end-1;
		  System.out.println(Arrays.toString(res));
		  return res;
	
	  }
	  
	  public static int[] searchRange2(int[] A, int target) {
		  int[] res={-1,-1};
		  int beg=0;
		  int end=A.length-1;
		  int index=-1;
		  while(beg<=end){
			  int mid=(beg+end)/2;
			  if(A[mid]==target){
				  index=mid;
				  break;
			  }
			  else if(A[mid]>target)
				  end=mid-1;
			  else
				  beg=mid+1;
		  }
		  if(index==-1)
			  return res;
		  beg=0;
		  end=index;
		  
		  while(beg<=end){
			  int mid=(beg+end);
			  if(A[mid]==target)
				  end=mid-1;
			  else
				  beg=mid+1;
		  }
		  res[0]=beg;
		  
		  beg=index;
		  end=A.length-1;
		  while(beg<=end){
			  int mid=(beg+end)/2;
			  if(A[mid]==target)
				  beg=mid+1;
			  else
				  end=mid-1;
		  }
		  res[1]=beg-1;
		  System.out.println(Arrays.toString(res));
		  
		  return res;
	  }
	  
	  public String strStr(String haystack, String needle) {
		  if(needle.length()==0)
			  return haystack;
		  if(haystack.length()<needle.length())
			  return null;
		  int n=needle.length();
		  
		  for(int i=0;i<haystack.length()-n+1;i++){
			  if(haystack.subSequence(i, i+n).equals(needle))
				  return haystack.substring(i);
		  }
		  return null;
	  }
	  
//	  算法如下：
//
//	　　① 设定一个x的初值x0 ; (在如下程序中取x0=a/2, 通过迭代公式求出x1，可以肯定与真正的平方根相比，误差很大。)
//	　　② 迭代关系式： 用公式x n+1 = (xn + a / xn) / 2求出x的下一个值 x1 ;
//	　　③ 迭代终止条件：如此继续下去,直到前后两次求出的x值(x n+1和xn)满足以下关系:|x n+1-xn|<10-5 .
	  
	  public int sqrt(int x) {
		  if(x==0||x==1)
			  return x;
		  //newton's method  f(x)=x2-n  >>>>>   x(n+1)=xn-f(xn)/f'(xn)
		  double g0=x;
		  double g1=(g0+x/g0)/2;
		  while(Math.abs(g1-g0)>0.01){
			  g0=g1;
			  g1=(g0+x/g0)/2;
		  }
		  return (int)g0;
	  }
	  
	  public double sqrt(double x) {
		  if(x==0||x==1)
			  return x;
		  //newton's method  f(x)=x2-n  >>>>>   x(n+1)=xn-f(xn)/f'(xn) -->>x(n+1) = (xn + a/xn)/2
		  double g0=x/2;
		  double g1=(g0+x/g0)/2;
		  while(Math.abs(g1-g0)>0.01){
			  g0=g1;
			  g1=(g0+x/g0)/2;
		  }
		  return g0;
	  }
	  
	  public static boolean isScramble(String s1, String s2) {		  
		  if(s1.length()!=s2.length())
			  return false;
		  if(s1.equals(s2))
			  return true;
		  
		  int n=s1.length();
		  for(int i=1;i<n;i++){
			  if(isScramble(s1.substring(0,i),s2.substring(0,i))&&
					  isScramble(s1.substring(i),s2.substring(i)))
				  return true;
			  if(isScramble(s1.substring(0,i),s2.substring(n-i))&&
					  isScramble(s1.substring(i),s2.substring(0,n-i)))
				  return true;
		  }
		  return false;
	  }

//	  f(i,j,l) is true iff substring starts at s1[i] and substring starts at s2[j] both with length l are scrambled]
	  public boolean isScrambledp(String s1, String s2) {
		  if(s1.length()!=s2.length())
			  return false;
		  int n=s1.length();
		  boolean[][][] dp=new boolean[n][n][n+1];
		  
		  for(int i=n-1;i>=0;i--){
			  for(int j=n-1;j>=0;j--){
				  for(int k=1;k<=n-Math.max(i, j);k++){
					  if(s1.substring(i,i+k).equals(s2.substring(j,j+k)))
						  dp[i][j][k]=true;
					  else{
						  for(int l=1;l<k;l++){
							  if(dp[i][j][l]&&dp[i+l][j+l][k-l]||
									  dp[i+l][j][k-l]&&dp[i][j+k-l][l]){
								  dp[i][j][k]=true;
							  	  break;
							  }
						  }
					  }
				  }
			  }
		  }
		  return dp[0][0][n];
	  }
	  
	  public int numDecodings(String s) {
		  if(s.length()==0)
			  return 0;
		  int n=s.length();
		  int[] dp=new int[n+1];
		  dp[0]=1;
		  if(isValidNum(s.substring(0,1)))
			  dp[1]=1;
		  
		  for(int i=2;i<=n;i++){
			  if(isValidNum(s.substring(i-1,i)))
				  dp[i]=dp[i-1];
			  if(isValidNum(s.substring(i-2,i)))
				  dp[i]=dp[i]+dp[i-2];
		  }
		  return dp[n];
	  }
	  public boolean isValidNum(String s){
		  if(s.charAt(0)=='0')
			  return false;
		  int num=Integer.parseInt(s);
		  if(num<1||num>26)
			  return false;
		  return true;
	  }
	  
	  
	  public static int jump(int[] A) {
		  int n=A.length;
		  if(n<2)
			  return 0;
		  int[] dp=new int[n];
		  dp[0]=0;
		  
		  for(int i=1;i<n;i++){
			  dp[i]=Integer.MAX_VALUE;
			  for(int j=0;j<i;j++){
				  if(i<=j+A[j]&&dp[j]!=Integer.MAX_VALUE){
					  dp[i]=dp[j]+1;
					  break;
				  }					  
			  }
		  }
		  return dp[n-1];
	  }
	  
	  public static int jump2(int[] A) {
		  if(A.length<2)
			  return 0;
		  int minstep=0;
		  
		  int max=A[0];
		  int min=1;
		  while(max<A.length){
			  int t=max;
			  int nextstart=min;
			  for(int i=min;i<=max;i++){
				  if(i+A[i]>t){
					  t=i+A[i];
					  nextstart=i;
				  }
			  }
			  min=nextstart;
			  max=t;
			  minstep++;
		  }
		  return minstep+1;		  
	  }
	  
	  public static int jump3(int[] A){
		  int max=0;
		  int steps=0;
		  int temp=0;
		  for(int i=0;i<A.length;){
			  if(temp>=A.length-1)
				  break;
			  while(i<=temp){
				  max=Math.max(temp, i+A[i]);
				  i++;
			  }
			  temp=max;
			  steps++;
		  }
		  return steps;
	  }
	  
	  
	  public static int jump4(int[] A){
		  int start=0;
		  int end=0;
		  int max=0;
		  int step=0;
		  
		  while(end<A.length-1){
			  step++;
			  for(int i=start;i<=end;i++){
				  if(i+A[i]>=A.length-1)
					  break;
				  if(i+A[i]>max)
					  max=i+A[i];
			  }
			  start=end+1;
			  end=max;
		  }
		  return step;
	  }
	  
	  public void solveSudoku(char[][] board) {
		  ArrayList<Integer> empty=new ArrayList<Integer>();
		  for(int i=0;i<9;i++){
			  for(int j=0;j<9;j++){
				  if(board[i][j]=='.')
					  empty.add(9*i+j);
			  }
		  }
		  
		  solveSudokuUtil(empty, board, 0);
	  }
	  
	  public boolean solveSudokuUtil(ArrayList<Integer> empty, char[][] board, int cur){
		  if(cur==empty.size())
			  return true;
		  int index=empty.get(cur);
		  int row=index/9;
		  int col=index%9;
		  for(int i=1;i<=9;i++){
			  if(isValidSudoku(i,row,col,board)){
				  board[row][col]=(char) ('0'+i);
				  if(solveSudokuUtil(empty,board,cur+1))
					  return true;
				  board[row][col]='.';
			  }			 
		  }
		  return false;
	  }
	  
	  public boolean isValidSudoku(int num, int row, int col, char[][] board){
		  for(int i=0;i<9;i++){
			  if(board[row][i]-'0'==num)
				  return false;
			  if(board[i][col]-'0'==num)
				  return false;
			  
			  //top left of cubic
			  int x=row/3*3;
			  int y=col/3*3;
			  
			  for(int j=0;j<3;j++){
				  for(int k=0;k<3;k++){
					  if(board[j+x][k+y]-'0'==num)
						  return false;
				  }
			  }			 
		  }	 
		  return true;
	  }
	  
	  
	  public ArrayList<ArrayList<String>> partition(String s) {
		  ArrayList<ArrayList<String>> res=new ArrayList<ArrayList<String>>();
		  if(s.length()==0)
			  return res;
		  ArrayList<String> sol=new ArrayList<String>();
		  partitionUtil(0,s,sol,res);
		  return res;
	  }
	  
	  public void partitionUtil(int dep, String s, ArrayList<String> sol, ArrayList<ArrayList<String>> res){
		  if(dep==s.length()){
			  ArrayList<String> out=new ArrayList<String>(sol);
			  res.add(out);
		  }
		  
		  for(int i=dep;i<s.length();i++){
			  if(isPalindrom(s.substring(dep,i+1))){
				  sol.add(s.substring(dep,i+1));
				  partitionUtil(i+1,s,sol,res);
				  sol.remove(sol.size()-1);
			  }
		  }
	  }
	  
	  public boolean isPalindrom(String s){
		  int i=0;
		  int j=s.length()-1;
		  while(i<j){
			  if(s.charAt(i)!=s.charAt(j))
				  return false;
			  i++;
			  j--;
		  }
		  return true;
	  }
	  
	  public int canCompleteCircuit(int[] a, int[] g) {
		  int i=0, j=0;
		  int total=0;
		  int sum=0;
		  while(j<a.length){
			  sum+=a[j]-g[j];
			  total+=a[j]-g[j];
			  if(sum<0){
				  sum=0;
				  i=j+1;
			  }
			  j++;
		  }
		  return total>=0?i:-1;
	  }
	  
	  TreeNode first;
	  TreeNode second;
	  TreeNode pre;
	  
	  public void recoverTree(TreeNode root){
		  if(root==null)
			  return;
		  first=null;
		  second=null;
		  pre=null;
		  recoverTreeUtil(root);
		  int t=first.val;
		  first.val=second.val;
		  second.val=t;
	  }
	  
	  public void recoverTreeUtil(TreeNode root){
		  if(root==null)
			  return;
		  recoverTreeUtil(root.left);
		  if(pre!=null&&pre.val>root.val){
			  if(first==null)
				  first=pre;
			  second=root;
		  }
		  pre=root;
		  recoverTreeUtil(root.right);
	  }
	  
	  public static int findKth(int[] A, int k){
		  if(k>A.length)
			  return -1;
		  return quickSelect(0,A.length-1,A,k);
	  }
	  
	  public static int quickSelect(int left, int right, int[] A, int k){
		  int pivot=left;
		  int i=left+1;
		  int j=right;
		  while(i<=j){
			  while(i<=j&&A[i]<=A[pivot])
				  i++;
			  while(i<=j&&A[j]>=A[pivot])
				  j--;
			  if(i<j)
				  swap(i,j,A);
		  }
		  int t=A[pivot];
		  A[pivot]=A[j];
		  A[j]=t;

		  if(j==k-1)
			  return A[j];
		  else if(j<k-1)
			  return quickSelect(j+1,right,A,k);
		  else
			  return quickSelect(left,j-1,A,k);
	  }
	  
	  public static void swap(int i,int j, int[]A){
		  int t=A[i];
		  A[i]=A[j];
		  A[j]=t;
	  }
	  
	  
	  public static int kthSmall(int[] A, int k){
		  if(k>A.length)
			  return -1;
		  
		  return kthSmall(0,A.length-1,A,k);
	  }
	  
	  public static int kthSmall(int start, int end, int[] A, int k){
		  int j=start;
		  int i=j-1;
		  int pivot=A[end];
		  for(;j<end;j++){
			  if(A[j]<pivot){
				  i++;
				  swap(i,j,A);
			  }
		  }
		  i++;
		 swap(i,end,A);
		 
		 int small=i-start+1;
		 if(small==k)
			 return A[i];
		 else if(small>k)
			 return kthSmall(start, i-1, A, k);
		 else
			 return kthSmall(i+1,end,A,k-small);
	  }
	  
	  
//	  public static int kthSmall(int[]a, int k){
//		    if(k == a.length)   
//		        return a[a.length-1];
//		     
//		    else
//		        return kthSmall(a, k, 0, a.length-1);
//		}
//		 
//		 
//		public static int kthSmall(int[] a, int k, int start, int end){
//		    int j = start;
//		    int i = j-1;
//		     
//		    int pivot = a[end];
//		     
//		    for(;j<end;j++){
//		        if(a[j] < pivot){
//		            i++;
//		            swap(a, i, j);
//		        }
//		    }
//		     
//		    i++;
//		    swap(a, i, end);
//		   
//		    int small = i-start+1;
//		    if(small == k){
//		        return a[i];
//		    }else if(small > k){
//		        return kthSmall(a, k, start, i-1);
//		    }else{   //small is less than k
//		        return kthSmall(a, k-small, i+1, end);
//		    }
//		}
//		 
//		public static void swap(int[] a, int i, int j){
//		    int temp = a[i];
//		    a[i] = a[j];
//		    a[j] = temp;
//		}
//	  
	  
	  
	  public static int findKthLargest(int[] nums, int k){
		  if(k<1||k>nums.length)
			  return -1;
		  return findKthLargest(nums, 0, nums.length-1,k);
	  }
	  
	  public static int findKthLargest(int[] nums, int start, int end, int k){
		  int pivot=start;
		  int left=start;
		  int right=end;
		  
		  while(left<=right){
			  while(left<=right&&nums[left]>=nums[pivot])// kth smallest <=
				  left++;
			  while(left<=right&&nums[right]<=nums[pivot])// kth smallest >=
				  right--;
			  if(left<right)
				  swap(left,right,nums);
		  }
		  swap(pivot,right,nums);
		  if(k==right+1)
			  return nums[right];
		  else if(k>right+1)
			  return findKthLargest(nums, right+1,end,k);
		  else
			  return findKthLargest(nums,start, right-1, k);
	  }
	  
	  
	  public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		  if(node==null)
			  return null;
		  Queue<UndirectedGraphNode> que=new LinkedList<UndirectedGraphNode>();
		  que.add(node);
		  HashMap<UndirectedGraphNode, UndirectedGraphNode> map=new HashMap<UndirectedGraphNode,UndirectedGraphNode>();
		  UndirectedGraphNode copy=new UndirectedGraphNode(node.label);
		  map.put(node, copy);
		  while(!que.isEmpty()){
			  UndirectedGraphNode top=que.remove();
			  ArrayList<UndirectedGraphNode> neighbours=top.neighbors;
			  
			  for(int i=0;i<neighbours.size();i++){
				  UndirectedGraphNode neighbour=neighbours.get(i);
				  if(!map.containsKey(neighbour)){
					  que.add(neighbour);
					  UndirectedGraphNode n=new UndirectedGraphNode(neighbour.label);
					  map.put(neighbour, n);
					  map.get(top).neighbors.add(n);
				  }
				  else{
					  map.get(top).neighbors.add(map.get(neighbour));
				  }
			  }
		  }
		  return copy;
	  }
	  
	  public int divide(int dividend, int divisor) {
		  boolean neg=false;
		  if(dividend<0&&divisor>0||dividend>0&&divisor<0)
			  neg=true;
		  
		  long a=dividend;
		  if(a<0)
			  a=-a;
		  long b=divisor;
		  if(b<0)
			  b=-b;
		  int res=0;
		  while(a>=b){
			  long t=b;
			  for(int i=0;a>=t;i++,t<<=1){
				  res+=1<<i;
				  a-=t;
			  }
		  }
		  return neg?-res:res;
	  }
	  
	  public ArrayList<ArrayList<Integer>> generate(int numRows) {
		  ArrayList<ArrayList<Integer>> res=new ArrayList<ArrayList<Integer>>();
		  if(numRows<=0)
			  return res;
		  int[][] dp=new int[numRows][numRows];
		  for(int i=0;i<numRows;i++)
			  dp[i][0]=1;
		  
		  for(int i=1;i<numRows;i++){
			  for(int j=1;j<=i;j++){
				  if(j==i)
					  dp[i][j]=1;
				  else
					  dp[i][j]=dp[i-1][j]+dp[i-1][j-1];
			  }
		  }
		  
		  for(int i=0;i<numRows;i++){
			  ArrayList<Integer> row=new ArrayList<Integer>();
			  for(int j=0;j<=i;j++){
				  row.add(dp[i][j]);
			  }
			  res.add(row);
		  }
		  return res;
	  }
	  
	  public boolean exist(char[][] board, String word) {
		  int n=board.length;
		  if(n==0)
			  return false;
		  int m=board[0].length;
		  boolean[][] used=new boolean[n][m];
		  for(int i=0;i<n;i++){
			  for(int j=0;j<m;j++){
				  if(board[i][j]==word.charAt(0)){
					 if(existUtildfs(board, i, j,used, word, 0))
						 return true;
				  }
			  }
		  }
		  return false;
	  }
	  
	  public boolean existUtildfs(char[][] board, int i, int j, boolean[][] used, String word, int cur){
		  if(cur==word.length())
			  return true;
		  if(i>=0&&i<board.length&&j>=0&&j<board[0].length&&!used[i][j]&&board[i][j]==word.charAt(cur)){
			  used[i][j]=true;
			  boolean res=existUtildfs(board, i+1,j,used,word,cur+1)|| 
					  existUtildfs(board, i-1,j,used,word,cur+1)||
					  existUtildfs(board, i,j+1,used,word,cur+1)||
					  existUtildfs(board, i,j-1,used,word,cur+1);
			  if(res)
				  return true;
			  else
				  used[i][j]=false;
		  }
		  return false;
	  }
	  
	  public ArrayList<Integer> getRow(int rowIndex) {
		  ArrayList<Integer> res=new ArrayList<Integer>();
		  int[] dp=new int[rowIndex+1];
		  dp[0]=1;
		  
		  for(int i=1;i<=rowIndex;i++){
			  for(int j=i;j>=0;j--){
				  if(j==i)
					  dp[j]=dp[j-1];
				  else
					  dp[j]=dp[j-1]+dp[j]; 
			  }	 
			 
		  }
		  for(int i=0;i<dp.length;i++)
			  res.add(dp[i]);
		  return res;			  
	  }
	  
	  
	  public ArrayList<Integer> getRow2(int rowIndex) {
		  ArrayList<Integer> res=new ArrayList<Integer>();
		  res.add(1);
		  
		  for(int i=1;i<=rowIndex;i++){
			  int p=1;
			  int temp;
			  for(int j=1;j<i;j++){
				  temp=p;
				  p=res.get(j);
				  res.set(j, res.get(j)+temp);
			  }
			  res.add(1);
		  }
		  return res; 
		   
	  }
	  
	  
	  public boolean isValidSudoku(char[][] board) {
		  for(int i=0;i<9;i++){
			  boolean checker[]=new boolean[10];
			  for(int j=0;j<9;j++){
				  if(board[i][j]=='.')
					  continue;
				  else{
					  int num=board[i][j]-'0';
					  if(checker[num])
						  return false;
					  else
						  checker[num]=true;
				  }
			  }
		  }
		  
		  for(int i=0;i<9;i++){
			  boolean checker[]=new boolean[10];
			  for(int j=0;j<9;j++){
				  if(board[j][i]=='.')
					  continue;
				  else{
					  int num=board[j][i]-'0';
					  if(checker[num])
						  return false;
					  else
						  checker[num]=true;
				  }
			  }
		  }
		  
		  
		  for(int i=0;i<9;i+=3){			  
			  for(int j=0;j<9;j+=3){
				  boolean checker[]=new boolean[10];
				  for(int k=0;k<3;k++){
					  for(int l=0;l<3;l++){
						  if(board[i+k][j+l]=='.')
							  continue;
						  else{
							  int num=board[i+k][j+l]-'0';
							  if(checker[num])
								  return false;
							  else
								  checker[num]=true;
						  }
					  }
				  }
			  }
		  }
		  return true;
	  }
	  
	  
	  public static boolean elementInKdistance(int[] A, int k){
		  if(A.length<2)
			  return false;
		  Queue<Integer> que=new LinkedList<Integer>();
		  for(int i=0;i<A.length&&i<k;i++){
			  if(!que.contains(A[i]))
				  que.add(A[i]);
			  else
				  return true;
		  }
		  if(que.size()<k)
			  return false;
		  
		  for(int i=k;i<A.length;i++){			  
			  if(!que.contains(A[i])){
				  que.remove();
				  que.add(A[i]);
			  }
			  else
				  return true;
		  }
		  return false;
		  
	  }
	  
	  public int longestValidParentheses(String s) {
		  int n=s.length();
		  if(n<2)
			  return 0;
		  int maxLen =0;
		  int last=-1;
		  Stack<Integer> stk=new Stack<Integer>();
		  
		  for(int i=0;i<n;i++){
			  if(s.charAt(i)=='(')
				  stk.push(i);
			  else{
				  if(stk.isEmpty())
					  last=i;
				  else{
					  stk.pop();
					  if(stk.isEmpty())
						  maxLen=Math.max(maxLen, i-last);
					  else
						  maxLen=Math.max(maxLen, i-stk.peek());
				  }
			  }
		  }
		  return maxLen;
	  }
	  
	  public static ComplexListNode flattenMultiLevelList(ComplexListNode head){
		  if(head==null)
			  return null;
		  ComplexListNode tail=head;
		  ComplexListNode cur=head;
		  while(tail.next!=null)
			  tail=tail.next;
		  
		  while(cur!=null){
			  if(cur.child!=null){
				  ComplexListNode tmp=cur.child;
				  tail.next=tmp;
				  while(tmp.next!=null)
					  tmp=tmp.next;
				  tail=tmp;
			  }
			  cur=cur.next;
		  }
		  return head;
	  }
	  
	  public int longestConsecutive(int[] num) {
		  if(num.length<2)
			  return num.length;
		  
		  HashSet<Integer> set=new HashSet<Integer>();
		  for(int i: num)
			  set.add(i);
		  
		  int longest=1;
		  
		  for(int i=0;i<num.length;i++){
			  if(set.contains(num[i]))
				  longest=Math.max(longest, getCountAsc(set,num[i]+1,true)+getCountAsc(set,num[i],false));
			  //num[i]+1, because num[i] removed when descending
		  }
		  return longest;
	  }
	  
	  public int getCountAsc(HashSet<Integer> set, int num, boolean asc){
		  int count=0;
		  
		  while(set.contains(num)){
			  count++;
			  set.remove(num);//if not remove, will LTE
			  if(asc)
				  num++;
			  else
				  num--;
		  }
		  return count;
	  }
	  
	  public static ArrayList<Integer> grayCode(int n) {
		  ArrayList<Integer> res=new ArrayList<Integer>();
		  if(n<0)
			  return res;
		  if(n==0)
			  res.add(0);
		  else{
			  ArrayList<Integer> sol=grayCode(n-1);
			  res.addAll(sol);
			  
			  for(int i=sol.size()-1;i>=0;i--){
				  res.add(sol.get(i)+(1<<(n-1))); // shift precedence is the lowest
			  }
		  }
		  return res;
	  }
	  
	  public ArrayList<Integer> grayCode2(int n) {
		  ArrayList<Integer> res=new ArrayList<Integer>();
		  res.add(0);
		  for(int i=0;i<n;i++){
			  int highestBit=1<<i;
			  
			  for(int j=res.size()-1;j>=0;j--){
				  res.add(res.get(j)+highestBit);
			  }
		  }
		  return res;
	  }
	  
//	  For a given array / sequence of colors, find the maximum number of couples.
	  public static int findMaxCouples(char[] colors){
		  if(colors.length<2)
			  return 0;
		  Stack<Character> stk=new Stack<Character>();
		  int count=0;
		  for(int i=0;i<colors.length;i++){
			  if(stk.isEmpty())
				  stk.push(colors[i]);
			  else if(stk.peek()!=colors[i])
				  stk.push(colors[i]);
			  else{
				  stk.pop();
				  count++;
			  }
		  }
		  return count;
	  }
//	  Recursively remove all adjacent duplicates
	  public static String removeAdjacentDuplicates(String str){
		  if(str.length()<2)
			  return str;
		  String res="";
		  char lastchar='#';
		  Stack<Character> stk=new Stack<Character>();
		  for(int i=0;i<str.length();i++){
			  char c=str.charAt(i);
			  if(c==lastchar)
				  continue;
			  if(stk.isEmpty())
				  stk.push(c);
			  else if(c==stk.peek()){
				  stk.pop();
				  lastchar=c;
			  }
			  else
				  stk.push(c);			  
			  
		  }
		  
		  while(!stk.isEmpty())
			  res=stk.pop()+res;
		  return res;
	  }
	  public static boolean noSameAdjChars(String str){
		  int j;
		  for(j=0;j<str.length()-1;j++){
			  if(str.charAt(j)==str.charAt(j+1))
				  break;
		  }
		  if(j==str.length()-1)
			  return true;
		  return false;
	  }
	  
	  public static String removeAdjacentDuplicatesRecur(String str){
		  if(str.length()<2)
			  return str;
		 if(noSameAdjChars(str))
			 return str;
		 if(str.charAt(0)==str.charAt(1)){
			 int i=2;
			 while(i<str.length()&&str.charAt(i)==str.charAt(0))
				 i++;
			 return removeAdjacentDuplicatesRecur(str.substring(i));
		 }
		 String s= removeAdjacentDuplicatesRecur(str.substring(1));
		 if(s.charAt(0)==str.charAt(0)){
			 return  s.substring(1);
		 }
//		 if(s.length()==0)
//			 return s;
		 return str.charAt(0) + s;
	  }
	  
	  public static String reversSentencs(String sentence){
		  char[] ch=sentence.toCharArray();
		  reverseWord(ch,0,ch.length-1);
		  
		  int start=0;
		  for(int i=0;i<ch.length;i++){
			  if(ch[i]==' '){
				  reverseWord(ch, start, i-1);
				  start=i+1;
			  }
		  }
		  reverseWord(ch, start, ch.length-1);
		  return new String(ch);
	  }
	  
	  public static void reverseWord(char[] ch, int beg, int end){
		  while(beg<end){
			  char c=ch[beg];
			  ch[beg]=ch[end];
			  ch[end]=c;
			  beg++;
			  end--;
		  }
	  }
	  
	  public static boolean findPartiion(int[] arr){
		  int sum=0;
		  for(int i=0;i<arr.length;i++)
			  sum+=arr[i];
		  if(sum%2!=0)
			  return false;
		  int n=arr.length;
		  boolean[][] dp=new boolean[sum/2+1][n+1];
		  
		  for(int i=0;i<dp.length;i++)
			  dp[i][0]=false;
		  for(int i=0;i<dp[0].length;i++)
			  dp[0][i]=true;
		  
		  for(int i=1;i<dp.length;i++){
			  for(int j=1;j<dp[0].length;j++){
				  dp[i][j]=dp[i][j-1];
				  if(i>=arr[j-1])
					  dp[i][j]=dp[i][j]||dp[i-arr[j-1]][j-1];
			  }
		  }
		  return dp[sum/2][n];
	  }
	  
	  
	  public ArrayList<String> restoreIpAddresses(String s) {
		  ArrayList<String>res =new ArrayList<String>();
		  if(s.length()<4||s.length()>12)
			  return res;
		  String sol="";
		  restoreIpAddressUtil(0, s, sol, res);
		  return res;
	  }
	  
	  public void restoreIpAddressUtil(int dep, String s, String sol,ArrayList<String>res){
		  if(dep==3&&isValidNumber(s))
			  res.add(sol+s);
		  for(int i=1;i<4&&i<s.length();i++){
			  if(isValidNumber(s.substring(0,i)))
				  restoreIpAddressUtil(dep+1, s.substring(i),sol+s.substring(0,i)+'.',res);
		  }
	  }
	  
	  public boolean isValidNumber(String s){
		  if(s.charAt(0)=='0')
			  return s.equals("0");
		  int num=Integer.parseInt(s);
		  return num>=1&&num<=255;
	  }
	  
	  
	  
	  public int romanToInt(String s) {
		  HashMap<Character, Integer> map=new HashMap<Character, Integer>();
		  map.put('I', 1);
		  map.put('V', 5);
		  map.put('X', 10);
		  map.put('L', 50);
		  map.put('C', 100);
		  map.put('D', 500);
		  map.put('M', 1000);
		  
		  int res=0;
		  
		  for(int i=0;i<s.length();i++){
			  res+=sign(i,s,map)*map.get(s.charAt(i));
		  }
		  return res;
	  }
	  public int sign(int i, String s, HashMap<Character,Integer>map){
		  if(i==s.length()-1)
			  return 1;
		  if(map.get(s.charAt(i))>=map.get(s.charAt(i+1)))
			  return 1;
		  else
			  return -1;
	  }
	  
	  public static boolean isMirror(TreeNode root1, TreeNode root2){
		  if(root1==null&&root2==null)
			  return true;
		  if(root1==null||root2==null)
			  return false;
		  if(root1.val!=root2.val)
			  return false;
		  return isMirror(root1.left,root2.right)&&isMirror(root1.right,root2.left);
	  }
	  
	  
	  public static void mirror(TreeNode root){
		  if(root==null)
			  return ;
		  TreeNode t=root.left;
		  root.left=root.right;
		  root.right=t;
		  mirror(root.left);
		  mirror(root.right);
	  }
	  
	  
	  public static void inorder(TreeNode root){
		  if(root==null)
			  return;
		  inorder(root.left);
		  System.out.print(root.val+" ");
		  inorder(root.right);
	  }
	  
	  public static void replaceNode(TreeNode root){
		  int[] sum={0};
		  replaceNode(root,sum);
	  }
	  
	  public static void replaceNode(TreeNode root, int[] sum){
		  if(root==null)
			  return;
		  replaceNode(root.right,sum);
		  sum[0]+=root.val;
		  root.val=sum[0];
		  replaceNode(root.left,sum);
	  }
	  
//	  public static int getSum(TreeNode root){
//		  if(root==null)
//			  return 0;
//		  return getSum(root.left)+root.val+getSum(root.right);
//	  }
	  
	  
	  public static int diameter(TreeNode root){
		  int[] height={0};
		  return diameterOp(root, height);
	  }
	  
	  public static int diameterOp(TreeNode root, int[] height){
		  int[] lh={0};
		  int[] rh={0};
		  if(root==null){
			  height[0]=0;
			  return 0;
		  }
		  int ldiameter=diameterOp(root.left,lh);
		  int rdiameter=diameterOp(root.right,rh);
		  height[0]=Math.max(lh[0], rh[0])+1;
		  
		  return Math.max(lh[0]+rh[0]+1, Math.max(ldiameter, rdiameter));
	  }
	  
	  
//	  Given an array of +ve as well as -ve numbers, 
//	  find out whether it is possible or not to convert it to 0
//	  by adding/subtracting operations on all the elements.
	  
	  public static boolean checkIfSumZero(int[] A){
		  if(A.length==0)
			  return false;
		  if(A.length==1)
			  return A[0]==0;
		  ArrayList<Integer> lst=new ArrayList<Integer>();
		  lst.add(A[0]);
		  lst.add(-A[0]);
		  
		  for(int i=1;i<A.length;i++){
			  ArrayList<Integer> t=new ArrayList<Integer>(lst);
			  lst=new ArrayList<Integer>();
			  for(int j:t){
				 lst.add(j+A[i]);
				 lst.add(j-A[i]);
			  }
		  }
		  for(int i=0;i<lst.size();i++){
			  if(lst.get(i)==0)
				  return true;
		  }
		  return false;
	  }
	  
	  public static int multipleOf3(int[] A){
		  if(A.length<2)
			  return 0;
		  ArrayList<Integer> lst0=new ArrayList<Integer>();
		  ArrayList<Integer> lst1=new ArrayList<Integer>();
		  ArrayList<Integer> lst2=new ArrayList<Integer>();
		  
		  for(int i=0;i<A.length;i++){
			  if(A[i]%3==0)
				  lst0.add(A[i]);
			  else if(A[i]%3==1)
				  lst1.add(A[i]);
			  else
				  lst2.add(A[i]);
		  }
		  int n1=lst0.size();
		  int n2=lst1.size();
		  int n3=lst2.size();
		  
		  int duplet=n1*(n1-1)/2+n2*n3;
		  
		  int triplet=n1*(n1-1)*(n1-2)/6+n2*(n2-1)*(n2-2)/6+n3*(n3-1)*(n3-2)/6+n1*n2*n3;
		  
		  return duplet+triplet;		  
		  
	  }
	  
	  public static ArrayList<String> wordBreak(String s, Set<String> dict){
		  int n=s.length();
		  boolean[][] dp=new boolean[n][n+1];
		  
		  for(int i=n-1;i>=0;i--){
			  for(int j=i+1;j<=n;j++){
				  String sub=s.substring(i,j);
				  if(dict.contains(sub)&&j==n){
					  dp[i][j-1]=true;
					  dp[i][n]=true;
				  }
				  else{
					  if(dict.contains(sub)&&j<n&&dp[j][n]){
						  dp[i][j-1]=true;
						  dp[i][n]=true;
					  }
				  }
			  }
		  }
		  
		  ArrayList<String> res=new ArrayList<String>();
		  if(!dp[0][n])
			  return res;
		  wordBreakUtil(0,s,dp,"",res);
		  return res;
	  }
	  
	  public static void wordBreakUtil(int cur, String s, boolean[][] dp, String sol,ArrayList<String> res){
		  if(cur==s.length())
			  res.add(sol);
		  
		  for(int i=cur;i<s.length();i++){
			  if(dp[cur][i]){
				  String sub="";
				  if(i<s.length()-1)
					  sub=sol+s.substring(cur,i+1)+" ";
				  else
					  sub=sol+s.substring(cur,i+1);
				  
				  wordBreakUtil(i+1,s,dp,sub,res);
			  }
		  }
	  }
	  
	  public static void verticalSum(TreeNode root){
		  if(root==null)
			  return;
		  HashMap<Integer, Integer> map=new HashMap<Integer, Integer>();
		  verticalSumUtil(root,0,map);
		  Iterator<Integer> it=map.keySet().iterator();
		  while(it.hasNext()){
			  int axis=it.next();
			  System.out.print(map.get(axis)+" ");
		  }
		  
	  }
	  
	  public static void verticalSumUtil(TreeNode root, int axis, HashMap<Integer, Integer> map){
		  if(root==null)
			  return;
		  if(!map.containsKey(axis)){
			  map.put(axis, root.val);
		  }
		  else{
			  int sum=map.get(axis)+root.val;
			  map.put(axis, sum);
		  }
		  verticalSumUtil(root.left,axis-1,map);
		  verticalSumUtil(root.right,axis+1,map);
			  
	  }
	  
	  
	  public static TreeNode inorderSuccessor(TreeNode root, TreeNode node){
		  if(root==null)
			  return null;
		  if(node.right!=null)
			  return findMinValue(node.right);
		  TreeNode succ=null;
		  
		  while(root!=null){
			  if(root.val>node.val){
				  succ=root;
				  root=root.left;
			  }
			  else if(root.val<node.val){
				  root=root.right;
			  }
			  else
				  break;
		  }
		  return succ;
	  }
	  
	  public static TreeNode findMinValue(TreeNode root){
		  if(root==null)
			  return null;
		  TreeNode cur=root;
		  while(cur.left!=null)
			  cur=cur.left;
		  return cur;
	  }
	  
	  
	  
	  public static String reverseWords(String s){
		  char[] ch=s.toCharArray();
		  
		  reverseWord(ch, 0, ch.length-1);
		  int start=0;
		  for(int i=0;i<ch.length;i++){
			  if(ch[i]==' '){
				  reverseWord(ch,start, i-1);
				  start=i+1;
			  }
		  }
		  reverseWord(ch, start, ch.length-1);
		  return new String(ch);
	  }
	  
	  public static boolean isRotated(String s1, String s2){
		  if(s1.length()!=s2.length())
			  return false;
		  String s=s1+s1;
		  
		  if(s.contains(s2))
			  return true;
		  else
			  return false;		  
	  }
	  
	  public static int findElement(int[] A, int target){
		  if(A.length==0)
			  return -1;
		  int beg=0;
		  int end=A.length-1;
		  int peak=(beg+end)/2;
		  while(beg<=end){
			  int mid=beg+(end-beg)/2;
			  if(A[mid]==target){
				  return mid;
			  }
			  if(mid==0||mid==A.length-1||A[mid]>A[mid+1]&&A[mid-1]<A[mid]){
				  peak=mid;
				  break;
			  }
			  else if(A[mid]<A[mid-1]){
				  end=mid-1;
			  }
			  else
				  beg=mid+1;
		  }
		  
		  beg=0;
		  end=peak;
		  
		  while(beg<=end){
			  int mid=(beg+end)/2;
			  if(A[mid]==target)
				  return mid;
			  if(A[mid]>target)
				  end=mid-1;
			  else
				  beg=mid+1;
		  }
		  
		  beg=peak;
		  end=A.length-1;
		  
		  while(beg<=end){
			  int mid=(beg+end)/2;
			  if(A[mid]==target)
				  return mid;
			  if(A[mid]>target)
				  beg=mid+1;
			  else
				  end=mid-1;
		  }
		  return -1;
				  
	  }
	  
	  
	  public static String longestPalindromeDP(String s) {
		  if(s.length()<2)
			  return s;
		  int n=s.length();
		  int start=0;
		  int length=1;
		  boolean[][] dp=new boolean[n][n];
		  
		  for(int i=0;i<n;i++)
			  dp[i][i]=true;
		  
		  for(int i=0;i<n-1;i++){
			  if(s.charAt(i)==s.charAt(i+1)){
					  dp[i][i+1]=true;
					  start=i;
					  length=2;
			  }
		  }
		  
		  for(int len=3;len<=n;len++){
			  for(int i=0;i<=n-len;i++){
				  int j=i+len-1;
				  
				  if(s.charAt(i)==s.charAt(j)&&dp[i+1][j-1]){
					  dp[i][j]=true;
					  start=i;
					  length=len;
				  }
			  }
		  }
		  System.out.println(length);
		  
		  return s.substring(start, start+length);
	  }
	  
	  
	  public int ladderLength(String start, String end, HashSet<String> dict) {
		  HashSet<String> visited=new HashSet<String>();
		  Queue<String> que=new LinkedList<String>();
		  int curlevel=0;
		  int nextlevel=0;
		  que.add(start);
		  curlevel++;
		  visited.add(start);
		  int steps=1;
		  
		  while(!que.isEmpty()){
			  String s=que.remove();
			  curlevel--;
			  if(s.equals(end)){
				  return steps;
			  }
			  else{
				  char[] ch=s.toCharArray();
				  for(int i=0;i<ch.length;i++){
					  char t=ch[i];
					  for(char c='a';c<='z';c++){
						 
						  if(t!=c){
							  ch[i]=c;
							  String st=new String(ch);
							  if(dict.contains(st)&&!visited.contains(st)){
								  visited.add(st);
								  que.add(st);
								  nextlevel++;
							  }
						  }
					  }
					  ch[i]=t;
				  }
			  }
			  if(curlevel==0){
				  steps++;
				  curlevel=nextlevel;
				  nextlevel=0;
			  }
		  }
		  return 0;
	  }
	  
	  public static int minCut(String s) {
		  int n=s.length();
		  if(n<2)
			  return 0;
		  int[][] dp=new int[n][n];
		  boolean[][] p=new boolean[n][n];
		  
		  for(int i=0;i<n;i++){
			  dp[i][i]=0;
			  p[i][i]=true;
		  }
		  
		  for(int len=2;len<=n;len++){
			  for(int i=0;i<=n-len;i++){
				  int j=i+len-1;
				  
				  if(s.charAt(i)==s.charAt(j)){
					  if(i+1==j){
						  p[i][j]=true;
					  }
					  else
						  p[i][j]=p[i+1][j-1];
				  }
					  if(p[i][j])
						  dp[i][j]=0;
					  else
						  dp[i][j]=Integer.MAX_VALUE;
					  
					  for(int k=i;k<j;k++){
						  dp[i][j]=Math.min(dp[i][j], dp[i][k]+dp[k+1][j]+1);
					  }				  
			  }
		  }
		  
		  return dp[0][n-1];
	  }
	  
//	  Dp[i] equals the minimum cut number for string [i,n].
//	  Thus, D[i] = min(D[i], D[j+1]+1) j<=i, and [j+1, i] forms a palindrome.
	  public static int minCut2(String s) {
		  int n=s.length();
		  int[] dp=new int[n+1];
		  boolean[][] p=new boolean[n][n];
		  
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
	  
	  public static int largestRectangleArea(int[] height) {
		  if(height.length==0)
			  return 0;
		  Stack<Integer> stk=new Stack<Integer>(); //store the indexes
		  int maxArea=0;
		  int i=0;
		  
		  while(i<height.length){
			  if(stk.isEmpty()||height[stk.peek()]<=height[i])
				  stk.push(i++);
			  else{
				  int top=stk.pop();
				  int max=height[top]*(stk.empty()?i:i-stk.peek()-1);
				  if(max>maxArea)
					  maxArea=max;
			  }
		  }
		  while(!stk.isEmpty()){
			  int top=stk.pop();
			  int max=height[top]*(stk.isEmpty()?i:i-stk.peek()-1);
			  if(max>maxArea)
				  maxArea=max;
		  }
		  return maxArea;
	  }
	  
	  public int maximalRectangle2(char[][] matrix) {
		  int n=matrix.length;
		  int m=matrix[0].length;
		  int[][] dp=new int[n][m];
		  for(int i=0;i<m;i++){
			  dp[0][i]=matrix[0][i]-'0';
		  }
		  
		  for(int i=1;i<n;i++){
			  for(int j=0;j<m;j++){
				  if(matrix[i][j]=='1')
					  dp[i][j]=dp[i-1][j]+1;
			  }
		  }
		  int maxArea=0;
		  
		  for(int i=0;i<n;i++){
			  maxArea=Math.max(maxArea, largestRectangle(dp[i]));
		  }
		  return maxArea;
		  
	  }
	  
	  
	  public int largestRectangle(int[] h){
		  Stack<Integer> stk=new Stack<Integer>();
		  int i=0;
		  int maxArea=0;
		  while(i<h.length){
			  if(stk.isEmpty()||h[stk.peek()]<=h[i])
				  stk.push(i++);
			  else{
				  int top=stk.pop();
				  int max=h[top]*(stk.isEmpty()?i:i-stk.peek()-1);
				  if(max>maxArea)
					  maxArea=max;
			  }
		  }
		  
		  while(!stk.isEmpty()){
			  int top=stk.pop();
			  int max=h[top]*(stk.isEmpty()?i:i-stk.peek()-1);
			  if(max>maxArea)
				  maxArea=max;
		  }
		  return maxArea;
	  }
	  
	  public boolean isMatch(String s, String p) {
		  if(p.length()==0)
			  return s.length()==0;
		  
		  if(p.length()==1||p.charAt(1)!='*'){
			  if(s.length()<1||p.charAt(0)!='.'&&p.charAt(0)!=s.charAt(0))
				  return false;
			  return isMatch(s.substring(1),p.substring(1));
		  }
		  else{
			  int length=s.length();
			  int i=-1;
			  while(i<length&&(i<0||p.charAt(0)=='.'||p.charAt(0)==s.charAt(i))){
				  if(isMatch(s.substring(i+1),p.substring(2)))
					  return true;
				  i++;
			  }
			  
		  }
		  return false;
	  }
	  
	  public boolean isNumber(String s) {
		  
		  s=s.trim();
		  if(s.length()==0)
			  return false;
		  boolean canSign=true;
		  boolean canDot=true;
		  boolean canE=false;
		  boolean hasE=false;
		  boolean hasNum=false;
		  
		  int i=0;
		  while(i<s.length()){
			  char c=s.charAt(i++);
			  if(c==' ')
				  return false;
			  if(c=='+'||c=='-'){
				  if(!canSign)
					  return false;
				  canSign=false;
			  }
			  else if(c=='.'){
				  if(!canDot)
					  return false;
				  canDot=false;
				  canSign=false;
			  }
			  else if(c=='e'||c=='E'){
				  if(!canE||hasE)
					  return false;
				  canE=false;
				  hasE=true;
				  hasNum=false;
				  canDot=false;
				  canSign=true;//e can have sign again
			  }
			  else if(c>='0'&&c<='9'){
				  hasNum=true;
				  canSign=false;
				  if(!canE&&!hasE)
					  canE=true;
			  }
			  else
				  return false;
		  }
		  return hasNum;
	  }
	  
	  public double findMedianSortedArrays(int A[], int B[]) {
		  int n1=A.length;
		  int n2=B.length;
		  int n=n1+n2;
		  if(n%2==0){
			  return (findKth(A,0,n1,B,0,n2,n/2)+findKth(A,0,n1,B,0,n2,n/2+1))/2.0;
		  }
		  return findKth(A,0,n1,B,0,n2,n/2+1);
	  }
	  
	  public int findKth(int[]A, int aoffset, int m, int[] B, int boffset, int n, int k){
		  if(m>n)
			  return findKth(B,boffset,n,A,aoffset,m,k);
		  if(m==0)
			  return B[k-1];
		  if(k==1)
			  return Math.min(A[aoffset], B[boffset]);
		  int pa=Math.min(m, k/2);
		  int pb=k-pa;
		  
		  if(A[aoffset+pa-1]<B[boffset+pb-1])
			  return findKth(A,aoffset+pa,m-pa,B,boffset,n,k-pa);
		  return findKth(A,aoffset,m,B,boffset+pb,n-pb,k-pb);
	  }
	  
	  
	  public static int maxPoints(Point[] points) {
		  if(points.length<=2)
			  return points.length;
		  
		  int maxPoints=1;
		  
		  for(int i=0;i<points.length;i++){
			  ArrayList<Double> slopes=new ArrayList<Double>();
			  int dup=1;
			  for(int j=0;j<points.length;j++){
				  if(i!=j){
					  if(points[i].x==points[j].x){
						  if(points[i].y==points[j].y)
							  dup++;
						  else
							  slopes.add(Double.MAX_VALUE);
					  }
					  else{
						  double slope=1.0*(points[j].y-points[i].y)/(points[j].x-points[i].x);
						  slopes.add(slope);
					  }
				  }
			  }
			  
			  Collections.sort(slopes);
			  int count=1;
			  if(slopes.size()==0)
				  count=0;
			  
			  System.out.println(slopes);
			  for(int k=1;k<slopes.size();k++){
//				  System.out.println(slopes.get(k)+" "+slopes.get(k-1));
//				  System.out.println(slopes.get(k).equals(slopes.get(k-1)));
				  if(slopes.get(k).equals(slopes.get(k-1)))
					  count++;
				  else{
					  if(count+dup>maxPoints){
						  maxPoints=count+dup;
					  }		
					  count=1;
				  }
//				  System.out.println(count+" "+dup);
			  }
			 
			  if(count+dup>maxPoints)
				  maxPoints=count+dup;
		  }
		  return maxPoints;
	  }
	  
	  
	  public static int maxPoints2(Point[] points) {
		  if(points.length<=2)
			  return points.length;
		  int res=0;
		  for(int i=0;i<points.length;i++){
			  HashMap<Double, Integer> map=new HashMap<Double,Integer>();
			  int dup=1;
			  int vertical=0;
			  for(int j=i+1;j<points.length;j++){
				  if(points[i].x==points[j].x){
					  if(points[i].y==points[j].y)
						  dup++;
					  else{
						  vertical++;
					  }
				  }
				  else{
					  double k=points[j].y == points[i].y ? 0.0
								: 1.0*(points[j].y-points[i].y)/(points[j].x-points[i].x);
					  if(!map.containsKey(k))
						  map.put(k, 1);
					  else
						  map.put(k, map.get(k)+1);
				  }
			  }
			  
			  Iterator<Double> it=map.keySet().iterator();
			  while(it.hasNext()){
				  
				  double key=it.next();
				  System.out.println(key+" "+map.get(key));
				  if(map.get(key)+dup>res)
					  res=map.get(key)+dup;
			  }
			  res=Math.max(vertical+dup, res);
//			  for(Integer it2:map.values()){
//				  if(it2.intValue()+dup>res){
//					  res=it2.intValue()+dup;
//				  }
//			  }
		  }
		  return res;
		 
	  }
	  
	  
	  public static int maxProductSubarray(int[] A){
		  int max_ending_here=1;
		  int min_ending_here=1;
		  int max=1;
		  
		  for(int i=0;i<A.length;i++){
			  if(A[i]>0){
				  max_ending_here*=A[i];
				  min_ending_here=Math.min(min_ending_here,1);
			  }
			  else if(A[i]==0){
				  max_ending_here=1;
				  min_ending_here=1;
			  }
			  else{
				  int tmp=max_ending_here;
				  max_ending_here=Math.max(1, min_ending_here*A[i]);
				  min_ending_here=tmp*A[i];
			  }
			  max=Math.max(max, max_ending_here);
		  }
		  return max;
	  }
	  
//	  public static String removerDirtyChars(String s1, String s2){
//		  int[] count=new int[256];
//		  for(int i=0;i<s2.length();i++){
//			  count[s2.charAt(i)]++;
//		  }
//		  
//		  String res="";
//		  for(int i=0;i<s1.length();i++){
//			  if(count[s1.charAt(i)]==0)
//				  res+=s1.charAt(i);
//			  else
//				  count[s1.charAt(i)]--;
//		  }
//		  return res;
//	  }
	  
	  public static String removerDirtyChars(String s1, String s2){
		  boolean[] count=new boolean[256];
		  for(int i=0;i<s2.length();i++){
			  count[s2.charAt(i)]=true;
		  }
		  
		  String res="";
		  for(int i=0;i<s1.length();i++){
			  if(!count[s1.charAt(i)])
				  res+=s1.charAt(i);
		  }
		  return res;
	  }
	  
	  public static int getMinChange(int[] coins, int amount){
		  int[] dp=new int[amount+1];
//		  int coin=0;
		  dp[0]=0;
		  for(int i=1;i<=amount;i++){
			  int coin=Integer.MAX_VALUE;
			  for(int j=0;j<coins.length;j++){
				  if(coins[j]<=i)
					  coin=Math.min(coin, dp[i-coins[j]]);
			  }
			  if(coin<Integer.MAX_VALUE)
				  dp[i]=coin+1;
			  else
				  dp[i]=Integer.MAX_VALUE;
		  }
		  return dp[amount];
	  }
	  
	  
	  public static ArrayList<String[]> solveNQueens(int n) {
		  ArrayList<String[]>  res=new ArrayList<String[]> ();
		  int[] loc=new int[n];
		  dfsNQueens(0,loc,res);
		  return res;
	  }
	  
	  public static  void dfsNQueens(int cur, int[] loc, ArrayList<String[]> res){
		  System.out.println("ss");
		  if(cur==loc.length){
			  printBoard(loc,res);
			  return;
		  }
		  for(int i=0;i<loc.length;i++){
			  loc[cur]=i;
			  if(isValidBoard(loc,cur))
				  dfsNQueens(cur+1,loc,res);
		  }
	  }
	  
	  public static boolean isValidBoard(int[] loc, int cur){
		  for(int i=0;i<cur;i++){
			  if(loc[i]==loc[cur]||Math.abs(loc[i]-loc[cur])==cur-i)
				  return false;
		  }
		  return true;
	  }
	  
	  public static void printBoard(int[] loc, ArrayList<String[]>  res){
		  int n=loc.length;
		  String[] sol=new String[n];
		  for(int i=0;i<n;i++){
			  String row="";
			  for(int j=0;j<n;j++){
				  if(loc[i]==j)
					  row+="Q";
				  else
					  row+=".";
			  }
			  sol[i]=row;
		  }
		  res.add(sol);
	  }
	  
	  public int totalNQueens(int n) {
		  int[] total={0};
		  int[] loc=new int[n];
		  dfsQueens(0,loc,total);
		  return total[0];
	  }
	  
	  public void dfsQueens(int cur, int[] loc, int[] total){
		  if(cur==loc.length)
			  total[0]++;
		  else{
			  for(int i=0;i<loc.length;i++){
				  loc[cur]=i;
				  if(isValidBoard(loc,cur))
					  dfsQueens(cur+1,loc,total);
			  }
		  }
	  }
	  
//	  public boolean isValidBoard(int[] loc, int cur){
//		  for(int i=0;i<cur;i++){
//			  if(loc[i]==loc[cur]||Math.abs(loc[cur]-loc[i])==cur-i)
//				  return false;
//		  }
//		  return true;
//	  }
	  
	  public static TreeNode constructBSTpre(int[] preorder){
		  int n=preorder.length;
		  if(n==0)
			  return null;
		  return constructBSTpreUtil(preorder,0, n-1);
	  }
	  
	  public static TreeNode constructBSTpreUtil(int[] preorder,int beg, int end){
		  if(beg>end)
			  return null;
		  TreeNode root=new TreeNode(preorder[beg]);
		  if(beg==end)
			  return root;
		  int index=end;
		  for(int i=beg;i<=end;i++){
			  if(preorder[i]>root.val){
				  index=i;
				  break;
			  }
		  }
		  root.left=constructBSTpreUtil(preorder,beg+1,index-1);
		  root.right=constructBSTpreUtil(preorder, index,end);
		  return root;
	  }
	  
	  
	  public static TreeNode constructBSTpost(int[] postorder){
		  int n=postorder.length;
		  if(n==0)
			  return null;
		  return constructBSTpostUtil(postorder,0, n-1);
	  }
	  
	  public static TreeNode constructBSTpostUtil(int[] postorder,int beg, int end){
		  if(beg>end)
			  return null;
		  TreeNode root=new TreeNode(postorder[end]);
		  if(beg==end)
			  return root;
		  int index=end;
		  for(int i=end;i>=beg;i--){
			  if(postorder[i]<root.val){
				  index=i;
				  break;
			  }
		  }
		  root.left=constructBSTpostUtil(postorder,beg,index);
		  root.right=constructBSTpostUtil(postorder, index+1,end-1);
		  return root;
	  }
	  
	  
	  public static TreeNode constructTree(int[] pre){
		  if(pre.length==0)
			  return null;
		  TreeNode root=new TreeNode(pre[0]);
		  Stack<TreeNode> stk=new Stack<TreeNode>();
		  stk.push(root);
		  
		  for(int i=1;i<pre.length;i++){
			  TreeNode top=null;
			  while(!stk.isEmpty()&&pre[i]>stk.peek().val)
				  top=stk.pop();
			  
			  if(top!=null){
				  root.right=new TreeNode(pre[i]);
			  	  stk.push(root.right);
			  }
			  else{
				  stk.peek().left=new TreeNode(pre[i]);
				  stk.push(stk.peek().left);
			  }
		  }
		  return root;
	  }
	  
	  public void solve(char[][] board) {
		  int m=board.length;
		  if(m==0)
			  return;
		  int n=board[0].length;
		  for(int i=0;i<m;i++){
			  bfsBoard(board,i,0);
			  bfsBoard(board,i,n-1);
		  }
		  
		  for(int i=1;i<n-1;i++){
			  bfsBoard(board,0,i);
			  bfsBoard(board,m-1,i);
		  }
		  
		  for(int i=0;i<m;i++){
			  for(int j=0;j<n;j++){
				  if(board[i][j]=='O')
					  board[i][j]='X';
				  if(board[i][j]=='#')
					  board[i][j]='O';
			  }
		  }
	  }
	  
	  public void bfsBoard(char[][] board, int i, int j){
		  Queue<Integer[]> que=new LinkedList<Integer[]>();
		  if(board[i][j]=='O')
			  que.add(new Integer[]{i,j});
		  
		  while(!que.isEmpty()){
			  Integer[] id=que.poll();
			  int x=id[0];
			  int y=id[1];
			  board[i][j]='#';
			  if(x-1>=0&&board[x-1][y]=='O')
				  que.add(new Integer[]{x-1,y});
			  if(x+1<board.length&&board[x+1][y]=='O')
				  que.add(new Integer[]{x+1,y});
			  if(y-1>=0&&board[x][y-1]=='O')
				  que.add(new Integer[]{x,y-1});
			  if(y+1<board[0].length&&board[x][y+1]=='O')
				  que.add(new Integer[]{x,y+1});
		  }
	  }
	  
	  //find pair in bst whose sum ==k
	  public static boolean findPairEqualSumBST(TreeNode root, int k){
		  if(root==null||root.left==null&&root.right==null)
			  return false;
		  Stack<TreeNode> stk1=new Stack<TreeNode>();
		  Stack<TreeNode> stk2=new Stack<TreeNode>();
		  
		  TreeNode cur1=root, cur2=root;
		  
		  while(true){
			  if(cur1!=null){
				  stk1.push(cur1);
				  cur1=cur1.left;
			  }
			  else if(cur2!=null){
				  stk2.push(cur2);
				  cur2=cur2.right;
			  }
			  else if(!stk1.isEmpty()&&!stk2.isEmpty()){
				  cur1=stk1.peek();
				  cur2=stk2.peek();
				  // tree already traversed
				  if(cur1.val>=cur2.val)
					  return false;
				  int sum=cur1.val+cur2.val;
				  if(sum==k)
					  return true;
				  else if(sum<k){
					  cur1=stk1.pop();
					  cur1=cur1.right;
					  cur2=null;
				  }
				  else{
					  cur2=stk2.pop();
					  cur2=cur2.left;
					  cur1=null;
				  }				  
			  }
			  else
				  return false;
		  }
	  }
	  // find the sume of nodes with no siblings in a binary tree
	  public static int findSumOfNoSiblingsNodes(TreeNode root){
		  if(root==null)
			  return 0;
		  //we check if the node has only one child, if yes, then we need to inculde the value.
		  int sum=0;
		  if(root.left!=null&&root.right==null)
			  sum+=root.left.val;
		  else if (root.left==null&&root.right!=null)
			  sum+=root.right.val;
		  //recursively call to find if there are node with only one sibling
		  return sum+findSumOfNoSiblingsNodes(root.left)+findSumOfNoSiblingsNodes(root.right);
	  }
	  
	  // find nodes K distance from given node
	  public static void printKDistanceNodes(TreeNode root, TreeNode node, int k){
		  if(root==null)
			  return;
		  kDistanceAncestor(root,node,k);
		  kDistanceChildren(node,k);
	  }
	  
	  public static void kDistanceChildren(TreeNode node, int k){
		  if(node==null||k<0)
			  return;
		 if(k==0){
			 System.out.println(node.val+" ");
			 return;
		 }
		 kDistanceChildren(node.left,k-1);
		 kDistanceChildren(node.right,k-1);
		 
	  }
	  
	  public static void kDistanceAncestor(TreeNode root, TreeNode node, int k){
		  Stack<TreeNode> stk=new Stack<TreeNode>();
		  boolean[] found=new boolean[1];
		  
		  getPathFromRootToNode(root,node,stk,found);
		  
		  for(int i=k;i>0;i--)
			  System.out.print(stk.pop().val+" ");
	  }
	  
	  public static void getPathFromRootToNode(TreeNode root, TreeNode node, Stack<TreeNode> stk, boolean[] found){
		  if(root==null)
			  return;
		  if(root.val==node.val){
			  found[0]=true;
			  return ;
		  }
		  stk.push(root);
		  getPathFromRootToNode(root.left,node,stk,found);
		  getPathFromRootToNode(root.right,node,stk,found);
		  if(!found[0])
			  stk.pop();
	  }
	  
	  
	  public static TreeNode findParent(TreeNode root, TreeNode node){
		  if(root==null)
			  return null;
		  if(root.left==node||root.right==node)
			  return root;
		  TreeNode lparent=findParent(root.left,node);
		  TreeNode rparent=findParent(root.right,node);
		  return lparent==null?rparent:lparent;
	  }
	  
	  public static ArrayList<String>  sortedPermutations ( String s ){
		  ArrayList<String> res=new ArrayList<String>();
		  if(s.length()==0)
			  return res;
		  char[] ch=s.toCharArray();
		  Arrays.sort(ch);
		  boolean[] used=new boolean[s.length()];
		  sortedPermutationsUtil(0,s, "", used, res);
		  return res;
	  }
	  
	  public static void sortedPermutationsUtil(int dep, String s, String sol,boolean[] used, ArrayList<String> res){
		  if(dep==s.length()){
			  res.add(sol);
			  return;
		  }
		  for(int i=0;i<s.length();i++){
			  if(!used[i]){
				  used[i]=true;
				  sol+=s.charAt(i);
				  sortedPermutationsUtil(dep+1,s,sol,used, res);
				  used[i]=false;
				  sol=sol.substring(0,sol.length()-1);				  
			  }
		  }
	  }
	  
//	  Given a level, child index return the child node for a binary tree.
	  public static TreeNode getNodebyLevelAndIndex(TreeNode root, int level, int index){
		  if(root==null)
			  return null;
		  Queue<TreeNode> que=new LinkedList<TreeNode>();
		  int curlevel=0;
		  int nextnum=0;
		  int curnum=0;
		  que.add(root);
		  curnum++;
		  int curindex=0;
		  while(!que.isEmpty()){
			  TreeNode top=que.remove();
			  if(curlevel==level&&curindex==index)
				  return top;
			  curnum--;
			  curindex++;
			  if(top.left!=null){
				  que.add(top.left);
				  nextnum++;
			  }
			  if(top.right!=null){
				  que.add(top.right);
				  nextnum++;
			  }
			  if(curnum==0){
				  curlevel++;
				  curindex=0;
				  curnum=nextnum;
				  nextnum=0;
			  }
		  }
		  return null;
	  }
	
	  public static int rowWithMostZeroes(int[][] matrix){
		  int index=0;
		  
		  int j=lastZeroInRow(matrix[0]);
		  if(j==-1)
			  j=0;
		  
		  for(int i=1;i<matrix.length;i++){
			  while(j<matrix[0].length&&matrix[i][j]==0){
				  j++;
				  index=i;
			  }
		  }
		  return index;
	  }
	  
	  public static int lastZeroInRow(int[] A){
		  if(A.length==0)
			  return -1;
		  int beg=0;
		  int end=A.length-1;
		  while(beg<=end){
			  int mid=(beg+end)/2;
			  if((mid==A.length-1||A[mid+1]==1)&&A[mid]==0)
				  return  mid;
			  else if(A[mid]==0)
				  beg=mid+1;
			  else
				  end=mid-1;
		  }
		  return -1;
	  }
	  
	  public static int findKthSamllestOfSortedMatrix(int[][] matrix, int k){
		  int m=matrix.length;
		  if(m==0)
			  return -1;
		  int n=matrix[0].length;
		  PriorityQueue<Integer> heap=new PriorityQueue<Integer>(50);
		 
		  for(int i=0;i<m;i++){
			  heap.add(matrix[i][0]);
		  }
//		  int count=0;
		  int num=Integer.MIN_VALUE;
		  for(int i=0;i<m;i++){
			  for(int j=1;j<n;j++){
				 num=heap.poll();
				 k--;
				 if(k==0)
					 return num;
				 heap.add(matrix[i][j]);
			  }
		  }
		  
		  while(!heap.isEmpty()&&k!=0){
			  num=heap.poll();
			  k--;
			  }
		  if(k==0)
			  return num;
		  else
			  return Integer.MAX_VALUE;
 
	  }
	  
	  public static int findOddTimesNum(int[] A){
		  int ones = 0;  
		   int twos = 0;  
		   int not_threes, x;  

		   for (int i=0; i<A.length; ++i) {  
		            x =  A[i];  
		            twos |= ones & x;  
		            ones ^= x;  
		            not_threes = ~(ones & twos);  
		            ones &= not_threes;  
		            twos &= not_threes;  
		   }  
		   return ones;
	  }
	  
	  
	  public static ArrayList<ArrayList<Integer>> findAllPairEqualSumBST(TreeNode root, int k){
			ArrayList<ArrayList<Integer>> res=new ArrayList<ArrayList<Integer>>();
			if(root==null||root.left==null&&root.right==null)
				  return res;
			  Stack<TreeNode> stk1=new Stack<TreeNode>();
			  Stack<TreeNode> stk2=new Stack<TreeNode>();
			  
			  TreeNode cur1=root, cur2=root;
			  
			  while(true){
				  if(cur1!=null){
					  stk1.push(cur1);
					  cur1=cur1.left;
				  }
				  else if(cur2!=null){
					  stk2.push(cur2);
					  cur2=cur2.right;
				  }
				  else if(!stk1.isEmpty()&&!stk2.isEmpty()){
					  cur1=stk1.peek();
					  cur2=stk2.peek();
					  // tree already traversed
					  if(cur1.val>=cur2.val)
						  return res;
					  int sum=cur1.val+cur2.val;
					  if(sum==k){
						  System.out.println(cur1.val+" "+cur2.val);
						 ArrayList<Integer> sol=new ArrayList<Integer>();
						 sol.add(cur1.val);
						 sol.add(cur2.val);
						 res.add(sol);
						 cur1=stk1.pop();
						 cur1=cur1.right;
						 cur2=stk2.pop();
						 cur2=cur2.left;
					  }
					  else if(sum<k){
						  cur1=stk1.pop();
						  cur1=cur1.right;
						  cur2=null;
					  }
					  else{
						  cur2=stk2.pop();
						  cur2=cur2.left;
						  cur1=null;
					  }				  
				  }
				  else
					  return res;
				
			}
		}
	  
	  public static void bubbleSort(int[] A){
		  if(A.length<2)
			  return;
		  for(int i=0;i<A.length-1;i++){
			  for(int j=1;j<A.length-i;j++){
				  if(A[j-1]>A[j]){
					  int t=A[j-1];
					  A[j-1]=A[j];
					  A[j]=t;
				  }
			  }
		  }
		  
		  System.out.println(Arrays.toString(A));
	  }
	  
	  
	  public static ListNode reverseListRecur(ListNode head){
		  if(head==null||head.next==null)
			  return head;
		  ListNode pnext=head.next;
		  head.next=null;
		  ListNode node=reverseListRecur(pnext);
		  pnext.next=head;
		  return node;
	  }
	  
	  
//	  public static int solution(int N) {
//	        // write your code in Java SE 7
//		  int res=digitSum(factorial(new BigInteger(""+N))).intValue();
//	        if(res>100000000)
//	            return -1;
//	        return res;
//		}
//		private static BigInteger digitSum(BigInteger  n){
//		        if(n.compareTo(BigInteger.TEN)==-1) return n;
//		        else return n.mod(BigInteger.TEN).add(digitSum(n.divide(BigInteger.TEN)));
//		}
//		private static BigInteger factorial(BigInteger n){
//	        	if(n.equals(BigInteger.ONE)) return BigInteger.ONE;
//	        	else return n.multiply(factorial(n.subtract(BigInteger.ONE)));
//		}
	  
	  public static int digitSumOfFactorial(int N) {
	        // write your code in Java SE 7
	        int res=digitSum(factorial(new BigInteger(""+N))).intValue();
	        if(res>100000000)
	            return -1;
	        return res;
	    }
	    
	    public static BigInteger digitSum(BigInteger n){
	        if(n.compareTo(BigInteger.TEN)==-1)
	            return n;
	        else
	            return n.mod(BigInteger.TEN).add(digitSum(n.divide(BigInteger.TEN)));
	    }
	    
	    public static BigInteger factorial(BigInteger n){
	        if(n.equals(BigInteger.ONE))
	            return BigInteger.ONE;
	        else
	            return n.multiply(factorial(n.subtract(BigInteger.ONE)));
	    }
		
	    
	    public static int deepSum(List<Object> list){
	    	if(list.size()==0)
	    		return 0;
	    	return deepSumUtil(list,1);
	    }
	    public static int deepSumUtil(List<Object> list, int dep){
	    	if(list.size()==0)
	    		return 0;
	    	int sum=0;
	    	for(int i=0;i<list.size();i++){
	    		Object o=list.get(i);
	    		if(o instanceof List){
	    			List l=(List) o;
	    			sum+=deepSumUtil(l, dep+1);
	    		}
	    		else
	    			sum+=(int)o*dep;
	    	}
	    	return sum;
	    }
	    
	    
	    public ArrayList<Integer> spiralOrder1(int[][] matrix) {
	    	ArrayList<Integer> res=new ArrayList<Integer>();
	    	int m=matrix.length;
	    	if(m==0)
	    		return res;
	    	int n=matrix[0].length;
	    	
	    	int top=0;
	    	int bottom=m-1;
	    	int left=0;
	    	int right=n-1;
	    	
	    	while(true){
	    		for(int i=left;i<=right;i++){
	    			res.add(matrix[top][i]);
	    		}
	    		if(++top>bottom)
	    			break;
	    		
	    		for(int i=top;i<=bottom;i++)
	    			res.add(matrix[i][right]);
	    		if(--right<left)
	    			break;
	    		
	    		for(int i=right;i>=left;i--)
	    			res.add(matrix[bottom][i]);
	    		if(--bottom<top)
	    			break;
	    		
	    		for(int i=bottom;i>=top;i--)
	    			res.add(matrix[i][left]);
	    		if(++left>right)
	    			break;
	    	}
	    	return res;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr={3,1,3,0,2,0};
//		Vector v=new Vector();
		System.out.println(Arrays.toString(twoSum2(arr,0)));
		int[] digits={9};
		System.out.println(Arrays.toString(plusOne(digits)));
		
		int[][] matrix={{0,1}};
		setZeroes(matrix);
		
		int[] candy={2,2};
		System.out.println(candySpaceOp(candy));
		
		TreeNode root=new TreeNode(1);
		root.right=new TreeNode(5);
		root.left=new TreeNode(3);
		root.right.left=new TreeNode(4);
		root.right.left.right=new TreeNode(1);
		root.right.right=new TreeNode(5);
		root.left.right=new TreeNode(6);
		System.out.println("--------------------");
		TreeNode lstHead=convert2DLL(root);
		
		while(lstHead!=null){
			System.out.print(lstHead.val+" ");
			lstHead=lstHead.right;
		}
		
		System.out.println("--------------------");
		
//		System.out.println(pathSumOne(root,11));
//		
//		System.out.println(levelOrder(root));
		
		System.out.println(maxTimesEggs(100));
		System.out.println(maxTimesEggs(2,100));
		int[] num={-1,-1,3,-1};
		System.out.println(permuteUnique(num));
		
		ListNode head=new ListNode(1);
		ListNode n1=new ListNode(2);
		ListNode n2=new ListNode(3);
		ListNode n3=new ListNode(4);
		ListNode n4=new ListNode(5);
		ListNode n5=new ListNode(6);
		head.next=n1;
		n1.next=n2;
		n2.next=n3;
		n3.next=n4;
		n4.next=n5;
		
		ListNode groupHead=reverseKGroup(head,2);
		while(groupHead!=null){
			System.out.print(groupHead.val+" OOOOXXXX");
			groupHead=groupHead.next;
		}
		System.out.println();
		
		ListNode n=removeNthFromEnd(head,3);
		
		while(n!=null){
			System.out.print(n.val+" ");
			n=n.next;
		}
		System.out.println();
		System.out.println(longestPalindrome("abaca"));
		
		System.out.println(minWindow2("aa", "aa"));
		System.out.println(countAndSay(3));
		
		System.out.println(isPalindrome(121));
		int[] A={2,4,6,8,7,5,4,3};
		
		System.out.println(findMaxRepeating(A,8));
		
		ListNode r1=reverseList(head);
		while(r1!=null){
			System.out.print(r1.val+"# ");
			r1=r1.next;
		}
		System.out.println();
		findIndex(A, 1);
		sortList(head);
		String[] L={"foo", "bar"};
		System.out.println(findSubstring("barfoothefoobarman",L));
		int[] S={1,2,3};
		System.out.println(subsetsWithDup(S));
		System.out.println(subsets(S));
		
		int[] A1={1,1,1,2};
		System.out.println(removeDuplicates2(A1));
		
		int[] A2={3,4,5,1,2};
		System.out.println(search(A2,2));
		
		System.out.println(getPermutation2(1,1));
		
		System.out.println(multiply("19","10"));
		
		int[] range={5, 6,7, 7, 7,8, 8, 10};
		int[] range1={1};
		searchRange2(range,8);
		
		System.out.println(isScramble("rgtae","great"));
		
		int[] jump={1,2,3};
		System.out.println(jump(jump));
		
		int[] arr1={3,2,6,5,4,7,9,1};
		System.out.println(findKth(arr1,8));
		System.out.println(kthSmall(arr1,5));
		System.out.println(findKthLargest(arr1,8));
		int[] dup={1,2,7,5,4,1,3,4};
		System.out.println(elementInKdistance(dup,3));
		
		
		 ComplexListNode complexhead=new ComplexListNode(1);
	      ComplexListNode cn1=new ComplexListNode(2);
	      ComplexListNode cn2=new ComplexListNode(3);
	      ComplexListNode cn3=new ComplexListNode(4);
	      
	      ComplexListNode child1=new ComplexListNode(5);
	      ComplexListNode child2=new ComplexListNode(6);
	      ComplexListNode child3=new ComplexListNode(7);
	      
	      ComplexListNode child4=new ComplexListNode(8);
	      ComplexListNode child5=new ComplexListNode(9);
	      ComplexListNode child6=new ComplexListNode(10);
	      
	      complexhead.next=cn1;
	      cn1.next=cn2;
	      cn2.next=cn3;
	      
	      complexhead.child=child1;
	      child1.next=child2;
	      
	      cn2.child=child3;
	      child3.next=child4;
	      
	      child4.child=child5;
	      child5.next=child6;
	      
	      ComplexListNode retNode=flattenMultiLevelList(complexhead);
	      
	      while(retNode!=null){
	    	  System.out.print(retNode.val+" ");;
	    	  retNode=retNode.next;
	      }
	      System.out.println();
	      
	      System.out.println(grayCode(2));
	      char[] colors={ 'R', 'G', 'B', 'B', 'G', 'R', 'Y'};
	      System.out.println(findMaxCouples(colors));
	      String sentence="This is a String";
	      System.out.println(reversSentencs(sentence));
	      
	      int subarr[] = {3, 1, 1, 2, 2, 13};
	      System.out.println(findPartiion(subarr));
	      
	      TreeNode root1=new TreeNode(1);
	      root1.right=new TreeNode(5);
			root1.left=new TreeNode(3);
			root1.right.left=new TreeNode(4);
			root1.right.left.right=new TreeNode(1);
			root1.right.right=new TreeNode(5);
			root1.left.right=new TreeNode(6);
			System.out.println("--------------------");
	      TreeNode root2=new TreeNode(5);
	      root2.right=new TreeNode(8);
	      root2.left=new TreeNode(2);
	      root2.left.left=new TreeNode(1);
	      root2.left.right=new TreeNode(4);
	      root2.left.right.left=new TreeNode(3);
	      root2.right.right=new TreeNode(9);
	      root2.right.right.left=new TreeNode(10);
	      root2.right.left=new TreeNode(7);
	      System.out.println("*****************************************xxxxxxxxx****************");
	      System.out.println(getNodebyLevelAndIndex(root2,3,0).val);
	      System.out.println(findParent(root2, root2.right.left).val);
	      printKDistanceNodes(root2,root2.left,2);
	      System.out.println("Fengpeng yuan");
	      System.out.println(findSumOfNoSiblingsNodes(root2));
	      
	      System.out.println(inorderSuccessor(root2,root2).val);
	      
	      verticalSum(root1);
	      
	      System.out.println(isMirror(root1,root2));
	      
	      inorder(root1);
	      System.out.println();
//	      mirror(root1);
//	      inorder(root1);
//	      System.out.println();
//	      inorder(root2);
//	      System.out.println();
//	      replaceNode(root2);
//	      inorder(root2);
//	      System.out.println();
	      
	      System.out.println(diameter(root1));
	      int[] A3={2,3,6,2};
	      
	      System.out.println(checkIfSumZero(A3));
	      
	      Set<String> set=new HashSet<String>();
	      set.add("cat");
	      set.add("cats");
	      set.add("and");
	      set.add("sand");
	      set.add("dog");
	      
	      System.out.println(wordBreak("catsanddog",set));
	      
	      System.out.println(reversSentencs(sentence));
	      
	      System.out.println(isRotated("waterbottle","terbottlewa"));
	      
	      int[] elements={1,2,5,7,9,6,4,3,2,1};
	      System.out.println(findElement(elements, 9));
	      
	      System.out.println(longestPalindromeDP("bb"));
	      
	      System.out.println(minCut2("aabcecbd"));
	      int[] height={4,2};
	      System.out.println(largestRectangleArea(height));
	      
	      int[] search={1};
	      System.out.println(search2(search,0));
//	      (84,250),(0,0),(1,0),(0,-70),(0,-70),(1,-1),(21,10),(42,90),(-42,-230)
//	      Point[] points={new Point(84,250),new Point(0,0),new Point(1,0),new Point(0,-70),new Point(0,-70),
//	    		  new Point(1,-1),new Point(21,10),new Point(42,90),new Point(-42,-230)};
	      Point[] points={new Point(2,3),new Point(-2,3),new Point(5,3)};
	      System.out.println(maxPoints(points));
	      System.out.println(maxPoints2(points));
	      
	      int prod[] = {1, -2, -3, 0, 7, -8, -2};
	      System.out.println(maxProductSubarray(prod));
	      
	      System.out.println(removerDirtyChars("geeksforgeeks","mask"));
	      
	      int[] coins={1,3,4};
	      System.out.println(getMinChange(coins,10));
	      
	      System.out.println(solveNQueens(1));
	      
	      int[] pre={5,3,2,6};
	      int[] post={2,3,5};
	      TreeNode bst=constructBSTpre(pre);
	      inorder(bst);
	      System.out.println();
	      TreeNode bst2=constructBSTpost(post);
	      inorder(bst2);
	      System.out.println();
	      System.out.println(removeAdjacentDuplicates("aabbbcddfjggiijjkl"));
	      System.out.println(removeAdjacentDuplicatesRecur("aabbbcddfjggiijjkl"));
	      System.out.println(removeAdjacentDuplicatesRecur("caaabbbaac"));
	      System.out.println(sortedPermutations("abc"));
	      int[] zeroOnes={0,0,0,0,0};
	      System.out.println(lastZeroInRow(zeroOnes));
	      
	      int[][] mat={ {1, 1, 1, 1},
	    	        {1, 1, 1, 1},
	    	        {1, 1, 1, 1},
	    	        {1, 1, 1, 1}};
	      
	      System.out.println(rowWithMostZeroes(mat));
	      int[][] matrix1={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
	      System.out.println(matrix1.length+" "+matrix1[0].length);
	      System.out.println(findKthSamllestOfSortedMatrix(matrix1,16));
	      int[] odd={1,2,3,2,4,5,4,1,5};
	      System.out.println(findOddTimesNum(odd));
	
	      System.out.println(findAllPairEqualSumBST(root2,11));
	      
	      int[] bubble={5,2,1,6,7,9,4,3};
	      bubbleSort(bubble);
	      
	      
	      ListNode rn=new ListNode(1);
	      ListNode rn1=new ListNode(2);
	      ListNode rn2=new ListNode(3);
	      ListNode rn3=new ListNode(4);
	      ListNode rn4=new ListNode(5);
	      ListNode rn5=new ListNode(6);
	      ListNode rn6=new ListNode(7);
	      
	      rn.next=rn1;
	      rn1.next=rn2;
	      rn2.next=rn3;
	      rn3.next=rn4;
	      rn4.next=rn5;
	      rn5.next=rn6;
	      
	      ListNode rev=reverseListRecur(rn);
	      
	      while(rev!=null){
	    	  System.out.print(rev.val+" ");
	    	  rev=rev.next;
	      }
	      System.out.println();
	      
	      System.out.println(digitSumOfFactorial(14));
	      
	      List list=new ArrayList();
	      list.add(1);
	      List sub1=new ArrayList();
	      sub1.add(4);
	      
	      
	      List sub2=new ArrayList();
	      sub2.add(6);
	      sub1.add(sub2);
	      
	      list.add(sub1);
	      System.out.println(list);
	      
	      System.out.println(deepSum(list));
	      
	     double[] aa={1.0,2.1,3.0,4.33};
	     double[] ccc=aa;
	     System.out.println(Arrays.toString(ccc));
	     
	     ArrayList<Integer> tlist=new ArrayList<Integer>();
	     tlist.add(1);
	     tlist.add(2);
	     tlist.add(4);
	     tlist.add(3);
	     
	     for(int i=0;i<tlist.size();i++){
	    	 if(tlist.get(i)==ccc[2]){
	    		 System.out.println("find it!");
	    	 }
	    	 else
	    		 tlist.add((int) ccc[2]);
	     }
	     System.out.println(tlist);
	     
	     double[] ppre=new double[3];
	     double[] curr=new double[7];
	     for(int i=0;i<7;i++)
	    	 curr[i]=i+1;
	     ppre=curr;
	     System.out.println(Arrays.toString(ppre));
	     System.out.println(Math.PI/7.5);
	     
	}

}

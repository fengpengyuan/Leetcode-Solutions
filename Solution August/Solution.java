package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
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

public class Solution {
	static String name="";
	
	public static String changeName(String s){
		String realname=s;
		name=realname;
		return realname;
	}
	
	public static int longestValidParentheses(String s){
		int n=s.length();
		if(n<2)
			return 0;
		Stack<Integer> stk=new Stack<Integer>();
		int max=0;
		int last=-1;
		for(int i=0;i<n;i++){
			if(s.charAt(i)=='(')
				stk.push(i);
			else{
				if(stk.isEmpty())
					last=i;
				else{
					stk.pop();
					if(stk.isEmpty())
						max=Math.max(max, i-last);
					else
						max=Math.max(max, i-stk.peek());
				}
			}
		}
		return max;
	}

	
	public ArrayList<String> restoreIpAddresses(String s) {
        ArrayList<String> res=new ArrayList<String>();
        if(s.length()<4||s.length()>12)
        	return res;
        String sol="";
        restoreIpAddressUtil(0,s,sol,res);
        return res;
    }
	
	public void restoreIpAddressUtil(int dep, String s, String sol, ArrayList<String> res){
		if(dep==3&&isValidNum(s))
			res.add(sol+s);
		for(int i=1;i<4&&i<s.length();i++){
			if(isValidNum(s.substring(0,i)))
				restoreIpAddressUtil(dep+1,s.substring(i),sol+s.substring(0,i)+'.',res);
		}
	}
	
	public boolean isValidNum(String s){
		if(s.charAt(0)=='0')
			return s.equals("0");
		int num=Integer.parseInt(s);
		return num>0&&num<=255;
	}
	
	public static void findTriple(int[]A){
		if(A.length<3)
			return;
		int n=A.length;
		int[] leftmin=new int[n];
		int[] rightmax=new int[n];
		int min=A[0];
		for(int i=0;i<n;i++){
			if(A[i]<min)
				min=A[i];
			leftmin[i]=min;
		}
		int max=A[n-1];
		for(int i=n-1;i>=0;i--){
			if(A[i]>max)
				max=A[i];
			rightmax[i]=max;
		}
		
		for(int i=1;i<n-1;i++){
			if(A[i]>leftmin[i]&&A[i]<rightmax[i])
				System.out.println(leftmin[i]+" "+A[i]+" "+rightmax[i]);
		}
	}
	
	
	public static int[] profitStock(int[] prices){
		int[] res={-1,-1};
		if(prices.length<2)
			return res;
		int min=prices[0];
		int max=0;
		for(int i=1;i<prices.length;i++){
			if(min>prices[i])
				min=prices[i];
			if(prices[i]-min>max){
				max=prices[i]-min;
				res[0]=min;
				res[1]=prices[i];
			}
		}
		System.out.println(Arrays.toString(res));
		return res;
	}
	
	public static ArrayList<String> wordBreak(String s, Set<String> dict) {
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
	
	public static void wordBreakUtil(int cur,String s, boolean[][] dp, String sol, ArrayList<String> res){
		if(cur==s.length()){
			res.add(sol);
		}
		
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
	
	public static ArrayList<Integer> intersection(ArrayList<Integer> lst1, ArrayList<Integer> lst2){
		ArrayList<Integer> res=new ArrayList<Integer>();
		if(lst1.size()==0||lst2.size()==0)
			return res;
		for(int i=0;i<lst1.size()&&i<lst2.size();i++){
			int num1=lst1.get(i);
			int num2=lst2.get(i);
			if(!res.contains(num1))
				res.add(num1);
			
			if(!res.contains(num2))
				res.add(num2);
		}
		return res;
	}
	
	
	public static void skipMdeleteN(ListNode head, int m, int n){
		if(head==null)
			return;
		ListNode cur=head;
		while(cur!=null){
			for(int i=0;i<m-1&&cur!=null;i++)
				cur=cur.next;
			if(cur==null)
				return;
			ListNode t=cur.next;
			for(int i=0;i<n&&t!=null;i++)
				t=t.next;
			cur.next=t;
			cur=t;
		}
	}
	
	
	public static int kthLevelSum(TreeNode root,int k){
		if(root==null)
			return 0;
		int[] sum={0};
		kthLevelSum(root,0,k,sum);
		return sum[0];
	}
	
	public static void kthLevelSum(TreeNode root, int cur, int k, int[] sum){
		if(root==null)
			return;
		if(cur==k){
			sum[0]+=root.val;
		}
		kthLevelSum(root.left,cur+1,k,sum);
		kthLevelSum(root.right,cur+1,k,sum);
	}
	
	public static int getHeight(TreeNode root){
		if(root==null)
			return 0;
		int left=getHeight(root.left);
		int right=getHeight(root.right);
		return left>right?left+1:right+1;
	}
	public static int longestPathLeafToLeaf(TreeNode root){
		if(root==null)
			return 0;
		int left=longestPathLeafToLeaf(root.left);
		int right=longestPathLeafToLeaf(root.right);
		
		int both=getHeight(root.left)+getHeight(root.right)+1;
		
		return Math.max(Math.max(left, right),both);
		
	}
	
	public static boolean isPalindrome(ListNode head){
		int len=0;
		ListNode cur=head;
		while(cur!=null){
			len++;
			cur=cur.next;
		}
		
		return isPalindrome( head, len);
		
	}
	
	public static boolean isPalindrome(ListNode head, int len){
		if(head==null)
			return false;
		if(len==1)
			return true;
		ListNode cur=head;
		for(int i=0;i<len-1;i++)
			cur=cur.next;
		
		if(head.val!=cur.val)
			return false;
		return isPalindrome(head.next,len-2);
			
	}
	
	public static boolean isPalindrome2(ListNode head){
		//can be done via reversing the list and compare with the original one
		if(head==null)
			return false;
		if(head.next==null)
			return true;
		ListNode fast=head;
		ListNode slow=head;
		ListNode pre=head;
		while(fast!=null&&fast.next!=null){
			fast=fast.next.next;
			if(fast==null)
				break;
			pre=slow;
			slow=slow.next;
		}
		
		ListNode second=slow.next;
		slow.next=null;
		
		ListNode node=reverseList(second);
		
		ListNode cur=head;
		while(node!=null){
			if(node.val!=cur.val)
				return false;
			node=node.next;
			cur=cur.next;
		}
		return true;
		
		
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
	
//	There is a N*N integer matrix Arr[N][N]. From the row r and column c, 
//	we can go to any of the following three indices:
//	I.                Arr[ r+1 ][ c-1 ] (valid only if c-1>=0)
//
//	II.               Arr[ r+1 ][ c ]
//
//	III.              Arr[ r+1 ][ c+1 ] (valid only if c+1<=N-1)
//
//	So if we start at any column index on row 0, what is the largest sum of any of the paths till row N-1.
	
	public static int findMaxFromFirstRow(int[][] matrix){
		int n=matrix.length;
		if(n==0)
			return 0;
		int m=matrix[0].length;
		
		int[][] dp=new int[n][m];
		for(int i=0;i<m;i++){
			dp[0][i]=matrix[0][i];
		}
		
		for(int i=1;i<n;i++){
			for(int j=0;j<m;j++){
				if(j==0){
					dp[i][j]=Math.max(dp[i-1][j], dp[i-1][j+1])+matrix[i][j];
				}
				else if(j==m-1){
					dp[i][j]=Math.max(dp[i-1][j], dp[i-1][j-1])+matrix[i][j];
				}
				else
					dp[i][j]=Math.max(dp[i-1][j], Math.max(dp[i-1][j-1],dp[i-1][j+1]))+matrix[i][j];
			}
		}
		
		int max=Integer.MIN_VALUE;
		for(int i=0;i<m;i++){
			if(dp[n-1][i]>max)
				max=dp[n-1][i];
		}
		return max;
	}
	
	public static int[] nextGreatestElement(int[] A){
		int n=A.length;
		int[] res=new int[n];
		res[n-1]=-1;
		int max=A[n-1];
		for(int i=n-2;i>=0;i--){
			res[i]=max;
			if(A[i]>max)
				max=A[i];
		}
		System.out.println(Arrays.toString(res));
		return res;
	}
	
	public static char findFirstNonRepeating(String s){
		if(s.length()==0)
			return '0';
		s=s.toLowerCase();
		int[] count=new int[256];
		
		for(int i=0;i<s.length();i++){
			count[s.charAt(i)]++;
		}
		
		for(int i=0;i<s.length();i++){
			if(count[s.charAt(i)]==1)
				return s.charAt(i);
		}
		return '0';
	}
	
	
	public static char findFirstNonRepeating2(String s){
		int n=s.length();
		s=s.toLowerCase();
		CountIndex[] count=new CountIndex[256];
		
		for(int i=0;i<n;i++){
			if(count[s.charAt(i)]==null){
				CountIndex ci=new CountIndex(1,i);
				count[s.charAt(i)]=ci;
			}
			else{
				count[s.charAt(i)].count++;
			}
		}
		
		int index=n;
		for(int i=0;i<256;i++){
			if(count[i]!=null){
				if(count[i].count==1&&index>count[i].index)
					index=count[i].index;
			}
		}
		return s.charAt(index);
	}
	
	public static boolean all9s(int[] num){
		for(int i=0;i<num.length;i++){
			if(num[i]!=9)
				return false;
		}
		return true;
	}
	
	public static int[] nextSmallestPalindrome(int[] num){
		int n=num.length;
		if(all9s(num)){
			int[] res=new int[n+1];
			res[0]=res[n]=1;
			System.out.println(Arrays.toString(res));
			return res;
		}
		
		return generateNextSmallestPalindromeUtil(num);
			
	}
	
	public static int[] generateNextSmallestPalindromeUtil(int[] num){
		int n=num.length;
		int mid=n/2;
		int i=mid-1;
		int j=n%2==1?mid+1:mid;
		
		boolean leftsmaller=false;
		
		while(i>=0&&num[i]==num[j]){
			i--;
			j++;
		}
		if(i<0||num[i]<num[j])
			leftsmaller=true;
		
		while(i>=0){
			num[j++]=num[i--];
		}
		
		if(leftsmaller){
			int carry=1;
			i=mid-1;
			
			if(n%2==1){
				num[mid]+=carry;
				carry=num[mid]/10;
				num[mid]%=10;
				j=mid+1;
			}
			else
				j=mid;
			
			while(i>=0){
				num[i]+=carry;
				carry=num[i]/10;
				num[i]%=10;
				num[j++]=num[i--];
			}
		}
		System.out.println(Arrays.toString(num));
		return num;
	}
	
	
	public static int distanceBetweenNodes(TreeNode root, TreeNode node1, TreeNode node2){
		if(root==null)
			return 0;
		if(node1==node2)
			return 0;
		if(covers(root.left,node1)&&covers(root.left,node2))
			return distanceBetweenNodes(root.left,node1,node2);
		else if(covers(root.right,node1)&&covers(root.right,node2))
			return distanceBetweenNodes(root.right,node1,node2);
		return 
				getLevel(root,node1)+getLevel(root,node2);
	}
	
	public static boolean covers(TreeNode root, TreeNode node){
		if(root==null)
			return false;
		if(root==node)
			return true;
		return covers(root.left,node)||covers(root.right,node);
	}
	
	public static int getLevel(TreeNode root, TreeNode node){
		if(root==null)
			return -1;
		return getNodeLevelUtil(root, node,0);
	}
	public static int getNodeLevelUtil(TreeNode root, TreeNode node, int cur){
		if(root==null)
			return -1;
		if(root==node)
			return cur;
		int downLevel=getNodeLevelUtil(root.left,node,cur+1);
		if(downLevel!=-1)
			return downLevel;
		else
			return getNodeLevelUtil(root.right,node,cur+1);
	}
	
	public static void topKStrings(String[] strs,int k){
		HashMap<String, Integer> map=new HashMap<String,Integer>();
		for(int i=0;i<strs.length;i++){
			if(!map.containsKey(strs[i]))
				map.put(strs[i], 1);
			else
				map.put(strs[i], map.get(strs[i])+1);
		}
		
		Comparator<StringFreq> cp=new Comparator<StringFreq>(){

			@Override
			public int compare(StringFreq o1, StringFreq o2) {
				// TODO Auto-generated method stub
				return o1.freq-o2.freq;
			}
			
		};
		PriorityQueue<StringFreq> que=new PriorityQueue<StringFreq>(k,cp);
		Iterator<String> it=map.keySet().iterator();
		while(it.hasNext()){
			String s=it.next();
			int freq=map.get(s);
			StringFreq sf=new StringFreq(s,freq);
			if(que.size()<k){
				que.add(sf);
			}
			else{
				if(sf.freq>que.peek().freq){
					que.remove();
					que.add(sf);
				}
			}
		}
		
		while(!que.isEmpty()){
			System.out.print(que.remove().s+" ");
		}
	}
	
	
	
	public static int minMakeChange(int[] coins, int m){
		int[] dp=new int[m+1];
		dp[0]=0;
		
		for(int i=1;i<=m;i++){
			int t=Integer.MAX_VALUE;;
			for(int j=0;j<coins.length;j++){
				if(coins[j]<=i){
					t=Math.min(t, dp[i-coins[j]]);
				}
			}
			if(t<Integer.MAX_VALUE)
				dp[i]=t+1;
			else
				dp[i]=Integer.MAX_VALUE;
		}
		return dp[m];
	}
	public static int maxProductSubarray(int[] A){
		int max_ending_here=1;
		int min_ending_here=1;
		int max=1;
		
		for(int i=0;i<A.length;i++){
			if(A[i]>0){
				max_ending_here*=A[i];
				min_ending_here*=A[i];
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
			max=Math.max(max_ending_here, max);
		}
		return max;
	}
	
	public static ListNode reverseKGroup(ListNode head, int k){
		if(head==null||head.next==null)
			return head;
		ListNode dummy=new ListNode(0);
		dummy.next=head;
		
		ListNode cur=head;
		ListNode pre=dummy;
		
		while(cur!=null){
			for(int i=0;i<k-1&&cur!=null;i++){
				cur=cur.next;
			}
			if(cur==null)
				break;
			pre=reverseList(pre,cur.next);
			cur=pre.next;
		}
		return dummy.next;
	}
	
	public static ListNode reverseList(ListNode pre, ListNode next){
		ListNode last=pre.next;
		ListNode cur=last.next;
		
		while(cur!=next){
			last.next=cur.next;
			cur.next=pre.next;
			pre.next=cur;
			
			cur=last.next;
		}
		return last;
	}
	
	
	
	public static String serializeTree(TreeNode root){
		if(root==null)
			return "";
		String res="";
		Queue<TreeNode> que=new LinkedList<TreeNode>();
		que.add(root);
		while(!que.isEmpty()){
			TreeNode top=que.remove();
			if(top==null)
				res+="#";
			else{
				res+=top.val;
				que.add(top.left);
				que.add(top.right);
			}
		}
		return res;
	}
	
	public static void inorder(TreeNode root){
		if(root==null)
			return;
		inorder(root.left);
		System.out.print(root.val+" ");
		inorder(root.right);
	}
	
	
	public static TreeNode deserializeTree(String res){
		if(res.length()==0||res.charAt(0)=='#')
			return null;
		int p=0;
		TreeNode root=new TreeNode(res.charAt(p++)-'0');
		Queue<TreeNode> que=new LinkedList<TreeNode>();
		que.add(root);
		while(!que.isEmpty()){
			TreeNode top=que.poll();
			TreeNode left=null;
			TreeNode right=null;
			System.out.println(res.charAt(p)+" "+p);
			if(p<res.length()&&res.charAt(p)!='#')
				left=new TreeNode(res.charAt(p++)-'0');
			else
				p++;
			if(p<res.length()&&res.charAt(p)!='#')
				right=new TreeNode(res.charAt(p++)-'0');
			else
				p++;
			top.left=left;
			top.right=right;
			if(left!=null)
				que.add(left);
			if(right!=null)
				que.add(right);
		}
		return root;
	}
	
//	public static TreeNode getNode(String res, int[] p){
//		if(p[0]>=res.length()||res.charAt(p[0])=='#')
//			return null;
//		return new TreeNode(res.charAt(p[0])-'0');
//		
//	}
	
	
	public static TreeNode constructBST(int[] pre){
		if(pre.length==0)
			return null;
		return constructBSTUtil(pre,0,pre.length-1);
	}
	public static TreeNode constructBSTUtil(int[] pre, int beg, int end){
		if(beg>end)
			return null;
		TreeNode root=new TreeNode(pre[beg]);
		if(beg==end)
			return root;
		int index=end+1;
		for(int i=beg+1;i<=end;i++){
			if(pre[i]>root.val){
				index=i;
				break;
			}
		}
		root.left=constructBSTUtil(pre,beg+1,index-1);
		root.right=constructBSTUtil(pre,index,end);
		return root;
	}
	
	public static void solve(char[][] board) {
		int m=board.length;
		if(m==0)
			return;
		int n=board[0].length;
		//left
		for(int i=0;i<m;i++){
			if(board[i][0]=='O')
				dfsBoard(board,i,0);
		}
		//right
		
		for(int i=0;i<m;i++){
			if(board[i][n-1]=='O')
				dfsBoard(board,i,n-1);
		}
		// top
		for(int i=1;i<n-1;i++){
			if(board[0][i]=='O')
				dfsBoard(board,0,i);
		}
		// bottom
		for(int i=1;i<n-1;i++){
			if(board[m-1][i]=='O')
				dfsBoard(board,m-1,i);
		}
		
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				if(board[i][j]=='O')
					board[i][j]='X';
				if(board[i][j]=='#')
					board[i][j]='O';
			}
		}
		
		for(int i=0;i<m;i++){
			System.out.println(Arrays.toString(board[i]));
		}
	}
	
	public static void dfsBoard(char[][] board, int i, int j){
		if(i>=0&&i<board.length&&j>=0&&j<board[0].length&&board[i][j]=='O'){
			board[i][j]='#';
			dfsBoard(board,i+1,j);
			dfsBoard(board,i-1,j);
			dfsBoard(board,i,j+1);
			dfsBoard(board,i,j-1);
		}
	}
	
	public static void solve2(char[][] board) {
		int m=board.length;
		if(m==0)
			return;
		int n=board[0].length;
		Queue<Integer> que=new LinkedList<Integer>();
		for(int i=0;i<m;i++){
			if(board[i][0]=='O')
				bfsBoard(board,i,0,que);
		}
		
		for(int i=0;i<m;i++){
			if(board[i][n-1]=='O')
				bfsBoard(board,i,n-1,que);
		}
		
		for(int i=1;i<n-1;i++){
			if(board[0][i]=='O')
				bfsBoard(board,0,i,que);
		}
		
		for(int i=1;i<n-1;i++){
			if(board[m-1][i]=='O')
				bfsBoard(board,m-1,i,que);
		}
		
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				if(board[i][j]=='O')
					board[i][j]='X';
				if(board[i][j]=='#')
					board[i][j]='O';
			}
		}
		for(int i=0;i<m;i++){
			System.out.println(Arrays.toString(board[i]));
		}
	}
	public static void bfsBoard(char[][] board, int i, int j, Queue<Integer> que){
		if(i>=0&&i<board.length&&j>=0&&j<board[0].length&&board[i][j]=='O'){
			que.add(i*board.length+j);
			board[i][j]='#';
			
			while(!que.isEmpty()){
				int cur=que.poll();
				
				int x=cur/board.length;
				int y=cur%board.length;
				bfsBoard(board,x+1,y,que);
				bfsBoard(board,x-1,y,que);
				bfsBoard(board,x,y+1,que);
				bfsBoard(board,x,y-1,que);				
			}
		}
	}
	
	static Queue<Integer> que=new LinkedList<Integer>();
	public static void solve3(char[][] board) {
		int m=board.length;
		if(m==0)
			return;
		int n=board[0].length;
		
		for(int i=0;i<m;i++){
			if(board[i][0]=='O')
				bfsBoard(board,i,0);
		}
		
		for(int i=0;i<m;i++){
			if(board[i][n-1]=='O')
				bfsBoard(board,i,n-1);
		}
		
		for(int i=1;i<n-1;i++){
			if(board[0][i]=='O')
				bfsBoard(board,0,i);
		}
		
		for(int i=1;i<n-1;i++){
			if(board[m-1][i]=='O')
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
		for(int i=0;i<m;i++){
			System.out.println(Arrays.toString(board[i]));
		}
	}
	
	public static void fill(char[][] board, int i, int j){
		if(i<0||i>=board.length||j<0||j>=board[0].length||board[i][j]!='O')
			return;
		int id=i*board[0].length+j;
		que.add(id);
		board[i][j]='#';
	}
	
	public static void bfsBoard(char[][] board, int i, int j){
		fill(board, i, j);
		while(!que.isEmpty()){
			int id=que.remove();
			int x=id/board[0].length;
			int y=id%board[0].length;
			fill(board,x+1,y);
			fill(board,x-1,y);
			fill(board,x,y+1);
			fill(board,x,y-1);
		}
	}
	
	public static int largestIndependentSet(TreeNode root){
		if(root==null)
			return 0;
		int children=largestIndependentSet(root.left)+largestIndependentSet(root.right);
		int parent=1;
		if(root.left!=null)
			parent+=largestIndependentSet(root.left.left)+largestIndependentSet(root.left.right);
		if(root.right!=null)
			parent+=largestIndependentSet(root.right.left)+largestIndependentSet(root.right.right);
		return Math.max(parent, children);
		
	}
	// bst find pair sum equal give sum k
	public static boolean isPairPresent(TreeNode root, int k){
		if(root==null)
			return false;
		Stack<TreeNode> stk1=new Stack<TreeNode>();
		Stack<TreeNode> stk2=new Stack<TreeNode>();
		TreeNode cur1=root,cur2=root;

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
	
	public static void getNoSiblingsNodes(TreeNode root){
		if(root==null)
			return;
		if(root.left!=null&&root.right==null)
			System.out.print(root.left.val+" ");
		else if(root.left==null&&root.right!=null)
			System.out.print(root.right.val+" ");
		getNoSiblingsNodes(root.left);
		getNoSiblingsNodes(root.right);
	}
	

	public static ListNode deletNodeFromCirlularList(ListNode head, int val){
		if(head==null)
			return null;
		if(head.next==head&&head.val==val)
			return null;
//		ListNode dummy=new ListNode(0);
//		ListNode cur=head.next;
//		while(cur.next!=head){
//			cur=cur.next;
//		}
//		cur.next=dummy;
//		dummy.next=head;
//		ListNode pre=dummy;
//		cur=head;
		ListNode cur=head.next;
		ListNode pre=head;
		
		while(cur!=head&&cur.val!=val){
			pre=cur;
			cur=cur.next;
		}
		if(cur.val==val){
			if(cur==head){
				head=cur.next;
				pre.next=head;
			}
			else{
				pre.next=cur.next;
			}
		}
		return head;
		
	}
//	Delete node from a Doubly Circular Linked List
	public static DListNode deletNodeFromDoublyCirlularList(DListNode head, int val){
		if(head==null)
			return null;
		if(head.next==head&&head.val==val)
			return null;
		DListNode cur=head.next;
		
		while(cur!=head&&cur.val!=val){
			cur=cur.next;
		}
		
		if(cur.val==val){
			if(cur==head){
				head=head.next;
				head.pre=cur.pre;
				cur.pre.next=head;
			}
			else{
//				DListNode previous=cur.pre;
//				previous.next=cur.next;
//				cur.next.pre=previous;
				cur.pre.next=cur.next;
				cur.next.pre=cur.pre;
			}
		}
		return head;
	}
	
	public static void leftViewOfTree(TreeNode root){
		if(root==null)
			return;
		int[] level={0};
		leftViewOfTreeUtil(root,level,1);
	}
	
	public static void leftViewOfTreeUtil(TreeNode root, int[] level,int cur){
		if(root==null)
			return;
		if(cur>level[0]){
			System.out.print(root.val+" ");
			level[0]=cur;
		}
		leftViewOfTreeUtil(root.left,level,cur+1);
		leftViewOfTreeUtil(root.right,level,cur+1);
		
	}
	
	 public static int findMin3DigitNum(int N){
		 for(int i=100;i<1000;i++){
			 if(getProduct(i)==N)
				 return i;
		 }
		 return -1;
	 }
	 
	 public static int getProduct(int num){
		 int prod=1;
		 while(num>0){
			 int last=num%10;
			 prod*=last;
			 num/=10;
		 }
		 return prod;
	 }
	 
	 public static ArrayList<ArrayList<Integer>> subsetSum(int[] A, int target){
		 ArrayList<ArrayList<Integer>> res=new ArrayList<ArrayList<Integer>>();
		 if(A.length==0)
			 return res;
		 ArrayList<Integer> sol=new ArrayList<Integer>();
		 Arrays.sort(A);
		 subsetSum(0,A,sol,res,target,0, 0);
		 return res;
	 }
	public static void subsetSum(int dep,int[]A, ArrayList<Integer> sol,ArrayList<ArrayList<Integer>> res, int target, int cur, int cursum){
		if(dep==A.length||cursum>target)
			return;
		if(cursum==target){
			ArrayList<Integer> out=new ArrayList<Integer>(sol);
			res.add(out);
			return;
		}
			
		for(int i=cur;i<A.length;i++){
			cursum+=A[i];
			sol.add(A[i]);
			subsetSum(dep+1,A,sol,res,target,i+1,cursum);
			cursum-=A[i];
			sol.remove(sol.size()-1);
		}
	}
	
	public static TreeNodeP LCAncestor(TreeNodeP node1, TreeNodeP node2){
		if(node1==null||node2==null)
			return null;
		int h1=0;
		TreeNodeP cur1=node1;
		while(cur1!=null){
			h1++;
			cur1=cur1.parent;
		}
		int h2=0;
		cur1=node2;
		while(cur1!=null){
			h2++;
			cur1=cur1.parent;
		}
		
		if(h2>h1){
			TreeNodeP t=node1;
			node1=node2;
			node2=t;
		}
		
		for(int i=0;i<Math.abs(h1-h2);i++)
			node1=node1.parent;
//		if(h1>h2){
//			for(int i=0;i<h1-h2;i++)
//				node1=node1.parent;
//		}
//		else{
//			for(int i=0;i<h2-h1;i++)
//				node2=node2.parent;
//		}
		
		while(node1!=null&&node2!=null){
			if(node1==node2)
				return node1;
			node1=node1.parent;
			node2=node2.parent;
		}
		return null;
	}
	
	
	public static String reverseString(String s){
		if(s.length()<2)
			return s;
		return reverseString(s.substring(1))+s.charAt(0);
	}
	
	public static void topKLargestestNum(int[] nums, int k){
		int n=nums.length;
		if(n<k)
			return;
		int kth=findKthLargest(nums,0,nums.length-1,k);
		
		for(int i=0;i<=kth;i++)
			System.out.print(nums[i]+" ");
	}
	
	public static int findKthLargest(int[] nums, int start, int end, int k){
		int pivot=start;
		int left=start;
		int right=end;
		while(left<=right){
			while(left<=right&&nums[left]>=nums[pivot])
				left++;
			while(left<=right&&nums[right]<=nums[pivot])
				right--;
			if(left<right)
				swap(nums,left,right);
		}
		swap(nums,pivot,right);
		if(k==right+1)
			return right;
		else if(k>right+1)
			return findKthLargest(nums,right+1,end,k);
		else
			return findKthLargest(nums,start,right-1,k);
			
	}
	public static void swap(int[] nums, int i, int j){
		int t=nums[i];
		nums[i]=nums[j];
		nums[j]=t;
	}
	
	
	public static TreeNodeP inorderSucc(TreeNodeP node){
		if(node==null)
			return null;
		TreeNodeP succ=null;
		if(node.parent==null||node.right!=null){
			return leftMostChild(node.right);
		}
		else{
			
			while((succ=node.parent)!=null){
				if(succ.left==node)
					break;
				node=succ;
			}
			return succ;
		}
	}
	
	public static TreeNodeP leftMostChild(TreeNodeP node){
		if(node==null)
			return null;
		while(node.left!=null)
			node=node.left;
		return node;
	}
	
	
	public static TreeNodeP inorderSuccessorBST(TreeNodeP node){
		if(node==null)
			return null;
		if(node.right!=null){
			return leftMostChild(node.right);
		}
		
		TreeNodeP p=node.parent;
		while(p!=null&&node==p.right){
			node=p;
			p=p.parent;
		}
		return p;
	}
	
	public static int[] inorderTrav(TreeNode root){
		if(root==null)
			return null;
		int n=countNodes(root);
		int[] inorder=new int[n];
		int[] index={0};
		inorderTravUtil(root,inorder,index);
		System.out.println(Arrays.toString(inorder));
		return inorder;
	}
	
	public static int countNodes(TreeNode root){
		if(root==null)
			return 0;
		return countNodes(root.left)+countNodes(root.right)+1;
	}
	public static void inorderTravUtil(TreeNode root, int[] inorder, int[] index){
		if(root==null)
			return;
		inorderTravUtil(root.left,inorder,index);
		inorder[index[0]]=root.val;
		index[0]++;
		inorderTravUtil(root.right,inorder,index);
	}
	
	public static ArrayList<Pair> findPathOfMaze(int[][] maze, int startr, int startc){
		ArrayList<Pair> res=new ArrayList<Pair>();
		int m=maze.length;
		if(m==0)
			return res;
		int n=maze[0].length;
		boolean[][] used=new boolean[m][n];
		boolean t=findPathOfMaze(maze,startr, startc,used,res);
		System.out.println(t);
		return res;
	}
	
	public static boolean findPathOfMaze(int[][] maze, int i, int j, boolean[][] used,ArrayList<Pair> res){
		if(i==maze.length-1&&j==maze[0].length-1)
			return true;
		if(i>=0&&i<maze.length&&j>=0&&j<maze[0].length&&maze[i][j]==0&&!used[i][j]){
			used[i][j]=true;
			Pair p=new Pair(i,j);
			res.add(p);
			boolean t=findPathOfMaze(maze,i+1,j,used,res)||findPathOfMaze(maze,i-1,j,used,res)
					||findPathOfMaze(maze,i,j-1,used,res)||findPathOfMaze(maze,i,j+1,used,res);
			if(t)
				return true;
			else{
				used[i][j]=false;
				res.remove(res.size()-1);
			}
		}
	
		return false;
	}
	
	public static int totalNodesOfLevelK(TreeNode root, int k){
		if(root==null)
			return 0;
		int[] count={0};
		totalNodesOfLevelK(root, k,count,0);
		return count[0];
	}
	
	public static void totalNodesOfLevelK(TreeNode root, int k, int[] count,int curlevel){
		if(root==null)
			return;
		if(curlevel==k)
			count[0]++;
		totalNodesOfLevelK(root.left,k,count,curlevel+1);
		totalNodesOfLevelK(root.right,k,count,curlevel+1);
	}
	
	
	public static int findKthOfSortedMatrix(int[][] matrix, int k){
		int m=matrix.length;
		if(m==0)
			return -1;
		int n=matrix[0].length;
		boolean[][] visited=new boolean[m][n];
		PriorityQueue<MatrixNode> heap=new PriorityQueue<MatrixNode>(k+1,new Comparator<MatrixNode>(){

			@Override
			public int compare(MatrixNode n1, MatrixNode n2) {
				// TODO Auto-generated method stub
				return n2.val-n1.val;
			}
			
		});
		heap.add(new MatrixNode(matrix[m-1][n-1],m-1,n-1));
		visited[m-1][n-1]=true;
		
		return findKthOfSortedMatrix(matrix,heap,visited, k, 0);
	}
	
	public static int findKthOfSortedMatrix(int[][] matrix, PriorityQueue<MatrixNode> heap,boolean[][] visited, int k, int count){
		MatrixNode top=heap.poll();
		count++;
		if(count==k)
			return top.val;
		
		if(top.i-1>=0&&!visited[top.i-1][top.j]){
			heap.offer(new MatrixNode(matrix[top.i-1][top.j],top.i-1,top.j));
			visited[top.i-1][top.j]=true;
		}
		if(top.j-1>=0&&!visited[top.i][top.j-1]){
			heap.offer(new MatrixNode(matrix[top.i][top.j-1],top.i,top.j-1));
			visited[top.i][top.j-1]=true;
		}
		return findKthOfSortedMatrix(matrix,heap,visited,k,count);
	}
	
	
	
	public static int kthLargestOfSortedMatrix(int[][] matrix, int k){
		int m=matrix.length;
		if(m==0)
			return -1;
		int n=matrix[0].length;
		PriorityQueue<Integer> heap=new PriorityQueue<Integer>(k+1,new Comparator<Integer>(){

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o2-o1;
			}
			
		});
		for(int i=n-1;i>=0;i--)
			heap.add(matrix[m-1][i]);
		int num=Integer.MIN_VALUE;
		for(int i=m-2;i>=0;i--){
			for(int j=n-1;j>=0;j--){
				num=heap.poll();
				k--;
				if(k==0)
					return num;
				heap.offer(matrix[i][j]);
			}
		}
		while(!heap.isEmpty()&&k!=0){
			num=heap.poll();
			k--;
		}
		if(k==0)
			return num;
		else
			return Integer.MIN_VALUE;
	}
	
	
	public static int findPathWithMaxSum(int[][] matrix){
		int m=matrix.length;
		if(m==0)
			return -1;
		int n=matrix[0].length;
		int[][] dp=new int[m][n];
		ArrayList<Pair> list=new ArrayList<Pair>();
		dp[0][0]=matrix[0][0];
		for(int i=1;i<m;i++){
			dp[i][0]=dp[i-1][0]+matrix[i][0];
		}
		
		for(int j=1;j<n;j++)
			dp[0][j]=dp[0][j-1]+matrix[0][j];
		HashMap<Pair,Pair> map=new HashMap<Pair, Pair>();
		Pair p=null;
		Pair tp=null;
		for(int i=1;i<m;i++){
			for(int j=1;j<n;j++){
				dp[i][j]=Math.max(dp[i-1][j], dp[i][j-1])+matrix[i][j];
				p=new Pair(i,j);
				if(dp[i-1][j]>dp[i][j-1])
					tp= new Pair(i-1,j);
				else
					tp=new Pair(i,j-1);
				map.put(p, tp);
			}
		}
		
		int min=Integer.MAX_VALUE;
		
		while(map.containsKey(p)){
			list.add(map.get(p));
			min=Math.min(min, matrix[map.get(p).first][map.get(p).second]);
			p=map.get(p);
		}
		System.out.println(list);
		return min;
	}
	
	public static int findMinOfRotatedArray(int[] A){
		if(A.length==0)
			return -1;
		return findMinOfRotatedArray(A, 0, A.length-1);
	}
	
	public static int findMinOfRotatedArray(int[]A, int beg, int end){
		if(A.length==0)
			return -1;
		if(A[beg]<A[end])
			return beg;
		int mid=beg+(end-beg)/2;
		if(A[beg]==A[mid])
			return A[beg]<A[end]?beg:end;
		if(A[beg]>A[mid])
			return findMinOfRotatedArray(A, beg,mid);
		else
			return findMinOfRotatedArray(A,mid+1,end);
		
	}
	
	
	public static void quickSort(int[] A){
		if(A.length<2)
			return;
		quickSort(A,0,A.length-1);
		System.out.println(Arrays.toString(A));
	}
	public static void quickSort(int[] A, int beg, int end){
		if(beg>end)
			return;
		int pivot=partition(A,beg,end);
		quickSort(A,beg,pivot-1);
		quickSort(A,pivot+1,end);
	}
	
	public static int partition(int[] A, int beg, int end){
		int pivot=beg;
		int left=beg;
		int right=end;
		
		while(left<=right){
			while(left<=right&&A[left]<=A[pivot])
				left++;
			while(left<=right&&A[right]>A[pivot])
				right--;
			if(left<right){
				swap(A,left,right);
//				left++;
//				right--;
			}
		}
		swap(A,pivot,right);
		return right;
	}
	
	public static boolean hasArrayTwoCandidates(int A[], int target){
		if(A.length<2)
			return false;
		HashMap<Integer, Integer> map=new HashMap<Integer, Integer>();
		
		for(int i=0;i<A.length;i++){
			int t=target-A[i];
			if(map.containsKey(t))
				return true;
			else
				map.put(A[i],i);
		}
		return false;
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
	
	public static ListNode reverseListIterative(ListNode head){
		if(head==null||head.next==null)
			return head;
		ListNode cur=head;
		ListNode pre=null;
		while(cur!=null){
			ListNode pnext=cur.next;
			cur.next=pre;
			pre=cur;
			cur=pnext;
		}
		return pre;
		
	}
	
	
	public static boolean anagram(String s1, String s2){
		if(s1.length()!=s2.length())
			return false;
		int[] letters=new int[256];
		
		for(int i=0;i<s1.length();i++)
			letters[s1.charAt(i)]++;
		
		for(int i=0;i<s2.length();i++){
			char c=s2.charAt(i);
			if(letters[c]==0)
				return false;
			letters[c]--;
		}
		
		for(int i=0;i<256;i++){
			if(letters[i]!=0)
				return false;
		}
		return true;
	}
	
	public static boolean anagram2(String s1, String s2){
		if(s1.length()!=s2.length())
			return false;
		int[] letters=new int[256];
		int uniqueNum=0;
		int completeNum=0;
		
		for(int i=0;i<s1.length();i++){
			if(letters[s1.charAt(i)]==0)
				uniqueNum++;
			letters[s1.charAt(i)]++;
		}
		
		for(int i=0;i<s2.length();i++){
			char c=s2.charAt(i);
			if(letters[c]==0)
				return false;
			letters[c]--;
			if(letters[c]==0){
				completeNum++;
				if(uniqueNum==completeNum)
					return i==s2.length()-1;
			}
		}
		
//		for(int i=0;i<256;i++){
//			if(letters[i]!=0)
//				return false;
//		}
		return false;
	}
	
	public static boolean leapfrog(int[] A){
		if(A.length==0)
			return true;
		boolean[] visited=new boolean[A.length];
//		visited[0]=true;
		
		for(int i=0;i<A.length;){
			if(visited[i])
				return false;
			i+=A[i];
		}
		return true;
	}
	
	public static void mergeSort(int[] A){
		if(A.length<2)
			return;
		mergeSort(A,0,A.length-1);
		System.out.println(Arrays.toString(A));
	}
	
	public static void mergeSort(int[] A, int beg, int end){
		if(beg>=end)
			return;
		int mid=(beg+end)/2;
		mergeSort(A,beg,mid);
		mergeSort(A,mid+1,end);
		
		int i=beg;
		int j=mid+1;
		
		while(i<=mid&&j<=end){
			if(A[i]>A[j]){
				int t=A[j];
				// Move the left array right one position to
                // make room for the smaller number
				for(int k=j-1;k>=i;k--)
					A[k+1]=A[k];
				// Put the smaller number where it belongs
				A[i]=t;
				// The right array and the middle need to be
                // shifted right
				j++;
				mid++;
			}
			// No matter what the left array moves right
			i++;
		}
	}
	
	
	public static int maxProfit(int[] prices){
	 if(prices.length<2)
	     return 0;
	 int min=prices[0];
	 int max=Integer.MIN_VALUE;
	 
	 for(int i=1;i<prices.length;i++){
	     if(prices[i]-min>max)
	         max=prices[i]-min;
	     if(prices[i]<min)
	         min=prices[i];
	 }
	 return max;
	}
	
	public boolean isBST(TreeNode root){
		if(root==null)
			return true;
		return isBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
		}

		public boolean isBSTUtil(TreeNode root, int leftmost, int rightmost){
			if(root==null)
				return true;
			if(root.val<=leftmost||root.val>=rightmost)
				return false;
			return isBSTUtil(root.left,leftmost, root.val)&&isBSTUtil(root.right,root.val, rightmost);

		}
		
		public static TreeNode LCAncestor(TreeNode root, TreeNode node1, TreeNode node2){
			if(root==null)
				return null;
			if(root==node1||root==node2)
				return root;
			TreeNode left=LCAncestor(root.left,node1,node2);
			TreeNode right=LCAncestor(root.right,node1,node2);
			
			if(left!=null&&right!=null)
				return root;
			return left==null?right:left;
		}
		
		public static int findDistance(TreeNode root, int n1, int n2){
			if(root==null)
				return -1;
			int[] d1={-1};
			int[] d2={-1};
			int[] dist={0};
			
			TreeNode lca=findDistanceUtil(root, n1,n2, d1,d2,dist,1);
			if(d1[0]!=-1&&d2[0]!=-1)
				return dist[0];
			if(d1[0]!=-1){
				return findLevel(lca,n2, 0);
			}
			if(d2[0]!=-1){
				return findLevel(lca,n1,0);
			}
			return -1;
		}
		
		public static int findLevel(TreeNode root, int n, int level){
			if(root==null)
				return -1;
			if(root.val==n)
				return level;
			int l=findLevel(root.left,n,level+1);
			return l==-1?findLevel(root.right,n,level+1):l;
		}
	
		
		public static TreeNode findDistanceUtil(TreeNode root, int n1, int n2, int[] d1, int[] d2, int[] dist, int level){
			if(root==null)
				return null;
			if(root.val==n1){
				d1[0]=level;
				return root;
			}
			if(root.val==n2){
				d2[0]=level;
				return root;
			}
			TreeNode left=findDistanceUtil(root.left,n1,n2,d1,d2,dist,level+1);
			TreeNode right=findDistanceUtil(root.right,n1,n2,d1,d2,dist,level+1);
			
			if(left!=null&&right!=null){
				dist[0]=d1[0]+d2[0]-2*level;
				return root;
			}
			return left==null?right:left;
		}
		
		public static char findNextChar(char[] list, char c){
			if(list.length==0)
				return '0';
			
			int beg=0;
			int end=list.length-1;
			char res=list[0];
			while(beg<=end){
				int mid=(beg+end)/2;
				if(list[mid]==c){
					if(mid+1<list.length)
						return list[mid+1];
					else
						return res;
				}
				else if(list[mid]<c)
					beg=mid+1;
				else{
					res=list[mid];
					end=mid-1;
				}					
			}
			return res;
				
		}
		
		public static int findDistanceBetweenWords(String sentence, String s1, String s2){
			if(sentence.length()<s1.length()+s2.length())
				return -1;
			if(s1.equals(s2))
				return 0;
			int minDis=Integer.MAX_VALUE;
			String[] strs=sentence.split(" ");
			int pre=-1;
			for(int i=0;i<strs.length;i++){
				if(strs[i].equals(s1)||strs[i].equals(s2)){
					pre=i;
					break;
				}
			}
			if(pre==-1)
				return -1;
			boolean found=false;
			
			for(int i=pre+1;i<strs.length;i++){
				if(strs[i].equals(s1)||strs[i].equals(s2)){
					if(!strs[i].equals(strs[pre])&&i-pre<minDis){
						minDis=i-pre;
						pre=i;
						found=true;
					}
					else
						pre=i;
				}
			}
			if(!found)
				return -1;
			return minDis;
		}
		
		public static int integralPartOfLog(int n){
			int res=0;
			while(n>0){
				n>>=1;
				res++;
			}
			return res;
		}
		
		public static int findDepth(String s){
			if(s.length()==0)
				return 0;
			int times=-1;
			while(true){
				times+=1;
				String str=s.replaceAll("\\(00\\)", "0");
				if(str.equals(s))
					break;
				s=str;
			}
			System.out.println(times+" "+s);
			
			if(times!=0&&s.equals("0"))
				times=times-1;
			else
				times=-1;
			
			return times;
		}
		
		public static int arraySum(int[] A){
			return arraySum(A,A.length);
		}
		
		public static int arraySum(int[] A, int n){
			if(n==0)
				return 0;
			return A[n-1]+arraySum(A,n-1);
		}
		// check red-black tree balanced
		public static boolean isBalanced(TreeNode root){
			if(root==null)
				return true;
			int[] minh={0};
			int[] maxh={0};
			return isBalancedUtil(root,minh, maxh);
		}
		
		public static boolean isBalancedUtil(TreeNode root, int[] minh, int[] maxh){
			if(root==null){
				minh[0]=0;
				maxh[0]=0;
				return true;
			}
			int[] lminh={0};
			int[] lmaxh={0};
			int[] rminh={0};
			int[] rmaxh={0};
			
			if(isBalancedUtil(root.left,lminh,lmaxh)==false)
				return false;
			if(isBalancedUtil(root.right,rminh,rmaxh)==false)
				return false;
			minh[0]=Math.min(lminh[0], rminh[0]);
			maxh[0]=Math.max(lmaxh[0], rmaxh[0]);
			
			if(maxh[0]<=minh[0]*2)
				return true;
			return false;
		}
		
		
		
		public static String reverseWords(String s) {
	        s=s.trim();
	        if(s.length()<2)
	            return s;
	        String res="";
	        char pre='0';
	        for(int i=0;i<s.length();i++){
	            char c=s.charAt(i);
	            if(c==' ' &&pre==' ')
	                continue;
	            pre=c;
	            res+=c;
	        }
	        int i=0;
	        int j=res.length()-1;
	        char[] ch=res.toCharArray();
	        reverse(ch, i, j);
	        
	        int start=0;
	        for(int k=0;k<ch.length;k++){
	            if(ch[k]==' '){
	                reverse(ch,start,k-1);
	                start=k+1;
	            }
	        }
	        reverse(ch, start, j);
	        
	        return new String(ch);	        
	        
	    }
	    
	    public static void reverse(char[] ch, int i, int j){
	        if(i>=j)
	            return;
	        while(i<j){
	            char c=ch[i];
	            ch[i]=ch[j];
	            ch[j]=c;
	            i++;
	            j--;
	        }
	    }
		
	    public static String reverseWords2(String s) {
	    s=s.trim();
	    if(s.length()<2)
	        return s;
	    String[] strs=s.split(" ");
	    String res="";
	    for(int i=strs.length-1;i>=0;i--){
	        if(!strs[i].equals("")){
	            res+=strs[i]+" ";
	        }
	    }
	    
	    return res.substring(0,res.length()-1);
	    }
	    
	    public static int findGroupsMultipleOf3(int[] arr){
	    	if(arr.length<2)
	    		return 0;
	    	int[] count=new int[3];
	    	
	    	for(int i=0;i<arr.length;i++){
	    		count[arr[i]%3]++;
	    	}
	    	int res=0;
	    	
	    	// 2 from remainder 0
	    	res+=count[0]*(count[0]-1)/2;
	    	// 1 from remainder 1 and 1 from remainder 2
	    	
	    	res+=count[1]*count[2];
	    	
	    	// 3 from remainder 0;
	    	res+=count[0]*(count[0]-1)*(count[0]-2)/6;
	    	//1 from 0 and 1 from 1 and 1 from 2;
	    	
	    	res+=count[0]*count[1]*count[2];
	    	// 3 from remainder 1
	    	res+=count[1]*(count[1]-1)*(count[1]-2)/6;
	    	//3 from remainder 2
	    	res+=count[2]*(count[2]-1)*(count[2]-2)/6;
	    	
	    	return res;
	    }
	    
	    public static int printkdistanceNode(TreeNode root, TreeNode target , int k){
	    	if(root==null)
	    		return -1;
	    	if(root==target){
	    		printkdistanceNodeDown(root, k);
	    		return 0;
	    	}
	    	
	    	int dl=printkdistanceNode(root.left,target, k);
	    	if(dl!=-1){
	    		if(dl+1==k)
	    			System.out.print(root.val+" ");
	    		else
	    			printkdistanceNodeDown(root.right,k-dl-2);
	    		return dl+1;
	    	}
	    	
	    	int dr=printkdistanceNode(root.right,target,k);
	    	
	    	if(dr!=-1){
	    		if(dr+1==k)
	    			System.out.print(root.val+" ");
	    		else
	    			printkdistanceNodeDown(root.left,k-dr-2);
	    		return dr+1;
	    	}
	    	return -1;
	    }
	    
	    public static void printkdistanceNodeDown(TreeNode root, int k){
	    	if(root==null||k<0)
	    		return;
	    	if(k==0)
	    		System.out.print(root.val+" ");
	    	printkdistanceNodeDown(root.left,k-1);
	    	printkdistanceNodeDown(root.right,k-1);
	    }
	    
	    
	    public static boolean match(String s1, String s2){
	    	if(s1.length()==0&&s2.length()==0)
	    		return true;
	    	if(s1.length()>1&&s1.charAt(0)=='*'&&s2.length()==0)
	    		return false;
	    	if((s1.length()>0&&s2.length()>0)&&(s1.charAt(0)=='?'||s1.charAt(0)==s2.charAt(0)))
	    		return match(s1.substring(1),s2.substring(1));
	    	if(s1.length()>0&&s1.charAt(0)=='*')
	    		return match(s1.substring(1),s2)||match(s1, s2.substring(1));
	    	return false;
	    }
	    
	    public static void printRightView(TreeNode root){
	    	if(root==null)
	    		return;
	    	int[] maxLevel={0};
	    	printRightViewUtil(root, maxLevel, 1);
	    }
	    
	    public static void printRightViewUtil(TreeNode root, int[] maxLevel, int level){
	    	if(root==null)
	    		return;
	    	if(maxLevel[0]<level){
	    		System.out.print(root.val+" ");
	    		maxLevel[0]=level;
	    	}
	    	
	    	printRightViewUtil(root.right,maxLevel, level+1);
	    	printRightViewUtil(root.left,maxLevel,level+1);
	    	
	    }
	    
	    
	    public static String lcs(String s1, String s2){
	    	int m=s1.length();
	    	int n=s2.length();
	    	if(m==0||n==0)
	    		return "";
	    	int[][] dp=new int[m+1][n+1];
	    	for(int i=1;i<=m;i++){
	    		for(int j=1;j<=n;j++){
	    			if(s1.charAt(i-1)==s2.charAt(j-1))
	    				dp[i][j]=dp[i-1][j-1]+1;
	    			else
	    				dp[i][j]=Math.max(dp[i-1][j], dp[i][j-1]);
	    		}
	    	}
	    	
	    	int length=dp[m][n];
	    	System.out.println(length);
	    	
	    	int i=m;
	    	int j=n;
	    	String res="";
	    	
	    	while(i>0&&j>0){
	    		if(s1.charAt(i-1)==s2.charAt(j-1)){	    			
	    			res=s1.charAt(i-1)+res;
	    			i--;
	    			j--;
	    		}
	    		else if(dp[i-1][j]>dp[i][j-1])
	    			i--;
	    		else
	    			j--;
	    	}
	    	return res;
	    }
	    
	    static TreeNode leaf=null;
	    public static TreeNode deepsetLeaf(TreeNode root){
	    	if(root==null)
	    		return null;
	    	int[] max={0};
	    	deepestLeaf(root, max,0);
	    	return leaf;
//	    	if(root.left==null&&root.right==null)
//	    		return root;
	    }
	    
	    public static void deepestLeaf(TreeNode root, int[] max, int cur){
	    	if(root==null)
	    		return;
	    	if(root.left==null&&root.right==null&&cur>max[0]){
	    		max[0]=cur;
	    		leaf= root;
	    	}
	    	
	    	deepestLeaf(root.left,max,cur+1);
	    	deepestLeaf(root.right,max,cur+1);
	    	
	    }
	    
	 // Naive Method: Returns length of smallest subarray with sum greater than x.
	 // If there is no subarray with given sum, then returns n+1
	 public static int smallestSubWithSum(int arr[], int x){
		 if(arr.length==0)
			 return 0;
		 int res=arr.length;
		 for(int i=0;i<arr.length;i++){
			 int sum=arr[i];
			 if(sum>x)
				 return 1;
			 for(int j=i+1;j<arr.length;j++){
				 sum+=arr[j];
				 if(sum>x&&j-i+1<res){
					 res=j-i+1;
					 break;
				 }
			 }
		 }
		 return res;
	 }
		
	 
	 // O(n) method
	 public static int smallestSubWithSum2(int[] arr, int x){
		 if(arr.length==0)
			 return 0;
		 int res=arr.length;
		 int sum=0;
		 int start=0;
		 for(int i=0;i<arr.length;i++){
			 while(sum>x&&start<i){
				 sum-=arr[start];
				 start++;
				 if(res>i-start+1)
					 res=i-start+1;
			 }
			 sum+=arr[i];
			
		 }
		 return res;
	 }
	 
	 
//	 Remove minimum elements from either side such that 2*min becomes more than max
//	 recursion
	 public static int minRemovals(int arr[]){
		 return minRemovals(arr, 0, arr.length-1);
	 }
	 
	 public static int minRemovals(int[] arr, int l, int h){
		 if(l>=h)
			 return 0;
		 int min =getMin(arr,l,h);
		 int max=getMax(arr,l,h);
		 if(2*min>max)
			 return 0;
		 return Math.min(minRemovals(arr,l+1,h), minRemovals(arr, l, h-1))+1;
	 }
	 public  static int getMin(int[] arr, int l, int h){
		 int min=arr[l];
		 for(int i=l+1;i<=h;i++){
			 if(arr[i]<min)
				 min=arr[i];
		 }
		 return min;
	 }
	 
	 public static int getMax(int[] arr,int l, int h){
		 int max=arr[l];
		 for(int i=l+1;i<=h;i++){
			 if(arr[i]>max)
				 max=arr[i];
		 }
		 return max;
	 }
	 
	 //DP
	 
	 public static int minRemovals2(int[] arr){
		 int n=arr.length;
		 int[][] dp=new int[n][n];
		 
		 for(int gap=0;gap<n;gap++){
			 for(int i=0,j=gap;j<n;i++,j++){
				 int min=getMin(arr,i,j);
				 int max=getMax(arr,i,j);
				 
				 dp[i][j]=2*min>max?0:Math.min(dp[i+1][j], dp[i][j-1])+1;
				 
			 }
		 }
		 return dp[0][n-1];
	 }
	 
//	 Create a matrix with alternating rectangles of O and X
	 
	 public static char[][] generateMatrix0X(int m , int n){
		 char[][] matrix=new char[m][n];
		 
		 int top=0;
		 int bottom=m-1;
		 int left=0;
		 int right=n-1;
		 char X='X';
		 while(left<=right&&top<=bottom){
			 for(int i=left;i<=right;i++)
				 matrix[top][i]=X;
			 top++;
			 
			 for(int i=top;i<=bottom;i++)
				 matrix[i][right]=X;
			 right--;
			 
			 if(top<=bottom){
				 for(int i=right;i>=left;i--)
					 matrix[bottom][i]=X;
				 bottom--;
			 }
			 if(right>=left){
				 for(int i=bottom;i>=top;i--)
					 matrix[i][left]=X;
				 left++;
			 }
			 X=X=='X'?'O':'X';
			 
		 }
		 
		 for(int i=0;i<m;i++){
			 for(int j=0;j<n;j++){
				 System.out.print(matrix[i][j]+" ");
			 }
			 System.out.println();
		 }
		 return matrix;
	 }
	 
	 
	 public static char[][] generateMatrix0X2(int m , int n){
		 char[][] matrix=new char[m][n];
		 int top=0;
		 int bottom=m-1;
		 int left=0;
		 int right=n-1;
		 char c='X';
		 
		 while(true){
			 for(int i=left;i<=right;i++)
				 matrix[top][i]=c;
			 if(++top>bottom)
				 break;
			 
			 for(int i=top;i<=bottom;i++)
				 matrix[i][right]=c;
			 if(--right<left)
				 break;
			 
			 for(int i=right;i>=left;i--)
				 matrix[bottom][i]=c;
			 if(--bottom<top)
				 break;
			 
			 for(int i=bottom;i>=top;i--)
				 matrix[i][left]=c;
			 if(++left>right)
				 break;
			 
			 c=c=='X'?'O':'X';
		 }
		 
		 for(int i=0;i<m;i++){
			 for(int j=0;j<n;j++){
				 System.out.print(matrix[i][j]+" ");
			 }
			 System.out.println();
		 }
		 
		 return matrix;
		 
	 }
	 
	 public static ListNode mergeSortList(ListNode head){
		 if(head==null||head.next==null)
			 return head;
//		 int len=0;
		 ListNode slow=head;
		 ListNode fast=head;
		 while(fast!=null&&fast.next!=null){
			 fast=fast.next.next;
			 if(fast==null)
				 break;
			 slow=slow.next;
		 }
		 ListNode secondHalf=slow.next;
		 slow.next=null;
		 ListNode firstHalf=head;
//		 System.out.println("firsthead is "+firstHalf.val);
//		 System.out.println("secondhead is "+secondHalf.val);
//		 
		 ListNode firstHead=mergeSortList(firstHalf);
		 ListNode secondHead=mergeSortList(secondHalf);
		 
		 ListNode res=mergeTwoLists(firstHead, secondHead);
		 return res;
		 
	 }
	 
	 public static ListNode mergeTwoLists(ListNode head1, ListNode head2){
		 if(head1==null||head2==null)
			 return head1==null?head2:head1;
		 
		 ListNode cur1=head1;
		 ListNode cur2=head2;
		 ListNode dummy=new ListNode(0);
		 ListNode cur=dummy;
		 
		 while(cur1!=null&&cur2!=null){
			 if(cur1.val<cur2.val){
				 cur.next=cur1;
				 cur1=cur1.next;
			 }
			 else{
				 cur.next=cur2;
				 cur2=cur2.next;
			 }
			 cur=cur.next;			 
		 }
		 if(cur1!=null)
			 cur.next=cur1;
		 if(cur2!=null)
			 cur.next=cur2;
		 
		 return dummy.next;
		 
	 }
//	 Checking if any anagram of a given string is palindrome or not
	 
	 //solution:  if we check if there is at most one character with odd occurrences
//	 in the string we can say that we can form a palindrome from any anagram.
	 
	 public static boolean checkPalindrome(String s) {
		 if (s == null || s.length()<2)
			 return true;
		 
		 int[] count = new int[26];
		 
		 for(int i=0;i<s.length();i++){
			 count[s.charAt(i) -'a']++;
		 }
		 
		 int oddOcc =0;
		 for(int i=0;i<26;i++){
			 if(oddOcc>1)
				 return false;
			 if(count[i]%2==1)
				 oddOcc++;			
		 }
		 return true;
	 }
	 
	 public void flatten(TreeNode root) {
	        if(root==null || root.left==null&&root.right==null)
	            return;
	        TreeNode node = root.right;
	        root.right=root.left;
	        TreeNode rightMost=getRightMost(root.right);
	        rightMost.right=node;
	        root.left=null;
	        flatten(root.right);
	    }
	 
	 public TreeNode getRightMost(TreeNode root){
		 if(root==null)
			 return null;
		 if(root.right!=null)
			 return getRightMost(root.right);
		 return root;
	 }
	 
	 public int evalRPN(String[] tokens) {
		 Stack<Integer> stk=new Stack<Integer>();
		 for(int i=0;i<tokens.length;i++){
			 String token=tokens[i];
			 if(!token.equals("+")&&!token.equals("-")&&!token.equals("*")&&!token.equals("/")){
				 int val =Integer.valueOf(token);
				 stk.push(val);
			 }
			 else{
				 int op1=stk.pop();
				 int op2=stk.pop();
				 if(token.equals("+"))
					 stk.push(op1+op2);
				 else if(token.equals("-"))
					 stk.push(op2-op1);
				 else if(token.equals("*"))
					 stk.push(op2*op1);
				 else
					 stk.push(op2/op1);
			 }
		 }
		 return stk.pop();
	 }
	 
	 public ListNode sortList(ListNode head) {
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
	        
	        ListNode h1=head;
	        ListNode h2=slow.next;
	        slow.next=null;
	        
	        h1=sortList(h1);
	        h2=sortList(h2);
	        
	        head=mergeSortedLists(h1,h2);
	        return head;	        
	    }
	 
	 public ListNode mergeSortedLists(ListNode head1, ListNode head2){
		 if(head1==null||head2==null)
			 return head1==null?head2:head1;
		 ListNode head=new ListNode(0);
		 ListNode pre=head;
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
		 return head.next;
	 }
	 
	 public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
	        if(node==null)
	            return null;
	        Queue<UndirectedGraphNode> que= new LinkedList<UndirectedGraphNode>();
	        que.add(node);
	        HashMap<UndirectedGraphNode, UndirectedGraphNode> map =new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
	        UndirectedGraphNode copy=new UndirectedGraphNode(node.label);
	        map.put(node,copy);
	        
	        while(!que.isEmpty()){
	            UndirectedGraphNode top=que.remove();
	            List<UndirectedGraphNode> neighbors = top.neighbors;
	            for(int i=0;i<neighbors.size();i++){
	                UndirectedGraphNode neighbor= neighbors.get(i);
	                if(!map.containsKey(neighbor)){
	                    que.add(neighbor);
	                    UndirectedGraphNode nd=new UndirectedGraphNode(neighbor.label);
	                    map.put(neighbor, nd);
	                    map.get(top).neighbors.add(nd);
	                }
	                else
	                    map.get(top).neighbors.add(map.get(neighbor));
	            }
	        }
	        return copy;
	    }
	 
	 public boolean hasCycle(ListNode head) {
	        if(head==null)
	            return false;
	        ListNode slow=head;
	        ListNode fast=head;
	        while(fast!=null&&fast.next!=null){
	            fast=fast.next.next;
	            slow=slow.next;
	            if(fast==slow)
	                break;
	        }
	        if(fast==null||fast.next==null)
	            return false;
	        return true;
	    }
	 
	 public ListNode insertionSortList(ListNode head) {
	        if(head==null)
	            return null;
	        ListNode dummy=new ListNode(0);
	        dummy.next=head;
	        ListNode last=head;
	        ListNode cur=head.next;
	        
	        while(cur!=null){
	            ListNode node=dummy.next;
	            ListNode pre=dummy;
	            while(node!=cur&&node.val<cur.val){
	                pre=node;
	                node=node.next;
	            }
	            if(node!=cur){
	                last.next=cur.next;
	                pre.next=cur;
	                cur.next=node;
	            }
	            else
	                last=cur;
	            cur=last.next;
	            
	        }
	        return dummy.next;
	 }
	 
	 public List<List<Integer>> levelOrder(TreeNode root) {
	        List<List<Integer>> res=new ArrayList<List<Integer>>();
	        if(root==null)
	            return res;
	        int curlevel=0;
	        int nextlevel=0;
	        Queue<TreeNode> que=new LinkedList<TreeNode>();
	        que.add(root);
	        curlevel++;
	        List<Integer> level=new ArrayList<Integer>();
	        
	        while(!que.isEmpty()){
	            TreeNode top=que.remove();
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
	                curlevel=nextlevel;
	                nextlevel=0;
	                res.add(level);
	                level=new ArrayList<Integer>();
	            }
	        }
	        return res;
	    }
	 
	 public boolean isValidBST(TreeNode root) {
	        if(root==null)
	            return true;
	        return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	    }
	    
	    public boolean isValidBST(TreeNode root, int leftMost, int rightMost){
	        if(root==null)
	            return true;
	        if(root.val<=leftMost||root.val>=rightMost)
	            return false;
	        return isValidBST(root.left, leftMost, root.val)&&isValidBST(root.right, root.val, rightMost);
	    }
	    
	    public boolean isInterleave(String s1, String s2, String s3) {
	        int n1=s1.length();
	        int n2=s2.length();
	        int n3=s3.length();
	        if(n1+n2!=n3)
	            return false;
	        boolean[][] dp=new boolean[n1+1][n2+1];
	        dp[0][0]=true;
	        for(int i=1;i<=n1;i++)
	            dp[i][0]=s1.charAt(i-1)==s3.charAt(i-1)&&dp[i-1][0];
	        for(int i=1;i<=n2;i++)
	            dp[0][i]=s2.charAt(i-1)==s3.charAt(i-1)&&dp[0][i-1];
	            
	        for(int i=1;i<=n1;i++){
	            for(int j=1;j<=n2;j++){
	                dp[i][j]=dp[i-1][j]&&s1.charAt(i-1)==s3.charAt(i+j-1)||
	                dp[i][j-1]&&s2.charAt(j-1)==s3.charAt(i+j-1);
	            }
	        }
	        return dp[n1][n2];
	    }
	    
	    public List<Integer> inorderTraversal(TreeNode root) {
	        List<Integer> res=new ArrayList<Integer>();
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
	    
	    public int atoi(String str) {
	        str=str.trim();
	        if(str.isEmpty())
	            return 0;
	                    
	        boolean neg=false;
	        boolean overflow=false;
	        int res=0;
	        int i=0;
	        if(str.charAt(0)=='+')
	            i++;
	        if(str.charAt(0)=='-'){
	            i++;
	            neg=true;
	        }

	        while(i<str.length()){
	            int val=str.charAt(i)-'0';
	            if(val>=0&&val<=9){
	                if(res<=(Integer.MAX_VALUE-val)/10)
	                    res=res*10+val;
	                else{
	                    overflow=true;
	                    break;
	                }
	            }
	            else
	                break;
	            i++;
	        }
	        
	        if(overflow){
	            if(neg)
	                return Integer.MIN_VALUE;
	            else
	                return Integer.MAX_VALUE;
	        }
	        if(neg)
	            return -res;
	        return res;
	    }
	    
	public List<List<Integer>> threeSum(int[] num) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (num.length < 3)
			return res;
		Arrays.sort(num);
		for (int i = 0; i < num.length - 2; i++) {
			if (i == 0 || num[i] > num[i - 1]) {
				int beg = i + 1;
				int end = num.length - 1;
				while (beg < end) {
					int sum = num[i] + num[beg] + num[end];
					if (sum == 0) {
						List<Integer> sol = new ArrayList<Integer>();
						sol.add(num[i]);
						sol.add(num[beg]);
						sol.add(num[end]);
						// if(!res.contains(sol))
						res.add(sol);
						beg++;
						end--;
						while (beg < end && num[beg] == num[beg - 1])
							beg++;
						while (end > beg && num[end] == num[end + 1])
							end--;
					} else if (sum > 0)
						end--;
					else
						beg++;
				}
			}
		}
		return res;
	}
	
	public int threeSumClosest(int[] num, int target) {
        int n=num.length;
        int minDiff=Integer.MAX_VALUE;
        Arrays.sort(num);
        int res=Integer.MAX_VALUE;
        for(int i=0;i<n-2;i++){
        	int j=i+1;
        	int k=n-1;
        	while(j<k){
        		int sum=num[i]+num[j]+num[k];
        		if(sum==target)
        			return sum;
        		int dif=Math.abs(sum-target);
        		if(dif<minDiff){
        			minDiff=dif;
        			res=sum;
        		}
        		if(sum>target){
        			k--;
        		}
        		else
        			j++;
        	}
        }
        return res;	
    }
	
	public boolean isValid(String s) {
        if(s.length()%2!=0)
            return false;
        Stack<Character> stk=new Stack<Character>();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c=='('||c=='['||c=='{')
            	stk.push(c);
            else{
            	if(!stk.isEmpty()&&(c==')'&&stk.peek()=='('||c==']'&&stk.peek()=='['||c=='}'&&stk.peek()=='{'))
            		stk.pop();
            	else
            		return false;
            }
        }
        return stk.isEmpty();
    }
	
	public ListNode mergeKLists(List<ListNode> lists) {
        if(lists.size()==0)
        	return null;
        while(lists.size()>1){
        	ListNode l1=lists.remove(0);
        	ListNode l2=lists.remove(0);
        	ListNode l=mergeTwoSortedLists(l1,l2);
        	lists.add(l);
        	
        }
        return lists.get(0);
    }
	 
	public ListNode mergeTwoSortedLists(ListNode l1, ListNode l2){
		if(l1==null&&l2==null)
			return null;
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
	
	public List<String> generateParenthesis(int n) {
        List<String> res=new ArrayList<String>();
        if(n<=0)
        	return res;
        generateParenthesis(n,0,0, "", res);
        return res;
    }
	
	public void generateParenthesis(int n, int left, int right, String sol, List<String> res){
		if(n==left&&left==right){
			res.add(sol);
			return;
		}
		if(left<n){
			generateParenthesis(n, left+1, right, sol+"(", res);
		}
		if(right<left){
			generateParenthesis(n, left, right+1, sol+")", res);
		}
	}
	
	public void reorderList(ListNode head) {
        if(head==null)
            return;
        ListNode slow=head;
        ListNode fast=head;
        
        while(fast!=null&&fast.next.next!=null){
        	fast=fast.next.next;
        	if(fast==null)
        		break;
        	slow=slow.next;
        }
        
        ListNode secondHalf=slow.next;
        slow.next=null;
        secondHalf=reverseList2(secondHalf);
        
        ListNode first=head;
        while(first!=null&&secondHalf!=null){
        	ListNode node1=first.next;
        	ListNode node2=secondHalf.next;
        	first.next=secondHalf;
        	secondHalf.next=node1;
        	first=node1;
        	secondHalf=node2;
        }
    }
	
	public static ListNode reverseList2(ListNode head){
		if(head==null||head.next==null)
			return head;
		ListNode cur=head;
		ListNode pre=null;
		while(cur!=null){
			ListNode next=cur.next;
			cur.next=pre;
			pre=cur;
			cur=next;
		}
		return pre;
	}
	
	public TreeNode sortedListToBST(ListNode head) {
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
        
        ListNode head2=slow.next;
        TreeNode root=new TreeNode(slow.val);
        root.right=sortedListToBST(head2);
        if(pre==null)
            return root;
        else{
            pre.next=null;
            root.left=sortedListToBST(head);
        }
        return root;
    }
	
	public TreeNode sortedListToBST2(ListNode head) {
        if(head==null)
            return null;
        int len=0;
        ListNode cur=head;
        while(cur!=null){
        	len++;
        	cur=cur.next;
        }
        return sortedListToBST(head, 0, len);
    }
	
	public TreeNode sortedListToBST(ListNode head, int beg, int end){
		if(head==null||beg>end)
			return null;
		int mid=beg+(end-beg)/2;
		ListNode cur=head;
		for(int i=beg;i<mid;i++)
			cur=cur.next;
		TreeNode root=new TreeNode(cur.val);
		root.left=sortedListToBST(head, beg, mid-1);
		root.right=sortedListToBST(cur.next,mid+1,end);
		return root;		
	}
	
	public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res =new ArrayList<List<Integer>>();
        if(numRows==0)
            return res;
        int[][] dp=new int[numRows][numRows];
        for(int i=0;i<numRows;i++){
            dp[i][0]=1;
        }
        for(int i=1;i<numRows;i++){
            for(int j=1;j<=i;j++){
                if(j==i)
                    dp[i][j]=1;
                else
                    dp[i][j]=dp[i-1][j]+dp[i-1][j-1];
            }
        }
        
        for(int i=0;i<numRows;i++){
            List<Integer> row=new ArrayList<Integer>();
            for(int j=0;j<=i;j++){
                row.add(dp[i][j]);
            }
            res.add(row);
        }
        return res;
    }
	
	public int minimumTotal(List<List<Integer>> triangle) {
        int n=triangle.size();
        int len=triangle.get(n-1).size();
        int[][] dp=new int[n][len];
        dp[0][0]=triangle.get(0).get(0);
        
        for(int i=1;i<n;i++){
            dp[i][0]=dp[i-1][0]+triangle.get(i).get(0);
        }
        
        for(int i=1;i<n;i++){
            for(int j=1;j<triangle.get(i).size();j++){
                if(j==triangle.get(i).size()-1)
                    dp[i][j]=dp[i-1][j-1]+triangle.get(i).get(j);
                else
                    dp[i][j]=Math.min(dp[i-1][j-1], dp[i-1][j])+triangle.get(i).get(j);
            }
        }
        
        int min=Integer.MAX_VALUE;
        for(int i=0;i<len;i++){
            min=Math.min(min, dp[n-1][i]);
        }
        return min;
    }
	
	public boolean isPalindrome(int x) {
        if(x<0)
            return false;
        int base=1;
        int t=x;
        while(t>=10){
            base*=10;
            t=t/10;
        }
        while(x>0){
            int first=x/base;
            int last=x%10;
            if(first!=last)
                return false;
            x%=base;
            x=x/10;
            base/=100;
        }
        return true;
    }
	
	 public int search(int[] A, int target) {
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
	            else{
	                if(A[mid]<target&&target<=A[end]){
	                    beg=mid+1;
	                }
	                else
	                    end=mid-1;
	            }
	        }
	        return -1;	        
	    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(longestValidParentheses("((()())(()()()"));
		int[] A={3,2,5,1,4,7,9,6,8};
		findTriple(A);
		
		int[] prices={3,7,4,5,8,6,9,1,7};
		profitStock(prices);
		String s="catsanddog";
		Set<String> set=new HashSet<String>();
		set.add("cat");
		set.add("cats");
		set.add("and");
		set.add("sand");
		set.add("dog");
		
		System.out.println(wordBreak(s,set));
		
		ListNode head=new ListNode(1);
		ListNode node1=new ListNode(2);
		ListNode node2=new ListNode(3);
		ListNode node3=new ListNode(4);
		ListNode node4=new ListNode(3);
		ListNode node5=new ListNode(2);
		ListNode node6=new ListNode(1);
		head.next=node1;
		node1.next=node2;
		node2.next=node3;
//		node3.next=node4;
//		node4.next=node5;
//		node5.next=node6;
		
		ListNode reverseHead=reverseList2(head);
		while(reverseHead!=null){
			System.out.print(reverseHead.val+" ");
			reverseHead=reverseHead.next;
		}
		System.out.println("***********");
		ListNode reshead=mergeSortList(head);
		
		while(reshead!=null){
			System.out.print(reshead.val+" ");
			reshead=reshead.next;
		}
		System.out.println();
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~");
		
		ListNode newhead=reverseKGroup(head,3);
		
		while(newhead!=null){
			System.out.print(newhead.val+" ");
			newhead=newhead.next;
		}
		System.out.println();
		System.out.println(isPalindrome(head));
		System.out.println(isPalindrome2(head));
	
		skipMdeleteN(head, 1,1);
		
		while(head!=null){
			System.out.print(head.val+" ");
			head=head.next;
		}
		System.out.println();
		
		TreeNode root=new TreeNode(5);
		root.left=new TreeNode(2);
		root.left.right=new TreeNode(4);
		root.left.right.left=new TreeNode(3);
		root.left.left=new TreeNode(1);
		
		root.right=new TreeNode(8);
		root.right.left=new TreeNode(6);
		root.right.left.right=new TreeNode(7);
		root.right.right=new TreeNode(9);
		root.right.right.left=new TreeNode(11);
		root.right.right.left.right=new TreeNode(13);
		
		System.out.println("-------------");
		
		System.out.println(deepsetLeaf(root).val+" ressssss");
		System.out.println("-------------");
		printRightView(root);
		System.out.println();
		System.out.println("-------------");
		System.out.println("-------------");
		printkdistanceNode(root, root.right.left,4);
		System.out.println();
		System.out.println("-------------");
		leftViewOfTree(root);
		System.out.println();
		getNoSiblingsNodes(root);
		System.out.println();
		System.out.println(isPairPresent(root,18));
		System.out.println(largestIndependentSet(root));
		String seq=serializeTree(root);
		System.out.println(seq);
		
//		TreeNode r=deserializeTree(seq);
//		inorder(r);
		System.out.println();
		System.out.println(distanceBetweenNodes(root, root.left.right.left, root.left.left));
		System.out.println(findDistance(root, 13, 3));
		
		System.out.println("-------------");
		
		
		System.out.println(kthLevelSum(root,3));
		System.out.println(longestPathLeafToLeaf(root));
		
		int[][] matrix={{1,-2,-3,4},{-2,1,-3,-2},{0,-2,-3,-1},{4,1,6,-2}};
		System.out.println(findMaxFromFirstRow(matrix));
		
		int[] nge={2,6,3,4,3,1,2};
		nextGreatestElement(nge);
		
		System.out.println(findFirstNonRepeating("geeksforgeeksFirst"));
		System.out.println(findFirstNonRepeating2("geeksforgeeksFirst"));
		int[] num={1,0,1,9};
		nextSmallestPalindrome(num);
		
		String[] strs={"yuan","F","feng","eng","eng","f","yuan","ff","s","ff","ff","yuan","ss","F","F","F"};
		
		topKStrings(strs,4);
		System.out.println();
		int[] arr={-1,0,0,0,0,-4};
		System.out.println(maxProductSubarray(arr));
		int[] coins={1,2,5,10};
		System.out.println(minMakeChange(coins,12 ));
		
		int[] pre={3,2,1,4};
		TreeNode roo=constructBST(pre);
		inorder(roo);
		
		System.out.println();
		char[][] board={{'X','O','X','O','X','O'},{'O','X','O','X','O','X'},{'X','O','X','O','X','O'},{'O','X','O','X','O','X'}};
		solve(board);
		solve2(board);
		solve3(board);
		
		ListNode l1=new ListNode(1);
		ListNode l2=new ListNode(2);
		ListNode l3=new ListNode(3);
		ListNode l4=new ListNode(4);
		ListNode l5=new ListNode(5);
		
		l1.next=l2;
		l2.next=l1;
		l2.next=l3;
		l3.next=l4;
		l4.next=l5;
		l5.next=l1;
		
		ListNode newHead=deletNodeFromCirlularList(l1,1);
		ListNode cur=newHead;
		do{
			System.out.print(cur.val+" ");
			cur=cur.next;
		}while(cur!=newHead);
		
		System.out.println();
		
		
		DListNode dl1=new DListNode(1);
		DListNode dl2=new DListNode(2);
		DListNode dl3=new DListNode(3);
		DListNode dl4=new DListNode(4);
		DListNode dl5=new DListNode(5);
		
//		dl1.next=dl1;
//		dl1.pre=dl1;
		dl1.next=dl2;
		dl2.pre=dl1;
		dl2.next=dl3;
		dl3.pre=dl2;
		dl3.next=dl4;
		dl4.pre=dl3;
		dl4.next=dl5;
		dl5.pre=dl4;
		dl5.next=dl1;
		dl1.pre=dl5;
		
		DListNode head1=deletNodeFromDoublyCirlularList(dl1,3);
		DListNode curnode=head1;
		do{
			System.out.print(curnode.val+" ");
			curnode=curnode.next;
		}while(curnode!=head1);
		System.out.println();
		System.out.println(findMin3DigitNum(100));
		int[] Arr={1,2,100,22,28,12};
		ArrayList<ArrayList<Integer>> result=subsetSum(Arr,150);
		for(int i=0;i<result.size();i++)
			System.out.println(result.get(i));
		
		System.out.println(reverseString("yuan fengpeng"));
		
		TreeNodeP rootp=new TreeNodeP(5);
		TreeNodeP n1=new TreeNodeP(2);
		TreeNodeP n2=new TreeNodeP(8);
		TreeNodeP n3=new TreeNodeP(7);
		TreeNodeP n4=new TreeNodeP(6);
		TreeNodeP n5=new TreeNodeP(9);
		
		TreeNodeP n6=new TreeNodeP(4);
		TreeNodeP n7=new TreeNodeP(3);
		TreeNodeP n8=new TreeNodeP(1);
		
		rootp.left=n1;
		rootp.right=n2;
		n2.left=n3;
		n2.right=n5;
		n3.left=n4;
		n1.left=n8;
		n1.right=n6;
		n6.left=n7;
		
		n1.parent=rootp;
		n2.parent=rootp;
		n3.parent=n2;
		n4.parent=n3;
		n5.parent=n2;
		n6.parent=n1;
		n7.parent=n6;
		n8.parent=n1;
		
		System.out.println(LCAncestor(n8,n5).val);
		System.out.println(inorderSuccessorBST(n5));
		System.out.println(inorderSucc(n6).val);
		int[] nums={12,11,10,5,6,2,30};
		topKLargestestNum(nums,4);
		System.out.println();
		System.out.println(Arrays.toString(nums));
		Arrays.sort(nums);
		System.out.println(Arrays.toString(nums));
		
		inorderTrav(root);
		
		int[][] maze={{0,0,0,0,1,1,1},{1,1,1,0,1,1,1},{0,0,0,0,1,1,1},{0,1,1,1,0,0,0},{0,0,1,0,0,1,0},{1,0,1,0,1,1,0},{1,0,0,0,1,1,0}};
//		ArrayList<Pair> res=findPathOfMaze(maze,0,0);
//		for(int i=0;i<res.size();i++){
//			System.out.println(res.get(i));
//		}
		System.out.println(totalNodesOfLevelK(root,4));
		
		int[][] matrix1={{1,5,10,12},
                {3,8,11,13},
                {7,9,14,16},
                {20,21,22,23}};
		System.out.println(findKthOfSortedMatrix(matrix1,12));
		System.out.println(kthLargestOfSortedMatrix(matrix1,12));
		
		int cost[][] = { {5,8,2,6},
                {1,3,8,2},
                {6,6,5,2},
                {4,6,1,6}};
		System.out.println(findPathWithMaxSum(cost));
		int arry[]={4,5,6,7,8,9,1,2,3};
		System.out.println(findMinOfRotatedArray(arry));
		int[] arrry={3,2,4,1,2,3,4,1,5,4,7,3,8};
		quickSort(arrry);
		
		int[] twosum={1, 4, 45, 6, 8};
		System.out.println(hasArrayTwoCandidates(twosum,16));
		
		
		ListNode h=new ListNode(1);
		ListNode h1=new ListNode(2);
		ListNode h2=new ListNode(3);
		ListNode h3=new ListNode(4);
		ListNode h4=new ListNode(5);
		ListNode h5=new ListNode(6);
		h.next=h1;
		h1.next=h2;
		h2.next=h3;
		h3.next=h4;
		h4.next=h5;
		
//		ListNode rh=reverseListRecur(h);
		ListNode rh=reverseListIterative(h);
		while(rh!=null){
			System.out.print(rh.val+" ");
			rh=rh.next;
		}
		System.out.println();
		
		System.out.println(anagram("ayuanw","anyuwa"));
		System.out.println(anagram2("ayuanw","anyuwa"));
		mergeSort(arrry);
		int[] prices1={7,6,5,4,3,2,1};
		System.out.println(maxProfit(prices1));
		char[] ch={'a','c','f','j','k'};
		System.out.println(findNextChar(ch,'b'));
		
//		char[] ch1={'c', 'f', 'j', 'p', 'v'};
//		System.out.println(findNextChar(ch1,'a'));
//		
//		char[] ch2={'c', 'f', 'j', 'p', 'v'};
//		System.out.println(findNextChar(ch2,'c'));
//		char[] ch3={'c', 'f', 'j', 'p', 'v'};
//		System.out.println(findNextChar(ch3,'k'));
		
		System.out.println(findDistanceBetweenWords("hello how are hello","hello","you"));
		
		System.out.println(findDepth("((00)(0(00)))"));
		
		int[] arrsum={1,3,5};
		System.out.println(arraySum(arrsum));
		
		TreeNode root1 = new TreeNode(10);
	    root1.left = new TreeNode(5);
	    root1.right = new TreeNode(100);
	    root1.right.left = new TreeNode(50);
	    root1.right.right = new TreeNode(150);
	    root1.right.left.left = new TreeNode(40);
	    System.out.println(isBalanced(root1));
	    String  testS="   a   b ";
	    System.out.println(reverseWords2(testS));
	    
	    int arr3[] = {2, 1, 3, 4};
	    System.out.println(findGroupsMultipleOf3(arr3));
		
	    System.out.println(match("*pqrs", "pqrst"));
	    
	    System.out.println(name);
	    changeName("yuan");
	    System.out.println(name);
	    
	    System.out.println(lcs("12345yu","13579uy"));
	    int arr1[] = {1, 10, 5, 2, 7};
	    int x = 9;
	    
	    System.out.println(smallestSubWithSum(arr1,x));
	    System.out.println(smallestSubWithSum2(arr1,x));
	    
	    int[] removal= {20, 4, 1, 3};
	    System.out.println(minRemovals(removal));
	    System.out.println(minRemovals2(removal));
	    
	    generateMatrix0X(5,4);
	    System.out.println();
	    generateMatrix0X2(5,4);
	    
	    
	    
	    
	}

}

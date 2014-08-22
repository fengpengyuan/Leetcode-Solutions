package com.Practice;

import java.util.ArrayDeque;
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
import java.util.TreeMap;











public class Solution {
	
	 public static int[] twoSum(int[] numbers, int target) {
	        // Start typing your Java solution below
	        // DO NOT write main() function
	        int[] res={-1,-1};
	        if(numbers.length<2)
	        	return res;
	        
	        HashMap<Integer, Integer> map=new HashMap<Integer,Integer>();
	        
	        for(int i=0;i<numbers.length;i++){
	        	map.put(numbers[i], i);
	        }
	        
//	        System.out.println(map);
	        
	        for(int i=0;i<numbers.length;i++){
	        	int left=target-numbers[i];
	        	if(map.containsKey(left)){
	        		res[0]=i+1;
	        		res[1]=map.get(left)+1;
	        		break;
	        	}
	        }
	        
	        return res;            
	        
	    }
	 
	 public ListNode deleteDuplicates(ListNode head) {
	        // Start typing your Java solution below
	        // DO NOT write main() function
	        if(head==null)
	        	return null;
	        ListNode cur=head.next;
	        ListNode pre=head;
	        while(cur!=null){
	        	if(cur.val==pre.val){
	        		cur=cur.next;
	        	}
	        	else{
	        		pre.next=cur;
	        		pre=cur;
	        		cur=cur.next;
	        		
	        	}
	        }
	        pre.next=null;
	        
	        return head;
	    }
	 
	 public ListNode deleteDuplicates2(ListNode head) {
	        // Start typing your Java solution below
	        // DO NOT write main() function
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
	 
	 public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
	        // Start typing your Java solution below
	        // DO NOT write main() function
		 ArrayList<ArrayList<Integer>> res=new ArrayList<ArrayList<Integer>>();
		 if(num.length<3)
			 return res;
		 Arrays.sort(num);
		 for (int i=0;i<num.length-2;i++){
			 int beg=i+1;
			 int end=num.length-1;
			 
			 while(beg<end){
				 int sum=num[i]+num[beg]+num[end];
				 if(sum==0){
					 ArrayList<Integer> sol=new ArrayList<Integer>();
					 sol.add(num[i]);
					 sol.add(num[beg]);
					 sol.add(num[end]);
					 res.add(sol);
//					 sol.clear();
					 while(beg+1<end&&num[beg]==num[beg+1])
						 beg++;
					 beg++;
					 while(end-1>beg&&num[end]==num[end-1])
						 end--;
					 end--;
				 }
				 else if(sum>0)
					 end--;
				 else
					 beg++;
			 }
			 
			 while(i+1<num.length-2&&num[i]==num[i+1])
				 i++;
//			 i++;
		 }
		 return res;
	    }
	 
	 
	 public int threeSumClosest(int[] num, int target) {
	        // Start typing your Java solution below
	        // DO NOT write main() function
		 if(num.length<3)
	        	return 0;
	        int mindif=Integer.MAX_VALUE;
	        Arrays.sort(num);
	        int closest=Integer.MAX_VALUE;
	        
	        for(int i=0;i<num.length;i++){
	        	int j=i+1;
	        	int k=num.length-1;
	        	
	        	while(j<k){
	        		int sum=num[i]+num[j]+num[k];
	        		int dif=Math.abs(sum-target);
	        		if(sum==target)
	        			return sum;
	        		if(dif<mindif){
	        			mindif=dif;
	        			closest=sum;
	        		}
	        		if(sum>target){	        		
	        			j++;	        			
	        		}
	        		else{        				        				
        				k--;
        			}
	        	}
	        }
	        
	        return closest;
	    }
	 
	 public String addBinary(String a, String b) {
	        // Start typing your Java solution below
	        // DO NOT write main() function
	        if(a.length()==0&&b.length()==0)
	        	return "";
	        int l1=a.length()-1;
	        int l2=b.length()-1;
	        
	        int carry=0;
	        String res="";
	        while(l1>=0&&l2>=0){
	        	int sum=a.charAt(l1)-'0'+b.charAt(l2)-'0'+carry;
	        	carry=sum/2;
	        	sum=sum%2;
	        	res=sum+res;
	        	l1--;
	        	l2--;
	        	
	        }
	        
	        while(l1>=0){
	        	int sum=a.charAt(l1)-'0'+carry;
	        	carry=sum/2;
	        	sum=sum%2;
	        	res=sum+res;
	        	l1--;
	        }
	        
	        while(l2>=0){
	        	int sum=b.charAt(l2)-'0'+carry;
	        	carry=sum/2;
	        	sum=sum%2;
	        	res=sum+res;
	        	l2--;
	        }
	        
	        if(carry==1)
	        	return 1+res;
	        return res;
	        
	    }
	 
	 public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	        // Start typing your Java solution below
	        // DO NOT write main() function
	        if(l1==null||l2==null)
	        	return l1==null?l2:l1;
	        ListNode dummy=new ListNode(1);
	        ListNode pre=dummy;
	        int carry=0;
	        while(l1!=null&&l2!=null){
	        	int sum=l1.val+l2.val+carry;
	        	carry=sum/10;
	        	sum=sum%10;
	        	pre.next=new ListNode(sum);
	        	pre=pre.next;
	        	l1=l1.next;
	        	l2=l2.next;
	        }
	        
	        while(l1!=null){
	        	int sum=l1.val+carry;
	        	carry=sum/10;
	        	sum=sum%10;
	        	pre.next=new ListNode(sum);
	        	pre=pre.next;
	        	l1=l1.next;
	        	}
	        while(l2!=null){
	        	int sum=l2.val+carry;
	        	carry=sum/10;
	        	sum=sum%10;
	        	pre.next=new ListNode(sum);
	        	pre=pre.next;
	        	l2=l2.next;
	        	}
	        
	        if(carry==1){
	        	pre.next=new ListNode(1);
	        }
	        return dummy.next;
	    }
	 
	 public boolean isBalanced(TreeNode root) {
	        // Start typing your Java solution below
	        // DO NOT write main() function
	        if(root==null)
	        	return true;
	        int left=getHeight(root.left);
	        int right=getHeight(root.right);
	        if(Math.abs(left-right)>1)
	        	return false;
	        else
	        	return isBalanced(root.left)&&isBalanced(root.right);
	    }
	 
	 public static int getHeight(TreeNode root){
		 if(root==null)
			 return 0;
		 int left=getHeight(root.left);
		 int right=getHeight(root.right);
		 return left>right?left+1:right+1;
		 
	 }
	 
	 public ArrayList<Integer> inorderTraversal(TreeNode root) {
	        // Start typing your Java solution below
	        // DO NOT write main() function
		 ArrayList<Integer> res=new ArrayList<Integer>();
		 if(root==null)
			 return res;
		 Stack<TreeNode> stk=new Stack<TreeNode>();
		 TreeNode cur=root;
//		 stk.push(root);
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
	 
	 public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
	        // Start typing your Java solution below
	        // DO NOT write main() function
		 ArrayList<ArrayList<Integer>>  res=new ArrayList<ArrayList<Integer>> ();
		 if(root==null)
			 return res;
		 Queue<TreeNode> q=new LinkedList<TreeNode>();
		 ArrayList<Integer> sol=new ArrayList<Integer>();
		 int curLevel=0;
		 int nextLevel=0;
		 q.add(root);
		 curLevel++;
		 while(!q.isEmpty()){
			 TreeNode top=q.poll();
			 sol.add(top.val);
			 curLevel--;
			 if(top.left!=null){
				 q.add(top.left);
				 nextLevel++;
			 }
			 if(top.right!=null){
				 q.add(top.right);
				 nextLevel++;
			 }
			 if(curLevel==0){
				 res.add(sol);
				 sol=new ArrayList<Integer>();
				 curLevel=nextLevel;
				 nextLevel=0;
			 }
		 }
		 return res;
	    }
	 
	 public static ComplexNode colone(ComplexNode head){///error  needs to restore original 
		 if(head==null)
			 return  null;
		 ComplexNode cur=head;
		 while(cur!=null){
			 ComplexNode node=new ComplexNode(cur.val);
			 ComplexNode pnext=cur.next;
			 cur.next=node;
			 node.next=pnext;
			 cur=pnext;
		 }
		 
		 cur=head;
		 while(cur!=null){
			 if(cur.sibling!=null){
				 cur.next.sibling=cur.sibling.next;
			 }
			 cur=cur.next.next;
		 }
		 
		 cur=head;
		 ComplexNode coloneHead=null;
		 ComplexNode pre=null;
		 
		 while(cur!=null){
			 if(coloneHead==null){
				 coloneHead=cur.next;
				 pre=coloneHead;
			 }
			 else{
				 pre.next=cur.next;
				 pre=pre.next;
			 }
			 cur=cur.next.next;
		 }
		 
		 return coloneHead;
	 }
	 
	 public int[] plusOne(int[] digits) {
	        // Start typing your Java solution below
	        // DO NOT write main() function
	        int[] res=new int[digits.length];
	        int carry=1;
	        int l=digits.length-1;
	        
	        while(l>=0){
	        	int sum=digits[l]+carry;
	        	carry=sum/10;
	        	sum=sum%10;
	        	res[l]=sum;
	        	l--;
	        }
	        
	        if(carry==1){
	        	int[] ret=new int[digits.length+1];
	        	ret[0]=1;
	        	for(int i=0;i<digits.length;i++)
	        		ret[i+1]=res[i];
	        	return ret;
	        }
	        return res;
	    }
	 
	 public static ArrayList<Integer> preOrder(TreeNode root){
		 ArrayList<Integer> res=new ArrayList<Integer>();
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
	 
	 public static ArrayList<Integer> postOrder(TreeNode root){
		 ArrayList<Integer> res=new ArrayList<Integer>();
		 if(root==null)
			 return res;
		 Stack<TreeNode> stk=new Stack<TreeNode>();
		 TreeNode cur=root;
		 while(cur!=null){
			 stk.push(cur);
			 cur=cur.left;
		 }
		 
		 TreeNode pre=null;
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
	 
	 public ListNode removeNthFromEnd(ListNode head, int n) {
	        // Start typing your Java solution below
	        // DO NOT write main() function
	        if(head==null)
	        	return null;
	        ListNode fast=head;
	        ListNode low=head;
	        
	        for(int i=0;i<n;i++)
	        	fast=fast.next;
	        ListNode pre=null;
	        
	        while(fast!=null){
	        	fast=fast.next;
	        	pre=low;
	        	low=low.next;	        	
	        }
	        if(pre!=null)
	        	pre.next=low.next;
	        else
	        	return head.next;
	       
	        
	        return head;
	    }
	
	 
	 public TreeNode buildTree(int[] inorder, int[] postorder) {
		 if(inorder.length==0)
			 return null;
		 
		 return buildTreeUtil(inorder,0, inorder.length-1, postorder, 0, postorder.length-1);
	 }
	 
	 public TreeNode buildTreeUtil(int[] inorder, int beg1, int end1,int[] postorder, int beg2, int end2) {
		 if(beg1>end1)
			 return null;
		 TreeNode root=new TreeNode(postorder[end2]);
		 
		 int index=-1;
		 for(int i=beg1;i<=end1;i++){
			 if(postorder[end2]==inorder[i]){
				 index=i;
				 break;
			 }
		 }
		 
		 root.left=buildTreeUtil(inorder, beg1,index-1,postorder,beg2,beg2+index-beg1-1);
		 root.right=buildTreeUtil(inorder, index+1,end1,postorder,beg2+index-beg1,end2-1);
		 return root;
	 }
	 
	 public int maxArea(int[] height) {
	        // Start typing your Java solution below
	        // DO NOT write main() function
	        if(height.length<2)
	        	return 0;
	        int max=0;
	        
	        int i=0;
	        int j=height.length-1;
	        while(i<j){
	        	int maxArea=Math.min(height[i],height[j])*(j-i);
	        	if(maxArea>max)
	        		max=maxArea;
	        	if(height[i]<height[j])
	        		i++;
	        	else
	        		j--;
	        }
	        return max;
	    }
	 
	 public int trap(int[] A) {
	        // Start typing your Java solution below
	        // DO NOT write main() function
	        if(A.length<2)
	        	return 0;
	        
	        int[] left=new int[A.length];
	        int leftmost=A[0];
	        
	        for(int i=0;i<A.length;i++){
	        	left[i]=leftmost;
	        	if(A[i]>leftmost)
	        		leftmost=A[i];
	        }
	        
	        int[] right=new int[A.length];
	        int rightmost=A[A.length-1];
	        
	        for(int i=A.length-1;i>=0;i--){
	        	right[i]=rightmost;
	        	if(A[i]>rightmost)
	        		rightmost=A[i];
	        }
	        
	        int res=0;
	        
	        for(int i=0;i<A.length;i++){
	        	res+=Math.min(left[i], right[i])-A[i]>0?Math.min(left[i], right[i])-A[i]:0;
	        }
	        return res;
	    }
	 
	 public int climbStairs(int n) {
	        // Start typing your Java solution below
	        // DO NOT write main() function
	        if(n==0||n==1)
	        	return 1;
	        int first=1;
	        int second=1;
	        
	        for(int i=2;i<=n;i++){
	        	int total=first+second;
	        	first=second;
	        	second=total;
	        }
	        return second;
	    }
	 
	 public int firstMissingPositive(int[] A) {
		 for(int i=0;i<A.length;i++){
			 while(A[i]!=i+1){
				 if(A[i]<0||A[i]>=A.length||A[i]==A[A[i]-1])
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
	 
	 public static ArrayList<ArrayList<Integer>> levelOrderdfs(TreeNode root) {
	        // Start typing your Java solution below
	        // DO NOT write main() function
		 ArrayList<ArrayList<Integer>> res=new ArrayList<ArrayList<Integer>>();
		 
		 levelOrderdfsUtil(root,0,res);
//		 Collections.reverse(res);
		 return res;
	    }
	 
	 
	 public static void levelOrderdfsUtil(TreeNode root, int dep, ArrayList<ArrayList<Integer>> res){
		 if(root==null)
			 return;
		 ArrayList<Integer> sol=null;
		 if(dep<res.size()){
			sol=res.get(dep);
		 }
		 else{
			 sol=new ArrayList<Integer>();
			 res.add(sol);
		 }
		 levelOrderdfsUtil(root.left,dep+1,res);
		 levelOrderdfsUtil(root.right,dep+1,res);
		 sol.add(root.val);
		
	 }
	 
	 public boolean isSameTree(TreeNode p, TreeNode q) {
	        // Start typing your Java solution below
	        // DO NOT write main() function
	        if(p==null&&q==null)
	        	return true;
	        if(p==null||q==null)
	        	return false;
	        if(p.val!=q.val)
	        	return false;
	        return isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);
	    }
	 
	 
	 public ArrayList<String> generateParenthesis(int n) {
	        // Start typing your Java solution below
	        // DO NOT write main() function
		 ArrayList<String> res=new ArrayList<String>();
		 if(n<=0)
			 return res;
		 generateParen(0,0,n,"",res);
		 return res;
	    }
	 
	 public void generateParen(int left, int right, int n, String sol,ArrayList<String> res ){
		 if(left==right&&left==n){
			 res.add(sol);
			 return;
		 }
		 if(left<n){
			 generateParen(left+1,right,n,sol+"(",res);
		 }
		 if(right<left)
			 generateParen(left, right+1,n, sol+")",res);
	 }
	 
	 public ArrayList<ArrayList<Integer>> permute(int[] num) {
	        // Note: The Solution object is instantiated only once and is reused by each test case.
		 ArrayList<ArrayList<Integer>> res=new ArrayList<ArrayList<Integer>>();
		 if(num.length==0)
			 return res;
		 ArrayList<Integer> sol=new ArrayList<Integer>();
		 boolean[] used = new boolean[num.length];
		 permuteUtil(0,num.length,num,used,sol,res);
		 return res;
	    }
	 
	 public void permuteUtil(int dep, int maxDep, int[] num, boolean[] used,ArrayList<Integer> sol, ArrayList<ArrayList<Integer>> res){
		 if(dep==maxDep){
			 ArrayList<Integer> out=new ArrayList<Integer>(sol);
			 res.add(out);
			 return;
		 }
		 for(int i=0;i<num.length;i++){
			 if(!used[i]){
				 used[i]=true;
				 sol.add(num[i]);
				 permuteUtil(dep+1,maxDep,num,used,sol,res);
				 sol.remove(sol.size()-1); 
				 used[i]=false;
			 }
			
		 }
		 
	 }
	 
	 public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
	        // Note: The Solution object is instantiated only once and is reused by each test case.
		 ArrayList<ArrayList<Integer>> res=new ArrayList<ArrayList<Integer>>();
		 if(num.length==0)
			 return res;
		 ArrayList<Integer> sol=new ArrayList<Integer>();
		 Arrays.sort(num);
		 boolean[] used = new boolean[num.length];
		 permuteUniqueUtil(0,num.length,num,used,sol,res);
		 return res;
	    }
	    
	 public void permuteUniqueUtil(int dep, int maxDep, int[] num, boolean[] used,ArrayList<Integer> sol, ArrayList<ArrayList<Integer>> res){
		 if(dep==maxDep){
			 ArrayList<Integer> out=new ArrayList<Integer>(sol);
			 res.add(out);
			 return;
		 }
		 for(int i=0;i<num.length;i++){
			 if(!used[i]){
				 if(i!=0&&!used[i-1]&&num[i-1]==num[i])
					 continue;
				 used[i]=true;
				 sol.add(num[i]);
				 permuteUniqueUtil(dep+1,maxDep,num,used,sol,res);
				 sol.remove(sol.size()-1); 
				 used[i]=false;
			 }
			
		 }
		 
	 }
	 
	 public void solve(char[][] board) {
	        // Note: The Solution object is instantiated only once and is reused by each test case.
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
	        
	        for(int j=1;j<n-1;j++){
	        	if(board[0][j]=='O'){
	        		q1.add(0);
	        		q2.add(j);
	        	}
	        	if(board[m-1][j]=='O'){
	        		q1.add(m-1);
	        		q2.add(j);
	        	}
	        }
	        
	        int i=0;
	        
	        while(i<q1.size()){
	        	int x=q1.get(i);
	        	int y=q2.get(i);
	        	board[x][y]='D';
	        	
	        	if(x-1>=0&&board[x-1][y]=='O'){
	        		q1.add(x-1);
	        		q2.add(y);
	        	}
	        	if(x+1<m&&board[x+1][y]=='O'){
	        		q1.add(x+1);
	        		q2.add(y);
	        	}
	        	
	        	if(y+1<n&&board[x][y+1]=='O'){
	        		q1.add(x);
	        		q2.add(y+1);
	        	}
	        	if(y-1>=0&&board[x][y-1]=='O'){
	        		q1.add(x);
	        		q2.add(y-1);
	        	}
	        	i++;
	        }
	        
	        for(int j=0;j<m;j++){
	        	for(int k=0;k<n;k++){
	        		if(board[j][k]=='O')
	        			board[j][k]='X';
	        		if(board[j][k]=='D')
	        			board[j][k]='O';
	        	}
	        }
	    }
	 
	  public boolean isPalindrome(int x) {
	        // Note: The Solution object is instantiated only once and is reused by each test case.
	        if(x<0)
	        	return false;
	        int base=1;
	        int t=x;
	        while(t/10>0){
	        	base*=10;
	        	t=t/10;
	        }
	        
	        t=x;
	        while(t>0){
	        	int first=t/base;
	        	int last=t%10;
	        	if(first!=last)
	        		return false;
	        	t=(t%base)/10;
	        	base/=100;
	        }
	        return true;
	    }
	  
	  int sum=0;
	  public int sumNumbers(TreeNode root) {
	        // Note: The Solution object is instantiated only once and is reused by each test case.
	        if(root==null)
	        	return 0;
	        return sumNumbersUtil(root, 0);
	       
	    }
	  
	  public int sumNumbersUtil(TreeNode root, int sum){
		  if(root==null)
			  return 0;
		  sum=sum*10+root.val;
		  if(root.left==null&&root.right==null)
			  return sum;
		  return sumNumbersUtil(root.left,sum)+sumNumbersUtil(root.right,sum);
	  }
	  
	  public int sumNumbers2(TreeNode root) {
		  if(root==null)
			  return 0;
		  int[] sum={0};
		  sumNumbersHelper(root,0,sum);
		  return sum[0];
	  }
	  
	  public void sumNumbersHelper(TreeNode root, int cur, int[] sum){
		  if(root==null)
			  return;
		  if(root.left==null&&root.right==null){
			  cur=cur*10+root.val;
			  sum[0]+=cur;
		  }
		  cur=cur*10+root.val;
		  sumNumbersHelper(root.left,cur,sum);
		  sumNumbersHelper(root.right,cur,sum);
	  }
	  
	  public TreeNode buildTree2(int[] preorder, int[] inorder) {
	        // Note: The Solution object is instantiated only once and is reused by each test case.
	        if(preorder.length==0)
	        	return null;
	        int n=preorder.length;
	        return buildTreeUtil2(preorder,0,n-1,inorder, 0, n-1);
	    }
	  
	  public TreeNode buildTreeUtil2(int[] preorder, int beg1, int end1, int[] inorder, int beg2, int end2){
		  if(beg1>end1)
			  return null;
		  TreeNode root=new TreeNode(preorder[beg1]);
		  int index=-1;
		  for(int i=beg2;i<=end2;i++){
			  if(inorder[i]==root.val){
				  index=i;
				  break;
			  }
		  }
		  int len=index-beg2;
		  root.left=buildTreeUtil2(preorder,beg1+1,beg1+len, inorder,beg2,index-1);
		  root.right=buildTreeUtil2(preorder,beg1+len+1,end1, inorder,index+1, end2);
		  return root;
	  }
	  
	  public int minCut(String s) {
	        // Note: The Solution object is instantiated only once and is reused by each test case.
	        if(s.length()==0)
	        	return 0;
	        int n=s.length();
	        int[] dp=new int[n+1];
	        
	        boolean[][] p=new boolean[n][n];
	        for(int i=n;i>=0;i--)
	        	dp[i]=n-i;
	        
	        for(int i=n-1;i>=0;i--){
	        	for(int j=i;j<n;j++){
	        		if(s.charAt(i)==s.charAt(j)&&(j-i<2||p[i+1][j-1])){
	        			p[i][j]=true;
	        			dp[i]=Math.min(dp[i], dp[j+1]+1);
	        		}
	        	}
	        }
	        return  dp[0]-1;
	    }
	 
	  public static int minCut2(String s) {
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
			  for(int i=0;i<n-len+1;i++){
				  int j=i+len-1;
				  
				  if(s.charAt(i)==s.charAt(j)){
					  if(len==2)
						  p[i][j]=true;
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
	  
	  int max;
	  public int maxPathSum(TreeNode root) {
	        // Note: The Solution object is instantiated only once and is reused by each test case.
	        if(root==null)
	        	return 0;
	        max=root.val;
	        maxPathSumUtil(root);
	        return max;
	    }
	  
	  public int maxPathSumUtil(TreeNode root){
		  if(root==null)
			  return 0;
		  
		  int left=maxPathSumUtil(root.left);
		  int right=maxPathSumUtil(root.right);
		  int sum=root.val;
		  if(left>0)
			  sum+=left;
		  if(right>0)
			  sum+=right;
		  max=Math.max(sum, max);
		  if(Math.max(left, right)>0)
			  return Math.max(left, right)+root.val;
		  else
			  return root.val;
	  }
	  
	  public static String removeBandACFromString(String s){
		  if(s.length()==0||s==null)
			  return s;
		  
		  String res="";
		  
		  for(int i=0;i<s.length();i++){
			  if(s.charAt(i)=='b')
				  continue;
			  if(s.charAt(i)=='a'){
				  if(i+1<s.length()&&s.charAt(i+1)=='c'){
					  i++;
					  continue;
				  }
			  }
			  res+=s.charAt(i);
		  }
		  return res;
	  }
	  
	  public int firstMissingPositive2(int[] A) {
	        // Note: The Solution object is instantiated only once and is reused by each test case.
	        int n=A.length;
	        int[] tmp=new int[n];
	         
	        for(int i=0;i<n;i++){
	        	if(A[i]>0&&A[i]<=n)
	        		tmp[A[i]-1]=1;
	        }
	        
	        for(int i=0;i<n;i++){
	        	if(tmp[i]==0)
	        		return i+1;
	        }
	        return n+1;
	    }
	  
	  public static boolean validParentheses(String s){
		  if(s.length()<2)
			  return false;
		  Stack<Character> stk=new Stack<Character>();
		  for(int i=0;i<s.length();i++){
			  char c=s.charAt(i);
			  if(c=='(')
				  stk.push(c);
			  else if(c==')'){
				  if(stk.isEmpty())
					  return false;
				  stk.pop();
			  }
		  }
		  return stk.isEmpty();
	  }
	  
	  public boolean searchMatrix(int[][] matrix, int target) {
	        // Note: The Solution object is instantiated only once and is reused by each test case.
	        int m=matrix.length;
	        if(m==0)
	        	return false;
	        int n=matrix[0].length;
	        
	        int i=0;
	        int j=n-1;
	        while(i<m&&j>=0){
	        	
	        		if(target==matrix[i][j])
	        			return true;
	        		else if(target>matrix[i][j])
	        			i++;
	        		else
	        			j--;
	        	}
	        
	        return false;
	    }
	  
	  public int[] plusOne2(int[] digits) {
	        // Start typing your Java solution below
	        // DO NOT write main() function
	              int[] res=new int[digits.length];
		        int carry=1;
		        int l=digits.length-1;
		        
		        while(l>=0){
		        	int sum=digits[l]+carry;
		        	carry=sum/10;
		        	sum=sum%10;
		        	res[l]=sum;
		        	l--;
		        }
		        
		        if(carry==1){
		        	int[] ret=new int[digits.length+1];
		        	ret[0]=1;
		        	for(int i=0;i<digits.length;i++)
		        		ret[i+1]=res[i];
		        	return ret;
		        }
		        return res;
	    }
	  
	  public ArrayList<ArrayList<Integer>> combine(int n, int k) {
	        // Note: The Solution object is instantiated only once and is reused by each test case.
		  ArrayList<ArrayList<Integer>> res= new ArrayList<ArrayList<Integer>>();
		  if(n<k)
			  return res;
		  ArrayList<Integer> sol=new ArrayList<Integer>();
		  
		  combineUtil(0,k,n,sol,res,1);
		  return res;
		  
	    }
	  
	  public void combineUtil(int dep, int maxDep, int n, ArrayList<Integer> sol, ArrayList<ArrayList<Integer>> res, int curPos){
		  if(dep==maxDep){
			  ArrayList<Integer>out=new ArrayList<Integer>(sol);
			  res.add(out);
		  }
		  for(int i=curPos;i<=n;i++){
			  sol.add(i);
			  combineUtil(dep+1,maxDep,n,sol,res,i+1);
			  sol.remove(sol.size()-1);
			  
		  }
	  }
	  
	  public TreeNode sortedListToBST(ListNode head) {
	        // Note: The Solution object is instantiated only once and is reused by each test case.
	        if(head==null)
	        	return null;
	        int len=0;
	        ListNode cur=head;
	        while(cur!=null){
	        	len++;
	        	cur=cur.next;
	        }
	        
	        return sortedListToBST(head, 0, len-1);
	      
	        
	    }
	  
	  public TreeNode sortedListToBST(ListNode head, int beg, int end){
		  if(head==null||beg>end)
			  return null;
		  
		  ListNode cur=head;
		  int mid=(beg+end)/2;
	        for(int i=beg;i<mid;i++){
	        	cur=cur.next;
	        }
	        
	        TreeNode root=new TreeNode(cur.val);
	        
	        root.left=sortedListToBST(head,beg, mid-1);
	        root.right=sortedListToBST(cur.next,mid+1,end);
	        return root;
	  }
	  
	  public double pow(double x, int n) {
	        // Note: The Solution object is instantiated only once and is reused by each test case.
	        if(n==0)
	        	return 1;
	        boolean sign=false;
	        if(n<0){
	        	sign=true;
	        	n=-n;
	        }
	        double res=pow(x,n/2);
	        if(n%2==1)
	        	res=res*res*x;
	        else
	        	res=res*res;
	        if(sign)
	        	res=1/res;
	        return res;
	    }
	  
	  TreeNode first=null;
	  TreeNode second=null;
	  TreeNode pre=null;
	  
	  public void recoverTree(TreeNode root){
		  first=null;
		  second=null;
		  pre=null;
		  recoverTreeUtil(root);
		  int t=first.val;
		  first.val=second.val;
		  second.val=t;
		  return;
				  
	  }
	  
	  public void recoverTreeUtil(TreeNode root) {
	        // Note: The Solution object is instantiated only once and is reused by each test case.
	        if(root==null)
	        	return;
	        recoverTreeUtil(root.left);
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
	        recoverTreeUtil(root.right);
	    }
	  
	 
	public void sortColors(int[] A) {
		// Note: The Solution object is instantiated only once and is reused by
		// each test case.
		int i = 0;
		int j = A.length - 1;
		int k = A.length - 1;

		while (i <= j) {
			if (A[i] == 2) {
				A[i] = A[k];
				A[k] = 2;
				k--;
				if (j > k)
					j--;
			} else if (A[i] == 1) {
				A[i] = A[j];
				A[j] = 1;
				j--;
			} else
				i++;
		}
	}
	
	public int removeDuplicates(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
		if(A.length<3)
			return A.length;
        int count=1;
        int j=0;
        for(int i=1;i<A.length;i++){
        if(A[i]!=A[i-1]){
        	j++;
        	A[j]=A[i];
        	count=1;
        }
        else{
        	count++;
        	if(count<3){
        		j++;
        		A[j]=A[i];
        	}
        }
        		
        }
        return j+1;
    }
	
	 public ArrayList<ArrayList<String>> partition(String s) {
	        // Note: The Solution object is instantiated only once and is reused by each test case.
		 ArrayList<ArrayList<String>> res=new ArrayList<ArrayList<String>>();
		 if(s.length()==0)
			 return res;
		 ArrayList<String> sol=new ArrayList<String>();
		 partitionUtil(0, s.length(),s, sol,res);
		 return res;
	    }
	 
	 public void partitionUtil(int dep, int maxDep, String s, ArrayList<String> sol, ArrayList<ArrayList<String>> res ){

		 if(dep==maxDep){
			 ArrayList<String> out=new ArrayList<String> (sol);
			 res.add(out);
		 }
		 
		 for(int i=dep;i<s.length();i++){
			 if(isPalindrome(s.substring(dep, i+1))){
				 sol.add(s.substring(dep,i+1));
				 partitionUtil(i+1,maxDep,s,sol,res);
				 sol.remove(sol.size()-1);
			 }
		 }
	 }
	 
	 public boolean isPalindrome(String s){
		 if(s.length()==0)
			 return true;
		 int i=0;
		 int j=s.length()-1;
		 while(i<j){
			 if(s.charAt(i)!=s.charAt(j))
				 return false;
			 else{
				 i++;
				 j--;
			 }
				 
		 }
		 return true;
	 }
	 
	 public int sqrt(int x) {
	        // Note: The Solution object is instantiated only once and is reused by each test case.
	        if(x==1||x==0)
	        	return x;
	        
	        double res=x;
	        while(Math.abs(res*res-x)>0.01){
	        	res=res-(res*res-x)/(2*res);
	        }
	        return (int)res;
	        
	    }
	 
	 public ArrayList<ArrayList<Integer>> subsets(int[] S) {
	        // Note: The Solution object is instantiated only once and is reused by each test case.
		 ArrayList<ArrayList<Integer>> res=new ArrayList<ArrayList<Integer>>();
		 if(S.length==0)
			 return res;
		 ArrayList<Integer> sol=new ArrayList<Integer>();
		 Arrays.sort(S);
		 subsetUtil(0,S.length,S,sol,res,0);
		 return res;
	    }
	 
	 public void subsetUtil(int dep, int maxDep,int[] S, ArrayList<Integer> sol, ArrayList<ArrayList<Integer>> res, int curPos ){
		 res.add(sol);
		 if(dep==maxDep){
			return;
		 }
		 
		 for(int i=curPos;i<S.length;i++){
			 ArrayList<Integer> list=new ArrayList<Integer>(sol);
				 list.add(S[i]);
				 subsetUtil(dep+1,maxDep,S,list,res,i+1);			 
		 }
	 }
	 
	 
	 public static ArrayList<String> wordBreak(String s, Set<String> dict) {
	        // Note: The Solution object is instantiated only once and is reused by each test case.
		 ArrayList<String> res=new ArrayList<String>();
		 if(s.length()==0)
			 return res;
		 wordBreakUtil(0,s,dict,"",res);
		 return res;
	    }
	 
	 public static void wordBreakUtil(int curPos,String s, Set<String> dict, String sol,ArrayList<String> res){
		 if(curPos==s.length()){
			 res.add(sol);
		 }
		 
		 for(int i=curPos;i<s.length();i++){
			 if(dict.contains(s.substring(curPos,i+1))){
				 String sub=sol+s.substring(curPos,i+1)+" ";
//				 System.out.println(sub);
				 wordBreakUtil(i+1,s,dict,sub,res);
			 }
		 }
	 }
	 
//	 static DLListNode head;
//	 static DLListNode tail;
	 public static  void findFirstNonRepeating(){
		 DLListNode[] inDLL=new DLListNode[256];
		 boolean[] repeated=new boolean[256];
		 DLListNode head=null;
		 DLListNode tail=null;

		 
		 String stream="geeksforgeeksandgeeksquizfor";
		 
		 for(int i=0;i<stream.length();i++){
			 char c=stream.charAt(i);
			 System.out.println("reading "+c+" from stream..");
			 if(!repeated[c]){
				 // If the character is not in DLL, then add this at the end of DLL.
		            if (inDLL[c] == null)
		            {
//		                appendNode(head, tail, c);
		                DLListNode node=new DLListNode(c);
		                if(head==null){
		                	head=tail=node;
		                }
		                else{
		                	tail.next=node;
		                	node.pre=tail;
		                	tail=node;
		                }
		                inDLL[c] = tail;
		            }
		            else // Otherwise remove this character from DLL
		            {
//		                removeNode(head, tail, inDLL[c]);
		                if(inDLL[c]==head)
		                	head=head.next;
		                else if(inDLL[c]==tail)
		                	tail=tail.pre;
		                else {
		                	if(inDLL[c].next!=null)
		                		inDLL[c].next.pre=inDLL[c].pre;
		                	if(inDLL[c].pre!=null)
		                		inDLL[c].pre.next=inDLL[c].next;
		                }
		                inDLL[c] = null;
		                repeated[c] = true;  // Also mark it as repeated
		            }
		        }
		 
		        // Print the current first non-repeating character from stream
		        if (head != null)
		            System.out.println( "First non-repeating character so far is " + head.c );
			 }
		 }
	 
//	 public static void appendNode(DLListNode head, DLListNode tail, char c){
//		 DLListNode node=new DLListNode(c);
//		 if(head==null){
//			 head=tail=node;
//			 return;
//		 }
//		 
//		 tail.next=node;
//		 node.pre=tail;
//		 tail=node;
//		 
//	 }
//	 
//	 public static void removeNode(DLListNode head, DLListNode tail,DLListNode node){
//		 if(head==null)
//			 return;
//		 if(node==head)
//			 head=head.next;
//		 if(node==tail)
//			 tail=tail.pre;
//		 
//		 if(node.next!=null)
//			 node.next.pre=node.pre;
//		 if(node.pre!=null)
//			 node.pre.next=node.next;
//	 }

	 
	 public boolean hasPathSum(TreeNode root, int sum) {
	        // Note: The Solution object is instantiated only once and is reused by each test case.
	        if(root==null)
	        	return false;
	        int curSum=0;
	        return hasPathSumUtil(root,curSum, sum);
	        
	    }
	 
	 public boolean hasPathSumUtil(TreeNode root, int curSum, int sum){		
		 if(root==null)
			 return false;
		 curSum+=root.val;
		 if(root.left==null&&root.right==null&&curSum==sum)
			 return true;
		 return hasPathSumUtil(root.left,curSum,sum)||
				 hasPathSumUtil(root.right,curSum,sum);
	 }
	 
	 public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
	        // Note: The Solution object is instantiated only once and is reused by each test case.
	        int n=triangle.size();
	        if(n==0)
	        	return 0;
	        int len=triangle.get(n-1).size();
	        
	        int[][] dp=new int[n][len];
	        dp[0][0]=triangle.get(0).get(0);
	        
	        for(int i=1;i<n;i++)
	        	dp[i][0]=dp[i-1][0]+triangle.get(i).get(0);
	        
	        for(int i=1;i<n;i++){
	        	for(int j=1;j<triangle.get(i).size();j++){
	        		if(j==triangle.get(i).size()-1)
	        			dp[i][j]=dp[i-1][j-1]+triangle.get(i).get(j);
	        		else
	        			dp[i][j]=Math.min(dp[i-1][j-1],dp[i-1][j])+triangle.get(i).get(j);
	        	}
	        }
	        int min=dp[n-1][0];
	        for(int i=1;i<len;i++){
	        	min=Math.min(min, dp[n-1][i]);
	        }
	        return min;
	        		
	        
	    }
	 
	 
	 public int maxProfit(int[] prices) {
	        // Note: The Solution object is instantiated only once and is reused by each test case.
	        int n=prices.length;
	        if(n<2)
	        	return 0;
	        int[] profit1=new int[n];
	        int[] profit2=new int[n];
	        
	        profit1[0]=0;
	        int lowest=prices[0];
	        int max=0;
	        for(int i=1;i<n;i++){
	        	if(prices[i]<lowest)
	        		lowest=prices[i];
	        	if(prices[i]-lowest>max)
	        		max=prices[i]-lowest;
	        	
	        	profit1[i]=max;
	        }
	        
	        int highest=prices[n-1];
	        profit2[n-1]=0;
	        max=0;
	        for(int i=n-2;i>=0;i--){	        	
	        	if(prices[i]>highest)
	        		highest=prices[i];
	        	if(highest-prices[i]>max)
	        		max=highest-prices[i];
	        	
	        	profit2[i]=max;
	        }
	        
	        int maxProfit=0;
	        for(int i=0;i<n;i++){
	        	if(profit1[i]+profit2[i]>maxProfit)
	        		maxProfit=profit1[i]+profit2[i];
	        }
	        
	        return maxProfit;
	    }
	 
	 public void rotate(int[][] matrix) {
	        // Note: The Solution object is instantiated only once and is reused by each test case.
	        int m=matrix.length;
	        if(m==0)
	        	return;
	        int n=matrix[0].length;
	        
	        for(int i=0;i<m;i++){
	        	for(int j=i;j<n;j++){
	        		int t=matrix[i][j];
	        		matrix[i][j]=matrix[j][i];
	        		matrix[j][i]=t;
	        	}
	        }
	        
	        for(int i=0;i<m;i++){
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
	 
	 
	 public int maxSubArray(int[] A) {
	        // Note: The Solution object is instantiated only once and is reused by each test case.
	        if(A.length==0)
	        	return 0;
	        int sum=0;
	        int max=Integer.MIN_VALUE;
	        for(int i=0;i<A.length;i++){
	        	sum+=A[i];
	        	if(sum>max)
	        		max=sum;
	        	if(sum<0)
	        		sum=0;
	        }
	        if(max==0){
	        	max=A[0];
	        	for(int i=1;i<A.length;i++)
	        		max=Math.max(max,A[i]);
	        }
	        return max;
	    }
	 
	 
	 public void setZeroes(int[][] matrix) {
	        // Note: The Solution object is instantiated only once and is reused by each test case.
	        int m=matrix.length;
	        if(m==0)
	        	return;
	        int n=matrix[0].length;
	        boolean[] row=new boolean[m];
	        boolean[] col=new boolean[n];
	        
	        for(int i=0;i<m;i++){
	        	for(int j=0;j<n;j++){
	        		if(matrix[i][j]==0){
	        			row[i]=true;
	        			col[j]=true;
	        		}
	        	}
	        }
	        
	        for(int i=0;i<m;i++){
	        	for(int j=0;j<n;j++){
	        		if(row[i]||col[j])
	        			matrix[i][j]=0;
	        	}
	        }
	    }
	 
	 
	 public void connect(TreeLinkNode root) {
	        // Note: The Solution object is instantiated only once and is reused by each test case.
	        if(root==null)
	        	return;
	        if(root.left!=null){
	        	root.left.next=root.right;
	        }
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
	        // Note: The Solution object is instantiated only once and is reused by each test case.
	        if(root==null)
	        	return;
	        Queue<TreeLinkNode> que=new LinkedList<TreeLinkNode>();
	        int curlevel=0;
	        int nextlevel=0;
	        que.add(root);
	        curlevel++;
	        
	        while(!que.isEmpty()){
	        	TreeLinkNode top=que.poll();
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
	        		top.next=null;
	        		curlevel=nextlevel;
	        		nextlevel=0;
	        	}
	        	else
	        		top.next=que.peek();
	        }
	    }
	 
	 
	 public ArrayList<String> generateParenthesis2(int n) {
	        // Note: The Solution object is instantiated only once and is reused by each test case.
		 ArrayList<String> res=new ArrayList<String>();
		 
		 if(n<=0)
	        	return res;
		 generateParenthesisUtil(0,0,n,"",res);
		 return res;
	    }
	 
	 public void generateParenthesisUtil(int left, int right, int n, String sol,ArrayList<String> res){
		 if(left==n&&left==right)
			 res.add(sol);
		 if(left<n)
			 generateParenthesisUtil(left+1,right,n,sol+"(",res);
		 if(right<left)
			 generateParenthesisUtil(left,right+1,n,sol+")",res);
	 }
	 
	 
	 public boolean wordBreakdp(String s, Set<String> dict) {
		 int n=s.length();
		 if(n==0)
			 return true;
		 boolean[] dp=new boolean[n];
		 
		 for(int i=n-1;i>=0;i--){
			 for(int j=i+1;j<=n;j++){
				 String sub=s.substring(i,j);
				 if(dict.contains(sub)&&j==n){
					 dp[i]=true;
					 break;
				 }
				 else{
					 if(dict.contains(sub)&&j<n&&dp[j]){
						 dp[i]=true;
						 break;
					 }
					 
				 }
					 
			 }
		 }
		 return dp[0];
	 }
	 
	 
	 public static ArrayList<String> wordBreak2(String s, Set<String> dict) {
		 ArrayList<String> res=new ArrayList<String>();
		 if(s.length()==0)
			 return res;
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
		 
		 if(!dp[0][n])
			 return res;
		 findWords(0,s,dp,"",res);
		 return res;
	 }
	 
	 public static void findWords(int cur, String s, boolean[][] dp, String sol,ArrayList<String> res){
		 if(cur==s.length()){
			 res.add(sol);
		 }
//		 if(!dp[cur][s.length()-1])
//			 return;
//		 
		 for(int i=cur;i<s.length();i++){
			 if(dp[cur][i]){
				 String sub="";
				 if(i<s.length()-1){
					sub=sol+s.substring(cur,i+1)+" ";					 
				 }
				 else
					 sub=sol+s.substring(cur,i+1);
				 findWords(i+1,s,dp,sub,res);
				
			 }
		 }
	 }
	 
	 
	 
	 public int maxProfit1(int[] prices) {
	        // Note: The Solution object is instantiated only once and is reused by each test case.
	        if(prices.length==0)
	        	return 0;
	        int lowest=prices[0];
	        int max=0;
	        for(int i=1;i<prices.length;i++){
	        	if(prices[i]<lowest)
	        		lowest=prices[i];
	        	max=Math.max(max, prices[i]-lowest);
	        }
	        return max;
	    }
	 
	 
	 public int maxProfit2(int[] prices) {
	        // Note: The Solution object is instantiated only once and is reused by each test case.
	        int n=prices.length;
	        if(n==0)
	        	return 0;
	        int max=0;
	        for(int i=1;i<n;i++){
	        	if(prices[i]-prices[i-1]>0)
	        		max+=prices[i]-prices[i-1];
	        }
	        return max;
	    }
	 
	 public int minDepth(TreeNode root) {
	        // Note: The Solution object is instantiated only once and is reused by each test case.
	        if(root==null)
	        	return 0;
//	        if(root.left==null){
//	        	return minDepth(root.right)+1;
//	        }
//	        if(root.right==null)
//	        	return minDepth(root.left)+1;
//	        return Math.min(minDepth(root.left), minDepth(root.right))+1;
	        int left=minDepth(root.left);
	        int right=minDepth(root.right);
	        if(left==0)
	        	return right+1;
	        if(right==0)
	        	return left+1;
	        return left<right?left+1:right+1;
	    }
	 
	 public boolean isSymmetric(TreeNode root) {
	        // Note: The Solution object is instantiated only once and is reused by each test case.
	        if(root==null)
	        	return true;
	        return isSymmetricUtil(root.left,root.right);
	    }
	 
	 public boolean isSymmetricUtil(TreeNode left, TreeNode right){
		 if(left==null&&right==null)
			 return true;
		 if(left==null||right==null)
			 return false;
		 if(left.val!=right.val)
			 return false;
		 return isSymmetricUtil(left.left,right.right)&&isSymmetricUtil(left.right,right.left);
	 }
	 
	 
	 
	 public static  boolean isInterleave(String s1, String s2, String s3) {
	        // Note: The Solution object is instantiated only once and is reused by each test case.
	        int n1=s1.length();
	        int n2=s2.length();
	        if(n1+n2!=s3.length())
	        	return false;
	        boolean[][] dp=new boolean[n1+1][n2+1];
	        dp[0][0]=true;
	        
	        for(int i=1;i<=n1;i++)
	        	dp[i][0]=dp[i-1][0]&&s1.charAt(i-1)==s3.charAt(i-1);
	        
	        for(int j=1;j<=n2;j++)
	        	dp[0][j]=dp[0][j-1]&&s2.charAt(j-1)==s3.charAt(j-1);
	        
	        for(int i=1;i<=n1;i++){
	        	for(int j=1;j<=n2;j++){
	        		dp[i][j]=dp[i-1][j]&&s1.charAt(i-1)==s3.charAt(i+j-1)||
	        				dp[i][j-1]&&s2.charAt(j-1)==s3.charAt(i+j-1);
	        	}
	        }
	        
	        return dp[n1][n2];
	    }
	 
	 public static int[] multiplyExceptSelf(int [] input){
		 int n=input.length;
		 int[] res=new int[n];
		 int[]l=new int[n];
		 int[] r=new int[n];
		 l[0]=1;
		 
		 for(int i=1;i<n;i++){
			 l[i]=l[i-1]*input[i-1];
		 }
		 r[n-1]=1;
		 for(int i=n-2;i>=0;i--)
			 r[i]=r[i+1]*input[i+1];
		 
		 for(int i=0;i<n;i++)
			 res[i]=l[i]*r[i];
		 
//		 for(int i=0;i<n;i++)
//			 System.out.print(res[i]+" ");
		 
		 return res;
	 }
	 
	 public boolean isValidBST(TreeNode root) {
	        // Note: The Solution object is instantiated only once and is reused by each test case.
	        if(root==null)
	        	return true;
	        return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	    }
	 
	 public boolean isValidBST(TreeNode root, int leftmost, int rightmost){
		 if(root==null)
			 return true;
		 if(root.val<=leftmost||root.val>=rightmost)
			 return false;
		 return isValidBST(root.left,leftmost,root.val)&&
				 isValidBST(root.right,root.val,rightmost);
	 }
	 
	 public ArrayList<ArrayList<Integer>> generate(int numRows) {
	        // Note: The Solution object is instantiated only once and is reused by each test case.
		 ArrayList<ArrayList<Integer>> res=new ArrayList<ArrayList<Integer>>();
		 if(numRows<=0)
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
			 ArrayList<Integer> row=new ArrayList<Integer>();
			 for(int j=0;j<=i;j++){
				 row.add(dp[i][j]);
			 }
			 res.add(row);
		 }
		 
		 return res;
	    }
	 
	 
	 public ArrayList<Integer> getRow(int rowIndex) {
	        // Note: The Solution object is instantiated only once and is reused by each test case.
		 ArrayList<Integer> res=new ArrayList<Integer>();
		 if(rowIndex<0)
			 return res;
		 
		 int[] dp=new int[rowIndex+1];
		 dp[0]=1;
		 dp[rowIndex]=1;
		 
		 for(int i=1;i<=rowIndex;i++){
			 for(int j=i;j>0;j--){
				 if(j==i)
					 dp[j]=1;
				 else
					 dp[j]=dp[j]+dp[j-1];
			 }
		 }
		 
		 for(int i=0;i<dp.length;i++)
			 res.add(dp[i]);
		 
		 return res;
	    }
	 
	 
	 
	 public ArrayList<TreeNode> generateTrees(int n) {
	        // Note: The Solution object is instantiated only once and is reused by each test case.
		 ArrayList<TreeNode> res=new ArrayList<TreeNode>();
		 if(n<=0)
			 return res;
		 generateTreesUtil(1,n,res);
		 return res;
	    }
	 
	 public void generateTreesUtil(int beg, int end, ArrayList<TreeNode> res){
		 
		 if(beg>end){
			 res.add(null);
		 }
		 
		 for(int i=beg;i<=end;i++){
			 ArrayList<TreeNode> left=new ArrayList<TreeNode>();
			 generateTreesUtil(beg,i-1,left);
			 
			 ArrayList<TreeNode> right=new ArrayList<TreeNode>();
			 generateTreesUtil(i+1,end,right);
			 
			 
			 for(int j=0;j<left.size();j++){
				 for(int k=0;k<right.size();k++){
					 TreeNode root=new TreeNode(i);
					 root.left=left.get(j);
					 root.right=right.get(k);
					 res.add(root);
				 }
			 }
		 }
		 
	 }
	 
	 public boolean canJump(int[] A) {
	        // Note: The Solution object is instantiated only once and is reused by each test case.
		 	int n=A.length;
		 if(n==0)
		 		return true;
		 	boolean[] dp=new boolean[n];
		 	dp[n-1]=true;
		 	int gap=0;
		 	
		 	for(int i=n-2;i>=0;i--){
		 		if(A[i]>gap){
		 			dp[i]=true;
		 			gap=0;
		 		}
		 		else
		 			gap++;
		 	}
		 	return dp[0];
	    }
	 
	 public void nextPermutation(int[] num) {
	        // Note: The Solution object is instantiated only once and is reused by each test case.
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
	        int idx = index+1;
	        for(int i=index+2;i<num.length;i++){
	        	if(num[i]>num[index])
	        		idx=i;
	        }
	        int t=num[index];
	        num[index]=num[idx];
	        num[idx]=t;
	        
	        int beg=index+1;
	        int end=num.length-1;
	        
	        while(beg<end){
	        	t=num[beg];
	        	num[beg]=num[end];
	        	num[end]=t;
	        	beg++;
	        	end--;
	        }
	    }
	 
	 
	 public int uniquePaths(int m, int n) {
	        // Note: The Solution object is instantiated only once and is reused by each test case.
	        int[][] dp=new int[m][n];
	        for(int i=0;i<m;i++)
	        	dp[i][0]=1;
	        for(int j=0;j<n;j++)
	        	dp[0][j]=1;
	        
	        for(int i=1;i<m;i++){
	        	for(int j=1;j<n;j++)
	        		dp[i][j]=dp[i-1][j]+dp[i][j-1];
	        }
	        return dp[m-1][n-1];
	    }
	 
	 public int removeDuplicates2(int[] A) {
	        // Note: The Solution object is instantiated only once and is reused by each test case.
	        if(A.length<2)
	        	return A.length;
	        int i=0,j=0;
	        
	        for(i=1;i<A.length;i++){
	        	if(A[i]!=A[i-1]){
	        		j++;
	        		A[j]=A[i];
	        	}	        		
	        }
	        return j+1;
	    }
	 
	 public String simplifyPath(String path) {
	        // Note: The Solution object is instantiated only once and is reused by each test case.
	        if(path.length()==0)
	        	return "/";
	        
	        String[] strs=path.split("/");
	        
	        Stack<String> stk=new Stack<String>();
	        for(String s:strs){
	        	if(s.equals("")||s.equals("."))
	        		continue;
	        	else if(s.equals("..")){
	        		if(!stk.isEmpty())
	        			stk.pop();
	        	}
	        	else
	        		stk.push(s);
	        }
	        
	        String res="";
	        if(stk.isEmpty())
	        	return "/";
	        while(!stk.isEmpty()){
	        	String top=stk.pop();
	        	res="/"+top+res;
	        }
	        return res;
	    }
	 
	 public TreeNode sortedArrayToBST(int[] num) {
	        // Note: The Solution object is instantiated only once and is reused by each test case.
	        if(num.length==0)
	        	return null;
	        return sortedArrayToBSTUtil(0, num.length-1, num);
	        
	    }
	 
	 public TreeNode sortedArrayToBSTUtil(int beg, int end, int[] num){
		 if(beg>end)
			 return null;
		 int mid=(beg+end)/2;
		 TreeNode root=new TreeNode(num[mid]);
		 root.left=sortedArrayToBSTUtil(beg,mid-1,num);
		 root.right=sortedArrayToBSTUtil(mid+1,end,num);
		 return root;
	 }
	 
	 public ListNode partition(ListNode head, int x) {
	        // Note: The Solution object is instantiated only once and is reused by each test case.
	        if(head==null)
	        	return null;
	        
	        ListNode small=new ListNode(0);
	        ListNode smallhead=small;
	        ListNode big=new ListNode(1);
	        ListNode bighead=big;
	        
	        ListNode cur=head;
	        while(cur!=null){
	        	if(cur.val<x){
	        		small.next=cur;
	        		small=small.next;
	        	}
	        	else{
	        		big.next=cur;
	        		big=big.next;
	        	}
	        	cur=cur.next;
	        }
	        small.next=bighead.next;
	        big.next=null;
	        
	        return smallhead.next;
	    }
	 
	 
	 public void flatten(TreeNode root) {
	        // Note: The Solution object is instantiated only once and is reused by each test case.
	        if(root==null)
	        	return;
	        TreeNode l=root.left;
	        TreeNode r=root.right;
	        if(l!=null){
	        	root.right=l;
	        	root.left=null;
	        	TreeNode rightmost=l;
	        	
	        	while(rightmost.right!=null)
	        		rightmost=rightmost.right;
	        	rightmost.right=r;
	        }
	        flatten(root.right);
	    }
	 
	 public void flatten2(TreeNode root) {
		 if(root==null)
			 return;
		 flatten(root.left);
		 flatten(root.right);

		 TreeNode p=root;
		 if(p.left==null)
			 return;
		 p=p.left;
		 while(p.right!=null)
			 p=p.right;
		 p.right=root.right;
		
		 root.right=root.left;
		 root.left=null;
		 
	 }
	 
	 public void flatten3(TreeNode root){
		 if(root==null)
			 return;
		 Stack<TreeNode> stk=new Stack<TreeNode>();
		 stk.push(root);
		 TreeNode cur=root;
		 
		 while(!stk.isEmpty()){
			 TreeNode top=stk.pop();

			 if(top.right!=null)
				 stk.push(top.right);
			 if(top.left!=null)
				 stk.push(top.left);
			 if(top!=root){
				 cur.left=null;
				 cur.right=top;
				 cur=cur.right;
			 }
		 }
		 
	 }
	
	 
	 public static void putZerosToEnd(int[] arr){
		 if(arr.length<2)
			 return;
		 
		 int count=0;
		 for(int i=0;i<arr.length;i++){
			 if(arr[i]!=0){
				 arr[count]=arr[i];
				 count++;
			 }
		 }
		 for(int i=count;i<arr.length;i++){
			 arr[i]=0;
		 }
		 
		 for(int i=0;i<arr.length;i++)
			 System.out.print(arr[i]+" ");
	 }
	 
	 public int ladderLength(String start, String end, HashSet<String> dict) {
	        // Note: The Solution object is instantiated only once and is reused by each test case.
	        Queue<String> que=new LinkedList<String>();
	        int curlevel=0;
	        int nextlevel=0;
	        int steps=1;
	        que.add(start);
	        curlevel++;
	        
	        HashSet<String> visited=new HashSet<String>();
	        
	        while(!que.isEmpty()){
	        	String s=que.poll();
	        	curlevel--;
	        	if(s.equals(end))
	        		return steps;
	        	else{
	        		char[] ch=s.toCharArray();
	        		for(int i=0;i<ch.length;i++){
	        			char c=ch[i];
	        			for(char t='a';t<='z';t++){
	        				if(t!=c){
	        					ch[i]=t;
	        					String st=new String(ch);
	        					if(dict.contains(st)&&!visited.contains(st)){
	        						que.add(st);
	        						visited.add(st);
	        						nextlevel++;
	        					}
	        				}
	        			}
	        			ch[i]=c;
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
	 
	  public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
	        // Note: The Solution object is instantiated only once and is reused by each test case.
		  ArrayList<ArrayList<Integer>> res =new ArrayList<ArrayList<Integer>>();
		  if(num.length==0)
			  return res;
		  ArrayList<Integer> sol=new ArrayList<Integer>();
		  boolean[] used=new boolean[num.length];
		  
		  Arrays.sort(num);
		  
		  subsetsWithDupUtil(0,num.length,num,used,sol,res);
		  return res;
	    }
	  
	  public void subsetsWithDupUtil(int dep, int maxDep, int[] num, boolean[] used, ArrayList<Integer> sol,ArrayList<ArrayList<Integer>> res){
		  res.add(sol);
		  if(dep==maxDep){
			  return;
		  }
		  for(int i=dep;i<num.length;i++){
			  if(!used[i]){
				  if(i!=0&&num[i]==num[i-1]&&!used[i-1])
					  continue;
				  else{
					  used[i]=true;
					  ArrayList<Integer> lst=new ArrayList<Integer>(sol);
					  lst.add(num[i]);
					  subsetsWithDupUtil(i+1,maxDep,num,used,lst,res);
					  used[i]=false;
				  }
			  }
		  }
	  }
	  
	  public ArrayList<String> anagrams(String[] strs) {
	        // Note: The Solution object is instantiated only once and is reused by each test case.
		  ArrayList<String> res=new ArrayList<String>();
		  HashMap<String, ArrayList<String>> map=new HashMap<String, ArrayList<String>>();
		  
		  for(String s: strs){
			  char[] ch=s.toCharArray();
			  Arrays.sort(ch);
			  String st=new String(ch);
			  if(!map.containsKey(st)){
				  ArrayList<String> lst=new ArrayList<String>();
				  lst.add(s);
				  map.put(st, lst);
			  }
			  else{
				  map.get(st).add(s);
			  }
		  }
		  Iterator<String> it=map.keySet().iterator();
		  
		  while(it.hasNext()){
			  String s=it.next();
			  if(map.get(s).size()>1)
				  res.addAll(map.get(s));
		  }
		  return res;
	    }
	  
	  public boolean isSameTree2(TreeNode p, TreeNode q) {
	        // Note: The Solution object is instantiated only once and is reused by each test case.
	        if(p==null&&q==null)
	        	return true;
	        if(p==null||q==null)
	        	return false;
	        if(p.val!=q.val)
	        	return false;
	        return isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);
	    }
	  
	  public boolean subTree(TreeNode p, TreeNode q){
		  if(p==null&&q==null)
			  return true;
		  if(p==null&&q!=null)
			  return false;
		  if(p!=null&&q==null)
			  return true;
		  if(isSameTree(p,q))
			  return true;
		  return subTree(p.left,q)&&subTree(p.right,q);
	  }
	  
	  
	  public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
	        // Note: The Solution object is instantiated only once and is reused by each test case.
		  ArrayList<ArrayList<Integer>> res=new ArrayList<ArrayList<Integer>>();
		  if(root==null)
			  return res;
		  ArrayList<Integer> sol=new ArrayList<Integer>();
		  int curSum=0;
		  pathSumUtil(root, curSum, sum,sol, res);
		  return res;
	    }
	  
	  public  void pathSumUtil(TreeNode root, int cursum, int sum, ArrayList<Integer> sol,  ArrayList<ArrayList<Integer>> res){
		  if(root==null)
			  return;
		  cursum+=root.val;
		  sol.add(root.val);
		  if(cursum==sum&&root.left==null&&root.right==null){
			  ArrayList<Integer> out=new ArrayList<Integer>(sol);
			  res.add(out);
		  }
		  pathSumUtil(root.left,cursum,sum,sol,res);
		  pathSumUtil(root.right,cursum,sum,sol,res);
		  cursum-=sol.get(sol.size()-1);
		  sol.remove(sol.size()-1);
		  
	  }
	  
	  public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
	        // Note: The Solution object is instantiated only once and is reused by each test case.
		  ArrayList<ArrayList<Integer>> res=new ArrayList<ArrayList<Integer>>();
		  if(root==null)
			  return res;
		  Stack<TreeNode> stk1=new Stack<TreeNode>();
		  Stack<TreeNode> stk2=new Stack<TreeNode>();
		  
		  ArrayList<Integer> level=new ArrayList<Integer>();
		  stk1.push(root);
		  boolean left2right=true;
		  while(!stk1.isEmpty()){
			  TreeNode top=stk1.pop();
			  level.add(top.val);
			  if(!left2right){
				  if(top.right!=null)
					  stk2.push(top.right);
				  if(top.left!=null)
					  stk2.push(top.left);
			  }
			  else{
				  if(top.left!=null)
					  stk2.push(top.left);
				  if(top.right!=null)
					  stk2.push(top.right);
			  }
			  if(stk1.isEmpty()){
				  res.add(level);
				  level=new ArrayList<Integer>();
				  left2right=!left2right;
				  stk1=stk2;
				  stk2=new Stack<TreeNode>();
			  }
			  
		  }
		  return res;
	    }
	  
	  public ArrayList<ArrayList<Integer>> zigzagLevelOrder2(TreeNode root) {
		  ArrayList<ArrayList<Integer>> res=new ArrayList<ArrayList<Integer>>();
		  if(root==null)
			  return res;
		  int curlevel=0;
		  int nextlevel=0;
		  Queue<TreeNode> que=new LinkedList<TreeNode>();
		  que.add(root);
		  curlevel++;
		  ArrayList<Integer> sol=new ArrayList<Integer>();
		  boolean left2right=true;
		  while(!que.isEmpty()){
			  TreeNode top=que.remove();
			  curlevel--;
			  sol.add(top.val);
			  if(top.left!=null){
				  que.add(top.left);
				  nextlevel++;
			  }
			  if(top.right!=null){
				  que.add(top.right);
				  nextlevel++;
			  }
			  
			  if(curlevel==0){
				  if(left2right){
					  res.add(sol);
				  }
				  else{
					  Collections.reverse(sol);
					  res.add(sol);
				  }
				  sol=new ArrayList<Integer>();
				  curlevel=nextlevel;
				  nextlevel=0;
				  left2right=!left2right;
			  }
		  }
		  return res;
		  
	  }
	  
	  public int threeSumClosest2(int[] num, int target) {
	        // Note: The Solution object is instantiated only once and is reused by each test case.
	        if(num.length<3)
	        	return 0;
	        int closeSum=Integer.MAX_VALUE;
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
	        			closeSum=sum;
	        		}
	        		if(sum>target)
	        			end--;
	        		else
	        			beg++;
	        	}
	        }
	        return closeSum;
	    }
	 
	  
	  public ListNode mergeKLists(ArrayList<ListNode> lists) {
	        // Note: The Solution object is instantiated only once and is reused by each test case.
	        if(lists.size()==0)
	        	return null;
	        
	        while(lists.size()>1){
	        	ListNode node1=lists.remove(0);
	        	ListNode node2=lists.remove(0);
	        	ListNode node=mergeList(node1,node2);
	        	lists.add(node);
	        }
	        return lists.get(0);
	    }
	  
	  public ListNode mergeList(ListNode node1, ListNode node2){
		  if(node1==null||node2==null)
			  return node1==null?node2:node1;
		  
		  ListNode p=new ListNode(0);
		  ListNode head=p;
		  while(node1!=null&&node2!=null){
			  if(node1.val<node2.val){
				  p.next=node1;
				  node1=node1.next;
			  }
			  else{
				  p.next=node2;
				  node2=node2.next;
			  }
			  p=p.next;
		  }
		  if(node1!=null)
			  p.next=node1;
		  if(node2!=null)
			  p.next=node2;
		  
		  return head.next;
	  }
	  
	  public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
	        // Note: The Solution object is instantiated only once and is reused by each test case.
		  ArrayList<Interval> res=new ArrayList<Interval>();  
		  if(intervals.size()==0){
			  res.add(newInterval);
			  return res;
		  }
		  boolean inserted=false;
		  for(int i=0;i<intervals.size();i++){
			  Interval interval=intervals.get(i);
			  if(interval.start<newInterval.start)
				  insertInterval(interval,res);
			  else{
				  insertInterval(newInterval, res);
				  inserted=true;
				  insertInterval(interval,res);
			  }
			  
		  }
		  if(!inserted)
			  insertInterval(newInterval,res);
		  return res;		  
		  
	    }
	  
	  public void insertInterval(Interval interval, ArrayList<Interval> res){
		  if(res.size()==0){
			  res.add(interval);
			  return;
		  }
		  
		  Interval interv=res.get(res.size()-1);
		  if(interv.end<interval.start)
			  res.add(interval);
		  else{
			  interv.end=Math.max(interv.end, interval.end);
		  }
	  }
	  
	  public int uniquePathsWithObstacles(int[][] obstacleGrid) {
	        // Note: The Solution object is instantiated only once and is reused by each test case.
	        int m=obstacleGrid.length;
	        if(m==0)
	        	return 0;
	        int n=obstacleGrid[0].length;
	        
	        int[][] dp=new int[m][n];
	        dp[0][0]=obstacleGrid[0][0]==0?1:0;
	        
	        for(int i=1;i<m;i++)
	        	dp[i][0]=obstacleGrid[i][0]==1?0:dp[i-1][0];
	        
	        for(int i=1;i<n;i++)
	        	dp[0][i]=obstacleGrid[0][i]==1?0:dp[0][i-1];
	        
	        for(int i=1;i<m;i++){
	        	for(int j=1;j<n;j++){
	        		if(obstacleGrid[i][j]==1)
	        			dp[i][j]=0;
	        		else
	        			dp[i][j]=dp[i-1][j]+dp[i][j-1];
	        	}
	        }
	        return dp[m-1][n-1];
	        		
	    }
	  
	  class comparator implements Comparator<Interval>{

		@Override
		public int compare(Interval o1, Interval o2) {
			// TODO Auto-generated method stub
			return o1.start-o2.start;
		}
		  
	  }
	  
	  public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
		  if(intervals.size()<2)
			  return intervals;
		  
		  Collections.sort(intervals, new comparator());
		  ArrayList<Interval> res = new ArrayList<Interval>();
		  res.add(intervals.get(0));
		  
		  for(int i=1;i<intervals.size();i++){
			  Interval interval=intervals.get(i);
			  Interval lastinterval=res.get(res.size()-1);
			  
			  if(interval.start>lastinterval.end)
				  res.add(interval);
			  else{
				  lastinterval.end=Math.max(lastinterval.end, interval.end);
			  }
		  }
		  return res;
	  }
	  
	  
	  public static Stack<Integer> sortStack(Stack<Integer> stk){
		  Stack<Integer> stk1=new Stack<Integer>();
		  while(!stk.isEmpty()){
			  int top=stk.pop();
			  while(!stk1.isEmpty()&&stk1.peek()>top)
				  stk.push(stk1.pop());
			  stk1.push(top);
		  }
		  return stk1;
	  }
	  
	  public int trap2(int[] A) {
	        // Note: The Solution object is instantiated only once and is reused by each test case.
	        if(A.length==0)
	        	return 0;
	        
	        int[] left=new int[A.length];
	        int[] right=new int[A.length];
	        
	        int leftmost=A[0];
	        for(int i=0;i<A.length;i++){
	        	left[i]=leftmost;
	        	if(A[i]>leftmost)
	        		leftmost=A[i];
	        }
	        
	        int rightmost=A[A.length-1];
	        
	        for(int i=A.length-1;i>=0;i--){
	        	right[i]=rightmost;
	        	if(A[i]>rightmost)
	        		rightmost=A[i];
	        }
	        
	        int sum=0;
	        for(int i=0;i<A.length;i++){
	        	int trap=Math.min(left[i], right[i])-A[i];
	        	if(trap>0)
	        		sum+=trap;
	        }
	        
	        return sum;
	    }
	  
	  
	  public int maxArea2(int[] height) {
	        // Note: The Solution object is instantiated only once and is reused by each test case.
	        if(height.length<2)
	        	return 0;
	        int beg=0;
	        int end=height.length-1;
	        int max=0;
	        
	        while(beg<end){
	        	int area=Math.min(height[beg], height[end])*(end-beg);
	        	if(area>max)
	        		max=area;
	        	if(height[beg]>height[end])
	        		end--;
	        	else
	        		beg++;
	        }
	        return max;
	    }
	  
	  public static int search(int[] A, int target) {
	        // Note: The Solution object is instantiated only once and is reused by each test case.
	        if(A.length==0)
	        	return -1;
	        
	        int beg=0;
	        int end=A.length-1;
	        
	        while(beg<=end){
	        	int mid=(beg+end)/2;
	        	if(A[mid]==target)
	        		return mid;
	        	else if(A[beg]<=A[mid]){
	        		if(A[beg]<=target&&target<A[mid])
	        			end=mid-1;
	        		else
	        			beg=mid+1;
	        	}
	        	else if(A[mid]<A[end]){
	        		if(A[mid]<target&&target<=A[end])
	        			beg=mid+1;
	        		else
	        			end=mid-1;
	        	}
	        }
	        return -1;
	    }
	  
	  public int divide(int dividend, int divisor) {
	        // Note: The Solution object is instantiated only once and is reused by each test case.
	        boolean sign=false;
	        if(dividend<0&&divisor>0||dividend>0&&divisor<0)
	        	sign=true;
	        int res=0;
	        
	        long dvd=dividend;
	        if(dvd<0)
	        	dvd=-dvd;
	        long dvs=divisor;
	        if(dvs<0)
	        	dvs=-dvs;
	        
	        while(dvd>=dvs){
	        	long t=dvs;
	        	
	        	for(int i=0;dvd>=t;i++,t<<=1){
	        		dvd-=t;
	        		res+=1<<i;
	        	}
	        }
	        return sign?-res:res;
	    }
	  
	  public boolean exist(char[][] board, String word) {
	        // Note: The Solution object is instantiated only once and is reused by each test case.
	        int m=board.length;
	        if(m==0)
	        	return false;
	        int n=board[0].length;
	        boolean[][] canUse = new boolean[m][n];
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++)
					canUse[i][j] = true;
			}
	        
	        for(int i=0;i<m;i++){
	        	for(int j=0;j<n;j++){
	        		if(board[i][j]==word.charAt(0)){
	        			if(dfs(board,word, i, j, canUse,0))
	        					return true;
	        		}
	        	}
	        }
	        return false;
	    }
	  
//	  public boolean dfs(char[][] board, String word, int i, int j, boolean canUse[][], int curPos){
//		  if(i<0||j<0||i >= board.length || j >= board[0].length)
//			  return false;
//		  
//		  if (board[i][j] != word.charAt(curPos) || !canUse[i][j])
//			    return false;
//		  canUse[i][j] = false;
//		  if (curPos == word.length() - 1)
//			  return true;
//		 
//		  boolean res = dfs(board, word, i - 1, j, canUse, curPos + 1)
//					|| dfs(board, word, i + 1, j, canUse, curPos + 1)
//					|| dfs(board, word, i, j - 1, canUse, curPos + 1)
//					|| dfs(board, word, i, j + 1, canUse, curPos + 1);
//		  canUse[i][j]=true;
//		  return res;
//		  
//	  }
//	  
	  public boolean dfs(char[][] board, String word, int i, int j, boolean canUse[][], int curPos){
		  if(curPos==word.length())
			  return true;
		  if(i>=0&&i<board.length&&j>=0&&j<board[0].length&&board[i][j]==word.charAt(curPos)&&canUse[i][j]){
			 canUse[i][j]=false;
			  boolean res = dfs(board, word, i - 1, j, canUse, curPos + 1)
						|| dfs(board, word, i + 1, j, canUse, curPos + 1)
						|| dfs(board, word, i, j - 1, canUse, curPos + 1)
						|| dfs(board, word, i, j + 1, canUse, curPos + 1);
			  if(res)
				  return true;
			  else
				  canUse[i][j]=true;
		  }
		  return false;
	  }
	  
	  public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
	        // Note: The Solution object is instantiated only once and is reused by each test case.
		  ArrayList<ArrayList<Integer>> res=new ArrayList<ArrayList<Integer>>();
		  if(candidates.length==0)
			  return res;
		  ArrayList<Integer> sol=new ArrayList<Integer>();
		  Arrays.sort(candidates);
		  
		  combinationSumUtil(0,candidates,target,0,sol,res);
		  return res;
	    }
	  
	  public void combinationSumUtil(int dep, int[] candidates, int target,
			  int cursum,ArrayList<Integer> sol, ArrayList<ArrayList<Integer>> res){
		  if(dep==candidates.length||cursum>target)
			  return;
		  if(cursum==target){
			  ArrayList<Integer> out=new ArrayList<Integer>(sol);
			  res.add(out);
		  }
		  
		  for(int i=dep;i<candidates.length;i++){
			  cursum+=candidates[i];
			  sol.add(candidates[i]);
			  combinationSumUtil(i,candidates,target,cursum,sol,res);
			  cursum-=sol.get(sol.size()-1);
//			  cursum-=candidates[i]; same as above
			  sol.remove(sol.size()-1);
		  }
	  }
	  
	  public ListNode rotateRight(ListNode head, int n) {
	        // Note: The Solution object is instantiated only once and is reused by each test case.
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
	        for(int i=0;i<n;i++){
	        	cur=cur.next;
	        }
	        
	        ListNode pre=head;
	        while(cur!=null&&cur.next!=null){
	        	pre=pre.next;
	        	cur=cur.next;
	        }
	        
	        ListNode newhead=pre.next;
	        pre.next=null;
	        
	        cur.next=head;
	        
	        return newhead;
	        
	    }
	  
	  
	  ///longest path in biary tree
	  public static int diameter(TreeNode root){
		  if(root==null)
			  return 0;
		  int left=diameter(root.left);
		  int right=diameter(root.right);
		  
		  int lheight=getHeight(root.left);
		  int rheight=getHeight(root.right);
		  return Math.max(lheight+rheight+1,Math.max(left, right));
		  
	  }
	  
	  public static int diameterOpt(TreeNode root){
		  if(root==null)
			  return 0;
		  int[] height={0};
		  return diameterOpt(root,height);
	  }
	  
	  public static int diameterOpt(TreeNode root, int[] height){
		  int[] lh={0};
		  int[] rh={0};
		  if(root==null){
			  height[0]=0;
			  return 0;
		  }
		  
		  int ldiameter=diameterOpt(root.left,lh);
		  int rdiameter=diameterOpt(root.right,rh);
		  height[0]=Math.max(lh[0],rh[0])+1;
		  
		  return Math.max(Math.max(ldiameter, rdiameter), lh[0]+rh[0]+1);
	  }
	  
	  public boolean isScramble(String s1, String s2) {
	        // Note: The Solution object is instantiated only once and is reused by each test case.
	        if(s1.length()!=s2.length())
	        	return false;
	        int n=s1.length();
	        boolean[][][] dp=new boolean[n][n][n+1];
	        
	        for(int i=n-1;i>=0;i--){
	        	for(int j=n-1;j>=0;j--){
	        		for(int k=1;k<=n-Math.max(i, j);k++){
	        			if(s1.substring(i, i+k).equals(s2.substring(j,j+k)))
	        				dp[i][j][k]=true;
	        			else{
	        				for(int l=1;l<k;l++){
	        					if((dp[i][j][l]&&dp[i+l][j+l][k-l])||
	        							(dp[i][j+k-l][l]&&dp[i+l][j][k-l])){
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
	  
	  public static TreeNode treeToDoublyList(TreeNode root){
		  if(root==null)
			  return null;
		  
		  TreeNode head=treeToDoublyListUtil(root);
		  while(head.left!=null)
			  head=head.left;
		  return head;		  
		  
	  }
	  
	  public static TreeNode treeToDoublyListUtil(TreeNode root){
		  if(root==null)
			  return null;
		  if(root.left!=null){
			  TreeNode left=treeToDoublyList(root.left);
			  while(left.right!=null)
				  left=left.right;
			  left.right=root;
			  root.left=left;
		  }
		  
		  if(root.right!=null){
			  TreeNode right=treeToDoublyList(root.right);
			  while(right.left!=null)
				  right=right.left;
			  right.left=root;
			  root.right=right;
		  }
		  return root;
	  }
	  
	  public static ListNode findNthNodeToLast(ListNode head, int n){
		  if(head==null||n<1)
			  return null;
		  ListNode p1=head;
		  ListNode p2=head;
		  for(int i=0;i<n-1;i++){
			  if(p1!=null)
				  p1=p1.next;
			  else
				  return null;
		  }
		  while(p1.next!=null){
			  p1=p1.next;
			  p2=p2.next;
		  }
		  return p2;
	  }
	  
	  public static boolean deleteMiddleNode(ListNode node){
		  if(node==null||node.next==null)
			  return false;
		  ListNode next=node.next;
		  node.val=next.val;
		  node.next=next.next;
		  return true;
	  }
	  
	  public static ListNode findBeginningofCircularList(ListNode head){
		  if(head==null)
			  return null;
		  ListNode p1=head;
		  ListNode p2=head;
		  while(p2.next!=null){
			  p1=p1.next;
			  p2=p2.next.next;
			  if(p1==p2)
				  break;
		  }
		  //error check, no meeting point
		  if(p2.next==null)
			  return null;
		  
		  p1=head;
		  
		  while(p1!=p2){
			  p1=p1.next;
			  p2=p2.next;
		  }
		  return p1;
	  }
	  
	  public int search2(int[] A, int target) {
		  if(A.length==0)
			  return -1;
		  return searchUtil(A,0,A.length-1,target);
	  }
	  
	  public int searchUtil(int[] A, int beg, int end, int target){
		  if(beg>end)
			  return -1;
		  int mid=(beg+end)/2;
		  if(A[mid]==target)
			  return mid;
		  if(A[beg]<=A[mid]){
			  if(A[beg]<=target&&target<A[mid])
				  return searchUtil(A,beg,mid-1,target);
			  return searchUtil(A,mid+1,end,target);
		  }
		  else if(A[mid]<=A[end]){
			  if(A[mid]<target&&target<=A[end])
				  return searchUtil(A,mid+1,end,target);
			  return searchUtil(A,beg,mid-1,target);
		  }
		  return -1;
	  }
	  
	  
	  public static TreeNode getClosestNode(TreeNode root, int value){
		  if(root==null)
			  return null;
		  TreeNode cur=root;
		  int minDif=Integer.MAX_VALUE;
		  TreeNode res=null;
		  
		  while(cur!=null){
			  int dif=Math.abs(cur.val-value);
			  if(dif<minDif){
				  minDif=dif;
				  res=cur;
			  }
			  if(dif==0){
//				  res= cur;
				  break;
			  }
			  
			  else if(cur.val>value)
				  cur=cur.left;
			  else 
				  cur=cur.right;
				  
		  }
		  return res;
	  }
	  
	  public static int maxStolenValue(int[] A){
		  int n=A.length;
		  if(n==0)
			  return 0;
		  if(n==1)
			  return A[0];
		  if(n==2)
			  return Math.max(A[0], A[1]);
		  int[] dp=new int[n];
		  dp[0]=A[0];
		  dp[1]=A[0]>A[1]?A[0]:A[1];
		  
		  
		  for(int i=2;i<n;i++){
			  dp[i]=Math.max(A[i]+dp[i-2], dp[i-1]);
		  }
		  return dp[n-1];
	  }
	  
	  
	  public static int maxStolenValue2(int[] values){
		  int n=values.length;
		  if(n==0)
			  return 0;
		  if(n==1)
			  return values[0];
		  if(n==2)
			  return Math.max(values[0], values[1]);
		  
		  int value1=values[0];
		  int value2=Math.max(values[0], values[1]);
		  int value=0;
		  for(int i=2;i<n;i++){
			  value=Math.max(value2, value1+values[i]);
			  value1=value2;
			  value2=value;
		  }
		  return value;
	  }
	  
	 public static int minSplit(String s){
		 if(s.length()<2)
			 return 0;
		 int n=s.length();
		 int[] dp=new int[n];
		 
		 for(int i=0;i<n;i++)
			 dp[i]=i;
		 
		 for(int i=1;i<n;i++){
			 if(isPal(s.substring(0,i+1))){
				 dp[i]=0;
			 }
			 else{
				 for(int j=0;j<i;j++){
					 if(isPal(s.substring(j+1,i+1))&&dp[i]>dp[j]+1)
						 dp[i]=dp[j]+1;
				 }
			 }
		 }
		 return dp[n-1];
	 }
	 
	 public static boolean isPal(String s){
		 if(s.length()==0)
			 return true;
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
	 
	  
	 public static int minSplit2(String s){
		 if(s.length()<2)
			 return 0;
		 int n=s.length();
		 int[] dp=new int[n+1];
		 
		 boolean[][] p=new boolean[n][n];
		 for(int i=0;i<n;i++)
			 dp[i]=n-i;
		 
		 for(int i=n-1;i>=0;i--){
			 for(int j=i;j<n;j++){
				 if(s.charAt(i)==s.charAt(j)&&(j-i<2||p[i+1][j-1])){
					 p[i][j]=true;
					 dp[i]=Math.min(dp[i],dp[j+1]+1);
				 }
			 }
		 }
		 return dp[0]-1;
	 }
	  
	  public static int[] increasingIndex(int[] A){
		  int[] res={-1,-1,-1};
		  if(A.length<3)
			  return res;
		  
		  int n=A.length;
		  
		  int[] left=new int[n];
		  int[] right=new int[n];
		  
		  int min=0;
		  left[0]=0;
		  
		  for(int i=1;i<n;i++){
			  if(A[i]<A[min])
				  min=i;
			  left[i]=min;
		  }
		  
		  int max=n-1;
		  right[n-1]=max;
		  
		  for(int i=n-2;i>=0;i--){
			  if(A[i]>A[max])
				  max=i;
			  right[i]=max;
		  }
		  
		  for(int i=0;i<n;i++){
			  if(A[left[i]]<A[i]&&A[i]<A[right[i]]){
				  res[0]=left[i];
				  res[1]=i;
				  res[2]=right[i];
				  System.out.println(res[0]+" "+res[1]+" "+res[2]);
//				  break;
			  }
		  }
		  return res;
	  }
	  
	  public int longestValidParentheses(String s) {
	        // Note: The Solution object is instantiated only once and is reused by each test case.
	        int n=s.length();
	        if(n<2)
	        	return 0;
	        int[] dp=new int[n];
	        
	        dp[n-1]=0;
	        
	        int max=0;
	        for(int i=n-2;i>=0;i--){
	        	if(s.charAt(i)=='('){
	        		int j=i+1+dp[i+1];
	        		if(j<n&&s.charAt(j)==')'){
	        			dp[i]=dp[i+1]+2;
	        			if(j+1<n)
	        				dp[i]+=dp[j+1];
	        		}
	        	}
	        	max=Math.max(max, dp[i]);
	        	
	        }
	        return max;
	    }
	  
	  
	  public int longestValidParentheses2(String s) {
		  int n=s.length();
		  if(n<2)
			  return 0;
		  Stack<Integer> stk=new Stack<Integer>();
		  
		  int maxLen=0;
		  int last=-1;
		  for(int i=0;i<n;i++){
			  if(s.charAt(i)=='(')
				  stk.push(i);
			  else{
				  if(stk.isEmpty())
					  last=i;
				  else{
					  stk.pop();
					  if(stk.isEmpty()){
						  maxLen=Math.max(maxLen, i-last);
					  }
					  else{
						  maxLen=Math.max(maxLen, i-stk.peek());
					  }
				  }
			  }
		  }
		  return maxLen;
	  }
	  
	  
	  public static ArrayList<ArrayList<Integer>> triangle(int n){
		  ArrayList<ArrayList<Integer>> res=new  ArrayList<ArrayList<Integer>>();
		  if(n<=0)
			  return res;
		  
		  int[][] dp=new int[n][n];
		  
		  for(int i=0;i<n;i++){
			  dp[i][0]=i+1;
		  }
		  
		  for(int i=1;i<n;i++){
			  for(int j=1;j<=i;j++){
				  if(j==i)
					  dp[i][j]=i+1;
				  else{
					  dp[i][j]=dp[i-1][j]+dp[i-1][j-1];
				  }
			  }
		  }
		  
		  for(int i=0;i<n;i++){
			  ArrayList<Integer> sol=new ArrayList<Integer>();
			  for(int j=0;j<=i;j++){
				  sol.add(dp[i][j]);
			  }
			  res.add(sol);
		  }
		  return res;
				  
	  }
	  
	  
	  public static String reverseSentence(String s){
		  if(s.length()==0)
			  return s;
		  
		  String res="";
		  int start=0;
		  boolean dig=false;

		  for(int i=0;i<s.length();i++){
			  char c=s.charAt(i);
			  if(Character.isDigit(c)){
//				  start=i+1;
				  dig=true;
				  continue;
			  }
			  else if(c==' '||c==','||c=='.'){
				  if(dig){
					  int j=i;
					  char x=s.charAt(j-1);
					  while(Character.isDigit(x)){
						  j--;
						  x=s.charAt(j);
					  }
					 
					  if(!Character.isLetter(x)){
						  res=res+s.substring(start,i)+c;
						  dig=false;
					  }
					  else
						  res=res+reverseString(s.substring(start,i))+c;
				  }
				  else
					  res=res+reverseString(s.substring(start,i))+c;
				  start=i+1;
			  }
		  }

		  return res;
	  }
	  
	  public static String reverseString(String s){
		  int i=0;
		  int j=s.length()-1;
		  char[] ch=s.toCharArray();
		  
		  while(i<j){
			  char c=ch[i];
			  ch[i]=ch[j];
			  ch[j]=c;
			  i++;
			  j--;
		  }
		  return new String(ch);
	  }
	  
	  
	  
	  public ListNode swapPairs(ListNode head) {
	        // Note: The Solution object is instantiated only once and is reused by each test case.
	        if(head==null)
	        	return null;
	        ListNode dummy=new ListNode(0);
	        dummy.next=head;
	        ListNode Ppre=dummy;
	        ListNode pre=head;
	        ListNode cur=head.next;
	        while(cur!=null){
	        	ListNode next=cur.next;
	        	cur.next=pre;
	        	Ppre.next=cur;
	        	pre.next=next;
	        	
	        	cur=next;
	        	if(cur!=null){
	        		Ppre=pre;
	        		pre=cur;
	        		cur=cur.next;
	        	}
	        }
	        
	        return dummy.next;
	    }
	  
	  public static boolean isFibonacci(int n){
		  if(n<0)
			  return false;
		  return isPerfactSquare(5*n*n+4)||
				  isPerfactSquare(5*n*n-4);
	  }
	  
	  public static boolean isPerfactSquare(int n){
		  int x=(int) Math.sqrt(n);
		  return n==x*x;
	  }
	  
	  
	  public int minDistance(String word1, String word2) {
	        // Note: The Solution object is instantiated only once and is reused by each test case.
	       int n1=word1.length();
	       int n2=word2.length();
	       
	       int[][] dp=new int[n1+1][n2+1];
	       dp[0][0]=0;
	       
	       for(int i=1;i<=n1;i++)
	    	   dp[i][0]=i;
	       
	       for(int i=1;i<=n2;i++)
	    	   dp[0][i]=i;
	       
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
	  
	  public String getPermutation(int n, int k) {
	        // Start typing your Java solution below
	        // DO NOT write main() function
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
		  if(index==-1)
			  return;
		  
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
	  
	  public int reverse(int x) {
	        // Note: The Solution object is instantiated only once and is reused by each test case.
	        boolean neg=false;
	        boolean overflow=false;
	        
	        if(x<0){
	        	neg=true;
	        	x=-x;
	        }
	        int res=0;
	        while(x>0){
	        	int lastdig=x%10;
	        	if((Integer.MAX_VALUE-lastdig)/10>=res)
	        		res=res*10+lastdig;
	        	else{
	        		overflow=true;
	        		break;
	        	}
	        	x/=10;
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
	  
	  public int lengthOfLastWord(String s) {
	        // Note: The Solution object is instantiated only once and is reused by each test case.
	        s=s.trim();
	        if(s.length()==0)
	        	return 0;
	        int i=s.length()-1;
	        
	        int count=0;
	        while(i>=0&&s.charAt(i)!=' '){
	        	count++;
	        	i--;
	        }
	        return count;
	    }
	  
	  public static void selectKItems(int[] stream, int k){
		  int[] reservoir=new int[k];
		  
		  int i;
		  for(i=0;i<k;i++)
			  reservoir[i]=stream[i];
		  
		  for(;i<stream.length;i++){
			  int j=(int) (Math.random()*(i+1));
			  if(j<k)
				  reservoir[j]=stream[i];
		  }
		  
		  for(int j=0;j<k;j++)
			  System.out.print(reservoir[j]+" ");
		  
	  }
	  
	  
	  public int jump(int[] A) {
	        // Note: The Solution object is instantiated only once and is reused by each test case.
	        if(A.length<2)
	        	return 0;
	        int max=A[0];
	        int steps=0;
	        int min=1;
	        
	        while(max<A.length-1){
	        	int m=max;
	        	int nextStart=min;
	        	for(int i=min;i<=max;i++){
	        		if(A[i]+i>m){
	        			m=A[i]+i;
	        			nextStart=i;
	        		}
	        	}
	        	min=nextStart;
	        	max=m;
	        	steps++;
	        }
	        return steps+1;
	    }
	  
	  public int jump2(int[] A){
		  if(A.length<2)
			  return 0;
		  int max=0;
		  int curPos=0;
		  int steps=0;
		  
		  for(int i=0;i<A.length-1;){
			  if(curPos>=A.length-1)
				  break;
			  while(i<=curPos){
				  max=Math.max(max, A[i]+i);
				  i++;
			  }
			  curPos=max;
			  steps++;			  
		  }
		  return steps;
		  
	  }
	  
	  public ArrayList<Integer> grayCode(int n) {
	        // Note: The Solution object is instantiated only once and is reused by each test case.
		  ArrayList<Integer> res=new ArrayList<Integer>();
		  if(n<0)
			  return res;
		  if(n==0){
			  res.add(0);
		  }
		  else{
			  ArrayList<Integer> sol=grayCode(n-1);
			  res.addAll(sol);
			  
			  for(int i=sol.size()-1;i>=0;i--)
				  res.add(sol.get(i)+(int)(Math.pow(2, n-1)));
		  }
		  return res;
	    }
	  
	  
	  public int[][] generateMatrix(int n) {
	        // Note: The Solution object is instantiated only once and is reused by each test case.
	        int[][] matrix=new int[n][n];
	        int upbound=0;
	        int lowerbound=n-1;
	        int leftbound=0;
	        int rightbound=n-1;
	        
	        int num=1;
	       while(leftbound<=rightbound&&upbound<=lowerbound){
	        	for(int i=leftbound;i<=rightbound;i++)
	        		matrix[upbound][i]=num++;
	        	upbound++;
	        	for(int i=upbound;i<=lowerbound;i++)
	        		matrix[i][rightbound]=num++;
	        	rightbound--;
	        	
	        	for(int i=rightbound;i>=leftbound;i--)
	        		matrix[lowerbound][i]=num++;
	        	lowerbound--;
	        	
	        	for(int i=lowerbound;i>=upbound;i--)
	        		matrix[i][leftbound]=num++;
	        	leftbound++;
	        }
	       return matrix;
	    	   
	    }
	  
//	  如果当前字符相同，那有两种可能，用到和不用到这个字符，所以这两种情况加起来。
//	  如果不同，那只能等于用不了这个字符的情况。
	  public int numDistinct(String S, String T) {
	        // Note: The Solution object is instantiated only once and is reused by each test case.
	       int l1=S.length();
	       int l2=T.length();
		  int[][] dp=new int[l1+1][l2+1];
		  dp[0][0]=1;
		  for(int i=1;i<=l1;i++)
			  dp[i][0]=1;
		  
		  for(int i=1;i<=l2;i++)
			  dp[0][i]=0;
		  
		  for(int i=1;i<=l1;i++){
			  for(int j=1;j<=l2;j++){
				  if(S.charAt(i-1)==T.charAt(j-1))
					  dp[i][j]=dp[i-1][j-1]+dp[i-1][j];
				  else
					  dp[i][j]=dp[i-1][j];
			  }
		  }
		  
		  return dp[l1][l2];
	    }
	  
	  public String longestPalindrome(String s) {
	        // Note: The Solution object is instantiated only once and is reused by each test case.
	        if(s.length()<2)
	        	return s;
	        int i=1;
	        int maxlen=1;
	        int beg1=0;
	        int end1 = 0;
	        int beg2 = 0;
	        int end2 = 0;
	        while(i<s.length()){
	        	int j=i-1;
	        	int k=i+1;
	        	while(j>=0&&k<s.length()&&s.charAt(j)==s.charAt(k)){
	        		if(k-j+1>maxlen){
	        			maxlen=k-j+1;
	        			beg1=j;
	        			end1=k;
	        		}
	        		j--;
	        		k++;
	        	}
	        	
	        	j=i-1;
	        	k=i;
	        	while(j>=0&&k<s.length()&&s.charAt(j)==s.charAt(k)){
	        		if(k-j+1>maxlen){
	        			maxlen=k-j+1;
	        			beg2=j;
	        			end2=k;
	        		}
	        		j--;
	        		k++;
	        	}
	        	i++;
	        }
	        
	        if(end2-beg2>end1-beg1)
	        	return s.substring(beg2,end2+1);
	        else
	        	return s.substring(beg1,end1+1);
	    }
	  
	  public int firstMissingPositive3(int[] A) {
	        // Note: The Solution object is instantiated only once and is reused by each test case.
//	          int n=A.length;
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
	  
	  public static String multiply(String num1, String num2) {
	        // Note: The Solution object is instantiated only once and is reused by each test case.
	        int n1=num1.length();
	        int n2=num2.length();
	        
	        int[] res=new int[n1+n2];
	        
	        for(int i=n1-1;i>=0;i--){
	        	int carry=0;
	        	int dig1=num1.charAt(i)-'0';
	        	for(int j=n2-1;j>=0;j--){
	        		int dig2=num2.charAt(j)-'0';
	        		int prod=dig1*dig2+carry+res[i+j+1];
	        		carry=prod/10;
	        		prod=prod%10;
	        		res[i+j+1]=prod;
	        	}
	        	res[i]=carry;
	        }

	        String ans="";
	        int i=0;
	        while(i<res.length-1&&res[i]==0)
	        	i++;
	        while(i<n1+n2){
	        	ans+=res[i];
	        	i++;
	        }
	     return ans;
	    }
	  
	  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
	        // Note: The Solution object is instantiated only once and is reused by each test case.
	        if(l1==null||l2==null)
	        	return l1==null?l2:l1;
	        
	        ListNode dummy=new ListNode(0);
	        ListNode p=l1;
	        ListNode q=l2;
	        ListNode pre=dummy;
	        while(p!=null&&q!=null){
	        	if(p.val<q.val){
	        		pre.next=p;
	        		p=p.next;
	        	}
	        	else{
	        		pre.next=q;
	        		q=q.next;
	        	}
	        	pre=pre.next;
	        		
	        }
	        if(p!=null)
	        	pre.next=p;
	        if(q!=null)
	        	pre.next=q;
	        return dummy.next;
	    }
	  
	  public int removeElement(int[] A, int elem) {
	        // Note: The Solution object is instantiated only once and is reused by each test case.
	        if(A.length==0)
	        	return 0;
	        
	        int i=0;
	        int j=0;
	        
	        for(i=0;i<A.length;i++){
	        	if(A[i]!=elem){
	        		A[j]=A[i];
	        		j++;
	        	}
	        }
	        return j;
	    }
	
	  
	  public ListNode reverseBetween(ListNode head, int m, int n) {
	        // Note: The Solution object is instantiated only once and is reused by each test case.
	        if(head==null)
	        	return null;
	        ListNode cur=head;
	        ListNode ppre=null;
	        for(int i=0;i<m-1;i++){
	        	ppre=cur;
	        	cur=cur.next;
	        }
	        ListNode start=cur;
	        ListNode pre=cur;
	        cur=cur.next;
	        for(int i=0;i<n-m;i++){
	        	ListNode pnext=cur.next;
	        	cur.next=pre;
	        	pre=cur;
	        	cur=pnext;	        	
	        }
	        start.next=cur;
	        
	        if(ppre!=null)
	        	ppre.next=pre;
	        else
	        	return pre;
	        return head;
	    }
	  
	  public int searchInsert(int[] A, int target) {
	        // Note: The Solution object is instantiated only once and is reused by each test case.
//	        if(A.length==0)
//	        	return 0;
	        int beg=0;
	        int end=A.length-1;
	        while(beg<=end){
	        	int mid=(beg+end)/2;
	        	if(A[mid]==target)
	        		return mid;
	        	else if(A[mid]>target)
	        		end=mid-1;
	        	else
	        		beg=mid+1;
	        }
	        return  beg;
	    }
	  
	  public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
	        // Note: The Solution object is instantiated only once and is reused by each test case.
		  ArrayList<ArrayList<Integer>> res=new ArrayList<ArrayList<Integer>>();
		  if(root==null)
			  return res;
		  ArrayList<Integer> sol=new ArrayList<Integer>();
		  Queue<TreeNode> que=new LinkedList<TreeNode>();
		  int curLevel=0;
		  int nextLevel=0;
		  que.add(root);
		  curLevel++;
		  while(!que.isEmpty()){
			  TreeNode top=que.poll();
			  sol.add(top.val);
			  curLevel--;
			  if(top.left!=null){
				  que.add(top.left);
				  nextLevel++;
			  }
			  if(top.right!=null){
				  que.add(top.right);
				  nextLevel++;
			  }
			  
			  if(curLevel==0){
				  res.add(sol);
				  sol=new ArrayList<Integer>();
				  curLevel=nextLevel;
				  nextLevel=0;
			  }
		  }
		  Collections.reverse(res);
//		  ArrayList<ArrayList<Integer>> ans=new ArrayList<ArrayList<Integer>>();
//		  for(int i=res.size()-1;i>=0;i--)
//			  ans.add(res.get(i));
		  return res;
	    }
	  
	  public void merge(int A[], int m, int B[], int n) {
	        // Note: The Solution object is instantiated only once and is reused by each test case.
	        int i=m-1;
	        int j=n-1;
	        int k=m+n-1;
	        while(i>=0&&j>=0){
	        	if(A[i]>B[j]){
	        		A[k--]=A[i--];
	        	}
	        	else{
	        		A[k--]=B[j--];
	        	}
	        }
	        while(j>=0)
	        	A[k--]=B[j--];
	    }
	  
	  
	  public int numTrees(int n) {
	        // Note: The Solution object is instantiated only once and is reused by each test case.
	        if(n<=1)
	        	return 1;
	        
	        int sum=0;
	        for(int i=1;i<=n;i++){
	        	sum+=numTrees(i-1)*numTrees(n-i);
	        }
	        return sum;
	    }
	  
	  public int minPathSum(int[][] grid) {
	        // Note: The Solution object is instantiated only once and is reused by each test case.
	        int m=grid.length;
	        if(m==0)
	        	return 0;
	        int n=grid[0].length;
	        
	        int[][] dp=new int[m][n];
	        dp[0][0]=grid[0][0];
	        
	        for(int i=1;i<m;i++)
	        	dp[i][0]=dp[i-1][0]+grid[i][0];
	        for(int i=1;i<n;i++)
	        	dp[0][i]=grid[0][i]+dp[0][i-1];
	        
	        for(int i=1;i<m;i++){
	        	for(int j=1;j<n;j++){
	        		dp[i][j]=Math.min(dp[i-1][j], dp[i][j-1]);
	        	}
	        }
	        return dp[m-1][n-1];
	    }
	  
	  
	  public boolean isPalindrome2(String s) {
	        // Note: The Solution object is instantiated only once and is reused by each test case.
	        if(s.length()==0)
	        	return true;
	        s=s.toLowerCase();
	        
	        int beg=0;
	        int end=s.length()-1;
	        
	        while(beg<=end){
//	        	char c=s.charAt(beg);
	        	while(beg<end&&!Character.isLetterOrDigit(s.charAt(beg)))
	        		beg++;
	        	while(end>beg&&!Character.isLetterOrDigit(s.charAt(end)))
	        		end--;
	        	if(beg<end&&s.charAt(beg)!=s.charAt(end))
	        		return false;
	        	beg++;
	        	end--;
	        }
	        return  true;
	        
	    }
	  
	
	  
	  public boolean isValid(String s) {
	        // Note: The Solution object is instantiated only once and is reused by each test case.
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
	  
	  public int canCompleteCircuit(int[] a, int[] g) {
		  int n=a.length;
		  int sum=0;
		  int total=0;
		  int index=-1;
		  for(int i=0;i<n;i++){
			  sum+=a[i]-g[i];
			  total+=a[i]-g[i];
			  if(sum<0){
				  index=i;
				  sum=0;
			  }
		  }
		  return  total>=0?index+1:-1;
			  
	  }
	 
	  
	  public ListNode deleteDuplicates3(ListNode head) {
	        // Note: The Solution object is instantiated only once and is reused by each test case.
	        if(head==null)
	        	return null;
	        
	        ListNode dummy=new ListNode(0);
	        dummy.next=head;
	        ListNode pre=dummy;
	        ListNode cur=head;
	        while(cur!=null){
	        	boolean dup=false;
	        	while(cur.next!=null&&cur.val==cur.next.val){
	        		dup=true;
	        		cur=cur.next;
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
	  
	  
	  public int longestConsecutive(int[] num) {
	        // Note: The Solution object is instantiated only once and is reused by each test case.
		  if(num.length<2)
			  return num.length;
		  HashSet<Integer> set=new HashSet<Integer>();
		  for(int i:num)
			  set.add(i);
		  
		  int res=1;
		  for(int i=0;i<num.length;i++){
			  if(set.contains(num[i])){
				  res=Math.max(res, getCount(set,num[i],false)+getCount(set,num[i]+1,true));
			  }
		  }
		  return res;
	    }
	  
	  public int getCount(HashSet<Integer> set, int num, boolean asc){
		  int count=0;
		  while(set.contains(num)){
			  set.remove(num);
			  count++;
			  if(asc)
				  num++;
			  else
				  num--;
		  }
		  return count;
	  }
	  
	  public static ArrayList<Integer> findSubstring(String S, String[] L) {
	        // Note: The Solution object is instantiated only once and is reused by each test case.
		  ArrayList<Integer> res = new ArrayList<Integer>();
			int num = L.length;
			int len = L[0].length();
			if (S.length() < num * len)
				return res;
			
			HashMap<String, Integer> map=new HashMap<String, Integer>();
			for(String s:L){
				if(map.containsKey(s))
					map.put(s, map.get(s)+1);
				else
					map.put(s, 1);
			}
			
			HashMap<String, Integer> found=new HashMap<String, Integer>();
			
			for(int i=0;i<S.length()-num*len+1;i++){
				found.clear();
				int j=0;
				for(j=0;j<num;j++){
					String s=S.substring(i+j*len,i+j*len+len);
					if(!map.containsKey(s))
						break;
					if(!found.containsKey(s))
						found.put(s, 1);
					else
						found.put(s, found.get(s)+1);
					if(found.get(s)>map.get(s))
						break;
				}
				if(j==num)
					res.add(i);
			}
			return res;
	    }
	  
	  public int atoi(String str) {
	        // Note: The Solution object is instantiated only once and is reused by each test case.
	       if(str.length()==0)
	    	   return 0;
		  str=str.trim();
	        int res=0;
	        boolean neg=false;
	        boolean overflow=false;
	        int i=0;
	        if(str.charAt(0)=='-'){
	        	neg=true;
	        	i++;
	        }
	        if(str.charAt(0)=='+')
	        	i++;
	        while(i<str.length()){
	        	int t=str.charAt(i)-'0';
	        	if(t>=0&&t<=9){
	        		if((Integer.MAX_VALUE-t)/10>=res)
	        			res=res*10+t;
	        		else{
	        			overflow=true;
	        			break;
	        		}
	        	}
	        	else
	        		break;
	        	i++;
	        }
	        if(neg){
	        	if(overflow)
	        		return Integer.MIN_VALUE;
	        	else
	        		return -res;
	        }
	        else{
	        	if(overflow)
	        		return Integer.MAX_VALUE;
	        	else
	        		return res;
	        }
	        
	    }
	  
	  public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
	        // Note: The Solution object is instantiated only once and is reused by each test case.
		  ArrayList<ArrayList<Integer>> res=new ArrayList<ArrayList<Integer>>();
		  if(num.length==0)
			  return res;
		  ArrayList<Integer> sol=new ArrayList<Integer>();
		  Arrays.sort(num);
		  
		  boolean[] used=new boolean[num.length];
		  
		  combinationSum2Util(0,num,used,0,target,sol,res);
		  return res;
		  
	    }
	  
	  public void combinationSum2Util(int dep, int[] num, boolean[] used, int cursum,int target, 
			  ArrayList<Integer> sol,ArrayList<ArrayList<Integer>> res ){
		  if(cursum>target||dep==num.length)
			  return;
		  if(cursum==target){
			  ArrayList<Integer> out=new ArrayList<Integer>(sol);
			  res.add(out);
		  }
		  for(int i=dep;i<num.length;i++){
			  if(!used[i]){
				  if(i!=0&&num[i]==num[i-1]&&!used[i-1])
					  continue;
				  else{
					  used[i]=true;
					  cursum+=num[i];
					  sol.add(num[i]);
					  combinationSum2Util(i,num,used,cursum,target,sol,res);
					  used[i]=false;
					  cursum-=num[i];
					  sol.remove(sol.size() - 1);
				  }
			  }
		  }
	  }
	  
	  
	  public static int removeDuplicates(char[] str){
		  if(str.length<2)
			  return str.length;
		  
		  int tail=1;
		  for(int i=1;i<str.length;i++){
			  int j=0;
			  
			  for(j=0;j<tail;j++){
				  if(str[i]==str[j])
					  break;
			  }
			  if(j==tail){
				  str[tail++]=str[i];
			  }
		  }
		  return tail;
	  }
	  
	  public String longestCommonPrefix(String[] strs) {
	        // Note: The Solution object is instantiated only once and is reused by each test case.
	        if(strs.length==0)
	        	return "";
	        
	        int len=strs[0].length();
	        String pre=strs[0];
	        for(int i=1;i<strs.length;i++){
	        	if(strs[i].length()<len){
	        		len=strs[i].length();
	        		pre=strs[i];
	        	}
	        }
	        
	        for(int i=0;i<len;i++){
	        	for(int j=0;j<strs.length;j++){
	        		if(pre.charAt(i)!=strs[j].charAt(i))
	        			return pre.substring(0,i);
	        	}
	        	
	        }
	        return pre;
	        
	    }
	  
	  public static TreeNode converToDLListUtil(TreeNode root){
		  if(root==null)
			  return null;
		  if(root.left!=null){
			  TreeNode left=convert2DLL(root.left);
			  while(left!=null&&left.right!=null)
				  left=left.right;
			  left.right=root;
			  root.left=left;
		  }
		  
		  if(root.right!=null){
			  TreeNode right=convert2DLL(root.right);
			  while(right!=null&&right.left!=null)
				  right=right.left;
			  right.left=root;
			  root.right=right;
		  }
		  
		  return root;	  
		  
		  
	  }
	  
private static TreeNode convert2DLL(TreeNode root) {
		// TODO Auto-generated method stub
	 if(root==null)
		  return null;
	 
	 TreeNode head=converToDLListUtil(root);
	  while(head.left!=null){
		  head=head.left;
	  }
	  return head;
	}


	  
	  public static String compress(String s){
		  if(s.length()<2)
			  return s;
		  
		  String res="";
		  char c=s.charAt(0);
		  int count=1;
		  for(int i=1;i<s.length();i++){
			  if(s.charAt(i)!=c){
				  if(count>1){
					  res=res+c+count;
				  }
				  else
					  res=res+c;
				  c=s.charAt(i);
				  count=1;
			  }
			  else
				  count++;
		  }
		  if(count>1)
			  res=res+c+count;
		  else
			  res=res+c;
		  return  res;
	  }
	  
	  public static String uncompress(String s){
		  if(s.length()<2)
			  return s;
		  String res="";
		  char c=s.charAt(0);
		  res=""+c;
		  for(int i=1;i<s.length();){			  
			  if(Character.isLetter(s.charAt(i))){
				  res=res+s.charAt(i);
				  c=s.charAt(i);
				  i++;
			  }
			  else{
				  int start=i;
				  while(i<s.length()&&Character.isDigit(s.charAt(i)))
					  i++;
				  int count=Integer.parseInt(s.substring(start,i));
				  for(int j=0;j<count-1;j++){
					  res=res+c;
				  }
			  }
		  }
		  return res;
	  }
	  
	  public static int NIterationArray(int[] A, int n){
		  if(A.length<=n)
			  return 0;
//		  int[] res=new int[A.length-n];
		  
		  for(int i=0;i<n;i++){
			  for(int j=0;j<A.length-1-i;j++){
				  A[j]=A[j+1]-A[j];
			  }
		  }
		  
		  int sum=0;
		  for(int i=0;i<A.length-n;i++)
			  sum+=A[i];
		  return sum;
	  }
	  
	  
	  public static ArrayList<String> permutations(String s){
		  ArrayList<String> res=new ArrayList<String>();
		  if(s.length()==0)
			  return res;
		  boolean[] used=new boolean[s.length()];
		  permutationsUtil(0,s,"",used,res);
		  return res;
	  }
	  
	  public static void permutationsUtil(int dep, String s, String sol,boolean[] used, ArrayList<String> res){
		  if(dep==s.length()){
			  res.add(sol);
		  }
		  
		  for(int i=0;i<s.length();i++){
			  if(!used[i]){
				  used[i]=true;
				  sol+=s.charAt(i);
				  permutationsUtil(dep+1,s,sol,used,res);
				  sol=sol.substring(0,sol.length()-1);
				  used[i]=false;
			  }			 
//			  
		  }
	  }
	  
	  public static void findDupOccandidx(int[] A){
		  if(A.length<2)
			  return;
		  
		  HashMap<Integer, ArrayList<Integer>> map=new HashMap<Integer, ArrayList<Integer>>();
		  for(int i=0;i<A.length;i++){
			  if(map.containsKey(A[i])){
				  map.get(A[i]).add(i);
			  }
			  else{
				  ArrayList<Integer> lst=new ArrayList<Integer>();
				  lst.add(i);
				  map.put(A[i],lst);
			  }
		  }
		  Iterator<Integer> it=map.keySet().iterator();
		  while(it.hasNext()){
			  int num=it.next();
			  if(map.get(num).size()>1)
				  System.out.println(num+" "+" "+map.get(num).size()+" "+map.get(num));
		  }
	  }
	  
	  
	  public static String countAndSay(int n) {
	        // Note: The Solution object is instantiated only once and is reused by each test case.	        
	        String s="1";        
	        
	        for(int i=1;i<n;i++){
	        	char c=s.charAt(0);
	        	int count=1;
	        	String str="";
	        	for(int j=1;j<s.length();j++){
	        		if(s.charAt(j)!=c){
	        			str=str+count+c;
	        			count=1;
	        			c=s.charAt(j);
	        		}
	        		else
	        			count++;
	        	}
	        	s=str+count+c;
	        }
	        return s;
	    }
	  
	  public static ArrayList<String> letterCombinations(String digits) {
	        // Note: The Solution object is instantiated only once and is reused by each test case.
		  ArrayList<String> res=new ArrayList<String>();
		  letterCombinationsUtil(0,digits,"",res);
		  return res;
	    }
	  
	  public static void letterCombinationsUtil(int cur, String digits, String sol, ArrayList<String> res){
		  if(cur==digits.length()){
			  res.add(sol);
			  return;
		  }
		  
		  String str=getString(digits.charAt(cur)-'0');
		  for(int i=0;i<str.length();i++){
			  letterCombinationsUtil(cur+1,digits,sol+str.charAt(i),res);
		  }
	  }
	  
	  public static String getString(int i){
		  String[] strs={"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs",
					"tuv", "wxyz" };
		  return strs[i];
	  }
	  
	  public static int maxDiff(int[] A){
		  if(A.length<2)
			  return 0;
		  int maxDiff=A[1]-A[0];
		  int min=A[0];
		  
		  for(int i=1;i<A.length;i++){
			  if(A[i]-min>maxDiff)
				  maxDiff=A[i]-min;
			  if(A[i]<min)
				  min=A[i];
		  }
		  return maxDiff;
	  }
	  
	  public static TreeNode LCAncestor(TreeNode root,TreeNode p, TreeNode q){
		  if(root==null)
			  return null;
		  if(covers(root.left,p)&&covers(root.left,q))
			  return LCAncestor(root.left,p,q);
		  else if(covers(root.right,p)&&covers(root.right,q))
			  return LCAncestor(root.right,p,q);
		  else
			  return root;
	  }
	  
	  public static boolean covers(TreeNode root, TreeNode p){
		  if(root==null)
			  return false;
		  if(root==p)
			  return true;
		  return covers(root.left,p)||covers(root.right,p);
	  }
	  
	  
	  public static void partitionArrayto3Parts(int[] A, int target){
		  if(A.length<2)
			  return;
		  
		  int j=A.length-1;
		  int k=A.length-1;
		  int i=0;
		  while(i<=j){
			  if(A[i]>target){
				  int t=A[i];
				  A[i]=A[k];
				  A[k]=t;
				  k--;
				  if(j>k)
					  j=k;
			  }
			  else if(A[i]==target){
				  int t=A[i];
				  A[i]=A[j];
				  A[j]=t;
				  j--;
			  }
			  else
				  i++;
		  }
		  
		  for(int m=0;m<A.length;m++)
			  System.out.print(A[m]+" ");
	  }
	  
	  
	  public static void getMedianofStream(int[] stream){
		  PriorityQueue<Integer> minHeap=new PriorityQueue<Integer>();
		  PriorityQueue<Integer> maxHeap=new PriorityQueue<Integer>(10,Collections.reverseOrder());
		  double m=0;
		  for(int i=0;i<stream.length;i++){
			 double median= getMedianofStreamUtil(stream[i],minHeap, maxHeap);
			 System.out.println(median);
			 m=median;
		  }
		  
	  }
	  
	  public static double getMedianofStreamUtil(int num,PriorityQueue<Integer> minHeap, PriorityQueue<Integer>maxHeap){
		  if(maxHeap.size()==minHeap.size()){
			  if(minHeap.peek()!=null&&num>minHeap.peek()){
				  maxHeap.add(minHeap.poll());
				  minHeap.add(num);
			  }
			  else{
				  maxHeap.add(num);
			  }
		  }
		  else{
			  if(num<maxHeap.peek()){
				  minHeap.add(maxHeap.poll());
				  maxHeap.add(num);
			  }
			  else
				  minHeap.add(num);
		  }
		  
		  if(maxHeap.size()==0)
			  return minHeap.peek();
		  else if(minHeap.size()==0)
			  return maxHeap.peek();
		  
		  if(maxHeap.size()==minHeap.size())
			  return (maxHeap.peek()+minHeap.peek())/2.0;
		  else if(maxHeap.size()>minHeap.size())
			  return maxHeap.peek();
		  else
			  return minHeap.peek();
	  }
	  
	  public String strStr(String haystack, String needle) {
	        // Note: The Solution object is instantiated only once and is reused by each test case.
	        if(needle.length()==0)
	        	return haystack;
		  if(haystack.length()<needle.length())
	        	return null;
	        int len=needle.length();
	        
	        for(int i=0;i<haystack.length()-len+1;i++){
	        	if(haystack.substring(i,i+len).equals(needle))
	        		return haystack.substring(i);
	        }
	        return null;
	    }
	  
	  public static ArrayList<Integer> spiralOrder(int[][] matrix) {
	        // Note: The Solution object is instantiated only once and is reused by each test case.
		  ArrayList<Integer> res=new ArrayList<Integer>();
		  int m=matrix.length;
		  if(m==0)
			  return res;
		  int n=matrix[0].length;
		  int upbound=0;
		  int bottombound=m-1;
		  int leftbound=0;
		  int rightbound=n-1;
		  
		  while(upbound<bottombound&&leftbound<rightbound){
			  for(int i=leftbound;i<=rightbound;i++)
				  res.add(matrix[upbound][i]);
			  upbound++;
			  
			  for(int i=upbound;i<=bottombound;i++)
				  res.add(matrix[i][rightbound]);
			  rightbound--;
			  for(int i=rightbound;i>=leftbound;i--)
				  res.add(matrix[bottombound][i]);
			  bottombound--;
			  
			  for(int i=bottombound;i>=upbound;i--)
				  res.add(matrix[i][leftbound]);
			  leftbound++;
		  }
		  
		  if(leftbound<rightbound&&upbound==bottombound){
			  for(int i=leftbound;i<=rightbound;i++)
				  res.add(matrix[upbound][i]);
		  }
		  
		  if(leftbound==rightbound&&upbound<bottombound){
			  for(int i=upbound;i<=bottombound;i++)
				  res.add(matrix[i][leftbound]);
		  }
		  
		  if(leftbound==rightbound&&upbound==bottombound)
			  res.add(matrix[leftbound][upbound]);
		  return res;
	    }
	  
	  
	  public static String minWindow(String S, String T) {
	        // Note: The Solution object is instantiated only once and is reused by each test case.
	        if(S.length()==0)
	        	return "";
	        int[] needfind=new int[256];
	        
	        for(int i=0;i<T.length();i++)
	        	needfind[T.charAt(i)]++;
	        
	        int[] hasfound=new int[256];
	        
	        int count=T.length();
	        int windowstart=0;
	        int windowend=0;
	        int minLength=S.length()+1;
	        int start=0;
	        
	        for(int i=0;i<S.length();i++){
	        	char c=S.charAt(i);
	        	if(needfind[c]==0)
	        		continue;
	        	hasfound[c]++;
	        	if(hasfound[c]<=needfind[c])
	        		count--;
	        	
	        	if(count==0){
	        		while(needfind[S.charAt(start)]==0||needfind[S.charAt(start)]<hasfound[S.charAt(start)]){
	        			if(hasfound[S.charAt(start)]>needfind[S.charAt(start)])
	        				hasfound[S.charAt(start)]--;
	        			start++;
	        		}
	        		
	        		if(i-start+1<minLength){
	        			minLength=i-start+1;
	        			windowstart=start;
	        			windowend=i;
	        		}
	        	}
	        }
	        
	        if(count==0)
	        	return S.substring(windowstart,windowend+1);
	        else
	        	return "";
	        	
	    }

	  public static ListNode  removeNode(ListNode head, int val){
		  if(head==null)
			  return null;
		  ListNode dummy=new ListNode(0);
		  dummy.next=head;
		  
		  ListNode cur=head;
		  ListNode pre=dummy;
		  while(cur!=null){
			  if(cur.val!=val){
				  pre=cur;
				  cur=cur.next;
			  }
			  else{
				  pre.next=cur.next;
				  cur=cur.next;
			  }
		  }
		  return dummy.next;
	  }
	  
	  
	  public int[] searchRange(int[] A, int target) {
	        // Note: The Solution object is instantiated only once and is reused by each test case.
	        int[] res={-1,-1};
	        if(A.length==0)
	        	return res;
	        
	        int beg=0;
	        int end=A.length-1;
	        int index=-1;
	        while(beg<=end){
	        	int mid=(beg+end)/2;
	        	if(A[mid]==target){
	        		index=mid;
	        		break;
	        	}
	        	else if(A[mid]<target)
	        		beg=mid+1;
	        	else
	        		end=mid-1;	        	
	        }
	        
	        if(index==-1)
	        	return res;
	        beg=0;
	        end=index;
	        
	        while(beg<=end){
	        	int mid=(beg+end)/2;
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
	        
	        return res;
	    }
	  
	  public static int lengthOfLongestSubstring(String s) {
	        // Note: The Solution object is instantiated only once and is reused by each test case.
	        if(s.length()<2)
	        	return s.length();
	        int start=0;
	        int longest=1;
	        int length=0;
	        HashMap<Character,Integer> map=new HashMap<Character, Integer>();
	        
	        for(int i=0;i<s.length();i++){
	        	char c=s.charAt(i);
	        	if(!map.containsKey(c))
	        		map.put(c, i);
	        	else{
	        		length=i-start;
	        		longest=Math.max(longest, length);
	        		int dup=map.get(c);
	        		for(int j=dup;j>=start;j--){
	        			map.remove(s.charAt(j));
	        		}
	        		map.put(c, i);
	        		start=dup+1;
	        	}
	        }
	        
	        return s.length()-start>longest?s.length()-start:longest;
	    }
	  
	  
	  	public static ListNode sortList(ListNode head){
	  		if(head==null||head.next==null)
	  			return head;
	  		ListNode p=head;
	  		ListNode q=head;
	  		while(q.next!=null&&q.next.next!=null){
	  			p=p.next;
	  			q=q.next.next;
	  		}	  		
	  		ListNode secondhalf=p.next;
	  		p.next=null;
//	  		ListNode fhalf = sortList(head);
//			ListNode shalf = sortList(secondhalf);
	  		
	  		return merge(sortList(head),sortList(secondhalf));
	  	}
	  
	  	
	  	public static ListNode merge(ListNode p, ListNode q){
	  		if(p==null||q==null)
	  			return p==null?q:p;
	  		
	  		ListNode dummy=new ListNode(0);
	  		ListNode cur=dummy;
	  		ListNode node1=p;
	  		ListNode node2=q;
	  		while(node1!=null&&node2!=null){
	  			if(node1.val<node2.val){
	  				cur.next=node1;
	  				node1=node1.next;
	  			}
	  			else{
	  				cur.next=node2;
	  				node2=node2.next;
	  			}
	  			cur=cur.next;
	  		}
	  		if(node1!=null)
	  			cur.next=node1;
	  		if(node2!=null)
	  			cur.next=node2;
	  		
	  		return dummy.next;
	  	}
	  
	  public static ListNode getMiddle(ListNode head){
		  if(head==null||head.next==null)
			  return head;
		  ListNode p=head;
	  		ListNode q=head;
	  		while(q.next!=null&&q.next.next!=null){
	  			p=p.next;
	  			q=q.next.next;
	  		}	  		
	  		return p;
	  }
	  
	  public static int getNodeLevel(TreeNode root, int val){
		  if(root==null)
			  return -1;
//		  int level=0;
		  return getNodeLevelUtil(root,val,0);
	  }
	  
	  public static int getNodeLevelUtil(TreeNode root, int val, int level){
		  if(root==null)
			  return -1;
		  if(root.val==val)
			  return level;
		  
		  int downLevel=getNodeLevelUtil(root.left,val,level+1);
		  if(downLevel!=-1)
			  return downLevel;
		  downLevel=getNodeLevelUtil(root.right,val,level+1);
		  return downLevel;
	  }
	  
	  public static int findDistanceBetweenNodes(TreeNode root, int node1, int node2){
		  if(root==null)
			  return -1;
		  ArrayList<TreeNode> path1=new ArrayList<TreeNode>();
		  ArrayList<TreeNode> path2=new ArrayList<TreeNode>();
		  
		 boolean first= findPath(root, node1, path1);
		 boolean second= findPath(root,node2,path2);
		 if(first&&second){
			 int index=0;
			 for(;index<path1.size();index++){
				 if(path1.get(index)!=path2.get(index))
					 break;
			 }
			 return path1.size()+path2.size()-2*index;
		 }
		 return -1;
	  }
	  
	  public static boolean findPath(TreeNode root, int node, ArrayList<TreeNode> path){
		  if(root==null)
			  return false;
		  path.add(root);
		  if(root.val==node)
			  return true;
		  if(findPath(root.left,node,path)||findPath(root.right,node,path))
			  return true;
		  path.remove(root);
		  return false;
	  }
	  
	  public static TreeNode findLCA(TreeNode root, TreeNode p, TreeNode q){
		  if(root==null||p==null||q==null)
			  return null;
		  if(root==p||root==q)
			  return root;
		  
		  int totalMatches=countMatches(root.left,p,q);
		  if(totalMatches==1)
			  return root;
		  else if(totalMatches==2)
			  return findLCA(root.left,p,q);
		  else
			  return findLCA(root.right,p,q);

	  }
	  
	  
	  public static int countMatches(TreeNode root, TreeNode p, TreeNode q){
		  if (root==null)
			  return 0;
		  int matches = countMatches(root.left, p, q) + countMatches(root.right, p, q);
		  if (root == p || root == q)
		    return 1 + matches;
		  else
		    return matches;
	  }
	  
	  
	  public static TreeNode LCA(TreeNode root, TreeNode p, TreeNode q) {
		  if (root==null) 
			  return null;
		  if (root == p || root == q) 
			  return root;
		  TreeNode L = LCA(root.left, p, q);
		  TreeNode R = LCA(root.right, p, q);
		  if (L!=null && R!=null)
			  return root;  // if p and q are on both sides
		  return L==null?R:L;  // either one of p,q is on one side OR p,q is not in L&R subtrees
		}
	  
	  
	  public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		  if(node==null)
			  return null;
		  Queue<UndirectedGraphNode> que=new LinkedList<UndirectedGraphNode>();
		  que.add(node);
		  HashMap<UndirectedGraphNode,UndirectedGraphNode> map=new HashMap<UndirectedGraphNode,UndirectedGraphNode>();
		  UndirectedGraphNode copy=new UndirectedGraphNode(node.label);
		  map.put(node, copy);
		  
		  while(!que.isEmpty()){
			  UndirectedGraphNode top=que.remove();
			  ArrayList<UndirectedGraphNode> neighbors=top.neighbors;
			  
			  for(int i=0;i<neighbors.size();i++){
				  UndirectedGraphNode neighbor=neighbors.get(i);
				  if(!map.containsKey(neighbor)){
					  que.add(neighbor);
					  UndirectedGraphNode p=new UndirectedGraphNode(neighbor.label);
					  map.put(neighbor, p);
					  map.get(top).neighbors.add(p);					  
				  }
				  else{
					  map.get(top).neighbors.add(map.get(neighbor));
				  }
				  
				  
			  }
		  }
		  return copy;
	  }
	  
	  
	  public ListNode reverseKGroup(ListNode head, int k) {
	        // Note: The Solution object is instantiated only once and is reused by each test case.
	        if(head==null)
	        	return null;
	        int len=0;
	        ListNode cur=head;
	        while(cur!=null){
	        	len++;
	        	cur=cur.next;
	        }
	        int count=0;
	        cur=head;
	        ListNode pre=null;
	        if(len>=k){
	        	while(cur!=null&&count<k){
	        		ListNode pnext=cur.next;
	        		cur.next=pre;
	        		pre=cur;
	        		cur=pnext;
	        		count++;
	        	}
	        	if(head!=null)
	        		head.next=reverseKGroup(cur,k);
	        }
	        else 
	        	return head;
	        return pre;
	    }
	  
	  public static ListNode reverseList(ListNode head){
		  if(head==null||head.next==null)
			  return head;
		  ListNode cur=head;
		  ListNode pre=null;
		  
		  while(cur!=null){
			  ListNode p=cur.next;
			  cur.next=pre;
			  pre=cur;
			  cur=p;
		  }
		  return pre;
	  }
	  
	  
	  public static ListNode reverseList2(ListNode head){
		  ListNode dummy=new ListNode(0);
		  dummy.next=head;
		  ListNode pre=dummy;
		  ListNode last=head;
		  ListNode cur=last.next;
		  while(cur!=null){
			  last.next=cur.next;
			  cur.next=pre.next;
			  pre.next=cur;
			  cur=last.next;
		  }
		  return dummy.next;
	  }
	  
	  public static ListNode reverseRange(ListNode p, ListNode q){
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
	  
	  public static ListNode reverseKGroup2(ListNode head, int k){
		  if(head==null||k==1)
			  return head;
		  ListNode dummy=new ListNode(0);
		  dummy.next=head;
		  ListNode pre=dummy;
		  ListNode cur=head;
		  int count=0;
		  while(cur!=null){
			  count++;
			  if(count%k==0){
				 pre=reverseRange(pre,cur.next);
				 cur=pre.next;
			  }
			  else
				  cur=cur.next;
		  }
		  return dummy.next;
	  }
	  
	  
	  public static int findKthElement(int[] A, int k){
		  if(A.length<k)
			  return -1;
//		  return quickSelect(A,0,A.length-1,k);
		  return quickSelect2(A,0,A.length-1,k);
	  }
	  
	  
	  public static int quickSelect2(int[] A, int left, int right, int k){
		  if(left==right)
			  return A[left];
		  int pivot=partition2(A,left,right);
		  int pivotDist=pivot-left+1;
		  if(pivotDist==k)
			  return A[pivot];
		  else if(pivotDist>k)
			  return quickSelect2(A,left,pivot-1,k);
		  else
			  return quickSelect2(A,pivot+1,right,k-pivotDist);
	  }
	  
	  
	  public static int quickSelect(int[] A, int left, int right, int k){
		  if(left==right)
			  return A[left];
		  int pivotIndex=left;
		  int pivotNewIndex=partition(A,left,right,pivotIndex);
		  int pivotDist=pivotNewIndex-left+1;
		  if(pivotDist==k)
			  return A[pivotNewIndex];
		  else if (k<pivotDist)
			  return quickSelect(A,left,pivotNewIndex-1,k);
		  else
			  return quickSelect(A,pivotNewIndex+1,right,k-pivotDist);
	  }
	  
	  public static int partition(int[] A, int left, int right, int pivotIndex){
		  int value=A[pivotIndex];
		 swap(A,pivotIndex,right);
		  
		  int storeIndex=left;
		  
		  for(int i=left;i<=right-1;i++){
			  if(A[i]<value){
				  swap(A,i,storeIndex);
				  storeIndex++;
			  }
		  }		  
		  swap(A,storeIndex,right);
		  return storeIndex;
	  }
	  
	  public static void swap(int[] A, int i, int j){
		  int t=A[i];
		  A[i]=A[j];
		  A[j]=t;
	  }
	  
	  public static int partition2(int[] A, int low, int high){
		  int pivot=low;
		  int left=low, right=high;
		  int value=A[pivot];
		  while(left<right){
			  while(left<right&&A[left]<=value)
				  left++;
			  while(right>left&&A[right]>value)
				  right--;
			  if(left<right)
				  swap(A,left,right);
		  }
		  int t=A[pivot];
		  A[pivot]=A[right];
		  A[right]=t;
//		  A[low]=A[right];
//		  A[right]=value;
		  
		  return right;
	  }
	  
	  // plane points k nearest to origin
	  public static ArrayList<Point> findKNearestPoints(ArrayList<Point> points, int k){
		  if(points.size()<=k)
			  return points;
		  ArrayList<Point> res=new ArrayList<Point>();
		  HashMap<Point,Double> map=new HashMap<Point,Double>();
		  PriorityQueue<Point> que=new PriorityQueue<Point>(k,Collections.reverseOrder());
		  for(int i=0;i<points.size();i++){
			  Point p=points.get(i);
			  double dist=Math.pow(p.x, 2)+Math.pow(p.y, 2);
			  map.put(p, dist);
			  if(que.size()<k){
				  que.add(p);
			  }
			  else{
				  Point top=que.peek();
				  if(dist<map.get(top)){
					  que.remove();
					  que.add(p);
				  }
			  }
		  }
		  while(!que.isEmpty()){
			  res.add(que.remove());
		  }
		  return res;
	  }
	  
	  
	  public String intToRoman(int num) {
	        // Note: The Solution object is instantiated only once and is reused by each test case.
		  if (num <= 0 || num > 3999)
				return null;

			String res = "";
			String[] str = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX",
					"V", "IV", "I" };
			int[] number = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
			for(int i=0;i<str.length;i++){
				while(num>=number[i]){
					res+=str[i];
					num-=number[i];
				}
			}
			return res;
	    }
	  
	  public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
	        // Note: The Solution object is instantiated only once and is reused by each test case.
		  ArrayList<ArrayList<Integer>> res=new ArrayList<ArrayList<Integer>>();
		  if(num.length<4)
			  return res;
		  ArrayList<Integer> sol=new ArrayList<Integer>();
		  Arrays.sort(num);
		  
		  for(int i=0;i<num.length-3;i++){
			  for(int j=i+1;j<num.length-2;j++){
				  int beg=j+1;
				  int end=num.length-1;
				  
				  while(beg<end){
					  int sum=num[i]+num[j]+num[beg]+num[end];
					  if(sum==target){
						  sol.add(num[i]);
						  sol.add(num[j]);
						  sol.add(num[beg]);
						  sol.add(num[end]);
						  if(!res.contains(sol)){
							  res.add(sol);
						  }						  
						  sol=new ArrayList<Integer>();
						  beg++;
						  end--;
					  }
					  else if(sum>target){
						  end--;
					  }
					  else
						  beg++;
				  }
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
	  
	  
	  public static void mirror(TreeNode root){
		  if(root==null)
			  return;
		  TreeNode t=root.left;
		  root.left=root.right;
		  root.right=t;
		  mirror(root.left);
		  mirror(root.right);
	  }
	  public int maximalRectangle(char[][] matrix) {
	        // Note: The Solution object is instantiated only once and is reused by each test case.
	        int m=matrix.length;
	        if(m==0)
	        	return 0;
	        int n=matrix[0].length;
	        
	        int[][] dp=new int[m][n];
	        for(int i=0;i<m;i++){
	        	dp[i][0]=matrix[i][0]-'0';
	        }
	        
	        for(int i=0;i<m;i++){
	        	for(int j=1;j<n;j++){
	        		if(matrix[i][j]=='1')
	        			dp[i][j]=dp[i][j-1]+1;
	        		else
	        			dp[i][j]=0;
	        	}
	        }
	        int maxArea=0;
	        
	        
	        for(int i=0;i<m;i++){
	        	for(int j=0;j<n;j++){
	        		int maxlen=dp[i][j];
	        		
	        		for(int k=i;k>=0;k--){
	        			if(dp[k][j]==0)
	        				break;
	        			maxlen=Math.min(maxlen, dp[k][j]);
	        			maxArea=Math.max(maxArea, maxlen*(i-k+1));
	        		}
	        	}
	        }
	        return maxArea;
	    }
	  
	  public ArrayList<String> restoreIpAddresses(String s) {
	        // Note: The Solution object is instantiated only once and is reused by each test case.
		  ArrayList<String> res=new ArrayList<String>();
		  if(s.length()<4|| s.length() > 12)
			  return res;
		  String sol="";
		  
		  restoreIpAddressesUtil(0,s,sol,res);
		  return res;		  
	    }
	  
	  public void restoreIpAddressesUtil(int dep, String s, String sol,  ArrayList<String> res){
		  if(dep==3&&isValidNum(s))
			  res.add(sol+s);
		  
		  for(int i=1;i<4&&i<s.length();i++){
			  String sub=s.substring(0,i);
			  if(isValidNum(sub)){
				  restoreIpAddressesUtil(dep+1,s.substring(i),sol+sub+".",res);
			  }
		  }
		  
	  }
	  public boolean isValidNum(String s){
		  if(s.charAt(0)=='0')
			  return s.equals("0");
		  int num=Integer.parseInt(s);
		  return num>0&&num<=255;
	  }
	  
	  
	  public int numDecodings(String s) {
	        // Note: The Solution object is instantiated only once and is reused by each test case.
		  	if(s.length()==0)
		  		return 0;
		  	
		  	int n=s.length();
		  	int[] dp=new int[n+1];
		  	dp[0]=1;
		  	
		  	if(isValidNumber(s.substring(0,1)))
		  		dp[1]=1;
		  	
		  	for(int i=2;i<=s.length();i++){
		  		if(isValidNumber(s.substring(i-1,i)))
		  			dp[i]=dp[i-1];
		  		if(isValidNumber(s.substring(i-2, i)))
		  			dp[i]=dp[i]+dp[i-2];
		  	}
		  	return dp[n];
		  	
	    }
	  
	  public static boolean isValidNumber(String s){
		  if(s.charAt(0)=='0')
			  return false;
		  int num=Integer.parseInt(s);
		  return num>=1&&num<=26;
	  }
	  
	  public static int numDecodings2(String s) {
	        if (s.length()==0) return 0;
	        int[] num = {0};
	        dfsUtil(s, num);
	        return num[0];
	    }
	  
	  public static void dfsUtil(String s, int[] num){
		  if(s.length()==0)
			  num[0]++;
		  
		  for(int i=0;i<=1&&i<s.length();i++){
			  if(isValidNumber(s.substring(0,i+1)))
				  dfsUtil(s.substring(i+1),num);
		  }
	  }
	    
	  
	  public static void changeTree(TreeNode root){
		  if(root==null)
			  return;
		TreeNode node=root.right;
		root.right=root.left;
		changeTree(root.left);
		TreeNode cur=root;
		while(cur.right!=null)
			cur=cur.right;
		cur.right=node;
		
		changeTree(node);
	  }
	  
	  
	  public static void findIntersection(ListNode head1, ListNode head2){
		  if(head1==null||head2==null)
			  return;
		  ListNode cur=head1;
		  int len1=0;
		  while(cur!=null){
			  len1++;
			  cur=cur.next;
		  }
		  cur=head2;
		  int len2=0;
		  while(cur!=null){
			  len2++;
			  cur=cur.next;
		  }
		  
		  cur=len1>len2?head1:head2;
		  ListNode cur2=len1>len2?head2:head1;
		  for(int i=0;i<Math.abs(len1-len2);i++)
			  cur=cur.next;
		  
		  while(cur!=cur2){
			  cur=cur.next;
			  cur2=cur2.next;
		  }
		  while(cur!=null)
			  System.out.println(cur.val);
	  }
	  
	  public static int findNumOf0s(int[] A){
//		  int count=0;
		  if(A.length==0)
			  return 0;
		  
		  int count=(A[0]==0?1:0);
		  for(int i=1;i<A.length;i++){
			  count=count+(A[i]==0?1:0);
		  }
		  return count;
	  }
	  
	  public static int makeChange(int[] coins, int n){
		  if(coins.length==0)
			  return 0;
		  int[] ways={0};
		  makeChangeUtil(0,coins,n, 0,ways);
		  return ways[0];
	  }
	  
	  public static void makeChangeUtil(int curPos, int[] coins,int n, int curSum,int[] ways){
		  if(curSum==n)
			  ways[0]++;
		  else if(curSum>n)
			  return;			  
		  
		  for(int i=curPos;i<coins.length;i++){
			  curSum+=coins[i];
			  makeChangeUtil(i,coins,n,curSum,ways);
			  curSum-=coins[i];
		  }
	  }
	  
	  public static int makeChange2(int[] coins, int n){
		  return makeChange2Util(coins,coins.length,n);
	  }
	  
	  public static int makeChange2Util(int[] coins, int m,int n){
		  if(n==0)
			  return 1;
		  if(n<0)
			  return 0;
		  if(m<=0&&n>0)
			  return 0;
		  return makeChange2Util(coins,m-1,n)+makeChange2Util(coins,m,n-coins[m-1]);
	  }
	  
	  public static String getInitial(String s){
		  if(s.length()==0)
			  return "";
		  String res="";
		  String[] strs=s.split(" ");
//		  System.out.println(strs.length);
		  for(int i=0;i<strs.length;i++){
//			  System.out.println(strs[i]);
			  if(strs[i].length()!=0)
				  res+=strs[i].charAt(0);
		  }
		  return res;
	  }
	  
	  public static ListNode reverseLinkedList(ListNode head){
		  if(head==null||head.next==null)
			  return head;

		  ListNode pnext=head.next;
		  head.next=null;
		  ListNode node=reverseLinkedList(pnext);
		  pnext.next=head;
		  return node;
	  }
	  
	  public static int moreThanThird(int[] A){
		  if(A.length==0)
			  return Integer.MAX_VALUE;
		  int[][] record=new int[2][2];
		  record[0][0]=Integer.MAX_VALUE;
		  record[0][1]=Integer.MAX_VALUE;
		  record[1][0]=0;
		  record[1][1]=0;
		  
		  for(int i=0;i<A.length;i++){
			  if(record[0][0]==A[i])
				  record[1][0]++;
			  else if(record[0][1]==A[i])
				  record[1][1]++;
			  else{
				  if(record[1][0]==0){
					  record[1][0]=1;
					  record[0][0]=A[i];
				  }
				  else if(record[1][1]==0){
					  record[1][1]=1;
					  record[0][1]=A[i];
				  }
				  else{
					  if(record[0][0]==A[i])
						  record[1][0]++;
					  else if(record[0][1]==A[i])
						  record[1][1]++;
					  else{
						  record[1][0]--;
						  record[1][1]--;
					  }
				  }
			  }			 
			
		  }
		  
		  int count1=0;
		  int count2=0;
		  
		  for(int i=0;i<A.length;i++){
			  if(A[i]==record[0][0])
				  count1++;
			  if(A[i]==record[0][1])
				  count2++;
		  }
		  if(count1*3>A.length)
			  return record[0][0];
		  if(count2*3>A.length)
			  return record[0][1];
		  return Integer.MAX_VALUE;
		 
	  }
	  
	  public static void moreThanThird2(int[] A){
		  if(A.length==0)
			  return;
		  TreeMap<Integer,Integer> map=new TreeMap<Integer, Integer>();
		  for(int i=0;i<A.length;i++){
			  if(map.containsKey(A[i]))
				  map.put(A[i], map.get(A[i])+1);
			  else if(map.size()<2)
				  map.put(A[i], 1);
			  else{
				  int first=map.firstKey();
				  map.put(first, map.get(first)-1);
				  int second=map.lastKey();
				  map.put(second,map.get(second)-1);
				  if(map.get(first)==0)
					  map.remove(first);
				  if(map.get(second)==0)
					  map.remove(second);
			  }
		  }
		  int first=map.firstKey();
		  int second=map.lastKey();
		  int count1=0;
		  int count2=0;
		  for(int i=0;i<A.length;i++){
			  if(A[i]==first)
				  count1++;
			  if(A[i]==second)
				  count2++;
		  }
		  if(count1*3>A.length)
			  System.out.println(first);
		  if(count2*3>A.length&&second!=first)
			  System.out.println(second);
			  
	  }
	  
	  public static ArrayList<ArrayList<Integer>> verticalView(TreeNode root){
		  ArrayList<ArrayList<Integer>> res=new ArrayList<ArrayList<Integer>>();
		  if(root==null)
			  return res;
		  HashMap<Integer, ArrayList<Integer>> map=new HashMap<Integer, ArrayList<Integer>>();
		  verticalViewUtil(root,0,map);
		  
		  Iterator<Integer> it=map.keySet().iterator();
		  while(it.hasNext()){
			  int axis=it.next();
			  res.add(map.get(axis));
		  }
		  return res;
		  
	  }
	  
	  public static void verticalViewUtil(TreeNode root, int axis, HashMap<Integer, ArrayList<Integer>> map){
		  if(root==null)
			  return;
		  if(!map.containsKey(axis)){
			  ArrayList<Integer> lst=new ArrayList<Integer>();
			  lst.add(root.val);
			  map.put(axis, lst);
		  }
		  else{
			  ArrayList<Integer> list=map.get(axis);
			  list.add(root.val);
			  map.put(axis, list);
		  }
		  verticalViewUtil(root.left,axis-1,map);
		  verticalViewUtil(root.right,axis+1,map);
	  }
	  
	  public static int[] nextLargerNumber(int[] A){// keep same if no great number
		  int n=A.length;
		  int[] res=new int[n];
		  if(n==0)
			  return res;
		  Stack<Integer> stk=new Stack<Integer>();
		  stk.push(0);
		  int cur=1;
		  while(cur<n){
			  while(!stk.isEmpty()&&A[stk.peek()]<A[cur]){
				  res[stk.pop()]=A[cur];
			  }
			  stk.push(cur);
			  cur++;
		  }
		  while(!stk.isEmpty()){
			  int t=stk.pop();
			  res[t]=A[t];
//			  res[t]=-1;
		  }
		  
		  System.out.println(Arrays.toString(res));

		  return res;
	  }
	  
//	  replace each element in the arry with the next larger element in the array
	  public static int[] nextLargerNumber2(int[] A){ //if no next greater num, give -1
		  int n=A.length;
		  int[] res=new int[n];
		  if(n==0)
			  return res;
		  
		  Stack<Integer> stk=new Stack<Integer>();
		  stk.push(0);
		  
		  for(int cur=1;cur<n;cur++){
			  while(!stk.isEmpty()&&A[stk.peek()]<A[cur])
				  res[stk.pop()]=A[cur];
			  stk.push(cur);
		  }
		  while(!stk.isEmpty()){
			  res[stk.pop()]=-1;
		  }
		  
		  for(int i=0;i<n;i++){
			  System.out.print(res[i]+" ");
		  }
		  
		  return res;
	  }
	  
	  public static Stack<Integer> reverseStack(Stack<Integer> stk){
		  if(stk.isEmpty())
			  return stk;
		  int top=stk.pop();
		  reverseStack(stk);
		  addToBottom(stk,top);
		  return stk;
	  }
	  
	  public static void addToBottom(Stack<Integer> stk, int val){
		  if(stk.isEmpty()){
			  stk.push(val);
			  return;
		  }
		  int top=stk.pop();
		  addToBottom(stk,val);
		  stk.push(top);
	  }
	  
	  public static Stack<Integer> sortStk(Stack<Integer> stk){
		  Stack<Integer> stack=new Stack<Integer>();
		  if(stk.isEmpty())
			  return stack;
		  
		  while(!stk.isEmpty()){
			  int top=stk.pop();
			  while(!stack.isEmpty()&&top>stack.peek())
				  stk.push(stack.pop());
			  stack.push(top);
		  }
		  return stack;
		  
	  }
	  
	  
	  public static ListNode addList(ListNode head1, ListNode head2){
		  if(head1==null||head2==null)
			  return head1==null?head2:head1;
		  Stack<Integer> stk1=new Stack<Integer>();
		  Stack<Integer> stk2=new Stack<Integer>();
		  ListNode cur=head1;
		  while(cur!=null){
			  stk1.push(cur.val);
			  cur=cur.next;
		  }
		  
		  cur=head2;
		  while(cur!=null){
			  stk2.push(cur.val);
			  cur=cur.next;
		  }
		  
		  ListNode last=null;
		  int carry=0;
		  while(!stk1.isEmpty()&&!stk2.isEmpty()){
			  int dig1=stk1.pop();
			  int dig2=stk2.pop();
			  int sum=dig1+dig2+carry;
			  carry=sum/10;
			  sum=sum%10;
			  if(last==null){
				  last=new ListNode(sum);
			  }
			  else{
				  ListNode node=new ListNode(sum);
				  node.next=last;
				  last=node;
			  }
		  }
		  
		  while(!stk1.isEmpty()){
			  int dig1=stk1.pop();
			  int sum=dig1+carry;
			  carry=sum/10;
			  sum=sum%10;
			  ListNode node=new ListNode(sum);
			  node.next=last;
			  last=node;
		  }
		  
		  while(!stk2.isEmpty()){
			  int dig1=stk2.pop();
			  int sum=dig1+carry;
			  carry=sum/10;
			  sum=sum%10;
			  ListNode node=new ListNode(sum);
			  node.next=last;
			  last=node;
		  }
		  
		  if(carry==1){
			  ListNode node=new ListNode(1);
			  node.next=last;
			  last=node;
		  }
		  return last;
		  
	  }
	  
	  
	  public static String convertString(String s,int row){
		  if(s.length()<2||row==1)
			  return s;
		  
		  String res="";
		  for(int i=0;i<row;i++){
			  for(int j=i;j<s.length();j+=row){
				  res+=s.charAt(j);
			  }
		  }
		  return res;
	  }
	  
	  public static int coinChange(int[] coins, int n){
		  if(coins.length==0)
			  return 0;
		  int m=coins.length;
		  int[][] dp=new int[n+1][m];
		  
		  for(int i=0;i<m;i++)
			  dp[0][i]=1;
		  
		  for(int i=1;i<=n;i++){
			  for(int j=0;j<m;j++){
				// Count of solutions including coins[j]
				  int x=(i-coins[j]>=0)?dp[i-coins[j]][j]:0;
				// Count of solutions excluding coins[j]
				  int y=j>0?dp[i][j-1]:0;
				// total count
				  dp[i][j]=x+y;
					  
			  }
		  }
		  return dp[n][m-1];
	  }
	  
	  public static ListNode reverseListRecur(ListNode head){
		  if(head==null||head.next==null)
			  return head;
		  ListNode pnext=head.next;
		  head.next=null;
		  ListNode node=reverseListRecur(pnext);
		  pnext.next=node;
		  return node;
	  }
	  
	  
	  public boolean hasCycle(ListNode head) {
	        // IMPORTANT: Please reset any member data you declared, as
	        // the same Solution instance will be reused for each test case.
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
	        else
	        	return true;
	    }
	  
	  public ListNode detectCycle(ListNode head) {
	        // IMPORTANT: Please reset any member data you declared, as
	        // the same Solution instance will be reused for each test case.
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
	        ListNode cur=head;
	        
	        while(cur!=fast){
	        	cur=cur.next;
	        	fast=fast.next;
	        }
	        return cur;
	    }
	  
	  
	  public void flatten4(TreeNode root) {
		  if(root==null)
			  return;
		 TreeNode left=root.left;
		 TreeNode right=root.right;
		 flatten(left);
		 root.left=null;
		 root.right=left;
		 
		 TreeNode cur=root;
		 while(cur.right!=null){
			 cur=cur.right;
		 }
		 cur.right=right;
		 flatten(right);
		 
	  }
	  
	  public static ArrayList<Character> serializationBT(TreeNode root){
		  ArrayList<Character> res=new ArrayList<Character>();
		  serializationBTUtil(root,res);
		  return res;
//		  if(root!=null){
//			  
//			 
//		  res.add((char) (root.val+'0'));
//		  if(root.left!=null||root.right!=null){
//			  res.add('(');
//			  serializationBT(root.left);
//			  if(root.right!=null)
//				  res.add(',');
//			  serializationBT(root.right);
//			  res.add(')');
//		  }
//		  }
//		  return res;
	  }
	  
	  static void DispBTree(TreeNode  root)
	  {		  
	   if (root!=null)
	   {
	         System.out.print(root.val);
	    if (root.left!=null||root.right!=null)
	    {
	    	System.out.print("(");
	     DispBTree(root.left);
	     if (root.right!=null)
	    	 System.out.print(",");
	    	 
	     DispBTree(root.right);
	     System.out.print(")");
	    }
	   }
	  }
	  

	  public static void serializationBTUtil(TreeNode root, ArrayList<Character> res){
		  if(root!=null){
			  res.add((char) (root.val+'0'));
			  if (root.left!=null||root.right!=null)
			    {
				  res.add('(');
				  serializationBTUtil(root.left,res);
			     if (root.right!=null)
			    	 res.add(',');
			    	 
			     serializationBTUtil(root.right,res);
			     res.add(')');
			    }
		  }
		  
	  }
	  
	  
	  public static String serializationBT2(TreeNode root){
		  StringBuilder sb=new StringBuilder(""); 
		  serializationBTUtil(root,  sb);
		  return sb.toString();
	  }
	  
	  public static void serializationBTUtil(TreeNode root, StringBuilder sb){
		  if (root != null) {               
	            sb.append(root.val);  
	            if (root.left != null || root.right != null) {  
	            	sb.append('(');  
	                if (root.left != null) {  
	                	serializationBTUtil(root.left, sb);  
	                }   
	                if (root.right != null) {    
		                sb.append(','); 
	                	serializationBTUtil(root.right, sb);          
	                }  
	                sb.append(')');  
	            }     
	        }             
	  }
	  
	  public static TreeNode deserializationBT(ArrayList<Character> res){
		  if(res.size()==0)
			  return null;
		  int[] idx={0};
		  TreeNode root=null;
		  return deserializationBTUtil(res,root,idx);
	  }
	  
	  public static TreeNode deserializationBTUtil(ArrayList<Character> res, TreeNode root,int[] index){
//		  if(index[0]>=res.size())
//			  return null;
		  TreeNode node=null;
		  if(res.get(index[0])!=','&&res.get(index[0])!='('&&
				  res.get(index[0])!=')'){
			  node=new TreeNode(res.get(index[0])-'0');
			  index[0]++;
			  if(root==null)
				  root=node;
			  else{
				  
			  }
			  
		  }
		  if(index[0]<res.size()&&res.get(index[0])=='('){
			  index[0]++;
			  root.left=deserializationBTUtil(res,root,index);
		  }
		  if(index[0]<res.size()&&res.get(index[0])==','){
			  index[0]++;
			  root.right=deserializationBTUtil(res,root,index);
			  return root;
		  }
		  
		  if(index[0]<res.size()&&res.get(index[0])==')'){
			  index[0]++;
			  return root;
		  }
		  else
			  return root;
//		  root.left=deserializationBTUtil(res,index);
//		  index[0]++;
//		  root.right=deserializationBTUtil(res,index);
//		  return root;
	  }
	  
	  public static TreeNode createTree(TreeNode root, String exp){
		  	TreeNode node=null;
		  	Stack<TreeNode> stk=new Stack<TreeNode>();
		  	
		  	int flag=0;
		  	
		  	for(char c:exp.toCharArray()){
		  		switch(c){
		  		case '(':
		  			stk.push(node);
		  			flag=0;
		  			break;
		  		case ')':
		  			stk.pop();
		  			break;
		  		case ',':
		  			flag=1;
		  			break;
		  		default:
		  			node=new TreeNode(c-'0');
		  			if(root==null)
		  				root=node;
		  			else{
		  				TreeNode top=stk.peek();
		  				if(flag==0){		  					
		  					top.left=node;
		  				}
		  				else{
		  					top.right=node;
		  				}
		  			}
		  			break;	  			
		  			
		  		}
		  	}
		  	return root;
	  }
	  
	  public static boolean isScrambleTree(TreeNode root1, TreeNode root2){
		  if(root1==null&&root2==null)
			  return true;
		  if(root1==null||root2==null)
			  return false;
		  if(root1.val!=root2.val)
			  return false;
		 
//		  if((root1.left.val==root2.left.val&&root1.right.val==root2.right.val)
//				  ||(root1.left.val==root2.right.val&&root1.right.val==root2.left.val))
			  return isScrambleTree(root1.left,root2.left)&&isScrambleTree(root1.right,root2.right)||
					  isScrambleTree(root1.right,root2.left)&&isScrambleTree(root1.left,root2.right);
//		  else
//			  return false;
//		  }
//		  
//		  return false;
	  }
	  
	 
	  
	  public static void reorderList(ListNode head) {
	        // IMPORTANT: Please reset any member data you declared, as
	        // the same Solution instance will be reused for each test case.
	        if(head==null||head.next==null)
	        	return;
	        
	        ListNode fast=head;
	        ListNode slow=head;
	        while(fast!=null){
	        	fast=fast.next;
	        	if(fast!=null)
	        		fast=fast.next;
	        	if(fast==null)
	        		break;
	        	slow=slow.next;
	        }
	        
	        ListNode head2=slow.next;
	        slow.next=null;
	        
	        ListNode node=reverseLST(head2);
	        
	        ListNode cur1=head;
	        ListNode cur2=node;
	        
	        while(cur1!=null&&cur2!=null){
	        	ListNode pnext=cur1.next;
	        	cur1.next=cur2;
	        	cur1=pnext;
	        	pnext=cur2.next;
	        	cur2.next=cur1;
	        	cur2=pnext;
	        }
	        
	    }
	  
	  public static ListNode reverseLST(ListNode head){
		  if(head==null||head.next==null)
			  return head;
		  ListNode dummy=new ListNode(0);
		  dummy.next=head;
		  ListNode last=head;
		  ListNode cur=last.next;
		  while(cur!=null){
			  last.next=cur.next;
			  cur.next=dummy.next;
			  dummy.next=cur;
			  cur=last.next;
		  }
		  return dummy.next;
	  }
	  
	  
	  public static void printMatrix(int[][] matrix){
		  int n=matrix.length;
		  
		  for(int i=0;i<n;i++)
			  System.out.print(matrix[i][i]+" ");
		  System.out.println();
		  
		  for (int slice = 0; slice < n*2-1; ++slice) {
		        int z = slice < n ? 0 : slice - n + 1;
		        for (int j = z; j <= slice - z; ++j) {
		            int c1=j;
		            int c2=(n-1)-(slice-j);
		            if(c1!=c2)
		            	System.out.print( matrix[c1][c2]+" ");
		        }
		        System.out.println();
		    }		    
		  
	  }
	  
	  public ArrayList<Integer> preorderTraversal(TreeNode root) {
	        // IMPORTANT: Please reset any member data you declared, as
	        // the same Solution instance will be reused for each test case.
		  ArrayList<Integer> res=new ArrayList<Integer>();
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
	  
	  public String convert(String s, int nRows) {
	        // Note: The Solution object is instantiated only once and is reused by each test case.
	        if(s.length()==0||nRows==1)
	        	return s;
	        
	        String res="";
	        int zigSize=2*nRows-2;
	        
	        for(int i=0;i<nRows;i++){
	        	for(int j=i;j<s.length();j+=zigSize){
	        		res+=s.charAt(j);
	        		if(i>0&&i<nRows-1){
	        			int k=j+zigSize-2*i;
	        			if(k<s.length())
	        				res+=s.charAt(k);
	        		}
	        	}
	        }
	        return res;
	    }
	  
	  public static ListNode insertionSort(int[] arr){
		  if(arr.length==0)
			  return null;
		  ListNode head=new ListNode(arr[0]);
		  
		  for(int i=1;i<arr.length;i++){
			  ListNode pre=null;
			  ListNode it=head;
			  while(it!=null){
				  if(it.val<arr[i]){
					  pre=it;
					  it=it.next;
				  }
				  else
					  break;
			  }
			  
			  ListNode node=new ListNode(arr[i]);
			  if(pre==null){
				  head=node;
			  }
			  else
				  pre.next=node;
			  node.next=it;
		  }
		  return head;
	  }
	  
	  public static TreeNode level_order_insert(int[] arr){
		  TreeNode root=null;
		  return level_order_insertUtil(root,arr,0,arr.length);
	  }
	  
	  public static TreeNode level_order_insertUtil(TreeNode root, int[] arr, int start, int size){
		  int left=2*start+1;
		  int right=2*start+2;
		  if(left>size||right>size)
			  return null;
		  if(root==null){
			  root=new TreeNode(arr[start]);
		  }
		  if(root.left == null && root.right == null) {
		        if(left < size)
		            root.left = new TreeNode(arr[left]);
		        if(right < size)
		            root.right = new TreeNode(arr[right]);
		    }
		    level_order_insertUtil(root.left, arr, left, size);
		    level_order_insertUtil(root.right, arr, right, size);
		    return root;
	  }
	  
	  
	  public static ArrayList<String> permuteString(String s){
		  ArrayList<String> res=new ArrayList<String>();
		  if(s.length()==0)
			  return res;
		  String sol="";
		  boolean[] used=new boolean[s.length()];
		  permuteStringUtil(0,s,used,sol,res);
		  return  res;
	  }
	  
	  public static void permuteStringUtil(int dep, String s, boolean[] used, String sol, ArrayList<String> res){
		  if(dep==s.length()){
			  res.add(sol);
		  }
		  
		  for(int i=0;i<s.length();i++){
			  if(!used[i]){
				  used[i]=true;
//				  sol+=s.charAt(i);
				  permuteStringUtil(dep+1,s,used,sol+s.charAt(i),res);
				  used[i]=false;
			  }
		  }
	  }
	  
	  public static ListNode intersecion(ListNode head1, ListNode head2){
		  if(head1==null||head2==null)
			  return null;
		  
		  int len1=0;
		  ListNode cur=head1;
		  while(cur!=null){
			  len1++;
			  cur=cur.next;
		  }
		  
		  int len2=0;
		  cur=head2;
		  while(cur!=null){
			  len2++;
			  cur=cur.next;
		  }
		  
		  int d=Math.abs(len1-len2);
		  
		  ListNode cur1=len1>len2?head1:head2;
		  ListNode cur2=len1>len2?head2:head1;
		  
		  for(int i=0;i<d;i++){
			  if(cur1==null)
				  return null;
			  cur1=cur1.next;
		  }
		  
		  while(cur1!=null&&cur2!=null){
			  if(cur1==cur2)
				  return cur1;
			  cur1=cur1.next;
			  cur2=cur2.next;
		  }
		  
		  return  null;
	  }
	  
	  public static void bucketSort(int[] arr){
		  int max=arr[0];
		  for(int i=1;i<arr.length;i++){
			  if(arr[i]>max)
				  max=arr[i];
		  }
		  
		  int[] buckets=new int[max+1];
		  
		  for(int i=0;i<arr.length;i++){
			  buckets[arr[i]]++;
		  }
		  
		  for(int i=0,j=0;i<max;i++){
			  for(int k=buckets[i];k>0;k--)
				  arr[j++]=i;
		  }
		  
		  for(int i=0;i<arr.length;i++)
			  System.out.print(arr[i]+" ");
		  System.out.println();
	  }
	  
	  public ArrayList<Integer> postorderTraversal(TreeNode root) {
	        // IMPORTANT: Please reset any member data you declared, as
	        // the same Solution instance will be reused for each test case.
		  ArrayList<Integer> res=new ArrayList<Integer>();
		  if(root==null)
			  return res;
		  TreeNode cur=root;
		  TreeNode pre=null;
		  Stack<TreeNode> stk=new Stack<TreeNode>();
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
	  
	  public ArrayList<String[]> solveNQueens(int n) {
		  ArrayList<String[]> res=new ArrayList<String[]>();
		  int[] loc=new int[n];
		  dfsQueens(0,n,loc,res);
		  return res;
	  }
	  
	  public void dfsQueens(int cur, int n, int[] loc, ArrayList<String[]> res){
		  if(cur==n)
			  printBoard(res,loc);
		  else{
			  for(int i=0;i<n;i++){
				  loc[cur]=i;
				  
				  if(isValid(loc,cur))
					  dfsQueens(cur+1,n,loc,res);
			  }
		  }
		 
	  }
	  
	  public boolean isValid(int[] loc, int cur){
		  for(int i=0;i<cur;i++){
			  if(loc[i]==loc[cur]||Math.abs(loc[cur]-loc[i])==(cur-i))
				  return false;
		  }
		  return true;
	  }
	  
	  public void printBoard(ArrayList<String[]> res, int[] loc){
		  int n=loc.length;
		  
		  String[] sol=new String[n];
		  for(int i=0;i<n;i++){
			  String row="";
			  
			  for(int j=0;j<n;j++){
				  if(j==loc[i])
					  row+="Q";
				  else
					  row+=".";
			  }
			  sol[i]=row;
		  }
		  res.add(sol);
	  }
	  
	  public int totalNQueens(int n) {
	        // Note: The Solution object is instantiated only once and is reused by each test case.
	        int[] loc=new int[n];
	        int res[]={0};
	        dfsNQueens(0,n,loc,res);
	        return res[0];
	    }
	  
	  
	  public void dfsNQueens(int cur, int n, int[] loc, int[] res){
		  if(cur==n)
			  res[0]++;
		  else{
			  for(int i=0;i<n;i++){
				  loc[cur]=i;
				  if(isValid2(loc, cur))
					  dfsNQueens(cur+1,n,loc,res);
			  }
		  }
	  }
	  
	  public boolean isValid2(int[] loc, int cur){
		  for(int i=0;i<cur;i++){
			  if(loc[i]==loc[cur]||Math.abs(loc[i]-loc[cur])==cur-i)
				  return false;
		  }
		  return  true;
	  }
	  
	  public static int longestCommonSequence(String s1, String s2){
		  if(s1.length()==0||s2.length()==0)
			  return 0;
		  int l1=s1.length();
		  int l2=s2.length();
		  int[][] dp=new int[l1+1][l2+1];
		  
		  for(int i=0;i<=l1;i++)
			  dp[i][0]=0;
		  for(int i=0;i<=l2;i++)
			  dp[0][i]=0;
		  
		  for(int i=1;i<=l1;i++){
			  for(int j=1;j<=l2;j++){
				  if(s1.charAt(i-1)==s2.charAt(j-1))
					  dp[i][j]=dp[i-1][j-1]+1;
				  else
					  dp[i][j]=Math.max(dp[i-1][j], dp[i][j-1]);
			  }
		  }
		  return dp[l1][l2];
	  }
	  
	  
	  public static int maxDifferent(int[] arr){
		  if(arr.length<2)
			  return 0;
		  int n=arr.length;
		  int[] diff=new int[n-1];
		  for(int i=1;i<n;i++)
			  diff[i-1]=arr[i-1]-arr[i];
		  int max=0;
		  int curSum=diff[0];
		  
		  for(int i=1;i<n-1;i++){
			  if(curSum<0)
				  curSum=diff[i];
			  else
				  curSum+=diff[i];
			  if(curSum>max)
				  max=curSum;
		  }
		  return max;
	  }
	  
	  
	  public static int topKthNumber(int[] arr, int k){
		  if(arr.length<k)
			  return -1;
//		  return quickSelection(arr,0,arr.length-1,k);
		  return quickSelect2(arr,0,arr.length-1,k);
	  }
	  
	  public static int quickSelection(int[] arr, int left, int right, int k){
		  if(left==right)
			  return arr[left];
		  int pivot=Partition(arr,left,right);
		  int pivotDist=pivot-left+1;
		  if(pivotDist==k)
			  return arr[pivot];
		  else if(pivotDist>k)
			  return quickSelection(arr, left,pivot-1,k);
		  else
			  return quickSelection(arr,pivot+1,right,k-pivotDist);
	  }
	  
	  
	  public static int Partition(int[] arr, int low, int high){
		  int pivot=low;
		  int left=low,right=high;
		  int val=arr[pivot];
		  while(left<right){
			  while(left<right&&arr[left]<=val)
				  left++;
			  
			  while(right>left&&arr[right]>val)
				  right--;
			  
			  if(left<right)
				  swap1(arr,left,right);
		  }
		  swap1(arr,pivot,right);
		  return right;
	  }
	  
	  public static void swap1(int[] A, int i, int j){
		  int t=A[i];
		  A[i]=A[j];
		  A[j]=t;
	  }
	  
	  
	  
//	  public static int findKthElement(int[] A, int k){
//		  if(A.length<k)
//			  return -1;
////		  return quickSelect(A,0,A.length-1,k);
//		  return quickSelect2(A,0,A.length-1,k);
//	  }
//	  
//	  
//	  public static int quickSelect2(int[] A, int left, int right, int k){
//		  if(left==right)
//			  return A[left];
//		  int pivot=partition2(A,left,right);
//		  int pivotDist=pivot-left+1;
//		  if(pivotDist==k)
//			  return A[pivot];
//		  else if(pivotDist>k)
//			  return quickSelect2(A,left,pivot-1,k);
//		  else
//			  return quickSelect2(A,pivot+1,right,k-pivotDist);
//	  }
//	  
//	  
//	  public static void swap(int[] A, int i, int j){
//		  int t=A[i];
//		  A[i]=A[j];
//		  A[j]=t;
//	  }
//	  
//	  public static int partition2(int[] A, int low, int high){
//		  int pivot=low;
//		  int left=low, right=high;
//		  int value=A[pivot];
//		  while(left<right){
//			  while(left<right&&A[left]<=value)
//				  left++;
//			  while(right>left&&A[right]>value)
//				  right--;
//			  if(left<right)
//				  swap(A,left,right);
//		  }
//		  int t=A[pivot];
//		  A[pivot]=A[right];
//		  A[right]=t;
////		  A[low]=A[right];
////		  A[right]=value;
//		  
//		  return right;
//	  }
	  
	  public static String minWindow2(String S, String T) {
		  if(S.length()==0)
			  return "";
		  
		  int[] needToFind=new int[256];
		  for(int i=0;i<T.length();i++)
			  needToFind[T.charAt(i)]++;
		  
		  int[] found=new int[256];
		  
		  int count=T.length();
		  int min=S.length();
		  int windowStart=0;
		  int windowEnd=S.length()-1;
		  int start=0;
		  
		  for(int i=0;i<S.length();i++){
			  char c=S.charAt(i);
			  if(needToFind[c]==0)
				  continue;
			  found[c]++;
			  if(found[c]<=needToFind[c])
				  count--;
			  
			  if(count==0){
				  while(needToFind[S.charAt(start)]==0||found[S.charAt(start)]>needToFind[S.charAt(start)]){
					  if(found[S.charAt(start)]>needToFind[S.charAt(start)]){
						  found[S.charAt(start)]--;
					  }
					  start++;
				  }
				  if(i-start+1<min){
					  windowStart=start;
					  windowEnd=i;
					  min=i-start+1;
				  }
			  }
		  }
		  
		  if(count==0)
			  return S.substring(windowStart,windowEnd+1);
		  else
			  return "";
	  }
	  
	  
	  public static void visible(TreeNode root){
		  if(root==null)
			  return;
		  visible(root, root.val);
	  }
	  
	  public static void visible(TreeNode root, int val){
		  if(root==null)
			  return;
		  if(root.val>=val){
			  System.out.print(root.val+" ");
			  val=root.val;
		  }
		  
		  visible(root.left,val);
		  visible(root.right,val);
	  }
	  
	  
	  private static TreeNode superImpose0(TreeNode below, TreeNode above)
	  {
	   if (above == null)
	    return below;
	   if (below == null)
	    return above;
	   above.left = superImpose(below.left, above.left);
	   above.right = superImpose(below.right, above.right);
	   return above;
	  }
	  
	  
	  public static TreeNode superImpose(TreeNode below, TreeNode above)
	  {
	   if (above == null ||below==null)
	    return above==null? below:above;
	   above.left = superImpose(below.left, above.left);
	   above.right = superImpose(below.right, above.right);
	   return above;
	  }
	  
	  public static TreeNode superImpose2(TreeNode below, TreeNode above)
	  {
	   if (above == null ||below==null)
	    return above==null? below:above;
	   if(below.val!=above.val){
		   System.out.println("exception");
		   return null;
	   }
	   above.left = superImpose2(below.left, above.left);
	   above.right = superImpose2(below.right, above.right);
	   return above;
	  }
	  
	  public static void rotateLeftKTimes(int[] arr, int k){
		  if(arr.length==0)
			  return;
		  int n=arr.length;
		  k=k%n;
		  
		  reverseArray(arr,0,arr.length-1);
		  reverseArray(arr,0,k-1);
		  reverseArray(arr,k,arr.length-1);
		  
		  for(int i=0;i<arr.length;i++)
			  System.out.print(arr[i]+" ");
		  System.out.println();
	  }
	  
	  public static void reverseArray(int[] arr, int beg, int end){
		  while(beg<end){
			  int t=arr[beg];
			  arr[beg]=arr[end];
			  arr[end]=t;
			  beg++;
			  end--;
		  }
	  }
	  
	  
	  public static String reverseWords(String str){
		  char[] ch=str.toCharArray();
		  int start=0;
		  int end=0;
		  reverseWord(ch,0,ch.length-1);
		  
		  while(end<ch.length){
			  if(ch[end]==' '){
				  reverseWord(ch,start,end-1);
				  start=end+1;
			  }
			  end++;
		  }
		  reverseWord(ch,start, end-1);
		  return new String(ch);
	  }
	  
	  public static void reverseWord(char[] ch, int i, int j){
		  while(i<j){
			  char c=ch[i];
			  ch[i]=ch[j];
			  ch[j]=c;
			  i++;j--;
		  }
	  }
	  
	  
	  public static void foldLinkedList(ListNode head){
		  if(head==null||head.next==null)
			  return;
		  
		  ListNode slow=head;
		  ListNode fast=head;
		  while(fast!=null){
			  slow=slow.next;
			  fast=fast.next;
			  if(fast!=null)
				  fast=fast.next;
		  }
		  
		  ListNode middle=slow;
		  ListNode cur=head;
		  ListNode halfHead=reverseList(slow);
		  
		  while(cur!=middle&&halfHead!=null){
			  ListNode pnext=cur.next;
			  cur.next=halfHead;
			  cur=pnext;
			  
			  pnext=halfHead.next;
			  halfHead.next=cur;
			  halfHead=pnext;
		  }
		  
		  if (halfHead != null)
			  halfHead.next = null;
			  else
			   cur.next = null;
		  
	  }
	  
	  public static void nextSmallerNumber(int[] A){
		  if(A.length==0)
			  return;
		  
		  Stack<Integer> stk=new Stack<Integer>();
		  stk.push(0);
		  int cur=1;
		  for(cur=1;cur<A.length;cur++){
			  while(!stk.isEmpty()&&A[stk.peek()]>A[cur])
				  A[stk.pop()]=A[cur];
			  stk.push(cur);
		  }
		  
		  while(!stk.isEmpty())
			  A[stk.pop()]=0;
		  
		  for(int i=0;i<A.length;i++)
			  System.out.print(A[i]+" ");
		  System.out.println();
	  }
	  
	  public static String nextPalindrome(int num)
	  {
	   String s=""+num;
	   int len=s.length();
	   boolean isodd=false;
	   if(len%2!=0)
		   isodd=true;
	   int leftEnd=-1;
	   int rightStart=-1;
	   if(isodd){
		   leftEnd=len/2;
		   rightStart=leftEnd+1;
	   }
	   else{
		   leftEnd=rightStart=len/2;
	   }
	   
	   if(isodd){
		   String left=s.substring(0,leftEnd);
		   String right=s.substring(rightStart);
		   
		   String leftReverse=reverseNum(left);
		   if(leftReverse.compareTo(right)<=0){
			   leftReverse=reverseNum(left);
			   left=plusOne(s.substring(0,leftEnd+1));
			   return left+leftReverse;
		   }
		   else
			   return s.substring(0,leftEnd+1)+leftReverse;
	   }
	   else{
		   String left=s.substring(0,leftEnd);
		   String right=s.substring(rightStart);
		   
		   String leftReverse=reverseNum(left);
		   if(leftReverse.compareTo(right)<=0){
			   left=plusOne(left);
			   leftReverse=reverseNum(left);
			   return left+leftReverse;
		   }
		   else
			   return left+leftReverse;
	   }
	   
	  }
	  
	  public static String reverseNum(String s){
		  char[] ch=s.toCharArray();
		  int i=0;
		  int j=s.length()-1;
		  while(i<j){
			  char c=ch[i];
			  ch[i]=ch[j];
			  ch[j]=c;
			  i++;
			  j--;
		  }
		  return new String(ch);
	  }
	  
	  public static String plusOne(String s){
		  String res="";
		  int carry=1;
		  int i=s.length()-1;
		  while(i>=0){
			  int sum=s.charAt(i)-'0'+carry;
			  carry=sum/10;
			  sum=sum%10;
			  res=sum+res;
			  i--;
		  }
		  if(carry==1)
			  return 1+res;
		  else
			  return res;
	  }
	  
	  public static void reorder(int[] arr) {
		    assert (arr != null);
		    if (arr.length == 0)
		      return;

		    boolean smallHead = true;

		    for (int i = 0; i < arr.length - 1; i++) {
		      if (smallHead && arr[i] > arr[i + 1] || !smallHead
		          && arr[i] < arr[i + 1]) {
		        int tmp = arr[i];
		        arr[i] = arr[i + 1];
		        arr[i + 1] = tmp;
		      }
		      smallHead = !smallHead;
		    }
		    
		    for(int i=0;i<arr.length;i++)
		    	System.out.print(arr[i]+" ");
		    System.out.println();
		  }
	  
	  public static ListNode insertionSortList(ListNode head) {
	        // IMPORTANT: Please reset any member data you declared, as
	        // the same Solution instance will be reused for each test case.
	        if(head==null||head.next==null)
	        	return head;
	        ListNode cur=head.next;
	        ListNode last=head;
	        while(cur!=null){
	        	ListNode pre=null;
	        	ListNode it=head;
	        	while(it!=cur){
	        		if(it.val<cur.val){
	        			pre=it;
	        			it=it.next;
	        		}
	        		else
	        			break;	        		
	        	}
	        	if(it!=cur){
	        		if(pre!=null){
		        		pre.next=cur;
		        	}
		        	else{
		        		head=cur;
		        	}
		        	ListNode pnext=cur.next;
		        	last.next=pnext;
		        	cur.next=it;	
		        	
		        	cur=pnext;
	        	}
	        	else{
	        		last=cur;
	        		cur=cur.next;
	        	}
	        	
	        }
	        return head;
	       
	    }
	  public static ListNode insertionSortList2(ListNode head) {
		  if(head==null||head.next==null)
			  return head;
		  ListNode dummy=new ListNode(0);
		  dummy.next=head;
		  ListNode last=head;
		  ListNode cur=head.next;
		  
		  while(cur!=null){
			  ListNode pre=dummy;
			  ListNode it=dummy.next;
			  while(it!=cur&&it.val<=cur.val){
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
	  
	  
	  public int romanToInt(String s) {
	        // Note: The Solution object is instantiated only once and is reused by each test case.
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
				char c=s.charAt(i);
				res+=sign(s,i,map)*map.get(c);
			}
			return res;
	    }
	  
	  public int sign(String s, int i, HashMap<Character, Integer> map){
		  if(i==s.length()-1)
			  return 1;
		  else if(map.get(s.charAt(i))>=map.get(s.charAt(i+1)))
			  return 1;
		  else return -1;
	  }
	  
	  public boolean equal(double x, double y)
	  {
	          return (x - y) >= -0.00000001 && (x - y) <= 0.00000001;
	  }
	  
	  
	  public int maxPointsOnLine2(Point[] points) {
		  if(points.length==0)
			  return 0;
		  if(points.length==1)
			  return 1;
		  int nMax=0;
		  
		  for(int i=0;i<points.length-1;i++){
			  HashMap<Double, Integer> map=new HashMap<Double, Integer>();
			  int nVertical=0;
			  for(int j=i+1;j<points.length;j++){
				  if(equal(points[i].x,points[j].x)){
					  nVertical++;
					  if(nVertical>nMax){
						  nMax=nVertical;
					  }
				  }
				  else{
					  double k=(double)(points[i].y-points[j].y)/(points[i].x-points[j].x);
					  if(!contains(map,k))
						  map.put(k, 1);
					  else
						  map.put(k, map.get(k)+1);
					  if(map.get(k)>nMax)
						  nMax=map.get(k);
				  }
			  }
		  }
		  return nMax;
	    }
	  
	  public boolean contains(HashMap<Double, Integer>map, double k){
		  Iterator<Double> it=map.keySet().iterator();
		  while(it.hasNext()){
			  double key=it.next();
			  if(equal(key,k))
				  return true;
		  }
		  return false;
	  }
	  
	  
	  public int maxPointsOnLine(Point[] points) {
		  if(points.length<=1)
			  return points.length;
		  double inf=Double.MAX_VALUE;
		  double alpha= 1.0e-7;
		  int nMax=0;
		  		  
		  for(int i=0;i<points.length-1;i++){
			  ArrayList<Double> slopes=new ArrayList<Double>();
			  for(int j=i+1;j<points.length;j++){
				  double diff=points[i].x-points[j].x;
				  if(Math.abs(diff)>alpha){
					  double slope=(points[i].y-points[j].y)/diff;
					  slopes.add(slope);
				  }
				  else
					  slopes.add(inf);					  
			  }
			  Collections.sort(slopes);
			  int start=0;
			  for(int k=1;k<slopes.size();k++){
				  if(Math.abs(slopes.get(k)-slopes.get(start))>alpha){
					  nMax=nMax>k-start?nMax:k-start;
					  start=k;
				  }
			  }
			  nMax=nMax>slopes.size()-start?nMax:slopes.size()-start;
		  }
		  return nMax+1;
	  }
	  
	  public boolean isInterleaving(String str1, String str2, String str3) {
		  int n1=str1.length();
		  int n2=str2.length();
		  int n3=str3.length();
		  if(n1+n2!=n3)
			  return false;
		  boolean[][] dp=new boolean[n1+1][n2+1];
		  dp[0][0]=true;
		  for(int i=1;i<=n1;i++)
			  dp[i][0]=dp[i-1][0]&&str1.charAt(i-1)==str3.charAt(i-1);
		  for(int i=1;i<=n2;i++)
			  dp[0][i]=dp[0][i-1]&&str2.charAt(i-1)==str3.charAt(i-1);
		  
		  for(int i=1;i<=n1;i++){
			  for(int j=1;j<=n2;j++){
				  dp[i][j]=dp[i-1][j]&&str1.charAt(i-1)==str3.charAt(i+j-1)||
						  dp[i][j-1]&&str2.charAt(j-1)==str3.charAt(i+j-1);
						  
			  }
		  }
		  return dp[n1][n2];
	    }
	  
	  
	  public int findMinAllOne(int a) {
		  // all the number from 0-9, only 1,3,7,9 can get last digit 1.
		  int M[] = {0,1,0,1,0,0,0,1,0,1};
		    if (a<0 || M[a%10]==0)
		    	return -1;
		  int count=1;
		  
		  for(int i=1;i>0;i%=a){
			  i=i*10+1;
			  count++;			  
		  }
		  return a==1?1:count;
	    }
	  
	  
	  public static int evaluate1(String expr) {
		  return evaluateUtil(expr,0,1);
	    }
	  
	  public static int evaluateUtil(String expr, int i, int res){
		  int number=getNumber(expr,i);
		  if(i>=expr.length())
			  return res*number;
		  if(expr.charAt(i)=='*')
			  return evaluateUtil(expr,i+1,res*number);
		  else
			  return res*number+evaluateUtil(expr,i+1,expr.charAt(i)=='+'?1:-1);

	  }
	  
	  public static int getNumber(String expr, int i){
		  int res=0;
		  
		  while(i<expr.length()&&expr.charAt(i)>='0'&&expr.charAt(i)<='9'){
			  res=res*10+(expr.charAt(i)-'0');
			  i++;
		  }
		  
		  return res;
	  }
	  
	  static int evaluate(String expr) {
		    int res = 0;
		    int  N = expr.length();
		    int n = 1;
		    for (int i = 0; i < N; ++i)
		    {
		        int number = getNumber(expr, i);
		        n *= number;
		        if (i == N) res += n;
		        else if (expr.charAt(i) == '+') {res += n; n = 1; }
		        else if (expr.charAt(i) == '-') {res += n; n = -1; }
		    }
		    return res;
		}
	  
	   public static int[] arrayUnion(int[] a, int[] b) {
		   int n1=a.length;
		   int n2=b.length;
		   int[] res=new int[n1+n2];
		   int k=0;
		   int i=0,j=0;
		   
		   while(i<n1||j<n2){
			   int value=0;
			   if(i==n1)
				   value=b[j++];
			   else if(j==n2)
				   value=a[i++];
			   else
				   value=a[i]<b[j]?a[i++]:b[j++];
				   
				if(k==0||res[k-1]!=value)
					res[k++]=value;
		   }
	
		   int[] ans=new int[k];
		   for(i=0;i<k;i++){
			   ans[i]=res[i];
//			   System.out.print(ans[i]+" ");
		   }
//		   System.out.println(ans.length);
		   return ans;
	    }

	    public static int[] arrayIntersect(int[] a, int[] b) {
	    	int n1=a.length;
	    	int n2=b.length;
	    	int n=n1<n2?n1:n2;
	    	int[] res=new int[n];
	    	
	    	int i=0,j=0,k=0;
	    	while(i<n1&&j<n2){
	    		if(a[i]==b[j]){
	    			if (k == 0 || res[k-1] != a[i])
	                    res[k++] = a[i];
	                i++;
	                j++;
	    		}
	    		else if(a[i]<b[j])
	    			i++;
	    		else
	    			j++;
	    	}
	    	
	    	int[] ans=new int[k];
	    	for(i=0;i<k;i++){
	    		ans[i]=res[i];
	    		System.out.print(ans[i]+" ");
	    	}
	    	return ans;
	    }
	    
	    
	    class stringComparator implements Comparator<String>{

			@Override
			public int compare(String s1, String s2) {
				// TODO Auto-generated method stub
				return (s1+s2).compareTo((s2+s1))<0?1:-1;
			}
	    	
	    }
	    
	    
	    public String biggestNum(String[] nums) {
	    	Arrays.sort(nums, new stringComparator());
	    	String res="";
	    	for(int i=0;i<nums.length;i++)
	    		res+=nums[i];
	    	return res;
	    }
	  
	    
	    public boolean exists(char[][] grid, String pattern) {
	    	int m=grid.length;
	    	int n=grid[0].length;
	    	
	    	boolean[][] used=new boolean[m][n];
	    	for(int i=0;i<grid.length;i++){
	    		for(int j=0;j<grid[0].length;j++){
	    			if(grid[i][j]==pattern.charAt(0)){
	    				if(dfs(grid,i,j,pattern, used, 0))
	    					return true;
	    			}
	    		}
	    	}
	    	return false;
	    }
	    
	    public boolean dfs(char[][]grid, int i, int j, String pattern, boolean[][] used, int cur){
	    	if(cur==pattern.length())
	    		return true;
	    	if(i>=0&&i<grid.length&&j>=0&&j<grid[0].length&&grid[i][j]==pattern.charAt(cur)&&!used[i][j]){
	    		used[i][j]=true;
	    		boolean res=dfs(grid,i+1,j,pattern,used, cur+1)||
	    				dfs(grid,i-1,j,pattern,used,cur+1)||
	    				dfs(grid,i,j+1,pattern,used,cur+1)||
	    				dfs(grid,i,j-1,pattern,used,cur+1);
	    		if(res)
	    			return true;
	    		else{
	    			used[i][j]=false;
	    		}
	    	}
	    	return false;
	    	
	    }
	    
	    public class intervalComparator implements Comparator<Interval>{

			@Override
			public int compare(Interval o1, Interval o2) {
				// TODO Auto-generated method stub
				return o1.start-o2.start;
			}
	    	
	    }
	    
	    public void intersected(Interval[] intervals, boolean[] isIntersected) {
	    	if(intervals.length<2)
	    		return;
	    	
	    	HashMap<Interval,Integer> map=new HashMap<Interval,Integer>();
	    	for(int i=0;i<intervals.length;i++)
	    		map.put(intervals[i],i);
	    	Arrays.sort(intervals,new intervalComparator());
	    	
	    	int pre=0;
	    	int end=intervals[pre].end;
	    	for(int i=1;i<intervals.length;i++){
	    		Interval cur=intervals[i];
	    		if(cur.start<=end){
	    			isIntersected[map.get(intervals[pre])]=true;
	    			isIntersected[map.get(intervals[i])]=true;
	    		}
	    		if(end<cur.end){
	    			end=cur.end;
	    			pre=i;
	    		}
	    		
//	    		end=Math.max(end, cur.end);
//	    		if(end==pre=i;
	    	}
	    	
	    }
	    
	    public void mergeSortedArray(int[] arr1, int[] arr2, int n, int m) {
	    	int i=n-1;
	    	int j=m-1;
	    	int k=m+n-1;
	
	    	while(i>=0&&j>=0){
	    		if(arr1[i]>=arr2[j])
	    			arr1[k--]=arr1[i--];
	    		else
	    			arr1[k--]=arr2[j--];
	    	}
	    	while(j>=0)
	    		arr1[k--]=arr2[j--];
	    }
	    
	    //将十进制数转换为excel数
	    public static String decToExcel(int decNum) {
	    	String res="";
	    	while(decNum>0){
	    		decNum--;
	    		char c=(char) ('A'+decNum%26);
	    		res=c+res;
	    		decNum/=26;
	    	}
	    	return res;
	    }
	    //将excel数转换为十进制数
	    public int excelToDec(String excelNum) {
	    	int res=0;
	    	for(int i=0;i<excelNum.length();i++){
	    		res=res*26+(excelNum.charAt(i)-'A'+1);
	    	}
	    	return res;
	    }
	    
	    public static List<String> transform(Set<String> dict, String from, String to) {
	    	Queue<String> que=new LinkedList<String>();
	    	HashSet<String> visited=new HashSet<String>();
	    	
	    	HashMap<String, String> backtrack=new HashMap<String, String>();
	    	que.add(from);
	    	visited.add(from);
	    	
	    	while(!que.isEmpty()){
	    		String str=que.remove();
	    		
	    		Set<String> neighbors=editOneWord(str,dict);
	    		for(String s:neighbors){
	    			if(s.equals(to)){
	    				//find the word, backtrack
	    				List<String> res=new ArrayList<String>();
	    				res.add(to);
	    				while(str!=null){
	    					res.add(0, str);
	    					str=backtrack.get(str);
	    				}
	    				return res;
	    			}
//	    			if(dict.contains(s)){
	    				if(!visited.contains(s)){
	    					que.add(s);
	    					visited.add(s);
	    					backtrack.put(s, str);	    					
	    				}
//	    			}
	    		}
	    		
	    	}
//	    	List<String> res=new  ArrayList<String>();
//	    	res.add(from);
	    	return new  ArrayList<String>();
	    }
	    
	    public static Set<String> editOneWord(String s, Set<String> dict){
	    	Set<String> res=new  HashSet<String>();
	    	
	    	char[] chs=s.toCharArray();
	    	for(int i=0;i<chs.length;i++){
	    		char c=chs[i];
	    		for(char ch='A';ch<='Z';ch++){
	    			if(c!=ch){
	    				chs[i]=ch;
	    				String word=new String(chs);
	    				if(dict.contains(word))
	    					res.add(word);	    				
	    			}
	    		}
	    		chs[i]=c;
	    	}
	    	return res;
	    }
	    
	    public static ListNode sortList2(ListNode head) {
	        // IMPORTANT: Please reset any member data you declared, as
	        // the same Solution instance will be reused for each test case.
	        if(head==null||head.next==null)
	        	return head;
	        ListNode fast=head;
	        ListNode slow=head;
	        
	        while(fast!=null){
	        	fast=fast.next;
	        	if(fast!=null)
	        		fast=fast.next;
	        	if(fast==null)
	        		break;
	        	slow=slow.next;
	        }
//	        while(fast.next!=null&&fast.next.next!=null){
//	  			slow=slow.next;
//	  			fast=fast.next.next;
//	  		}	  
	        ListNode secondHalf=slow.next;
	        slow.next=null;
	        return mergeList2(sortList2(head),sortList2(secondHalf));
	    }
	    
	    public static ListNode mergeList2(ListNode head1, ListNode head2){
	    	if(head1==null||head2==null)
	    		return head1==null?head2:head1;
	    	
	    	ListNode dummy=new ListNode(0);
	    	ListNode cur=dummy;
	    	ListNode cur1=head1;
	    	ListNode cur2=head2;
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
	    
	    public static double maxDistance(int n, int fuel){
	    	double distance_covered=0;
	    	
	    	while(n>0){
	    		// after ever fuel/n km we are discarding one bike and filling 
	            // all the other bikes with fuel/n liters of fuel i.e. to their
	            // maximum limit (100 litre)
	     
	    		distance_covered+=(double)fuel/n;
	    		n--;//drop one bike
	    	}
	    	
	    	return distance_covered;
	    }
	    
	    
	    public static int minChange(String s) {
	    	int n=s.length();
	    	if(n<2)
	    		return 0;
	    	int[] countABackward=new int[n+1];
	    	countABackward[n]=0;
	    	for(int i=n-1;i>=0;i--){
	    		countABackward[i]=s.charAt(i)=='a'?countABackward[i+1]+1:countABackward[i+1];
	    	}
	    	
	    	int countBForward=0;
	    	int  min=countABackward[0];
	    	
	    	for(int i=0;i<n;i++){
	    		if(s.charAt(i)=='b')
	    			countBForward++;
	    		
	    		if(countBForward+countABackward[i+1]<min)
	    			min=countBForward+countABackward[i+1];
	    	}
	    	return min;
	    }
	    
	    public static boolean isCompleteTree(TreeNode root){
	    	if(root==null)
	    		return true;
	    	Queue<TreeNode> que=new LinkedList<TreeNode>();
	    	que.add(root);
	    	boolean flag=false;
	    	
	    	while(!que.isEmpty()){
	    		TreeNode top=que.remove();
	    		if(top.left!=null){
	    			if(flag)
	    				return false;
	    			else
	    				que.add(top.left);
	    		}
	    		else
	    			flag=true;
	    		if(top.right!=null){
	    			if(flag)
	    				return false;
	    			else
	    				que.add(top.right);
	    		}
	    		else
	    			flag=true;
	    	}
	    	return true;
	    }
	  
	    public static String makeWordBold(String sentence, String[] terms){
	    	if(sentence.length()==0)
	    		return "";
	    	String res="";
//	    	sentence=sentence.toLowerCase();
	    	StringBuilder s=new StringBuilder();
	    	for(int i=0;i<sentence.length();i++){
	    		char c=sentence.charAt(i);
	    		if(Character.isLetterOrDigit(c))
	    			s.append(c);
	    		else{
	    			System.out.println(s);
	    			if(contains(terms,s)){
	    				System.out.println("??");
	    				res+="<b>"+s+"</b>";
	    			}
	    			else{
	    				res+=s;
	    			}
	    			res+=c;
	    			s=new StringBuilder();
	    		}	    			
	    	}
	    	return res;
	    }
	    
	    public static boolean contains(String[] terms, StringBuilder s){
	    	String string=s.toString();
	    	for(String str:terms){
	    		if(str.equals(string)){
	    			return true;
	    		}
	    	}
	    	return false;
	    }
	    
	    
	    public static TreeNode buidTreeFromArray(int[] arr){
	    	return buidTreeFromArrayUtil(arr, 0, arr.length-1);
	    }
	    
	    public static TreeNode buidTreeFromArrayUtil(int[]arr, int start, int end){
	    	if(start>end)
	    		return null;
	    	int left=2*start+1;
	    	int right=2*start+2;
//	    	if(left>end||right>end)
//	    		return null;
	    	TreeNode root=new TreeNode(arr[start]);
	    	root.left=buidTreeFromArrayUtil(arr,left,end);
	    	root.right=buidTreeFromArrayUtil(arr,right,end);
	    	
//	    	buidTreeFromArrayUtil(arr,left,end);
//	    	buidTreeFromArrayUtil(arr,right,end);
	    	return root;
	    }
	    
	    public static void countSorting(int[] A){
	    	if(A.length<2)
	    		return;
	    	int max=A[0];
	    	for(int i=1;i<A.length;i++){
	    		max=A[i]>max?A[i]:max;
	    	}
	    	
	    	int[] count=new int[max+1];
	    	
	    	for(int i=0;i<A.length;i++)
	    		count[A[i]]++;
	    	
	    	for(int i=1;i<=max;i++)
	    		count[i]+=count[i-1];
	    	
	    	int[] res=new int[A.length];
	    	
	    	for(int i=0;i<A.length;i++){
	    		res[count[A[i]]-1]=A[i];
	    		count[A[i]]--;
	    	}
	    	
	    	for(int i=0;i<A.length;i++)
	    		A[i]=res[i];
	    		
//	    	for(int i=0,j=0;i<max;i++){
//	    		for(int k=count[i];k>0;k--)
//	    			A[j++]=i;
//	    	}
//	    	
	    	for(int i=0;i<A.length;i++)
	    		System.out.print(A[i]+" ");
	    	System.out.println();
	    		
	    }
	    
	    public static TreeNode flipDown(TreeNode root){
	    	if(root==null)
	    		return null;
	    	if(root.left==null&&root.right==null)
	    		return root;
	    	TreeNode node=flipDown(root.left);
	    	
	    	root.left.left=root.right;
	    	root.left.right=root;
	    	root.left=root.right=null;
	    	
	    	return node;
	    }
	    
	    public static TreeNode flipDown2(TreeNode root){
	    	if(root==null)
	    		return null;
	    	if(root.left==null&&root.right==null)
	    		return root;
	    	flipDown2(root.left);
//	    	TreeNode node=root.right;
//	    	root.right=null;
//	    	flipDown2(root.left);
	    	root.left.right=root.right;
	    	root.right=null;
	    	return root;
	    	
//	    	return root;
	    }
	    
	    
	    public static boolean colinear(Point p1, Point p2, Point p3){
	    	return (p1.y-p2.y)*(p1.x-p3.x)==(p1.y-p3.y)*(p1.x-p2.x);
	    }
	    
	    //Check if all points are the same
	    public boolean allSamePoints(Point[] points){
	        int i=0;
	        while(i<points.length){
	            if(points[i].x!=points[0].x || points[i].y!=points[0].y)
	                break;
	            i++;
	        }
	        return i==points.length;
	    }
	    
	public int maxPoints(Point[] points) {
		// IMPORTANT: Please reset any member data you declared, as
		// the same Solution instance will be reused for each test case.
		if (points.length <= 1 || allSamePoints(points))
			return points.length;

		int best = 2;
		for (int i = 0; i < points.length; ++i) {
			for (int j = i + 1; j < points.length; j++) {
				if (points[i].x == points[j].x && points[i].y == points[j].y)
					continue;
				int count = 2;
				for (int k = 0; k < points.length; ++k) {
					if (k == i || k == j)
						continue;
					if (colinear(points[i], points[j], points[k]))
						count++;
				}
				best = Math.max(best, count);
			}
		}
		return best;
	}
	
	public static void printTreeBracket(TreeNode root){
		if(root==null)
			return;
		System.out.print(root.val);
		if(root.left!=null||root.right!=null){
			System.out.print("(");
			printTreeBracket(root.left);
			if(root.right!=null)
				System.out.print(",");
			printTreeBracket(root.right);
			System.out.print(")");
		}
		
	}
	
	 public boolean isValidSudoku(char[][] board) {
	        // Start typing your Java solution below
	        // DO NOT write main() function
	        //check rows
		 
		 for(int i=0;i<9;i++){
			 boolean[] checker=new boolean[10];
			 for(int j=0;j<9;j++){
				 char c=board[i][j];
				 if(c=='.')
					 continue;
				 int num=c-'0';
				 if(num>=1&&num<=9){
					 if(checker[num])
						 return false;
					 else
						 checker[num]=true;
				 }				
			 }
		 }
		 
		 //check cols
		 
		 for(int i=0;i<9;i++){
			 boolean[] checker=new boolean[10];
			 for(int j=0;j<9;j++){
				 char c=board[j][i];
				 if(c=='.')
					 continue;
				 int num=c-'0';

				 if(num>=1&&num<=9){
					 if(checker[num])
						 return false;
					 else
						 checker[num]=true;
				 }
			 }
		 }
		 
		 // check grid
		 for(int i=0;i<9;i+=3){
			 for(int j=0;j<9;j+=3){
				 boolean checker[]=new boolean[10];
				 for(int k=0;k<3;k++){
					 for(int l=0;l<3;l++){
						 char c=board[i+k][j+l];
						 if(c=='.')
							 continue;
						 int num=c-'0';
						 if(num>=1&&num<=9){
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
	 
	 public static void leftViewofBT(TreeNode root){
		 if(root==null)
			 return;
		 int[] max={0};
		 leftViewofBTUtil(root,1, max);
	 }
	 
	 public static void leftViewofBTUtil(TreeNode root, int level, int[] max){
		 if(root==null)
			 return;
		 if(level>max[0]){
			 System.out.print(root.val+" ");
			 max[0]=level;
		 }
		 leftViewofBTUtil(root.left,level+1,max);
		 leftViewofBTUtil(root.right,level+1,max);
	 }
	 
	
	 public static ListNode addThreeNumber(ListNode head1, ListNode head2, ListNode head3){
		 ListNode node=addTwoNumber(head1,head2);
		 ListNode head=addTwoNumber(node,head3);
		 return head;
		 
	 }
	 
	 public static ListNode addTwoNumber(ListNode head1, ListNode head2){
		 if(head1==null||head2==null)
			 return head1==null?head2:head1;
		 
		 ListNode cur1=head1;
		 ListNode cur2=head2;
		 int carry=0;
		 ListNode last=null;
		 
		 Stack<ListNode> stk1=new Stack<ListNode>();
		 Stack<ListNode> stk2=new Stack<ListNode>();
		 
		 while(cur1!=null){
			 stk1.push(cur1);
			 cur1=cur1.next;
		 }
		 
		 while(cur2!=null){
			 stk2.push(cur2);
			 cur2=cur2.next;
		 }
		 
		 while(!stk1.isEmpty()&&!stk2.isEmpty()){
			 int sum=stk1.pop().val+stk2.pop().val+carry;
			 carry=sum/10;
			 sum=sum%10;
			 ListNode node=new ListNode(sum);
			 if(last==null)
				 last=node;
			 else{
				 node.next=last;
				 last=node;
			 }
		 }
		 
		 while(!stk1.isEmpty()){
			 int sum=stk1.pop().val+carry;
			 carry=sum/10;
			 sum=sum%10;
			 ListNode node=new ListNode(sum);
			 node.next=last;
			 last=node;
		 }
		 
		 while(!stk2.isEmpty()){
			 int sum=stk2.pop().val+carry;
			 carry=sum/10;
			 sum=sum%10;
			 ListNode node=new ListNode(sum);
			 node.next=last;
			 last=node;
		 }
		 
//		 while(cur1!=null&&cur2!=null){
//			 int sum=cur1.val+cur2.val+carry;
//			 carry=sum/10;
//			 sum=sum%10;
//			 ListNode node=new ListNode(sum);
//			 pre.next=node;
//			 pre=pre.next;
//			 cur1=cur1.next;
//			 cur2=cur2.next;
//		 }
//		 
//		 while(cur1!=null){
//			 int sum=cur1.val+carry;
//			 carry=sum/10;
//			 sum=sum%10;
//			 ListNode node=new ListNode(sum);
//			 pre.next=node;
//			 pre=pre.next;
//			 cur1=cur1.next;			 
//		 }
//		 while(cur2!=null){
//			 int sum=cur2.val+carry;
//			 carry=sum/10;
//			 sum=sum%10;
//			 ListNode node=new ListNode(sum);
//			 pre.next=node;
//			 pre=pre.next;
//			 cur2=cur2.next;			 
//		 }
		 
		 if(carry==1){
			 ListNode node=new ListNode(1);
			 node.next=last;
			 last=node;
		 }
		 
		 return last;
	 }
	 
	 public static void connectRight(TreeLinkNode root){
		 if(root==null)
			 return;
		 root.next=null;
		 connectRightUtil(root);		 
	 }
	 
	 public static void connectRightUtil(TreeLinkNode root){
		 if(root==null)
			 return;
		 if(root.next!=null)
			 connectRightUtil(root.next);
		 
		 if(root.left!=null){
			 if(root.right!=null){
				 root.left.next=root.right;
				 root.right.next=getNextRight(root);
			 }
			 else
				 root.left.next=getNextRight(root);
			 
			 connectRightUtil(root.left);
		 }
		 else if(root.right!=null){
			 root.right.next=getNextRight(root);
			 connectRightUtil(root.right);
		 }
		 else
			 connectRightUtil(getNextRight(root));
	 }
	 
	 public static TreeLinkNode getNextRight(TreeLinkNode root){
		 if(root==null)
			 return null;
		 TreeLinkNode t=root.next;
		 while(t!=null){
			 if(t.left!=null)
				 return t.left;
			 if(t.right!=null)
				 return t.right;
			 t=t.next;
				 
		 }
		 return null;
	 }
	 
	 public void connectRight2(TreeLinkNode root){
		 if(root==null)
			 return;
		 root.next=null;
		 TreeLinkNode cur=root;
		 while(cur!=null){
			 TreeLinkNode t=cur;
			 while(t!=null){
				 if(t.left!=null){
					 if(t.right!=null){
						 t.left.next=t.right;
						 t.right.next=getNextRight(t);
					 }
					 else
						 t.left.next=getNextRight(t);
				 }
				 else if(t.right!=null){
					 t.right.next=getNextRight(t);
				 }
				 t=t.next;
			 }
			 if(cur.left!=null)
				 cur=cur.left;
			 else if(cur.right!=null)
				 cur=cur.right;
			 else
				 cur=getNextRight(cur);
			 
		 }
	 }
	 
	 public static TreeLinkNode getNextRight2(TreeLinkNode root){
		 if(root==null)
			 return null;
		 TreeLinkNode cur=root.next;
		 while(cur!=null){
			 if(cur.left!=null)
				 return cur.left;
			 if(cur.right!=null)
				 return cur.right;
			 cur=cur.next;
		 }
		 return null;
	 }
	 
	 
//	 static int maxLength=0;
	 public static int longestPathOneBend(TreeNode root){
		 if(root==null)
			 return 0;
		 int rootatMid=getLeftLength(root.left)+getRightLength(root.right)+1;
		 int rootandright=1+getLeftLength(root.right);
		 int rootandleft=1+getRightLength(root.left);
		 int maxLength=Math.max(Math.max(rootandright,rootandleft),rootatMid);
		 
		 
//		 int maxLength=getLeftLength(root.left)+getRightLength(root.right)+1;
		 int left=longestPathOneBend(root.left);
		 int right=longestPathOneBend(root.right);
		 
		 return Math.max(Math.max(left, right),maxLength);
	 }
	 
	 public static int getLeftLength(TreeNode root){
		 if(root==null)
			 return 0;
		 TreeNode cur=root;
		 int length=0;
		 
		 while(cur!=null){
			 length++;
			 cur=cur.left;
		 }
		 return length;
	 }
	 
	 public static int getRightLength(TreeNode root){
		 if(root==null)
			 return 0;
		 TreeNode cur=root;
		 int length=0;
		 
		 while(cur!=null){
			 length++;
			 cur=cur.right;
		 }
		 return length;
	 }
	 
	 static TreeNode parent = null;
	 public static ArrayList<Integer> findCousins(TreeNode root, int key){
		 ArrayList<Integer> res=new ArrayList<Integer>();
		 if(root==null)
			 return res;
		 
		 int[] level={0};
		 TreeNode p=findLevelandParent(root, key, 0,level, parent);
		 if(p==null||level[0]==1)
			 return res;
//		 System.out.print(parent+" yuan");
		 findCousins(root, 0,level, p,res);
		 return res;
	 }
	 
	 public static void findCousins(TreeNode root, int curLevel, int[] level,TreeNode parent, ArrayList<Integer> res){
//		 if(root!=null){
//					 
//		 if(root!=parent){
//			 findCousins(root.left,curLevel+1,level,parent, res);
//			 if(curLevel==level[0])
//				 res.add(root.val);
//		 }
//		 if(root!=parent){
//			 findCousins(root.right,curLevel+1,level,parent, res);
////			 if(curLevel==level[0])
////				 res.add(root.val);
//		 }
//		 }
		if(root==null)
			return;
		if(curLevel==level[0]&&(root!=parent.left&&root!=parent.right)){
			res.add(root.val);
		}
		 findCousins(root.left,curLevel+1,level,parent, res);
		 findCousins(root.right,curLevel+1,level,parent, res);
	 }
	 
	 public static TreeNode  findLevelandParent(TreeNode root, int key , int curlevel, int[] level, TreeNode parent){
		 if(root==null)
			 return null;
		 if(root.val==key){
			 level[0]=curlevel;
			 return parent;
		 }
		 
//		 System.out.println(parent);
		 parent=root;
//		 level[0]++;
		 TreeNode left=findLevelandParent(root.left,key,curlevel+1,level,parent);
		 if(left!=null)
			 return left;
		 
		 return findLevelandParent(root.right,key,curlevel+1,level,parent);
//		 return null;
		 
	 }
	 
	 static TreeNode res=null;
	 public static TreeNode deepestLeftLeaf(TreeNode root){
		 if(root==null)
			 return null;
		 	
		 TreeNode[] res=new TreeNode[1];
		 int[] level={0};
		 deepestLeftLeaf(root,0,level, res, parent);
		 return res[0];
	 }
	 
	 public static void deepestLeftLeaf(TreeNode root, int curlevel, int[] level, TreeNode[] res, TreeNode parent){
		 if(root==null)
			 return ;
		 if(root.left==null&&root.right==null&&parent.left==root&&curlevel>level[0]){
			 level[0]=curlevel;
			 res[0]=root;
			 return;
		 }
		 parent=root;
		 
		deepestLeftLeaf(root.left, curlevel+1, level,res, parent);
		deepestLeftLeaf(root.right,curlevel+1, level,res, parent);
	 }
	    
	 
	 public static int depthOfOddLeaf(TreeNode root){
		 return depthOfOddLeaf(root,0);
	 }
	 
	 public static int depthOfOddLeaf(TreeNode root, int level){
		 if(root==null)
			 return 0;
		 if(root.left==null&&root.right==null&&level%2==1)
			 return level;
		 return Math.max(depthOfOddLeaf(root.left,level+1), depthOfOddLeaf(root.right,level+1));
	 }
	 
	 
//	 static TreeNode res=null;
//	 public static TreeNode deepestLeftLeaf(TreeNode root){
//		 if(root==null)
//			 return null;
//		 
//		 TreeNode[] res= new TreeNode[1];		 	
//		 int[] maxlevel={0};
//		 deepestLeftLeaf(root,0,maxlevel,false, res);
//		 return res[0];
//	 }
//	 
//	 public static void deepestLeftLeaf(TreeNode root, int curlevel, int[] maxlevel, boolean isLeft,TreeNode[] res){
//		 if(root==null)
//			 return ;
//		 if(root.left==null&&root.right==null&&isLeft&&curlevel>maxlevel[0]){
//			 maxlevel[0]=curlevel;
//			 res[0]=root;
//			 return;
//		 }
//		 
//		deepestLeftLeaf(root.left, curlevel+1, maxlevel, true,res);
//		deepestLeftLeaf(root.right,curlevel+1, maxlevel, false,res);
//	 }
	 
	 
	 public static int evalRPN(String[] tokens) {
	        if(tokens.length==0)
	        	return 0;
	        Stack<Integer> stk=new Stack<Integer>();
//	        int res=0;
	        int i=0;
	        while(i<tokens.length){
	        	String s=tokens[i];
	        	switch(s){
	        	case "+":
	        		int num1=stk.pop();
	        		int num2=stk.pop();
	        		int sum=num1+num2;
	        		stk.push(sum);
	        		break;
	        	case "-":
	        		num1=stk.pop();
	        		num2=stk.pop();
	        		int dif=num2-num1;
	        		stk.push(dif);
	        		break;
	        	case "*":
	        		num1=stk.pop();
	        		num2=stk.pop();
	        		int prod=num1*num2;
	        		stk.push(prod);
	        		break;
	        	case "/":
	        		num1=stk.pop();
	        		num2=stk.pop();
	        		int div=num2/num1;
	        		stk.push(div);
	        		break;
	        	default:
	        		int num=Integer.parseInt(s);
	        		stk.push(num);
	        		break;
	        			
	        	}
	        	i++;
	        }
	        return stk.pop();
	    }
	 
	 
	 
	 public static int evalRPN2(String[] tokens) {
	        if(tokens.length==0)
	        	return 0;
	        Stack<Integer> stk=new Stack<Integer>();
//	        int res=0;
	        int i=0;
	        while(i<tokens.length){
	        	String s=tokens[i];
	        	if(!s.equals("+")&&!s.equals("-")&&!s.equals("*")&&!s.equals("/")){
	        		int num=Integer.parseInt(s);
	        		stk.push(num);
	        	}
	        	else{
	        		int res;
	        		int num1=stk.pop();
	        		int num2=stk.pop();
	        		if(s.equals("+"))
	        			res=num1+num2;
	        		else if(s.equals("-"))
	        			res=num2-num1;
	        		else if(s.equals("*"))
	        			res=num1*num2;
	        		else
	        			res=num2/num1;
	        		stk.push(res);
	        	}
//	        	if(s.equals("+")){
//	        		int num1=stk.pop();
//	        		int num2=stk.pop();
//	        		int sum=num1+num2;
//	        		stk.push(sum);
//	        	}
//	        	else if(s.equals("-")){
//	        		int num1=stk.pop();
//	        		int num2=stk.pop();
//	        		int dif=num2-num1;
//	        		stk.push(dif);
//	        	}
//	        	else if(s.equals("*")){
//	        		int num1=stk.pop();
//	        		int num2=stk.pop();
//	        		int prod=num1*num2;
//	        		stk.push(prod);
//	        	}
//	        	else if(s.equals("/")){
//	        		int num1=stk.pop();
//	        		int num2=stk.pop();
//	        		int div=num2/num1;
//	        		stk.push(div);
//	        	}
//	        	else{
//	        		int num=Integer.parseInt(s);
//	        		stk.push(num);
//	        	}
	        	i++;
	        }
//	        System.out.println(stk.size());
	        return stk.pop();
	    }
	 
	 
	 public static boolean isPalindrome(ListNode head){
		 if(head==null)
			 return true;
		 ListNode head2=reverseListUtil(head);
		 
		 while(head!=null&&head2!=null){
			 if(head.val!=head2.val)
				 return false;
			 head=head.next;
			 head2=head2.next;
		 }
		 return true;
	 }
	 
	 public static ListNode reverseListUtil(ListNode head){
		 if(head==null||head.next==null)
			 return head;
		 
		 ListNode dummy=new ListNode(0);
		 dummy.next=head;
		 
		 ListNode pre=dummy;
		 ListNode last=head;
		 ListNode cur=head.next;
		 
		 while(cur!=null){
			 last.next=cur.next;
			 cur.next=pre.next;
			 pre.next=cur;
			 cur=last.next;
		 }
		 return dummy.next;
	 }
	 
	 public static boolean isBST(TreeNode root){
		 if(root==null)
			 return true;
		 return isBST(root, Integer.MIN_VALUE,Integer.MAX_VALUE);
	 }
	 
	 public static boolean isBST(TreeNode root, int leftmost, int rightmost){
		 if(root==null)
			 return true;
		 if(root.val<=leftmost||root.val>rightmost)
			 return false;
		 return isBST(root.left,leftmost,root.val)&&isBST(root.right,root.val,rightmost);
	 }
	 
	 public static boolean isSameLevel(TreeNode root){
		 int[] leafLevel={0};
		 return  isSameLevel(root, 0,leafLevel);
	 }
	 
	 public static boolean isSameLevel(TreeNode root, int curLevel, int[] leafLevel){
		 if(root==null)
			 return true;
		 if(root.left==null&&root.right==null){
			 if(leafLevel[0]==0){
				 leafLevel[0]=curLevel;
//				 return true;
			 }
			 return curLevel==leafLevel[0];
		 }
		 
		 return isSameLevel(root.left,curLevel+1,leafLevel)&&
				 isSameLevel(root.right,curLevel+1,leafLevel);
	 }
	 
	 
	 public double findMedianSortedArrays(int A[], int B[]) {
	        // Note: The Solution object is instantiated only once and is reused by each test case.
	        int n1=A.length;
	        int n2=B.length;
	        int n=n1+n2;
	        if(n%2==0)
	        	return (findKth(A,0,n1,B,0,n2,n/2)+
	        			findKth(A,0,n1,B,0,n2,n/2+1))/2.0;
	        else
	        	return findKth(A,0,n1,B,0,n2,n/2+1);
	    }
	 
	 public double findKth(int[] A,int aoffset, int m, int[] B,int boffset, int n, int k){
		 if(m>n)
			 return findKth(B,boffset,n, A, aoffset,m,k);
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
	 
	 public boolean isMatch(String s, String p) {
	        // Note: The Solution object is instantiated only once and is reused by each test case.
	        if(s.length()==0)
	        	return allstar(p);
	        if(p.length()==0)
	        	return false;
	        char s1=s.charAt(0);
	        char p1=p.charAt(0);
	        
	        char p2 = 0;
	        if(p.length()>1)
	        	p2=p.charAt(1);
	        
	        if(p2=='*'){
	        	if(s1==p1||p1=='.')
	        		return isMatch(s.substring(1),p)||isMatch(s,p.substring(2));
	        	else
	        		return isMatch(s,p.substring(2));
	        }
	        else{
	        	if(s1==p1||p1=='.')
	        		return isMatch(s.substring(1),p.substring(1));
	        	else
	        		return false;
	        }
	    }
	 
	 public boolean allstar(String p){
		 if(p.length()%2==1)
			 return false;
		 for(int i=1;i<p.length();i+=2){
			 if(p.charAt(i)!='*')
				 return false;
		 }
		 return true;
	 }
	 
	 
	 public int largestRectangleArea(int[] height) {
	        // Note: The Solution object is instantiated only once and is reused by each test case.
	        if(height.length==0)
	        	return 0;
	        
	        Stack<Integer> stk=new Stack<Integer>();
	        int[] h=new int[height.length+1];
	        h=Arrays.copyOf(height, height.length+1);
	        int max=0;
	        int i=0;
	        while(i<h.length){
	        	if(stk.isEmpty()||h[stk.peek()]<=h[i])
	        		stk.push(i++);
	        	else{
	        		int top=stk.pop();
	        		max=Math.max(max, h[top]*(stk.isEmpty()?i:i-stk.peek()-1));
	        	}
	        }
	        return max;
	    }
	 
	 
	 public void flattenPrac(TreeNode root) {
		 if(root==null)
			 return;
		 TreeNode left=root.left;
		 TreeNode right=root.right;
		 
		 flattenPrac(root.left);
		 root.left=null;
		 root.right=left;
		 
		 TreeNode cur=root;
		 while(cur.right!=null)
			 cur=cur.right;
		 cur.right=right;
		 flattenPrac(right);
	 }
	 
	 public static int secondBiggest(int[] A){
		 if(A.length<2)
			 return Integer.MIN_VALUE;
		 int max=A[0];
		 int index=-1;
		 for(int i=1;i<A.length;i++){
			 if(A[i]>max){
				 max=A[i];
				 index=i;
			 }
		 }
		 
		 int dif=Integer.MAX_VALUE;
		 int idx=-1;
		 
		 for(int i=0;i<A.length;i++){
			 if(i!=index){
				 if(max-A[i]<dif){
					 dif=max-A[i];
					 idx=i;
				 }
			 }
		 }
		 return A[idx];
	 }
	 
	 
	 public void setZeroes2(int[][] matrix) {
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
		 
		 if(fr){
			 for(int i=0;i<n;i++)
				 matrix[0][i]=0;
		 }
		 
		 if(fc){
			 for(int i=9;i<m;i++)
				 matrix[i][0]=0;
		 }
	 }
	 
	 
	 public static void findAllFactors(int n){
		 if(n<=0)
			 return;
		 System.out.print(1+" ");
		 System.out.print(n+" ");
		 for(int i=2;i<=Math.sqrt(n);i++){
			 if(n%i==0){
				 System.out.print(i+" ");
				 System.out.print(n/i+" ");
			 }
		 }
	 }
	 
	 public static RandomListNode cloneList(RandomListNode head){
		 if(head==null)
			 return null;
		 RandomListNode cur=head;
		 while(cur!=null){
			 RandomListNode copy=new RandomListNode(cur.label);
			 RandomListNode pnext=cur.next;
			 cur.next=copy;
			 copy.next=pnext;
			 cur=pnext;
		 }
		 
		 cur=head;
		 while(cur!=null){
			 if(cur.random!=null)
				 cur.next.random=cur.random.next;
			 cur=cur.next.next;
		 }
		 
		 RandomListNode coloneHead=head.next;
		 cur=head;
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
	 
	 
	 public static void dfsTraverse(TreeNode root){
		 if(root==null)
			 return;
		 int h=getHeight(root);
		 for(int i=1;i<=h;i++){
			 dfsTraversal(root,i);
			 System.out.println();
		 }
		 
	 }
	 
	 public static void dfsTraversal(TreeNode root, int level){
		 if(root==null)
			 return;
		 if(level==1)
			 System.out.print(root.val+" ");
		 else{
			 dfsTraversal(root.left,level-1);
			 dfsTraversal(root.right,level-1);
		 }
		 			 
	 }
	 
	 public int[] sortDistinctIntegers(int[] a, int min, int max){  
         int N = (max-min) / 8 + 1;  
         byte[] bitmap = new byte[N]; //initialized to 0  
           
         for(int i = 0; i < a.length; i++)  
              bitmap[a[i]/8] |= 1 << (a[i] % 8);  
           
         int k = 0;  
         for(int i = 0; i < N; i++){  
              for(int j = 0; j < 8; j++){  
                   if((bitmap[i] & (1 << j)) > 0){  
                        a[k] = i * 8 + j + min;  
                        k++;  
                   }  
              }  
         }  
           
         return a;  
    }  
	 
	 public static TreeNode remove(TreeNode root, int key){
		 if(root==null)
			 return null;
		 if(root.val==key){
			 if(root.left==null)
				 return root.right;
			 else if(root.right==null)
				 return root.left;
			 else{
				 root.val=getRightMost(root.left);
				 root.left=remove(root.left,root.val);				 
			 }
		 }
		 else{
			 if(key<root.val)
				 root.left=remove(root.left,key);
			 else
				 root.right=remove(root.right,key);
		 }
		 return root;
	 }
	 
	 public static int getRightMost(TreeNode root){
		 if(root==null)
			 return Integer.MIN_VALUE;
		 TreeNode right=root.right;
		 if(right==null)
			 return root.val;
		 else
			 return getRightMost(right);
	 }
	 
	 
	 public static int findIndexSameSum(int[] A){
		 if(A.length<3)
			 return -1;
		 
		 int i=0;
		 int j=A.length-1;
		 int leftSum=A[i];
		 int rightSum=A[j];
		 while(i<j-2){		 
			 
			 if(leftSum<rightSum){
				 i++;
				 leftSum+=A[i];
			 }
			 else{
				 j--;
				 rightSum+=A[j];
			 }
		 }
		 
		 System.out.println(leftSum+" "+rightSum);
		 if(leftSum==rightSum)
			 return i+1;
		 else
			 return -1;
	 }
	 
	 public static String longestPalindromeSimple(String s){
		 int n=s.length();
		 if(n==0)
			 return "";
		 
		 String longest=s.substring(0,1);
		 
		 for(int i=0;i<n-1;i++){
			 String s1=expandAroundCenter(s,i,i);
			 if(s1.length()>longest.length())
				 longest=s1;
			 
			 String s2=expandAroundCenter(s,i,i+1);
			 if(s2.length()>longest.length())
				 longest=s2;
		 }
		 
		 return longest;
	 }
	 
	 public static String expandAroundCenter(String s, int l, int r){
		 while(l>=0&&r<s.length()&&s.charAt(l)==s.charAt(r)){
			 r++;
			 l--;			 
		 }
		 return s.substring(l+1, r);
	 }
	 
	 public static int sumTree(TreeNode root){
		 if(root==null)
			 return 0;
		 int oldVal=root.val;
		 root.val=sumTree(root.left)+sumTree(root.right);
		 return root.val+oldVal;
	 }
	 
	 
	 public static int firstMissing(int[] A){
		 if(A.length==0)
			 return 1;
		 int i=0;
		 int j=A.length-1;
		 while(i<j){
			 int mid=(i+j)/2;
			 if(A[mid]<=mid+1)
				 i=mid+1;
			 else
				 j=mid;
		 }
		 if(A[i]==i+1)
			 return A.length+1;
		 else
			 return i+1;
	 }
	 
	 public static ArrayList<Integer> morrisInorder(TreeNode root){
		 ArrayList<Integer> res=new ArrayList<Integer>();
		 if(root==null)
			 return res;
		 TreeNode cur=root;
		 TreeNode pre=null;
		 while(cur!=null){
			 if(cur.left==null){
				 res.add(cur.val);
				 cur=cur.right;
			 }
			 else{
				 pre=cur.left;
				 while(pre.right!=null&&pre.right!=cur)
					 pre=pre.right;
				 if(pre.right==null){
					 pre.right=cur;
					 cur=cur.left;
				 }
				 else{
					 pre.right=null;
					 res.add(cur.val);
					 cur=cur.right;
				 }
					 
			 }
		 }
		 return res;
	 }
	 
	 public static boolean string2StringWithOneChange(String s1, String s2){
		 int n1=s1.length();
		 int n2=s2.length();
		 if(Math.abs(n1-n2)>1||s1.equals(s2))
			 return false;
		 if(n1==n2){
			 int count=0;
			 for(int i=0;i<n1;i++){
				 if(s1.charAt(i)!=s2.charAt(i))
					 count++;
				 if(count>1)
					 return false;
			 }
			 return true;
		 }
		 else{
			 if(n1<n2)
				 return check(s2,s1);
			 else
				 return check(s1,s2);				 
				
			 }
	 }
	 
	 public static boolean check(String s1, String s2){
		 for(int i=0;i<s1.length();i++){
		 String s=s1.substring(0,i)+s1.substring(i+1);
		 if(s.equals(s2))
			 return  true;
	 }
		 return false;
	 }
	 
	 
	 public static int factorialZeroes(int n){
		 if(n<5)
			 return 0;
		 if(n==5)
			 return 1;
		 int count=0;
		 
		 for(int i=5;n/i>=1;i*=5){
			 count+=n/i;
			 }
		 return count;

	 }
	 
	 public static int treeLevelSum(TreeNode root){
		 if(root==null)
			 return 0;
//		 HashMap<Integer, Integer> map=new HashMap<Integer, Integer>();
		 int[] sum={0};
		 treeLevelSumUtil(root,1,sum);
		 return sum[0];
		 
	 }
	 
	 public static void treeLevelSumUtil(TreeNode root, int level, int[] sum){
		 if(root==null)
			 return;
		 sum[0]+=level*root.val;
		 treeLevelSumUtil(root.left,level+1,sum);
		 treeLevelSumUtil(root.right,level+1,sum);
	 }
	 
	 public static TreeNode lca(TreeNode root, TreeNode p, TreeNode q){
		 if(root==null)
			 return null;
		 if(root==p||root==q)
			 return root;
		 TreeNode left=lca(root.left,p,q);
		 TreeNode right=lca(root.right,p,q);
		 if(left!=null&&right!=null)
			 return root;
		 else
			 return left==null?right:left;
		 
	 }
	 
	 public static boolean hasCycle(Graph G){
		 if(G==null)
			 return false;
		 int v=G.V;
		 boolean visited[]=new boolean[v];
		 
		 for(int i=0;i<v;i++){
			 if(!visited[i]&&dfsCyclic(G, i,visited,-1))
				 return true;
		 }
		 return false;
	 }
	 
	 public static boolean dfsCyclic(Graph G, int cur, boolean[] visited, int parent){
		 visited[cur]=true;
		 ArrayList<Integer> adj=G.adj.get(cur);
		 
		 for(int i=0;i<adj.size();i++){
			 if(!visited[i]){
				 if(dfsCyclic(G, i,visited, cur))
					 return true;
			 }
			 else{
				// If an adjacent is visited and not parent of current vertex,
			        // then there is a cycle.
				 if(i!=parent)
					 return true;
			 }
		 }
		 return false;
		 
	 }
	 
	 public static void slidingWindowMax(int[] A, int k){
		 ArrayDeque<Integer> deque=new ArrayDeque<Integer>();
		 //process the first k elements
		 for(int i=0;i<k;i++){
			 while(!deque.isEmpty()&&A[i]>=A[deque.getLast()])
				 deque.pollLast();
			 deque.add(i);			 
		 }
		 
		 for(int i=k;i<A.length;i++){
			// The element at the front of the queue is the largest element of
		        // previous window, so print it
			 System.out.print(A[deque.getFirst()]+" ");
			// Remove the elements which are out of this window
			 while(!deque.isEmpty()&&deque.getFirst()<=i-k)
				 deque.poll();
			 
			// Remove all elements smaller than the currently
		        // being added element (remove useless elements)
			 while(!deque.isEmpty()&&A[i]>=A[deque.getLast()])
				 deque.pollLast();
			 deque.add(i);
		 }
//		 System.out.println(deque.size()+" ss");
		 System.out.println(A[deque.getFirst()]);
	 }
	 
	 public static ListNode difference(ListNode head1, ListNode head2){
		 if(head1==null||head2==null)
			 return head1;
		 
//		 int l1=0;
//		 int l2=0;
//		 
//		 boolean neg=false;
//		 
//		 ListNode cur1=head1;
//		 ListNode cur2=head2;
//		 
//		 while(cur1!=null){
//			 l1++;
//			 cur1=cur1.next;
//		 }
//		 
//		 while(cur2!=null){
//			 l2++;
//			 cur2=cur2.next;
//		 }
//		 
//		 if(l1>=l2){
//			 cur1=head1;
//			 cur2=head2;
//		 }
//		 else{
//			 neg=true;
//			 cur1=head2;
//			 cur2=head1;
//		 }
		 
		 ListNode cur1=head1;
		 ListNode cur2=head2;
//		 
		 boolean carry=false;
		 
		 ListNode dummy=new ListNode(0);
		 ListNode pre=dummy;
		 int dif=0;
		 int val=0;
		 while(cur1!=null&&cur2!=null){
//			 ListNode pnext=cur1.next;
			 if(carry){
				 val=cur1.val-1;
			 }
			 else
				 val=cur1.val;
			 if(val<cur2.val){
				 carry=true;
				 dif=val+10-cur2.val;
			 }
			 else{
				 carry=false;
				 dif=val-cur2.val;
			 }
			 ListNode node=new ListNode(dif);
					 
			 cur1=cur1.next;
			 cur2=cur2.next;
			 
			 if(cur1==null&&cur2==null&&dif==0)
				 break;
			 pre.next=node;
			 pre=pre.next;
		 }
		 
		 while(cur1!=null){
			 if(carry){
				 val=cur1.val-1;
			 }
			 else
				 val=cur1.val;
			 if(val<0)
				 carry=true;
			 else
				 carry=false;
			 ListNode node=new ListNode(val);
			 pre.next=node;
			 pre=pre.next;
			 cur1=cur1.next;
			 System.out.println("dddd");
		 }
		 
		 while(cur2!=null){
			 if(carry){
				 val=cur2.val-1;
			 }
			 else
				 val=cur2.val;
			 if(val<0)
				 carry=true;
			 else
				 carry=false;
			 ListNode node=new ListNode(val);
			 pre.next=node;
			 pre=pre.next;
			 cur2=cur2.next;
		 }			 
		 
		 if(carry){
			 ListNode node=new ListNode(-1);
			 pre.next=node;
			
		 }
		
//		 if(dummy.next.val==0)
//			 return  dummy.next.next;
		 
		 return dummy.next;
	 }
	 
	 public static String removeDup(String s){
		 if(s.length()<2)
			 return s;
		 char[] ch=s.toCharArray();
		 
		 int tail=1;
		 for(int i=1;i<s.length();i++){
			 int j=0;
			 for(j=0;j<tail;j++){
				 if(ch[i]==ch[j])
					 break;
			 }
			 if(j==tail){
				 ch[tail]=ch[i];
				 tail++;
			 }
		 }
		 String str=new String(ch);
		 return str.substring(0,tail);
	 }
	 
	 public static int multiply(int a, int b){
		 int res=0;
		 
		 while(b>0){
			 if((b&1)==1)
				 res+=a;
			 a<<=1;
			 b=b>>1;
		 }
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
	        
	        solveSudokuUtil(empty, board, 0);
	    }
	 
	 public boolean solveSudokuUtil(ArrayList<Integer> empty, char[][] board, int cur){
		 if(cur==empty.size())
			 return true;
		 
		 int index=empty.get(cur);
		 int row=index/9;
		 int col=index%9;
		 
		 for(int i=1;i<=9;i++){
			 if(isValidSudoku(i,row, col, board)){
				 board[row][col]=(char)('0'+i);
				 if(solveSudokuUtil(empty, board, cur+1))
					 return true;
				 board[row][col]='.';
			 }
		 }
		 return false;
	 }
	 
	 public boolean isValidSudoku(int num, int row, int col, char[][] board){
		 for(int i=0;i<9;i++){
			 if(board[row][i]==(char)('0'+num))
				 return false;
			 
			 if(board[i][col]==(char)('0'+num))
				 return false;
//			 int b_row=3*(row/3)+i/3;
//			 int b_col=3*(col/3)+i%3;
//			 if(board[b_row][b_col]=='0'+num)
//				 return false;
			 
			 int xt=row/3*3;
			 int yt=col/3*3;
			 
			 for(int j=0;j<3;j++){
				 for(int k=0;k<3;k++){
					 if(board[j+xt][k+yt]=='0'+num)
						 return false;
				 }
			 }
		 }
		 return true;
	 }
	 
	 
	 public boolean isMatch2(String s, String p) {
		 int i=0;
		 int j=0;
		 int star=-1;
		 int sp=0;
		 
		 while(i<s.length()){
			 if(j<p.length()&&p.charAt(j)=='?'||p.charAt(j)==s.charAt(i)){
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
				 i=sp+1;
				 sp++;
				 continue;
			 }
			 return false;
		 }
		 
		 while(j<p.length()&&p.charAt(j)=='*')
			 j++;
		 
		 return j==p.length();
		 
		 
	 }
	 
	 public static String longestSubStringContainK(String s, int k){
		 if(s.length()<k)
			 return "";
		 
		 int start=0;
		 int end=0;
		 int max=0;
		 int finalstart=0;

		 HashMap<Character, Integer> map=new HashMap<Character, Integer>();
		 
		for(int i=0;i<s.length();i++){
			char c=s.charAt(i);
			if(map.size()<k){
				if(map.containsKey(c))
					map.put(c, map.get(c)+1);
				else
					map.put(c, 1);
//				if(i-start+1>max){
//					max=i-start+1;
//					end=i;
//					finalstart=start;
//				}
				
			}
			else{
				if(map.containsKey(c))
					map.put(c, map.get(c)+1);
				else{
//					char ch=s.charAt(start);
					while(map.get(s.charAt(start))>1){
						map.put(s.charAt(start), map.get(s.charAt(start))-1);
						start++;
					}
					map.remove(s.charAt(start));
					start++;
					map.put(c, 1);
				}
//				if(i-start+1>max){
//					end=i;
//					max=i-start+1;
//					finalstart=start;
//				}
			}
			if(i-start+1>max){
				end=i;
				max=i-start+1;
				finalstart=start;
			}
		}
		System.out.println(start+" "+end);
		return s.substring(finalstart,end+1);
	 }
	 
	 
	 public static int findDupIndex(int[] A, int n){
		 if(A.length<2)
			 return -1;
		 
		 int res=0;
		 for(int i=0;i<A.length;i++){
			 res^=A[i]^(i+1);
		 }
		 
//		 for(int i=1;i<=n;i++)
//			 res^=i;
		 
		 
//		 System.out.println("res "+res);
		 int k=0;
		 while((res&(1<<k))==0)
			 k++;
		 
//		 System.out.println((res&(1<<k)));
		 int rightMostBit=res&~(res-1);
		 
//		 System.out.println(rightMostBit);
		 
		 int x=0;
		 int y=0;
		 for(int i=0;i<A.length;i++){
			 if((A[i]&rightMostBit)==0)
				 x^=A[i];
			 else
				 y^=A[i];
		 }
		 
		 for(int i=1;i<=n;i++){
			 if((i&rightMostBit)==0)
				 x^=i;
			 else
				 y^=i;
		 }
//		 System.out.println(x+" "+y);
		 for(int i=1;i<A.length;i++){
			 if(A[i]==x)
				 return y;
		 }
		 return  x;
		
	 }
	 
	 public static ArrayList<Integer> postOrder2(TreeNode root){
		 ArrayList<Integer> res=new ArrayList<Integer>();
		 if(root==null)
			 return res;
		 Stack<TreeNode> stk=new Stack<TreeNode>();
		 TreeNode cur=root;
		 while(cur!=null){
			 stk.push(cur);
			 cur=cur.left;
		 }
		 TreeNode pre=null;
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
	 
	 
	 public static ArrayList<Integer> postOrder3(TreeNode root){
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
		 
		 while(!stk2.isEmpty()){
			 res.add(stk2.pop().val);
		 }
		 return res;
	 }
	 
	 
	 public static TreeNode nextRight(TreeNode root, int k){
		 if(root==null)
			 return null;
		 
		 Queue<TreeNode> que=new LinkedList<TreeNode>();
		 int curLevel=0;
		 int nextLevel=0;
		 que.add(root);
		 curLevel++;
		 
		 while(!que.isEmpty()){
			 TreeNode top=que.remove();
			 curLevel--;
			 if(top.val==k){
				 if(curLevel==0)
					 return null;
				 else
					 return que.peek();
			 }
			 if(top.left!=null){
				 que.add(top.left);
				 nextLevel++;
			 }
			 if(top.right!=null){
				 que.add(top.right);
				 nextLevel++;
			 }
			 
			 if(curLevel==0){
				 curLevel=nextLevel;
				 nextLevel=0;
			 }
		 }
		 return null;
	 }
	 
	 
	 
	 public static int deepSum(List<Object> list){
		 if(list.size()==0)
			 return 0;
		 
		return  deepSumUtil(list,1);
//		 return res[0];
	 }
	 
	 
	 public static int deepSumUtil(List<Object> list, int depth){
		 int res=0;
		 for(int i=0;i<list.size();i++){
			 System.out.println(depth+" depth");
			 System.out.println(res+" res");
			 Object obj=list.get(i);
			 if(obj instanceof Integer)
				 res+=(int)(obj)*depth;
			 if(obj instanceof List<?>){
				 System.out.println("xxxx");
//				 List<Object> l=(List<Object>)obj;
				 res+=deepSumUtil((List<Object>) obj, depth+1);
			 }
		 }
		 return res;
	 }
	 
	 public static int getMajority(int[] A){
		 if(A.length==0)
			 return Integer.MIN_VALUE;
		 int majority=A[0];
		 int count=1;
		 for(int i=1;i<A.length;i++){
			 if(A[i]==majority)
				 count++;
			 else
				 count--;
			 if(count==0){
				 majority=A[i];
				 count=1;
			 }
		 }
		 
		 System.out.println(majority);
		 count=0;
		 for(int i=0;i<A.length;i++){
			 if(A[i]==majority)
				 count++;
		 }
		 
		 return count>=A.length/2+1?majority:Integer.MIN_VALUE;
	 }
	 
	 
	 public static ListNode deleteMiddle(ListNode head){
		 if(head==null||head.next==null)
			 return null;

		 ListNode cur=head;
		 ListNode slow=head;
		 ListNode fast=head;
		 
		 ListNode dummy=new ListNode(0);
		 dummy.next=head;
		 ListNode pre=dummy;
		 while(fast!=null&&fast.next!=null){
			 slow=slow.next;
			 fast=fast.next.next;
			 if(slow==fast)
				 break;
		 }
		 
		 if(fast==null||fast.next==null)
			 return null;
		 
		 cur=head;
		 
		 while(cur!=fast){
			 pre=cur;
			 cur=cur.next;
			 fast=fast.next;
		 }
		 
		 pre.next=cur.next;
		 
		 ListNode node=cur.next;
		 while(node.next!=cur)
			 node=node.next;
		 node.next=null;
		 
		 return dummy.next;			 
		 
	 }
	 public ArrayList<String> fullJustify(String[] words, int L) {
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
	        	
	        	int spaces=L-size;
	        	int spaceforeach;
	        	
	        	if(i-beg-1!=0&&i<n){
	        		spaceforeach=spaces/(i-beg-1);
	        		spaces=spaces%(i-beg-1);
	        	}
	        	else{
	        		spaceforeach=0;
	        	}
	        	
	        	String word=words[beg];
	        	
	        	for(int j=beg+1;j<i;j++){
	        		for(int k=0;k<=spaceforeach;k++){
	        			word+=" ";
	        		}
	        		if(spaces>0&&i<n){
	        			word+=" ";
	        			spaces--;
	        		}
	        		word+=words[j];
	        	}
	        	
	        	for(int j=0;j<spaces;j++)
	        		word+=" ";
	        	
	        	res.add(word);
	        }
	        return res;
	    }
	 
	 
	 public static String compressInplace(char[] string){
		 if(string.length<2)
			 return new String(string);
		 
		 int tail=1;
		 
		 int count=1;
		 
		 char c=string[0];
		 for(int i=1;i<string.length;i++){
			 if(string[i]==c)
				 count++;
			 else{
				 if(count==1){
					 string[tail]=string[i];
					 tail++;
				 }
				 else{					 
					 string[tail]=(char) ('0'+count);
					 tail++;
					 string[tail]=string[i];
					 tail++;
				 }
				 count=1;
				 c=string[i];
			 }
		 }
		 String s="";
		 for(int i=0;i<tail;i++)
			 s+=string[i];
		 return s;
	 }
	 
	 
	 public static void findIntersection(int[] A, int[] B){
		 if(A.length==0||B.length==0)
			 return;
		int i=0;
		int j=0;
		while(i<A.length&&j<B.length){
			if(A[i]==B[j]){
				System.out.print(A[i]+" ");
				i++;
				while(A[i]==B[j]){
					System.out.print(A[i]+" ");
					i++;
				}
				j++;
			}
			else if(A[i]>B[j])
				j++;
			else
				i++;
		}
	 }
	 
	 
	 public static ArrayList<ArrayList<Integer>> printAllUniqueParts(int n){
		 ArrayList<ArrayList<Integer>> res=new ArrayList<ArrayList<Integer>>();
		 if(n<=0)
			 return  res;
		 ArrayList<Integer> sol=new ArrayList<Integer>();
		 printAllUniqueParts(n,n,sol,res, 0);
		 return res;
		 
	 }
	 
	 public static void printAllUniqueParts(int dep, int n, ArrayList<Integer> sol, ArrayList<ArrayList<Integer>> res, int cursum){
		 if(dep==0||cursum>n)
			 return;
		 if(cursum==n){
			 ArrayList<Integer> out=new ArrayList<Integer>(sol);
			 res.add(out);
		 }
		 
		 for(int i=dep;i>=0;i--){
			 cursum+=i;
			 sol.add(i);
			 printAllUniqueParts(i, n,sol,res,cursum);
			 cursum-=i;
			 sol.remove(sol.size()-1);
		 }
	 }
	 
	 
	public static void printArray(int p[], int n)
	 {
	     for (int i = 0; i < n; i++)
	        System.out.print(p[i]+ " ");
	     System.out.println();
	 }
	 
	 public static void printAllUniqueParts2(int n)
	 {
	     int[] p=new int[n]; // An array to store a partition
	     int k = 0;  // Index of last element in a partition
	     p[k] = n;  // Initialize first partition as number itself
	  
	     // This loop first prints current partition, then generates next
	     // partition. The loop stops when the current partition has all 1s
	     while (k>=0)
	     {
	         // print current partition
	         printArray(p, k+1);
	  
	         // Generate next partition
	  
	         // Find the rightmost non-one value in p[]. Also, update the
	         // rem_val so that we know how much value can be accommodated
	         int rem_val = 0;
	         while (k >= 0 && p[k] == 1)
	         {
	             rem_val += p[k];
	             k--;
	         }
	  
	         // if k < 0, all the values are 1 so there are no more partitions
	         if (k < 0)  return;
	  
	         // Decrease the p[k] found above and adjust the rem_val
	         p[k]--;
	         rem_val++;
	  
	  
	         // If rem_val is more, then the sorted order is violeted.  Divide
	         // rem_val in differnt values of size p[k] and copy these values at
	         // different positions after p[k]
	         while (rem_val > p[k])
	         {
	             p[k+1] = p[k];
	             rem_val = rem_val - p[k];
	             k++;
	         }
	  
	         // Copy rem_val to next position and increment position
	         p[k+1] = rem_val;
	         k++;
	     }
	 }
	 
//	 public static TreeNode rebuildTree(String levelOrder){
//		 char[] dfs=levelOrder.toCharArray();
//		 if(dfs.length==0)
//			 return null;
//		 
//		 TreeNode root=new TreeNode(dfs[0]);
//		 return rebuildTree(root,dfs,dfs[1],1);
////		 TreeNode root=new TreeNode(dfs[0]);
////		 return root;
//	 }
//	 
//	 public static TreeNode rebuildTree(TreeNode root,char[] dfs, int level,int cur){
//		 if(root==null||level==0)
//			 root=new TreeNode(dfs[cur]);
//		 if(root.left==null&&cur+2<dfs.length)
//			 root.left= rebuildTree(root.left,dfs,level+1,(int)(cur+Math.pow(2, level)));
//		 if(root.right==null&&cur+4<dfs.length&&dfs[cur+4]==level)
//			 root.right=rebuildTree(root.right,dfs,level+1,(int)(cur+Math.pow(2, level+1)));
//		 return root;
//	 }
	 
	 
	 public static void primeFactors(int n){
		 while(n%2==0){
			 System.out.print(2+" ");
			 n=n/2;
		 }
		 
		 for(int i=3;i<=Math.sqrt(n);i+=2){
			 while(n%i==0){
				 System.out.print(i+" ");
				 n=n/i;
			 }
		 }
		 if(n>2)
			 System.out.println(n);
	 }
	 
	 public static TreeNode convertList2Tree(ListNode head){
		 if(head==null)
			 return null;
		 
		 Queue<TreeNode> que=new LinkedList<TreeNode>();
		 TreeNode root=new TreeNode(head.val);
		 que.add(root);
		 
		 head=head.next;
		 while(head!=null){
			 TreeNode parent=que.poll();
			 TreeNode left=new TreeNode(head.val);
			 TreeNode right=null;
			 que.add(left);
			 head=head.next;
			 if(head!=null){
				 right=new TreeNode(head.val);
				 que.add(right);
				 head=head.next;
			 }
			 
			 parent.left=left;
			 parent.right=right;
		 }
		 return root;
	 }
	 
	 public static TreeNode levelOrder2Tree(int[] A){
		 if(A.length==0)
			 return null;
		 Queue<TreeNode> que=new LinkedList<TreeNode>();
		 int i=0;
		 TreeNode root=new TreeNode(A[i]);
		 que.add(root);
		 i++;
		 
		 while(i<A.length){
			 TreeNode parent=que.poll();
			 
			 TreeNode left=new TreeNode(A[i]);
			 que.add(left);
			 i++;
			 TreeNode right=null;
			 if(i<A.length){
				 right=new TreeNode(A[i]);
				 que.add(right);
				 i++;
			 }
			 
			 parent.left=left;
			 parent.right=right;
		 }
		 
		 return root;
	 }
	 
	 
//	 static TreeNode root=null;
	 public static TreeNode levelOrderToTreeNode(int[] A){
		 if(A.length==0)
			 return null;
		 TreeNode root=null;
		 return levelOrderToTree(root, A,0, A.length);
//		 return root;
	 }
	 
	 public  static TreeNode levelOrderToTree(TreeNode root, int[] A, int start, int end){
		 int left=2*start+1;
		 int right=2*start+2;
		 if(left>end||right>end)
			 return null;
		 if(root==null){
			 root=new TreeNode(A[start]);
		 }
		 
		 if(root.left==null&&root.right==null){
			 if(left<end)
				 root.left=new TreeNode(A[left]);
			 if(right<end)
				 root.right=new TreeNode(A[right]);
		 }
		 
		 levelOrderToTree(root.left,A,left, end);
		 levelOrderToTree(root.right,A,right,end);
		 
		 return root;
	 }
	 ///greeedy?
	 public static int minWeightDiff(int[] A, int[] B){
		 int n=A.length;
		 if(n==0)
			 return 0;
		 int[][] dp=new int[n+1][n+1];
		 Arrays.sort(A);
		 Arrays.sort(B);
		 dp[0][0]=0;
		 for(int i=1;i<=n;i++){
			 dp[i][0]=Integer.MAX_VALUE;
			 dp[0][i]=Integer.MAX_VALUE;
		 }
		 
		 for(int i=1;i<=n;i++){
			 for(int j=1;j<=n;j++){
				 int min=Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]));
				 dp[i][j]=Math.abs(A[i-1]-B[j-1])+min;
			 }
		 }
		 
		 return dp[n][n];
			 
	 }
	 
		public static String numToStringExcel(int n){
			String res="";
			res=(char)('a'+n%26)+res;
			n=n/26;
			while(n!=0){
				res=(char)('a'+(n-1)%26)+res;
				n=(n-1)/26;
			}
			return res;
		}
		
		public static String getExcelNumber(int n){
			String s="";
			while(n>=0){
				int remainder=n%26;
				s=(char)('A'+remainder)+s;
				n=n/26-1;
			}
			return s;
		}
		
		
		public static int excelToDec2(String excelNum){
			if(excelNum.length()==0)
				return 0;
			int res=0;
			for(int i=0;i<excelNum.length();i++){
				res=res*26+(excelNum.charAt(i)-'A')+1;
			}
			return res;
		}
		
		// activity scheduling  s[]  an array contains start time, f[] an array contains finish time of all activities
		public static void maxActivities(int[] s, int[] f){
			int i=0;
			System.out.print(i+" ");
			
			for(int j=1;j<s.length;j++){
				if(s[j]>=f[i]){
					System.out.print(j+" ");
					i=j;
				}					
			}
			System.out.println();
		}
	 
		
		public static String serializeTree(TreeNode root){
			if(root==null)
				return "";
			String res="";
			Queue<TreeNode> que=new LinkedList<TreeNode>();
			que.add(root);
			
			while(!que.isEmpty()){
				TreeNode top=que.poll();
				
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
		
		public static TreeNode deserialize(String s){
			if(s.length()==0||s.charAt(0)=='#')
				return null;
			
			Queue<TreeNode> que=new LinkedList<TreeNode>();
			int i=0;
			TreeNode root=new TreeNode(s.charAt(i++)-'0');
			que.add(root);
			while(!que.isEmpty()){
				TreeNode top=que.poll();
				TreeNode left=null, right=null;
				System.out.println(s.charAt(i)+" "+i);
				if(s.charAt(i)!='#')
					left=new TreeNode(s.charAt(i++)-'0');
				else
					i++;
				if(s.charAt(i)!='#')
					right=new TreeNode(s.charAt(i++)-'0');
				else 
					i++;
				top.left=left;
				top.right=right;
				if(left!=null)
					que.add(left);
				if(right!=null)
					que.add(right);
			}
			return root;
		}
		
		
//		f (i ,k ) = max{  f (i-1,k) ,  max {  f( j,k-1) + prices[i]-prices[ j]  |  0<=j<i } } ,
//		即，第i天不做生意，那么是f(i-1,k)，或者第i天要卖，那么这次买应该来自第j 天，所以是  f(j,k-1) +prices[i] - prices[j]  ，然后取最大值。
		public static int maxProfit(int[] prices, int k){
			if(prices.length<2)
				return 0;
			
			int n=prices.length;
			int[][] dp=new int[n+1][k+1];
			
			for(int i=1;i<n;i++){
				for(int t=1;t<=k;t++){
					int max=dp[i-1][t];
					for(int j=i-1;j>=0;j--){
						max=Math.max(max, dp[j][t-1]+prices[i]-prices[j]);
					}
					dp[i][t]=max;
				}
			}
			
			return dp[n-1][k];
		}
		
		
		
		
		
		public static int evalIPN(String[] tokens){
			if(tokens.length==0)
				return 0;
			
			Stack<Integer> stk=new Stack<Integer>();
			
			int i=0;
			while(i<tokens.length){
				if(!tokens[i].equals("+")&&!tokens[i].equals("*")){
					int num=Integer.parseInt(tokens[i]);
					stk.push(num);
				}
				else{
					int res=0;
					if(tokens[i].equals("*")){
						int num1=stk.pop();
						int num2=Integer.parseInt(tokens[++i]);
						res=num1*num2;
						stk.push(res);
					}
				}
				i++;
			}
			
			int res=0;
			while(!stk.isEmpty()){
				res+=stk.pop();
			}
			return res;
		}
		
		public static int findMaxIndices(int[] A, int[] B){
			int n=A.length;
			int[] c=new int[n];
			
			for(int i=0;i<n;i++)
				c[i]=A[i]-B[i];
			
			for(int i=1;i<n;i++)
				c[i]=c[i-1]+c[i];
			
			HashMap<Integer, Integer> map=new HashMap<Integer, Integer>();
			
			int beg=0;
			int end=0;
			int max=0;
			for(int i=0;i<n;i++){
				if(!map.containsKey(c[i]))
					map.put(c[i], i);
				else{
					if(i-map.get(c[i])>max){
						max=i-map.get(c[i]);
						beg=map.get(c[i])+1;
						end=i;
					}
				}
			}
			System.out.println(beg+" "+end);
			
			return max;
			
		}
		
		public static Node[] merge(int[] A, int[] B, int[] C){
			int n1=A.length;
			int n2=B.length;
			int n3=C.length;
			int n=n1+n2+n3;
			
			int[] A1=new int[n1+1];
			A1=Arrays.copyOf(A, n1+1);
			A1[n1]=Integer.MAX_VALUE;
			
			int[] B1=new int[n2+1];
			B1=Arrays.copyOf(B, n2+1);
			B1[n2]=Integer.MAX_VALUE;
			
			int[] C1=new int[n3+1];
			C1=Arrays.copyOf(C, n3+1);
			C1[n3]=Integer.MAX_VALUE;
			
			Node[] res=new Node[n];
			int i=0,j=0,k=0;
			int p=0;
			while(p<n){
				int from=0;
				int min=Math.min(Math.min(A1[i], B1[j]), C1[k]);
				
				if(min==Integer.MAX_VALUE)
					break;
				else{
					if(min==A1[i]){
						from=1;
						i++;
					}
					else if(min==B1[j]){
						from =2;
						j++;
					}
					else{
						from=3;
						k++;
					}
					res[p++]=new Node(from, min);
				}
				
			}
			
			return res;
			
		}
		
		public static void getMinRange(int[] A, int[] B, int[] C){
			Node[] array=merge(A,B,C);
			
			int start=0;
			int beg=0;
			int end=0;
			int min=Integer.MAX_VALUE;
			int count=3;
			
			HashMap<Integer, Integer> map=new HashMap<Integer, Integer>();
			
			for(int i=0;i<array.length&&array[i]!=null;i++){
				int from=array[i].from;
				if(!map.containsKey(from)){
					map.put(from, 1);
					count--;
				}
				else{
					map.put(from, map.get(from)+1);
				}
				
				if(count==0){
					while(true){
						int startFrom=array[start].from;
						if(map.get(startFrom)>1)
							map.put(startFrom,map.get(startFrom)-1);
						else
							break;
						start++;
					}
					
					int right=array[i].val;
					int left=array[start].val;
					
					System.out.println(left+" "+right +" ddddd0");
					System.out.println("min:"+min);
					if(right-left+1<min){
						min=right-left+1;
						beg=left;
						end=right;
					}
				}
			}
			
			System.out.println(beg+" "+end);
		}
		
		public static String parity(String msg){
			String parityStr=null;
			int n=msg.hashCode();
			switch(n%2){
			case 0:
				parityStr="even";
				break;
			case 1:
				parityStr="odd";
				break;			
			}
			return parityStr;
		}
		
		
		public static int findKthLargest(int[] nums, int k){
			if(k<1||k>nums.length)
				return -1;
			return findKthLargest(nums, 0, nums.length-1, k);
		}
		
		public static int findKthLargest(int[] nums, int start, int end, int k){
			int pivot=start;
			int left=start;
			int right=end;
			
			while(left<=right){
				// scan from left to right until we find a value is larger than pivot
				while(left<=right&&nums[left]<=nums[pivot])
					left++;
				
				while(left<=right&&nums[right]>=nums[pivot])
					right--;
				
				if(left<right){
					swap2(nums, left, right);
				}
			}
			
			swap2(nums, pivot, right);
			
			if(right==k-1)
				return nums[right];
			else if(right<k-1)
				return findKthLargest(nums,right+1,end, k);
			else
				return findKthLargest(nums, start, right-1, k);
		}
		
		public static void swap2(int[] nums, int a, int b){
			int tmp=nums[a];
			nums[a]=nums[b];
			nums[b]=tmp;
		}
		
		static class QueComparator implements Comparator<PairNode>{

			@Override
			public int compare(PairNode p1, PairNode p2) {
				// TODO Auto-generated method stub
				return p1.val-p2.val;
			}
		}
		
		public static int findKthLargestSum(int[] A, int[] B, int k){
			if(A.length+B.length<k)
				return -1;
			PriorityQueue<PairNode> heap=new PriorityQueue<PairNode>(k, new QueComparator());
			heap.offer(new PairNode(0,0, A[0]+B[0]));
			HashSet<Integer> set=new HashSet<Integer>();
			set.add(A[0]+B[0]);
			
			PairNode max=null;
			// remove max k-1 times
			for (int i = 0; i < k - 1; ++i) {
			    // get max and remove it from the heap
			    max = heap.poll();
			    if(!set.contains(A[max.a]+B[max.b]))
			    	set.add(A[max.a]+B[max.b]);
			    // add next candidates
			    if(max.a+1<A.length)
			    	heap.add(new PairNode(max.a + 1, max.b, A[max.a+1]+B[max.b]));
			    if(max.b+1<B.length)
			    	heap.add(new PairNode(max.a, max.b + 1,A[max.a]+B[max.b+1]));
			}

			// get k-th maximum element
			max = heap.poll();
			int maxVal = A[max.a] + B[max.b];
			
			return maxVal;
		}
		
		public static int findHalf(int[] A){
			if(A.length%2!=0)
				return -1;
			
			int candidate=A[0];
			int count=1;
			for(int i=0;i<A.length;i++){
				if(count==0){
					candidate=A[i];
					count=1;
				}
				else{
					if(candidate==A[i])
						count++;
					else
						count--;
				}
			}
			
			count=0;
			int candidate2=A[A.length-1];
			for(int i=0;i<A.length;i++){
				if(A[i]==candidate)
				{
					count++;
				}
			}
			
			return count==A.length/2?candidate:candidate2;
		}
		
		
		public static void rearrange(int[] A){
			if(A.length<2)
				return;
			
			int i=A.length-1;
			int negStart=-1;
			int negEnd=-1;
			int posStart=-1;
			int posEnd=-1;
			while(i>=0){
				if(A[i]<0){
					negEnd=i;
					while(i>=0&&A[i]<0)
						i--;
					if(i<0)
						break;
					posEnd=i;
					negStart=i+1;					
					
					while(i>=0&&A[i]>=0)
						i--;
					posStart=i+1;
								
					
					System.out.println("neg: "+ negStart+" "+negEnd);
					System.out.println("pos: "+ posStart+" "+posEnd);
					swapRange(A,posStart, posEnd);
					swapRange(A, negStart, negEnd);
					swapRange(A,posStart, negEnd);
					i+=negEnd-negStart+1;
				}
				else
					i--;
			}
			
			for(int j=0;j<A.length;j++)
				System.out.print(A[j]+" ");
			System.out.println();
		}
		
		public static void swapRange(int[]A, int i, int j){
			while(i<j){
				int tmp=A[i];
				A[i]=A[j];
				A[j]=tmp;
				i++;
				j--;
			}
		}
		
		
		public static int findShortestSequence(int[] num,int target){
			if(num.length==0)
				return -1;
			int minLen=num.length+1;
			
			int start=0;
			int end=0;
			int sum=0;
			while(end<num.length){
				if(sum<target)
					sum+=num[end];
				
				while(sum>=target){
					minLen=Math.min(minLen, end-start+1);
					System.out.println(sum+" "+start+" "+end);
					sum-=num[start++];
					
				}
				end++;
			}
			
			return minLen;
		}
		
		
		public static int findKthSum(int A[],int B[],int k) {
			PriorityQueue<PairNode> heap=new PriorityQueue<PairNode>(k, new QueComparator());
			heap.offer(new PairNode(0,0, A[0]+B[0]));
			HashSet<Pair> visited=new HashSet<Pair>();
			visited.add(new Pair(0,0));
			
			while(!heap.isEmpty()){
				PairNode node=heap.poll();
				k--;
				
				if(k==0)
					return node.val;
				if(node.a+1<A.length&&!visited.contains(new Pair(node.a+1,node.b))){
					visited.add(new Pair(node.a+1,node.b));
					heap.offer(new PairNode(node.a+1,node.b, A[node.a+1]+B[node.b]));
				}
				
				if(node.b+1<B.length&&!visited.contains(new Pair(node.a,node.b+1))){
					visited.add(new Pair(node.a,node.b+1));
					heap.offer(new PairNode(node.a,node.b+1, A[node.a]+B[node.b+1]));
				}
			}
			
			return -1;
		}
		
//		public static int minDiffWithExchange(int[] A, int[] B){
//			int n=A.length;
//			int[] t=new int[2*n];
//			for(int i=0;i<n;i++){
//				t[i]=A[i];
//				t[n+i]=B[i];
//			}
//			
//			Arrays.sort(t);
//			int big=t[2*n-1];
//			int small=t[2*n-2];
//			
//			
//		}
		
		
//		1. //将n划分为不大于m的个数 
//		dp[n][m]= dp[n][m-1]+ dp[n-m][m]
//		　　2. 将n划分为不大于m的不同的数 
//		dp[n][m]= dp[n][m-1]+ dp[n-m][m-1]
//		　　3. 将n划分为m个数 
//		dp[n][m]= dp[n][m-1]+ dp[n-m][m-1]  
//		　　4.将n划分为m个奇数
//		　　5. 将n划分为m个偶数 
//		g[i][j]:将i划分为j个偶数
//	　　　　f[i][j]:将i划分为j个奇数
//	　　   g[i][j] = f[i - j][j];
//	   　　f[i][j] = f[i - 1][j - 1] + g[i - j][j];
		public static int splitNum(int num, int m){
			if(num<m)
				return 0;
			int[][] dp=new int[num+1][m+1];
//			dp[0][0]=1;
			for(int i=1;i<=num;i++){
				for(int j=1;j<=m;j++){
					if(i<j)
						dp[i][j]=dp[i][i];
					else if(i==j)
						dp[i][j]=dp[i][j-1]+1;
					else
						dp[i][j]=dp[i][j-1]+dp[i-j][j];
				}
			}
			return dp[num][m];
		}
		
		
		public static int splitNum2(int num, int m){
			if(num<m)
				return 0;
			int[][] dp=new int[num+1][m+1];
//			dp[0][0]=1;
			for(int i=1;i<=num;i++){
				for(int j=1;j<=m;j++){
					if(i<j)
						dp[i][j]=dp[i][i];
					else if(i==j)
						dp[i][j]=dp[i][j-1]+1;
					else
						dp[i][j]=dp[i][j-1]+dp[i-j][j-1];
				}
			}
			return dp[num][m];
		}
		
		public static int splitNum3(int num, int m){
			if(num<m)
				return 0;
			int[][] dp=new int[num+1][m+1];
//			dp[0][0]=1;
			for(int i=1;i<=num;i++){
				for(int j=1;j<=m;j++){
					if(i<j)
						dp[i][j]=0;
					else if(i==j)
						dp[i][j]=1;
					else
						dp[i][j]=dp[i-j][j]+dp[i-1][j-1];
				}
			}
			return dp[num][m];
		}
		
		//将n分为k个整数 最小的大于等于min,最大不超过B 
		public static int splitNum4(int n, int k, int min, int max){
			if(n<min)
				return 0;
			if(k==1)
				return 1;
			int sum=0;
			for(int i=min;i<=max;i++){
				sum+=splitNum4(n-i,k-1,i,max);
			}
			return sum;
		}
		
		public static int countPairsWithDiffK(int arr[], int k){
			int max=arr[0];
			for(int i=1;i<arr.length;i++){
				if(arr[i]>max)
					max=arr[i];
			}
			int count=0;
			boolean[] hash=new boolean[max+1];
			
			for(int i=0;i<arr.length;i++)
				hash[arr[i]]=true;
			for(int i=0;i<arr.length;i++){
				int x=arr[i];
				if(x-k>=0&&hash[x-k])
					count++;
				if(x+k<max+1&&hash[x+k])
					count++;
				hash[x]=false;
			}
			
			return count;
		}
		
		public int longestUnrepeat(ListNode head){ 
			if(head==null)
				return 0;
			if(head.next==head)
				return 1;
			
			ListNode i=head;
			ListNode j=head;
			
			int len=0;
			int maxLen=0;
			boolean[] visited=new boolean[26];
			boolean imove=false;
			while(true){
				if(i!=head)
					imove=true;
				if(i==head&&imove)
					break;
				if(!visited[j.val-'A']){
					visited[j.val-'A']=true;
					j=j.next;
					len++;
				}
				else{
					maxLen=Math.max(maxLen, len);
					while(i.val!=j.val){
						visited[i.val-'A']=false;
						i=i.next;
						len--;
						
						if(i==head)
							return maxLen;
					}
					i=i.next;
					j=j.next;
				}
			}
			
			maxLen=Math.max(maxLen, len);
			return maxLen;
		}
		
		public static int findLoop (int[] arr){  
			HashMap<Integer, Integer> map=new HashMap<Integer, Integer>();
			int num=1;
			int i=0;
			while(true){
				if(!map.containsKey(i)){
					map.put(i, num++);
					i=arr[i];
				}
				else
					break;
			}
			
			return num-map.get(i);
		}
		
		
		 public static int findLoopConSpace(int[] arr){
			 int num=-1;			 
			 int cur=0;
			 
			 while(true){
				 if(arr[cur]<0)
					 break;
				 int next=arr[cur];				 
				 arr[cur]=num--;
				 cur=next;
			 }
			 
			 return Math.abs(num)-Math.abs(arr[cur]);
		 }
		 
		 
		 public static boolean isAscending(int a[]) {
			 if(a.length<2)
				 return true;
			 int n=a.length;
			  return isAscending(a, n);
			}
		 public static boolean isAscending(int a[], int len) {
			  if(len==1)
				  return true;
			  if(a[len-2]>a[len-1])
				  return false;
			  else
				  return isAscending(a,len-1);
			}
		 
		 
		 public static void moreThanThirdNew(int[] A){
			 int num1=-1;
			 int num2=-1;
			 int times1=0;
			 int times2=0;
			 
			 for(int i=0;i<A.length;i++){
				 if(num1==-1){
					 num1=A[i];
					 times1=1;
				 }
				 else if(A[i]==num1)
					 times1++;
				 else if(num2==-1){
					 num2=A[i];
					 times2=1;
				 }
				 else if(A[i]==num2)
					 times2++;
				 else{
					 if(--times1==0)
						 num1=-1;
					 if(--times2==0)
						 num2=-1;
					 if(times1==0&&times2>0){
						 num1=num2;
						 times1=times2;
						 num2=-1;
						 times2=0;
					 }
				 }
			 }
			 
			 if(num1!=-1&&check(num1, A))
				 System.out.print(num1+" ");
			 if(num2!=-1&&check(num2, A))
				 System.out.println(num2);
				 
		 }
		 
		 public static boolean check(int num, int[] A){
			 int count=0;
			 for(int i=0;i<A.length;i++){
				 if(num==A[i])
					 count++;
			 }
			 return count>=A.length/3;
		 }
		 
		 
		 public static ComplexListNode flattenList(ComplexListNode head){
			 if(head==null)
				 return null;
			 Queue<ComplexListNode> que=new LinkedList<ComplexListNode>();
			 ComplexListNode cur=head;
			 que.offer(cur);
			 
			 ComplexListNode dummy=new ComplexListNode(0);
			 ComplexListNode pre=dummy;
			 while(!que.isEmpty()){
				 ComplexListNode node=que.poll();
				
				 while(node!=null){
					 System.out.print(node.val+" ");
					 if(node.child!=null)
						 que.offer(node.child); 
					 pre.next=node;
					 pre=pre.next;
					 node=node.next;
				 }				 
			 }
			 
			 return dummy.next;
		 }
		 
		 public static ComplexListNode flattenMultiLevelList2(ComplexListNode head){
			 if(head==null)
				 return null;
			 ComplexListNode cur=head;
			 ComplexListNode tail=head;
			 
			 while(tail.next!=null)
				 tail=tail.next;
			 
			 while(cur!=null){
				 if(cur.child!=null){
					 tail.next=cur.child;
					 ComplexListNode tmp=cur.child;
					 
					 while(tmp.next!=null){
						 tmp=tmp.next;
					 }
					 tail=tmp;
				 }
				 cur=cur.next;
			 }
			 return head;
		 }
		 
		 
		 public static ComplexListNode flatten(ComplexListNode head){
			 if(head==null||head.next==null)
				 return head;
			 
			 return merge(head, head.next);
		 }
		 
		 public static ComplexListNode merge(ComplexListNode head1, ComplexListNode head2){
			 if(head1==null||head2==null)
				 return head1==null?head2:head1;
			 
			 ComplexListNode res=null;
			 if(head1.val<head2.val){
				 res=head1;
				 res.child=merge(head1.child,head2);
			 }
			 else{
				 res=head2;
				 res.child=merge(head1, head2.child);
			 }
			 return res;
		 }
		 
		 
		 /* Deletes nodes which have a node with greater value node
		  on left side */
		public static ListNode  delLesserNodes(ListNode head){
			if(head==null||head.next==null)
				return null;
			head=reverseList3(head);
			
			delLesserNodesUtil(head);
			head=reverseList3(head);
			
			return head;
		}
		
		public static void delLesserNodesUtil(ListNode head){
			if(head==null)
				return;
			
			ListNode cur=head;
			int max=head.val;
			while(cur!=null&&cur.next!=null){
				if(cur.next.val<max){
					cur.next=cur.next.next;
				}
				else{
					max=cur.next.val;
					cur=cur.next;
				}
			}
		}
		public static ListNode reverseList3(ListNode head){
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
		 
		
		public static boolean isIsomorphic(TreeNode n1, TreeNode n2){
			if(n1==null&&n2==null)
				return true;
			if(n1==null||n2==null)
				return false;
			
			if(n1.val!=n2.val)
				return false;
			
			return (isIsomorphic(n1.left,n2.left)&&isIsomorphic(n1.right,n2.right))||
					(isIsomorphic(n1.left,n2.right)&&isIsomorphic(n1.right,n2.left));
		}
		
		private static final String[] alphabet = {"", "a", "b", "c", "d", "e",
	        "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r",
	        "s", "t", "u", "v", "w", "x", "v", "z"};
		
		static void printAllInterpretations(int[] arr) {
			// Step 1: Create Tree
	        TNode root = createTree(0, "", arr);
	 
	        // Step 2: Print Leaf nodes
	        printLeaf(root);
	 
	        System.out.println();  // Print new line
		}
		
		public static TNode createTree(int data, String pString, int[] arr){
			if(data>26)
				return null;
			
			String  dataToString=pString+alphabet[data];
			
			TNode root=new TNode(dataToString);
			
			if(arr.length!=0){
				data=arr[0];
				// new array will be from index 1 to end as we are consuming 
	            // first index with this node
	            int newArr[] = Arrays.copyOfRange(arr, 1, arr.length);
	            
	            root.left=createTree(data, dataToString, newArr);
	            
	            if(arr.length>1){
	            	data=arr[0]*10+arr[1];
	            	newArr=Arrays.copyOfRange(arr, 2, arr.length);
	            	
	            	root.right=createTree(data, dataToString, newArr);
	            }
			}
			return root;
		}
		
		public static void printLeaf(TNode root){
			if(root==null)
				return;
			if(root.left==null&&root.right==null)
				System.out.print(root.val+" ");
			
			printLeaf(root.left);
			printLeaf(root.right);
		}
		
		public static boolean printAncestors(TreeNode root, int target){
			if(root==null)
				return false;
			if(root.val==target)
				return true;
			if(printAncestors(root.left,target)||printAncestors(root.right,target)){
				System.out.println(root.val+" ");
				return true;
			}
			return false;
		}
		
		public static void printAncestorsIterative(TreeNode root, int target){
			if(root==null)
				return;
			
			Stack<TreeNode> stk=new Stack<TreeNode>();
			
			TreeNode cur=root;
			while(cur!=null&&cur.val!=target){
				stk.push(cur);
				cur=cur.left;
			}
			
			if(cur!=null&&cur.val==target)
				printStk(stk);
			
			
			TreeNode pre=null;
			while(!stk.isEmpty()){
				TreeNode top=stk.peek();
				if(top.right!=null&&pre!=top.right){
					top=top.right;
					while(top!=null&&top.val!=target){
						stk.push(top);
						top=top.left;
					}
					if(top!=null&&top.val==target){
						printStk(stk);
						return;
					}
				}
				else{
					pre=stk.pop();
				}
			}
						
		}
		
		public static void printStk(Stack<TreeNode> stk){
			while(!stk.isEmpty()){
				System.out.print(stk.pop().val+" ");
			}
			System.out.println();
		}
		
		public static int LCSubStr(String str1, String str2){
			int m=str1.length();
			int n=str2.length();
			int[][] dp=new int[m+1][n+1];
			int maxLen=0;
			for(int i=1;i<=m;i++){
				for(int j=1;j<=n;j++){
					if(str1.charAt(i-1)==str2.charAt(j-1))
						dp[i][j]=dp[i-1][j-1]+1;
					else
						dp[i][j]=0;
					
					maxLen=dp[i][j]>maxLen?dp[i][j]:maxLen;
				}
			}
			
			return maxLen;
		}
		 
		
		
		public static void naivePatternSearch(String pat, String txt){
			int m=pat.length();
			int n=txt.length();
			
			for(int i=0;i<=n-m;i++){
				int j=0;
				
				for(;j<m;j++){
					if(pat.charAt(j)!=txt.charAt(i+j))
						break;
				}
				if(j==m)
					System.out.println("pattern found at "+i);
			}
		}
		
		public static int[] preProcess(String s) {  
			int[] res=new int[s.length()];
			
			int j=0;
			for(int i=1;i<s.length();i++){
				while(j>0&&s.charAt(i)!=s.charAt(j))
					j=res[j-1];
				
				if(s.charAt(i)==s.charAt(j))
					j++;
				res[i]=j;
			}
			System.out.println(java.util.Arrays.toString(res));  
			return res;
		}
		
		public static void KMP(String pattern, String text) { 
			int[] next=preProcess(pattern);
			
			int j=0;
			
			for(int i=0;i<text.length();i++){
				//找到匹配的字符时才执行  
				while(j>0&&pattern.charAt(j)!=text.charAt(i))
					j=next[j-1];//设置为source中合适的位置
				//找到一个匹配的字符  
				if(pattern.charAt(j)==text.charAt(i))
					j++;
				//匹配到一个，输出结果 
				if(j==pattern.length()){
					j=next[j-1];
					System.out.println("found at index "+(i-pattern.length()+1));
				}
			}
		}
		
		public static TreeNode convertBSTtoDLL(TreeNode root){
			if(root==null)
				return null;
			TreeNode head= convertBST2DLLUtil(root);
			
			while(head.left!=null)
			head=head.left;
			return head;
		}
		
		public static TreeNode convertBST2DLLUtil(TreeNode root){
			if(root==null)
				return null;
			if(root.left!=null){
				TreeNode left=convertBST2DLLUtil(root.left);
				
				while(left!=null&&left.right!=null)
					left=left.right;
				
				left.right=root;
				root.left=left;
			}
			if(root.right!=null){
				TreeNode right=convertBST2DLLUtil(root.right);
				
				while(right!=null&&right.left!=null)
					right=right.left;
				root.right=right;
				right.left=root;
			}
			
			return root;
		}
		
		public static int largestIndependentSet(TreeNode root){
			if(root==null)
				return 0;
			int maxWithoutCur=largestIndependentSet(root.left)+largestIndependentSet(root.right);
			int maxWithCur=1;
			if(root.left!=null)
				maxWithCur=largestIndependentSet(root.left.left)+
				largestIndependentSet(root.left.right);
			
			if(root.right!=null)
				maxWithCur=largestIndependentSet(root.right.left)+
				largestIndependentSet(root.right.right);
			
			return maxWithCur>maxWithoutCur?maxWithCur:maxWithoutCur;
		}
		
		
		public static TreeNode addGreaterTree(TreeNode root){
			if(root==null)
				return null;
			int[] sum={0};
			addGreaterTree(root, sum);
			return root;
		}
		
		public static void addGreaterTree(TreeNode root, int[] sum){
			if(root==null)
				return;
			
			addGreaterTree(root.right,sum);
			sum[0]+=root.val;
			
			root.val=sum[0];
			
			addGreaterTree(root.left,sum);
		}
		
		static TreeNode node1=null;
		static TreeNode node2=null;
		static TreeNode middle=null;
		static TreeNode previous=null;
		
		public static void correctBST(TreeNode root ){
			if(root==null)
				return;

			correctBSTUtil(root);
			if(node1!=null&&node2!=null){
				int t=node1.val;
				node1.val=node2.val;
				node2.val=t;
			}
			else if(node1!=null&&middle!=null){
				int t=node1.val;
				node1.val=middle.val;
				middle.val=t;
			}
		}
		
		public static void correctBSTUtil(TreeNode root){
			if(root==null)
				return;
			
			correctBSTUtil(root.left);
			if(previous!=null&&previous.val>root.val){
				if(node1==null){
					node1=previous;
					middle=root;
				}
				else
					node2=root;					
			}
			previous=root;
			
			correctBSTUtil(root.right);
		}
		
		public static void printBoundary (TreeNode root){
			if(root==null)
				return;
			System.out.print(root.val+" ");
			printLeftBoundary(root.left);
			printLeaves(root.left);
			printLeaves(root.right);
			printRightBoundary(root.right);
		}
		
		public static void printLeftBoundary(TreeNode root){
			if(root==null)
				return;
			if(root.left!=null){
				System.out.print(root.val+" ");
				printLeftBoundary(root.left);
			}
			else if(root.right!=null){
				System.out.print(root.val+" ");
				printLeftBoundary(root.right);
			}
		}
		
		public static void printRightBoundary(TreeNode root){
			if(root==null)
				return;
			if(root.right!=null){
				printRightBoundary(root.right);
				System.out.print(root.val+" ");
			}
			else if(root.left!=null){
				printRightBoundary(root.left);
				System.out.print(root.val+" ");
			}
		}
		
		public static void printLeaves(TreeNode root){
			if(root==null)
				return;
			printLeaves(root.left);
			if(root.left==null&&root.right==null)
				System.out.print(root.val+" ");
			printLeaves(root.right);
		}
		
		public static int largestBSTSize(TreeNode root){
			if(root==null)
				return 0;
			if(isBST(root))
				return size(root);
			else
				return Math.max(largestBSTSize(root.left),largestBSTSize(root.right));
		}
		
		public static int size(TreeNode root){
			if(root==null)
				return 0;
			return size(root.left)+size(root.right)+1;
		}
		
		
		public static void populateNext(TreeLinkNode root){
			TreeLinkNode ancestor=null;
			populateNextUtil(root, ancestor);
		}
		
		public static void populateNextUtil(TreeLinkNode root, TreeLinkNode ancestor){
			if(root==null)
				return;
			if(root.right!=null){
				TreeLinkNode cur=root.right;
				while(cur.left!=null)
					cur=cur.left;
				
				root.next=cur;
			}
			else
				root.next=ancestor;
			
			populateNextUtil(root.left,root);
			populateNextUtil(root.right,ancestor);
			
		}
		
		
		static TreeLinkNode next=null;

		public static void populateNext2(TreeLinkNode root){
			if(root==null)
				return;
			populateNext2(root.right);
			root.next=next;
			next=root;
			
			populateNext2(root.left);
		}
		
		public static int maxSum(int[] A){
			if(A.length==0)
				return 0;
			if(A.length==1)
				return A[0];
			if(A.length==2)
				return Math.max(A[0], A[1]);
			
			int[] dp=new int[A.length];
			dp[0]=A[0];
			dp[1]=Math.max(A[0], A[1]);
			
			for(int i=2;i<A.length;i++){
				dp[i]=Math.max(dp[i-1], dp[i-2]+A[i]);
			}
			
			return dp[A.length-1];
		}
		
		
		public static int doubleSquare(int m) {
			int p=(int) Math.sqrt((double)(m/2.0));
			int total=0;
			for(int i=0;i<=p;i++){
				double j=Math.sqrt(m-i*i);
				if(j-(int)j==0.0)
					total++;
			}
			return total;
		}
		
		static class HeightComparator implements Comparator<HeightPair>{

			@Override
			public int compare(HeightPair o1, HeightPair o2) {
				// TODO Auto-generated method stub
				return o2.height-o1.height;
			}
			
		}
	
		public static void rearrangeHeight(int[] A, int[] B){
			ArrayList<HeightPair> hp=new ArrayList<HeightPair>();
			
			for(int i=0;i<A.length;i++){
				hp.add(new HeightPair(A[i],B[i]));
			}
			
			Collections.sort(hp,new HeightComparator());
			
			
//			System.out.println(Arrays.toString(A));
			ArrayList<Integer> res=new ArrayList<Integer>();
			for(int k=0;k<hp.size();k++){
//				System.out.println(hp.get(k).height+" "+hp.get(k).count);
				res.add(hp.get(k).count, hp.get(k).height);
			}
			
			
			System.out.println(res);
		}
		
		public static int getInversionCount(int[] A){
			if(A.length<2)
				return 0;
			int count=0;
			for(int i=0;i<A.length-1;i++){
				int num=A[i];
				for(int j=i+1;j<A.length;j++){
					if(num>A[j])
						count++;
				}
			}
			return count;
		}
		
		public static int getInversionCountMergeSort(int[] arr){
			int[] tmp=new int[arr.length];
			
			return mergeSort(arr, tmp, 0, arr.length-1);
		}
		
		public static int mergeSort(int[] arr, int[] tmp, int left, int right){
			int count=0;
			if(right>left){
				int mid=left+(right-left)/2;
				/* Inversion count will be sum of inversions in left-part, right-part
			      and number of inversions in merging */
				count=mergeSort(arr, tmp,left, mid);
				count+=mergeSort(arr, tmp,mid+1,right);
				/*Merge the two parts*/
				count+=merge(arr, tmp, left, mid+1,right);
			}
			return count;				
		}
		
		public static int merge(int[] arr, int [] tmp, int left, int mid, int right){
			int count=0;
			int i=left;
			int j=mid;
			int k=left;
			
			while(i<mid&&j<=right){
				if(arr[i]<arr[j])
					tmp[k++]=arr[i++];
				else{
					tmp[k++]=arr[j++];
//					left and right subarrays are sorted, 
//					so all the remaining elements in left-subarray
//					(a[i+1], a[i+2] … a[mid]) will be greater than a[j]
					count+=mid-i;
				}
			}
			
			while(i<mid)
				tmp[k++]=arr[i++];
			
			while(j<=right)
				tmp[k++]=arr[j++];
			
			/*Copy back the merged elements to original array*/
			  for (i=left; i <= right; i++)
			    arr[i] = tmp[i];
			  
			  return count;
		}
		
		public static TreeNode constructTree(int pre[], char preLN[]){
			if(pre.length==0)
				return null;
			int[] index={0};
			return constructTreeUtil(pre, preLN, index);
		}
		
		public static TreeNode constructTreeUtil(int[] pre, char[] preLN, int[] index){
			int idx=index[0];
			if(idx==pre.length)
				return null;
			
			TreeNode root=new TreeNode(pre[idx]);
			index[0]++;
			
			if(preLN[idx]=='N'){
				root.left=constructTreeUtil(pre,preLN,index);
				root.right=constructTreeUtil(pre,preLN,index);
			}
			
			return root;
		}
		
		public static TreeNode buildTree(int[] inorder){
			if(inorder.length==0)
				return null;
			return buildTreeUtil(inorder, 0, inorder.length-1);
		}
		
		public static TreeNode buildTreeUtil(int[]inorder, int left, int right){
			if(right<left)
				return null;
			int index=maxValue(inorder, left, right);
			TreeNode root=new TreeNode(inorder[index]);
			
			root.left=buildTreeUtil(inorder,left, index-1);
			root.right=buildTreeUtil(inorder,index+1, right);
			return root;
		}
		
		public static int maxValue(int[] inorder, int left, int right){
			int max=inorder[left];
			int index=left;
			for(int i=left+1;i<=right;i++){
				if(inorder[i]>max){
					max=inorder[i];
					index=i;
				}
			}
			return index;
		}
		
		public static boolean isSubtree(TreeNode T, TreeNode S){
			if(S==null)
				return true;
			if(T==null)
				return false;
			if(isIdentical(T,S))
				return true;
			return isSubtree(T.left,S)||isSubtree(T.right,S);
		}
		
		public static boolean isIdentical(TreeNode root1, TreeNode root2){
			if(root1==null&&root2==null)
				return true;
			if(root1==null||root2==null)
				return false;
			if(root1.val!=root2.val)
				return false;
			return isIdentical(root1.left,root2.left)&&
					isIdentical(root1.right,root2.right);
		}
		
		public static void printKeysInRange(TreeNode root, int k1, int k2){
			if(root==null)
				return;
			if(root.val>k1)
				printKeysInRange(root.left,k1,k2);
			if(k1<=root.val&&root.val<=k2)
				System.out.print(root.val+" ");
			if(root.val<k2)
				printKeysInRange(root.right,k1,k2);
		}
		
		public static TreeNode inOrderSuccessor(TreeNode root, TreeNode node){
			if(root==null)
				return null;
			if(node.right!=null)
				return minValue(root.right);
			TreeNode succ=null;
			
			while(root!=null){
				if(root.val>node.val){
					succ=root;
					root=root.left;
				}
				else if(root.val<node.val)
					root=root.right;
				else break;
			}
			return succ;
		}
		
		public static TreeNode minValue(TreeNode root){
			if(root==null)
				return null;
			TreeNode cur=root;
			while(cur.left!=null){
				cur=cur.left;
			}
			return cur;
		}
		
		public static void printKDistant(TreeNode root, int k){
			if(root==null)
				return;
			if(k==0)
				System.out.print(root.val+" ");
			printKDistant(root.left,k-1);
			printKDistant(root.right,k-1);
		}
		
		
		public static void doubleTree(TreeNode root){
			if(root==null)
				return;
			TreeNode left=root.left;
			TreeNode node=new TreeNode(root.val);
			root.left=node;
			node.left=left;
			doubleTree(left);
			doubleTree(root.right);
		}
		
		public static int getMaxWidth(TreeNode root){
			if(root==null)
				return 0;
			int h=getHeight(root);
			int maxWidth=0;
			
			for(int i=1;i<=h;i++){
				int wid=getWidth(root,i);
				maxWidth=maxWidth<wid?wid:maxWidth;
			}
			return  maxWidth;
		}
		
		public static int getWidth(TreeNode root, int level){
			if(root==null)
				return 0;
			if(level==1)
				return 1;
			
			return getWidth(root.left,level-1)+getWidth(root.right,level-1);
		}
		
		public static ArrayList<ArrayList<Integer>> printPaths(TreeNode root){
			ArrayList<ArrayList<Integer>> res=new ArrayList<ArrayList<Integer>>();
			if(root==null)
				return res;
			ArrayList<Integer> sol=new ArrayList<Integer>();
			
			printPathsUtil(root, sol, res);
			return res;
		}
		
		public static void printPathsUtil(TreeNode root, ArrayList<Integer> sol,ArrayList<ArrayList<Integer>> res){
			if(root==null)
				return;
			sol.add(root.val);
			if(root.left==null&&root.right==null){
//				System.out.println(sol);
				ArrayList<Integer> out=new ArrayList<Integer>(sol);
				res.add(out);
			}
			printPathsUtil(root.left,sol,res);
			printPathsUtil(root.right,sol,res);
			sol.remove(sol.size()-1);
		}
		
		public static boolean isSumTree(TreeNode root){
			if(root==null||(root.left==null&&root.right==null))
				return true;
			int ls=sum(root.left);
			int rs=sum(root.right);
			if(root.val!=ls+rs)
				return false;
			return isSumTree(root.left)&&isSumTree(root.right);
		}
		public static int sum(TreeNode root){
			if(root==null)
				return 0;
			return sum(root.left)+sum(root.right)+root.val;
		}
		
		public static boolean isLeaf(TreeNode node){
			if(node==null)
				return false;
			return node.left==null&&node.right==null;
		}
		public static boolean isSumTree2(TreeNode root){
			if(root==null||isLeaf(root))
					return true;
			
			if(isSumTree2(root.left)&&isSumTree2(root.right)){
				int ls,rs;
				if(root.left==null)
					ls=0;
				else if(isLeaf(root.left))
					ls=root.left.val;
				else
					ls=2*root.left.val;
				
				if(root.right==null)
					rs=0;
				else if(isLeaf(root.right))
					rs=root.right.val;
				else
					rs=2*root.right.val;
				
				return root.val==ls+rs;
			}
			return false;
		}
		
		public static boolean isSumProperty(TreeNode root){
			if(root==null||(root.left==null&&root.right==null))
				return true;
			int right = 0, left = 0;
			if(root.left!=null)
				left=root.left.val;
			if(root.right!=null)
				right=root.right.val;
			
			if(root.val==(left+right)&&isSumProperty(root.left)&&isSumProperty(root.right))
				return true;
			else
				return false;
		}
		
//		Convert an arbitrary Binary Tree to a tree that holds Children Sum Property// sumtree
		
		public static void convertTree(TreeNode root){
			if(root==null||(root.left==null&&root.right==null))
				return;
			int leftData=0;
			int rightData=0;
			
			convertTree(root.left);
			convertTree(root.right);
			
			if(root.left!=null)
				leftData=root.left.val;
			if(root.right!=null)
				rightData=root.right.val;
			
			int diff=leftData+rightData-root.val;
			if(diff==0)
				return;
			else if(diff>0)
				root.val+=diff;
			else
				increment(root, -diff);
			
		}
		
		public static void increment(TreeNode root, int diff){
			if(root==null)
				return;
			if(root.left!=null){
				root.left.val+=diff;
				increment(root.left,diff);
			}
			else if(root.right!=null){
				root.right.val+=diff;
				increment(root.right,diff);
			}
		}
		
		
		public static int[] countCharArray(String str){
			int[] count=new int[256];
			
			for(int i=0;i<str.length();i++)
				count[str.charAt(i)]++;
			return count;
		}
		
		public static char firstNonRepeating(String str){
			int[] count=countCharArray(str);
			int index=-1;
			
			for(int i=0;i<str.length();i++){
				if(count[str.charAt(i)]==1){
					index=i;
					break;
				}
			}
			return str.charAt(index);
		}
		
		public static CountIndex[] getCharCountArray(String str){
			CountIndex[] count=new CountIndex[256];
			
			for(int i=0;i<str.length();i++){
				if(count[str.charAt(i)]==null){
					count[str.charAt(i)]=new CountIndex(1,i);
				}
				else
					count[str.charAt(i)].count++;
			}
			return count;
		}
		
		public static char firstNonRepeatingChar(String str){
			CountIndex[] count=getCharCountArray(str);

			int index=Integer.MAX_VALUE;
			for(int i=0;i<count.length;i++){
				if(count[i]!=null){
					if(count[i].count==1&&index>count[i].index)
						index=count[i].index;
				}
			}
			return str.charAt(index);
		}
		
		public static ArrayList<ArrayList<Integer>> findAllPairs(int[] arr){
			ArrayList<ArrayList<Integer>> res=new ArrayList<ArrayList<Integer>>();
			if(arr.length<2)
				return res;
			Arrays.sort(arr);
			ArrayList<Integer> sol=new ArrayList<Integer>();
			findAllPairs(arr, 0, 2,sol,res, 0);
			return res;
		}
		
		public static void findAllPairs(int[] arr, int dep, int maxDep,ArrayList<Integer> sol, ArrayList<ArrayList<Integer>> res,int cur){
			if(dep==maxDep){
				ArrayList<Integer> out=new ArrayList<Integer>(sol);
				if(!res.contains(out))
					res.add(out);
			}
			
			for(int i=cur;i<arr.length;i++){
				sol.add(arr[i]);
				findAllPairs(arr, dep+1,maxDep,sol, res, i+1);
				sol.remove(sol.size()-1);
			}
				
		}
		
		
		public static boolean hasPathSum2(TreeNode root, int sum){
			if(root==null)
				return sum==0;
			
			boolean ans=false;
			sum-=root.val;
			if(sum==0&&root.left==null&&root.right==null)
				return true;
			
			if(root.left!=null)
				ans=ans||hasPathSum2(root.left,sum);
			
			if(root.right!=null)
				ans=ans||hasPathSum2(root.right,sum);
			return ans;
		}
		
		public static TreeNode lcaBST(TreeNode root, TreeNode node1, TreeNode node2){
			if(root==null)
				return null;
			
			if(root.val>node1.val&&root.val>node2.val)
				return lcaBST(root.left,node1,node2);
			
			if(root.val<node1.val&&root.val<node2.val)
				return lcaBST(root.right,node1,node2);
			return root;
		}
		
		public static TreeNode lcaBST2(TreeNode root, TreeNode node1, TreeNode node2){
			if(root==null)
				return null;
			
			while(root!=null){
				if(root.val>node1.val&&root.val>node2.val)
					root=root.left;
				else if(root.val<node1.val&&root.val<node2.val)
					root=root.right;
				else
					break;
			}
			return root;
		}
		
		public static void printSpiral(TreeNode root){
			if(root==null)
				return;
			
			int h=getHeight(root);
			boolean ltr=false;
			
			for(int i=1;i<=h;i++){
				printSpiral(root,i,ltr);
				ltr=!ltr;
				System.out.println();
			}			
		}
		
		public static void printSpiral(TreeNode root, int level, boolean ltr){
			if(root==null)
				return;
			if(level==1)
				System.out.print(root.val+" ");
			
			if(ltr){
				printSpiral(root.left,level-1,ltr);
				printSpiral(root.right,level-1,ltr);
			}
			else{
				printSpiral(root.right,level-1,ltr);
				printSpiral(root.left,level-1,ltr);
			}
		}
		
		static TreeNode prev=null;
		static TreeNode head=null;
//		public static TreeNode treeToCircularDoublyList(TreeNode root){
//			if(root==null)
//				return null;			
//			
//			treeToCircularDoublyList(root, prev, head);
//			return head;
//		}
		
		public static TreeNode treeToCircularDoublyList(TreeNode root){
			if(root==null)
				return null;
			treeToCircularDoublyList(root.left);
			root.left=prev;
			if(prev!=null)
				prev.right=root;
			else
				head=root;
			
			TreeNode right=root.right;
			
			//make it circular
			head.left=root;
			root.right=head;
			
			
			prev=root;
			
			treeToCircularDoublyList(right);
			return head;
			
		}
		
		public static int maxDiff2(int arr[]){
			if(arr.length<2)
				return 0;
			int maxdif=arr[1]-arr[0];
			int min=arr[0];
			
			for(int i=1;i<arr.length;i++){
				if(arr[i]-min>maxdif)
					maxdif=arr[i]-min;
				if(arr[i]<min)
					min=arr[i];
			}
			return maxdif;
		}
		
		public static void printMaxSubSquare(int[][] matrix){
			int m=matrix.length;
			int n=matrix[0].length;
			
			int[][] s=new int[m][n];
			
			for(int i=0;i<m;i++)
				s[i][0]=matrix[i][0];
			
			for(int j=0;j<n;j++)
				s[0][j]=matrix[0][j];
			
			for(int i=1;i<m;i++){
				for(int j=1;j<n;j++){
					if(matrix[i][j]==1)
						s[i][j]=Math.min(s[i-1][j-1], Math.min(s[i-1][j], s[i][j-1]))+1;
					else
						s[i][j]=0;
				}
			}
			int maxsub=0;
			int row=0;
			int col=0;
			for(int i=0;i<m;i++){
				for(int j=0;j<n;j++){
					if(s[i][j]>maxsub){
						maxsub=s[i][j];
						row=i;
						col=j;
					}
				}
			}
			
//			System.out.println(maxsub+" "+ row+" "+col+" "+m+" "+n);
			for(int i=row;i>row-maxsub;i--){
				for(int j=col;j>col-maxsub;j--)
					System.out.print(matrix[i][j]+" ");
				System.out.println();
			}
		}
		
		public static void findSamllestand2ndSmallest(int[] arr){
			if(arr.length<2)
				return;
			int first=Integer.MAX_VALUE;
			int second=Integer.MAX_VALUE;
			for(int i=0;i<arr.length;i++){
				if(arr[i]<first){
					second=first;
					first=arr[i];
				}
				else if(arr[i]<second&&arr[i]!=first)
					second=arr[i];
			}
			System.out.println("smallest is "+first+" and second smallest is "+second);
		}
		
		public static void findLeaders(int[] arr){
			if(arr.length==0)
				return;
			int n=arr.length;
			int max=Integer.MIN_VALUE;
			
			for(int i=n-1;i>=0;i--){
				if(arr[i]>max){
					System.out.print(arr[i]+" ");
					max=arr[i];
				}
					
			}
			System.out.println();
		}
		
		static class NumCountComparator implements Comparator<NumCounts>{

			@Override
			public int compare(NumCounts o1, NumCounts o2) {
				// TODO Auto-generated method stub
				if(o1.count>o2.count)
					return -1;
				else if(o1.count<o2.count)
					return 1;
				else
					return o1.firstIndex-o2.firstIndex;
			}
			
		}
		
		public static void sortByFrequency(int[] arr){
			ArrayList<NumCounts> lst=new ArrayList<NumCounts>();
			HashMap<Integer, NumCounts> map=new HashMap<Integer, NumCounts>();
			for(int i=0;i<arr.length;i++){
				if(!map.containsKey(arr[i])){
					map.put(arr[i], new NumCounts(arr[i],i,1));
				}
				else{
					map.get(arr[i]).count++;
				}
			}
			Iterator<Integer> it=map.keySet().iterator();
			
			while(it.hasNext()){
				int key=it.next();
				lst.add(map.get(key));
			}
			
			Collections.sort(lst, new NumCountComparator());
			
			for(int i=0;i<lst.size();i++){
				for(int j=0;j<lst.get(i).count;j++){
					System.out.print(lst.get(i).num+" ");
				}
			}
			System.out.println();
		}
		
		
		public void printSubTreeWeight(List<CSVNode> nodes) {
			if(nodes.size()==0)
				return;
			
			HashMap<Integer, ArrayList<CSVNode>> map=new HashMap<Integer, ArrayList<CSVNode>>();
			CSVNode root=null;
			for(CSVNode node:nodes){
				int parent=node.parent;
				if(parent==0)
					root=node;
				if(!map.containsKey(parent))
					map.put(parent, new ArrayList<CSVNode>());
				else
					map.get(parent).add(node);
			}
			
			sumWeight(root, map);
		}
		
		public static int sumWeight(CSVNode node, HashMap<Integer, ArrayList<CSVNode>> map){
			int weight=node.weight;
			
			if(map.containsKey(node.id)){
				for(CSVNode child:map.get(node.id)){
					weight+=sumWeight(child,map);
				}
			}
			
			System.out.println("Weight for " + node.id + " is " + weight);
			return weight;
		}
		
		
		public static int findFirstEleRotatedAarray(int[] arr){
			if(arr.length==0)
				return -1;
			int beg=0;
			int end=arr.length-1;
			
			while(beg<end){
				int mid=(beg+end)/2;
				if(mid<1||mid>arr.length-1)
					return arr[mid];
				if(arr[mid]<arr[mid-1]&&arr[mid]<arr[mid+1])
					return arr[mid];
				else if(arr[beg]<=arr[mid]){
					if(arr[beg]<arr[mid+1])
						end=mid-1;
					else
						beg=mid+1;
				}
				else if(arr[mid]<arr[end]){
					if(arr[mid-1]>arr[end])
						beg=mid+1;
					else
						end=mid-1;
				}
			}
			return arr[beg];
		}
		
		
		public static int findMinRotatedArray(int[] arr){
			return findMinRotatedArray(arr,0,arr.length-1);
		}
		
		public static int findMinRotatedArray(int[] arr, int low, int high){
			if(low>high)
				return arr[0];
			if(low==high)
				return arr[low];
			
			int mid=low+(high-low)/2;
			
			if(mid<high&&arr[mid+1]<arr[mid])
				return arr[mid+1];
			
			if(mid>low&&arr[mid-1]>arr[mid])
				return arr[mid];
			
			if(arr[mid]<arr[high])
				return findMinRotatedArray(arr,low,mid-1);
			else
				return findMinRotatedArray(arr,mid+1,high);
		}
		
		public static int findMin(int[] arr){
			return findMin(arr, 0, arr.length-1);
		}
		
		public static int findMin(int[] arr, int low, int high){
			if(low==high)
				return arr[low];
			if(low==high-1){
				return arr[low]>arr[high]?arr[high]:arr[low];
			}
			
			if(arr[low]<arr[high])
				return arr[low];
			
			int mid=(low+high)/2;
			if(arr[mid]>=arr[low])
				return findMin(arr, mid,high);
			else
				return findMin(arr,low,mid);				
		
		}
		
		public static int findMin2(int[] a, int left, int right){
		     
		    //one element
		    if(left == right){
		        return a[left];
		    }
		     
		    //two elements
		    if(left == right-1){
		        return a[left]<a[right]? a[left]: a[right];
		    }
		     
		    //the array is ordered
		    if(a[left] < a[right]){
		        return a[left];
		    }
		     
		    int mid = (left+right)/2;
		     
		    if(a[mid] > a[left]){
		        return findMin(a, mid, right);
		    }else if(a[mid] < a[left]){
		        return findMin(a, left, mid);
		    }else{ //when a[mid] == a[left], we have to search both side
		        return Math.min(findMin(a, mid, right), findMin(a, left, mid));
		    }
		     
		}
		
		public static int findMax(int[] arr){
			if(arr.length==0)
				return -1;
			if(arr.length==1)
				return arr[0];
			int left=0;
			int right=arr.length-1;
			
			while(left<right){
				int mid=left+(right-left)/2;
				if(mid==0||mid==arr.length-1||arr[mid]>arr[mid+1])
					return arr[mid];
				else if(arr[mid]>arr[left])
					left=mid;
				else
					right=mid;
			}
			return -1;
		}
		
		public static int getMin(int[] arr){
			int min=arr[0];
			for(int i=1;i<arr.length;i++){
				if(min>arr[i])
					min=arr[i];
			}
			return min;
		}
		
		public static int getMax(int[] arr){
			int max=arr[0];
			for(int i=1;i<arr.length;i++){
				if(max<arr[i])
					max=arr[i];
			}
			return max;
		}
		public static boolean areConsecutive(int arr[]){
			if(arr.length<1)
				return false;
			
			int min=getMin(arr);
			int max=getMax(arr);
			int n=arr.length;
			
			if(max-min+1==n){
				boolean[] visited=new boolean[arr.length];
				
				for(int i=0;i<n;i++){
					if(visited[arr[i]-min])
						return false;
					visited[arr[i]-min]=true;
				}
				return true;
			}
			return false;			
			
		}
		
		public static boolean areConsecutive2(int arr[]){
			if(arr.length<1)
				return false;
			
			int min=getMin(arr);
			int max=getMax(arr);
			int n=arr.length;
			
			if(max-min+1==n){
				
				for(int i=0;i<n;i++){
					int j;
					if(arr[i]<0)
						j=-arr[i]-min;
					else
						j=arr[i]-min;
					
					if(arr[j]<0)
						return false;
					else
						arr[j]=-arr[j];
				}
				return true;
			}
			return false;			
			
		}
		
		public static int findFirstMissing(int[] arr){
			if(arr.length==0)
				return -1;
			return findFirstMissing(arr, 0, arr.length-1);
		}
		
		public static int findFirstMissing(int[] arr, int beg, int end){
			if(beg>end)
				return end+1;
			if(beg!=arr[beg])
				return beg;
			
			int mid=beg+(end-beg)/2;
			
			if(arr[mid]>mid)
				return findFirstMissing(arr,beg, mid-1);//or mid?
			else
				return findFirstMissing(arr, mid+1, end);
		}
		
		public static void printRepeating(int arr[]){
			if(arr.length<4)
				return;
			int n=arr.length-2;
			int s=0;
			int p=1;
			
			for(int i=0;i<arr.length;i++){
				s+=arr[i];
				p*=arr[i];
			}
			s=s-(n+1)*n/2;
			p=p/factorial(n);
			
			int d=(int) Math.sqrt(s*s-4*p);
			
			int x=(s+d)/2;
			int y=(s-d)/2;
			System.out.println(x+" and "+y);
		}
		
		public static int factorial(int n){
			if(n==1)
				return 1;
			return n*factorial(n-1);
		}
		
		public static void printRepeating2(int arr[]){
			if(arr.length<4)
				return;
			int n=arr.length-2;
			int xor=arr[0];
			
			for(int i=0;i<arr.length;i++)
				xor^=arr[i];
			for(int i=1;i<=n;i++)
				xor^=i;
			
			int rightMost=xor&~(xor-1);
			int x=0;
			int y=0;
			for(int i=0;i<arr.length;i++){
				if((arr[i]&rightMost)==0)
					x^=arr[i];
				else
					y^=arr[i];
			}
			
			for(int i=1;i<=n;i++){
				if((i&rightMost)==0)
					x^=i;
				else
					y^=i;
			}
			System.out.println(x+" and "+y);
			
		}
		
		public static int findTurnPoint(int[] arr){
			if(arr.length==0)
				return -1;
			return findTurnPoint(arr, 0, arr.length-1);
		}
		
		public static int findTurnPoint(int[] arr, int left, int right){
			if(left==right)
				return arr[left];
			if(left==right-1)
				return arr[left]>arr[right]?arr[left]:arr[right];
			
			int mid=left+(right-left)/2;
			
			if(arr[mid]>arr[mid-1]&&arr[mid]>arr[mid+1])
				return arr[mid];
			else if(arr[mid]>arr[mid-1])
				return findTurnPoint(arr,mid+1, right);
			else
				return findTurnPoint(arr, left, mid-1);
		}
		
		public static int findTurnPoint2(int[] arr){
			if(arr.length==0)
				return -1;
			
			int beg=0;
			int end=arr.length-1;
			
			while(beg<end){
				int mid=beg+(end-beg)/2;
				if(arr[mid]>arr[mid-1]&&arr[mid]>arr[mid+1])
					return arr[mid];
				else if(arr[mid]>arr[mid-1])
					beg=mid+1;
				else
					end=mid-1;
			}
			return arr[beg];
		}
		
		
		public static void sort012(int[] arr){
			if(arr.length<2)
				return;
			int i=0;;
			int j=arr.length-1;
			int k=arr.length-1;
			
			while(i<=j){
				if(arr[i]==2){
					int t=arr[i];
					arr[i]=arr[k];
					arr[k]=t;
					k--;
					if(j>k)
						j--;
				}
				else if(arr[i]==1){
					int t=arr[i];
					arr[i]=arr[j];
					arr[j]=t;
					j--;
				}
				else
					i++;
			}
		}
		
		public static void sortColors012(int[] arr){
			if(arr.length<2)
				return;
			
			int low=0;
			int mid=0;
			int high=arr.length-1;
			
			while(mid<=high){
				switch(arr[mid]){
				case 0:
					swap(arr, low++, mid++);
					break;
				case 1:
					mid++;
					break;
				case 2:
					swap(arr,mid,high--);
					break;
				}
			}
		}
		// given array, out array each element is the multiplication of all the elements except itself
		public static int[] productArray(int arr[]){
			int n=arr.length;
			int[] prod=new int[n];
			
			int[] left=new int[n];
			left[0]=1;
			for(int i=1;i<n;i++){
				left[i]=left[i-1]*arr[i-1];
			}
			
			int[] right=new int[n];
			right[n-1]=1;
			for(int i=n-2;i>=0;i--){
				right[i]=right[i+1]*arr[i+1];
			}
			
			for(int i=0;i<n;i++)
				prod[i]=left[i]*right[i];
			return prod;
		}
		// constant space
		public static int[] productArray2(int arr[]){
			int n=arr.length;
			int[] prod=new int[n];
			
			int tmp=1;
			
			for(int i=0;i<n;i++){
				prod[i]=tmp;
				tmp*=arr[i];
			}
			tmp=1;
			
			for(int i=n-1;i>=0;i--){
				prod[i]*=tmp;
				tmp*=arr[i];
			}
			return prod;
		}
		
//		Given an array of n elements which contains elements from 0 to n-1,
//		with any of these numbers appearing any number of times. 
//		Find these repeating numbers
		
		public static void printRepeatingAnyTimes(int arr[]){
			if(arr.length<2)
				return;
			for(int i=0;i<arr.length;i++){
				if(arr[Math.abs(arr[i])]>=0)
					arr[Math.abs(arr[i])]=-arr[Math.abs(arr[i])];
				else
					System.out.println(Math.abs(arr[i]));
			}
		}
		
		public static int equilibrium(int arr[]){
			if(arr.length==0)
				return -1;
			int sum=0;
			for(int i=0;i<arr.length;i++)
				sum+=arr[i];
			
			int leftsum=0;
			for(int i=0;i<arr.length;i++){
				sum-=arr[i];
				if(leftsum==sum)
					return i;
				leftsum+=arr[i];
				
			}
			return -1;
		}
		
		public static void finMinLengthMakeSorted(int[] arr){
			if(arr.length<2)
				return;
			int s=0;
			int end=0;
			
			for(int i=0;i<arr.length-1;i++){
				if(arr[i]>arr[i+1]){
					s=i;
					break;
				}
			}
			
			for(int i=arr.length-1;i>0;i--){
				if(arr[i]<arr[i-1]){
					end=i;
					break;
				}
			}
			
			int min=arr[s];
			int max=arr[s];
			
			for(int i=s;i<=end;i++){
				if(arr[i]>max)
					max=arr[i];
				if(arr[i]<min)
					min=arr[i];
			}
			
			for(int i=0;i<s;i++){
				if(arr[i]>min){
					s=i;
					break;
				}
			}
			
			for(int i=arr.length-1;i>end;i--){
				if(arr[i]<max){
					end=i;
					break;
				}
			}
			System.out.printf(" The unsorted subarray which makes the given array"
					+ " sorted lies between the indexes %d and %d", s, end);
		}
		
		public static int findFixedPoint(int[] arr){
			if(arr.length==0)
				return -1;
			int beg=0;
			int end=arr.length-1;
			
			while(beg<=end){
				int mid=beg+(end-beg)/2;
				if(arr[mid]==mid)
					return mid;
				else if(arr[mid]<mid)
					beg=mid+1;
				else
					end=mid-1;
			}
			return -1;
		}
		public static void printNGE(int arr[]){
			if(arr.length<2)
				return;
			Stack<Integer> stk=new Stack<Integer>();
			stk.push(arr[0]);
			
			for(int i=1;i<arr.length;i++){
				int next=arr[i];
				if(!stk.isEmpty()){
					int ele=stk.pop();
					
					while(next>ele){
						System.out.println("the NGE of "+ele +" is "+next);
						if(stk.isEmpty())
							break;
						ele=stk.pop();
					}
					if(ele>next)
						stk.push(ele);
				}
				stk.push(next);
			}
			int next=-1;
			while(!stk.isEmpty()){
				int ele=stk.pop();
				System.out.println("the NGE of "+ele +" is "+next);
			}
		}
		
		public static int maxIndexDiff(int arr[]){
			if(arr.length<2)
				return -1;
			int maxDif=0;
			
			for(int i=0;i<arr.length-1;i++){
				for(int j=i+1;j<arr.length;j++){
					if(arr[j]>arr[i]&&j-i>maxDif)
						maxDif=j-i;
				}
			}
			return maxDif;
		}
		
		public static int maxIndexDiff2(int arr[]){
			if(arr.length<2)
				return -1;
			
			int maxDif=0;
			int n=arr.length;
			int[] LMin=new int[n];
			LMin[0]=arr[0];
			
			for(int i=1;i<n;i++)
				LMin[i]=Math.min(LMin[i-1], arr[i]);
			
			int[] RMax=new int[n];
			RMax[n-1]=arr[n-1];
			
			for(int i=n-2;i>=0;i--)
				RMax[i]=Math.max(RMax[i+1], arr[i]);
			
			int i=0;
			int j=0;
			while(i<n&&j<n){
				if(LMin[i]<RMax[j]){
					maxDif=j-i>maxDif?j-i:maxDif;
					j++;
				}
				else
					i++;
//				System.out.println(maxDif+" is max diff");
			}
			
			return maxDif;
			
		}
		
		public static int minDist(int arr[], int x, int y){
			int minDis=Integer.MAX_VALUE;
			for(int i=0;i<arr.length-1;i++){
				for(int j=i+1;j<arr.length;j++){
					if(((arr[i]==x &&arr[j]==y)||
							(arr[i]==y&&arr[j]==x))&&Math.abs(j-i)<minDis){
						minDis=Math.abs(j-i);
					}
					
				}
			}
			return minDis;
		}
		
		public static int minDist2(int arr[], int x, int y){
			int minDis=Integer.MAX_VALUE;
			int pre=-1;
			
			for(int i=0;i<arr.length;i++){
				if(arr[i]==x||arr[i]==y){
					pre=i;
					break;
				}
			}
			for(int i=pre+1;i<arr.length;i++){
				if(arr[i]==x||arr[i]==y){
					if(arr[i]!=arr[pre]&&i-pre<minDis){
						minDis=i-pre;
						pre=i;
					}
					else
						pre=i;
				}
			}
			return minDis;
		}
		
		public static boolean isSubset(int arr1[], int arr2[]){
			int m=arr1.length;
			int n=arr2.length;
			if(m<n)
				return false;
			Arrays.sort(arr1);
			Arrays.sort(arr2);
			int i=0, j=0;
			while(i<m&&j<n){
				if(arr1[i]<arr2[j])
					i++;
				else if(arr1[i]==arr2[j]){
					i++;
					j++;
				}
				else
					return false;
			}
			if(j<n)
				return false;
			else
				return true;
		}
		
		public static int countOccurrences(int arr[], int x){
			if(arr.length==0)
				return 0;
			int first=findFirstOccurrence(arr, x);
			if(first==-1)
				return -1;
			
			int last=findLastOccurrence(arr,x);
			
			return last-first+1;
		}
		
		public static int findFirstOccurrence(int[] arr, int x){
			if(arr.length==0)
				return -1;
			int beg=0;
			int end=arr.length-1;
			while(beg<=end){
				int mid=beg+(end-beg)/2;
				if(mid==0||arr[mid]>arr[mid-1]&&arr[mid]==x)
					return mid;
				else if(arr[mid]>x)
					end=mid-1;
				else
					beg=mid+1;
			}
			return -1;
		}
		
		public static int findLastOccurrence(int[] arr, int x){
			if(arr.length==0)
				return -1;
			int beg=0;
			int end=arr.length-1;
			while(beg<=end){
				int mid=beg+(end-beg)/2;
				if(mid==arr.length-1||arr[mid]<arr[mid+1]&&arr[mid]==x)
					return mid;
				else if(arr[mid]>x)
					end=mid-1;
				else
					beg=mid+1;
			}
			return -1;
		}
		
		public static int maxLengthBitonic(int arr[]){
			if(arr.length<2)
				return arr.length;
			int n=arr.length;
			int[] left=new int[n];
			int[] right=new int[n];
			left[0]=1;
			for(int i=1;i<n;i++){
				if(arr[i]>arr[i-1])
					left[i]=left[i-1]+1;
				else
					left[i]=1;
			}
			
			right[n-1]=1;
			for(int i=n-2;i>=0;i--){
				if(arr[i]>arr[i+1])
					right[i]=right[i+1]+1;
				else
					right[i]=1;
			}
			
			int max=left[0]+right[0]-1;
			
			for(int i=1;i<n;i++){
				if(left[i]+right[i]-1>max)
					max=left[i]+right[i]-1;
			}
			return max;
		}
		
		public static BSTNode insert(BSTNode root, int data){
			if(root==null)
				return new BSTNode(data);
			else{
				if(root.val==data)
					root.count++;
				else if(root.val<data)
					root.right= insert(root.right,data);
				else
					root.left= insert(root.left,data);
			}
			return root;
		}
		
		public static void store(BSTNode root,BSTNode[] count, int index){
			if(root==null)
				return;
			store(root.left,count,index);
//			DataFreq element=new DataFreq(root.val,root.count);
			count[index++]=root;
			store(root.right,count,index);
		}
		
		static class FreqComparator implements Comparator<BSTNode>{

			@Override
			public int compare(BSTNode o1, BSTNode o2) {
				// TODO Auto-generated method stub
				return o2.count-o1.count;
			}
		}
		
		public static void sortByFrequencyBST(int arr[]){
			BSTNode root=null;
			for(int i=0;i<arr.length;i++)
				root=insert(root,arr[i]);
			
			int n=arr.length;
			BSTNode[] count=new BSTNode[n];
			
			store(root, count, 0);
			int slow=0;
			while(count[slow]!=null)
				slow++;
			
			BSTNode[] freq=new BSTNode[slow];
			for(int i=0;i<slow;i++)
				freq[i]=count[i];
			
			Arrays.sort(freq, new FreqComparator());
			
			int k=0;
			for(int i=0;i<slow;i++){
				for(int j=0;j<freq[i].count;j++){
					arr[k++]=freq[i].val;
				}
				
			}
			System.out.println(Arrays.toString(arr));
		}
		
		public static void rearrange2(int arr[]){
			int n=arr.length;
			int i=-1;
			for(int j=0;j<n;j++){
				if(arr[j]<0)
					swap(arr,++i,j);
			}
			
			int pos=i+1;
			int neg=0;
//			while(neg<pos&&pos<n){
			while(neg<pos&&pos<n&&arr[neg]<0){
				swap(arr,neg,pos);
				neg+=2;
				pos++;
			}
			System.out.println(Arrays.toString(arr));
		}
		
		public static int findPeak(int arr[]){
			if(arr.length==0)
				return -1;
			int beg=0;
			int end=arr.length-1;
			
			while(beg<=end){
				int mid=beg+(end-beg)/2;
				if(mid==0||mid==arr.length-1||arr[mid]>arr[mid-1]&&arr[mid]>arr[mid+1])
					return mid;
				else if(arr[mid]<arr[mid-1])
					end=mid-1;
				else
					beg=mid+1;
			}
			return -1;
		}
		
//		Largest subarray with equal number of 0s and 1s
		public static int findLargestSubArrayWith0s1s(int arr[]){
			if(arr.length<2)
				return -1;
			int sum=0;
			int maxSize=0;
			int startIndex=-1;
			
			for(int i=0;i<arr.length-1;i++){
				sum=arr[i]==0?-1:1;
				for(int j=i+1;j<arr.length;j++){
					if(arr[j]>0)
						sum++;
					else
						sum--;
					if(sum==0&&maxSize<j-i+1){
						maxSize=j-i+1;
						startIndex=i;
					}
				}
			}
			if(maxSize==0)
				System.out.println("No such subarray");
			else{
				System.out.printf("%d to %d", startIndex, startIndex+maxSize-1);
				System.out.println();
			}
			return maxSize;
		}
		
		public static int findLargestSubArrayWith0s1s2(int arr[]){
			int[] aux=new int[arr.length];
			for(int i=0;i<arr.length;i++){
				if(arr[i]==0)
					aux[i]=-1;
				else
					aux[i]=1;
			}
			HashMap<Integer, Integer> map=new HashMap<Integer, Integer>();
			int sum=0;
			
			int max=-1;
			for(int i=0;i<arr.length;i++){
				sum+=aux[i];
				if(sum==0){
					max=max<i?i:max;
				}
				else if(map.containsKey(sum)){
					max=i-map.get(sum)>max?i-map.get(sum):max;
				}
				else
					map.put(sum, i);
			}
			return max;
		}
		
		public static void find3Numbers(int arr[]){
			if(arr.length<3)
				return;
			int n=arr.length;
			int[] left=new int[n];
			int[] right=new int[n];
			int min=0;
			int max=n-1;
			
			left[0]=-1;
			right[n-1]=-1;
			
			for(int i=1;i<n;i++){
				if(arr[i]<=arr[min]){
					min=i;
					left[i]=-1;
				}
				else
					left[i]=min;
			}
			
			for(int j=n-2;j>=0;j--){
				if(arr[j]>=arr[max]){
					max=j;
					right[j]=-1;
				}
				else
					right[j]=max;
			}
			
			for(int i=0;i<n;i++){
				if(left[i]!=-1&&right[i]!=-1){
					System.out.println(arr[left[i]]+", "+arr[i]+", "+arr[right[i]]);
				}
			}
		}
//		Partition problem 2 subarray equal
		public static boolean findPartiion (int arr[]){
			if(arr.length<2)
				return false;
			int sum=0;
			for(int i=0;i<arr.length;i++)
				sum+=arr[i];
			if(sum%2!=0)
				return false;
			return isSubsetSum(arr, arr.length,sum/2);
		}
		
		public static boolean isSubsetSum(int[] arr, int n,int sum){
			if(sum==0)
				return true;
			if(n==0&&sum!=0)
				return false;
			if(arr[n-1]>sum)
				return isSubsetSum(arr,n-1,sum);
			return isSubsetSum(arr, n-1, sum)||isSubsetSum(arr, n-1, sum-arr[n-1]);
		}
		
		public static boolean findPartiionDp(int[] arr){
			int n=arr.length;
			int sum=0;
			for(int i=0;i<arr.length;i++)
				sum+=arr[i];
			if(sum%2!=0)
				return false;
			boolean[][] dp=new boolean[sum/2+1][n+1];
			
			for(int i=0;i<=n;i++)
				dp[0][i]=true;
			
			for(int i=1;i<=sum/2;i++)
				dp[i][0]=false;
			
			for(int i=1;i<=sum/2;i++){
				for(int j=1;j<=n;j++){
					dp[i][j]=dp[i][j-1];
					if(i>=arr[j-1])
						dp[i][j]=dp[i][j]||dp[i-arr[j-1]][j-1];
				}
			}
			
			return dp[sum/2][n];
		}
		
		
		public static int LongestIncreasingSubsequence(int[] arr){
			if(arr.length<2)
				return arr.length;
			int[] dp=new int[arr.length];
			
			dp[0]=1;
			
			for(int i=1;i<arr.length;i++){
				for(int j=0;j<i;j++){
					if(arr[i]>arr[j]&&dp[i]<dp[j]+1)
						dp[i]=dp[j]+1;
				}
			}
			int max=1;
			for(int i=0;i<dp.length;i++){
				max=max<dp[i]?dp[i]:max;
			}
				
			return max;
		}
		
		public static int LongestBitonicSubsequence(int[] arr){
			if(arr.length<3)
				return arr.length;
			
			int[] inc=new int[arr.length];
			inc[0]=1;
			
			for(int i=1;i<arr.length;i++){
				for(int j=0;j<i;j++){
					if(arr[i]>arr[j]&&inc[i]<inc[j]+1)
						inc[i]=inc[j]+1;
				}
			}
			
			int[] dec=new int[arr.length];
			dec[0]=1;
			
			for(int i=1;i<arr.length;i++){
				for(int j=0;j<i;j++){
					if(arr[i]<arr[j]&&dec[i]<dec[j]+1)
						dec[i]=dec[j]+1;
				}
			}
			
			int max=1;
			
			for(int i=0;i<arr.length;i++){
				max=max<inc[i]+dec[i]?inc[i]+dec[i]:max;
			}
			return max;
			
		}
		
		public static int findCelebrity(int[][] matrix){
			int n=matrix.length;
			Stack<Integer> stk=new Stack<Integer>();
			
			for(int i=0;i<n;i++){
				stk.push(i);
				i++;
			}
			
			while(stk.size()!=1){
				int A=stk.pop();
				int B=stk.pop();
				
				if(matrix[A][B]==1){
					stk.push(B);
				}
				else
					stk.push(A);
			}
			int celebrity=stk.pop();
			
			for(int i=0;i<n;i++){
				if(i!=celebrity&&matrix[i][celebrity]!=1)
					return -1;
			}
			return celebrity;			
			
		}
		
		
//		Find subarray with given sum
		public static boolean subArraySum(int arr[], int sum){
			if(arr.length==0&&sum!=0)
				return false;
			int cursum=0;
			int start=0;
			for(int i=0;i<arr.length;i++){
				cursum+=arr[i];
				while(cursum>sum&&start<i){
					cursum-=arr[start];
					start++;
				}
				if(cursum==sum){
					System.out.println("from "+start+" to "+i);
					return true;
				}
			}
			return false;
		}
		
		public static int minJumps(int arr[]){
			if(arr.length<2)
				return 0;
			int[] dp=new int[arr.length];
			dp[0]=0;
			
			for(int i=1;i<arr.length;i++){
				dp[i]=Integer.MAX_VALUE;
				for(int j=0;j<i;j++){
					if(i<=j+arr[j]&&dp[j]!=Integer.MAX_VALUE){
						dp[i]=dp[j]+1;
						break;
					}
				}
			}
			return dp[arr.length-1];
		}
		
//		Maximum Sum Increasing Subsequence
		public static int maxSumIS( int arr[] ){
			if(arr.length==0)
				return 0;
			int[] dp=new int[arr.length];
			dp[0]=arr[0];
			for(int i=1;i<arr.length;i++){
				for(int j=0;j<i;j++){
					if(dp[i]<dp[j]+arr[i]&&arr[i]>arr[j])
						dp[i]=dp[j]+arr[i];
				}
			}
			int max=0;
			
			for(int i=0;i<arr.length;i++)
				max=max<dp[i]?dp[i]:max;
				
			return max;
		}
		
		public static int firstMissingPos(int[] arr){
			for(int i=0;i<arr.length;i++){
				while(arr[i]!=i+1){
					if(arr[i]<=0||arr[i]>arr.length||arr[i]==arr[arr[i]-1])
						break;
					else{
						int t=arr[i];
						arr[i]=arr[arr[i]-1];
						arr[t-1]=t;
					}
				}				
			}
			
			for(int i=0;i<arr.length;i++){
				if(arr[i]!=i+1)
					return i+1;
			}
			return arr.length;
		}
		
		public static void MatrixInplaceTranspose(int[] A, int r, int c){
			int size=r*c-1;
			boolean[] marker=new boolean[r*c];
			marker[0]=marker[size]=true;
			int i=1;
			
			while(i<size){
				int cycleBegin=i;
				int t=A[i];
				
				do{
					int next=(i*c)%size;
					
					int tmp=A[next];
					A[next]=t;
					t=tmp;
					marker[i]=true;
					i=next;
				}while(i!=cycleBegin);
				
				for(i=1;i<size&&marker[i];i++)
					;
				
			}
		}
		
		
//		Find the row with maximum number of 1s
		public static int rowWithMax1s(int mat[][]){
			int n=mat.length;
			int m=mat[0].length;
			
			int i=first1Index(mat[0]);
			if(i==-1)
				i=m-1;
			int index=0;
			for(int j=1;j<n;j++){
				while(i>=0&&mat[j][i]==1){
					i--;
					index=j;
				}
			}
			
			return index;
		}
		
		public static int first1Index(int[] A){
			if(A.length==0)
				return -1;
			int beg=0;
			int end=A.length-1;
			while(beg<end){
				int mid=(beg+end)/2;
				if(A[mid]<1)
					beg=mid+1;
				else
					end=mid;
			}
			return beg;
		}
		
//		Sort a nearly sorted (or K sorted) array in O(n log k) time. 
		
		public static void sortKSorted(int arr[], int k){
			if(arr.length<2)
				return;
			
			PriorityQueue<Integer> heap=new PriorityQueue<Integer>();
			
			for(int i=0;i<=k&&i<arr.length;i++)
				heap.add(arr[i]);
//			int targetIndex=0;
			for(int i=k+1,ti=0;ti<arr.length;ti++,i++){
				if(i<arr.length){
					arr[ti]=heap.poll();
					heap.add(arr[i]);
				}
				else
					arr[ti]=heap.poll();
				
			}			
			
		}
//		Maximum circular subarray sum
		public static int maxCircularSum (int arr[]){
			if(arr.length==0)
				return 0;
			int nonWrap=kadane(arr);
			
			int wrap=0;
			for(int i=0;i<arr.length;i++){
				wrap+=arr[i];
				arr[i]=-arr[i];
			}
			
			wrap+=kadane(arr);
			
			return nonWrap>wrap?nonWrap:wrap;
		}
		public static int kadane(int[] arr){
			int max=0;
			int sum=0;
			for(int i=0;i<arr.length;i++){
				sum+=arr[i];
				if(sum<0)
					sum=0;
				if(sum>max)
					max=sum;
			}
			return max;
		}
		
		public static int maxCircularSum2 (int arr[]){
			int n=arr.length;
			int[] aux=new int[2*n];
			int j=0;
			for(int i=0;j<n+1&&i<2*n;i++,j++){
				if(j==n)
					j=0;
				aux[i]=arr[j];				
			}
			
			System.out.println(Arrays.toString(aux));
			int max=0;
			int sum=0;
			int start=0;
			for(int i=0;i<2*n;i++){
				if(i-start+1<=n){
					sum+=aux[i];
					if(sum<0){
						sum=0;
						start=i+1;
					}
					if(sum>max)
						max=sum;
				}
				else{
					sum-=aux[start];
					start++;
					while(aux[start]<0){
						sum-=aux[start];
						start++;
					}	
					if(sum>max)
						max=sum;
					sum+=aux[i];
					if(sum<0){
						sum=0;
						start=i;
					}
					if(sum>max)
						max=sum;
				}
			}
			return max;
		}
		
		static Comparator<PairSum> cmp=new Comparator<PairSum>(){

			@Override
			public int compare(PairSum o1, PairSum o2) {
				// TODO Auto-generated method stub
				return o1.sum-o2.sum;
			}
			
		};
		
		
		public static boolean noCommon(PairSum p1, PairSum p2){
			if(p1.first==p2.first||p1.first==p2.second
					||p1.second==p2.second||p1.second==p2.first)
				return false;
			return true;
		}
		
		//not really working, if only one  quadruple, it would be good.
		public static ArrayList<ArrayList<Integer>> fourSum2(int[] num, int target) {
			ArrayList<ArrayList<Integer>>res=new ArrayList<ArrayList<Integer>>();
			int n=num.length;
			int size=n*(n-1)/2;
			
			PairSum[] aux=new PairSum[size];
			int k=0;
			for(int i=0;i<n-1;i++){
				for(int j=i+1;j<n;j++){
					aux[k]=new PairSum(num[i]+num[j],i,j);
					k++;
				}
			}
			Arrays.sort(aux, cmp);
			
			int i=0;
			int j=size-1;
			
			ArrayList<Integer> sol=new ArrayList<Integer>();
			while(i<j){
				int sum=aux[i].sum+aux[j].sum;
				if(sum==target&&noCommon(aux[i],aux[j])){
					sol.add(num[aux[i].first]);
					sol.add(num[aux[i].second]);
					sol.add(num[aux[j].first]);
					sol.add(num[aux[j].second]);
					Collections.sort(sol);
					if(!res.contains(sol))
						res.add(sol);
					sol=new ArrayList<Integer>();
					i++;
					j--;
				}
				else if(sum>target)
					j--;
				else
					i++;
			}
			return res;
		}
		
//		Find a pair with the given difference k
		public static void findPair(int arr[], int k){
			if(arr.length<2)
				return;
			Arrays.sort(arr);
			int i=0;
			int j=1;
			while(i<arr.length&&j<arr.length){
				if(i!=j&&arr[j]-arr[i]==k){
					System.out.println(arr[i]+" and "+arr[j]);
					return;
				}
				else if(arr[j]-arr[i]<k)
					j++;
				else
					i++;
			}
			
			System.out.println("no such pair!");
		}
		
		public static int maxChainLength( Pair[] arr){
			int n=arr.length;
			int[] dp=new int[n];
			Arrays.fill(dp, 1);
			
			for(int i=1;i<n;i++){
				for(int j=0;j<i;j++){
					if(arr[i].a>arr[j].b&&dp[i]<dp[j]+1)
						dp[i]=dp[j]+1;
				}
			}
			int max=1;
			for(int i=0;i<n;i++)
				max=max>dp[i]?max:dp[i];
			return max;
		}
//		Replace every element with the next greatest
		public static void nextGreatest(int arr[]){
			int n=arr.length;
			if(n<2)
				return;
						
			int max=arr[n-1];
			arr[n-1]=-1;
			
			for(int i=n-2;i>=0;i--){
				int t=max;
				if(arr[i]>max)
					max=arr[i];
				arr[i]=t;
			}
//			int[] aux=new int[n];
//			aux[n-1]=-1;
//			int max=arr[n-1];
//			for(int i=n-2;i>=0;i--){
//				aux[i]=max;
//				if(arr[i]>max)
//					max=arr[i];
//			}
//			
//			for(int i=0;i<n;i++){
//				arr[i]=aux[i];
//			}
			
			System.out.println(Arrays.toString(arr));
		}
		
//		Shuffle a given array deck
		
		public static void randomize(int[] arr){
			if(arr.length<2)
				return;
			int n=arr.length;
			for(int i=n-1;i>0;i--){
				int j=(int) (Math.random()*n)%(i+1);
				swap(arr,i,j);
			}
			System.out.println(Arrays.toString(arr));
		}
		
		
		public static int partition (int arr[], int l, int h){
			int pivot=arr[h];
			
			int j=l-1;
			for(int i=l;i<h;i++){
				if(arr[i]<=pivot){
					j++;
					swap(arr,i,j);
				}
			}
			swap(arr,j+1,h);
			return j+1;
		}
		public static void quickSortIterative (int arr[], int l, int h){
			int top=-1;
			int[] stk=new int[h-l+1];
			stk[++top]=l;
			stk[++top]=h;
			
			while(top>=0){
				h=stk[top--];
				l=stk[top--];
				
				int p=partition(arr,l,h);
				// If there are elements on left side of pivot, then push left
		        // side to stack
		        if ( p-1 > l )
		        {
		            stk[ ++top ] = l;
		            stk[ ++top ] = p - 1;
		        }
		 
		        // If there are elements on right side of pivot, then push right
		        // side to stack
		        if ( p+1 < h )
		        {
		            stk[ ++top ] = p + 1;
		            stk[ ++top ] = h;
		        }
			}
			
			System.out.println(Arrays.toString(arr));
		}
		
		public static int findNumberOfTriangles(int arr[]){
			if(arr.length<3)
				return 0;
			Arrays.sort(arr);
			int count=0;
			for(int i=0;i<arr.length-2;i++){
				int k=i+1;
				for(int j=i+1;j<arr.length;j++){
					while(k<arr.length&&arr[i]+arr[j]>arr[k])
						k++;
					count+=k-j-1;
				}
			}
			return count;
		}
		
		
		Comparator<Interval> cp=new Comparator<Interval>(){

			@Override
			public int compare(Interval o1, Interval o2) {
				// TODO Auto-generated method stub
				return o1.start-o2.start;
			}
			
		};
		public ArrayList<Interval> merge2(ArrayList<Interval> intervals) {
			ArrayList<Interval> res=new ArrayList<Interval>();
			if(intervals.size()<2)
				return intervals;
			Collections.sort(intervals,cp);
			res.add(intervals.get(0));
			for(int i=1;i<intervals.size();i++){
				Interval interval=intervals.get(i);
				Interval preinterval=res.get(res.size()-1);
				if(interval.start>preinterval.end)
					res.add(interval);
				else{
					int end=Math.max(interval.end, preinterval.end);
					Interval interv=new Interval(preinterval.start,end);
					res.remove(res.size()-1);
					res.add(interv);
				}
			}
			return res;
		}
		
//		Find the maximum repeating number in O(n)
//		the array contains numbers in range from 0 to k-1 where k is a positive integer and k <= n.
		public static int maxRepeating(int[] arr, int k){
			for(int i=0;i<arr.length;i++){
				arr[arr[i]%k]+=k;
			}
			int max=arr[0];
			int index=0;
			
			for(int i=0;i<arr.length;i++){
				if(arr[i]>max){
					max=arr[i];
					index=i;
				}
			}
			
			/* Uncomment this code to get the original array back
		       for (int i = 0; i< n; i++)
		          arr[i] = arr[i]%k; */
			
			return index;
		}
		
		public static int findMaxOfArray(int[] arr, int n){
			int max=arr[0];
			int index=0;
			for(int i=1;i<n;i++){
				if(arr[i]>max){
					max=arr[i];
					index=i;
				}
			}
			return index;
		}
		
		public static void flip(int[] arr, int n){
			int i=0;
			int j=n;
			while(i<j){
				int t=arr[i];
				arr[i]=arr[j];
				arr[j]=t;
				i++;
				j--;
			}
		}
		public static void pancakeSort(int[] arr){
			int n=arr.length;
			
			for(int size=n;size>1;size--){
				int mi=findMaxOfArray(arr, size);
				if (mi != size-1){
					flip(arr,mi);
					flip(arr,size-1);
				}
			}
			
			System.out.println(Arrays.toString(arr));
		}
		
		
		public static int ceilSearch(int arr[], int low, int high, int x){
			if(x<=arr[low])
				return low;
			if(x>arr[high])
				return -1;
			
			int mid=(low+high)/2;
			if(arr[mid]==x)
				return mid;
			if(arr[mid]<x){
				if(mid+1<=high&&x<arr[mid+1])
					return mid+1;
				else
					return ceilSearch(arr,mid+1,high,x);
			}
			else{
				if(mid-1>=low&& x > arr[mid-1])
					return mid;
				else
					return ceilSearch(arr, low, mid-1,x);
			}
		}
		
		public static void insertionSortPancake(int arr[]){
			if(arr.length<2)
				return;
			
			for(int i=1;i<arr.length;i++){
//				int j=ceilSearch(arr,0,i-1,arr[i]);
				int j=findCeil(arr,0,i-1,arr[i]);
				if(j!=-1){
					flip(arr, j-1);
					flip(arr, i-1);
					flip(arr,i);
					flip(arr,j);
				}
			}
			
			System.out.println(Arrays.toString(arr));
		}
		
		
		public static int findCeil(int arr[], int low, int high, int x){
			if(x<=arr[low])
				return low;
			if(x>arr[high])
				return -1;
			
			int beg=low;
			int end=high;
			while(beg<end){
				int mid=(beg+end)/2;
				if(arr[mid]==x)
					return mid;
				else if(arr[mid]<x)
					beg=mid+1;
				else
					end=mid;
			}
			return beg;
		}
		
		public int sumNumbersTree(TreeNode root) {
			if(root==null)
				return 0;
			return sumNumbersTree(root,0);
		}
		
		public int sumNumbersTree(TreeNode root, int sum){
			if(root==null)
				return 0;
			int res=sum*10+root.val;
			if(root.left==null&&root.right==null){
				return res;
				}
			return sumNumbersTree(root.left,res)+sumNumbersTree(root.right,res);
		}
		
		
		public static ArrayList<Integer> findKDistanceNodes(TreeNode root, int k){
			ArrayList<Integer> res=new ArrayList<Integer>();
			findKDistanceNodes(root, res, k);
			return res;			
		}
		
		public static void findKDistanceNodes(TreeNode root, ArrayList<Integer> res, int k){
			if(root==null||k<0)
				return;
			if(k==0)
				res.add(root.val);
			findKDistanceNodes(root.left,res,k-1);
			findKDistanceNodes(root.right,res,k-1);
		}
		
//		Given a number, find the next smallest palindrome
//		There can be three different types of inputs that need to be handled separately.
//		1) The input number is palindrome and has all 9s. For example “9 9 9″. Output should be “1 0 0 1″
//		2) The input number is not palindrome. For example “1 2 3 4″. Output should be “1 3 3 1″
//		3) The input number is palindrome and doesn’t have all 9s. For example “1 2 2 1″. Output should be “1 3 3 1″.
		
		public static int[] generateNextPalindrome( int num[]){
			if(all9s(num)){
				int n=num.length;
				int[] res=new int[n+1];
				res[0]=1;
				res[n]=1;
				System.out.println(Arrays.toString(res));
				return res;
			}
			
			return generateNextPalindromeUtil(num);
		}
		
		public static int[] generateNextPalindromeUtil(int[] num){
			int n=num.length;
			// find the index of mid digit
			int mid=n/2;
			// end of left side is always 'mid -1'
			int i=mid-1;
			// Begining of right side depends if n is odd or even
			int j=n%2==1?mid+1:mid;
			// A bool variable to check if copy of left side to right is sufficient or not
			boolean leftsmaller=false;
			// Initially, ignore the middle same digits 
			while(i>=0&&num[i]==num[j]){
				i--;
				j++;
			}
			// Find if the middle digit(s) need to be incremented or not (or copying left 
		    // side is not sufficient)
			if(i<0||num[i]<num[j])
				leftsmaller=true;
			// Copy the mirror of left to tight
			while(i>=0){
				num[j]=num[i];
				i--;
				j++;
			}
			
			System.out.println(Arrays.toString(num)+" ss");
			// Handle the case where middle digit(s) must be incremented. 
//			This case occurs when the input number is palindrome. 
//			In this case, we just add 1 to the middle digit
//			(or digits in case n is even) propagate the carry
//			towards MSB digit of left side and simultaneously
//			copy mirror of the left side to the right side.
			
			if(leftsmaller){
				int carry=1;
				i=mid-1;
				
				if(n%2==1){
					num[mid]=num[mid]+carry;
					carry=num[mid]/10;
					num[mid]%=10;
					j=mid+1;
				}
				else
					j=mid;
				
				 // Add 1 to the rightmost digit of the left side, propagate the carry 
		        // towards MSB digit and simultaneously copying mirror of the left side 
		        // to the right side.
				while(i>=0){
					num[i]+=carry;
					carry=num[i]/10;
					num[i]%=10;
					// copy mirror to right
					num[j++]=num[i--];
				}
			}
			System.out.println(Arrays.toString(num));
			return num;
			
		}
		
		public static boolean all9s(int[] num){
			for(int i=0;i<num.length;i++){
				if(num[i]!=9)
					return false;
			}
			return true;
		}
		
		
		public static int makeChangeDPOpt(int[] coins, int amount){
			int[] dp=new int[amount+1];
			dp[0]=1;
			for(int i=0;i<coins.length;i++){
				for(int j=coins[i];j<=amount;j++){
					dp[j]+=dp[j-coins[i]];
				}
			}
			return dp[amount];
		}
		
//		public static int makeChangeDPOpt(int[] coins, int amount){
//			int[] dp=new int[amount+1];
//			dp[0]=1;
//			for(int i=1;i<=amount;i++){
//				for(int j=0;j<coins.length;j++){
//					if(i>=coins[j])
//						dp[i]+=dp[i-coins[j]];
//				}
//			}
//			return dp[amount];
//		}
//		
		public static int makeChangeDP(int[] coins, int amount){
			int n=coins.length;
			int[][] dp=new int[amount+1][n];
			for(int i=0;i<n;i++){
				dp[0][i]=1;
			}
			
			for(int i=1;i<=amount;i++){
				for(int j=0;j<n;j++){
					int x=i-coins[j]>=0?dp[i-coins[j]][j]:0;
					int y=j>0?dp[i][j-1]:0;
					
					dp[i][j]=x+y;
				}
			}
			return dp[amount][n-1];
		}
		
		
		public static int numOfIsland(int[][] matrix){
			int m=matrix.length;
			if(m==0)
				return 0;
			int n=matrix[0].length;
			boolean[][] visited=new boolean[m][n];
			int count=0;
			for(int i=0;i<m;i++){
				for(int j=0;j<n;j++){
					if(!visited[i][j]&&matrix[i][j]==1){
						dfsIsland(i,j,visited,matrix);
						count++;
					}						
				}
			}
			return count;
		}
		
		public static void dfsIsland(int row, int col, boolean[][] visited, int[][] matrix){
			if(row>=0&&row<matrix.length&&col>=0&&col<matrix[0].length&&!visited[row][col]&&matrix[row][col]==1){
				visited[row][col]=true;
				dfsIsland(row-1,col,visited,matrix);
				dfsIsland(row+1,col,visited,matrix);
				dfsIsland(row,col+1,visited,matrix);
				dfsIsland(row,col-1,visited,matrix);
			}
		}
		
//		Given a string S1, convert it to another string S2 (Anagram) by swapping
//		only adjacent elements. Print all the intermediate strings formed. 

		
		public static void transpose(String s1, String s2) {
			if(s1.equals(s2))
				return;
			char[] ch1=s1.toCharArray();
			char[] ch2=s2.toCharArray();
			
			int i=0;
			System.out.println(s1);
			while(i<s2.length()){
				if(ch1[i]==ch2[i]){
					i++;
//					System.out.println(new String(ch1));
				}
				else{
					int j=i;
					while(j<ch1.length-1&&ch1[i]!=ch2[i]){
						char t=ch1[j];
						ch1[j]=ch1[j+1];
						ch1[j+1]=t;
						j++;
					}
					System.out.println(new String(ch1));
				}
			}
		}
		
//		
//		Given a matrix, you need to create another matrix such that the value (i,j) is either -1, 0 or 1. 
//		1 - if multiplication of all values in ith row and jth column is greater than 0. 
//		-1 - if multiplication of all values in ith row and jth column is less than 0. 
//		0 - if multiplication of all the values in ith row and jth column is 0. 
		
		
		public static void coverMatrix(int[][] matrix){
			int m=matrix.length;
			if(m==0)
				return;
			int n=matrix[0].length;
			int[] row=new int[m];
			int[] col=new int[n];
			
			for(int i=0;i<m;i++){
				int rowProd=1;
				for(int j=0;j<n;j++){
					rowProd*=matrix[i][j];
				}
				row[i]=rowProd;
			}
			
			for(int i=0;i<n;i++){
				int colProd=1;
				for(int j=0;j<m;j++){
					colProd*=matrix[j][i];
				}
				col[i]=colProd;
			}
			
			for(int i=0;i<m;i++){
				for(int j=0;j<n;j++){
					int val=row[i]*col[j];
					if(val>0)
						matrix[i][j]=1;
					else if(val<0)
						matrix[i][j]=-1;
					else
						matrix[i][j]=0;
				}
			}
			
			for(int i=0;i<m;i++){
				System.out.println(Arrays.toString(matrix[i]));
			}
		}
		
//		You are given an array A with elements 0 to n-1,
//		numbers can be repeated in the array. Create n sets where 
//
//		S[i]={a[i],a[a[i]],a[a[a[i]]]…}. 
//		Set has all elements unique. Find the size of the largest set. 
		
		public static void updateArray (int a[]){
			int[] s=new int[a.length];
			
			for(int i=0;i<a.length;i++)
				updateArray(a,s,i);
			
			int max=0;
			for(int i=0;i<s.length;i++){
				if(s[i]>max)
					max=s[i];
			}
			System.out.println(max);
		}
		
		public static int updateArray(int[] A, int[] S, int i){
			if(S[i]!=0)// unused check
				return 0;
			S[i]++;
			if(i==A[i])
				return 0;
			else
				S[i]+=updateArray(A,S,A[i]);
			return S[i];
		}
		
//		Implement a function which returns list of all nodes
//		in a binary tree having a given number of leaves, say k . 
		
		public static ArrayList<TreeNode> getNodesHaveKLeaves(TreeNode root, int k){
			ArrayList<TreeNode> list= new ArrayList<TreeNode>();
			getLeaves(root,list,k);
			return list;
		}
		
		public static int getLeaves(TreeNode root, ArrayList<TreeNode> list, int k){
			if(root==null)
				return 0;
			if(root.left==null&&root.right==null)
				return 1;
			int left=getLeaves(root.left,list,k);
			int right=getLeaves(root.right,list,k);
			if(left+right==k){
				list.add(root);
			}
			return left+right;
			
		}
		
		public static void convertToSumTree(TreeNode root){
			int[] sum={0};
			convertToSumTree(root,sum);
		}
		
		public static void convertToSumTree(TreeNode root, int[] sum){
			if(root==null)
				return;
			convertToSumTree(root.right,sum);
			sum[0]+=root.val;
			root.val=sum[0];
			convertToSumTree(root.left,sum);
		}
		
		public static boolean isMultipleOfFive(int a){
			int mask=5;
			while((mask<<1)<=a){
				mask<<=1;
			}
			
			while(mask>=5){
				if(a>=mask)
					a-=mask;
				mask>>=1;
			}
			return a==0;	
		}
		
		
		public static boolean isOverlap(Rectangle rect1, Rectangle rect2){
			if (rect1.topLeft.x >= rect2.bottomRight.x 
				      || rect1.bottomRight.x <= rect2.topLeft.x 
				      || rect1.topLeft.y <= rect2.bottomRight.y 
				      || rect1.bottomRight.y >= rect2.topLeft.y)
				    return false;
				    
				  return true;
		}
		
//		Since we know we are looking for pairs where x+y = A[x] + A[y], 
//				by simple algebra, you can also look for x-A[x] = A[y]-y
//		the sum of any two elements is equal to the sum of the corresponding indices
		
		public static ArrayList<ArrayList<Integer>> findSums(int[] A) {
			// Look for pairs where  x - A[x] == A[y] - y
			ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
			HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
			
			for (int i = 0; i< A.length; i++) {
				map.put(i-A[i],i);
			}
			
			for (int j = 0; j < A.length; j++) {
				if (map.containsKey(A[j]-j)) {
					int i = map.get(A[j]-j);
					if (j != i) {
						ArrayList<Integer> pair= new ArrayList<Integer>();
						pair.add(i);
						pair.add(j);
						res.add(pair);
					}
				}
			}			
			return res;
		}
		
		
		public static boolean isWellFormed(String s){
			if(s.length()==0)
			    return true;
			    
			Stack<Character> stk=new Stack<Character>();

			for(int i=0;i<s.length();i++){
			    char c=s.charAt(i);
			    if(c=='('||c=='['||c=='{')
			        stk.push(c);
			    else{
			        if(!stk.isEmpty()&&(stk.peek()=='('&&c==')'||stk.peek()=='{'&&c=='}'||stk.peek()=='['&&c==']'))
			            stk.pop();
			        else
			            return false;
			    }

			}
			    return stk.isEmpty();

			}
		
		public static void intersetion(int[] A, int[] B){
			if(A.length==0)
				return;
			if(B.length==0)
				System.out.println(Arrays.toString(A));
			
			int i=0;
			int j=0;
			while(i<A.length&&j<B.length){
				if(A[i]<B[j]){
					System.out.print(A[i++]+" ");// in A but not in B
				}
				else if(A[i]>B[j]){
					j++;
//					System.out.print(A[j++]+" ");// int B but not in A
				}
				else{
					i++;
					j++;
				}
			}
			while(i<A.length)
				System.out.print(A[i++]+" ");
				
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
		
		public static void topKLargest(int[] nums, int k){
			int n=nums.length;
			if(n<k)
				return;
			int kth=findKthIndex(nums,0,n-1,k);
			for(int i=0;i<=kth;i++)
				System.out.print(nums[i]+" ");
			System.out.println();
		}
		public static int findKthIndex(int[] nums, int start, int end, int k){
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
				return findKthIndex(nums,right+1,end,k);
			else
				return findKthIndex(nums,start,right-1,k);
		}
		
		
		public static void binaryTreeToBST (TreeNode root){
			if(root==null)
				return;
			int n=countNode(root);
			int[] arr=new int[n];
			int[] index={0};
			storeInorder(root,arr, index);
			Arrays.sort(arr);
			int[] id={0};
			arryToBST(root,arr, id);
		
		}
		public static int countNode(TreeNode root){
			if(root==null)
				return 0;
			return countNode(root.left)+countNode(root.right)+1;
		}
		
		public static void storeInorder(TreeNode root, int[] arr, int[] index){
			if(root==null)
				return;
			storeInorder(root.left,arr,index);
			arr[index[0]]=root.val;
			index[0]++;
			storeInorder(root.right,arr,index);
		}
		
		public static void arryToBST(TreeNode root, int[] arr, int[] id){
			if(root==null)
				return;
			arryToBST(root.left,arr,id);
			root.val=arr[id[0]];
			id[0]++;
			arryToBST(root.right,arr,id);
		}
		
		static TreeNode preNode=null;
		static TreeNode dllhead=null;
		
		public static TreeNode BinaryTree2DoubleLinkedList(TreeNode root){
			if(root==null)
				return null;
			// Recursively convert left subtree
		    BinaryTree2DoubleLinkedList(root.left);
		    if(preNode==null)
		    	dllhead=root;
		    else{
		    	root.left=preNode;
		    	preNode.right=root;
		    }
		    preNode=root;
		 // Recursively convert right subtree
		    BinaryTree2DoubleLinkedList(root.right);
		    
//		    while(root.left!=null)
//		    	root=root.left;
//		    return root;
		    
		   return dllhead;
		}
		public static void solveMaze(int[][] maze){
			int m=maze.length;
			if(m==0)
				return;
			int n=maze[0].length;
			int[][] sol=new int[m][n];
			
			if(!solveMazeUtil(maze,0,0,sol))
				System.out.println("solution doesn't exist!");
			else
				printSolution(sol);
		}
		
		public static boolean solveMazeUtil(int[][] maze, int i, int j, int[][] sol){
			if(i==maze.length-1&&j==maze[0].length-1){
				sol[i][j]=1;
				return true;
			}
			if(isSafe(maze, i, j)){
				sol[i][j]=1;
				if(solveMazeUtil(maze,i+1,j,sol))
					return true;
				if(solveMazeUtil(maze,i,j+1,sol))
					return true;
				sol[i][j]=0;
				return false;
			}
			return false;
		}
		
		public static boolean isSafe(int[][] maze,int i, int j){
			if(i>=0&&i<maze.length&&j>=0&&j<maze[0].length&&maze[i][j]==1)
				return true;
			return false;
		}
		
		public static void printSolution(int[][] sol){
			for(int i=0;i<sol.length;i++){
				for(int j=0;j<sol[0].length;j++)
					System.out.print(sol[i][j]+" ");
				System.out.println();
			}
		}
		
		
		public static TreeNode insertBST(TreeNode root, int data){
			if(root==null){
				root=new TreeNode(data);
				return root;
			}
			else{
				if(root.val>=data)
					root.left=insertBST(root.left,data);
				else
					root.right=insertBST(root.right,data);
				return root;
			}
		}
		
		public static TreeNode inorderPredecessor(TreeNode root, TreeNode node){
			if(root==null||node==null)
				return  null;
			if(node.left!=null){
				TreeNode pred=node.left;
				while(pred.right!=null)
					pred=pred.right;
				return pred;
			}
			TreeNode cur=root;
			TreeNode pre=null;
			while(cur!=node){
				if(cur.val>node.val)
					cur=cur.left;
				else{
					pre=cur;
					cur=cur.right;
				}
			}
			return pre;
		}
		

		  public static TreeNodeP inorderSucc(TreeNodeP node){
			  if(node==null)
				  return null;
			  if(node.parent==null||node.right!=null)
				  return leftMostChild(node.right);
			  else{
				  TreeNodeP p=node.parent;
				  while(p!=null&&node==p.right){
					  node=p;
					  p=p.parent;
				  }
				  return p;
			  }
		  }
		  
		  public static TreeNodeP leftMostChild(TreeNodeP node){
			  if(node==null)
				  return null;
			  TreeNodeP cur=node;
			  
			  while(cur.left!=null){
				  cur=cur.left;
			  }
			  return cur;
		  }
		
		public static TreeNode lcaBSTRecur(TreeNode root, TreeNode n1, TreeNode n2){
			if(root==null)
				return null;
			if(root.val>n1.val&&root.val>n2.val)
				return lcaBST(root.left,n1,n2);
			else if(root.val<n1.val&&root.val<n2.val)
				return lcaBST(root.right,n1,n2);
			return root;
		}
		
		public static TreeNode lcaBSTIterative(TreeNode root, TreeNode n1, TreeNode n2){
			if(root==null)
				return null;
			
			TreeNode cur=root;
			while(cur!=null){
				if(cur.val>n1.val&&cur.val>n2.val)
					cur=cur.left;
				else if(cur.val<n1.val&&cur.val<n2.val)
					cur=cur.right;
				else
					break;
			}
			return cur;
		}
		// givne a linkedlist reverse alternate nodes and append at the end
		public static void rearrange(ListNode head){
			if(head==null||head.next==null||head.next.next==null)
				return;
			ListNode odd=head;
			ListNode even=odd.next;
			
			odd.next=even.next;
			odd=odd.next;
			even.next=null;
			
			while(odd!=null&&odd.next!=null){
				ListNode t=odd.next.next;
				odd.next.next=even;
				even=odd.next;
				
				odd.next=t;
				if(t!=null)
					odd=t;
			}
			odd.next=even;
		}
		
		public static ListNode rearrange2(ListNode head){
			if(head==null||head.next==null||head.next.next==null)
				return head;
			ListNode odddummy=new ListNode(0);
			ListNode evendummy=new ListNode(1);
			ListNode oddpre=odddummy;
			ListNode evenpre=evendummy;
			
			ListNode cur=head;
			int count=0;
			while(cur!=null){
//				System.out.println("hlji");
				count++;
				System.out.println(count);
				if(count%2==1){
					oddpre.next=cur;
					oddpre=oddpre.next;
				}
				else{
					evenpre.next=cur;
					evenpre=evenpre.next;
				}
				cur=cur.next;
			}
			
			oddpre.next=null;
			evenpre.next=null;
			
			reverseEven(evendummy);
			oddpre.next=evendummy.next;
			return odddummy.next;
			
		}
		
		public static void reverseEven(ListNode dummy){
			if(dummy.next==null||dummy.next.next==null)
				return ;
			ListNode pre=dummy;
			ListNode last=dummy.next;
			ListNode cur=dummy.next.next;
			
			while(cur!=null){
				last.next=cur.next;
				cur.next=pre.next;
				pre.next=cur;
				
				cur=last.next;
			}
		}
		
		// find all pair of bst sum=k
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
		
		public static void intersectionOfTwoSortedArray(int[] A, int[] B){
			int m=A.length;
			int n=B.length;
			if(m==0||n==0)
				return;
			int i=0;
			int j=0;
			while(i<m&&j<n){
				if(A[i]==B[j]){
					System.out.print(A[i]+" ");
					i++;
					j++;
				}
				else if(A[i]<B[j])
					i++;
				else
					j++;
			}
			System.out.println();
		}
		
		public static void unionOfTwoSortedArray(int[] A, int[] B){
			int n=A.length;
			int m=B.length;
			if(m==0||n==0)
				return;
			int i=0;
			int j=0;
			while(i<n&&j<m){
				if(A[i]==B[j]){
					System.out.print(A[i]+" ");
					i++;
					j++;
				}
				else if(A[i]<B[j]){
					System.out.print(A[i]+" ");
					i++;
				}
				else{
					System.out.print(B[j]+" ");
					j++;
				}
			}
			while(i<n)
				System.out.print(A[i++]+" ");
			while(j<m)
				System.out.print(B[j++]+" ");
			System.out.println();
		}
		
		// find the longest repeated substring in a given text
		public static String longestRepeatedString(String str){
			if(str.length()<2)
				return "";
			for(int step=str.length()-1;step>0;step--){
				HashMap<String, Integer> map=new HashMap<String, Integer>();
				
				for(int j=0;j<=str.length()-step;j++){
					String s=str.substring(j,j+step);
					if(map.containsKey(s))
						return s;
					else
						map.put(s, 1);
				}
			}
			return "";
		}
		public static String longestRepeatedSubString(String s){
			int n=s.length();
			String[] suffixes=new String[n];
			
			for(int i=0;i<n;i++){
				suffixes[i]=s.substring(i,n);
			}
			Arrays.sort(suffixes);
			String lrs="";
			
			for(int i=0;i<n-1;i++){
				int len=lcp(suffixes[i], suffixes[i+1]);
				if(len>lrs.length()){
					lrs=suffixes[i].substring(0,len);
				}
			}
			return lrs;
		}
		// given two strings,find the length of their longest prefix match
		public static int lcp(String s1, String s2){
			int len=0;
			int n=Math.min(s1.length(), s2.length());
			
			for(int i=0;i<n;i++){
				if(s1.charAt(i)==s2.charAt(i))
					len++;
				else
					break;
			}
			return len;
		}
		
		// calculate the length of the linked list contains loop
		
		public static int lengthOfListContainsLoop(ListNode head){
			if(head==null)
				return 0;
			int len =0;
			ListNode loopStart=findLoopStart(head);
			if(loopStart==null){
				ListNode cur=head;
				while(cur!=null){
					len++;
					cur=cur.next;
				}
				return len;
					
			}

			ListNode p=loopStart;
			
			do{
				len++;
				p=p.next;
			}while(p!=loopStart);
			ListNode cur=head;
			
			while(cur!=loopStart){
				len++;
				cur=cur.next;
			}
			return len;
		}
		
		public static ListNode findLoopStart(ListNode head){
			if(head==null)
				return null;
			ListNode fast=head;
			ListNode slow=head;
			while(fast!=null&&fast.next!=null){
				fast=fast.next.next;
				slow=slow.next;
				if(fast==slow)
					break;
			}
			if(fast==null||fast.next==null)
				return null;
			ListNode cur=head;
			while(cur!=fast){
				cur=cur.next;
				fast=fast.next;
			}
			return cur;
		}
		// balanced binary tree
		// optimized version, linear O(n) calculate the height in the same recursion
		public boolean isBalanced2(TreeNode root){
			if(root==null)
				return true;
			int[] h={0};
			return isBalanced(root, h);
		}
		public boolean isBalanced(TreeNode root, int[] height){
			if(root==null){
				height[0]=0;
				return true;
			}
			int[] lh={0};
			int[] rh={0};
			
			boolean left=isBalanced(root.left,lh);
			boolean right=isBalanced(root.right,rh);
			
			height[0]=Math.max(lh[0], rh[0])+1;
			if(left&&right)
				return Math.abs(lh[0]-rh[0])<2;
			return false;
		}
		
		
		public static int[] nextGreaterElement(int[] A){
			int n=A.length;
			int[] res=new int[n];
			Stack<Integer> stk=new Stack<Integer>();
			stk.push(0);
			for(int i=1;i<n;i++){
				while(!stk.isEmpty()&&A[i]>A[stk.peek()])
					res[stk.pop()]=A[i];	
				stk.push(i);
			}
			
			while(!stk.isEmpty()){
				int t=stk.pop();
				res[t]=A[t];
			}
			System.out.println(Arrays.toString(res));
			return res;
		}
		
		public static int divideWithoutdivision(int numerator, int denomenator) throws Exception{
			if(denomenator==0)
				throw new Exception("denomenator cannot be 0!");
			boolean neg=false;
			if(numerator<0&&denomenator>0||numerator>0&&denomenator<0)
				neg=true;
			numerator=numerator<0?-numerator:numerator;
			denomenator=denomenator<0?-denomenator:denomenator;
			int count=0;
			while(numerator>=denomenator){
				numerator-=denomenator;
				count++;
			}
			if(neg)
				return -count;
			return count;
		}
		
		
		public static ArrayList<Integer> primeFactors2(int n){
			ArrayList<Integer> lst=new ArrayList<Integer>();
			if(n==0||n==1)
				return lst;
			
			for(int i=2;i<=n/i;i++){
				while(n%i==0){
					lst.add(i);
					n/=i;
				}
			}
			if(n>1)
				lst.add(n);
			return lst;
		}
		
//		Given n, find the smallest number for which product of the digits is n, 
//		if no such number exists, print -1
//		public int smallestNumEuqalProdOfDigs(int n){
//			if(n==0||n==1)
//				return n;
//			ArrayList<Integer> lst=primeFactors2(n);
//			for(int i=0;i<lst.size();i++){
//				int num=lst.get(i);
//				if(num!=2||num!=3||num!=5||num!=7)
//					return -1;
//			}
//			int[] arr=new int[4];
//			for(int i=0;i<lst.size();i++){
//				if(lst.get(i)==2)
//					arr[0]++;
//				else if(lst.get(i)==3)
//					arr[1]++;
//				else if(lst.get(i)==5)
//					arr[2]++;
//				else
//					arr[3]++;
//			}
//			String s="";
//			for(int i=0;i<4;i++){
//				while(arr[i]>1){
//					if(i==0){
//						
//					}
//				}
//			}
//		}
		public static int treeSize(TreeNode root){
			if(root==null)
				return 0;
			return treeSize(root.left)+treeSize(root.right)+1;
		}
		
		public static TreeNode kthLargestNode(TreeNode root, int k){
			int size=treeSize(root);
			if(root==null||k<=0||k>size)
				return null;
			if(k==treeSize(root.right)+1)
				return root;
			else if(k<treeSize(root.right)+1)
				return kthLargestNode(root.right,k);
			else
				return kthLargestNode(root.left,k-treeSize(root.right)-1);
		}
		
		public static ArrayList<String> findValidWords(char[][] matrix, HashSet<String> dic){
			ArrayList<String> res=new ArrayList<String>();
			int m=matrix.length;
			if(m==0)
				return res;
			int n=matrix[0].length;
			String sol="";
			boolean[][] used=new boolean[m][n];
			for(int i=0;i<m;i++){
				for(int j=0;j<n;j++){
					findValidWords(matrix, i, j, sol,dic,used,res);
				}
			}
			return res;
		}
		
		public static void findValidWords(char[][] matrix, int i, int j, String sol, HashSet<String> dic, boolean[][] used, ArrayList<String> res){
			if(i>=0&&i<matrix.length&&j>=0&&j<matrix[0].length&&!used[i][j]){
				sol+=matrix[i][j];
				used[i][j]=true;
				if(dic.contains(sol)){
					if(!res.contains(sol))
						res.add(sol);
				}
				findValidWords(matrix, i+1,j,sol,dic,used,res);
				findValidWords(matrix, i-1,j,sol,dic,used,res);
				findValidWords(matrix, i,j+1,sol,dic,used,res);
				findValidWords(matrix, i,j-1,sol,dic,used,res);
				sol=sol.substring(0,sol.length()-1);
				used[i][j]=false;
				
			}
		}
		// given an array, ifind three numbers that form the maximum product(O(n))
		public static int[] maxProduct(int[] A){
			int[] res=new int[3];
			for(int i=0;i<3;i++)
				res[i]=Integer.MIN_VALUE;
			if(A.length<3)
				return res;
			int[] min=new int[2];
			int neg=0;
			for(int i=0;i<A.length;i++){
				// find two smallest negative numbers
				if(A[i]<=0){
					if(A[i]<min[0]){
						min[1]=min[0];
						min[0]=A[i];
					}
					else if(A[i]<min[1])
						min[1]=A[i];
					neg++;					
				}
				
				//find three largest number
				if(A[i]>res[0]){
					res[2]=res[1];
					res[1]=res[0];
					res[0]=A[i];
				}
				else if(A[i]>res[1]){
					res[2]=res[1];
					res[1]=A[i];
				}
				else if(A[i]>res[2])
					res[2]=A[i];
			}
			
			if(neg!=A.length){
				if(min[0]*min[1]>res[0]*res[1]||min[0]*min[1]>res[1]*res[2]){
					res[1]=min[0];
					res[2]=min[1];
				}
			}
			System.out.println(Arrays.toString(res));
			System.out.println(res[0]*res[1]*res[2]);
			return res;
		}
		// given a set of lego bricks of height 1,2,3,4, each colored differently, how many ways fo constructing a tower of height>=1
		public static int waysOfLego(int n){
			if(n<3)
				return n;
			if(n==3)
				return 4;
			if(n==4)
				return 8;
			return waysOfLego(n-1)+waysOfLego(n-2)+waysOfLego(n-3)+waysOfLego(n-4);
		}
		
		
		public static TreeNode findSecondMaxOfBST(TreeNode root){
			if(root==null)
				return null;
			int largest=root.val;
			TreeNode cur=root;
			while(cur.right!=null){
				cur=cur.right;
			}
			largest=cur.val;
			
			cur=root;
			TreeNode secondMax=null;;
			while(cur!=null){
				if(cur.val<largest){
					secondMax=cur;
					cur=cur.right;
				}
				else
					cur=cur.left;
			}
			return secondMax;
		}
		
		public static boolean isOverlap(Point l1, Point r1, Point l2, Point r2){
			// if one rectangle is on the left of the other
			if(l1.x>r2.x||l2.x>r1.x)
				return false;
			// if one rectangle is above the other
			if(l1.y<r2.y||l2.y<r1.y)
				return false;
			return true;
		}
		
		public static void findNodesWithoutSiblings(TreeNode root){
			if(root==null)
				return;
			
			if(root.left!=null&&root.right!=null){
				findNodesWithoutSiblings(root.left);
				findNodesWithoutSiblings(root.right);
			}
			else if(root.right!=null){
				System.out.print(root.right.val+" ");
				findNodesWithoutSiblings(root.right);
			}
			else if(root.left!=null){
				System.out.print(root.left.val+" ");
				findNodesWithoutSiblings(root.left);
			}
		}
		
		
		/// running time O(nlogk)
		public ListNode mergeKList(ArrayList<ListNode> lists){
			if(lists.size()==0)
				return null;
			PriorityQueue<ListNode> que=new PriorityQueue<ListNode>(lists.size(),new Comparator<ListNode>(){

				@Override
				public int compare(ListNode o1, ListNode o2) {
					// TODO Auto-generated method stub
					return o1.val-o2.val;
				}
				
			});
			for(int i=0;i<lists.size();i++){
				ListNode node=lists.get(i);
				if(node!=null)
					que.offer(node);
			}
			
			ListNode head=null;
			ListNode pre=null;
			while(!que.isEmpty()){
				ListNode node=que.poll();
				if(head==null){
					head=node;
					pre=head;
				}
				else{
					pre.next=node;
					pre=pre.next;
				}
				if(node.next!=null)
					que.offer(node.next);
			}
			return head;
			
		}
		
		public static void findRepeatingStrings(String s, int len){
			if(s.length()==0||len<=0||len>s.length())
				return;
			Set<String> set=new HashSet<String>();
			
			for(int i=0;i<=s.length()-len;i++){
				int j=i+len;
				if(!set.contains(s.substring(i,j)))
					set.add(s.substring(i,j));
				else
					System.out.print(s.substring(i,j)+" ");
			}
			System.out.println();
		}
		
		public static boolean isIsomorphic(String s1, String s2){
			if(s1.length()!=s2.length())
				return false;
			HashMap<Character, Character> map=new HashMap<Character, Character>();
			
			for(int i=0;i<s1.length();i++){
				System.out.println(i+" ");
				if(!map.containsKey(s1.charAt(i))&&!map.containsValue(s2.charAt(i)))
					map.put(s1.charAt(i), s2.charAt(i));
				if(map.get(s1.charAt(i))==null)
					return false;
				if(map.get(s1.charAt(i))!=s2.charAt(i))
					return false;
			}
			return true;
		}
		
		public static char findNextChar(char[] list, char c){
			if(list.length==0)
				return '0';
			
			int beg=0;
			int end=list.length-1;
			char res=list[0];
			while(beg<=end){
				int mid=beg+(end-beg)/2;
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
			
			int minDist=Integer.MAX_VALUE;
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
					if(!strs[i].equals(strs[pre])&&i-pre<minDist){
						minDist=i-pre;
						pre=i;
					}
					else
						pre=i;
						
				}
			}
			
			if(!found)
				return -1;
			return minDist;
		}
		
		public static boolean isBipartite(int[][] G, int src){
			int V=G.length;
			int[] colorArr=new int[V];
			
			for(int i=0;i<V;i++)
				colorArr[i]=-1;
			colorArr[src]=1;
			
			Queue<Integer> que=new LinkedList<Integer>();
			que.add(src);
			
			while(!que.isEmpty()){
				int u=que.poll();
				for(int v=0;v<V;v++){
					if(G[u][v]==1&&colorArr[v]==-1){
						colorArr[v]=1-colorArr[u];
						que.offer(v);
					}
					else if(G[u][v]==1&&colorArr[u]==colorArr[v])
						return false;
				}
			}
			return true;
		}
		// two arrays, x from first array, y from second, find the min(abs(x-y))
		public static int minDifference(int[] A, int[] B){
			int res=Integer.MAX_VALUE;
			int i=0;
			int j=0;
			while(i<A.length&&j<B.length){
				if(A[i]<=B[j]){
					res=Math.min(res, B[j]-A[i]);
					i++;
				}
				else{
					res=Math.min(res, A[i]-B[j]);
					j++;
				}
			}
			return res;
		}
		
		public static int getInfluencer(boolean[][] followingMatrix){
			for(int i=0;i<followingMatrix.length;i++){
				boolean isInfluencer=true;
				
				for(int j=0;j<followingMatrix[0].length;j++){
					if(followingMatrix[i][j]){
						isInfluencer=false;
						break;
					}
				}
				if(isInfluencer){
					// check for all(j,i) for j=0 tp i-1
					for(int j=0;j<i;j++){
						if(followingMatrix[j][i]){
							isInfluencer=false;
							break;
						}
					}
					//(i,i) will always be false, so skip
					
					// check for all (j,i) for j=i+1i to n
					
					for(int j=i+1;j<followingMatrix[i].length;j++){
						if(followingMatrix[j][i]){
							isInfluencer=false;
							break;
						}
					}
					
					if(isInfluencer)
						return i;
				}				
			}
			return -1;
		}
	
//		Each node is of the form (lr), where l represents the left child and
//		r represents the right child. If l is the character 0,
		
//		For example: (00) is a tree that consists of one node. 
//		((00)0) is a two-node tree in which the root has a left child,
//		and the left child is a leaf. And ((00)(00)) is a three-node tree,
//		with a root, a left and a right child. 

		
//		idea: Actually, we needn't compare the occurrence of ( or ), 
//		we just need to replace "(00)" with "0" and recur the process, 
//		return the times of replacement. See my code below:
		public static int findDepth(String s){
			if(s.length()==0)
				return -1;
			int times=-1;
			while(true){
				times=times+1;
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
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] pairs={1,2,1,3,1};
		System.out.println(findAllPairs(pairs));
		
		System.out.println(firstNonRepeating("geeksforgeeksf"));
		System.out.println(firstNonRepeatingChar("geeksforgeeksf"));
		ListNode lst1=new ListNode(1);
		ListNode dig2=new ListNode(2);
		ListNode dig3=new ListNode(3);
		lst1.next=dig2;
		dig2.next=dig3;
		
		
		ListNode lst2=new ListNode(4);
		ListNode d2=new ListNode(5);
		ListNode d3=new ListNode(2);
		lst2.next=d2;
		d2.next=d3;
		
		ListNode dif=difference(lst1,lst2);
		
		while(dif!=null){
			System.out.print(dif.val+" ");
			dif=dif.next;
		}
		System.out.println();
		
		ListNode lst3=new ListNode(6);
		ListNode ld2=new ListNode(7);
		ListNode ld3=new ListNode(8);
		ListNode ld4=new ListNode(9);
		lst3.next=ld2;
		ld2.next=ld3;
		ld3.next=ld4;
		
		System.out.println("**********************");
//		TreeNode tree=convertList2Tree(lst3);
//		inorder(tree);
		System.out.println();
		ListNode ret=addThreeNumber(lst1,lst2,lst3);
//		ListNode ret=addList(lst1,lst2);
//		ListNode ret=addTwoNumber(lst1,lst2);
		while(ret!=null){
			System.out.print(ret.val+" ");
			ret=ret.next;
		}
		System.out.println();
		ListNode head = new ListNode(5);
		ListNode node1 = new ListNode(0);
		ListNode node2 = new ListNode(7);
		ListNode node3 = new ListNode(5);
		ListNode node4 = new ListNode(8);
		ListNode node5 = new ListNode(4);
		ListNode node6 = new ListNode(4);
		ListNode node7 = new ListNode(4);
		head.next = node1;
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		node6.next = node7;
		
		System.out.println("**********************ccc");
		TreeNode tree=convertList2Tree(head);
		inorder(tree);
		System.out.println();
		
		ListNode nhead=insertionSortList2(head);
		 while( nhead!=null){
				System.out.print( nhead.val+" ");
				nhead= nhead.next;
			}
		 System.out.println();
		
//		reorderList(head);
		
		System.out.println("-------------");
		 ListNode h=reverseLinkedList(head);
		 while( h!=null){
				System.out.print( h.val+" ");
				 h= h.next;
			}
		 System.out.println();
		ListNode sortnode=reverseList(head);
		
//		ListNode middle=getMiddle(head);
//		System.out.print( middle.val+" ");
//		ListNode sortnode=sortList(head);
		while( sortnode!=null){
			System.out.print( sortnode.val+" ");
			 sortnode= sortnode.next;
		}
		System.out.println();
		ListNode leftnodes=removeNode(head,4);
		while(leftnodes!=null){
			System.out.print(leftnodes.val+" ");
			leftnodes=leftnodes.next;
		}
		System.out.println();
//		System.out.println(findNthNodeToLast(head,2).val+ "oooo");
		
		
		int[] arr={5,75,25};
		int res[]=twoSum(arr,100);
		
		System.out.println(res[0]+" "+res[1]);
		
		TreeNode root=new TreeNode(5);
		root.left=new TreeNode (2);
		root.right=new TreeNode(7);
		root.left.right=new TreeNode(4);
		root.left.left=new TreeNode(1);
		root.right.right=new TreeNode(8);
		root.right.right.right=new TreeNode(9);
		root.right.left=new TreeNode(6);
		root.left.right.left=new TreeNode(3);
//		root.left.right.right=new TreeNode(11);
		
		System.out.println("uuuuuuuuuuuuuuuuuuuuu");
		System.out.println(findKDistanceNodes(root,2));
//		TreeNode chead=treeToCircularDoublyList(root);
//		TreeNode crr=chead;
//		do{
//			System.out.print(crr.val+" ");
//			crr=crr.right;
//			
//		}while(crr!=chead);
		
		System.out.println("uuuuuuuuuuuuuuuuuuuuu");
//		convertTree(root);
//		inorder(root);
		printSpiral(root);
		System.out.println();
		System.out.println(isSumTree(root));
		System.out.println(printPaths(root));
		System.out.println(getMaxWidth(root));
		printKDistant(root,2);
		System.out.println("*******");
		System.out.println(inOrderSuccessor(root,root.left.right).val);
		System.out.println("---xxxxx---------xxxxx------xxxxx---");
		printKeysInRange(root,2,8);
		System.out.println();
		System.out.println(largestBSTSize(root));
		printBoundary(root);
		System.out.println();
		
		convertToSumTree(root);
		inorder(root);
//		TreeNode gRoot=addGreaterTree(root);
//		inorder(gRoot);
//		 TreeNode dllhead=convertBSTtoDLL(root);
//		 while(dllhead!=null){
//			 System.out.print(dllhead.val+" ");
//			 dllhead=dllhead.right;
//		 }
//		 System.out.println("---xxxxx---------xxxxx------xxxxx---");
		printAncestorsIterative(root,6);
		System.out.println("---xxxxx---------xxxxx------xxxxx---");
		System.out.println(serializeTree(root));
		System.out.println("---oooo---------oooooo------oooooo---");
//		root.left.right.left.left=new TreeNode(3);
//		root.left.right.left.left.left=new TreeNode(3);
//		root.left.right.left.left.left.left=new TreeNode(3);
		
//		System.out.println(serializationBT2(root));
//		System.out.println("---------------------");
//		
//		inorder(createTree(null,serializationBT2(root)));
//		System.out.println();
//		System.out.println("---------------------");
		
		
//		DispBTree(root);
//		System.out.println(serializationBT(root));
//		ArrayList<Character> serialList=serializationBT(root);
//		System.out.println(deserializationBT(serialList).val);
//		inorder(deserializationBT(serialList));
//		System.out.println();
		
		TreeNode root1=new TreeNode(5);
		root1.left=new TreeNode (7);
		root1.right=new TreeNode(2);
		root1.left.right=new TreeNode(8);
		root1.left.left=new TreeNode(6);
		root1.right.right=new TreeNode(1);
//		root1.right.right.right=new TreeNode(3);
		root1.right.left=new TreeNode(4);
		root1.right.left.right=new TreeNode(3);
		
		System. out.println("xxxxxxxoooooooozzzzjjjj");
		doubleTree(root1);
		inorder(root1);
		 System. out.println();
	       System. out.println("***********");
	       System. out.println(treeLevelSum(root));
//	       dfsTraverse(roo);
	       TreeNode removed=remove(root,7);
	       inorder(removed);
	       System. out.println();
	       System. out.println("*************");
		visible(root);
		System.out.println();
		System.out.println(isScrambleTree(root, root1));
		
		System.out.println(verticalView(root));
		
		System.out.println("11oxoxoxoxoxoxxoxoxoxoxo");
		System.out.println(deepestLeftLeaf(root).val);
		System. out.println(findCousins(root,1));
		System. out.println();
	       System. out.println(longestPathOneBend(root));
	       System. out.println("--------------");
		changeTree(root);
		TreeNode cur=root;
		while(cur!=null){
			System.out.print(cur.val+" ");
			cur=cur.right;
		}
		System.out.println();
		System.out.println("oxoxoxoxoxoxxoxoxoxoxo");
////		inorder(root);
//		System.out.println();
//		mirror(root);
//		inorder(root);
		
		
		System.out.println(LCA(root,root.left.right,root.right.right).val);
		System.out.println(findLCA(root,root.left.right,root.left.left).val);
		System.out.println(getNodeLevel(root,5)+" ssss");
		
		System.out.println(findDistanceBetweenNodes(root,2,1));
		
//		System.out.println(convert2DLL(root).val);
//		System.out.println(getClosestNode(root,0).val+" value");
//		TreeNode treeNode=treeToDoublyList(root);
//		while(treeNode.right!=null){
//			System.out.print(treeNode.val+" ");
//			treeNode=treeNode.right;
//		}

		System.out.println();
		System.out.println(diameter(root)+"xxxxxxx");
		System.out.println("Diameter is "+diameterOpt(root)+" xxxxxxx");
		
		System.out.println(preOrder(root));
		System.out.println(postOrder(root));
		
		System.out.println(levelOrderdfs(root));
		
		System.out.println(minCut2("lts"));
		
		System.out.println(removeBandACFromString("aac"));
		System.out.println(validParentheses(")(dkk)() "));
		
		String word = "catsanddog";
		HashSet<String> set=new HashSet<String>();
		set.add("cat");
		set.add("cats");
		set.add("sand");
		set.add("dog");
		set.add("and");
		
		System.out.println(wordBreak2(word,set));
		System.out.println(isInterleave("a","b","ab"));
		findFirstNonRepeating();
		int[] input1={1,2,3,4,5};
		multiplyExceptSelf(input1);
		int[] zeroarr={1,9,8,4,0,0,2,7,0,6,0,9};
		putZerosToEnd(zeroarr);
		System.out.println();
		
		Stack<Integer> stk=new Stack<Integer>();
		stk.push(2);
		stk.push(3);
		stk.push(1);
		stk.push(4);
		stk.push(5);
		stk.push(8);
		stk.push(0);
		
//		Stack<Integer> reversestk=reverseStack(stk);
//		
//		while(!reversestk.isEmpty()){
//			System.out.print(reversestk.pop()+" ");
//		}
//		
		System.out.println("--------------------------------------");
//		Stack<Integer> s=sortStack(stk);
		Stack<Integer> s=sortStk(stk);
		while(!s.isEmpty()){
			System.out.print(s.pop()+" ");
		}
		System.out.println("--------------------------------------");
		System.out.println();
		int[] values={6,2,1,3,1};
		System.out.println(maxStolenValue2(values));
		
		System.out.println(minSplit2("eegiicgaeadbcfacfhifdbiehbgejcaeggcgbahfcajfhjjdgj"));
		
		int[] threearray={3, 2, 5, 1, 4, 7, 9, 6, 8};
		increasingIndex(threearray);
		
		System.out.println(triangle(4));
		
		System.out.println(reverseSentence("s1 23 I have  36 23books, 40 pens2, and 1 2notebook3."));
	
		System.out.println(isFibonacci(4));
		
		int stream[]={12,3,4,5,6,7,8,9,10,1,11,13};
		selectKItems(stream,4);
		
		multiply("1","1");
		String[] L={"a"};
		System.out.println(findSubstring("a",L));
		
		char[] str={'a','b','c','c','c','d','s','s','e','d','s'};
		System.out.println(removeDuplicates(str));
		
		System.out.println(compress("AAABBBBBCDEHHS"));
		System.out.println(uncompress("A3B5CDEH2S"));
		
		int[] iteration={5,6,3,9,-1};
		
		System.out.println(NIterationArray(iteration,4));
		
		System.out.println(permutations("ABC"));
		int[] dupArray = {1,2,3,1,4,1,4};
		
		findDupOccandidx(dupArray);
		System.out.println(countAndSay(2));
		System.out.println(letterCombinations("2"));
		
		int[] arrayDif={2, 3, 10, 6, 4, 8, 1 };
		System.out.println(maxDiff(arrayDif)+" Yuan fengpeng");
		System.out.println(maxDifferent(arrayDif));
		
		int[] partitionArray={1,2};
		partitionArrayto3Parts(partitionArray,1);
		System.out.println();
		
		int[] medianStream={5, 15, 1, 3, 2, 8, 7, 9, 10, 6, 11, 4};
		getMedianofStream(medianStream);
		
		int[][] matrix={{7},{9},{6}};
		System.out.println(spiralOrder(matrix));
		System.out.println( minWindow("a","a"));
		
		System.out.println(lengthOfLongestSubstring("ruowzgiooobpple"));
		
		int[] kthArray={1,3,5,7,2,4,6,0,9};
		System.out.println(partition2(kthArray,0,7));
//		System.out.println(quickSelect(kthArray,0,7,1));
		System.out.println(findKthElement(kthArray,3));
		System.out.println("***********************************************");
		System.out.println(numDecodings2("123"));
		int[] array01={0,0,0,0,0,0,1,1,1,1,1};
		System.out.println(findNumOf0s(array01));
		
		int[] coins={2, 5, 3, 6};
		System.out.println(makeChange(coins,10)+" ways");
		System.out.println(makeChange2(coins,10)+" ways");
		System.out.println(coinChange(coins,10)+" ways");
		
		System.out.println(getInitial(" this is a test case "));
		
//int[] morethanthird={2, 3 ,1, 2, 2 ,2, 1, 4, 3 ,3};
int[] morethanthird={0,0,0,0,2,3,4,4,5,5};
		
		System.out.println(moreThanThird(morethanthird));
		moreThanThird2(morethanthird);
		
		int[] NGE={3,2,5,11,4,11,13,8,6,20,10};
		nextLargerNumber(NGE);
		
		System.out.println(convertString("abcdefgh", 3));
		
		int[] arr1={ 5, 3, 7, 6, 2, 2,1,0};
		ListNode node=insertionSort(arr1);
		while(node!=null){
			System.out.print(node.val+" ");
			node=node.next;
		}
		System.out.println();
		TreeNode treenode=level_order_insert(arr1);
		inorder(treenode);
		
		
		
		
		
		
		
		
		
		
		
		
		
		  Trie dict = new Trie();        
	        dict.insert("are");
	        dict.insert("area");
	        dict.insert("base");
	        dict.insert("cat");
	        dict.insert("cater");        
	        dict.insert("basement");
	         
	        String input = "caterer";
	        System.out.print(input + ":   ");
	        System.out.println(dict.getMatchingPrefix(input));              
	 
	        input = "basement";
	        System.out.print(input + ":   ");
	        System.out.println(dict.getMatchingPrefix(input));                      
	         
	        input = "are";
	        System.out.print(input + ":   ");
	        System.out.println(dict.getMatchingPrefix(input));              
	 
	        input = "arex";
	        System.out.print(input + ":   ");
	        System.out.println(dict.getMatchingPrefix(input));              
	 
	        input = "basemexz";
	        System.out.print(input + ":   ");
	        System.out.println(dict.getMatchingPrefix(input));                      
	         
	        input = "xyz";
	        System.out.print(input + ":   ");
	        System.out.println(dict.getMatchingPrefix(input)); 
	        
	        System.out.println( permuteString("yuan"));
	        
	        bucketSort(NGE);
	        
	        System.out.println(longestCommonSequence("1234567890","013549"));
	        
	        
	        int[] ayy={1,3,5,7,2,4,6,0,2,9};
//	        System.out.println(findKthElement(ayy,2));
//	        System.out.println(topKthNumber(ayy,3));
	        
	        System.out.println(minWindow2("aa","aa"));
	        
	        TreeNode below=new TreeNode(2);
	        below.left=new TreeNode(5);
	        below.right=new TreeNode(4);
	        
	        TreeNode above=new TreeNode(2);
	        above.right=new TreeNode(3);
	        
	        TreeNode impose=superImpose2(below, above);
	       inorder(impose);
	       System.out.println();
	       
	       int[] rotateArry={1,2,3,4,5,6};
	       rotateLeftKTimes(rotateArry,10);
	       
	       System.out.println(reverseWords("reverse words of a sentence."));
	       int[] inputA={3,4,5,2,7,5,7,3,8,2,5,7,9,1,3};
	       nextSmallerNumber(inputA);
	       
	       System.out.println(nextPalindrome(99)+" yuan");
//	       System.out.println(reverseNum("1"));
//	       System.out.println(nextPalindrome(9));
	       
	       int[] order={6,5,3,4,2};
	       reorder(order);
	       
	       System.out.println(evaluate1("1+2*4"));
	       
	       int[] a={};
	       int[] b={1,1};
	       
	       arrayUnion(a,b);
	       arrayIntersect(a,b);
	       System.out.println();
	       System.out.println(decToExcel(27));
	       
	       Set<String> dic=new HashSet<String>();
	       dic.add("a");
	       dic.add("b");
	       
	       System.out.println(transform(dic, "b","a"));
	       
	       ListNode h1=new ListNode(3);
	       ListNode h2=new ListNode(2);
	       ListNode h3=new ListNode(4);
	       h1.next=h2;
	       h2.next=h3;
	       
	       ListNode h4=sortList2(h1);
	       
	       while(h4!=null){
	    	   System.out.print(h4.val+" ");
	    	   h4=h4.next;
	       }
	       System.out.println();
	       
	       
	       System. out.println("<db name=\""+2+"\" "+ "imei=\""+3+"\">");
	       
	       System. out.println("<table name=\"" +2+"\">");
	       
	       System. out.println(minChange("bba"));
	       
	       String[] terms={"is","good","20"};
	       
	       System. out.println(makeWordBold("Yuan Fengpeng now 20, is good21!",terms));
	       
	       int[] levelorder={ 5, 2, 1, 3, 4, 7, 8};
	       TreeNode r=buidTreeFromArray(levelorder);
	       inorder(r);
	       System. out.println();
	       countSorting(levelorder);
	       
	       TreeNode roo=new TreeNode(1);
	       roo.left=new TreeNode(2);
	       roo.right=new TreeNode(3);
	       roo.right.left=new TreeNode(7);
	       roo.left.left=new TreeNode(4);
	       roo.left.left.left=new TreeNode(5);
	       roo.left.left.right=new TreeNode(6);
	       inorder(roo);
	       System. out.println();
	       System. out.println("***********");
	       
	      
	       System. out.println("*********** yuanananna");
	       System.out.println(nextRight(roo, 4).val);
	       System. out.println(treeLevelSum(roo));
//	       sumTree(roo);
//	       inorder(roo);
	       dfsTraverse(roo);
//	       TreeNode removed=remove(roo,2);
//	       inorder(removed);
	       System. out.println();
	       System. out.println("*************");
	       printTreeBracket(roo);
	       System. out.println();
	       System. out.println("--------------");
	       System. out.println(isSameLevel(roo));
	       
	       int[] level={0};
	       TreeNode parent=findLevelandParent(roo,4,0,level,null);
	       System.out.println(level[0]);
	       
	       System. out.println(parent.val);
	       System.out.println(findCousins(roo,4));
	       System.out.println(deepestLeftLeaf(roo).val);
	       System. out.println(depthOfOddLeaf(roo));
	       System. out.println("--------------");
	       
	       leftViewofBT(roo);
	       
	       System. out.println();
	       System. out.println(longestPathOneBend(roo));
	       System. out.println("--------------");
	       TreeNode flip=flipDown2(roo);
	       inorder(flip);
	       System. out.println();
	       
	       Point point1=new Point(0,0);
	       Point point2=new Point(1,1);
	       Point point3=new Point(0,0);
	       Point[] points={point1, point2, point3};
//	       System.out.println(maxPoints(points));
	       
//	       System.out.println(-0.0==0.0);
	       printTreeBracket(roo);
	       
	       leftViewofBT(roo);
	       System.out.println(-0.0==0.0);
	       
	       
//	       System.out.println(parent.val);
	       String[] RPN={"4","-2","/","2","-3","-","-"};
	       System.out.println(evalRPN(RPN));
//	       System.out.println(Integer.parseInt("-2"));
	       
	       ListNode p=new ListNode(1);
	       p.next=new ListNode(1);
	       System.out.println(isPalindrome(p));
	       
	       int[] arrs={1,2,5,7,3,4,6};
	       System.out.println(secondBiggest(arrs));
	       
	       findAllFactors(24);
	       
	       int[] arrx={1,2,1};
	       System.out.println(findIndexSameSum(arrx));
	       
	       System.out.println(longestPalindromeSimple("abcdedcb"));
	       int[] sorted={1,3};
	       System.out.println(firstMissing(sorted));
	       
	       System.out.println(string2StringWithOneChange("cats","cat"));
	       System.out.println(factorialZeroes(35));
	       
	       int[] slideWindow= {12, 1, 78, 90, 57, 89, 56};
	       slidingWindowMax(slideWindow,3);
	       System.out.println(removeDup("aaaa"));
	       
	       System.out.println(multiply(3,10));
	       
	       System.out.println("HH "+longestSubStringContainK("aabcdcbeaacbce",3));
	       
	       
	       int[] dupArr={5,2,2,1,4,6};
	       System.out.println(findDupIndex(dupArr,6));
	       
	       List<Object> list=new ArrayList<Object>();
	       List<Object> element=new ArrayList<Object>();
//	       element.add(1);
	       element.add(2);
	       List<Integer> subele=new ArrayList<Integer>();
	       subele.add(3);
	       subele.add(4);
	       element.add(subele);
	       
	       list.add(element);
	       list.add(5);
	       
	       System.out.println(deepSum(list)+" yuan");
	       
	       int[] test={3,2,3,4,3,5,3,3,2,2};
	       System.out.println(getMajority(test));
	       char[] ch="abbbccddeefgh".toCharArray();
	       System.out.println(ch);
	       System.out.println(compressInplace(ch));
	       
	       int[] array1={1,2,2,3,3,4,4,4,5};
	       int[] arr2={2,3,4,6};
	       findIntersection(array1, arr2);
	       System.out.println();
	       System.out.println(printAllUniqueParts(4));
	       printAllUniqueParts2(4);
	       int[] levelOrder={1,2,3,4,5,6,7};
	       TreeNode treeRoot=levelOrder2Tree(levelOrder);
	       
	       inorder(treeRoot);
	       
	       System.out.println();
	       
	       TreeNode treee=levelOrderToTreeNode(levelOrder);
	       inorder(treee);
	       
	       System.out.println();
	       
	       int[] g1={5,3,4,7};
	       int[] g2={1,6,2,8};
	       
	       System.out.println(minWeightDiff(g1,g2));
	       
	       System.out.println(numToStringExcel(51));
	       System.out.println(getExcelNumber(27));
	       
	       int start[] =  {1, 3, 0, 5, 8, 5};
	       int f[] =  {2, 4, 6, 7, 9, 9};
	       
	       maxActivities(start,f);
	       
	       TreeNode rootx=new TreeNode(5);
			rootx.left=new TreeNode (2);
			rootx.right=new TreeNode(7);
			rootx.left.right=new TreeNode(4);
			rootx.left.left=new TreeNode(1);
			rootx.right.right=new TreeNode(8);
			rootx.right.right.right=new TreeNode(9);
			rootx.right.left=new TreeNode(6);
			rootx.left.right.left=new TreeNode(3);
	       
	       
	      String sequence=serializeTree(rootx);
	       System.out.println(sequence+" dsdd");
//	       TreeNode recoverroot=deserialize("527#468#####9##");
	       TreeNode recoverroot=deserialize(sequence);
	       inorder(recoverroot);
	       System.out.println();
	       System.out.println();
	       System.out.println();
	       System.out.println();
	       System.out.println(); System.out.println();
	       
	       
	       int[] prices={2 ,4, 3, 5, 3, 1, 7};
	       
	       System.out.println(maxProfit(prices, 1));
	       
	       String[] tokens={"3","+" ,"4","*","5","*","6","+","7","+","10","*","2" };
	       System.out.println(evalIPN(tokens));
	       
	       int[] A1={0,0,1,0,0,0,1,0,0};
	       int[] B1={0,0,0,0,0,1,0,0,0};
	       
	       System.out.println(findMaxIndices(A1,B1));
	       
	       int[] a1={ 4, 10, 15, 25, 26};
	       int[] a2={0, 9, 12, 20};
	       int[] a3={5, 18, 22, 30};
	       
	       getMinRange(a1,a2,a3);
	       
	       System.out.println(parity("yuan1"));
	       
	       int[] test1={6,1,2,3,4,5,7,8,9,10};
	       System.out.println(findKthLargest(test1,10));
	       
	       int[] a4={1,2,3,4};
	       int[] b2={3,4,5,6};
	       
	       System.out.println(findKthLargestSum(a4,b2,5));
	       
	       System.out.println(findKthSum(a4,b2,4));
	       System.out.println("$$$$$$$$$$$$$$$$$$$$$");
	       int[] halfArray={1, 0, 2, 1, 2, 1}; 
	       System.out.println(findHalf(halfArray));
	       
	       
	       int[] negpos={1,7,-5,9,-12,15};
	       
	       rearrange(negpos);
	       
	       int[] minSeq={2,1,4,5,3,0,7,9,-1,3};
	       
	       System.out.println(findShortestSequence(minSeq,15));
	       System.out.println(splitNum3(6,4));
	       
	      int arrK[] = {8, 12, 16, 4, 0, 20};
	      System.out.println(countPairsWithDiffK(arrK,4));
	      
	      int[] jump = new int[]{2,3,1,1,3};
	      
	      System.out.println(findLoop(jump));
	      System.out.println(findLoopConSpace(jump));
	      
	      int[] asc={1,2,3,5,4,6,7};
	      System.out.println(isAscending(asc));
	      
	      int[] xarr={1,2,2,3,3,2,3,5,3};
	      moreThanThirdNew(xarr);
	      
	      
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
	      
	      ComplexListNode retNode=flattenMultiLevelList2(complexhead);
	      
	      while(retNode!=null){
	    	  System.out.print(retNode.val+" ");;
	    	  retNode=retNode.next;
	      }
	      
	      ListNode t1=new ListNode(12);
	      ListNode t2=new ListNode(15);
	      ListNode t3=new ListNode(10);
	      ListNode t4=new ListNode(11);
	      ListNode t5=new ListNode(5);
	      ListNode t6=new ListNode(6);
	      ListNode t7=new ListNode(2);
	      ListNode t8=new ListNode(3);
	      
	      t1.next=t2;
	      t2.next=t3;
	      t3.next=t4;
	      t4.next=t5;
	      t5.next=t6;
	      t6.next=t7;
	      t7.next=t8;
	      
	      ListNode te=delLesserNodes(t1);
	      
	      while(te!=null){
	    	  System.out.print(te.val+" ");
	    	  te=te.next;
	      }
	      
	      System.out.println();
	      
	      System.out.println(LCSubStr("ABAB" , "BABA"));
	      
	      naivePatternSearch("AABA","AABAACAADAABAAABAA");
	      KMP("abcd","abcdabcd");
	      
	      
	      TreeLinkNode r1=new TreeLinkNode(5);
	      r1.left=new TreeLinkNode(2);
	      r1.right=new TreeLinkNode(7);
	      r1.left.left=new TreeLinkNode(1);
	      r1.left.right=new TreeLinkNode(3);
	      r1.right.left=new TreeLinkNode(6);
	      
	      
	      populateNext(r1);
//	      populateNext2(r1);
	      TreeLinkNode ptr=r1.left.left;
	      while(ptr!=null){
	    	System.out.printf("Next of %d is %d \n", ptr.val, ptr.next!=null? ptr.next.val: -1);

	    	  ptr=ptr.next;
	      }
	      
	      System.out.println(doubleSquare(25));
	    
	      int[] height={8, 1, 6, 9, 8};
	      int[] count={1,3,2,0,0};
	      
	      rearrangeHeight(height,count);
	      
	      int[] seq={1, 20, 6, 4, 5};
	      
	      System.out.println(getInversionCount(seq));
	      System.out.println(getInversionCountMergeSort(seq));
	      
	      int pre[] = {10, 30, 20, 5, 15};
	      char preLN[] = {'N', 'N', 'L', 'L', 'L'};
	      
	      TreeNode cRoot = constructTree (pre, preLN);
	      inorder(cRoot);
	      System.out.println();
	      int inorder[] = {5, 10, 40, 30, 28};
	      TreeNode iRoot=buildTree(inorder);
	      inorder(iRoot);
	      
	      int maxdiff[]={1, 2, 6, 80, 100};
	      System.out.println(maxDiff2(maxdiff));
	      
	      int M[][] =  {{0, 1, 1, 0, 1}, 
                  {1, 1, 0, 1, 0}, 
                  {0, 1, 1, 1, 0},
                  {1, 1, 1, 1, 0},
                  {1, 1, 1, 1, 1},
                  {0, 0, 0, 0, 0}};
               
	      printMaxSubSquare(M);
	      
	      int[] ar={12, 13, 1, 10, 34, 1 };
	      
	      findSamllestand2ndSmallest(ar);
	      int[] leaders= {16, 17, 4, 3, 5, 2};
	      
	      findLeaders(leaders);
	      
	      int[] freqArray={2, 3, 2, 4, 5, 12, 2, 3, 3, 3, 12};
	      sortByFrequency(freqArray);
	      
	      int[] rotated={2,3,4,5,7,1};
	      System.out.println(findFirstEleRotatedAarray(rotated));
	      System.out.println(search(rotated,1));
	      System.out.println(findMinRotatedArray(rotated));
	      System.out.println(findMin(rotated));
	      System.out.println(findMax(rotated));
	      int[] consecutive={3,5,4,2,6,7};
	      System.out.println(areConsecutive(consecutive));
	      System.out.println(areConsecutive2(consecutive));
	      int[] missing={ 1,2, 3,  5, 6, 7};
	      System.out.println(findFirstMissing(missing));
	      
	      int[] tworepeat={4, 2, 4, 5, 2, 3, 1};
	      printRepeating(tworepeat);
	      printRepeating2(tworepeat);
	      
	      int[] ascDec={16,13,12,10};
	      System.out.println(findTurnPoint(ascDec));
	      System.out.println(findTurnPoint2(ascDec));
	      int[] colors={0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};
	      sortColors012(colors);
	      System.out.println(Arrays.toString(colors));
	      
	      int product[]={10, 3, 5, 6, 2};
	      System.out.println(Arrays.toString(productArray(product)));
	      System.out.println(Arrays.toString(productArray2(product)));
	      printRepeatingAnyTimes(tworepeat);
	      
	      int equal[] = {-7, 1, 5, 2, -4, 3, 0};
	      System.out.println(equilibrium(equal));
	      int[] unsorted={0, 1, 15, 25, 6, 7, 30, 40, 50};
	      finMinLengthMakeSorted(unsorted);
	      System.out.println();
	      int[] fixPoint={-10, -5, 3, 4, 7, 9};
	      System.out.println(findFixedPoint(fixPoint));
	      int[] nextGreater={13, 7, 6, 12};
	      printNGE(nextGreater);
	      
	      int[] maxdif={34, 8, 10, 3, 2, 80, 30, 33, 1};
	      System.out.println(maxIndexDiff(maxdif));
	      System.out.println(maxIndexDiff2(maxdif));
	      int mindis[]= {3, 5, 4, 2, 6, 5, 6, 6, 5, 4, 8, 3};
	      System.out.println(minDist(mindis,3,6));
	      System.out.println(minDist2(mindis,3,6));
	      
	      int[] set1={1,2,3,4,5,6};
	      int[] set2={1,4,2};
	      
	      System.out.println(isSubset(set1,set2));
	      int[] occurrence={1, 2, 2, 3, 3, 3, 3};
	      System.out.println(countOccurrences(occurrence,2));
	      int[] bitonic={10, 20, 30, 40};
	      System.out.println(maxLengthBitonic(bitonic));
	      int[] freq={2, 3, 2, 4, 5, 12, 2, 3, 3, 3, 12};
	      sortByFrequencyBST(freq);
	      
	      int rearrange[] = {-1, 2, -3, -4, -5, 6, -7, 8, 9};
	      rearrange2(rearrange);
	      int[] peak={ 1,2,3,4,5,3};
	      System.out.println(findPeak(peak));
	      
	      int[] largesrsub= {0, 0, 1, 1, 0};
	      System.out.println(findLargestSubArrayWith0s1s(largesrsub));
	      System.out.println(findLargestSubArrayWith0s1s2(largesrsub));
	      int[] nums= {12, 11, 10, 5, 6, 2, 30};
	      find3Numbers(nums);
	      int partition[] = {3, 1, 1, 2, 2, 1,12};
	      System.out.println(findPartiion(partition));
	      System.out.println(findPartiionDp(partition));
	      
	      int[] lis=  { 10, 22, 9, 33, 21, 50, 41, 60, 80 };
	      System.out.println(LongestIncreasingSubsequence(lis));
	      int[] longestbitonic={80, 60, 30, 40, 20, 10};
	      System.out.println(LongestBitonicSubsequence(longestbitonic));
	      int[][] matrix1 = {{0, 0, 1, 0}, {0, 0, 1, 0}, {0, 0, 0, 0}, {0, 0, 1, 0}};
	      System.out.println(findCelebrity(matrix1));
	      
	      int[] subsum= {1, 4, 0, 0, 3, 10, 5};
	      System.out.println(subArraySum(subsum,7));
	      
	      int jumps[] = {1, 3, 6, 1, 0, 9};
	      
	      System.out.println(minJumps(jumps));
	      
	      int maxsumis[] = {10, 5, 4, 3};
	      System.out.println(maxSumIS(maxsumis));
	      int size=30;
	      int[] A=new int[30];
	      for(int i = 0; i < size; i++)
	          A[i] = i+1;
	      System.out.println(Arrays.toString(A));
	      MatrixInplaceTranspose(A,6,5);
	      
	      System.out.println(Arrays.toString(A));
	      
	      int mat[][] = { {0, 0, 0, 1},
	    	        {0, 1, 1, 1},
	    	        {1, 1, 1, 1},
	    	        {0, 0, 0, 0}
	    	    };
	      
	      System.out.println(rowWithMax1s(mat));
	      
	      int[] ksorted = {2, 6, 3, 12, 56, 8};
	      sortKSorted(ksorted,3);
	      System.out.println(Arrays.toString(ksorted));
	      int[] circular={-2, 4, -1, 4, -1};
	      System.out.println(kadane(circular));
//	      System.out.println(maxCircularSum(circular));
	      System.out.println(maxCircularSum2(circular));
	      
	      int[] foursum={2,0,1,-1};
	      System.out.println(fourSum2(foursum,2));
	      int[] findpair={5, 20, 3, 2, 50, 80};
	      findPair(findpair,78);
	      Pair[] pairchain={new Pair(5, 14), new Pair(39, 60), new Pair(15, 28), new Pair(29, 40),new Pair(50, 90)};
	      System.out.println(maxChainLength(pairchain));
	      int[] nextgreatest={16, 17, 4, 3, 5, 2};
	      nextGreatest(nextgreatest);
	      int random[] = {1, 2, 3, 4, 5, 6, 7, 8};
	      
	      randomize(random);
	      int[] quicksort={4, 3, 5, 2, 1, 3, 2, 3};
	      
	      quickSortIterative(quicksort,0,7);
	      
	      int[] edges={10,20,30,40};
	      System.out.println(findNumberOfTriangles(edges));
	      
	      int maxrepeat[] = {1,3,1,3,1};
	      
	      System.out.println( maxRepeating(maxrepeat,4));
	      
	      int[] pan={2,23, 1,10, 4,20, 11, 12, 6, 7,28};
	      pancakeSort(pan);
	      
	      int[] pancake = {18, 40, 35, 12, 30, 35, 20, 6, 90, 80};
	      insertionSortPancake(pancake);
	      
	      int num[] = {9, 4, 1, 8, 7, 9, 7, 8, 3, 2, 2};
	      generateNextPalindrome(num);
	      
	      int[] coin={1,2,3};
	      System.out.println(makeChangeDP(coin,5));
	      System.out.println(makeChangeDPOpt(coin,5));
	      
	      int islands[][]= {  {1, 1, 0, 0, 0},
	    	        {0, 1, 0, 0, 1},
	    	        {1, 0, 0, 1, 1},
	    	        {0, 0, 0, 0, 0},
	    	        {1, 0, 1, 0, 1}
	    	    };
	      
	      System.out.println(numOfIsland(islands));
	      
	      transpose("abcde","bcdae");
	      
	      int[][] arrmatrix = {{1,2,3,1},
				  {1,0,-1,2},
				  {-1,1,1,1}};
	      coverMatrix(arrmatrix);
	      
	      int[] update={5, 4, 0, 3, 1, 6, 2} ;
	      updateArray(update);
	      
	      System.out.println(isMultipleOfFive(10));
	      
	      System.out.println(isWellFormed("()"));
	      
	      int[] Aa = {1, 3, 4, 6,8,10, 17, 34};
	    		int[]  Bb = {2, 8, 17, 33, 44, 66, 89, 100, 123}; 
	      intersetion(Aa, Bb);
	      System.out.println();
	      topKLargest(nums,4);
	      
	      
	      TreeNode bt=new TreeNode(5);
	      bt.left=new TreeNode(2);
	      bt.right=new TreeNode(7);
	      bt.left.left=new TreeNode(1);
	      bt.left.right=new TreeNode(4);
	      bt.right.right=new TreeNode(8);
	      inorder(bt);
	      System.out.println("++++++++++++++++++++++++++++");
	      System.out.println(kthLargestNode(bt,2).val);
	      System.out.println(findSecondMaxOfBST(bt).val);
	      
	      binaryTreeToBST(bt);
	      inorder(bt);
	      System.out.println();
	      System.out.println(inorderPredecessor(bt, bt.right.right).val);
	      
	     TreeNode dllhead= BinaryTree2DoubleLinkedList(bt);
	     while(dllhead!=null){
	    	 System.out.print(dllhead.val+" ");
	    	 dllhead=dllhead.right;
	     }
	     System.out.println();
	     int maze[][]  =  { {1, 0, 0, 0},
	    	        {1, 1, 0, 1},
	    	        {0, 1, 0, 0},
	    	        {1, 1, 1, 1}
	    	    };
	    solveMaze(maze);	 
	    
	    ListNode odd=new ListNode(1);
	    ListNode o1=new ListNode(2);
	    ListNode o2=new ListNode(3);
	    ListNode o3=new ListNode(4);
	    ListNode o4=new ListNode(5);
	    ListNode o5=new ListNode(6);
	    ListNode o6=new ListNode(7);
	    
	    odd.next=o1;
	    o1.next=o2;
	    o2.next=o3;
	    o3.next=o4;
	    o4.next=o5;
//	    o5.next=o6;

//	    rearrange(odd);
//	    while(odd!=null){
//	    	System.out.print(odd.val+" ");
//	    	odd=odd.next;
//	    }
	    
	    ListNode oddhead=rearrange2(odd);
	    while(oddhead!=null){
    	System.out.print(oddhead.val+" ");
    	oddhead=oddhead.next;
    }
	   
	    System.out.println(findAllPairEqualSumBST(rootx,10));
	    
	    
	    int Array1[] = {1, 3, 4, 5, 7};
	    int Array2[] = {2, 3, 5, 6};
	    
	    intersectionOfTwoSortedArray(Array1,Array2);
	    unionOfTwoSortedArray(Array1,Array2);
	    
	    System.out.println(longestRepeatedString("banana"));
	    System.out.println(longestRepeatedSubString("banana"));
	    
	    ListNode loophead=new ListNode(0);
	    ListNode l1=new ListNode(1);
	    ListNode l2=new ListNode(2);
	    ListNode l3=new ListNode(3);
	    ListNode l4=new ListNode(4);
	    ListNode l5=new ListNode(5);
	    ListNode l6=new ListNode(6);
	    ListNode l7=new ListNode(7);
	    ListNode l8=new ListNode(8);
	    ListNode l9=new ListNode(9);
	    loophead.next=l1;
	    l1.next=l2;
	    l2.next=l3;
	    l3.next=l4;
	    l4.next=l5;
	    l5.next=l6;
	    l6.next=l7;
	    l7.next=l8;
	    l8.next=l9;
	    l9.next=l9;
	    
	    System.out.println(lengthOfListContainsLoop(loophead));
	    
	    int[] nextgreater={5,2,3,1,6,4,7};
	    nextGreaterElement(nextgreater);
	    nextLargerNumber(nextgreater);
	    
	    try {
			System.out.println(divideWithoutdivision(10,-3));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    char[][] letters={{'a','b','c','d'},{'e','f','g','h'},{'i','j','k','l'},{'m','n','o','p'}};
	    HashSet<String> dictionary=new HashSet<String>();
	    dictionary.add("abf");
	    dictionary.add("jkl");
	    dictionary.add("fba");
	    dictionary.add("fgh");
	    dictionary.add("jfbc");
	    dictionary.add("dcbfe");
	    dictionary.add("miea");
	    dictionary.add("oklhgc");
	    dictionary.add("plkjfgcba");
	    dictionary.add("abcdh");
	    
	    System.out.println(findValidWords(letters, dictionary));
	    int[] threeNum={-6,1,2,-33,4,15,7,28,-9,10};
	    maxProduct(threeNum);
	    
	    System.out.println(waysOfLego(5));
	    
	    findRepeatingStrings("ABCACBABC",3);
	    findRepeatingStrings("ABCABCA",2);
	    
	    System.out.println(isIsomorphic("foo","app"));
	    System.out.println(isIsomorphic("bar","foo"));
	    char[] ch1={'a','c','f','j','k'};
	    System.out.println(findNextChar(ch1, 'p'));
	    
	    System.out.println(findDepth("((00)(0(00)))"));
	}

}

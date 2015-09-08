import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Stack;

public class LeetCode {
	
	public LeetCode(){
		//System.out.println("sfcwefw");
	}
	//ListNode n = new ListNode(1);
public int lengthOfLongestSubstring(String s) {
        int max = 0, len = 0, start = 0, end = 0, ls = s.length();
        HashSet set = new HashSet();
        while(end != ls && start != ls){
        		char c = s.charAt(end);
        		if(!set.contains(c)){
        			set.add(c);
        			len++;
        			end++;
        			max = (max > len)? max : len;
        		}else{
        			max = (max > len)? max : len;
        			set.remove(s.charAt(start));
        			len--;
        			start++;
        		}
        }
		return max;
    }
	
	public void rotate(int[][] matrix) {
		int mx = matrix.length, my = matrix[0].length,rm[][] = new int[my][mx];
        for(int i = 0 ; i < my ; i ++){
        		for(int j = mx-1 ; j >= 0 ; j --){
        			rm[i][mx-j-1] = matrix[j][i];
        		}
        }
        for(int i = 0 ; i < my ; i ++){
    		for(int j = 0 ; j < mx ; j ++){
    			System.out.print(rm.toString());
    		}
    		System.out.println();
    }
    }
	
	public void sortColors(int[] A) {
        int len = A.length, r = 0 ,w = 0, b =0;
        for(int i = 0 ; i < len ; i++){
        		if(A[i] == 0){
        			r++;
        		}else if(A[i] == 1){
        			w++;
        		}else if(A[i] == 2){
        			b++;
        		}
        }
        for(int i = 0 ;i < r ; i++){
        		A[i] = 0;
        }
        for(int i = r ;i < w+r ; i++){
    		A[i] = 1;
		    } for(int i = w+r ;i < len ; i++){
				A[i] = 2;
		}
		    
		    for(int i = 0 ;i < len ; i++){
        		System.out.print(A[i]);
        }
    }
	public static int monthToNumber(String m){
		if("January".equals(m)) return 1;
		else if("February".equals(m)) return 2;
		else if("March".equals(m)) return 3;
		else if("April".equals(m)) return 4;
		else if("May".equals(m)) return 5;
		else if("June".equals(m)) return 6;
		else if("July".equals(m)) return 7;
		else if("August".equals(m)) return 8;
		else if("September".equals(m)) return 9;
		else if("October".equals(m)) return 10;
		else if("November".equals(m)) return 11;
		else if("December".equals(m)) return 12;
		else return -1;
	}
	public static int weekToNumber(String w){
		if("Monday".equals(w)) return 1;
		else if("Tuesday".equals(w)) return 2;
		else if("Wednesday".equals(w)) return 3;
		else if("Thursday".equals(w)) return 4;
		else if("Friday".equals(w)) return 5;
		else if("Saturday".equals(w)) return 6;
		else if("Sunday".equals(w)) return 0;
		else return -1;
	}
	
	public static int Days(int m, boolean isLeap){
		if(m == 4 || m == 6 || m == 9 || m == 11) return 30;
		else if(m == 2){
			if(isLeap) return 29; else return 28;
		}else return 31;
	}
	
	public int solution(int Y, String A, String B, String W) {
        // write your code in Java SE 8
        int num = 0, mA = monthToNumber(A),  mB = monthToNumber(B), w = weekToNumber(W);
        boolean isLeap = Y % 4 == 0 ? true : false;
        int days = 0;
        for(int i = 1 ; i < mA; i++){
        		days += Days(i, isLeap);
        }
        int date = (w + days) % 7;
        //System.out.println(day);
        int totalDays = 0;
        for(int i = mA ; i <= mB ; i++){
        		totalDays += Days(i,isLeap);
        }
        num = (totalDays - (8 - date) % 7) / 7;
        return num;
    }
	
	public int solution(int[] A, int X, int D) {
        // write your code in Java SE 8
		int size = A.length;
		int len = 0, step = 0;
        for(int i = 0 ;i < size; i++){
        		if(A[i] <= D || A[i] + len >= X)
        			len += A[i];
        		if(len >= X)
        			{step = i; break;}
        }
        if(len < X){
        		step = -1;
        }
        return step ;
    }
	
	public String largestNumber(int[] num) {
        String res = "";
        HashMap <Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
        ArrayList <Integer> subArr = null;
        LinkedList < Integer> arr = null;
        int len = num.length, digit = -1;
        Arrays.sort(num);
        for(int i = len - 1; i >= 0; i --){
        		int d_len = String.valueOf(num[i]).length();
        		if(d_len != digit){
        			digit = d_len;
        		}
        		if(!map.containsKey(digit))
        			subArr = new ArrayList<Integer>();
        		else subArr = map.get(digit);
        		subArr.add(num[i]);
        		map.put(digit, subArr);
        }
      
        Iterator iter = map.entrySet().iterator();     
        while (iter.hasNext()) {
        		Map.Entry entry = (Map.Entry) iter.next();
        		subArr = (ArrayList<Integer>) entry.getValue();
        		if(arr == null){
        			arr = new LinkedList <Integer>();
        			for(int i = 0 ; i < subArr.size() ; i++){
        				arr.add(subArr.get(i));
        			}
        		}else{
        			int i = 0, j = 0;
        			while(i < subArr.size()){
	        			String e = subArr.get(i).toString();
	        			boolean isAdd = false;
	        			while(j < arr.size()){	
	        				String e_link = arr.get(j).toString();
		        			int e_link_len = e_link.length(), e_len = e.length(), e_len_max = e_link_len + e_len;
		        			for(int k = 0 ; k < e_len_max ; k++){
							if(e_link.charAt(k % e_link_len) != e.charAt(k % e_len)){
		        					if(e_link.charAt(k % e_link_len) < e.charAt(k % e_len)){
			        					arr.add(j, subArr.get(i));
			        					j ++;
			        					isAdd = true;
		        					}
		        					break;
		        				}
		        			 }
		        			if(!isAdd){
		        				j++;
		        			}else break;
		        			
	        			}
	        			if(!isAdd){
	        				arr.add(j, subArr.get(i));
		        			j++;	
		        		}
	        			i++;
        			}
        		}        		
        	}
        boolean isZero = true;
        for(int i = 0 ; i < arr.size() ; i++){
        		int val = arr.get(i);
        		if(val != 0){
        			isZero = false;
        		}
        		res += arr.get(i);
        }
        	if(isZero) res = "0";
        return res;
    }
	
	public int canCompleteCircuit(int[] gas, int[] cost) {
        int index = -1;
        int len = gas.length;
        //find index
        for(int i = 0 ; i < len ; i++){
        		boolean ccc = true;
        		if(cost [i] <= gas[i]){
        			int g = gas[i] - cost[i];
        			for(int j = i + 1; j < i + len ; j++){
        				int k = j % len;
        				g += (gas[k] - cost[k]);
        				if(g < 0){
        					ccc = false;
        					if(j < len)
        						i = k;
        					break;
        				}
        			}
        		}else ccc = false;
        		if(ccc){
        			index = i;
        			break;
        		}
        }
        return index;
    }
	
	public int titleToNumber(String s) {
        int num = 0, len = s.length();
        for(int i = 0 ; i < len ; i++){
        		num += ((int) s.charAt(i) - 64) * Math.pow(26, (len - i -1) );
        }
        return num;
    }
	
	
	public String convertToTitle(int n) {
        String s = "";
        while(n > 0){
        		int temp = n;
        		int i = 0;
        		while(temp > 26){
        			if(temp % 26 == 0){
        				temp = temp / 26 - 1;
        			}else{
        				temp /= 26;
        			}
        			i++;
        			System.out.println(temp);
        		}
        		n -= (int) Math.pow(26, i) * temp;
        		s += (char) (temp + 64);
        }
        return s;
    }
	
	public String fractionToDecimal(int numerator, int denominator) {
        String res = "";
        if((numerator > 0 && denominator < 0) || (numerator < 0 && denominator > 0)){ 
        		res += "-";
        }
			
        long long_n = numerator, long_d = denominator;
		long n = Math.abs(long_n), d = Math.abs(long_d), mod = n % d, q = n / d;
		if(mod == 0) {
			res += q;
			return res;
		}
		
		HashSet <Long> modSet = new HashSet<Long>();
		LinkedList <String> arr = new LinkedList <String>();
		arr.add(String.valueOf(q));
        while(true){
        		long n_mod = mod;
        		int zero = -1;
        		while(n_mod <= d){
        			n_mod *= 10;
        			zero ++;
        		}
        		//System.out.println(n_mod);
        		mod = n_mod % d;
        		q = n_mod / d;
        		if(!modSet.contains(n_mod)){
        			modSet.add(n_mod);
	        		for(int i = 0 ; i < zero ; i++)
	        			arr.add("0");
        			arr.add(String.valueOf(q));
        			if(mod == 0)
        				break;
        			//System.out.println(q);
        		}else{        				
        			int index = arr.indexOf(String.valueOf(q));
        			if(zero > 0)
        				index -= zero;
        			//System.out.println(index + " ---- "+q);
        			arr.add(index, "(");
        			arr.add(")");
        			break;
        		}
        }
        arr.add(1,".");
        int len = arr.size();
        for(int i = 0 ; i < len ; i++){
        		res += arr.get(i);
        }
        return res;
    }
	
	public int compareVersion(String version1, String version2) {
        String [] v1 = version1.split("\\.");
        String [] v2 = version2.split("\\.");
        int res = 0, i = 0, len_v1 = v1.length, len_v2 = v2.length;
        //System.out.println(v2.length);
        while(i < len_v1 && i < len_v2){
        		int i1 = Integer.parseInt(v1[i]), i2 = Integer.parseInt(v2[i]);
        		if(i1 != i2){
        			if(i1 > i2)
        				res = 1;
        			else res = -1;
        			break;
        		}
        		i++;
        } 
        if(res == 0 && len_v1 != len_v2){
        		boolean isEqual = true, isBig = len_v1 > len_v2 ? true: false;
        		int len = isBig ? len_v1 : len_v2;
        		String v[] = isBig ? v1:v2;
        		res = isBig ? 1: -1;
        		for(int j = i ; j < len; j++){
        			int j1 = Integer.parseInt(v[j]);
        					if(j1 != 0){
                				isEqual = false;
                				break;
                			}
        		}
        		if(isEqual){
        			res = 0;
        		}
        }
        return res;
    }
	
	public int findMin(int[] num) {
        int len = num.length;
        int  min = num[0];
        for(int i = 0 ; i < len ; i++){
        		if(num[i] < min) min = num[i];
        }
        return min;
    }
	
	public int maxProduct(int[] num) {
			int len = num.length;
			if(len < 2) return num[0];
	        int  max = num[0];
	        for(int i = 0 ; i < len - 1; i++){
	        		int p = num[i] * num[i+1];
	        		int temp = num[i] > num[i+1]?num[i]:num[i+1];
	        		max = temp > max ? temp : max;
	        		max = p > max ? p:Integer.MIN_VALUE;
	        }
	        return max;
    }
	
	public int evalRPN(String[] tokens) {
        int []stack = new int[tokens.length];
        int top = -1, len = tokens.length;
        for(int i = 0 ; i < len; i++){
        		if(!tokens[i].equals("+") && !tokens[i].equals("-") && !tokens[i].equals("*") && !tokens[i].equals("/")){
        			Integer num = Integer.parseInt(tokens[i]);
        			stack[++top] = num;
        			//System.out.println(num);
        		}else{
        			int num1 = stack[top-1], num2 = stack[top];
        			if(tokens[i].equals("+")){
        				stack[top-1] = num1 + num2;
        			}else if(tokens[i].equals("-")){
        				stack[top-1] = num1 - num2;
        			}else if(tokens[i].equals("*")){
        				stack[top-1] = num1 * num2;
        			}else if(tokens[i].equals("/")){
        				stack[top-1] = num1 / num2;
        			}
        			top--;
        		}
        }
        return stack[top];
    }
	
	public int uniquePaths(int m, int n) {
		int [][]p = new int[m][n];
		for(int i = 0 ; i < m; i++){
			p[i][0] = 1;
		}
		for(int j = 0 ; j < n; j++){
			p[0][j] = 1;
		}
		for(int i = 1 ; i < m ; i ++){
			for(int j = 1 ; j < n ; j++){
				p[i][j] = p[i-1][j]+p[i][j-1];
			}
		}
		return p[m-1][n-1];
    }
	
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int m = obstacleGrid.length, n = obstacleGrid[0].length;
		int [][]p = new int[m][n];
		if(obstacleGrid[0][0] != 1)
			p[0][0] = 1;
		else p[0][0] = 0;
		for(int i = 1 ; i < m; i++){
			if(obstacleGrid[i][0] == 1)
				p[i][0] = 0;
			else p[i][0] = p[i-1][0];
		}
		for(int j = 1 ; j < n; j++){
			if(obstacleGrid[0][j] == 1)
				p[0][j] = 0;
			else p[0][j] = p[0][j-1];
		}
		for(int i = 1 ; i < m ; i ++){
			for(int j = 1 ; j < n ; j++){
				if(obstacleGrid[i][j] != 1)
					p[i][j] = p[i-1][j]+p[i][j-1];
				else p[i][j] = 0;
			}
		}
		return p[m-1][n-1];
    }
	
	public boolean isPalindrome(String s, int start, int end){
		boolean b = true;
		int i = start, j = end;
		while(i < j){
			if(s.charAt(i) != s.charAt(j)){
				b = false;
				break;
			}else{
				i++;
				j--;
			}
		}
		return b;
	}
	
	public int minCut(String s) {
        int len = s.length();
        	int palindrome[][] = new int[len][len];
        boolean same = false;
        palindrome[len - 1][len - 1] = 1;
        for(int i = 0 ; i < len - 1; i ++){
        		palindrome[i][i] = 1;
        		if(s.charAt(i) == s.charAt(i+1)){
        			same = true;
        		}
        		for(int j = i +1; j < len ; j++){
        			if(same && s.charAt(j) == s.charAt(j-1)){
        				palindrome[i][j] = j - i + 1;
        			}else {
        				same = false;
        				if(i == 0 || j == len - 1 || palindrome[i - 1][j + 1] == 0){
	        				if(isPalindrome(s,i,j))
	        					palindrome[i][j] = j - i + 1;
	        				else {
	        					palindrome[i][j] = 0;
	        				}
        				}else palindrome[i][j] = j - i + 1;
        			}        				
        		}
        }
        
        int min[] = new int[len];
        min[0] = 0;
        for(int i = 1 ; i < len; i++){
			int min_count = 32767;
			for(int j = 0 ; j <= i; j++){
				int num =palindrome[j][i];
				if(num == 1){
					min_count = min_count < min[i - 1] + 1 ? min_count : min[i - 1] + 1;
				}
				else if(num != 0 && num > 1){
					if(i - num < 0)
						min_count = 0;
					else min_count = min_count < min[i - num] + 1? min_count : min[i - num] + 1;
				}
			}
			min[i] = min_count;
		}
        
        return min[len - 1];
    }
		
	public int maxProfit(int[] prices) {
			int len = prices.length;
			if(len == 0) return 0;
			int min1 = prices[0], min2 = prices[len - 1], max = 0,m1,m2;
			int [] max1= new int[len], max2 = new int [len];
			max1[0] = 0;
			max2[len - 1] = 0;
			if(len < 4){
				for(int i = 0 ; i < len ; i++){
					if(prices[i] > min1){
						max = prices[i] - min1 > max ? prices[i] - min1 : max;
					}else{
						min1 = prices[i];
					}
				}
			}else{
				for(int i = 1 ; i < len; i++){
						m1 = max1[i - 1]; 
						m2 = max2[i - 1];
						if(prices[i] > min1){
							if(prices[i] - min1 > max1[i - 1])
								m1 = prices[i] - min1;
						}else{
							min1 = prices[i];
						}		
						max1[i] = m1;
					
						if(prices[len - i] < min2){
							if(min2 - prices[len - i] > max2[i - 1])
								m2 = min2 - prices[len - i];
						}else{
							min2 = prices[len - i];
						}
						max2[i] = m2;
				}
				//max2[len - 1] = 0;
				for(int i = 0 ; i < len - 1; i++){
					max = max > max1[i] + max2[len - i - 1] ? max : max1[i] + max2[len - i - 1];
				}
				max = max > max1[len - 1] ? max : max1[len - 1];
		}
		return max;
    }
	
	public int minimumTotal(List<List<Integer>> triangle) {
        int len = triangle.size();
        for(int i = len - 2 ; i >=0 ; i--){
        		for(int j = 0 ; j < i + 1; j++){
        			int min = Math.min(triangle.get(i + 1).get(j), triangle.get(i + 1).get(j + 1));
        			triangle.get(i).set(j, min + triangle.get(i).get(j));
        		}
        }
        return triangle.get(0).get(0);
    }
	private int getV(String s, int index){
	    int v = 0;
	    for(int i = index; i<index+10; i++){
	        int vv = 0;
	        if(s.charAt(i) == 'A') vv = 0;
	        else if(s.charAt(i) == 'C') vv = 1;
	        else if(s.charAt(i) == 'G') vv = 2;
	        else vv = 3;
	        v <<= 2;
	        v |= vv;
	    }
	    return v;
	}
	public List<String> findRepeatedDnaSequences(String s) {
        int len = s.length();
        List <String> sl = new ArrayList<String>();
        HashSet<Integer> ht = new HashSet<Integer>();
        for(int i = 10 ; i < len ; i++){
        		String sub = s.substring(i - 10, i);
        		if(!ht.contains(sub)){
        		//	ht.add(e)(sub);
        		}else {
        			sl.add(sub);
        		}
        		
        }
        return sl;
    }
	
	public class TreeLinkNode {
		   int val;
		   TreeLinkNode left, right, next;
		   TreeLinkNode(int x) { val = x; }
	}
	
	public class TreeNode {
		   int val;
		   TreeNode left, right;
		   TreeNode(int x) { val = x; }
	}
	
	public void connect(TreeLinkNode root) {
		if(root != null){
			if(root.left != null && root.right != null){
	        		root.left.next = root.right;
	        		TreeLinkNode node = root;
	        		if(node.next != null){
		        		while(node.next != null){
		        			node = node.next;
		        			if(node.left != null)
		        			{
		        				root.right.next = node.left;
		        				break;
		        			}else if(node.right != null){
		        				root.right.next = node.right;
		        				break;
		        			}	
		        		}
	        		}else root.right.next = null;
	        		connect(root.right);
	        		connect(root.left);
	        }  		
	        else if(root.left != null && root.right == null){
	        		TreeLinkNode node = root;
	        		if(node.next != null){
		        		while(node.next != null){
		        			node = node.next;
		        			if(node.left != null)
		        			{
		        				root.left.next = node.left;
		        				break;
		        			}else if(node.right != null){
		        				root.left.next = node.right;
		        				break;
		        			}	
		        		}
	        		}else root.left.next = null;
	        		connect(root.left);
	        }
	        else if(root.left == null && root.right != null){
	        		TreeLinkNode node = root;
		        	if(node.next != null){
		        		while(node.next != null){
		        			node = node.next;
		        			if(node.left != null)
		        			{
		        				root.right.next = node.left;
		        				break;
		        			}else if(node.right != null){
		        				root.right.next = node.right;
		        				break;
		        			}
		        			
		        		}
		    		}else root.right.next = null;
		        	connect(root.right);
	        }
		}
        
    }
	
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> lo = new ArrayList();
		lo = levelOrderHelper(root, lo, 0);
		return lo;
    }
	
	public List<List<Integer>> levelOrderHelper(TreeNode root, List<List<Integer>> lo, int height){
		if(root != null){
			if(lo.size() <= height){
				List<Integer> l = new ArrayList<Integer>();
				l.add(root.val);
				lo.add(l);
			} else{
				List<Integer> l = lo.get(height);
				l.add(root.val);
			}
			lo = levelOrderHelper(root.left, lo, height + 1);
			lo = levelOrderHelper(root.right, lo, height + 1);
		}
		
		return lo;
	}
	
	   public boolean exist(char[][] board, String word) {
			int h = board.length, w = board[0].length;
	        if(word == null || word.length() <= 0) return false;
	        char f = word.charAt(0);
	        for(int i = 0 ; i < h ; i++){
	        		for(int j = 0 ; j < w ; j++){
	        			if(board[i][j] == f && getWord(board, i, j, word))
	        				return true;
	        		}
	        }
	        return false;
	    }
		
		public boolean getWord(char[][] board, int m ,int n, String word){
	        int h = board.length, w = board[0].length, len = word.length(), top = 0;
	        boolean b = false;
	        boolean passed[][] = new boolean[h][w];
	        Point p[] = new Point[len];
	        p[top] = new Point(m,n);
	        passed[m][n] = true;
	        while(top > -1){
	        		if(top == len - 1){
	        			b = true; 
	        			break;
	        		}
	        		char c = word.charAt(top + 1);
	        		if(n - 1 >= 0 && board[m][n - 1] == c && !passed[m][n - 1] && p[top].dir[0] == false){
	        			p[top].dir[0] = true;
	        			p[++top] = new Point(m, --n);
	        			p[top].last_step = 0;
	        			passed[m][n] = true;
	        		}else if(m + 1 < h && board[m + 1][n] == c && !passed[m + 1][n] && p[top].dir[1] == false){
	        			p[top].dir[1] = true;
	        			p[++top] = new Point(++m, n);
	        			p[top].last_step = 1;
	        			passed[m][n] = true;
	        		}else if(n + 1 < w && board[m][n + 1] == c && !passed[m][n + 1] && p[top].dir[2] == false){
	        			p[top].dir[2] = true;
	        			p[++top] = new Point(m, ++n);
	        			p[top].last_step = 2;
	        			passed[m][n] = true;
	        		}else if(m - 1 >= 0 && board[m - 1][n] == c && !passed[m - 1][n] && p[top].dir[3] == false){
	        			p[top].dir[3] = true;
	        			p[++top] = new Point(--m, n);
	        			p[top].last_step = 3;
	        			passed[m][n] = true;
	        		}else {
	        			passed[m][n] = false;
	        			switch (p[top].last_step){
	        				case 0: p[top] = null; n++; break;
	        				case 1: p[top] = null; m--; break;
	        				case 2: p[top] = null; n--; break;
	        				case 3: p[top] = null; m++; break;
	        				case -1: break;
	        			}
	        			top--;
	        		}
	        }
	        	return b;
		}
		public class Point {
			public int px;
			public int py;
			public int last_step = -1;
			public boolean [] dir = {false,false,false,false};
			public Point(int x, int y){
				px = x;
				py = y;
			}
		}
	
		public class WindowCount{
			public int start = 0;
			public int end = 0;
			public int size = 0;
			public int count[];
			public WindowCount(int size){
				count = new int[size];
			}
		}
		
		public String minWindow(String S, String T) {
	        int len = S.length(), c_num = T.length(), min = Integer.MAX_VALUE;
	        WindowCount wc = new WindowCount(128);
	        Deque<Integer> start = new ArrayDeque<Integer>();
	        HashMap<Character, Integer> hm_t = new HashMap<Character, Integer>();
	        for(int i = 0 ; i < c_num; i++){
	        		char c = T.charAt(i);
	        		if(!hm_t.containsKey(c))
	        			hm_t.put(c, 1);
	        		else hm_t.put(c, hm_t.get(c) + 1);
	        }
	        	
	        for(int i = 0 ; i < len ; i++){
	        		char c = S.charAt(i);
	        		if(hm_t.containsKey(c)){
	        			start.add(i);
	        			wc.count[c] ++;
	        			wc.size ++;
		        		while(wc.size >= c_num){
		        			Iterator it = hm_t.entrySet().iterator();     
		        			boolean is_full = true;
		        	        while (it.hasNext()) {
		        	        		Map.Entry <Character, Integer>entry = (Map.Entry) it.next();
		        	        		char key = entry.getKey();
		        	        		int val = entry.getValue();
		        	        		if(wc.count[key] < val){
		        	        			is_full = false;
		        	        			break;
		        	        		}
		        	        }
		        	        if(is_full){
		        	        		int start_index = start.poll();
		        	        		if(min > i - start_index){
		        	        			min = i - start_index;
		        	        			wc.start = start_index;
		        	        			wc.end = i + 1 ;
		        	        		}
		        	        		wc.count[S.charAt(start_index)] --;
		        	        		wc.size--;
		        	        }else break;
		        		}
	        		}
	        }
	        return S.substring(wc.start, wc.end);
	    }
		
		public int maxProfit(int k, int[] prices) {
	        int len = prices.length, sum = 0;
	        List <Integer> arr = new LinkedList <Integer>();
	        k = k > len / 2 ? len / 2: k;
	        if(len == 0 || k == 0) return sum;
	        int min = prices[0];
	        for(int i = 1 ; i < len ; i++){
	        		if(prices[i] < prices[i - 1]){
	        			if(min < prices[i - 1]){
	        				arr.add(min);
	        				arr.add(prices[i - 1]);
	        				sum += prices[i - 1] - min;
	        			}
	        			min = prices[i];
	        		}
	        }
	        if(prices[len - 1] != min){
	        		arr.add(min);
	        		arr.add(prices[len - 1]);
	        		sum += prices[len - 1] - min;
	        }
	        
	        int trans = arr.size() / 2 - k;
		    while(trans > 0){
		    		ListIterator<Integer> iter = arr.listIterator();
		    		int last = iter.next(), min_gap = 32767, index = -1;
		    		while(iter.hasNext()){
		    			int val = iter.next();
		    			if(min_gap > Math.abs(val - last)){
		    				min_gap = Math.abs(val - last);
		    				index = iter.previousIndex();
		    			}
		    			last = val;
		    		}
		    		arr.remove(index);
		    		arr.remove(index - 1);
		    		sum -= min_gap;
		    		trans--;
		    }
	        
	        return sum;
	    }
		
		
		public int minDistance(String word1, String word2) {
			
		    if (word1.equals(word2)) {
		        return 0;
		    }
		    if (word1.length() == 0 || word2.length() == 0) {
		        return Math.abs(word1.length() - word2.length());
		    }
		    int[][] dp = new int[word1.length() + 1][word2.length() + 1];
		    for (int i = 0; i <= word1.length(); i++) {
		        dp[i][0] = i;
		    }
		    for (int i = 0; i <= word2.length(); i++) {
		        dp[0][i] = i;
		    }
		    for (int i = 1; i <= word1.length(); i++) {
		        for (int j = 1; j <= word2.length(); j++) {
		            if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
		                dp[i][j] = dp[i - 1][j - 1];
		            } else {
		                dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1])) + 1;
		            }
		        }
		    }
		    return dp[word1.length()][word2.length()];
		}
		
		
			
		
		static class ThreadTest implements Runnable{
			public volatile int count = 0;
			@Override
			public void run(){
				System.out.println(count);
			}
			
			public ThreadTest(int val){
				System.out.println(count);
				this.count = val;
			}
		}
		
		public int candy(int[] ratings) {
	        int len = ratings.length;
	        if(len == 0) return 0;
	        int sum = 1, val = 1, start_index = 0;
	        
	        for(int i = 1; i < len ; i++){
	        		if(ratings[i] > ratings[i - 1]){
	        			val ++;
	        			start_index = i;
	        		}else if(ratings[i] <= ratings[i - 1]){
	        			val --;
	        			sum += i - start_index;
	        		}
	        		sum += val;
	        }
	        
	        return sum;
	    }
				
		public boolean isOneLadderDifference(String s1, String s2){
			int len = s1.length(), count = 0;
			for(int i = 0 ; i < len ; i++){
				if(s1.charAt(i) != s2.charAt(i)){
					count ++;
					if(count > 1)
						break;
				}
			}
			return count == 1? true : false;
		}
		
		public int ladderLength(String start, String end, Set<String> dict) {
	        int size = dict.size();
	        if(size == 0) return 0;
	        dict.add(end);
	        HashMap <String, Integer>hm = new HashMap<String, Integer>();
	        hm.put(start, 0);
	        for(Iterator<String> i = dict.iterator(); i.hasNext();)
	    			hm.put(i.next(), 0);
	        Deque <String>deq = new ArrayDeque<String>();
	        deq.add(start);
	        while(!deq.isEmpty()){
	        		String s = deq.poll();
	        		Iterator i = hm.entrySet().iterator();
	        		for(; i.hasNext();){
	        			Entry e = (Entry) i.next();
	        			String k = (String) e.getKey();
	        			Integer v = (Integer) e.getValue();
	        			if(v == 0 && isOneLadderDifference(k, s)){
	        				deq.add(k);
	        				int val = hm.get(s);
	        				hm.put(k, val + 1);
	        				if(k.equals(end))
	        					return hm.get(k) + 1;
	        			}
	        			//hm.remove(k);
	        		}
	        }
	        return 0;
	    }
		
		
		public int calculateMinimumHP(int[][] dungeon) {
	       int h = dungeon.length, w = dungeon[0].length ,hp[][] = new int[h + 1][w + 1];
	       for(int i = 0 ; i < h ; i++){
	    	   	hp[i][w] = 32767;
	       }
	       for(int i = 0 ; i < w ; i++){
	    	   	hp[h][i] = 32767;
	       }
	       
	       for(int i = h - 1; i >= 0; i-- ){
	    	   	for(int j = w - 1 ; j >= 0 ; j--){
	    	   		if(i == h - 1 && j == w - 1)
	    	   			hp[i][j] = dungeon[i][j] >= 0 ? 0 : -dungeon[i][j];
	    	   		else{
		    	   		hp[i][j] = Math.min(hp[i + 1][j], hp[i][j + 1]) - dungeon[i][j];
		    	   		if(hp[i][j] < 0){
		    	   			hp[i][j] = 0;
		    	   		}
	    	   		} 
	    	   			
	    	   	}
	       }
	       return hp[0][0] + 1;
	    }
		
		
		public void rotate(int[] nums, int k) {
	        int len = nums.length;
	        k %= len;
	        	int []n = new int[k];
	        	for(int i = 0 ; i < n.length; i++){
	   			n[i] = nums[len - k + i];
	        	}
	        	for(int i = len - 1 ; i >= k; i--){
	        		nums[i] = nums[i - k];
	        	}
	        	for(int i = 0 ; i < n.length; i++){
	        		nums[i] = n[i];
	        	}
	        
	    }
		
		public boolean isPalindrome(int x) {
			if(x < 0) return false;
			List cl = new ArrayList();
			boolean b = true;
	        while(x != 0){
	        		char c = (char) (x % 10 + 48);
	        		x /= 10;
	        		cl.add(c);
	        }
	        int i = 0, j = cl.size() - 1;
	        while(i < j){
	        		if(cl.get(i) != cl.get(j)){
	        			b = false;
	        			break;
	        		}
	        		i ++;
	        		j --;
	        }
	        return b;
	    }
		
		
		public String convertToString(int a[]){
			StringBuffer sb = new StringBuffer();
			for(int i = 0 ; i < a.length; i++){
				sb.append(a[i]);
			}
			return sb.toString();
		}
		
		
		public boolean characterCheck(String s, char c){
			int len = s.length();
			for(int i = 0 ; i < len ; i++){
				if(s.charAt(i) == c)
					return true;
			}
	    		return false;
	    }
		
		public List<String> wordBreakII(String s, Set<String> dict) {
	        int len = s.length(), max_d = -32767, min_d = 32767;
	        HashMap<Integer, ArrayList<String>> hm = new HashMap<Integer, ArrayList<String>>();
	        HashMap<String , Boolean> d = new HashMap<String, Boolean>();
	        HashMap<Character, Boolean> check = new HashMap<Character, Boolean>();
	        for(int i = 0 ; i < len ; i ++){
	        		hm.put(i, new ArrayList<String>());
	        		if(!check.containsKey(s.charAt(i)))
	        			check.put(s.charAt(i), false);
	        }
	        for(Iterator<String> i = dict.iterator(); i.hasNext();){
	        		String d_s = i.next();
	        		d.put(d_s, true);
	        		max_d = max_d > d_s.length() ? max_d : d_s.length(); 
	        		min_d = min_d < d_s.length() ? min_d : d_s.length();
	        		for(Iterator j = check.entrySet().iterator(); j.hasNext();){
		        		Entry<Character, Boolean> e = (Entry) j.next();
		        		char c = e.getKey();
		        		if(characterCheck(d_s, c)){
		        			check.put(c, true);
		        		}
		        }
	        }
	        
	        //检查s中是否有dict中没有字符 有直接返回null
	        for(Iterator i = check.values().iterator(); i.hasNext();){
	        		boolean b = (Boolean) i.next();
	        		if(!b) return new ArrayList();
	        }
		        
	        for(int i = 0; i < len; i++){
	        		for(int j = i - min_d; j >= i - max_d && j >= -1; j --){
	        			String sub = s.substring(j + 1, i + 1);
	        			if(d.containsKey(sub)){
	        				if(j == -1){
	        					ArrayList<String> arr_i = hm.get(i);	  
	        					arr_i.add(sub);
	        					hm.put(i, arr_i);
	        				}else{
	        					if(hm.get(j) != null){
	        						ArrayList <String>arr_i = hm.get(i), arr = hm.get(j);
	        						for(int k = 0; k < arr.size(); k++){
	        							arr_i.add(arr.get(k) + " " + sub);
	        						}
	        						hm.put(i, arr_i);
	        					}
	        				}
	        			}
	        		}
	        }
	        return hm.get(len - 1);
	    }
		
		public boolean wordBreak(String s, Set<String> dict) {
			int len = s.length(), index = 0;
	        HashMap<String , Boolean> d = new HashMap<String, Boolean>();
	        HashMap<Character, Boolean> check = new HashMap<Character, Boolean>();
	        HashMap<Integer, HashSet<String>> passed  = new HashMap<Integer, HashSet<String>>();
	        Stack<String> st = new Stack<String>();
	        for(int i = 0 ; i < len ; i ++){
	        		if(!check.containsKey(s.charAt(i)))
	        			check.put(s.charAt(i), false);
	        }
	        for(Iterator<String> i = dict.iterator(); i.hasNext();){
	        		String d_s = i.next();
	        		d.put(d_s, false);
	        		for(Iterator j = check.entrySet().iterator(); j.hasNext();){
		        		Entry<Character, Boolean> e = (Entry) j.next();
		        		char c = e.getKey();
		        		if(characterCheck(d_s, c)){
		        			check.put(c, true);
		        		}
		        }
	        }	        
	        for(Iterator i = check.values().iterator(); i.hasNext();){
	        		boolean b = (Boolean) i.next();
	        		if(!b) return false;
	        }
	        
	        while(true){
	        		boolean match = false;
		        	for(Iterator i = d.keySet().iterator(); i.hasNext();){
		        		String d_s = (String) i.next();
		        		if(index + d_s.length() <= len){
			        		String sub = s.substring(index, index + d_s.length());
			        		HashSet hs = null;
			        		if(passed.get(index) != null)
			        			hs = passed.get(index);
			        		if(d_s.equals(sub) && (hs == null || !hs.contains(sub))){
			        			index += d_s.length();
			        			st.add(d_s);
			        			match = true;
			        			if(index == len)
			        				return true;
			        		}
		        		}
		        		
		        }
		        	if(!match){
		        		if(st.isEmpty())
		        			break;
		        		else{
			        		String last_pop = st.pop();
			        		index -= last_pop.length();
			        		HashSet hs = null;
			        		if(passed.get(index) == null){
			        			hs = new HashSet<String>();
			        		}else hs = passed.get(index);
			        		hs.add(last_pop);
			        		passed.put(index, hs);
		        		}
		        		
		        	}
	        }
	        
	        return false;
	    }
		
		public boolean hasCycle(ListNode head) {
			int count = 0;
	        while(head != null){
	        		count ^= head.val;
	        		if(count == 0)
	        			return true;
	        		head = head.next;
	        }
	        return false;
	    }
		public boolean hasCycle(int a[]) {
			int count = 0, len = a.length;
	        for(int i = 0 ; i < len ; i++){
	        		count ^= a[i];
	        		System.out.println(count);
	        }
	        return false;
	    }
		
		public void heapSortBuilder(List<Integer> arr){
			int size = arr.size();
			for(int i = size / 2; i >= 1; i--){
				int temp;
				if(arr.get(i * 2 - 1) < arr.get(i - 1)){
					temp = (Integer) arr.get(i - 1);
					arr.set(i - 1, arr.get(i * 2 - 1));
					arr.set(i * 2 - 1, temp);
				}
				if(i * 2 < size && arr.get(i * 2) < arr.get(i - 1)){
					temp = (Integer) arr.get(i - 1);
					arr.set(i - 1, arr.get(i * 2));
					arr.set(i * 2, temp);
				}
			}
		}
		
		public List heapSort(List<Integer> arr){
			List res = new ArrayList<Integer>();
			heapSortBuilder(arr);
			while(!arr.isEmpty()){
				res.add(arr.remove(0));
				heapSortBuilder(arr);
			}
			return res;
		}
		
		public boolean binarySearch(int a[], int key){
			int i = 0, j = a.length - 1;
			while(i <= j){
				int mid = (i + j) / 2;
				if(a[mid] > key){
					j = mid - 1;
				}else if(a[mid] < key){
					i = mid + 1;
				}
				else return true;
			}
			return false;
		}
		
		public int reverseBits(int n) {
			int m = 0;
	        for(int i = 0;i < 32;i++)
	            if((n & (0x00000001 << i)) != 0) m |= (0x80000000 >>> i);
	        return m;
	    }
		
		public int hammingWeight(int n) {
	        int count = 0;
	        for(int i = 0 ; i < 32; i++){
	        		if((n & 0x00000001) == 1){
	        			count++;
	        		}
	        		n >>>= 1;
	        }
	        return count;
	    }
		
		public class NumCount{
			public int left_index = -1, right_index = -1;
			public NumCount(int l, int r){
				left_index = l;
				right_index = r;
			}
		}
		
		public int longestConsecutive(int[] num) {
	        int len = num.length, count = 1;
	        HashMap<Integer, NumCount> hm = new HashMap<Integer, NumCount>();
	        for(int i = 0 ; i < len; i++){
	        		int prev = num[i] - 1, next = num[i] + 1;
	        		if(!hm.containsKey(num[i])){
		        		if(hm.containsKey(prev) && !hm.containsKey(next)){
		        			NumCount nc_prev = hm.get(prev),
		        									nc = new NumCount(nc_prev.left_index, num[i]);
		        			hm.put(num[i], nc);
		        			hm.put(nc_prev.left_index, new NumCount(nc_prev.left_index, num[i]));
		        			count = num[i] - nc_prev.left_index + 1 > count ? num[i] - nc_prev.left_index + 1 : count;
		        		}else if(!hm.containsKey(prev) && hm.containsKey(next)){
		        			NumCount nc_next = hm.get(next),
									nc = new NumCount(num[i], nc_next.right_index);
		        			hm.put(num[i], nc);
		        			hm.put(nc_next.right_index, new NumCount(num[i], nc_next.right_index));
		        			count = nc_next.right_index - num[i] + 1 > count ? nc_next.right_index - num[i] + 1 : count;
		        		}else if(hm.containsKey(prev) && hm.containsKey(next)){
		        			NumCount nc_next = hm.get(next), nc_prev = hm.get(prev),
									nc = new NumCount(nc_prev.left_index, nc_next.right_index);
		        			hm.put(num[i], nc);
		        			hm.put(nc_next.right_index, new NumCount(nc_prev.left_index, nc_next.right_index));
		        			hm.put(nc_prev.left_index, new NumCount(nc_prev.left_index, nc_next.right_index));
		        			count = nc_next.right_index - nc_prev.left_index + 1 > count ? nc_next.right_index - nc_prev.left_index + 1 : count;
		        		}else{
		        			hm.put(num[i], new NumCount(num[i], num[i]));
		        		}
	        		}
	        		
	        }
	        return count;
	    }
		
		public int singleNumber(int[] A) {
	        /*
	        element in A is 32bit,
	        sum corresponding bits from all elements and mod each by 3 then should left the single number
	        */
	        int[] sum=new int[32];
	        int res=0;
	        for(int i=0;i<32;i++)
	        {
	            for(int j=0;j<A.length;j++)
	            {
	                sum[i]+=((A[j]>>>i)&1);//sum every bit of all numbers
	            }
	            sum[i]%=3;
	            res+=((sum[i]&1)<<i);// recover the single number
	        }
	        return res;
	    }
		
		public void mergeSort(int a[], int start, int end){
			if(start < end - 1){
				mergeSort(a, start, (start + end) / 2);
				mergeSort(a, (start + end) / 2 + 1, end);
				int i = start, j = (start + end) / 2 + 1, index = 0;
				int b[] = new int[end - start + 1];
				while(index < end - start + 1){
					if(i <= (start + end) / 2 && j <= end){
						if(a[i] < a[j]){
							b[index++] = a[i++];
						}else{
							b[index++] = a[j++];
						}
					}else{
						if(i > (start + end) / 2)
							b[index++] = a[j++];
						else b[index++] = a[i++];
					}
				}
				for(int k = start; k <= end ; k++){
					a[k] = b[k - start];
				}
			}else{
				if(a[start] > a[end]){
					int temp = a[start];
					a[start] = a[end];
					a[end] = temp;
				}
				
			}
		}
		
		public void quickSort(int a[], int start, int end){
			if(start < end){
				int i = start, j = end - 1, key = a[end];
				while(i <= j){
					if(a[i] > key){
						int temp = a[i];
						a[i] = a[j];
						a[j] = temp;
						j--;
					}else{
						i++;
					}
				}
				a[end] = a[i];
				a[i] = key;			
				quickSort(a, start, i - 1);
				quickSort(a, i + 1, end);
			}
			
		}
		
		public int jump(int[] A) {
	        int len = A.length, min_index = -1;
	        int steps[] = new int[len];
	        for(int i = len - 2; i >= 0 ; i --){
	        		if(i + A[i] >= len - 1){
	        			steps[i] = 1;
	        			min_index = i;
	        			continue;
	        		}
	        		if(i + A[i] >= min_index){
	        			steps[i] = steps[min_index] + 1;
	        			continue;
	        		}
	        		
	        		int step_min = 32767;
	        		for(int j = A[i] ; j >= 1; j --){
		        		step_min = Math.min(step_min, steps[i + j] + 1);
		        		
	        		}
	        		steps[i] = step_min;
	        }
	        return steps[0];
	    }
		
		public int majorityElement(int[] num) {
	        int elem = num[0], count = 0;
	        for(int i = 1 ; i < num.length ; i++){
	        		if(num[i] == elem){
	        			count ++;
	        		}else{
	        			count--;
	        			if(count < 0){
	        				count = 0;
	        				elem = num[i];
	        			}
	        		}
	        }
	        return elem;
	    }
		
		
		public void reorderList(ListNode head) {
	        if(head != null){
	        		int len = 1;
	        		ListNode l1 = head, l2 = head;
	        		while(head.next != null){
	        			len ++;
	        			head = head.next;
	        		}
	        		for(int i = 0 ; i < len / 2 ; i++){
	        			l2 = l2.next;
	        		}
	        		//reverse l2
	        		ListNode pre = null, pNext;
	        		while(l2 != null){
	        			pNext = l2.next;
	        			l2.next = pre;
	                 pre = l2;
	                 l2 = pNext;
	        		}
	        		l2 = pre;
	        		//merge
	        		ListNode l1Next = null, l2Next = null;
	        		head = l1;
	        		while(l2 != null){
	        			l1Next = l1.next;
	        			l2Next = l2.next;
	        			l1.next = l2;
	        			l2.next = l1Next;
	        			l1 = l1Next;
	        			l2 = l2Next;
	        		}
	        		if(l1 != null)
	        			l1.next = null;
	        		while(head != null){
	        			System.out.print(head.val + " ");
	        			head = head.next;
	        		}
	        }
	    }
		
		public void reverseList(ListNode head) {
	        if(head != null){
	        		//reverse l2
	        		ListNode pre = null, pNext;
	        		while(head != null){
	        			pNext = head.next;
	                 head.next = pre;
	                 pre = head;
	                 head = pNext;
	        		}
	        }
	    }
		
//		def findMedianSortedArrays(self, A, B):
//		    l = len(A) + len(B)
//		    if l % 2 == 1:
//		        return self.kth(A, B, l // 2)
//		    else:
//		        return (self.kth(A, B, l // 2) + self.kth(A, B, l // 2 - 1)) / 2.   
//
//		def kth(self, a, b, k):
//		    if not a:
//		        return b[k]
//		    if not b:
//		        return a[k]
//		    ia, ib = len(a) // 2 , len(b) // 2
//		    ma, mb = a[ia], b[ib]
//
//		    # when k is bigger than the sum of a and b's median indices 
//		    if ia + ib < k:
//		        # if a's median is bigger than b's, b's first half doesn't include k
//		        if ma > mb:
//		            return self.kth(a, b[ib + 1:], k - ib - 1)
//		        else:
//		            return self.kth(a[ia + 1:], b, k - ia - 1)
//		    # when k is smaller than the sum of a and b's indices
//		    else:
//		        # if a's median is bigger than b's, a's second half doesn't include k
//		        if ma > mb:
//		            return self.kth(a[:ia], b, k)
//		        else:
//		            return self.kth(a, b[:ib], k)
		
		public int rob(int[] num) {
			if(num.length == 0) return 0;
	        int len = num.length, count[] = new int[len];
	        count[0] = num[0];
	        for(int i = 1 ; i < len ; i++){
	        		if(i - 2 >= 0){
	        			count[i] = Math.max(count[i - 2] + num[i], count[i - 1]);
	        		}else count[i] = Math.max(num[0], num[1]);
	        }
	        return count[len - 1];
	    }
		
		public void swap(int a[], int index1, int index2){
			int temp = a[index1];
			a[index1] = a[index2];
			a[index2] = temp;
		}

		public void rangeAll(int a[], int index) {
				if(index == a.length)
					return;
				else
				for(int i = index; i < a.length; i++){
					swap(a, index, i);
					rangeAll(a, index + 1);
					swap(a, index, i);
				}
	    }
		
		public void getPermutationHelper(List <Integer>arr, int k,int []stack,int top) {
			if(count < k){
				if(arr.isEmpty()){
					count++;
					if(count == k){
						StringBuffer sb = new StringBuffer();
						for(int i: stack)
							sb.append(i);
						res = sb.toString();
			        		count++;
					}
				}
				else
				for(int i = 0; i < arr.size(); i++){
					if(count > k)
						break;
					int e = arr.remove(i);
					stack[++top] = e;
					getPermutationHelper(arr, k,stack,top);
					if(count > k)
						break;
					arr.add(i, e);
					top--;
				}
			}
			
	    }
		private int count = 0;
		private String res = "";
		public String getPermutation(int n, int k) {
			if(n <= 0 || k < 0) return "";
			List <Integer>arr = new LinkedList<Integer>();
			int stack[] = new int[n];
			for(int i = 1 ; i <= n ; i++){
				arr.add(i);
			}
			getPermutationHelper(arr, k,stack , -1);
	        	return res;
	    }
		
		public String solution (int n,int k){
			List<Integer> num = new LinkedList<Integer>();
	        for (int i = 1; i <= n; i++) num.add(i);
	        int[] fact = new int[n];  // factorial
	        fact[0] = 1;
	        for (int i = 1; i < n; i++) 
	        		fact[i] = i*fact[i-1];
	        k = k-1;
	        StringBuilder sb = new StringBuilder();
	        for (int i = n; i > 0; i--){
	            int ind = k/fact[i-1];
	            k = k%fact[i-1];
	            sb.append(num.get(ind));
	            num.remove(ind);
	        }
	        return sb.toString();
		}
		
		public int minPathSum(int[][] grid) {
	        int h = grid.length, w = grid[0].length;
	        if(h == 0 || w == 0) return 0;
	        for(int i = 0 ; i < h ; i ++){
	        		for(int j = 0 ; j < w ; j++){
	        			if(i == 0 && j == 0)
	        				continue;
	        			int top = i > 0 ? grid[i - 1][j] : 32767,
	        				left = j > 0 ? grid[i][j - 1] : 32767;
	        			grid[i][j] = Math.min(top, left) + grid[i][j];
	        		}
	        }
	        return grid[h - 1][w - 1];
	    }
		
		
		public List<Integer> rightSideView(TreeNode root) {
			if(root == null) return new LinkedList<Integer>();
	        List<Integer> arr = new LinkedList<Integer>();
	        Deque<TreeNode> deq = new ArrayDeque<TreeNode>();
	        Deque<Integer> level = new ArrayDeque<Integer>();
	        TreeNode node = null;
	        deq.add(root);
	        level.add(0);
	        arr.add(root.val);
	        int last_level = 0;
	        while(!deq.isEmpty()){
	        		int lev = level.poll();
	        		if(lev != last_level){
	        			arr.add(node.val);
	        		}
	        		node = deq.poll();
	        		if(node.left != null){
	        			deq.add(node.left);
	        			level.add(lev + 1);
	        		}	
	        		if(node.right != null){
	        			deq.add(node.right);
	        			level.add(lev + 1);
	        		}
	        		last_level = lev;
	        }
	        return arr;
	    }
		
		public ListNode getMiddleNode(ListNode head) {
			if(null == head || null == head.next || null == head.next.next)
			    return head;

			ListNode mid = head;
			ListNode last = mid.next;
			while(null != last && null != last.next){
			    mid = mid.next;
			    last = last.next.next;
			}
			return mid;   
	    }
		
		public ListNode removeNthFromEnd (ListNode head, int k) {
	        if((head == null) || (head.next == null && k == 1)) return null;
	        ListNode p1 = new ListNode(-1), p2 = head, n;
	        p1.next = head;
	        int i = 0;
	        while(i < k){
	        		p2 = p2.next;
	        		i++;
	        }
	        while(p2 != null){
        			p2 = p2.next;
        			p1 = p1.next;
	        }
	        n = p1.next;
	        p1.next = n.next;
	        return (head != n) ? head : p1.next;
	    }
		
		public void moveBack(int a[], int index){
			for(int i = a.length - 1; i > index ; i --)
				a[i] = a[i - 1];
		}
		
		public void merge(int A[], int m, int B[], int n) {
			int i = 0, j = 0, m_count = 0;
	        while(j < n && m_count < m){
	        		if(A[i] <= B[j]){
	        			i++;    
	        			m_count++;
	        			continue;
	        		}
	        		moveBack(A, i);
	        		A[i] = B[j];
	        		j++;
	        		i++;
	        }
	        while(j < n)
	        		A[i++] = B[j++];
	    }
		
		public int numIslands(char[][] grid) {
			if(grid.length == 0) return 0;
	        int h = grid.length, w = grid[0].length, count = 0;
	        boolean [][]has_passed = new boolean[h][w];
	        for(int i = 0; i < h; i++)
	        		for(int j = 0; j < w; j++){
	        			if(grid[i][j] == '1' && has_passed[i][j] == false){
	        				findIsland(grid, has_passed, i, j);
	        				count ++;
	        			}
	        		}
	        return count;
	    }
		
		public void findIsland(char[][] grid, boolean [][]has_passed, int i, int j){
			if(grid[i][j] == '1' && has_passed[i][j] == false){
				has_passed[i][j] = true;
				if(i + 1 < grid.length && grid[i + 1][j] == '1')
					findIsland(grid, has_passed, i + 1, j);
				if(j + 1 < grid[0].length && grid[i][j + 1] == '1')
					findIsland(grid, has_passed, i, j + 1);
				if(i - 1 >= 0 && grid[i - 1][j] == '1')
					findIsland(grid, has_passed, i - 1, j);
				if(j - 1 >= 0 && grid[i][j - 1] == '1')
					findIsland(grid, has_passed, i, j - 1);
			}
		}
		
		//method 1: del one for each elem(except zero) after a traversal. TLE
		/*public int trap(int[] A) {
	        if(A.length < 3) return 0;
	        int sum = 0;
	        while(true){
		        boolean flag = false;
		        	for(int i = 1 ; i < A.length - 1 ; i++){
		        		if(A[i - 1] > A[i]){
			        		if(A[i + 1] > A[i]){
			        			sum ++;
			        			flag = true;
			        		}
			        		else 	if(A[i + 1] == A[i]){
			        			int count = 0;
			        			while(i < A.length - 1 && A[i + 1] == A[i]){
			        				i++;
			        				count ++;
			        			}
			        			if(i != A.length - 1 && A[i + 1] > A[i]){
			        				sum += count;
			        				flag = true;
			        			}
			        		}
		        		}
		        }
		        	if(!flag) break;
		        	for(int i = 0 ; i < A.length; i++)
		        		if(A[i] > 0)
		        			A[i]--;
	        }
	        return sum;
	    }*/
		
		public ListNode insertionSortList(ListNode head) {
			if(head == null || head.next == null) return head;
			ListNode pt, pNext,temp, p = head, h = new ListNode(Integer.MIN_VALUE);
			h.next = head;
			while(p.next != null){
				pt = h;
				pNext = p.next;
				while(pt.next.val <= pNext.val && pt.next != pNext)
					pt = pt.next;
				if(pt.next.val > pNext.val){
					temp = pt.next;
					p.next = pNext.next;
					pt.next = pNext;
					pNext.next = temp;
				}
				p = pNext;
			}
			head = h.next;
			h = null;
			return head;
	    }
		
		public List<Integer> preorderTraversal(TreeNode root) {
	        List <Integer>arr = new ArrayList<Integer>();
	        if(root == null || root.val == '#') return arr;
	        Stack <TreeNode> stack = new Stack<TreeNode>();
	        HashSet <TreeNode>hs = new HashSet<TreeNode>();
	        stack.push(root);
	        while(!stack.isEmpty()){
	        		TreeNode node = stack.peek();
	        		if(!hs.contains(node)){
		        		hs.add(node);
		        		arr.add(node.val);
	        		}
	        		
	        		if(node.left != null && !hs.contains(node.left)){
	        			stack.push(node.left);
	        			continue;
	        		}	
	        		if(node.right != null && !hs.contains(node.right)){
	        			stack.push(node.right);
	        			continue;
	        		}
	        		stack.pop();
	        }
	        return arr;
	    }
		
		public String reverseWords(String s) {
	        if(s == null) return null;
	        if(s.trim().equals("")) return "";
	        String [] s1 = s.split(" ");
	        StringBuilder sb = new StringBuilder();
	        for(int i = s1.length - 1; i >= 0; i--){
	        		if(s1[i].trim().equals("")) continue;
	        		sb.append(s1[i] + " ");
	        }
	        return sb.toString();
	    }
		
		class RandomListNode {
		     int label;
		     RandomListNode next, random;
		     RandomListNode(int x) { this.label = x; }
		 };
		 
		private HashMap<RandomListNode,RandomListNode> randomMap = new HashMap<RandomListNode,RandomListNode>();
		public RandomListNode copyRandomList(RandomListNode head) {
	        if(head == null) return null;
	        RandomListNode node = null;
	        copyRandomListHelper(node, head);
	        return node;
	    }
		
		public void copyRandomListHelper(RandomListNode head, RandomListNode original) {
	        head = new RandomListNode(original.label);
	        if(original.next != null){
	        		copyRandomListHelper(head.next, original.next); 
	        }
	        if(original.random != null){
	        		//randomMap.get()
	        		copyRandomListHelper(head.random, original.random); 
	        }
	    }
		
		public int binarySearch2(int a[], int key){
			int i = 0, j = a.length - 1, mid = 0;
			while(i <= j){
				mid = (i + j) / 2;
				if(a[mid] > key){
					j = mid - 1;
				}else if(a[mid] < key){
					i = mid + 1;
				}else break;
			}
			return mid;
		}
		
		public int threeSumClosest(int[] num, int target) {
			int result = 32767;
	        Arrays.sort(num);
	        for (int i = 0; i < num.length - 2; i++) {
	            int start = i + 1, end = num.length - 1;
	            while (start < end) {
	                int sum = num[i] + num[start] + num[end];
	                if (sum > target) {
	                    end--;
	                } else {
	                    start++;
	                }
	                if (Math.abs(sum - target) < Math.abs(result - target)) {
	                    result = sum;
	                }
	            }
	        }
	        return result;
	    }
		
		public List<List<Integer>> levelOrderBottom(TreeNode root) {
	        List<List<Integer>> res = new LinkedList<List<Integer>>();
	        List<Integer> arr = null;
	        TreeNode node = null;
	        if(root != null){
	        		Deque<TreeNode> dq = new ArrayDeque<TreeNode>();
	        		Deque<Integer> ls = new LinkedList<Integer>();
	        		int level, last_level = -1;
	        		dq.add(root);
	        		ls.add(0);
	        		while(!dq.isEmpty()){
	        			node = dq.poll();
	        			level = ls.pop();
	        			if(level != last_level){
	        				last_level = level;
	        				if(arr != null) res.add(0, arr);
	        				arr = new ArrayList<Integer>();
	        				arr.add(node.val);
	        			}else{
	        				arr.add(node.val);
	        			}
	        			if(node.left != null){
	        				dq.add(node.left);
	        				ls.add(level + 1);
	        			}
	        			if(node.right != null){
	        				dq.add(node.right);
	        				ls.add(level + 1);
	        			}
	        		}
	        		res.add(0, arr);
	        }
	        return res;
	    }
		
		class LCC extends LeetCode{
			private int a = 0;
		    LCC(){
		    		super();
		    }
		 };
		 
		 public int rangeBitwiseAnd(int m, int n) {
		        int res = m;
		        if(m < Integer.MAX_VALUE)
			        for(int i = m + 1; i <= n ; i++){
			        		res &= i;
			        		if(res == 0)
			        			break;
			        }
		        return res;
		    }
		 class KVPair{
			 private String key;
			 private int value;
			 public KVPair(String k, int v){
				 key = k;
				 value = v;
			 }
		 }
		 private HashMap<Integer, Boolean> isCalculated = new HashMap<Integer, Boolean>();
		 public boolean isHappy(int n) {
			 if(n < 1) return false;
			 if(n == 1) return true;
			 if(isCalculated.get(n) == null){
				 isCalculated.put(n, true);
				 int m = 0;
				 while(n > 0){
					 m += Math.pow(n % 10, 2);
					 n /= 10;
				 }
				 return isHappy(m);
			 }else return false;			 	
		    }
		 
		 public ListNode removeElements(ListNode head, int val) {
			 if(head == null) return null;
			 ListNode p = new ListNode(-1), tmp = p;
		     p.next = head;
		     while(p.next != null){
		    	 	if(p.next.val == val)
		    	 		p.next = p.next.next;
		    	 	else p = p.next;
		     }
		     return tmp.next;
		  }
		 
		 public int countPrimes(int n) {
			 if (n <= 2) return 0;
		        boolean []f = new boolean[n];
		        int count = 0;
		        for (int i = 2; i < n; i++) {
		            if (!f[i]) {
		                count++;
		                for (int j = i + i; j < n; j += i) f[j] = true;
		            }
		        }
		        return count;
		  }
		
		 
		 public int calculate(char op, int x, int y)
		 {
			 switch (op){
			 case '+' : return x + y;
			 case '-' : return x - y;
			 case '*' : return x * y;
			 case '/' : return x / y;
			 default : return  x + y;
			 }
		 }
		 
		 public List diffWaysToCompute(String input) {
			 	List res = new ArrayList<Integer>();
			 	List<Integer> numsStack = new ArrayList<Integer>();
			 	List<Character> opStack = new ArrayList<Character>();
			 	for( int i = 0; i < input.length() ; i++){
			 		if (i % 2 == 1)
				         opStack.add(input.charAt(i));
				    else  numsStack.add(Integer.parseInt(String.valueOf(input.charAt(i))));
			 	}
			 	diffWaysToComputeHelper(res, numsStack, opStack, 0);
			 	return res;
		 }
		 
		 public List diffWaysToComputeHelper(List arr, List<Integer> numsStack, List<Character> opStack, int opi){
		        if (numsStack.size() == 2)
		            arr.add(calculate((Character)opStack.get(opi), (Integer)numsStack.remove(0), (Integer)numsStack.remove(0)));
		        else 
		            if (opi < opStack.size() - 1){
			                diffWaysToComputeHelper(arr, numsStack, opStack, opi + 1);
			                int res = calculate((Character)opStack.get(opi), (Integer)numsStack.remove(opi), (Integer)numsStack.remove(opi));
			                numsStack.add(opi, res);
			                opStack.remove(opi);
			                diffWaysToComputeHelper(arr, numsStack, opStack, opi);
		                }
		            else {
		                int res = calculate((Character)opStack.get(opi), (Integer)numsStack.remove(opi), (Integer)numsStack.remove(opi));
		                numsStack.add(numsStack.size() - 1, res);
		                opStack.remove(opi);
		                diffWaysToComputeHelper(arr, numsStack, opStack, opi - 1);
		            }

		        return arr;
		 }
		 
		 /*
		  * Got TLE because too many Map...
		  * 
		 public int largestRectangleArea(int[] height) {
			 	if(height.length == 0) return 0;
		        int maxArea = height[0];
		        HashMap<Integer, Integer> area = new HashMap<Integer, Integer>();
		        area.put(height[0], 1);
		        for(int i = 1 ; i < height.length ; i++){		        	
		        	HashMap hm = (HashMap) area.clone();
		        	for(Iterator j = hm.entrySet().iterator(); j.hasNext();){
		        		Entry<Integer, Integer> e = (Entry) j.next();
		        		int temp = height[i];
		        		if(height[i] >= e.getKey()){
		        			if(!area.containsKey(height[i]) && height[i] > e.getValue() * e.getKey())
		        				area.put(height[i], 1);
		        			e.setValue(e.getValue() + 1);
		        			temp = Math.max(temp, e.getValue() * e.getKey());
		        		}else{
		        			area.put(height[i], e.getValue() + 1);
		        			area.remove(e.getKey());
		        			temp = Math.max(temp, (e.getValue() + 1) * height[i]);
		        		}
		        		maxArea = Math.max(maxArea, temp);
		        	}
		        	
		        }
		        return maxArea;
		    }*/
		 
		 // stack solution, really nice...
		 public int largestRectangleArea(int[] height) {
			 if (height.length == 0) return 0;
			 int maxArea = 0, j;
			 int left[] = new int[height.length], right[] = new int[height.length], len[] = new int[height.length];
			 left[0] = height[0];
			 right[height.length - 1] = height[height.length - 1];
			 len[0] = height[0];
			 for(int i = 1; i < height.length; i++){
				 j = i - 1;
				 while(j >= 0 && height[j] >= height[i]){
					 left[i] += height[i];
					 j--;
				 }
			 }
			 for(int i = height.length - 2; i >= 0 ; i--){
				 right[i] = height[i];
				 j = i + 1;
				 while(j < height.length && height[j] >= height[i]){
					 right[i] += height[i];
					 j++;
				 }
			 }
			 for(int i = 0 ; i < height.length ; i++)
				 maxArea = Math.max(maxArea, right[i] + left[i]);
			 return maxArea;
		 }
		 
		 
	public static void main(String args[]) throws InterruptedException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		LeetCode lc = new LeetCode();
		int a[] = {2,1,5,6,2,3};
		int b[] = {-1, 2, 1, -4};
		List arr = new ArrayList(Arrays.asList(2,6,5,1,7,8,12,7,6));
		//Thread.sleep(1000);
		ListNode l1 = new ListNode(5);
//		ListNode l2 = new ListNode(2);
//		ListNode l3 = new ListNode(1);
//		ListNode l4 = new ListNode(4);
//		ListNode l5 = new ListNode(3);
//		l1.next = l2;
//		l2.next = l3;
//		l3.next = l4;
//		l4.next = l5;
//		ListNode n = lc.insertionSortList(l1);
//		Byte c = (byte) '艹';
		//System.out.println(lc.findSubstring("aaa", Arrays.asList("a", "a")));
		System.out.println(lc.largestRectangleArea(a));
		
	}
}

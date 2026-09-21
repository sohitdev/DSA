// ===== Approach 2: Optimal — Two Pointers (Sorted Arrays) =====
// Time Complexity: O(n + m) | Space Complexity: O(1)
class Solution {
	static ArrayList<Integer> intersection(int arr1[], int arr2[]) {
		ArrayList<Integer> ans = new ArrayList<>();
		
		int i = 0;
		int j = 0;
		
		while (i < arr1.length && j < arr2.length) {
			if (arr1[i] < arr2[j])
				i++;
			else if (arr1[i] > arr2[j])
				j++;
			else {
				if (ans.size() == 0 || ans.get(ans.size() - 1) != arr1[i]) {
					ans.add(arr1[i]);
				}
				i++;
				j++;
			}
		}
		
		return ans;
	}
}
	
/*
// ===== Approach 1: Brute Force — Nested Loops with Set =====
// Time Complexity: O(n * m) | Space Complexity: O(min(n, m))
class Solution {
    static ArrayList<Integer> intersection(int arr1[], int arr2[]) {
        int len1 = arr1.length;
        int len2 = arr2.length;
        
        ArrayList<Integer> ans = new ArrayList<>();
        Set<Integer> set = new TreeSet<>();
        
        for (int i = 0; i<len1; i++) {
            for (int j = 0; j<len2; j++) {
                if (arr1[i] == arr2[j]) {
                    set.add(arr1[i]);
                    break;
                }
            }
        }
        
        for (int num: set) {
            ans.add(num);
        }
        
        return ans;
    }
}
*/

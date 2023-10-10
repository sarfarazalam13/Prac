class Solution {
    
    private String s;
    private String t;
    private int sn;
    private int tn;
    private Integer memo[][];
    
    private int check(int si, int ti) {
        if (si == sn || ti == tn || sn - si < tn - ti) {
            return ti == tn ? 1 : 0;
        }
        if (ti == tn) {
            return 1;
        }
        if (si == sn) {
            return 0;
        }
        if (memo[si][ti] != null) {
            return memo[si][ti];
        }
        int count = check(si + 1, ti);
        if (s.charAt(si) == t.charAt(ti)) {
            count += check(si + 1, ti + 1);
        }
        memo[si][ti] = count;
        return count;
    }
    
    public int numDistinct(String s, String t) {
        this.s = s;
        this.t = t;
        this.sn = s.length();
        this.tn = t.length();
        this.memo = new Integer[sn][tn];
        return check(0, 0);
    }
    
}
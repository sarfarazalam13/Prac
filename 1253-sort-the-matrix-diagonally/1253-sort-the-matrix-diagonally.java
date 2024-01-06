class Solution {
    public int[][] diagonalSort(int[][] mat) {
        if(mat.length == 1) {
            return mat;
        }

        int i = mat.length - 2;
        int j = 0;

        while(i != 0 || j != mat[0].length - 1) {
            List<Integer> list = new ArrayList<>();
            int m = i;
            int n = j;

            while(m < mat.length && n < mat[0].length) {
                list.add(mat[m++][n++]);
            }

            Collections.sort(list);

            m = i;
            n = j;
            for(int l = 0; l < list.size(); l++) {
                mat[m++][n++] = list.get(l);
            }

            if(i != 0) {
                i--;
            } else {
                j++;
            }
        }
        return mat;
    }
}
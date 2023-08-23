class Solution {
 public static int numIslands(char[][] grid) {
  List<String> knownLand = new ArrayList<>();
  int islands = 0;
  for (int i = 0; i < grid.length; i++) {
   for (int j = 0; j < grid[i].length; j++) {
    if(grid[i][j] == '1' ){
      islands++;
      exploreIsland(i, j , grid);
    }
   }
  }
  return islands;
 }

private static void exploreIsland(int posA, int posB,char[][] grid){
  grid[posA][posB] = '2';
  if(posA-1 >= 0 && grid[posA-1][posB] == '1')
   exploreIsland(posA-1, posB, grid);
 if(posA+1 < grid.length && grid[posA+1][posB] == '1')
  exploreIsland(posA+1, posB, grid);
 if(posB-1 >= 0 && grid[posA][posB-1] == '1')
  exploreIsland(posA, posB-1, grid);
 if(posB+1 < grid[posA].length && grid[posA][posB+1] == '1')
  exploreIsland(posA, posB+1, grid);
}


}
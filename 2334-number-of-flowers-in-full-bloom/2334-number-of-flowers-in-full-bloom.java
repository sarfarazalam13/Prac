class Solution {
public int[] fullBloomFlowers(int[][] flowers, int[] people) {

  int m = flowers.length;
  int[] starts = new int[m], ends = new int[m];
  for (int i = 0; i < m; i++) {
      starts[i] = flowers[i][0];
      ends[i] = flowers[i][1];
  }
  Arrays.sort(starts);
  Arrays.sort(ends);

  int n = people.length;
  
  int[] indices = new int[n];
  for (int i = 0; i < n; i++) 
      indices[i] = i;
  
  quickSort(indices, people, 0, n - 1);
  
  int[] result = new int[n];
  int index1 = 0, index2 = 0;
  for (int index:indices) {
      int arrival = people[index];
      while ( index1 < m && starts[index1] <= arrival) index1++;
      while ( index2 < m && ends[index2] < arrival) index2++;  
      result[index] = index1 - index2;
  }
  return result;

}

public void quickSort(int[] indices, int[] people, int low, int high) {
    
    if (low >= high) return;

    int left = low -1, right = high + 1, mid = low + high >> 1;
    int pivot = people[indices[mid]];

    while (left  < right) {
        while (people[indices[++left]] < pivot) continue;
        while (people[indices[--right]] > pivot) continue;
        if (left < right) {
            int temp = indices[left];
            indices[left] = indices[right];
            indices[right] = temp;
        }
    }
    quickSort(indices, people, low, right); 
    quickSort(indices, people, right + 1, high);
  }
}
class Solution {
    public int findClosest(int x, int y, int z) {
        int xsteps=Math.abs(z-x);
        int ysteps= Math.abs(z-y);
      if (ysteps > xsteps) return 1;
       else  if(xsteps > ysteps) return 2;
       else return 0;
        
    }
}
package darkRealm;

public class FirstBadVersion {

//  You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version
//  of your product fails the quality check. Since each version is developed based on the previous version, all the
//  versions after a bad version are also bad.
//  Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the
//  following ones to be bad.
//  You are given an API bool isBadVersion(version) which will return whether version is bad. Implement a function to
//  find the first bad version. You should minimize the number of calls to the API.

  

  public int firstBadVersionFAST(int n) {
    int low = 1, high = n;
    int mid;
    while(low <= high){
      mid = low + (high - low) / 2;
      if(isBadVersion(mid)){
        if(!isBadVersion(mid - 1)) return mid;
        high = mid - 1;
      }
      else low = mid + 1;
    }
    return low;
  }

   // Calls API more # times
   public int firstBadVersionSLOW(int n) {
    int l = 0;
    int r = n;
    int mid;
    while(l < r){
      mid = l + (r - l) / 2;
      if(!isBadVersion(mid) && !isBadVersion(mid + 1))
        l = mid;
      else if(isBadVersion(mid) && isBadVersion(mid + 1))
        r = mid;
      else return mid + 1;
    }
    return n;// this return doesnt matter, i hv submitted with both [l+1, n]
  }
}

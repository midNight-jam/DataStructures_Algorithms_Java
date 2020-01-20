package darkRealm;

public class StudentAttendanceRecord1 {

//  551. Student Attendance Record I
//  You are given a string representing an attendance record for a student. The record only contains the following three characters:
//
//  'A' : Absent.
//  'L' : Late.
//  'P' : Present.
//  A student could be rewarded if his attendance record doesn't contain more than one 'A' (absent) or more than two continuous 'L' (late).
//
//  You need to return whether the student could be rewarded according to his attendance record.
//  Example 1:
//  Input: "PPALLP"
//  Output: True
//  Example 2:
//  Input: "PPALLL"
//  Output: False

  public static boolean checkRecord(String s){
    return !s.matches(".*LLL.*|.*A.*A.*");
  }

  public static boolean checkRecordOLD(String s) {
    int absent = 0;
    int late = 0;
    for (char c : s.toCharArray()) {
      if (c == 'A') absent++;
      if (absent > 1) return false;
      if (c == 'L') late++;
      else late = 0;
      if (late == 3) return false;
    }
    return true;
  }

  public static void main(String[] args) {
//    String rec = "PPALLP";
    String rec = "PPALLL";
    boolean res = checkRecord(rec);
    System.out.println("Rec : " + rec);
    System.out.println("Res : " + res);
  }
}

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public List<Interval> merge(List<Interval> intervals) {
     
        if(intervals.size()<=1){
            return intervals;
        }
        
        List<Interval> mergeInt = new ArrayList<Interval>();
        
        //sorting using lambda comparator.
        intervals.sort((i1,i2) -> Integer.compare(i1.start, i2.start));
        
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        
        for(Interval in: intervals){
            //comparing every interval  and increasing the end point if the interval is the part of other.
            if(in.start<= end)
            {
             end = Math.max(in.end, end);   
            }else{
                // adding the interval to the set.
              mergeInt.add(new Interval(start,end));
              start =in.start;
              end = in.end;
            }
        }
        
        //adding the last set.
       mergeInt.add(new Interval(start,end)); 
        
     return mergeInt;
        
    }
}

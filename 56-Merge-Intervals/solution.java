/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> res = new LinkedList<Interval>();
        //后面会用到get(0),所以size()是不能为0的
        if(intervals == null || intervals.size() == 0) return res;
        
        //comparator 去对collections进行排序
        Collections.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval i1, Interval i2) {
                return i1.start - i2.start;
            }
        });
        
        //取出第一个
        Interval cur = intervals.get(0);
        
        for(Interval itv: intervals) {
            //包含重叠的边界的时候，一定要考虑等于
            if(cur.end >= itv.start) {
                // cur.start = Math.min(cur.start, itv.start); 
                cur.end = Math.max(cur.end, itv.end);
            } else {
                res.add(cur);
                cur = itv;
            }
        }
        //要将最后一个结果加上去
        res.add(cur);
        return res;
    }
}
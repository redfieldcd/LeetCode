// two vectors
// public class ZigzagIterator {
//     Iterator<Integer> iter1, iter2;
//     public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
//         iter1 = v1.iterator();
//         iter2 = v2.iterator();
//     }

//     public int next() {
//         if(iter1.hasNext()) {
//             Iterator<Integer> temp = iter1;
//             iter1 = iter2;
//             iter2 = temp;
//         }
//         return iter2.next();
//     }

//     public boolean hasNext() {
//         return iter1.hasNext() || iter2.hasNext();
//     }
// }

//k vectors
public class ZigzagIterator {
    Iterator<Integer> iter1, iter2;
    Queue<Iterator> list;
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        list = new LinkedList();
        list.add(v1.iterator());
        list.add(v2.iterator());
    }

    public int next() {
        Iterator<Integer> poll = list.poll();
        int res = poll.next();
        if(poll.hasNext()) {
            list.add(poll);
        }
        return res;
    }

    public boolean hasNext() {
       return !list.isEmpty();
    }
}


/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */
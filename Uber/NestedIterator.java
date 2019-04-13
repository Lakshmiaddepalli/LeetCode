public class NestedIterator implements Iterator<Integer> {
    Stack<Iterator<NestedInteger>> stack = new Stack<Iterator<NestedInteger>>();
    Integer current;
 
    public NestedIterator(List<NestedInteger> nestedList) {
        if(nestedList==null)
            return;
 
        stack.push(nestedList.iterator());    
    }
 
    @Override
    public Integer next() {
        Integer result = current;
        current = null;
        return result;
    }
 
    @Override
    public boolean hasNext() {
        while(!stack.isEmpty() && current==null){
            Iterator<NestedInteger> top = stack.peek();
            if(!top.hasNext()){
                stack.pop();
                continue;
            }
 
            NestedInteger n = top.next();
            if(n.isInteger()){
                current = n.getInteger();
                return true;
            }else{
                stack.push(n.getList().iterator());
            }
        }
 
        return false;
    }
}

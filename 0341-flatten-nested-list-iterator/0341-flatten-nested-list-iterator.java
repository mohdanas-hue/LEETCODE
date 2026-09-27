public class NestedIterator implements Iterator<Integer> {

    ArrayList<Integer> arr = new ArrayList<>();
    int index = 0;

    public NestedIterator(List<NestedInteger> nestedList) {
        flatten(nestedList);
    }

    void flatten(List<NestedInteger> list) {
        for (NestedInteger x : list) {
            if (x.isInteger()) {
                arr.add(x.getInteger());
            } else {
                flatten(x.getList());
            }
        }
    }

    @Override
    public Integer next() {
        return arr.get(index++);
    }

    @Override
    public boolean hasNext() {
        return index < arr.size();
    }
}
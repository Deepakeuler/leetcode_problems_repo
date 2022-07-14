class MedianFinder {
        PriorityQueue <Integer>min = new PriorityQueue<>();
        PriorityQueue <Integer>max = new PriorityQueue<>(Collections.reverseOrder());
    
    public void addNum(int num) {
        max.add(num);
        min.add(max.poll());
        if (max.size() < min.size()){
            max.add(min.remove());
        }
        
    }
    public double findMedian() {
        if (max.size() == min.size()) return (max.peek() + min.peek()) /  2.0;
        else return max.peek();
    }
}

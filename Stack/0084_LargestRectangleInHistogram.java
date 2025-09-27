class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                int height = heights[stack.pop()];
                int width;
                if (stack.isEmpty()) {
                    // no bar left in stack → width is i
                    width = i;
                } else {
                    // width is distance between current i and new top
                    width = i - stack.peek() - 1;
                }
                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
        }

        // Process remaining bars in stack
        while (!stack.isEmpty()) {
            int height = heights[stack.pop()];
            int width;
            if (stack.isEmpty()) {
                width = n;
            } else {
                width = n - stack.peek() - 1;
            }
            maxArea = Math.max(maxArea, height * width);
        }

        return maxArea;
    }
}

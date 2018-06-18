package dp;

public class TrapRainWater {
    public static int trap(int[] height) {
        int start = 0;
        int end = 0;
        int cum = 0;
        for(int i = start; i < height.length -1; i++) {
            if(height[i] > height[i+1]) {
                end = getEnd(i, height);
                if(end > 0) {
                    int startWall = height[i];
                    int diff = 0;
                    if(startWall > height[end]) {
                        diff = startWall - height[end];
                    }
                    for(int j = i + 1; j < end; j++) {
                        cum += (startWall - height[j]) - diff;
                    }
                    i = end - 1;
                }
            }
        }
        return cum;
    }

    private static int getEnd(int start, int[] height) {
        int currEnd = -1;
        int endIndex = -1;
        for(int i = start + 1; i < height.length; i++) {

            if(height[i] >= height[start])
                return i;
            if(currEnd <= height[i]) {
                endIndex = i;
                currEnd = height[i];
            }

        }
        return endIndex;
    }

    public static int trap2(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        int ans = 0;
        int[] leftHeight = new int[height.length];
        int[] rightHeight = new int[height.length];

        leftHeight[0] = height[0];
        for (int i = 1; i < height.length; i++) {
            leftHeight[i] = Integer.max(height[i], leftHeight[i - 1]);
        }

        rightHeight[height.length - 1] = height[height.length - 1];
        for (int i = height.length - 2; i >= 0; i--) {
            rightHeight[i] = Integer.max(height[i], rightHeight[i + 1]);
        }

        for (int i = 0; i < height.length; i++) {
            ans += Integer.min(leftHeight[i], rightHeight[i]) - height[i];
        }

        return ans;

    }
}

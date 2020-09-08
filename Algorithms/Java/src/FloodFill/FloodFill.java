package src.FloodFill;

/**
 * @author mingqiao
 * @Date 2020/9/7
 */
public class FloodFill {

    /**
     * 经典dfs问题，复杂度O(M * N)
     *
     * @param image
     * @param sr
     * @param sc
     * @param newColor
     * @return
     */
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int originColor = image[sr][sc];
        if (originColor != newColor) {
            dfs(image, sr, sc, newColor, originColor);
        }
        return image;
    }

    public void dfs(int[][] image, int x, int y, int newColor, int originColor) {
        if (x < 0 || x >= image.length || y < 0 || y >= image[0].length) {
            return;
        }
        if (image[x][y] == originColor) {
            image[x][y] = newColor;
            dfs(image, x - 1, y, newColor, originColor);
            dfs(image, x + 1, y, newColor, originColor);
            dfs(image, x, y - 1, newColor, originColor);
            dfs(image, x, y + 1, newColor, originColor);
        }
    }
}

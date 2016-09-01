package zuobook;

/**
 * 顺时针旋转打印矩阵（类似贪吃蛇），最后打印格式按具体要求来打印(这里是按照实际效果打印了）
 * Created by sjh on 2016/9/1.
 */
public class DrawSnakeMatrix {
    public static int[][] draw(int n){
        if(n <= 0){
            return null;
        }
        int num = 1;
        int[][] res = new int[n][n];

        int row = 0;//行
        int column = 0;//列
        Point pointA = new Point(0,0);
        Point pointB = new Point(n-1,n-1);

        while(pointA.x <= pointB.x && pointA.y <= pointB.y){
            row = pointA.x;//行打印位置赋初始值
            column = pointA.y;//列打印位置赋初始值
            //打印上面行
            while (column <= pointB.x){
                res[row][column] = num++;
                column++;
            }
            column--;//回到最右边临界点
            row++;//下移一格

            //打印右边列
            while (row <= pointB.y){
                res[row][column] = num++;
                row++;
            }
            row--;//回到最下面临界点
            column--;//左移一格
            //打印下边行
            while (column >= pointA.x){
                res[row][column] = num++;
                column--;
            }
            column++;//回到最左边临界点
            row--;//上移一格
            //打印左边列
            while (row > pointA.y){
                res[row][column] = num++;
                row--;
            }

            pointA.x = pointA.x+1;
            pointA.y = pointA.y+1;

            pointB.x = pointB.x-1;
            pointB.y = pointB.y-1;
        }
        return res;
    }


    static class Point{
        int x;
        int y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void print(int[][] nums){
        if(nums == null || nums.length == 0){
            return;
        }
        int n = nums.length;

        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                System.out.print(nums[i][j]+ " ");
            }
            System.out.println();

        }
    }

    public static void main(String[] args) {
        int[][] nums = draw(5);
        print(nums);

    }
}

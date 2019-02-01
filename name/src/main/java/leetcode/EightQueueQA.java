package leetcode;

/**
 * @author linlang
 * @date 2019/1/29
 * @description:八皇后问题回溯法解答》
 */
public class EightQueueQA {
    int[] x;
    int N;
    int sum = 0;

    public int eightQueueQA(int n) {

        N = n;

        x = new int[N + 1];

        backTrace(1);

        return sum;
    }

    private boolean place(int col) {
        for (int i = 1; i < col; i++) {
            //判断新加的皇后是不是和之前
            if (Math.abs(col - i) == Math.abs(x[col] - x[i]) || x[col] == x[i]) {
                return false;
            }
        }
        return true;
    }

    private void backTrace(int t) {
        if (t > N) {
            sum++;
        } else {
            for (int j = 1; j <= N; j++) {
                x[t] = j;
                if(place(t)){
                    backTrace(t+1);
                }

            }
        }
    }

    public static void main(String[] args) {
        EightQueueQA n = new EightQueueQA();

        System.out.println(n.eightQueueQA(8));

    }
}

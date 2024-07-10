import java.util.Arrays;

/**
 * ClassName：yinhangjia
 * Package:PACKAGE_NAME
 * Description:
 *
 * @Author:XiaoYang
 * @Create:2024/3/11 - 20:47
 */
public class yinhangjia {
    public static class BankersAlgorithm {
        private int[][] maximum; // 最大需求矩阵
        private int[][] allocation; // 已分配资源矩阵
        private int[][] need; // 需求资源矩阵
        private int[] available; // 可用资源向量
        private int[] safeSequence; // 安全序列

        public BankersAlgorithm(int[][] max, int[][] alloc, int[] avail) {
            maximum = max;
            allocation = alloc;
            available = avail;
            int numberOfProcesses = max.length;
            int numberOfResources = avail.length;
            need = new int[numberOfProcesses][numberOfResources];
            safeSequence = new int[numberOfProcesses];
            calculateNeed();
        }

        // 计算需求矩阵
        private void calculateNeed() {
            for (int i = 0; i < need.length; i++) {
                for (int j = 0; j < need[i].length; j++) {
                    need[i][j] = maximum[i][j] - allocation[i][j];
                }
            }
        }

        // 检查是否有足够资源满足进程
        private boolean isSafe(int process, int[] work, boolean[] finish) {
            int numberOfResources = available.length;
            for (int i = 0; i < numberOfResources; i++) {
                if (need[process][i] > work[i])
                    return false;
            }
            return !finish[process];
        }

        // 执行银行家算法
        public boolean executeAlgorithm() {
            int numberOfProcesses = allocation.length;
            int numberOfResources = available.length;
            int[] work = Arrays.copyOf(available, numberOfResources);
            boolean[] finish = new boolean[numberOfProcesses];
            Arrays.fill(finish, false);

            int count = 0;
            while (count < numberOfProcesses) {
                boolean found = false;
                for (int i = 0; i < numberOfProcesses; i++) {
                    if (!finish[i] && isSafe(i, work, finish)) {
                        for (int j = 0; j < numberOfResources; j++) {
                            work[j] += allocation[i][j];
                        }
                        safeSequence[count++] = i;
                        finish[i] = true;
                        found = true;
                    }
                }
                if (!found) {
                    return false; // 没有找到安全序列
                }
            }
            return true; // 找到安全序列
        }

        // 输出安全序列
        public void printSafeSequence() {
            System.out.print("Safe Sequence: ");
            for (int i = 0; i < safeSequence.length; i++) {
                System.out.print("P" + safeSequence[i]);
                if (i != safeSequence.length - 1) {
                    System.out.print(" -> ");
                }
            }
            System.out.println();
        }

        public static void main(String[] args) {
            int[][] max = {{7, 5, 3}, {3, 2, 2}, {9, 0, 2}, {2, 2, 2}, {4, 3, 3}};
            int[][] allocation = {{0, 1, 0}, {2, 0, 0}, {3, 0, 2}, {2, 1, 1}, {0, 0, 2}};
            int[] available = {3, 3, 2};

            BankersAlgorithm bankersAlgorithm = new BankersAlgorithm(max, allocation, available);
            if (bankersAlgorithm.executeAlgorithm()) {
                bankersAlgorithm.printSafeSequence();
            } else {
                System.out.println("No safe sequence exists.");
            }
        }
    }
}

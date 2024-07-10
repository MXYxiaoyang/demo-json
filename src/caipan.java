
import java.io.*;
import java.util.concurrent.ThreadLocalRandom;
/**
 * ClassName：caipan
 * Package:PACKAGE_NAME
 * Description:
 *
 * @Author:XiaoYang
 * @Create:2024/3/20 - 9:12
 */
public class caipan {


        public static void main(String[] args) {
            try {
                // 创建命名管道
                BufferedReader pipeReader = new BufferedReader(new FileReader("\\\\.\\pipe\\rps_pipe"));

                // 等待选手连接
                System.out.println("Waiting for players...");

                // 接收选手的选择
                String choice1 = pipeReader.readLine();
                System.out.println("Player 1 choice: " + choice1);

                String choice2 = pipeReader.readLine();
                System.out.println("Player 2 choice: " + choice2);

                // 比较选手的选择
                String result;
                if (choice1.equals(choice2)) {
                    result = "It's a tie!";
                } else if (choice1.equals("Rock") && choice2.equals("Scissors") ||
                        choice1.equals("Paper") && choice2.equals("Rock") ||
                        choice1.equals("Scissors") && choice2.equals("Paper")) {
                    result = "Player 1 wins!";
                } else {
                    result = "Player 2 wins!";
                }

                // 发送结果给选手
                BufferedWriter pipeWriter = new BufferedWriter(new FileWriter("\\\\.\\pipe\\rps_pipe"));
                pipeWriter.write(result);
                pipeWriter.flush();

                // 关闭管道
                pipeReader.close();
                pipeWriter.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }



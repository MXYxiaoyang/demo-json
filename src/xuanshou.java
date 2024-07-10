import java.io.*;
import java.util.concurrent.ThreadLocalRandom;

/**
 * ClassName：xuanshou
 * Package:PACKAGE_NAME
 * Description:
 *
 * @Author:XiaoYang
 * @Create:2024/3/20 - 9:12
 */
public class xuanshou {


        public static void main(String[] args) {
            try {
                // 随机出拳
                String[] choices = {"Rock", "Paper", "Scissors"};
                String choice = choices[ThreadLocalRandom.current().nextInt(3)];

                // 连接到裁判的命名管道
                BufferedWriter pipeWriter = new BufferedWriter(new FileWriter("\\\\.\\pipe\\rps_pipe"));
                pipeWriter.write(choice);
                pipeWriter.newLine();
                pipeWriter.flush();

                // 接收裁判的结果
                BufferedReader pipeReader = new BufferedReader(new FileReader("\\\\.\\pipe\\rps_pipe"));
                String result = pipeReader.readLine();
                System.out.println("Result: " + result);

                // 关闭管道
                pipeReader.close();
                pipeWriter.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }



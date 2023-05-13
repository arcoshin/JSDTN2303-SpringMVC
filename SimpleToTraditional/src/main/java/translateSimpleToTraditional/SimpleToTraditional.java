package translateSimpleToTraditional;

import com.github.houbb.opencc4j.util.ZhConverterUtil;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class SimpleToTraditional {
    public static void main(String[] args) {

        /**
         * 獲取源數據
         */
        File baseDir = new File("SimpleToTraditional/src/main/java/translateSimpleToTraditional");
        File originDir = new File(baseDir, "origin");
        File targetDir = new File(baseDir, "target");
        File[] listFiles = originDir.listFiles();

        /**
         * 遍歷這個掃描結果
         */
        for (File listFile : listFiles) {
            /**
             * 源文件、目標文件綁定
             */
            File originFile = new File(originDir, listFile.getName());
            File targetFile = new File(targetDir, listFile.getName());

            /**
             * 建立流
             */
            try (
                    BufferedReader br = new BufferedReader(
                            new InputStreamReader(
                                    new FileInputStream(originFile), StandardCharsets.UTF_8
                            )
                    );

                    PrintWriter pw = new PrintWriter(
                            new OutputStreamWriter(
                                    new FileOutputStream(targetFile), StandardCharsets.UTF_8
                            )
                            , true)

            ) {
                String line;
                while ((line = br.readLine()) != null) {
                    pw.println(ZhConverterUtil.convertToTraditional(line));
                }
                //ZhConverterUtil.convertToTraditional(line);//將簡體字轉換為繁體字
                //ZhConverterUtil.convertToSimple(line);//將繁體字轉換為簡體字

            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }
}

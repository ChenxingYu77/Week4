package HomeworkIO;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class FileIO{

    private static final Scanner in = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        File targetFile = createFile();

        writeAndRead(targetFile);
    }

    private static File createFile() throws IOException{
        System.out.println("请输入文件名：");
        String fileName = in.nextLine().trim();
        File f = new File("."+File.separator+fileName+".txt");
        if(f.isFile()){
            System.out.println("目标文件存在，删除："+f.delete());
        }
        System.out.println(f.createNewFile());
        return f;
    }
    private static void writeToFiles(File targetFiles) throws IOException{
        // >> TODO try with resource, 帮我们搞定close
        try (
                // >> TODO 创建一个inputstream,建立一个从文件到程序的byte数据传输流
                FileOutputStream fos = new FileOutputStream(targetFiles);
                // >> TODO 建立一个可以消费inputstream的writer, 并指定字符集，这样就可以一个个地写入字符
                OutputStreamWriter osw = new OutputStreamWriter(fos, StandardCharsets.UTF_8);
                // >> TODO 使用PrintWriter,可以方便地写入一行字符
                PrintWriter pw = new PrintWriter(osw);
        ) {
            System.out.println("输入的内容会实时写入文件，如果输入空行则结束");
            while (true){
                String lineToWrite = in.nextLine().trim();
                System.out.println("输入内容为："+lineToWrite);
                if(lineToWrite.trim().isBlank()){
                    System.out.println("输入结束");
                    break;
                } else {
                    pw.println(lineToWrite);
                    pw.flush();
                }
            }
        } catch(Exception ex){
            ex.printStackTrace();
        }
    }

    public static void readFile(File sourceFile){
        System.out.println("--------------经典的处理方式-----------");
        try(
                // >> TODO 建立从文件到程序的数据输入（input)流
                FileInputStream fis = new FileInputStream(sourceFile);
                // >> TODO 用InputStreamReader将这个byte流套一下、装饰一下，并制定字符编码，让它能够将读出的byte转为字符
                InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
                // >> TODO 增加缓存功能，输入输出效率更高，并且可以一次读取一行
                BufferedReader reader = new BufferedReader(isr);
        ){
            String line = null;
            while ((line=reader.readLine())!= null){
                System.out.println(line.trim());
            }
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public static void writeAndRead(File sourceFile) throws IOException{
        writeToFiles(sourceFile);
        readFile(sourceFile);
        System.out.println("任务结束");
    }
}


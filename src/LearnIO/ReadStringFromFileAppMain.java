package LearnIO;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Locale;
import java.util.Scanner;

public class ReadStringFromFileAppMain {
    private static final Scanner in = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //File sourceFile = createFile();
        File sourceFile = new File("."+File.separator+"目标文件.txt");
        // >> TODO System.in只能读取标准的输入里的byte， 而Scanner可以将byte读取出来，转换成String，进而转换成不同的数据类型，比如int，boolean


        classicWay(sourceFile);

        //coolerWay(sourceFile);
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

    private static void classicWay(File sourceFile){
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
                System.out.println(line.trim().toUpperCase());
            }
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

    private static void coolerWay(File sourceFile){
        System.out.println("--------------酷的处理方式-----------");

        try(
            FileInputStream fis = new FileInputStream(sourceFile);
            InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
            BufferedReader reader = new BufferedReader(isr);
        ){
            reader.lines().map(String::trim).map(String::toUpperCase).forEach(System.out::println);
        } catch (Exception ex){
            ex.printStackTrace();
        }

    }
}

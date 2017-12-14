package test1;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
 
public class main {
 
    public static void main(String[] args) {
        try {
            System.out.println("Pleaseinput:");							
            File inputfile = new File("src.txt");							//生成对象为inputfile的文件名为src的txt文件
            File outputfile = new File("dest.txt");							//生成对象为outputfile的文件名为dest的txt文件
            byte[] outCh = new byte[100];									//创建数组名为outCh 的数组对象
            int bytes = System.in.read(outCh, 0, 100);						//创建一个int型名为bytes的对象接受键盘的输入
            FileOutputStream Fout = new FileOutputStream("src.txt");		//创建 FileOutputStream对象，名为Fout导向src.txt
            Fout.write(outCh,0,bytes);										//向src.txt写入信息
            FileInputStream in= new FileInputStream(inputfile);				//创建 FileInputStream对象，名为Fout导向inputfile文件
            FileOutputStream out = new FileOutputStream(outputfile);		//创建 FileOutputStream对象，名为Fout导向Outputfile文件
            int c;															//创建int 型对象，名为c
            while ((c=in.read())!=-1)										//当从inputfile对象即src中读出的数据不为-1则将数据写入dest文件中
            	out.write(c);
            in.close();														//关闭in
            out.close();													//关闭out
            byte[] inCh = new byte[bytes];									//创建一个数组型对象，名为inCh
            FileInputStream Fin = new FileInputStream("dest.txt");			//创建 FileInputStream对象，名为Fout导向dest文件

            Fin.read(inCh);													//将fin中的数据读取出来放入inch数组中
            System.out.println(new String(inCh));							//显示Inch数组中的内容
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }
}

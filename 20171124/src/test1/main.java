package test1;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
 
public class main {
 
    public static void main(String[] args) {
        try {
            System.out.println("Pleaseinput:");							
            File inputfile = new File("src.txt");							//���ɶ���Ϊinputfile���ļ���Ϊsrc��txt�ļ�
            File outputfile = new File("dest.txt");							//���ɶ���Ϊoutputfile���ļ���Ϊdest��txt�ļ�
            byte[] outCh = new byte[100];									//����������ΪoutCh ���������
            int bytes = System.in.read(outCh, 0, 100);						//����һ��int����Ϊbytes�Ķ�����ܼ��̵�����
            FileOutputStream Fout = new FileOutputStream("src.txt");		//���� FileOutputStream������ΪFout����src.txt
            Fout.write(outCh,0,bytes);										//��src.txtд����Ϣ
            FileInputStream in= new FileInputStream(inputfile);				//���� FileInputStream������ΪFout����inputfile�ļ�
            FileOutputStream out = new FileOutputStream(outputfile);		//���� FileOutputStream������ΪFout����Outputfile�ļ�
            int c;															//����int �Ͷ�����Ϊc
            while ((c=in.read())!=-1)										//����inputfile����src�ж��������ݲ�Ϊ-1������д��dest�ļ���
            	out.write(c);
            in.close();														//�ر�in
            out.close();													//�ر�out
            byte[] inCh = new byte[bytes];									//����һ�������Ͷ�����ΪinCh
            FileInputStream Fin = new FileInputStream("dest.txt");			//���� FileInputStream������ΪFout����dest�ļ�

            Fin.read(inCh);													//��fin�е����ݶ�ȡ��������inch������
            System.out.println(new String(inCh));							//��ʾInch�����е�����
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }
}

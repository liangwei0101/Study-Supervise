package com.Example;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class CreateFile {
    public static void main(String[] args)
    {
       String  filename="E:\\untitled\\test.txt";
        File file=new File(filename);
        try {
            //如果文件不存在就创建新的文件
            if(!file.exists())
            {
                file.createNewFile();
                System.out.println("success create the file,the file is "+filename);
                //写入数据
                writefilecontent(filename);
            }
            else
            {//存在就删掉，重新建立文件写入
                System.out.println("file has already exists");
                file.delete();
                file.createNewFile();
                //写入数据
                writefilecontent(filename);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    public static boolean writefilecontent(String filename)throws IOException {
        // TODO Auto-generated method stub
        boolean bool=false;
        @SuppressWarnings("resource")
        FileOutputStream outputStream = new FileOutputStream(filename);
        OutputStreamWriter streamWriter = new OutputStreamWriter(outputStream);
        String[] str= {"assistant","associate","full"};
        try {
            for(int i=0;i<1000;i++)
            {
                int a=(int)(Math.random()*3);
                streamWriter.write("FirstName"+i+" LastName"+i+" "+ str[a]+" ");
                if(a==0)
                {
                    double b=((int)(Math.random()*30000+50000*100)/100.00);
                    String s=Double.toString(b);
                    streamWriter.write(s+"\r\n");

                }
                else if(a==1)
                {
                    double b=((int)((Math.random()*50000+60000)*100)/100.0);
                    String s=Double.toString(b);
                    streamWriter.write(s+"\r\n");

                }
                else
                {
                    double b=((int)((Math.random()*550000+75000)*100)/100.0);
                    String s=Double.toString(b);
                    streamWriter.write(s+"\r\n");

                }
                bool=true;
            }
        }catch(Exception ex) {
            ex.getStackTrace();
        }
        return bool;

    }
}

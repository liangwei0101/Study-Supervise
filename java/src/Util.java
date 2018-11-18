import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Util {

    public static boolean writefilecontent(String filename)throws IOException {
        // TODO Auto-generated method stub
        boolean bool=false;
        FileOutputStream outputStream = new FileOutputStream(filename);
        OutputStreamWriter streamWriter = new OutputStreamWriter(outputStream);
        String[] str= {"assistant","associate","full"};
        try {
            for(int i=0;i<1000;i++)
            {
                int a=(int)(Math.random()*3);
                streamWriter.write("FirstName"+i+"-"+"LastName"+i+"-"+ str[a]+"-");
                if(a==0)
                {
                    double b=((int)(Math.random()*30000+50000*100)/100.00);
                    String s=Double.toString(b);
                    streamWriter.write(s+"-"+ "\r\n");
                }
                else if(a==1)
                {
                    double b=((int)((Math.random()*50000+60000)*100)/100.0);
                    String s=Double.toString(b);
                    streamWriter.write(s+"-"+"\r\n");

                }
                else
                {
                    double b=((int)((Math.random()*550000+75000)*100)/100.0);
                    String s=Double.toString(b);
                    streamWriter.write(s+"-"+"\r\n");

                }
                bool=true;
            }
        }catch(Exception ex) {

        }
        return bool;

    }

    public static List<Professor> readFileContent() throws IOException {

        List<Professor> list = new ArrayList<Professor>();
        FileReader fr = new FileReader("E:\\test.txt");//FileReader 用于读文件
        BufferedReader br = new BufferedReader(fr);//使用缓冲区的方法将数据读入到缓冲区中
        String str;

        while((str=br.readLine()) != null)
        {
             Professor professor = new Professor();
             String[] st = new String[4];
             st = str.split("-");
             professor.setFirstname(st[0]);
             professor.setLastname(st[1]);
             professor.setPosition(st[2]);
             professor.setSalary(st[3]);
             list.add(professor);
        }
        return list;
    }
}




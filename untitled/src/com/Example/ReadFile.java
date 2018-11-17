package com.Example;

import java.io.*;

public class ReadFile {
    public  static void main(String[] args) throws IOException
    {
        FileReader fr = new FileReader("E:\\untitled\\test.txt");//FileReader 用于读文件
        BufferedReader br = new BufferedReader(fr);//使用缓冲区的方法将数据读入到缓冲区中
        String[][] data=new String[1000][4];
        double sum1=0,sum2=0,sum3=0;
        int count1=0,count2=0,count3=0;
        int line=0;
        double avg1,avg2,avg3;
        String str;
        while((str=br.readLine()) != null)
        {
         data[line]=str.split(" ");
         line++;
        }
for(int i=0;i<1000;i++)
    {
        double data1=Double.parseDouble(data[i][3]);
        if(data[i][2]=="assistant")
        {

            sum1=sum1+data1;
            count1++;
        }
        else if(data[i][2]=="associate")
        {
            sum2=sum2+data1;
            count2++;
        }
        else
        {
            sum3=sum3+data1;
            count3++;
        }
    }
        avg1=sum1/count1;
        avg2=sum2/count2;
        avg3=sum3/count3;
        System.out.println("associates' sumsalary is "+sum1+" the average salary is "+avg1);
        System.out.println("assistants' sumsalary is "+sum2+" the average salary is "+avg2);
        System.out.println("fulls' sumsalary is "+sum3+" the average salary is "+avg3);
    }

}

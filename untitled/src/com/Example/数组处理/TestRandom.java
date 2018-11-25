package com.Example.数组处理;

public class TestRandom {
    public static void main(String[] args) throws ArrayIndexOutOfBoundsException
    {
        final int NUMBER=5;
        try{RandomArray ra=new RandomArray(NUMBER);
        for(int i=0;i<NUMBER;i++)
        {
            for(int j=0;j<NUMBER;j++)
            {
                System.out.println(ra.getArray()[i][j]+" ");
            }
            System.out.println();
        }}
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}

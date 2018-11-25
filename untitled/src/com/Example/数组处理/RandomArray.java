package com.Example.数组处理;

public class RandomArray {
    public int[][] getArray() {
        return array;
    }

    private  int[][] array;

    public void setSize(int size) {
        this.size = size;
    }
public RandomArray(int size)
{
    setSize(size);
    array=new int[size][size];
    generateRandomArray(size);
}
    private int size;
    public void  generateRandomArray(int size)
    {
        int randomNumber;
        //标记是否重复
        boolean isRepeated;
        for(int i=0;i<size;i++)
        {
            for(int j=0;i<size;j++)
            {
                randomNumber=(int)(Math.random()*size*size)+1;
                isRepeated=false;
                for(int a=0;a<size;a++)
                {
                    for(int b=0;b<size;b++)
                    {
                        if(randomNumber==array[a][b])
                            isRepeated=true;
                        break;
                    }
                }
                if(!isRepeated)
                {
                    array[i][j]=randomNumber;

                }
                else{
                    j--;
                }
            }
        }
    }
}

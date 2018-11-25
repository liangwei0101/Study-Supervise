package 计算器;

import javax.swing.*;

public class Calculator {
    public static void main(String args[]){
        DemoWindow demoWindow=new DemoWindow("计算器");
        //设置frame的大小为300x200，且可见默认是不可见的
        demoWindow.setSize(1000,500);
        demoWindow.setVisible(true);
        //使右上角的关闭按钮生效，如果没有这句，点击右上角的关闭按钮只能关闭窗口，无法结束进程
        demoWindow.setDefaultCloseOperation(DemoWindow.EXIT_ON_CLOSE);
    }
}

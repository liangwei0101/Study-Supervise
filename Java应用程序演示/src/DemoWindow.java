import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class DemoWindow extends JFrame implements ActionListener {
    //显示数值的文本框
    JTextField jtf=new JTextField();
    //布局面板
     JPanel jp=new JPanel();
     //显示0到9的按钮数组
     JButton[] jb;
     //显示等号的按钮
     JButton jb1=new JButton("=");
     //显示加号的按钮
     JButton jb2=new JButton("+");
     //被加数
     int num1=0;
     //加数
     int num2=0;
     //表示是否要清空数值的标记变量
     boolean clearTextboxFlag=false;
     //表示是否要进行加法运算的标记变量
     boolean plusFlag =false;
     //构造函数
     public DemoWindow(String title)
     {
         super(title);
         //面板布局
         jp.setLayout(new GridLayout(4,3));
         //建立按钮
         jb=new JButton[10];
         for(int i=0;i<10;i++) {
             jb[i] = new JButton(String.valueOf(i));
             jp.add(jb[i]);
         }
         //添加事件监听器
         jb1.addActionListener(this);
         jb2.addActionListener(this);
         //在布局上添加按钮
         jp.add(jb1);
         jp.add(jb2);
         //窗体布局
         jb2.setBackground(Color.GREEN);
         add(jtf,BorderLayout.NORTH);
         add(jtf,BorderLayout.CENTER);
         //设置初始状态
         reset();
     }
     //设置初始状态的函数
     public  void reset()
     {
         num1=0;
         num2=0;
         jtf.setText("0");
     }
     //响应单击按钮函数
    public void actionPerformed(ActionEvent ae)
    {
        //判断是否要清空数值
        if(clearTextboxFlag)
        {
            jtf.setText("");
        }
        try{
            //获取当前的按钮标题
            JButton be=(JButton) ae.getSource();
            String st=be.getText();
            //处理加
            if(st.equals("+"))
            {
                //设置当前的文本值为被加数
                num1=Integer.parseInt(st);
                //需要清空文本框
                clearTextboxFlag=true;
                //进入加法运算
                plusFlag=true;
            }
            else if(st.equals("="))
            {
                //如果在单击加号按钮后，直接单击等于按钮，将加数设置为嗬被加数相等
                if(plusFlag)
                {
                    num2=num1;
                }
                else
                {
                    num2=Integer.parseInt(jtf.getText());
                }
                //得到加法结果
                jtf.setText(String.valueOf(num1+num2));
                //需要清空文本框
                clearTextboxFlag=true;
                //退出加法运算
                plusFlag=false;
            }
            //处理输入0到9
            else
            {
                //防止在数值前面输入0字符
                if(jtf.getText().equals("0"))
                {
                    jtf.setText("");
                }
                //追加输入数字字符
                jtf.setText(jtf.getText()+st);
                //不需要清空文本框
                clearTextboxFlag=false;
                //不进行加法运算
                plusFlag=false;
            }
        }catch(Exception ex)
        {
            reset();
        }
    }

}

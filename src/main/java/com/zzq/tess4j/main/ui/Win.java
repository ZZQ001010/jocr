package com.zzq.tess4j.main.ui;

import com.zzq.tess4j.main.sb.SbImg;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Win extends JFrame implements ActionListener {

    JButton jb1, jb2,defjb,jby;  //按钮
    JPanel jp1,jp2,jp3, jp4;        //面板
    JTextField jtf;   //文本框
    JLabel jlb1, jlb2, jlb3; //标签
    JTextArea jpf; //密码框
    String imgPath =null;
    String defPath = "C:\\Users\\27660\\Desktop\\截图未命名.jpg" ;


    public Win() {
        // TODO Auto-generated constructor stub
        jb1 = new JButton("中文识别");
        jby=new JButton("英文识别");
        jb2 = new JButton("重置");
        defjb = new JButton("默认路径");

        initEvent();



        jp1 = new JPanel();  //创建面板
        jp2 = new JPanel();
        jp3 = new JPanel();

        jlb1 = new JLabel("识别图片路径:");  //添加标签
        jlb2 = new JLabel("识别文字结果:");

        jtf = new JTextField(defPath,30);  //创建文本框和密码框
        jpf = new JTextArea(25,30);


        //加入面板中
        jp1.add(jlb1);
        jp1.add(jtf);

        jp2.add(jlb2);
        jp2.add(jpf);

        jp3.add(jb1);
        jp3.add(jb2);
        jp3.add(defjb);
        jp3.add(jby);
        //将JPane加入JFrame中
        this.add(jp1);
        this.add(jp2);
        this.add(jp3);

        //设置布局
        this.setTitle("ocr 图片文字提取");
        this.setLayout(new FlowLayout());
        this.setSize(500, 600);   //设置窗体大小
        this.setLocationRelativeTo(null);//在屏幕中间显示(居中显示)
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);  //设置可关闭

        this.setVisible(true);  //设置可见
        this.setResizable(false);   //设置不可拉伸大小

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

    }


    public void initEvent(){
        jb1.addActionListener((e)->{
            imgPath = jtf.getText();
            try {
                service(imgPath,"CN");
            } catch (Exception e1) {
                e1.printStackTrace();
                JOptionPane.showMessageDialog(null,
                        "路径有误","消息提示!",2);
            }
        });
        jby.addActionListener((e)->{
            imgPath = jtf.getText();
            try {
                service(imgPath,"EN");
            } catch (Exception e1) {
                e1.printStackTrace();
                JOptionPane.showMessageDialog(null,
                        "路径有误","消息提示!",2);
            }
        });
        jb2.addActionListener(e->{
            jtf.setText("");
            jpf.setText("");
        });

        defjb.addActionListener(e->{
            jtf.setText(defPath);
        });

    }


    public void service(String imgPath,String language) throws  Exception{
        String sbstr = new SbImg().sb(imgPath,language);
        jpf.setText(sbstr);
    }




}

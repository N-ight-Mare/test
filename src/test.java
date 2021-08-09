//第一步，引用需要的包或类；
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//第二步，定义一个窗口类，并实现 ActionListener 接口，把需要的组件定义放到类里；
//定义一个窗口类，该类实现 ActionListener 接口；
public class test extends JFrame implements ActionListener{
    JButton jiandao,shitou,bu,clear; //定义 JButton 对象；
            JPanel pane12,panel1; //定义JPanel对象
    JLabel label,label1,label2; //定义JLabel对象
    static int x = 0;

    //第三步，设置窗体。
    public test() {
        setTitle("石头剪刀布游戏"); //设置窗体标题， 修改标题为 “ 石头剪刀布游戏 ” ；
        setLocation(250,250); //设置窗体左上顶点坐标；
        setSize(350,350); //设置窗体大小， 修改窗体大小为： 350 × 350 ；

        //第四步，根据需求建立对象，这里只需要 4 个 JButton 对象，2 个 JPanel 对象，1 个 JLabel 对象；
        panel1 =new JPanel(); //创建panel1对象
        panel1.setBackground(Color.yellow); //设置panel1的背景颜色为黄色

        shitou = new JButton("石头"); //创建shitou对象
        jiandao =new JButton("剪刀"); //创建jiandao对象
        bu = new JButton("布"); //创建bu对象
        clear = new JButton("清空"); //创建clear对象

        pane12=new JPanel(); //创建panel2对象
        pane12.setBackground(Color.green); //设置panel1的背景颜色为绿色

        label =new JLabel("选择剪刀、石头、布开始游戏"); //创建label对象且内容为选择剪刀、石头、布开始游戏

        //第五步，给所有 JButton 对象注册事件监听器；
        shitou.addActionListener(this); //给 shitou 添加事件监听器；
        bu.addActionListener(this); //给 jiandao 添加事件监听器；
        jiandao.addActionListener(this); //给 bu 添加事件监听器；
        clear.addActionListener(this); //给 clear 添加事件监听器；

        //第六步，把所有新添加的对象都逐次放进窗体中，例如下面，先放进面板里面，然后再把面板放进窗体中，放置位置可以自定义；
        panel1.add(shitou); //把 shitou 放进 panel1 中；
        panel1.add(jiandao); //把 jiandao 放进 panel1 中；
        panel1.add(bu); //把 bu 放进 panel1 中；
        panel1.add(clear); //把 clear 放进 panel1 中；
        pane12.add(label); //把 label 放进 panel2 中；
        add(panel1,BorderLayout.NORTH); //把 panel1 放进 窗体 中；布局为边界布局 上方
        add(pane12,BorderLayout.CENTER); //把 panel2 放进 窗体 中；布局为边界布局 中间


        JMenuBar mbar = new JMenuBar();
        setJMenuBar(mbar);

        JMenu m1 = new JMenu("结果显示方式");
        JMenu m2 = new JMenu("关于游戏");
        mbar.add(m1);
        mbar.add(m2);

        JMenuItem mi1 = new JMenuItem("文本显示");
        JMenuItem mi2 = new JMenuItem("图形显示");
        JMenuItem mi3 = new JMenuItem("结束游戏");
        JMenuItem mi4 = new JMenuItem("关于游戏");
        m1.add(mi1);
        m1.add(mi2);
        m1.add(mi3);
        m2.add(mi4);

        mi3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                System.exit(0);
            }
        });

        label1 = new JLabel(" ");
        label2 = new JLabel(" ");


        mi1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                label1.setVisible(false);
                label2.setVisible(false);
                label.setVisible(true);
                x = 1;
            }
        });

        mi2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                x = 2;
                label.setVisible(false);
                label.setText("选择剪刀、石头、布开始游戏");
                label1.setVisible(false);
                label2.setVisible(false);
                label.setVisible(true);
            }
        });

        final JDialog dlg = new JDialog(this,"关于游戏");
        dlg.setBounds(325,325,200,200);
        dlg.setLayout(new BorderLayout());
        dlg.setModal(false);

        JTextArea j = new JTextArea();
        j.setBounds(100,100,200,200);
        j.append("用 JAVA 语言设计如下界面的石头剪刀布游戏。游戏的一方点击界面上石头、剪刀、布按钮，游戏的另一方计算机随机选择，然后给出游戏结果。");
        j.setLineWrap(true);
        j.setColumns(5);
        dlg.add(j,BorderLayout.CENTER);
        dlg.setVisible(false);

        mi4.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                dlg.setVisible(true);
            }
        });
    }



    //第七步，实现 ActionListener 接口方法，使得按下按钮后执行方法里的代码；
    //实现 ActionListener 接口方法，当按下按钮就会调用该方法，可以称为事件响应器；
    public void actionPerformed(ActionEvent e) {
        ImageIcon ii1 = new ImageIcon("D:\\资料\\图片\\shitou.jpg");
        ImageIcon ii2 = new ImageIcon("D:\\资料\\图片\\jiandao.jpg");
        ImageIcon ii3 = new ImageIcon("D:\\资料\\图片\\bu.jpg");
        ii1.setImage(ii1.getImage().getScaledInstance(100,100,0));
        ii2.setImage(ii2.getImage().getScaledInstance(100,100,0));
        ii3.setImage(ii3.getImage().getScaledInstance(100,100,0));
        if(x==0||x==1){

            if(e.getSource()==shitou){ //如果你按下的是 shitou 按键时，就会执行以下操作；
                int i=((int)(Math.random()*10))%3; //定义一个 int 型变量 i，利用 Math.random()函数获取随机数，因为*10 所以随机数区间为[0,10)，最后强制转换为 int 型，再除 3 取余，最后的赋值给 i；
                switch(i) //i 为 0 时就执行 case 0 操作，以此类推；
                {
                    case 0 :label.setText("你出石头，电脑出石头，平局！");break; //当 i=0 时，执行后续操作，到 break 结束；（必须要添加 break，不然会一直执行下去）；
                    case 1 :label.setText("你出石头，电脑出剪子，恭喜你赢了！");break; //当 i=1 时，与上同理；
                    case 2 :label.setText("你出石头，电脑出布，很遗憾你输了！");break; //当 i=2 时，与上同理；
                }
            }
            else if (e.getSource()==bu){ //如果你按下的是 bu 按键时，与上同理；
                int i=((int)(Math.random()*10))%3;
                switch(i)
                {
                    case 0 :label.setText("你出布，电脑出布，平局！");break;
                    case 1 :label.setText("你出布，电脑出石头，恭喜你赢了！");break;
                    case 2 :label.setText("你出布，电脑出剪刀，很遗憾你输了！");break;
                }
            }
            else if (e.getSource()==jiandao){ //当你按下 jiandao 按键时，与上同理；
                int i=((int)(Math.random()*10))%3;
                switch(i)
                {
                    case 0 :label.setText("你出剪刀，电脑出剪刀，平局！");break;
                    case 1 :label.setText("你出剪刀，电脑出布，恭喜你赢了！");break;
                    case 2 :label.setText("你出剪刀，电脑出石头，很遗憾你输了！");break;
                }
            }
            else if(e.getSource()==clear) //当你按下 clear 按键时，直接输出 label.setText()；
            {
                label.setText("选择剪刀、石头、布开始游戏");
            }
        }
        else if(x==2){

            if(e.getSource()==shitou){
                int j=((int)(Math.random()*10))%3;

                label.setVisible(false);
                label1.setVisible(false);
                label1 = new JLabel(ii1);
                pane12.add(label1);
                label1.setVisible(true);

                switch(j)
                {
                    case 0 :
                        label2.setVisible(false);
                        label2 = new JLabel(ii1);
                        pane12.add(label2);
                        label2.setVisible(true);
                        break;
                    case 1 :
                        label2.setVisible(false);
                        label2 = new JLabel(ii2);
                        pane12.add(label2);
                        label2.setVisible(true);
                        break;
                    case 2 :
                        label2.setVisible(false);
                        label2 = new JLabel(ii3);
                        pane12.add(label2);
                        label2.setVisible(true);
                        break;
                }
            }
            else if (e.getSource()==bu){
                int j=((int)(Math.random()*10))%3;

                label.setVisible(false);
                label1.setVisible(false);
                label1 = new JLabel(ii3);
                pane12.add(label1);
                label1.setVisible(true);

                switch(j)
                {
                    case 0 :
                        label2.setVisible(false);
                        label2 = new JLabel(ii1);
                        pane12.add(label2);
                        label2.setVisible(true);
                        break;
                    case 1 :
                        label2.setVisible(false);
                        label2 = new JLabel(ii2);
                        pane12.add(label2);
                        label2.setVisible(true);
                        break;
                    case 2 :
                        label2.setVisible(false);
                        label2 = new JLabel(ii3);
                        pane12.add(label2);
                        label2.setVisible(true);
                        break;
                }
            }
            else if (e.getSource()==jiandao){
                int j=((int)(Math.random()*10))%3;

                label.setVisible(false);
                label1.setVisible(false);
                label1 = new JLabel(ii2);
                pane12.add(label1);
                label1.setVisible(true);

                switch(j)
                {
                    case 0 :
                        label2.setVisible(false);
                        label2 = new JLabel(ii1);
                        pane12.add(label2);
                        label2.setVisible(true);
                        break;
                    case 1 :
                        label2.setVisible(false);
                        label2 = new JLabel(ii2);
                        pane12.add(label2);
                        label2.setVisible(true);
                        break;
                    case 2 :
                        label2.setVisible(false);
                        label2 = new JLabel(ii3);
                        pane12.add(label2);
                        label2.setVisible(true);
                        break;
                }
            }
            else if(e.getSource()==clear)
            {
                label.setText("选择剪刀、石头、布开始游戏");
                label1.setVisible(false);
                label2.setVisible(false);
                label.setVisible(true);
            }

        }
    }

    //第八步，添加主方法，进行测试；
    public static void main(String agrs[]) { //添加一个主函数，对窗体显示情况进行测试；
        test frame =new test(); //初始化窗体对象；
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //设置窗体关闭按钮；
        frame.setVisible(true); //使窗体可见；
    }
}

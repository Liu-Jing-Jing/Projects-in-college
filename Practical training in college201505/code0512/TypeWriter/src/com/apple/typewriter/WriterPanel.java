package com.apple.typewriter;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * 打字游戏界面类
 * @author Mark
 * 
 *
 */
public class WriterPanel extends JPanel implements KeyListener
{
	BufferedImage back;//背景图
	BufferedImage num0;
	BufferedImage num1;
	BufferedImage num2;
	BufferedImage num3;
	BufferedImage num4;
	BufferedImage num5;
	BufferedImage num6;
	BufferedImage num7;
	BufferedImage num8;
	BufferedImage num9;
	// ArrayList<String> images = new ArrayList<String>();
	
	ArrayList<Letter> letters = new ArrayList<Letter>();
	
	BufferedImage[] scores;
	
	
		// ImageIO.read(getClass().getResource("/images/0.png"));
	
	
	
	
	WriterPanel() throws IOException{//构造器
		back = ImageIO.read(getClass().getResource("/images/bg.jpg"));
		scores = new BufferedImage[10];
		for(int i=0;i<10;++i)
		{
			scores[i] = ImageIO.read(getClass().getResource("/images/" + i + ".png"));
		}//存入分数图片
		                           
		                           
/*		num0 = ImageIO.read(getClass().getResource("/images/0.png"));
		num1 = ImageIO.read(getClass().getResource("/images/1.png"));
		num2 = ImageIO.read(getClass().getResource("/images/2.png"));
		num3 = ImageIO.read(getClass().getResource("/images/3.png"));
		num4 = ImageIO.read(getClass().getResource("/images/4.png"));
		num5 = ImageIO.read(getClass().getResource("/images/5.png"));
		num6 = ImageIO.read(getClass().getResource("/images/6.png"));
		num7 = ImageIO.read(getClass().getResource("/images/7.png"));
		num8 = ImageIO.read(getClass().getResource("/images/8.png"));
		num9 = ImageIO.read(getClass().getResource("/images/9.png"));*/
		for(int i=0;i<10;i++)
		{
			String imageName = "/images/"+i+".png";
		}
		
		
		
		for(int i=0; i<5;i++)
		{
			Letter letter = new Letter();
			letters.add(letter);
		}
		
		
		
	}
	
	@Override
	public void paint(Graphics g) 
	{
		g.drawImage(back,-500,-627,this);

		/*
		for(String name : imageName)
		{
			g.drawImage(letter.image,letter.x,letter.y,this);
		}
		*/
/*		
		g.drawImage(num0,50,0,this);
		g.drawImage(num1,100,0,this);
		g.drawImage(num2,150,0,this);
		g.drawImage(num3,200,0,this);
		g.drawImage(num4,250,0,this);
		g.drawImage(num5,300,0,this);
		g.drawImage(num6,350,0,this);
		g.drawImage(num7,400,0,this);
		g.drawImage(num8,450,0,this);
		g.drawImage(num9,500,0,this);*/
		

		
		//绘制随机字母
		for(Letter letter : letters)
		{
			g.drawImage(letter.image,letter.x,letter.y,this);
		}

		
		if(Global.score <=9)
		{
			g.drawImage(scores[Global.score],900,10,this);
		}
		else if(Global.score <100)
		{
			g.drawImage(scores[Global.score/10],860,10,this);
			g.drawImage(scores[Global.score%10],900,10,this);
		}
		else if(Global.score<1000)
		{
			g.drawImage(scores[Global.score/100],820,10,this);
			g.drawImage(scores[(Global.score%100)/10],860,10,this);
			g.drawImage(scores[Global.score%10],900,10,this);
		}
		
	}
	
	void start() throws InterruptedException
	{
		//1.定义键盘监听事件
		
		
		
		while(true)
		{//死循环，字母不停地向下掉落
			
			for(Letter letter : letters)
			{
				letter.move();
			}
			
			//给定字母下降的间隔时间
			Thread.sleep(20);//毫秒为单位的ms
			repaint();
			
		}
	}
	
	public static void main(String[] args) throws IOException, InterruptedException {
		JFrame frame = new JFrame("打字游戏");
		WriterPanel panel = new WriterPanel();
		
		frame.add(panel);
		frame.setSize(960, 600);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//注册键盘事件
		panel.addKeyListener(panel);
		frame.addKeyListener(panel);
		
		panel.start();
	}

/*	添加注释的快捷键是control+shift+/
 * public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		// System.out.println("pressed "+ e.getKeyChar());
		char pressedKey = e.getKeyChar();
		
		for(int i=0;i<20;i++)
		{
			if(letters.get(i).name.equalsIgnoreCase(pressedKey+".png"))
			{
				try {
					Letter letter = letters.get(i).init();
					letters.remove(i);
					letters.add(letter);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		}

	}
	*/

	
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public void keyPressed(KeyEvent key)
	{
		char ch = key.getKeyChar();
		int yy=-1,index=-1; // yy表示最下面那个字母的坐标，index表示最下面那个字母的index
		
		for(int i=0;i<letters.size();i++)
		{
			String name = letters.get(i).name;
			
			if(name.equalsIgnoreCase(ch+".png"))
			{
				if(yy < letters.get(i).y)
				{
					yy = letters.get(i).y;
					index = i;
				}
			}
		}
		
		if(index>-1)
		{
			//加分
			Global.score +=5;
			try 
			{
				Letter letter = letters.get(index).init();
				letters.remove(index);
				repaint();
				letters.add(letter);
			}
			catch (Exception e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}

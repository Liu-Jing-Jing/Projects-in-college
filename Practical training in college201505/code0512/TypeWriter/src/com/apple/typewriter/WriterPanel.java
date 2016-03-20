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
 * ������Ϸ������
 * @author Mark
 * 
 *
 */
public class WriterPanel extends JPanel implements KeyListener
{
	BufferedImage back;//����ͼ
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
	
	
	
	
	WriterPanel() throws IOException{//������
		back = ImageIO.read(getClass().getResource("/images/bg.jpg"));
		scores = new BufferedImage[10];
		for(int i=0;i<10;++i)
		{
			scores[i] = ImageIO.read(getClass().getResource("/images/" + i + ".png"));
		}//�������ͼƬ
		                           
		                           
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
		

		
		//���������ĸ
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
		//1.������̼����¼�
		
		
		
		while(true)
		{//��ѭ������ĸ��ͣ�����µ���
			
			for(Letter letter : letters)
			{
				letter.move();
			}
			
			//������ĸ�½��ļ��ʱ��
			Thread.sleep(20);//����Ϊ��λ��ms
			repaint();
			
		}
	}
	
	public static void main(String[] args) throws IOException, InterruptedException {
		JFrame frame = new JFrame("������Ϸ");
		WriterPanel panel = new WriterPanel();
		
		frame.add(panel);
		frame.setSize(960, 600);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//ע������¼�
		panel.addKeyListener(panel);
		frame.addKeyListener(panel);
		
		panel.start();
	}

/*	���ע�͵Ŀ�ݼ���control+shift+/
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
		int yy=-1,index=-1; // yy��ʾ�������Ǹ���ĸ�����꣬index��ʾ�������Ǹ���ĸ��index
		
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
			//�ӷ�
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

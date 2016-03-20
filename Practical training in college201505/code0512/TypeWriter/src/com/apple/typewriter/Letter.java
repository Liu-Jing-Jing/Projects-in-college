package com.apple.typewriter;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;


public class Letter 
{
	BufferedImage image;
	int x,y;//����
	int width,height;//���
	String name;//��ĸ������
	
	int speed;	//��ĸ������ٶ�
	Random r = new Random();

	
	
	
	public Letter(BufferedImage image, int x, int y, int width, int height,
			String name, int speed) 
	{	//�в����Ĺ��췽��
		super();
		this.image = image;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.name = name;
		this.speed = speed;
	}

	public Letter() throws IOException 
	{	//�޲����Ĺ��췽��
		super();
		
		init();
		
	}
	
	
	Letter init() throws IOException
	{
		name = Character.toString((char)(r.nextInt(26) +'a'));
		//name = (String)(r.nextInt(10)+"");
		name = name + ".png"; //ͼƬ����������
		image = ImageIO.read(getClass().getResource("/images/"+name));
		
		width = image.getWidth();
		height = image.getHeight();
		x = r.nextInt(960-width);
		y = -height;
		// y = r.nextInt(600-height);
		speed = r.nextInt(5) + 1;
		
		
		
		return new Letter(image,x,y,width,height,name,speed);
	}
	
	
	//XLS��ĸ������
	void move()
	{
		y+=speed;
		
		if(y > 600)
		{
			if(Global.score > 0)
			{
				Global.score --;
			}
			else if(Global.score <=0) 
			{
				JOptionPane.showMessageDialog(null, "Game Over !");
				System.exit(0);
			}
			
				
			x = r.nextInt(960-width);
			y = -height;
			speed = r.nextInt(5)+1;
		}
	}
}

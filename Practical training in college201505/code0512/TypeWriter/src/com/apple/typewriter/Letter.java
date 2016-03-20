package com.apple.typewriter;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;


public class Letter 
{
	BufferedImage image;
	int x,y;//坐标
	int width,height;//宽高
	String name;//字母的名字
	
	int speed;	//字母下落的速度
	Random r = new Random();

	
	
	
	public Letter(BufferedImage image, int x, int y, int width, int height,
			String name, int speed) 
	{	//有参数的构造方法
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
	{	//无参数的构造方法
		super();
		
		init();
		
	}
	
	
	Letter init() throws IOException
	{
		name = Character.toString((char)(r.nextInt(26) +'a'));
		//name = (String)(r.nextInt(10)+"");
		name = name + ".png"; //图片的完整名称
		image = ImageIO.read(getClass().getResource("/images/"+name));
		
		width = image.getWidth();
		height = image.getHeight();
		x = r.nextInt(960-width);
		y = -height;
		// y = r.nextInt(600-height);
		speed = r.nextInt(5) + 1;
		
		
		
		return new Letter(image,x,y,width,height,name,speed);
	}
	
	
	//XLS字母的下落
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

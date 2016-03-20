package com.apple.plane;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Bullet 
{
    BufferedImage image;//子弹图片
    int x; //子弹X坐标
    int y; //子弹Y坐标
    int width; //子弹宽度
    int height; //子弹高度
    int speed; //子弹移动的速度
    
    
    
    Bullet(int x,int y) throws IOException
    {
    	image = ImageIO.read(getClass().getResource("/images/bullet.png"));
		width = image.getWidth();
		height = image.getHeight();
		
		this.x = x;
		this.y =y;
		speed = 5;
    }
    
	//子弹移动
	void move()
	{
		y -= speed;
	}
	
	
	void init()
	{//子弹销毁
		y = -height;
	}
    
}

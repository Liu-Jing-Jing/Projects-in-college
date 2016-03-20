package com.apple.plane;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class Hero {
	BufferedImage[] images;//英雄机状态
	BufferedImage image; //英雄机当前状态
	int x; //英雄机中心点X坐标
	int y; //英雄机中心点Y坐标
	int width;//英雄机宽度
	int height;//英雄机高度
	int life;//生命值
	int index; //标识当前英雄机状态的下标
	ArrayList<Bullet> bullets;
	
	
	
	Hero() throws IOException
	{
		images = new BufferedImage[2];
		for (int i = 0; i < images.length; i++) 
		{
			images[i] = ImageIO.read(getClass().getResource("/images/hero"+i+".png"));
			
		}
		
		image = images[0];
		width = image.getWidth();
		height = image.getHeight();
		x = 200;
		y = 600;
		index = 0;
		life = 5;
		bullets = new ArrayList<Bullet>();
		
		
	}
	
	
	
	//状态的切换
	void anim()
	{
		image = images[(index++)/8%2];
	}
	
	  
	//英雄机移动
	void moveTo(int x, int y)
	{
		this.x = x; //this代表当前对象
		this.y = y;
	}
	
	ArrayList<Bullet> shoot() throws IOException
	{
		Bullet bullet = new Bullet(x,y-height/2);
		bullets.add(bullet);
		Bullet bullet1 = new Bullet(x-20,y-height/2);
		bullets.add(bullet1);
		Bullet bullet2 = new Bullet(x+20,y-height/2);
		bullets.add(bullet2);
		
		return bullets;
	}	
	
	void moveToKeyLeft()
	{
		this.x-= 50;
	}
	
	void moveToKeyRight()
	{
		this.x+= 50;
	}

	void moveToKeyUp()
	{
		this.y-= 50;
	}
	
	void moveToKeyDown()
	{
		this.y+= 50;
	}	
	
	
	//是否被敌机撞到?
	boolean crash(Enemy enemy)
	{
		int x1 = enemy.x - width/2;
		int x2 = enemy.x + enemy.width + width/2;
		int y1 = enemy.y - height/2;
		int y2 = enemy.y + enemy.height + height/2;
		
		
		
		return (x > x1 && x < x2)
			&& (y > y1 && y <y2);
	}
	
	
	  
}

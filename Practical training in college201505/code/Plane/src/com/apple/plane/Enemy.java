package com.apple.plane;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

/**
 * 飞机大战
 *     -敌机类
 * @author Mark
 *
 */
public class Enemy {
	BufferedImage image;//敌机图片
	int x;//敌机x坐标
	int y;//敌机y坐标
	int width;//敌机宽度
	int height;//敌机高度
	int speed;//敌机下落的速度
	Random random = new Random();//随机数生产类
	
	Enemy() throws IOException{//构造器，初始化属性
		image = ImageIO.read(getClass().
				  getResource("/images/airplane.png"));

		width = image.getWidth();//获取敌机宽度
		height = image.getHeight();//获取敌机高度
		
		init();
	}
	
	//敌机初始化
	void init(){
		x = random.nextInt(400-width);//敌机随机x坐标
		y = -height;
		speed = random.nextInt(3)+1;//敌机随机速度
	}
	
	//敌机下落
	void move(){
		y += speed;
		if(y > 654){
			init();
		}
	}
	
	
	// 敌人是否被子弹射中
    boolean shootBy(Bullet bullet)
    {
    	int bx = bullet.x;
    	int by = bullet.y;
    	
    	
		return (bx > x && bx <x+width) &&
			   (by > y && by <y+height);
    }
	
}













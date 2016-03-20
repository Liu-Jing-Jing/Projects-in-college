package com.apple.plane;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Bullet 
{
    BufferedImage image;//�ӵ�ͼƬ
    int x; //�ӵ�X����
    int y; //�ӵ�Y����
    int width; //�ӵ����
    int height; //�ӵ��߶�
    int speed; //�ӵ��ƶ����ٶ�
    
    
    
    Bullet(int x,int y) throws IOException
    {
    	image = ImageIO.read(getClass().getResource("/images/bullet.png"));
		width = image.getWidth();
		height = image.getHeight();
		
		this.x = x;
		this.y =y;
		speed = 5;
    }
    
	//�ӵ��ƶ�
	void move()
	{
		y -= speed;
	}
	
	
	void init()
	{//�ӵ�����
		y = -height;
	}
    
}

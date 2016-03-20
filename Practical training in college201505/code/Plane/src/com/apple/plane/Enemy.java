package com.apple.plane;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

/**
 * �ɻ���ս
 *     -�л���
 * @author Mark
 *
 */
public class Enemy {
	BufferedImage image;//�л�ͼƬ
	int x;//�л�x����
	int y;//�л�y����
	int width;//�л����
	int height;//�л��߶�
	int speed;//�л�������ٶ�
	Random random = new Random();//�����������
	
	Enemy() throws IOException{//����������ʼ������
		image = ImageIO.read(getClass().
				  getResource("/images/airplane.png"));

		width = image.getWidth();//��ȡ�л����
		height = image.getHeight();//��ȡ�л��߶�
		
		init();
	}
	
	//�л���ʼ��
	void init(){
		x = random.nextInt(400-width);//�л����x����
		y = -height;
		speed = random.nextInt(3)+1;//�л�����ٶ�
	}
	
	//�л�����
	void move(){
		y += speed;
		if(y > 654){
			init();
		}
	}
	
	
	// �����Ƿ��ӵ�����
    boolean shootBy(Bullet bullet)
    {
    	int bx = bullet.x;
    	int by = bullet.y;
    	
    	
		return (bx > x && bx <x+width) &&
			   (by > y && by <y+height);
    }
	
}













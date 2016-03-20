package com.apple.plane;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
/**
 * 飞机大战
 *     -游戏界面类
 * @author Mark
 *
 */
public class PlanePanel extends JPanel implements KeyListener{
	BufferedImage back;//游戏背景图
	
	Enemy[] enemies;//N架敌机
	Hero hero;
	ArrayList<Bullet> bullets;
	int index;
	int state; //游戏不同的运行状态
	
	BufferedImage startImage;
	BufferedImage pauseImage;
	BufferedImage overImage;
	
	              
	PlanePanel() throws IOException{//构造器，初始化属性
		back = ImageIO.read(getClass().
				getResource("/images/background.png"));
		
		initEnemy();//调用敌机初始化方法
		hero = new Hero(); //创建一架英雄机
		
		bullets = new ArrayList<Bullet>();
		state = Global.START;
		
		startImage = ImageIO.read(getClass().getResource("/images/start.png"));
		pauseImage = ImageIO.read(getClass().getResource("/images/pause.png"));
		overImage =  ImageIO.read(getClass().getResource("/images/gameover.png"));
		
	}
	
	//初始化敌机
	void initEnemy() throws IOException{
		enemies = new Enemy[5];//5架敌机
		for(int i=0; i<5; i++){
			enemies[i] = new Enemy();//依次创建敌机
		}
	}
	
	
	@Override
	public void paint(Graphics g) {
		//绘制游戏背景
		g.drawImage(back,0,0,this);
		//绘制敌机
		for(Enemy enemy : enemies){
			g.drawImage(enemy.image,enemy.x,enemy.y,this);
		}
		
		//绘制英雄机
		g.drawImage(hero.image,hero.x-(hero.width/2),(hero.y-hero.height/2),this);
		
		for (Bullet bullet : bullets) 
		{
			g.drawImage(bullet.image,bullet.x,bullet.y,this);
			g.drawImage(bullet.image,bullet.x-20,bullet.y,this);
			g.drawImage(bullet.image,bullet.x+20,bullet.y,this);
		}
		
		//绘制游戏不同状态的背景图片
		switch(state)
		{
			case Global.START:
				g.drawImage(startImage,0,0,this);
				break;
			case Global.PAUSE:
				g.drawImage(pauseImage,0,0,this);
				break;
			case Global.OVER:
				g.drawImage(overImage,0,0,this);
				break;
			default:
				break;
		}
		
		
		
		g.drawString("生命值："+hero.life, 20, 20);
	}
	
	//开启游戏
	void action() throws InterruptedException
	{
		/*KeyAdapter kListener = new KeyAdapter()
		{

			@Override
			public void keyPressed(KeyEvent e) 
			{
				System.out.println("test");
				super.keyPressed(e);
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				super.keyReleased(e);
			}
			
		};
		addKeyListener(kListener);*/
		
		
		
		MouseAdapter listener = new MouseAdapter()
		{

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				if(state == Global.START)
				{
					state = Global.RUNNING;
				}
			}

			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseDragged(e);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				if(state == Global.PAUSE)
				{
					state = Global.RUNNING;
				}
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if(state != Global.OVER)
				{
					state = Global.PAUSE;
				}
			}

			@Override
			public void mouseMoved(MouseEvent e)
			{
				//System.out.println("move~~");
				int x = e.getX();
				int y = e.getY();
				try {
					hero.moveTo(x,y);//英雄机移动
					if((index++)%20==0){
						bullets = hero.shoot();
					}
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
				
				hero.moveTo(x,y);
			}//MouseAdapter定义的结束
			
			@Override
		    public void mousePressed(MouseEvent e) 
		    {
				//System.out.println("haha");
				try {
					if((index++)%10==0){
						bullets = hero.shoot();
					}
				} catch (IOException e1) {
					e1.printStackTrace();
				}
		    }

		};
		//2.注册MouseAdapter鼠标监听事件
		addMouseListener(listener);
		addMouseMotionListener(listener);
		
		//if (state == Global.RUNNING) 
		{
			while (true) {//死循环
				for (Enemy enemy : enemies) {
					enemy.move();//敌机下落
				}

				hero.anim();

				for (Bullet bullet : bullets) {
					bullet.move();
					// 检查敌机是否被击中
					explode(bullet);
				}

				try {
					if((index++)%50==0) bullets = hero.shoot();
				} catch (IOException e1) {
					e1.printStackTrace();
				}

				
				if(isGameOver())
				{
					state = Global.OVER;
				}
				
				Thread.sleep(20);//时间间隔20ms
				repaint(); //重新绘图
			}
		}
	}// action方法结束
	
	
	// 敌机销毁
	void explode(Bullet bullet)
	{
		int j = -1;
		for (int i = 0; i < enemies.length; i++) 
		{
			Enemy enemy = enemies[i];
			if(enemy.shootBy(bullet))
			{
				j= i;
				break;
			}
		}
		
		if(j > -1)
		{
			Enemy enemy = enemies[j];
			enemy.init();
			bullet.init(); //子弹销毁
		}
	}//explode方法结束
	
	boolean isGameOver()
	{
		for (int i = 0; i < enemies.length; i++) 
		{
			int j = -1;
			Enemy enemy = enemies[i];
			if(hero.crash(enemy))
			{
				j = 1;
			}
			
			if(j > -1)
			{
				hero.life--;
				Enemy en = enemies[j];
				en.init();
				j=-1;
			}
			
		}
		
		return hero.life <=0;
	}

	@Override
	public void keyPressed(KeyEvent e) 
	{
		try {
			if((index++)%3==0) bullets = hero.shoot();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		int ch = e.getKeyCode();
		if(ch == KeyEvent.VK_A || ch == 37 )
		{
			System.out.println("-----");
			hero.moveToKeyLeft();
		}
		else if(ch == KeyEvent.VK_D || ch == 39)
		{
			hero.moveToKeyRight();
		}
		else if(ch == KeyEvent.VK_W || ch == 38)
		{
			hero.moveToKeyUp();
		}
		else if(ch == KeyEvent.VK_S || ch == 40)
		{
			hero.moveToKeyDown();
		}
		


		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}
















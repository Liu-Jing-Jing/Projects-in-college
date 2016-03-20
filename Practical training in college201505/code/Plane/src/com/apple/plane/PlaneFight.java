package com.apple.plane;

import java.io.IOException;

import javax.swing.JFrame;


/**
 * 飞机大战
 *     -主启动类
 * @author Mark
 *
 */
public class PlaneFight
{
	public static void main(String[] args) throws IOException, InterruptedException  
	{
		//1. 组装游戏
		JFrame frame = new JFrame("飞机大战");
		PlanePanel panel = new PlanePanel();
		
		frame.add(panel);//窗口添加游戏界面
		frame.setSize(400,654);//大小
		frame.setVisible(true);//可见
		frame.setLocationRelativeTo(null);//居中
		frame.setResizable(false);//大小不可变
		frame.setDefaultCloseOperation(
				               JFrame.EXIT_ON_CLOSE);
		
		//注册键盘的
		frame.addKeyListener(panel);
		panel.addKeyListener(panel);

		//2. 启动游戏
		panel.action();
		

	}


}

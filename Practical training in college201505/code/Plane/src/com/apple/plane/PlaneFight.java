package com.apple.plane;

import java.io.IOException;

import javax.swing.JFrame;


/**
 * �ɻ���ս
 *     -��������
 * @author Mark
 *
 */
public class PlaneFight
{
	public static void main(String[] args) throws IOException, InterruptedException  
	{
		//1. ��װ��Ϸ
		JFrame frame = new JFrame("�ɻ���ս");
		PlanePanel panel = new PlanePanel();
		
		frame.add(panel);//���������Ϸ����
		frame.setSize(400,654);//��С
		frame.setVisible(true);//�ɼ�
		frame.setLocationRelativeTo(null);//����
		frame.setResizable(false);//��С���ɱ�
		frame.setDefaultCloseOperation(
				               JFrame.EXIT_ON_CLOSE);
		
		//ע����̵�
		frame.addKeyListener(panel);
		panel.addKeyListener(panel);

		//2. ������Ϸ
		panel.action();
		

	}


}

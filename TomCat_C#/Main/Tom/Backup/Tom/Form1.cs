using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using System.Threading;

namespace Tom
{
    public partial class Form1 : Form
    {

        Image[] angryImages;
        Image[] cymbalImages;
        Image[] drinkImages;
        Image[] eatImages;
        Image[] knockoutImages;
        Image[] fartImages;



        public Form1()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            //初始化实例变量
            angryImages = new Image[26];
            for(int i=0; i<angryImages.Length;++i)
            {
                angryImages[i] = Image.FromFile("C:\\Documents and Settings\\Administrator\\桌面\\Resource\\Animations\\angry\\angry_"+i+".jpg");
                Console.WriteLine("读取图片成功！");
            }

            cymbalImages  = new Image[13];
            for (int i = 0; i < cymbalImages.Length; ++i)
            {
                cymbalImages[i] = Image.FromFile("C:\\Documents and Settings\\Administrator\\桌面\\Resource\\Animations\\cymbal\\cymbal_" + i + ".jpg");
            }

            drinkImages = new Image[81];
            eatImages = new Image[40];
            knockoutImages = new Image[81];
            fartImages = new Image[28];

        }


        int x, y;
        private void pictureBox1_MouseMove(object sender, MouseEventArgs e)
        {
            x = e.X;
            y = e.Y;
            this.Text = string.Format("Tom    " + "坐标:({0},{1})", x, y);
        }
        private void pictureBox1_Click(object sender, EventArgs e)
        {
            if(x>=216 && x<=235)
            {
                if (y>=383 && y<=415)
                {
                    Console.WriteLine("点击了尾巴");
                    int i = 0;
                    foreach (Image image in angryImages)
                    {
                        Thread.Sleep(50);
                        Console.WriteLine(i++);

                    }
                    Console.WriteLine("test");
                }
                
            }
        }

    }
}

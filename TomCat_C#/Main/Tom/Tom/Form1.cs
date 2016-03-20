using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;
// using System.Threading;

namespace Tom
{
    public partial class Form1 : Form
    {
        Timer t1;

        Image[] angryImages;
        Image[] cymbalImages;
        //Image[] drinkImages;
        //Image[] eatImages;
        Image[] knockoutImages;
        //Image[] fartImages;
        //Image[] foot_leftImages;
        //Image[] foot_rightImages;
        Image[] scratchImages;


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

            knockoutImages = new Image[81];
            for (int i = 0; i < knockoutImages.Length; ++i)
            {
                knockoutImages[i] = Image.FromFile("C:\\Documents and Settings\\Administrator\\桌面\\Resource\\Animations\\knockout\\knockout_" + i + ".jpg");
            }


            /*
            foot_leftImages = new Image[30];
            for (int i = 0; i < foot_leftImages.Length; ++i)
            {
                // foot_leftImages[i] = Image.FromFile("C:\\Documents and Settings\\Administrator\\桌面\\Resource\\Animations\\footleft\\foot_left_" + i + ".jpg");
            }
            foot_rightImages = new Image[30];
            for (int i = 0; i < foot_rightImages.Length; ++i)
            {
                // foot_rightImages[i] = Image.FromFile("C:\\Documents and Settings\\Administrator\\桌面\\Resource\\Animations\\footright\\foot_right_" + i + ".jpg");
            }
             */


            scratchImages = new Image[56];
            for (int i = 0; i < scratchImages.Length; ++i)
            {
                scratchImages[i] = Image.FromFile("C:\\Documents and Settings\\Administrator\\桌面\\Resource\\Animations\\scratch\\scratch_" + i + ".jpg");
            }
            
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
            t1 = new Timer();
            t1.Interval = 40;



            if(x>=216 && x<=235)
            {
                if (y>=383 && y<=415)
                {
                    Console.WriteLine("点击了尾巴");
                    t1.Tick += new EventHandler(changeAngrty);
                    t1.Start();
                }
                
            }


            if (x >= 100 && x <= 220)
            {
                if (y >= 100 && y <= 270)
                {
                    t1.Tick+=new EventHandler(changeHead);
                    Console.WriteLine("点击了头部");
                    t1.Start();
                }

            }

            if (x >= 90 && x <= 105)
            {
                if (y >= 275 && y <= 300)
                {
                    t1.Tick += new EventHandler(changeLeftHand);
                    Console.WriteLine("点击了Tom的右手");
                    t1.Start();
                }

            }
        }

        static int index1 = 0;
        public void changeAngrty(object sender, EventArgs e)
        {
            if (index1 < angryImages.Length)
            {
                pictureBox1.Image = angryImages[index1++];
            }
            else
            {
                index1 = 0;
                t1.Stop();
            }
        }

        static int index2 = 0;
        public void changeHead(object sender, EventArgs e)
        {
            if (index2 < knockoutImages.Length)
            {
                pictureBox1.Image = knockoutImages[index2++];
            }
            else
            {
                index2 = 0;
                t1.Stop();
            }
        }


        static int index3 = 0;
        public void changeLeftHand(object sender, EventArgs e)
        {
            if (index3 < scratchImages.Length)
            {
                pictureBox1.Image = scratchImages[index3++];
            }
            else
            {
                index3 = 0;
                t1.Stop();
            }
        }

    }
}

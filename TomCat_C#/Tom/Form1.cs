using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;

namespace Tom
{
    public partial class Form1 : Form
    {
        Image[] images;
        

        public Form1()
        {
            InitializeComponent();
            images = new Image[100];
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            for(int i=0;i<=80;i++)
            {
                images[i] = Image.FromFile("C:\\Resource\\Animations\\drink\\drink_" +i+".jpg");
            }

            pictureBox1.Image = images[0];
        }

        static int index = 0;
        private void pictureBox1_Click(object sender, EventArgs e)
        {
            pictureBox1.Image = images[index++%80];
        }

        static int x = 0;
        private void Form1_MouseMove(object sender, MouseEventArgs e)
        {
            
            x = e.X;
            pictureBox1.Image = images[x % 80];
            x++;
        }
    }
}

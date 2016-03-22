using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;

namespace Calculator
{
    public partial class Form2 : Form
    {
        public Form2()
        {
            InitializeComponent();
            this.StartPosition = FormStartPosition.CenterScreen;
            this.MaximizeBox = false;
        }

        private void button1_Click(object sender, EventArgs e)
        {

            double a = 0, b = 0, c = 0;
            if (textBox1.Text.Length > 0) a = double.Parse(textBox1.Text);
            if (textBox2.Text.Length > 0) b = double.Parse(textBox2.Text);
            if (textBox3.Text.Length > 0) c = double.Parse(textBox3.Text);


            try
            {
                if (textBox1.Text.Length > 0 && textBox2.Text.Length > 0 && textBox3.Text.Length > 0)
                {
                    double delta = b * b - 4 * a * c;
                    string resultContent = string.Format("方程的Delta = " + delta);

                    if (delta > 0) resultContent += "\n有两个实数根";
                    if (delta == 0) resultContent += "\n有一个实数根";
                    if (delta < 0) resultContent += "\n无个实数根";


                    double x1 = (-b + System.Math.Sqrt(delta)) / (2 * a);
                    double x2 = (-b - System.Math.Sqrt(delta)) / (2 * a);
                    resultContent += string.Format("\n两根之和：X1 + X2 = {0}", (x1 + x2));
                    resultContent += string.Format("\n两根之积：X1 * X2 = {0}", (x1 * x2));

                    resultContent += string.Format("\nX1 = {0}", x1);
                    resultContent += string.Format("\nX2 = {0}", x2);

                    richTextBox1.Text = resultContent;
                }
                else
                {
                    MessageBox.Show("3个文本框都必须输入数字", "错误警告",0,MessageBoxIcon.Error);
                }
            }

            catch (Exception ex)
            {
                MessageBox.Show(ex.Message, "错误警告",0,MessageBoxIcon.Error);
            }
        }
    }
}

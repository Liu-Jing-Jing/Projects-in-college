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
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
            this.StartPosition = FormStartPosition.CenterScreen;
            label2.Text = "Copyright by 网络1405-刘竞";

            string label1Text = "";
            for (int i = 0; i < 8; ++i)
            {
                label1Text = string.Format(label1Text + "0000 ");

            }
            label1.Text = label1Text;

        }


        
        static string contentA;
        static string contentB;

        static bool flag=false;//标记是否点击了运算符按钮
        static string notation; // 记录运算符符号
        private void buttonPressed(string num)
        {
            if (!flag)
            {
                contentA = string.Format(contentA + num);
                textBox1.Text = contentA;
                label1.Text = printBinary(int.Parse(textBox1.Text));
            }
            else
            {
                contentB = string.Format(contentB + num);
                textBox1.Text = contentB;
            }
        }


        // 返回二进制格式的算法，封装为函数
        private string printBinary(int n)
        {
            //int temp = sizeof(int) << 3 - 1;
            int temp = 31;
            string result = "";
            while (temp >= 0)
            {
                int value = n >> temp & 1;
                result =string.Format(result+value);

                temp--;

                if ((temp + 1) % 4 == 0)
                {
                    result = string.Format(result + " ");
                }
            }
            result = string.Format(result + "\n");


            return result;
        }

        #region 数字和清除按钮事件处理代码
         
        private void button1_Click(object sender, EventArgs e)
        {
            buttonPressed(button1.Text);
        }

        private void button2_Click(object sender, EventArgs e)
        {
            buttonPressed(button2.Text);
        }

        private void button3_Click(object sender, EventArgs e)
        {
            buttonPressed(button3.Text);
        }

        private void button4_Click(object sender, EventArgs e)
        {
            buttonPressed(button4.Text);
        }

        private void button5_Click(object sender, EventArgs e)
        {
            buttonPressed(button5.Text);
        }

        private void button6_Click(object sender, EventArgs e)
        {
            buttonPressed(button6.Text);
        }

        private void button7_Click(object sender, EventArgs e)
        {
            buttonPressed(button7.Text);
        }

        private void button8_Click(object sender, EventArgs e)
        {
            buttonPressed(button8.Text);
        }

        private void button9_Click(object sender, EventArgs e)
        {
            buttonPressed(button9.Text);
        }

        private void button0_Click(object sender, EventArgs e)
        {
            buttonPressed(button0.Text);
        }

        private void button10_Click(object sender, EventArgs e)
        {
            contentA = "";
            textBox1.Text = contentA;


            // Label的值复位
            string label1Text = "";
            for (int i = 0; i < 8; ++i)
            {
                label1Text = string.Format(label1Text + "0000 ");

            }
            label1.Text = label1Text;


            buttonAdd.BackColor = System.Drawing.Color.White;
            buttonMinus.BackColor = System.Drawing.Color.White;
            buttonMultiply.BackColor = System.Drawing.Color.White;
            buttonDivide.BackColor = System.Drawing.Color.White;
        }



        private void label1_Click(object sender, EventArgs e)
        {

        }
#endregion




        private void buttonAdd_Click(object sender, EventArgs e)
        {
            isNotationFunc(buttonAdd.Text);
            buttonAdd.BackColor = System.Drawing.Color.Gray;
        }

        private void buttonMinus_Click(object sender, EventArgs e)
        {
            isNotationFunc(buttonMinus.Text);
            buttonMinus.BackColor = System.Drawing.Color.Gray;
        }

        private void buttonMultiply_Click(object sender, EventArgs e)
        {
            isNotationFunc(buttonMultiply.Text);
            buttonMultiply.BackColor = System.Drawing.Color.Gray;
        }

        private void buttonDivide_Click(object sender, EventArgs e)
        {
            isNotationFunc(buttonDivide.Text);
            buttonDivide.BackColor = System.Drawing.Color.Gray;
        }


        // 判断运算符符号
        private void isNotationFunc(string f)
        {
            if (contentA == null)
            {
                MessageBox.Show("请输入正确的数字后，再选择运算符！\n运算符是："+notation);
            }
            else
            {
                flag = true;
                textBox1.Text = "";
                notation = f;

                //MessageBox.Show("运算符是：" + notation);
            }
        }



        private void calculateFunc(string num1, string num2)
        {
            string result = "";


            try
            {
                // 将字符串转换为数字，再运算
                int a = int.Parse(contentA);
                int b = int.Parse(contentB);


                switch (notation)
                {
                    case "+":
                        result = string.Format("{0} + {1} = {2}", a, b, a + b);
                        break;
                    case "-":
                        result = string.Format("{0} - {1} = {2}", a, b, a - b);
                        break;
                    case "*":
                        result = string.Format("{0} * {1} = {2}", a, b, a * b);
                        break;
                    case "/":
                        try
                        {
                            result = string.Format("{0} / {1} = {2}", a, b, (double)a / b);
                        }
                        catch (DivideByZeroException e)
                        {
                            MessageBox.Show("除数不能为0");
                            MessageBox.Show(e.Message);
                        }
                        break;
                    default:
                        MessageBox.Show(notation + "是非法算数运算符");
                        break;

                }

            }

            catch (Exception e)
            {
                MessageBox.Show(e.Message);
            }


            MessageBox.Show(result,"计算结果");
        }


        private void button11_Click(object sender, EventArgs e)
        {// 按下了等号按钮

            calculateFunc(contentA, contentB);


            // 复位
            flag = false;
            contentA = "";
            contentB = "";
            textBox1.Text = "";

            buttonAdd.BackColor = System.Drawing.Color.White;
            buttonMinus.BackColor = System.Drawing.Color.White;
            buttonMultiply.BackColor = System.Drawing.Color.White;
            buttonDivide.BackColor = System.Drawing.Color.White;
        }

        private void button12_Click(object sender, EventArgs e)
        {
            MessageBox.Show
                ("\n1.选择的运算符只能弹窗提示1下\n2.Binary Format只能显示第一个数字\n3.异常处理会重复弹窗提示\n4.按下等号按钮后，顶部的文本框不会立即清空\n5.计算完成后，直接按下数字按钮可以重新计算\n", "BUG List");
        }


        static int i = 0;
        private void button13_Click(object sender, EventArgs e)
        {
            if (i % 2 == 0)
            {
                Form2 f2 = new Form2();
                f2.Show();
            }
            else
            {
                System.Diagnostics.Process.Start("calc");
            }

            i++;
        }



        // 窗口加载方法
        private void Form1_Load(object sender, EventArgs e)
        {
            this.MaximizeBox = false; //禁用最大化按钮
            // this.StartPosition = FormStartPosition.CenterScreen; 
        }
    }
}

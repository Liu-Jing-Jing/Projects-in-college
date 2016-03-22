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
    public partial class WeiboDEMO : Form
    {
        public WeiboDEMO()
        {
            InitializeComponent();
            this.MaximizeBox = false;
            this.StartPosition = FormStartPosition.CenterScreen;
        }

        private void WeiboDEMO_Load(object sender, EventArgs e)
        {
            Uri url = new Uri("http://www.baidu.com");
            webBrowser1.Navigate(url);
        }

        private void webBrowser1_DocumentCompleted(object sender, WebBrowserDocumentCompletedEventArgs e)
        {

        }

        private void WeiboDEMO_KeyPress(object sender, KeyPressEventArgs e)
        {
            MessageBox.Show("Loading......");
            Uri url = new Uri("http://m.weibo.cn");
            webBrowser1.Navigate(url);
        }
    }
}

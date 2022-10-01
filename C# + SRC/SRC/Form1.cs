using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace WindowsFormsApp1
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void label1_Click(object sender, EventArgs e)
        {

        }

        private void Form1_Load(object sender, EventArgs e)
        {
        }

        private void checkBox1_CheckedChanged(object sender, EventArgs e)
        {

        }

        private void button1_Click(object sender, EventArgs e)
        {
            if (textBox1.Text.All(char.IsDigit) != true || (String.IsNullOrEmpty(textBox1.Text) == true))
            {
                MessageBox.Show("Only integer are accepted", "Error In Selecting the Length",
                        MessageBoxButtons.OK, MessageBoxIcon.Error);
            }
            else
            {
                List<string> test = Program.dictgenerator(checkBox1.Checked, checkBox2.Checked, checkBox3.Checked);
                textBox2.Text = Program.generator(test, int.Parse(textBox1.Text));
            }
        }

        private void textBox2_Click(object sender, EventArgs e)
        {
            if (String.IsNullOrEmpty(textBox2.Text)==false){
                System.Windows.Forms.Clipboard.SetText(textBox2.Text);
            }
        
        }
    }
}
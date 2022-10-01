using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace WindowsFormsApp1
{
    public static class Program
    {
        [STAThread]
        static void Main()
        {
            List<string> test = new List<string> { "1", "2", "3", "4" };
            Application.EnableVisualStyles();
            Application.SetCompatibleTextRenderingDefault(false);
            Application.Run(new Form1());
        }
        public static string generator(List<string> x, int o)
        {
            string otp = "";
            int length = x.Count;
            Random randomStep = new Random();
            for (int i = 0; i < o; i++)
            {
                otp += (x[randomStep.Next(length)]).ToString();
            }
            return otp;
        }

        public static List<string> dictgenerator(bool z, bool y, bool o)
        {
            List<string> L = new List<string> {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p",
                        "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
            if (z == true)
            {
                List<string> op1 = new List<string> { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z" };
                L.AddRange(op1);
            }
            if (y == true)
            {
                List<string> op2 = new List<string> { "1", "2", "3", "4", "5", "6", "7", "8", "9", "0" };
                L.AddRange(op2);
            }
            if (o == true)
            {
                List<string> op3 = new List<string> { "!", "#", "$", "%", "&", "*", "+", "-", ".", "/", ":", ";", "<", "=", ">", "@", "^", "_", "|", "~" };
                L.AddRange(op3);
            }
            return L;
        }
    }
}

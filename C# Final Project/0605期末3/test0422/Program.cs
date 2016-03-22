using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace test0422
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("2333");

            Console.WriteLine("\n解方程源代码");
            Console.WriteLine("输入a:");
            int a = int.Parse(Console.ReadLine());
            Console.WriteLine("输入b:");
            int b = int.Parse(Console.ReadLine());
            Console.WriteLine("输入c:");
            int c = int.Parse(Console.ReadLine());

            Console.WriteLine("{0}X^2 + {1}X + {2} = 0", a, b, c);
            double delta = b * b - 4 * a * c;

            Console.WriteLine("Delta = " + delta);
            if (delta > 0) Console.WriteLine("有两个实数根");
            if (delta == 0) Console.WriteLine("有一个实数根");
            if (delta < 0) Console.WriteLine("无实数根");


            double x1 = (-b + System.Math.Sqrt(delta)) / (2 * a);
            double x2 = (-b - System.Math.Sqrt(delta)) / (2 * a);
            Console.WriteLine("x1 = " + x1);
            Console.WriteLine("x2 = " + x2);
            Console.WriteLine();
            Console.ReadKey();
        }
    }
}

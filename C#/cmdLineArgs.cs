using System;

class cmdLineArgs {
    static void Main(string []args) {
        Console.WriteLine("Passed arguments are:");
        //foreach(object s in args) {
        foreach (string s in args) {
            Console.WriteLine(s);
        }
    }
}
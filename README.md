Overview
--------
This program generates a superpermutation sequence for a given set of n distinct symbols. 
It implements a custom construction algorithm described in the accompanying paper submitted to Algorithmica.

The output is written to a file named: superperm_n{n}.txt, where {n} is the number of input symbols.

Files
-----
- SuperpermAlgo.java : Java source file implementing the superpermutation generation algorithm.
- README.txt : This file, explaining how to compile, run, and use the code.

How to Compile and Run
----------------------
1. Ensure you have Java 8 or higher installed.

2. Open a terminal in the directory containing SuperpermAlgo.java.

3. Compile the program:
   javac SuperpermAlgo.java

4. Run the program:
   java SuperpermAlgo

5. When prompted, enter an integer n (e.g. 3, 4, 5,...). This represents the number of symbols.

6. The program will create a file named superperm_n{n}.txt in the same directory, 
   containing the generated superpermutation string


Example
-------
> javac SuperpermAlgo.java
> java SuperpermAlgo
Enter the number of symbols in integer format:
4


Output: superperm_n4.txt

Notes
-----
- Input must be an integer greater than 0.
- Output files will be overwritten if they already exist.
- Execution time will be printed to the console in milliseconds.


Contact
-------
For questions, contact: dhruvajmera0@gmail.com

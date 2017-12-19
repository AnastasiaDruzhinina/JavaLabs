package ru.spbstu.telematics.java;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

class Tests
{
    @Test
    public void Test1() throws IOException {
        File f1 = new File("testFile.txt");
        f1.createNewFile();
        MV.main(new String[] {f1.getPath(), "renamedTestFile.txt"});
        f1.delete();

        File f2 = new File("renamedTestFile.txt");

        if(f2.exists())
            System.out.println("File renamed. Test 1 passed.");
        else
            System.out.println("File don't renamed. Test 1 failed");

        f2.delete();
    }

    @Test
    public void Test2() throws IOException {
        File f1 = new File("testFile.txt");
        f1.createNewFile();
        MV.main(new String[] {f1.getPath(), "..\\"});
        f1.delete();

        File f2 = new File("..\\testFile.txt");

        if(f2.exists())
            System.out.println("File removed. Test 2 passed.");
        else
            System.out.println("File don't removed. Test 2 failed");

        f2.delete();
    }
}


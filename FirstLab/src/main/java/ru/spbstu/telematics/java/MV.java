package ru.spbstu.telematics.java;

import java.io.File;
import java.io.IOError;

public class MV
{
    public static void main(String[] args)
    {
        String destString = args[args.length - 1];

        File destFile = new File(destString);
        if (!destFile.isDirectory() && args.length > 2)
        {
            System.out.println("Неверные аргументы! Последний аргумент должен быть директорией");
            return;
        }

        try {
            if (destFile.isDirectory()) {
                for (int i = 0; i < args.length - 1; i++) {
                    File curFile = new File(args[i]);
                    curFile.renameTo(new File(destFile, curFile.getName()));
                }
            } else {
                {
                    File curFile = new File(args[0]);
                    boolean a = curFile.renameTo(destFile);
                    a=true;
                }
            }
        } catch (IOError a)
        {
            System.out.println("Неверный аргумент!");
        }
    }
}

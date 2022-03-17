package com.example.to_do_list.util;

import android.content.Context;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Persistence implements Serializable
{
    public static boolean readData(String fileName, Context context)
    {
        boolean success = false;
        try{
            FileInputStream fin = context.openFileInput(fileName);
            ObjectInput in = new ObjectInputStream(fin);
            Singleton.setNotes((Notes) in.readObject());
            success = true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return success;
    }

    public static boolean writeData(String fileName,Object object, Context context)
    {
        boolean success = false;
        try {
            FileOutputStream fout = context.openFileOutput(fileName, Context.MODE_PRIVATE);
            ObjectOutputStream out = new ObjectOutputStream(fout);
            out.writeObject(object);
            out.close();
            success = true;
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return success;
    }
}

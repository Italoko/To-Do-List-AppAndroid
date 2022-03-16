package com.example.to_do_list.util;

import android.provider.ContactsContract;

public class Singleton {
    static private Notes notes = new Notes();

    private Singleton(){}

    public static Notes getNotes(){return notes;}
    public static void setNotes(Notes note){notes = note;}
}

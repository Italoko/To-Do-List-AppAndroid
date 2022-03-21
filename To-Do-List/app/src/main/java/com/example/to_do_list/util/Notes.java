package com.example.to_do_list.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Notes implements Serializable {
    private List<Item> itens;

    public Notes() {
        itens=new ArrayList<Item>();
    }
    public void add(Item i)
    {
        i.setOrd(itens.size()+1);
        itens.add(i);
    }
    public boolean remove(int i)
    {
        if(i <= itens.size())
        {
            itens.remove(i);
            return true;
        }
        return false;
    }

    public List<Item> getItens() {
        return itens;
    }
}

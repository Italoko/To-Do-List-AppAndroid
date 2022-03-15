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
        itens.add(i);
    }

    public List<Item> getItens() {
        return itens;
    }
}
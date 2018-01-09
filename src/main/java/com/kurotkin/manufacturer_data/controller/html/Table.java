package com.kurotkin.manufacturer_data.controller.html;

import com.kurotkin.manufacturer_data.model.Manufacturer;

import java.util.List;

public class Table<T> {
    public String getTable(List<Manufacturer> list){
        String str = "";
        str += "<table border=\"1\">\n";

        str += "<tr>\n";
        str += "<td>" + "ID" + "</td>\n";
        str += "<td>" + "Name" + "</td>\n";
        str += "</tr>\n";

        for(int i = 0; i < list.size(); i++){
            str += "<tr>\n";
            str += "<td>" + list.get(i).getId() + "</td>\n";
            str += "<td>" + list.get(i).getName() + "</td>\n";
            str += "</tr>\n";
        }
        return str;
    }
}

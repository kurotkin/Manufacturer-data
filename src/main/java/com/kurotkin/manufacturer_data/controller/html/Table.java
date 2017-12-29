package com.kurotkin.manufacturer_data.controller.html;

import com.kurotkin.manufacturer_data.model.Manufacturer;

import java.util.List;

public class Table<T> {
    public String getTable(List<Manufacturer> list){
        String str = "";
        str.concat("<table border=\"1\">\n");

        str.concat("<tr>\n");
        str.concat("<td>" + "ID" + "</td>\n");
        str.concat("<td>" + "Name" + "</td>\n");
        str.concat("</tr>\n");

        for(int i = 0; i < list.size(); i++){
            str.concat("<tr>\n");
            str.concat("<td>" + list.get(i).getId() + "</td>\n");
            str.concat("<td>" + list.get(i).getName() + "</td>\n");
            str.concat("</tr>\n");
        }
        return str;
    }
}

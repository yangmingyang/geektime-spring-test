package com.megoai.controller;

import com.megoai.domain.Items;
import com.megoai.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/items")
public class ItemsController {
    @Autowired
    private ItemsService itemsService;

    @RequestMapping("/findById")
    public String findDetail(Model model){
        Items items = itemsService.findById(1);
        model.addAttribute("item",items);
        return "itemDetail";
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ru.ac.ugatu.asu.news;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author aleksandr
 */
@Controller
public class NewsController {
    @Autowired
    private NewsService newsManager;

    @RequestMapping("/")
    public String actionIndex(
            @RequestParam(value = "page", required = false, defaultValue = "1") Integer page, 
            Model model) {
        
        model.addAttribute("items", this.newsManager.getPagableResults(NewsItem.class.getName(), page));
        
        return "news/index";
    }
}

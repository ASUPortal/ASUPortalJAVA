/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ru.ac.ugatu.asu.news;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.ac.ugatu.asu.core.BaseService;

/**
 *
 * @author aleksandr
 */
@Component
public class NewsService extends BaseService {
    private final int PAGE_SIZE = 20;
    
    @Transactional(readOnly = true)
    public List getAllNews() {
        return this.getTemplate().find("from NewsItem");
    }
    
    public List<NewsItem> getNewsPage(int page) {
        return new ArrayList();
    }
}

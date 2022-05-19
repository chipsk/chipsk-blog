package com.shutiao.utils;

import com.shutiao.domain.entity.Article;
import com.shutiao.domain.vo.HotArticleVo;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BeanCopyUtils {

    private BeanCopyUtils() {

    }

    public static <V> V copyBean(Object source, Class<V> clazz) {
        //创建目标对象
        V result = null;
        try {
            result = clazz.newInstance();
            //实现属性copy
            BeanUtils.copyProperties(source, result);
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static <O,V> List<V> copyBeanList(List<O> list, Class<V> clazz) {
        return list.stream()
                .map(o -> copyBean(o, clazz))
                .collect(Collectors.toList());
    }


    public static void main(String[] args) {
        List<Article> articles = new ArrayList<>();
        Article article1 = new Article();
        article1.setId(1L);
        article1.setTitle("ss");
        articles.add(article1);
        System.out.println(articles);
        List<HotArticleVo> articleVos = copyBeanList(articles, HotArticleVo.class);
        System.out.println(articleVos);
    }
}

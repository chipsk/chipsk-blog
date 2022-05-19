package com.shutiao.constants;

public class SystemConstants {

    /**
     * 文章是草稿
     */
    public static final int ARTICLE_STATUS_DRAFT = 1;

    /**
     * 文章是正常发布状态
     */
    public static final int ARTICLE_STATUS_NORMAL = 0;

    /**
     * 文章分页当前页
     */
    public static final int ARTICLE_PAGE_CURRENT = 1;

    /**
     * 文章分页可显示页数
     */
    public static final int ARTICLE_PAGE_SIZE = 10;

    /**
     * 分类正常状态
     */
    public static final String Category_STATUS_NORMAL = "0";

    /**
     * 友链是通过审核状态
     */
    public static final int LINK_STATUS_NORMAL = 0;

    /**
     * 友链是审核未通过状态
     */
    public static final int LINK_STATUS_FAIL = 1;

    /**
     * 友链是未审核状态
     */
    public static final int LINK_STATUS_NOT_AUDIT = 2;

    /**
     * 评论类型为文章评论
     */
    public static final String ARTICLE_COMMENT = "0";

    /**
     * 评论类型为友链评论
     */
    public static final String LINK_COMMENT = "1";
}

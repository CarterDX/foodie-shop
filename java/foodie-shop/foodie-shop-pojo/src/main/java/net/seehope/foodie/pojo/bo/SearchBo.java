package net.seehope.foodie.pojo.bo;

import io.swagger.annotations.ApiModel;

@ApiModel("接受查询参数")
public class SearchBo {
    private String keywords;
    private String sort;
    private Integer page;
    private Integer pageSize;

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

}

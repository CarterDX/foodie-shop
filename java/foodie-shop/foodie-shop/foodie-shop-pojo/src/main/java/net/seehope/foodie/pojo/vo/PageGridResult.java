package net.seehope.foodie.pojo.vo;

import java.util.ArrayList;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("分页插件要求返回给前端的数据模型")
public class PageGridResult {
    @ApiModelProperty("分页数据区域")
    List<?> rows = new ArrayList<>();
    @ApiModelProperty("所有记录的总页数")
    private Integer total;
    @ApiModelProperty("当前页数")
    private Integer page;
    @ApiModelProperty("总记录条数")
    private Long records;

    public List<?> getRows() {
        return rows;
    }

    public void setRows(List<?> rows) {
        this.rows = rows;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Long getRecords() {
        return records;
    }

    public void setRecords(Long records) {
        this.records = records;
    }

}

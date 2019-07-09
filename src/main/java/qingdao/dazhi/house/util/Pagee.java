package qingdao.dazhi.house.util;
//分页工具类
public class Pagee {
    private Integer page=1;
    private Integer rows=3;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }

    public Pagee() {

    }

    public Pagee(Integer page, Integer rows) {

        this.page = page;
        this.rows = rows;
    }
}

package com.example.sample.model;

/**
 * @Description:
 * @Author renzhiyong
 * @Date 2017/9/29 15:27
 */
public class BaseResp {
    private Integer total;
    private Object data;

    public BaseResp() {
    }

    public Integer getTotal() {

        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "BaseResp{" +
                "total=" + total +
                ", data=" + data +
                '}';
    }
}

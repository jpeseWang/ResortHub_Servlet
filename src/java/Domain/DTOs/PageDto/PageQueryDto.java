package Domain.DTOs.PageDto;

import Domain.Enums.Order;

public class PageQueryDto {
    private Order order = Order.ASC;
    private int page;
    private int pageSize;

    public PageQueryDto() {
        this.page = 1;
        this.pageSize = 10;
    }

    public PageQueryDto(int page, int pageSize) {
        this.page = page;
        this.pageSize = pageSize;
    }

    public PageQueryDto(int page, int pageSize, Order order) {
        this.page = page;
        this.pageSize = pageSize;
        this.order = order;
    }

    public Order getOrder() {
        return order;
    }

    public int getPage() {
        return page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public int getOffset() {
        return (this.page - 1) * this.pageSize;
    }
}

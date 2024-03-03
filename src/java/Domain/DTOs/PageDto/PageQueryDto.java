package Domain.DTOs.PageDto;

import Domain.Enums.Order;
import Utils.ConvertUtils;
import jakarta.servlet.http.HttpServletRequest;

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

    public PageQueryDto(HttpServletRequest request) {
        page = ConvertUtils.convertStringToInt(request.getParameter("Page"));
        pageSize = ConvertUtils.convertStringToInt(request.getParameter("PageSize"));
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

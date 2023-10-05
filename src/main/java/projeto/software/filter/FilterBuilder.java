package projeto.software.filter;

public class FilterBuilder {
    private Filter filter;

    public FilterBuilder() {
        this.filter = new Filter();
    }

    public Filter build() {
        if (this.filter.getSql().isEmpty()) {
            throw new IllegalArgumentException("SQL não pode ser vazio");
        }

        return this.filter;
    }

    public FilterBuilder setSql(String sql) {
        this.filter.setSql(sql);
        return this;
    }

    public FilterBuilder setParams(String[] params) {
        this.filter.setParams(params);
        return this;
    }

    public FilterBuilder setOrderBy(String orderBy) {
        this.filter.setOrderBy(orderBy);
        return this;
    }

    public FilterBuilder setGroupBy(String groupBy) {
        this.filter.setGroupBy(groupBy);
        return this;
    }
}

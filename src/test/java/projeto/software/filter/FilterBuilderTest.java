package projeto.software.filter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FilterBuilderTest {
    private FilterBuilder filterBuilder;

    @BeforeEach
    void setUp() {
        this.filterBuilder = new FilterBuilder();
    }

    @Test
    void deveRetornarExcecaoSeSqlNaoForDeclarada() {
        try {
            this.filterBuilder.build();
            fail("Deveria ter lançado exceção");
        } catch (IllegalArgumentException e) {
            assertEquals("SQL não pode ser vazio", e.getMessage());
        }
    }

    @Test
    void devRetornarFilterValido() {
        Filter filter = this.filterBuilder
                .setSql("SELECT * FROM users")
                .setParams(new String[] {"1", "2"})
                .setOrderBy("id")
                .setGroupBy("id")
                .build();

        assertEquals("SELECT * FROM users", filter.getSql());
        assertEquals("1", filter.getParams()[0]);
        assertEquals("2", filter.getParams()[1]);
        assertEquals("id", filter.getOrderBy());
        assertEquals("id", filter.getGroupBy());
    }
}
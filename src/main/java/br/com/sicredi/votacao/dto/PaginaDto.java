package br.com.sicredi.votacao.dto;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Sort;

import java.util.List;

@Setter
@Getter
@ApiModel(value = "Pagina")
public class PaginaDto<T> {

    private List<T> content;
    private List<SortOrder> sorts;

    private int size;
    private int number;
    private long totalElements;

    private boolean last;
    private boolean first;
    private boolean empty;

    @Getter
    public static class SortOrder {

        private final String dir;
        private final String prop;

        public SortOrder(Sort.Order order) {
            this.prop = order.getProperty();
            this.dir = order.getDirection().name().toLowerCase();
        }

    }

}

package projet.micro.auth.specification;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class SearchCriteria implements Serializable {

    private static final long serialVersionUID = 1L;

    private String key;

    private SearchOperation searchOperation;

    private boolean isOrOperation;

    private transient List<Object> arguments;

    private String joinTable;

    public SearchCriteria(String key, SearchOperation searchOperation, boolean isOrOperation, List<Object> arguments, String joinTable) {
        this.key = key;
        this.searchOperation = searchOperation;
        this.isOrOperation = isOrOperation;
        this.arguments = arguments;
        this.joinTable = joinTable;
    }
}

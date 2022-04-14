package projet.micro.auth.specification;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class SpecificationFactory<T> {

    public Specification<T> isEqual(String key, Object arg) {
        return isEqual(key,arg,null);
    }

    public Specification<T> isEqual(String key, Object arg, String joinTable) {
        GenericSpecificationsBuilder<T> builder = new GenericSpecificationsBuilder<>();
        return builder.with(key, SearchOperation.EQUAL, Collections.singletonList(arg), joinTable).build();
    }

    public Specification<T> isNotEqual(String key, Object arg) {
        return isNotEqual(key,arg,null);
    }

    public Specification<T> isNotEqual(String key, Object arg, String joinTable) {
        GenericSpecificationsBuilder<T> builder = new GenericSpecificationsBuilder<>();
        return builder.with(key, SearchOperation.NOT_EQUAL, Collections.singletonList(arg), joinTable).build();
    }

    public Specification<T> isLike(String key, Object arg) {
        return isLike(key,arg,null);
    }

    public Specification<T> isLike(String key, Object arg, String joinTable) {
        GenericSpecificationsBuilder<T> builder = new GenericSpecificationsBuilder<>();
        return builder.with(key, SearchOperation.LIKE, Collections.singletonList(arg), joinTable).build();
    }

    public Specification<T> isLessThen(String key, Object arg) {
        return isLessThen(key,arg,null);
    }

    public Specification<T> isLessThen(String key, Object arg, String joinTable) {
        GenericSpecificationsBuilder<T> builder = new GenericSpecificationsBuilder<>();
        return builder.with(key, SearchOperation.LESS_THAN, Collections.singletonList(arg), joinTable).build();
    }

    public Specification<T> isLessThenOrEqual(String key, Object arg) {
        return isLessThenOrEqual(key,arg,null);
    }

    public Specification<T> isLessThenOrEqual(String key, Object arg, String joinTable) {
        GenericSpecificationsBuilder<T> builder = new GenericSpecificationsBuilder<>();
        return builder.with(key, SearchOperation.LESS_THAN_OR_EQUAL, Collections.singletonList(arg), joinTable).build();
    }

    public Specification<T> isGreaterThen(String key, Object arg) {
        return isGreaterThen(key,arg,null);
    }

    public Specification<T> isGreaterThen(String key, Object arg, String joinTable) {
        GenericSpecificationsBuilder<T> builder = new GenericSpecificationsBuilder<>();
        return builder.with(key, SearchOperation.GREATER_THAN, Collections.singletonList(arg), joinTable).build();
    }

    public Specification<T> isGreaterThenOrEqual(String key, Object arg) {
        return isGreaterThenOrEqual(key,arg,null);
    }

    public Specification<T> isGreaterThenOrEqual(String key, Object arg, String joinTable) {
        GenericSpecificationsBuilder<T> builder = new GenericSpecificationsBuilder<>();
        return builder.with(key, SearchOperation.GREATER_THAN_OR_EQUAL, Collections.singletonList(arg), joinTable).build();
    }

    public Specification<T> isIn(String key, Object arg, String joinTable) {
        GenericSpecificationsBuilder<T> builder = new GenericSpecificationsBuilder<>();
        return builder.with(key, SearchOperation.IN, Collections.singletonList(arg), joinTable).build();
    }

    public Specification<T> isIn(String key, Object arg) {
        return isIn(key,arg,null);
    }
}

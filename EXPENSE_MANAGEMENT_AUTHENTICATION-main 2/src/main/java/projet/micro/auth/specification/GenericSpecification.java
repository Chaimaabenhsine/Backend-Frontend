package projet.micro.auth.specification;

import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;
import java.util.List;

public class GenericSpecification<T> implements Specification<T> {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private transient SearchCriteria searchCriteria;

    public GenericSpecification(SearchCriteria searchCriteria) {
        this.searchCriteria = searchCriteria;
    }

    @Override
    public Predicate toPredicate(Root<T> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        List<Object> arguments = searchCriteria.getArguments();
        Object arg = arguments.get(0);
        switch (searchCriteria.getSearchOperation()) {
            case EQUAL:
                return getPredicateEqual(root,criteriaBuilder,arg);
            case NOT_EQUAL:
                return getPredicateNotEqual(root,criteriaBuilder,arg);
            case LIKE:
                return getPredicateLike(root,criteriaBuilder,arg);
            case GREATER_THAN:
                return getPredicateGreaterThan(root,criteriaBuilder,arg);
            case GREATER_THAN_OR_EQUAL:
                return getPredicateEqualOrEqualTo(root,criteriaBuilder,arg);
            case LESS_THAN:
                return getPredicateLessThan(root,criteriaBuilder,arg);
            case LESS_THAN_OR_EQUAL:
                return getPredicateLessThanOrEqualTo(root,criteriaBuilder,arg);
            case IN:
                return getPredicateIn(root,arguments);
            default:
                return null;
        }
    }

    private Predicate getPredicateEqual(Root<T> root, CriteriaBuilder criteriaBuilder, Object arg) {
        return null!=searchCriteria.getJoinTable() ? criteriaBuilder.equal(root.join(searchCriteria.getJoinTable()).get(searchCriteria.getKey()), arg) :  criteriaBuilder.equal(root.get(searchCriteria.getKey()), arg);
    }

    private Predicate getPredicateNotEqual(Root<T> root, CriteriaBuilder criteriaBuilder, Object arg) {
        return null!=searchCriteria.getJoinTable() ? criteriaBuilder.notEqual(root.join(searchCriteria.getJoinTable()).get(searchCriteria.getKey()), arg) :  criteriaBuilder.notEqual(root.get(searchCriteria.getKey()), arg);
    }

    private Predicate getPredicateLike(Root<T> root, CriteriaBuilder criteriaBuilder, Object arg) {
        return null!=searchCriteria.getJoinTable() ? criteriaBuilder.like(root.join(searchCriteria.getJoinTable()).get(searchCriteria.getKey()), "%" + arg + "%"):  criteriaBuilder.like(root.get(searchCriteria.getKey()), "%" + arg + "%");
    }

    private Predicate getPredicateGreaterThan(Root<T> root, CriteriaBuilder criteriaBuilder, Object arg) {
        return null!=searchCriteria.getJoinTable() ? criteriaBuilder.greaterThan(root.join(searchCriteria.getJoinTable()).get(searchCriteria.getKey()), (Comparable) arg) :  criteriaBuilder.greaterThan(root.get(searchCriteria.getKey()), (Comparable) arg);
    }

    private Predicate getPredicateEqualOrEqualTo(Root<T> root, CriteriaBuilder criteriaBuilder, Object arg) {
        return null!=searchCriteria.getJoinTable() ? criteriaBuilder.greaterThanOrEqualTo(root.join(searchCriteria.getJoinTable()).get(searchCriteria.getKey()), (Comparable) arg) :  criteriaBuilder.greaterThanOrEqualTo(root.get(searchCriteria.getKey()), (Comparable) arg);
    }

    private Predicate getPredicateLessThan(Root<T> root, CriteriaBuilder criteriaBuilder, Object arg) {
        return null!=searchCriteria.getJoinTable() ? criteriaBuilder.lessThan(root.join(searchCriteria.getJoinTable()).get(searchCriteria.getKey()), (Comparable) arg) :  criteriaBuilder.lessThan(root.get(searchCriteria.getKey()), (Comparable) arg);
    }

    private Predicate getPredicateLessThanOrEqualTo(Root<T> root, CriteriaBuilder criteriaBuilder, Object arg) {
        return null!=searchCriteria.getJoinTable() ? criteriaBuilder.lessThanOrEqualTo(root.join(searchCriteria.getJoinTable()).get(searchCriteria.getKey()), (Comparable) arg) :  criteriaBuilder.lessThanOrEqualTo(root.get(searchCriteria.getKey()), (Comparable) arg);
    }

    private Predicate getPredicateIn(Root<T> root, List<Object> arguments) {
        return null!=searchCriteria.getJoinTable() ? root.join(searchCriteria.getJoinTable()).get(searchCriteria.getKey()).in(arguments) :  root.get(searchCriteria.getKey()).in(arguments);
    }
}
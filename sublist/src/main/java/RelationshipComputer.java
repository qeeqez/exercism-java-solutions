import java.util.Collections;
import java.util.List;

class RelationshipComputer<T> {
    Relationship computeRelationship(List<T> firstList, List<T> secondList) {
        if (firstList.equals(secondList)) return Relationship.EQUAL;

        if (isSublist(firstList, secondList)) return Relationship.SUPERLIST;
        if (isSublist(secondList, firstList)) return Relationship.SUBLIST;

        return Relationship.UNEQUAL;
    }

    private boolean isSublist(List<T> first, List<T> second) {
        if (second.size() > first.size()) return false;
        if (second.isEmpty()) return true;

        return Collections.indexOfSubList(first, second) != -1;
    }
}

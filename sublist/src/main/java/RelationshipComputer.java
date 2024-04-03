import java.util.List;

class RelationshipComputer<T> {
    Relationship computeRelationship(List<T> firstList, List<T> secondList) {
        if(firstList.equals(secondList)) return Relationship.EQUAL;

        return Relationship.UNEQUAL;
    }
}

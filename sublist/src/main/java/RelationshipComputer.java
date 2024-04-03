import java.util.List;

class RelationshipComputer<T> {
    Relationship computeRelationship(List<T> firstList, List<T> secondList) {
        if (firstList.equals(secondList)) return Relationship.EQUAL;

        if (isSublist(firstList, secondList)) return Relationship.SUPERLIST;
        if (isSublist(secondList, firstList)) return Relationship.SUBLIST;

        return Relationship.UNEQUAL;
    }

    private boolean isSublist(List<T> firstList, List<T> secondList) {
        if (secondList.size() > firstList.size()) return false;
        if (secondList.isEmpty()) return true;
        if (secondList.size() == firstList.size()) return firstList.equals(secondList);

        boolean isSublist = false;
        for (int i = 0; i < firstList.size() - secondList.size() + 1; i++) {
            int k = i;
            for (T second : secondList) {
                if (firstList.get(k).equals(second)) {
                    k++;
                    isSublist = true;
                } else {
                    isSublist = false;
                    break;
                }
            }
            if (isSublist) return true;
        }

        return false;
    }
}

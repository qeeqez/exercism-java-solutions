class Badge {

    /**
     * @param id         Employee id, could be null
     * @param name       Employee name
     * @param department Employee department, could be null
     * @return String "[id] - name - DEPARTMENT"
     */
    public String print(Integer id, String name, String department) {
        String badge = id == null ? "" : "[" + id + "] - ";
        badge += name + " - ";
        badge += department == null ? "OWNER" : department.toUpperCase();
        return badge;
    }
}

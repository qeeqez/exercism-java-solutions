public class GameMaster {

    public String describe(Character character) {
        return String.format("You're a level %d %s with %d hit points.",
                             character.getLevel(),
                             character.getCharacterClass(),
                             character.getHitPoints()
        );
    }

    public String describe(Destination destination) {
        return String.format("You've arrived at %s, which has %s inhabitants.",
                             destination.getName(),
                             destination.getInhabitants()
        );
    }

    public String describe(TravelMethod travel) {
        String travelStr = travel == TravelMethod.WALKING ? "by walking" : "on horseback";
        return String.format("You're traveling to your destination %s.", travelStr);
    }

    public String describe(Character character, Destination destination, TravelMethod travel) {
        return describe(character) + " " + describe(travel) + " " + describe(destination);
    }

    public String describe(Character character, Destination destination) {
        return describe(character) + " " + describe(TravelMethod.WALKING) + " " + describe(destination);
    }

}

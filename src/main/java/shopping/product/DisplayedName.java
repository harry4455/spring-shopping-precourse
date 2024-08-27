package shopping.product;

public class DisplayedName {
    public DisplayedName(String name, Profanities profanities) {
        if(profanities.contains(name)) {
            throw new IllegalArgumentException(ㅁ);
        }
    }
}

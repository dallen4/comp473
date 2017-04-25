package model;

/**
 * Created by dominiqueallen on 4/24/17.
 */
public interface Visitable {
    public void accept(Visitor visitor);
}

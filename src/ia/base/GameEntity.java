package ia.base;

import java.util.UUID;

/**
 * Default Template. Information about thus class should go here
 * Created by mauriciog on 10/1/15 for Artificial Intelligence
 */
public abstract class GameEntity {

    public UUID id;
    public String name;
    protected static int num = 0;

    public GameEntity(String name) {
        this.name = name;
        id = UUID.randomUUID();
    }

    public GameEntity() {
        this.name =  "Entity " + num;
        id = UUID.randomUUID();
        num++;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null) return false;
        if (object instanceof GameEntity) {
            return id.equals( ( (GameEntity) object ).id );
        }
        return false;
    }

    @Override
    public String toString() {
        return name;
    }

    public abstract void update();

}

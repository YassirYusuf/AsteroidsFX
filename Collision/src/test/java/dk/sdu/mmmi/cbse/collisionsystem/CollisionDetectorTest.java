package dk.sdu.mmmi.cbse.collisionsystem;


import dk.sdu.mmmi.cbse.common.data.Entity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;




class CollisionDetectorTest {
    private CollisionDetector collisiondetection;

    @BeforeEach
    public void setUp() {
        collisiondetection = new CollisionDetector();
    }

    @Test
    public void testCollisionBetweenEntities() {
        Entity entityA = new Entity();
        entityA.setX(5);
        entityA.setY(5);
        entityA.setRadius(2);


        Entity entityB = new Entity();
        entityB.setX(5);
        entityB.setY(5);
        entityB.setRadius(2);


       Assertions.assertTrue(collisiondetection.collides(entityA, entityB));
    }

    @Test
    public void testNoCollisionBetweenEntities() {
        Entity entityA = new Entity();
        entityA.setX(0);
        entityA.setY(0);
        entityA.setRadius(2);

        Entity entityB = new Entity();
        entityB.setX(10);
        entityB.setY(10);
        entityB.setRadius(2);

        Assertions.assertFalse(collisiondetection.collides(entityA, entityB));
    }

}

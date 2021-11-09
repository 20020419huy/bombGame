package uet.oop.bomberman.entities.SubClass;

import uet.oop.bomberman.entities.Entity;

public class Duplicate {
//    public static boolean canMoveRight;
//
//    public static boolean canMoveLeft;
//
//    public static boolean canMoveUp;
//
//    public static boolean canMoveDown;
//
//    public static void checkDuplicate(Entity bomber, Entity entity) {
//        double rightBomber = bomber.x + bomber.sprite._realWidth;
//        double leftBomber = bomber.x;
//        double aboveBomber = bomber.y;
//        double belowBomber = bomber.y + bomber.sprite._realHeight;
//
//        double rightEntity = entity.x + entity.sprite._realWidth;
//        double leftEntity = entity.x;
//        double aboveEntity = entity.y;
//        double belowEntity = entity.y + entity.sprite._realHeight;
//        if (rightBomber >= leftEntity && rightBomber <= rightEntity) {
//            canMoveRight = false;
//        } else if (leftBomber >= leftEntity && leftBomber <= rightEntity) {
//            canMoveLeft = false;
//        }
//        else if (belowBomber >= aboveEntity && belowBomber <= belowEntity) {
//            canMoveDown = false;
//        }
//        else if (aboveBomber >= aboveEntity && aboveBomber <= belowEntity) {
//            canMoveUp = false;
//        }
//        else {
//            canMoveRight = true;
//            canMoveLeft = true;
//            canMoveDown = true;
//            canMoveUp = true;
//        }
//    }

    public static boolean collision(Entity bomber, Entity entity) {
        if(entity.status == Constant.STATUS_DESTROYED) {
            return false;
        }
        double rightBomber = bomber.x + bomber.sprite._realWidth;
        double leftBomber = bomber.x;
        double aboveBomber = bomber.y;
        double belowBomber = bomber.y + bomber.sprite._realHeight;

        double rightEntity = entity.x + entity.sprite._realWidth;
        double leftEntity = entity.x;
        double aboveEntity = entity.y;
        double belowEntity = entity.y + entity.sprite._realHeight;

        if (belowBomber <= aboveEntity) {
            return false;
        }
        else if (aboveBomber >= belowEntity) {
            return false;
        }
        else if (rightBomber <= leftEntity) {
            return false;
        }
        else if (leftBomber >=rightEntity) {
            return false;
        }
        return true;
    }
}

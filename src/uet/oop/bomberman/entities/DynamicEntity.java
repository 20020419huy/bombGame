package uet.oop.bomberman.entities;

import javafx.scene.image.Image;
import uet.oop.bomberman.BombermanGame;
import uet.oop.bomberman.entities.SubClass.Constant;
import uet.oop.bomberman.entities.SubClass.Duplicate;
import uet.oop.bomberman.graphics.Sprite;

import java.util.ArrayList;
import java.util.List;

public class DynamicEntity extends Entity {

    public DynamicEntity(int xUnit, int yUnit, Sprite sprite) {
        super(xUnit, yUnit, sprite);
      
    }

    @Override
    public void update() {

    }

    protected int checkCollision() {
        if (this instanceof Alien) {
            for (int i = 0; i <  BombermanGame.stillObjects.size(); i++) {
                boolean checkCollision = Duplicate.collision(this, BombermanGame.stillObjects.get(i));
                if ((BombermanGame.stillObjects.get(i) instanceof Wall) && checkCollision) {
                    return Constant.COLLISION_WITH_WALL; // va cham voi Wall va brick
                }
                if(BombermanGame.stillObjects.get(i) instanceof Brick && checkCollision) {
                    return Constant.COLLISION_WITH_BRICK;
                }
                if ((BombermanGame.stillObjects.get(i) instanceof Alien) && checkCollision && this !=  BombermanGame.stillObjects.get(i)) {
                    return Constant.COLLISION_WITH_ALIEN; 
                }
                if((BombermanGame.stillObjects.get(i) instanceof Flame) && checkCollision && this !=  BombermanGame.stillObjects.get(i)) {
                    return Constant.COLLISION_WITH_FLAME;
                }
                if((BombermanGame.stillObjects.get(i) instanceof Bomb) && checkCollision && this !=  BombermanGame.stillObjects.get(i)) {
                    return Constant.COLLISION_WITH_BOMB;
                }
            }
        }
        if (this instanceof Bomber) {
            for (int i = 0; i <  BombermanGame.stillObjects.size(); i++) {
                boolean checkCollision = Duplicate.collision(this, BombermanGame.stillObjects.get(i));
                if ((BombermanGame.stillObjects.get(i) instanceof Wall) && checkCollision) {
                    return Constant.COLLISION_WITH_WALL; // va cham voi Wall va brick
                }
                if(BombermanGame.stillObjects.get(i) instanceof Brick && checkCollision) {
                    return Constant.COLLISION_WITH_BRICK;
                }
                if ((BombermanGame.stillObjects.get(i) instanceof Alien) && checkCollision) {
                    return Constant.COLLISION_WITH_ALIEN; // va cham voi alien
                }
                if((BombermanGame.stillObjects.get(i) instanceof Flame) && checkCollision && this !=  BombermanGame.stillObjects.get(i)) {
                    return Constant.COLLISION_WITH_FLAME;
                }
            }
        }
        if(this instanceof  Flame) {
            for (int i = 0; i <  BombermanGame.stillObjects.size(); i++) {
                if (BombermanGame.stillObjects.get(i) instanceof Wall || BombermanGame.stillObjects.get(i) instanceof Brick) {
                    boolean checkCollision = Duplicate.collision(this, BombermanGame.stillObjects.get(i));
                    if ((BombermanGame.stillObjects.get(i) instanceof Wall) && checkCollision) {
                        return Constant.COLLISION_WITH_WALL; // va cham voi Wall va brick
                    }
                    if (BombermanGame.stillObjects.get(i) instanceof Brick && checkCollision) {
                        return Constant.COLLISION_WITH_BRICK;
                    }
                }
            }
        }
        if(this instanceof Brick) {
            for (int i = 0; i < BombermanGame.stillObjects.size(); i++) {
                if (BombermanGame.stillObjects.get(i) instanceof Flame) {
                    boolean checkCollision = Duplicate.collision(this, BombermanGame.stillObjects.get(i));
                    if(checkCollision) {
                        return Constant.COLLISION_WITH_FLAME;
                    }
                }
            }
        }
        return Constant.NO_COLLISION;
    }
}

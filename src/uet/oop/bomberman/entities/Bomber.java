package uet.oop.bomberman.entities;

import javafx.scene.input.KeyCode;
import uet.oop.bomberman.BombermanGame;
import uet.oop.bomberman.entities.SubClass.Constant;
import uet.oop.bomberman.graphics.AnimationFrame;
import uet.oop.bomberman.graphics.Sprite;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;


public class Bomber extends DynamicEntity {
    private double speed = 2;
    private int power_up = Constant.POWER_UP_1;
    private double speedAnimation = 100;
    private int oldPosX;
    private int oldPosY;
    private int sumBomb = 0;
    private final int MAX_BOMB = 1;
    public static KeyCode KEY_BOMB = KeyCode.SPACE;
    private AnimationFrame animationFrame;
    private ArrayList<Sprite> frameRight = new ArrayList<Sprite>();
    private ArrayList<Sprite> frameDown = new ArrayList<Sprite>();
    private ArrayList<Sprite> frameLeft = new ArrayList<Sprite>();
    private ArrayList<Sprite> frameUp = new ArrayList<Sprite>();
    private ArrayList<Sprite> frameDestroy = new ArrayList<Sprite>();
    public Bomber(int x, int y, Sprite sprite) {
        super( x, y, sprite);
        oldPosX = x;
        oldPosY = y;
        init();
    }
    private void init() {
        frameUp.add(Sprite.player_up);
        frameUp.add(Sprite.player_up_1);
        frameUp.add(Sprite.player_up_2);

        frameRight.add(Sprite.player_right);
        frameRight.add(Sprite.player_right_1);
        frameRight.add(Sprite.player_right_2);

        frameDown.add(Sprite.player_down);
        frameDown.add(Sprite.player_down_1);
        frameDown.add(Sprite.player_down_2);

        frameLeft.add(Sprite.player_left);
        frameLeft.add(Sprite.player_left_1);
        frameLeft.add(Sprite.player_left_2);

        frameDestroy.add(Sprite.player_dead1);
        frameDestroy.add(Sprite.player_dead2);
        frameDestroy.add(Sprite.player_dead3);

        animationFrame = new AnimationFrame(this, speedAnimation, frameUp, frameRight, frameDown, frameLeft, frameDestroy);
    }

    @Override
    public void update() {
        animationFrame.loadFrame();
    }

    public void updatePosition (KeyCode direc) {
        oldPosY = y;
        oldPosX = x;
        if(direc == KeyCode.UP) {
            y -=  speed;
            status = Constant.STATUS_UP;
        } else if(direc == KeyCode.RIGHT) {
            x +=  speed;
            status = Constant.STATUS_RIGHT;
        } else if(direc == KeyCode.DOWN) {
            y +=  speed;
            status = Constant.STATUS_DOWN;
        } else if(direc == KeyCode.LEFT) {
            x -=  speed;
            status = Constant.STATUS_LEFT;
        }  else if(direc == KEY_BOMB) {
            setBomb();
        } else if(direc == null) {
            status = Constant.STATUS_STAND;
        }
        int collision = checkCollision();
        if(collision != Constant.NO_COLLISION) {
            if(collision == Constant.COLLISION_WITH_ALIEN || collision == Constant.COLLISION_WITH_FLAME)
                status = Constant.STATUS_DESTROY;
            x = oldPosX;
            y  = oldPosY;
        }

    }

    private void setBomb() {
        int currentBomb = 0;
        for(int i = 0; i < BombermanGame.stillObjects.size(); i++) {
            if(BombermanGame.stillObjects.get(i) instanceof  Bomb && BombermanGame.stillObjects.get(i).status != Constant.STATUS_DESTROYED) {
               currentBomb++;
            }
        }
        if(currentBomb < MAX_BOMB) {
            Bomb bomb = new Bomb((x + Sprite.SCALED_SIZE / 2) / Sprite.SCALED_SIZE, (y + Sprite.SCALED_SIZE / 2) / Sprite.SCALED_SIZE, Sprite.bomb, Constant.POWER_UP_MAX);
        }
    }

}

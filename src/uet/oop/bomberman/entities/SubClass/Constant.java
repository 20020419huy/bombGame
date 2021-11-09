package uet.oop.bomberman.entities.SubClass;

import uet.oop.bomberman.graphics.Sprite;

import java.util.ArrayList;

public class Constant {
    public static final int COLLISION_WITH_WALL = 1;
    public static final int COLLISION_WITH_BRICK = 2;
    public static final int COLLISION_WITH_ALIEN = 3;
    public static final int COLLISION_WITH_BOMBER = 4;
    public static final int COLLISION_WITH_FLAME = 5;
    public static final int COLLISION_WITH_BOMB = 6;
    public static final int NO_COLLISION = 0;

    public static final int STATUS_STAND = 24;
    public static final int STATUS_UP = 25;
    public static final int STATUS_RIGHT = 26;
    public static final int STATUS_DOWN = 27;
    public static final int STATUS_LEFT = 28;
    public static final int STATUS_DESTROY = 29;
    public static final int STATUS_SET_BOMB = 30;
    public static final int STATUS_DESTROYED = 31;

    public static final int STATUS_FLAME_CENTER = 12;
    public static final int STATUS_FLAME_VERTICAL = 13;
    public static final int STATUS_FLAME_HORIZONTAL = 14;
    public static final int STATUS_FLAME_TOP = 15;
    public static final int STATUS_FLAME_RIGHT = 16;
    public static final int STATUS_FLAME_DOWN = 17;
    public static final int STATUS_FLAME_LEFT = 18;

    public static final int WIDTH = 31;
    public static final int HEIGHT = 13;

    public static final int POWER_UP_MAX = 4;
    public static final int POWER_UP_1 = 1;
    public static final int POWER_UP_2 = 2;
    public static final int POWER_UP_3 = 3;

    public static final int SPEED_ANIMATION_BOMB = 1000;

    public static final char MAP_PLAYER = 'p';
    public static final char MAP_WALL = '#';
    public static final char MAP_BRICK = '*';
    public static final char MAP_PORTAL = 'X';
    public static final char MAP_BOLLOOM = '1';
    public static final char MAP_ONEAL = '2';
    public static final char MAP_BOMB_ITEM = 'b';
    public static final char MAP_POWER_UP = 'f';
    public static final char MAP_POWER_SPEED = 's';

    public static final String BASE_MAP_URL = "/levels/Level";

    public static ArrayList<Sprite> getTransparent() {
        ArrayList<Sprite>result = new ArrayList<Sprite>();
        result.add(Sprite.transparent);
        result.add(Sprite.transparent);
        result.add(Sprite.transparent);
        return result;
    }

}
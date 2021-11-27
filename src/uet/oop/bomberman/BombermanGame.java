package uet.oop.bomberman;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import uet.oop.bomberman.entities.*;
import uet.oop.bomberman.entities.SubClass.Constant;
import uet.oop.bomberman.graphics.Map;
import uet.oop.bomberman.graphics.Sprite;

import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.PrimitiveIterator;

public class BombermanGame extends Application {
    private GraphicsContext gc;
    private Canvas canvas;
    private HBox menu;
    public static List<Entity> stillObjects = new ArrayList<>();
    private List<Entity> entities = new ArrayList<>();
    private Map map = new Map();
    private Bomber bomber = null;
    private KeyCode direc = null;
    public static void main(String[] args) {
        Application.launch(BombermanGame.class);
    }

    @Override
    public void start(Stage stage) {
        // Tao Canvas
        canvas = new Canvas(Sprite.SCALED_SIZE * Constant.WIDTH, Sprite.SCALED_SIZE * Constant.HEIGHT);
        gc = canvas.getGraphicsContext2D();
        //tao menu
        menu = new HBox(Sprite.SCALED_SIZE);
        menu.setPrefWidth(Sprite.SCALED_SIZE * (Constant.WIDTH / 2));
        menu.setPrefHeight(Sprite.SCALED_SIZE * Constant.HEIGHT_MENU);
        menu.getChildren().add(new Text("hello world"));
        menu.getChildren().add(new Text("hello world"));
        menu.getChildren().add(new Text("hello world"));
        // Tao root container
        Group root = new Group();
        root.setClip(new Rectangle(Sprite.SCALED_SIZE * (Constant.WIDTH / 2), Sprite.SCALED_SIZE * (Constant.HEIGHT + Constant.HEIGHT_MENU)));
        root.getChildren().addAll(menu, canvas);
        canvas.setLayoutY(Sprite.SCALED_SIZE * Constant.HEIGHT_MENU);
        // Tao map
        bomber = (Bomber) stillObjects.get(map.createMap(1));
        // Tao scene
        Scene scene = new Scene(root);

        // Them scene vao stage
        stage.setScene(scene);
        stage.show();
        // lang nghe di ban phim
        move(scene);
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                render();
                update();
                bomber.updatePosition(direc);
            }
        };
        timer.start();
    }

    public void move(Scene scene) {
        scene.setOnKeyPressed((KeyEvent e) -> {
//            if(e.getCode() != Bomber.KEY_BOMB) {
                direc = e.getCode();
//            }
        });
        scene.setOnKeyReleased((KeyEvent e) -> {
//            if(e.getCode() != Bomber.KEY_BOMB) {
                direc = null;
//            } else {
//                direc = e.getCode();
//            }
        });
    }

    public void update() {
        for (int i = 0; i < stillObjects.size(); i++) {
            stillObjects.get(i).update();
        }
        updateCanvas();
    }

    public void render() {
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        stillObjects.forEach(g -> g.render(gc));
        entities.forEach(g -> g.render(gc));
    }

    private void updateCanvas() {
        if(-1 * bomber.x + Sprite.SCALED_SIZE * (Constant.WIDTH / 4) <= 0 && -1 * bomber.x + Sprite.SCALED_SIZE * (Constant.WIDTH / 4) >= -1 * Sprite.SCALED_SIZE * (Constant.WIDTH / 2 + 1)) {
            canvas.setLayoutX(- bomber.x + Sprite.SCALED_SIZE * (Constant.WIDTH / 4));
        }
    }
}

package javafxexample;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;



/**
 * @author dmitriykorobskiy
 */
Stage {
    title : "JavaFX Snow Storm"
    scene: Scene {
        content: [ ImageView {
            image: Image {
                url: "{__DIR__}/SnowScene.png"
            }
        } ]
    }
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loginform;

import javafx.scene.Node;
import javafx.scene.control.DialogPane;
import javafx.stage.Stage;
import javafx.stage.Window;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.testfx.api.FxRobot;
import static org.testfx.api.FxToolkit.registerPrimaryStage;
import static org.testfx.api.FxToolkit.setupApplication;
import static org.testfx.api.FxToolkit.setupStage;
import org.testfx.service.query.NodeQuery;

/**
 *
 * @author csc190
 */
public class LoginFormTest {

    FxRobot fx = new FxRobot();
    @BeforeClass
    public static void setupSpec() throws Exception {
        Stage primaryStage = registerPrimaryStage();
        setupStage(stage -> stage.show());
    }

    @Before
    public void setup() throws Exception {
        setupApplication(LoginForm.class);
    }

    @Test
    public void should_login_with_correct_credentials() {
        // when:
        
        fx.clickOn("#tfUser").write("scott");
        fx.clickOn("#pf").write("tiger");
        fx.clickOn("#btnLogin");

        // then:
        Window wd1 = fx.window(0);
        Window wd2 = fx.window(1);
        double w1 = wd1.getWidth();
        double w2 = wd2.getWidth();
        Object obj = wd2.getUserData();
        fx.moveTo(wd2);
        NodeQuery nq = fx.lookup(".contextText");
        Node root = fx.rootNode(wd2);
        DialogPane dp = (DialogPane) root;
        String msg = dp.contentTextProperty().getValue();
        if(msg.indexOf("scott")==-1){
            fail("No good!");
        }
        
    }
}

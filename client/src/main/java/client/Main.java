/*
 * Copyright 2021 Delft University of Technology
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package client;

import client.factory.SceneCreator;
import client.factory.SceneFactory;
import client.scenes.interfaces.MainCtrl;
import com.google.inject.Injector;
import javafx.application.Application;
import javafx.stage.Stage;

import static com.google.inject.Guice.createInjector;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        Injector injector = createInjector(new MyModule());
        MyFXML myFXML = new MyFXML(injector);
        SceneFactory sceneFactory = new SceneFactory(injector, myFXML,
                injector.getInstance(SceneCreator.class));
        var mainCtrl = sceneFactory.getInjector().getInstance(MainCtrl.class);
        mainCtrl.initialize(primaryStage, sceneFactory);
    }
}
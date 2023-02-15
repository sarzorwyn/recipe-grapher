package com.recipegrapher.app;

import com.recipegrapher.app.RecipeGrapherApp;
import com.recipegrapher.app.config.AsyncSyncConfiguration;
import com.recipegrapher.app.config.EmbeddedNeo4j;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

/**
 * Base composite annotation for integration tests.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@SpringBootTest(classes = { RecipeGrapherApp.class, AsyncSyncConfiguration.class })
@EmbeddedNeo4j
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
public @interface IntegrationTest {
    // 5s is the spring default https://github.com/spring-projects/spring-framework/blob/29185a3d28fa5e9c1b4821ffe519ef6f56b51962/spring-test/src/main/java/org/springframework/test/web/reactive/server/DefaultWebTestClient.java#L106
    String DEFAULT_TIMEOUT = "PT5S";

    String DEFAULT_ENTITY_TIMEOUT = "PT5S";
}

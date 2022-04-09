package co.com.sofka.serenityapi.runners;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
    glue = "co.com.sofka.serenityapi.stepdefinitions",
    features = "src/test/resources/features/service.feature",
    snippets = SnippetType.CAMELCASE)
public class Service {

}

package co.com.sofka.serenityapi.stepdefinitions;

import static co.com.sofka.serenityapi.utils.Constants.ACTOR;
import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static net.serenitybdd.screenplay.actors.OnStage.setTheStage;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

import co.com.sofka.serenityapi.questions.TheResponse;
import co.com.sofka.serenityapi.questions.TheStatusCode;
import co.com.sofka.serenityapi.tasks.SearchBook;
import io.cucumber.java.Before;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.actors.OnlineCast;

public class ServiceStepDefinitions {

  @Before
  public void setUp() {
    setTheStage(new OnlineCast());
    theActorCalled(ACTOR);
  }

  @Cuando("se consulta un libro con el id {int}")
  public void searchById(Integer id) {

    theActorInTheSpotlight().attemptsTo(
        SearchBook.byId(id)
    );
  }

  @Entonces("debería tener una respuesta con código {int}")
  public void statusCode(Integer code) {
    theActorInTheSpotlight().should(
        seeThat(TheStatusCode.is(code))
    );
  }
  @Entonces("la respuesta deberia ser vacia")
  public void validateEmpty() {
    theActorInTheSpotlight().should(
            seeThat(TheResponse.isEmpty())
    );

  }

  @Entonces("el título del libro es {string} y el autor del libro debe ser {string}")
  public void validateTitle(String title, String author) {

    theActorInTheSpotlight().should(
        seeThat(TheResponse.contains(title, author))
    );
  }
}

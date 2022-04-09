package co.com.sofka.serenityapi.tasks;

import static co.com.sofka.serenityapi.utils.Constants.BASE_PATH;
import static co.com.sofka.serenityapi.utils.Constants.RESOURCE;

import io.restassured.http.ContentType;
import lombok.AllArgsConstructor;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.thucydides.core.annotations.Step;

@AllArgsConstructor
public class SearchBook implements Task {

  private int id;

  public static SearchBook byId(int id) {
    return Tasks.instrumented(SearchBook.class, id);
  }

  @Step("{0} search book by id #id")
  @Override
  public <T extends Actor> void performAs(T actor) {

    SerenityRest.given()
        .relaxedHTTPSValidation()
        .baseUri(BASE_PATH)
        .log()
        .all()
        .urlEncodingEnabled(false)
        .contentType(ContentType.JSON)
        .when()
        .get(RESOURCE, id)
        .then();
  }
}

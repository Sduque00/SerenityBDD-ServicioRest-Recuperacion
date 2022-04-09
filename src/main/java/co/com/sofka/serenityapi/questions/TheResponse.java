package co.com.sofka.serenityapi.questions;

import co.com.sofka.serenityapi.models.BookResponse;
import lombok.AllArgsConstructor;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;
import net.serenitybdd.screenplay.ensure.Ensure;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@AllArgsConstructor
public class TheResponse implements Question<Boolean> {

  private static final Logger LOGGER = LoggerFactory.getLogger(TheResponse.class);

  private String title;
  private String author;

  public static TheResponse contains(String title, String author){
    return new TheResponse(title, author);
  }
  public static TheResponse isEmpty(){
    return new TheResponse(null,null);
  }

  @Subject("validate response")
  @Override
  public Boolean answeredBy(Actor actor) {

    List <BookResponse> response = SerenityRest.lastResponse().getBody().jsonPath().getList(".", BookResponse.class);

    LOGGER.info("Response -> "+response);

    if (author != null){
      actor.attemptsTo(
              Ensure.that(response.get(0).getTitle()).isEqualTo(title),
              Ensure.that(response.get(0).getAuthor()).isEqualTo(author)
      );
    }else {
      actor.attemptsTo(
              Ensure.that(response).isEmpty()
      );
    }
    return true;
  }
}

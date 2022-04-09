package co.com.sofka.serenityapi.questions;

import lombok.AllArgsConstructor;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;

@AllArgsConstructor
public class TheStatusCode implements Question<Boolean> {

  private int code;

  public static TheStatusCode is(int code){
    return new TheStatusCode(code);
  }

  @Subject("validate status code")
  @Override
  public Boolean answeredBy(Actor actor) {
    return SerenityRest.lastResponse().statusCode() == code;
  }
}

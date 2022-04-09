package co.com.sofka.serenityapi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Category {

  @JsonProperty("category_id")
  private int categoryId;

  @JsonProperty("name")
  private String name;

  @JsonProperty("nicename")
  private String nicename;
}

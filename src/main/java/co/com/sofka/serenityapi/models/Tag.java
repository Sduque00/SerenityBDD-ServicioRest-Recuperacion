package co.com.sofka.serenityapi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Tag {

  @JsonProperty("tag_id")
  private int tagId;

  @JsonProperty("name")
  private String name;

  @JsonProperty("nicename")
  private String nicename;
}

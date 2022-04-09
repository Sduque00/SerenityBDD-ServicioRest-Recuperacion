package co.com.sofka.serenityapi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class BookResponse {

  @JsonProperty("ID")
  private String id;

  @JsonProperty("title")
  private String title;

  @JsonProperty("author")
  private String author;

  @JsonProperty("content")
  private String content;

  @JsonProperty("url_download")
  private String urlDownload;

  @JsonProperty("cover")
  private String cover;

  @JsonProperty("categories")
  private List<Category> categories;

  @JsonProperty("tags")
  private List<Tag> tags;
}

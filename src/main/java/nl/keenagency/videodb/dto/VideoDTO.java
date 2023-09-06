package nl.keenagency.videodb.dto;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class VideoDTO {
    private int id;
    private String title;
    private int duration;
    private String file_url;
    private String cover_url;
    private String excerpt;
    private String type;
    List<CategoryDTO> categories;
}

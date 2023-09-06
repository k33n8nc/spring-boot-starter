package nl.keenagency.videodb.mapper;
import nl.keenagency.videodb.dto.VideoDTO;
import nl.keenagency.videodb.dto.CategoryDTO;
import nl.keenagency.videodb.entity.Video;
import nl.keenagency.videodb.entity.Category;
import org.mapstruct.Mapper;
import java.util.List;

// allows the mapper to be autowired into other Spring components.
@Mapper(componentModel = "spring")
public interface VideoMapper {
    VideoDTO toVideoDTO(Video video);
    List<VideoDTO> toVideoDTOList(List<Video> videos);
    Video toVideoEntity(VideoDTO videoDTO);
    CategoryDTO toCategoryDTO(Category category);

//    List<CategoryDTO> toCategoryDTOList(List<Category> categories);
}


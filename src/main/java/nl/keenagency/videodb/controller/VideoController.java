package nl.keenagency.videodb.controller;
import lombok.RequiredArgsConstructor;
import nl.keenagency.videodb.dto.VideoDTO;
import nl.keenagency.videodb.entity.Category;
import nl.keenagency.videodb.entity.Video;
import nl.keenagency.videodb.exeptions.ResourceNotFoundException;
import nl.keenagency.videodb.mapper.VideoMapper;
import nl.keenagency.videodb.repository.CategoryRepository;
import nl.keenagency.videodb.repository.VideoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class VideoController {
    private final VideoMapper videoMapper;
    private final VideoRepository videoRepository;
    private final CategoryRepository categoryRepository;

    @CrossOrigin
    @GetMapping("/videos")
    public List<VideoDTO> findAll() {
        List<Video> videos = videoRepository.findAll();
        return videoMapper.toVideoDTOList(videos);
    }

    @CrossOrigin
    @GetMapping("/videos/categories")
    public List<VideoDTO> findByCategories(@RequestParam("id") List<Integer> id,
                                           @RequestParam(value = "rule", defaultValue = "any") String rule) {
        List<Category> categories = categoryRepository.findAllById(id);
        List<Video> videos;
        if ("all".equalsIgnoreCase(rule)) {
            videos = videoRepository.findByCategoriesInAnd(categories, id.size());
        } else {
            videos = videoRepository.findByCategoriesIn(categories);
        }
        return videoMapper.toVideoDTOList(videos);
    }


    // add mapping for GET /videos/id - get single video
    @CrossOrigin
    @GetMapping("/videos/{id}")
    public ResponseEntity<VideoDTO> getVideoById(@PathVariable int id) {
        VideoDTO videoDTO = videoMapper.toVideoDTO(videoRepository.findById(id));
        if (videoDTO != null) {
            return ResponseEntity.ok(videoDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // add mapping for POST /videos - add new video
    @CrossOrigin
    @PostMapping("/videos")
    public VideoDTO addVideo(@RequestBody VideoDTO theVideoDTO) {
        theVideoDTO.setId(0);
        Video theVideo = videoMapper.toVideoEntity(theVideoDTO);

        List<Category> categories = theVideoDTO.getCategories().stream()
            .map(categoryDTO -> categoryRepository.findById(categoryDTO.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Category not found with id: " + categoryDTO.getId())))
            .collect(Collectors.toList());
        theVideo.setCategories(categories);

        Video savedVideo = videoRepository.save(theVideo);
        return videoMapper.toVideoDTO(savedVideo);
        // return videoRepository.save(theVideoDTO); // returns DB Customer with id set
    }

    @CrossOrigin
    @PutMapping("/videos")
    public VideoDTO updateVideo(@RequestBody VideoDTO theVideoDTO) {
        Video theVideo = videoMapper.toVideoEntity(theVideoDTO);
        Video savedVideo = videoRepository.save(theVideo);
        return videoMapper.toVideoDTO(savedVideo);
    }

    @CrossOrigin
    @DeleteMapping("/videos/{id}")
    public Video deleteVideo(@PathVariable int id) {
        Video tempVideo = videoRepository.findById(id);

        if (tempVideo == null) {
            throw new RuntimeException("Video id not found - " + id);
        }
        tempVideo.getCategories().clear();
        videoRepository.save(tempVideo);
        videoRepository.deleteById(id);
//      return "Deleted video id - " + id + "Object: " + tempVideo;
        return tempVideo;
    }

}

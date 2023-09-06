package nl.keenagency.videodb.repository;
import nl.keenagency.videodb.entity.Category;
import nl.keenagency.videodb.entity.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface VideoRepository extends JpaRepository<Video, Integer> {
    List<Video> findAll();
    Video findById(int theId);
    Video save(Video theVideo);
    void deleteById(int theId);
//    List<Video> findByCategoriesInAnd(List<Category> categories);

    List<Video> findByCategoriesIn(List<Category> categories);
    @Query("SELECT v FROM Video v JOIN v.categories c WHERE c IN :categories GROUP BY v HAVING COUNT(DISTINCT c) = :categoryCount")
    List<Video> findByCategoriesInAnd(@Param("categories") List<Category> categories, @Param("categoryCount") long categoryCount);

}

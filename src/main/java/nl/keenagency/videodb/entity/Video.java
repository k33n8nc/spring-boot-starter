package nl.keenagency.videodb.entity;
import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@ToString
@Entity
@Table(name = "video")
public class Video {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "duration")
    private int duration;

    @Column(name = "file_url")
    private String file_url;

    @Column(name = "cover_url")
    private String cover_url;

    @Column(name = "excerpt")
    private String excerpt;

    @Column(name = "type")
    private String type;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    @JoinTable(
            name = "video_category",
            joinColumns = {@JoinColumn(name = "video_pk", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "category_pk", referencedColumnName = "id")}
    )
    private List<Category> categories;
}

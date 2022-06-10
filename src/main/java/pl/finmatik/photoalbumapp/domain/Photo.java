package pl.finmatik.photoalbumapp.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Photo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String title;

    private String description;

    private String privacy;

    private String uploaderName;

    private String uploaderPhoneNumber;

    private String uploaderEmail;

    private String uploaderAddress;

    private String view;

    @ManyToOne
    @JoinColumn(name = "album_id", nullable = false)
    private Album album;

    @ManyToOne(optional = false)
    @JoinColumn(name = "location_id", nullable = false)
    private Location location;

    @OneToMany(mappedBy = "photo")
    private Set<Comment> comments;

    @OneToOne(mappedBy = "photo",cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private UploadHistory uploadHistory;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "Photo_Tag",
            joinColumns = { @JoinColumn(name = "photo_id") },
            inverseJoinColumns = { @JoinColumn(name = "tag_id") }
    )
    Set<Tag> tags = new HashSet<>();
}

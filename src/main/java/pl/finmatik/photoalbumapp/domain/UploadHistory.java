package pl.finmatik.photoalbumapp.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class UploadHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private Date date;

    @OneToOne(cascade = CascadeType.ALL)
    @MapsId
    @JoinColumn(name = "photo_id")
    private Photo photo;

}

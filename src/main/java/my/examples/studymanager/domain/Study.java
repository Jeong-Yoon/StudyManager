package my.examples.studymanager.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "study")
@Getter
@Setter
public class Study {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studyId;
    private String studyName;
    @Lob
    private String studyInformation;
    private Date regdate;

    @OneToMany(mappedBy = "study", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    private List<Curriculum> curriculumList;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(mappedBy = "studyUserId.study", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    private List<StudyUser> studyUsers;
}

/*
| study_id          | bigint(20) unsigned | NO   | PRI | NULL              | auto_increment    |
| study_name        | varchar(255)        | NO   |     | NULL              |                   |
| study_information | varchar(255)        | NO   |     | NULL              |                   |
| regdate           | datetime            | NO   |     | CURRENT_TIMESTAMP | DEFAULT_GENERATED |
| category_id       | bigint(20) unsigned | NO   | MUL | NULL              |                   |
 */
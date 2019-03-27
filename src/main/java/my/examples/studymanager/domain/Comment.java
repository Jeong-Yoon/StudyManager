package my.examples.studymanager.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "comment")
@Getter
@Setter
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;
    @Lob
    private String commentContent;

    @ManyToOne
    @JoinColumn(name = "study_content_id")
    private StudyContent studyContent;

    @ManyToOne
    @JoinColumn(name = "writer")
    private User user;
}
/*
 Field            | Type                | Null | Key | Default | Extra |
+------------------+---------------------+------+-----+---------+-------+
| comment_id       | bigint(20) unsigned | NO   | PRI | NULL    | auto_increment |
| comment_content  | longtext            | NO   |     | NULL    |                |
| study_content_id | bigint(20) unsigned | NO   | MUL | NULL    |                |
| writer           | varchar(50)         | NO   | MUL | NULL    |                |
 */
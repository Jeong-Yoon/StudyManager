package my.examples.StudyManager.domain;

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
    private String commentContent;
    @Column(length = 50)
    private String writer;

    private Long studyContentId;

}
/*
 Field            | Type                | Null | Key | Default | Extra |
+------------------+---------------------+------+-----+---------+-------+
| study_content_id | bigint(20) unsigned | NO   | PRI | NULL    |       |
| comment_content  | longtext            | NO   |     | NULL    |       |
| writer           | varchar(50)         | NO   | PRI | NULL    |       |
 */
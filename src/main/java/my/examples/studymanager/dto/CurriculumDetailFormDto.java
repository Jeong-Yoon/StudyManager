package my.examples.studymanager.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Lob;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CurriculumDetailFormDto {
    private Long curriculumId;
    @Lob
    private String curriculumDetailContent;
}

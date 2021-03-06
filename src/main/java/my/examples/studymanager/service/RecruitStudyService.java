package my.examples.studymanager.service;

import my.examples.studymanager.domain.RecruitStudy;
import my.examples.studymanager.dto.RecruitStudyDto;

import java.util.List;

public interface RecruitStudyService {
    public List<RecruitStudy> getRecruitStudyAll();
    public void addRecruitStudy(RecruitStudyDto recruitStudyDto, Long userId);
    public RecruitStudy getRecruitStudy(Long recruitStudyId);
    public List<RecruitStudy> searchRecruitStudy(int page, Long categoryId, String searchType, String searchStr);
}

package my.examples.studymanager.service.impl;

import lombok.RequiredArgsConstructor;
import my.examples.studymanager.domain.Curriculum;
import my.examples.studymanager.dto.CurriculumFormDto;
import my.examples.studymanager.repository.CurriculumRepository;
import my.examples.studymanager.repository.StudyRepository;
import my.examples.studymanager.service.CurriculumService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CurriculumServiceImpl implements CurriculumService {
    private final CurriculumRepository curriculumRepository;
    private final StudyRepository studyRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Curriculum> getCurriculumByStudyId(Long studyId) {
        return curriculumRepository.getCurriculumByStudyId(studyId);
    }

    @Override
    @Transactional(readOnly = true)
    public Curriculum getcurriculum(Long curriculumId){
        return curriculumRepository.getOne(curriculumId);
    }

    @Override
    @Transactional
    public void deleteCurriculum(Long curriculumId) {
        curriculumRepository.deleteById(curriculumId);
    }

    @Override
    @Transactional(readOnly = true)
    public Curriculum getCurriculumByCurriculumDetailId(Long curriculumDetailId){
        return curriculumRepository.getCurriculumBycurriculumDetailId(curriculumDetailId);
//        return studyRepository.getStudynameByCurriculumId(curriculumId);
    }

    @Override
    @Transactional
    public void modifyCurriculum(Long curriculumId, String curriculumContent) {
        Curriculum curriculum = curriculumRepository.getOne(curriculumId);
        curriculum.setCurriculumContent(curriculumContent);
        curriculumRepository.save(curriculum);
    }

    @Override
    @Transactional
    public void addCurriculum(List<CurriculumFormDto> curriculumFormDtoList) {
        for(CurriculumFormDto c : curriculumFormDtoList) {
            Curriculum curriculum = new Curriculum();
            curriculum.setStudy(studyRepository.getOne(c.getStudyId()));
            curriculum.setCurriculumContent(c.getCurriculumContent());
            curriculumRepository.save(curriculum);
        }
    }
}

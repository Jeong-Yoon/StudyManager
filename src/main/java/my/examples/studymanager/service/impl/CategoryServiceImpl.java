package my.examples.studymanager.service.impl;

import lombok.RequiredArgsConstructor;
import my.examples.studymanager.domain.Category;
import my.examples.studymanager.repository.CategoryRepository;
import my.examples.studymanager.service.CategoryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Transactional(readOnly = true)
    @Override
    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }


    @Override
    public Category getCategory(Long categoryId) {
        return categoryRepository.getOne(categoryId);
    }
}

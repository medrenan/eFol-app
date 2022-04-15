package br.org.fatec.efol.impl.service;

import br.org.fatec.efol.impl.excel.ExcelReader;
import br.org.fatec.efol.impl.excel.FolImporter;
import br.org.fatec.efol.impl.repository.FolRepository;
import br.org.fatec.efol.model.fol.Fol;
import br.org.fatec.efol.model.fol.Keyword;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class FolService {

    @Autowired
    FolRepository repository;
    @Autowired
    private EquipmentService equipmentService;
    @Autowired
    private FolCategoryService folCategoryService;
    @Autowired
    private KeywordService keywordService;
    @Autowired
    private FolImporter folImporter;


    public Long create(Fol fol){
        if(fol == null) {
            return null;
        }

        // Validate necessary parameters
        this.validateInsertionParameters(fol);
        repository.merge(fol);

        return fol.getId();
    }

    public Long remove(Long id){
        if(id == null){
            return null;
        }

        this.repository.remove(id);
        return id;
    }

    public Fol find(Long id){
        if (id == null){
            return null;
        }

        return this.repository.findById(id);
    }

    public List<Fol> findAll(){
        return this.repository.findAll();
    }

    public Boolean importFols() throws IOException, InvalidFormatException {
        File excelFile = new File("efol-core/src/main/resources/static/excel/fols.xlsx");
        List<Fol> fols = folImporter.importExcel(excelFile);
        if(fols.isEmpty()){
            return false;
        }
        for(Fol fol : fols){
            this.repository.merge(fol);
        }

        return true;
    }

    private void validateInsertionParameters(Fol fol) {
        List<Long> keywordIdsNotFound = validateKeywordsList(fol.getKeywords());

        if (fol.getEquipment() == null || fol.getCategory() == null || fol.getKeywords() == null) {
            throw new RuntimeException("It's necessary to inform a valid Equipment, Category and Keywords");
        } else if(this.equipmentService.find(fol.getEquipment().getId()) == null) {
            throw new RuntimeException("Couldn't find an Equipment with id " + fol.getEquipment().getId());
        } else if(this.folCategoryService.find(fol.getCategory().getId()) == null) {
            throw new RuntimeException("Couldn't find an FolCategory with id " + fol.getEquipment().getId());
        } else  if(!keywordIdsNotFound.isEmpty()){
            throw new RuntimeException("Couldn't find Keywords with ids " + keywordIdsNotFound);
        }
    }

    private List<Long> validateKeywordsList(Set<Keyword> keywords){
        List<Long> keywordsIdsNotFound = new ArrayList<>();
        if(keywords == null){
            return keywordsIdsNotFound;
        }

        for(Keyword keyword : keywords){
            if(this.keywordService.find(keyword.getId()) == null) {
                keywordsIdsNotFound.add(keyword.getId());
            }
        }
        return keywordsIdsNotFound;
    }
}

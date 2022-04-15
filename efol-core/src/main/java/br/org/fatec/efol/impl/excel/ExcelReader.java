package br.org.fatec.efol.impl.excel;

import br.org.fatec.efol.impl.repository.EquipmentRepository;
import br.org.fatec.efol.impl.repository.FolCategoryRepository;
import br.org.fatec.efol.impl.repository.KeywordRepository;
import br.org.fatec.efol.model.equipment.Equipment;
import br.org.fatec.efol.model.fol.Fol;
import br.org.fatec.efol.model.fol.FolCategory;
import br.org.fatec.efol.model.fol.Keyword;
import br.org.fatec.efol.model.fol.StatusFol;
import br.org.fatec.efol.util.DateUtil;
import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.*;
import java.util.stream.Collectors;

@Component
public class ExcelReader {

    @Autowired
    EquipmentRepository equipmentRepository;
    @Autowired
    FolCategoryRepository folCategoryRepository;
    @Autowired
    KeywordRepository keywordRepository;

    public List<Fol> readRowsFol(Workbook excel){
        int start = 0;

        try {
            Sheet sheet = excel.getSheetAt(start);
            return this.readFolSheet(sheet);
        } catch (IllegalArgumentException | ParseException e) {
            return new ArrayList<>();
        }
    }

    private List<Fol> readFolSheet(Sheet sheet) throws ParseException {
        Map<Integer, List<String>> rowsValues =  mapSheetRowsValues(sheet);
        return toFolList(rowsValues);
    }

    private Map<Integer, List<String>> mapSheetRowsValues(Sheet sheet){
        Map<Integer, List<String>> rowsCells = new HashMap<>();

        int start = 1;
        int end = sheet.getLastRowNum();

        DataFormatter df = new DataFormatter(Locale.UK);
        for(int index = start; index <= end; index++){
            List<String> cellValues = new ArrayList<>();
            Row row = sheet.getRow(index);

            for(int cellIndex = 0; cellIndex <= row.getLastCellNum() - 1; cellIndex++){

                Cell cell = row.getCell(cellIndex, Row.MissingCellPolicy.RETURN_BLANK_AS_NULL);

                if(cellIndex == 6 || cellIndex == 8) {
                    cellValues.add((cell != null) ? DateUtil.toPtBr(cell.getDateCellValue()) : null);
                } else {
                    cellValues.add((cell != null) ? df.formatCellValue(cell) : null);
                }
            }
            rowsCells.put(index, cellValues);
        }

        return rowsCells;
    }

    private List<Fol> toFolList(Map<Integer, List<String>> rowsValues) throws ParseException {
        List<Fol> folList = new ArrayList<>();

        for(List<String> fields : rowsValues.values()){
            this.createIfNull(fields.get(1), fields.get(4));

            Fol fol = new Fol();
            Equipment equipment = this.equipmentRepository.findByEquipmentName(fields.get(1));
            FolCategory category = this.folCategoryRepository.findByFolCategoryName(fields.get(4));

            fol.setTitle(fields.get(0) != null ? fields.get(0) : null);
            fol.setEquipment(equipment);
            fol.setApplicability(fields.get(2) != null ? fields.get(2) : null);
            fol.setIssueDescription(fields.get(3) != null ? fields.get(3) : null);
            category.setName(fields.get(4) != null ? fields.get(4) : null);
            fol.setCategory(category);
            fol.setStatus(fields.get(5) != null ? StatusFol.fromString(fields.get(5).replace(" ", "_")) : null);
            fol.setIssueDate(DateUtil.parseDatePtBr(fields.get(6) != null ? fields.get(6) : null));
            fol.setRevisionNumber(fields.get(7) != null ? Integer.valueOf(fields.get(7)) : null);
            fol.setRevisionDate(fields.get(8) != null ? DateUtil.parseDatePtBr(fields.get(8)) : null);
            fol.setRemarks(fields.get(9) != null ? fields.get(9) : null);
            fol.setKeywords(fromKeywordsString(fields.get(10)));

            folList.add(fol);
        }

        return folList;
    }

    private Set<Keyword> fromKeywordsString(String keywords){
        Set<Keyword> keywordSet = new HashSet<>();
        if(keywords == null) {
            return keywordSet;
        }
        List<String> keywordsList = Arrays.asList(keywords.split("\\s*,\\s*"));
        keywordsList = keywordsList.stream().map(string -> string.toUpperCase().replaceAll("\\s", " ")).collect(Collectors.toList());

        for(String keywordName : keywordsList){
            Keyword keyword = this.keywordRepository.findByKeywordName(keywordName);
            if(keyword == null){
                keyword = new Keyword();
                keyword.setName(keywordName);
                System.out.println("----------------------------------------> "+ keywordName);
                this.keywordRepository.persist(keyword);
            }

            keywordSet.add(this.keywordRepository.findByKeywordName(keywordName));
        }

        return keywordSet;
    }

    public void createIfNull(String equipmentName, String folCategoryName){
        Equipment equipment = this.equipmentRepository.findByEquipmentName(equipmentName);
        if(equipment == null){
            equipment = new Equipment();
            equipment.setName(equipmentName);
            this.equipmentRepository.persist(equipment);
        }

        FolCategory folCategory = this.folCategoryRepository.findByFolCategoryName(folCategoryName);
        if(folCategory == null){
            folCategory = new FolCategory();
            folCategory.setName(folCategoryName);
            this.folCategoryRepository.persist(folCategory);
        }
    }
}

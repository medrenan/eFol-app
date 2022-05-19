package br.org.fatec.efol.impl.excel;

import br.org.fatec.efol.model.fol.Fol;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Component
public class FolImporter {

    @Autowired
    ExcelReader excelReader;

    public List<Fol> importExcel(File excelFile) throws IOException {
        Workbook workbook = WorkbookFactory.create(excelFile);
        return this.excelReader.readRowsFol(workbook);
    }
}

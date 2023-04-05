package daxping.code;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReadExcel {
    public static Map<Object, Object> xlsxToMap(String pathToFile) {
        List<Object> list = new ArrayList<>();
        Map<Object, Object> map = new HashMap<>();
        try {
            FileInputStream excelFile = new FileInputStream(getXlsx(pathToFile));
            XSSFWorkbook workbook = new XSSFWorkbook(excelFile);
            Sheet datatypeSheet = workbook.getSheetAt(0);
            for (Row row : datatypeSheet) {
                for (Cell currentCell : row) {
                    list.add(currentCell);
                }
                map.put(list.get(0), list.get(1));
                list.clear();
            }
            workbook.close();
            excelFile.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

    public static File getXlsx (String pathToFile) throws Exception {
        Path path = Paths.get(pathToFile).toAbsolutePath().normalize();
        if (!Files.exists(path)) {
            throw new Exception("File '" + pathToFile + "' does not exist");
        }
        return path.toFile();
    }
}
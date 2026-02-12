package service;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook; // для .xlsx
import org.apache.poi.hssf.usermodel.HSSFWorkbook; // для .xls

public class FileServiceImpl implements FileService{
    String filePath = "src/main/java/resources/projects.xlsx";

    ProjectService projectService;
    TaskService taskService;

    public FileServiceImpl(ProjectService projectService, TaskService taskService){
        this.projectService = projectService;
        this.taskService = taskService;
    }

    @Override
    public void initialize() {
        // TODO Нужно получить доступ к map в репозиториях и здесь их заполнить - через create
        Map<String, String> taskMap = new HashMap<>();

        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = WorkbookFactory.create(fis)) {

            Sheet sheet = workbook.getSheetAt(0); // Берём первый лист



        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

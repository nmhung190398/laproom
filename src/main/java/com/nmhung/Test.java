package com.nmhung;
import com.nmhung.model.RoomTimeModel;
import com.nmhung.utils.POIUtils;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Test {
    public static void main(String[] args) {
        try {
            POIUtils.writeTabsInfo("test.xlsx",null,"Hùng đẹp trai","pm-1");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

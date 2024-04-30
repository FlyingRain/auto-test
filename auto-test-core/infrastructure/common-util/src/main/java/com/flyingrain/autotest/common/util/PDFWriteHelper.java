package com.flyingrain.autotest.common.util;

import com.itextpdf.kernel.colors.Color;
import com.itextpdf.kernel.colors.DeviceRgb;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.Rectangle;
import com.itextpdf.kernel.pdf.PdfDictionary;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;
import com.itextpdf.layout.borders.SolidBorder;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.properties.BorderRadius;
import com.itextpdf.layout.properties.TextAlignment;
import com.itextpdf.layout.properties.UnitValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

import static com.itextpdf.io.font.constants.StandardFonts.HELVETICA;


public class PDFWriteHelper {


    public static Table createRectangle(String title, String text,Color textColor, Color rectangleColor) throws IOException {

        Paragraph recPra = new Paragraph(title).setPadding(1).setBackgroundColor(rectangleColor);
        PdfFont font = PdfFontFactory.createFont("STSongStd-Light", "UniGB-UCS2-H", PdfFontFactory.EmbeddingStrategy.PREFER_NOT_EMBEDDED);
        recPra.setFont(font);
        recPra.setBorderRadius(new BorderRadius(2));
        recPra.setHeight(30);
        recPra.setWidth(80);
        recPra.setTextAlignment(TextAlignment.CENTER);
        recPra.setFontColor(new DeviceRgb(255, 255, 255)).setFontSize(15);

        Table contentTable = new Table(UnitValue.createPercentArray(2));
        contentTable.addCell(new Cell(1,1).setBorder(SolidBorder.NO_BORDER).add(recPra)).addCell(new Cell(1,1).setBorder(SolidBorder.NO_BORDER).add(new Paragraph(text).setFont(font).setPaddingTop(5).setTextAlignment(TextAlignment.CENTER).setFontColor(textColor).setMarginLeft(10)));

        return contentTable;

    }
}

package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class FileOpenManagerTest {
    private final FileOpenManager manager = new FileOpenManager();

    @BeforeEach
    public void setUp() {
        manager.add(".bmp", "Paint 3D");
        manager.add(".png", "Paint 3D");
        manager.add(".txt", "Блокнот");
        manager.add(".doc", "MSWord");
        manager.add(".docx", "MSWord");
        manager.add(".xls", "MSExcel");
        manager.add(".xlsx", "MSExcel");
        manager.add(".dwg", "AutoCAD");
        manager.add(".pln", "ArchiCAD");
    }

    @Test
    void shouldGetApplication() {
        assertEquals("MSExcel", manager.getApplication(".xlsx"));
    }

    @Test
    void shouldGetApplicationByExtensionWithCapitals() {
        assertEquals("MSExcel", manager.getApplication(".XLS"));
    }

    @Test
    void shouldRemoveApplicationWhenKeyExist() {
        manager.removeApplication("bmp");
        assertNull(manager.getApplication("bmp"));
    }

    @Test
    void shouldNotFailRemovingApplicationWhenKeyNotExist() {
        manager.removeApplication("tmp");
        assertNull(manager.getApplication("tmp"));
    }

    @Test
    void shouldGetAllExtensions() {
        Set<Object> expected = Set.of(".bmp", ".BMP", ".png", ".PNG", ".txt", ".TXT", ".doc", ".DOC", ".docx", ".DOCX",
                ".xls", ".XLS", ".xlsx", ".XLSX", ".dwg", ".DWG", ".pln", ".PLN");

        assertEquals(expected, manager.getAllExtensions());
    }

    @Test
    void shouldGetAllApplications() {
        Set<Object> expected = Set.of("Paint 3D", "Блокнот", "MSWord", "MSExcel", "AutoCAD", "ArchiCAD");

        assertEquals(expected, manager.getAllApplications());
    }
}
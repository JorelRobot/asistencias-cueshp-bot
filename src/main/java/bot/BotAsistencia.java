/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bot;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.time.LocalDateTime;
import model.FormValues;

/**
 *
 * @author Joel
 */
public class BotAsistencia {

    private Robot robot;
    private final FormValues values;
    private int DELAY = 300;
    private final int TYPE_KEY_DEALY = 50;

    public BotAsistencia(FormValues values) {
        try {
            this.robot = new Robot();
        } catch (AWTException ex) {
            //Logger.getLogger(BotAsistencia.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Excepcion al instanciar Robot: " + ex.getMessage());
        }

        this.values = values;
    }

    public void setDelay(int delay) {
        this.DELAY = delay;
    }

    private void pressUp() {
        robot.delay(DELAY);
        robot.keyPress(KeyEvent.VK_UP);
        robot.keyRelease(KeyEvent.VK_UP);
    }

    private void pressDown() {
        robot.delay(DELAY);
        robot.keyPress(KeyEvent.VK_DOWN);
        robot.keyRelease(KeyEvent.VK_DOWN);
    }

    private void doubleTabAndEnter() {
        nTabs(2);
        enter();
    }

    private void clickAndDoubleTab() {
        robot.delay(DELAY);
        robot.mouseMove(200, 200);

        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

        nTabs(2);
    }

    private void tab() {
        robot.delay(DELAY);
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_TAB);
    }

    private void nTabs(int nTabs) {
        for (int i = 0; i < nTabs; i++) {
            tab();
        }
    }

    private void enter() {
        robot.delay(DELAY);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }

    private void clip(String text) {
        StringSelection stringSelection = new StringSelection(text);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, stringSelection);
    }

    private void typeKey(char key) {

        if (Character.isAlphabetic(key)) {
            key = Character.toUpperCase(key);
        }

        robot.delay(DELAY);

        /*/
        if (key == ':') {
            robot.keyPress(KeyEvent.VK_COLON);
            robot.keyRelease(KeyEvent.VK_COLON);
        } else {
            robot.keyPress(key);
            robot.keyRelease(key);
        }
        //*/
        //*/
        robot.keyPress(key);
        robot.keyRelease(key);
        //*/
    }

    private void typeText(String text) {
        char[] chars = text.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            typeKey(chars[i]);
        }
    }

    private void copyPasteText(String text) {
        robot.delay(DELAY);
        clip(text);
        robot.delay(DELAY);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_V);
    }

    public void p0() {
        clickAndDoubleTab();
        enter();
    }

    public void p1() {
        clickAndDoubleTab();
        typeText(String.valueOf(values.getSemestre()));
        doubleTabAndEnter();
    }

    public void p2() {
        clickAndDoubleTab();
                
        //*/
        switch (values.getMateria().toLowerCase()) {
            case "tae: frances junior":
                for (int i = 0; i < 12; i++) {
                    pressDown();
                }
                enter();
                break;
            case "tae: diagnostico de la problematica ambiental":
                for (int i = 0; i < 2; i++) {
                    pressDown();
                }
                enter();
                break;
            case "tae: principios basicos de la salud publica":
                for (int i = 0; i < 7; i++) {
                    pressDown();
                }
                enter();
                break;
            case "tae: frances inicial":
                for (int i = 0; i < 9; i++) {
                    pressDown();
                }
                enter();
                break;
            case "tae: salud biopsicosocial":
                for (int i = 0; i < 7; i++) {
                    pressDown();
                }
                enter();
                break;
            case "tae: gestion y ejecucion de proyectos de educacion ambiental":
                for (int i = 0; i < 2; i++) {
                    pressDown();
                }
                enter();
                break;
            case "tae: imaginacion digital":
                for (int i = 0; i < 5; i++) {
                    pressDown();
                }
                enter();
                break;
            case "tae: identificacion y prevencion de riesgos para la salud":
                for (int i = 0; i < 7; i++) {
                    pressDown();
                }
                enter();
                break;
            case "tae: gestion del bienestar y cuidado de la salud":
                for (int i = 0; i < 7; i++) {
                    pressDown();
                }
                enter();
                break;
            default:
                typeText(values.getMateria().substring(0, 5));
        }
        //*/
        doubleTabAndEnter();
    }

    public void p3() {
        clickAndDoubleTab();
        pressDown();
        doubleTabAndEnter();
    }

    public void p4() {
        clickAndDoubleTab();

        LocalDateTime dateTime = LocalDateTime.now();

        copyPasteText(String.valueOf(dateTime.getDayOfMonth()));
        tab();
        copyPasteText(String.valueOf(dateTime.getMonthValue()));
        tab();
        copyPasteText(String.valueOf(dateTime.getYear()));
        tab();
        copyPasteText(String.valueOf(dateTime.getHour()));
        tab();
        copyPasteText(String.valueOf(dateTime.getMinute()));
        doubleTabAndEnter();
    }

    public void p5() {
        clickAndDoubleTab();
        tab();
        // TODO: enter();
    }

    public void p6() {
        clickAndDoubleTab();
        pressDown();
        pressUp();
        doubleTabAndEnter();
    }

    public void p7() {
        clickAndDoubleTab();

        LocalDateTime dateTime = LocalDateTime.now();

        copyPasteText(String.valueOf(dateTime.getDayOfMonth()));
        tab();
        copyPasteText(String.valueOf(dateTime.getMonthValue()));
        tab();
        copyPasteText(String.valueOf(dateTime.getYear()));
        tab();
        copyPasteText(String.valueOf(dateTime.getHour()));
        tab();
        copyPasteText(String.valueOf(dateTime.getMinute()));
        tab();
    }

    public void p8() {
        pressDown();
        pressDown();
        pressDown();
        pressDown();

        copyPasteText(values.getOtra_actividad());

        doubleTabAndEnter();
    }

    public void p9() {
        pressDown();
        pressDown();
        pressDown();

        doubleTabAndEnter();
    }

    public void p10() {
        clickAndDoubleTab();

        pressDown();
        pressUp();

        doubleTabAndEnter();
    }

    public void p11() {
        clickAndDoubleTab();

        pressDown();

        doubleTabAndEnter();
    }

    public void p12() {
        clickAndDoubleTab();

        pressDown();
        pressDown();

        doubleTabAndEnter();
    }

    public void p13() {
        clickAndDoubleTab();

        pressDown();
        pressDown();
        pressDown();

        doubleTabAndEnter();
    }

    public void p14() {
        pressDown();
        pressDown();

        doubleTabAndEnter();
    }

    public void p15() {
        clickAndDoubleTab();

        pressDown();
        pressUp();

        doubleTabAndEnter();
    }

    public void p16() {
        clickAndDoubleTab();

        pressDown();

        doubleTabAndEnter();
    }

    public void p17() {
        clickAndDoubleTab();

        pressDown();
        pressDown();

        doubleTabAndEnter();
    }

    public void p18() {
        clickAndDoubleTab();

        copyPasteText(values.getVideoconferencia());

        doubleTabAndEnter();
    }

    public void p19() {
        pressDown();
        pressUp();

        doubleTabAndEnter();
    }

    public void p24() {
        pressDown();

        doubleTabAndEnter();
    }

    public void p20() {
        clickAndDoubleTab();

        copyPasteText(values.getActividad());

        tab();
    }

    public void p21() {
        pressDown();
        pressUp();

        doubleTabAndEnter();
    }

    public void p22() {
        pressDown();

        doubleTabAndEnter();
    }

    public void p23() {
        pressDown();
        pressDown();

        doubleTabAndEnter();
    }

    public static void main(String[] args) {

        BotAsistencia bot = new BotAsistencia(new FormValues());

        bot.p7();
        bot.p9();

    }
}

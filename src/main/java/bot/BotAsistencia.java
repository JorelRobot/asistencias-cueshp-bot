/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bot;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.FormValues;

/**
 *
 * @author Joel
 */
public class BotAsistencia {

    private Robot robot;
    private FormValues values;

    public BotAsistencia(FormValues values) {
        try {
            this.robot = new Robot();
        } catch (AWTException ex) {
            //Logger.getLogger(BotAsistencia.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Excepcion al instanciar Robot: " + ex.getMessage());
        }

        this.values = values;
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
        //typeText(values.getMateria());
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
        
        robot.delay(50);
        typeText(String.valueOf(dateTime.getDayOfMonth()));
        tab();
        robot.delay(50);
        typeText(String.valueOf(dateTime.getMonthValue()));
        tab();
        robot.delay(50);
        typeText(String.valueOf(dateTime.getYear()));
        tab();
        robot.delay(50);
        typeText(String.valueOf(dateTime.getHour()));
        tab();
        robot.delay(50);
        typeText(String.valueOf(dateTime.getMinute()));
        tab();
        tab();
        //doubleTabAndEnter();
    }
    
    public void p5() {
        clickAndDoubleTab();
        tab();
        //enter();
    }
    
    private void pressUp() {
        robot.keyPress(KeyEvent.VK_UP);
        robot.keyRelease(KeyEvent.VK_UP);
    }
    
    private void pressDown() {
        robot.keyPress(KeyEvent.VK_DOWN);
        robot.keyRelease(KeyEvent.VK_DOWN);
    }
    
    private void doubleTabAndEnter() {
        nTabs(2);
        enter();
    }

    private void clickAndDoubleTab() {
        robot.mouseMove(200, 200);

        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

        nTabs(2);
    }

    private void tab() {
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_TAB);
    }

    private void nTabs(int nTabs) {
        for (int i = 0; i < nTabs; i++) {
            tab();
        }
    }

    private void enter() {
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }

    private void clip(String text) {
        StringSelection stringSelection = new StringSelection(text);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, stringSelection);
    }

    private void typeText(String text) {
        clip(text);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_V);
    }

    public static void main(String[] args) {

        BotAsistencia bot = new BotAsistencia(new FormValues());

        
        bot.p4();

    }
}
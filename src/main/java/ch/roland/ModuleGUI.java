package ch.roland;


import javax.swing.*;
import java.io.File;
import util.*;

public  abstract class ModuleGUI {
    public JFrame frame;
    public boolean fullCyclePlayed = false;
    abstract public void preperaGUI() throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException;
    abstract public void initListeners();
    abstract public void initActions();
    protected timeBasedUUID Uuid = new timeBasedUUID();
    public JMenuBar MenuBar;
    public void clean(String Lock){
        File lockFile = new File(Lock);
        if (lockFile.delete())
            lockFile.delete();
        System.exit(0);
    }
    public void proceedExitTry(String WarningMessage, String LockFiles){
        if (fullCyclePlayed)
            clean(LockFiles);

        Object[] options = {"Да, выйти",
                "Нет, остаться"};
        int n = JOptionPane.showOptionDialog(frame,
                WarningMessage,
                "Внимание",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[1]);
        if (n==0)
            clean(LockFiles);
    }
}

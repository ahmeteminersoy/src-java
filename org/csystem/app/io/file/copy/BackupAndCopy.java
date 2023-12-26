package org.csystem.app.io.file.copy;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class BackupAndCopy {
    private final Path m_srcPath;
    private final Path m_destPath;

    private final String m_suffix;
    private void copy() throws IOException
    {
        try {
            Files.copy(m_srcPath, m_destPath);
        }
        catch (FileAlreadyExistsException ignore)
        {
            backupAndCopy();
        }
    }
    private void backupAndCopy() throws IOException
    {
        Files.move(m_srcPath, Path.of(m_destPath + m_suffix) , StandardCopyOption.REPLACE_EXISTING);
        copy();
    }
    public BackupAndCopy(Path srcPath, Path destPath, String suffix)
    {
        m_srcPath = srcPath;
        m_destPath = destPath;
        m_suffix = suffix;
    }
    public void doCopy() throws IOException
    {
        copy();
    }
}

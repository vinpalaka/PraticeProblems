package strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParseDirPathTest {

    @Test
    void simplifyPath() {
        ParseDirPath.simplifyPath("/home/foo/.ssh/../.ssh2/authorized_keys/");

    }
}
package nuc.ss.utils;

import org.junit.Test;

import java.util.UUID;

@SuppressWarnings("all")
public class IdUtils {
    public static String getId() {
        return UUID.randomUUID().toString().replace("-","");
    }

    @Test
    public void test() {
        System.out.println(IdUtils.getId());
    }
}

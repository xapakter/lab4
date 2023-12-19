package org.example;

import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BSTNodeTest {
    public static Map<Integer, String> map = new LinkedHashMap<>();
    public static BSTNode root;

    @Test
    void test1() {
        map.put(30, "Value 30");
        map.put(31, "Value 31");
        map.put(24, "Value 24");
        map.put(27, "Value 27");
        map.put(11, "Value 11");
        map.put(21, "Value 21");
        map.put(15, "Value 15");
        map.put(28, "Value 28");
        map.put(16, "Value 16");
        map.put(14, "Value 14");
        map.put(12, "Value 12");
        map.put(26, "Value 26");
        map.put(13, "Value 13");
        map.put(22, "Value 22");
        map.put(18, "Value 18");
        map.put(19, "Value 19");
        map.put(29, "Value 29");
        map.put(17, "Value 17");
        map.put(25, "Value 25");
        map.put(23, "Value 23");
        map.put(20, "Value 20");
    }

    @Test
    void test2() {
        root = new BSTNode(30, map.get(30));
        for (int key : map.keySet()) {
            String value = map.get(key);
            root.insert(root, key, value);
        }
        int nodeCount = root.countNodes(root);
        assertEquals(map.size(), nodeCount);
    }

    @Test
    void test3() {
        BSTNode node;
        node = root.search(root, 25);
        assertEquals("Value 25", node.getValue());

        node = root.search(root, 28);
        assertEquals("Value 28", node.getValue());

        node = root.search(root, 1);
        assertNull(node);
    }

    @Test
    void test4() {
        BSTNode node;
        root = new BSTNode(30, map.get(30));
        for (int key : map.keySet()) {
            if (key == 15) {
                continue;
            }
            String value = map.get(key);
            root.insert(root, key, value);
        }
        assertEquals(map.size() - 1, root.countNodes(root));

        root.insert(root, 15, "test 15");
        node = root.search(root, 15);
        assertEquals("test 15", node.getValue());

        root.insert(root, 11, "11 test");
        int CountModeS = root.countNodes(root);
        assertEquals(map.size(), CountModeS);

        node = root.search(root, 11);
        assertEquals("11 test", node.getValue());
    }

    @Test
    void test5() {
        BSTNode node;
        root = root.delete(root, 15);
        int CountModeS = root.countNodes(root);
        assertEquals(map.size() -1, CountModeS);
        node = root.search(root, 15);
        assertNull(node);
    }
}
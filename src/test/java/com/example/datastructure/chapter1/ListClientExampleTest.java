package com.example.datastructure.chapter1;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class ListClientExampleTest {
    @Test
    public void testListClientExample() {

        ListClientExample lce = new ListClientExample();
        List list = lce.getList();
        assertThat(true).isEqualTo(list instanceof LinkedList<?>);
    }

}
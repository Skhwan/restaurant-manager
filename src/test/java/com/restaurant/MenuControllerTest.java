package com.restaurant;

import com.restaurant.controller.MenuController;
import com.restaurant.database.MenuDao;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Created by khwanchanok on 4/22/2018 AD.
 */
@SpringBootTest
public class MenuControllerTest {

    @Mock
    MenuDao menuDao;

    @InjectMocks
    MenuController menuController;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getNextPageCorrectly(){
        Mockito.when(menuDao.hasNextPage(Mockito.anyInt())).thenReturn(true);

        String expectedPath = "testPath?limit=3&offset=3";
        String nextPath = menuController.getNextPage(3, 3, "testPath");

        Assert.assertEquals(expectedPath, nextPath);
    }

    @Test
    public void getNextPageCorrectlyWithNullNextPage(){
        Mockito.when(menuDao.hasNextPage(Mockito.anyInt())).thenReturn(false);

        String nextPath = menuController.getNextPage(3, 3, "testPath");

        Assert.assertNull(nextPath);
    }

    @Test
    public void getPreviousPageCorrectly(){
        String expectedPath = "testPath?limit=3&offset=3";
        String prevPath = menuController.getPrevPage(3, 3, "testPath");

        Assert.assertEquals(expectedPath, prevPath);
    }

    @Test
    public void getPreviousPageCorrectlyWithNullPrevPage(){
        String prevPath = menuController.getPrevPage(3, -1, "testPath");

        Assert.assertNull(prevPath);
    }

    @Test
    public void getNextPageForSearchResultCorrectly(){
        Mockito.when(menuDao.hasNextPageForKeyword(Mockito.anyString(), Mockito.anyInt())).thenReturn(true);

        String expectedPath = "testPath?limit=3&offset=3";
        String nextPath = menuController.getNextPageForSearchResult("testKeyword", 3, 3, "testPath");

        Assert.assertEquals(expectedPath, nextPath);
    }

    @Test
    public void getNextPageForSearchResultCorrectlyWithNullNextPage(){
        Mockito.when(menuDao.hasNextPageForKeyword(Mockito.anyString(), Mockito.anyInt())).thenReturn(false);

        String nextPath = menuController.getNextPageForSearchResult("testKeyword", 3, 3, "testPath");

        Assert.assertNull(nextPath);
    }
}
